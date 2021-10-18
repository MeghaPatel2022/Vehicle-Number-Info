package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class zzz implements zzar {
    private static final Object zzaOF = new Object();
    private static zzz zzaPU;
    private String zzaPV;
    private String zzaPW;
    private zzas zzaPX;
    private zzcd zzaPi;

    private zzz(Context context) {
        this(zzat.zzaO(context), new zzcs());
    }

    zzz(zzas zzas, zzcd zzcd) {
        this.zzaPX = zzas;
        this.zzaPi = zzcd;
    }

    public static zzar zzaM(Context context) {
        zzz zzz;
        synchronized (zzaOF) {
            if (zzaPU == null) {
                zzaPU = new zzz(context);
            }
            zzz = zzaPU;
        }
        return zzz;
    }

    public boolean zzeH(String str) {
        if (!this.zzaPi.zzkp()) {
            zzbg.zzaE("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
            return false;
        }
        if (!(this.zzaPV == null || this.zzaPW == null)) {
            try {
                str = this.zzaPV + "?" + this.zzaPW + "=" + URLEncoder.encode(str, "UTF-8");
                zzbg.m29v("Sending wrapped url hit: " + str);
            } catch (UnsupportedEncodingException e) {
                zzbg.zzd("Error wrapping URL for testing.", e);
                return false;
            }
        }
        this.zzaPX.zzeL(str);
        return true;
    }
}
