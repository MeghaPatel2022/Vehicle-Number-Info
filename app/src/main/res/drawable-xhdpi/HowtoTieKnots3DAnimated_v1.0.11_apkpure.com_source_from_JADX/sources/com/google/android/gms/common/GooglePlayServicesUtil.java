package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.Notification.BigTextStyle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller.SessionInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.NotificationCompatExtras;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.google.android.gms.C0224R;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.zzlk;
import com.google.android.gms.internal.zzlv;
import java.util.concurrent.atomic.AtomicBoolean;

public final class GooglePlayServicesUtil {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzmW();
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static boolean zzYu = false;
    public static boolean zzYv = false;
    private static int zzYw = -1;
    private static String zzYx = null;
    private static Integer zzYy = null;
    static final AtomicBoolean zzYz = new AtomicBoolean();
    private static final Object zzpm = new Object();

    private static class zza extends Handler {
        private final Context zzqO;

        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zzqO = context.getApplicationContext();
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzqO);
                    if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                        GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.zzqO);
                        return;
                    }
                    return;
                default:
                    Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + msg.what);
                    return;
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode) {
        return getErrorDialog(errorCode, activity, requestCode, null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return zza(errorCode, activity, null, requestCode, cancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int errorCode, Context context, int requestCode) {
        Intent zzbc = zzbc(errorCode);
        if (zzbc == null) {
            return null;
        }
        return PendingIntent.getActivity(context, requestCode, zzbc, DriveFile.MODE_READ_ONLY);
    }

    @Deprecated
    public static String getErrorString(int errorCode) {
        return ConnectionResult.getStatusString(errorCode);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getOpenSourceSoftwareLicenseInfo(android.content.Context r4) {
        /*
            r1 = 0
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r2 = "android.resource"
            android.net.Uri$Builder r0 = r0.scheme(r2)
            java.lang.String r2 = "com.google.android.gms"
            android.net.Uri$Builder r0 = r0.authority(r2)
            java.lang.String r2 = "raw"
            android.net.Uri$Builder r0 = r0.appendPath(r2)
            java.lang.String r2 = "oss_notice"
            android.net.Uri$Builder r0 = r0.appendPath(r2)
            android.net.Uri r0 = r0.build()
            android.content.ContentResolver r2 = r4.getContentResolver()     // Catch:{ Exception -> 0x004e }
            java.io.InputStream r2 = r2.openInputStream(r0)     // Catch:{ Exception -> 0x004e }
            java.util.Scanner r0 = new java.util.Scanner     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            r0.<init>(r2)     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            java.lang.String r3 = "\\A"
            java.util.Scanner r0 = r0.useDelimiter(r3)     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            java.lang.String r0 = r0.next()     // Catch:{ NoSuchElementException -> 0x003f, all -> 0x0047 }
            if (r2 == 0) goto L_0x003e
            r2.close()     // Catch:{ Exception -> 0x004e }
        L_0x003e:
            return r0
        L_0x003f:
            r0 = move-exception
            if (r2 == 0) goto L_0x0045
            r2.close()     // Catch:{ Exception -> 0x004e }
        L_0x0045:
            r0 = r1
            goto L_0x003e
        L_0x0047:
            r0 = move-exception
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ Exception -> 0x004e }
        L_0x004d:
            throw r0     // Catch:{ Exception -> 0x004e }
        L_0x004e:
            r0 = move-exception
            r0 = r1
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtil.getOpenSourceSoftwareLicenseInfo(android.content.Context):java.lang.String");
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        if (zzd.zzacF) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(C0224R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            zzad(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzd zzmY = zzd.zzmY();
            if (!zzlk.zzbX(packageInfo.versionCode) && !zzlk.zzao(context)) {
                try {
                    zza zza2 = zzmY.zza(packageManager.getPackageInfo(GOOGLE_PLAY_STORE_PACKAGE, 64), zzbu.zzYt);
                    if (zza2 == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                        return 9;
                    }
                    if (zzmY.zza(packageInfo, zza2) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                        return 9;
                    }
                } catch (NameNotFoundException e) {
                    if (zzh(context, GOOGLE_PLAY_STORE_PACKAGE)) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store is updating.");
                        if (zzmY.zza(packageInfo, zzbu.zzYt) == null) {
                            Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                            return 9;
                        }
                    } else {
                        Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                        return 9;
                    }
                }
            } else if (zzmY.zza(packageInfo, zzbu.zzYt) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzlk.zzbV(packageInfo.versionCode) < zzlk.zzbV(GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but found " + packageInfo.versionCode);
                return 2;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null) {
                try {
                    applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                } catch (NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.");
                    e2.printStackTrace();
                    return 1;
                }
            }
            return !applicationInfo.enabled ? 3 : 0;
        } catch (NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static boolean isUserRecoverableError(int errorCode) {
        switch (errorCode) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode) {
        return showErrorDialogFragment(errorCode, activity, requestCode, null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int errorCode, Activity activity, int requestCode, OnCancelListener cancelListener) {
        return showErrorDialogFragment(errorCode, activity, null, requestCode, cancelListener);
    }

    public static boolean showErrorDialogFragment(int errorCode, Activity activity, Fragment fragment, int requestCode, OnCancelListener cancelListener) {
        boolean z = false;
        Dialog zza2 = zza(errorCode, activity, fragment, requestCode, cancelListener);
        if (zza2 == null) {
            return z;
        }
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(zza2, cancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), GMS_ERROR_DIALOG);
        } else if (zzlv.zzpO()) {
            ErrorDialogFragment.newInstance(zza2, cancelListener).show(activity.getFragmentManager(), GMS_ERROR_DIALOG);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int errorCode, Context context) {
        if (zzlk.zzao(context) && errorCode == 2) {
            errorCode = 42;
        }
        if (zzd(context, errorCode) || zzf(context, errorCode)) {
            zzae(context);
        } else {
            zza(errorCode, context);
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, OnCancelListener onCancelListener) {
        Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zzlk.zzao(activity) && i == 2) {
            i = 42;
        }
        if (zzlv.zzpR()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new Builder(activity);
        }
        builder.setMessage(zzg.zzb(activity, i, zzaf(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent zzbc = zzbc(i);
        zzh zzh = fragment == null ? new zzh(activity, zzbc, i2) : new zzh(fragment, zzbc, i2);
        String zzh2 = zzg.zzh(activity, i);
        if (zzh2 != null) {
            builder.setPositiveButton(zzh2, zzh);
        }
        String zzg = zzg.zzg(activity, i);
        if (zzg != null) {
            builder.setTitle(zzg);
        }
        return builder.create();
    }

    /* access modifiers changed from: private */
    public static void zza(int i, Context context) {
        zza(i, context, (String) null);
    }

    private static void zza(int i, Context context, String str) {
        Notification notification;
        Notification notification2;
        int i2;
        Resources resources = context.getResources();
        String zzaf = zzaf(context);
        String zzi = zzg.zzi(context, i);
        if (zzi == null) {
            zzi = resources.getString(C0224R.string.common_google_play_services_notification_ticker);
        }
        String zzc = zzg.zzc(context, i, zzaf);
        PendingIntent errorPendingIntent = getErrorPendingIntent(i, context, 0);
        if (zzlk.zzao(context)) {
            zzx.zzY(zzlv.zzpS());
            notification = new Notification.Builder(context).setSmallIcon(C0224R.C0225drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true).setStyle(new BigTextStyle().bigText(zzi + " " + zzc)).addAction(C0224R.C0225drawable.common_full_open_on_phone, resources.getString(C0224R.string.common_open_on_phone), errorPendingIntent).build();
        } else {
            String string = resources.getString(C0224R.string.common_google_play_services_notification_ticker);
            if (zzlv.zzpO()) {
                Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(zzi).setContentText(zzc).setContentIntent(errorPendingIntent).setTicker(string).setAutoCancel(true);
                if (zzlv.zzpW()) {
                    autoCancel.setLocalOnly(true);
                }
                if (zzlv.zzpS()) {
                    autoCancel.setStyle(new BigTextStyle().bigText(zzc));
                    notification2 = autoCancel.build();
                } else {
                    notification2 = autoCancel.getNotification();
                }
                if (VERSION.SDK_INT == 19) {
                    notification2.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
                notification = notification2;
            } else {
                notification = new Notification(17301642, string, System.currentTimeMillis());
                notification.flags |= 16;
                notification.setLatestEventInfo(context, zzi, zzc, errorPendingIntent);
            }
        }
        if (zzbd(i)) {
            zzYz.set(false);
            i2 = 10436;
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, notification);
        } else {
            notificationManager.notify(i2, notification);
        }
    }

    public static boolean zza(Context context, int i, String str) {
        if (zzlv.zzpV()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i, str);
                return true;
            } catch (SecurityException e) {
                return false;
            }
        } else {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i);
            if (str == null || packagesForUid == null) {
                return false;
            }
            for (String equals : packagesForUid) {
                if (str.equals(equals)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Deprecated
    public static void zzaa(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent zzbc = zzbc(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + isGooglePlayServicesAvailable);
            if (zzbc == null) {
                throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
            }
            throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zzbc);
        }
    }

    @Deprecated
    public static void zzac(Context context) {
        if (!zzYz.getAndSet(true)) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancel(10436);
            } catch (SecurityException e) {
            }
        }
    }

    private static void zzad(Context context) {
        Integer num;
        synchronized (zzpm) {
            if (zzYx == null) {
                zzYx = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        zzYy = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                    } else {
                        zzYy = null;
                    }
                } catch (NameNotFoundException e) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", e);
                }
            } else if (!zzYx.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + zzYx + "' and this call used package '" + context.getPackageName() + "'.");
            }
            num = zzYy;
        }
        if (num == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        } else if (num.intValue() != GOOGLE_PLAY_SERVICES_VERSION_CODE) {
            throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + GOOGLE_PLAY_SERVICES_VERSION_CODE + " but" + " found " + num + ".  You must have the" + " following declaration within the <application> element: " + "    <meta-data android:name=\"" + "com.google.android.gms.version" + "\" android:value=\"@integer/google_play_services_version\" />");
        }
    }

    private static void zzae(Context context) {
        zza zza2 = new zza(context);
        zza2.sendMessageDelayed(zza2.obtainMessage(1), 120000);
    }

    public static String zzaf(Context context) {
        ApplicationInfo applicationInfo;
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    public static boolean zzag(Context context) {
        return zzlv.zzpX() && context.getPackageManager().hasSystemFeature("com.google.sidewinder");
    }

    public static boolean zzb(PackageManager packageManager) {
        synchronized (zzpm) {
            if (zzYw == -1) {
                try {
                    if (zzd.zzmY().zza(packageManager.getPackageInfo("com.google.android.gms", 64), zzc.zzYm[1]) != null) {
                        zzYw = 1;
                    } else {
                        zzYw = 0;
                    }
                } catch (NameNotFoundException e) {
                    zzYw = 0;
                }
            }
        }
        return zzYw != 0;
    }

    @Deprecated
    public static boolean zzb(PackageManager packageManager, String str) {
        return zzd.zzmY().zzb(packageManager, str);
    }

    @Deprecated
    public static Intent zzbc(int i) {
        switch (i) {
            case 1:
            case 2:
                return zzn.zzcp("com.google.android.gms");
            case 3:
                return zzn.zzcn("com.google.android.gms");
            case 42:
                return zzn.zzoM();
            default:
                return null;
        }
    }

    private static boolean zzbd(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 18:
            case 42:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzc(PackageManager packageManager) {
        return zzb(packageManager) || !zzmX();
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzh(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean zze(Context context, int i) {
        return zza(context, i, "com.google.android.gms") && zzb(context.getPackageManager(), "com.google.android.gms");
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        if (i == 9) {
            return zzh(context, GOOGLE_PLAY_STORE_PACKAGE);
        }
        return false;
    }

    public static boolean zzh(Context context, String str) {
        if (zzlv.zzpX()) {
            for (SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(appPackageName.getAppPackageName())) {
                    return true;
                }
            }
        } else {
            try {
                if (context.getPackageManager().getApplicationInfo(str, 8192).enabled) {
                    return true;
                }
            } catch (NameNotFoundException e) {
            }
        }
        return false;
    }

    private static int zzmW() {
        return 7895000;
    }

    public static boolean zzmX() {
        return zzYu ? zzYv : "user".equals(Build.TYPE);
    }
}
