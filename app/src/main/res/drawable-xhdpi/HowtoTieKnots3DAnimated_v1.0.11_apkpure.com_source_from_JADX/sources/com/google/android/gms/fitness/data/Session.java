package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.plus.PlusShare;
import java.util.concurrent.TimeUnit;

public class Session implements SafeParcelable {
    public static final Creator<Session> CREATOR = new zzp();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    private final String mName;
    private final int mVersionCode;
    private final long zzMS;
    private final Application zzanK;
    private final long zzann;
    private final int zzanx;
    private final String zzaoA;
    private final String zzaoB;
    private final Long zzaoC;

    public static class Builder {
        /* access modifiers changed from: private */
        public String mName = null;
        /* access modifiers changed from: private */
        public long zzMS = 0;
        /* access modifiers changed from: private */
        public Application zzanK;
        /* access modifiers changed from: private */
        public long zzann = 0;
        /* access modifiers changed from: private */
        public int zzanx = 4;
        /* access modifiers changed from: private */
        public String zzaoA;
        /* access modifiers changed from: private */
        public String zzaoB;
        /* access modifiers changed from: private */
        public Long zzaoC;

        public Session build() {
            boolean z = false;
            zzx.zza(this.zzMS > 0, (Object) "Start time should be specified.");
            if (this.zzann == 0 || this.zzann > this.zzMS) {
                z = true;
            }
            zzx.zza(z, (Object) "End time should be later than start time.");
            if (this.zzaoA == null) {
                this.zzaoA = (this.mName == null ? "" : this.mName) + this.zzMS;
            }
            return new Session(this);
        }

        public Builder setActiveTime(long time, TimeUnit timeUnit) {
            this.zzaoC = Long.valueOf(timeUnit.toMillis(time));
            return this;
        }

        public Builder setActivity(String activity) {
            return zzey(FitnessActivities.zzcP(activity));
        }

        public Builder setDescription(String description) {
            zzx.zzb(description.length() <= 1000, "Session description cannot exceed %d characters", Integer.valueOf(1000));
            this.zzaoB = description;
            return this;
        }

        public Builder setEndTime(long time, TimeUnit timeUnit) {
            zzx.zza(time >= 0, (Object) "End time should be positive.");
            this.zzann = timeUnit.toMillis(time);
            return this;
        }

        public Builder setIdentifier(String identifier) {
            zzx.zzZ(identifier != null && TextUtils.getTrimmedLength(identifier) > 0);
            this.zzaoA = identifier;
            return this;
        }

        public Builder setName(String name) {
            zzx.zzb(name.length() <= 100, "Session name cannot exceed %d characters", Integer.valueOf(100));
            this.mName = name;
            return this;
        }

        public Builder setStartTime(long time, TimeUnit timeUnit) {
            zzx.zza(time > 0, (Object) "Start time should be positive.");
            this.zzMS = timeUnit.toMillis(time);
            return this;
        }

        public Builder zzey(int i) {
            this.zzanx = i;
            return this;
        }
    }

    Session(int versionCode, long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, Application application, Long activeTimeMillis) {
        this.mVersionCode = versionCode;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.mName = name;
        this.zzaoA = identifier;
        this.zzaoB = description;
        this.zzanx = activityType;
        this.zzanK = application;
        this.zzaoC = activeTimeMillis;
    }

    public Session(long startTimeMillis, long endTimeMillis, String name, String identifier, String description, int activityType, Application application, Long activeTimeMillis) {
        this(3, startTimeMillis, endTimeMillis, name, identifier, description, activityType, application, activeTimeMillis);
    }

    private Session(Builder builder) {
        this(builder.zzMS, builder.zzann, builder.mName, builder.zzaoA, builder.zzaoB, builder.zzanx, builder.zzanK, builder.zzaoC);
    }

    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) zzc.zza(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String activity) {
        return MIME_TYPE_PREFIX + activity;
    }

    private boolean zza(Session session) {
        return this.zzMS == session.zzMS && this.zzann == session.zzann && zzw.equal(this.mName, session.mName) && zzw.equal(this.zzaoA, session.zzaoA) && zzw.equal(this.zzaoB, session.zzaoB) && zzw.equal(this.zzanK, session.zzanK) && this.zzanx == session.zzanx;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Session) && zza((Session) o));
    }

    public long getActiveTime(TimeUnit timeUnit) {
        zzx.zza(this.zzaoC != null, (Object) "Active time is not set");
        return timeUnit.convert(this.zzaoC.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzanx);
    }

    public String getAppPackageName() {
        if (this.zzanK == null) {
            return null;
        }
        return this.zzanK.getPackageName();
    }

    public String getDescription() {
        return this.zzaoB;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzann, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzaoA;
    }

    public String getName() {
        return this.mName;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzMS, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasActiveTime() {
        return this.zzaoC != null;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzMS), Long.valueOf(this.zzann), this.zzaoA);
    }

    public boolean isOngoing() {
        return this.zzann == 0;
    }

    public String toString() {
        return zzw.zzu(this).zzg("startTime", Long.valueOf(this.zzMS)).zzg("endTime", Long.valueOf(this.zzann)).zzg("name", this.mName).zzg("identifier", this.zzaoA).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, this.zzaoB).zzg("activity", Integer.valueOf(this.zzanx)).zzg("application", this.zzanK).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzp.zza(this, dest, flags);
    }

    public long zzkH() {
        return this.zzMS;
    }

    public Application zzrF() {
        return this.zzanK;
    }

    public Long zzrN() {
        return this.zzaoC;
    }

    public int zzru() {
        return this.zzanx;
    }

    public long zzrw() {
        return this.zzann;
    }
}
