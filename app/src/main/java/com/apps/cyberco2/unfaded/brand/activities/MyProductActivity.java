package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.ProductsAdapter;
import com.apps.cyberco2.unfaded.brand.model.CollectionModel;
import com.apps.cyberco2.unfaded.databinding.ActivityMyProductBinding;

import java.util.ArrayList;

public class MyProductActivity extends AppCompatActivity {
    ActivityMyProductBinding productBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_product);
        setAdapter();
    }

    private void setAdapter() {
        productBinding.rvMyprodcut.setLayoutManager(new LinearLayoutManager(this));
        ProductsAdapter adapter = new ProductsAdapter(initArray(), this);
        productBinding.rvMyprodcut.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<CollectionModel> initArray() {
        ArrayList<CollectionModel> arrayList = new ArrayList<>();
        arrayList.add(new CollectionModel("Armani", "Pegasus 36 Maimi", "$281,3", R.drawable.product1));
        arrayList.add(new CollectionModel("Prada's Bag", "Pegasus 36 Maimi", "$281,3", R.drawable.product2));
        arrayList.add(new CollectionModel("Niki Air Zoom", "Pegasus 36 Maimi", "$281,3", R.drawable.product3));
        arrayList.add(new CollectionModel("Armani", "Pegasus 36 Maimi", "$281,3", R.drawable.product1));
        arrayList.add(new CollectionModel("Prada's Bag", "Pegasus 36 Maimi", "$281,3", R.drawable.product2));
        arrayList.add(new CollectionModel("Niki Air Zoom", "Pegasus 36 Maimi", "$281,3", R.drawable.product3));
        arrayList.add(new CollectionModel("Armani", "Pegasus 36 Maimi", "$281,3", R.drawable.product1));
        arrayList.add(new CollectionModel("Prada's Bag", "Pegasus 36 Maimi", "$281,3", R.drawable.product2));
        arrayList.add(new CollectionModel("Niki Air Zoom", "Pegasus 36 Maimi", "$281,3", R.drawable.product3));
        return arrayList;
    }
}
