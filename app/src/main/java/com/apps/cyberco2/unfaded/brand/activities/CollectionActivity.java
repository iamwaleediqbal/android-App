package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.AddProductIntoCollectionAdapter;
import com.apps.cyberco2.unfaded.brand.model.CollectionModel;
import com.apps.cyberco2.unfaded.databinding.ActivityCollectionBinding;

import java.util.ArrayList;

public class CollectionActivity extends AppCompatActivity {
    ActivityCollectionBinding collectionBinding;
    String collectionName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        collectionBinding = DataBindingUtil.setContentView(this, R.layout.activity_collection);
        Intent intent = getIntent();
        collectionName = intent.getStringExtra("collection");
        collectionBinding.txtTitle.setText(collectionName.toUpperCase());
        collectionBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        setAdapter();

    }

    public void setAdapter() {
        collectionBinding.rvCollection.setLayoutManager(new LinearLayoutManager(this));
        AddProductIntoCollectionAdapter adapter = new AddProductIntoCollectionAdapter(initArray(), this);
        collectionBinding.rvCollection.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<CollectionModel> initArray() {
        ArrayList<CollectionModel> arrayList = new ArrayList<>();
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart, false));
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart, true));
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart, false));
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart, true));
        return arrayList;
    }
}
