package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    public static final class Builder {
        private String zzBm = null;
        private int zzaBA = 0;
        private long zzaBB = Long.MIN_VALUE;
        private short zzaBC = -1;
        private double zzaBD;
        private double zzaBE;
        private float zzaBF;
        private int zzaBG = 0;
        private int zzaBH = -1;

        public Geofence build() {
            if (this.zzBm == null) {
                throw new IllegalArgumentException("Request ID not set.");
            } else if (this.zzaBA == 0) {
                throw new IllegalArgumentException("Transitions types not set.");
            } else if ((this.zzaBA & 4) != 0 && this.zzaBH < 0) {
                throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
            } else if (this.zzaBB == Long.MIN_VALUE) {
                throw new IllegalArgumentException("Expiration not set.");
            } else if (this.zzaBC == -1) {
                throw new IllegalArgumentException("Geofence region not set.");
            } else if (this.zzaBG >= 0) {
                return new ParcelableGeofence(this.zzBm, this.zzaBA, 1, this.zzaBD, this.zzaBE, this.zzaBF, this.zzaBB, this.zzaBG, this.zzaBH);
            } else {
                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
            }
        }

        public Builder setCircularRegion(double latitude, double longitude, float radius) {
            this.zzaBC = 1;
            this.zzaBD = latitude;
            this.zzaBE = longitude;
            this.zzaBF = radius;
            return this;
        }

        public Builder setExpirationDuration(long durationMillis) {
            if (durationMillis < 0) {
                this.zzaBB = -1;
            } else {
                this.zzaBB = SystemClock.elapsedRealtime() + durationMillis;
            }
            return this;
        }

        public Builder setLoiteringDelay(int loiteringDelayMs) {
            this.zzaBH = loiteringDelayMs;
            return this;
        }

        public Builder setNotificationResponsiveness(int notificationResponsivenessMs) {
            this.zzaBG = notificationResponsivenessMs;
            return this;
        }

        public Builder setRequestId(String requestId) {
            this.zzBm = requestId;
            return this;
        }

        public Builder setTransitionTypes(int transitionTypes) {
            this.zzaBA = transitionTypes;
            return this;
        }
    }

    String getRequestId();
}
