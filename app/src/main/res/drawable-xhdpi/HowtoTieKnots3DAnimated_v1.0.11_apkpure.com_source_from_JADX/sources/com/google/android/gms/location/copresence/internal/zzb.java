package com.google.android.gms.location.copresence.internal;

import android.content.Context;
import com.google.android.gms.location.internal.zzg;
import com.google.android.gms.location.internal.zzn;

public class zzb {
    private final Context mContext;
    private final String zzQE;
    private final String zzQl;
    private final zzn<zzg> zzaCs;
    private final CopresenceApiOptions zzaCt;
    private zzc zzaCu = null;

    private zzb(Context context, String str, String str2, zzn<zzg> zzn, CopresenceApiOptions copresenceApiOptions) {
        this.mContext = context;
        this.zzQE = str;
        this.zzaCs = zzn;
        this.zzQl = str2;
        this.zzaCt = copresenceApiOptions;
    }

    public static zzb zza(Context context, String str, String str2, zzn<zzg> zzn, CopresenceApiOptions copresenceApiOptions) {
        return new zzb(context, str, str2, zzn, copresenceApiOptions);
    }
}
