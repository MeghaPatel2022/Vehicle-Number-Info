package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;

public class zzno implements HistoryApi {

    private static class zza extends com.google.android.gms.internal.zzms.zza {
        private final zzb<DataReadResult> zzQz;
        private int zzapd;
        private DataReadResult zzape;

        private zza(zzb<DataReadResult> zzb) {
            this.zzapd = 0;
            this.zzape = null;
            this.zzQz = zzb;
        }

        public void zza(DataReadResult dataReadResult) {
            synchronized (this) {
                Log.v("Fitness", "Received batch result");
                if (this.zzape == null) {
                    this.zzape = dataReadResult;
                } else {
                    this.zzape.zzb(dataReadResult);
                }
                this.zzapd++;
                if (this.zzapd == this.zzape.zzsB()) {
                    this.zzQz.zzn(this.zzape);
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final DataSet dataSet, final boolean z) {
        zzx.zzb(dataSet, (Object) "Must set the data set");
        zzx.zza(!dataSet.getDataPoints().isEmpty(), (Object) "Cannot use an empty data set");
        zzx.zzb(dataSet.getDataSource().zzrF(), (Object) "Must set the app package name for the data source");
        return googleApiClient.zza(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmm zzmm) throws RemoteException {
                ((zzmx) zzmm.zzoA()).zza(new DataInsertRequest(dataSet, new zznt(this), zzmm.getContext().getPackageName(), z));
            }
        });
    }

    public PendingResult<Status> deleteData(GoogleApiClient client, final DataDeleteRequest request) {
        return client.zza(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmm zzmm) throws RemoteException {
                ((zzmx) zzmm.zzoA()).zza(new DataDeleteRequest(request, new zznt(this), zzmm.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> insertData(GoogleApiClient client, DataSet dataSet) {
        return zza(client, dataSet, false);
    }

    public PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<DailyTotalResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzK */
            public DailyTotalResult zzb(Status status) {
                return DailyTotalResult.zzQ(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmm zzmm) throws RemoteException {
                ((zzmx) zzmm.zzoA()).zza(new DailyTotalRequest(new com.google.android.gms.internal.zzmr.zza() {
                    public void zza(DailyTotalResult dailyTotalResult) throws RemoteException {
                        C10254.this.zza(dailyTotalResult);
                    }
                }, dataType, zzmm.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<DataReadResult> readData(GoogleApiClient client, final DataReadRequest request) {
        return client.zza(new zza<DataReadResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzJ */
            public DataReadResult zzb(Status status) {
                return DataReadResult.zza(status, request);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmm zzmm) throws RemoteException {
                ((zzmx) zzmm.zzoA()).zza(new DataReadRequest(request, new zza(this), zzmm.getContext().getPackageName()));
            }
        });
    }
}
