package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.BrandProfileActivity;
import com.apps.cyberco2.unfaded.brand.model.SwitchBrand;
import com.apps.cyberco2.unfaded.databinding.SwitchbrandItemBinding;

import java.util.ArrayList;

public class SwitchBrandAdapter extends RecyclerView.Adapter<SwitchBrandAdapter.SwitchBrandViewHolder> {
    ArrayList<SwitchBrand> dataList;
    Context context;

    public SwitchBrandAdapter(ArrayList<SwitchBrand> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public SwitchBrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SwitchbrandItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.switchbrand_item,
            parent, false);
        return new SwitchBrandViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull SwitchBrandAdapter.SwitchBrandViewHolder holder, int position) {
        holder.itemBinding.imgBrand.setImageResource(dataList.get(position).getBrand());
        holder.itemBinding.txtBrandName.setText(dataList.get(position).getName());
        holder.itemBinding.imgCheck.setImageResource(dataList.get(position).getCheck());
        holder.itemBinding.imgBrand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BrandProfileActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class SwitchBrandViewHolder extends RecyclerView.ViewHolder {
        SwitchbrandItemBinding itemBinding;

        public SwitchBrandViewHolder(@NonNull SwitchbrandItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
