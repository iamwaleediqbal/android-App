package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.OtpActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityOtpBinding;
import com.apps.cyberco2.unfaded.databinding.ActivityResetPwdBinding;
import com.apps.cyberco2.unfaded.retroapi.ApiClient;
import com.apps.cyberco2.unfaded.retroapi.ApiInterface;
import com.apps.cyberco2.unfaded.retroapi.ResetPassword;
import com.apps.cyberco2.unfaded.retroapi.UserPOJO;
import com.apps.cyberco2.unfaded.retroapi.VerifyOTP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ResetPwdActivity extends AppCompatActivity {
    ActivityResetPwdBinding resetPwdBinding;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        resetPwdBinding = DataBindingUtil.setContentView(this, R.layout.activity_reset_pwd);
        resetPwdBinding.btnVerifiy.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                TextView editTextPassword = (TextView) findViewById(R.id.et_password);
                TextView editTextConfirmPassword = (TextView) findViewById(R.id.et_confirm_password);
                String password = editTextPassword.getText().toString();
                String confirmPassword = editTextConfirmPassword.getText().toString();
                
                Intent intent = getIntent();
                String user_email = intent.getStringExtra("email");
                ResetPassword user = new ResetPassword(user_email, password, confirmPassword);
                Call<UserPOJO> call = apiInterface.updatePassword(user);
                Toast.makeText(getApplicationContext(),
                    "Verifying ...", Toast.LENGTH_LONG).show();
                call.enqueue(new Callback<UserPOJO>() {


                    @Override
                    public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                        if (response.body().getMessage() == "Invalid OTP Code") {
                            //progressDoalog.dismiss();
                            Toast.makeText(getApplicationContext(),
                                "Wrong Credentials...", Toast.LENGTH_SHORT).show();

                        } else {

                            Intent backIntent = new Intent(ResetPwdActivity.this, LogInActivity.class);
                            startActivity(backIntent);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserPOJO> call, Throwable t) {
                        call.cancel();
                        Toast.makeText(getApplicationContext(),
                            "Wrong Credentials", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
