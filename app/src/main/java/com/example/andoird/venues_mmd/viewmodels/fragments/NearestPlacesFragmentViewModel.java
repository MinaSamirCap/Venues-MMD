package com.example.andoird.venues_mmd.viewmodels.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.VenueExploreModel;
import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.example.andoird.venues_mmd.api.models.wrapper.SearchVenueLocationModelWrapper;
import com.example.andoird.venues_mmd.api.models.wrapper.SearchVenueModelWrapper;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.example.andoird.venues_mmd.ui.adapters.VenueItemAdapter;
import com.example.andoird.venues_mmd.utils.GPSTracker;
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

public class NearestPlacesFragmentViewModel extends NetWorkViewModel<SearchVenueLocationModelWrapper> {

    @Inject
    Retrofit retrofit;
    
    public ObservableField<String> text = new ObservableField<>();
    public ObservableInt progressVisibility = new ObservableInt();

    private FragmentActivity activity;

    private double latitude, longitude;
    private VenueItemAdapter venueItemAdapter;
    private List<VenueModel> data = new ArrayList<>();

    public NearestPlacesFragmentViewModel(FragmentActivity activity, RecyclerView recyclerView, double latitude, double longitude) {

        super(activity, new SearchVenueLocationModelWrapper());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        setupRecyclerView(recyclerView);
        progressVisibility.set(View.GONE);
        this.latitude = latitude;
        this.longitude = longitude;
        loadData();
    }

    private void setupRecyclerView(RecyclerView recyclerView) {

        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(activity)
                        .color(ContextCompat.getColor(activity, R.color.transparent))
                        .sizeResId(R.dimen.divider)
                        .build());
        SlideInUpAnimator slideInUpAnimator = new SlideInUpAnimator();
        slideInUpAnimator.setAddDuration(500);
        recyclerView.setItemAnimator(slideInUpAnimator);

        venueItemAdapter = new VenueItemAdapter(activity, data);
        recyclerView.setAdapter(venueItemAdapter);
    }

    private void loadData() {
        Observable<SearchVenueLocationModelWrapper> posts = retrofit.create(RestApi.class).getNearestPlaces(latitude + "," + longitude,
                ApiUtils.CLIENT_ID, ApiUtils.CLIENT_SECRET, ApiUtils.DATE_VERSION, ApiUtils.LIMIT_100);

        makeNetworkRequest(posts, new ProgressController() {
            @Override
            public void setProgress() {
                progressVisibility.set(View.VISIBLE);
            }

            @Override
            public void removeProgress() {
                progressVisibility.set(View.GONE);
            }
        });
    }

    @Override
    protected void setModel(SearchVenueLocationModelWrapper model) {
        if (data.size() > 0) {
            venueItemAdapter.notifyItemRangeRemoved(0, data.size());
            data.clear();
        }
        List<VenueExploreModel> tempVenues = model.getResponse().getGroups().get(0).getItems();
        for (VenueExploreModel tempVenue: tempVenues) {
            data.add(tempVenue.getVenue());
        }
        venueItemAdapter.notifyItemRangeInserted(0, data.size());
    }


}
