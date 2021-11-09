package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.ReviewAdapter;
import com.apps.cyberco2.unfaded.brand.model.Review;
import com.apps.cyberco2.unfaded.databinding.ActivityProductDetailBinding;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {
    ActivityProductDetailBinding detailBinding;
    boolean sizelayout = true;
    boolean speclayout = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailBinding = DataBindingUtil.setContentView(this, R.layout.activity_product_detail);
        detailBinding.layoutSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sizelayout) {
                    detailBinding.layoutSizeDetail.setVisibility(View.VISIBLE);
                    sizelayout = false;
                    detailBinding.arrowDrop.setImageResource(R.drawable.ic_drop_up);
                } else {
                    detailBinding.layoutSizeDetail.setVisibility(View.GONE);
                    sizelayout = true;
                    detailBinding.arrowDrop.setImageResource(R.drawable.ic_drop_down);
                }

            }
        });
        detailBinding.layoutSpec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (speclayout) {
                    detailBinding.layoutSpecDetail.setVisibility(View.VISIBLE);
                    speclayout = false;
                    detailBinding.arrowDropSpec.setImageResource(R.drawable.ic_drop_up);
                } else {
                    detailBinding.layoutSpecDetail.setVisibility(View.GONE);
                    speclayout = true;
                    detailBinding.arrowDropSpec.setImageResource(R.drawable.ic_drop_down);
                }
            }
        });
        setAdapter();
    }

    private void setAdapter() {
        detailBinding.rvReview.setLayoutManager(new LinearLayoutManager(this));
        ReviewAdapter adapter = new ReviewAdapter(initArray(), this);
        detailBinding.rvReview.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<Review> initArray() {
        ArrayList<Review> arrayList = new ArrayList<>();
        arrayList.add(new Review(R.drawable.product1, "Emma"));
        arrayList.add(new Review(R.drawable.product2, "Jack"));
        arrayList.add(new Review(R.drawable.product3, "John"));
        arrayList.add(new Review(R.drawable.product4, "Emma"));
        arrayList.add(new Review(R.drawable.product1, "Jack"));
        arrayList.add(new Review(R.drawable.product1, "John"));
        arrayList.add(new Review(R.drawable.product1, "Emma"));
        arrayList.add(new Review(R.drawable.product1, "Jack"));
        return arrayList;
    }


}
