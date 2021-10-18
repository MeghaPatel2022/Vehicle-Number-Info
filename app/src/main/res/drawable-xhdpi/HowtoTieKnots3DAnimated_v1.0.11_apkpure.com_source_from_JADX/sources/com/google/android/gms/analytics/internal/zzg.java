package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzof;

public class zzg {
    private final Context zzLR;
    private final Context zzqO;

    public zzg(Context context) {
        zzx.zzv(context);
        Context applicationContext = context.getApplicationContext();
        zzx.zzb(applicationContext, (Object) "Application context can't be null");
        this.zzqO = applicationContext;
        this.zzLR = applicationContext;
    }

    public Context getApplicationContext() {
        return this.zzqO;
    }

    /* access modifiers changed from: protected */
    public zzof zzY(Context context) {
        return zzof.zzaI(context);
    }

    /* access modifiers changed from: protected */
    public zzu zza(zzf zzf) {
        return new zzu(zzf);
    }

    /* access modifiers changed from: protected */
    public zzk zzb(zzf zzf) {
        return new zzk(zzf);
    }

    /* access modifiers changed from: protected */
    public zza zzc(zzf zzf) {
        return new zza(zzf);
    }

    /* access modifiers changed from: protected */
    public zzn zzd(zzf zzf) {
        return new zzn(zzf);
    }

    /* access modifiers changed from: protected */
    public zzan zze(zzf zzf) {
        return new zzan(zzf);
    }

    /* access modifiers changed from: protected */
    public zzaf zzf(zzf zzf) {
        return new zzaf(zzf);
    }

    /* access modifiers changed from: protected */
    public zzr zzg(zzf zzf) {
        return new zzr(zzf);
    }

    /* access modifiers changed from: protected */
    public zzlm zzh(zzf zzf) {
        return zzlo.zzpN();
    }

    /* access modifiers changed from: protected */
    public GoogleAnalytics zzi(zzf zzf) {
        return new GoogleAnalytics(zzf);
    }

    public Context zziq() {
        return this.zzLR;
    }

    /* access modifiers changed from: 0000 */
    public zzl zzj(zzf zzf) {
        return new zzl(zzf, this);
    }

    /* access modifiers changed from: 0000 */
    public zzag zzk(zzf zzf) {
        return new zzag(zzf);
    }

    /* access modifiers changed from: protected */
    public zzb zzl(zzf zzf) {
        return new zzb(zzf, this);
    }

    public zzj zzm(zzf zzf) {
        return new zzj(zzf);
    }

    public zzah zzn(zzf zzf) {
        return new zzah(zzf);
    }

    public zzi zzo(zzf zzf) {
        return new zzi(zzf);
    }

    public zzv zzp(zzf zzf) {
        return new zzv(zzf);
    }

    public zzai zzq(zzf zzf) {
        return new zzai(zzf);
    }
}
