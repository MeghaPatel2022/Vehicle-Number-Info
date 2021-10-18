package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity.SubstringEntity;
import java.util.Collections;
import java.util.List;

public class zzb extends zzt implements AutocompletePrediction {
    public zzb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public String getDescription() {
        return zzD("ap_description", "");
    }

    public List<SubstringEntity> getMatchedSubstrings() {
        return zza("ap_matched_subscriptions", SubstringEntity.CREATOR, Collections.emptyList());
    }

    public String getPlaceId() {
        return zzD("ap_place_id", null);
    }

    public List<Integer> getPlaceTypes() {
        return zza("ap_place_types", Collections.emptyList());
    }

    /* renamed from: zzwg */
    public AutocompletePrediction freeze() {
        return AutocompletePredictionEntity.zza(getDescription(), getPlaceId(), getPlaceTypes(), getMatchedSubstrings(), zzwh());
    }

    public int zzwh() {
        return zzA("ap_personalization_type", 6);
    }
}
