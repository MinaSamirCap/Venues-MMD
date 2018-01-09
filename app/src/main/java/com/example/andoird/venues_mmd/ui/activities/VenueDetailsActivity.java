package com.example.andoird.venues_mmd.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.graphics.Palette;
import android.transition.Slide;
import android.widget.ImageView;

import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.databinding.ActivityVenueDetailsBinding;
import com.example.andoird.venues_mmd.viewmodels.VenueDetailsActivityViewModel;

public class VenueDetailsActivity extends BaseActivity {

    VenueDetailsActivityViewModel venueDetailsActivityViewModel;

    public static final String VENUE_ID = "venueId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActivityTransitions();
        ActivityVenueDetailsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_venue_details);
        venueDetailsActivityViewModel = new VenueDetailsActivityViewModel(this);
        binding.setDetailsActivity(venueDetailsActivityViewModel);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String itemTitle = "MinaSamir";//getIntent().getStringExtra(EXTRA_TITLE);
        binding.collapsingToolbar.setTitle(itemTitle);
        binding.collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        binding.title.setText(itemTitle);

        statusBarColor(binding.image, binding.collapsingToolbar);

    }

    private void statusBarColor(ImageView imageView, CollapsingToolbarLayout collapsingToolbar) {
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                applyPalette(palette, collapsingToolbar);
            }
        });
    }

    /// change the color of toolbar to match the pallet I get from the image ..
    private void applyPalette(Palette palette, CollapsingToolbarLayout collapsingToolbar) {
        int primaryDark = getResources().getColor(R.color.primary_dark);
        int primary = getResources().getColor(R.color.primary);
        collapsingToolbar.setContentScrimColor(palette.getMutedColor(primary));
        collapsingToolbar.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        //updateBackground((FloatingActionButton) findViewById(R.id.fab), palette);
        supportStartPostponedEnterTransition();
    }

    public static Intent openVenueDetailsActivity(Context context, String venueId) {
        Intent intent = new Intent(context, VenueDetailsActivity.class);
        intent.putExtra(VENUE_ID, venueId);
        return intent;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        venueDetailsActivityViewModel.dispose();
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }
}
