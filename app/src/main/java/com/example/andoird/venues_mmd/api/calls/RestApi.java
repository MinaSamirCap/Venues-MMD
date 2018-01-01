package com.example.andoird.venues_mmd.api.calls;

import com.example.andoird.venues_mmd.api.models.SearchVenueModel;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;

import javax.inject.Inject;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mina on 06/12/17.
 */

public interface RestApi {

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModel> getPlacesWithName(@Query("near") String near,
                                                   @Query("client_id") String clientId,
                                                   @Query("client_secret") String clientSecret,
                                                   @Query("v") String date);

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModel> getPlacesWithLocation(@Query("ll") String latLng,
                                                       @Query("client_id") String clientId,
                                                       @Query("client_secret") String clientSecret,
                                                       @Query("v") String date);

}
