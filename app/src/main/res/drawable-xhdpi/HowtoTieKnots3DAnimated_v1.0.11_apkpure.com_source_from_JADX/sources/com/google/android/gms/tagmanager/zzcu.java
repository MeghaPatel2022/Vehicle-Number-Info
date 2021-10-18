package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

class zzcu extends zzct {
    /* access modifiers changed from: private */
    public static final Object zzaRX = new Object();
    private static zzcu zzaSi;
    /* access modifiers changed from: private */
    public boolean connected = true;
    /* access modifiers changed from: private */
    public Handler handler;
    private Context zzaRY;
    /* access modifiers changed from: private */
    public zzau zzaRZ;
    private volatile zzas zzaSa;
    /* access modifiers changed from: private */
    public int zzaSb = 1800000;
    private boolean zzaSc = true;
    private boolean zzaSd = false;
    private boolean zzaSe = true;
    private zzav zzaSf = new zzav() {
        public void zzas(boolean z) {
            zzcu.this.zzd(z, zzcu.this.connected);
        }
    };
    private zzbl zzaSg;
    /* access modifiers changed from: private */
    public boolean zzaSh = false;

    private zzcu() {
    }

    public static zzcu zzAP() {
        if (zzaSi == null) {
            zzaSi = new zzcu();
        }
        return zzaSi;
    }

    private void zzAQ() {
        this.zzaSg = new zzbl(this);
        this.zzaSg.zzaP(this.zzaRY);
    }

    private void zzAR() {
        this.handler = new Handler(this.zzaRY.getMainLooper(), new Callback() {
            public boolean handleMessage(Message msg) {
                if (1 == msg.what && zzcu.zzaRX.equals(msg.obj)) {
                    zzcu.this.dispatch();
                    if (zzcu.this.zzaSb > 0 && !zzcu.this.zzaSh) {
                        zzcu.this.handler.sendMessageDelayed(zzcu.this.handler.obtainMessage(1, zzcu.zzaRX), (long) zzcu.this.zzaSb);
                    }
                }
                return true;
            }
        });
        if (this.zzaSb > 0) {
            this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzaRX), (long) this.zzaSb);
        }
    }

    public synchronized void dispatch() {
        if (!this.zzaSd) {
            zzbg.m29v("Dispatch call queued. Dispatch will run once initialization is complete.");
            this.zzaSc = true;
        } else {
            this.zzaSa.zzg(new Runnable() {
                public void run() {
                    zzcu.this.zzaRZ.dispatch();
                }
            });
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized zzau zzAS() {
        if (this.zzaRZ == null) {
            if (this.zzaRY == null) {
                throw new IllegalStateException("Cant get a store unless we have a context");
            }
            this.zzaRZ = new zzby(this.zzaSf, this.zzaRY);
        }
        if (this.handler == null) {
            zzAR();
        }
        this.zzaSd = true;
        if (this.zzaSc) {
            dispatch();
            this.zzaSc = false;
        }
        if (this.zzaSg == null && this.zzaSe) {
            zzAQ();
        }
        return this.zzaRZ;
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zza(Context context, zzas zzas) {
        if (this.zzaRY == null) {
            this.zzaRY = context.getApplicationContext();
            if (this.zzaSa == null) {
                this.zzaSa = zzas;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzat(boolean z) {
        zzd(this.zzaSh, z);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzd(boolean z, boolean z2) {
        if (!(this.zzaSh == z && this.connected == z2)) {
            if (z || !z2) {
                if (this.zzaSb > 0) {
                    this.handler.removeMessages(1, zzaRX);
                }
            }
            if (!z && z2 && this.zzaSb > 0) {
                this.handler.sendMessageDelayed(this.handler.obtainMessage(1, zzaRX), (long) this.zzaSb);
            }
            zzbg.m29v("PowerSaveMode " + ((z || !z2) ? "initiated." : "terminated."));
            this.zzaSh = z;
            this.connected = z2;
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzhY() {
        if (!this.zzaSh && this.connected && this.zzaSb > 0) {
            this.handler.removeMessages(1, zzaRX);
            this.handler.sendMessage(this.handler.obtainMessage(1, zzaRX));
        }
    }
}
