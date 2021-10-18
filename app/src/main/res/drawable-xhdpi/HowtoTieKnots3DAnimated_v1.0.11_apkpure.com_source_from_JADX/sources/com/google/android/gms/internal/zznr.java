package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.fitness.data.zzk;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;

public class zznr implements SensorsApi {

    private interface zza {
        void zzrZ();
    }

    private static class zzb extends com.google.android.gms.internal.zzmt.zza {
        private final com.google.android.gms.common.api.zzc.zzb<DataSourcesResult> zzQz;

        private zzb(com.google.android.gms.common.api.zzc.zzb<DataSourcesResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(DataSourcesResult dataSourcesResult) {
            this.zzQz.zzn(dataSourcesResult);
        }
    }

    private static class zzc extends com.google.android.gms.internal.zznh.zza {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;
        private final zza zzapr;

        private zzc(com.google.android.gms.common.api.zzc.zzb<Status> zzb, zza zza) {
            this.zzQz = zzb;
            this.zzapr = zza;
        }

        public void zzr(Status status) {
            if (this.zzapr != null && status.isSuccess()) {
                this.zzapr.zzrZ();
            }
            this.zzQz.zzn(status);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, zzj zzj, PendingIntent pendingIntent, zza zza2) {
        final zza zza3 = zza2;
        final zzj zzj2 = zzj;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmp zzmp) throws RemoteException {
                ((zzna) zzmp.zzoA()).zza(new SensorUnregistrationRequest(zzj2, pendingIntent2, new zzc(this, zza3), zzmp.getContext().getPackageName()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, SensorRequest sensorRequest, zzj zzj, PendingIntent pendingIntent) {
        final SensorRequest sensorRequest2 = sensorRequest;
        final zzj zzj2 = zzj;
        final PendingIntent pendingIntent2 = pendingIntent;
        return googleApiClient.zza(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmp zzmp) throws RemoteException {
                ((zzna) zzmp.zzoA()).zza(new SensorRegistrationRequest(sensorRequest2, zzj2, pendingIntent2, new zznt(this), zzmp.getContext().getPackageName()));
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, PendingIntent intent) {
        return zza(client, request, (zzj) null, intent);
    }

    public PendingResult<Status> add(GoogleApiClient client, SensorRequest request, OnDataPointListener listener) {
        return zza(client, request, (zzj) com.google.android.gms.fitness.data.zzk.zza.zzrL().zza(listener), (PendingIntent) null);
    }

    public PendingResult<DataSourcesResult> findDataSources(GoogleApiClient client, final DataSourcesRequest request) {
        return client.zza(new zza<DataSourcesResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzM */
            public DataSourcesResult zzb(Status status) {
                return DataSourcesResult.zzR(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmp zzmp) throws RemoteException {
                ((zzna) zzmp.zzoA()).zza(new DataSourcesRequest(request, new zzb(this), zzmp.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> remove(GoogleApiClient client, PendingIntent pendingIntent) {
        return zza(client, (zzj) null, pendingIntent, (zza) null);
    }

    public PendingResult<Status> remove(GoogleApiClient client, final OnDataPointListener listener) {
        zzk zzb2 = com.google.android.gms.fitness.data.zzk.zza.zzrL().zzb(listener);
        return zzb2 == null ? new zznj(Status.zzaaD) : zza(client, (zzj) zzb2, (PendingIntent) null, (zza) new zza() {
            public void zzrZ() {
                com.google.android.gms.fitness.data.zzk.zza.zzrL().zzc(listener);
            }
        });
    }
}
