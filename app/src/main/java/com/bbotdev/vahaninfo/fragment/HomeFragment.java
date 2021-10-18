package com.bbotdev.vahaninfo.fragment;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.activity.CityListActivity;
import com.bbotdev.vahaninfo.activity.DrivingLicenceActivity;
import com.bbotdev.vahaninfo.activity.GetChallanDetailActivity;
import com.bbotdev.vahaninfo.activity.OwnerDetailActivity;
import com.bbotdev.vahaninfo.activity.RecentSearchesActivity;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.customclass.PrefValue;
import com.bbotdev.vahaninfo.databinding.FragmentHomeBinding;
import com.bbotdev.vahaninfo.objectdata.DataItem;
import com.bbotdev.vahaninfo.objectdata.OwnerDetailResponse;
import com.facebook.ads.AdView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cz.msebera.android.httpclient.Header;

public class HomeFragment extends Fragment {

    MyClickHandlers myClickHandlers;
    public static String[] tagarray = {"owner_name", "reg_no", "regn_dt", "maker", "vh_class", "fuel_type", "engine_no", "chasi_no", "rto"};

    FragmentHomeBinding homeBinding;

    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;
    Type type = new TypeToken<List<DataItem>>() {
    }.getType();

    AdView mAdView;

    //    AdRequest adRequest;
    ProgressDialog pd;
    ArrayList<String> arrayList;
    private FirebaseAnalytics mFirebaseAnalytics;

    //    private AdView adView;
//    private InterstitialAd interstitialAd;
//    InterstitialAdListener interstitialAdListener;
    private MoPubInterstitial mInterstitial;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        myClickHandlers = new MyClickHandlers(getActivity());
        homeBinding.setOnClick(myClickHandlers);

        AndroidNetworking.initialize(getContext());
        initview();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(getContext());

        SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder(getResources().getString(R.string.ad_unit_id_interstitial))
                .withLogLevel(MoPubLog.LogLevel.DEBUG)
                .withLegitimateInterestAllowed(false)
                .build();

        MoPub.initializeSdk(getContext(), sdkConfiguration, () -> {
            Log.d("Mopub", "SDK initialized");
            if (getActivity() != null) {
                mInterstitial = new MoPubInterstitial(getActivity(), getResources().getString(R.string.ad_unit_id_interstitial));
                mInterstitial.load();
                listener();
            }
        });


//        AudienceNetworkAds.initialize(getContext());
//        interstitialAd = new InterstitialAd(getContext(), getString(R.string.fb_inter_placementID));
//
//
//        // load the ad
//        listner();
//        interstitialAd.loadAd(
//                interstitialAd.buildLoadAdConfig()
//                        .withAdListener(interstitialAdListener)
//                        .build());


