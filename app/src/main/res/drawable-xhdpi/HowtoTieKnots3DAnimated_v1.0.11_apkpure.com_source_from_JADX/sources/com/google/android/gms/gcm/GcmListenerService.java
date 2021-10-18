package com.google.android.gms.gcm;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;

public abstract class GcmListenerService extends Service {
    private int zzazD;
    private int zzazE = 0;
    private final Object zzpc = new Object();

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007d A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x008a A[SYNTHETIC, Splitter:B:40:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0098 A[Catch:{ all -> 0x0085 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzk(android.content.Intent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "com.google.android.c2dm.intent.RECEIVE"
            java.lang.String r1 = r5.getAction()     // Catch:{ all -> 0x0085 }
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x0010
            com.google.android.gms.gcm.GcmReceiver.completeWakefulIntent(r5)
        L_0x000f:
            return
        L_0x0010:
            java.lang.String r0 = "message_type"
            java.lang.String r0 = r5.getStringExtra(r0)     // Catch:{ all -> 0x0085 }
            if (r0 != 0) goto L_0x00ab
            java.lang.String r0 = "gcm"
            r1 = r0
        L_0x001b:
            r0 = -1
            int r2 = r1.hashCode()     // Catch:{ all -> 0x0085 }
            switch(r2) {
                case -2062414158: goto L_0x005f;
                case 102161: goto L_0x0055;
                case 814694033: goto L_0x0073;
                case 814800675: goto L_0x0069;
                default: goto L_0x0023;
            }     // Catch:{ all -> 0x0085 }
        L_0x0023:
            switch(r0) {
                case 0: goto L_0x007d;
                case 1: goto L_0x008a;
                case 2: goto L_0x008e;
                case 3: goto L_0x0098;
                default: goto L_0x0026;
            }     // Catch:{ all -> 0x0085 }
        L_0x0026:
            java.lang.String r0 = "GcmListenerService"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0085 }
            r2.<init>()     // Catch:{ all -> 0x0085 }
            java.lang.String r3 = "Received message with unknown type: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0085 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0085 }
            android.util.Log.w(r0, r1)     // Catch:{ all -> 0x0085 }
        L_0x003e:
            java.lang.Object r1 = r4.zzpc     // Catch:{ all -> 0x0085 }
            monitor-enter(r1)     // Catch:{ all -> 0x0085 }
            int r0 = r4.zzazE     // Catch:{ all -> 0x00a8 }
            int r0 = r0 + -1
            r4.zzazE = r0     // Catch:{ all -> 0x00a8 }
            int r0 = r4.zzazE     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0050
            int r0 = r4.zzazD     // Catch:{ all -> 0x00a8 }
            r4.zzgr(r0)     // Catch:{ all -> 0x00a8 }
        L_0x0050:
            monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
            com.google.android.gms.gcm.GcmReceiver.completeWakefulIntent(r5)
            goto L_0x000f
        L_0x0055:
            java.lang.String r2 = "gcm"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0023
            r0 = 0
            goto L_0x0023
        L_0x005f:
            java.lang.String r2 = "deleted_messages"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0023
            r0 = 1
            goto L_0x0023
        L_0x0069:
            java.lang.String r2 = "send_event"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0023
            r0 = 2
            goto L_0x0023
        L_0x0073:
            java.lang.String r2 = "send_error"
            boolean r2 = r1.equals(r2)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0023
            r0 = 3
            goto L_0x0023
        L_0x007d:
            android.os.Bundle r0 = r5.getExtras()     // Catch:{ all -> 0x0085 }
            r4.zzt(r0)     // Catch:{ all -> 0x0085 }
            goto L_0x003e
        L_0x0085:
            r0 = move-exception
            com.google.android.gms.gcm.GcmReceiver.completeWakefulIntent(r5)
            throw r0
        L_0x008a:
            r4.onDeletedMessages()     // Catch:{ all -> 0x0085 }
            goto L_0x003e
        L_0x008e:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r5.getStringExtra(r0)     // Catch:{ all -> 0x0085 }
            r4.onMessageSent(r0)     // Catch:{ all -> 0x0085 }
            goto L_0x003e
        L_0x0098:
            java.lang.String r0 = "google.message_id"
            java.lang.String r0 = r5.getStringExtra(r0)     // Catch:{ all -> 0x0085 }
            java.lang.String r1 = "error"
            java.lang.String r1 = r5.getStringExtra(r1)     // Catch:{ all -> 0x0085 }
            r4.onSendError(r0, r1)     // Catch:{ all -> 0x0085 }
            goto L_0x003e
        L_0x00a8:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00a8 }
            throw r0     // Catch:{ all -> 0x0085 }
        L_0x00ab:
            r1 = r0
            goto L_0x001b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.GcmListenerService.zzk(android.content.Intent):void");
    }

    private void zzt(Bundle bundle) {
        bundle.remove("message_type");
        bundle.remove("android.support.content.wakelockid");
        if (zza.zzu(bundle)) {
            zza.zzay(this).zzv(bundle);
            return;
        }
        String string = bundle.getString("from");
        bundle.remove("from");
        onMessageReceived(string, bundle);
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public void onDeletedMessages() {
    }

    public void onMessageReceived(String from, Bundle data) {
    }

    public void onMessageSent(String msgId) {
    }

    public void onSendError(String msgId, String error) {
    }

    public final int onStartCommand(final Intent intent, int flags, int startId) {
        synchronized (this.zzpc) {
            this.zzazD = startId;
            this.zzazE++;
        }
        if (VERSION.SDK_INT >= 11) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() {
                public void run() {
                    GcmListenerService.this.zzk(intent);
                }
            });
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                /* renamed from: zzb */
                public Void doInBackground(Void... voidArr) {
                    GcmListenerService.this.zzk(intent);
                    return null;
                }
            }.execute(new Void[0]);
        }
        return 3;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzgr(int i) {
        return stopSelfResult(i);
    }
}
