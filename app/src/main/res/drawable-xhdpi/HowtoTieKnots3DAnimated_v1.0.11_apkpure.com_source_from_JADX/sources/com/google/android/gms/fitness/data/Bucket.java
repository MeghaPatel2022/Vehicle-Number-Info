package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.FitnessActivities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Bucket implements SafeParcelable {
    public static final Creator<Bucket> CREATOR = new zzc();
    public static final int TYPE_ACTIVITY_SEGMENT = 4;
    public static final int TYPE_ACTIVITY_TYPE = 3;
    public static final int TYPE_SESSION = 2;
    public static final int TYPE_TIME = 1;
    private final int mVersionCode;
    private final long zzMS;
    private boolean zzanA;
    private final long zzann;
    private final Session zzanp;
    private final int zzanx;
    private final List<DataSet> zzany;
    private final int zzanz;

    Bucket(int versionCode, long startTimeMillis, long endTimeMillis, Session session, int activityType, List<DataSet> dataSets, int bucketType, boolean serverHasMoreData) {
        this.zzanA = false;
        this.mVersionCode = versionCode;
        this.zzMS = startTimeMillis;
        this.zzann = endTimeMillis;
        this.zzanp = session;
        this.zzanx = activityType;
        this.zzany = dataSets;
        this.zzanz = bucketType;
        this.zzanA = serverHasMoreData;
    }

    public Bucket(RawBucket bucket, List<DataSource> uniqueDataSources) {
        this(2, bucket.zzMS, bucket.zzann, bucket.zzanp, bucket.zzaov, zza(bucket.zzany, uniqueDataSources), bucket.zzanz, bucket.zzanA);
    }

    private static List<DataSet> zza(Collection<RawDataSet> collection, List<DataSource> list) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (RawDataSet dataSet : collection) {
            arrayList.add(new DataSet(dataSet, list));
        }
        return arrayList;
    }

    private boolean zza(Bucket bucket) {
        return this.zzMS == bucket.zzMS && this.zzann == bucket.zzann && this.zzanx == bucket.zzanx && zzw.equal(this.zzany, bucket.zzany) && this.zzanz == bucket.zzanz && this.zzanA == bucket.zzanA;
    }

    public static String zzel(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "time";
            case 2:
                return "session";
            case 3:
                return "type";
            case 4:
                return "segment";
            default:
                return "bug";
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof Bucket) && zza((Bucket) o));
    }

    public String getActivity() {
        return FitnessActivities.getName(this.zzanx);
    }

    public int getBucketType() {
        return this.zzanz;
    }

    public DataSet getDataSet(DataType dataType) {
        for (DataSet dataSet : this.zzany) {
            if (dataSet.getDataType().equals(dataType)) {
                return dataSet;
            }
        }
        return null;
    }

    public List<DataSet> getDataSets() {
        return this.zzany;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzann, TimeUnit.MILLISECONDS);
    }

    public Session getSession() {
        return this.zzanp;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzMS, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzMS), Long.valueOf(this.zzann), Integer.valueOf(this.zzanx), Integer.valueOf(this.zzanz));
    }

    public String toString() {
        return zzw.zzu(this).zzg("startTime", Long.valueOf(this.zzMS)).zzg("endTime", Long.valueOf(this.zzann)).zzg("activity", Integer.valueOf(this.zzanx)).zzg("dataSets", this.zzany).zzg("bucketType", zzel(this.zzanz)).zzg("serverHasMoreData", Boolean.valueOf(this.zzanA)).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzc.zza(this, dest, flags);
    }

    public boolean zzb(Bucket bucket) {
        return this.zzMS == bucket.zzMS && this.zzann == bucket.zzann && this.zzanx == bucket.zzanx && this.zzanz == bucket.zzanz;
    }

    public long zzkH() {
        return this.zzMS;
    }

    public int zzru() {
        return this.zzanx;
    }

    public boolean zzrv() {
        if (this.zzanA) {
            return true;
        }
        for (DataSet zzrv : this.zzany) {
            if (zzrv.zzrv()) {
                return true;
            }
        }
        return false;
    }

    public long zzrw() {
        return this.zzann;
    }
}
