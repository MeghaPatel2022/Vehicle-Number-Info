package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

public class zzpi implements PanoramaApi {

    private static abstract class zza extends zzc<PanoramaResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaW */
        public PanoramaResult zzb(Status status) {
            return new zzpk(status, null);
        }
    }

    private static final class zzb extends com.google.android.gms.internal.zzpg.zza {
        private final com.google.android.gms.common.api.zzc.zzb<PanoramaResult> zzQz;

        public zzb(com.google.android.gms.common.api.zzc.zzb<PanoramaResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(int i, Bundle bundle, int i2, Intent intent) {
            this.zzQz.zzn(new zzpk(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null), intent));
        }
    }

    private static abstract class zzc<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzpj> {
        protected zzc(GoogleApiClient googleApiClient) {
            super(Panorama.zzQf, googleApiClient);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(Context context, zzph zzph) throws RemoteException;

        /* access modifiers changed from: protected */
        public final void zza(zzpj zzpj) throws RemoteException {
            zza(zzpj.getContext(), (zzph) zzpj.zzoA());
        }
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, Uri uri) {
        context.revokeUriPermission(uri, 1);
    }

    /* access modifiers changed from: private */
    public static void zza(final Context context, zzph zzph, final zzpg zzpg, final Uri uri, Bundle bundle) throws RemoteException {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        try {
            zzph.zza(new com.google.android.gms.internal.zzpg.zza() {
                public void zza(int i, Bundle bundle, int i2, Intent intent) throws RemoteException {
                    zzpi.zza(context, uri);
                    zzpg.zza(i, bundle, i2, intent);
                }
            }, uri, bundle, true);
        } catch (RemoteException e) {
            zza(context, uri);
            throw e;
        } catch (RuntimeException e2) {
            zza(context, uri);
            throw e2;
        }
    }

    public PendingResult<PanoramaResult> loadPanoramaInfo(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzph zzph) throws RemoteException {
                zzph.zza(new zzb(this), uri, null, false);
            }
        });
    }

    public PendingResult<PanoramaResult> loadPanoramaInfoAndGrantAccess(GoogleApiClient client, final Uri uri) {
        return client.zza(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzph zzph) throws RemoteException {
                zzpi.zza(context, zzph, new zzb(this), uri, null);
            }
        });
    }
}
