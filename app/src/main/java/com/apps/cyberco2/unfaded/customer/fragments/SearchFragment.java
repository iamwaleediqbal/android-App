package com.apps.cyberco2.unfaded.customer.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.databinding.FragmentSearchBinding;

public class SearchFragment extends Fragment {


    FragmentSearchBinding searchBinding;

    public SearchFragment() {
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
        searchBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_search,
            container, false);
        return searchBinding.getRoot();
    }
}
