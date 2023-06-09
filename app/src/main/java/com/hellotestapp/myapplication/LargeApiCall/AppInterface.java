package com.hellotestapp.myapplication.LargeApiCall;

import com.hellotestapp.myapplication.LargeApiCall.model.Payload;

import retrofit2.Call;
import retrofit2.http.GET;

interface AppInterface {


    @GET("/v1/38ff410f-235d-47f7-99b6-582ab8d1dae6")
    Call<Payload> getGetPayloadList();

}
