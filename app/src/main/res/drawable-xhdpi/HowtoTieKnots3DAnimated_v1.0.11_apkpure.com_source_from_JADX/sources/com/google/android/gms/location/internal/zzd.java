package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class zzd implements FusedLocationProviderApi {

    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public Location getLastLocation(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).getLastLocation();
        } catch (Exception e) {
            return null;
        }
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient client) {
        try {
            return LocationServices.zze(client).zzvQ();
        } catch (Exception e) {
            return null;
        }
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final PendingIntent callbackIntent) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzf(callbackIntent);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationCallback callback) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(callback);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> removeLocationUpdates(GoogleApiClient client, final LocationListener listener) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(listener);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final PendingIntent callbackIntent) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzb(request, callbackIntent);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationCallback callback, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationCallback locationCallback = callback;
        final Looper looper2 = looper;
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(LocationRequestInternal.zzb(locationRequest), locationCallback, looper2);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, final LocationRequest request, final LocationListener listener) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(request, listener, (Looper) null);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> requestLocationUpdates(GoogleApiClient client, LocationRequest request, LocationListener listener, Looper looper) {
        final LocationRequest locationRequest = request;
        final LocationListener locationListener = listener;
        final Looper looper2 = looper;
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zza(locationRequest, locationListener, looper2);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> setMockLocation(GoogleApiClient client, final Location mockLocation) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzb(mockLocation);
                zza(Status.zzaaD);
            }
        });
    }

    public PendingResult<Status> setMockMode(GoogleApiClient client, final boolean isMockMode) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzj zzj) throws RemoteException {
                zzj.zzag(isMockMode);
                zza(Status.zzaaD);
            }
        });
    }
}
