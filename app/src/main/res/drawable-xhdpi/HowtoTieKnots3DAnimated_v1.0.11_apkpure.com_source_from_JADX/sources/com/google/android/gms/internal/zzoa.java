package com.google.android.gms.internal;

import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.LogPrinter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class zzoa implements zzoh {
    private static final Uri zzaHN;
    private final LogPrinter zzaHO = new LogPrinter(4, "GA/LogCatTransport");

    static {
        Builder builder = new Builder();
        builder.scheme("uri");
        builder.authority("local");
        zzaHN = builder.build();
    }

    public void zzb(zzob zzob) {
        ArrayList<zzod> arrayList = new ArrayList<>(zzob.zzxi());
        Collections.sort(arrayList, new Comparator<zzod>() {
            /* renamed from: zza */
            public int compare(zzod zzod, zzod zzod2) {
                return zzod.getClass().getCanonicalName().compareTo(zzod2.getClass().getCanonicalName());
            }
        });
        StringBuilder sb = new StringBuilder();
        for (zzod obj : arrayList) {
            String obj2 = obj.toString();
            if (!TextUtils.isEmpty(obj2)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(obj2);
            }
        }
        this.zzaHO.println(sb.toString());
    }

    public Uri zzhs() {
        return zzaHN;
    }
}
