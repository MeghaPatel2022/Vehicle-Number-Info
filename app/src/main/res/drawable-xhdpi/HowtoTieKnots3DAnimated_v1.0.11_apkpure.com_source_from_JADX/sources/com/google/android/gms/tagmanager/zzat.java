package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class zzat extends Thread implements zzas {
    private static zzat zzaQj;
    private volatile boolean mClosed = false;
    /* access modifiers changed from: private */
    public final Context mContext;
    private volatile boolean zzMT = false;
    private final LinkedBlockingQueue<Runnable> zzaQi = new LinkedBlockingQueue<>();
    /* access modifiers changed from: private */
    public volatile zzau zzaQk;

    private zzat(Context context) {
        super("GAThread");
        if (context != null) {
            this.mContext = context.getApplicationContext();
        } else {
            this.mContext = context;
        }
        start();
    }

    static zzat zzaO(Context context) {
        if (zzaQj == null) {
            zzaQj = new zzat(context);
        }
        return zzaQj;
    }

    private String zzd(Throwable th) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        th.printStackTrace(printStream);
        printStream.flush();
        return new String(byteArrayOutputStream.toByteArray());
    }

    public void run() {
        while (!this.mClosed) {
            try {
                Runnable runnable = (Runnable) this.zzaQi.take();
                if (!this.zzMT) {
                    runnable.run();
                }
            } catch (InterruptedException e) {
                zzbg.zzaD(e.toString());
            } catch (Throwable th) {
                zzbg.m28e("Error on Google TagManager Thread: " + zzd(th));
                zzbg.m28e("Google TagManager is shutting down.");
                this.zzMT = true;
            }
        }
    }

    public void zzeL(String str) {
        zzh(str, System.currentTimeMillis());
    }

    public void zzg(Runnable runnable) {
        this.zzaQi.add(runnable);
    }

    /* access modifiers changed from: 0000 */
    public void zzh(String str, long j) {
        final long j2 = j;
        final String str2 = str;
        zzg(new Runnable() {
            public void run() {
                if (zzat.this.zzaQk == null) {
                    zzcu zzAP = zzcu.zzAP();
                    zzAP.zza(zzat.this.mContext, this);
                    zzat.this.zzaQk = zzAP.zzAS();
                }
                zzat.this.zzaQk.zzg(j2, str2);
            }
        });
    }
}
