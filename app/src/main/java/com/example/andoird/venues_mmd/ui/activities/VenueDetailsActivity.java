package com.example.andoird.venues_mmd.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.databinding.ActivityVenueDetailsBinding;
import com.example.andoird.venues_mmd.viewmodels.VenueDetailsActivityViewModel;

public class VenueDetailsActivity extends BaseActivity {

    VenueDetailsActivityViewModel venueDetailsActivityViewModel;

    public static final String VENUE_ID = "venueId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityVenueDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_venue_details);
        venueDetailsActivityViewModel = new VenueDetailsActivityViewModel(this);
        binding.setDetailsActivity(venueDetailsActivityViewModel);

    }

    public static Intent openVenueDetailsActivity(Context context,String venueId){
        Intent intent = new Intent(context, VenueDetailsActivity.class);
        intent.putExtra(VENUE_ID, venueId);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        venueDetailsActivityViewModel.dispose();
    }
}
