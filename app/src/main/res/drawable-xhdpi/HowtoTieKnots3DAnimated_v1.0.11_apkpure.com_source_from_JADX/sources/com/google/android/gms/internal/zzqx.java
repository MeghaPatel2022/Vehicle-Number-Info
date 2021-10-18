package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqo.zza.C1464zza;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqp.zzg;
import com.google.android.gms.tagmanager.zzbg;

public abstract class zzqx {
    private zzqn zzaUo;
    private zzql zzaUp;
    private zzlm zzpO;

    public enum zza {
        NOT_AVAILABLE,
        IO_ERROR,
        SERVER_ERROR
    }

    public class zzb {
        private final C1464zza zzaTJ;
        private final long zzaTL;
        private final Object zzaUu;

        public long zzBB() {
            return this.zzaTL;
        }

        public Object zzBX() {
            return this.zzaUu;
        }

        public C1464zza zzBx() {
            return this.zzaTJ;
        }
    }

    public zzqx(zzqn zzqn, zzql zzql) {
        this(zzqn, zzql, zzlo.zzpN());
    }

    public zzqx(zzqn zzqn, zzql zzql, zzlm zzlm) {
        boolean z = true;
        if (zzqn.zzBv().size() != 1) {
            z = false;
        }
        zzx.zzZ(z);
        this.zzaUo = zzqn;
        this.zzaUp = zzql;
        this.zzpO = zzlm;
    }

    /* access modifiers changed from: protected */
    public abstract zzb zza(zzqi zzqi);

    /* access modifiers changed from: protected */
    public abstract void zza(zzqo zzqo);

    public void zza(zza zza2) {
        zzbg.m28e("ResourceManager: Failed to download a resource: " + zza2.name());
        zzqi zzqi = (zzqi) this.zzaUo.zzBv().get(0);
        zzb zza3 = zza(zzqi);
        zza(new zzqo((zza3 == null || !(zza3.zzBX() instanceof zzc)) ? new com.google.android.gms.internal.zzqo.zza(Status.zzaaF, zzqi, C1464zza.NETWORK) : new com.google.android.gms.internal.zzqo.zza(Status.zzaaD, zzqi, null, (zzc) zza3.zzBX(), zza3.zzBx(), zza3.zzBB())));
    }

    public void zzu(byte[] bArr) {
        long j;
        C1464zza zza2;
        Object obj;
        com.google.android.gms.internal.zzqo.zza zza3;
        zzbg.m29v("ResourceManager: Resource downloaded from Network: " + this.zzaUo.getId());
        zzqi zzqi = (zzqi) this.zzaUo.zzBv().get(0);
        C1464zza zza4 = C1464zza.NETWORK;
        try {
            Object zzt = this.zzaUp.zzt(bArr);
            long currentTimeMillis = this.zzpO.currentTimeMillis();
            if (zzt == null) {
                zzbg.zzaD("Parsed resource from network is null");
                zzb zza5 = zza(zzqi);
                if (zza5 != null) {
                    zzt = zza5.zzBX();
                    zza4 = zza5.zzBx();
                    currentTimeMillis = zza5.zzBB();
                }
            }
            j = currentTimeMillis;
            zza2 = zza4;
            obj = zzt;
        } catch (zzg e) {
            zzbg.zzaD("Resource from network is corrupted");
            zzb zza6 = zza(zzqi);
            if (zza6 != null) {
                Object zzBX = zza6.zzBX();
                j = 0;
                zza2 = zza6.zzBx();
                obj = zzBX;
            } else {
                j = 0;
                zza2 = zza4;
                obj = null;
            }
        }
        if (obj != null) {
            zza3 = new com.google.android.gms.internal.zzqo.zza(Status.zzaaD, zzqi, bArr, (zzc) obj, zza2, j);
        } else {
            zza3 = new com.google.android.gms.internal.zzqo.zza(Status.zzaaF, zzqi, C1464zza.NETWORK);
        }
        zza(new zzqo(zza3));
    }
}
