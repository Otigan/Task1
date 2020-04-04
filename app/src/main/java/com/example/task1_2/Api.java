package com.example.task1_2;

import com.example.task1_2.Models.JsonResponse;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;




public interface Api {

    String key = "365c9428dcc85508c9671363f567a64f";
    String params = "USD,RUB,KZT,UAH,GBP,CNY,JPY,BYN,CAD,AUD,NOK,SGD,CZK";



    @GET("latest?access_key=" + key + "&symbols=" + params)
    Call<JsonResponse> getRate();


}