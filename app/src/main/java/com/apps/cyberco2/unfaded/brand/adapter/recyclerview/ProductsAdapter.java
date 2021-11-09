package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.activities.EditProductActivity;
import com.apps.cyberco2.unfaded.brand.model.CollectionModel;
import com.apps.cyberco2.unfaded.databinding.ProductItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductViewHolder> {
    ArrayList<CollectionModel> dataList;
    Context context;

    public ProductsAdapter(ArrayList<CollectionModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ProductItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.product_item,
            parent, false);
        return new ProductViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductViewHolder holder, int position) {
        holder.itemBinding.imgAddCollection.setImageResource(dataList.get(position).getImage());
        holder.itemBinding.txtProductName.setText(dataList.get(position).getName());
//holder.itemBinding.txtAddressShop.setText(dataList.get(position).getAddress());
        holder.itemBinding.txtPrice.setText(dataList.get(position).getPrice());
        holder.itemBinding.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditProductActivity.class);
                context.startActivity(intent);
            }
        });
        holder.itemBinding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogbox();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void showDialogbox() {
        View promptsView = LayoutInflater.from(context).inflate(R.layout.dialoge_show, null);
        AlertDialog.Builder builder = new
            android.app.AlertDialog.Builder(context, R.style.customDialog);
        builder.setView(promptsView);
        builder.setCancelable(true);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        alertDialog.getWindow().setLayout(435, 270);
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ProductItemBinding itemBinding;

        public ProductViewHolder(@NonNull @NotNull ProductItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
