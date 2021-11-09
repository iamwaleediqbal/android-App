package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.viewpager.HomePagerAdapter;
import com.apps.cyberco2.unfaded.brand.fragments.Followers_Fragment;
import com.apps.cyberco2.unfaded.brand.fragments.My_Products_Fragment;
import com.apps.cyberco2.unfaded.databinding.ActivityBrandProfileBinding;

public class BrandProfileActivity extends AppCompatActivity {
    ActivityBrandProfileBinding profileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileBinding = DataBindingUtil.setContentView(this, R.layout.activity_brand_profile);
        setTabLayout(profileBinding.viewPager);
        profileBinding.tabs.setupWithViewPager(profileBinding.viewPager);


    }

    //Set Tab Layout
    public void setTabLayout(ViewPager viewPager) {
        HomePagerAdapter adapter = new HomePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new My_Products_Fragment(), "Products");
        adapter.addFragment(new Followers_Fragment(), "Followers");
        viewPager.setAdapter(adapter);
    }
}
