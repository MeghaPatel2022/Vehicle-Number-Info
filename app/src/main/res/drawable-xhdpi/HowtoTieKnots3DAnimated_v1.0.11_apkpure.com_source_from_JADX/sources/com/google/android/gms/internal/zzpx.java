package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.internal.zzpv.zza;
import java.util.List;

public class zzpx extends zzj<zzpv> {
    private final Context mContext;

    public zzpx(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 45, zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
    }

    private String zzlK() {
        try {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(this.mContext.getPackageName(), 128);
            if (applicationInfo == null) {
                return null;
            }
            Bundle bundle = applicationInfo.metaData;
            if (bundle == null) {
                return null;
            }
            return (String) bundle.get("com.google.android.safetynet.API_KEY");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public void zza(zzpu zzpu, List<Integer> list, int i, String str) throws RemoteException {
        int[] iArr = new int[list.size()];
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                iArr[i3] = ((Integer) list.get(i3)).intValue();
                i2 = i3 + 1;
            } else {
                ((zzpv) zzoA()).zza(zzpu, zzlK(), iArr, i, str);
                return;
            }
        }
    }

    public void zza(zzpu zzpu, byte[] bArr) throws RemoteException {
        ((zzpv) zzoA()).zza(zzpu, bArr);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdC */
    public zzpv zzV(IBinder iBinder) {
        return zza.zzdB(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.safetynet.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }
}
