package com.apps.cyberco2.unfaded.retroapi;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/api/login")
    Call<UserPOJO> loginUser(@Body LoginUser user);
    @POST("/api/register")
    Call<UserPOJO> registerUser(@Body RegisterUser user);
    @POST("/api/forget-password")
    Call<UserPOJO> forgetPassword(@Body ForgetPassword user);
    @POST("/api/verify-otp")
    Call<UserPOJO> verifyOTP(@Body VerifyOTP user);
    @POST("/api/change-password")
    Call<UserPOJO> updatePassword(@Body ResetPassword user);
}
