package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.util.Log;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzc;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    public static int zzazR = 5000000;
    public static int zzazS = 6500000;
    public static int zzazT = 7000000;
    static GoogleCloudMessaging zzazU;
    private static final AtomicInteger zzazX = new AtomicInteger(1);
    /* access modifiers changed from: private */
    public Context context;
    private PendingIntent zzazV;
    private Map<String, Handler> zzazW = Collections.synchronizedMap(new HashMap());
    /* access modifiers changed from: private */
    public final BlockingQueue<Intent> zzazY = new LinkedBlockingQueue();
    final Messenger zzazZ = new Messenger(new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg == null || !(msg.obj instanceof Intent)) {
                Log.w(GoogleCloudMessaging.INSTANCE_ID_SCOPE, "Dropping invalid message");
            }
            Intent intent = (Intent) msg.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                GoogleCloudMessaging.this.zzazY.add(intent);
            } else if (!GoogleCloudMessaging.this.zzl(intent)) {
                intent.setPackage(GoogleCloudMessaging.this.context.getPackageName());
                GoogleCloudMessaging.this.context.sendBroadcast(intent);
            }
        }
    });

    public static synchronized GoogleCloudMessaging getInstance(Context context2) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            if (zzazU == null) {
                zzazU = new GoogleCloudMessaging();
                zzazU.context = context2.getApplicationContext();
            }
            googleCloudMessaging = zzazU;
        }
        return googleCloudMessaging;
    }

    static String zza(Intent intent, String str) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra(str);
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR);
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private void zza(String str, String str2, long j, int i, Bundle bundle) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zzm(intent);
        intent.setPackage(zzaz(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j));
        intent.putExtra("google.delay", Integer.toString(i));
        if (zzaz(this.context).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            InstanceID.getInstance(this.context).zzc(INSTANCE_ID_SCOPE, "upstream", bundle2);
            return;
        }
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public static int zzaA(Context context2) {
        try {
            return context2.getPackageManager().getPackageInfo(zzaz(context2), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    public static String zzaz(Context context2) {
        return zzc.zzaD(context2);
    }

    /* access modifiers changed from: private */
    public boolean zzl(Intent intent) {
        String stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR)) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) this.zzazW.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    private String zzvm() {
        return "google.rpc" + String.valueOf(zzazX.getAndIncrement());
    }

    public void close() {
        zzazU = null;
        zza.zzazH = null;
        zzvn();
    }

    public String getMessageType(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? MESSAGE_TYPE_MESSAGE : stringExtra;
    }

    @Deprecated
    public synchronized String register(String... senderIds) throws IOException {
        String zza;
        String zzc = zzc(senderIds);
        Bundle bundle = new Bundle();
        if (zzaz(this.context).contains(".gsf")) {
            bundle.putString("legacy.sender", zzc);
            zza = InstanceID.getInstance(this.context).getToken(zzc, INSTANCE_ID_SCOPE, bundle);
        } else {
            bundle.putString("sender", zzc);
            zza = zza(zzy(bundle), "registration_id");
        }
        return zza;
    }

    public void send(String to, String msgId, long timeToLive, Bundle data) throws IOException {
        zza(to, msgId, timeToLive, -1, data);
    }

    public void send(String to, String msgId, Bundle data) throws IOException {
        send(to, msgId, -1, data);
    }

    @Deprecated
    public synchronized void unregister() throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        InstanceID.getInstance(this.context).deleteInstanceID();
    }

    /* access modifiers changed from: 0000 */
    public String zzc(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("No senderIds");
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(',').append(strArr[i]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzm(Intent intent) {
        if (this.zzazV == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzazV = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzazV);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzvn() {
        if (this.zzazV != null) {
            this.zzazV.cancel();
            this.zzazV = null;
        }
    }

    /* access modifiers changed from: 0000 */
    @Deprecated
    public Intent zzy(Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (zzaA(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            if (bundle == null) {
                bundle = new Bundle();
            }
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaz(this.context));
            zzm(intent);
            intent.putExtra("google.message_id", zzvm());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.zzazZ);
            this.context.startService(intent);
            try {
                return (Intent) this.zzazY.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}
