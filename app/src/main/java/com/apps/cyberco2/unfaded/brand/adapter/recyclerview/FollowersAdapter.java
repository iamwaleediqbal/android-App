package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.Followers;
import com.apps.cyberco2.unfaded.databinding.FollowersItemBinding;

import java.util.ArrayList;

public class FollowersAdapter extends RecyclerView.Adapter<FollowersAdapter.FollowerViewHolder> {
    ArrayList<Followers> dataList;
    Context context;

    public FollowersAdapter(ArrayList<Followers> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public FollowerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FollowersItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.followers_item, parent, false);
        return new FollowerViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FollowersAdapter.FollowerViewHolder holder, int position) {
        holder.itemBinding.txtAddress.setText(dataList.get(position).getAddress());
        holder.itemBinding.txtName.setText(dataList.get(position).getName());
        holder.itemBinding.imgFollowers.setImageResource(dataList.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class FollowerViewHolder extends RecyclerView.ViewHolder {
        FollowersItemBinding itemBinding;

        public FollowerViewHolder(@NonNull FollowersItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
