package com.example.task1_2.Models;

public class Currency {

    private String name_currency;

    private double rate_currency;

    private String date;

    public Currency(String name_currency, double rate_currency, String date) {
        this.name_currency = name_currency;
        this.rate_currency = rate_currency;
        this.date = date;
    }

    public String getName_currency() {
        return name_currency;
    }

    public void setName_currency(String name_currency) {
        this.name_currency = name_currency;
    }

    public double getRate_currency() {
        return rate_currency;
    }

    public void setRate_currency(double rate_currency) {
        this.rate_currency = rate_currency;
    }

    public String getDate() {
        return date;
    }
}
