package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;

public final class zzk implements ChannelApi {

    static final class zza extends zzh<Status> {
        private final String zzaZM;
        private ChannelListener zzaZN;

        zza(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaZN = (ChannelListener) zzx.zzv(channelListener);
            this.zzaZM = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzaZN, this.zzaZM);
            this.zzaZN = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzaZN = null;
            return status;
        }
    }

    static final class zzb implements OpenChannelResult {
        private final Status zzQA;
        private final Channel zzaZO;

        zzb(Status status, Channel channel) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZO = channel;
        }

        public Channel getChannel() {
            return this.zzaZO;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static final class zzc extends zzh<Status> {
        private final String zzaZM;
        private ChannelListener zzaZN;

        zzc(GoogleApiClient googleApiClient, ChannelListener channelListener, String str) {
            super(googleApiClient);
            this.zzaZN = (ChannelListener) zzx.zzv(channelListener);
            this.zzaZM = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zzb((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzaZN, this.zzaZM);
            this.zzaZN = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzaZN = null;
            return status;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(listener, (Object) "listener is null");
        return client.zza(new zza(client, listener, null));
    }

    public PendingResult<OpenChannelResult> openChannel(GoogleApiClient client, final String nodeId, final String path) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(nodeId, (Object) "nodeId is null");
        zzx.zzb(path, (Object) "path is null");
        return client.zzb(new zzh<OpenChannelResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zze(this, nodeId, path);
            }

            /* renamed from: zzbm */
            public OpenChannelResult zzb(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(listener, (Object) "listener is null");
        return client.zza(new zzc(client, listener, null));
    }
}
