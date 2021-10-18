package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.tagmanager.zzbg;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class zzqz {
    private boolean mClosed;
    private String zzaPw;
    private final ScheduledExecutorService zzaRr;
    private ScheduledFuture<?> zzaRt;

    public zzqz() {
        this(Executors.newSingleThreadScheduledExecutor());
    }

    public zzqz(String str) {
        this(Executors.newSingleThreadScheduledExecutor());
        this.zzaPw = str;
    }

    zzqz(ScheduledExecutorService scheduledExecutorService) {
        this.zzaRt = null;
        this.zzaPw = null;
        this.zzaRr = scheduledExecutorService;
        this.mClosed = false;
    }

    public void zza(Context context, zzqn zzqn, long j, zzqx zzqx) {
        synchronized (this) {
            zzbg.m29v("ResourceLoaderScheduler: Loading new resource.");
            if (this.zzaRt == null) {
                this.zzaRt = this.zzaRr.schedule(this.zzaPw != null ? new zzqy(context, zzqn, zzqx, this.zzaPw) : new zzqy(context, zzqn, zzqx), j, TimeUnit.MILLISECONDS);
            }
        }
    }
}
