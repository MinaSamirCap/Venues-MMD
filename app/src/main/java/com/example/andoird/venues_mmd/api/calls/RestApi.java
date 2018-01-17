package com.example.andoird.venues_mmd.api.calls;

import com.example.andoird.venues_mmd.api.models.SearchVenueModelWrapper;
import com.example.andoird.venues_mmd.api.models.VenueDetailsModelWrapper;
import com.example.andoird.venues_mmd.api.utils.ApiUtils;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.example.andoird.venues_mmd.api.utils.ApiUtils.CLIENT_ID_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.CLIENT_SECRET_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.DATE_VERSION_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.INTENT_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.LIMIT_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.LL_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.NEAR_KEY;
import static com.example.andoird.venues_mmd.api.utils.ApiUtils.QUERY_KEY;

/**
 * Created by mina on 06/12/17.
 */

public interface RestApi {

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getPlacesWithArea(@Query(NEAR_KEY) String near,
                                                          @Query(CLIENT_ID_KEY) String clientId,
                                                          @Query(CLIENT_SECRET_KEY) String clientSecret,
                                                          @Query(DATE_VERSION_KEY) String date);

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getPlacesWithLocationQuery(@Query(LL_KEY) String latLng,
                                                                   @Query(QUERY_KEY) String query,
                                                                   @Query(CLIENT_ID_KEY) String clientId,
                                                                   @Query(CLIENT_SECRET_KEY) String clientSecret,
                                                                   @Query(DATE_VERSION_KEY) String date);

    @GET(ApiUtils.SEARCH_VENUE_URL)
    Observable<SearchVenueModelWrapper> getGlobalPlaces(@Query(INTENT_KEY) String intent,
                                                        @Query(QUERY_KEY) String query,
                                                        @Query(CLIENT_ID_KEY) String clientId,
                                                        @Query(CLIENT_SECRET_KEY) String clientSecret,
                                                        @Query(DATE_VERSION_KEY) String date);

    @GET(ApiUtils.EXPLORE_VENUE_URL)
    Observable<SearchVenueModelWrapper> getNearestPlaces(@Query(LL_KEY) String latLng,
                                                         @Query(CLIENT_ID_KEY) String clientId,
                                                         @Query(CLIENT_SECRET_KEY) String clientSecret,
                                                         @Query(DATE_VERSION_KEY) String date,
                                                         @Query(LIMIT_KEY) String limit);

    @GET(ApiUtils.DETAILS_VENUE_URL)
    Observable<VenueDetailsModelWrapper> getVenueDetails(@Path(value = ApiUtils.VENUE_ID_KEY, encoded = true) String venueId,
                                                         @Query(CLIENT_ID_KEY) String clientId,
                                                         @Query(CLIENT_SECRET_KEY) String clientSecret,
                                                         @Query(DATE_VERSION_KEY) String date);

}
