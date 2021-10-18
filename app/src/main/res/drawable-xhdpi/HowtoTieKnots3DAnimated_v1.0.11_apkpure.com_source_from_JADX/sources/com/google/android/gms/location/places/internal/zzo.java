package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class zzo {
    private static final String TAG = zzo.class.getSimpleName();
    private static final long zzaEN = TimeUnit.SECONDS.toMillis(1);
    private static zzo zzaEO;
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Handler mHandler;
    private final Runnable zzaEP;
    /* access modifiers changed from: private */
    public ArrayList<String> zzaEQ;
    /* access modifiers changed from: private */
    public ArrayList<String> zzaER;
    /* access modifiers changed from: private */
    public final Object zzpc;

    private class zza implements Runnable {
        private zza() {
        }

        public void run() {
            synchronized (zzo.this.zzpc) {
                Intent intent = new Intent("com.google.android.location.places.METHOD_CALL");
                intent.setPackage("com.google.android.gms");
                intent.putStringArrayListExtra("PLACE_IDS", zzo.this.zzaEQ);
                intent.putStringArrayListExtra("METHOD_NAMES", zzo.this.zzaER);
                intent.putExtra("PACKAGE_NAME", zzo.this.mContext.getPackageName());
                intent.putExtra("CLIENT_VERSION", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                zzo.this.mContext.sendBroadcast(intent);
                zzo.this.zzaEQ = null;
                zzo.this.zzaER = null;
            }
        }
    }

    private zzo(Context context) {
        this((Context) zzx.zzv(context), new Handler(Looper.getMainLooper()));
    }

    zzo(Context context, Handler handler) {
        this.zzaEP = new zza();
        this.zzpc = new Object();
        this.zzaEQ = null;
        this.zzaER = null;
        this.mContext = context;
        this.mHandler = handler;
    }

    public static synchronized zzo zzaE(Context context) {
        zzo zzo;
        synchronized (zzo.class) {
            zzx.zzv(context);
            if (VERSION.SDK_INT < 14) {
                zzo = null;
            } else {
                if (zzaEO == null) {
                    zzaEO = new zzo(context.getApplicationContext());
                }
                zzo = zzaEO;
            }
        }
        return zzo;
    }

    public void zzC(String str, String str2) {
        synchronized (this.zzpc) {
            if (this.zzaEQ == null) {
                this.zzaEQ = new ArrayList<>();
                this.zzaER = new ArrayList<>();
                this.mHandler.postDelayed(this.zzaEP, zzaEN);
            }
            this.zzaEQ.add(str);
            this.zzaER.add(str2);
            if (this.zzaEQ.size() >= 10000) {
                if (Log.isLoggable(TAG, 5)) {
                    Log.w(TAG, "Event buffer full, flushing");
                }
                this.zzaEP.run();
                this.mHandler.removeCallbacks(this.zzaEP);
            }
        }
    }
}
