package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.List;

public class GcmNetworkManager {
    public static final int RESULT_FAILURE = 2;
    public static final int RESULT_RESCHEDULE = 1;
    public static final int RESULT_SUCCESS = 0;
    private static GcmNetworkManager zzazG;
    private Context mContext;
    private final PendingIntent mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, new Intent(), 0);

    private GcmNetworkManager(Context context) {
        this.mContext = context;
    }

    public static GcmNetworkManager getInstance(Context context) {
        if (zzazG == null) {
            zzazG = new GcmNetworkManager(context.getApplicationContext());
        }
        return zzazG;
    }

    static void zzdi(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must provide a valid tag.");
        } else if (100 < str.length()) {
            throw new IllegalArgumentException("Tag is larger than max permissible tag length (100)");
        }
    }

    private void zzdj(String str) {
        boolean z = true;
        zzx.zzb(str, (Object) "GcmTaskService must not be null.");
        Intent intent = new Intent(GcmTaskService.SERVICE_ACTION_EXECUTE_TASK);
        intent.setPackage(this.mContext.getPackageName());
        List queryIntentServices = this.mContext.getPackageManager().queryIntentServices(intent, 0);
        zzx.zzb((queryIntentServices == null || queryIntentServices.size() == 0) ? false : true, (Object) "There is no GcmTaskService component registered within this package. Have you extended GcmTaskService correctly?");
        Iterator it = queryIntentServices.iterator();
        while (true) {
            if (it.hasNext()) {
                if (((ResolveInfo) it.next()).serviceInfo.name.equals(str)) {
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        zzx.zzb(z, (Object) "The GcmTaskService class you provided " + str + " does not seem to support receiving" + " com.google.android.gms.gcm.ACTION_TASK_READY.");
    }

    private Intent zzvl() {
        int zzaA = GoogleCloudMessaging.zzaA(this.mContext);
        if (zzaA < GoogleCloudMessaging.zzazR) {
            Log.e("GcmNetworkManager", "Google Play Services is not available, dropping GcmNetworkManager request. code=" + zzaA);
            return null;
        }
        Intent intent = new Intent("com.google.android.gms.gcm.ACTION_SCHEDULE");
        intent.setPackage(GoogleCloudMessaging.zzaz(this.mContext));
        intent.putExtra("app", this.mPendingIntent);
        return intent;
    }

    public void cancelAllTasks(Class<? extends GcmTaskService> gcmTaskService) {
        zzdj(gcmTaskService.getName());
        Intent zzvl = zzvl();
        if (zzvl != null) {
            zzvl.putExtra("scheduler_action", "CANCEL_ALL");
            zzvl.putExtra("component", new ComponentName(this.mContext, gcmTaskService));
            this.mContext.sendBroadcast(zzvl);
        }
    }

    public void cancelTask(String tag, Class<? extends GcmTaskService> gcmTaskService) {
        zzdi(tag);
        zzdj(gcmTaskService.getName());
        Intent zzvl = zzvl();
        if (zzvl != null) {
            zzvl.putExtra("scheduler_action", "CANCEL_TASK");
            zzvl.putExtra("tag", tag);
            zzvl.putExtra("component", new ComponentName(this.mContext, gcmTaskService));
            this.mContext.sendBroadcast(zzvl);
        }
    }

    public void schedule(Task task) {
        zzdj(task.getServiceName());
        Intent zzvl = zzvl();
        if (zzvl != null) {
            Bundle extras = zzvl.getExtras();
            extras.putString("scheduler_action", "SCHEDULE_TASK");
            task.toBundle(extras);
            zzvl.putExtras(extras);
            this.mContext.sendBroadcast(zzvl);
        }
    }
}
