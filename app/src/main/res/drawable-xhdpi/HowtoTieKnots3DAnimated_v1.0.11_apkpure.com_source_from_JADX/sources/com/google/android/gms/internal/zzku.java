package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import com.google.android.gms.common.internal.zzw;

public final class zzku extends zzlf<zza, Drawable> {

    public static final class zza {
        public final int zzacA;
        public final int zzacz;

        public zza(int i, int i2) {
            this.zzacz = i;
            this.zzacA = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zza zza = (zza) obj;
            return zza.zzacz == this.zzacz && zza.zzacA == this.zzacA;
        }

        public int hashCode() {
            return zzw.hashCode(Integer.valueOf(this.zzacz), Integer.valueOf(this.zzacA));
        }
    }

    public zzku() {
        super(10);
    }
}
