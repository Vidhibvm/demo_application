package com.hellotestapp.myapplication.sqlitedatabse;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.hellotestapp.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterClick {

    public List<User> userlist;
    RecyclerView recyclerView;
    UserAdapter userAdapter;
    int[] id = new int[]{1, 2, 3, 4, 5};
    String[] name = new String[]{"vidhi", "nirali", "dolly", "isha", "hello"};
    String[] number = new String[]{"2565896521", "1456846", "7498532565", "5498659", "5461452412"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_main);

        recyclerView = (findViewById(R.id.recycle_view));

        userlist = new ArrayList<>();

        if(!Prefs.getBoolean("dataget")){
            for (int i = 0; i <= 4; i++) {
                new Mydatabase(this).insertdata(name[i], number[i], 0);
            }
            Prefs.putBoolean("dataget",true);
        }

        userlist = new Mydatabase(this).retrivedata();
        userAdapter = new UserAdapter(MainActivity.this, userlist, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(userAdapter);

    }

    @Override
    public void onitemclick(int position) {
        Toast.makeText(this, position + "", Toast.LENGTH_SHORT).show();

    }
}