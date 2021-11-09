package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.SwitchBrandAdapter;
import com.apps.cyberco2.unfaded.brand.model.SwitchBrand;
import com.apps.cyberco2.unfaded.databinding.ActivitySwitchBrandBinding;

import java.util.ArrayList;

public class SwitchBrandActivity extends AppCompatActivity {
    ActivitySwitchBrandBinding brandBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brandBinding = DataBindingUtil.setContentView(this, R.layout.activity_switch_brand);
        setAdapter();
        brandBinding.btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SwitchBrandActivity.this, AddBrandDetail.class);
                startActivity(intent);
            }
        });
    }

    private void setAdapter() {
        brandBinding.rvBrand.setLayoutManager(new LinearLayoutManager(this));
        SwitchBrandAdapter adapter = new SwitchBrandAdapter(initarray(), this);
        brandBinding.rvBrand.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<SwitchBrand> initarray() {
        ArrayList<SwitchBrand> arrayList = new ArrayList<>();
        arrayList.add(new SwitchBrand("Niki", R.drawable.img_nike, R.drawable.ic_check_mark));
        arrayList.add(new SwitchBrand("Skecher", R.drawable.img_skecher, R.drawable.ic_brand_notify));
        arrayList.add(new SwitchBrand("Soral", R.drawable.img_soral, R.drawable.ic_brand_notify));
        arrayList.add(new SwitchBrand("Calvin Klein", R.drawable.img_calvin, R.drawable.ic_brand_notify));
        return arrayList;
    }

}
