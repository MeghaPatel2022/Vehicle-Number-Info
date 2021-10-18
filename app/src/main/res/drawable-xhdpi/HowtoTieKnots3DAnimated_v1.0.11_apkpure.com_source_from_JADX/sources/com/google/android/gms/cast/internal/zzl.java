package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

public class zzl {
    private static boolean zzXv = false;
    protected final String mTag;
    private final boolean zzXw;
    private boolean zzXx;
    private boolean zzXy;
    private String zzXz;

    public zzl(String str) {
        this(str, zzmL());
    }

    public zzl(String str, boolean z) {
        zzx.zzh(str, "The log tag cannot be null or empty.");
        this.mTag = str;
        this.zzXw = str.length() <= 23;
        this.zzXx = z;
        this.zzXy = false;
    }

    public static boolean zzmL() {
        return zzXv;
    }

    public void zzW(boolean z) {
        this.zzXx = z;
    }

    public void zza(String str, Object... objArr) {
        if (zzmK()) {
            Log.v(this.mTag, zzg(str, objArr));
        }
    }

    public void zzb(String str, Object... objArr) {
        if (zzmJ() || zzXv) {
            Log.d(this.mTag, zzg(str, objArr));
        }
    }

    public void zzb(Throwable th, String str, Object... objArr) {
        if (zzmJ() || zzXv) {
            Log.d(this.mTag, zzg(str, objArr), th);
        }
    }

    public void zzbR(String str) {
        String format;
        if (TextUtils.isEmpty(str)) {
            format = null;
        } else {
            format = String.format("[%s] ", new Object[]{str});
        }
        this.zzXz = format;
    }

    public void zzc(String str, Object... objArr) {
        Log.e(this.mTag, zzg(str, objArr));
    }

    public void zzc(Throwable th, String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr), th);
    }

    public void zze(String str, Object... objArr) {
        Log.i(this.mTag, zzg(str, objArr));
    }

    public void zzf(String str, Object... objArr) {
        Log.w(this.mTag, zzg(str, objArr));
    }

    /* access modifiers changed from: protected */
    public String zzg(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(Locale.ROOT, str, objArr);
        }
        return !TextUtils.isEmpty(this.zzXz) ? this.zzXz + str : str;
    }

    public boolean zzmJ() {
        return this.zzXx || (this.zzXw && Log.isLoggable(this.mTag, 3));
    }

    public boolean zzmK() {
        return this.zzXy;
    }
}
