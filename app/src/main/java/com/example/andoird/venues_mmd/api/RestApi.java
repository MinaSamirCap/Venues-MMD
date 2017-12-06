package com.example.andoird.venues_mmd.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mina on 06/12/17.
 */

public interface RestApi {

    @GET("/v2/venues/search?")
    Call<String> getPosts(@Query("near") String near,
                          @Query("client_id") String clientId,
                          @Query("client_secret") String clientSecret,
                          @Query("v") String date);
}
