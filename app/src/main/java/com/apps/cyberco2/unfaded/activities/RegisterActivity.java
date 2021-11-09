package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.SubcriptionActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding registerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        registerBinding = DataBindingUtil.setContentView(this, R.layout.activity_register);
        registerBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSubs = new Intent(RegisterActivity.this, SubcriptionActivity.class);
                startActivity(intentSubs);
            }
        });
        registerBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(RegisterActivity.this, LogInActivity.class);
                startActivity(backIntent);
            }
        });
    }
}
