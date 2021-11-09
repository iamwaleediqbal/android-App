package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.androidbuts.multispinnerfilter.KeyPairBoolData;
import com.androidbuts.multispinnerfilter.MultiSpinnerListener;
import com.androidbuts.multispinnerfilter.MultiSpinnerSearch;
import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.MainActivity;
import com.apps.cyberco2.unfaded.databinding.ActivityAddBrandDetailBinding;

import java.util.ArrayList;
import java.util.List;

public class AddBrandDetail extends AppCompatActivity {
    ActivityAddBrandDetailBinding brandDetailBinding;
    MultiSpinnerSearch multiSelectSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        brandDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_brand_detail);
        multiSelectSpinner = findViewById(R.id.multipleItemSelectionSpinner);
        multiSelectSpinner.setSearchEnabled(false);
        multiSelectSpinner.setSearchHint("Choose Only 3");
        multiSelectSpinner.setEmptyTitle("Not Data Found!");
        multiSelectSpinner.setItems(getList(), new MultiSpinnerListener() {
            @Override
            public void onItemsSelected(List<KeyPairBoolData> selectedItems) {

            }
        });
        multiSelectSpinner.setLimit(3, new MultiSpinnerSearch.LimitExceedListener() {
            @Override
            public void onLimitListener(com.androidbuts.multispinnerfilter.KeyPairBoolData data) {
                Toast.makeText(getApplicationContext(),
                    "Limit exceed ", Toast.LENGTH_LONG).show();
            }
        });
        brandDetailBinding.btnAddBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AddBrandDetail.this, MainActivity.class);
                startActivity(mainIntent);
            }
        });
    }

    public List<KeyPairBoolData> getList() {
        ArrayList<KeyPairBoolData> arrayList = new ArrayList<>();
        arrayList.add(new KeyPairBoolData("Clothes", false));
        arrayList.add(new KeyPairBoolData("Clothes", false));
        arrayList.add(new KeyPairBoolData("Clothes", false));
        arrayList.add(new KeyPairBoolData("Clothes", false));
        arrayList.add(new KeyPairBoolData("Clothes", false));
        arrayList.add(new KeyPairBoolData("Clothes", false));
        return arrayList;
    }
}
