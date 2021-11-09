package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.databinding.ActivitySubcriptionBinding;

public class SubcriptionActivity extends AppCompatActivity {
    ActivitySubcriptionBinding subscriptionBinding;
    int isGold, isPremium, isSilvir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        subscriptionBinding = DataBindingUtil.setContentView(this, R.layout.activity_subcription);
        isGold = 1;
        isPremium = 2;
        isSilvir = 3;
        subscriptionBinding.btnSubscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubcriptionActivity.this, CardDetail.class);
                startActivity(intent);

            }
        });

        subscriptionBinding.cvGold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSubscription(isGold);
            }
        });
        subscriptionBinding.cvPrimium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSubscription(isPremium);
            }
        });
        subscriptionBinding.cvSilver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectSubscription(isSilvir);
            }
        });
    }

    public void selectSubscription(int isSelected) {
        switch (isSelected) {
            case 1:
                subscriptionBinding.imgSelectGold.setVisibility(View.VISIBLE);
                subscriptionBinding.imgSelectPremium.setVisibility(View.GONE);
                subscriptionBinding.imgSelectSilver.setVisibility(View.GONE);
                break;
            case 2:
                subscriptionBinding.imgSelectGold.setVisibility(View.GONE);
                subscriptionBinding.imgSelectPremium.setVisibility(View.VISIBLE);
                subscriptionBinding.imgSelectSilver.setVisibility(View.GONE);
                break;
            case 3:
                subscriptionBinding.imgSelectGold.setVisibility(View.GONE);
                subscriptionBinding.imgSelectPremium.setVisibility(View.GONE);
                subscriptionBinding.imgSelectSilver.setVisibility(View.VISIBLE);
                break;
            default:
        }

    }
}
