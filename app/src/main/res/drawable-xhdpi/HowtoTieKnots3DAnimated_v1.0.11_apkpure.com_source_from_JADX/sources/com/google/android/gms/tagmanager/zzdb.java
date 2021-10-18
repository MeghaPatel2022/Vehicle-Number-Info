package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class zzdb extends zzak {

    /* renamed from: ID */
    private static final String f45ID = zzad.TIMER_LISTENER.toString();
    private static final String NAME = zzae.NAME.toString();
    private static final String zzaSA = zzae.UNIQUE_TRIGGER_ID.toString();
    private static final String zzaSy = zzae.INTERVAL.toString();
    private static final String zzaSz = zzae.LIMIT.toString();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public DataLayer zzaOT;
    /* access modifiers changed from: private */
    public boolean zzaSB;
    /* access modifiers changed from: private */
    public boolean zzaSC;
    private final HandlerThread zzaSD;
    /* access modifiers changed from: private */
    public final Set<String> zzaSE = new HashSet();

    private final class zza implements Runnable {
        private final long zzOC = System.currentTimeMillis();
        private final long zzaBW;
        private final String zzaSF;
        private final String zzaSG;
        private final long zzaSH;
        private long zzaSI;

        zza(String str, String str2, long j, long j2) {
            this.zzaSF = str;
            this.zzaSG = str2;
            this.zzaBW = j;
            this.zzaSH = j2;
        }

        public void run() {
            if (this.zzaSH <= 0 || this.zzaSI < this.zzaSH) {
                this.zzaSI++;
                if (zzcu()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    zzdb.this.zzaOT.push(DataLayer.mapOf("event", this.zzaSF, "gtm.timerInterval", String.valueOf(this.zzaBW), "gtm.timerLimit", String.valueOf(this.zzaSH), "gtm.timerStartTime", String.valueOf(this.zzOC), "gtm.timerCurrentTime", String.valueOf(currentTimeMillis), "gtm.timerElapsedTime", String.valueOf(currentTimeMillis - this.zzOC), "gtm.timerEventNumber", String.valueOf(this.zzaSI), "gtm.triggers", this.zzaSG));
                }
                zzdb.this.mHandler.postDelayed(this, this.zzaBW);
            } else if (!"0".equals(this.zzaSG)) {
                zzdb.this.zzaSE.remove(this.zzaSG);
            }
        }

        /* access modifiers changed from: protected */
        public boolean zzcu() {
            if (zzdb.this.zzaSC) {
                return zzdb.this.zzaSB;
            }
            KeyguardManager keyguardManager = (KeyguardManager) zzdb.this.mContext.getSystemService("keyguard");
            PowerManager powerManager = (PowerManager) zzdb.this.mContext.getSystemService("power");
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) zzdb.this.mContext.getSystemService("activity")).getRunningAppProcesses()) {
                if (Process.myPid() == runningAppProcessInfo.pid && runningAppProcessInfo.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && powerManager.isScreenOn()) {
                    return true;
                }
            }
            return false;
        }
    }

    public zzdb(Context context, DataLayer dataLayer) {
        super(f45ID, zzaSy, NAME);
        this.mContext = context;
        this.zzaOT = dataLayer;
        this.zzaSD = new HandlerThread("Google GTM SDK Timer", 10);
        this.zzaSD.start();
        this.mHandler = new Handler(this.zzaSD.getLooper());
    }

    public com.google.android.gms.internal.zzag.zza zzG(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        long j;
        long j2;
        String zzg = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(NAME));
        String zzg2 = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzaSA));
        String zzg3 = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzaSy));
        String zzg4 = zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzaSz));
        try {
            j = Long.parseLong(zzg3);
        } catch (NumberFormatException e) {
            j = 0;
        }
        try {
            j2 = Long.parseLong(zzg4);
        } catch (NumberFormatException e2) {
            j2 = 0;
        }
        if (j > 0 && !TextUtils.isEmpty(zzg)) {
            if (zzg2 == null || zzg2.isEmpty()) {
                zzg2 = "0";
            }
            if (!this.zzaSE.contains(zzg2)) {
                if (!"0".equals(zzg2)) {
                    this.zzaSE.add(zzg2);
                }
                this.mHandler.postDelayed(new zza(zzg, zzg2, j, j2), j);
            }
        }
        return zzdf.zzBg();
    }

    public boolean zzzx() {
        return false;
    }
}
