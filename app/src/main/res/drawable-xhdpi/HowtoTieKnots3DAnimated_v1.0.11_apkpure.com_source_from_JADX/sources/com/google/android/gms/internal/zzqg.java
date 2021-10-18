package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.TagManager;
import java.util.HashSet;
import java.util.Set;

public class zzqg {
    private static zzqg zzaTp;
    /* access modifiers changed from: private */
    public Context mContext;
    private boolean mStarted;
    private final Set<zza> zzaTq = new HashSet();
    private TagManager zzaTr = null;
    /* access modifiers changed from: private */
    public zzqf zzpo;

    public interface zza {
        void zzbo();
    }

    zzqg(Context context, TagManager tagManager) {
        this.mContext = context;
        this.zzaTr = tagManager;
    }

    public static zzqg zzaR(Context context) {
        zzx.zzv(context);
        if (zzaTp == null) {
            synchronized (zzqg.class) {
                if (zzaTp == null) {
                    zzaTp = new zzqg(context, TagManager.getInstance(context.getApplicationContext()));
                }
            }
        }
        return zzaTp;
    }

    /* access modifiers changed from: private */
    public void zzgK() {
        synchronized (this) {
            for (zza zzbo : this.zzaTq) {
                zzbo.zzbo();
            }
        }
    }

    public void start() throws IllegalStateException {
        synchronized (this) {
            if (this.mStarted) {
                throw new IllegalStateException("Method start() has already been called");
            } else if (this.zzpo == null) {
                throw new IllegalStateException("No settings configured");
            } else {
                this.mStarted = true;
                this.zzaTr.zzc(this.zzpo.zzBj(), -1, "admob").setResultCallback(new ResultCallback<ContainerHolder>() {
                    /* renamed from: zza */
                    public void onResult(ContainerHolder containerHolder) {
                        zzqg.this.zzpo = new zzqe(zzqg.this.mContext, containerHolder.getStatus().isSuccess() ? containerHolder.getContainer() : null, zzqg.this.zzBn()).zzBh();
                        zzqg.this.zzgK();
                    }
                });
            }
        }
    }

    public zzqf zzBn() {
        zzqf zzqf;
        synchronized (this) {
            zzqf = this.zzpo;
        }
        return zzqf;
    }

    public void zza(zzqf zzqf) {
        synchronized (this) {
            if (this.mStarted) {
                throw new IllegalStateException("Settings can't be changed after TagManager has been started");
            }
            this.zzpo = zzqf;
        }
    }

    public void zza(zza zza2) {
        synchronized (this) {
            this.zzaTq.add(zza2);
        }
    }
}
