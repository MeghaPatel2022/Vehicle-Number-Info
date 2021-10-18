package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoe;
import java.util.ArrayList;
import java.util.List;

public abstract class zzoe<T extends zzoe> {
    private final zzof zzaIa;
    protected final zzob zzaIb;
    private final List<zzoc> zzaIc = new ArrayList();

    protected zzoe(zzof zzof, zzlm zzlm) {
        zzx.zzv(zzof);
        this.zzaIa = zzof;
        zzob zzob = new zzob(this, zzlm);
        zzob.zzxr();
        this.zzaIb = zzob;
    }

    /* access modifiers changed from: protected */
    public void zza(zzob zzob) {
    }

    /* access modifiers changed from: protected */
    public void zzd(zzob zzob) {
        for (zzoc zza : this.zzaIc) {
            zza.zza(this, zzob);
        }
    }

    public zzob zzhq() {
        zzob zzxh = this.zzaIb.zzxh();
        zzd(zzxh);
        return zzxh;
    }

    /* access modifiers changed from: protected */
    public zzof zzxp() {
        return this.zzaIa;
    }

    public zzob zzxs() {
        return this.zzaIb;
    }

    public List<zzoh> zzxt() {
        return this.zzaIb.zzxj();
    }
}
