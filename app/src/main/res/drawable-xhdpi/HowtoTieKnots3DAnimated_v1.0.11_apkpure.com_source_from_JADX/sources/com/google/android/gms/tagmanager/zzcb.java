package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcb {
    private static zzcb zzaQY;
    private volatile String zzaOS;
    private volatile zza zzaQZ;
    private volatile String zzaRa;
    private volatile String zzaRb;

    enum zza {
        NONE,
        CONTAINER,
        CONTAINER_DEBUG
    }

    zzcb() {
        clear();
    }

    static zzcb zzAv() {
        zzcb zzcb;
        synchronized (zzcb.class) {
            if (zzaQY == null) {
                zzaQY = new zzcb();
            }
            zzcb = zzaQY;
        }
        return zzcb;
    }

    private String zzeP(String str) {
        return str.split("&")[0].split("=")[1];
    }

    private String zzn(Uri uri) {
        return uri.getQuery().replace("&gtm_debug=x", "");
    }

    /* access modifiers changed from: 0000 */
    public void clear() {
        this.zzaQZ = zza.NONE;
        this.zzaRa = null;
        this.zzaOS = null;
        this.zzaRb = null;
    }

    /* access modifiers changed from: 0000 */
    public String getContainerId() {
        return this.zzaOS;
    }

    /* access modifiers changed from: 0000 */
    public zza zzAw() {
        return this.zzaQZ;
    }

    /* access modifiers changed from: 0000 */
    public String zzAx() {
        return this.zzaRa;
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean zzm(Uri uri) {
        boolean z = true;
        synchronized (this) {
            try {
                String decode = URLDecoder.decode(uri.toString(), "UTF-8");
                if (decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
                    zzbg.m29v("Container preview url: " + decode);
                    if (decode.matches(".*?&gtm_debug=x$")) {
                        this.zzaQZ = zza.CONTAINER_DEBUG;
                    } else {
                        this.zzaQZ = zza.CONTAINER;
                    }
                    this.zzaRb = zzn(uri);
                    if (this.zzaQZ == zza.CONTAINER || this.zzaQZ == zza.CONTAINER_DEBUG) {
                        this.zzaRa = "/r?" + this.zzaRb;
                    }
                    this.zzaOS = zzeP(this.zzaRb);
                } else if (!decode.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$")) {
                    zzbg.zzaE("Invalid preview uri: " + decode);
                    z = false;
                } else if (zzeP(uri.getQuery()).equals(this.zzaOS)) {
                    zzbg.m29v("Exit preview mode for container: " + this.zzaOS);
                    this.zzaQZ = zza.NONE;
                    this.zzaRa = null;
                } else {
                    z = false;
                }
            } catch (UnsupportedEncodingException e) {
                z = false;
            }
        }
        return z;
    }
}
