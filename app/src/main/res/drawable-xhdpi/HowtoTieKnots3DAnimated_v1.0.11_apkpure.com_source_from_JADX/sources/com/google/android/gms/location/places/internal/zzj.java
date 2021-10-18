package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import java.util.Locale;

public class zzj extends com.google.android.gms.common.internal.zzj<zze> {
    private final PlacesParams zzaEj;
    private final Locale zzaEk = Locale.getDefault();

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzj, PlacesOptions> {
        private final String zzaEl;
        private final String zzaEm;

        public zza(String str, String str2) {
            this.zzaEl = str;
            this.zzaEm = str2;
        }

        /* renamed from: zzb */
        public zzj zza(Context context, Looper looper, zzf zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, this.zzaEl != null ? this.zzaEl : context.getPackageName(), this.zzaEm != null ? this.zzaEm : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzj(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 67, zzf, connectionCallbacks, onConnectionFailedListener);
        String str3 = null;
        if (zzf.getAccount() != null) {
            str3 = zzf.getAccount().name;
        }
        this.zzaEj = new PlacesParams(str, this.zzaEk, str3, placesOptions.zzaDU, str2);
    }

    public void zza(zzl zzl, PlaceFilter placeFilter) throws RemoteException {
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzwe();
        }
        ((zze) zzoA()).zza(placeFilter, this.zzaEj, (zzh) zzl);
    }

    public void zza(zzl zzl, PlaceReport placeReport) throws RemoteException {
        zzx.zzv(placeReport);
        ((zze) zzoA()).zza(placeReport, this.zzaEj, (zzh) zzl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzch */
    public zze zzV(IBinder iBinder) {
        return com.google.android.gms.location.places.internal.zze.zza.zzcd(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }
}
