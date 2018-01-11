package com.example.andoird.venues_mmd.dagger.component;

import com.example.andoird.venues_mmd.dagger.module.AppModule;
import com.example.andoird.venues_mmd.dagger.module.NetModule;
import com.example.andoird.venues_mmd.ui.activities.MainActivity;
import com.example.andoird.venues_mmd.viewmodels.MainActivityViewModel;
import com.example.andoird.venues_mmd.viewmodels.NetWorkViewModel;
import com.example.andoird.venues_mmd.viewmodels.VenueDetailsActivityViewModel;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by mina on 06/12/17.
 */

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    //void inject(MainActivity activity);

    void inject(MainActivityViewModel mainActivityViewModel);
    void inject(VenueDetailsActivityViewModel venueDetailsActivityViewModel);

    //void inject(NetWorkViewModel NetWorkViewModel);
    //<T> void inject(NetWorkViewModel<T> tNetWorkViewModel);
}
