package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqw;
import com.google.android.gms.tagmanager.zzbf.zza;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

class zzcl implements Runnable {
    private final Context mContext;
    private final String zzaOS;
    private volatile String zzaPp;
    private final zzqw zzaRm;
    private final String zzaRn;
    private zzbf<zzj> zzaRo;
    private volatile zzs zzaRp;
    private volatile String zzaRq;

    zzcl(Context context, String str, zzqw zzqw, zzs zzs) {
        this.mContext = context;
        this.zzaRm = zzqw;
        this.zzaOS = str;
        this.zzaRp = zzs;
        this.zzaRn = "/r?id=" + str;
        this.zzaPp = this.zzaRn;
        this.zzaRq = null;
    }

    public zzcl(Context context, String str, zzs zzs) {
        this(context, str, new zzqw(), zzs);
    }

    private boolean zzAy() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.m29v("...no network connectivity");
        return false;
    }

    private void zzAz() {
        if (!zzAy()) {
            this.zzaRo.zza(zza.NOT_AVAILABLE);
            return;
        }
        zzbg.m29v("Start loading resource from network ...");
        String zzAA = zzAA();
        zzqv zzBW = this.zzaRm.zzBW();
        try {
            InputStream zzfs = zzBW.zzfs(zzAA);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqp.zzc(zzfs, byteArrayOutputStream);
                zzj zzd = zzj.zzd(byteArrayOutputStream.toByteArray());
                zzbg.m29v("Successfully loaded supplemented resource: " + zzd);
                if (zzd.zziR == null && zzd.zziQ.length == 0) {
                    zzbg.m29v("No change for container: " + this.zzaOS);
                }
                this.zzaRo.zzB(zzd);
                zzBW.close();
                zzbg.m29v("Load resource from network finished.");
            } catch (IOException e) {
                zzbg.zzd("Error when parsing downloaded resources from url: " + zzAA + " " + e.getMessage(), e);
                this.zzaRo.zza(zza.SERVER_ERROR);
                zzBW.close();
            }
        } catch (FileNotFoundException e2) {
            zzbg.zzaE("No data is retrieved from the given url: " + zzAA + ". Make sure container_id: " + this.zzaOS + " is correct.");
            this.zzaRo.zza(zza.SERVER_ERROR);
            zzBW.close();
        } catch (IOException e3) {
            zzbg.zzd("Error when loading resources from url: " + zzAA + " " + e3.getMessage(), e3);
            this.zzaRo.zza(zza.IO_ERROR);
            zzBW.close();
        } catch (Throwable th) {
            zzBW.close();
            throw th;
        }
    }

    public void run() {
        if (this.zzaRo == null) {
            throw new IllegalStateException("callback must be set before execute");
        }
        this.zzaRo.zzzL();
        zzAz();
    }

    /* access modifiers changed from: 0000 */
    public String zzAA() {
        String str = this.zzaRp.zzzN() + this.zzaPp + "&v=a65833898";
        if (this.zzaRq != null && !this.zzaRq.trim().equals("")) {
            str = str + "&pv=" + this.zzaRq;
        }
        return zzcb.zzAv().zzAw().equals(zza.CONTAINER_DEBUG) ? str + "&gtm_debug=x" : str;
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzbf<zzj> zzbf) {
        this.zzaRo = zzbf;
    }

    /* access modifiers changed from: 0000 */
    public void zzeB(String str) {
        if (str == null) {
            this.zzaPp = this.zzaRn;
            return;
        }
        zzbg.zzaC("Setting CTFE URL path: " + str);
        this.zzaPp = str;
    }

    /* access modifiers changed from: 0000 */
    public void zzeQ(String str) {
        zzbg.zzaC("Setting previous container version: " + str);
        this.zzaRq = str;
    }
}
