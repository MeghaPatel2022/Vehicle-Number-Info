package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MomentEntity extends FastSafeParcelableJsonResponse implements Moment {
    public static final zzb CREATOR = new zzb();
    private static final HashMap<String, Field<?, ?>> zzaLS = new HashMap<>();
    final int mVersionCode;
    String zzFz;
    final Set<Integer> zzaLT;
    String zzaMG;
    ItemScopeEntity zzaMO;
    ItemScopeEntity zzaMP;
    String zzwj;

    static {
        zzaLS.put("id", Field.zzm("id", 2));
        zzaLS.put("result", Field.zza("result", 4, ItemScopeEntity.class));
        zzaLS.put("startDate", Field.zzm("startDate", 5));
        zzaLS.put("target", Field.zza("target", 6, ItemScopeEntity.class));
        zzaLS.put("type", Field.zzm("type", 7));
    }

    public MomentEntity() {
        this.mVersionCode = 1;
        this.zzaLT = new HashSet();
    }

    MomentEntity(Set<Integer> indicatorSet, int versionCode, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = versionCode;
        this.zzwj = id;
        this.zzaMO = result;
        this.zzaMG = startDate;
        this.zzaMP = target;
        this.zzFz = type;
    }

    public MomentEntity(Set<Integer> indicatorSet, String id, ItemScopeEntity result, String startDate, ItemScopeEntity target, String type) {
        this.zzaLT = indicatorSet;
        this.mVersionCode = 1;
        this.zzwj = id;
        this.zzaMO = result;
        this.zzaMG = startDate;
        this.zzaMP = target;
        this.zzFz = type;
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MomentEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        MomentEntity momentEntity = (MomentEntity) obj;
        for (Field field : zzaLS.values()) {
            if (zza(field)) {
                if (!momentEntity.zza(field)) {
                    return false;
                }
                if (!zzb(field).equals(momentEntity.zzb(field))) {
                    return false;
                }
            } else if (momentEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    public String getId() {
        return this.zzwj;
    }

    public ItemScope getResult() {
        return this.zzaMO;
    }

    public String getStartDate() {
        return this.zzaMG;
    }

    public ItemScope getTarget() {
        return this.zzaMP;
    }

    public String getType() {
        return this.zzFz;
    }

    public boolean hasId() {
        return this.zzaLT.contains(Integer.valueOf(2));
    }

    public boolean hasResult() {
        return this.zzaLT.contains(Integer.valueOf(4));
    }

    public boolean hasStartDate() {
        return this.zzaLT.contains(Integer.valueOf(5));
    }

    public boolean hasTarget() {
        return this.zzaLT.contains(Integer.valueOf(6));
    }

    public boolean hasType() {
        return this.zzaLT.contains(Integer.valueOf(7));
    }

    public int hashCode() {
        int i = 0;
        Iterator it = zzaLS.values().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            Field field = (Field) it.next();
            if (zza(field)) {
                i = zzb(field).hashCode() + i2 + field.zzpi();
            } else {
                i = i2;
            }
        }
    }

    public boolean isDataValid() {
        return true;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    /* access modifiers changed from: protected */
    public boolean zza(Field field) {
        return this.zzaLT.contains(Integer.valueOf(field.zzpi()));
    }

    /* access modifiers changed from: protected */
    public Object zzb(Field field) {
        switch (field.zzpi()) {
            case 2:
                return this.zzwj;
            case 4:
                return this.zzaMO;
            case 5:
                return this.zzaMG;
            case 6:
                return this.zzaMP;
            case 7:
                return this.zzFz;
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzpi());
        }
    }

    /* renamed from: zzyT */
    public HashMap<String, Field<?, ?>> zzpb() {
        return zzaLS;
    }

    /* renamed from: zzyV */
    public MomentEntity freeze() {
        return this;
    }
}
