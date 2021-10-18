package com.google.android.gms.wearable.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzi implements CapabilityApi {

    private static final class zza extends zzh<Status> {
        private CapabilityListener zzaZE;
        private String zzaZF;

        private zza(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaZE = capabilityListener;
            this.zzaZF = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzaZE, this.zzaZF);
            this.zzaZE = null;
            this.zzaZF = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzaZE = null;
            this.zzaZF = null;
            return status;
        }
    }

    public static class zzb implements AddLocalCapabilityResult, RemoveLocalCapabilityResult {
        private final Status zzQA;

        public zzb(Status status) {
            this.zzQA = status;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzc implements CapabilityInfo {
        private final String mName;
        private final Set<Node> zzaZG;

        public zzc(CapabilityInfo capabilityInfo) {
            this(capabilityInfo.getName(), capabilityInfo.getNodes());
        }

        public zzc(String str, Set<Node> set) {
            this.mName = str;
            this.zzaZG = set;
        }

        public String getName() {
            return this.mName;
        }

        public Set<Node> getNodes() {
            return this.zzaZG;
        }
    }

    public static class zzd implements GetAllCapabilitiesResult {
        private final Status zzQA;
        private final Map<String, CapabilityInfo> zzaZH;

        public zzd(Status status, Map<String, CapabilityInfo> map) {
            this.zzQA = status;
            this.zzaZH = map;
        }

        public Map<String, CapabilityInfo> getAllCapabilities() {
            return this.zzaZH;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zze implements GetCapabilityResult {
        private final Status zzQA;
        private final CapabilityInfo zzaZI;

        public zze(Status status, CapabilityInfo capabilityInfo) {
            this.zzQA = status;
            this.zzaZI = capabilityInfo;
        }

        public CapabilityInfo getCapability() {
            return this.zzaZI;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class zzf extends zzh<Status> {
        private CapabilityListener zzaZE;
        private String zzaZF;

        private zzf(GoogleApiClient googleApiClient, CapabilityListener capabilityListener, String str) {
            super(googleApiClient);
            this.zzaZE = capabilityListener;
            this.zzaZF = str;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zzb((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzaZE, this.zzaZF);
            this.zzaZE = null;
            this.zzaZF = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzaZE = null;
            this.zzaZF = null;
            return status;
        }
    }

    public PendingResult<Status> addCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        return client.zza(new zza(client, listener, capability));
    }

    public PendingResult<AddLocalCapabilityResult> addLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzh<AddLocalCapabilityResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzr(this, capability);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbk */
            public AddLocalCapabilityResult zzb(Status status) {
                return new zzb(status);
            }
        });
    }

    public PendingResult<GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient client, final int filter) {
        return client.zza(new zzh<GetAllCapabilitiesResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzd(this, filter);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbj */
            public GetAllCapabilitiesResult zzb(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<GetCapabilityResult> getCapability(GoogleApiClient client, final String capability, final int filter) {
        return client.zza(new zzh<GetCapabilityResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzg(this, capability, filter);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbi */
            public GetCapabilityResult zzb(Status status) {
                return new zze(status, null);
            }
        });
    }

    public PendingResult<Status> removeCapabilityListener(GoogleApiClient client, CapabilityListener listener, String capability) {
        return client.zza(new zzf(client, listener, capability));
    }

    public PendingResult<RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient client, final String capability) {
        return client.zza(new zzh<RemoveLocalCapabilityResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzs(this, capability);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbl */
            public RemoveLocalCapabilityResult zzb(Status status) {
                return new zzb(status);
            }
        });
    }
}
