package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrr;
import java.io.IOException;

public abstract class zzrr<M extends zzrr<M>> extends zzrx {
    protected zzrt zzbca;

    /* access modifiers changed from: protected */
    public int zzB() {
        if (this.zzbca == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.zzbca.size(); i2++) {
            i += this.zzbca.zzlB(i2).zzB();
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public final int zzDk() {
        if (this.zzbca == null || this.zzbca.isEmpty()) {
            return 0;
        }
        return this.zzbca.hashCode();
    }

    /* renamed from: zzDl */
    public M zzDm() throws CloneNotSupportedException {
        M m = (zzrr) super.clone();
        zzrv.zza(this, (zzrr) m);
        return m;
    }

    public final <T> T zza(zzrs<M, T> zzrs) {
        if (this.zzbca == null) {
            return null;
        }
        zzru zzlA = this.zzbca.zzlA(zzsa.zzlE(zzrs.tag));
        if (zzlA != null) {
            return zzlA.zzb(zzrs);
        }
        return null;
    }

    public void zza(zzrq zzrq) throws IOException {
        if (this.zzbca != null) {
            for (int i = 0; i < this.zzbca.size(); i++) {
                this.zzbca.zzlB(i).zza(zzrq);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzrp zzrp, int i) throws IOException {
        int position = zzrp.getPosition();
        if (!zzrp.zzlj(i)) {
            return false;
        }
        int zzlE = zzsa.zzlE(i);
        zzrz zzrz = new zzrz(i, zzrp.zzy(position, zzrp.getPosition() - position));
        zzru zzru = null;
        if (this.zzbca == null) {
            this.zzbca = new zzrt();
        } else {
            zzru = this.zzbca.zzlA(zzlE);
        }
        if (zzru == null) {
            zzru = new zzru();
            this.zzbca.zza(zzlE, zzru);
        }
        zzru.zza(zzrz);
        return true;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(M m) {
        return (this.zzbca == null || this.zzbca.isEmpty()) ? m.zzbca == null || m.zzbca.isEmpty() : this.zzbca.equals(m.zzbca);
    }
}
