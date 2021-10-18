package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzru implements Cloneable {
    private zzrs<?, ?> zzbch;
    private Object zzbci;
    private List<zzrz> zzbcj = new ArrayList();

    zzru() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzB()];
        zza(zzrq.zzA(bArr));
        return bArr;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof zzru)) {
            return false;
        }
        zzru zzru = (zzru) o;
        if (this.zzbci == null || zzru.zzbci == null) {
            if (this.zzbcj != null && zzru.zzbcj != null) {
                return this.zzbcj.equals(zzru.zzbcj);
            }
            try {
                return Arrays.equals(toByteArray(), zzru.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzbch != zzru.zzbch) {
            return false;
        } else {
            if (!this.zzbch.zzbcb.isArray()) {
                return this.zzbci.equals(zzru.zzbci);
            }
            if (this.zzbci instanceof byte[]) {
                return Arrays.equals((byte[]) this.zzbci, (byte[]) zzru.zzbci);
            }
            if (this.zzbci instanceof int[]) {
                return Arrays.equals((int[]) this.zzbci, (int[]) zzru.zzbci);
            }
            if (this.zzbci instanceof long[]) {
                return Arrays.equals((long[]) this.zzbci, (long[]) zzru.zzbci);
            }
            if (this.zzbci instanceof float[]) {
                return Arrays.equals((float[]) this.zzbci, (float[]) zzru.zzbci);
            }
            if (this.zzbci instanceof double[]) {
                return Arrays.equals((double[]) this.zzbci, (double[]) zzru.zzbci);
            }
            return this.zzbci instanceof boolean[] ? Arrays.equals((boolean[]) this.zzbci, (boolean[]) zzru.zzbci) : Arrays.deepEquals((Object[]) this.zzbci, (Object[]) zzru.zzbci);
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzB() {
        int i = 0;
        if (this.zzbci != null) {
            return this.zzbch.zzS(this.zzbci);
        }
        Iterator it = this.zzbcj.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((zzrz) it.next()).zzB() + i2;
        }
    }

    /* renamed from: zzDo */
    public final zzru clone() {
        zzru zzru = new zzru();
        try {
            zzru.zzbch = this.zzbch;
            if (this.zzbcj == null) {
                zzru.zzbcj = null;
            } else {
                zzru.zzbcj.addAll(this.zzbcj);
            }
            if (this.zzbci != null) {
                if (this.zzbci instanceof zzrx) {
                    zzru.zzbci = ((zzrx) this.zzbci).clone();
                } else if (this.zzbci instanceof byte[]) {
                    zzru.zzbci = ((byte[]) this.zzbci).clone();
                } else if (this.zzbci instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.zzbci;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzru.zzbci = bArr2;
                    for (int i = 0; i < bArr.length; i++) {
                        bArr2[i] = (byte[]) bArr[i].clone();
                    }
                } else if (this.zzbci instanceof boolean[]) {
                    zzru.zzbci = ((boolean[]) this.zzbci).clone();
                } else if (this.zzbci instanceof int[]) {
                    zzru.zzbci = ((int[]) this.zzbci).clone();
                } else if (this.zzbci instanceof long[]) {
                    zzru.zzbci = ((long[]) this.zzbci).clone();
                } else if (this.zzbci instanceof float[]) {
                    zzru.zzbci = ((float[]) this.zzbci).clone();
                } else if (this.zzbci instanceof double[]) {
                    zzru.zzbci = ((double[]) this.zzbci).clone();
                } else if (this.zzbci instanceof zzrx[]) {
                    zzrx[] zzrxArr = (zzrx[]) this.zzbci;
                    zzrx[] zzrxArr2 = new zzrx[zzrxArr.length];
                    zzru.zzbci = zzrxArr2;
                    for (int i2 = 0; i2 < zzrxArr.length; i2++) {
                        zzrxArr2[i2] = zzrxArr[i2].clone();
                    }
                }
            }
            return zzru;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzrq zzrq) throws IOException {
        if (this.zzbci != null) {
            this.zzbch.zza(this.zzbci, zzrq);
            return;
        }
        for (zzrz zza : this.zzbcj) {
            zza.zza(zzrq);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzrz zzrz) {
        this.zzbcj.add(zzrz);
    }

    /* access modifiers changed from: 0000 */
    public <T> T zzb(zzrs<?, T> zzrs) {
        if (this.zzbci == null) {
            this.zzbch = zzrs;
            this.zzbci = zzrs.zzx(this.zzbcj);
            this.zzbcj = null;
        } else if (this.zzbch != zzrs) {
            throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
        }
        return this.zzbci;
    }
}
