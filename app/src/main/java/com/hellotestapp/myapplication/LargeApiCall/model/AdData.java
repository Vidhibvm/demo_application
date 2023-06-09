package com.hellotestapp.myapplication.LargeApiCall.model;

import com.google.gson.annotations.SerializedName;

public class AdData {

    @SerializedName("ad_unit_id")
    private String adUnitId;

    @SerializedName("ad_network")
    private String adNetwork;

    @SerializedName("enabled")
    private boolean enabled;

    public void setAdUnitId(String adUnitId){
        this.adUnitId = adUnitId;
    }

    public String getAdUnitId(){
        return adUnitId;
    }

    public void setAdNetwork(String adNetwork){
        this.adNetwork = adNetwork;
    }

    public String getAdNetwork(){
        return adNetwork;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public boolean isEnabled(){
        return enabled;
    }

}
