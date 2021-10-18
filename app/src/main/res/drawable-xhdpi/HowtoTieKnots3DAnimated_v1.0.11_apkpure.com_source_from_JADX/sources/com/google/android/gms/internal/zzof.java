package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzof {
    private static volatile zzof zzaId;
    private final Context mContext;
    private volatile zzok zzMm;
    /* access modifiers changed from: private */
    public final List<zzog> zzaIe = new CopyOnWriteArrayList();
    private final zzoa zzaIf = new zzoa();
    private final zza zzaIg = new zza();
    /* access modifiers changed from: private */
    public UncaughtExceptionHandler zzaIh;

    private class zza extends ThreadPoolExecutor {
        public zza() {
            super(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new zzb());
        }

        /* access modifiers changed from: protected */
        public <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
            return new FutureTask<T>(runnable, value) {
                /* access modifiers changed from: protected */
                public void setException(Throwable error) {
                    UncaughtExceptionHandler zzb = zzof.this.zzaIh;
                    if (zzb != null) {
                        zzb.uncaughtException(Thread.currentThread(), error);
                    } else if (Log.isLoggable("GAv4", 6)) {
                        Log.e("GAv4", "MeasurementExecutor: job failed with " + error);
                    }
                    super.setException(error);
                }
            };
        }
    }

    private static class zzb implements ThreadFactory {
        private static final AtomicInteger zzaIl = new AtomicInteger();

        private zzb() {
        }

        public Thread newThread(Runnable target) {
            return new zzc(target, "measurement-" + zzaIl.incrementAndGet());
        }
    }

    private static class zzc extends Thread {
        zzc(Runnable runnable, String str) {
            super(runnable, str);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    zzof(Context context) {
        Context applicationContext = context.getApplicationContext();
        zzx.zzv(applicationContext);
        this.mContext = applicationContext;
    }

    public static zzof zzaI(Context context) {
        zzx.zzv(context);
        if (zzaId == null) {
            synchronized (zzof.class) {
                if (zzaId == null) {
                    zzaId = new zzof(context);
                }
            }
        }
        return zzaId;
    }

    /* access modifiers changed from: private */
    public void zzb(zzob zzob) {
        zzx.zzci("deliver should be called from worker thread");
        zzx.zzb(zzob.zzxm(), (Object) "Measurement must be submitted");
        List<zzoh> zzxj = zzob.zzxj();
        if (!zzxj.isEmpty()) {
            HashSet hashSet = new HashSet();
            for (zzoh zzoh : zzxj) {
                Uri zzhs = zzoh.zzhs();
                if (!hashSet.contains(zzhs)) {
                    hashSet.add(zzhs);
                    zzoh.zzb(zzob);
                }
            }
        }
    }

    public static void zzic() {
        if (!(Thread.currentThread() instanceof zzc)) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public void zza(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.zzaIh = uncaughtExceptionHandler;
    }

    public <V> Future<V> zzb(Callable<V> callable) {
        zzx.zzv(callable);
        if (!(Thread.currentThread() instanceof zzc)) {
            return this.zzaIg.submit(callable);
        }
        FutureTask futureTask = new FutureTask(callable);
        futureTask.run();
        return futureTask;
    }

    /* access modifiers changed from: 0000 */
    public void zze(zzob zzob) {
        if (zzob.zzxq()) {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        } else if (zzob.zzxm()) {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else {
            final zzob zzxh = zzob.zzxh();
            zzxh.zzxn();
            this.zzaIg.execute(new Runnable() {
                public void run() {
                    zzxh.zzxo().zza(zzxh);
                    for (zzog zza : zzof.this.zzaIe) {
                        zza.zza(zzxh);
                    }
                    zzof.this.zzb(zzxh);
                }
            });
        }
    }

    public void zzf(Runnable runnable) {
        zzx.zzv(runnable);
        this.zzaIg.submit(runnable);
    }

    public zzok zzxu() {
        if (this.zzMm == null) {
            synchronized (this) {
                if (this.zzMm == null) {
                    zzok zzok = new zzok();
                    PackageManager packageManager = this.mContext.getPackageManager();
                    String packageName = this.mContext.getPackageName();
                    zzok.setAppId(packageName);
                    zzok.setAppInstallerId(packageManager.getInstallerPackageName(packageName));
                    String str = null;
                    try {
                        PackageInfo packageInfo = packageManager.getPackageInfo(this.mContext.getPackageName(), 0);
                        if (packageInfo != null) {
                            CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                            if (!TextUtils.isEmpty(applicationLabel)) {
                                packageName = applicationLabel.toString();
                            }
                            str = packageInfo.versionName;
                        }
                    } catch (NameNotFoundException e) {
                        Log.e("GAv4", "Error retrieving package info: appName set to " + packageName);
                    }
                    zzok.setAppName(packageName);
                    zzok.setAppVersion(str);
                    this.zzMm = zzok;
                }
            }
        }
        return this.zzMm;
    }

    public zzom zzxv() {
        DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
        zzom zzom = new zzom();
        zzom.setLanguage(zzam.zza(Locale.getDefault()));
        zzom.zzhO(displayMetrics.widthPixels);
        zzom.zzhP(displayMetrics.heightPixels);
        return zzom;
    }
}
