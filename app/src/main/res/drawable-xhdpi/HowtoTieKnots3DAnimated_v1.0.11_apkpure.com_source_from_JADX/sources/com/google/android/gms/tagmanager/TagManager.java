package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager {
    private static TagManager zzaSv;
    private final Context mContext;
    private final DataLayer zzaOT;
    private final zzs zzaRp;
    private final zza zzaSs;
    private final zzct zzaSt;
    private final ConcurrentMap<zzo, Boolean> zzaSu;

    public interface zza {
        zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzs);
    }

    TagManager(Context context, zza containerHolderLoaderProvider, DataLayer dataLayer, zzct serviceManager) {
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        this.mContext = context.getApplicationContext();
        this.zzaSt = serviceManager;
        this.zzaSs = containerHolderLoaderProvider;
        this.zzaSu = new ConcurrentHashMap();
        this.zzaOT = dataLayer;
        this.zzaOT.zza((zzb) new zzb() {
            public void zzH(Map<String, Object> map) {
                Object obj = map.get("event");
                if (obj != null) {
                    TagManager.this.zzeU(obj.toString());
                }
            }
        });
        this.zzaOT.zza((zzb) new zzd(this.mContext));
        this.zzaRp = new zzs();
        zzAU();
    }

    public static TagManager getInstance(Context context) {
        TagManager tagManager;
        synchronized (TagManager.class) {
            if (zzaSv == null) {
                if (context == null) {
                    zzbg.m28e("TagManager.getInstance requires non-null context.");
                    throw new NullPointerException();
                }
                zzaSv = new TagManager(context, new zza() {
                    public zzp zza(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzs) {
                        return new zzp(context, tagManager, looper, str, i, zzs);
                    }
                }, new DataLayer(new zzw(context)), zzcu.zzAP());
            }
            tagManager = zzaSv;
        }
        return tagManager;
    }

    private void zzAU() {
        if (VERSION.SDK_INT >= 14) {
            this.mContext.registerComponentCallbacks(new ComponentCallbacks2() {
                public void onConfigurationChanged(Configuration configuration) {
                }

                public void onLowMemory() {
                }

                public void onTrimMemory(int i) {
                    if (i == 20) {
                        TagManager.this.dispatch();
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void zzeU(String str) {
        for (zzo zzew : this.zzaSu.keySet()) {
            zzew.zzew(str);
        }
    }

    public void dispatch() {
        this.zzaSt.dispatch();
    }

    public DataLayer getDataLayer() {
        return this.zzaOT;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaRp);
        zza2.zzzH();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerDefaultOnly(String containerId, int defaultContainerResourceId, Handler handler) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaRp);
        zza2.zzzH();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaRp);
        zza2.zzzJ();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferFresh(String containerId, int defaultContainerResourceId, Handler handler) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaRp);
        zza2.zzzJ();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, null, containerId, defaultContainerResourceId, this.zzaRp);
        zza2.zzzI();
        return zza2;
    }

    public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String containerId, int defaultContainerResourceId, Handler handler) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, handler.getLooper(), containerId, defaultContainerResourceId, this.zzaRp);
        zza2.zzzI();
        return zza2;
    }

    public void setVerboseLoggingEnabled(boolean enableVerboseLogging) {
        zzbg.setLogLevel(enableVerboseLogging ? 2 : 5);
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzo zzo) {
        this.zzaSu.put(zzo, Boolean.valueOf(true));
    }

    /* access modifiers changed from: 0000 */
    public boolean zzb(zzo zzo) {
        return this.zzaSu.remove(zzo) != null;
    }

    public PendingResult<ContainerHolder> zzc(String str, int i, String str2) {
        zzp zza2 = this.zzaSs.zza(this.mContext, this, null, str, i, this.zzaRp);
        zza2.load(str2);
        return zza2;
    }

    /* access modifiers changed from: 0000 */
    public synchronized boolean zzm(Uri uri) {
        boolean z;
        zzcb zzAv = zzcb.zzAv();
        if (zzAv.zzm(uri)) {
            String containerId = zzAv.getContainerId();
            switch (zzAv.zzAw()) {
                case NONE:
                    for (zzo zzo : this.zzaSu.keySet()) {
                        if (zzo.getContainerId().equals(containerId)) {
                            zzo.zzey(null);
                            zzo.refresh();
                        }
                    }
                    break;
                case CONTAINER:
                case CONTAINER_DEBUG:
                    for (zzo zzo2 : this.zzaSu.keySet()) {
                        if (zzo2.getContainerId().equals(containerId)) {
                            zzo2.zzey(zzAv.zzAx());
                            zzo2.refresh();
                        } else if (zzo2.zzzE() != null) {
                            zzo2.zzey(null);
                            zzo2.refresh();
                        }
                    }
                    break;
            }
            z = true;
        } else {
            z = false;
        }
        return z;
    }
}
