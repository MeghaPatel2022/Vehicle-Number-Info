package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public class zza implements ActivityRecognitionApi {

    /* renamed from: com.google.android.gms.location.internal.zza$zza reason: collision with other inner class name */
    private static abstract class C1474zza extends com.google.android.gms.location.ActivityRecognition.zza<Status> {
        public C1474zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Status> removeActivityUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new C1474zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(callbackIntent);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> requestActivityUpdates(GoogleApiClient client, long detectionIntervalMillis, PendingIntent callbackIntent) {
        final long j = detectionIntervalMillis;
        final PendingIntent pendingIntent = callbackIntent;
        return client.zzb(new C1474zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(j, pendingIntent);
                zza(Status.zzaaD);
            }
        });
    }
}
