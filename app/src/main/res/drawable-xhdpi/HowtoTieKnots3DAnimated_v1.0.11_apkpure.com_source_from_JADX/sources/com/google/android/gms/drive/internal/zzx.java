package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class zzx extends zzaa implements DriveFolder {

    private static class zza extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveFileResult> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<DriveFileResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzQz.zzn(new zzc(Status.zzaaD, new zzv(onDriveIdResponse.getDriveId())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzc(status, null));
        }
    }

    private static class zzb extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<DriveFolderResult> zzQz;

        public zzb(com.google.android.gms.common.api.zzc.zzb<DriveFolderResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
            this.zzQz.zzn(new zze(Status.zzaaD, new zzx(onDriveIdResponse.getDriveId())));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zze(status, null));
        }
    }

    private static class zzc implements DriveFileResult {
        private final Status zzQA;
        private final DriveFile zzaiU;

        public zzc(Status status, DriveFile driveFile) {
            this.zzQA = status;
            this.zzaiU = driveFile;
        }

        public DriveFile getDriveFile() {
            return this.zzaiU;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static abstract class zzd extends zzs<DriveFileResult> {
        zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzD */
        public DriveFileResult zzb(Status status) {
            return new zzc(status, null);
        }
    }

    private static class zze implements DriveFolderResult {
        private final Status zzQA;
        private final DriveFolder zzaiV;

        public zze(Status status, DriveFolder driveFolder) {
            this.zzQA = status;
            this.zzaiV = driveFolder;
        }

        public DriveFolder getDriveFolder() {
            return this.zzaiV;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static abstract class zzf extends zzs<DriveFolderResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzE */
        public DriveFolderResult zzb(Status status) {
            return new zze(status, null);
        }
    }

    public zzx(DriveId driveId) {
        super(driveId);
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        ExecutionOptions.zza(googleApiClient, executionOptions);
        final MetadataChangeSet metadataChangeSet2 = metadataChangeSet;
        final int i3 = i;
        final int i4 = i2;
        final ExecutionOptions executionOptions2 = executionOptions;
        return googleApiClient.zzb(new zzd(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                metadataChangeSet2.zzqp().setContext(zzt.getContext());
                zzt.zzqF().zza(new CreateFileRequest(zzx.this.getDriveId(), metadataChangeSet2.zzqp(), i3, i4, executionOptions2), (zzam) new zza(this));
            }
        });
    }

    private PendingResult<DriveFileResult> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        int i;
        if (driveContents == null) {
            i = 1;
        } else if (!(driveContents instanceof zzu)) {
            throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
        } else if (driveContents.getDriveId() != null) {
            throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
        } else if (driveContents.zzqj()) {
            throw new IllegalArgumentException("DriveContents are already closed.");
        } else {
            i = driveContents.zzqh().getRequestId();
            driveContents.zzqi();
        }
        if (metadataChangeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (!DriveFolder.MIME_TYPE.equals(metadataChangeSet.getMimeType())) {
            return zza(googleApiClient, metadataChangeSet, i, 0, executionOptions);
        } else {
            throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
        }
    }

    private Query zza(Query query) {
        Builder addFilter = new Builder().addFilter(Filters.m24in(SearchableField.PARENTS, getDriveId()));
        if (query != null) {
            if (query.getFilter() != null) {
                addFilter.addFilter(query.getFilter());
            }
            addFilter.setPageToken(query.getPageToken());
            addFilter.setSortOrder(query.getSortOrder());
        }
        return addFilter.build();
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents) {
        return createFile(apiClient, changeSet, driveContents, null);
    }

    public PendingResult<DriveFileResult> createFile(GoogleApiClient apiClient, MetadataChangeSet changeSet, DriveContents driveContents, ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new ExecutionOptions.Builder().build();
        }
        if (executionOptions.zzqn() == 0) {
            return zza(apiClient, changeSet, driveContents, executionOptions);
        }
        throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }

    public PendingResult<DriveFolderResult> createFolder(GoogleApiClient apiClient, final MetadataChangeSet changeSet) {
        if (changeSet == null) {
            throw new IllegalArgumentException("MetadataChangeSet must be provided.");
        } else if (changeSet.getMimeType() == null || changeSet.getMimeType().equals(DriveFolder.MIME_TYPE)) {
            return apiClient.zzb(new zzf(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzt zzt) throws RemoteException {
                    changeSet.zzqp().setContext(zzt.getContext());
                    zzt.zzqF().zza(new CreateFolderRequest(zzx.this.getDriveId(), changeSet.zzqp()), (zzam) new zzb(this));
                }
            });
        } else {
            throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
        }
    }

    public PendingResult<MetadataBufferResult> listChildren(GoogleApiClient apiClient) {
        return queryChildren(apiClient, null);
    }

    public PendingResult<MetadataBufferResult> queryChildren(GoogleApiClient apiClient, Query query) {
        return new zzr().query(apiClient, zza(query));
    }
}
