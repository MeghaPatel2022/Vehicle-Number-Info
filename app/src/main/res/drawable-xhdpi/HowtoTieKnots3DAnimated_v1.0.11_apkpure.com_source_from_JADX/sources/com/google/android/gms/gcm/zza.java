package com.google.android.gms.gcm;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;
import java.util.MissingFormatArgumentException;
import org.json.JSONArray;
import org.json.JSONException;

class zza {
    static zza zzazH;
    private Context mContext;

    /* renamed from: com.google.android.gms.gcm.zza$zza reason: collision with other inner class name */
    private class C1382zza extends IllegalArgumentException {
        private C1382zza(String str) {
            super(str);
        }
    }

    private zza(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void zza(String str, Notification notification) {
        if (Log.isLoggable("GcmNotification", 3)) {
            Log.d("GcmNotification", "Showing notification");
        }
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        if (TextUtils.isEmpty(str)) {
            str = "GCM-Notification:" + SystemClock.uptimeMillis();
        }
        notificationManager.notify(str, 0, notification);
    }

    static synchronized zza zzay(Context context) {
        zza zza;
        synchronized (zza.class) {
            if (zzazH == null) {
                zzazH = new zza(context);
            }
            zza = zzazH;
        }
        return zza;
    }

    static String zzb(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private String zzc(Bundle bundle, String str) {
        String zzb = zzb(bundle, str);
        if (!TextUtils.isEmpty(zzb)) {
            return zzb;
        }
        String zzb2 = zzb(bundle, str + "_loc_key");
        if (TextUtils.isEmpty(zzb2)) {
            return null;
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(zzb2, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            throw new C1382zza(zzdk(str + "_loc_key") + " resource not found: " + zzb2);
        }
        String zzb3 = zzb(bundle, str + "_loc_args");
        if (TextUtils.isEmpty(zzb3)) {
            return resources.getString(identifier);
        }
        try {
            JSONArray jSONArray = new JSONArray(zzb3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = jSONArray.opt(i);
            }
            try {
                return resources.getString(identifier, objArr);
            } catch (MissingFormatArgumentException e) {
                throw new C1382zza("Missing format argument for " + zzb2 + ": " + e);
            }
        } catch (JSONException e2) {
            throw new C1382zza("Malformed " + zzdk(str + "_loc_args") + ": " + zzb3);
        }
    }

    private String zzdk(String str) {
        return str.substring("gcm.n.".length());
    }

    private int zzdl(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new C1382zza("Missing icon");
        }
        Resources resources = this.mContext.getResources();
        int identifier = resources.getIdentifier(str, "drawable", this.mContext.getPackageName());
        if (identifier == 0) {
            identifier = resources.getIdentifier(str, "mipmap", this.mContext.getPackageName());
            if (identifier == 0) {
                throw new C1382zza("Icon resource not found: " + str);
            }
        }
        return identifier;
    }

    private Uri zzdm(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("default".equals(str)) {
            return RingtoneManager.getDefaultUri(2);
        }
        throw new C1382zza("Invalid sound: " + str);
    }

    static boolean zzu(Bundle bundle) {
        return zzb(bundle, "gcm.n.icon") != null;
    }

    private Notification zzw(Bundle bundle) {
        String zzc = zzc(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(zzc)) {
            throw new C1382zza("Missing title");
        }
        String zzc2 = zzc(bundle, "gcm.n.body");
        int zzdl = zzdl(zzb(bundle, "gcm.n.icon"));
        Uri zzdm = zzdm(zzb(bundle, "gcm.n.sound"));
        PendingIntent zzx = zzx(bundle);
        if (VERSION.SDK_INT >= 11) {
            Builder contentText = new Builder(this.mContext).setAutoCancel(true).setSmallIcon(zzdl).setContentTitle(zzc).setContentText(zzc2);
            if (VERSION.SDK_INT >= 21) {
                String zzb = zzb(bundle, "gcm.n.color");
                if (!TextUtils.isEmpty(zzb)) {
                    contentText.setColor(Color.parseColor(zzb));
                }
            }
            if (zzdm != null) {
                contentText.setSound(zzdm);
            }
            if (zzx != null) {
                contentText.setContentIntent(zzx);
            }
            return VERSION.SDK_INT >= 16 ? contentText.build() : contentText.getNotification();
        }
        Notification notification = new Notification();
        notification.flags |= 16;
        notification.icon = zzdl;
        if (zzdm != null) {
            notification.sound = zzdm;
        }
        if (zzx == null) {
            Intent intent = new Intent();
            intent.setPackage("com.google.example.invalidpackage");
            zzx = PendingIntent.getBroadcast(this.mContext, 0, intent, 0);
        }
        notification.setLatestEventInfo(this.mContext, zzc, zzc2, zzx);
        return notification;
    }

    private PendingIntent zzx(Bundle bundle) {
        String zzb = zzb(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(zzb)) {
            return null;
        }
        Intent intent = new Intent(zzb);
        intent.setPackage(this.mContext.getPackageName());
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.putExtras(bundle);
        for (String str : bundle.keySet()) {
            if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                intent.removeExtra(str);
            }
        }
        return PendingIntent.getActivity(this.mContext, 0, intent, 1073741824);
    }

    /* access modifiers changed from: 0000 */
    public boolean zzv(Bundle bundle) {
        try {
            zza(zzb(bundle, "gcm.n.tag"), zzw(bundle));
            return true;
        } catch (C1382zza e) {
            Log.w("GcmNotification", "Failed to show notification: " + e.getMessage());
            return false;
        }
    }
}
