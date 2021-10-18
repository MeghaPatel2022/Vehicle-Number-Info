package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzof;

public class zzc {
    private final zzf zzLy;

    protected zzc(zzf zzf) {
        zzx.zzv(zzf);
        this.zzLy = zzf;
    }

    private void zza(int i, String str, Object obj, Object obj2, Object obj3) {
        zzaf zzaf = null;
        if (this.zzLy != null) {
            zzaf = this.zzLy.zzir();
        }
        if (zzaf != null) {
            zzaf.zza(i, str, obj, obj2, obj3);
            return;
        }
        String str2 = (String) zzy.zzNa.get();
        if (Log.isLoggable(str2, i)) {
            Log.println(i, str2, zzc(str, obj, obj2, obj3));
        }
    }

    protected static String zzc(String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zzi = zzi(obj);
        String zzi2 = zzi(obj2);
        String zzi3 = zzi(obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zzi)) {
            sb.append(str2);
            sb.append(zzi);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzi2)) {
            sb.append(str2);
            sb.append(zzi2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zzi3)) {
            sb.append(str2);
            sb.append(zzi3);
            String str3 = ", ";
        }
        return sb.toString();
    }

    private static String zzi(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof Boolean)) {
            return obj instanceof Throwable ? ((Throwable) obj).toString() : obj.toString();
        }
        return obj == Boolean.TRUE ? "true" : "false";
    }

    /* access modifiers changed from: protected */
    public Context getContext() {
        return this.zzLy.getContext();
    }

    public void zza(String str, Object obj) {
        zza(2, str, obj, null, null);
    }

    public void zza(String str, Object obj, Object obj2) {
        zza(2, str, obj, obj2, null);
    }

    public void zza(String str, Object obj, Object obj2, Object obj3) {
        zza(3, str, obj, obj2, obj3);
    }

    public void zzaY(String str) {
        zza(2, str, null, null, null);
    }

    public void zzaZ(String str) {
        zza(3, str, null, null, null);
    }

    public void zzb(String str, Object obj) {
        zza(3, str, obj, null, null);
    }

    public void zzb(String str, Object obj, Object obj2) {
        zza(3, str, obj, obj2, null);
    }

    public void zzb(String str, Object obj, Object obj2, Object obj3) {
        zza(5, str, obj, obj2, obj3);
    }

    public void zzba(String str) {
        zza(4, str, null, null, null);
    }

    public void zzbb(String str) {
        zza(5, str, null, null, null);
    }

    public void zzbc(String str) {
        zza(6, str, null, null, null);
    }

    public void zzc(String str, Object obj) {
        zza(4, str, obj, null, null);
    }

    public void zzc(String str, Object obj, Object obj2) {
        zza(5, str, obj, obj2, null);
    }

    public void zzd(String str, Object obj) {
        zza(5, str, obj, null, null);
    }

    public void zzd(String str, Object obj, Object obj2) {
        zza(6, str, obj, obj2, null);
    }

    public void zze(String str, Object obj) {
        zza(6, str, obj, null, null);
    }

    /* access modifiers changed from: protected */
    public zzan zzhA() {
        return this.zzLy.zzhA();
    }

    public GoogleAnalytics zzhu() {
        return this.zzLy.zzis();
    }

    /* access modifiers changed from: protected */
    public zzb zzhz() {
        return this.zzLy.zzhz();
    }

    public zzf zzia() {
        return this.zzLy;
    }

    /* access modifiers changed from: protected */
    public void zzib() {
        if (zzif().zzjk()) {
            throw new IllegalStateException("Call only supported on the client side");
        }
    }

    /* access modifiers changed from: protected */
    public void zzic() {
        this.zzLy.zzic();
    }

    /* access modifiers changed from: protected */
    public zzlm zzid() {
        return this.zzLy.zzid();
    }

    /* access modifiers changed from: protected */
    public zzaf zzie() {
        return this.zzLy.zzie();
    }

    /* access modifiers changed from: protected */
    public zzr zzif() {
        return this.zzLy.zzif();
    }

    /* access modifiers changed from: protected */
    public zzof zzig() {
        return this.zzLy.zzig();
    }

    /* access modifiers changed from: protected */
    public zzv zzih() {
        return this.zzLy.zzih();
    }

    /* access modifiers changed from: protected */
    public zzai zzii() {
        return this.zzLy.zzii();
    }

    /* access modifiers changed from: protected */
    public zzn zzij() {
        return this.zzLy.zziv();
    }

    /* access modifiers changed from: protected */
    public zza zzik() {
        return this.zzLy.zziu();
    }

    /* access modifiers changed from: protected */
    public zzk zzil() {
        return this.zzLy.zzil();
    }

    /* access modifiers changed from: protected */
    public zzu zzim() {
        return this.zzLy.zzim();
    }

    public boolean zzin() {
        return Log.isLoggable((String) zzy.zzNa.get(), 2);
    }
}
