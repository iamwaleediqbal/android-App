package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.NewOrder;
import com.apps.cyberco2.unfaded.databinding.OrderItemBinding;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {
    ArrayList<NewOrder> dataList;
    Context context;

    public OrderAdapter(ArrayList<NewOrder> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        OrderItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.order_item
            , parent, false);

        return new OrderViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.OrderViewHolder holder, int position) {
        holder.itemBinding.imgBrand.setImageResource(dataList.get(position).getImg());
        holder.itemBinding.txtProductName.setText(dataList.get(position).getName());
        holder.itemBinding.txtAddress.setText(dataList.get(position).getAddress());
        holder.itemBinding.txtOrderId.setText(dataList.get(position).getOrderId());
        holder.itemBinding.txtDate.setText(dataList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        OrderItemBinding itemBinding;

        public OrderViewHolder(@NonNull OrderItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
