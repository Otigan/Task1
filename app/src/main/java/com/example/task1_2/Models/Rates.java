package com.example.task1_2.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

//This is model for embedded Json object, currency rates
public class Rates {

    @SerializedName("USD")
    @Expose
    private double uSD;
    @SerializedName("RUB")
    @Expose
    private double rUB;
    @SerializedName("KZT")
    @Expose
    private double kZT;
    @SerializedName("UAH")
    @Expose
    private double uAH;
    @SerializedName("GBP")
    @Expose
    private double gBP;
    @SerializedName("CNY")
    @Expose
    private double cNY;
    @SerializedName("JPY")
    @Expose
    private double jPY;
    @SerializedName("BYN")
    @Expose
    private double bYN;
    @SerializedName("CAD")
    @Expose
    private double cAD;
    @SerializedName("AUD")
    @Expose
    private double aUD;
    @SerializedName("NOK")
    @Expose
    private double nOK;
    @SerializedName("SGD")
    @Expose
    private double sGD;
    @SerializedName("CZK")
    @Expose
    private double cZK;

    private HashMap<String, Double> map = new HashMap<>();

    public double getUSD() {
        return uSD;
    }

    public void setUSD(double uSD) {
        this.uSD = uSD;
    }

    public double getRUB() {
        return rUB;
    }

    public void setRUB(double rUB) {
        this.rUB = rUB;
    }

    public double getKZT() {
        return kZT;
    }

    public void setKZT(double kZT) {
        this.kZT = kZT;
    }

    public double getUAH() {
        return uAH;
    }

    public void setUAH(double uAH) {
        this.uAH = uAH;
    }

    public double getGBP() {
        return gBP;
    }

    public void setGBP(double gBP) {
        this.gBP = gBP;
    }

    public double getCNY() {
        return cNY;
    }

    public void setCNY(double cNY) {
        this.cNY = cNY;
    }

    public double getJPY() {
        return jPY;
    }

    public void setJPY(double jPY) {
        this.jPY = jPY;
    }

    public double getBYN() {
        return bYN;
    }

    public void setBYN(double bYN) {
        this.bYN = bYN;
    }

    public double getCAD() {
        return cAD;
    }

    public void setCAD(double cAD) {
        this.cAD = cAD;
    }

    public double getAUD() {
        return aUD;
    }

    public void setAUD(double aUD) {
        this.aUD = aUD;
    }

    public double getNOK() {
        return nOK;
    }

    public void setNOK(double nOK) {
        this.nOK = nOK;
    }

    public double getSGD() {
        return sGD;
    }

    public void setSGD(double sGD) {
        this.sGD = sGD;
    }

    public double getCZK() {
        return cZK;
    }

    public void setCZK(double cZK) {
        this.cZK = cZK;
    }


    public HashMap<String, Double> nameAndrate(){
        map.put("USD (Доллар США)", getUSD());
        map.put("RUB (Российский рубль)", getRUB());
        map.put("UAH (Украинская гривна)", getUAH());
        map.put("KZT (Казахстанский тенге)", getKZT());
        map.put("GBP (Фунт стерлингов)", getGBP());
        map.put("CNY (Китайский юань)", getCNY());
        map.put("JPY (Японская йена)", getJPY());
        map.put("BYN (Белорусский рубль)", getBYN());
        map.put("CAD (Канадский доллар)", getCAD());
        map.put("AUD (Австралийский доллар)", getAUD());
        map.put("NOK (Норвежская крона)", getNOK());
        map.put("SGD (Сингапурский доллар)", getSGD());
        map.put("CZK (Чешская крона)", getCZK());

        return map;
    }

}

