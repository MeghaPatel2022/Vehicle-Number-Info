package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.appstate.AppStateBuffer;
import com.google.android.gms.appstate.AppStateManager.StateConflictResult;
import com.google.android.gms.appstate.AppStateManager.StateDeletedResult;
import com.google.android.gms.appstate.AppStateManager.StateListResult;
import com.google.android.gms.appstate.AppStateManager.StateLoadedResult;
import com.google.android.gms.appstate.AppStateManager.StateResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import java.util.Set;

public final class zzjn extends zzj<zzjp> {

    private static final class zza extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<StateDeletedResult> zzQz;

        public zza(com.google.android.gms.common.api.zzc.zzb<StateDeletedResult> zzb) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb(zzb, (Object) "Result holder must not be null");
        }

        public void zzg(int i, int i2) {
            this.zzQz.zzn(new zzb(new Status(i), i2));
        }
    }

    private static final class zzb implements StateDeletedResult {
        private final Status zzQA;
        private final int zzQB;

        public zzb(Status status, int i) {
            this.zzQA = status;
            this.zzQB = i;
        }

        public int getStateKey() {
            return this.zzQB;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class zzc extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<StateListResult> zzQz;

        public zzc(com.google.android.gms.common.api.zzc.zzb<StateListResult> zzb) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb(zzb, (Object) "Result holder must not be null");
        }

        public void zza(DataHolder dataHolder) {
            this.zzQz.zzn(new zzd(dataHolder));
        }
    }

    private static final class zzd extends com.google.android.gms.common.api.zze implements StateListResult {
        private final AppStateBuffer zzQC;

        public zzd(DataHolder dataHolder) {
            super(dataHolder);
            this.zzQC = new AppStateBuffer(dataHolder);
        }

        public AppStateBuffer getStateBuffer() {
            return this.zzQC;
        }
    }

    private static final class zze extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<StateResult> zzQz;

        public zze(com.google.android.gms.common.api.zzc.zzb<StateResult> zzb) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb(zzb, (Object) "Result holder must not be null");
        }

        public void zza(int i, DataHolder dataHolder) {
            this.zzQz.zzn(new zzf(i, dataHolder));
        }
    }

    private static final class zzf extends com.google.android.gms.common.api.zze implements StateConflictResult, StateLoadedResult, StateResult {
        private final int zzQB;
        private final AppStateBuffer zzQC;

        public zzf(int i, DataHolder dataHolder) {
            super(dataHolder);
            this.zzQB = i;
            this.zzQC = new AppStateBuffer(dataHolder);
        }

        private boolean zzlp() {
            return this.zzQA.getStatusCode() == 2000;
        }

        public StateConflictResult getConflictResult() {
            if (zzlp()) {
                return this;
            }
            return null;
        }

        public StateLoadedResult getLoadedResult() {
            if (zzlp()) {
                return null;
            }
            return this;
        }

        public byte[] getLocalData() {
            if (this.zzQC.getCount() == 0) {
                return null;
            }
            return this.zzQC.get(0).getLocalData();
        }

        public String getResolvedVersion() {
            if (this.zzQC.getCount() == 0) {
                return null;
            }
            return this.zzQC.get(0).getConflictVersion();
        }

        public byte[] getServerData() {
            if (this.zzQC.getCount() == 0) {
                return null;
            }
            return this.zzQC.get(0).getConflictData();
        }

        public int getStateKey() {
            return this.zzQB;
        }

        public void release() {
            this.zzQC.release();
        }
    }

    private static final class zzg extends zzjm {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzQz;

        public zzg(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            this.zzQz = (com.google.android.gms.common.api.zzc.zzb) zzx.zzb(zzb, (Object) "Holder must not be null");
        }

        public void zzll() {
            this.zzQz.zzn(new Status(0));
        }
    }

    public zzjn(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 7, zzf2, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    public Set<Scope> zza(Set<Scope> set) {
        zzx.zza(set.contains(new Scope(Scopes.APP_STATE)), (Object) String.format("App State APIs requires %s to function.", new Object[]{Scopes.APP_STATE}));
        return set;
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateListResult> zzb2) throws RemoteException {
        ((zzjp) zzoA()).zza(new zzc(zzb2));
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateDeletedResult> zzb2, int i) throws RemoteException {
        ((zzjp) zzoA()).zzb(new zza(zzb2), i);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateResult> zzb2, int i, String str, byte[] bArr) throws RemoteException {
        ((zzjp) zzoA()).zza(new zze(zzb2), i, str, bArr);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<StateResult> zzb2, int i, byte[] bArr) throws RemoteException {
        ((zzjp) zzoA()).zza(zzb2 == null ? null : new zze(zzb2), i, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzal */
    public zzjp zzV(IBinder iBinder) {
        return com.google.android.gms.internal.zzjp.zza.zzan(iBinder);
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb<Status> zzb2) throws RemoteException {
        ((zzjp) zzoA()).zzb(new zzg(zzb2));
    }

    public void zzb(com.google.android.gms.common.api.zzc.zzb<StateResult> zzb2, int i) throws RemoteException {
        ((zzjp) zzoA()).zza(new zze(zzb2), i);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.appstate.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.appstate.internal.IAppStateService";
    }

    public boolean zzlm() {
        return true;
    }

    public int zzln() {
        try {
            return ((zzjp) zzoA()).zzln();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }

    public int zzlo() {
        try {
            return ((zzjp) zzoA()).zzlo();
        } catch (RemoteException e) {
            Log.w("AppStateClient", "service died");
            return 2;
        }
    }
}
