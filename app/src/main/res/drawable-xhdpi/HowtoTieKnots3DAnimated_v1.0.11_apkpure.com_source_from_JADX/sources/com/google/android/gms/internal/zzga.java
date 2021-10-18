package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzn;

@zzgk
public class zzga {

    public interface zza {
        void zzb(zzhj zzhj);
    }

    public zzhq zza(Context context, com.google.android.gms.ads.internal.zza zza2, com.google.android.gms.internal.zzhj.zza zza3, zzan zzan, zzip zzip, zzeh zzeh, zza zza4, zzcd zzcd) {
        zzhq zzgb;
        AdResponseParcel adResponseParcel = zza3.zzGM;
        if (adResponseParcel.zzDX) {
            zzgb = new zzgd(context, zza3, zzip, zzeh, zza4, zzcd);
        } else if (!adResponseParcel.zzsJ) {
            zzgb = adResponseParcel.zzEd ? new zzfy(context, zza3, zzip, zza4) : (!((Boolean) zzby.zzuM.get()).booleanValue() || !zzlv.zzpV() || zzlv.isAtLeastL() || !zzip.zzaN().zzsH) ? new zzgb(context, zza3, zzip, zza4) : new zzgc(context, zza3, zzip, zza4);
        } else if (zza2 instanceof zzn) {
            zzgb = new zzge(context, (zzn) zza2, new zzbc(), zza3, zzan, zza4);
        } else {
            throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (zza2 != null ? zza2.getClass().getName() : "null") + "; Required: NativeAdManager.");
        }
        zzb.zzaC("AdRenderer: " + zzgb.getClass().getName());
        zzgb.zzgo();
        return zzgb;
    }
}
