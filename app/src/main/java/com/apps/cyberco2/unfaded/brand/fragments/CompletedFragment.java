package com.apps.cyberco2.unfaded.brand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.CompleteOrderAdapter;
import com.apps.cyberco2.unfaded.brand.model.NewOrder;
import com.apps.cyberco2.unfaded.databinding.FragmentCompletedBinding;

import java.util.ArrayList;


public class CompletedFragment extends Fragment {

    FragmentCompletedBinding completedBinding;

    public CompletedFragment() {
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
        completedBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_completed,
            container, false);
        setAdapter();
        return completedBinding.getRoot();
    }

    private void setAdapter() {
        completedBinding.rvCompleted.setLayoutManager(new LinearLayoutManager(getContext()));
        CompleteOrderAdapter adapter = new CompleteOrderAdapter(initArray(), getContext());
        completedBinding.rvCompleted.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<NewOrder> initArray() {
        ArrayList<NewOrder> arrayList = new ArrayList<>();
        arrayList.add(new NewOrder("Niki's Shoe", "13 jun 2021", "Order #2453", "New York", R.drawable.order3));
        arrayList.add(new NewOrder("Armani's Jacket", "13 jun 2021", "Order #2453", "New York", R.drawable.order2));
        arrayList.add(new NewOrder("Prada's bag", "13 jun 2021", "Order #2453", "New York", R.drawable.order1));
        arrayList.add(new NewOrder("Niki's Shoe", "13 jun 2021", "Order #2453", "New York", R.drawable.order3));
        arrayList.add(new NewOrder("Armani's Jacket", "13 jun 2021", "Order #2453", "New York", R.drawable.order2));
        arrayList.add(new NewOrder("Prada's bag", "13 jun 2021", "Order #2453", "New York", R.drawable.order1));
        arrayList.add(new NewOrder("Niki's Shoe", "13 jun 2021", "Order #2453", "New York", R.drawable.order3));
        arrayList.add(new NewOrder("Armani's Jacket", "13 jun 2021", "Order #2453", "New York", R.drawable.order2));
        arrayList.add(new NewOrder("Prada's bag", "13 jun 2021", "Order #2453", "New York", R.drawable.order1));
        return arrayList;
    }
}
