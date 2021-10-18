package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class zzj extends zzdd {

    /* renamed from: ID */
    private static final String f53ID = zzad.ARBITRARY_PIXEL.toString();
    private static final String URL = zzae.URL.toString();
    private static final String zzaOL = zzae.ADDITIONAL_PARAMS.toString();
    private static final String zzaOM = zzae.UNREPEATABLE.toString();
    static final String zzaON = ("gtm_" + f53ID + "_unrepeatable");
    private static final Set<String> zzaOO = new HashSet();
    private final Context mContext;
    private final zza zzaOP;

    public interface zza {
        zzar zzzy();
    }

    public zzj(final Context context) {
        this(context, new zza() {
            public zzar zzzy() {
                return zzz.zzaM(context);
            }
        });
    }

    zzj(Context context, zza zza2) {
        super(f53ID, URL);
        this.zzaOP = zza2;
        this.mContext = context;
    }

    private synchronized boolean zzeq(String str) {
        boolean z = true;
        synchronized (this) {
            if (!zzes(str)) {
                if (zzer(str)) {
                    zzaOO.add(str);
                } else {
                    z = false;
                }
            }
        }
        return z;
    }

    public void zzI(Map<String, com.google.android.gms.internal.zzag.zza> map) {
        String str = map.get(zzaOM) != null ? zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(zzaOM)) : null;
        if (str == null || !zzeq(str)) {
            Builder buildUpon = Uri.parse(zzdf.zzg((com.google.android.gms.internal.zzag.zza) map.get(URL))).buildUpon();
            com.google.android.gms.internal.zzag.zza zza2 = (com.google.android.gms.internal.zzag.zza) map.get(zzaOL);
            if (zza2 != null) {
                Object zzl = zzdf.zzl(zza2);
                if (!(zzl instanceof List)) {
                    zzbg.m28e("ArbitraryPixel: additional params not a list: not sending partial hit: " + buildUpon.build().toString());
                    return;
                }
                for (Object next : (List) zzl) {
                    if (!(next instanceof Map)) {
                        zzbg.m28e("ArbitraryPixel: additional params contains non-map: not sending partial hit: " + buildUpon.build().toString());
                        return;
                    }
                    for (Entry entry : ((Map) next).entrySet()) {
                        buildUpon.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                    }
                }
            }
            String uri = buildUpon.build().toString();
            this.zzaOP.zzzy().zzeH(uri);
            zzbg.m29v("ArbitraryPixel: url = " + uri);
            if (str != null) {
                synchronized (zzj.class) {
                    zzaOO.add(str);
                    zzcv.zzb(this.mContext, zzaON, str, "true");
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean zzer(String str) {
        return this.mContext.getSharedPreferences(zzaON, 0).contains(str);
    }

    /* access modifiers changed from: 0000 */
    public boolean zzes(String str) {
        return zzaOO.contains(str);
    }
}
