package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.plus.PlusShare;
import java.util.Map;

class zzd implements zzb {
    private final Context context;

    public zzd(Context context2) {
        this.context = context2;
    }

    public void zzH(Map<String, Object> map) {
        Object obj;
        Object obj2 = map.get("gtm.url");
        if (obj2 == null) {
            Object obj3 = map.get("gtm");
            if (obj3 != null && (obj3 instanceof Map)) {
                obj = ((Map) obj3).get(PlusShare.KEY_CALL_TO_ACTION_URL);
                if (obj != null && (obj instanceof String)) {
                    String queryParameter = Uri.parse((String) obj).getQueryParameter("referrer");
                    if (queryParameter != null) {
                        zzax.zzl(this.context, queryParameter);
                        return;
                    }
                    return;
                }
            }
        }
        obj = obj2;
        if (obj != null) {
        }
    }
}
