package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zzma {
    private static final Method zzagh = zzpZ();
    private static final Method zzagi = zzqa();
    private static final Method zzagj = zzqb();
    private static final Method zzagk = zzqc();
    private static final Method zzagl = zzqd();

    public static int zza(WorkSource workSource) {
        if (zzagj != null) {
            try {
                return ((Integer) zzagj.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return 0;
    }

    public static String zza(WorkSource workSource, int i) {
        if (zzagl != null) {
            try {
                return (String) zzagl.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
        return null;
    }

    public static void zza(WorkSource workSource, int i, String str) {
        if (zzagi != null) {
            if (str == null) {
                str = "";
            }
            try {
                zzagi.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        } else if (zzagh != null) {
            try {
                zzagh.invoke(workSource, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource");
            }
        }
    }

    public static boolean zzaq(Context context) {
        return context.getPackageManager().checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }

    public static List<String> zzb(WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzlz.zzcB(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static WorkSource zze(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    public static WorkSource zzj(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zze(applicationInfo.uid, str);
            }
            Log.e("WorkSourceUtil", "Could not get applicationInfo from package: " + str);
            return null;
        } catch (NameNotFoundException e) {
            Log.e("WorkSourceUtil", "Could not find package: " + str);
            return null;
        }
    }

    private static Method zzpZ() {
        boolean z = false;
        try {
            return WorkSource.class.getMethod(ProductAction.ACTION_ADD, new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return z;
        }
    }

    private static Method zzqa() {
        Method method = null;
        if (!zzlv.zzpU()) {
            return method;
        }
        try {
            return WorkSource.class.getMethod(ProductAction.ACTION_ADD, new Class[]{Integer.TYPE, String.class});
        } catch (Exception e) {
            return method;
        }
    }

    private static Method zzqb() {
        boolean z = false;
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return z;
        }
    }

    private static Method zzqc() {
        boolean z = false;
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return z;
        }
    }

    private static Method zzqd() {
        Method method = null;
        if (!zzlv.zzpU()) {
            return method;
        }
        try {
            return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return method;
        }
    }
}
