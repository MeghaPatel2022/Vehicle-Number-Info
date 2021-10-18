package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class zzob {
    private final zzoe zzaHQ;
    private boolean zzaHR;
    private long zzaHS;
    private long zzaHT;
    private long zzaHU;
    private long zzaHV;
    private long zzaHW;
    private boolean zzaHX;
    private final Map<Class<? extends zzod>, zzod> zzaHY;
    private final List<zzoh> zzaHZ;
    private final zzlm zzpO;

    zzob(zzob zzob) {
        this.zzaHQ = zzob.zzaHQ;
        this.zzpO = zzob.zzpO;
        this.zzaHS = zzob.zzaHS;
        this.zzaHT = zzob.zzaHT;
        this.zzaHU = zzob.zzaHU;
        this.zzaHV = zzob.zzaHV;
        this.zzaHW = zzob.zzaHW;
        this.zzaHZ = new ArrayList(zzob.zzaHZ);
        this.zzaHY = new HashMap(zzob.zzaHY.size());
        for (Entry entry : zzob.zzaHY.entrySet()) {
            zzod zzf = zzf((Class) entry.getKey());
            ((zzod) entry.getValue()).zza(zzf);
            this.zzaHY.put(entry.getKey(), zzf);
        }
    }

    zzob(zzoe zzoe, zzlm zzlm) {
        zzx.zzv(zzoe);
        zzx.zzv(zzlm);
        this.zzaHQ = zzoe;
        this.zzpO = zzlm;
        this.zzaHV = 1800000;
        this.zzaHW = 3024000000L;
        this.zzaHY = new HashMap();
        this.zzaHZ = new ArrayList();
    }

    private static <T extends zzod> T zzf(Class<T> cls) {
        try {
            return (zzod) cls.newInstance();
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public void zzL(long j) {
        this.zzaHT = j;
    }

    public void zzb(zzod zzod) {
        zzx.zzv(zzod);
        Class cls = zzod.getClass();
        if (cls.getSuperclass() != zzod.class) {
            throw new IllegalArgumentException();
        }
        zzod.zza(zze(cls));
    }

    public <T extends zzod> T zzd(Class<T> cls) {
        return (zzod) this.zzaHY.get(cls);
    }

    public <T extends zzod> T zze(Class<T> cls) {
        T t = (zzod) this.zzaHY.get(cls);
        if (t != null) {
            return t;
        }
        T zzf = zzf(cls);
        this.zzaHY.put(cls, zzf);
        return zzf;
    }

    public zzob zzxh() {
        return new zzob(this);
    }

    public Collection<zzod> zzxi() {
        return this.zzaHY.values();
    }

    public List<zzoh> zzxj() {
        return this.zzaHZ;
    }

    public long zzxk() {
        return this.zzaHS;
    }

    public void zzxl() {
        zzxp().zze(this);
    }

    public boolean zzxm() {
        return this.zzaHR;
    }

    /* access modifiers changed from: 0000 */
    public void zzxn() {
        this.zzaHU = this.zzpO.elapsedRealtime();
        if (this.zzaHT != 0) {
            this.zzaHS = this.zzaHT;
        } else {
            this.zzaHS = this.zzpO.currentTimeMillis();
        }
        this.zzaHR = true;
    }

    /* access modifiers changed from: 0000 */
    public zzoe zzxo() {
        return this.zzaHQ;
    }

    /* access modifiers changed from: 0000 */
    public zzof zzxp() {
        return this.zzaHQ.zzxp();
    }

    /* access modifiers changed from: 0000 */
    public boolean zzxq() {
        return this.zzaHX;
    }

    /* access modifiers changed from: 0000 */
    public void zzxr() {
        this.zzaHX = true;
    }
}
