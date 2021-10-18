package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzhq;

@zzgk
public abstract class zzd extends zzhq implements com.google.android.gms.ads.internal.request.zzc.zza {
    private AdResponseParcel zzCG;
    private final com.google.android.gms.ads.internal.request.zzc.zza zzDt;
    private final Object zzpc = new Object();
    private final AdRequestInfoParcel zzyd;

    @zzgk
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza zza) {
            super(adRequestInfoParcel, zza);
            this.mContext = context;
        }

        public void zzfx() {
        }

        public zzj zzfy() {
            return zzgm.zza(this.mContext, new zzbr((String) zzby.zztW.get()), zzgl.zzfG());
        }
    }

    @zzgk
    public static class zzb extends zzd implements ConnectionCallbacks, OnConnectionFailedListener {
        private Context mContext;
        private final com.google.android.gms.ads.internal.request.zzc.zza zzDt;
        protected zze zzDu;
        private boolean zzDv;
        private final Object zzpc = new Object();
        private AdRequestInfoParcel zzyd;

        public zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza zza) {
            Looper mainLooper;
            super(adRequestInfoParcel, zza);
            this.mContext = context;
            this.zzyd = adRequestInfoParcel;
            this.zzDt = zza;
            if (((Boolean) zzby.zzuv.get()).booleanValue()) {
                this.zzDv = true;
                mainLooper = zzp.zzbI().zzgB();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.zzDu = new zze(context, mainLooper, this, this, adRequestInfoParcel.zzqb.zzIB);
            connect();
        }

        /* access modifiers changed from: protected */
        public void connect() {
            this.zzDu.zzox();
        }

        public void onConnected(Bundle connectionHint) {
            zzgn();
        }

        public void onConnectionFailed(ConnectionResult result) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Cannot connect to remote service, fallback to local instance.");
            zzfz().zzgn();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzp.zzbx().zzb(this.mContext, this.zzyd.zzqb.zzIz, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int cause) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Disconnected from remote ad request service.");
        }

        public void zzfx() {
            synchronized (this.zzpc) {
                if (this.zzDu.isConnected() || this.zzDu.isConnecting()) {
                    this.zzDu.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzDv) {
                    zzp.zzbI().zzgC();
                    this.zzDv = false;
                }
            }
        }

        public zzj zzfy() {
            zzj zzj;
            synchronized (this.zzpc) {
                try {
                    zzj = this.zzDu.zzfC();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzj = null;
                }
            }
            return zzj;
        }

        /* access modifiers changed from: 0000 */
        public zzhq zzfz() {
            return new zza(this.mContext, this.zzyd, this.zzDt);
        }
    }

    public zzd(AdRequestInfoParcel adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzc.zza zza2) {
        this.zzyd = adRequestInfoParcel;
        this.zzDt = zza2;
    }

    public final void onStop() {
        zzfx();
    }

    /* access modifiers changed from: 0000 */
    public boolean zza(zzj zzj, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzj.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service.", e);
            zzp.zzbA().zzc((Throwable) e, true);
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzp.zzbA().zzc((Throwable) e2, true);
        } catch (SecurityException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzp.zzbA().zzc((Throwable) e3, true);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not fetch ad response from ad request service due to an Exception.", th);
            zzp.zzbA().zzc(th, true);
        }
        this.zzDt.zzb(new AdResponseParcel(0));
        return false;
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzpc) {
            this.zzCG = adResponseParcel;
            this.zzpc.notify();
        }
    }

    public void zzdG() {
        try {
            zzj zzfy = zzfy();
            if (zzfy == null) {
                this.zzDt.zzb(new AdResponseParcel(0));
            } else if (zza(zzfy, this.zzyd)) {
                zzi(zzp.zzbB().elapsedRealtime());
            }
        } finally {
            zzfx();
        }
    }

    /* access modifiers changed from: protected */
    public boolean zze(long j) {
        long elapsedRealtime = 60000 - (zzp.zzbB().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpc.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    public abstract void zzfx();

    public abstract zzj zzfy();

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzi(long r6) {
        /*
            r5 = this;
            java.lang.Object r1 = r5.zzpc
            monitor-enter(r1)
        L_0x0003:
            com.google.android.gms.ads.internal.request.AdResponseParcel r0 = r5.zzCG     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0010
            com.google.android.gms.ads.internal.request.zzc$zza r0 = r5.zzDt     // Catch:{ all -> 0x0023 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = r5.zzCG     // Catch:{ all -> 0x0023 }
            r0.zzb(r2)     // Catch:{ all -> 0x0023 }
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
        L_0x000f:
            return
        L_0x0010:
            boolean r0 = r5.zze(r6)     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0003
            com.google.android.gms.ads.internal.request.AdResponseParcel r0 = r5.zzCG     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.request.zzc$zza r0 = r5.zzDt     // Catch:{ all -> 0x0023 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = r5.zzCG     // Catch:{ all -> 0x0023 }
            r0.zzb(r2)     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
            goto L_0x000f
        L_0x0023:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0023 }
            throw r0
        L_0x0026:
            com.google.android.gms.ads.internal.request.zzc$zza r0 = r5.zzDt     // Catch:{ all -> 0x0023 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0023 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            r0.zzb(r2)     // Catch:{ all -> 0x0023 }
            goto L_0x0021
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.request.zzd.zzi(long):void");
    }
}
