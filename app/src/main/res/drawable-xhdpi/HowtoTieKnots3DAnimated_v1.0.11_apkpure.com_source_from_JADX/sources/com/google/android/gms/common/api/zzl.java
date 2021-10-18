package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.zzx;

public final class zzl<L> {
    private volatile L mListener;
    private final zza zzaaz;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            boolean z = true;
            if (msg.what != 1) {
                z = false;
            }
            zzx.zzZ(z);
            zzl.this.zzb((zzb) msg.obj);
        }
    }

    public interface zzb<L> {
        void zznh();

        void zzo(L l);
    }

    zzl(Looper looper, L l) {
        this.zzaaz = new zza<>(looper);
        this.mListener = zzx.zzb(l, (Object) "Listener must not be null");
    }

    public void clear() {
        this.mListener = null;
    }

    public void zza(zzb<? super L> zzb2) {
        zzx.zzb(zzb2, (Object) "Notifier must not be null");
        this.zzaaz.sendMessage(this.zzaaz.obtainMessage(1, zzb2));
    }

    /* access modifiers changed from: 0000 */
    public void zzb(zzb<? super L> zzb2) {
        L l = this.mListener;
        if (l == null) {
            zzb2.zznh();
            return;
        }
        try {
            zzb2.zzo(l);
        } catch (RuntimeException e) {
            zzb2.zznh();
            throw e;
        }
    }
}
