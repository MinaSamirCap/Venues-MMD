package com.example.andoird.venues_mmd.viewmodels;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.SearchVenueModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.lapism.searchview.SearchAdapter;
import com.lapism.searchview.SearchHistoryTable;
import com.lapism.searchview.SearchItem;
import com.lapism.searchview.SearchView;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by mina on 07/12/17.
 */

public class MainActivityViewModel extends NetWorkViewModel<SearchVenueModel> {

    @Inject
    Retrofit retrofit;

    public ObservableField<String> text = new ObservableField<>();
    public ObservableInt progressVisibility = new ObservableInt();

    public SearchView searchView;
    public Toolbar toolbar;
    private AppCompatActivity activity;
    private SearchHistoryTable recentSearchDatabase;

    public MainActivityViewModel(AppCompatActivity activity, SearchView searchView, Toolbar toolbar) {

        super(activity, new SearchVenueModel());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        this.searchView = searchView;
        this.toolbar = toolbar;
        activity.setSupportActionBar(toolbar);
        setupSearchView();
        loadData();
    }

    private void loadData() {
        Observable<SearchVenueModel> posts = retrofit.create(RestApi.class).getPosts("new cairo",
                ApiUtils.CLIENT_ID, ApiUtils.CLIENT_SECRET, ApiUtils.DATE_VERSION);

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
    protected void setModel(SearchVenueModel model) {
        text.set(model.getMeta().getRequestId() + "\n" + model.getResponse().isConfident() + "\n" +
                model.getResponse().getVenuesList().get(0).getContact().getPhone() + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getAddress() + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getState() + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getFormattedAddress().get(0) + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getFormattedAddress().get(3) + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getLabeledLatLngs().get(0).getLabel() + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getLabeledLatLngs().get(0).getLat() + "\n" +
                model.getResponse().getVenuesList().get(0).getLocation().getLabeledLatLngs().get(0).getLng() + "\n" +
                model.getResponse().getVenuesList().get(0).getStats().getUsersCount() + "\n" +
                model.getResponse().getVenuesList().get(0).isHasPerk() + "\n" +
                model.getResponse().getVenuesList().get(0).isVerified());
    }

    private void setupSearchView() {

        recentSearchDatabase = new SearchHistoryTable(activity);
        searchView.setVersionMargins(SearchView.VersionMargins.MENU_ITEM);
        searchView.setHint(R.string.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                recentSearchDatabase.addItem(new SearchItem(query));
                searchView.close(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        SearchAdapter searchAdapter = new SearchAdapter(activity);
        searchAdapter.setOnSearchItemClickListener(new SearchAdapter.OnSearchItemClickListener() {
            @Override
            public void onSearchItemClick(View view, int position, String text) {
                searchView.close(false);
            }
        });
        searchView.setAdapter(searchAdapter);

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

        /*List<SearchFilter> filter = new ArrayList<>();
        filter.add(new SearchFilter("Filter1", true));
        filter.add(new SearchFilter("Filter2", true));
        searchView.setFilters(filter);*/

        //use mSearchView.getFiltersStates() to consider filter when performing search
    }

}
