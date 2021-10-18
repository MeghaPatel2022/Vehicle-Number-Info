package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public class zznq implements RecordingApi {

    private static class zza extends com.google.android.gms.internal.zznc.zza {
        private final zzb<ListSubscriptionsResult> zzQz;

        private zza(zzb<ListSubscriptionsResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(ListSubscriptionsResult listSubscriptionsResult) {
            this.zzQz.zzn(listSubscriptionsResult);
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final Subscription subscription) {
        return googleApiClient.zza(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmo zzmo) throws RemoteException {
                ((zzmz) zzmo.zzoA()).zza(new SubscribeRequest(subscription, false, new zznt(this), zzmo.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client) {
        return client.zza(new zza<ListSubscriptionsResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzL */
            public ListSubscriptionsResult zzb(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmo zzmo) throws RemoteException {
                ((zzmz) zzmo.zzoA()).zza(new ListSubscriptionsRequest(null, new zza(this), zzmo.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient client, final DataType dataType) {
        return client.zza(new zza<ListSubscriptionsResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzL */
            public ListSubscriptionsResult zzb(Status status) {
                return ListSubscriptionsResult.zzT(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmo zzmo) throws RemoteException {
                ((zzmz) zzmo.zzoA()).zza(new ListSubscriptionsRequest(dataType, new zza(this), zzmo.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataSource dataSource) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataSource).zzrR());
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, DataType dataType) {
        return zza(client, new com.google.android.gms.fitness.data.Subscription.zza().zzb(dataType).zzrR());
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataSource dataSource) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmo zzmo) throws RemoteException {
                ((zzmz) zzmo.zzoA()).zza(new UnsubscribeRequest(null, dataSource, new zznt(this), zzmo.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final DataType dataType) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmo zzmo) throws RemoteException {
                ((zzmz) zzmo.zzoA()).zza(new UnsubscribeRequest(dataType, null, new zznt(this), zzmo.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, Subscription subscription) {
        return subscription.getDataType() == null ? unsubscribe(client, subscription.getDataSource()) : unsubscribe(client, subscription.getDataType());
    }
}
