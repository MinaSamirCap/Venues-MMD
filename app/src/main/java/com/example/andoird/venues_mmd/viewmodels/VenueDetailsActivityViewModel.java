package com.example.andoird.venues_mmd.viewmodels;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.VenueDetailsModelWrapper;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.example.andoird.venues_mmd.ui.activities.VenueDetailsActivity;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by mina on 08/01/18.
 */

public class VenueDetailsActivityViewModel extends NetWorkViewModel<VenueDetailsModelWrapper> {

    @Inject
    Retrofit retrofit;

    public ObservableField<String> venueName = new ObservableField<>();
    public ObservableInt progressVisibility = new ObservableInt();
    private AppCompatActivity activity;


    public VenueDetailsActivityViewModel(AppCompatActivity activity) {
        super(activity, new VenueDetailsModelWrapper());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        loadVenueDetails();
    }

    private void loadVenueDetails() {

        Observable<VenueDetailsModelWrapper> posts = retrofit.create(RestApi.class).
                getVenueDetails(activity.getIntent().getStringExtra(VenueDetailsActivity.VENUE_ID),
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
    protected void setModel(VenueDetailsModelWrapper model) {
        venueName.set(model.getResponse().getVenue().getName() + " " + model.getResponse().getVenue().getId());
    }
}
