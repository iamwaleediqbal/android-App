package com.apps.cyberco2.unfaded.retroapi;

import com.google.gson.annotations.SerializedName;

public class RegisterUser {

    @SerializedName("email")
    public String email;
    @SerializedName("password")
    public String password;

    @SerializedName("full_name")
    public String full_name;
    @SerializedName("phone_number")
    public String phone_number;
    @SerializedName("role_id")
    public Integer role_id;

    public RegisterUser(String email, String password,String name,String phone,Integer role){
        this.email = email;
        this.password = password;
        this.full_name = name;
        this. phone_number = phone;
        this.role_id = role;

    }
}
