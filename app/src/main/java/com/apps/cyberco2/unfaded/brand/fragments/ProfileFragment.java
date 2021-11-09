package com.apps.cyberco2.unfaded.brand.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.activities.ChangePassword;
import com.apps.cyberco2.unfaded.activities.EditProfile;
import com.apps.cyberco2.unfaded.brand.activities.AddBrandDetail;
import com.apps.cyberco2.unfaded.brand.activities.MyProductActivity;
import com.apps.cyberco2.unfaded.brand.activities.OrderListActivity;
import com.apps.cyberco2.unfaded.brand.activities.SwitchBrandActivity;
import com.apps.cyberco2.unfaded.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding profileBinding;

    public ProfileFragment() {
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
        profileBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_profile,
            container, false);

        profileBinding.layoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(getContext(), EditProfile.class);
                startActivity(profileIntent);
            }
        });
        profileBinding.layoutOrderList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderIntent = new Intent(getContext(), OrderListActivity.class);
                startActivity(orderIntent);
            }
        });
        profileBinding.layoutBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WalletFragment walletFragment = new WalletFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.nav_host_fragment, walletFragment)
                    .setPrimaryNavigationFragment(walletFragment) // equivalent to app:defaultNavHost="true"
                    .commit();
            }
        });
        profileBinding.layoutChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changepwdIntent = new Intent(getContext(), ChangePassword.class);
                startActivity(changepwdIntent);
            }
        });
        profileBinding.layoutBrandProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addBrandIntent = new Intent(getContext(), AddBrandDetail.class);
                startActivity(addBrandIntent);

            }
        });
        profileBinding.layoutSwicthBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchbrandIntent = new Intent(getContext(), SwitchBrandActivity.class);
                startActivity(switchbrandIntent);
            }
        });
        profileBinding.layoutProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent productIntent = new Intent(getContext(), MyProductActivity.class);
                startActivity(productIntent);
            }
        });

        return profileBinding.getRoot();
    }
}
