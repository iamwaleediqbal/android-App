package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.databinding.ActivityAddCollectionBinding;

public class AddCollectionActivity extends AppCompatActivity {
    ActivityAddCollectionBinding collectionBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        collectionBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_collection);
        collectionBinding.btnAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCollectionActivity.this, AddProductInCollectionActivity.class);
                startActivity(intent);
            }
        });

    }

}
