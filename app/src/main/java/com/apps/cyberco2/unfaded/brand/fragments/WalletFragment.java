package com.apps.cyberco2.unfaded.brand.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.Withdrawa;
import com.apps.cyberco2.unfaded.databinding.FragmentWalletBinding;


public class WalletFragment extends Fragment {
    FragmentWalletBinding walletBinding;


    public WalletFragment() {
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
        walletBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_wallet,
            container, false);
        walletBinding.cvWithdrawal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Withdrawa.class);
                startActivity(intent);
            }
        });
        return walletBinding.getRoot();
    }
}
