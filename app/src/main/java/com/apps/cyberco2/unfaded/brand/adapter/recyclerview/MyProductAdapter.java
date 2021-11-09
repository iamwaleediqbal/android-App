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
import com.apps.cyberco2.unfaded.brand.activities.ProductDetailActivity;
import com.apps.cyberco2.unfaded.brand.model.CollectionModel;
import com.apps.cyberco2.unfaded.databinding.MyProductItemBinding;

import java.util.ArrayList;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.ProductViewHolder> {
    ArrayList<CollectionModel> dataList;
    Context context;

    public MyProductAdapter(ArrayList<CollectionModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyProductItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.my_product_item, parent, false);
        return new ProductViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductAdapter.ProductViewHolder holder, int position) {
        holder.itemBinding.imgAddCollection.setImageResource(dataList.get(position).getImage());
        holder.itemBinding.txtProductName.setText(dataList.get(position).getName());
        // holder.itemBinding.txtAddressShop.setText(dataList.get(position).getAddress());
        holder.itemBinding.txtPrice.setText(dataList.get(position).getPrice());
        holder.itemBinding.txtStar.setText(dataList.get(position).getRating());
        holder.itemBinding.cvProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductDetailActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        MyProductItemBinding itemBinding;

        public ProductViewHolder(@NonNull MyProductItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
