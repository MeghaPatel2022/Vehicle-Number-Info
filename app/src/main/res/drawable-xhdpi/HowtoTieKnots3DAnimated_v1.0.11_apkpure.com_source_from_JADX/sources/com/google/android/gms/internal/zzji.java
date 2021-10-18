package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public class zzji implements AppInviteApi {

    static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzjj> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppInvite.zzQf, googleApiClient);
        }
    }

    final class zzb extends zza<Status> {
        private final String zzQh;

        public zzb(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzQh = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzjj zzjj) throws RemoteException {
            zzjj.zzb(new com.google.android.gms.internal.zzjk.zza() {
                public void zze(Status status) throws RemoteException {
                    zzb.this.zza(status);
                }
            }, this.zzQh);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    final class zzc extends zza<Status> {
        private final String zzQh;

        public zzc(GoogleApiClient googleApiClient, String str) {
            super(googleApiClient);
            this.zzQh = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzjj zzjj) throws RemoteException {
            zzjj.zza(new com.google.android.gms.internal.zzjk.zza() {
                public void zze(Status status) throws RemoteException {
                    zzc.this.zza(status);
                }
            }, this.zzQh);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Status> convertInvitation(GoogleApiClient client, String invitationId) {
        return client.zza(new zzc(client, invitationId));
    }

    public PendingResult<Status> updateInvitationOnInstall(GoogleApiClient client, String invitationId) {
        return client.zza(new zzb(client, invitationId));
    }
}
