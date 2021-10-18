package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;

class zzbj extends zzd {
    private final zzb<DriveContentsResult> zzQz;
    private final DownloadProgressListener zzajW;

    zzbj(zzb<DriveContentsResult> zzb, DownloadProgressListener downloadProgressListener) {
        this.zzQz = zzb;
        this.zzajW = downloadProgressListener;
    }

    public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
        this.zzQz.zzn(new zza(onContentsResponse.zzqO() ? new Status(-1) : Status.zzaaD, new zzu(onContentsResponse.zzqN())));
    }

    public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
        if (this.zzajW != null) {
            this.zzajW.onProgress(onDownloadProgressResponse.zzqQ(), onDownloadProgressResponse.zzqR());
        }
    }

    public void zzy(Status status) throws RemoteException {
        this.zzQz.zzn(new zza(status, null));
    }
}
