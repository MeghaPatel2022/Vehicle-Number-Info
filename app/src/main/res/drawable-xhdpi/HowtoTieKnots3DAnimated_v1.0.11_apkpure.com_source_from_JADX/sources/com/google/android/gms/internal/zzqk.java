package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqo.zza.C1464zza;
import com.google.android.gms.tagmanager.zzbg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzqk {
    private final Context mContext;
    private String zzaPw;
    private final Map<String, zzqz> zzaTA;
    /* access modifiers changed from: private */
    public final zzqr zzaTy;
    Map<String, zzc<com.google.android.gms.internal.zzqp.zzc>> zzaTz;
    private final zzlm zzpO;

    public interface zza {
        void zza(zzqo zzqo);
    }

    class zzb extends zzqx {
        private final zza zzaTE;

        zzb(zzqn zzqn, zzql zzql, zza zza) {
            super(zzqn, zzql);
            this.zzaTE = zza;
        }

        /* access modifiers changed from: protected */
        public com.google.android.gms.internal.zzqx.zzb zza(zzqi zzqi) {
            return null;
        }

        /* access modifiers changed from: protected */
        public void zza(zzqo zzqo) {
            com.google.android.gms.internal.zzqo.zza zzBw = zzqo.zzBw();
            zzqk.this.zza(zzBw);
            if (zzBw.getStatus() != Status.zzaaD || zzBw.zzBx() != C1464zza.NETWORK || zzBw.zzBy() == null || zzBw.zzBy().length <= 0) {
                zzbg.m29v("Response status: " + (zzBw.getStatus().isSuccess() ? "SUCCESS" : "FAILURE"));
                if (zzBw.getStatus().isSuccess()) {
                    zzbg.m29v("Response source: " + zzBw.zzBx().toString());
                    zzbg.m29v("Response size: " + zzBw.zzBy().length);
                }
                zzqk.this.zza(zzBw.zzBz(), this.zzaTE);
                return;
            }
            zzqk.this.zzaTy.zze(zzBw.zzBz().zzBr(), zzBw.zzBy());
            zzbg.m29v("Resource successfully load from Network.");
            this.zzaTE.zza(zzqo);
        }
    }

    static class zzc<T> {
        private T mData;
        private Status zzQA;
        private long zzaTF;

        public zzc(Status status, T t, long j) {
            this.zzQA = status;
            this.mData = t;
            this.zzaTF = j;
        }

        public long zzBu() {
            return this.zzaTF;
        }

        public void zzQ(T t) {
            this.mData = t;
        }

        public void zzU(long j) {
            this.zzaTF = j;
        }

        public void zzbh(Status status) {
            this.zzQA = status;
        }
    }

    public zzqk(Context context) {
        this(context, new HashMap(), new zzqr(context), zzlo.zzpN());
    }

    zzqk(Context context, Map<String, zzqz> map, zzqr zzqr, zzlm zzlm) {
        this.zzaPw = null;
        this.zzaTz = new HashMap();
        this.mContext = context;
        this.zzpO = zzlm;
        this.zzaTy = zzqr;
        this.zzaTA = map;
    }

    private void zza(zzqn zzqn, zza zza2) {
        boolean z = true;
        List zzBv = zzqn.zzBv();
        if (zzBv.size() != 1) {
            z = false;
        }
        zzx.zzZ(z);
        zza((zzqi) zzBv.get(0), zza2);
    }

    /* access modifiers changed from: 0000 */
    public void zza(final zzqi zzqi, final zza zza2) {
        this.zzaTy.zza(zzqi.zzBr(), zzqi.zzBp(), zzqm.zzaTG, new zzqq() {
            public void zza(Status status, Object obj, Integer num, long j) {
                com.google.android.gms.internal.zzqo.zza zza;
                if (status.isSuccess()) {
                    zza = new com.google.android.gms.internal.zzqo.zza(Status.zzaaD, zzqi, null, (com.google.android.gms.internal.zzqp.zzc) obj, num == zzqr.zzaUg ? C1464zza.DEFAULT : C1464zza.DISK, j);
                } else {
                    zza = new com.google.android.gms.internal.zzqo.zza(new Status(16, "There is no valid resource for the container: " + zzqi.getContainerId()), null, C1464zza.DISK);
                }
                zza2.zza(new zzqo(zza));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzqn zzqn, zza zza2, zzqx zzqx) {
        boolean z;
        zzqz zzqz;
        boolean z2 = false;
        Iterator it = zzqn.zzBv().iterator();
        while (true) {
            z = z2;
            if (!it.hasNext()) {
                break;
            }
            zzqi zzqi = (zzqi) it.next();
            zzc zzc2 = (zzc) this.zzaTz.get(zzqi.getContainerId());
            z2 = (zzc2 != null ? zzc2.zzBu() : this.zzaTy.zzfp(zzqi.getContainerId())) + 900000 < this.zzpO.currentTimeMillis() ? true : z;
        }
        if (z) {
            zzqz zzqz2 = (zzqz) this.zzaTA.get(zzqn.getId());
            if (zzqz2 == null) {
                zzqz zzqz3 = this.zzaPw == null ? new zzqz() : new zzqz(this.zzaPw);
                this.zzaTA.put(zzqn.getId(), zzqz3);
                zzqz = zzqz3;
            } else {
                zzqz = zzqz2;
            }
            zzqz.zza(this.mContext, zzqn, 0, zzqx);
            return;
        }
        zza(zzqn, zza2);
    }

    /* access modifiers changed from: 0000 */
    public void zza(com.google.android.gms.internal.zzqo.zza zza2) {
        String containerId = zza2.zzBz().getContainerId();
        Status status = zza2.getStatus();
        com.google.android.gms.internal.zzqp.zzc zzBA = zza2.zzBA();
        if (this.zzaTz.containsKey(containerId)) {
            zzc zzc2 = (zzc) this.zzaTz.get(containerId);
            zzc2.zzU(this.zzpO.currentTimeMillis());
            if (status == Status.zzaaD) {
                zzc2.zzbh(status);
                zzc2.zzQ(zzBA);
                return;
            }
            return;
        }
        this.zzaTz.put(containerId, new zzc(status, zzBA, this.zzpO.currentTimeMillis()));
    }

    public void zza(String str, Integer num, String str2, zza zza2) {
        zzqn zzb2 = new zzqn().zzb(new zzqi(str, num, str2, false));
        zza(zzb2, zza2, new zzb(zzb2, zzqm.zzaTG, zza2));
    }

    public void zzfj(String str) {
        this.zzaPw = str;
    }
}
