package com.bbotdev.vahaninfo.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.adapter.CityListAdapter;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.databinding.ActivityCityListBinding;
import com.bbotdev.vahaninfo.objectdata.FuelData;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.firebase.analytics.FirebaseAnalytics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CityListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ActivityCityListBinding cityListBinding;

    Toolbar toolbar;

    private FirebaseAnalytics mFirebaseAnalytics;
    ArrayList<FuelData> fuelDataArrayList, filteredDataList;

    LinearLayoutManager linearLayoutManager;
    CityListAdapter cityListAdapter;

    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    AdRequest adRequest;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cityListBinding = DataBindingUtil.setContentView(CityListActivity.this,R.layout.activity_city_list);

        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(CityListActivity.this);
        initUi();
    }

    private void fireAnalyticsAds(String arg1, String arg2) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, arg1);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, arg2);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        mFirebaseAnalytics.setAnalyticsCollectionEnabled(true);
    }

    public void initUi() {

        linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        cityListBinding.listCityDetail.setLayoutManager(linearLayoutManager);

        cityListBinding.searchView.setOnQueryTextListener(this);
        cityListBinding.searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                if (cityListBinding.searchView.getVisibility() == View.VISIBLE) {
                    cityListBinding.tvTitle.setVisibility(View.VISIBLE);
                    cityListBinding.searchView.setVisibility(View.GONE);
                } else {
                    cityListBinding.searchView.setVisibility(View.VISIBLE);
                    cityListBinding.tvTitle.setVisibility(View.GONE);
                }
                return false;
            }
        });

        fuelDataArrayList = new ArrayList<>();
        cityListAdapter = new CityListAdapter(CityListActivity.this, fuelDataArrayList);

        readTextCityFile();
        cityListBinding.imgSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cityListBinding.searchView.getVisibility() == View.VISIBLE) {
                    cityListBinding.tvTitle.setVisibility(View.VISIBLE);
                    cityListBinding.searchView.setVisibility(View.GONE);
                } else {
                    cityListBinding.searchView.setVisibility(View.VISIBLE);
                    cityListBinding.tvTitle.setVisibility(View.GONE);
                }
            }
        });

        cityListBinding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        adRequest = new AdRequest.Builder().build();

        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(CityListActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getResources().getString(R.string.admob_interstitial_id));
        fireAnalyticsAds("admob_interstitial", "Ad Request send");
        interstitial.loadAd(adRequest);

    }

    public void readTextCityFile() {
        String Citylist = ReadFromfile("CityList.txt", getApplicationContext());
        try {
            JSONObject jsonObject = new JSONObject(Citylist);
            Iterator keys = jsonObject.keys();

            while (keys.hasNext()) {
                String statekey = (String) keys.next();
                FuelData fuelDatastate = new FuelData();
                fuelDatastate.setCityname(statekey);
                fuelDatastate.setCitycode("0");
                fuelDatastate.setHeader(true);
                fuelDataArrayList.add(fuelDatastate);
//                    Log.e("key", "" + statekey);
                JSONArray citylist = jsonObject.getJSONArray(statekey);
                if (citylist.length() > 0) {
                    for (int i = 0; i < citylist.length(); i++) {

                        JSONObject jsonObject1 = citylist.getJSONObject(i);
                        FuelData fuelData = new FuelData();
                        fuelData.setCityname(jsonObject1.getString("cityName"));
                        fuelData.setCitycode(jsonObject1.getString("id"));
                        fuelData.setHeader(false);
                        fuelDataArrayList.add(fuelData);
                    }
                }
            }
            cityListBinding.listCityDetail.setAdapter(cityListAdapter);


        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        filteredDataList = (ArrayList<FuelData>) filter(fuelDataArrayList, newText);
        cityListAdapter.setFilter(filteredDataList);
        return true;
    }

    private List<FuelData> filter(List<FuelData> dataList, String newText) {
        newText = newText.toLowerCase();
        String text;
        filteredDataList = new ArrayList<>();
        for (FuelData dataFromDataList : dataList) {
            text = dataFromDataList.getCityname().toLowerCase();

            if (text.contains(newText)) {
                filteredDataList.add(dataFromDataList);
            }
        }

        return filteredDataList;
    }

    @Override
    protected void onStop() {
        if (cityListBinding.searchView != null) {
            cityListBinding.searchView.clearFocus();
        }
        super.onStop();
    }

    @Override
    public void onBackPressed() {
//

//        finish();

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
