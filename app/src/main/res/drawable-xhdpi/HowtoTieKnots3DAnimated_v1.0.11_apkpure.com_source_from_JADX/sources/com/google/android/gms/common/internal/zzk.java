package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzk implements Callback {
    private final Handler mHandler;
    private final zza zzadM;
    private final ArrayList<ConnectionCallbacks> zzadN = new ArrayList<>();
    final ArrayList<ConnectionCallbacks> zzadO = new ArrayList<>();
    private final ArrayList<OnConnectionFailedListener> zzadP = new ArrayList<>();
    private volatile boolean zzadQ = false;
    private final AtomicInteger zzadR = new AtomicInteger(0);
    private boolean zzadS = false;
    private final Object zzpc = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzmw();
    }

    public zzk(Looper looper, zza zza2) {
        this.zzadM = zza2;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message msg) {
        if (msg.what == 1) {
            ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) msg.obj;
            synchronized (this.zzpc) {
                if (this.zzadQ && this.zzadM.isConnected() && this.zzadN.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zzadM.zzmw());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", "Don't know how to handle this message.");
        return false;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        boolean contains;
        zzx.zzv(listener);
        synchronized (this.zzpc) {
            contains = this.zzadN.contains(listener);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        boolean contains;
        zzx.zzv(listener);
        synchronized (this.zzpc) {
            contains = this.zzadP.contains(listener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        zzx.zzv(listener);
        synchronized (this.zzpc) {
            if (this.zzadN.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionCallbacks(): listener " + listener + " is already registered");
            } else {
                this.zzadN.add(listener);
            }
        }
        if (this.zzadM.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, listener));
        }
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        zzx.zzv(listener);
        synchronized (this.zzpc) {
            if (this.zzadP.contains(listener)) {
                Log.w("GmsClientEvents", "registerConnectionFailedListener(): listener " + listener + " is already registered");
            } else {
                this.zzadP.add(listener);
            }
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        zzx.zzv(listener);
        synchronized (this.zzpc) {
            if (!this.zzadN.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionCallbacks(): listener " + listener + " not found");
            } else if (this.zzadS) {
                this.zzadO.add(listener);
            }
        }
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        zzx.zzv(listener);
        synchronized (this.zzpc) {
            if (!this.zzadP.remove(listener)) {
                Log.w("GmsClientEvents", "unregisterConnectionFailedListener(): listener " + listener + " not found");
            }
        }
    }

    public void zzbB(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        zzx.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzpc) {
            this.zzadS = true;
            ArrayList arrayList = new ArrayList(this.zzadN);
            int i2 = this.zzadR.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.zzadQ || this.zzadR.get() != i2) {
                    break;
                } else if (this.zzadN.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.zzadO.clear();
            this.zzadS = false;
        }
    }

    public void zzh(Bundle bundle) {
        boolean z = true;
        zzx.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzpc) {
            zzx.zzY(!this.zzadS);
            this.mHandler.removeMessages(1);
            this.zzadS = true;
            if (this.zzadO.size() != 0) {
                z = false;
            }
            zzx.zzY(z);
            ArrayList arrayList = new ArrayList(this.zzadN);
            int i = this.zzadR.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ConnectionCallbacks connectionCallbacks = (ConnectionCallbacks) it.next();
                if (!this.zzadQ || !this.zzadM.isConnected() || this.zzadR.get() != i) {
                    break;
                } else if (!this.zzadO.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.zzadO.clear();
            this.zzadS = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzj(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            r1 = 1
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r2 = r5.mHandler
            android.os.Looper r2 = r2.getLooper()
            if (r0 != r2) goto L_0x0046
            r0 = r1
        L_0x000e:
            java.lang.String r2 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.zzx.zza(r0, r2)
            android.os.Handler r0 = r5.mHandler
            r0.removeMessages(r1)
            java.lang.Object r1 = r5.zzpc
            monitor-enter(r1)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r5.zzadP     // Catch:{ all -> 0x0054 }
            r0.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.zzadR     // Catch:{ all -> 0x0054 }
            int r2 = r2.get()     // Catch:{ all -> 0x0054 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x002c:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0     // Catch:{ all -> 0x0054 }
            boolean r4 = r5.zzadQ     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0044
            java.util.concurrent.atomic.AtomicInteger r4 = r5.zzadR     // Catch:{ all -> 0x0054 }
            int r4 = r4.get()     // Catch:{ all -> 0x0054 }
            if (r4 == r2) goto L_0x0048
        L_0x0044:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
        L_0x0045:
            return
        L_0x0046:
            r0 = 0
            goto L_0x000e
        L_0x0048:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r4 = r5.zzadP     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.contains(r0)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x002c
            r0.onConnectionFailed(r6)     // Catch:{ all -> 0x0054 }
            goto L_0x002c
        L_0x0054:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzk.zzj(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzoI() {
        this.zzadQ = false;
        this.zzadR.incrementAndGet();
    }

    public void zzoJ() {
        this.zzadQ = true;
    }
}
