package com.bbotdev.vahaninfo.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.adapter.OwnerDetailAdapter;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.databinding.ActivityOwnerDetailBinding;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;

public class OwnerDetailActivity extends AppCompatActivity {

    ActivityOwnerDetailBinding ownerDetailBinding;
    MyClickHandlers myClickHandlers;

    private FirebaseAnalytics mFirebaseAnalytics;

    LinearLayoutManager linearLayoutManager;
    OwnerDetailAdapter ownerDetailAdapter;
    ArrayList<String> value;

    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    AdRequest adRequest;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ownerDetailBinding = DataBindingUtil.setContentView(OwnerDetailActivity.this,R.layout.activity_owner_detail);
        myClickHandlers = new MyClickHandlers(OwnerDetailActivity.this);
        ownerDetailBinding.setOnClick(myClickHandlers);

        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(OwnerDetailActivity.this);

        init();
    }

    private void fireAnalyticsAds(String arg1, String arg2) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, arg1);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, arg2);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
    }

    public void init() {

        value = getIntent().getStringArrayListExtra("value");

        adRequest = new AdRequest.Builder().build();

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(OwnerDetailActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getResources().getString(R.string.admob_interstitial_id));
        fireAnalyticsAds("admob_interstitial", "Ad Request send");
        interstitial.loadAd(adRequest);
        if (!interstitial.isLoaded()) {
            interstitial.loadAd(adRequest);
        }

        ownerDetailAdapter = new OwnerDetailAdapter(OwnerDetailActivity.this, value);
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        ownerDetailBinding.listDetail.setLayoutManager(linearLayoutManager);
        ownerDetailBinding.listDetail.setAdapter(ownerDetailAdapter);

    }

    @Override
    public void onBackPressed() {

        if(!interstitial.isLoaded()) {
            finish();
        } else {
            interstitial.show();
            interstitial.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }

                @Override
                public void onAdLoaded() {
                    super.onAdLoaded();
                    fireAnalyticsAds("admob_interstitial", "loaded");
                    interstitial.show();
                }

                @Override
                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    if (loadAdError.getMessage() != null)
                        fireAnalyticsAds("admob_interstitial_Error", loadAdError.getMessage());
                    Log.e("LLLL_Error: ",loadAdError.getMessage());
                    finish();
                }

                @Override
                public void onAdFailedToLoad(int i) {
                    super.onAdFailedToLoad(i);
                    finish();
                }
            });
        }
    }

    public class MyClickHandlers {
        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onBackBtnClicked(View view) {
            onBackPressed();
        }
    }

}
