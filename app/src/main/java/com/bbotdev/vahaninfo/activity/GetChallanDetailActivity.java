package com.bbotdev.vahaninfo.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;

import com.bbotdev.vahaninfo.R;
import com.bbotdev.vahaninfo.customclass.ConnectionDetector;
import com.bbotdev.vahaninfo.databinding.ActivityGetChallanBinding;

public class GetChallanDetailActivity extends AppCompatActivity {

    ActivityGetChallanBinding challanBinding;

    Boolean isInternetPresent = false;
    ConnectionDetector connectionDetector;

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        challanBinding = DataBindingUtil.setContentView(GetChallanDetailActivity.this,R.layout.activity_get_challan);
        initUi();
    }

    public void initUi() {

        connectionDetector = new ConnectionDetector(getApplicationContext());
        isInternetPresent = connectionDetector.isConnectingToInternet();

        Typeface face = ResourcesCompat.getFont(GetChallanDetailActivity.this, R.font.montserrat_medium);
        challanBinding.etRcNo.setTypeface(face);

        challanBinding.ivWeb.requestFocus();
        challanBinding.ivWeb.getSettings().setLightTouchEnabled(true);
        challanBinding.ivWeb.getSettings().setJavaScriptEnabled(true);
        challanBinding.ivWeb.getSettings().setGeolocationEnabled(true);
        challanBinding.ivWeb.setSoundEffectsEnabled(true);
        challanBinding.ivWeb.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        challanBinding.ivWeb.getSettings().setUseWideViewPort(true);
        challanBinding.ivWeb.loadUrl(getResources().getString(R.string.Echallan));
        challanBinding.ivWeb.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        if (challanBinding.etRcNo != null) {
            hideKeyboardFrom(getApplicationContext(), challanBinding.etRcNo);
        }
        super.onBackPressed();
    }


    public class MyClickHandlers {
        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onTvSearch(View view) {

            if (challanBinding.etRcNo.getText().length() == 0) {
                Toast.makeText(getApplicationContext(), "Please Enter Valid RC Number.", Toast.LENGTH_SHORT).show();
            } else {
                if (isInternetPresent) {
//                        SearchNumber();
                } else {
                    Toast.makeText(getApplicationContext(), "Please connect to your mobile data!", Toast.LENGTH_SHORT).show();
                }
            }
        }

        public void onBackBtnClicked(View view) {
            onBackPressed();
        }
    }
}
