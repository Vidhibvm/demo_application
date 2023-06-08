package com.hellotestapp.myapplication.NestestJsonCall;

import com.google.gson.annotations.SerializedName;
import com.hellotestapp.myapplication.apicall.model.MultipleResource;
import com.hellotestapp.myapplication.apicall.model.Support;

import java.util.ArrayList;
import java.util.List;

public class Book {
@SerializedName("page")
    Integer page;
    @SerializedName("per_page")
    Integer per_page;


    @SerializedName("total")
    Integer total;
    @SerializedName("total_pages")
    Integer total_pages;
    @SerializedName("data")
    ArrayList<Data> data;
    @SerializedName("support")
    Support support;
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public Support getSupport() {
        return support;
    }

    public void setSupport(Support support) {
        this.support = support;
    }

}
