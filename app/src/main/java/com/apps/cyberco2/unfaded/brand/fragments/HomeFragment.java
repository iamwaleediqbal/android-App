package com.apps.cyberco2.unfaded.brand.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.addisonelliott.segmentedbutton.SegmentedButtonGroup;
import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.NotificationActivity;
import com.apps.cyberco2.unfaded.brand.adapter.viewpager.HomePagerAdapter;
import com.apps.cyberco2.unfaded.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    FragmentHomeBinding homeBinding;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        homeBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_home,
            container, false);
        FragmentTransaction orderFragment = getActivity().getSupportFragmentManager().beginTransaction();
// Replace the contents of the container with the new fragment
        orderFragment.replace(R.id.fram, new New_Orders_Fragment());
// or ft.add(R.id.your_placeholder, new FooFragment());
// Complete the changes added above
        orderFragment.commit();
        homeBinding.btnTab.setOnPositionChangedListener(new SegmentedButtonGroup.OnPositionChangedListener() {
            @Override
            public void onPositionChanged(int position) {
                // setTabLayout(homeBinding.viewPager);
                //Toast.makeText(getContext(),position+" Tab Position",Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        FragmentTransaction orderFragment = getActivity().getSupportFragmentManager().beginTransaction();
                        orderFragment.replace(R.id.fram, new New_Orders_Fragment());
                        orderFragment.commit();
                        break;
                    case 1:
                        FragmentTransaction productFragment = getActivity().getSupportFragmentManager().beginTransaction();
                        productFragment.replace(R.id.fram, new My_Products_Fragment());
                        productFragment.commit();
                        break;
                    case 2:
                        FragmentTransaction followerFragment = getActivity().getSupportFragmentManager().beginTransaction();
                        followerFragment.replace(R.id.fram, new Followers_Fragment());
                        followerFragment.commit();
                        break;
                    default:

                }

            }
        });
        homeBinding.imgNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notifyIntent = new Intent(getContext(), NotificationActivity.class);
                startActivity(notifyIntent);
            }
        });
        return homeBinding.getRoot();
    }

    //Set Tab Layout
    public void setTabLayout(ViewPager viewPager) {
        HomePagerAdapter adapter = new HomePagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new New_Orders_Fragment(), "New Orders");
        adapter.addFragment(new My_Products_Fragment(), "Products");
        adapter.addFragment(new Followers_Fragment(), "Followers");
        viewPager.setAdapter(adapter);
    }
}
