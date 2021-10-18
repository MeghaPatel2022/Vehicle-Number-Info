package com.google.android.gms.iid;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class InstanceID {
    public static final String ERROR_BACKOFF = "RETRY_LATER";
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_MISSING_INSTANCEID_SERVICE = "MISSING_INSTANCEID_SERVICE";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String ERROR_TIMEOUT = "TIMEOUT";
    static Map<String, InstanceID> zzaAO = new HashMap();
    private static zzd zzaAP;
    private static zzc zzaAQ;
    static String zzaAU;
    Context mContext;
    KeyPair zzaAR;
    String zzaAS = "";
    long zzaAT;

    protected InstanceID(Context context, String subtype, Bundle options) {
        this.mContext = context.getApplicationContext();
        this.zzaAS = subtype;
    }

    public static InstanceID getInstance(Context context) {
        return zza(context, null);
    }

    public static synchronized InstanceID zza(Context context, Bundle bundle) {
        InstanceID instanceID;
        synchronized (InstanceID.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (zzaAP == null) {
                zzaAP = new zzd(applicationContext);
                zzaAQ = new zzc(applicationContext);
            }
            zzaAU = Integer.toString(zzaB(applicationContext));
            instanceID = (InstanceID) zzaAO.get(str);
            if (instanceID == null) {
                instanceID = new InstanceID(applicationContext, str, bundle);
                zzaAO.put(str, instanceID);
            }
        }
        return instanceID;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("InstanceID", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static int zzaB(Context context) {
        boolean z = false;
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            Log.w("InstanceID", "Never happens: can't find own package " + e);
            return z;
        }
    }

    static String zzm(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    public void deleteInstanceID() throws IOException {
        zzb("*", "*", null);
        zzvz();
    }

    public void deleteToken(String authorizedEntity, String scope) throws IOException {
        zzb(authorizedEntity, scope, null);
    }

    public long getCreationTime() {
        if (this.zzaAT == 0) {
            String str = zzaAP.get(this.zzaAS, "cre");
            if (str != null) {
                this.zzaAT = Long.parseLong(str);
            }
        }
        return this.zzaAT;
    }

    public String getId() {
        return zza(zzvy());
    }

    public String getToken(String authorizedEntity, String scope) throws IOException {
        return getToken(authorizedEntity, scope, null);
    }

    public String getToken(String authorizedEntity, String scope, Bundle extras) throws IOException {
        boolean z = false;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        boolean z2 = true;
        String zzg = zzvC() ? null : zzaAP.zzg(this.zzaAS, authorizedEntity, scope);
        if (zzg == null) {
            if (extras == null) {
                extras = new Bundle();
            }
            if (extras.getString("ttl") != null) {
                z2 = false;
            }
            if (!"jwt".equals(extras.getString("type"))) {
                z = z2;
            }
            zzg = zzc(authorizedEntity, scope, extras);
            Log.w("InstanceID", "token: " + zzg);
            if (zzg != null && z) {
                zzaAP.zza(this.zzaAS, authorizedEntity, scope, zzg, zzaAU);
            }
        }
        return zzg;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        zzaAP.zzh(this.zzaAS, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.zzaAS) ? str : this.zzaAS);
        String str3 = "X-subtype";
        if (!"".equals(this.zzaAS)) {
            str = this.zzaAS;
        }
        bundle.putString(str3, str);
        zzaAQ.zzp(zzaAQ.zza(bundle, zzvy()));
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.zzaAS) ? str : this.zzaAS;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return zzaAQ.zzp(zzaAQ.zza(bundle, zzvy()));
    }

    /* access modifiers changed from: 0000 */
    public zzd zzvA() {
        return zzaAP;
    }

    /* access modifiers changed from: 0000 */
    public zzc zzvB() {
        return zzaAQ;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzvC() {
        String str = zzaAP.get("appVersion");
        if (str == null || !str.equals(zzaAU)) {
            return true;
        }
        String str2 = zzaAP.get("lastToken");
        if (str2 == null) {
            return true;
        }
        return (System.currentTimeMillis() / 1000) - Long.valueOf(Long.parseLong(str2)).longValue() > 604800;
    }

    /* access modifiers changed from: 0000 */
    public KeyPair zzvy() {
        if (this.zzaAR == null) {
            this.zzaAR = zzaAP.zzdr(this.zzaAS);
        }
        if (this.zzaAR == null) {
            this.zzaAT = System.currentTimeMillis();
            this.zzaAR = zzaAP.zze(this.zzaAS, this.zzaAT);
        }
        return this.zzaAR;
    }

    /* access modifiers changed from: 0000 */
    public void zzvz() {
        this.zzaAT = 0;
        zzaAP.zzds(this.zzaAS);
        this.zzaAR = null;
    }
}
