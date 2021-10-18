package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzx;

public final class PendingResults {

    private static final class zza<R extends Result> extends zzb<R> {
        private final R zzaaB;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzaaB = r;
        }

        /* access modifiers changed from: protected */
        public R zzb(Status status) {
            if (status.getStatusCode() == this.zzaaB.getStatus().getStatusCode()) {
                return this.zzaaB;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zza<R> {
        public zzb() {
            super(Looper.getMainLooper());
        }

        /* access modifiers changed from: protected */
        public R zzb(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzo zzo = new zzo(Looper.getMainLooper());
        zzo.cancel();
        return zzo;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R result) {
        zzx.zzb(result, (Object) "Result must not be null");
        zzx.zzb(result.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(result);
        zza2.cancel();
        return zza2;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R result) {
        zzx.zzb(result, (Object) "Result must not be null");
        zzb zzb2 = new zzb();
        zzb2.zza(result);
        return zzb2;
    }

    public static PendingResult<Status> immediatePendingResult(Status result) {
        zzx.zzb(result, (Object) "Result must not be null");
        zzo zzo = new zzo(Looper.getMainLooper());
        zzo.zza(result);
        return zzo;
    }
}
