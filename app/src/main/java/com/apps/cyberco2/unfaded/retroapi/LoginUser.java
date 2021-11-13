package com.apps.cyberco2.unfaded.retroapi;

import com.google.gson.annotations.SerializedName;

public class LoginUser {

    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
