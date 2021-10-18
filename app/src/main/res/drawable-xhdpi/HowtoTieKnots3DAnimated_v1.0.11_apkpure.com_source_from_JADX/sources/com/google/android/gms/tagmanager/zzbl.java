package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

class zzbl extends BroadcastReceiver {
    static final String zzOo = zzbl.class.getName();
    private final zzct zzaQI;

    zzbl(zzct zzct) {
        this.zzaQI = zzct;
    }

    public static void zzaQ(Context context) {
        Intent intent = new Intent("com.google.analytics.RADIO_POWERED");
        intent.addCategory(context.getPackageName());
        intent.putExtra(zzOo, true);
        context.sendBroadcast(intent);
    }

    public void onReceive(Context ctx, Intent intent) {
        String action = intent.getAction();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            Bundle extras = intent.getExtras();
            Boolean bool = Boolean.FALSE;
            if (extras != null) {
                bool = Boolean.valueOf(intent.getExtras().getBoolean("noConnectivity"));
            }
            this.zzaQI.zzat(!bool.booleanValue());
        } else if ("com.google.analytics.RADIO_POWERED".equals(action) && !intent.hasExtra(zzOo)) {
            this.zzaQI.zzhY();
        }
    }

    public void zzaP(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        context.registerReceiver(this, intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.google.analytics.RADIO_POWERED");
        intentFilter2.addCategory(context.getPackageName());
        context.registerReceiver(this, intentFilter2);
    }
}
