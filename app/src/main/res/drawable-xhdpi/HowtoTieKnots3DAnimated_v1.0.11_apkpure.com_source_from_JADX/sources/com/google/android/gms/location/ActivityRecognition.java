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
import com.google.android.gms.location.internal.zzj;

public class ActivityRecognition {
    public static final Api<NoOptions> API = new Api<>("ActivityRecognition.API", zzQg, zzQf);
    public static final ActivityRecognitionApi ActivityRecognitionApi = new com.google.android.gms.location.internal.zza();
    public static final String CLIENT_NAME = "activity_recognition";
    /* access modifiers changed from: private */
    public static final zzc<zzj> zzQf = new zzc<>();
    private static final com.google.android.gms.common.api.Api.zza<zzj, NoOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zzj, NoOptions>() {
        /* renamed from: zzm */
        public zzj zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzj(context, looper, connectionCallbacks, onConnectionFailedListener, ActivityRecognition.CLIENT_NAME);
        }
    };

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzj> {
        public zza(GoogleApiClient googleApiClient) {
            super(ActivityRecognition.zzQf, googleApiClient);
        }
    }

    private ActivityRecognition() {
    }
}
