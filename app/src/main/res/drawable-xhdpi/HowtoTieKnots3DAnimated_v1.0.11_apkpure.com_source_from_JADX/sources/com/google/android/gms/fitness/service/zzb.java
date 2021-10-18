package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.zzj;
import java.util.List;

class zzb implements SensorEventDispatcher {
    private final zzj zzaqi;

    zzb(zzj zzj) {
        this.zzaqi = (zzj) zzx.zzv(zzj);
    }

    public void publish(DataPoint dataPoint) throws RemoteException {
        dataPoint.zzrB();
        this.zzaqi.zzc(dataPoint);
    }

    public void publish(List<DataPoint> dataPoints) throws RemoteException {
        for (DataPoint publish : dataPoints) {
            publish(publish);
        }
    }
}
