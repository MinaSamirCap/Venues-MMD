package com.example.andoird.venues_mmd;

import android.app.Application;

import com.example.andoird.venues_mmd.dagger.component.DaggerNetComponent;
import com.example.andoird.venues_mmd.dagger.component.NetComponent;
import com.example.andoird.venues_mmd.dagger.module.AppModule;
import com.example.andoird.venues_mmd.dagger.module.NetModule;

/**
 * Created by mina on 06/12/17.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.foursquare.com"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}