package com.example.andoird.venues_mmd.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;
import com.example.andoird.venues_mmd.databinding.ActivityMainBinding;
import com.example.andoird.venues_mmd.viewmodels.MainActivityViewModel;


public class MainActivity extends BaseActivity {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new MainActivityViewModel(this, binding.searchView,
                binding.toolbar, binding.contentMain.searchRecyclerView);
        binding.setMainActivity(mainActivityViewModel);

        binding.contentMain.oAuthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(ApiUtils.O_AUTH_URL));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Uri uri = getIntent().getData();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Uri uri = getIntent().getData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search_item:
                mainActivityViewModel.searchView.open(true);
                return true;
            case R.id.gps_item:
                mainActivityViewModel.getLocationPermission();
                return true;
            default:
                return false;
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        mainActivityViewModel.permissionResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainActivityViewModel.dispose();
    }
}
