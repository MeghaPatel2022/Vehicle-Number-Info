package com.bbotdev.vahaninfo.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.customclass.ClcikEventCallBack;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.customclass.Constant;
import com.bbotdev.vahaninfo.customclass.Utils;
import com.bbotdev.vahaninfo.databinding.ActivityMainBinding;
import com.bbotdev.vahaninfo.fragment.HomeFragment;
import com.bbotdev.vahaninfo.listadapter.NavListAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mopub.common.MoPub;
import com.mopub.common.SdkConfiguration;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;

import static com.mopub.mobileads.MoPubView.MoPubAdSize.HEIGHT_50;

public class MainActivity extends AppCompatActivity implements ClcikEventCallBack {

    ActivityMainBinding mainBinding;

    public static int REQUEST_PERMISSION = 1;
    Fragment newContent;
    ActionBarDrawerToggle toggle;

    LinearLayoutManager linearLayoutManager;
    NavListAdapter navListAdapter;
    String[] Title = {"Search Vehicle", "More Apps", "Share App", "Rate Us", "Feedback", "Privacy Policy"};
    int[] icon = {R.drawable.iv_search_vehicle, R.drawable.iv_more_app, R.drawable.iv_share, R.drawable.iv_rate, R.drawable.iv_feedback, R.drawable.iv_privacy};
    FrameLayout adBar;
    Handler second;
    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    private FirebaseAnalytics mFirebaseAnalytics;

    private static final int RC_APP_UPDATE = 101;
    private AppUpdateManager mAppUpdateManager;

    InstallStateUpdatedListener installStateUpdatedListener = new
            InstallStateUpdatedListener() {
                @Override
                public void onStateUpdate(InstallState state) {
                    if (state.installStatus() == InstallStatus.DOWNLOADED) {
                        //CHECK THIS if AppUpdateType.FLEXIBLE, otherwise you can skip
                        popupSnackbarForCompleteUpdate();
                    } else if (state.installStatus() == InstallStatus.INSTALLED) {
                        if (mAppUpdateManager != null) {
                            mAppUpdateManager.unregisterListener(installStateUpdatedListener);
                        }

                    } else {
                        Log.i("LLL_Update_App: ", "InstallStateUpdatedListener: state: " + state.installStatus());
                    }
                }
            };