        return homeBinding.getRoot();
    }

    private void listener() {

        if (mInterstitial!=null) {
            mInterstitial.setInterstitialAdListener(new MoPubInterstitial.InterstitialAdListener() {
                @Override
                public void onInterstitialLoaded(MoPubInterstitial interstitial) {

                }

                @Override
                public void onInterstitialFailed(MoPubInterstitial interstitial, MoPubErrorCode errorCode) {

                }

                @Override
                public void onInterstitialShown(MoPubInterstitial interstitial) {

                }

                @Override
                public void onInterstitialClicked(MoPubInterstitial interstitial) {

                }

                @Override
                public void onInterstitialDismissed(MoPubInterstitial interstitial) {
                    mInterstitial.load();
                    String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
                    if (homeBinding.etEnterNumber.getText().toString().matches(reg)) {
                        if (isInternetPresent) {
                            SearchNumber();
                        } else {
                            Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }


//        interstitialAdListener = new InterstitialAdListener() {
//            @Override
//            public void onError(Ad ad, AdError adError) {
//
//                Log.e("LLLLL_Err: ",adError.getErrorMessage());
//                // load the ad
//                interstitialAd.loadAd(
//                        interstitialAd.buildLoadAdConfig()
//                                .withAdListener(interstitialAdListener)
//                                .build());
//
//                String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
//                if (etEnterNumber.getText().toString().matches(reg)) {
//                    if (isInternetPresent) {
//                        SearchNumber();
//                    } else {
//                        Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
//                    }
//
//                } else {
//                    Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onAdLoaded(Ad ad) {
//
//            }
//
//            @Override
//            public void onAdClicked(Ad ad) {
//
//            }
//
//            @Override
//            public void onLoggingImpression(Ad ad) {
//
//            }
//
//            @Override
//            public void onInterstitialDisplayed(Ad ad) {
//
//            }
//
//            @Override
//            public void onInterstitialDismissed(Ad ad) {
//
//                // load the ad
//                interstitialAd.loadAd(
//                        interstitialAd.buildLoadAdConfig()
//                                .withAdListener(interstitialAdListener)
//                                .build());
//
//                String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
//                if (etEnterNumber.getText().toString().matches(reg)) {
//                    if (isInternetPresent) {
//                        SearchNumber();
//                    } else {
//                        Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
//                    }
//
//                } else {
//                    Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
//                }
//            }
//        };
    }

    @Override
    public void onDestroy() {
//        if (interstitialAd != null) {
//            interstitialAd.destroy();
//        }
        super.onDestroy();
        if (mInterstitial != null)
            mInterstitial.destroy();
    }

    public void initview() {

        connectionDetector = new ConnectionDetector(getActivity());
        isInternetPresent = connectionDetector.isConnectingToInternet();

        Typeface face = ResourcesCompat.getFont(getContext(), R.font.montserrat_bold);
//        if (isInternetPresent) {
//            adView = new AdView(getContext(), getString(R.string.fb_banner_placementID), AdSize.BANNER_HEIGHT_50);
//            // Find the Ad Container
//            LinearLayout adContainer = (LinearLayout) view.findViewById(R.id.banner_container);
//            // Add the ad view to your activity layout
//            adContainer.addView(adView);
//            // Request an ad
//            adView.loadAd();
//        }

//        adRequest = new AdRequest.Builder().build();
////
//        // Prepare the Interstitial Ad
//        interstitial = new InterstitialAd(getContext());
//        // Insert the Ad Unit ID
//        interstitial.setAdUnitId(getActivity().getResources().getString(R.string.admob_interstitial_id));
//        interstitial.loadAd(adRequest);
//
//        etEnterNumber.setFilters(new InputFilter[]{new InputFilter.AllCaps()});
//        interstitial.loadAd(adRequest);

        readTextCityFile("Delhi", "2");
    }

    public void readTextCityFile(String city, String code) {
        homeBinding.pbFuel.setVisibility(View.VISIBLE);
        isInternetPresent = connectionDetector.isConnectingToInternet();
        if (isInternetPresent) {
            homeBinding.loutMainFuel.setVisibility(View.VISIBLE);
            homeBinding.tvCityname.setText(city);
            getPetrolDiesel(city, code);
        } else {
            Toast.makeText(getActivity(), "Please Connect to your Internet connection", Toast.LENGTH_SHORT).show();
            homeBinding.pbFuel.setVisibility(View.GONE);
            homeBinding.loutMainFuel.setVisibility(View.GONE);
        }


    }

    public void getPetrolDiesel(String cityname, String id) {

        RequestParams params = new RequestParams();
        AsyncHttpClient client = new AsyncHttpClient();
        client.setTimeout(60 * 1000);
        client.addHeader("Connection", "Keep-Alive");
        client.addHeader("Accept-Encoding", "gzip");
        client.addHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36");
        client.addHeader("Host", "www.mypetrolprice.com");

        client.get("https://www.mypetrolprice.com/" + id + "/Fuel-prices-in-" + cityname, params, new getPetrolDieselResponseHandler());


    }

    public void SearchNumber() {
        new LongOperation().execute();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == 1) {
                if (data.getStringExtra("code").equals("0")) {
                    Toast.makeText(getActivity(), "Price not available, Please check nearby city.", Toast.LENGTH_SHORT).show();

                } else {
                    readTextCityFile(data.getStringExtra("city"), data.getStringExtra("code"));
                }
            }
        }
    }

    private void fireAnalytics(String arg0, String arg1, String arg2) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, arg0);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, arg1);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, arg2);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void SearchData(String arg1, String arg2) {
        AndroidNetworking.post("https://rto.vasundharaapps.com/rto_application/api/new_vehicle_info")
                .addBodyParameter("reg1", arg1)
                .addBodyParameter("reg2", arg2)
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        OwnerDetailResponse ownerDetailResponse = new Gson().fromJson(response.toString(), OwnerDetailResponse.class);
                        if (ownerDetailResponse.getData() != null && ownerDetailResponse.getData().size() > 0) {
                            arrayList = new ArrayList<>();
                            ArrayList<DataItem> dataItems = new ArrayList<>();

                            if (!PrefValue.getVehicleInfo(getActivity()).equals("")) {
                                dataItems = new Gson().fromJson(PrefValue.getVehicleInfo(getActivity()), type);
                            } else {
                                dataItems = new ArrayList<>();
                            }

                            DataItem dataItem = ownerDetailResponse.getData().get(0);
                            arrayList.add(dataItem.getOwnerName());
                            arrayList.add(dataItem.getRegNo());
                            arrayList.add(dataItem.getRegnDt());
                            arrayList.add(dataItem.getMaker());
                            arrayList.add(dataItem.getVhClass());
                            arrayList.add(dataItem.getFuelType());
                            arrayList.add(dataItem.getEngineNo());
                            arrayList.add(dataItem.getChasiNo());
                            arrayList.add(dataItem.getRto());

                            arrayList.add(getResources().getString(R.string.Note));
                            arrayList.add("---");
                            if (dataItems.contains(dataItem)) {
                                int pos = dataItems.indexOf(dataItem);
                                dataItems.remove(pos);
                                dataItems.add(pos, dataItem);

                            } else {
                                dataItems.add(dataItem);
                            }
                            PrefValue.setVehicleInfo(getActivity(), new Gson().toJson(dataItems));

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (pd != null && pd.isShowing())
                                        pd.dismiss();
                                }
                            });

                            Intent intent = new Intent(getActivity(), OwnerDetailActivity.class);
                            intent.putStringArrayListExtra("value", arrayList);
                            startActivityForResult(intent, 1);

                        } else {

                            AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                            builder1.setTitle("OOPS!");
                            builder1.setMessage("We could not find details of " + homeBinding.etEnterNumber.getText().toString() + "." + " It may be a temporary issue or your vehicle is new or recently transferred, its " +
                                    "details might not updated by your RTO to their database yet. Please Try again in few days or searching othe vehicle numbers.");
                            builder1.setCancelable(true);

                            builder1.setPositiveButton(
                                    "Contact Us",
                                    (dialog, id) -> {
                                        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                                        intent.setType("text/plain");
                                        intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK");
                                        intent.putExtra(Intent.EXTRA_TEXT, "Vehicle number:" + homeBinding.etEnterNumber.getText().toString());
                                        intent.setData(Uri.parse("mailto:" + getActivity().getResources().getString(R.string.email))); // or just "mailto:" for blank
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

                                        try {
                                            startActivity(intent);
                                        } catch (android.content.ActivityNotFoundException ex) {
                                            Toast.makeText(getActivity(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                                        }

                                        getActivity().runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                if (pd != null && pd.isShowing())
                                                    pd.dismiss();
                                            }
                                        });

                                        dialog.cancel();
                                    });

                            builder1.setNegativeButton(
                                    "Cancel",
                                    (dialog, id) -> dialog.cancel());

                            AlertDialog alert11 = builder1.create();
                            alert11.show();
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.e("LLLL_Error: ", anError.getErrorDetail());
                    }
                });
    }

    private final class LongOperation extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // TODO Auto-generated method stub
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    pd = ProgressDialog.show(getActivity(), "", "Please Wait...", true, false);
                    pd.show();
                }
            });
        }

        @Override
        protected String doInBackground(Void... params) {
            String first = homeBinding.etEnterNumber.getText().toString().substring(0, homeBinding.etEnterNumber.getText().toString().length() - 4);
            String second = homeBinding.etEnterNumber.getText().toString().substring(homeBinding.etEnterNumber.getText().toString().length() - 4);

            SearchData(first, second);

            Log.e("LLLL_Data: ", first + "     Second: " + second);

            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {


        }
    }

    public class getPetrolDieselResponseHandler extends AsyncHttpResponseHandler {

        @Override
        public void onStart() {
            // TODO Auto-generated method stub

            homeBinding.pbFuel.setVisibility(View.VISIBLE);


            super.onStart();
        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub
            homeBinding.pbFuel.setVisibility(View.GONE);
            super.onFinish();

        }

        @Override
        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
            homeBinding.pbFuel.setVisibility(View.GONE);
            String response = new String(responseBody);
            if (response.length() > 0) {
                Log.e("responce", "" + response);
                Document document = Jsoup.parse(response);
                String description = document.select("meta[name=description]").first().attr("content");
                System.out.println("LLLLL_Description : " + description);

                String keywords = document.select("meta[name=keywords]").first().attr("content");
                System.out.println("LLL_Keywords : " + keywords);

                String[] separated = description.split(",");
                String[] subseparated = separated[0].split("₹");
                String[] subseparated1 = separated[1].split("₹");
                String petrol = subseparated[1];
                String diesel = subseparated1[1];
                petrol = petrol.substring(petrol.indexOf(" ") + 1);
                petrol = petrol.substring(0, petrol.indexOf(" "));
                homeBinding.tvPetrol.setText("₹" + " " + petrol);
                Log.e("LLL_petrol", "" + petrol);
                diesel = diesel.substring(diesel.indexOf(" ") + 1);
                diesel = diesel.substring(0, diesel.indexOf(" "));
                homeBinding.tvDiesel.setText("₹" + " " + diesel);
                Log.e("LLL_diesel", "" + diesel);

            } else {
                Toast.makeText(getActivity(), "Price not available, Please check nearby city.", Toast.LENGTH_SHORT).show();
            }


        }

        @Override
        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
            homeBinding.pbFuel.setVisibility(View.GONE);
        }


    }

    public class MyClickHandlers {
        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onTvSearchClicked(View view) {
            if (mInterstitial != null) {
                if (mInterstitial.isReady())
                    mInterstitial.show();
                else {
                    mInterstitial.load();
                    String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
                    if (homeBinding.etEnterNumber.getText().toString().matches(reg)) {
                        if (isInternetPresent) {
                            SearchNumber();
                        } else {
                            Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
                        }

                    } else {
                        Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                mInterstitial.load();
                String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
                if (homeBinding.etEnterNumber.getText().toString().matches(reg)) {
                    if (isInternetPresent) {
                        SearchNumber();
                    } else {
                        Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
                }
            }

//                listner();

//                if(interstitialAd == null || !interstitialAd.isAdLoaded()) {
//                    return;
//                }
//                // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
//                if(interstitialAd.isAdInvalidated()) {
//                    return;
//                }
//                // Show the ad
//                interstitialAd.show();

////                String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
////                if (etEnterNumber.getText().toString().matches(reg)) {
////                    if (isInternetPresent) {
////                        SearchNumber();
////                    } else {
////                        Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
////                    }
////
////                } else {
////                    Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
////                }
////
//                if (!interstitial.isLoaded()) {
//                    interstitial.loadAd(adRequest);
//                }
//                interstitial.show();
//
//
//                interstitial.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//                        String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
//                        if (etEnterNumber.getText().toString().matches(reg)) {
//                            if (isInternetPresent) {
//                                SearchNumber();
//                            } else {
//                                Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
//                            }
//
//                        } else {
//                            Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onAdLoaded() {
//                        super.onAdLoaded();
//                        interstitial.show();
//                    }
//
//                    @Override
//                    public void onAdFailedToLoad(int i) {
//                        super.onAdFailedToLoad(i);
//                        String reg = "^[A-Z]{2}[0-9]{1,2}(?:[A-Z])?(?:[A-Z]*)?[0-9]{4}$";
//                        if (etEnterNumber.getText().toString().matches(reg)) {
//                            if (isInternetPresent) {
//                                SearchNumber();
//                            } else {
//                                Toast.makeText(getActivity(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
//                            }
//
//                        } else {
//                            Toast.makeText(getActivity(), "Please Enter Valid Vehicle Number.", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });

        }

        public void onLLDrivingLicenceClick(View view) {
            Intent intent1 = new Intent(getActivity(), DrivingLicenceActivity.class);
            startActivity(intent1);
        }

        public void onLLCheckChalan(View view) {
            fireAnalytics("HomeFragment", "Challan Detail", "text");

            Intent intent1 = new Intent(getActivity(), GetChallanDetailActivity.class);
            startActivity(intent1);
        }

        public void onLLHistory(View view) {
            fireAnalytics("HomeFragment", "Recent Search", "text");
            Intent intent1 = new Intent(getActivity(), RecentSearchesActivity.class);
            startActivity(intent1);
        }

        public void onChangeCity(View view) {

            fireAnalytics("HomeFragment", "CityList", "text");
            Intent intent1 = new Intent(getActivity(), CityListActivity.class);
            startActivityForResult(intent1, 1);

//                if (interstitial.isLoaded()){
//                    interstitial.show();
//                } else {
//                    interstitial.loadAd(adRequest);
//                    interstitial.show();
////                    Intent intent1 = new Intent(getActivity(), CityListActivity.class);
////                    startActivityForResult(intent1, 1);
//                }
//
//                interstitial.setAdListener(new AdListener() {
//                    @Override
//                    public void onAdClosed() {
//                        super.onAdClosed();
//                        Intent intent1 = new Intent(getActivity(), CityListActivity.class);
//                        startActivityForResult(intent1, 1);
//                    }
//
//                    @Override
//                    public void onAdLoaded() {
//                        super.onAdLoaded();
//                        interstitial.show();
//                    }
//
//                    @Override
//                    public void onAdFailedToLoad(int i) {
//                        super.onAdFailedToLoad(i);
//                        Intent intent1 = new Intent(getActivity(), CityListActivity.class);
//                        startActivityForResult(intent1, 1);
//                    }
//                });

        }
    }

}
