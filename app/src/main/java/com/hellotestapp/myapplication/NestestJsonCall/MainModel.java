package com.hellotestapp.myapplication.NestestJsonCall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MainModel {
    @SerializedName("Book")
    List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
