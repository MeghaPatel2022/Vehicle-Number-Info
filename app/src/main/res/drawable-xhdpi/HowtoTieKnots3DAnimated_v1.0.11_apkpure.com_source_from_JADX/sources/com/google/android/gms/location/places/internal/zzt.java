package com.google.android.gms.location.places.internal;

import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzrn;
import com.google.android.gms.internal.zzrw;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzt extends zzc {
    private final String TAG = "SafeDataBufferRef";

    public zzt(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* access modifiers changed from: protected */
    public int zzA(String str, int i) {
        return (!zzcd(str) || zzcf(str)) ? i : getInteger(str);
    }

    /* access modifiers changed from: protected */
    public String zzD(String str, String str2) {
        return (!zzcd(str) || zzcf(str)) ? str2 : getString(str);
    }

    /* access modifiers changed from: protected */
    public <E extends SafeParcelable> E zza(String str, Creator<E> creator) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return null;
        }
        return com.google.android.gms.common.internal.safeparcel.zzc.zza(zzc, creator);
    }

    /* access modifiers changed from: protected */
    public <E extends SafeParcelable> List<E> zza(String str, Creator<E> creator, List<E> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzrn zzx = zzrn.zzx(zzc);
            if (zzx.zzbbM == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzx.zzbbM.length);
            for (byte[] zza : zzx.zzbbM) {
                arrayList.add(com.google.android.gms.common.internal.safeparcel.zzc.zza(zza, creator));
            }
            return arrayList;
        } catch (zzrw e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* access modifiers changed from: protected */
    public List<Integer> zza(String str, List<Integer> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzrn zzx = zzrn.zzx(zzc);
            if (zzx.zzbbL == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzx.zzbbL.length);
            for (int valueOf : zzx.zzbbL) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            return arrayList;
        } catch (zzrw e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* access modifiers changed from: protected */
    public float zzb(String str, float f) {
        return (!zzcd(str) || zzcf(str)) ? f : getFloat(str);
    }

    /* access modifiers changed from: protected */
    public List<String> zzb(String str, List<String> list) {
        byte[] zzc = zzc(str, null);
        if (zzc == null) {
            return list;
        }
        try {
            zzrn zzx = zzrn.zzx(zzc);
            return zzx.zzbbK != null ? Arrays.asList(zzx.zzbbK) : list;
        } catch (zzrw e) {
            if (!Log.isLoggable("SafeDataBufferRef", 6)) {
                return list;
            }
            Log.e("SafeDataBufferRef", "Cannot parse byte[]", e);
            return list;
        }
    }

    /* access modifiers changed from: protected */
    public byte[] zzc(String str, byte[] bArr) {
        return (!zzcd(str) || zzcf(str)) ? bArr : getByteArray(str);
    }

    /* access modifiers changed from: protected */
    public boolean zzh(String str, boolean z) {
        return (!zzcd(str) || zzcf(str)) ? z : getBoolean(str);
    }
}
