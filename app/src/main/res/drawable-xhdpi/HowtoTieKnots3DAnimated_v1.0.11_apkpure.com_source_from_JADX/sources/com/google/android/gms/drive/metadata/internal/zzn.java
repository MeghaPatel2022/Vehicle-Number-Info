package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class zzn extends zzb<String> {
    public zzn(String str, int i) {
        super(str, Collections.singleton(str), Collections.emptySet(), i);
    }

    public static final Collection<String> zzcH(String str) throws JSONException {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str);
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return Collections.unmodifiableCollection(arrayList);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, Collection<String> collection) {
        bundle.putStringArrayList(getName(), new ArrayList(collection));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzd */
    public Collection<String> zzc(DataHolder dataHolder, int i, int i2) {
        try {
            return zzcH(dataHolder.zzd(getName(), i, i2));
        } catch (JSONException e) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public Collection<String> zzk(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }
}
