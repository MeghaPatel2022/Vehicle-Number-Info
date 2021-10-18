package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.zzmb;
import com.google.android.gms.internal.zzmd;
import com.google.android.gms.internal.zzmf;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zze {
    private static final Map<String, MetadataField<?>> zzakl = new HashMap();

    static {
        zzb(zzmb.zzako);
        zzb((MetadataField<?>) zzmb.zzakU);
        zzb((MetadataField<?>) zzmb.zzakL);
        zzb((MetadataField<?>) zzmb.zzakS);
        zzb((MetadataField<?>) zzmb.zzakV);
        zzb(zzmb.zzakB);
        zzb(zzmb.zzakA);
        zzb(zzmb.zzakC);
        zzb((MetadataField<?>) zzmb.zzakD);
        zzb(zzmb.zzakE);
        zzb(zzmb.zzaky);
        zzb(zzmb.zzakG);
        zzb(zzmb.zzakH);
        zzb(zzmb.zzakI);
        zzb((MetadataField<?>) zzmb.zzakQ);
        zzb(zzmb.zzakp);
        zzb((MetadataField<?>) zzmb.zzakN);
        zzb(zzmb.zzakr);
        zzb(zzmb.zzakz);
        zzb(zzmb.zzaks);
        zzb(zzmb.zzakt);
        zzb(zzmb.zzaku);
        zzb(zzmb.zzakv);
        zzb(zzmb.zzakK);
        zzb(zzmb.zzakF);
        zzb(zzmb.zzakM);
        zzb((MetadataField<?>) zzmb.zzakO);
        zzb((MetadataField<?>) zzmb.zzakP);
        zzb((MetadataField<?>) zzmb.zzakR);
        zzb(zzmb.zzakW);
        zzb(zzmb.zzakX);
        zzb(zzmb.zzakx);
        zzb(zzmb.zzakw);
        zzb(zzmb.zzakT);
        zzb(zzmb.zzakJ);
        zzb((MetadataField<?>) zzmb.zzakq);
        zzb(zzmb.zzakY);
        zzb((MetadataField<?>) zzmb.zzakZ);
        zzb(zzmb.zzala);
        zzb(zzmb.zzalb);
        zzb((MetadataField<?>) zzmb.zzalc);
        zzb((MetadataField<?>) zzmd.zzald);
        zzb((MetadataField<?>) zzmd.zzalf);
        zzb((MetadataField<?>) zzmd.zzalg);
        zzb((MetadataField<?>) zzmd.zzalh);
        zzb((MetadataField<?>) zzmd.zzale);
        zzb(zzmf.zzalj);
        zzb(zzmf.zzalk);
    }

    public static void zzb(DataHolder dataHolder) {
        zzmb.zzakQ.zzd(dataHolder);
    }

    private static void zzb(MetadataField<?> metadataField) {
        if (zzakl.containsKey(metadataField.getName())) {
            throw new IllegalArgumentException("Duplicate field name registered: " + metadataField.getName());
        }
        zzakl.put(metadataField.getName(), metadataField);
    }

    public static MetadataField<?> zzcG(String str) {
        return (MetadataField) zzakl.get(str);
    }

    public static Collection<MetadataField<?>> zzra() {
        return Collections.unmodifiableCollection(zzakl.values());
    }
}
