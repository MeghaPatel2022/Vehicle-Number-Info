package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.AndroidAppUri;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.internal.zzgt.zza;
import com.google.android.gms.plus.PlusShare;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@zzgk
public final class zzgn {
    private static final SimpleDateFormat zzEY = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static String zzH(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b4 A[Catch:{ JSONException -> 0x0116 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r32, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r33, java.lang.String r34) {
        /*
            org.json.JSONObject r12 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0116 }
            r0 = r34
            r12.<init>(r0)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "ad_base_url"
            r3 = 0
            java.lang.String r4 = r12.optString(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "ad_url"
            r3 = 0
            java.lang.String r5 = r12.optString(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "ad_size"
            r3 = 0
            java.lang.String r17 = r12.optString(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            if (r33 == 0) goto L_0x007f
            r0 = r33
            int r2 = r0.zzDE     // Catch:{ JSONException -> 0x0116 }
            if (r2 == 0) goto L_0x007f
            r25 = 1
        L_0x0026:
            if (r25 == 0) goto L_0x0082
            java.lang.String r2 = "ad_json"
            r3 = 0
            java.lang.String r3 = r12.optString(r2, r3)     // Catch:{ JSONException -> 0x0116 }
        L_0x002f:
            r18 = -1
            java.lang.String r2 = "debug_dialog"
            r6 = 0
            java.lang.String r20 = r12.optString(r2, r6)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "interstitial_timeout"
            boolean r2 = r12.has(r2)     // Catch:{ JSONException -> 0x0116 }
            if (r2 == 0) goto L_0x008a
            java.lang.String r2 = "interstitial_timeout"
            double r6 = r12.getDouble(r2)     // Catch:{ JSONException -> 0x0116 }
            r8 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r6 = r6 * r8
            long r10 = (long) r6     // Catch:{ JSONException -> 0x0116 }
        L_0x004d:
            java.lang.String r2 = "orientation"
            r6 = 0
            java.lang.String r2 = r12.optString(r2, r6)     // Catch:{ JSONException -> 0x0116 }
            r16 = -1
            java.lang.String r6 = "portrait"
            boolean r6 = r6.equals(r2)     // Catch:{ JSONException -> 0x0116 }
            if (r6 == 0) goto L_0x008d
            com.google.android.gms.internal.zzhv r2 = com.google.android.gms.ads.internal.zzp.zzbz()     // Catch:{ JSONException -> 0x0116 }
            int r16 = r2.zzgw()     // Catch:{ JSONException -> 0x0116 }
        L_0x0066:
            r2 = 0
            boolean r6 = android.text.TextUtils.isEmpty(r3)     // Catch:{ JSONException -> 0x0116 }
            if (r6 != 0) goto L_0x009e
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ JSONException -> 0x0116 }
            if (r5 == 0) goto L_0x0209
            java.lang.String r2 = "Could not parse the mediation config: Missing required ad_base_url field"
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)     // Catch:{ JSONException -> 0x0116 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x0116 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0116 }
        L_0x007e:
            return r2
        L_0x007f:
            r25 = 0
            goto L_0x0026
        L_0x0082:
            java.lang.String r2 = "ad_html"
            r3 = 0
            java.lang.String r3 = r12.optString(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            goto L_0x002f
        L_0x008a:
            r10 = -1
            goto L_0x004d
        L_0x008d:
            java.lang.String r6 = "landscape"
            boolean r2 = r6.equals(r2)     // Catch:{ JSONException -> 0x0116 }
            if (r2 == 0) goto L_0x0066
            com.google.android.gms.internal.zzhv r2 = com.google.android.gms.ads.internal.zzp.zzbz()     // Catch:{ JSONException -> 0x0116 }
            int r16 = r2.zzgv()     // Catch:{ JSONException -> 0x0116 }
            goto L_0x0066
        L_0x009e:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ JSONException -> 0x0116 }
            if (r2 != 0) goto L_0x00e2
            r0 = r33
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r0.zzqb     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r4 = r2.zzIz     // Catch:{ JSONException -> 0x0116 }
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r2 = r33
            r3 = r32
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = com.google.android.gms.internal.zzgm.zza(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r4 = r2.zzAT     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r5 = r2.body     // Catch:{ JSONException -> 0x0116 }
            long r0 = r2.zzEb     // Catch:{ JSONException -> 0x0116 }
            r18 = r0
            r8 = r2
        L_0x00bf:
            java.lang.String r2 = "click_urls"
            org.json.JSONArray r6 = r12.optJSONArray(r2)     // Catch:{ JSONException -> 0x0116 }
            if (r8 != 0) goto L_0x013c
            r2 = 0
        L_0x00c8:
            if (r6 == 0) goto L_0x0206
            if (r2 != 0) goto L_0x00d1
            java.util.LinkedList r2 = new java.util.LinkedList     // Catch:{ JSONException -> 0x0116 }
            r2.<init>()     // Catch:{ JSONException -> 0x0116 }
        L_0x00d1:
            r3 = 0
        L_0x00d2:
            int r7 = r6.length()     // Catch:{ JSONException -> 0x0116 }
            if (r3 >= r7) goto L_0x013f
            java.lang.String r7 = r6.getString(r3)     // Catch:{ JSONException -> 0x0116 }
            r2.add(r7)     // Catch:{ JSONException -> 0x0116 }
            int r3 = r3 + 1
            goto L_0x00d2
        L_0x00e2:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0116 }
            r2.<init>()     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r3 = "Could not parse the mediation config: Missing required "
            java.lang.StringBuilder r3 = r2.append(r3)     // Catch:{ JSONException -> 0x0116 }
            if (r25 == 0) goto L_0x0139
            java.lang.String r2 = "ad_json"
        L_0x00f1:
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r3 = " or "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r3 = "ad_url"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r3 = " field."
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0116 }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)     // Catch:{ JSONException -> 0x0116 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x0116 }
            r3 = 0
            r2.<init>(r3)     // Catch:{ JSONException -> 0x0116 }
            goto L_0x007e
        L_0x0116:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Could not parse the mediation config: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r2 = r2.getMessage()
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r3 = 0
            r2.<init>(r3)
            goto L_0x007e
        L_0x0139:
            java.lang.String r2 = "ad_html"
            goto L_0x00f1
        L_0x013c:
            java.util.List<java.lang.String> r2 = r8.zzyw     // Catch:{ JSONException -> 0x0116 }
            goto L_0x00c8
        L_0x013f:
            r6 = r2
        L_0x0140:
            java.lang.String r2 = "impression_urls"
            org.json.JSONArray r7 = r12.optJSONArray(r2)     // Catch:{ JSONException -> 0x0116 }
            if (r8 != 0) goto L_0x0163
            r2 = 0
        L_0x0149:
            if (r7 == 0) goto L_0x0203
            if (r2 != 0) goto L_0x0152
            java.util.LinkedList r2 = new java.util.LinkedList     // Catch:{ JSONException -> 0x0116 }
            r2.<init>()     // Catch:{ JSONException -> 0x0116 }
        L_0x0152:
            r3 = 0
        L_0x0153:
            int r9 = r7.length()     // Catch:{ JSONException -> 0x0116 }
            if (r3 >= r9) goto L_0x0166
            java.lang.String r9 = r7.getString(r3)     // Catch:{ JSONException -> 0x0116 }
            r2.add(r9)     // Catch:{ JSONException -> 0x0116 }
            int r3 = r3 + 1
            goto L_0x0153
        L_0x0163:
            java.util.List<java.lang.String> r2 = r8.zzyx     // Catch:{ JSONException -> 0x0116 }
            goto L_0x0149
        L_0x0166:
            r7 = r2
        L_0x0167:
            java.lang.String r2 = "manual_impression_urls"
            org.json.JSONArray r9 = r12.optJSONArray(r2)     // Catch:{ JSONException -> 0x0116 }
            if (r8 != 0) goto L_0x018a
            r2 = 0
        L_0x0170:
            if (r9 == 0) goto L_0x0201
            if (r2 != 0) goto L_0x0179
            java.util.LinkedList r2 = new java.util.LinkedList     // Catch:{ JSONException -> 0x0116 }
            r2.<init>()     // Catch:{ JSONException -> 0x0116 }
        L_0x0179:
            r3 = 0
        L_0x017a:
            int r13 = r9.length()     // Catch:{ JSONException -> 0x0116 }
            if (r3 >= r13) goto L_0x018d
            java.lang.String r13 = r9.getString(r3)     // Catch:{ JSONException -> 0x0116 }
            r2.add(r13)     // Catch:{ JSONException -> 0x0116 }
            int r3 = r3 + 1
            goto L_0x017a
        L_0x018a:
            java.util.List<java.lang.String> r2 = r8.zzDZ     // Catch:{ JSONException -> 0x0116 }
            goto L_0x0170
        L_0x018d:
            r13 = r2
        L_0x018e:
            if (r8 == 0) goto L_0x01ff
            int r2 = r8.orientation     // Catch:{ JSONException -> 0x0116 }
            r3 = -1
            if (r2 == r3) goto L_0x0199
            int r0 = r8.orientation     // Catch:{ JSONException -> 0x0116 }
            r16 = r0
        L_0x0199:
            long r2 = r8.zzDW     // Catch:{ JSONException -> 0x0116 }
            r14 = 0
            int r2 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x01ff
            long r8 = r8.zzDW     // Catch:{ JSONException -> 0x0116 }
        L_0x01a3:
            java.lang.String r2 = "active_view"
            java.lang.String r23 = r12.optString(r2)     // Catch:{ JSONException -> 0x0116 }
            r22 = 0
            java.lang.String r2 = "ad_is_javascript"
            r3 = 0
            boolean r21 = r12.optBoolean(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            if (r21 == 0) goto L_0x01bb
            java.lang.String r2 = "ad_passback_url"
            r3 = 0
            java.lang.String r22 = r12.optString(r2, r3)     // Catch:{ JSONException -> 0x0116 }
        L_0x01bb:
            java.lang.String r2 = "mediation"
            r3 = 0
            boolean r10 = r12.optBoolean(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "custom_render_allowed"
            r3 = 0
            boolean r24 = r12.optBoolean(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "content_url_opted_out"
            r3 = 1
            boolean r27 = r12.optBoolean(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "prefetch"
            r3 = 0
            boolean r28 = r12.optBoolean(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "oauth2_token_status"
            r3 = 0
            int r29 = r12.optInt(r2, r3)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "refresh_interval_milliseconds"
            r14 = -1
            long r14 = r12.optLong(r2, r14)     // Catch:{ JSONException -> 0x0116 }
            java.lang.String r2 = "mediation_config_cache_time_milliseconds"
            r30 = -1
            r0 = r30
            long r11 = r12.optLong(r2, r0)     // Catch:{ JSONException -> 0x0116 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ JSONException -> 0x0116 }
            r0 = r33
            boolean r0 = r0.zzDG     // Catch:{ JSONException -> 0x0116 }
            r26 = r0
            r3 = r33
            r2.<init>(r3, r4, r5, r6, r7, r8, r10, r11, r13, r14, r16, r17, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)     // Catch:{ JSONException -> 0x0116 }
            goto L_0x007e
        L_0x01ff:
            r8 = r10
            goto L_0x01a3
        L_0x0201:
            r13 = r2
            goto L_0x018e
        L_0x0203:
            r7 = r2
            goto L_0x0167
        L_0x0206:
            r6 = r2
            goto L_0x0140
        L_0x0209:
            r8 = r2
            r5 = r3
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgn.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgr zzgr, zza zza, Location location, zzbr zzbr, String str, String str2, List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.zzDx != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.zzDx);
            }
            zza(hashMap, adRequestInfoParcel.zzDy);
            hashMap.put("format", adRequestInfoParcel.zzqf.zzsG);
            if (adRequestInfoParcel.zzqf.width == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.zzqf.height == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.zzqf.zzsI != null) {
                StringBuilder sb = new StringBuilder();
                AdSizeParcel[] adSizeParcelArr = adRequestInfoParcel.zzqf.zzsI;
                int length = adSizeParcelArr.length;
                for (int i = 0; i < length; i++) {
                    AdSizeParcel adSizeParcel = adSizeParcelArr[i];
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSizeParcel.width == -1 ? (int) (((float) adSizeParcel.widthPixels) / zzgr.zzDK) : adSizeParcel.width);
                    sb.append("x");
                    sb.append(adSizeParcel.height == -2 ? (int) (((float) adSizeParcel.heightPixels) / zzgr.zzDK) : adSizeParcel.height);
                }
                hashMap.put("sz", sb);
            }
            if (adRequestInfoParcel.zzDE != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.zzDE));
                hashMap.put("native_templates", adRequestInfoParcel.zzqv);
                hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.zzqt));
                if (!adRequestInfoParcel.zzDS.isEmpty()) {
                    hashMap.put("native_custom_templates", adRequestInfoParcel.zzDS);
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.zzpZ);
            hashMap.put("pn", adRequestInfoParcel.applicationInfo.packageName);
            if (adRequestInfoParcel.zzDz != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.zzDz.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.zzDB);
            hashMap.put("session_id", adRequestInfoParcel.zzDC);
            hashMap.put("js", adRequestInfoParcel.zzqb.zzIz);
            zza(hashMap, zzgr, zza);
            hashMap.put("fdz", Integer.valueOf(zzbr.zzdc()));
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.zzDy.versionCode >= 2 && adRequestInfoParcel.zzDy.zzsy != null) {
                zza(hashMap, adRequestInfoParcel.zzDy.zzsy);
            }
            if (adRequestInfoParcel.versionCode >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.zzDD);
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzDG) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.zzDG));
            }
            if (adRequestInfoParcel.versionCode >= 4 && adRequestInfoParcel.zzDF != null) {
                Bundle bundle = adRequestInfoParcel.zzDF;
                zza(context, adRequestInfoParcel, bundle);
                hashMap.put("content_info", bundle);
            }
            if (adRequestInfoParcel.versionCode >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.zzDK));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.zzDJ));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.zzDI));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzgr.zzDK));
                hashMap.put("sh", Integer.valueOf(zzgr.zzDJ));
                hashMap.put("sw", Integer.valueOf(zzgr.zzDI));
            }
            if (adRequestInfoParcel.versionCode >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.zzDL)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.zzDL));
                    } catch (JSONException e) {
                        zzb.zzd("Problem serializing view hierarchy to JSON", e);
                    }
                }
                if (((Boolean) zzby.zzuQ.get()).booleanValue() && adRequestInfoParcel.zzDM) {
                    hashMap.put("ga_hid", Integer.valueOf(adRequestInfoParcel.zzDN));
                    hashMap.put("ga_cid", adRequestInfoParcel.zzDO);
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.zzDP));
            }
            if (adRequestInfoParcel.versionCode >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.zzDQ);
            }
            if (adRequestInfoParcel.versionCode >= 11 && adRequestInfoParcel.zzDU != null) {
                hashMap.put("capability", adRequestInfoParcel.zzDU.toBundle());
            }
            zza(hashMap, str);
            if (zzb.zzM(2)) {
                zzb.m20v("Ad Request JSON: " + zzp.zzbx().zzx(hashMap).toString(2));
            }
            return zzp.zzbx().zzx(hashMap);
        } catch (JSONException e2) {
            zzb.zzaE("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    static void zza(Context context, AdRequestInfoParcel adRequestInfoParcel, Bundle bundle) {
        if (!((Boolean) zzby.zzuK.get()).booleanValue()) {
            zzb.zzaD("App index is not enabled");
        } else if (!zzd.zzacF) {
            zzb.zzaD("Not on package side, return");
        } else if (zzk.zzcE().zzgI()) {
            zzb.zzaD("Cannot invoked on UI thread");
        } else if (adRequestInfoParcel == null || adRequestInfoParcel.zzDz == null) {
            zzb.zzaE("Invalid ad request info");
        } else {
            String str = adRequestInfoParcel.zzDz.packageName;
            if (TextUtils.isEmpty(str)) {
                zzb.zzaE("Fail to get package name");
                return;
            }
            try {
                zza(zzd(context, str), str, bundle);
            } catch (RuntimeException e) {
                zzb.zzaD("Fail to add app index to content info");
            }
        }
    }

    static void zza(UsageInfo usageInfo, String str, Bundle bundle) {
        if (usageInfo != null && usageInfo.zzle() != null) {
            DocumentContents zzle = usageInfo.zzle();
            String zzkX = zzle.zzkX();
            if (!TextUtils.isEmpty(zzkX)) {
                bundle.putString("web_url", zzkX);
            }
            try {
                DocumentSection zzbu = zzle.zzbu("intent_data");
                if (zzbu != null && !TextUtils.isEmpty(zzbu.zzPe)) {
                    bundle.putString("app_uri", AndroidAppUri.newAndroidAppUri(str, Uri.parse(zzbu.zzPe)).toString());
                }
            } catch (IllegalArgumentException e) {
                zzb.zzaE("Failed to parse the third-party Android App URI");
            }
        }
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzgm = zzhp.zzgm();
        if (zzgm != null) {
            hashMap.put("abf", zzgm);
        }
        if (adRequestParcel.zzsq != -1) {
            hashMap.put("cust_age", zzEY.format(new Date(adRequestParcel.zzsq)));
        }
        if (adRequestParcel.extras != null) {
            hashMap.put("extras", adRequestParcel.extras);
        }
        if (adRequestParcel.zzsr != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.zzsr));
        }
        if (adRequestParcel.zzss != null) {
            hashMap.put("kw", adRequestParcel.zzss);
        }
        if (adRequestParcel.zzsu != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.zzsu));
        }
        if (adRequestParcel.zzst) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.versionCode >= 2) {
            if (adRequestParcel.zzsv) {
                hashMap.put("d_imp_hdr", Integer.valueOf(1));
            }
            if (!TextUtils.isEmpty(adRequestParcel.zzsw)) {
                hashMap.put("ppid", adRequestParcel.zzsw);
            }
            if (adRequestParcel.zzsx != null) {
                zza(hashMap, adRequestParcel.zzsx);
            }
        }
        if (adRequestParcel.versionCode >= 3 && adRequestParcel.zzsz != null) {
            hashMap.put(PlusShare.KEY_CALL_TO_ACTION_URL, adRequestParcel.zzsz);
        }
        if (adRequestParcel.versionCode >= 5) {
            if (adRequestParcel.zzsB != null) {
                hashMap.put("custom_targeting", adRequestParcel.zzsB);
            }
            if (adRequestParcel.zzsC != null) {
                hashMap.put("category_exclusions", adRequestParcel.zzsC);
            }
            if (adRequestParcel.zzsD != null) {
                hashMap.put("request_agent", adRequestParcel.zzsD);
            }
        }
        if (adRequestParcel.versionCode >= 6 && adRequestParcel.zzsE != null) {
            hashMap.put("request_pkg", adRequestParcel.zzsE);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.zztA) != 0) {
            hashMap.put("acolor", zzH(searchAdRequestParcel.zztA));
        }
        if (Color.alpha(searchAdRequestParcel.backgroundColor) != 0) {
            hashMap.put("bgcolor", zzH(searchAdRequestParcel.backgroundColor));
        }
        if (!(Color.alpha(searchAdRequestParcel.zztB) == 0 || Color.alpha(searchAdRequestParcel.zztC) == 0)) {
            hashMap.put("gradientto", zzH(searchAdRequestParcel.zztB));
            hashMap.put("gradientfrom", zzH(searchAdRequestParcel.zztC));
        }
        if (Color.alpha(searchAdRequestParcel.zztD) != 0) {
            hashMap.put("bcolor", zzH(searchAdRequestParcel.zztD));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.zztE));
        switch (searchAdRequestParcel.zztF) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (searchAdRequestParcel.zztG) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.zztH != null) {
            hashMap.put("channel", searchAdRequestParcel.zztH);
        }
        if (Color.alpha(searchAdRequestParcel.zztI) != 0) {
            hashMap.put("dcolor", zzH(searchAdRequestParcel.zztI));
        }
        if (searchAdRequestParcel.zztJ != null) {
            hashMap.put("font", searchAdRequestParcel.zztJ);
        }
        if (Color.alpha(searchAdRequestParcel.zztK) != 0) {
            hashMap.put("hcolor", zzH(searchAdRequestParcel.zztK));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.zztL));
        if (searchAdRequestParcel.zztM != null) {
            hashMap.put("q", searchAdRequestParcel.zztM);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzgr zzgr, zza zza) {
        hashMap.put("am", Integer.valueOf(zzgr.zzFB));
        hashMap.put("cog", zzx(zzgr.zzFC));
        hashMap.put("coh", zzx(zzgr.zzFD));
        if (!TextUtils.isEmpty(zzgr.zzFE)) {
            hashMap.put("carrier", zzgr.zzFE);
        }
        hashMap.put("gl", zzgr.zzFF);
        if (zzgr.zzFG) {
            hashMap.put("simulator", Integer.valueOf(1));
        }
        if (zzgr.zzFH) {
            hashMap.put("is_sidewinder", Integer.valueOf(1));
        }
        hashMap.put("ma", zzx(zzgr.zzFI));
        hashMap.put("sp", zzx(zzgr.zzFJ));
        hashMap.put("hl", zzgr.zzFK);
        if (!TextUtils.isEmpty(zzgr.zzFL)) {
            hashMap.put("mv", zzgr.zzFL);
        }
        hashMap.put("muv", Integer.valueOf(zzgr.zzFM));
        if (zzgr.zzFN != -2) {
            hashMap.put("cnt", Integer.valueOf(zzgr.zzFN));
        }
        hashMap.put("gnt", Integer.valueOf(zzgr.zzFO));
        hashMap.put("pt", Integer.valueOf(zzgr.zzFP));
        hashMap.put("rm", Integer.valueOf(zzgr.zzFQ));
        hashMap.put("riv", Integer.valueOf(zzgr.zzFR));
        Bundle bundle = new Bundle();
        bundle.putString("build", zzgr.zzFW);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", zzgr.zzFT);
        bundle2.putDouble("battery_level", zzgr.zzFS);
        bundle.putBundle("battery", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putInt("active_network_state", zzgr.zzFV);
        bundle3.putBoolean("active_network_metered", zzgr.zzFU);
        if (zza != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("predicted_latency_micros", zza.zzGb);
            bundle4.putLong("predicted_down_throughput_bps", zza.zzGc);
            bundle4.putLong("predicted_up_throughput_bps", zza.zzGd);
            bundle3.putBundle("predictions", bundle4);
        }
        bundle.putBundle("network", bundle3);
        hashMap.put("device", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("token", str);
            hashMap.put("pan", hashMap2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.zzwo : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.appdatasearch.UsageInfo zzd(android.content.Context r6, java.lang.String r7) {
        /*
            r1 = 0
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = new com.google.android.gms.common.api.GoogleApiClient$Builder     // Catch:{ SecurityException -> 0x0073, all -> 0x0081 }
            r0.<init>(r6)     // Catch:{ SecurityException -> 0x0073, all -> 0x0081 }
            com.google.android.gms.common.api.Api<com.google.android.gms.common.api.Api$ApiOptions$NoOptions> r2 = com.google.android.gms.appdatasearch.zza.zzOQ     // Catch:{ SecurityException -> 0x0073, all -> 0x0081 }
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = r0.addApi(r2)     // Catch:{ SecurityException -> 0x0073, all -> 0x0081 }
            com.google.android.gms.common.api.GoogleApiClient r2 = r0.build()     // Catch:{ SecurityException -> 0x0073, all -> 0x0081 }
            r2.connect()     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza r0 = new com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            r0.<init>()     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            r3 = 1
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza r0 = r0.zzL(r3)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza r0 = r0.zzbw(r7)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request r0 = r0.zzlb()     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.appdatasearch.zzk r3 = com.google.android.gms.appdatasearch.zza.zzOR     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.common.api.PendingResult r0 = r3.zza(r2, r0)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            r4 = 1
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.common.api.Result r0 = r0.await(r4, r3)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.appdatasearch.GetRecentContextCall$Response r0 = (com.google.android.gms.appdatasearch.GetRecentContextCall.Response) r0     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r0 == 0) goto L_0x0041
            com.google.android.gms.common.api.Status r3 = r0.getStatus()     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            boolean r3 = r3.isSuccess()     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r3 != 0) goto L_0x004c
        L_0x0041:
            java.lang.String r0 = "Fail to obtain recent context call"
            com.google.android.gms.ads.internal.util.client.zzb.zzaD(r0)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r2 == 0) goto L_0x004b
            r2.disconnect()
        L_0x004b:
            return r1
        L_0x004c:
            java.util.List<com.google.android.gms.appdatasearch.UsageInfo> r3 = r0.zzPw     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r3 == 0) goto L_0x0058
            java.util.List<com.google.android.gms.appdatasearch.UsageInfo> r3 = r0.zzPw     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            boolean r3 = r3.isEmpty()     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r3 == 0) goto L_0x0063
        L_0x0058:
            java.lang.String r0 = "Fail to obtain recent context"
            com.google.android.gms.ads.internal.util.client.zzb.zzaD(r0)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r2 == 0) goto L_0x004b
            r2.disconnect()
            goto L_0x004b
        L_0x0063:
            java.util.List<com.google.android.gms.appdatasearch.UsageInfo> r0 = r0.zzPw     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            com.google.android.gms.appdatasearch.UsageInfo r0 = (com.google.android.gms.appdatasearch.UsageInfo) r0     // Catch:{ SecurityException -> 0x008f, all -> 0x0089 }
            if (r2 == 0) goto L_0x0071
            r2.disconnect()
        L_0x0071:
            r1 = r0
            goto L_0x004b
        L_0x0073:
            r0 = move-exception
            r0 = r1
        L_0x0075:
            java.lang.String r2 = "Fail to get recent context"
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r2)     // Catch:{ all -> 0x008b }
            if (r0 == 0) goto L_0x0092
            r0.disconnect()
            r0 = r1
            goto L_0x0071
        L_0x0081:
            r0 = move-exception
            r2 = r1
        L_0x0083:
            if (r2 == 0) goto L_0x0088
            r2.disconnect()
        L_0x0088:
            throw r0
        L_0x0089:
            r0 = move-exception
            goto L_0x0083
        L_0x008b:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L_0x0083
        L_0x008f:
            r0 = move-exception
            r0 = r2
            goto L_0x0075
        L_0x0092:
            r0 = r1
            goto L_0x0071
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgn.zzd(android.content.Context, java.lang.String):com.google.android.gms.appdatasearch.UsageInfo");
    }

    private static Integer zzx(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
