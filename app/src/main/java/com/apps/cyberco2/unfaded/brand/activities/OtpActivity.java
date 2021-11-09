package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.activities.ForgetPwdActivity;
import com.apps.cyberco2.unfaded.activities.ResetPwdActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityOtpBinding;

public class OtpActivity extends AppCompatActivity {
    ActivityOtpBinding otpBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        otpBinding = DataBindingUtil.setContentView(this, R.layout.activity_otp);
        otpBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(OtpActivity.this, ForgetPwdActivity.class);
                startActivity(backIntent);
            }
        });
        otpBinding.btnVerifiy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newPwdIntent = new Intent(OtpActivity.this, ResetPwdActivity.class);
                startActivity(newPwdIntent);
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
