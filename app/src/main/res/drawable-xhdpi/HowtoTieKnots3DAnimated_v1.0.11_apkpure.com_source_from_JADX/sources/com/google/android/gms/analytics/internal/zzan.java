package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class zzan extends zzd {
    protected boolean zzKx;
    protected int zzMQ;
    protected String zzNT;
    protected String zzNU;
    protected int zzNW;
    protected boolean zzOL;
    protected boolean zzOM;
    protected boolean zzON;

    public zzan(zzf zzf) {
        super(zzf);
    }

    private static int zzbt(String str) {
        String lowerCase = str.toLowerCase();
        if ("verbose".equals(lowerCase)) {
            return 0;
        }
        if ("info".equals(lowerCase)) {
            return 1;
        }
        if ("warning".equals(lowerCase)) {
            return 2;
        }
        return MediaRouteProviderProtocol.SERVICE_DATA_ERROR.equals(lowerCase) ? 3 : -1;
    }

    public int getLogLevel() {
        zzio();
        return this.zzMQ;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzaa zzaa) {
        zzaY("Loading global XML config values");
        if (zzaa.zzjY()) {
            String zzjZ = zzaa.zzjZ();
            this.zzNT = zzjZ;
            zzb("XML config - app name", zzjZ);
        }
        if (zzaa.zzka()) {
            String zzkb = zzaa.zzkb();
            this.zzNU = zzkb;
            zzb("XML config - app version", zzkb);
        }
        if (zzaa.zzkc()) {
            int zzbt = zzbt(zzaa.zzkd());
            if (zzbt >= 0) {
                this.zzMQ = zzbt;
                zza("XML config - log level", Integer.valueOf(zzbt));
            }
        }
        if (zzaa.zzke()) {
            int zzkf = zzaa.zzkf();
            this.zzNW = zzkf;
            this.zzOM = true;
            zzb("XML config - dispatch period (sec)", Integer.valueOf(zzkf));
        }
        if (zzaa.zzkg()) {
            boolean zzkh = zzaa.zzkh();
            this.zzKx = zzkh;
            this.zzON = true;
            zzb("XML config - dry run", Boolean.valueOf(zzkh));
        }
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        zzkW();
    }

    public String zzjZ() {
        zzio();
        return this.zzNT;
    }

    public int zzkV() {
        zzio();
        return this.zzNW;
    }

    /* access modifiers changed from: protected */
    public void zzkW() {
        ApplicationInfo applicationInfo;
        Context context = getContext();
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 129);
        } catch (NameNotFoundException e) {
            zzd("PackageManager doesn't know about the app package", e);
            applicationInfo = null;
        }
        if (applicationInfo == null) {
            zzbb("Couldn't get ApplicationInfo to load global config");
            return;
        }
        Bundle bundle = applicationInfo.metaData;
        if (bundle != null) {
            int i = bundle.getInt("com.google.android.gms.analytics.globalConfigResource");
            if (i > 0) {
                zzaa zzaa = (zzaa) new zzz(zzia()).zzac(i);
                if (zzaa != null) {
                    zza(zzaa);
                }
            }
        }
    }

    public String zzkb() {
        zzio();
        return this.zzNU;
    }

    public boolean zzkc() {
        zzio();
        return this.zzOL;
    }

    public boolean zzke() {
        zzio();
        return this.zzOM;
    }

    public boolean zzkg() {
        zzio();
        return this.zzON;
    }

    public boolean zzkh() {
        zzio();
        return this.zzKx;
    }
}
