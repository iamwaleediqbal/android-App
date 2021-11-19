package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.OtpActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityForgetPwdBinding;
import com.apps.cyberco2.unfaded.retroapi.ApiClient;
import com.apps.cyberco2.unfaded.retroapi.ApiInterface;
import com.apps.cyberco2.unfaded.retroapi.ForgetPassword;
import com.apps.cyberco2.unfaded.retroapi.LoginUser;
import com.apps.cyberco2.unfaded.retroapi.UserPOJO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgetPwdActivity extends AppCompatActivity {
    ActivityForgetPwdBinding forgetPwdBinding;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        forgetPwdBinding = DataBindingUtil.setContentView(this, R.layout.activity_forget_pwd);
        forgetPwdBinding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEmail = (EditText) findViewById(R.id.et_email);
                String email = editTextEmail.getText().toString();
                ForgetPassword user = new ForgetPassword(email);
                Call<UserPOJO> call = apiInterface.forgetPassword(user);
                Toast.makeText(getApplicationContext(),
                    "Verifying ...",Toast.LENGTH_LONG).show();
                call.enqueue(new Callback<UserPOJO>() {


                    @Override
                    public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                        if(response.body().getMessage() == "Email Not Found"){
                            //progressDoalog.dismiss();
                            Toast.makeText(getApplicationContext(),
                                "Wrong Credentials...",Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Intent otpIntent = new Intent(ForgetPwdActivity.this, OtpActivity.class);
                            otpIntent.putExtra("email", email);
                            startActivity(otpIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserPOJO> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(getApplicationContext(),
                            "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    }
                });

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
