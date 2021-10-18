package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.api.zzl.zzb;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class zzv extends zzaa implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzl<DownloadProgressListener> zzaiL;

        public zza(zzl<DownloadProgressListener> zzl) {
            this.zzaiL = zzl;
        }

        public void onProgress(long bytesDownloaded, long bytesExpected) {
            final long j = bytesDownloaded;
            final long j2 = bytesExpected;
            this.zzaiL.zza(new zzb<DownloadProgressListener>() {
                /* renamed from: zza */
                public void zzo(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j, j2);
                }

                public void zznh() {
                }
            });
        }
    }

    public zzv(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        if (downloadProgressListener == null) {
            return null;
        }
        return new zza(googleApiClient.zzp(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient apiClient, final int mode, DownloadProgressListener listener) {
        if (mode == 268435456 || mode == 536870912 || mode == 805306368) {
            final DownloadProgressListener zza2 = zza(apiClient, listener);
            return apiClient.zza(new zzb(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzt zzt) throws RemoteException {
                    zza(zzt.zzqF().zza(new OpenContentsRequest(zzv.this.getDriveId(), mode, 0), (zzam) new zzbj(this, zza2)).zzqJ());
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
