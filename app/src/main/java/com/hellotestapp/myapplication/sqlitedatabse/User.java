package com.hellotestapp.myapplication.sqlitedatabse;

import java.io.Serializable;

public class User implements Serializable {
    int id;
    String mobile_number;
    String name;
    int isfav;

    public User(int id, String mobile_number, String name, int isfav) {
        this.id = id;
        this.mobile_number = mobile_number;
        this.name = name;
        this.isfav = isfav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsfav() {
        return isfav;
    }

    public void setIsfav(int isfav) {
        this.isfav = isfav;
    }
}
