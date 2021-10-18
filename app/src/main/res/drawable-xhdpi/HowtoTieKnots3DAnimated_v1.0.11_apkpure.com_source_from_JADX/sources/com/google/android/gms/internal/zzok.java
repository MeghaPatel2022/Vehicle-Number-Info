package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;

public final class zzok extends zzod<zzok> {
    private String zzNT;
    private String zzNU;
    private String zzaIs;
    private String zzaIt;

    public void setAppId(String value) {
        this.zzaIs = value;
    }

    public void setAppInstallerId(String value) {
        this.zzaIt = value;
    }

    public void setAppName(String value) {
        this.zzNT = value;
    }

    public void setAppVersion(String value) {
        this.zzNU = value;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.zzNT);
        hashMap.put("appVersion", this.zzNU);
        hashMap.put("appId", this.zzaIs);
        hashMap.put("appInstallerId", this.zzaIt);
        return zzA(hashMap);
    }

    public void zza(zzok zzok) {
        if (!TextUtils.isEmpty(this.zzNT)) {
            zzok.setAppName(this.zzNT);
        }
        if (!TextUtils.isEmpty(this.zzNU)) {
            zzok.setAppVersion(this.zzNU);
        }
        if (!TextUtils.isEmpty(this.zzaIs)) {
            zzok.setAppId(this.zzaIs);
        }
        if (!TextUtils.isEmpty(this.zzaIt)) {
            zzok.setAppInstallerId(this.zzaIt);
        }
    }

    public String zzjZ() {
        return this.zzNT;
    }

    public String zzkb() {
        return this.zzNU;
    }

    public String zztW() {
        return this.zzaIs;
    }

    public String zzxA() {
        return this.zzaIt;
    }
}
