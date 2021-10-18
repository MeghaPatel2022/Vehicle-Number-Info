package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqp.zzc;

public class zzqo implements Result {
    private final zza zzaTI;

    public static class zza {
        private final Status zzQA;
        private final C1464zza zzaTJ;
        private final byte[] zzaTK;
        private final long zzaTL;
        private final zzqi zzaTM;
        private final zzc zzaTN;

        /* renamed from: com.google.android.gms.internal.zzqo$zza$zza reason: collision with other inner class name */
        public enum C1464zza {
            NETWORK,
            DISK,
            DEFAULT
        }

        public zza(Status status, zzqi zzqi, C1464zza zza) {
            this(status, zzqi, null, null, zza, 0);
        }

        public zza(Status status, zzqi zzqi, byte[] bArr, zzc zzc, C1464zza zza, long j) {
            this.zzQA = status;
            this.zzaTM = zzqi;
            this.zzaTK = bArr;
            this.zzaTN = zzc;
            this.zzaTJ = zza;
            this.zzaTL = j;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public zzc zzBA() {
            return this.zzaTN;
        }

        public long zzBB() {
            return this.zzaTL;
        }

        public C1464zza zzBx() {
            return this.zzaTJ;
        }

        public byte[] zzBy() {
            return this.zzaTK;
        }

        public zzqi zzBz() {
            return this.zzaTM;
        }
    }

    public zzqo(zza zza2) {
        this.zzaTI = zza2;
    }

    public Status getStatus() {
        return this.zzaTI.getStatus();
    }

    public zza zzBw() {
        return this.zzaTI;
    }
}
