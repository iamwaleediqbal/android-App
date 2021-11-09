package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.Withdraw;
import com.apps.cyberco2.unfaded.databinding.WithdrawItemBinding;

import java.util.ArrayList;

public class WithdrawAdapter extends RecyclerView.Adapter<WithdrawAdapter.WithdrawViewHolder> {
    ArrayList<Withdraw> dataList;
    Context context;

    public WithdrawAdapter(ArrayList<Withdraw> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public WithdrawViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        WithdrawItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.withdraw_item, parent, false);
        return new WithdrawViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull WithdrawAdapter.WithdrawViewHolder holder, int position) {
        holder.itemBinding.txtAmountno.setText(dataList.get(position).getAmount());
        holder.itemBinding.txtTransactionId.setText(dataList.get(position).getId());
        holder.itemBinding.txtDate.setText(dataList.get(position).getDate());
        if (dataList.get(position).getStatus()) {
            holder.itemBinding.txtStatus.setText("Accepted");
            holder.itemBinding.txtStatus.setTextColor(context.getResources().getColor(R.color.txtaccept));
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class WithdrawViewHolder extends RecyclerView.ViewHolder {
        WithdrawItemBinding itemBinding;

        public WithdrawViewHolder(@NonNull WithdrawItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
