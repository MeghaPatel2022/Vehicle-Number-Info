package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg {
    private final Context mContext;
    private final FaceSettingsParcel zzaVV;
    private zzc zzaVW = null;
    private boolean zzaVX = false;
    private final Object zzpc = new Object();

    public zzg(Context context, FaceSettingsParcel faceSettingsParcel) {
        this.mContext = context;
        this.zzaVV = faceSettingsParcel;
        zzCg();
    }

    private zzc zzCg() {
        zzc zzc;
        synchronized (this.zzpc) {
            if (this.zzaVW != null) {
                zzc = this.zzaVW;
            } else {
                this.zzaVW = zzf.zza(this.mContext, this.zzaVV);
                if (!this.zzaVX && this.zzaVW == null) {
                    Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
                    this.zzaVX = true;
                } else if (this.zzaVX && this.zzaVW != null) {
                    Log.w("FaceDetectorHandle", "Native face detector is now available.");
                }
                zzc = this.zzaVW;
            }
        }
        return zzc;
    }

    private Face zza(FaceParcel faceParcel) {
        return new Face(faceParcel.f60id, new PointF(faceParcel.centerX, faceParcel.centerY), faceParcel.width, faceParcel.height, faceParcel.zzaVK, faceParcel.zzaVL, zzb(faceParcel), faceParcel.zzaVN, faceParcel.zzaVO, faceParcel.zzaVP);
    }

    private Landmark zza(LandmarkParcel landmarkParcel) {
        return new Landmark(new PointF(landmarkParcel.f61x, landmarkParcel.f62y), landmarkParcel.type);
    }

    private Landmark[] zzb(FaceParcel faceParcel) {
        LandmarkParcel[] landmarkParcelArr = faceParcel.zzaVM;
        if (landmarkParcelArr == null) {
            return new Landmark[0];
        }
        Landmark[] landmarkArr = new Landmark[landmarkParcelArr.length];
        for (int i = 0; i < landmarkParcelArr.length; i++) {
            landmarkArr[i] = zza(landmarkParcelArr[i]);
        }
        return landmarkArr;
    }

    public boolean isOperational() {
        return zzCg() != null;
    }

    public void zzCf() {
        synchronized (this.zzpc) {
            if (this.zzaVW != null) {
                try {
                    this.zzaVW.zzCf();
                } catch (RemoteException e) {
                    Log.e("FaceDetectorHandle", "Could not finalize native face detector", e);
                }
                return;
            }
            return;
        }
    }

    public Face[] zzb(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzc zzCg = zzCg();
        if (zzCg == null) {
            return new Face[0];
        }
        try {
            FaceParcel[] zzc = zzCg.zzc(zze.zzx(byteBuffer), frameMetadataParcel);
            Face[] faceArr = new Face[zzc.length];
            for (int i = 0; i < zzc.length; i++) {
                faceArr[i] = zza(zzc[i]);
            }
            return faceArr;
        } catch (RemoteException e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return new Face[0];
        }
    }

    public boolean zzjG(int i) {
        boolean z = false;
        zzc zzCg = zzCg();
        if (zzCg == null) {
            return z;
        }
        try {
            return zzCg.zzjG(i);
        } catch (RemoteException e) {
            Log.e("FaceDetectorHandle", "Could not call native face detector", e);
            return z;
        }
    }
}
