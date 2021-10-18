package com.google.android.gms.internal;

import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zzgk
public class zzie<T> implements zzih<T> {
    private T zzID = null;
    private boolean zzIE = false;
    private final zzii zzIF = new zzii();
    private final Object zzpc = new Object();
    private boolean zzyg = false;

    public boolean cancel(boolean mayInterruptIfRunning) {
        if (!mayInterruptIfRunning) {
            return false;
        }
        synchronized (this.zzpc) {
            if (this.zzIE) {
                return false;
            }
            this.zzyg = true;
            this.zzIE = true;
            this.zzpc.notifyAll();
            this.zzIF.zzgK();
            return true;
        }
    }

    public T get() {
        T t;
        synchronized (this.zzpc) {
            if (!this.zzIE) {
                try {
                    this.zzpc.wait();
                } catch (InterruptedException e) {
                }
            }
            if (this.zzyg) {
                throw new CancellationException("CallbackFuture was cancelled.");
            }
            t = this.zzID;
        }
        return t;
    }

    public T get(long timeout, TimeUnit unit) throws TimeoutException {
        T t;
        synchronized (this.zzpc) {
            if (!this.zzIE) {
                try {
                    long millis = unit.toMillis(timeout);
                    if (millis != 0) {
                        this.zzpc.wait(millis);
                    }
                } catch (InterruptedException e) {
                }
            }
            if (!this.zzIE) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzyg) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzID;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzyg;
        }
        return z;
    }

    public boolean isDone() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzIE;
        }
        return z;
    }

    public void zzc(Runnable runnable) {
        this.zzIF.zzc(runnable);
    }

    public void zzf(T t) {
        synchronized (this.zzpc) {
            if (this.zzIE) {
                throw new IllegalStateException("Provided CallbackFuture with multiple values.");
            }
            this.zzIE = true;
            this.zzID = t;
            this.zzpc.notifyAll();
            this.zzIF.zzgK();
        }
    }
}
