package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.ActiveOrder;
import com.apps.cyberco2.unfaded.databinding.ActiveOrderItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class ActiveOrderItemAdapter extends RecyclerView.Adapter<ActiveOrderItemAdapter.OrderItemViewHolder> {
    ArrayList<ActiveOrder> dataList;
    Context context;

    public ActiveOrderItemAdapter(ArrayList<ActiveOrder> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public OrderItemViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ActiveOrderItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.active_order_item, parent, false);
        return new OrderItemViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderItemViewHolder holder, int position) {
        holder.itemBinding.imgProduct.setImageResource(dataList.get(position).getImg());
        holder.itemBinding.txtProductName.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class OrderItemViewHolder extends RecyclerView.ViewHolder {
        ActiveOrderItemBinding itemBinding;

        public OrderItemViewHolder(@NonNull @NotNull ActiveOrderItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
