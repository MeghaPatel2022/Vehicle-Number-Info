package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class zzl extends zzi<DriveId> implements SearchableCollectionMetadataField<DriveId> {
    public zzl(int i) {
        super("parents", Collections.emptySet(), Arrays.asList(new String[]{"parentsExtra", "dbInstanceId", "parentsExtraHolder"}), i);
    }

    private void zzc(DataHolder dataHolder) {
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) dataHolder.zznP().getParcelable("parentsExtraHolder");
            if (dataHolder2 != null) {
                try {
                    int count = dataHolder.getCount();
                    ArrayList arrayList = new ArrayList(count);
                    HashMap hashMap = new HashMap(count);
                    for (int i = 0; i < count; i++) {
                        int zzbo = dataHolder.zzbo(i);
                        ParentDriveIdSet parentDriveIdSet = new ParentDriveIdSet();
                        arrayList.add(parentDriveIdSet);
                        hashMap.put(Long.valueOf(dataHolder.zzb("sqlId", i, zzbo)), parentDriveIdSet);
                    }
                    Bundle zznP = dataHolder2.zznP();
                    String string = zznP.getString("childSqlIdColumn");
                    String string2 = zznP.getString("parentSqlIdColumn");
                    String string3 = zznP.getString("parentResIdColumn");
                    int count2 = dataHolder2.getCount();
                    for (int i2 = 0; i2 < count2; i2++) {
                        int zzbo2 = dataHolder2.zzbo(i2);
                        ((ParentDriveIdSet) hashMap.get(Long.valueOf(dataHolder2.zzb(string, i2, zzbo2)))).zza(new PartialDriveId(dataHolder2.zzd(string3, i2, zzbo2), dataHolder2.zzb(string2, i2, zzbo2), 1));
                    }
                    dataHolder.zznP().putParcelableArrayList("parentsExtra", arrayList);
                } finally {
                    dataHolder2.close();
                    dataHolder.zznP().remove("parentsExtraHolder");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzd */
    public Collection<DriveId> zzc(DataHolder dataHolder, int i, int i2) {
        Bundle zznP = dataHolder.zznP();
        ArrayList parcelableArrayList = zznP.getParcelableArrayList("parentsExtra");
        if (parcelableArrayList == null) {
            if (zznP.getParcelable("parentsExtraHolder") != null) {
                zzc(dataHolder);
                parcelableArrayList = zznP.getParcelableArrayList("parentsExtra");
            }
            if (parcelableArrayList == null) {
                return null;
            }
        }
        return ((ParentDriveIdSet) parcelableArrayList.get(i)).zzC(zznP.getLong("dbInstanceId"));
    }

    public void zzd(DataHolder dataHolder) {
        Bundle zznP = dataHolder.zznP();
        if (zznP != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zznP.getParcelable("parentsExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zznP.remove("parentsExtraHolder");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public Collection<DriveId> zzk(Bundle bundle) {
        Collection zzp = super.zzk(bundle);
        if (zzp == null) {
            return null;
        }
        return new HashSet(zzp);
    }
}
