package com.example.andoird.venues_mmd.viewmodels.activities;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.andoird.venues_mmd.App;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.calls.RestApi;
import com.example.andoird.venues_mmd.api.models.wrapper.VenueDetailsModelWrapper;
import com.example.andoird.venues_mmd.api.models.VenueModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.example.andoird.venues_mmd.databinding.ActivityVenueDetailsBinding;
import com.example.andoird.venues_mmd.ui.activities.VenueDetailsActivity;
import com.example.andoird.venues_mmd.utils.IntentUtils;
import com.example.andoird.venues_mmd.viewmodels.NetWorkViewModel;
import com.squareup.picasso.Picasso;

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
    public ObservableField<String> venueUrl = new ObservableField<>();
    public ObservableField<String> venuePhone = new ObservableField<>();
    public ObservableField<String> likesNumber = new ObservableField<>();
    public ObservableField<String> priceRange = new ObservableField<>();
    public ObservableField<String> rating = new ObservableField<>();
    public ObservableInt progressVisibility = new ObservableInt();

    private double lat, lng;

    private AppCompatActivity activity;
    private ImageView venueImageView;

    public VenueDetailsActivityViewModel(AppCompatActivity activity, ActivityVenueDetailsBinding binding) {
        super(activity, new VenueDetailsModelWrapper());
        ((App) activity.getApplication()).getNetComponent().inject(this);
        this.activity = activity;
        this.venueImageView = binding.venueImageView;

        activity.setSupportActionBar(binding.toolbar);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //String itemTitle = getIntent().getStringExtra(EXTRA_TITLE);
        //binding.collapsingToolbar.setTitle(itemTitle);
        binding.collapsingToolbar.setExpandedTitleColor(ContextCompat.getColor(activity, android.R.color.transparent));

        //statusBarColor(binding.image, binding.collapsingToolbar);
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
        VenueModel venueModel = model.getResponse().getVenue();
        venueName.set(venueModel.getName());
        venueUrl.set(venueModel.getUrl());
        venuePhone.set(venueModel.getContact().getPhone());
        if (venueModel.getLikes() != null) {
            String likes = activity.getString(R.string.likes) + " " + venueModel.getLikes().getCount();
            likesNumber.set(likes);
        }
        if (venueModel.getPrice() != null) {
            String price = activity.getString(R.string.price) + " " + venueModel.getPrice().getMessage() + " " + venueModel.getPrice().getCurrency();
            priceRange.set(price);
        }

        String rate = activity.getString(R.string.rating) + " " + venueModel.getRating();
        rating.set(rate);

        Picasso.with(activity).load(venueModel.getBestPhoto().getPrefix() + "original" + venueModel.getBestPhoto().getSuffix())
                .placeholder(R.drawable.colors)
                .error(R.drawable.colors)
                .into(venueImageView);

        lat = venueModel.getLocation().getLat();
        lng = venueModel.getLocation().getLng();
    }

    public void openBrowser() {
        IntentUtils.openBrowser(activity, venueUrl.get());
    }

    public void openDialScreen() {
        IntentUtils.openDialScreen(activity, venuePhone.get());
    }

    public void openMap() {
        IntentUtils.openMapWithLatLng(activity, lat, lng);
    }
}
