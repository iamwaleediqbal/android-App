package com.apps.cyberco2.unfaded.retroapi;

import com.google.gson.annotations.SerializedName;

public class VerifyOTP {
    @SerializedName("email")
    public String email;
    @SerializedName("otp")
    public String otp;

    public VerifyOTP(String email, String otp) {
        this.email = email;
        this.otp = otp;
    }
}
