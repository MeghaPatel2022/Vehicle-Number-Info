package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public class zznn implements ConfigApi {

    private static class zza extends com.google.android.gms.internal.zzmu.zza {
        private final zzb<DataTypeResult> zzQz;

        private zza(zzb<DataTypeResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(DataTypeResult dataTypeResult) {
            this.zzQz.zzn(dataTypeResult);
        }
    }

    public PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient client, final DataTypeCreateRequest request) {
        return client.zzb(new zza<DataTypeResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzI */
            public DataTypeResult zzb(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzml zzml) throws RemoteException {
                ((zzmw) zzml.zzoA()).zza(new DataTypeCreateRequest(request, new zza(this), zzml.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> disableFit(GoogleApiClient client) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzml zzml) throws RemoteException {
                ((zzmw) zzml.zzoA()).zza(new DisableFitRequest(new zznt(this), zzml.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<DataTypeResult> readDataType(GoogleApiClient client, final String dataTypeName) {
        return client.zza(new zza<DataTypeResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzI */
            public DataTypeResult zzb(Status status) {
                return DataTypeResult.zzS(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzml zzml) throws RemoteException {
                ((zzmw) zzml.zzoA()).zza(new DataTypeReadRequest(dataTypeName, new zza(this), zzml.getContext().getPackageName()));
            }
        });
    }
}
