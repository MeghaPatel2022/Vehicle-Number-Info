package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.playlog.internal.LogEvent;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import com.google.android.gms.playlog.internal.zzd;
import com.google.android.gms.playlog.internal.zzf;

@Deprecated
public class zzpm {
    private final zzf zzaKE;
    private PlayLoggerContext zzaKF;

    public interface zza {
        void zzh(PendingIntent pendingIntent);

        void zzyA();

        void zzyB();
    }

    public zzpm(Context context, int i, String str, String str2, zza zza2, boolean z, String str3) {
        String packageName = context.getPackageName();
        int i2 = 0;
        try {
            i2 = context.getPackageManager().getPackageInfo(packageName, 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.wtf("PlayLogger", "This can't happen.");
        }
        this.zzaKF = new PlayLoggerContext(packageName, i2, i, str, str2, z);
        this.zzaKE = new zzf(context, context.getMainLooper(), new zzd(zza2), new com.google.android.gms.common.internal.zzf(null, null, null, 49, null, packageName, str3, null));
    }

    public void start() {
        this.zzaKE.start();
    }

    public void stop() {
        this.zzaKE.stop();
    }

    public void zza(long j, String str, byte[] bArr, String... strArr) {
        this.zzaKE.zzb(this.zzaKF, new LogEvent(j, 0, str, bArr, strArr));
    }

    public void zzb(String str, byte[] bArr, String... strArr) {
        zza(System.currentTimeMillis(), str, bArr, strArr);
    }
}
