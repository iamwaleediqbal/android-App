package com.apps.cyberco2.unfaded.retroapi;

import com.google.gson.annotations.SerializedName;

public class ForgetPassword {
    @SerializedName("email")
    public String email;

    public ForgetPassword(String email) {
        this.email = email;
    }
}
