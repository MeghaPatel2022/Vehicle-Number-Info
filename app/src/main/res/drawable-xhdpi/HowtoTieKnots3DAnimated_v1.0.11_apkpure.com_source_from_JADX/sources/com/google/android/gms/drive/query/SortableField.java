package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.util.Date;

public class SortableField {
    public static final SortableMetadataField<Date> CREATED_DATE = zzmd.zzald;
    public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME = zzmd.zzale;
    public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE = zzmd.zzalg;
    public static final SortableMetadataField<Date> MODIFIED_DATE = zzmd.zzalf;
    public static final SortableMetadataField<Long> QUOTA_USED = zzmb.zzakR;
    public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE = zzmd.zzalh;
    public static final SortableMetadataField<String> TITLE = zzmb.zzakU;
}
