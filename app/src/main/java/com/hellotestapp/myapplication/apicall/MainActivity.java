package com.hellotestapp.myapplication.apicall;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.R;
import com.hellotestapp.myapplication.apicall.model.Datum;
import com.hellotestapp.myapplication.apicall.model.Example;
import com.hellotestapp.myapplication.apicall.model.User;
import com.hellotestapp.myapplication.apicall.model.UserList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;
    ArrayList<Datum> datalist = new ArrayList<>();
    AllListAdapter allListAdapter;
    RecyclerView recycleview_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);
        apiInterface = APIClient.getClient().create(APIInterface.class);

        recycleview_data  = (RecyclerView)findViewById(R.id.recycleview_data);


        Call<Example> call = apiInterface.getalllist();
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {

                Example example = new Example();
                example = response.body();
                int page = example.getPage();
                int per_page = example.getPerPage();
                int total = example.getTotal();
                int total_pages = example.getTotalPages();
                ArrayList<Datum> data = (ArrayList<Datum>) example.getData();
               /* example.setPage(page);
                example.setPerPage(per_page);
                example.setTotal(total);
                example.setTotalPages(total_pages);
                example.setData(data);*/
              //  datalist.add(data);


               allListAdapter = new AllListAdapter(MainActivity.this,data);
               recycleview_data.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recycleview_data.setHasFixedSize(true);
                recycleview_data.setAdapter(allListAdapter);
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });


        User user = new User("morpheus", "leader");
        Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();

                String data = user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt;
                Toast.makeText(getApplicationContext(), user1.name + " " + user1.job + " " + user1.id + " " + user1.createdAt, Toast.LENGTH_SHORT).show();
                responseText.setText(data);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });

        /**
         GET List Users
         **/
        Call<UserList> call2 = apiInterface.doGetUserList("2");
        call2.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {

                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });


        /**
         POST name and job Url encoded.
         **/
        Call<UserList> call3 = apiInterface.doCreateUserWithField("morpheus", "leader");
        call3.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                UserList userList = response.body();
                Integer text = userList.page;
                Integer total = userList.total;
                Integer totalPages = userList.totalPages;
                List<UserList.Datum> datumList = userList.data;
                Toast.makeText(getApplicationContext(), text + " page\n" + total + " total\n" + totalPages + " totalPages\n", Toast.LENGTH_SHORT).show();

                for (UserList.Datum datum : datumList) {
                    Toast.makeText(getApplicationContext(), "id : " + datum.id + " name: " + datum.first_name + " " + datum.last_name + " avatar: " + datum.avatar, Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });

    }
}