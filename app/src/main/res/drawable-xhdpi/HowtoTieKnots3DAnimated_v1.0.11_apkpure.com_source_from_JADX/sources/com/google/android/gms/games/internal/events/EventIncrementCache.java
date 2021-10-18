package com.google.android.gms.games.internal.events;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class EventIncrementCache {
    final Object zzawC = new Object();
    private Handler zzawD;
    private boolean zzawE;
    private HashMap<String, AtomicInteger> zzawF;
    private int zzawG;

    public EventIncrementCache(Looper looper, int flushIntervalMillis) {
        this.zzawD = new Handler(looper);
        this.zzawF = new HashMap<>();
        this.zzawG = flushIntervalMillis;
    }

    /* access modifiers changed from: private */
    public void zzut() {
        synchronized (this.zzawC) {
            this.zzawE = false;
            flush();
        }
    }

    public void flush() {
        synchronized (this.zzawC) {
            for (Entry entry : this.zzawF.entrySet()) {
                zzt((String) entry.getKey(), ((AtomicInteger) entry.getValue()).get());
            }
            this.zzawF.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzt(String str, int i);

    public void zzx(String str, int i) {
        synchronized (this.zzawC) {
            if (!this.zzawE) {
                this.zzawE = true;
                this.zzawD.postDelayed(new Runnable() {
                    public void run() {
                        EventIncrementCache.this.zzut();
                    }
                }, (long) this.zzawG);
            }
            AtomicInteger atomicInteger = (AtomicInteger) this.zzawF.get(str);
            if (atomicInteger == null) {
                atomicInteger = new AtomicInteger();
                this.zzawF.put(str, atomicInteger);
            }
            atomicInteger.addAndGet(i);
        }
    }
}
