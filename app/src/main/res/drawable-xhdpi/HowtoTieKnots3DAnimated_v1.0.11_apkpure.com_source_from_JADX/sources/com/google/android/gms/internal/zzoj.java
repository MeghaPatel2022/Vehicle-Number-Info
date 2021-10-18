package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.List;

public class zzoj {
    private static final zza[] zzaIm = new zza[0];
    private static zzoj zzaIn;
    private final Application zzaIo;
    private zzoq zzaIp;
    private final List<zza> zzaIq = new ArrayList();
    private zzot zzaIr;

    public interface zza {
        void zza(zzoq zzoq);

        void zza(zzoq zzoq, Activity activity);
    }

    private zzoj(Application application) {
        zzx.zzv(application);
        this.zzaIo = application;
    }

    public static zzoj zzaJ(Context context) {
        zzoj zzoj;
        zzx.zzv(context);
        Application application = (Application) context.getApplicationContext();
        zzx.zzv(application);
        synchronized (zzoj.class) {
            if (zzaIn == null) {
                zzaIn = new zzoj(application);
            }
            zzoj = zzaIn;
        }
        return zzoj;
    }

    private zza[] zzxz() {
        zza[] zzaArr;
        synchronized (this.zzaIq) {
            zzaArr = this.zzaIq.isEmpty() ? zzaIm : (zza[]) this.zzaIq.toArray(new zza[this.zzaIq.size()]);
        }
        return zzaArr;
    }

    public void zza(zza zza2) {
        zzx.zzv(zza2);
        synchronized (this.zzaIq) {
            this.zzaIq.remove(zza2);
            this.zzaIq.add(zza2);
        }
    }

    public void zzaj(boolean z) {
        if (VERSION.SDK_INT < 14) {
            Log.i("com.google.android.gms.measurement.ScreenViewService", "AutoScreeViewTracking is not supported on API 14 or earlier devices");
        } else if (zzxy() == z) {
        } else {
            if (z) {
                this.zzaIr = new zzot(this);
                this.zzaIo.registerActivityLifecycleCallbacks(this.zzaIr);
                return;
            }
            this.zzaIo.unregisterActivityLifecycleCallbacks(this.zzaIr);
            this.zzaIr = null;
        }
    }

    public void zzb(zzoq zzoq, Activity activity) {
        zzx.zzv(zzoq);
        zza[] zzaArr = null;
        if (zzoq.isMutable()) {
            if (activity instanceof zzoi) {
                ((zzoi) activity).zzb(zzoq);
            }
            if (this.zzaIp != null) {
                zzoq.zzhT(this.zzaIp.zzbp());
                zzoq.zzdU(this.zzaIp.zzxT());
            }
            zza[] zzxz = zzxz();
            for (zza zza2 : zzxz) {
                zza2.zza(zzoq, activity);
            }
            zzoq.zzxX();
            if (!TextUtils.isEmpty(zzoq.zzxT())) {
                zzaArr = zzxz;
            } else {
                return;
            }
        }
        if (this.zzaIp == null || this.zzaIp.zzbp() != zzoq.zzbp()) {
            zzxx();
            this.zzaIp = zzoq;
            if (zzaArr == null) {
                zzaArr = zzxz();
            }
            for (zza zza3 : zzaArr) {
                zza3.zza(zzoq);
            }
            return;
        }
        this.zzaIp = zzoq;
    }

    public zzoq zzxw() {
        return this.zzaIp;
    }

    public void zzxx() {
        this.zzaIp = null;
    }

    public boolean zzxy() {
        return this.zzaIr != null;
    }
}
