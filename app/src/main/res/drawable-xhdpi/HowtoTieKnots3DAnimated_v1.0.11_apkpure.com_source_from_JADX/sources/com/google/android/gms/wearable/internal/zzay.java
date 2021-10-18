package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class zzay implements MessageApi {

    private static final class zza extends zzh<Status> {
        private MessageListener zzbaI;
        private IntentFilter[] zzbal;

        private zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbaI = messageListener;
            this.zzbal = intentFilterArr;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzbaI, this.zzbal);
            this.zzbaI = null;
            this.zzbal = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzbaI = null;
            this.zzbal = null;
            return status;
        }
    }

    public static class zzb implements SendMessageResult {
        private final Status zzQA;
        private final int zzagq;

        public zzb(Status status, int i) {
            this.zzQA = status;
            this.zzagq = i;
        }

        public int getRequestId() {
            return this.zzagq;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, messageListener, intentFilterArr));
    }

    public PendingResult<Status> addListener(GoogleApiClient client, MessageListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final MessageListener listener) {
        return client.zza(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, listener);
            }

            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<SendMessageResult> sendMessage(GoogleApiClient client, String nodeId, String action, byte[] data) {
        final String str = nodeId;
        final String str2 = action;
        final byte[] bArr = data;
        return client.zza(new zzh<SendMessageResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<SendMessageResult>) this, str, str2, bArr);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbt */
            public SendMessageResult zzb(Status status) {
                return new zzb(status, -1);
            }
        });
    }
}
