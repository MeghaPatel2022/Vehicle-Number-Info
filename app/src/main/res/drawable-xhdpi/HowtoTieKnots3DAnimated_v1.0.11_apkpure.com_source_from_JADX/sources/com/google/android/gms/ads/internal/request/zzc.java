package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzhq;

@zzgk
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zzd(AdRequestInfoParcel adRequestInfoParcel);
    }

    public static zzhq zza(final Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2) {
        return zza(context, adRequestInfoParcel, zza2, new zzb() {
            public boolean zzd(AdRequestInfoParcel adRequestInfoParcel) {
                return adRequestInfoParcel.zzqb.zzIC || (GooglePlayServicesUtil.zzag(context) && !((Boolean) zzby.zzuw.get()).booleanValue());
            }
        });
    }

    static zzhq zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2, zzb zzb2) {
        return zzb2.zzd(adRequestInfoParcel) ? zzb(context, adRequestInfoParcel, zza2) : zzc(context, adRequestInfoParcel, zza2);
    }

    private static zzhq zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Fetching ad response from local ad request service.");
        com.google.android.gms.ads.internal.request.zzd.zza zza3 = new com.google.android.gms.ads.internal.request.zzd.zza(context, adRequestInfoParcel, zza2);
        zza3.zzgn();
        return zza3;
    }

    private static zzhq zzc(Context context, AdRequestInfoParcel adRequestInfoParcel, zza zza2) {
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Fetching ad response from remote ad request service.");
        if (zzk.zzcE().zzR(context)) {
            return new com.google.android.gms.ads.internal.request.zzd.zzb(context, adRequestInfoParcel, zza2);
        }
        com.google.android.gms.ads.internal.util.client.zzb.zzaE("Failed to connect to remote ad request service.");
        return null;
    }
}
