package com.hellotestapp.myapplication.githubapicall;



import com.hellotestapp.myapplication.apicall.model.User;
import com.hellotestapp.myapplication.githubapicall.model.mainobject;

import retrofit2.Call;
import retrofit2.http.GET;

interface gitInterface {

    @GET("/2.2/search?order=desc&sort=activity&tagged=android&site=stackoverflow")
    Call<mainobject> GetItemListResources();


}
