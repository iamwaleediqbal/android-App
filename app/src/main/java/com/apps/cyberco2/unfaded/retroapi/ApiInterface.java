package com.apps.cyberco2.unfaded.retroapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/login")
    Call<UserPOJO> loginUser(@Body LoginUser user);
}