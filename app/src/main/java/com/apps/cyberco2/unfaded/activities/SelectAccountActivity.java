package com.apps.cyberco2.unfaded.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.databinding.ActivitySelectAccountBinding;

import io.paperdb.Paper;

import static com.apps.cyberco2.unfaded.utils.Constants.ACCOUNT_TYPE;

public class SelectAccountActivity extends AppCompatActivity {
    ActivitySelectAccountBinding accountBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        accountBinding = DataBindingUtil.setContentView(this, R.layout.activity_select_account);
        Paper.init(this);
        accountBinding.btnBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTOLogIn(1);
            }
        });
        accountBinding.btnCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTOLogIn(2);
            }
        });
    }

    public void moveTOLogIn(int check) {
        Intent loginIntent = new Intent(SelectAccountActivity.this, LogInActivity.class);
        Paper.book().write(ACCOUNT_TYPE, check);
        startActivity(loginIntent);
    }
}
