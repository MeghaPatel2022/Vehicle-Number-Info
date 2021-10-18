package com.bbotdev.vahaninfo.activity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bbotdev.vahaninfo.R;

public class PrivacyPolicyApp extends AppCompatActivity {

    Toolbar toolbar;

    WebView ivWeb;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_app);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Privacy Policy");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setResult(RESULT_OK);
                finish();


            }
        });

        ivWeb = findViewById(R.id.ivWeb);
        ivWeb.setWebViewClient(new MyWebViewClient());
        showWebView();
    }

    private void showWebView() {
        ivWeb.loadUrl(getResources().getString(R.string.privacy_policy));
        ivWeb.requestFocus();
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
