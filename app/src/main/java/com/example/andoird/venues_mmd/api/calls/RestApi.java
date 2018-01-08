package com.example.andoird.venues_mmd.api.calls;

import com.example.andoird.venues_mmd.api.models.SearchVenueModelWrapper;
import com.example.andoird.venues_mmd.api.models.VenueDetailsModelWrapper;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mina on 06/12/17.
 */

public interface RestApi {

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getPlacesWithName(@Query("near") String near,
                                                          @Query("client_id") String clientId,
                                                          @Query("client_secret") String clientSecret,
                                                          @Query("v") String date);

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getPlacesWithLocation(@Query("ll") String latLng,
                                                              @Query("client_id") String clientId,
                                                              @Query("client_secret") String clientSecret,
                                                              @Query("v") String date);

    @GET(ApiUtils.DETAILS_VENUE_URL)
    Observable<VenueDetailsModelWrapper> getVenueDetails(@Path(value = ApiUtils.VENUE_ID, encoded = true) String venueId,
                                                         @Query("client_id") String clientId,
                                                         @Query("client_secret") String clientSecret,
                                                         @Query("v") String date);

}
