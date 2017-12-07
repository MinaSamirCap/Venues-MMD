package com.example.andoird.venues_mmd.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.example.andoird.venues_mmd.R;
import com.example.andoird.venues_mmd.databinding.ActivityMainBinding;
import com.example.andoird.venues_mmd.viewmodels.MainActivityViewModel;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MainActivityViewModel mainActivityViewModel = new MainActivityViewModel(this);
        activityMainBinding.setMainActivity(mainActivityViewModel);


    }

}
