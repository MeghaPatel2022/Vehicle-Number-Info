package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = zzmb.zzakD;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = zzmd.zzale;
    public static final SearchableMetadataField<String> MIME_TYPE = zzmb.zzakL;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = zzmd.zzalf;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = zzmb.zzakQ;
    public static final SearchableMetadataField<Boolean> STARRED = zzmb.zzakS;
    public static final SearchableMetadataField<String> TITLE = zzmb.zzakU;
    public static final SearchableMetadataField<Boolean> TRASHED = zzmb.zzakV;
    public static final SearchableOrderedMetadataField<Date> zzalr = zzmd.zzalh;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzals = zzmb.zzakq;
}
