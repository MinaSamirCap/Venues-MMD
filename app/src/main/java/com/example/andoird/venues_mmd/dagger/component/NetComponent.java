package com.example.andoird.venues_mmd.dagger.component;

import com.example.andoird.venues_mmd.dagger.module.AppModule;
import com.example.andoird.venues_mmd.dagger.module.NetModule;
import com.example.andoird.venues_mmd.viewmodels.activities.MainActivityViewModel;
import com.example.andoird.venues_mmd.viewmodels.activities.VenueDetailsActivityViewModel;
import com.example.andoird.venues_mmd.viewmodels.fragments.LocationQueryPlacesFragmentViewModel;
import com.example.andoird.venues_mmd.viewmodels.fragments.NearestPlacesFragmentViewModel;

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
    void inject(NearestPlacesFragmentViewModel placesWithLocationFragmentViewModel);
    void inject(LocationQueryPlacesFragmentViewModel locationQueryPlacesFragmentViewModel);

    //void inject(NetWorkViewModel NetWorkViewModel);
    //<T> void inject(NetWorkViewModel<T> tNetWorkViewModel);
}
