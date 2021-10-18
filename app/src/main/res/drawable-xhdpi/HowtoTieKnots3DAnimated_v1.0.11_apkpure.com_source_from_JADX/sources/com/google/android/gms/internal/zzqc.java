package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;
import com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult;

public class zzqc implements SearchAuthApi {

    static abstract class zza extends com.google.android.gms.internal.zzpz.zza {
        zza() {
        }

        public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
            throw new UnsupportedOperationException();
        }

        public void zzbc(Status status) {
            throw new UnsupportedOperationException();
        }
    }

    static class zzb extends com.google.android.gms.common.api.zzc.zza<Status, zzqb> {
        private final GoogleApiClient zzTC;
        private final String zzaNN;
        /* access modifiers changed from: private */
        public final boolean zzaNQ = Log.isLoggable("SearchAuth", 3);

        protected zzb(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzQf, googleApiClient);
            this.zzTC = googleApiClient;
            this.zzaNN = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzqb zzqb) throws RemoteException {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String packageName = this.zzTC.getContext().getPackageName();
            ((zzqa) zzqb.zzoA()).zzb(new zza() {
                public void zzbc(Status status) {
                    if (zzb.this.zzaNQ) {
                        Log.d("SearchAuth", "ClearTokenImpl success");
                    }
                    zzb.this.zza(status);
                }
            }, packageName, this.zzaNN);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "ClearTokenImpl received failure: " + status.getStatusMessage());
            }
            return status;
        }
    }

    static class zzc extends com.google.android.gms.common.api.zzc.zza<GoogleNowAuthResult, zzqb> {
        private final GoogleApiClient zzTC;
        /* access modifiers changed from: private */
        public final boolean zzaNQ = Log.isLoggable("SearchAuth", 3);
        private final String zzaNS;

        protected zzc(GoogleApiClient googleApiClient, String str) {
            super(SearchAuth.zzQf, googleApiClient);
            this.zzTC = googleApiClient;
            this.zzaNS = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzqb zzqb) throws RemoteException {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String packageName = this.zzTC.getContext().getPackageName();
            ((zzqa) zzqb.zzoA()).zza(new zza() {
                public void zza(Status status, GoogleNowAuthState googleNowAuthState) {
                    if (zzc.this.zzaNQ) {
                        Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                    }
                    zzc.this.zza(new zzd(status, googleNowAuthState));
                }
            }, packageName, this.zzaNS);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzbd */
        public GoogleNowAuthResult zzb(Status status) {
            if (this.zzaNQ) {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl received failure: " + status.getStatusMessage());
            }
            return new zzd(status, null);
        }
    }

    static class zzd implements GoogleNowAuthResult {
        private final Status zzQA;
        private final GoogleNowAuthState zzaNU;

        zzd(Status status, GoogleNowAuthState googleNowAuthState) {
            this.zzQA = status;
            this.zzaNU = googleNowAuthState;
        }

        public GoogleNowAuthState getGoogleNowAuthState() {
            return this.zzaNU;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public PendingResult<Status> clearToken(GoogleApiClient client, String accessToken) {
        return client.zza(new zzb(client, accessToken));
    }

    public PendingResult<GoogleNowAuthResult> getGoogleNowAuth(GoogleApiClient client, String webAppClientId) {
        return client.zza(new zzc(client, webAppClientId));
    }
}
