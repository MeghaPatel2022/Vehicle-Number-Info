package com.google.android.gms.common.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.PendingResult.BatchCallback;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzb<R extends Result> implements PendingResult<R> {
    private boolean zzL;
    private final Object zzYD = new Object();
    protected final zza<R> zzYE;
    private final ArrayList<BatchCallback> zzYF = new ArrayList<>();
    private ResultCallback<R> zzYG;
    private volatile R zzYH;
    private volatile boolean zzYI;
    private boolean zzYJ;
    private zzq zzYK;
    private final CountDownLatch zzoR = new CountDownLatch(1);

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzb) msg.obj).zzw(Status.zzaaG);
                    return;
                default:
                    Log.wtf("AbstractPendingResult", "Don't know how to handle this message.");
                    return;
            }
        }

        public void zza(ResultCallback<R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzb<R> zzb, long j) {
            sendMessageDelayed(obtainMessage(2, zzb), j);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzb.zzc(r);
                throw e;
            }
        }

        public void zzna() {
            removeMessages(2);
        }
    }

    protected zzb(Looper looper) {
        this.zzYE = new zza<>(looper);
    }

    protected zzb(zza<R> zza2) {
        this.zzYE = (zza) zzx.zzb(zza2, (Object) "CallbackHandler must not be null");
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.zzYD) {
            if (this.zzYI) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed.");
            zzx.zza(isReady(), (Object) "Result is not ready.");
            r = this.zzYH;
            this.zzYH = null;
            this.zzYG = null;
            this.zzYI = true;
        }
        zzmZ();
        return r;
    }

    private void zzb(R r) {
        this.zzYH = r;
        this.zzYK = null;
        this.zzoR.countDown();
        Status status = this.zzYH.getStatus();
        if (this.zzYG != null) {
            this.zzYE.zzna();
            if (!this.zzL) {
                this.zzYE.zza(this.zzYG, get());
            }
        }
        Iterator it = this.zzYF.iterator();
        while (it.hasNext()) {
            ((BatchCallback) it.next()).onComplete(status);
        }
        this.zzYF.clear();
    }

    static void zzc(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("AbstractPendingResult", "Unable to release " + result, e);
            }
        }
    }

    public final void addBatchCallback(BatchCallback callback) {
        zzx.zza(!this.zzYI, (Object) "Result has already been consumed.");
        synchronized (this.zzYD) {
            if (isReady()) {
                callback.onComplete(this.zzYH.getStatus());
            } else {
                this.zzYF.add(callback);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzx.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        if (this.zzYI) {
            z = false;
        }
        zzx.zza(z, (Object) "Result has already been consumed");
        try {
            this.zzoR.await();
        } catch (InterruptedException e) {
            zzw(Status.zzaaE);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long time, TimeUnit units) {
        boolean z = true;
        zzx.zza(time <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        if (this.zzYI) {
            z = false;
        }
        zzx.zza(z, (Object) "Result has already been consumed.");
        try {
            if (!this.zzoR.await(time, units)) {
                zzw(Status.zzaaG);
            }
        } catch (InterruptedException e) {
            zzw(Status.zzaaE);
        }
        zzx.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r1 = r2.zzYD
            monitor-enter(r1)
            boolean r0 = r2.zzL     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.zzYI     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.common.internal.zzq r0 = r2.zzYK     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.common.internal.zzq r0 = r2.zzYK     // Catch:{ RemoteException -> 0x002f }
            r0.cancel()     // Catch:{ RemoteException -> 0x002f }
        L_0x0016:
            R r0 = r2.zzYH     // Catch:{ all -> 0x002c }
            zzc(r0)     // Catch:{ all -> 0x002c }
            r0 = 0
            r2.zzYG = r0     // Catch:{ all -> 0x002c }
            r0 = 1
            r2.zzL = r0     // Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.zzaaH     // Catch:{ all -> 0x002c }
            com.google.android.gms.common.api.Result r0 = r2.zzb(r0)     // Catch:{ all -> 0x002c }
            r2.zzb((R) r0)     // Catch:{ all -> 0x002c }
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            goto L_0x000c
        L_0x002c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002c }
            throw r0
        L_0x002f:
            r0 = move-exception
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzb.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzYD) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzoR.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r4) {
        /*
            r3 = this;
            boolean r0 = r3.zzYI
            if (r0 != 0) goto L_0x0015
            r0 = 1
        L_0x0005:
            java.lang.String r1 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzx.zza(r0, r1)
            java.lang.Object r1 = r3.zzYD
            monitor-enter(r1)
            boolean r0 = r3.isCanceled()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
        L_0x0014:
            return
        L_0x0015:
            r0 = 0
            goto L_0x0005
        L_0x0017:
            boolean r0 = r3.isReady()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.common.api.zzb$zza<R> r0 = r3.zzYE     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.Result r2 = r3.get()     // Catch:{ all -> 0x0028 }
            r0.zza(r4, r2)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x0014
        L_0x0028:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x002b:
            r3.zzYG = r4     // Catch:{ all -> 0x0028 }
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzb.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<R> r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            boolean r0 = r4.zzYI
            if (r0 != 0) goto L_0x0015
            r0 = 1
        L_0x0005:
            java.lang.String r1 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzx.zza(r0, r1)
            java.lang.Object r1 = r4.zzYD
            monitor-enter(r1)
            boolean r0 = r4.isCanceled()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x0017
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
        L_0x0014:
            return
        L_0x0015:
            r0 = 0
            goto L_0x0005
        L_0x0017:
            boolean r0 = r4.isReady()     // Catch:{ all -> 0x0028 }
            if (r0 == 0) goto L_0x002b
            com.google.android.gms.common.api.zzb$zza<R> r0 = r4.zzYE     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.Result r2 = r4.get()     // Catch:{ all -> 0x0028 }
            r0.zza(r5, r2)     // Catch:{ all -> 0x0028 }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            goto L_0x0014
        L_0x0028:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0028 }
            throw r0
        L_0x002b:
            r4.zzYG = r5     // Catch:{ all -> 0x0028 }
            com.google.android.gms.common.api.zzb$zza<R> r0 = r4.zzYE     // Catch:{ all -> 0x0028 }
            long r2 = r8.toMillis(r6)     // Catch:{ all -> 0x0028 }
            r0.zza(r4, r2)     // Catch:{ all -> 0x0028 }
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzb.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public final void zza(R r) {
        boolean z = true;
        synchronized (this.zzYD) {
            if (this.zzYJ || this.zzL) {
                zzc(r);
                return;
            }
            zzx.zza(!isReady(), (Object) "Results have already been set");
            if (this.zzYI) {
                z = false;
            }
            zzx.zza(z, (Object) "Result has already been consumed");
            zzb(r);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzq zzq) {
        synchronized (this.zzYD) {
            this.zzYK = zzq;
        }
    }

    /* access modifiers changed from: protected */
    public abstract R zzb(Status status);

    /* access modifiers changed from: protected */
    public void zzmZ() {
    }

    public final void zzw(Status status) {
        synchronized (this.zzYD) {
            if (!isReady()) {
                zza((R) zzb(status));
                this.zzYJ = true;
            }
        }
    }
}
