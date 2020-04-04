package com.example.task1_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.task1_2.Models.Currency;
import com.example.task1_2.Models.JsonResponse;
import com.example.task1_2.Models.Rates;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    public static final String EXTRA_TEXT = "com.example.application.example.EXTRA_TEXT";

    private RecyclerView recyclerView;
    private Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Currency> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        mLayoutManager = new LinearLayoutManager(this);

        ArrayList<Currency> arrayList = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://data.fixer.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<JsonResponse> call = api.getRate();



        call.enqueue(new Callback<JsonResponse>() {
            @Override
            public void onResponse(Call<JsonResponse> call, Response<JsonResponse> response) {

                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                JsonResponse jsonResponse = response.body();

                HashMap<String, Double> map = jsonResponse.getRates().nameAndrate();

                for(Map.Entry<String, Double> entry : map.entrySet()) {
                    String key = entry.getKey();
                    double rate = entry.getValue();

                    if (rate != 0.0) {
                        arrayList.add(new Currency(key, rate, jsonResponse.getDate()));
                    }

                }

                recyclerView.setLayoutManager(mLayoutManager);
                mAdapter = new Adapter(arrayList);
                recyclerView.setAdapter(mAdapter);

                mAdapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {

                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                        Currency currency = arrayList.get(position);

                        String text = "1 EUR равен " + currency.getRate_currency() + " " +
                                currency.getName_currency();


                        intent.putExtra(EXTRA_TEXT, text);

                        startActivity(intent);




                    }
                });


            }

            @Override
            public void onFailure(Call<JsonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}