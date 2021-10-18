package com.mobilicos.howtotieknotspro;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.mobilicos.howtotieknots.C1295R;

public class RateDialog implements OnClickListener {
    final int USES_UNTIL_PROMPT = 4;
    AlertDialog alertDialog;
    ImageButton androidButton;
    String androidUri = "market://details?id=com.mobilicos.howtotieknotspro";
    Builder builder;
    Context context;
    ImageButton facebookButton;
    String facebookUri = "http://www.facebook.com/pages/How-to-make-Origami/292303934141379";
    boolean isShowIfChecked = false;
    String negativeButtonTitle = "No, Thanks";
    String positiveButtonTitle = "Remind me later";
    final SharedPreferences settings;
    String title = "Rate How to Tie Knots Pro";
    ImageButton twitterButton;
    String twitterUri = "http://twitter.com/#!/HowtomakeOriga1";

    public RateDialog(Context context2) {
        this.context = context2;
        View view = LayoutInflater.from(context2).inflate(C1295R.layout.rate_dialog, null);
        this.builder = new Builder(context2);
        this.builder.setView(view);
        this.androidButton = (ImageButton) view.findViewById(C1295R.C1297id.rate_text);
        this.facebookButton = (ImageButton) view.findViewById(C1295R.C1297id.android_logo);
        this.twitterButton = (ImageButton) view.findViewById(C1295R.C1297id.facebook_logo);
        this.androidButton.setOnClickListener(this);
        this.facebookButton.setOnClickListener(this);
        this.twitterButton.setOnClickListener(this);
        this.settings = context2.getSharedPreferences("Settings", 0);
    }

    public void setTitle(String title2) {
        this.title = title2;
    }

    public void setNegativeButton(String title2) {
        this.negativeButtonTitle = title2;
    }

    public void setPositiveButton(String title2) {
        this.positiveButtonTitle = title2;
    }

    public void showIfChecked() {
        int currentVersionCode;
        Editor editor = this.settings.edit();
        try {
            currentVersionCode = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            currentVersionCode = 1;
        }
        if (currentVersionCode != this.settings.getInt("lastRateVersion", 0)) {
            editor.putInt("lastRateVersion", currentVersionCode);
            editor.putBoolean("rateThisVersion", false);
            editor.putBoolean("reliseThisVersion", false);
            editor.putInt("usesCount", 0);
            editor.commit();
        }
        editor.putInt("usesCount", this.settings.getInt("usesCount", 0) + 1);
        editor.commit();
        if (!this.settings.getBoolean("rateThisVersion", false) && !this.settings.getBoolean("reliseThisVersion", false) && this.settings.getInt("usesCount", 0) >= 4) {
            editor.putInt("usesCount", 0);
            editor.commit();
            this.isShowIfChecked = true;
            show();
        }
    }

    public void show() {
        this.builder.setTitle(this.title);
        this.builder.setPositiveButton(this.negativeButtonTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                if (RateDialog.this.isShowIfChecked) {
                    Editor editor = RateDialog.this.settings.edit();
                    editor.putBoolean("reliseThisVersion", true);
                    editor.commit();
                }
                dialog.cancel();
            }
        });
        this.builder.setNegativeButton(this.positiveButtonTitle, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        this.alertDialog = this.builder.create();
        this.alertDialog.show();
    }

    public void onClick(View v) {
        Uri uri = Uri.parse(this.facebookUri);
        if (v == this.androidButton) {
            uri = Uri.parse(this.androidUri);
        } else if (v == this.facebookButton) {
            uri = Uri.parse(this.facebookUri);
        } else if (v == this.twitterButton) {
            uri = Uri.parse(this.twitterUri);
        }
        this.alertDialog.cancel();
        if (this.isShowIfChecked) {
            Editor editor = this.settings.edit();
            editor.putBoolean("rateThisVersion", true);
            editor.commit();
        }
        this.context.startActivity(new Intent("android.intent.action.VIEW", uri));
    }
}
