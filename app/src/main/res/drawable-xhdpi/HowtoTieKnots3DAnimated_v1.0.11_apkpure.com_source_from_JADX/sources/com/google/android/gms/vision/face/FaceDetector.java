package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;

public final class FaceDetector extends Detector<Face> {
    public static final int ACCURATE_MODE = 1;
    public static final int ALL_CLASSIFICATIONS = 1;
    public static final int ALL_LANDMARKS = 1;
    public static final int FAST_MODE = 0;
    public static final int NO_CLASSIFICATIONS = 0;
    public static final int NO_LANDMARKS = 0;
    private final zza zzaVD;
    private final zzg zzaVE;
    private boolean zzaVF;
    private final Object zzpc;

    public static class Builder {
        private final Context mContext;
        private int zzaVG = 0;
        private boolean zzaVH = false;
        private int zzaVI = 0;
        private boolean zzaVJ = true;
        private int zzagr = 0;

        public Builder(Context context) {
            this.mContext = context;
        }

        public FaceDetector build() {
            FaceSettingsParcel faceSettingsParcel = new FaceSettingsParcel();
            faceSettingsParcel.mode = this.zzagr;
            faceSettingsParcel.zzaVQ = this.zzaVG;
            faceSettingsParcel.zzaVR = this.zzaVI;
            faceSettingsParcel.zzaVS = this.zzaVH;
            faceSettingsParcel.zzaVT = this.zzaVJ;
            return new FaceDetector(new zzg(this.mContext, faceSettingsParcel));
        }

        public Builder setClassificationType(int classificationType) {
            if (classificationType == 0 || classificationType == 1) {
                this.zzaVI = classificationType;
                return this;
            }
            throw new IllegalArgumentException("Invalid classification type: " + classificationType);
        }

        public Builder setLandmarkType(int landmarkType) {
            if (landmarkType == 0 || landmarkType == 1) {
                this.zzaVG = landmarkType;
                return this;
            }
            throw new IllegalArgumentException("Invalid landmark type: " + landmarkType);
        }

        public Builder setMode(int mode) {
            switch (mode) {
                case 0:
                case 1:
                    this.zzagr = mode;
                    return this;
                default:
                    throw new IllegalArgumentException("Invalid mode: " + mode);
            }
        }

        public Builder setProminentFaceOnly(boolean prominentFaceOnly) {
            this.zzaVH = prominentFaceOnly;
            return this;
        }

        public Builder setTrackingEnabled(boolean trackingEnabled) {
            this.zzaVJ = trackingEnabled;
            return this;
        }
    }

    private FaceDetector() {
        this.zzaVD = new zza();
        this.zzpc = new Object();
        this.zzaVF = true;
        throw new IllegalStateException("Default constructor called");
    }

    private FaceDetector(zzg handle) {
        this.zzaVD = new zza();
        this.zzpc = new Object();
        this.zzaVF = true;
        this.zzaVE = handle;
    }

    public SparseArray<Face> detect(Frame frame) {
        Face[] zzb;
        if (frame == null) {
            throw new IllegalArgumentException("No frame supplied.");
        }
        ByteBuffer grayscaleImageData = frame.getGrayscaleImageData();
        synchronized (this.zzpc) {
            if (!this.zzaVF) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            zzb = this.zzaVE.zzb(grayscaleImageData, FrameMetadataParcel.zzc(frame));
        }
        HashSet hashSet = new HashSet();
        SparseArray<Face> sparseArray = new SparseArray<>(zzb.length);
        int i = 0;
        for (Face face : zzb) {
            int id = face.getId();
            i = Math.max(i, id);
            if (hashSet.contains(Integer.valueOf(id))) {
                id = i + 1;
                i = id;
            }
            hashSet.add(Integer.valueOf(id));
            sparseArray.append(this.zzaVD.zzjo(id), face);
        }
        return sparseArray;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            synchronized (this.zzpc) {
                if (this.zzaVF) {
                    Log.w("FaceDetector", "FaceDetector was not released with FaceDetector.release()");
                    release();
                }
            }
        } finally {
            super.finalize();
        }
    }

    public boolean isOperational() {
        return this.zzaVE.isOperational();
    }

    public void release() {
        synchronized (this.zzpc) {
            if (this.zzaVF) {
                this.zzaVE.zzCf();
                this.zzaVF = false;
            }
        }
    }

    public boolean setFocus(int id) {
        boolean zzjG;
        int zzjp = this.zzaVD.zzjp(id);
        synchronized (this.zzpc) {
            if (!this.zzaVF) {
                throw new RuntimeException("Cannot use detector after release()");
            }
            zzjG = this.zzaVE.zzjG(zzjp);
        }
        return zzjG;
    }
}
