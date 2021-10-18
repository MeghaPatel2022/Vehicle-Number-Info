package com.bbotdev.vahaninfo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.adapter.DrivingDetailAdapter;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.databinding.ActivityOwnerDetailBinding;
import com.bbotdev.vahaninfo.objectdata.LicenceData;

import java.util.ArrayList;

public class DrivingDetailActivity extends AppCompatActivity {

    ActivityOwnerDetailBinding ownerDetailBinding;
    LinearLayoutManager linearLayoutManager;
    DrivingDetailAdapter drivingDetailAdapter;
    ArrayList<LicenceData> licenceDataArrayList;
    Toolbar toolbar;
    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownerDetailBinding = DataBindingUtil.setContentView(DrivingDetailActivity.this,R.layout.activity_owner_detail);
        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();
        init();
    }

    public void init() {

        Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        licenceDataArrayList = (ArrayList<LicenceData>) args.getSerializable("array");


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Licence Detail");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        drivingDetailAdapter = new DrivingDetailAdapter(DrivingDetailActivity.this, licenceDataArrayList);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        ownerDetailBinding.listDetail.setLayoutManager(linearLayoutManager);
        ownerDetailBinding.listDetail.setAdapter(drivingDetailAdapter);

    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
