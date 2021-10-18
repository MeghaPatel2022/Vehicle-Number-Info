package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznx;

public final class Address {
    public static final Api<AddressOptions> API = new Api<>("Address.API", zzQg, zzQf);
    static final zzc<zznx> zzQf = new zzc<>();
    private static final com.google.android.gms.common.api.Api.zza<zznx, AddressOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zznx, AddressOptions>() {
        public zznx zza(Context context, Looper looper, zzf zzf, AddressOptions addressOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(context instanceof Activity, (Object) "An Activity must be used for Address APIs");
            if (addressOptions == null) {
                addressOptions = new AddressOptions();
            }
            return new zznx((Activity) context, looper, zzf, addressOptions.theme, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public static final class AddressOptions implements HasOptions {
        public final int theme;

        public AddressOptions() {
            this.theme = 0;
        }

        public AddressOptions(int theme2) {
            this.theme = theme2;
        }
    }

    private static abstract class zza extends com.google.android.gms.common.api.zzc.zza<Status, zznx> {
        public zza(GoogleApiClient googleApiClient) {
            super(Address.zzQf, googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public static void requestUserAddress(GoogleApiClient googleApiClient, final UserAddressRequest request, final int requestCode) {
        googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zznx zznx) throws RemoteException {
                zznx.zza(request, requestCode);
                zza(Status.zzaaD);
            }
        });
    }
}
