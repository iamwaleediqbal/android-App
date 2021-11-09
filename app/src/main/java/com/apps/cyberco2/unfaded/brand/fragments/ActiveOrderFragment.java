package com.apps.cyberco2.unfaded.brand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.ActiveOrderAdapter;
import com.apps.cyberco2.unfaded.brand.model.ActiveOrder;
import com.apps.cyberco2.unfaded.databinding.FragmentActiveOrderBinding;

import java.util.ArrayList;


public class ActiveOrderFragment extends Fragment {
    FragmentActiveOrderBinding orderBinding;

    public ActiveOrderFragment() {
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
        orderBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_active_order,
            container, false);
        setAdapter();
        return orderBinding.getRoot();
    }

    private void setAdapter() {
        orderBinding.rvActiveorder.setLayoutManager(new LinearLayoutManager(getContext()));
        ActiveOrderAdapter adapter = new ActiveOrderAdapter(initArray(), getContext());
        orderBinding.rvActiveorder.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<ActiveOrder> initArray() {
        ArrayList<ActiveOrder> arrayList = new ArrayList<>();
        arrayList.add(new ActiveOrder("Emma", R.drawable.img_person));
        arrayList.add(new ActiveOrder("Emma", R.drawable.img_person));
        arrayList.add(new ActiveOrder("Emma", R.drawable.img_person));
        arrayList.add(new ActiveOrder("Emma", R.drawable.img_person));
        return arrayList;
    }

}
