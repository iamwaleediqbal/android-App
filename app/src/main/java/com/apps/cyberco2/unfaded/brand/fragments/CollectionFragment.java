package com.apps.cyberco2.unfaded.brand.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.AddCollectionActivity;
import com.apps.cyberco2.unfaded.brand.activities.CollectionActivity;
import com.apps.cyberco2.unfaded.databinding.FragmentCollectionBinding;


public class CollectionFragment extends Fragment {

    FragmentCollectionBinding collectionBinding;

    public CollectionFragment() {
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
        collectionBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_collection,
            container, false);
        collectionBinding.floatingBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addintent = new Intent(getContext(), AddCollectionActivity.class);
                startActivity(addintent);
            }
        });
        collectionBinding.cvSummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToCollection("Summer Collection");
            }
        });
        collectionBinding.cvWinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToCollection("Winter Collection");
            }
        });
        return collectionBinding.getRoot();
    }

    public void sendToCollection(String collection) {
        Intent intent = new Intent(getContext(), CollectionActivity.class);
        intent.putExtra("collection", collection);
        startActivity(intent);
    }
}
