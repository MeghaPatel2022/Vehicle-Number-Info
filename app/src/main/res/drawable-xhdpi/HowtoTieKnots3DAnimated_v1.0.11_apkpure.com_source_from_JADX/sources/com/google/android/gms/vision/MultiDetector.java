package com.google.android.gms.vision;

import android.util.SparseArray;
import com.google.android.gms.vision.Detector.Processor;
import java.util.ArrayList;
import java.util.List;

public class MultiDetector extends Detector<Object> {
    /* access modifiers changed from: private */
    public List<Detector<? extends Object>> zzaVj;

    public static class Builder {
        private MultiDetector zzaVk = new MultiDetector();

        public Builder add(Detector<? extends Object> detector) {
            this.zzaVk.zzaVj.add(detector);
            return this;
        }

        public MultiDetector build() {
            if (this.zzaVk.zzaVj.size() != 0) {
                return this.zzaVk;
            }
            throw new RuntimeException("No underlying detectors added to MultiDetector.");
        }
    }

    private MultiDetector() {
        this.zzaVj = new ArrayList();
    }

    public SparseArray<Object> detect(Frame frame) {
        SparseArray<Object> sparseArray = new SparseArray<>();
        for (Detector detect : this.zzaVj) {
            SparseArray detect2 = detect.detect(frame);
            int i = 0;
            while (true) {
                if (i < detect2.size()) {
                    int keyAt = detect2.keyAt(i);
                    if (sparseArray.get(keyAt) != null) {
                        throw new IllegalStateException("Detection ID overlap for id = " + keyAt + ".  " + "This means that one of the detectors is not using global IDs.");
                    }
                    sparseArray.append(keyAt, detect2.valueAt(i));
                    i++;
                }
            }
        }
        return sparseArray;
    }

    public boolean isOperational() {
        for (Detector isOperational : this.zzaVj) {
            if (!isOperational.isOperational()) {
                return false;
            }
        }
        return true;
    }

    public void receiveFrame(Frame frame) {
        for (Detector receiveFrame : this.zzaVj) {
            receiveFrame.receiveFrame(frame);
        }
    }

    public void release() {
        for (Detector release : this.zzaVj) {
            release.release();
        }
        this.zzaVj.clear();
    }

    public void setProcessor(Processor<Object> processor) {
        throw new UnsupportedOperationException("MultiDetector.setProcessor is not supported.  You should set a processor instance on each underlying detector instead.");
    }
}
