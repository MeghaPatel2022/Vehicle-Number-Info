package com.google.android.gms.vision.face.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FaceParcel implements SafeParcelable {
    public static final zza CREATOR = new zza();
    public final float centerX;
    public final float centerY;
    public final float height;

    /* renamed from: id */
    public final int f60id;
    public final int versionCode;
    public final float width;
    public final float zzaVK;
    public final float zzaVL;
    public final LandmarkParcel[] zzaVM;
    public final float zzaVN;
    public final float zzaVO;
    public final float zzaVP;

    public FaceParcel(int versionCode2, int id, float centerX2, float centerY2, float width2, float height2, float eulerY, float eulerZ, LandmarkParcel[] landmarkParcels, float isLeftEyeOpenScore, float isRightEyeOpenScore, float isSmilingScore) {
        this.versionCode = versionCode2;
        this.f60id = id;
        this.centerX = centerX2;
        this.centerY = centerY2;
        this.width = width2;
        this.height = height2;
        this.zzaVK = eulerY;
        this.zzaVL = eulerZ;
        this.zzaVM = landmarkParcels;
        this.zzaVN = isLeftEyeOpenScore;
        this.zzaVO = isRightEyeOpenScore;
        this.zzaVP = isSmilingScore;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zza.zza(this, parcel, flags);
    }
}
