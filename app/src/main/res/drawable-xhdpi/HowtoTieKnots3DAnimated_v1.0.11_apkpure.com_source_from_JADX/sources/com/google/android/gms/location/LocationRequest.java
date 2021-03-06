package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class LocationRequest implements SafeParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int mPriority;
    private final int mVersionCode;
    long zzaBB;
    long zzaBW;
    long zzaBX;
    int zzaBY;
    float zzaBZ;
    long zzaCa;
    boolean zzaqs;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = 102;
        this.zzaBW = 3600000;
        this.zzaBX = 600000;
        this.zzaqs = false;
        this.zzaBB = Long.MAX_VALUE;
        this.zzaBY = Integer.MAX_VALUE;
        this.zzaBZ = 0.0f;
        this.zzaCa = 0;
    }

    LocationRequest(int versionCode, int priority, long interval, long fastestInterval, boolean explicitFastestInterval, long expireAt, int numUpdates, float smallestDisplacement, long maxWaitTime) {
        this.mVersionCode = versionCode;
        this.mPriority = priority;
        this.zzaBW = interval;
        this.zzaBX = fastestInterval;
        this.zzaqs = explicitFastestInterval;
        this.zzaBB = expireAt;
        this.zzaBY = numUpdates;
        this.zzaBZ = smallestDisplacement;
        this.zzaCa = maxWaitTime;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzK(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("invalid interval: " + j);
        }
    }

    private static void zzd(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("invalid displacement: " + f);
        }
    }

    private static void zzgG(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            default:
                throw new IllegalArgumentException("invalid quality: " + i);
        }
    }

    public static String zzgH(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
            default:
                return "???";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof LocationRequest)) {
            return false;
        }
        LocationRequest locationRequest = (LocationRequest) object;
        return this.mPriority == locationRequest.mPriority && this.zzaBW == locationRequest.zzaBW && this.zzaBX == locationRequest.zzaBX && this.zzaqs == locationRequest.zzaqs && this.zzaBB == locationRequest.zzaBB && this.zzaBY == locationRequest.zzaBY && this.zzaBZ == locationRequest.zzaBZ;
    }

    public long getExpirationTime() {
        return this.zzaBB;
    }

    public long getFastestInterval() {
        return this.zzaBX;
    }

    public long getInterval() {
        return this.zzaBW;
    }

    public long getMaxWaitTime() {
        long j = this.zzaCa;
        return j < this.zzaBW ? this.zzaBW : j;
    }

    public int getNumUpdates() {
        return this.zzaBY;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.zzaBZ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.zzaBW), Long.valueOf(this.zzaBX), Boolean.valueOf(this.zzaqs), Long.valueOf(this.zzaBB), Integer.valueOf(this.zzaBY), Float.valueOf(this.zzaBZ));
    }

    public LocationRequest setExpirationDuration(long millis) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (millis > Long.MAX_VALUE - elapsedRealtime) {
            this.zzaBB = Long.MAX_VALUE;
        } else {
            this.zzaBB = elapsedRealtime + millis;
        }
        if (this.zzaBB < 0) {
            this.zzaBB = 0;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long millis) {
        this.zzaBB = millis;
        if (this.zzaBB < 0) {
            this.zzaBB = 0;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long millis) {
        zzK(millis);
        this.zzaqs = true;
        this.zzaBX = millis;
        return this;
    }

    public LocationRequest setInterval(long millis) {
        zzK(millis);
        this.zzaBW = millis;
        if (!this.zzaqs) {
            this.zzaBX = (long) (((double) this.zzaBW) / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long millis) {
        zzK(millis);
        this.zzaCa = millis;
        return this;
    }

    public LocationRequest setNumUpdates(int numUpdates) {
        if (numUpdates <= 0) {
            throw new IllegalArgumentException("invalid numUpdates: " + numUpdates);
        }
        this.zzaBY = numUpdates;
        return this;
    }

    public LocationRequest setPriority(int priority) {
        zzgG(priority);
        this.mPriority = priority;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float smallestDisplacementMeters) {
        zzd(smallestDisplacementMeters);
        this.zzaBZ = smallestDisplacementMeters;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[").append(zzgH(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.zzaBW + "ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzaBX + "ms");
        if (this.zzaCa > this.zzaBW) {
            sb.append(" maxWait=");
            sb.append(this.zzaCa + "ms");
        }
        if (this.zzaBB != Long.MAX_VALUE) {
            long elapsedRealtime = this.zzaBB - SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(elapsedRealtime + "ms");
        }
        if (this.zzaBY != Integer.MAX_VALUE) {
            sb.append(" num=").append(this.zzaBY);
        }
        sb.append(']');
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        LocationRequestCreator.zza(this, parcel, flags);
    }
}
