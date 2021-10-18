package com.google.android.gms.fitness.request;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.BleDevice;
import java.util.HashMap;
import java.util.Map;

public class zza extends com.google.android.gms.fitness.request.zzn.zza {
    private final BleScanCallback zzapz;

    /* renamed from: com.google.android.gms.fitness.request.zza$zza reason: collision with other inner class name */
    public static class C1380zza {
        private static final C1380zza zzapA = new C1380zza();
        private final Map<BleScanCallback, zza> zzapB = new HashMap();

        private C1380zza() {
        }

        public static C1380zza zzsa() {
            return zzapA;
        }

        public zza zza(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzapB) {
                zza = (zza) this.zzapB.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                    this.zzapB.put(bleScanCallback, zza);
                }
            }
            return zza;
        }

        public zza zzb(BleScanCallback bleScanCallback) {
            zza zza;
            synchronized (this.zzapB) {
                zza = (zza) this.zzapB.get(bleScanCallback);
                if (zza == null) {
                    zza = new zza(bleScanCallback);
                }
            }
            return zza;
        }
    }

    private zza(BleScanCallback bleScanCallback) {
        this.zzapz = (BleScanCallback) zzx.zzv(bleScanCallback);
    }

    public void onDeviceFound(BleDevice device) throws RemoteException {
        this.zzapz.onDeviceFound(device);
    }

    public void onScanStopped() throws RemoteException {
        this.zzapz.onScanStopped();
    }
}
