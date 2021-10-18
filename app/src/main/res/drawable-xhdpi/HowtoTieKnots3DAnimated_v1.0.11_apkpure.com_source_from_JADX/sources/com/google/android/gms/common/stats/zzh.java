package com.google.android.gms.common.stats;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.stats.zzc.zzb;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlv;
import java.util.List;

public class zzh {
    private static String TAG = "WakeLockTracker";
    private static Integer zzafB;
    private static final ComponentName zzafz = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    private static zzh zzaga = new zzh();
    private static IntentFilter zzagb = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    private static int getLogLevel() {
        try {
            return zzll.zzjk() ? ((Integer) zzb.zzafD.get()).intValue() : zzd.LOG_LEVEL_OFF;
        } catch (SecurityException e) {
            return zzd.LOG_LEVEL_OFF;
        }
    }

    private int zzal(Context context) {
        int i = 1;
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, zzagb);
        boolean z = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0;
        int i2 = (zzlv.zzpW() ? ((PowerManager) context.getSystemService("power")).isInteractive() : ((PowerManager) context.getSystemService("power")).isScreenOn() ? 1 : 0) << 1;
        if (!z) {
            i = 0;
        }
        return i2 | i;
    }

    private float zzam(Context context) {
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return Float.NaN;
        }
        return ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
    }

    private static boolean zzan(Context context) {
        if (zzafB == null) {
            zzafB = Integer.valueOf(getLogLevel());
        }
        return zzafB.intValue() != zzd.LOG_LEVEL_OFF;
    }

    public static zzh zzpL() {
        return zzaga;
    }

    public void zza(Context context, String str, int i, String str2, String str3, int i2, List<String> list) {
        if (zzan(context)) {
            if (TextUtils.isEmpty(str)) {
                Log.e(TAG, "missing wakeLock key. " + str);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                try {
                    context.startService(new Intent().setComponent(zzafz).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", new WakeLockEvent(currentTimeMillis, i, str2, i2, list, str, SystemClock.elapsedRealtime(), zzal(context), str3, context.getPackageName(), zzam(context))));
                } catch (Exception e) {
                    Log.wtf(TAG, e);
                }
            }
        }
    }
}
