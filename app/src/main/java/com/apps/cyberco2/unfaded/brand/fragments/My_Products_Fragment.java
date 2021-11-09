package com.apps.cyberco2.unfaded.brand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.MyProductAdapter;
import com.apps.cyberco2.unfaded.brand.model.CollectionModel;
import com.apps.cyberco2.unfaded.databinding.FragmentMyProductsBinding;

import java.util.ArrayList;


public class My_Products_Fragment extends Fragment {

    FragmentMyProductsBinding productsBinding;

    public My_Products_Fragment() {
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
        productsBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_my__products_, container, false);
        setadapter();
        return productsBinding.getRoot();
    }

    private void setadapter() {
        productsBinding.rvMyprodcut.setLayoutManager(new LinearLayoutManager(getContext()));
        MyProductAdapter adapter = new MyProductAdapter(initArray(), getContext());
        productsBinding.rvMyprodcut.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private ArrayList<CollectionModel> initArray() {
        ArrayList<CollectionModel> arrayList = new ArrayList<>();
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart));
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart));
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart));
        arrayList.add(new CollectionModel("Armani Jeans", "pegasus 36 Miami", "$124,9",
            "3.5", R.drawable.img_cart));
        return arrayList;
    }
}
