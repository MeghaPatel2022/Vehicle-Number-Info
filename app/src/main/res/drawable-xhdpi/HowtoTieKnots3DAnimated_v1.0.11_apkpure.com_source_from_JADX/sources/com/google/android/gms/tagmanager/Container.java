package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzaf.zzi;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqp.zzg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Container {
    private final Context mContext;
    private final String zzaOS;
    private final DataLayer zzaOT;
    private zzcp zzaOU;
    private Map<String, FunctionCallMacroCallback> zzaOV = new HashMap();
    private Map<String, FunctionCallTagCallback> zzaOW = new HashMap();
    private volatile long zzaOX;
    private volatile String zzaOY = "";

    public interface FunctionCallMacroCallback {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagCallback {
        void execute(String str, Map<String, Object> map);
    }

    private class zza implements com.google.android.gms.tagmanager.zzt.zza {
        private zza() {
        }

        public Object zzd(String str, Map<String, Object> map) {
            FunctionCallMacroCallback zzeu = Container.this.zzeu(str);
            if (zzeu == null) {
                return null;
            }
            return zzeu.getValue(str, map);
        }
    }

    private class zzb implements com.google.android.gms.tagmanager.zzt.zza {
        private zzb() {
        }

        public Object zzd(String str, Map<String, Object> map) {
            FunctionCallTagCallback zzev = Container.this.zzev(str);
            if (zzev != null) {
                zzev.execute(str, map);
            }
            return zzdf.zzBf();
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzj resource) {
        this.mContext = context;
        this.zzaOT = dataLayer;
        this.zzaOS = containerId;
        this.zzaOX = lastRefreshTime;
        zza(resource.zziR);
        if (resource.zziQ != null) {
            zza(resource.zziQ);
        }
    }

    Container(Context context, DataLayer dataLayer, String containerId, long lastRefreshTime, zzc resource) {
        this.mContext = context;
        this.zzaOT = dataLayer;
        this.zzaOS = containerId;
        this.zzaOX = lastRefreshTime;
        zza(resource);
    }

    private void zza(zzf zzf) {
        if (zzf == null) {
            throw new NullPointerException();
        }
        try {
            zza(zzqp.zzb(zzf));
        } catch (zzg e) {
            zzbg.m28e("Not loading resource: " + zzf + " because it is invalid: " + e.toString());
        }
    }

    private void zza(zzc zzc) {
        this.zzaOY = zzc.getVersion();
        zzc zzc2 = zzc;
        zza(new zzcp(this.mContext, zzc2, this.zzaOT, new zza(), new zzb(), zzex(this.zzaOY)));
        if (getBoolean("_gtm.loadEventEnabled")) {
            this.zzaOT.pushEvent("gtm.load", DataLayer.mapOf("gtm.id", this.zzaOS));
        }
    }

    private synchronized void zza(zzcp zzcp) {
        this.zzaOU = zzcp;
    }

    private void zza(zzi[] zziArr) {
        ArrayList arrayList = new ArrayList();
        for (zzi add : zziArr) {
            arrayList.add(add);
        }
        zzzD().zzs(arrayList);
    }

    private synchronized zzcp zzzD() {
        return this.zzaOU;
    }

    public boolean getBoolean(String key) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m28e("getBoolean called for closed container.");
            return zzdf.zzBd().booleanValue();
        }
        try {
            return zzdf.zzk((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(key).getObject()).booleanValue();
        } catch (Exception e) {
            zzbg.m28e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBd().booleanValue();
        }
    }

    public String getContainerId() {
        return this.zzaOS;
    }

    public double getDouble(String key) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m28e("getDouble called for closed container.");
            return zzdf.zzBc().doubleValue();
        }
        try {
            return zzdf.zzj((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(key).getObject()).doubleValue();
        } catch (Exception e) {
            zzbg.m28e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBc().doubleValue();
        }
    }

    public long getLastRefreshTime() {
        return this.zzaOX;
    }

    public long getLong(String key) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m28e("getLong called for closed container.");
            return zzdf.zzBb().longValue();
        }
        try {
            return zzdf.zzi((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(key).getObject()).longValue();
        } catch (Exception e) {
            zzbg.m28e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBb().longValue();
        }
    }

    public String getString(String key) {
        zzcp zzzD = zzzD();
        if (zzzD == null) {
            zzbg.m28e("getString called for closed container.");
            return zzdf.zzBf();
        }
        try {
            return zzdf.zzg((com.google.android.gms.internal.zzag.zza) zzzD.zzeS(key).getObject());
        } catch (Exception e) {
            zzbg.m28e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return zzdf.zzBf();
        }
    }

    public boolean isDefault() {
        return getLastRefreshTime() == 0;
    }

    public void registerFunctionCallMacroCallback(String customMacroName, FunctionCallMacroCallback customMacroCallback) {
        if (customMacroCallback == null) {
            throw new NullPointerException("Macro handler must be non-null");
        }
        synchronized (this.zzaOV) {
            this.zzaOV.put(customMacroName, customMacroCallback);
        }
    }

    public void registerFunctionCallTagCallback(String customTagName, FunctionCallTagCallback customTagCallback) {
        if (customTagCallback == null) {
            throw new NullPointerException("Tag callback must be non-null");
        }
        synchronized (this.zzaOW) {
            this.zzaOW.put(customTagName, customTagCallback);
        }
    }

    /* access modifiers changed from: 0000 */
    public void release() {
        this.zzaOU = null;
    }

    public void unregisterFunctionCallMacroCallback(String customMacroName) {
        synchronized (this.zzaOV) {
            this.zzaOV.remove(customMacroName);
        }
    }

    public void unregisterFunctionCallTagCallback(String customTagName) {
        synchronized (this.zzaOW) {
            this.zzaOW.remove(customTagName);
        }
    }

    /* access modifiers changed from: 0000 */
    public FunctionCallMacroCallback zzeu(String str) {
        FunctionCallMacroCallback functionCallMacroCallback;
        synchronized (this.zzaOV) {
            functionCallMacroCallback = (FunctionCallMacroCallback) this.zzaOV.get(str);
        }
        return functionCallMacroCallback;
    }

    /* access modifiers changed from: 0000 */
    public FunctionCallTagCallback zzev(String str) {
        FunctionCallTagCallback functionCallTagCallback;
        synchronized (this.zzaOW) {
            functionCallTagCallback = (FunctionCallTagCallback) this.zzaOW.get(str);
        }
        return functionCallTagCallback;
    }

    /* access modifiers changed from: 0000 */
    public void zzew(String str) {
        zzzD().zzew(str);
    }

    /* access modifiers changed from: 0000 */
    public zzah zzex(String str) {
        if (zzcb.zzAv().zzAw().equals(zza.CONTAINER_DEBUG)) {
        }
        return new zzbo();
    }

    /* access modifiers changed from: 0000 */
    public String zzzC() {
        return this.zzaOY;
    }
}
