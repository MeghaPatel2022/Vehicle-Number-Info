package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzpc extends zzj<zzpf> {
    private final long zzasQ = ((long) hashCode());

    private static final class zza extends zzb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<Status> zzb, zzl<MessageListener> zzl) {
            super(zzl);
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(zzb);
        }

        public void zzii(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    private static class zzb extends zzpb {
        private final zzl<MessageListener> zzaJk;

        zzb(zzl<MessageListener> zzl) {
            this.zzaJk = zzl;
        }

        public void onDisconnected(final String remoteEndpointId) throws RemoteException {
            this.zzaJk.zza(new com.google.android.gms.common.api.zzl.zzb<MessageListener>() {
                /* renamed from: zza */
                public void zzo(MessageListener messageListener) {
                    messageListener.onDisconnected(remoteEndpointId);
                }

                public void zznh() {
                }
            });
        }

        public void onMessageReceived(final String remoteEndpointId, final byte[] payload, final boolean isReliable) throws RemoteException {
            this.zzaJk.zza(new com.google.android.gms.common.api.zzl.zzb<MessageListener>() {
                /* renamed from: zza */
                public void zzo(MessageListener messageListener) {
                    messageListener.onMessageReceived(remoteEndpointId, payload, isReliable);
                }

                public void zznh() {
                }
            });
        }
    }

    private static class zzc extends zzpb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzaJo;

        zzc(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            this.zzaJo = zzb;
        }

        public void zzij(int i) throws RemoteException {
            this.zzaJo.zzn(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;
        private final zzl<ConnectionResponseCallback> zzaJp;

        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> zzb, zzl<ConnectionResponseCallback> zzl, zzl<MessageListener> zzl2) {
            super(zzl2);
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(zzb);
            this.zzaJp = (zzl) zzx.zzv(zzl);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzaJp.zza(new com.google.android.gms.common.api.zzl.zzb<ConnectionResponseCallback>() {
                /* renamed from: zza */
                public void zzo(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public void zznh() {
                }
            });
        }

        public void zzih(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    private static final class zze extends zzpb {
        private final com.google.android.gms.common.api.zzc.zzb<StartAdvertisingResult> zzQz;
        private final zzl<ConnectionRequestListener> zzaJr;

        zze(com.google.android.gms.common.api.zzc.zzb<StartAdvertisingResult> zzb, zzl<ConnectionRequestListener> zzl) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(zzb);
            this.zzaJr = (zzl) zzx.zzv(zzl);
        }

        public void onConnectionRequest(String remoteEndpointId, String remoteDeviceId, String remoteEndpointName, byte[] payload) throws RemoteException {
            final String str = remoteEndpointId;
            final String str2 = remoteDeviceId;
            final String str3 = remoteEndpointName;
            final byte[] bArr = payload;
            this.zzaJr.zza(new com.google.android.gms.common.api.zzl.zzb<ConnectionRequestListener>() {
                /* renamed from: zza */
                public void zzo(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str, str2, str3, bArr);
                }

                public void zznh() {
                }
            });
        }

        public void zzk(int i, String str) throws RemoteException {
            this.zzQz.zzn(new zzf(new Status(i), str));
        }
    }

    private static final class zzf implements StartAdvertisingResult {
        private final Status zzQA;
        private final String zzaJv;

        zzf(Status status, String str) {
            this.zzQA = status;
            this.zzaJv = str;
        }

        public String getLocalEndpointName() {
            return this.zzaJv;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class zzg extends zzpb {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;
        private final zzl<EndpointDiscoveryListener> zzaJr;

        zzg(com.google.android.gms.common.api.zzc.zzb<Status> zzb, zzl<EndpointDiscoveryListener> zzl) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzv(zzb);
            this.zzaJr = (zzl) zzx.zzv(zzl);
        }

        public void onEndpointFound(String endpointId, String deviceId, String serviceId, String name) throws RemoteException {
            final String str = endpointId;
            final String str2 = deviceId;
            final String str3 = serviceId;
            final String str4 = name;
            this.zzaJr.zza(new com.google.android.gms.common.api.zzl.zzb<EndpointDiscoveryListener>() {
                /* renamed from: zza */
                public void zzo(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str, str2, str3, str4);
                }

                public void zznh() {
                }
            });
        }

        public void onEndpointLost(final String endpointId) throws RemoteException {
            this.zzaJr.zza(new com.google.android.gms.common.api.zzl.zzb<EndpointDiscoveryListener>() {
                /* renamed from: zza */
                public void zzo(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(endpointId);
                }

                public void zznh() {
                }
            });
        }

        public void zzif(int i) throws RemoteException {
            this.zzQz.zzn(new Status(i));
        }
    }

    public zzpc(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, zzf2, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzpf) zzoA()).zzE(this.zzasQ);
            } catch (RemoteException e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> zzb2, String str, long j, zzl<EndpointDiscoveryListener> zzl) throws RemoteException {
        ((zzpf) zzoA()).zza((zzpe) new zzg(zzb2, zzl), str, j, this.zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StartAdvertisingResult> zzb2, String str, AppMetadata appMetadata, long j, zzl<ConnectionRequestListener> zzl) throws RemoteException {
        ((zzpf) zzoA()).zza((zzpe) new zze(zzb2, zzl), str, appMetadata, j, this.zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> zzb2, String str, String str2, byte[] bArr, zzl<ConnectionResponseCallback> zzl, zzl<MessageListener> zzl2) throws RemoteException {
        ((zzpf) zzoA()).zza((zzpe) new zzd(zzb2, zzl, zzl2), str, str2, bArr, this.zzasQ);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> zzb2, String str, byte[] bArr, zzl<MessageListener> zzl) throws RemoteException {
        ((zzpf) zzoA()).zza((zzpe) new zza(zzb2, zzl), str, bArr, this.zzasQ);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzpf) zzoA()).zza(strArr, bArr, this.zzasQ);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzpf) zzoA()).zzb(strArr, bArr, this.zzasQ);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzde */
    public zzpf zzV(IBinder iBinder) {
        return com.google.android.gms.internal.zzpf.zza.zzdg(iBinder);
    }

    public void zzec(String str) {
        try {
            ((zzpf) zzoA()).zzf(str, this.zzasQ);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzed(String str) {
        try {
            ((zzpf) zzoA()).zzg(str, this.zzasQ);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    public void zzp(com.google.android.gms.common.api.zzc.zzb<Status> zzb2, String str) throws RemoteException {
        ((zzpf) zzoA()).zza((zzpe) new zzc(zzb2), str, this.zzasQ);
    }

    public String zzyk() {
        try {
            return ((zzpf) zzoA()).zzQ(this.zzasQ);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public String zzyl() {
        try {
            return ((zzpf) zzoA()).zzyl();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void zzym() {
        try {
            ((zzpf) zzoA()).zzN(this.zzasQ);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzyn() {
        try {
            ((zzpf) zzoA()).zzP(this.zzasQ);
        } catch (RemoteException e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }
}
