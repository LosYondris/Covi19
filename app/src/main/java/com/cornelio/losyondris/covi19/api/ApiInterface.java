package com.cornelio.losyondris.covi19.api;

import com.cornelio.losyondris.covi19.models.New;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

   // @GET("top-headlines")
    @GET("top-headlines?country=mx&category=health")
    Call<New> getNews(

            //@Query("country") String country ,
            @Query ("q") String query,
            @Query("apiKey") String apiKey
    );



}
