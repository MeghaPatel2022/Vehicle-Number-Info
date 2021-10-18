package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.Node;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.util.ArrayList;
import java.util.List;

public final class zzba implements NodeApi {

    private static final class zza extends zzh<Status> {
        private NodeListener zzbaL;

        private zza(GoogleApiClient googleApiClient, NodeListener nodeListener) {
            super(googleApiClient);
            this.zzbaL = nodeListener;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzbaL);
            this.zzbaL = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzbaL = null;
            return status;
        }
    }

    public static class zzb implements GetConnectedNodesResult {
        private final Status zzQA;
        private final List<Node> zzbaM;

        public zzb(Status status, List<Node> list) {
            this.zzQA = status;
            this.zzbaM = list;
        }

        public List<Node> getNodes() {
            return this.zzbaM;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzc implements GetLocalNodeResult {
        private final Status zzQA;
        private final Node zzbaN;

        public zzc(Status status, Node node) {
            this.zzQA = status;
            this.zzbaN = node;
        }

        public Node getNode() {
            return this.zzbaN;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, NodeListener listener) {
        return client.zza(new zza(client, listener));
    }

    public PendingResult<GetConnectedNodesResult> getConnectedNodes(GoogleApiClient client) {
        return client.zza(new zzh<GetConnectedNodesResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzp(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbv */
            public GetConnectedNodesResult zzb(Status status) {
                return new zzb(status, new ArrayList());
            }
        });
    }

    public PendingResult<GetLocalNodeResult> getLocalNode(GoogleApiClient client) {
        return client.zza(new zzh<GetLocalNodeResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzo(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbu */
            public GetLocalNodeResult zzb(Status status) {
                return new zzc(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final NodeListener listener) {
        return client.zza(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzb(this, listener);
            }

            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
