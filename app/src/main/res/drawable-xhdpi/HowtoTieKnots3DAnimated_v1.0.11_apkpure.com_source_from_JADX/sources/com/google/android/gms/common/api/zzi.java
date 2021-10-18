package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkw;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class zzi implements GoogleApiClient {
    private final Context mContext;
    private final Looper zzYV;
    final zzf zzZH;
    final Map<Api<?>, Integer> zzZI;
    private final Condition zzZX;
    final zzk zzZY;
    final Queue<zze<?>> zzZZ = new LinkedList();
    /* access modifiers changed from: private */
    public final int zzZf;
    private final int zzZg;
    private final GoogleApiAvailability zzZi;
    final com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.signin.zzd, com.google.android.gms.signin.zze> zzZj;
    /* access modifiers changed from: private */
    public final Lock zzZs = new ReentrantLock();
    private volatile boolean zzaaa;
    private long zzaab = 120000;
    private long zzaac = 5000;
    private final zza zzaad;
    BroadcastReceiver zzaae;
    final Map<com.google.android.gms.common.api.Api.zzc<?>, com.google.android.gms.common.api.Api.zzb> zzaaf = new HashMap();
    final Map<com.google.android.gms.common.api.Api.zzc<?>, ConnectionResult> zzaag = new HashMap();
    Set<Scope> zzaah = new HashSet();
    /* access modifiers changed from: private */
    public volatile zzj zzaai;
    private ConnectionResult zzaaj = null;
    private final Set<zzl<?>> zzaak = Collections.newSetFromMap(new WeakHashMap());
    final Set<zze<?>> zzaal = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final zzd zzaam = new zzd() {
        public void zzc(zze<?> zze) {
            zzi.this.zzaal.remove(zze);
        }
    };
    private final ConnectionCallbacks zzaan = new ConnectionCallbacks() {
        public void onConnected(Bundle connectionHint) {
            zzi.this.zzZs.lock();
            try {
                zzi.this.zzaai.onConnected(connectionHint);
            } finally {
                zzi.this.zzZs.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
            zzi.this.zzZs.lock();
            try {
                zzi.this.zzaai.onConnectionSuspended(cause);
            } finally {
                zzi.this.zzZs.unlock();
            }
        }
    };
    private final com.google.android.gms.common.internal.zzk.zza zzaao = new com.google.android.gms.common.internal.zzk.zza() {
        public boolean isConnected() {
            return zzi.this.isConnected();
        }

        public Bundle zzmw() {
            return null;
        }
    };

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzi.this.zznC();
                    return;
                case 2:
                    zzi.this.resume();
                    return;
                case 3:
                    ((zzb) msg.obj).zzf(zzi.this);
                    return;
                case 4:
                    throw ((RuntimeException) msg.obj);
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + msg.what);
                    return;
            }
        }
    }

    static abstract class zzb {
        private final zzj zzaaw;

        protected zzb(zzj zzj) {
            this.zzaaw = zzj;
        }

        public final void zzf(zzi zzi) {
            zzi.zzZs.lock();
            try {
                if (zzi.zzaai == this.zzaaw) {
                    zznn();
                    zzi.zzZs.unlock();
                }
            } finally {
                zzi.zzZs.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zznn();
    }

    private static class zzc extends BroadcastReceiver {
        private WeakReference<zzi> zzaax;

        zzc(zzi zzi) {
            this.zzaax = new WeakReference<>(zzi);
        }

        public void onReceive(Context context, Intent intent) {
            Uri data = intent.getData();
            String str = null;
            if (data != null) {
                str = data.getSchemeSpecificPart();
            }
            if (str != null && str.equals("com.google.android.gms")) {
                zzi zzi = (zzi) this.zzaax.get();
                if (zzi != null) {
                    zzi.resume();
                }
            }
        }
    }

    interface zzd {
        void zzc(zze<?> zze);
    }

    interface zze<A extends com.google.android.gms.common.api.Api.zzb> {
        void cancel();

        void zza(zzd zzd);

        void zzb(A a) throws DeadObjectException;

        com.google.android.gms.common.api.Api.zzc<A> zznd();

        int zzng();

        void zzw(Status status);

        void zzx(Status status);
    }

    public zzi(Context context, Looper looper, zzf zzf, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.signin.zzd, com.google.android.gms.signin.zze> zza2, Map<Api<?>, ApiOptions> map, ArrayList<ConnectionCallbacks> arrayList, ArrayList<OnConnectionFailedListener> arrayList2, int i, int i2) {
        int i3;
        this.mContext = context;
        this.zzZY = new zzk(looper, this.zzaao);
        this.zzYV = looper;
        this.zzaad = new zza(looper);
        this.zzZi = googleApiAvailability;
        this.zzZf = i;
        this.zzZg = i2;
        this.zzZI = new HashMap();
        this.zzZX = this.zzZs.newCondition();
        this.zzaai = new zzh(this);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzZY.registerConnectionCallbacks((ConnectionCallbacks) it.next());
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.zzZY.registerConnectionFailedListener((OnConnectionFailedListener) it2.next());
        }
        Map zzok = zzf.zzok();
        for (Api api : map.keySet()) {
            Object obj = map.get(api);
            if (zzok.get(api) != null) {
                i3 = ((com.google.android.gms.common.internal.zzf.zza) zzok.get(api)).zzadg ? 1 : 2;
            } else {
                i3 = 0;
            }
            this.zzZI.put(api, Integer.valueOf(i3));
            this.zzaaf.put(api.zznd(), api.zzne() ? zza(api.zznc(), obj, context, looper, zzf, this.zzaan, zza(api, i3)) : zza(api.zznb(), obj, context, looper, zzf, this.zzaan, zza(api, i3)));
        }
        this.zzZH = zzf;
        this.zzZj = zza2;
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.zzZs.lock();
        try {
            if (zznB()) {
                connect();
            }
        } finally {
            this.zzZs.unlock();
        }
    }

    private static <C extends com.google.android.gms.common.api.Api.zzb, O> C zza(com.google.android.gms.common.api.Api.zza<C, O> zza2, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return zza2.zza(context, looper, zzf, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private final OnConnectionFailedListener zza(final Api<?> api, final int i) {
        return new OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult result) {
                zzi.this.zzZs.lock();
                try {
                    zzi.this.zzaai.zza(result, api, i);
                } finally {
                    zzi.this.zzZs.unlock();
                }
            }
        };
    }

    private static <C extends com.google.android.gms.common.api.Api.zzd, O> zzac zza(com.google.android.gms.common.api.Api.zze<C, O> zze2, Object obj, Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        return new zzac(context, looper, zze2.zznf(), connectionCallbacks, onConnectionFailedListener, zzf, zze2.zzm(obj));
    }

    /* access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzo zzo, final boolean z) {
        zzkw.zzaet.zzc(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzr */
            public void onResult(Status status) {
                if (status.isSuccess() && zzi.this.isConnected()) {
                    zzi.this.reconnect();
                }
                zzo.zza(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void zznC() {
        this.zzZs.lock();
        try {
            if (zznE()) {
                connect();
            }
        } finally {
            this.zzZs.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.zzZs.lock();
        try {
            connect();
            while (isConnecting()) {
                this.zzZX.await();
            }
            if (isConnected()) {
                connectionResult = ConnectionResult.zzYi;
            } else if (this.zzaaj != null) {
                connectionResult = this.zzaaj;
                this.zzZs.unlock();
            } else {
                connectionResult = new ConnectionResult(13, null);
                this.zzZs.unlock();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzZs.unlock();
        }
        return connectionResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        if (isConnected() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        r0 = com.google.android.gms.common.ConnectionResult.zzYi;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r5.zzaaj == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0066, code lost:
        r0 = r5.zzaaj;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        r5.zzZs.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r0 = new com.google.android.gms.common.ConnectionResult(13, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0076, code lost:
        r5.zzZs.unlock();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.common.ConnectionResult blockingConnect(long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r5 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L_0x003c
            r0 = 1
        L_0x000b:
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            com.google.android.gms.common.internal.zzx.zza(r0, r1)
            java.util.concurrent.locks.Lock r0 = r5.zzZs
            r0.lock()
            r5.connect()     // Catch:{ all -> 0x007c }
            long r0 = r8.toNanos(r6)     // Catch:{ all -> 0x007c }
        L_0x001c:
            boolean r2 = r5.isConnecting()     // Catch:{ all -> 0x007c }
            if (r2 == 0) goto L_0x0054
            java.util.concurrent.locks.Condition r2 = r5.zzZX     // Catch:{ InterruptedException -> 0x003e }
            long r0 = r2.awaitNanos(r0)     // Catch:{ InterruptedException -> 0x003e }
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L_0x001c
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ InterruptedException -> 0x003e }
            r1 = 14
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ InterruptedException -> 0x003e }
            java.util.concurrent.locks.Lock r1 = r5.zzZs
            r1.unlock()
        L_0x003b:
            return r0
        L_0x003c:
            r0 = 0
            goto L_0x000b
        L_0x003e:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x007c }
            r0.interrupt()     // Catch:{ all -> 0x007c }
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x007c }
            r1 = 15
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r5.zzZs
            r1.unlock()
            goto L_0x003b
        L_0x0054:
            boolean r0 = r5.isConnected()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0062
            com.google.android.gms.common.ConnectionResult r0 = com.google.android.gms.common.ConnectionResult.zzYi     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r5.zzZs
            r1.unlock()
            goto L_0x003b
        L_0x0062:
            com.google.android.gms.common.ConnectionResult r0 = r5.zzaaj     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x006e
            com.google.android.gms.common.ConnectionResult r0 = r5.zzaaj     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r5.zzZs
            r1.unlock()
            goto L_0x003b
        L_0x006e:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch:{ all -> 0x007c }
            r1 = 13
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x007c }
            java.util.concurrent.locks.Lock r1 = r5.zzZs
            r1.unlock()
            goto L_0x003b
        L_0x007c:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r5.zzZs
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzi.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzx.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        final zzo zzo = new zzo(this.zzYV);
        if (this.zzaaf.containsKey(zzkw.zzQf)) {
            zza(this, zzo, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            C04025 r2 = new ConnectionCallbacks() {
                public void onConnected(Bundle connectionHint) {
                    zzi.this.zza((GoogleApiClient) atomicReference.get(), zzo, true);
                }

                public void onConnectionSuspended(int cause) {
                }
            };
            GoogleApiClient build = new Builder(this.mContext).addApi(zzkw.API).addConnectionCallbacks(r2).addOnConnectionFailedListener(new OnConnectionFailedListener() {
                public void onConnectionFailed(ConnectionResult result) {
                    zzo.zza(new Status(8));
                }
            }).setHandler(this.zzaad).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzo;
    }

    public void connect() {
        this.zzZs.lock();
        try {
            this.zzaai.connect();
        } finally {
            this.zzZs.unlock();
        }
    }

    public void disconnect() {
        this.zzZs.lock();
        try {
            zznE();
            this.zzaai.disconnect();
        } finally {
            this.zzZs.unlock();
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.append(prefix).append("mState=").append(this.zzaai.getName());
        writer.append(" mResuming=").print(this.zzaaa);
        writer.append(" mWorkQueue.size()=").print(this.zzZZ.size());
        writer.append(" mUnconsumedRunners.size()=").println(this.zzaal.size());
        String str = prefix + "  ";
        for (Api api : this.zzZI.keySet()) {
            writer.append(prefix).append(api.getName()).println(":");
            ((com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(api.zznd())).dump(str, fd, writer, args);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        com.google.android.gms.common.api.Api.zzc zznd = api.zznd();
        this.zzZs.lock();
        try {
            if (!isConnected() && !zznB()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzaaf.containsKey(zznd)) {
                if (((com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(zznd)).isConnected()) {
                    connectionResult = ConnectionResult.zzYi;
                } else if (this.zzaag.containsKey(zznd)) {
                    connectionResult = (ConnectionResult) this.zzaag.get(zznd);
                    this.zzZs.unlock();
                } else {
                    Log.wtf("GoogleApiClientImpl", api.getName() + " requested in getConnectionResult" + " is not connected but is not present in the failed connections map");
                    connectionResult = new ConnectionResult(8, null);
                    this.zzZs.unlock();
                }
                return connectionResult;
            } else {
                this.zzZs.unlock();
                throw new IllegalArgumentException(api.getName() + " was never registered with GoogleApiClient");
            }
        } finally {
            this.zzZs.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzYV;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(Api<?> api) {
        com.google.android.gms.common.api.Api.zzb zzb2 = (com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(api.zznd());
        if (zzb2 == null) {
            return false;
        }
        return zzb2.isConnected();
    }

    public boolean isConnected() {
        return this.zzaai instanceof zzf;
    }

    public boolean isConnecting() {
        return this.zzaai instanceof zzg;
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks listener) {
        return this.zzZY.isConnectionCallbacksRegistered(listener);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener listener) {
        return this.zzZY.isConnectionFailedListenerRegistered(listener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzZY.registerConnectionCallbacks(listener);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzZY.registerConnectionFailedListener(listener);
    }

    public void stopAutoManage(final FragmentActivity lifecycleActivity) {
        if (this.zzZf >= 0) {
            zzp zza2 = zzp.zza(lifecycleActivity);
            if (zza2 == null) {
                new Handler(this.mContext.getMainLooper()).post(new Runnable() {
                    public void run() {
                        if (!lifecycleActivity.isFinishing() && !lifecycleActivity.getSupportFragmentManager().isDestroyed()) {
                            zzp.zzb(lifecycleActivity).zzbi(zzi.this.zzZf);
                        }
                    }
                });
            } else {
                zza2.zzbi(this.zzZf);
            }
        } else if (this.zzZg >= 0) {
            zzq.zzc(lifecycleActivity).zzbi(this.zzZg);
        } else {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks listener) {
        this.zzZY.unregisterConnectionCallbacks(listener);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener listener) {
        this.zzZY.unregisterConnectionFailedListener(listener);
    }

    public <C extends com.google.android.gms.common.api.Api.zzb> C zza(com.google.android.gms.common.api.Api.zzc<C> zzc2) {
        C c = (com.google.android.gms.common.api.Api.zzb) this.zzaaf.get(zzc2);
        zzx.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.common.api.zzc.zza<R, A>> T zza(T t) {
        zzx.zzb(t.zznd() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        zzx.zzb(this.zzaaf.containsKey(t.zznd()), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        this.zzZs.lock();
        try {
            return this.zzaai.zza(t);
        } finally {
            this.zzZs.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzb zzb2) {
        this.zzaad.sendMessage(this.zzaad.obtainMessage(3, zzb2));
    }

    /* access modifiers changed from: 0000 */
    public void zza(RuntimeException runtimeException) {
        this.zzaad.sendMessage(this.zzaad.obtainMessage(4, runtimeException));
    }

    public boolean zza(Api<?> api) {
        return this.zzaaf.containsKey(api.zznd());
    }

    public boolean zza(Scope scope) {
        this.zzZs.lock();
        try {
            return isConnected() && this.zzaah.contains(scope);
        } finally {
            this.zzZs.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.zzc.zza<? extends Result, A>> T zzb(T t) {
        zzx.zzb(t.zznd() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        this.zzZs.lock();
        try {
            if (zznB()) {
                this.zzZZ.add(t);
                while (!this.zzZZ.isEmpty()) {
                    zze zze2 = (zze) this.zzZZ.remove();
                    zzb(zze2);
                    zze2.zzx(Status.zzaaF);
                }
            } else {
                t = this.zzaai.zzb(t);
                this.zzZs.unlock();
            }
            return t;
        } finally {
            this.zzZs.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public <A extends com.google.android.gms.common.api.Api.zzb> void zzb(zze<A> zze2) {
        this.zzaal.add(zze2);
        zze2.zza(this.zzaam);
    }

    /* access modifiers changed from: 0000 */
    public void zzg(ConnectionResult connectionResult) {
        this.zzZs.lock();
        try {
            this.zzaaj = connectionResult;
            this.zzaai = new zzh(this);
            this.zzaai.begin();
            this.zzZX.signalAll();
        } finally {
            this.zzZs.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zznA() {
        this.zzZs.lock();
        try {
            zznE();
            this.zzaai = new zzf(this);
            this.zzaai.begin();
            this.zzZX.signalAll();
        } finally {
            this.zzZs.unlock();
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zznB() {
        return this.zzaaa;
    }

    /* access modifiers changed from: 0000 */
    public void zznD() {
        if (!zznB()) {
            this.zzaaa = true;
            if (this.zzaae == null) {
                this.zzaae = new zzc(this);
                IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
                intentFilter.addDataScheme("package");
                this.mContext.getApplicationContext().registerReceiver(this.zzaae, intentFilter);
            }
            this.zzaad.sendMessageDelayed(this.zzaad.obtainMessage(1), this.zzaab);
            this.zzaad.sendMessageDelayed(this.zzaad.obtainMessage(2), this.zzaac);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zznE() {
        if (!zznB()) {
            return false;
        }
        this.zzaaa = false;
        this.zzaad.removeMessages(2);
        this.zzaad.removeMessages(1);
        if (this.zzaae != null) {
            this.mContext.getApplicationContext().unregisterReceiver(this.zzaae);
            this.zzaae = null;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void zznx() {
        for (zze zze2 : this.zzaal) {
            zze2.zza(null);
            zze2.cancel();
        }
        this.zzaal.clear();
        for (zzl clear : this.zzaak) {
            clear.clear();
        }
        this.zzaak.clear();
    }

    /* access modifiers changed from: 0000 */
    public void zzny() {
        for (com.google.android.gms.common.api.Api.zzb disconnect : this.zzaaf.values()) {
            disconnect.disconnect();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zznz() {
        this.zzZs.lock();
        try {
            this.zzaai = new zzg(this, this.zzZH, this.zzZI, this.zzZi, this.zzZj, this.zzZs, this.mContext);
            this.zzaai.begin();
            this.zzZX.signalAll();
        } finally {
            this.zzZs.unlock();
        }
    }

    public <L> zzl<L> zzp(L l) {
        zzx.zzb(l, (Object) "Listener must not be null");
        this.zzZs.lock();
        try {
            zzl<L> zzl = new zzl<>(this.zzYV, l);
            this.zzaak.add(zzl);
            return zzl;
        } finally {
            this.zzZs.unlock();
        }
    }
}
