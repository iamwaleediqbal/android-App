package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.OtpActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityForgetPwdBinding;

public class ForgetPwdActivity extends AppCompatActivity {
    ActivityForgetPwdBinding forgetPwdBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forgetPwdBinding = DataBindingUtil.setContentView(this, R.layout.activity_forget_pwd);
        forgetPwdBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otpIntent = new Intent(ForgetPwdActivity.this, OtpActivity.class);
                startActivity(otpIntent);
            }
        });
        forgetPwdBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(ForgetPwdActivity.this, LogInActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
