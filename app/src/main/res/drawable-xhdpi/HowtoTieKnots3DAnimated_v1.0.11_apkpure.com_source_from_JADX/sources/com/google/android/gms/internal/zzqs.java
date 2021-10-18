package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.tagmanager.zzbg;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class zzqs {
    private String zzaPw = "https://www.google-analytics.com";

    private String zzff(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
        } catch (UnsupportedEncodingException e) {
            zzbg.m28e("Cannot encode the string: " + str);
            return "";
        }
    }

    public void zzfj(String str) {
        this.zzaPw = str;
        zzbg.zzaD("The Ctfe server endpoint was changed to: " + str);
    }

    public String zzt(List<zzqi> list) {
        return this.zzaPw + "/gtm/android?" + zzu(list);
    }

    /* access modifiers changed from: 0000 */
    public String zzu(List<zzqi> list) {
        boolean z = true;
        if (list.size() > 1) {
            z = false;
        }
        zzx.zzZ(z);
        if (list.isEmpty()) {
            return "";
        }
        zzqi zzqi = (zzqi) list.get(0);
        String str = !zzqi.zzBt().trim().equals("") ? zzqi.zzBt().trim() : "-1";
        StringBuilder sb = new StringBuilder();
        if (zzqi.zzBq() != null) {
            sb.append(zzqi.zzBq());
        } else {
            sb.append("id");
        }
        sb.append("=").append(zzff(zzqi.getContainerId())).append("&").append("pv").append("=").append(zzff(str));
        if (zzqi.zzBs()) {
            sb.append("&gtm_debug=x");
        }
        return sb.toString();
    }
}
