package com.example.andoird.venues_mmd.api.calls;

import com.example.andoird.venues_mmd.api.models.SearchVenueModelWrapper;
import com.example.andoird.venues_mmd.api.models.VenueDetailsModelWrapper;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.example.andoird.venues_mmd.api.utils.ApiUtils.CLIENT_ID_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.CLIENT_SECRET;

/**
 * Created by mina on 06/12/17.
 */

public interface RestApi {

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getPlacesWithName(@Query("near") String near,
                                                          @Query(CLIENT_ID_KEY) String clientId,
                                                          @Query(CLIENT_SECRET) String clientSecret,
                                                          @Query("v") String date);

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getPlacesWithLocation(@Query("ll") String latLng,
                                                              @Query(CLIENT_ID_KEY) String clientId,
                                                              @Query(CLIENT_SECRET) String clientSecret,
                                                              @Query("v") String date);

    @GET(ApiUtils.DETAILS_VENUE_URL)
    Observable<VenueDetailsModelWrapper> getVenueDetails(@Path(value = ApiUtils.VENUE_ID, encoded = true) String venueId,
                                                         @Query(CLIENT_ID_KEY) String clientId,
                                                         @Query(CLIENT_SECRET) String clientSecret,
                                                         @Query("v") String date);

}
