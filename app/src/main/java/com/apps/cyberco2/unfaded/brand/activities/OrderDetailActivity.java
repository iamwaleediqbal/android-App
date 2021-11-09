package com.apps.cyberco2.unfaded.brand.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.OrderDetailAdapter;
import com.apps.cyberco2.unfaded.brand.model.Review;
import com.apps.cyberco2.unfaded.databinding.ActivityOrderDetailBinding;

import java.util.ArrayList;

public class OrderDetailActivity extends AppCompatActivity {
    ActivityOrderDetailBinding detailBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = DataBindingUtil.setContentView(this, R.layout.activity_order_detail);
        setAdapter();
        detailBinding.imgBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetailActivity.this, OrderListActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setAdapter() {
        detailBinding.rvOrderItem.setLayoutManager(new LinearLayoutManager(this));
        OrderDetailAdapter adapter = new OrderDetailAdapter(initArray(), this);
        detailBinding.rvOrderItem.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<Review> initArray() {
        ArrayList<Review> arrayList = new ArrayList<>();
        arrayList.add(new Review(R.drawable.product1, "Niki's Shoes"));
        arrayList.add(new Review(R.drawable.product2, "Armani Jeans"));
        arrayList.add(new Review(R.drawable.product1, "Niki's Shoes"));
        return arrayList;
    }
}
