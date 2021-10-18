package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

public class zzh implements Messages {
    public static final zzc<zzg> zzQf = new zzc<>();
    public static final com.google.android.gms.common.api.Api.zza<zzg, MessagesOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zzg, MessagesOptions>() {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }

        public zzg zza(Context context, Looper looper, zzf zzf, MessagesOptions messagesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, connectionCallbacks, onConnectionFailedListener, zzf, messagesOptions);
        }
    };

    static abstract class zza extends com.google.android.gms.common.api.zzc.zza<Status, zzg> {
        public zza(GoogleApiClient googleApiClient) {
            super(zzh.zzQf, googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient client) {
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzg zzg) throws RemoteException {
                zzg.zzi(this);
            }
        });
    }

    public PendingResult<Status> publish(GoogleApiClient client, Message message) {
        return publish(client, message, Strategy.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient client, final Message message, final Strategy strategy) {
        zzx.zzv(message);
        zzx.zzv(strategy);
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzg zzg) throws RemoteException {
                zzg.zza(this, MessageWrapper.zza(message), strategy);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener) {
        return subscribe(client, listener, Strategy.DEFAULT, MessageFilter.INCLUDE_ALL_MY_TYPES);
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy) {
        return subscribe(client, listener, strategy, MessageFilter.INCLUDE_ALL_MY_TYPES);
    }

    public PendingResult<Status> subscribe(GoogleApiClient client, MessageListener listener, Strategy strategy, MessageFilter filter) {
        zzx.zzv(listener);
        zzx.zzv(strategy);
        zzx.zzv(filter);
        final MessageListener messageListener = listener;
        final Strategy strategy2 = strategy;
        final MessageFilter messageFilter = filter;
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzg zzg) throws RemoteException {
                zzg.zza(this, messageListener, strategy2, messageFilter);
            }
        });
    }

    public PendingResult<Status> unpublish(GoogleApiClient client, final Message message) {
        zzx.zzv(message);
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzg zzg) throws RemoteException {
                zzg.zza((zzb<Status>) this, MessageWrapper.zza(message));
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient client, final MessageListener listener) {
        zzx.zzv(listener);
        return client.zzb(new zza(client) {
            /* access modifiers changed from: protected */
            public void zza(zzg zzg) throws RemoteException {
                zzg.zza((zzb<Status>) this, listener);
            }
        });
    }
}
