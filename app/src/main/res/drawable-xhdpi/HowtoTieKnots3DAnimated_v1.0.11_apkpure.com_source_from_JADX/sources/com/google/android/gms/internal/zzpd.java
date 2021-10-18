package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzpd implements Connections {
    public static final com.google.android.gms.common.api.Api.zzc<zzpc> zzQf = new com.google.android.gms.common.api.Api.zzc<>();
    public static final com.google.android.gms.common.api.Api.zza<zzpc, NoOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zzpc, NoOptions>() {
        /* renamed from: zzo */
        public zzpc zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzpc(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzpc> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzpd.zzQf, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaV */
        public StartAdvertisingResult zzb(final Status status) {
            return new StartAdvertisingResult() {
                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public static zzpc zzd(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzpc zze(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        } else if (hasConnectedApi) {
            return (zzpc) googleApiClient.zza(zzQf);
        } else {
            return null;
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload, MessageListener messageListener) {
        final zzl zzp = apiClient.zzp(messageListener);
        final String str = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpc zzpc) throws RemoteException {
                zzpc.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, str, bArr, zzp);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient apiClient, String remoteEndpointId) {
        zzd(apiClient, false).zzed(remoteEndpointId);
    }

    public String getLocalDeviceId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzyl();
    }

    public String getLocalEndpointId(GoogleApiClient apiClient) {
        return zzd(apiClient, true).zzyk();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient apiClient, final String remoteEndpointId) {
        return apiClient.zzb(new zzc(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpc zzpc) throws RemoteException {
                zzpc.zzp(this, remoteEndpointId);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient apiClient, String name, String remoteEndpointId, byte[] payload, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        final zzl zzp = apiClient.zzp(connectionResponseCallback);
        final zzl zzp2 = apiClient.zzp(messageListener);
        final String str = name;
        final String str2 = remoteEndpointId;
        final byte[] bArr = payload;
        return apiClient.zzb(new zzc(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpc zzpc) throws RemoteException {
                zzpc.zza(this, str, str2, bArr, zzp, zzp2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zza(new String[]{remoteEndpointId}, payload);
    }

    public void sendReliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zza((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, String remoteEndpointId, byte[] payload) {
        zzd(apiClient, false).zzb(new String[]{remoteEndpointId}, payload);
    }

    public void sendUnreliableMessage(GoogleApiClient apiClient, List<String> remoteEndpointIds, byte[] payload) {
        zzd(apiClient, false).zzb((String[]) remoteEndpointIds.toArray(new String[remoteEndpointIds.size()]), payload);
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient apiClient, String name, AppMetadata appMetadata, long durationMillis, ConnectionRequestListener connectionRequestListener) {
        final zzl zzp = apiClient.zzp(connectionRequestListener);
        final String str = name;
        final AppMetadata appMetadata2 = appMetadata;
        final long j = durationMillis;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpc zzpc) throws RemoteException {
                zzpc.zza(this, str, appMetadata2, j, zzp);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient apiClient, String serviceId, long durationMillis, EndpointDiscoveryListener listener) {
        final zzl zzp = apiClient.zzp(listener);
        final String str = serviceId;
        final long j = durationMillis;
        return apiClient.zzb(new zzc(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpc zzpc) throws RemoteException {
                zzpc.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, str, j, zzp);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzym();
    }

    public void stopAllEndpoints(GoogleApiClient apiClient) {
        zzd(apiClient, false).zzyn();
    }

    public void stopDiscovery(GoogleApiClient apiClient, String serviceId) {
        zzd(apiClient, false).zzec(serviceId);
    }
}
