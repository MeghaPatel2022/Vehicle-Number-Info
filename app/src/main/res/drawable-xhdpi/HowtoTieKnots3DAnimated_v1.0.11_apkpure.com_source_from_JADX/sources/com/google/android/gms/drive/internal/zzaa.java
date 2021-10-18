package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.Set;

public class zzaa implements DriveResource {
    protected final DriveId zzags;

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
            this.zzQz.zzn(new zzf(Status.zzaaD, new MetadataBuffer(onListParentsResponse.zzqV()), false));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzf(status, null, false));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<MetadataResult> zzQz;

        public zzb(com.google.android.gms.common.api.zzc.zzb<MetadataResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzQz.zzn(new zzc(Status.zzaaD, new zzo(onMetadataResponse.zzqW())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzc(status, null));
        }
    }

    private static class zzc implements MetadataResult {
        private final Status zzQA;
        private final Metadata zzajd;

        public zzc(Status status, Metadata metadata) {
            this.zzQA = status;
            this.zzajd = metadata;
        }

        public Metadata getMetadata() {
            return this.zzajd;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private abstract class zzd extends zzs<MetadataResult> {
        private zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzG */
        public MetadataResult zzb(Status status) {
            return new zzc(status, null);
        }
    }

    protected zzaa(DriveId driveId) {
        this.zzags = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new GetMetadataRequest(zzaa.this.zzags, z), (zzam) new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zza(apiClient, this.zzags, listener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient apiClient) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zza(apiClient, this.zzags);
    }

    public PendingResult<Status> delete(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzs.zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new DeleteResourceRequest(zzaa.this.zzags), (zzam) new zzbr(this));
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzags;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient apiClient) {
        return zza(apiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient apiClient) {
        return apiClient.zza(new zzg(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new ListParentsRequest(zzaa.this.zzags), (zzam) new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient apiClient, ChangeListener listener) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zzb(apiClient, this.zzags, listener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient apiClient) {
        return ((zzt) apiClient.zza(Drive.zzQf)).zzb(apiClient, this.zzags);
    }

    public PendingResult<Status> setParents(GoogleApiClient apiClient, Set<DriveId> parentIds) {
        if (parentIds == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        final ArrayList arrayList = new ArrayList(parentIds);
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzs.zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new SetResourceParentsRequest(zzaa.this.zzags, arrayList), (zzam) new zzbr(this));
            }
        });
    }

    public PendingResult<Status> trash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzs.zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new TrashResourceRequest(zzaa.this.zzags), (zzam) new zzbr(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzs.zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new UntrashResourceRequest(zzaa.this.zzags), (zzam) new zzbr(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet != null) {
            return apiClient.zzb(new zzd(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzt zzt) throws RemoteException {
                    changeSet.zzqp().setContext(zzt.getContext());
                    zzt.zzqF().zza(new UpdateMetadataRequest(zzaa.this.zzags, changeSet.zzqp()), (zzam) new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
