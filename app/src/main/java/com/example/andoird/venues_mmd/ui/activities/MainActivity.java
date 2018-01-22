package com.example.andoird.venues_mmd.ui.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.databinding.ActivityMainBinding;
import com.example.andoird.venues_mmd.viewmodels.activities.MainActivityViewModel;


public class MainActivity extends BaseActivity {


    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new MainActivityViewModel(this, binding.searchView, binding.toolbar);
        binding.setMainActivity(viewModel);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        viewModel.onNewIntent(intent);
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
                viewModel.searchView.open(true);
                return true;
            case R.id.gps_item:
                viewModel.openLocationFragment();
                return true;
            default:
                return false;
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        viewModel.permissionResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.dispose();
    }
}
