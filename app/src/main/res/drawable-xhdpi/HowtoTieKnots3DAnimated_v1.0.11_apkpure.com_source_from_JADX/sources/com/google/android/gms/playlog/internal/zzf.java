package com.google.android.gms.playlog.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.playlog.internal.zza.C1535zza;
import com.google.android.gms.playlog.internal.zzb.zza;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class zzf extends zzj<zza> {
    private final String zzOZ;
    private final zzd zzaKZ;
    private final zzb zzaLa = new zzb();
    private boolean zzaLb = true;
    private final Object zzpc = new Object();

    public zzf(Context context, Looper looper, zzd zzd, com.google.android.gms.common.internal.zzf zzf) {
        super(context, looper, 24, zzf, zzd, zzd);
        this.zzOZ = context.getPackageName();
        this.zzaKZ = (zzd) zzx.zzv(zzd);
        this.zzaKZ.zza(this);
    }

    private void zzc(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        this.zzaLa.zza(playLoggerContext, logEvent);
    }

    private void zzd(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        try {
            zzyE();
            ((zza) zzoA()).zza(this.zzOZ, playLoggerContext, logEvent);
        } catch (RemoteException e) {
            Log.e("PlayLoggerImpl", "Couldn't send log event.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        } catch (IllegalStateException e2) {
            Log.e("PlayLoggerImpl", "Service was disconnected.  Will try caching.");
            zzc(playLoggerContext, logEvent);
        }
    }

    private void zzyE() {
        PlayLoggerContext playLoggerContext;
        zzb.zzY(!this.zzaLb);
        if (!this.zzaLa.isEmpty()) {
            PlayLoggerContext playLoggerContext2 = null;
            try {
                ArrayList arrayList = new ArrayList();
                Iterator it = this.zzaLa.zzyC().iterator();
                while (it.hasNext()) {
                    zza zza = (zza) it.next();
                    if (zza.zzaKO != null) {
                        ((zza) zzoA()).zza(this.zzOZ, zza.zzaKM, zzrx.zzf(zza.zzaKO));
                    } else {
                        if (zza.zzaKM.equals(playLoggerContext2)) {
                            arrayList.add(zza.zzaKN);
                            playLoggerContext = playLoggerContext2;
                        } else {
                            if (!arrayList.isEmpty()) {
                                ((zza) zzoA()).zza(this.zzOZ, playLoggerContext2, (List<LogEvent>) arrayList);
                                arrayList.clear();
                            }
                            PlayLoggerContext playLoggerContext3 = zza.zzaKM;
                            arrayList.add(zza.zzaKN);
                            playLoggerContext = playLoggerContext3;
                        }
                        playLoggerContext2 = playLoggerContext;
                    }
                }
                if (!arrayList.isEmpty()) {
                    ((zza) zzoA()).zza(this.zzOZ, playLoggerContext2, (List<LogEvent>) arrayList);
                }
                this.zzaLa.clear();
            } catch (RemoteException e) {
                Log.e("PlayLoggerImpl", "Couldn't send cached log events to AndroidLog service.  Retaining in memory cache.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void start() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.zzpc
            monitor-enter(r1)
            boolean r0 = r3.isConnecting()     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x000f
            boolean r0 = r3.isConnected()     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0011
        L_0x000f:
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.playlog.internal.zzd r0 = r3.zzaKZ     // Catch:{ all -> 0x001c }
            r2 = 1
            r0.zzan(r2)     // Catch:{ all -> 0x001c }
            r3.zzox()     // Catch:{ all -> 0x001c }
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            goto L_0x0010
        L_0x001c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zzf.start():void");
    }

    public void stop() {
        synchronized (this.zzpc) {
            this.zzaKZ.zzan(false);
            disconnect();
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzao(boolean z) {
        synchronized (this.zzpc) {
            boolean z2 = this.zzaLb;
            this.zzaLb = z;
            if (z2 && !this.zzaLb) {
                zzyE();
            }
        }
    }

    public void zzb(PlayLoggerContext playLoggerContext, LogEvent logEvent) {
        synchronized (this.zzpc) {
            if (this.zzaLb) {
                zzc(playLoggerContext, logEvent);
            } else {
                zzd(playLoggerContext, logEvent);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdu */
    public zza zzV(IBinder iBinder) {
        return C1535zza.zzdt(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.playlog.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.playlog.internal.IPlayLogService";
    }
}
