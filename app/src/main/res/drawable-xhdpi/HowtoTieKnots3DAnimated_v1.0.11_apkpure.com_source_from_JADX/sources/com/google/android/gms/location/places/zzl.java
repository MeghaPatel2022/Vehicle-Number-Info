package com.google.android.gms.location.places;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx;

public class zzl extends com.google.android.gms.location.places.internal.zzh.zza {
    private static final String TAG = zzl.class.getSimpleName();
    private final Context mContext;
    private final zzd zzaDP;
    private final zza zzaDQ;
    private final zze zzaDR;
    private final zzf zzaDS;
    private final zzc zzaDT;

    public static abstract class zza<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaP */
        public AutocompletePredictionBuffer zzb(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.zzbp(status.getStatusCode()));
        }
    }

    public static abstract class zzb<R extends Result, A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.common.api.zzc.zza<R, A> {
        public zzb(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }
    }

    public static abstract class zzc<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceBuffer, A> {
        public zzc(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaQ */
        public PlaceBuffer zzb(Status status) {
            return new PlaceBuffer(DataHolder.zzbp(status.getStatusCode()), null);
        }
    }

    public static abstract class zzd<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaR */
        public PlaceLikelihoodBuffer zzb(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.zzbp(status.getStatusCode()), 100, null);
        }
    }

    public static abstract class zze<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<com.google.android.gms.location.places.personalized.zzd, A> {
        /* access modifiers changed from: protected */
        /* renamed from: zzaS */
        public com.google.android.gms.location.places.personalized.zzd zzb(Status status) {
            return com.google.android.gms.location.places.personalized.zzd.zzaT(status);
        }
    }

    public static abstract class zzf<A extends com.google.android.gms.common.api.Api.zzb> extends zzb<Status, A> {
        public zzf(com.google.android.gms.common.api.Api.zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public zzl(zza zza2) {
        this.zzaDP = null;
        this.zzaDQ = zza2;
        this.zzaDR = null;
        this.zzaDS = null;
        this.zzaDT = null;
        this.mContext = null;
    }

    public zzl(zzc zzc2, Context context) {
        this.zzaDP = null;
        this.zzaDQ = null;
        this.zzaDR = null;
        this.zzaDS = null;
        this.zzaDT = zzc2;
        this.mContext = context;
    }

    public zzl(zzd zzd2, Context context) {
        this.zzaDP = zzd2;
        this.zzaDQ = null;
        this.zzaDR = null;
        this.zzaDS = null;
        this.zzaDT = null;
        this.mContext = context;
    }

    public zzl(zzf zzf2) {
        this.zzaDP = null;
        this.zzaDQ = null;
        this.zzaDR = null;
        this.zzaDS = zzf2;
        this.zzaDT = null;
        this.mContext = null;
    }

    public void zzZ(DataHolder dataHolder) throws RemoteException {
        zzx.zza(this.zzaDP != null, (Object) "placeEstimator cannot be null");
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceEstimated received null DataHolder: " + zzlx.zzpY());
            }
            this.zzaDP.zzx(Status.zzaaF);
            return;
        }
        this.zzaDP.zza(new PlaceLikelihoodBuffer(dataHolder, 100, this.mContext));
    }

    public void zzaO(Status status) throws RemoteException {
        this.zzaDS.zza(status);
    }

    public void zzaa(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onAutocompletePrediction received null DataHolder: " + zzlx.zzpY());
            }
            this.zzaDQ.zzx(Status.zzaaF);
            return;
        }
        this.zzaDQ.zza(new AutocompletePredictionBuffer(dataHolder));
    }

    public void zzab(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            if (Log.isLoggable(TAG, 6)) {
                Log.e(TAG, "onPlaceUserDataFetched received null DataHolder: " + zzlx.zzpY());
            }
            this.zzaDR.zzx(Status.zzaaF);
            return;
        }
        this.zzaDR.zza(new com.google.android.gms.location.places.personalized.zzd(dataHolder));
    }

    public void zzac(DataHolder dataHolder) throws RemoteException {
        this.zzaDT.zza(new PlaceBuffer(dataHolder, this.mContext));
    }
}
