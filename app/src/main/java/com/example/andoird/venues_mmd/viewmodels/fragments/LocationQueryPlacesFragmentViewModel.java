package com.example.andoird.venues_mmd.viewmodels.fragments;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.example.andoird.venues_mmd.viewmodels.NetWorkViewModel;
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

public class LocationQueryPlacesFragmentViewModel extends NetWorkViewModel<SearchVenueModelWrapper> {

    @Inject
    Retrofit retrofit;

    public ObservableField<String> text = new ObservableField<>();
    public ObservableInt progressVisibility = new ObservableInt();

    private FragmentActivity activity;

    private VenueItemAdapter venueItemAdapter;
    private List<VenueModel> data = new ArrayList<>();

    public LocationQueryPlacesFragmentViewModel(FragmentActivity activity, RecyclerView recyclerView, double latitude, double longitude, String query, boolean isGlobal) {

        super(activity, new SearchVenueModelWrapper());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        setupRecyclerView(recyclerView);
        progressVisibility.set(View.GONE);
        if (isGlobal) {
            loadData(ApiUtils.INTENT_GLOBAL_KEY, query);
        }else {
            loadData(latitude, longitude, query);
        }
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


    @Override
    protected void setModel(SearchVenueModelWrapper model) {
        if (data.size() > 0) {
            venueItemAdapter.notifyItemRangeRemoved(0, data.size());
            data.clear();
        }
        data.addAll(model.getResponse().getVenuesList());
        //venueItemAdapter.notifyDataSetChanged(); we do not use this to enable animation in recycler view
        venueItemAdapter.notifyItemRangeInserted(0, data.size());
    }


    private void loadData(double latitude, double longitude, String query) {
        Observable<SearchVenueModelWrapper> posts = retrofit.create(RestApi.class).getPlacesWithLocationQuery(latitude + "," + longitude,
                query, ApiUtils.CLIENT_ID, ApiUtils.CLIENT_SECRET, ApiUtils.DATE_VERSION);

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

    private void loadData(String intent, String query) {
        Observable<SearchVenueModelWrapper> posts = retrofit.create(RestApi.class).getGlobalPlaces(intent,
                query, ApiUtils.CLIENT_ID, ApiUtils.CLIENT_SECRET, ApiUtils.DATE_VERSION);

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

}
