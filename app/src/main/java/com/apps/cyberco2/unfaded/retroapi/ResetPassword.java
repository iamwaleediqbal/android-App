package com.apps.cyberco2.unfaded.retroapi;

import com.google.gson.annotations.SerializedName;

public class ResetPassword {
    @SerializedName("email")
    public String email;

    @SerializedName("password")
    public String password;

    @SerializedName("password_confirmation")
    public String password_confirmation;

    public ResetPassword(String email, String password, String password_confirmation) {
        this.email = email;
        this.password = password;
        this.password_confirmation = password_confirmation;
    }
}
