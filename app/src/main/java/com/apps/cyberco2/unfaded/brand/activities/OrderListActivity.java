package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.viewpager.HomePagerAdapter;
import com.apps.cyberco2.unfaded.brand.fragments.ActiveOrderFragment;
import com.apps.cyberco2.unfaded.brand.fragments.CompletedFragment;
import com.apps.cyberco2.unfaded.brand.fragments.New_Orders_Fragment;
import com.apps.cyberco2.unfaded.databinding.ActivityOrderListBinding;

public class OrderListActivity extends AppCompatActivity {
    ActivityOrderListBinding orderListBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orderListBinding = DataBindingUtil.setContentView(this, R.layout.activity_order_list);
        setTabLayout(orderListBinding.viewPager);
        orderListBinding.tabs.setupWithViewPager(orderListBinding.viewPager);
    }

    //Set Tab Layout
    public void setTabLayout(ViewPager viewPager) {
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new New_Orders_Fragment(), "NEW ORDER");
        adapter.addFragment(new ActiveOrderFragment(), "ACTIVE ORDER");
        adapter.addFragment(new CompletedFragment(), "COMPLETED");
        viewPager.setAdapter(adapter);
    }
}
