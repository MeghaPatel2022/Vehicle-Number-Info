package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzaw;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzhj;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;

@zzgk
public class zzf extends zzc {
    private boolean zzoM;

    public zzf(Context context, AdSizeParcel adSizeParcel, String str, zzeh zzeh, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, str, zzeh, versionInfoParcel, null);
    }

    private boolean zzb(zzhj zzhj, zzhj zzhj2) {
        if (zzhj2.zzDX) {
            try {
                zzd view = zzhj2.zzyR.getView();
                if (view == null) {
                    zzb.zzaE("View in mediation adapter is null.");
                    return false;
                }
                View view2 = (View) zze.zzp(view);
                View nextView = this.zzos.zzqc.getNextView();
                if (nextView != null) {
                    if (nextView instanceof zzip) {
                        ((zzip) nextView).destroy();
                    }
                    this.zzos.zzqc.removeView(nextView);
                }
                try {
                    zzb(view2);
                } catch (Throwable th) {
                    zzb.zzd("Could not add mediation view to view hierarchy.", th);
                    return false;
                }
            } catch (RemoteException e) {
                zzb.zzd("Could not get View from mediation adapter.", e);
                return false;
            }
        } else if (!(zzhj2.zzGH == null || zzhj2.zzAR == null)) {
            zzhj2.zzAR.zza(zzhj2.zzGH);
            this.zzos.zzqc.removeAllViews();
            this.zzos.zzqc.setMinimumWidth(zzhj2.zzGH.widthPixels);
            this.zzos.zzqc.setMinimumHeight(zzhj2.zzGH.heightPixels);
            zzb((View) zzhj2.zzAR.getWebView());
        }
        if (this.zzos.zzqc.getChildCount() > 1) {
            this.zzos.zzqc.showNext();
        }
        if (zzhj != null) {
            View nextView2 = this.zzos.zzqc.getNextView();
            if (nextView2 instanceof zzip) {
                ((zzip) nextView2).zza(this.zzos.context, this.zzos.zzqf);
            } else if (nextView2 != null) {
                this.zzos.zzqc.removeView(nextView2);
            }
            this.zzos.zzbO();
        }
        this.zzos.zzqc.setVisibility(0);
        return true;
    }

    public void setManualImpressionsEnabled(boolean enabled) {
        zzx.zzch("setManualImpressionsEnabled must be called from the main thread.");
        this.zzoM = enabled;
    }

    public void showInterstitial() {
        throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
    }

    public boolean zza(AdRequestParcel adRequestParcel) {
        return super.zza(zzd(adRequestParcel));
    }

    public boolean zza(zzhj zzhj, final zzhj zzhj2) {
        if (!super.zza(zzhj, zzhj2)) {
            return false;
        }
        if (!this.zzos.zzbP() || zzb(zzhj, zzhj2)) {
            zza(zzhj2, false);
            if (this.zzos.zzbP()) {
                if (zzhj2.zzAR != null) {
                    if (zzhj2.zzGF != null) {
                        this.zzou.zza(this.zzos.zzqf, zzhj2);
                    }
                    if (zzhj2.zzbY()) {
                        this.zzou.zza(this.zzos.zzqf, zzhj2).zza((zzaw) zzhj2.zzAR);
                    } else {
                        zzhj2.zzAR.zzgS().zza((zziq.zzb) new zziq.zzb() {
                            public void zzbf() {
                                zzf.this.zzou.zza(zzf.this.zzos.zzqf, zzhj2).zza((zzaw) zzhj2.zzAR);
                            }
                        });
                    }
                }
            } else if (!(this.zzos.zzqy == null || zzhj2.zzGF == null)) {
                this.zzou.zza(this.zzos.zzqf, zzhj2, this.zzos.zzqy);
            }
            return true;
        }
        zze(0);
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zzaU() {
        boolean z = true;
        if (!zzp.zzbx().zza(this.zzos.context.getPackageManager(), this.zzos.context.getPackageName(), "android.permission.INTERNET")) {
            zzk.zzcE().zza(this.zzos.zzqc, this.zzos.zzqf, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
            z = false;
        }
        if (!zzp.zzbx().zzI(this.zzos.context)) {
            zzk.zzcE().zza(this.zzos.zzqc, this.zzos.zzqf, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
            z = false;
        }
        if (!z && this.zzos.zzqc != null) {
            this.zzos.zzqc.setVisibility(0);
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public AdRequestParcel zzd(AdRequestParcel adRequestParcel) {
        if (adRequestParcel.zzsv == this.zzoM) {
            return adRequestParcel;
        }
        return new AdRequestParcel(adRequestParcel.versionCode, adRequestParcel.zzsq, adRequestParcel.extras, adRequestParcel.zzsr, adRequestParcel.zzss, adRequestParcel.zzst, adRequestParcel.zzsu, adRequestParcel.zzsv || this.zzoM, adRequestParcel.zzsw, adRequestParcel.zzsx, adRequestParcel.zzsy, adRequestParcel.zzsz, adRequestParcel.zzsA, adRequestParcel.zzsB, adRequestParcel.zzsC, adRequestParcel.zzsD, adRequestParcel.zzsE);
    }
}
