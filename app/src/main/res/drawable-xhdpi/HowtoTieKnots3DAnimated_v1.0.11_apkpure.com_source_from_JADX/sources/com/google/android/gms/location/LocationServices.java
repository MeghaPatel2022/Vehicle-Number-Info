package com.google.android.gms.location;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.internal.zzd;
import com.google.android.gms.location.internal.zze;
import com.google.android.gms.location.internal.zzj;
import com.google.android.gms.location.internal.zzo;

public class LocationServices {
    public static final Api<NoOptions> API = new Api<>("LocationServices.API", zzQg, zzQf);
    public static final FusedLocationProviderApi FusedLocationApi = new zzd();
    public static final GeofencingApi GeofencingApi = new zze();
    public static final SettingsApi SettingsApi = new zzo();
    /* access modifiers changed from: private */
    public static final zzc<zzj> zzQf = new zzc<>();
    private static final com.google.android.gms.common.api.Api.zza<zzj, NoOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zzj, NoOptions>() {
        /* renamed from: zzm */
        public zzj zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, "locationServices", zzf);
        }
    };

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(LocationServices.zzQf, googleApiClient);
        }
    }

    private LocationServices() {
    }

    public static zzj zze(GoogleApiClient googleApiClient) {
        boolean z = true;
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzj zzj = (zzj) googleApiClient.zza(zzQf);
        if (zzj == null) {
            z = false;
        }
        zzx.zza(z, (Object) "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzj;
    }
}
