package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzri extends zzg<zzrd> {
    private static zzri zzaYt;

    protected zzri() {
        super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
    }

    private static zzri zzCm() {
        if (zzaYt == null) {
            zzaYt = new zzri();
        }
        return zzaYt;
    }

    public static zzra zza(Activity activity, zzc zzc, WalletFragmentOptions walletFragmentOptions, zzrb zzrb) throws GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        if (isGooglePlayServicesAvailable != 0) {
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
        try {
            return ((zzrd) zzCm().zzar(activity)).zza(zze.zzx(activity), zzc, walletFragmentOptions, zzrb);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (zza e2) {
            throw new RuntimeException(e2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdW */
    public zzrd zzd(IBinder iBinder) {
        return zzrd.zza.zzdS(iBinder);
    }
}
