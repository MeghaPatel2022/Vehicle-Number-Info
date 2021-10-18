package com.bbotdev.vahaninfo.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bbotdev.vahaninfo.R;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2000;

    ImageView ivapp_icon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        if (Build.VERSION.SDK_INT >= 26) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        init();
    }

    public void init() {

//        ivapp_icon = findViewById(R.id.ivapp_icon);
//        Animation expandIn = AnimationUtils.loadAnimation(this, R.anim.popin);
//        ivapp_icon.startAnimation(expandIn);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivityForResult(i, 1);
            }
        }, SPLASH_TIME_OUT);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                setResult(RESULT_OK);
                finish();
            }
        }
    }
}
