package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

final class zzm extends zzl implements Callback {
    private final Handler mHandler;
    /* access modifiers changed from: private */
    public final HashMap<zza, zzb> zzadV = new HashMap<>();
    /* access modifiers changed from: private */
    public final com.google.android.gms.common.stats.zzb zzadW;
    private final long zzadX;
    /* access modifiers changed from: private */
    public final Context zzqO;

    private static final class zza {
        private final String zzOj;
        private final ComponentName zzadY;

        public zza(ComponentName componentName) {
            this.zzOj = null;
            this.zzadY = (ComponentName) zzx.zzv(componentName);
        }

        public zza(String str) {
            this.zzOj = zzx.zzcs(str);
            this.zzadY = null;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof zza)) {
                return false;
            }
            zza zza = (zza) o;
            return zzw.equal(this.zzOj, zza.zzOj) && zzw.equal(this.zzadY, zza.zzadY);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzOj, this.zzadY);
        }

        public String toString() {
            return this.zzOj == null ? this.zzadY.flattenToString() : this.zzOj;
        }

        public Intent zzoK() {
            return this.zzOj != null ? new Intent(this.zzOj).setPackage("com.google.android.gms") : new Intent().setComponent(this.zzadY);
        }
    }

    private final class zzb {
        /* access modifiers changed from: private */
        public int mState = 2;
        /* access modifiers changed from: private */
        public IBinder zzacE;
        /* access modifiers changed from: private */
        public ComponentName zzadY;
        private final zza zzadZ = new zza();
        /* access modifiers changed from: private */
        public final Set<ServiceConnection> zzaea = new HashSet();
        private boolean zzaeb;
        /* access modifiers changed from: private */
        public final zza zzaec;

        public class zza implements ServiceConnection {
            public zza() {
            }

            public void onServiceConnected(ComponentName component, IBinder binder) {
                synchronized (zzm.this.zzadV) {
                    zzb.this.zzacE = binder;
                    zzb.this.zzadY = component;
                    for (ServiceConnection onServiceConnected : zzb.this.zzaea) {
                        onServiceConnected.onServiceConnected(component, binder);
                    }
                    zzb.this.mState = 1;
                }
            }

            public void onServiceDisconnected(ComponentName component) {
                synchronized (zzm.this.zzadV) {
                    zzb.this.zzacE = null;
                    zzb.this.zzadY = component;
                    for (ServiceConnection onServiceDisconnected : zzb.this.zzaea) {
                        onServiceDisconnected.onServiceDisconnected(component);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zza2) {
            this.zzaec = zza2;
        }

        public IBinder getBinder() {
            return this.zzacE;
        }

        public ComponentName getComponentName() {
            return this.zzadY;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.zzaeb;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzm.this.zzadW.zza(zzm.this.zzqO, serviceConnection, str, this.zzaec.zzoK());
            this.zzaea.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.zzaea.contains(serviceConnection);
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzm.this.zzadW.zzb(zzm.this.zzqO, serviceConnection);
            this.zzaea.remove(serviceConnection);
        }

        public void zzcl(String str) {
            this.zzaeb = zzm.this.zzadW.zza(zzm.this.zzqO, str, this.zzaec.zzoK(), (ServiceConnection) this.zzadZ, 129);
            if (this.zzaeb) {
                this.mState = 3;
                return;
            }
            try {
                zzm.this.zzadW.zza(zzm.this.zzqO, this.zzadZ);
            } catch (IllegalArgumentException e) {
            }
        }

        public void zzcm(String str) {
            zzm.this.zzadW.zza(zzm.this.zzqO, this.zzadZ);
            this.zzaeb = false;
            this.mState = 2;
        }

        public boolean zzoL() {
            return this.zzaea.isEmpty();
        }
    }

    zzm(Context context) {
        this.zzqO = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzadW = com.google.android.gms.common.stats.zzb.zzpD();
        this.zzadX = 5000;
    }

    private boolean zza(zza zza2, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzadV) {
            zzb zzb2 = (zzb) this.zzadV.get(zza2);
            if (zzb2 != null) {
                this.mHandler.removeMessages(0, zzb2);
                if (!zzb2.zza(serviceConnection)) {
                    zzb2.zza(serviceConnection, str);
                    switch (zzb2.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzb2.getComponentName(), zzb2.getBinder());
                            break;
                        case 2:
                            zzb2.zzcl(str);
                            break;
                    }
                } else {
                    throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + zza2);
                }
            } else {
                zzb2 = new zzb(zza2);
                zzb2.zza(serviceConnection, str);
                zzb2.zzcl(str);
                this.zzadV.put(zza2, zzb2);
            }
            isBound = zzb2.isBound();
        }
        return isBound;
    }

    private void zzb(zza zza2, ServiceConnection serviceConnection, String str) {
        zzx.zzb(serviceConnection, (Object) "ServiceConnection must not be null");
        synchronized (this.zzadV) {
            zzb zzb2 = (zzb) this.zzadV.get(zza2);
            if (zzb2 == null) {
                throw new IllegalStateException("Nonexistent connection status for service config: " + zza2);
            } else if (!zzb2.zza(serviceConnection)) {
                throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + zza2);
            } else {
                zzb2.zzb(serviceConnection, str);
                if (zzb2.zzoL()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzb2), this.zzadX);
                }
            }
        }
    }

    public boolean handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                zzb zzb2 = (zzb) msg.obj;
                synchronized (this.zzadV) {
                    if (zzb2.zzoL()) {
                        if (zzb2.isBound()) {
                            zzb2.zzcm("GmsClientSupervisor");
                        }
                        this.zzadV.remove(zzb2.zzaec);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    public boolean zza(String str, ServiceConnection serviceConnection, String str2) {
        return zza(new zza(str), serviceConnection, str2);
    }

    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    public void zzb(String str, ServiceConnection serviceConnection, String str2) {
        zzb(new zza(str), serviceConnection, str2);
    }
}
