package com.bbotdev.vahaninfo.activity;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class FuelPriceActivity extends AppCompatActivity {

    Toolbar toolbar;
    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;
    TableLayout fuelInfo;
    ProgressDialog pd;
    ArrayList<String> arrayList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuel);
        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();
        init();

    }

    public void init() {

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Today's Fuel Price");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);
                finish();


            }
        });

        fuelInfo = findViewById(R.id.fuelInfo);

        if (isInternetPresent) {
            getFuel();
        } else {
            Toast.makeText(getApplicationContext(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
        }
    }

    public void getFuel() {

        RequestParams params = new RequestParams();
        params.put("dates", "2019-04-19");
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60 * 1000);

        client.post("http://smweballapi.biz/SmApps/FPrice", params, new getFuelResponseHandler());


    }

    @Override
    public void onResume() {
        super.onResume();

    }

    public class getFuelResponseHandler extends AsyncHttpResponseHandler {

        @Override
        public void onStart() {
            // TODO Auto-generated method stub

            pd = ProgressDialog.show(FuelPriceActivity.this, "", "Please Wait...", true, false);
            pd.show();


            super.onStart();
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            pd.dismiss();
            super.onFinish();

        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            pd.dismiss();
            String response = new String(responseBody);
            if (response != null && response.length() > 0) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("cities");
                    if (jsonArray != null && jsonArray.length() > 0) {
                        TableRow row1 = (TableRow) LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_row, null);
                        ((TextView) row1.findViewById(R.id.tvCity)).setText("City, State");
                        Typeface boldTypeface = Typeface.defaultFromStyle(Typeface.BOLD);
                        ((TextView) row1.findViewById(R.id.tvCity)).setTypeface(boldTypeface);
                        row1.findViewById(R.id.tvState).setVisibility(View.GONE);
                        ((TextView) row1.findViewById(R.id.tvCity)).setGravity(Gravity.CENTER);
                        ((TextView) row1.findViewById(R.id.tvPetrol)).setText("Petrol");
                        ((TextView) row1.findViewById(R.id.tvPetrol)).setTypeface(boldTypeface);
                        row1.findViewById(R.id.tvpe).setVisibility(View.GONE);
                        ((TextView) row1.findViewById(R.id.tvDisel)).setText("Diesel");
                        ((TextView) row1.findViewById(R.id.tvDisel)).setTypeface(boldTypeface);
                        row1.findViewById(R.id.tvdi).setVisibility(View.GONE);
                        fuelInfo.addView(row1);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                            TableRow row = (TableRow) LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_row, null);
                            ((TextView) row.findViewById(R.id.tvCity)).setText(jsonObject1.getString("city") + ",");
                            ((TextView) row.findViewById(R.id.tvState)).setText(jsonObject1.getString("state"));
                            ((TextView) row.findViewById(R.id.tvPetrol)).setText(jsonObject1.getString("petrol"));
                            ((TextView) row.findViewById(R.id.tvDisel)).setText(jsonObject1.getString("diesel"));
                            fuelInfo.addView(row);
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } else {
                Toast.makeText(getApplicationContext(), "No data available.", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            pd.dismiss();
        }


    }
}
