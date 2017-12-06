package com.example.andoird.venues_mmd.dagger.component;

import com.example.andoird.venues_mmd.dagger.module.AppModule;
import com.example.andoird.venues_mmd.dagger.module.NetModule;
import com.example.andoird.venues_mmd.ui.activities.MainActivity;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by mina on 06/12/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    void inject(MainActivity activity);
}
