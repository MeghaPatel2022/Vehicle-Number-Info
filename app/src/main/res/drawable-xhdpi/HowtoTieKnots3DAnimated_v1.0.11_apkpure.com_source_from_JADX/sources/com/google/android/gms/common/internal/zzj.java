package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzj<T extends IInterface> implements com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza {
    public static final String[] zzadF = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzOY;
    private final Looper zzYV;
    private final zzf zzZH;
    private final GoogleApiAvailability zzZi;
    /* access modifiers changed from: private */
    public final Set<Scope> zzZp;
    private int zzadA;
    /* access modifiers changed from: private */
    public final ConnectionCallbacks zzadB;
    /* access modifiers changed from: private */
    public final OnConnectionFailedListener zzadC;
    private final int zzadD;
    protected AtomicInteger zzadE;
    private final zzl zzadu;
    /* access modifiers changed from: private */
    public zzs zzadv;
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.GoogleApiClient.zza zzadw;
    private T zzadx;
    /* access modifiers changed from: private */
    public final ArrayList<zzc<?>> zzady;
    private zze zzadz;
    private final Object zzpc;

    private abstract class zza extends zzc<Boolean> {
        public final int statusCode;
        public final Bundle zzadG;

        protected zza(int i, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.statusCode = i;
            this.zzadG = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzc */
        public void zzs(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                zzj.this.zzb(1, null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!zzoD()) {
                        zzj.this.zzb(1, null);
                        zzi(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    zzj.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzj.this.zzb(1, null);
                    if (this.zzadG != null) {
                        pendingIntent = (PendingIntent) this.zzadG.getParcelable("pendingIntent");
                    }
                    zzi(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzi(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zzoD();

        /* access modifiers changed from: protected */
        public void zzoE() {
        }
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzoE();
            zzc.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        public void handleMessage(Message msg) {
            if (zzj.this.zzadE.get() != msg.arg1) {
                if (zzb(msg)) {
                    zza(msg);
                }
            } else if ((msg.what == 1 || msg.what == 5 || msg.what == 6) && !zzj.this.isConnecting()) {
                zza(msg);
            } else if (msg.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(msg.arg2, null);
                zzj.this.zzadw.zza(connectionResult);
                zzj.this.onConnectionFailed(connectionResult);
            } else if (msg.what == 4) {
                zzj.this.zzb(4, null);
                if (zzj.this.zzadB != null) {
                    zzj.this.zzadB.onConnectionSuspended(msg.arg2);
                }
                zzj.this.onConnectionSuspended(msg.arg2);
                zzj.this.zza(4, 1, null);
            } else if (msg.what == 2 && !zzj.this.isConnected()) {
                zza(msg);
            } else if (zzb(msg)) {
                ((zzc) msg.obj).zzoF();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle this message.");
            }
        }
    }

    protected abstract class zzc<TListener> {
        private TListener mListener;
        private boolean zzadI = false;

        public zzc(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzoG();
            synchronized (zzj.this.zzady) {
                zzj.this.zzady.remove(this);
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzoE();

        public void zzoF() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.zzadI) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    zzs(tlistener);
                } catch (RuntimeException e) {
                    zzoE();
                    throw e;
                }
            } else {
                zzoE();
            }
            synchronized (this) {
                this.zzadI = true;
            }
            unregister();
        }

        public void zzoG() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zzs(TListener tlistener);
    }

    public static final class zzd extends com.google.android.gms.common.internal.zzr.zza {
        private zzj zzadJ;
        private final int zzadK;

        public zzd(zzj zzj, int i) {
            this.zzadJ = zzj;
            this.zzadK = i;
        }

        private void zzoH() {
            this.zzadJ = null;
        }

        public void zza(int i, IBinder iBinder, Bundle bundle) {
            zzx.zzb(this.zzadJ, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzadJ.zza(i, iBinder, bundle, this.zzadK);
            zzoH();
        }

        public void zzb(int i, Bundle bundle) {
            zzx.zzb(this.zzadJ, (Object) "onAccountValidationComplete can be called only once per call to validateAccount");
            this.zzadJ.zza(i, bundle, this.zzadK);
            zzoH();
        }
    }

    public final class zze implements ServiceConnection {
        private final int zzadK;

        public zze(int i) {
            this.zzadK = i;
        }

        public void onServiceConnected(ComponentName component, IBinder binder) {
            zzx.zzb(binder, (Object) "Expecting a valid IBinder");
            zzj.this.zzadv = com.google.android.gms.common.internal.zzs.zza.zzaK(binder);
            zzj.this.zzbA(this.zzadK);
        }

        public void onServiceDisconnected(ComponentName component) {
            zzj.this.mHandler.sendMessage(zzj.this.mHandler.obtainMessage(4, this.zzadK, 1));
        }
    }

    protected class zzf implements com.google.android.gms.common.api.GoogleApiClient.zza {
        public zzf() {
        }

        public void zza(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zzj.this.zza((zzp) null, zzj.this.zzZp);
            } else if (zzj.this.zzadC != null) {
                zzj.this.zzadC.onConnectionFailed(connectionResult);
            }
        }

        public void zzb(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    protected final class zzg extends zza {
        public final IBinder zzadL;

        public zzg(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzadL = iBinder;
        }

        /* access modifiers changed from: protected */
        public void zzi(ConnectionResult connectionResult) {
            if (zzj.this.zzadC != null) {
                zzj.this.zzadC.onConnectionFailed(connectionResult);
            }
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzoD() {
            try {
                String interfaceDescriptor = this.zzadL.getInterfaceDescriptor();
                if (!zzj.this.zzfB().equals(interfaceDescriptor)) {
                    Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzfB() + " vs. " + interfaceDescriptor);
                    return false;
                }
                IInterface zzV = zzj.this.zzV(this.zzadL);
                if (zzV == null || !zzj.this.zza(2, 3, zzV)) {
                    return false;
                }
                Bundle zzmw = zzj.this.zzmw();
                if (zzj.this.zzadB != null) {
                    zzj.this.zzadB.onConnected(zzmw);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    protected final class zzh extends zza {
        public zzh() {
            super(0, null);
        }

        /* access modifiers changed from: protected */
        public void zzi(ConnectionResult connectionResult) {
            zzj.this.zzadw.zza(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzoD() {
            zzj.this.zzadw.zza(ConnectionResult.zzYi);
            return true;
        }
    }

    protected final class zzi extends zza {
        public zzi(int i, Bundle bundle) {
            super(i, bundle);
        }

        /* access modifiers changed from: protected */
        public void zzi(ConnectionResult connectionResult) {
            zzj.this.zzadw.zzb(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public boolean zzoD() {
            zzj.this.zzadw.zzb(ConnectionResult.zzYi);
            return true;
        }
    }

    protected zzj(Context context, Looper looper, int i, zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.zzak(context), GoogleApiAvailability.getInstance(), i, zzf2, (ConnectionCallbacks) zzx.zzv(connectionCallbacks), (OnConnectionFailedListener) zzx.zzv(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzl, GoogleApiAvailability googleApiAvailability, int i, zzf zzf2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this.zzpc = new Object();
        this.zzady = new ArrayList<>();
        this.zzadA = 1;
        this.zzadE = new AtomicInteger(0);
        this.mContext = (Context) zzx.zzb(context, (Object) "Context must not be null");
        this.zzYV = (Looper) zzx.zzb(looper, (Object) "Looper must not be null");
        this.zzadu = (zzl) zzx.zzb(zzl, (Object) "Supervisor must not be null");
        this.zzZi = (GoogleApiAvailability) zzx.zzb(googleApiAvailability, (Object) "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzadD = i;
        this.zzZH = (zzf) zzx.zzv(zzf2);
        this.zzOY = zzf2.getAccount();
        this.zzZp = zzb(zzf2.zzoj());
        this.zzadB = connectionCallbacks;
        this.zzadC = onConnectionFailedListener;
    }

    /* access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzpc) {
            if (this.zzadA != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    private Set<Scope> zzb(Set<Scope> set) {
        Set<Scope> zza2 = zza(set);
        if (zza2 == null) {
            return zza2;
        }
        for (Scope contains : zza2) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zza2;
    }

    /* access modifiers changed from: private */
    public void zzb(int i, T t) {
        boolean z = true;
        if ((i == 3) != (t != null)) {
            z = false;
        }
        zzx.zzZ(z);
        synchronized (this.zzpc) {
            this.zzadA = i;
            this.zzadx = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzow();
                    break;
                case 2:
                    zzov();
                    break;
                case 3:
                    zzou();
                    break;
            }
        }
    }

    private void zzov() {
        if (this.zzadz != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzfA());
            this.zzadu.zzb(zzfA(), (ServiceConnection) this.zzadz, zzot());
            this.zzadE.incrementAndGet();
        }
        this.zzadz = new zze<>(this.zzadE.get());
        if (!this.zzadu.zza(zzfA(), (ServiceConnection) this.zzadz, zzot())) {
            Log.e("GmsClient", "unable to connect to service: " + zzfA());
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzadE.get(), 9));
        }
    }

    private void zzow() {
        if (this.zzadz != null) {
            this.zzadu.zzb(zzfA(), (ServiceConnection) this.zzadz, zzot());
            this.zzadz = null;
        }
    }

    public void disconnect() {
        this.zzadE.incrementAndGet();
        synchronized (this.zzady) {
            int size = this.zzady.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.zzady.get(i)).zzoG();
            }
            this.zzady.clear();
        }
        zzb(1, null);
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        int i;
        T t;
        synchronized (this.zzpc) {
            i = this.zzadA;
            t = this.zzadx;
        }
        writer.append(prefix).append("mConnectState=");
        switch (i) {
            case 1:
                writer.print("DISCONNECTED");
                break;
            case 2:
                writer.print("CONNECTING");
                break;
            case 3:
                writer.print("CONNECTED");
                break;
            case 4:
                writer.print("DISCONNECTING");
                break;
            default:
                writer.print("UNKNOWN");
                break;
        }
        writer.append(" mService=");
        if (t == null) {
            writer.println("null");
        } else {
            writer.append(zzfB()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzYV;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzadA == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzadA == 2;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult result) {
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int cause) {
    }

    /* access modifiers changed from: protected */
    public abstract T zzV(IBinder iBinder);

    /* access modifiers changed from: protected */
    public Set<Scope> zza(Set<Scope> set) {
        return set;
    }

    /* access modifiers changed from: protected */
    public void zza(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzi(i, bundle)));
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(i, iBinder, bundle)));
    }

    public void zza(com.google.android.gms.common.api.GoogleApiClient.zza zza2) {
        this.zzadw = (com.google.android.gms.common.api.GoogleApiClient.zza) zzx.zzb(zza2, (Object) "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzp zzp) {
        try {
            this.zzadv.zza((zzr) new zzd(this, this.zzadE.get()), new ValidateAccountRequest(zzp, (Scope[]) this.zzZp.toArray(new Scope[this.zzZp.size()]), this.mContext.getPackageName(), zzoB()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbz(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    public void zza(zzp zzp, Set<Scope> set) {
        try {
            GetServiceRequest zzg2 = new GetServiceRequest(this.zzadD).zzck(this.mContext.getPackageName()).zzg(zzli());
            if (set != null) {
                zzg2.zzd(set);
            }
            if (zzlm()) {
                zzg2.zzb(zzog()).zzc(zzp);
            } else if (zzoC()) {
                zzg2.zzb(this.zzOY);
            }
            this.zzadv.zza((zzr) new zzd(this, this.zzadE.get()), zzg2);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbz(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void zzbA(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, i, -1, new zzh()));
    }

    public void zzbz(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzadE.get(), i));
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
    }

    /* access modifiers changed from: protected */
    public abstract String zzfA();

    /* access modifiers changed from: protected */
    public abstract String zzfB();

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        return new Bundle();
    }

    public boolean zzlm() {
        return false;
    }

    public Bundle zzmw() {
        return null;
    }

    public final T zzoA() throws DeadObjectException {
        T t;
        synchronized (this.zzpc) {
            if (this.zzadA == 4) {
                throw new DeadObjectException();
            }
            zzoz();
            zzx.zza(this.zzadx != null, (Object) "Client is connected but service is null");
            t = this.zzadx;
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public Bundle zzoB() {
        return null;
    }

    public boolean zzoC() {
        return false;
    }

    public final Account zzog() {
        return this.zzOY != null ? this.zzOY : new Account("<<default account>>", GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    /* access modifiers changed from: protected */
    public final String zzot() {
        return this.zzZH.zzom();
    }

    /* access modifiers changed from: protected */
    public void zzou() {
    }

    public void zzox() {
        int isGooglePlayServicesAvailable = this.zzZi.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable != 0) {
            zzb(1, null);
            this.zzadw = new zzf();
            this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzadE.get(), isGooglePlayServicesAvailable));
            return;
        }
        zza((com.google.android.gms.common.api.GoogleApiClient.zza) new zzf());
    }

    /* access modifiers changed from: protected */
    public final zzf zzoy() {
        return this.zzZH;
    }

    /* access modifiers changed from: protected */
    public final void zzoz() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }
}
