package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.activities.ForgetPwdActivity;
import com.apps.cyberco2.unfaded.activities.ResetPwdActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityOtpBinding;
import com.apps.cyberco2.unfaded.retroapi.ApiClient;
import com.apps.cyberco2.unfaded.retroapi.ApiInterface;
import com.apps.cyberco2.unfaded.retroapi.ForgetPassword;
import com.apps.cyberco2.unfaded.retroapi.UserPOJO;
import com.apps.cyberco2.unfaded.retroapi.VerifyOTP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtpActivity extends AppCompatActivity {
    ActivityOtpBinding otpBinding;
    ApiInterface apiInterface;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        otpBinding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        otpBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent newPwdIntent = new Intent(OtpActivity.this, ResetPwdActivity.class);
               startActivity(newPwdIntent);
           }
       });
        otpBinding.btnVerifiy.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    EditText editTextOtp1 = (EditText) findViewById(R.id.et_first);
                    String otp1 = editTextOtp1.getText().toString();
                    EditText editTextOtp2 = (EditText) findViewById(R.id.et_second);
                    String otp2 = editTextOtp2.getText().toString();
                    EditText editTextOtp3 = (EditText) findViewById(R.id.et_third);
                    String otp3 = editTextOtp3.getText().toString();
                    EditText editTextOtp4 = (EditText) findViewById(R.id.et_fourth);
                    String otp4 = editTextOtp4.getText().toString();

                    String otp = otp1 + otp2 + otp3 + otp4;

                    Intent intent = getIntent();
                    String user_email = intent.getStringExtra("email");
                    VerifyOTP user = new VerifyOTP(user_email,otp);
                    Call<UserPOJO> call = apiInterface.verifyOTP(user);
                    Toast.makeText(getApplicationContext(),
                        "Verifying ...",Toast.LENGTH_LONG).show();
                    call.enqueue(new Callback<UserPOJO>() {


                        @Override
                        public void onResponse(Call<UserPOJO> call, Response<UserPOJO> response) {
                            if(response.body().getMessage() == "Invalid OTP Code"){
                                //progressDoalog.dismiss();
                                Toast.makeText(getApplicationContext(),
                                    "Wrong Credentials...",Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Toast.makeText(getApplicationContext(),
                                    "Success",Toast.LENGTH_SHORT).show();
                                Intent backIntent = new Intent(OtpActivity.this, ResetPwdActivity.class);
                                backIntent.putExtra("email",user_email);
                                startActivity(backIntent);
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

        textWatcher();
    }

    private void textWatcher() {
        otpBinding.etFirst.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otpBinding.etFirst.getText().length() == 1) {
                    otpBinding.etFirst.clearFocus();
                    otpBinding.etSecond.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (otpBinding.etFirst.getText().length() == 0) {
                    otpBinding.etFirst.requestFocus();
                }
            }
        });
        otpBinding.etSecond.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otpBinding.etSecond.getText().length() == 1) {
                    otpBinding.etSecond.clearFocus();
                    otpBinding.etThird.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (otpBinding.etSecond.getText().length() == 0) {
                    otpBinding.etSecond.requestFocus();
                }
            }
        });
        otpBinding.etThird.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otpBinding.etThird.getText().length() == 1) {
                    otpBinding.etThird.clearFocus();
                    otpBinding.etFourth.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (otpBinding.etThird.getText().length() == 0) {
                    otpBinding.etThird.requestFocus();
                }
            }
        });
        otpBinding.etFourth.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (otpBinding.etFourth.getText().length() == 1) {
                    otpBinding.etFourth.clearFocus();
                    otpBinding.btnVerifiy.setFocusable(true);
                    otpBinding.btnVerifiy.setFocusableInTouchMode(true);
                    otpBinding.btnVerifiy.requestFocus();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (otpBinding.etFourth.getText().length() == 0) {
                    otpBinding.etFourth.requestFocus();
                }
            }
        });
    }
}
