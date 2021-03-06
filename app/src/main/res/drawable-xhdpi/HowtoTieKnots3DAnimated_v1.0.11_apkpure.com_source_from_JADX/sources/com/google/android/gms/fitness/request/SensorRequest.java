package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest {
    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final long zzaoE;
    private final int zzaoF;
    private final long zzaql;
    private final long zzaqm;
    private final LocationRequest zzaqq;
    private final long zzaqr;

    public static class Builder {
        /* access modifiers changed from: private */
        public DataType zzanl;
        /* access modifiers changed from: private */
        public DataSource zzanm;
        /* access modifiers changed from: private */
        public long zzaoE = -1;
        /* access modifiers changed from: private */
        public int zzaoF = 2;
        /* access modifiers changed from: private */
        public long zzaql = 0;
        /* access modifiers changed from: private */
        public long zzaqm = 0;
        /* access modifiers changed from: private */
        public long zzaqr = Long.MAX_VALUE;
        private boolean zzaqs = false;

        public SensorRequest build() {
            boolean z = false;
            zzx.zza((this.zzanm == null && this.zzanl == null) ? false : true, (Object) "Must call setDataSource() or setDataType()");
            if (this.zzanl == null || this.zzanm == null || this.zzanl.equals(this.zzanm.getDataType())) {
                z = true;
            }
            zzx.zza(z, (Object) "Specified data type is incompatible with specified data source");
            return new SensorRequest(this);
        }

        public Builder setAccuracyMode(int accuracyMode) {
            this.zzaoF = SensorRequest.zzeW(accuracyMode);
            return this;
        }

        public Builder setDataSource(DataSource dataSource) {
            this.zzanm = dataSource;
            return this;
        }

        public Builder setDataType(DataType dataType) {
            this.zzanl = dataType;
            return this;
        }

        public Builder setFastestRate(int fastestInterval, TimeUnit unit) {
            zzx.zzb(fastestInterval >= 0, (Object) "Cannot use a negative interval");
            this.zzaqs = true;
            this.zzaqm = unit.toMicros((long) fastestInterval);
            return this;
        }

        public Builder setMaxDeliveryLatency(int interval, TimeUnit unit) {
            zzx.zzb(interval >= 0, (Object) "Cannot use a negative delivery interval");
            this.zzaql = unit.toMicros((long) interval);
            return this;
        }

        public Builder setSamplingRate(long interval, TimeUnit unit) {
            zzx.zzb(interval >= 0, (Object) "Cannot use a negative sampling interval");
            this.zzaoE = unit.toMicros(interval);
            if (!this.zzaqs) {
                this.zzaqm = this.zzaoE / 2;
            }
            return this;
        }

        public Builder setTimeout(long timeout, TimeUnit timeUnit) {
            boolean z = true;
            zzx.zzb(timeout > 0, "Invalid time out value specified: %d", Long.valueOf(timeout));
            if (timeUnit == null) {
                z = false;
            }
            zzx.zzb(z, (Object) "Invalid time unit specified");
            this.zzaqr = timeUnit.toMicros(timeout);
            return this;
        }
    }

    private SensorRequest(DataSource dataSource, LocationRequest locationRequest) {
        this.zzaqq = locationRequest;
        this.zzaoE = TimeUnit.MILLISECONDS.toMicros(locationRequest.getInterval());
        this.zzaqm = TimeUnit.MILLISECONDS.toMicros(locationRequest.getFastestInterval());
        this.zzaql = this.zzaoE;
        this.zzanl = dataSource.getDataType();
        this.zzaoF = zza(locationRequest);
        this.zzanm = dataSource;
        long expirationTime = locationRequest.getExpirationTime();
        if (expirationTime == Long.MAX_VALUE) {
            this.zzaqr = Long.MAX_VALUE;
        } else {
            this.zzaqr = TimeUnit.MILLISECONDS.toMicros(expirationTime - SystemClock.elapsedRealtime());
        }
    }

    private SensorRequest(Builder builder) {
        this.zzanm = builder.zzanm;
        this.zzanl = builder.zzanl;
        this.zzaoE = builder.zzaoE;
        this.zzaqm = builder.zzaqm;
        this.zzaql = builder.zzaql;
        this.zzaoF = builder.zzaoF;
        this.zzaqq = null;
        this.zzaqr = builder.zzaqr;
    }

    public static SensorRequest fromLocationRequest(DataSource dataSource, LocationRequest locationRequest) {
        return new SensorRequest(dataSource, locationRequest);
    }

    private static int zza(LocationRequest locationRequest) {
        switch (locationRequest.getPriority()) {
            case 100:
                return 3;
            case 104:
                return 1;
            default:
                return 2;
        }
    }

    private boolean zza(SensorRequest sensorRequest) {
        return zzw.equal(this.zzanm, sensorRequest.zzanm) && zzw.equal(this.zzanl, sensorRequest.zzanl) && this.zzaoE == sensorRequest.zzaoE && this.zzaqm == sensorRequest.zzaqm && this.zzaql == sensorRequest.zzaql && this.zzaoF == sensorRequest.zzaoF && zzw.equal(this.zzaqq, sensorRequest.zzaqq) && this.zzaqr == sensorRequest.zzaqr;
    }

    public static int zzeW(int i) {
        switch (i) {
            case 1:
            case 3:
                return i;
            default:
                return 2;
        }
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof SensorRequest) && zza((SensorRequest) that));
    }

    public int getAccuracyMode() {
        return this.zzaoF;
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public DataType getDataType() {
        return this.zzanl;
    }

    public long getFastestRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaqm, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaql, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzaoE, TimeUnit.MICROSECONDS);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm, this.zzanl, Long.valueOf(this.zzaoE), Long.valueOf(this.zzaqm), Long.valueOf(this.zzaql), Integer.valueOf(this.zzaoF), this.zzaqq, Long.valueOf(this.zzaqr));
    }

    public String toString() {
        return zzw.zzu(this).zzg("dataSource", this.zzanm).zzg("dataType", this.zzanl).zzg("samplingRateMicros", Long.valueOf(this.zzaoE)).zzg("deliveryLatencyMicros", Long.valueOf(this.zzaql)).zzg("timeOutMicros", Long.valueOf(this.zzaqr)).toString();
    }

    public long zzsu() {
        return this.zzaqr;
    }
}
