package com.example.andoird.venues_mmd.api;

import com.example.andoird.venues_mmd.api.models.BaseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mina on 06/12/17.
 */

public interface RestApi {

    @GET("/v2/venues/search?")
    Observable<BaseModel> getPosts(@Query("near") String near,
                                   @Query("client_id") String clientId,
                                   @Query("client_secret") String clientSecret,
                                   @Query("v") String date);
}
