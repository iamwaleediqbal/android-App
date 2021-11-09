package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.NewOrder;
import com.apps.cyberco2.unfaded.databinding.CompletedOrderItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CompleteOrderAdapter extends RecyclerView.Adapter<CompleteOrderAdapter.CompleteViewHolder> {
    ArrayList<NewOrder> dataList;
    Context context;

    public CompleteOrderAdapter(ArrayList<NewOrder> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }


    @NonNull
    @NotNull
    @Override
    public CompleteViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        CompletedOrderItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.completed_order_item, parent, false);
        return new CompleteViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CompleteViewHolder holder, int position) {
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

    public class CompleteViewHolder extends RecyclerView.ViewHolder {
        CompletedOrderItemBinding itemBinding;

        public CompleteViewHolder(@NonNull @NotNull CompletedOrderItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
