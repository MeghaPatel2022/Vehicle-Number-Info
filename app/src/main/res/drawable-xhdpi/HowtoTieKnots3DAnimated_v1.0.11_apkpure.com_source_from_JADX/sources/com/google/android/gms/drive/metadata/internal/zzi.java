package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;

public class zzi<T extends Parcelable> extends zzb<T> {
    public zzi(String str, Collection<String> collection, Collection<String> collection2, int i) {
        super(str, collection, collection2, i);
    }

    /* access modifiers changed from: protected */
    public void zza(Bundle bundle, Collection<T> collection) {
        bundle.putParcelableArrayList(getName(), collection instanceof ArrayList ? (ArrayList) collection : new ArrayList(collection));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzp */
    public Collection<T> zzk(Bundle bundle) {
        return bundle.getParcelableArrayList(getName());
    }
}
