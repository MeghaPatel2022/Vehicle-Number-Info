package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzr implements DriveApi {

    static class zza implements Releasable, DriveContentsResult {
        private final Status zzQA;
        private final DriveContents zzagv;

        public zza(Status status, DriveContents driveContents) {
            this.zzQA = status;
            this.zzagv = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzagv;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzagv != null) {
                this.zzagv.zzqi();
            }
        }
    }

    static abstract class zzb extends zzs<DriveContentsResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzA */
        public DriveContentsResult zzb(Status status) {
            return new zza(status, null);
        }
    }

    static class zzc extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveIdResult> zzQz;

        public zzc(com.google.android.gms.common.api.zzc.zzb<DriveIdResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzQz.zzn(new zzd(Status.zzaaD, onDriveIdResponse.getDriveId()));
        }

        public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
            this.zzQz.zzn(new zzd(Status.zzaaD, new zzo(onMetadataResponse.zzqW()).getDriveId()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzd(status, null));
        }
    }

    private static class zzd implements DriveIdResult {
        private final Status zzQA;
        private final DriveId zzags;

        public zzd(Status status, DriveId driveId) {
            this.zzQA = status;
            this.zzags = driveId;
        }

        public DriveId getDriveId() {
            return this.zzags;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static abstract class zze extends zzs<DriveIdResult> {
        zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzB */
        public DriveIdResult zzb(Status status) {
            return new zzd(status, null);
        }
    }

    static class zzf implements MetadataBufferResult {
        private final Status zzQA;
        private final MetadataBuffer zzain;
        private final boolean zzaio;

        public zzf(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzQA = status;
            this.zzain = metadataBuffer;
            this.zzaio = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzain;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzain != null) {
                this.zzain.release();
            }
        }
    }

    static abstract class zzg extends zzs<MetadataBufferResult> {
        zzg(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzC */
        public MetadataBufferResult zzb(Status status) {
            return new zzf(status, null, false);
        }
    }

    private static class zzh extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveContentsResult> zzQz;

        public zzh(com.google.android.gms.common.api.zzc.zzb<DriveContentsResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
            this.zzQz.zzn(new zza(Status.zzaaD, new zzu(onContentsResponse.zzqN())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zza(status, null));
        }
    }

    private static class zzi extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> zzQz;

        public zzi(com.google.android.gms.common.api.zzc.zzb<MetadataBufferResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
            this.zzQz.zzn(new zzf(Status.zzaaD, new MetadataBuffer(onListEntriesResponse.zzqT()), onListEntriesResponse.zzqU()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzf(status, null, false));
        }
    }

    static class zzj extends com.google.android.gms.drive.internal.zzs.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zza(status);
        }

        /* access modifiers changed from: protected */
        public void zza(zzt zzt) {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, List<String> trackingTags) {
        return ((zzt) apiClient.zza(Drive.zzQf)).cancelPendingActions(apiClient, trackingTags);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient apiClient, final String resourceId) {
        return apiClient.zza(new zze(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new GetMetadataRequest(DriveId.zzcC(resourceId), false), (zzam) new zzc(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient apiClient) {
        if (!apiClient.isConnected()) {
            throw new IllegalStateException("Client must be connected");
        }
        DriveId zzqH = ((zzt) apiClient.zza(Drive.zzQf)).zzqH();
        if (zzqH != null) {
            return new zzx(zzqH);
        }
        return null;
    }

    public DriveFile getFile(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzv(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient apiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (apiClient.isConnected()) {
            return new zzx(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient apiClient) {
        if (apiClient.isConnected()) {
            return new zzx(((zzt) apiClient.zza(Drive.zzQf)).zzqG());
        }
        throw new IllegalStateException("Client must be connected");
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient apiClient) {
        return apiClient.zza(new zzs<BooleanResult>(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zze(new zzd() {
                    public void zzaa(boolean z) {
                        this.zza(new BooleanResult(Status.zzaaD, z));
                    }
                });
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzz */
            public BooleanResult zzb(Status status) {
                return new BooleanResult(status, false);
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient apiClient) {
        return zza(apiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient apiClient, final Query query) {
        if (query != null) {
            return apiClient.zza(new zzg(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzt zzt) throws RemoteException {
                    zzt.zzqF().zza(new QueryRequest(query), (zzam) new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient apiClient) {
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzs.zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza((zzam) new zzbr(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zza(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new CreateContentsRequest(i), (zzam) new zzh(this));
            }
        });
    }
}
