package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.databinding.ActivityCardDetailBinding;

public class CardDetail extends AppCompatActivity {
    ActivityCardDetailBinding cardDetailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cardDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_card_detail);
        cardDetailBinding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CardDetail.this, AddBrandDetail.class);
                startActivity(intent);
            }
        });
    }
}
