package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import java.util.List;

public class zze implements GeofencingApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Status> addGeofences(GoogleApiClient client, final GeofencingRequest geofencingRequest, final PendingIntent pendingIntent) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(geofencingRequest, pendingIntent, (zzb<Status>) this);
            }
        });
    }

    @Deprecated
    public PendingResult<Status> addGeofences(GoogleApiClient client, List<Geofence> geofences, PendingIntent pendingIntent) {
        Builder builder = new Builder();
        builder.addGeofences(geofences);
        builder.setInitialTrigger(5);
        return addGeofences(client, builder.build(), pendingIntent);
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final PendingIntent pendingIntent) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(pendingIntent, (zzb<Status>) this);
            }
        });
    }

    public PendingResult<Status> removeGeofences(GoogleApiClient client, final List<String> geofenceRequestIds) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(geofenceRequestIds, (zzb<Status>) this);
            }
        });
    }
}
