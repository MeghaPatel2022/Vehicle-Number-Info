package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzcm implements zze {
    private boolean mClosed;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final String zzaOS;
    private String zzaPp;
    private zzbf<zzj> zzaRo;
    private zzs zzaRp;
    private final ScheduledExecutorService zzaRr;
    private final zza zzaRs;
    private ScheduledFuture<?> zzaRt;

    interface zza {
        zzcl zza(zzs zzs);
    }

    interface zzb {
        ScheduledExecutorService zzAC();
    }

    public zzcm(Context context, String str, zzs zzs) {
        this(context, str, zzs, null, null);
    }

    zzcm(Context context, String str, zzs zzs, zzb zzb2, zza zza2) {
        this.zzaRp = zzs;
        this.mContext = context;
        this.zzaOS = str;
        if (zzb2 == null) {
            zzb2 = new zzb() {
                public ScheduledExecutorService zzAC() {
                    return Executors.newSingleThreadScheduledExecutor();
                }
            };
        }
        this.zzaRr = zzb2.zzAC();
        if (zza2 == null) {
            this.zzaRs = new zza() {
                public zzcl zza(zzs zzs) {
                    return new zzcl(zzcm.this.mContext, zzcm.this.zzaOS, zzs);
                }
            };
        } else {
            this.zzaRs = zza2;
        }
    }

    private synchronized void zzAB() {
        if (this.mClosed) {
            throw new IllegalStateException("called method after closed");
        }
    }

    private zzcl zzeR(String str) {
        zzcl zza2 = this.zzaRs.zza(this.zzaRp);
        zza2.zza(this.zzaRo);
        zza2.zzeB(this.zzaPp);
        zza2.zzeQ(str);
        return zza2;
    }

    public synchronized void release() {
        zzAB();
        if (this.zzaRt != null) {
            this.zzaRt.cancel(false);
        }
        this.zzaRr.shutdown();
        this.mClosed = true;
    }

    public synchronized void zza(zzbf<zzj> zzbf) {
        zzAB();
        this.zzaRo = zzbf;
    }

    public synchronized void zzeB(String str) {
        zzAB();
        this.zzaPp = str;
    }

    public synchronized void zzf(long j, String str) {
        zzbg.m29v("loadAfterDelay: containerId=" + this.zzaOS + " delay=" + j);
        zzAB();
        if (this.zzaRo == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.zzaRt != null) {
            this.zzaRt.cancel(false);
        }
        this.zzaRt = this.zzaRr.schedule(zzeR(str), j, TimeUnit.MILLISECONDS);
    }
}
