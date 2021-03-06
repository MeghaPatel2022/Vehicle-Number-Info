package com.google.android.gms.common.api;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.atomic.AtomicReference;

public class zzc {

    public static abstract class zza<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends zza<R> implements zzb<R>, zze<A> {
        private final com.google.android.gms.common.api.Api.zzc<A> zzXW;
        private AtomicReference<zzd> zzYO = new AtomicReference<>();

        protected zza(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(((GoogleApiClient) zzx.zzb(googleApiClient, (Object) "GoogleApiClient must not be null")).getLooper());
            this.zzXW = (com.google.android.gms.common.api.Api.zzc) zzx.zzv(zzc);
        }

        private void zza(RemoteException remoteException) {
            zzx(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        /* access modifiers changed from: protected */
        public abstract void zza(A a) throws RemoteException;

        public void zza(zzd zzd) {
            this.zzYO.set(zzd);
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza(a);
            } catch (DeadObjectException e) {
                zza((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        /* access modifiers changed from: protected */
        public void zzmZ() {
            zzd zzd = (zzd) this.zzYO.getAndSet(null);
            if (zzd != null) {
                zzd.zzc(this);
            }
        }

        public /* synthetic */ void zzn(Object obj) {
            super.zza((Result) obj);
        }

        public final com.google.android.gms.common.api.Api.zzc<A> zznd() {
            return this.zzXW;
        }

        public int zzng() {
            return 0;
        }

        public final void zzx(Status status) {
            zzx.zzb(!status.isSuccess(), (Object) "Failed result must not be success");
            zza(zzb(status));
        }
    }

    public interface zzb<R> {
        void zzn(R r);

        void zzx(Status status);
    }
}
