package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzs.zza;
import com.google.android.gms.internal.zzlr;
import java.io.InputStream;
import java.io.OutputStream;

public class zzu implements DriveContents {
    private boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Contents zzaiD;
    private boolean zzaiE = false;
    private boolean zzaiF = false;

    public zzu(Contents contents) {
        this.zzaiD = (Contents) zzx.zzv(contents);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, MetadataChangeSet changeSet) {
        return commit(apiClient, changeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient apiClient, final MetadataChangeSet changeSet, final ExecutionOptions executionOptions) {
        if (executionOptions == null) {
            executionOptions = new Builder().build();
        }
        if (this.zzaiD.getMode() == 268435456) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzcf(executionOptions.zzqn()) || this.zzaiD.zzqf()) {
            ExecutionOptions.zza(apiClient, executionOptions);
            if (zzqj()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (changeSet == null) {
                    changeSet = MetadataChangeSet.zzagR;
                }
                zzqi();
                return apiClient.zzb(new zza(apiClient) {
                    /* access modifiers changed from: protected */
                    public void zza(zzt zzt) throws RemoteException {
                        changeSet.zzqp().setContext(zzt.getContext());
                        zzt.zzqF().zza(new CloseContentsAndUpdateMetadataRequest(zzu.this.zzaiD.getDriveId(), changeSet.zzqp(), zzu.this.zzaiD.getRequestId(), zzu.this.zzaiD.zzqf(), executionOptions), (zzam) new zzbr(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public void discard(GoogleApiClient apiClient) {
        if (zzqj()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzqi();
        ((C06334) apiClient.zzb(new zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new CloseContentsRequest(zzu.this.zzaiD.getRequestId(), false), (zzam) new zzbr(this));
            }
        })).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzr */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    zzy.zzx("DriveContentsImpl", "Error discarding contents");
                } else {
                    zzy.zzv("DriveContentsImpl", "Contents discarded");
                }
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzaiD.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzqj()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzaiD.getMode() != 268435456) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzaiE) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzaiE = true;
            return this.zzaiD.getInputStream();
        }
    }

    public int getMode() {
        return this.zzaiD.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzqj()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzaiD.getMode() != 536870912) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzaiF) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzaiF = true;
            return this.zzaiD.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzqj()) {
            return this.zzaiD.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient apiClient) {
        if (zzqj()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzaiD.getMode() != 268435456) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzqi();
            return apiClient.zza(new zzb(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzt zzt) throws RemoteException {
                    zzt.zzqF().zza(new OpenContentsRequest(zzu.this.getDriveId(), DriveFile.MODE_WRITE_ONLY, zzu.this.zzaiD.getRequestId()), (zzam) new zzbj(this, null));
                }
            });
        }
    }

    public Contents zzqh() {
        return this.zzaiD;
    }

    public void zzqi() {
        zzlr.zza(this.zzaiD.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzqj() {
        return this.mClosed;
    }
}
