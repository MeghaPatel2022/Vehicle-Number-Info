package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzrz {
    final int tag;
    final byte[] zzbcm;

    zzrz(int i, byte[] bArr) {
        this.tag = i;
        this.zzbcm = bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzrz)) {
            return false;
        }
        zzrz zzrz = (zzrz) o;
        return this.tag == zzrz.tag && Arrays.equals(this.zzbcm, zzrz.zzbcm);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.zzbcm);
    }

    /* access modifiers changed from: 0000 */
    public int zzB() {
        return 0 + zzrq.zzlx(this.tag) + this.zzbcm.length;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzrq zzrq) throws IOException {
        zzrq.zzlw(this.tag);
        zzrq.zzD(this.zzbcm);
    }
}
