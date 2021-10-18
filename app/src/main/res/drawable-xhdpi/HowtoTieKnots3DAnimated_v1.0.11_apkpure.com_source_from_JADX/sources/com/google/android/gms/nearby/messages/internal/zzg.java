package com.google.android.gms.nearby.messages.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.Strategy;

class zzg extends zzj<zzd> {
    private String zzQl;
    private String zzaJT;
    private boolean zzaJU;

    private static class zza extends com.google.android.gms.nearby.messages.internal.zzb.zza {
        private final MessageListener zzaJV;

        private zza(MessageListener messageListener) {
            this.zzaJV = messageListener;
        }

        public void zza(MessageWrapper messageWrapper) throws RemoteException {
            this.zzaJV.onFound(messageWrapper.zzaJS);
        }

        public void zzb(MessageWrapper messageWrapper) throws RemoteException {
            this.zzaJV.onLost(messageWrapper.zzaJS);
        }
    }

    zzg(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf, MessagesOptions messagesOptions) {
        super(context, looper, 62, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQl = zzf.zzol();
        if (messagesOptions != null) {
            this.zzaJT = messagesOptions.zzaCr;
            this.zzaJU = messagesOptions.zzaJJ;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb<Status> zzb, MessageListener messageListener) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new UnsubscribeRequest(new zza(messageListener), zzj.zzj(zzb), null, messageListener.hashCode(), this.zzaJT, this.zzQl));
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb<Status> zzb, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new SubscribeRequest(new zza(messageListener), strategy, zzj.zzj(zzb), messageFilter, null, messageListener.hashCode(), this.zzaJT, this.zzQl, null, this.zzaJU));
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb<Status> zzb, MessageWrapper messageWrapper) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new UnpublishRequest(messageWrapper, zzj.zzj(zzb), this.zzaJT, this.zzQl));
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb<Status> zzb, MessageWrapper messageWrapper, Strategy strategy) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new PublishRequest(messageWrapper, strategy, zzj.zzj(zzb), this.zzaJT, this.zzQl, this.zzaJU));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdk */
    public zzd zzV(IBinder iBinder) {
        return com.google.android.gms.nearby.messages.internal.zzd.zza.zzdj(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    /* access modifiers changed from: 0000 */
    public void zzi(zzb<Status> zzb) throws RemoteException {
        zzoz();
        ((zzd) zzoA()).zza(new GetPermissionStatusRequest(zzj.zzj(zzb), this.zzaJT));
    }
}
