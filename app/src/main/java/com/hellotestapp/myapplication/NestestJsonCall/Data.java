package com.hellotestapp.myapplication.NestestJsonCall;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("id")
    Integer id;
    @SerializedName("name")
    String name;
    @SerializedName("year")
    Integer year;
    @SerializedName("color")
    String color;
    @SerializedName("pantone_value")
    String pantone_value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPantone_value() {
        return pantone_value;
    }

    public void setPantone_value(String pantone_value) {
        this.pantone_value = pantone_value;
    }
}
