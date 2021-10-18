package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.internal.zzt;

public final class ExecutionOptions {
    public static final int CONFLICT_STRATEGY_KEEP_REMOTE = 1;
    public static final int CONFLICT_STRATEGY_OVERWRITE_REMOTE = 0;
    public static final int MAX_TRACKING_TAG_STRING_LENGTH = 65536;
    private final String zzagM;
    private final boolean zzagN;
    private final int zzagO;

    public static final class Builder {
        private String zzagM;
        private boolean zzagN;
        private int zzagO = 0;

        public ExecutionOptions build() {
            if (this.zzagO != 1 || this.zzagN) {
                return new ExecutionOptions(this.zzagM, this.zzagN, this.zzagO);
            }
            throw new IllegalStateException("Cannot use CONFLICT_STRATEGY_KEEP_REMOTE without requesting completion notifications");
        }

        public Builder setConflictStrategy(int strategy) {
            if (!ExecutionOptions.zzcg(strategy)) {
                throw new IllegalArgumentException("Unrecognized value for conflict strategy: " + strategy);
            }
            this.zzagO = strategy;
            return this;
        }

        public Builder setNotifyOnCompletion(boolean notify) {
            this.zzagN = notify;
            return this;
        }

        public Builder setTrackingTag(String trackingTag) {
            if (!ExecutionOptions.zzcD(trackingTag)) {
                throw new IllegalArgumentException(String.format("trackingTag must not be null nor empty, and the length must be <= the maximum length (%s)", new Object[]{Integer.valueOf(65536)}));
            }
            this.zzagM = trackingTag;
            return this;
        }
    }

    public ExecutionOptions(String trackingTag, boolean notifyOnCompletion, int conflictStrategy) {
        this.zzagM = trackingTag;
        this.zzagN = notifyOnCompletion;
        this.zzagO = conflictStrategy;
    }

    public static void zza(GoogleApiClient googleApiClient, ExecutionOptions executionOptions) {
        zzt zzt = (zzt) googleApiClient.zza(Drive.zzQf);
        if (executionOptions.zzqm() && !zzt.zzqI()) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to be notified on completion");
        }
    }

    public static boolean zzcD(String str) {
        return str != null && !str.isEmpty() && str.length() <= 65536;
    }

    public static boolean zzcf(int i) {
        switch (i) {
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzcg(int i) {
        switch (i) {
            case 0:
            case 1:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object o) {
        if (o == null || o.getClass() != getClass()) {
            return false;
        }
        if (o == this) {
            return true;
        }
        ExecutionOptions executionOptions = (ExecutionOptions) o;
        return zzw.equal(this.zzagM, executionOptions.zzagM) && this.zzagO == executionOptions.zzagO && this.zzagN == executionOptions.zzagN;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzagM, Integer.valueOf(this.zzagO), Boolean.valueOf(this.zzagN));
    }

    public String zzql() {
        return this.zzagM;
    }

    public boolean zzqm() {
        return this.zzagN;
    }

    public int zzqn() {
        return this.zzagO;
    }
}
