package com.hellotestapp.myapplication.LargeApiCall.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Payload{

	@SerializedName("payload")
	private Payload payload;

	@SerializedName("ad_networks")
	private List<AdNetworksItem> adNetworks;

	@SerializedName("app_setting")
	private List<AppSettingItem> appSetting;

	public void setPayload(Payload payload){
		this.payload = payload;
	}

	public Payload getPayload(){
		return payload;
	}

	public void setAdNetworks(List<AdNetworksItem> adNetworks){
		this.adNetworks = adNetworks;
	}

	public List<AdNetworksItem> getAdNetworks(){
		return adNetworks;
	}

	public void setAppSetting(List<AppSettingItem> appSetting){
		this.appSetting = appSetting;
	}

	public List<AppSettingItem> getAppSetting(){
		return appSetting;
	}
}