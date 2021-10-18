package com.google.android.gms.drive.query;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.HasFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;
import com.google.android.gms.drive.query.internal.OwnedByMeFilter;

public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.zzalR, filter, additionalFilters);
    }

    public static Filter and(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.zzalR, filters);
    }

    public static Filter contains(SearchableMetadataField<String> field, String value) {
        return new ComparisonFilter(Operator.zzalU, field, value);
    }

    /* renamed from: eq */
    public static Filter m22eq(CustomPropertyKey key, String value) {
        zzx.zzb(value != null, (Object) "Custom property value may not be null.");
        return new HasFilter(SearchableField.zzals, new zza().zza(key, value).zzqY());
    }

    /* renamed from: eq */
    public static <T> Filter m23eq(SearchableMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzalM, field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzalP, (SearchableMetadataField<T>) field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzalQ, (SearchableMetadataField<T>) field, value);
    }

    /* renamed from: in */
    public static <T> Filter m24in(SearchableCollectionMetadataField<T> field, T value) {
        return new InFilter(field, value);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzalN, (SearchableMetadataField<T>) field, value);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.zzalO, (SearchableMetadataField<T>) field, value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    public static Filter openedByMe() {
        return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
    }

    /* renamed from: or */
    public static Filter m25or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.zzalS, filter, additionalFilters);
    }

    /* renamed from: or */
    public static Filter m26or(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.zzalS, filters);
    }

    public static Filter ownedByMe() {
        return new OwnedByMeFilter();
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.zzalr);
    }
}
