package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.OrderDetailActivity;
import com.apps.cyberco2.unfaded.brand.model.ActiveOrder;
import com.apps.cyberco2.unfaded.databinding.ActiveOrderMainItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ActiveOrderAdapter extends RecyclerView.Adapter<ActiveOrderAdapter.OrderViewHolder> {
    ArrayList<ActiveOrder> dataList;
    Context context;

    public ActiveOrderAdapter(ArrayList<ActiveOrder> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ActiveOrderMainItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.active_order_main_item, parent, false);
        return new OrderViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OrderViewHolder holder, int position) {
        holder.itemBinding.imdPerson.setImageResource(dataList.get(position).getImg());
        holder.itemBinding.txtName.setText(dataList.get(position).getName());
        holder.itemBinding.rvOrder.setLayoutManager(new LinearLayoutManager(context));
        ActiveOrderItemAdapter adapter = new ActiveOrderItemAdapter(initArray(), context);
        holder.itemBinding.rvOrder.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        holder.itemBinding.btnOrderDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, OrderDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public ArrayList<ActiveOrder> initArray() {
        ArrayList<ActiveOrder> arrayList = new ArrayList<>();
        arrayList.add(new ActiveOrder("Nikis's Shoes", R.drawable.product3));
        arrayList.add(new ActiveOrder("Nikis's Shoes", R.drawable.order3));
        arrayList.add(new ActiveOrder("Nikis's Shoes", R.drawable.order3));
        return arrayList;
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder {
        ActiveOrderMainItemBinding itemBinding;

        public OrderViewHolder(@NonNull @NotNull ActiveOrderMainItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