    @Override
    protected void onStart() {
        super.onStart();

        mAppUpdateManager = AppUpdateManagerFactory.create(MainActivity.this);

        mAppUpdateManager.registerListener(installStateUpdatedListener);

        mAppUpdateManager = AppUpdateManagerFactory.create(MainActivity.this);

        mAppUpdateManager.registerListener(installStateUpdatedListener);

        mAppUpdateManager.getAppUpdateInfo().addOnSuccessListener(appUpdateInfo -> {

            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE /*AppUpdateType.IMMEDIATE*/)) {

                try {
                    mAppUpdateManager.startUpdateFlowForResult(
                            appUpdateInfo, AppUpdateType.FLEXIBLE /*AppUpdateType.IMMEDIATE*/, MainActivity.this, RC_APP_UPDATE);
                    Log.e("LLL_Update_App: ", "Update available");
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                    Log.e("LLL_Update_App: ", e.getMessage());
                }

            } else if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                //CHECK THIS if AppUpdateType.FLEXIBLE, otherwise you can skip
                popupSnackbarForCompleteUpdate();
            } else {
                Log.e("LLL_Update_App: ", "checkForAppUpdateAvailability: something else");
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAppUpdateManager != null) {
            mAppUpdateManager.unregisterListener(installStateUpdatedListener);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mAppUpdateManager != null) {
            mAppUpdateManager.unregisterListener(installStateUpdatedListener);
        }
    }

    private void popupSnackbarForCompleteUpdate() {

        Snackbar snackbar =
                Snackbar.make(
                        findViewById(R.id.drawer_layout),
                        "New app is ready!",
                        Snackbar.LENGTH_INDEFINITE);

        snackbar.setAction("Install", view -> {
            if (mAppUpdateManager != null) {
                mAppUpdateManager.completeUpdate();
            }
        });


        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
        snackbar.show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(MainActivity.this,R.layout.activity_main);

        permission_fn();
        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();
        initview();

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

    public void initview() {

        newContent = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, newContent, "home").commit();

        isInternetPresent = connectionDetector.isConnectingToInternet();
//        if (isInternetPresent) {
//
//            adContainer = (FrameLayout) findViewById(R.id.adContainer);
////            adView = new AdView(MainActivity.this);
////            adView.setAdUnitId(getString(R.string.banner_ad));
////            LoadAdaptiveBanner(MainActivity.this, adView);
////            adContainer.addView(adView);
//
//        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_APP_UPDATE) {
            if (resultCode != RESULT_OK) {
                Log.e("LLL_Update_App: ", "onActivityResult: app download failed");
            }
        }
    }

    @Override
    public void onBackPressed() {

        if (Utils.getFromUserDefaults(getApplicationContext(), Constant.PARAM_VALID_RATING).equals("")) {
            DisplayRating();
        } else {
            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

//    public void LoadAdaptiveBanner(Activity context, final AdView adView) {
//        AdRequest adRequest = new AdRequest.Builder().build();
//
//
//        AdSize adSize = getAdSize(context);
//        // Step 4 - Set the adaptive ad size on the ad view.
//        adView.setAdSize(adSize);
//
//        adView.loadAd(adRequest);
//
//        adView.setVisibility(View.GONE);
//        adView.setAdListener(new AdListener() {
//            @Override
//            public void onAdOpened() {
//                super.onAdOpened();
//            }
//
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                adView.setVisibility(View.VISIBLE);
//            }
//        });
//
//    }
//
//    private AdSize getAdSize(Activity context) {
//        // Step 2 - Determine the screen width (less decorations) to use for the ad width.
//        Display display = context.getWindowManager().getDefaultDisplay();
//        DisplayMetrics outMetrics = new DisplayMetrics();
//        display.getMetrics(outMetrics);
//
//        float widthPixels = outMetrics.widthPixels;
//        float density = outMetrics.density;
//
//        int adWidth = (int) (widthPixels / density);
//
//        // Step 3 - Get adaptive ad size and return for setting on the ad view.
//        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, adWidth);
//    }

    private void requestStoragePermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION) &&
                ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            new android.app.AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("Permission is needed to access files from your device...")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION);
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    }).create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSION);
        }
    }

    private void permission_fn() {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) &&
                    ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION)) {

            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_PERMISSION);
            }
        } else {
            requestStoragePermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION) {

            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mainBinding.bannerMopubview.loadAd();
                SdkConfiguration sdkConfiguration = new SdkConfiguration.Builder(getResources().getString(R.string.ad_unit_id_banner))
                        .withLogLevel(MoPubLog.LogLevel.DEBUG)
                        .withLegitimateInterestAllowed(false)
                        .build();

                MoPub.initializeSdk(this, sdkConfiguration, new SdkInitializationListener() {
                    @Override
                    public void onInitializationFinished() {
                        Log.d("Mopub", "SDK initialized");
                    }
                });

                final LinearLayout.LayoutParams layoutParams =
                        (LinearLayout.LayoutParams) mainBinding.bannerMopubview.getLayoutParams();
                mainBinding.bannerMopubview.setLayoutParams(layoutParams);
                mainBinding.bannerMopubview.setAdUnitId(getResources().getString(R.string.ad_unit_id_banner)); // Enter your Ad Unit ID from www.mopub.com
                mainBinding.bannerMopubview.setAdSize(HEIGHT_50);
                mainBinding.bannerMopubview.loadAd();
                mainBinding.bannerMopubview.setBannerAdListener(new MoPubView.BannerAdListener() {
                    @Override
                    public void onBannerLoaded(@NonNull MoPubView banner) {

                    }

                    @Override
                    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {

                    }

                    @Override
                    public void onBannerClicked(MoPubView banner) {

                    }

                    @Override
                    public void onBannerExpanded(MoPubView banner) {

                    }

                    @Override
                    public void onBannerCollapsed(MoPubView banner) {

                    }
                });
            } else {
                requestStoragePermission();
            }
        }

    }

    @Override
    public void onItemClick(int pos) {
        switch (pos) {
            case 0:
                break;
            case 1:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("https://play.google.com/store/apps/developer?id=" + getResources().getString(R.string.publisher)));
                startActivity(intent1);
                break;
            case 2:
                shareApp();
                break;
            case 3:
                rateApp();
                break;
            case 4:
                Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "FEEDBACK");
                intent.setData(Uri.parse("mailto:" + getResources().getString(R.string.email))); // or just "mailto:" for blank
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.

                try {
                    startActivity(intent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
                break;
            case 5:
                Intent intent2 = new Intent(MainActivity.this, PrivacyPolicyApp.class);
                startActivity(intent2);
                break;

        }
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        }
    }

    private void shareApp() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        String url = "https://play.google.com/store/apps/details?id="
                + getApplicationContext().getPackageName() + "";

        // Add data to the intent, the receiving app will decide
        // what to do with it.
        share.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name));
        share.putExtra(Intent.EXTRA_TEXT, url);

        startActivity(Intent.createChooser(share, "Share AppLink!"));
    }

    public void rateApp() {

        String url = "https://play.google.com/store/apps/details?id="
                + getApplicationContext().getPackageName() + "";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }


    public void DisplayRating() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.lout_custom_rating, null);
        dialogBuilder.setView(dialogView);

        TextView tvTitle = dialogView.findViewById(R.id.tvTitle);
        TextView tvDesc = dialogView.findViewById(R.id.tvDesc);
        TextView tvRateus = dialogView.findViewById(R.id.tvRateus);
        ImageView ivCancel = dialogView.findViewById(R.id.ivCancel);

        tvTitle.setText("Like using " + getResources().getString(R.string.app_name) + " ?");
        tvDesc.setText("If you like our app, please rate us 5 star. Thanks!");
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();

        tvRateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Rate();
                Utils.saveToUserDefaults(getApplicationContext(), Constant.PARAM_VALID_RATING, "1");
                alertDialog.dismiss();

            }
        });

        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                setResult(RESULT_OK);
                finish();
            }
        });


    }


    public void Rate() {

        String url = "https://play.google.com/store/apps/details?id="
                + getPackageName() + "";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    private void fireAnalytics(String arg1, String arg2) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "MainActivity");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, arg1);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, arg2);
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    private void fireDetailAnalytics(String arg0, String arg1) {
        Bundle params = new Bundle();
        params.putString(arg0, arg1);
        mFirebaseAnalytics.logEvent("select_image", params);
    }

}
