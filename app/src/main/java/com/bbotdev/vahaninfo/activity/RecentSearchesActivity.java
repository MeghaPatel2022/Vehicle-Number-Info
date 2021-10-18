package com.bbotdev.vahaninfo.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.adapter.RecentSearchAdapter;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.customclass.PrefValue;
import com.bbotdev.vahaninfo.databinding.ActivityOwnerDetailBinding;
import com.bbotdev.vahaninfo.objectdata.DataItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RecentSearchesActivity extends AppCompatActivity {

    ActivityOwnerDetailBinding ownerDetailBinding;

    LinearLayoutManager linearLayoutManager;
    RecentSearchAdapter recentSearchAdapter;
    Type type = new TypeToken<List<DataItem>>() {
    }.getType();
    ArrayList<DataItem> vehicleDatas;

    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownerDetailBinding = DataBindingUtil.setContentView(RecentSearchesActivity.this,R.layout.activity_owner_detail);
        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();
        init();
    }

    public void init() {

        ownerDetailBinding.imgBack.setOnClickListener(v -> finish());

        vehicleDatas = new ArrayList<>();
        if (!PrefValue.getVehicleInfo(getApplicationContext()).equals("")) {
            vehicleDatas = new Gson().fromJson(PrefValue.getVehicleInfo(getApplicationContext()), type);
            if (vehicleDatas.size() > 0) {
                ownerDetailBinding.tvNoData.setVisibility(View.GONE);
                ownerDetailBinding.listDetail.setVisibility(View.VISIBLE);
                recentSearchAdapter = new RecentSearchAdapter(RecentSearchesActivity.this, vehicleDatas);
                linearLayoutManager = new LinearLayoutManager(getApplicationContext());
                ownerDetailBinding.listDetail.setLayoutManager(linearLayoutManager);
                ownerDetailBinding.listDetail.setAdapter(recentSearchAdapter);
            } else {
                ownerDetailBinding.tvNoData.setVisibility(View.VISIBLE);
                ownerDetailBinding.listDetail.setVisibility(View.GONE);
            }

        } else {
            vehicleDatas = new ArrayList<>();
            ownerDetailBinding.tvNoData.setVisibility(View.VISIBLE);
            ownerDetailBinding.listDetail.setVisibility(View.GONE);
        }


    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
