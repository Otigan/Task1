package com.example.task1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.Models.Currency;
import com.example.task1.Models.JsonResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    private RecyclerView recyclerView;
    //Adapter provides a binding our custom data set to views that will be displayed in RecyclerView
    private Adapter mAdapter;
    //A LayoutManager is responsible for measuring and positioning item views within a RecyclerView
    // as well as determining the policy
    // for when to recycle item views that are no longer visible to the user.
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Currency> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);

        arrayList = new ArrayList<>();

        //Creating an instance of Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        //Retrofit implements api interface
        Api api = retrofit.create(Api.class);

        //String of URL currency parameter
        String args =  "USD,RUB,KZT,UAH,GBP,CNY,JPY,BYN,CAD,AUD,NOK,SGD,CZK";


        Call<JsonResponse> call = api.getRate(args);

        //Getting response asynchronously, otherwise it would freeze main thread of app
        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                //Getting body of response Json
                JsonResponse jsonResponse = response.body();

                //Filling HashMap with results of currency rate
                HashMap<String, Double> map = jsonResponse.getRates().nameAndrate();


                for(Map.Entry<String, Double> entry : map.entrySet()) {
                    String key = entry.getKey();
                    double rate = entry.getValue();

                    //This provided for changes in parameters list
                    //because Rates model has hard-coded types of currency
                    //and if we will delete some currencies from parameters URL
                    //they will be displayed as 0.0
                    if (rate != 0.0) {
                        //Adding currencies to ArrayList
                        arrayList.add(new Currency(key, rate, jsonResponse.getDate()));
                    }
                }
                //Setting LayoutManager
                recyclerView.setLayoutManager(mLayoutManager);
                //Creating an instance of Adapter with our ArrayList of currencies
                mAdapter = new Adapter(arrayList);
                //Setting Adapter to our RecyclerView
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {

                //Displays an error with request in popping notification
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}