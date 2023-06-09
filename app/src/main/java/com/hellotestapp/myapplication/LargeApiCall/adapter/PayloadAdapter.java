package com.hellotestapp.myapplication.LargeApiCall.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.hellotestapp.myapplication.LargeApiCall.model.AdData;
import com.hellotestapp.myapplication.LargeApiCall.model.AdNetworksItem;
import com.hellotestapp.myapplication.LargeApiCall.model.AppOpenAdsItem;
import com.hellotestapp.myapplication.LargeApiCall.model.AppSettingItem;
import com.hellotestapp.myapplication.R;
import com.squareup.okhttp.Call;

import java.util.ArrayList;
import java.util.Collection;

public class PayloadAdapter extends RecyclerView.Adapter<PayloadAdapter.PayloadViewholder> {
    Context context;
    ArrayList<Object> payloadlist;
    int view_app_setting = 1;
    int view_app_network = 2;


    public PayloadAdapter(Context context, ArrayList<Object> payloadlist){
        this.context = context;
        this.payloadlist = payloadlist;
    }
    @NonNull
    @Override
    public PayloadViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == view_app_setting){
            View view = LayoutInflater.from(context).inflate(R.layout.appsetting_item,parent,false);
            return new PayloadViewholder(view,viewType);
        }
        View view = LayoutInflater.from(context).inflate(R.layout.adnetwork_item,parent,false);
        return new PayloadViewholder(view,viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull PayloadViewholder holder, int position) {
        if(payloadlist.get(position) instanceof AppSettingItem){
            Object data = payloadlist.get(position);
            AppSettingItem settingItem = (AppSettingItem) data;
            holder.key.setText(settingItem.getKey());
            holder.value.setText(settingItem.getValue());
        }
        else{
            Object adnetwork = payloadlist.get(position);
            AdNetworksItem data2 = (AdNetworksItem) adnetwork;

            holder.ad_network.setText(((AdNetworksItem) adnetwork).getAdNetwork());
            boolean b = ((AdNetworksItem) adnetwork).isEnabled();
            if (b) {
                holder.enabled.setText("true");
            } else {
                holder.enabled.setText("false");
            }
            holder.priority.setText((String.valueOf(((AdNetworksItem) adnetwork).getPriority())));
            holder.api_key.setText(((AdNetworksItem) adnetwork).getApiKey());

            /*ArrayList<AdData> bannerAdsItemArrayList = (ArrayList<AdData>) ((AdNetworksItem) adnetwork).getBannerAds();
            ArrayList<AdData> interstitialAdsItemArrayList = (ArrayList<AdData>) ((AdNetworksItem) adnetwork).getInterstitialAds();
            ArrayList<AdData> appOpenAdsItemArrayList = (ArrayList<AdData>) ((AdNetworksItem) adnetwork).getAppOpenAds();
            ArrayList<AdData> nativeAdsItemArrayList = (ArrayList<AdData>) ((AdNetworksItem) adnetwork).getNativeAds();

            Log.e("TAG", "onBindViewHolderrrrrr: " + bannerAdsItemArrayList.size());
            setAdData("Banner Ads", context, holder.ll_main, bannerAdsItemArrayList);

            //
            setAdData("Inter Ads", context, holder.ll_main, interstitialAdsItemArrayList);
            setAdData("Open  Ads", context, holder.ll_main, appOpenAdsItemArrayList);
            setAdData("Native Ads", context, holder.ll_main, nativeAdsItemArrayList);*/
        }

    }

    @Override
    public int getItemCount() {
        return payloadlist.size();
    }

    public void setAdData(String title, Context context, LinearLayout linearLayout, ArrayList<AdData> AdsItemArrayList) {
        TextView tv = new TextView(context);
        tv.setText(title);
        linearLayout.addView(tv);
        for (AdData adsItem : AdsItemArrayList) {
            TextView tv1 = new TextView(context);
            tv.setText(adsItem.getAdNetwork());
            linearLayout.addView(tv1);
            TextView tv2 = new TextView(context);
            tv.setText(adsItem.getAdUnitId());
            linearLayout.addView(tv2);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(payloadlist.get(position) instanceof AppSettingItem){
            return view_app_setting;
        }
        else{
            return view_app_network;
        }
    }

    public class PayloadViewholder extends RecyclerView.ViewHolder {
        MaterialTextView key, value;
        MaterialTextView api_key, priority, enabled, ad_network;
        LinearLayout ll_main;
        public PayloadViewholder(@NonNull View itemView,int viewtype) {
            super(itemView);
            if (viewtype == view_app_setting) {
                key = itemView.findViewById(R.id.key);
                value = itemView.findViewById(R.id.value);
            } else {
                api_key = itemView.findViewById(R.id.api_key);
                priority = itemView.findViewById(R.id.priority);
                enabled = itemView.findViewById(R.id.enabled);
                ad_network = itemView.findViewById(R.id.ad_network);
                ll_main = itemView.findViewById(R.id.ll_main);
            }
        }
    }
}
