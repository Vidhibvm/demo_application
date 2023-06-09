package com.hellotestapp.myapplication.LargeApiCall.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AdNetworksItem{

	@SerializedName("ad_network")
	private String adNetwork;

	@SerializedName("api_key")
	private String apiKey;

	@SerializedName("priority")
	private int priority;

	@SerializedName("enabled")
	private boolean enabled;

	@SerializedName("native_ads")
	private List<AdData> nativeAds;

	@SerializedName("interstitial_ads")
	private List<AdData> interstitialAds;

	@SerializedName("banner_ads")
	private List<AdData> bannerAds;

	@SerializedName("app_open_ads")
	private List<AdData> appOpenAds;

	public void setAdNetwork(String adNetwork){
		this.adNetwork = adNetwork;
	}

	public String getAdNetwork(){
		return adNetwork;
	}

	public void setApiKey(String apiKey){
		this.apiKey = apiKey;
	}

	public String getApiKey(){
		return apiKey;
	}

	public void setPriority(int priority){
		this.priority = priority;
	}

	public int getPriority(){
		return priority;
	}

	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}

	public boolean isEnabled(){
		return enabled;
	}

	public void setNativeAds(List<AdData> nativeAds){
		this.nativeAds = nativeAds;
	}

	public List<AdData> getNativeAds(){
		return nativeAds;
	}

	public void setInterstitialAds(List<AdData> interstitialAds){
		this.interstitialAds = interstitialAds;
	}

	public List<AdData> getInterstitialAds(){
		return interstitialAds;
	}

	public void setBannerAds(List<AdData> bannerAds){
		this.bannerAds = bannerAds;
	}

	public List<AdData> getBannerAds(){
		return bannerAds;
	}

	public void setAppOpenAds(List<AdData> appOpenAds){
		this.appOpenAds = appOpenAds;
	}

	public List<AdData> getAppOpenAds(){
		return appOpenAds;
	}
}