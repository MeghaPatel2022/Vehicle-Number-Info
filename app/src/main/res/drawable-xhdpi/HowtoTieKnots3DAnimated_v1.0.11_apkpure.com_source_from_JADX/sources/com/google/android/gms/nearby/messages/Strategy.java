package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class Strategy implements SafeParcelable {
    public static final Strategy BLE_ONLY = new Builder().zzim(2).setTtlSeconds(Integer.MAX_VALUE).build();
    public static final Creator<Strategy> CREATOR = new zzd();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    public static final Strategy zzaJK = BLE_ONLY;
    final int versionCode;
    @Deprecated
    final int zzaJL;
    final int zzaJM;
    final int zzaJN;
    @Deprecated
    final boolean zzaJO;
    final int zzaJP;
    final int zzaJQ;

    public static class Builder {
        private int zzaJM = Strategy.TTL_SECONDS_DEFAULT;
        private int zzaJN = 0;
        private int zzaJP = 1;
        private int zzaJQ = 3;

        public Strategy build() {
            if (this.zzaJP == 2) {
                if (this.zzaJQ != 3) {
                    throw new IllegalStateException("Discovery mode must be DISCOVERY_MODE_DEFAULT.");
                } else if (this.zzaJN == 1) {
                    throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
                }
            }
            return new Strategy(2, 0, this.zzaJM, this.zzaJN, false, this.zzaJP, this.zzaJQ);
        }

        public Builder setDiscoveryMode(int discoveryMode) {
            this.zzaJQ = discoveryMode;
            return this;
        }

        public Builder setDistanceType(int distanceType) {
            this.zzaJN = distanceType;
            return this;
        }

        public Builder setTtlSeconds(int ttlSeconds) {
            zzx.zzb(ttlSeconds == Integer.MAX_VALUE || (ttlSeconds > 0 && ttlSeconds <= 86400), "ttlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(ttlSeconds), Integer.valueOf(Strategy.TTL_SECONDS_MAX));
            this.zzaJM = ttlSeconds;
            return this;
        }

        public Builder zzim(int i) {
            this.zzaJP = i;
            return this;
        }
    }

    Strategy(int versionCode2, int broadcastScanStrategy, int ttlSeconds, int distanceType, boolean isBleBeaconStrategy, int discoveryMedium, int discoveryMode) {
        this.versionCode = versionCode2;
        this.zzaJL = broadcastScanStrategy;
        if (broadcastScanStrategy != 0) {
            switch (broadcastScanStrategy) {
                case 2:
                    this.zzaJQ = 1;
                    break;
                case 3:
                    this.zzaJQ = 2;
                    break;
                default:
                    this.zzaJQ = 3;
                    break;
            }
        } else {
            this.zzaJQ = discoveryMode;
        }
        this.zzaJN = distanceType;
        this.zzaJO = isBleBeaconStrategy;
        if (isBleBeaconStrategy) {
            this.zzaJP = 2;
            this.zzaJM = Integer.MAX_VALUE;
        } else if (discoveryMedium == 0) {
            this.zzaJP = 1;
            this.zzaJM = ttlSeconds;
        } else {
            this.zzaJP = discoveryMedium;
            this.zzaJM = ttlSeconds;
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) other;
        return this.versionCode == strategy.versionCode && this.zzaJQ == strategy.zzaJQ && this.zzaJM == strategy.zzaJM && this.zzaJN == strategy.zzaJN && this.zzaJP == strategy.zzaJP;
    }

    public int hashCode() {
        return (((((((this.versionCode * 31) + this.zzaJQ) * 31) + this.zzaJM) * 31) + this.zzaJN) * 31) + this.zzaJP;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzd.zza(this, out, flags);
    }
}
