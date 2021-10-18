package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzc {
    static String zzaBf = null;
    static int zzaBg = 0;
    static int zzaBh = 0;
    static int zzaBi = 0;
    Context context;
    Map<String, Object> zzaBj = new HashMap();
    Messenger zzaBk;
    MessengerCompat zzaBl;
    long zzaBm;
    long zzaBn;
    int zzaBo;
    int zzaBp;
    long zzaBq;
    PendingIntent zzazV;
    Messenger zzazZ;

    public zzc(Context context2) {
        this.context = context2;
    }

    static String zza(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return InstanceID.zzm(instance.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    public static String zzaD(Context context2) {
        if (zzaBf != null) {
            return zzaBf;
        }
        zzaBg = Process.myUid();
        PackageManager packageManager = context2.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", "Found " + applicationInfo.uid);
                    zzaBh = applicationInfo.uid;
                    zzaBf = resolveInfo.serviceInfo.packageName;
                    return zzaBf;
                } catch (NameNotFoundException e) {
                }
            } else {
                Log.w("InstanceID/Rpc", "Possible malicious package " + resolveInfo.serviceInfo.packageName + " declares " + "com.google.android.c2dm.intent.REGISTER" + " without permission");
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            zzaBf = applicationInfo2.packageName;
            zzaBh = applicationInfo2.uid;
            return zzaBf;
        } catch (NameNotFoundException e2) {
            try {
                ApplicationInfo applicationInfo3 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                zzaBf = applicationInfo3.packageName;
                zzaBh = applicationInfo3.uid;
                return zzaBf;
            } catch (NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    private Intent zzb(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzvE = zzvE();
        synchronized (getClass()) {
            this.zzaBj.put(zzvE, conditionVariable);
        }
        zza(bundle, keyPair, zzvE);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.zzaBj.remove(zzvE);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                Log.w("InstanceID/Rpc", "No response " + remove);
                throw new IOException(InstanceID.ERROR_TIMEOUT);
            }
        }
        return intent;
    }

    private void zzdo(String str) {
        if ("com.google.android.gsf".equals(zzaBf)) {
            this.zzaBo++;
            if (this.zzaBo >= 3) {
                if (this.zzaBo == 3) {
                    this.zzaBp = new Random().nextInt(1000) + 1000;
                }
                this.zzaBp *= 2;
                this.zzaBq = SystemClock.elapsedRealtime() + ((long) this.zzaBp);
                Log.w("InstanceID/Rpc", "Backoff due to " + str + " for " + this.zzaBp);
            }
        }
    }

    private void zze(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                Log.w("InstanceID/Rpc", "Failed to send response " + e);
            }
        }
    }

    private void zzi(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzaBj.get(str);
            this.zzaBj.put(str, obj);
            zze(obj2, obj);
        }
    }

    public static synchronized String zzvE() {
        String num;
        synchronized (zzc.class) {
            int i = zzaBi;
            zzaBi = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    private void zzz(Object obj) {
        synchronized (getClass()) {
            for (String str : this.zzaBj.keySet()) {
                Object obj2 = this.zzaBj.get(str);
                this.zzaBj.put(str, obj);
                zze(obj2, obj);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public Intent zza(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent zzb = zzb(bundle, keyPair);
        return (zzb == null || !zzb.hasExtra("google.messenger")) ? zzb : zzb(bundle, keyPair);
    }

    /* access modifiers changed from: 0000 */
    public void zza(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.zzaBq == 0 || elapsedRealtime > this.zzaBq) {
            zzvD();
            if (zzaBf == null) {
                throw new IOException(InstanceID.ERROR_MISSING_INSTANCEID_SERVICE);
            }
            this.zzaBm = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaBf);
            bundle.putString("gmsv", Integer.toString(GoogleCloudMessaging.zzaA(this.context)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(InstanceID.zzaB(this.context)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", InstanceID.zza(keyPair));
            String zzm = InstanceID.zzm(keyPair.getPublic().getEncoded());
            bundle.putString("pub2", zzm);
            bundle.putString("sig", zza(keyPair, this.context.getPackageName(), zzm));
            intent.putExtras(bundle);
            zzo(intent);
            zzb(intent, str);
            return;
        }
        Log.w("InstanceID/Rpc", "Backoff mode, next request attempt: " + (this.zzaBq - elapsedRealtime) + " interval: " + this.zzaBp);
        throw new IOException(InstanceID.ERROR_BACKOFF);
    }

    /* access modifiers changed from: protected */
    public void zzb(Intent intent, String str) {
        this.zzaBm = SystemClock.elapsedRealtime();
        intent.putExtra("kid", "|ID|" + str + "|");
        intent.putExtra("X-kid", "|ID|" + str + "|");
        boolean equals = "com.google.android.gsf".equals(zzaBf);
        String stringExtra = intent.getStringExtra("useGsf");
        if (stringExtra != null) {
            equals = "1".equals(stringExtra);
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Sending " + intent.getExtras());
        }
        if (this.zzaBk != null) {
            intent.putExtra("google.messenger", this.zzazZ);
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                this.zzaBk.send(obtain);
                return;
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        if (equals) {
            Intent intent2 = new Intent("com.google.android.gms.iid.InstanceID");
            intent2.setPackage(this.context.getPackageName());
            intent2.putExtra("GSF", intent);
            this.context.startService(intent2);
            return;
        }
        intent.putExtra("google.messenger", this.zzazZ);
        intent.putExtra("messenger2", "1");
        if (this.zzaBl != null) {
            Message obtain2 = Message.obtain();
            obtain2.obj = intent;
            try {
                this.zzaBl.send(obtain2);
                return;
            } catch (RemoteException e2) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.context.startService(intent);
    }

    public void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.zzaBl = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.zzaBk = (Messenger) parcelableExtra;
                    }
                }
                zzr((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzo(Intent intent) {
        if (this.zzazV == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzazV = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzazV);
    }

    /* access modifiers changed from: 0000 */
    public String zzp(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR);
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        Log.w("InstanceID/Rpc", "Unexpected response from GCM " + intent.getExtras(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* access modifiers changed from: 0000 */
    public void zzq(Intent intent) {
        String stringExtra = intent.getStringExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR);
        if (stringExtra == null) {
            Log.w("InstanceID/Rpc", "Unexpected response, no error or registration id " + intent.getExtras());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received InstanceID error " + stringExtra);
        }
        String str = null;
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                Log.w("InstanceID/Rpc", "Unexpected structured response " + stringExtra);
            }
            if (split.length > 2) {
                str = split[2];
                stringExtra = split[3];
                if (stringExtra.startsWith(":")) {
                    stringExtra = stringExtra.substring(1);
                }
            } else {
                stringExtra = "UNKNOWN";
            }
            intent.putExtra(MediaRouteProviderProtocol.SERVICE_DATA_ERROR, stringExtra);
        }
        if (str == null) {
            zzz(stringExtra);
        } else {
            zzi(str, stringExtra);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.zzaBn = SystemClock.elapsedRealtime();
            this.zzaBp = ((int) longExtra) * 1000;
            this.zzaBq = SystemClock.elapsedRealtime() + ((long) this.zzaBp);
            Log.w("InstanceID/Rpc", "Explicit request from server to backoff: " + this.zzaBp);
        } else if ("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) {
            zzdo(stringExtra);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzr(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
                String stringExtra = intent.getStringExtra("registration_id");
                String str = stringExtra == null ? intent.getStringExtra("unregistered") : stringExtra;
                if (str == null) {
                    zzq(intent);
                    return;
                }
                this.zzaBm = SystemClock.elapsedRealtime();
                this.zzaBq = 0;
                this.zzaBo = 0;
                this.zzaBp = 0;
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "AppIDResponse: " + str + " " + intent.getExtras());
                }
                String str2 = null;
                if (str.startsWith("|")) {
                    String[] split = str.split("\\|");
                    if (!"ID".equals(split[1])) {
                        Log.w("InstanceID/Rpc", "Unexpected structured response " + str);
                    }
                    String str3 = split[2];
                    if (split.length > 4) {
                        if ("SYNC".equals(split[3])) {
                            InstanceIDListenerService.zzaC(this.context);
                        } else if ("RST".equals(split[3])) {
                            InstanceIDListenerService.zza(this.context, InstanceID.getInstance(this.context).zzvA());
                            intent.removeExtra("registration_id");
                            zzi(str3, intent);
                            return;
                        }
                    }
                    String str4 = split[split.length - 1];
                    if (str4.startsWith(":")) {
                        str4 = str4.substring(1);
                    }
                    intent.putExtra("registration_id", str4);
                    str2 = str3;
                }
                if (str2 == null) {
                    zzz(intent);
                } else {
                    zzi(str2, intent);
                }
            } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response " + intent.getAction());
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Unexpected response: null");
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzvD() {
        if (this.zzazZ == null) {
            zzaD(this.context);
            this.zzazZ = new Messenger(new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message msg) {
                    zzc.this.zze(msg);
                }
            });
        }
    }
}
