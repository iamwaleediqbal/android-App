package com.apps.cyberco2.unfaded.brand.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.FollowersAdapter;
import com.apps.cyberco2.unfaded.brand.model.Followers;
import com.apps.cyberco2.unfaded.databinding.FragmentFollowersBinding;

import java.util.ArrayList;


public class Followers_Fragment extends Fragment {


    FragmentFollowersBinding followersBinding;

    public Followers_Fragment() {
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
        followersBinding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_followers,
            container, false);
        setAdapter();
        return followersBinding.getRoot();
    }

    private void setAdapter() {
        followersBinding.rvFollowes.setLayoutManager(new LinearLayoutManager(getContext()));
        FollowersAdapter adapter = new FollowersAdapter(initArray(), getContext());
        followersBinding.rvFollowes.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private ArrayList<Followers> initArray() {
        ArrayList<Followers> arrayList = new ArrayList<>();
        arrayList.add(new Followers("Angellina key", "New York", R.drawable.follower2));
        arrayList.add(new Followers("Stephen Grey", "New York", R.drawable.follower));
        arrayList.add(new Followers("Angellina key", "New York", R.drawable.follower2));
        arrayList.add(new Followers("Stephen Grey", "New York", R.drawable.follower));
        arrayList.add(new Followers("Angellina key", "New York", R.drawable.follower2));
        arrayList.add(new Followers("Stephen Grey", "New York", R.drawable.follower));
        arrayList.add(new Followers("Angellina key", "New York", R.drawable.follower2));
        arrayList.add(new Followers("Stephen Grey", "New York", R.drawable.follower));
        return arrayList;
    }
}
