package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.CollectionModel;
import com.apps.cyberco2.unfaded.databinding.CollectionItemBinding;

import java.util.ArrayList;

public class AddProductIntoCollectionAdapter extends RecyclerView.Adapter<AddProductIntoCollectionAdapter.AddItemViewholder> {
    ArrayList<CollectionModel> dataList;
    Context context;

    public AddProductIntoCollectionAdapter(ArrayList<CollectionModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public AddItemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CollectionItemBinding collectionItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.collection_item, parent, false);

        return new AddItemViewholder(collectionItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AddProductIntoCollectionAdapter.AddItemViewholder holder, int position) {
        holder.collectionItemBinding.txtProductName.setText(dataList.get(position).getName());
        holder.collectionItemBinding.imgAddCollection.setImageResource(dataList.get(position).getImage());
        //  holder.collectionItemBinding.txtAddressShop.setText(dataList.get(position).getAddress());
        holder.collectionItemBinding.txtPrice.setText(dataList.get(position).getPrice());
        holder.collectionItemBinding.txtStar.setText(dataList.get(position).getRating());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class AddItemViewholder extends RecyclerView.ViewHolder {
        CollectionItemBinding collectionItemBinding;

        public AddItemViewholder(@NonNull CollectionItemBinding collectionItemBinding) {
            super(collectionItemBinding.getRoot());
            this.collectionItemBinding = collectionItemBinding;
        }
    }
}
