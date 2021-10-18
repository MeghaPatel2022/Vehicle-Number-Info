package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tagmanager.ContainerHolder.ContainerAvailableListener;

class zzo implements ContainerHolder {
    private Status zzQA;
    private final Looper zzYV;
    private Container zzaPa;
    private Container zzaPb;
    private zzb zzaPc;
    private zza zzaPd;
    private TagManager zzaPe;
    private boolean zzahz;

    public interface zza {
        void zzey(String str);

        String zzzE();

        void zzzG();
    }

    private class zzb extends Handler {
        private final ContainerAvailableListener zzaPf;

        public zzb(ContainerAvailableListener containerAvailableListener, Looper looper) {
            super(looper);
            this.zzaPf = containerAvailableListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    zzeA((String) msg.obj);
                    return;
                default:
                    zzbg.m28e("Don't know how to handle this message.");
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public void zzeA(String str) {
            this.zzaPf.onContainerAvailable(zzo.this, str);
        }

        public void zzez(String str) {
            sendMessage(obtainMessage(1, str));
        }
    }

    public zzo(Status status) {
        this.zzQA = status;
        this.zzYV = null;
    }

    public zzo(TagManager tagManager, Looper looper, Container container, zza zza2) {
        this.zzaPe = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzYV = looper;
        this.zzaPa = container;
        this.zzaPd = zza2;
        this.zzQA = Status.zzaaD;
        tagManager.zza(this);
    }

    private void zzzF() {
        if (this.zzaPc != null) {
            this.zzaPc.zzez(this.zzaPb.zzzC());
        }
    }

    public synchronized Container getContainer() {
        Container container = null;
        synchronized (this) {
            if (this.zzahz) {
                zzbg.m28e("ContainerHolder is released.");
            } else {
                if (this.zzaPb != null) {
                    this.zzaPa = this.zzaPb;
                    this.zzaPb = null;
                }
                container = this.zzaPa;
            }
        }
        return container;
    }

    /* access modifiers changed from: 0000 */
    public String getContainerId() {
        if (!this.zzahz) {
            return this.zzaPa.getContainerId();
        }
        zzbg.m28e("getContainerId called on a released ContainerHolder.");
        return "";
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public synchronized void refresh() {
        if (this.zzahz) {
            zzbg.m28e("Refreshing a released ContainerHolder.");
        } else {
            this.zzaPd.zzzG();
        }
    }

    public synchronized void release() {
        if (this.zzahz) {
            zzbg.m28e("Releasing a released ContainerHolder.");
        } else {
            this.zzahz = true;
            this.zzaPe.zzb(this);
            this.zzaPa.release();
            this.zzaPa = null;
            this.zzaPb = null;
            this.zzaPd = null;
            this.zzaPc = null;
        }
    }

    public synchronized void setContainerAvailableListener(ContainerAvailableListener listener) {
        if (this.zzahz) {
            zzbg.m28e("ContainerHolder is released.");
        } else if (listener == null) {
            this.zzaPc = null;
        } else {
            this.zzaPc = new zzb(listener, this.zzYV);
            if (this.zzaPb != null) {
                zzzF();
            }
        }
    }

    public synchronized void zza(Container container) {
        if (!this.zzahz) {
            if (container == null) {
                zzbg.m28e("Unexpected null container.");
            } else {
                this.zzaPb = container;
                zzzF();
            }
        }
    }

    public synchronized void zzew(String str) {
        if (!this.zzahz) {
            this.zzaPa.zzew(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzey(String str) {
        if (this.zzahz) {
            zzbg.m28e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        } else {
            this.zzaPd.zzey(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public String zzzE() {
        if (!this.zzahz) {
            return this.zzaPd.zzzE();
        }
        zzbg.m28e("setCtfeUrlPathAndQuery called on a released ContainerHolder.");
        return "";
    }
}
