package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzgk
public final class zzdo implements zzdg {
    private final Map<zzip, Integer> zzxq = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = (String) map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return zzk.zzcE().zzb(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            zzb.zzaE("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    public void zza(zzip zzip, Map<String, String> map) {
        int i;
        String str = (String) map.get("action");
        if (str == null) {
            zzb.zzaE("Action missing from video GMSG.");
            return;
        }
        if (zzb.zzM(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzb.zzaC("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzb.zzaE("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zzd zzgQ = zzip.zzgQ();
                if (zzgQ != null) {
                    com.google.android.gms.ads.internal.overlay.zzk zzew = zzgQ.zzew();
                    if (zzew != null) {
                        zzew.setBackgroundColor(parseColor);
                        return;
                    }
                }
                this.zzxq.put(zzip, Integer.valueOf(parseColor));
            } catch (IllegalArgumentException e) {
                zzb.zzaE("Invalid color parameter in video GMSG.");
            }
        } else {
            zzd zzgQ2 = zzip.zzgQ();
            if (zzgQ2 == null) {
                zzb.zzaE("Could not get ad overlay for a video GMSG.");
                return;
            }
            boolean equals = "new".equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzip.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                try {
                    i = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException e2) {
                    i = 0;
                }
                if (!equals || zzgQ2.zzew() != null) {
                    zzgQ2.zzd(zza, zza2, zza3, zza4);
                    return;
                }
                zzgQ2.zza(zza, zza2, zza3, zza4, i);
                if (this.zzxq.containsKey(zzip)) {
                    zzgQ2.zzew().setBackgroundColor(((Integer) this.zzxq.get(zzip)).intValue());
                    return;
                }
                return;
            }
            com.google.android.gms.ads.internal.overlay.zzk zzew2 = zzgQ2.zzew();
            if (zzew2 == null) {
                com.google.android.gms.ads.internal.overlay.zzk.zzd(zzip);
            } else if ("click".equals(str)) {
                Context context2 = zzip.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzew2.zzd(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str3 = (String) map.get("time");
                if (str3 == null) {
                    zzb.zzaE("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzew2.seekTo((int) (Float.parseFloat(str3) * 1000.0f));
                } catch (NumberFormatException e3) {
                    zzb.zzaE("Could not parse time parameter from currentTime video GMSG: " + str3);
                }
            } else if ("hide".equals(str)) {
                zzew2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzew2.zzeP();
            } else if ("mimetype".equals(str)) {
                zzew2.setMimeType((String) map.get("mimetype"));
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzew2.zzeq();
                } else {
                    zzew2.zzer();
                }
            } else if ("pause".equals(str)) {
                zzew2.pause();
            } else if ("play".equals(str)) {
                zzew2.play();
            } else if ("show".equals(str)) {
                zzew2.setVisibility(0);
            } else if ("src".equals(str)) {
                zzew2.zzak((String) map.get("src"));
            } else if (MediaRouteProviderProtocol.CLIENT_DATA_VOLUME.equals(str)) {
                String str4 = (String) map.get(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
                if (str4 == null) {
                    zzb.zzaE("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzew2.zza(Float.parseFloat(str4));
                } catch (NumberFormatException e4) {
                    zzb.zzaE("Could not parse volume parameter from volume video GMSG: " + str4);
                }
            } else if ("watermark".equals(str)) {
                zzew2.zzeQ();
            } else {
                zzb.zzaE("Unknown video action: " + str);
            }
        }
    }
}
