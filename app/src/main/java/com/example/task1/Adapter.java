package com.example.task1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1.Models.Currency;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Currency> list;

    public Adapter(ArrayList<Currency> list) {
        this.list = list;
    }


    //A ViewHolder describes an item view and metadata about its place within the RecyclerView.
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mText1;
        public TextView mText2;
        public TextView mText3;


        //
        public ViewHolder(View itemView) {
            super(itemView);
            mText1 = itemView.findViewById(R.id.item_number);
            mText2 = itemView.findViewById(R.id.rate);
            mText3 = itemView.findViewById(R.id.date);
        }
    }


    //Called when RecyclerView needs a new RecyclerView.ViewHolder of the given type to represent an item.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Creating view-element from from layout-files
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        //Creating an instance of ViewHolder
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }


    //Called by RecyclerView to display the data at the specified position.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Getting current item of ArrayList
        Currency currentItem = list.get(position);


        //Strings to display rate info
        String title = "Курс евро " + "к " + currentItem.getName_currency();

        String subtitle = "" + currentItem.getRate_currency();

        String date = currentItem.getDate();

        //Setting text in TextView
        holder.mText1.setText(title);
        holder.mText2.setText(subtitle);
        holder.mText3.setText("Дата: " + date);

    }

    //Returns the total number of items in the data set held by the adapter.
    @Override
    public int getItemCount() {
        return list.size();
    }
}