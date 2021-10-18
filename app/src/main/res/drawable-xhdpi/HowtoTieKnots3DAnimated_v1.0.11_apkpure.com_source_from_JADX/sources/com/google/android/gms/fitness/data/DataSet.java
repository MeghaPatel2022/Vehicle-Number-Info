package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DataSet implements SafeParcelable {
    public static final Creator<DataSet> CREATOR = new zze();
    private final int mVersionCode;
    private boolean zzanA;
    private final List<DataPoint> zzanH;
    private final List<DataSource> zzanI;
    private final DataType zzanl;
    private final DataSource zzanm;

    DataSet(int versionCode, DataSource dataSource, DataType dataType, List<RawDataPoint> dataPoints, List<DataSource> uniqueDataSources, boolean serverHasMoreData) {
        this.zzanA = false;
        this.mVersionCode = versionCode;
        this.zzanm = dataSource;
        this.zzanl = dataSource.getDataType();
        this.zzanA = serverHasMoreData;
        this.zzanH = new ArrayList(dataPoints.size());
        if (versionCode < 2) {
            uniqueDataSources = Collections.singletonList(dataSource);
        }
        this.zzanI = uniqueDataSources;
        for (RawDataPoint dataPoint : dataPoints) {
            this.zzanH.add(new DataPoint(this.zzanI, dataPoint));
        }
    }

    public DataSet(DataSource dataSource) {
        this.zzanA = false;
        this.mVersionCode = 3;
        this.zzanm = (DataSource) zzx.zzv(dataSource);
        this.zzanl = dataSource.getDataType();
        this.zzanH = new ArrayList();
        this.zzanI = new ArrayList();
        this.zzanI.add(this.zzanm);
    }

    public DataSet(RawDataSet dataSet, List<DataSource> uniqueDataSources) {
        this.zzanA = false;
        this.mVersionCode = 3;
        this.zzanm = (DataSource) zzb(uniqueDataSources, dataSet.zzaow);
        this.zzanl = this.zzanm.getDataType();
        this.zzanI = uniqueDataSources;
        this.zzanA = dataSet.zzanA;
        List<RawDataPoint> list = dataSet.zzaoz;
        this.zzanH = new ArrayList(list.size());
        for (RawDataPoint dataPoint : list) {
            this.zzanH.add(new DataPoint(this.zzanI, dataPoint));
        }
    }

    public static DataSet create(DataSource dataSource) {
        zzx.zzb(dataSource, (Object) "DataSource should be specified");
        return new DataSet(dataSource);
    }

    private boolean zza(DataSet dataSet) {
        return zzw.equal(getDataType(), dataSet.getDataType()) && zzw.equal(this.zzanm, dataSet.zzanm) && zzw.equal(this.zzanH, dataSet.zzanH) && this.zzanA == dataSet.zzanA;
    }

    private static <T> T zzb(List<T> list, int i) {
        if (i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public void add(DataPoint dataPoint) {
        DataSource dataSource = dataPoint.getDataSource();
        zzx.zzb(dataSource.getStreamIdentifier().equals(this.zzanm.getStreamIdentifier()), "Conflicting data sources found %s vs %s", dataSource, this.zzanm);
        dataPoint.zzrB();
        zzb(dataPoint);
    }

    public void addAll(Iterable<DataPoint> dataPoints) {
        for (DataPoint add : dataPoints) {
            add(add);
        }
    }

    public DataPoint createDataPoint() {
        return DataPoint.create(this.zzanm);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        return o == this || ((o instanceof DataSet) && zza((DataSet) o));
    }

    public List<DataPoint> getDataPoints() {
        return Collections.unmodifiableList(this.zzanH);
    }

    public DataSource getDataSource() {
        return this.zzanm;
    }

    public DataType getDataType() {
        return this.zzanm.getDataType();
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzanm);
    }

    public boolean isEmpty() {
        return this.zzanH.isEmpty();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String toString() {
        /*
            r8 = this;
            r5 = 2
            r7 = 1
            r6 = 0
            java.util.List r0 = r8.zzrD()
            java.lang.String r1 = "DataSet{%s %s}"
            java.lang.Object[] r2 = new java.lang.Object[r5]
            com.google.android.gms.fitness.data.DataSource r3 = r8.zzanm
            java.lang.String r3 = r3.toDebugString()
            r2[r6] = r3
            java.util.List<com.google.android.gms.fitness.data.DataPoint> r3 = r8.zzanH
            int r3 = r3.size()
            r4 = 10
            if (r3 >= r4) goto L_0x0024
        L_0x001d:
            r2[r7] = r0
            java.lang.String r0 = java.lang.String.format(r1, r2)
            return r0
        L_0x0024:
            java.lang.String r3 = "%d data points, first 5: %s"
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.util.List<com.google.android.gms.fitness.data.DataPoint> r5 = r8.zzanH
            int r5 = r5.size()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r6] = r5
            r5 = 5
            java.util.List r0 = r0.subList(r6, r5)
            r4[r7] = r0
            java.lang.String r0 = java.lang.String.format(r3, r4)
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.data.DataSet.toString():java.lang.String");
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zze.zza(this, parcel, flags);
    }

    public void zzb(DataPoint dataPoint) {
        this.zzanH.add(dataPoint);
        DataSource originalDataSource = dataPoint.getOriginalDataSource();
        if (originalDataSource != null && !this.zzanI.contains(originalDataSource)) {
            this.zzanI.add(originalDataSource);
        }
    }

    public void zzb(Iterable<DataPoint> iterable) {
        for (DataPoint zzb : iterable) {
            zzb(zzb);
        }
    }

    /* access modifiers changed from: 0000 */
    public List<RawDataPoint> zzk(List<DataSource> list) {
        ArrayList arrayList = new ArrayList(this.zzanH.size());
        for (DataPoint rawDataPoint : this.zzanH) {
            arrayList.add(new RawDataPoint(rawDataPoint, list));
        }
        return arrayList;
    }

    /* access modifiers changed from: 0000 */
    public List<RawDataPoint> zzrD() {
        return zzk(this.zzanI);
    }

    /* access modifiers changed from: 0000 */
    public List<DataSource> zzrE() {
        return this.zzanI;
    }

    public boolean zzrv() {
        return this.zzanA;
    }
}
