package com.hellotestapp.myapplication.NestestJsonCall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.hellotestapp.myapplication.databinding.ActivityNestedApiActivityBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class NestedApiActivityActivity extends AppCompatActivity {
    ActivityNestedApiActivityBinding binding;
    MainBookAdapter mainBookAdapter;
    ArrayList<Book> booklist = new ArrayList<>();
    ArrayList<Data> datalist = new ArrayList<>();
    String josndata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNestedApiActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        try {
            josndata = AssetJSONFile("jsonviewer.json", NestedApiActivityActivity.this);

        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


        try {
            JSONObject jsonObject = new JSONObject(josndata);
            JSONArray jsonArray = jsonObject.getJSONArray("book");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                String page = jsonObject1.getString("page");
                String per_page = jsonObject1.getString("per_page");
                String total = jsonObject1.getString("total");
                String total_pages = jsonObject1.getString("total_pages");
                JSONArray data = jsonObject1.getJSONArray("data");

                Book book = new Book();
                book.setPage(Integer.valueOf(page));
                book.setPer_page(Integer.valueOf(per_page));
                book.setTotal(Integer.valueOf(total));
                book.setTotal_pages(Integer.valueOf(total_pages));
                datalist = new ArrayList<>();
                for (int j = 0; j < data.length(); j++) {
                    Data data1 = new Data();
                    JSONObject jsonObject2 = data.getJSONObject(j);
                    String id = jsonObject2.getString("id").toString();
                    String name = jsonObject2.getString("name").toString();
                    String year = jsonObject2.getString("year").toString();
                    String color = jsonObject2.getString("color").toString();
                    String pantone_value = jsonObject2.getString("pantone_value").toString();

                    Log.e("TAG", "onCreate: " + data.length() + "////" + name);

                    data1.setId(Integer.valueOf(id));
                    data1.setName(name);
                    data1.setYear(Integer.valueOf(year));
                    data1.setColor(color);
                    data1.setPantone_value(pantone_value);
                    datalist.add(data1);
                }
                book.setData(datalist);
                booklist.add(book);
            }

            binding.mainRecycview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            mainBookAdapter = new MainBookAdapter(NestedApiActivityActivity.this, booklist);
            binding.mainRecycview.setNestedScrollingEnabled(false);

            binding.mainRecycview.setAdapter(mainBookAdapter);

        } catch (
                JSONException e) {
            throw new RuntimeException(e);
        }


    }


    public static String AssetJSONFile(String filename, Context context) throws IOException {
        AssetManager manager = context.getAssets();
        InputStream file = manager.open(filename);
        byte[] formArray = new byte[file.available()];
        file.read(formArray);
        file.close();

        return new String(formArray);
    }
}