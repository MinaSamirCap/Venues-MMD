package com.example.andoird.venues_mmd.viewmodels;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.SearchVenueModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.example.andoird.venues_mmd.ui.adapters.VenueItemAdapter;
import com.lapism.searchview.SearchAdapter;
import com.lapism.searchview.SearchHistoryTable;
import com.lapism.searchview.SearchItem;
import com.lapism.searchview.SearchView;

import java.util.List;

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
    private SearchHistoryTable searchHistoryTable;

    private RecyclerView recyclerView;

    public MainActivityViewModel(AppCompatActivity activity, SearchView searchView,
                                 Toolbar toolbar, RecyclerView recyclerView) {

        super(activity, new SearchVenueModel());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        this.searchView = searchView;
        this.toolbar = toolbar;
        this.recyclerView = recyclerView;
        searchHistoryTable = new SearchHistoryTable(activity);
        searchHistoryTable.setHistorySize(4);

        activity.setSupportActionBar(toolbar);
        setupSearchView();
        progressVisibility.set(View.GONE);
        //loadData();
    }

    private void loadData(String queryPlace) {
        Observable<SearchVenueModel> posts = retrofit.create(RestApi.class).getPlacesWithName(queryPlace,
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
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new VenueItemAdapter(activity, model.getResponse().getVenuesList()));
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
                loadData(finalQuery);
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
                loadData(text);
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

        /*List<SearchFilter> filter = new ArrayList<>();
        filter.add(new SearchFilter("Filter1", true));
        filter.add(new SearchFilter("Filter2", true));
        searchView.setFilters(filter);*/

        //use mSearchView.getFiltersStates() to consider filter when performing search
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

}
