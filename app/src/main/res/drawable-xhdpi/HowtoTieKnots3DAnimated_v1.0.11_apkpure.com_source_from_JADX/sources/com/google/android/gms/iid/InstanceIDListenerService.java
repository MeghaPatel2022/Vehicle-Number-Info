package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String zzaAX = "google.com/iid";
    private static String zzaAY = "CMD";
    private static String zzazM = "gcm.googleapis.com/refresh";
    MessengerCompat zzaAV = new MessengerCompat((Handler) new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            InstanceIDListenerService.this.zza(msg, MessengerCompat.zzc(msg));
        }
    });
    BroadcastReceiver zzaAW = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (Log.isLoggable("InstanceID", 3)) {
                intent.getStringExtra("registration_id");
                Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
            }
            InstanceIDListenerService.this.zzn(intent);
            InstanceIDListenerService.this.stop();
        }
    };
    int zzaAZ;
    int zzaBa;

    static void zza(Context context, zzd zzd) {
        zzd.zzvF();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(zzaAY, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* access modifiers changed from: private */
    public void zza(Message message, int i) {
        zzc.zzaD(this);
        getPackageManager();
        if (i == zzc.zzaBh || i == zzc.zzaBg) {
            zzn((Intent) message.obj);
        } else {
            Log.w("InstanceID", "Message from unexpected caller " + i + " mine=" + zzc.zzaBg + " appid=" + zzc.zzaBh);
        }
    }

    static void zzaC(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(zzaAY, "SYNC");
        context.startService(intent);
    }

    public IBinder onBind(Intent intent) {
        if (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            return null;
        }
        return this.zzaAV.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.zzaAW, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.zzaAW);
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzgz(startId);
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                zzn(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.completeWakefulIntent(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    public void onTokenRefresh() {
    }

    /* access modifiers changed from: 0000 */
    public void stop() {
        synchronized (this) {
            this.zzaAZ--;
            if (this.zzaAZ == 0) {
                stopSelf(this.zzaBa);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Stop " + this.zzaAZ + " " + this.zzaBa);
            }
        }
    }

    public void zzaf(boolean z) {
        onTokenRefresh();
    }

    /* access modifiers changed from: 0000 */
    public void zzgz(int i) {
        synchronized (this) {
            this.zzaAZ++;
            if (i > this.zzaBa) {
                this.zzaBa = i;
            }
        }
    }

    public void zzn(Intent intent) {
        InstanceID zza;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            zza = InstanceID.getInstance(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            zza = InstanceID.zza(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(zzaAY);
        if (intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR) == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Service command " + stringExtra + " " + stringExtra2 + " " + intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                zzd zzvA = zza.zzvA();
                if (stringExtra == null) {
                    stringExtra = "";
                }
                zzvA.zzdt(stringExtra);
                zza.zzvB().zzr(intent);
            } else if (zzazM.equals(intent.getStringExtra("from"))) {
                zza.zzvA().zzdt(stringExtra);
                zzaf(false);
            } else if ("RST".equals(stringExtra2)) {
                zza.zzvz();
                zzaf(true);
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!zza.zzvA().isEmpty()) {
                    zza.zzvA().zzvF();
                    zzaf(true);
                }
            } else if ("SYNC".equals(stringExtra2)) {
                zza.zzvA().zzdt(stringExtra);
                zzaf(false);
            } else if ("PING".equals(stringExtra2)) {
                try {
                    GoogleCloudMessaging.getInstance(this).send(zzaAX, zzc.zzvE(), 0, intent.getExtras());
                } catch (IOException e) {
                    Log.w("InstanceID", "Failed to send ping response");
                }
            }
        } else {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Register result in service " + stringExtra);
            }
            zza.zzvB().zzr(intent);
        }
    }
}
