package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@zzgk
public class zzbi {
    private final Object zzpc = new Object();
    private int zzrM;
    private List<zzbh> zzrN = new LinkedList();

    public boolean zza(zzbh zzbh) {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzrN.contains(zzbh);
        }
        return z;
    }

    public boolean zzb(zzbh zzbh) {
        boolean z;
        synchronized (this.zzpc) {
            Iterator it = this.zzrN.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                zzbh zzbh2 = (zzbh) it.next();
                if (zzbh != zzbh2 && zzbh2.zzcm().equals(zzbh.zzcm())) {
                    it.remove();
                    z = true;
                    break;
                }
            }
        }
        return z;
    }

    public void zzc(zzbh zzbh) {
        synchronized (this.zzpc) {
            if (this.zzrN.size() >= 10) {
                zzb.zzaC("Queue is full, current size = " + this.zzrN.size());
                this.zzrN.remove(0);
            }
            int i = this.zzrM;
            this.zzrM = i + 1;
            zzbh.zzg(i);
            this.zzrN.add(zzbh);
        }
    }

    public zzbh zzcs() {
        int i;
        zzbh zzbh;
        zzbh zzbh2 = null;
        synchronized (this.zzpc) {
            if (this.zzrN.size() == 0) {
                zzb.zzaC("Queue empty");
                return null;
            } else if (this.zzrN.size() >= 2) {
                int i2 = Integer.MIN_VALUE;
                for (zzbh zzbh3 : this.zzrN) {
                    int score = zzbh3.getScore();
                    if (score > i2) {
                        int i3 = score;
                        zzbh = zzbh3;
                        i = i3;
                    } else {
                        i = i2;
                        zzbh = zzbh2;
                    }
                    i2 = i;
                    zzbh2 = zzbh;
                }
                this.zzrN.remove(zzbh2);
                return zzbh2;
            } else {
                zzbh zzbh4 = (zzbh) this.zzrN.get(0);
                zzbh4.zzcn();
                return zzbh4;
            }
        }
    }
}
