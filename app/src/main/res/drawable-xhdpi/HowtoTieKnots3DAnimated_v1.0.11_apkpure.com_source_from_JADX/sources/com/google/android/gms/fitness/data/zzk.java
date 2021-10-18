package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.request.OnDataPointListener;
import java.util.HashMap;
import java.util.Map;

public class zzk extends com.google.android.gms.fitness.data.zzj.zza {
    private final OnDataPointListener zzaor;

    public static class zza {
        private static final zza zzaos = new zza();
        private final Map<OnDataPointListener, zzk> zzaot = new HashMap();

        private zza() {
        }

        public static zza zzrL() {
            return zzaos;
        }

        public zzk zza(OnDataPointListener onDataPointListener) {
            zzk zzk;
            synchronized (this.zzaot) {
                zzk = (zzk) this.zzaot.get(onDataPointListener);
                if (zzk == null) {
                    zzk = new zzk(onDataPointListener);
                    this.zzaot.put(onDataPointListener, zzk);
                }
            }
            return zzk;
        }

        public zzk zzb(OnDataPointListener onDataPointListener) {
            zzk zzk;
            synchronized (this.zzaot) {
                zzk = (zzk) this.zzaot.get(onDataPointListener);
            }
            return zzk;
        }

        public zzk zzc(OnDataPointListener onDataPointListener) {
            zzk zzk;
            synchronized (this.zzaot) {
                zzk = (zzk) this.zzaot.remove(onDataPointListener);
                if (zzk == null) {
                    zzk = new zzk(onDataPointListener);
                }
            }
            return zzk;
        }
    }

    private zzk(OnDataPointListener onDataPointListener) {
        this.zzaor = (OnDataPointListener) zzx.zzv(onDataPointListener);
    }

    public void zzc(DataPoint dataPoint) throws RemoteException {
        this.zzaor.onDataPoint(dataPoint);
    }
}
