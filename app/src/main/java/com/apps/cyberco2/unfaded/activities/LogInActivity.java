package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.MainActivity;
import com.apps.cyberco2.unfaded.customer.MainCustomerActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityLogInBinding;
import com.apps.cyberco2.unfaded.retroapi.ApiClient;
import com.apps.cyberco2.unfaded.retroapi.LoginUser;
import com.apps.cyberco2.unfaded.retroapi.UserPOJO;
import com.apps.cyberco2.unfaded.retroapi.ApiInterface;

import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.apps.cyberco2.unfaded.utils.Constants.ACCOUNT_TYPE;

public class LogInActivity extends AppCompatActivity {
    ApiInterface apiInterface;

    ActivityLogInBinding logInBinding;
    int accountType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logInBinding = DataBindingUtil.setContentView(this, R.layout.activity_log_in);
        Paper.init(this);
        accountType = Paper.book().read(ACCOUNT_TYPE);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

        logInBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser user = new LoginUser("momin@server1.com", "momin1234");
                Call<UserPOJO> call = apiInterface.loginUser(user);
                call.enqueue(new Callback<UserPOJO>() {
                    @Override
                    public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                        Log.d("TAG",response.body().getToken());
                    }

                    @Override
                    public void onFailure(Call<UserPOJO> call, Throwable t) {
                        call.cancel();
                    }
                });
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
