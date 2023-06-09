package com.hellotestapp.myapplication.LargeApiCall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.hellotestapp.myapplication.LargeApiCall.adapter.PayloadAdapter;
import com.hellotestapp.myapplication.LargeApiCall.model.Payload;
import com.hellotestapp.myapplication.databinding.ActivityRestApiBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestApiActivity extends AppCompatActivity {
    ActivityRestApiBinding restApiBinding;
    ArrayList<Object> payloadlist;
    AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restApiBinding = ActivityRestApiBinding.inflate(LayoutInflater.from(RestApiActivity.this));
        setContentView(restApiBinding.getRoot());

        appInterface = APIClient.getClient().create(AppInterface.class);

        Call<Payload> call = appInterface.getGetPayloadList();
        call.enqueue(new Callback<Payload>() {
            @Override
            public void onResponse(Call<Payload> call, Response<Payload> response) {
              Payload payload = response.body();
              payloadlist.addAll(payload.getPayload().getAppSetting());
              payloadlist.addAll(payload.getPayload().getAdNetworks());

              restApiBinding.recPayload.setLayoutManager(new LinearLayoutManager(RestApiActivity.this));
              restApiBinding.recPayload.setAdapter(new PayloadAdapter(RestApiActivity.this,payloadlist));

            }

            @Override
            public void onFailure(Call<Payload> call, Throwable t) {

            }
        });


    }
}