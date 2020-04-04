package com.example.task1_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task1_2.Models.Currency;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private ArrayList<Currency> list;
    private OnItemClickListener mListener;


    public Adapter(ArrayList<Currency> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }


    public  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mText1;
        public TextView mText2;
        public TextView mText3;


        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            mText1 = itemView.findViewById(R.id.item_number);
            mText2 = itemView.findViewById(R.id.rate);
            mText3 = itemView.findViewById(R.id.date);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        ViewHolder vh = new ViewHolder(v, mListener);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Currency currentItem = list.get(position);


        String title = "Курс евро " + "к " + currentItem.getName_currency();

        String subtitle = "" + currentItem.getRate_currency();

        String date = currentItem.getDate();

        holder.mText1.setText(title);
        holder.mText2.setText(subtitle);
        holder.mText3.setText("Дата: " + date);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}