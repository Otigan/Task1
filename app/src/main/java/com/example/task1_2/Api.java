package com.example.task1_2;

import com.example.task1_2.Models.JsonResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


//Retrofit interface which do all work with http-requests
//Currency rate api i used http://data.fixer.io/api/

public interface Api {

    //Api key
    String key = "365c9428dcc85508c9671363f567a64f";


    @GET("latest?access_key=" + key)
    Call<JsonResponse> getRate(
            @Query("symbols") String args
    );


}