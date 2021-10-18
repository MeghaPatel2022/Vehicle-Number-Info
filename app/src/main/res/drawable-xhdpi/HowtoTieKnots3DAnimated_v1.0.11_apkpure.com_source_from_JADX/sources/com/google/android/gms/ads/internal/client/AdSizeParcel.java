package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzgk;

@zzgk
public final class AdSizeParcel implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;
    public final String zzsG;
    public final boolean zzsH;
    public final AdSizeParcel[] zzsI;
    public final boolean zzsJ;

    public AdSizeParcel() {
        this(3, "interstitial_mb", 0, 0, true, 0, 0, null, false);
    }

    AdSizeParcel(int versionCode2, String formatString, int height2, int heightPixels2, boolean isInterstitial, int width2, int widthPixels2, AdSizeParcel[] supportedAdSizes, boolean isNative) {
        this.versionCode = versionCode2;
        this.zzsG = formatString;
        this.height = height2;
        this.heightPixels = heightPixels2;
        this.zzsH = isInterstitial;
        this.width = width2;
        this.widthPixels = widthPixels2;
        this.zzsI = supportedAdSizes;
        this.zzsJ = isNative;
    }

    public AdSizeParcel(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public AdSizeParcel(Context context, AdSize[] adSizes) {
        int i;
        AdSize adSize = adSizes[0];
        this.versionCode = 3;
        this.zzsH = false;
        this.width = adSize.getWidth();
        this.height = adSize.getHeight();
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (!zzk.zzcE().zzS(context) || !zzk.zzcE().zzT(context)) {
                this.widthPixels = zza(displayMetrics);
            } else {
                this.widthPixels = zza(displayMetrics) - zzk.zzcE().zzU(context);
            }
            double d = (double) (((float) this.widthPixels) / displayMetrics.density);
            int i2 = (int) d;
            if (d - ((double) ((int) d)) >= 0.01d) {
                i2++;
            }
            i = i2;
        } else {
            int i3 = this.width;
            this.widthPixels = zzk.zzcE().zza(displayMetrics, this.width);
            i = i3;
        }
        int i4 = z2 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzk.zzcE().zza(displayMetrics, i4);
        if (z || z2) {
            this.zzsG = i + "x" + i4 + "_as";
        } else {
            this.zzsG = adSize.toString();
        }
        if (adSizes.length > 1) {
            this.zzsI = new AdSizeParcel[adSizes.length];
            for (int i5 = 0; i5 < adSizes.length; i5++) {
                this.zzsI[i5] = new AdSizeParcel(context, adSizes[i5]);
            }
        } else {
            this.zzsI = null;
        }
        this.zzsJ = false;
    }

    public AdSizeParcel(AdSizeParcel adSize, AdSizeParcel[] supportedAdSizes) {
        this(3, adSize.zzsG, adSize.height, adSize.heightPixels, adSize.zzsH, adSize.width, adSize.widthPixels, supportedAdSizes, adSize.zzsJ);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return (int) (((float) zzc(displayMetrics)) * displayMetrics.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static AdSizeParcel zzcB() {
        return new AdSizeParcel(3, "reward_mb", 0, 0, false, 0, 0, null, false);
    }

    public static AdSizeParcel zzs(Context context) {
        return new AdSizeParcel(3, "320x50_mb", 0, 0, false, 0, 0, null, true);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public AdSize zzcC() {
        return zza.zza(this.width, this.height, this.zzsG);
    }
}
