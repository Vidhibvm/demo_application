package com.hellotestapp.myapplication.githubapicall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.hellotestapp.myapplication.databinding.ActivityGithubMainBinding;
import com.hellotestapp.myapplication.githubapicall.adapter.githubAdapter;
import com.hellotestapp.myapplication.githubapicall.model.ItemsItem;
import com.hellotestapp.myapplication.githubapicall.model.mainobject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubMainActivity extends AppCompatActivity {
    ActivityGithubMainBinding mainBinding;
    gitInterface gitInterface;
    ArrayList<ItemsItem> mainobjectArrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityGithubMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        gitInterface = APIClient.getClient().create(com.hellotestapp.myapplication.githubapicall.gitInterface.class);

        Call<mainobject> call = gitInterface.GetItemListResources();
        call.enqueue(new Callback<mainobject>() {
            @Override
            public void onResponse(Call<mainobject> call, Response<mainobject> response) {
                mainobject mainobject = response.body();
                ArrayList<ItemsItem> arrayList = (ArrayList<ItemsItem>) mainobject.getItems();

                mainBinding.recMainobject.setLayoutManager(new LinearLayoutManager(GithubMainActivity.this));
                mainBinding.recMainobject.setAdapter(new githubAdapter(GithubMainActivity.this,arrayList));
                mainBinding.txtquotaMax.setText(String.valueOf(mainobject.getQuotaMax()));
                mainBinding.txtquotaRemaining.setText(String.valueOf(mainobject.getQuotaRemaining()));
            }

            @Override
            public void onFailure(Call<mainobject> call, Throwable t) {

            }
        });


    }
}