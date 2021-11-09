package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.Review;
import com.apps.cyberco2.unfaded.databinding.ReviewsItemBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder> {
    ArrayList<Review> dataList;
    Context context;

    public ReviewAdapter(ArrayList<Review> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        ReviewsItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.reviews_item, parent, false);
        return new ReviewViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ReviewViewHolder holder, int position) {
        holder.itemBinding.imgPerson.setImageResource(dataList.get(position).getImg());
        holder.itemBinding.txtPersonName.setText(dataList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder {
        ReviewsItemBinding itemBinding;

        public ReviewViewHolder(@NonNull @NotNull ReviewsItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
