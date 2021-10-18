package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.PlaceDetectionApi;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceLikelihoodBuffer;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.location.places.zzl.zzd;
import com.google.android.gms.location.places.zzl.zzf;

public class zzi implements PlaceDetectionApi {
    public PendingResult<PlaceLikelihoodBuffer> getCurrentPlace(GoogleApiClient client, final PlaceFilter filter) {
        return client.zza(new zzd<zzj>(Places.zzaDO, client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(new zzl((zzd) this, zzj.getContext()), filter);
            }
        });
    }

    public PendingResult<Status> reportDeviceAtPlace(GoogleApiClient client, final PlaceReport report) {
        return client.zzb(new zzf<zzj>(Places.zzaDO, client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(new zzl((zzf) this), report);
            }
        });
    }
}
