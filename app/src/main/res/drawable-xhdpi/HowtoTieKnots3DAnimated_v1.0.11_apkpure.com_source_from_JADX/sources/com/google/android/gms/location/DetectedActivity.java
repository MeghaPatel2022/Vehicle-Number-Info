package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Comparator;

public class DetectedActivity implements SafeParcelable {
    public static final DetectedActivityCreator CREATOR = new DetectedActivityCreator();
    public static final int IN_VEHICLE = 0;
    public static final int ON_BICYCLE = 1;
    public static final int ON_FOOT = 2;
    public static final int RUNNING = 8;
    public static final int STILL = 3;
    public static final int TILTING = 5;
    public static final int UNKNOWN = 4;
    public static final int WALKING = 7;
    public static final Comparator<DetectedActivity> zzaBx = new Comparator<DetectedActivity>() {
        /* renamed from: zza */
        public int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
            int compareTo = Integer.valueOf(detectedActivity2.getConfidence()).compareTo(Integer.valueOf(detectedActivity.getConfidence()));
            return compareTo == 0 ? Integer.valueOf(detectedActivity.getType()).compareTo(Integer.valueOf(detectedActivity2.getType())) : compareTo;
        }
    };
    private final int mVersionCode;
    int zzaBy;
    int zzaBz;

    public DetectedActivity(int activityType, int confidence) {
        this.mVersionCode = 1;
        this.zzaBy = activityType;
        this.zzaBz = confidence;
    }

    public DetectedActivity(int versionCode, int activityType, int confidence) {
        this.mVersionCode = versionCode;
        this.zzaBy = activityType;
        this.zzaBz = confidence;
    }

    private int zzgB(int i) {
        if (i > 15) {
            return 4;
        }
        return i;
    }

    public static String zzgC(int i) {
        switch (i) {
            case 0:
                return "IN_VEHICLE";
            case 1:
                return "ON_BICYCLE";
            case 2:
                return "ON_FOOT";
            case 3:
                return "STILL";
            case 4:
                return "UNKNOWN";
            case 5:
                return "TILTING";
            case 7:
                return "WALKING";
            case 8:
                return "RUNNING";
            default:
                return Integer.toString(i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DetectedActivity detectedActivity = (DetectedActivity) o;
        return this.zzaBy == detectedActivity.zzaBy && this.zzaBz == detectedActivity.zzaBz;
    }

    public int getConfidence() {
        return this.zzaBz;
    }

    public int getType() {
        return zzgB(this.zzaBy);
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzaBy), Integer.valueOf(this.zzaBz));
    }

    public String toString() {
        return "DetectedActivity [type=" + zzgC(getType()) + ", confidence=" + this.zzaBz + "]";
    }

    public void writeToParcel(Parcel out, int flags) {
        DetectedActivityCreator.zza(this, out, flags);
    }
}
