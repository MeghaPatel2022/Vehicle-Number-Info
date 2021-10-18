package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Detections;
import com.google.android.gms.vision.Detector.Processor;
import java.util.HashSet;

public class MultiProcessor<T> implements Processor<T> {
    /* access modifiers changed from: private */
    public Factory<T> zzaVl;
    private SparseArray<zza<T>> zzaVm;
    /* access modifiers changed from: private */
    public int zzaVn;

    public static class Builder<T> {
        private MultiProcessor<T> zzaVo = new MultiProcessor<>();

        public Builder(Factory<T> factory) {
            if (factory == null) {
                throw new IllegalArgumentException("No factory supplied.");
            }
            this.zzaVo.zzaVl = factory;
        }

        public MultiProcessor<T> build() {
            return this.zzaVo;
        }

        public Builder<T> setMaxGapFrames(int maxGapFrames) {
            if (maxGapFrames < 0) {
                throw new IllegalArgumentException("Invalid max gap: " + maxGapFrames);
            }
            this.zzaVo.zzaVn = maxGapFrames;
            return this;
        }
    }

    public interface Factory<T> {
        Tracker<T> create(T t);
    }

    private class zza<T> {
        /* access modifiers changed from: private */
        public Tracker<T> zzaVa;
        /* access modifiers changed from: private */
        public int zzaVp;

        private zza() {
            this.zzaVp = 0;
        }
    }

    private MultiProcessor() {
        this.zzaVm = new SparseArray<>();
        this.zzaVn = 3;
    }

    private void zza(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        for (int i = 0; i < detectedItems.size(); i++) {
            int keyAt = detectedItems.keyAt(i);
            Object valueAt = detectedItems.valueAt(i);
            if (this.zzaVm.get(keyAt) == null) {
                zza zza2 = new zza();
                zza2.zzaVa = this.zzaVl.create(valueAt);
                zza2.zzaVa.onNewItem(keyAt, valueAt);
                this.zzaVm.append(keyAt, zza2);
            }
        }
    }

    private void zzb(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        HashSet<Integer> hashSet = new HashSet<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzaVm.size()) {
                break;
            }
            int keyAt = this.zzaVm.keyAt(i2);
            if (detectedItems.get(keyAt) == null) {
                zza zza2 = (zza) this.zzaVm.valueAt(i2);
                zza2.zzaVp = zza2.zzaVp + 1;
                if (zza2.zzaVp == this.zzaVn) {
                    zza2.zzaVa.onDone();
                    hashSet.add(Integer.valueOf(keyAt));
                }
            }
            i = i2 + 1;
        }
        for (Integer intValue : hashSet) {
            this.zzaVm.delete(intValue.intValue());
        }
    }

    private void zzc(Detections<T> detections) {
        SparseArray detectedItems = detections.getDetectedItems();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < detectedItems.size()) {
                int keyAt = detectedItems.keyAt(i2);
                ((zza) this.zzaVm.get(keyAt)).zzaVa.onUpdate(detections, detectedItems.valueAt(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void receiveDetections(Detections<T> detections) {
        zza(detections);
        zzb(detections);
        zzc(detections);
    }

    public void release() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzaVm.size()) {
                ((zza) this.zzaVm.valueAt(i2)).zzaVa.onDone();
                i = i2 + 1;
            } else {
                this.zzaVm.clear();
                return;
            }
        }
    }
}
