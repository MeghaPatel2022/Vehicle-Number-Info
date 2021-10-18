package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzz implements DrivePreferencesApi {

    private class zza extends zzd {
        private final com.google.android.gms.common.api.zzc.zzb<FileUploadPreferencesResult> zzQz;

        private zza(com.google.android.gms.common.api.zzc.zzb<FileUploadPreferencesResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
            this.zzQz.zzn(new zzb(Status.zzaaD, onDeviceUsagePreferenceResponse.zzqP()));
        }

        public void zzy(Status status) throws RemoteException {
            this.zzQz.zzn(new zzb(status, null));
        }
    }

    private class zzb implements FileUploadPreferencesResult {
        private final Status zzQA;
        private final FileUploadPreferences zzaiZ;

        private zzb(Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzQA = status;
            this.zzaiZ = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzaiZ;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private abstract class zzc extends zzs<FileUploadPreferencesResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzF */
        public FileUploadPreferencesResult zzb(Status status) {
            return new zzb(status, null);
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient apiClient) {
        return apiClient.zza(new zzc(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient apiClient, FileUploadPreferences fileUploadPreferences) {
        if (!(fileUploadPreferences instanceof FileUploadPreferencesImpl)) {
            throw new IllegalArgumentException("Invalid preference value");
        }
        final FileUploadPreferencesImpl fileUploadPreferencesImpl = (FileUploadPreferencesImpl) fileUploadPreferences;
        return apiClient.zzb(new com.google.android.gms.drive.internal.zzs.zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new SetFileUploadPreferencesRequest(fileUploadPreferencesImpl), (zzam) new zzbr(this));
            }
        });
    }
}
