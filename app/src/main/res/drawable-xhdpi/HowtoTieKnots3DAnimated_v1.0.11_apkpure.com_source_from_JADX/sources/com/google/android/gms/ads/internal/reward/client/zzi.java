package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private String zzGh;
    private RewardedVideoAdListener zzGm;
    private final zzb zzGn;
    private final Object zzpc = new Object();

    public zzi(Context context, zzb zzb) {
        this.zzGn = zzb;
        this.mContext = context;
    }

    public void destroy() {
        synchronized (this.zzpc) {
            if (this.zzGn != null) {
                try {
                    this.zzGn.destroy();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzpc) {
            rewardedVideoAdListener = this.zzGm;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        String str;
        synchronized (this.zzpc) {
            str = this.zzGh;
        }
        return str;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzpc) {
            if (this.zzGn != null) {
                try {
                    z = this.zzGn.isLoaded();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String adUnitId, AdRequest adRequest) {
        synchronized (this.zzpc) {
            if (this.zzGn != null) {
                try {
                    this.zzGn.zza(zzg.zzcA().zza(this.mContext, adRequest.zzaF(), adUnitId));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void pause() {
        synchronized (this.zzpc) {
            if (this.zzGn != null) {
                try {
                    this.zzGn.pause();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward pause to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void resume() {
        synchronized (this.zzpc) {
            if (this.zzGn != null) {
                try {
                    this.zzGn.resume();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward resume to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener listener) {
        synchronized (this.zzpc) {
            this.zzGm = listener;
            if (this.zzGn != null) {
                try {
                    this.zzGn.zza((zzd) new zzg(listener));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setUserId(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.Object r1 = r3.zzpc
            monitor-enter(r1)
            java.lang.String r0 = r3.zzGh     // Catch:{ all -> 0x001f }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = "A user id has already been set, ignoring."
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r0)     // Catch:{ all -> 0x001f }
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
        L_0x0011:
            return
        L_0x0012:
            r3.zzGh = r4     // Catch:{ all -> 0x001f }
            com.google.android.gms.ads.internal.reward.client.zzb r0 = r3.zzGn     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001d
            com.google.android.gms.ads.internal.reward.client.zzb r0 = r3.zzGn     // Catch:{ RemoteException -> 0x0022 }
            r0.setUserId(r4)     // Catch:{ RemoteException -> 0x0022 }
        L_0x001d:
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            goto L_0x0011
        L_0x001f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r0
        L_0x0022:
            r0 = move-exception
            java.lang.String r2 = "Could not forward setUserId to RewardedVideoAd"
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r0)     // Catch:{ all -> 0x001f }
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.reward.client.zzi.setUserId(java.lang.String):void");
    }

    public void show() {
        synchronized (this.zzpc) {
            if (this.zzGn != null) {
                try {
                    this.zzGn.show();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward show to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }
}
