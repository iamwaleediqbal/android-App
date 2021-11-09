package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.WithdrawAdapter;
import com.apps.cyberco2.unfaded.brand.model.Withdraw;
import com.apps.cyberco2.unfaded.databinding.ActivityWithdrawaBinding;

import java.util.ArrayList;

public class Withdrawa extends AppCompatActivity {
    ActivityWithdrawaBinding withdrawaBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        withdrawaBinding = DataBindingUtil.setContentView(this, R.layout.activity_withdrawa);
        setAdapter();
    }

    private void setAdapter() {
        withdrawaBinding.rvTransation.setLayoutManager(new LinearLayoutManager(this));
        WithdrawAdapter adapter = new WithdrawAdapter(initArray(), this);
        withdrawaBinding.rvTransation.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<Withdraw> initArray() {
        ArrayList<Withdraw> arrayList = new ArrayList<>();
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", false));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", true));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", true));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", false));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", true));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", false));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", true));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", false));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", true));
        arrayList.add(new Withdraw("#223", "$23.56", "12 jun 2021/ 03:34", false));
        return arrayList;
    }
}
