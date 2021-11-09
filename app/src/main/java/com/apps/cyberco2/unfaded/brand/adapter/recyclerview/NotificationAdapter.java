package com.apps.cyberco2.unfaded.brand.adapter.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.model.Notification;
import com.apps.cyberco2.unfaded.databinding.NotificationItemBinding;

import java.util.ArrayList;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    ArrayList<Notification> dataList;
    Context context;

    public NotificationAdapter(ArrayList<Notification> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        NotificationItemBinding itemBinding = DataBindingUtil.inflate(LayoutInflater.from(context),
            R.layout.notification_item, parent, false);
        return new NotificationViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.NotificationViewHolder holder, int position) {
        holder.itemBinding.txtNotificationTitle.setText(dataList.get(position).getTitle());
        holder.itemBinding.txtDate.setText(dataList.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        NotificationItemBinding itemBinding;

        public NotificationViewHolder(@NonNull NotificationItemBinding itemView) {
            super(itemView.getRoot());
            this.itemBinding = itemView;
        }
    }
}
