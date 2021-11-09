package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.Review;
import com.apps.cyberco2.unfaded.databinding.OrderDetailItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OrderDetailAdapter extends RecyclerView.Adapter<OrderDetailAdapter.DetailViewHolder> {
    ArrayList<Review> dataList;
    Context context;

    public OrderDetailAdapter(ArrayList<Review> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public DetailViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        OrderDetailItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.order_detail_item,
            parent, false);
        return new DetailViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DetailViewHolder holder, int position) {
        holder.itemBinding.imgAddCollection.setImageResource(dataList.get(position).getImg());
        holder.itemBinding.txtProductName.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DetailViewHolder extends RecyclerView.ViewHolder {
        OrderDetailItemBinding itemBinding;

        public DetailViewHolder(@NonNull @NotNull OrderDetailItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
