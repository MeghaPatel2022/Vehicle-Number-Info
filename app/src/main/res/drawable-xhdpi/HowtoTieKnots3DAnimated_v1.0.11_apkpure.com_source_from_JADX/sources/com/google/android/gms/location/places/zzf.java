package com.google.android.gms.location.places;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

public class zzf extends com.google.android.gms.location.places.internal.zzg.zza {
    private final zzb zzaDw;
    private final zza zzaDx;

    public static abstract class zza<A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.location.places.zzl.zzb<PlacePhotoResult, A> {
        public zza(zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaM */
        public PlacePhotoResult zzb(Status status) {
            return new PlacePhotoResult(status, null);
        }
    }

    public static abstract class zzb<A extends com.google.android.gms.common.api.Api.zzb> extends com.google.android.gms.location.places.zzl.zzb<PlacePhotoMetadataResult, A> {
        public zzb(zzc<A> zzc, GoogleApiClient googleApiClient) {
            super(zzc, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzaN */
        public PlacePhotoMetadataResult zzb(Status status) {
            return new PlacePhotoMetadataResult(status, null);
        }
    }

    public zzf(zza zza2) {
        this.zzaDw = null;
        this.zzaDx = zza2;
    }

    public zzf(zzb zzb2) {
        this.zzaDw = zzb2;
        this.zzaDx = null;
    }

    public void zza(PlacePhotoMetadataResult placePhotoMetadataResult) throws RemoteException {
        this.zzaDw.zza(placePhotoMetadataResult);
    }

    public void zza(PlacePhotoResult placePhotoResult) throws RemoteException {
        this.zzaDx.zza(placePhotoResult);
    }
}
