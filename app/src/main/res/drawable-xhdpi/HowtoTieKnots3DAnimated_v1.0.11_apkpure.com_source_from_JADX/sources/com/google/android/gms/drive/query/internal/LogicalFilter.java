package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.query.Filter;
import java.util.ArrayList;
import java.util.List;

public class LogicalFilter extends AbstractFilter {
    public static final Creator<LogicalFilter> CREATOR = new zzk();
    final int mVersionCode;
    final List<FilterHolder> zzalK;
    private List<Filter> zzalq;
    final Operator zzalv;

    LogicalFilter(int versionCode, Operator operator, List<FilterHolder> filterHolders) {
        this.mVersionCode = versionCode;
        this.zzalv = operator;
        this.zzalK = filterHolders;
    }

    public LogicalFilter(Operator operator, Filter filter, Filter... additionalFilters) {
        this.mVersionCode = 1;
        this.zzalv = operator;
        this.zzalK = new ArrayList(additionalFilters.length + 1);
        this.zzalK.add(new FilterHolder(filter));
        this.zzalq = new ArrayList(additionalFilters.length + 1);
        this.zzalq.add(filter);
        for (Filter filter2 : additionalFilters) {
            this.zzalK.add(new FilterHolder(filter2));
            this.zzalq.add(filter2);
        }
    }

    public LogicalFilter(Operator operator, Iterable<Filter> filters) {
        this.mVersionCode = 1;
        this.zzalv = operator;
        this.zzalq = new ArrayList();
        this.zzalK = new ArrayList();
        for (Filter filter : filters) {
            this.zzalq.add(filter);
            this.zzalK.add(new FilterHolder(filter));
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzk.zza(this, out, flags);
    }

    public <T> T zza(zzf<T> zzf) {
        ArrayList arrayList = new ArrayList();
        for (FilterHolder filter : this.zzalK) {
            arrayList.add(filter.getFilter().zza(zzf));
        }
        return zzf.zzb(this.zzalv, (List<F>) arrayList);
    }
}
