package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.p000v4.content.ContextCompat;
import android.util.Base64;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class zzd {
    Context context;
    SharedPreferences zzaBs;

    public zzd(Context context2) {
        this(context2, "com.google.android.gms.appid");
    }

    public zzd(Context context2, String str) {
        this.context = context2;
        this.zzaBs = context2.getSharedPreferences(str, 4);
        zzdp(str + "-no-backup");
    }

    private void zzdp(String str) {
        File file = new File(new ContextCompat().getNoBackupFilesDir(this.context), str);
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    Log.i("InstanceID/Store", "App restored, clearing state");
                    InstanceIDListenerService.zza(this.context, this);
                }
            } catch (IOException e) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    Log.d("InstanceID/Store", "Error creating file in no backup dir: " + e.getMessage());
                }
            }
        }
    }

    private String zzf(String str, String str2, String str3) {
        return str + "|T|" + str2 + "|" + str3;
    }

    /* access modifiers changed from: 0000 */
    public synchronized String get(String key) {
        return this.zzaBs.getString(key, null);
    }

    /* access modifiers changed from: 0000 */
    public synchronized String get(String subtype, String key) {
        return this.zzaBs.getString(subtype + "|S|" + key, null);
    }

    /* access modifiers changed from: 0000 */
    public boolean isEmpty() {
        return this.zzaBs.getAll().isEmpty();
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zza(Editor editor, String str, String str2, String str3) {
        editor.putString(str + "|S|" + str2, str3);
    }

    public synchronized void zza(String str, String str2, String str3, String str4, String str5) {
        String zzf = zzf(str, str2, str3);
        Editor edit = this.zzaBs.edit();
        edit.putString(zzf, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
    }

    public synchronized void zzdq(String str) {
        Editor edit = this.zzaBs.edit();
        for (String str2 : this.zzaBs.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
    }

    public KeyPair zzdr(String str) {
        return zzdu(str);
    }

    /* access modifiers changed from: 0000 */
    public void zzds(String str) {
        zzdq(str + "|");
    }

    public void zzdt(String str) {
        zzdq(str + "|T|");
    }

    /* access modifiers changed from: 0000 */
    public KeyPair zzdu(String str) {
        String str2 = get(str, "|P|");
        String str3 = get(str, "|K|");
        if (str3 == null) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str2, 8);
            byte[] decode2 = Base64.decode(str3, 8);
            KeyFactory instance = KeyFactory.getInstance("RSA");
            return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.w("InstanceID/Store", "Invalid key stored " + e);
            InstanceIDListenerService.zza(this.context, this);
            return null;
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized KeyPair zze(String str, long j) {
        KeyPair zzvx;
        zzvx = zza.zzvx();
        Editor edit = this.zzaBs.edit();
        zza(edit, str, "|P|", InstanceID.zzm(zzvx.getPublic().getEncoded()));
        zza(edit, str, "|K|", InstanceID.zzm(zzvx.getPrivate().getEncoded()));
        zza(edit, str, "cre", Long.toString(j));
        edit.commit();
        return zzvx;
    }

    public synchronized String zzg(String str, String str2, String str3) {
        return this.zzaBs.getString(zzf(str, str2, str3), null);
    }

    public synchronized void zzh(String str, String str2, String str3) {
        String zzf = zzf(str, str2, str3);
        Editor edit = this.zzaBs.edit();
        edit.remove(zzf);
        edit.commit();
    }

    public synchronized void zzvF() {
        this.zzaBs.edit().clear().commit();
    }
}
