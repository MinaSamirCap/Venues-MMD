package com.example.andoird.venues_mmd.viewmodels.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.wrapper.SearchVenueModelWrapper;
import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.example.andoird.venues_mmd.ui.adapters.VenueItemAdapter;
import com.example.andoird.venues_mmd.ui.fragments.LocationQueryPlacesFragment;
import com.example.andoird.venues_mmd.ui.fragments.NearestPlacesFragment;
import com.example.andoird.venues_mmd.utils.GPSTracker;
import com.example.andoird.venues_mmd.utils.IntentUtils;
import com.example.andoird.venues_mmd.utils.UiUtils;
import com.example.andoird.venues_mmd.viewmodels.NetWorkViewModel;
import com.lapism.searchview.SearchAdapter;
import com.lapism.searchview.SearchFilter;
import com.lapism.searchview.SearchHistoryTable;
import com.lapism.searchview.SearchItem;
import com.lapism.searchview.SearchView;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;
import retrofit2.Retrofit;

/**
 * Created by mina on 07/12/17.
 */

public class MainActivityViewModel extends NetWorkViewModel<SearchVenueModelWrapper> {

    private static final String TAG = "fsfs";

    @Inject
    Retrofit retrofit;

    private Toast toast;

    public ObservableField<String> text = new ObservableField<>();

    public SearchView searchView;
    public Toolbar toolbar;
    private AppCompatActivity activity;
    private SearchHistoryTable searchHistoryTable;

    private double latitude, longitude;

    public MainActivityViewModel(AppCompatActivity activity, SearchView searchView,
                                 Toolbar toolbar) {

        super(activity, new SearchVenueModelWrapper());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        this.searchView = searchView;
        this.toolbar = toolbar;
        searchHistoryTable = new SearchHistoryTable(activity);
        searchHistoryTable.setHistorySize(4);

        activity.setSupportActionBar(toolbar);
        setupSearchView();
        getLocationPermission();
    }


    private void setupSearchView() {

        SearchAdapter searchAdapter = new SearchAdapter(activity);
        searchView.setAdapter(searchAdapter);
        searchView.setHint(R.string.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                final String finalQuery = query.trim();
                if (!itemExist(finalQuery)) {
                    searchHistoryTable.addItem(new SearchItem(finalQuery));
                }
                searchView.close(false);
                replaceFragmentWithOutAddToBackStack(LocationQueryPlacesFragment.newInstance(
                        latitude, longitude, finalQuery, globalSearch()
                ));
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        searchAdapter.setOnSearchItemClickListener(new SearchAdapter.OnSearchItemClickListener() {
            @Override
            public void onSearchItemClick(View view, int position, String text) {
                searchView.close(false);
                replaceFragmentWithOutAddToBackStack(LocationQueryPlacesFragment.newInstance(
                        latitude, longitude, text, globalSearch()
                ));
                //dispose();
            }
        });


       /* mSearchView.setOnOpenCloseListener(new SearchView.OnOpenCloseListener() {
            @Override
            public boolean onOpen() {
                if (mFab != null) {
                    mFab.hide();
                }
                return true;
            }

            @Override
            public boolean onClose() {
                if (mFab != null && !mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mFab.show();
                }
                return true;
            }
        });
        mSearchView.setVoiceText("Set permission on Android 6.0+ !");
        searchView.setOnVoiceIconClickListener(new SearchView.OnVoiceIconClickListener() {
            @Override
            public void onVoiceIconClick() {
                // permission
            }
        });*/

        /*List<SearchItem> suggestionsList = new ArrayList<>();
        suggestionsList.add(new SearchItem("search1"));
        suggestionsList.add(new SearchItem("search2"));
        suggestionsList.add(new SearchItem("search3"));
        SearchAdapter searchAdapter = new SearchAdapter(activity, suggestionList);*/

        /*suggestionsList.add(new SearchItem("search1"));
        suggestionsList.add(new SearchItem("search2"));
        suggestionsList.add(new SearchItem("search3"));
        searchAdapter.notifyDataSetChanged();*/

        List<SearchFilter> filter = new ArrayList<>();
        filter.add(new SearchFilter(activity.getString(R.string.global), false));
        searchView.setFilters(filter);


        //use mSearchView.getFiltersStates() to consider filter when performing search
    }

    private boolean globalSearch() {
        return searchView.getFiltersStates().get(0);
    }

    private boolean itemExist(String finalQuery) {
        List<SearchItem> items = searchHistoryTable.getAllItems(null);
        for (SearchItem item : items) {
            if (item.getText().equals(finalQuery)) {
                return true;
            }
        }
        return false;

    }

    public void getLocationPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && activity.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && activity.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    GPSTracker.PERMISSIONS_REQUEST_ACCESS_LOCATION);
            toast = UiUtils.displayToast(activity, toast, activity.getString(R.string.permission_denied));
            toast.show();
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            getLatLng();

        }
    }

    private void getLatLng() {
        GPSTracker gps = new GPSTracker(activity);
        if (gps.canGetLocation()) {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();
        } else {
            toast = UiUtils.displayToast(activity, toast, activity.getString(R.string.turn_on_gps));
            toast.show();
        }
    }

    public void permissionResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == GPSTracker.PERMISSIONS_REQUEST_ACCESS_LOCATION) {
            getLatLng();
        }
    }

    public void getOauth(){
        IntentUtils.openBrowser(activity, ApiUtils.O_AUTH_URL);
    }

    public void openLocationFragment() {
        replaceFragmentWithOutAddToBackStack(NearestPlacesFragment.newInstance(latitude, longitude));
    }

    public void replaceFragmentWithAddToBackStack(Fragment fr) {
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fr).addToBackStack(null).commit();

    }

    public void replaceFragmentWithOutAddToBackStack(Fragment fr) {
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.containerFrameLayout, fr).commit();

    }

    public void onNewIntent(Intent intent){
        Uri uri = intent.getData();
        Log.d(TAG, uri.toString());
        if (uri != null && uri.toString().contains(ApiUtils.CALLBACK_URL)) {

        }
    }



}
