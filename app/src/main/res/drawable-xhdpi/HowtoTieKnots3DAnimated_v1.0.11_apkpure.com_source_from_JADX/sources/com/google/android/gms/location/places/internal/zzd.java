package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.location.places.PlacesOptions.Builder;
import com.google.android.gms.location.places.zzl;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

public class zzd extends zzj<zzf> {
    private final PlacesParams zzaEj;
    private final Locale zzaEk = Locale.getDefault();

    public static class zza extends com.google.android.gms.common.api.Api.zza<zzd, PlacesOptions> {
        private final String zzaEl;
        private final String zzaEm;

        public zza(String str, String str2) {
            this.zzaEl = str;
            this.zzaEm = str2;
        }

        public zzd zza(Context context, Looper looper, zzf zzf, PlacesOptions placesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzd(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, this.zzaEl != null ? this.zzaEl : context.getPackageName(), this.zzaEm != null ? this.zzaEm : context.getPackageName(), placesOptions == null ? new Builder().build() : placesOptions);
        }
    }

    public zzd(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, String str, String str2, PlacesOptions placesOptions) {
        super(context, looper, 65, zzf, connectionCallbacks, onConnectionFailedListener);
        String str3 = null;
        if (zzf.getAccount() != null) {
            str3 = zzf.getAccount().name;
        }
        this.zzaEj = new PlacesParams(str, this.zzaEk, str3, placesOptions.zzaDU, str2);
    }

    public void zza(com.google.android.gms.location.places.zzf zzf, String str) throws RemoteException {
        zzx.zzb(str, (Object) "placeId cannot be null");
        ((zzf) zzoA()).zza(str, this.zzaEj, (zzg) zzf);
    }

    public void zza(com.google.android.gms.location.places.zzf zzf, String str, int i, int i2, int i3) throws RemoteException {
        boolean z = true;
        zzx.zzb(str, (Object) "fifeUrl cannot be null");
        zzx.zzb(i > 0, (Object) "width should be > 0");
        if (i <= 0) {
            z = false;
        }
        zzx.zzb(z, (Object) "height should be > 0");
        ((zzf) zzoA()).zza(str, i, i2, i3, this.zzaEj, (zzg) zzf);
    }

    public void zza(zzl zzl, AddPlaceRequest addPlaceRequest) throws RemoteException {
        zzx.zzb(addPlaceRequest, (Object) "userAddedPlace == null");
        ((zzf) zzoA()).zza(addPlaceRequest, this.zzaEj, (zzh) zzl);
    }

    public void zza(zzl zzl, String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter) throws RemoteException {
        zzx.zzb(str, (Object) "query == null");
        zzx.zzb(latLngBounds, (Object) "bounds == null");
        zzx.zzb(zzl, (Object) "callback == null");
        ((zzf) zzoA()).zza(str, latLngBounds, autocompleteFilter == null ? AutocompleteFilter.create(null) : autocompleteFilter, this.zzaEj, (zzh) zzl);
    }

    public void zza(zzl zzl, List<String> list) throws RemoteException {
        ((zzf) zzoA()).zzb(list, this.zzaEj, (zzh) zzl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzcc */
    public zzf zzV(IBinder iBinder) {
        return com.google.android.gms.location.places.internal.zzf.zza.zzce(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }
}
