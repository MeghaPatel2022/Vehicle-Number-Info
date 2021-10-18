package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzob;
import com.google.android.gms.internal.zzoe;
import com.google.android.gms.internal.zzoh;
import java.util.ListIterator;

public class zza extends zzoe<zza> {
    private final zzf zzKa;
    private boolean zzKb;

    public zza(zzf zzf) {
        super(zzf.zzig(), zzf.zzid());
        this.zzKa = zzf;
    }

    public void enableAdvertisingIdCollection(boolean enable) {
        this.zzKb = enable;
    }

    /* access modifiers changed from: protected */
    public void zza(zzob zzob) {
        zzjb zzjb = (zzjb) zzob.zze(zzjb.class);
        if (TextUtils.isEmpty(zzjb.getClientId())) {
            zzjb.setClientId(this.zzKa.zziv().zzjd());
        }
        if (this.zzKb && TextUtils.isEmpty(zzjb.zzhL())) {
            com.google.android.gms.analytics.internal.zza zziu = this.zzKa.zziu();
            zzjb.zzaT(zziu.zzhQ());
            zzjb.zzG(zziu.zzhM());
        }
    }

    public void zzaN(String str) {
        zzx.zzcs(str);
        zzaO(str);
        zzxt().add(new zzb(this.zzKa, str));
    }

    public void zzaO(String str) {
        Uri zzaP = zzb.zzaP(str);
        ListIterator listIterator = zzxt().listIterator();
        while (listIterator.hasNext()) {
            if (zzaP.equals(((zzoh) listIterator.next()).zzhs())) {
                listIterator.remove();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public zzf zzhp() {
        return this.zzKa;
    }

    public zzob zzhq() {
        zzob zzxh = zzxs().zzxh();
        zzxh.zzb(this.zzKa.zzil().zziL());
        zzxh.zzb(this.zzKa.zzim().zzjS());
        zzd(zzxh);
        return zzxh;
    }
}
