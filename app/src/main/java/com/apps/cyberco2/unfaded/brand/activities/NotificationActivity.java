package com.apps.cyberco2.unfaded.brand.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.apps.cyberco2.unfaded.R;
import com.apps.cyberco2.unfaded.brand.adapter.recyclerview.NotificationAdapter;
import com.apps.cyberco2.unfaded.brand.model.Notification;
import com.apps.cyberco2.unfaded.databinding.ActivityNotificationBinding;

import java.util.ArrayList;

public class NotificationActivity extends AppCompatActivity {
    ActivityNotificationBinding notificationBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationBinding = DataBindingUtil.setContentView(this, R.layout.activity_notification);
        setAdapter();
    }

    public void setAdapter() {
        notificationBinding.rvNotification.setLayoutManager(new LinearLayoutManager(this));
        NotificationAdapter adapter = new NotificationAdapter(initArray(), this);
        notificationBinding.rvNotification.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public ArrayList<Notification> initArray() {
        ArrayList<Notification> arrayList = new ArrayList<>();
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        arrayList.add(new Notification("New Notification", "12 Feb 2021/12:43"));
        return arrayList;
    }
}
