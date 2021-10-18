package com.google.android.gms.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqx.zza;
import com.google.android.gms.tagmanager.zzbg;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class zzqy implements Runnable {
    private final Context mContext;
    private final zzqw zzaRm;
    private final zzqn zzaUo;
    private final zzqx zzaUv;
    private final zzqs zzaUw;

    public zzqy(Context context, zzqn zzqn, zzqx zzqx) {
        this(context, zzqn, zzqx, new zzqw(), new zzqs());
    }

    zzqy(Context context, zzqn zzqn, zzqx zzqx, zzqw zzqw, zzqs zzqs) {
        zzx.zzv(context);
        zzx.zzv(zzqx);
        this.mContext = context;
        this.zzaUo = zzqn;
        this.zzaUv = zzqx;
        this.zzaRm = zzqw;
        this.zzaUw = zzqs;
    }

    public zzqy(Context context, zzqn zzqn, zzqx zzqx, String str) {
        this(context, zzqn, zzqx, new zzqw(), new zzqs());
        this.zzaUw.zzfj(str);
    }

    public void run() {
        zzeP();
    }

    /* access modifiers changed from: 0000 */
    public boolean zzBY() {
        if (!zzbf("android.permission.INTERNET")) {
            zzbg.m28e("Missing android.permission.INTERNET. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.INTERNET\" />");
            return false;
        } else if (!zzbf("android.permission.ACCESS_NETWORK_STATE")) {
            zzbg.m28e("Missing android.permission.ACCESS_NETWORK_STATE. Please add the following declaration to your AndroidManifest.xml: <uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />");
            return false;
        } else {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return true;
            }
            zzbg.zzaE("NetworkLoader: No network connectivity - Offline");
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzbf(String str) {
        return this.mContext.getPackageManager().checkPermission(str, this.mContext.getPackageName()) == 0;
    }

    /* access modifiers changed from: 0000 */
    public void zzeP() {
        String zzt;
        if (!zzBY()) {
            this.zzaUv.zza(zza.NOT_AVAILABLE);
            return;
        }
        zzbg.m29v("NetworkLoader: Starting to load resource from Network.");
        zzqv zzBW = this.zzaRm.zzBW();
        try {
            zzt = this.zzaUw.zzt(this.zzaUo.zzBv());
            InputStream zzfs = zzBW.zzfs(zzt);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzlr.zza(zzfs, (OutputStream) byteArrayOutputStream);
                this.zzaUv.zzu(byteArrayOutputStream.toByteArray());
                zzBW.close();
                zzbg.m29v("NetworkLoader: Resource loaded.");
            } catch (IOException e) {
                zzbg.zzb("NetworkLoader: Error when parsing downloaded resources from url: " + zzt + " " + e.getMessage(), e);
                this.zzaUv.zza(zza.SERVER_ERROR);
                zzBW.close();
            }
        } catch (FileNotFoundException e2) {
            zzbg.m28e("NetworkLoader: No data is retrieved from the given url: " + zzt);
            this.zzaUv.zza(zza.SERVER_ERROR);
            zzBW.close();
        } catch (IOException e3) {
            zzbg.zzb("NetworkLoader: Error when loading resource from url: " + zzt + " " + e3.getMessage(), e3);
            this.zzaUv.zza(zza.IO_ERROR);
            zzBW.close();
        } catch (Throwable th) {
            zzBW.close();
            throw th;
        }
    }
}
