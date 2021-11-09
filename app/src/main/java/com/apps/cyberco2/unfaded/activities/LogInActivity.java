package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.MainActivity;
import com.apps.cyberco2.unfaded.customer.MainCustomerActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityLogInBinding;

import io.paperdb.Paper;

import static com.apps.cyberco2.unfaded.utils.Constants.ACCOUNT_TYPE;

public class LogInActivity extends AppCompatActivity {
    ActivityLogInBinding logInBinding;
    int accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logInBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in);
        Paper.init(this);
        accountType = Paper.book().read(ACCOUNT_TYPE);
        logInBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToHome();
            }
        });
        logInBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(LogInActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
                finish();
            }
        });
        logInBinding.txtForgetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentForget = new Intent(LogInActivity.this, ForgetPwdActivity.class);
                startActivity(intentForget);
                finish();
            }
        });
        logInBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(LogInActivity.this, SelectAccountActivity.class);
                startActivity(backIntent);
                finish();
            }
        });
    }

    public void moveToHome() {

        if (accountType == 1) {
            Intent mainIntent = new Intent(LogInActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        } else {
            Intent mainIntent = new Intent(LogInActivity.this, MainCustomerActivity.class);
            startActivity(mainIntent);
            finish();
        }

    }

    public void moveToForgetPWD() {

    }

    public void moveTORegister() {

    }

}
