package com.hellotestapp.myapplication.apicall;

import com.hellotestapp.myapplication.apicall.model.Example;
import com.hellotestapp.myapplication.apicall.model.MultipleResource;
import com.hellotestapp.myapplication.apicall.model.User;
import com.hellotestapp.myapplication.apicall.model.UserList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface APIInterface {

    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @GET("/api/unknown")
    Call<Example> getalllist();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);
}