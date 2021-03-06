package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.images.WebImage;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzkk {
    private static final zzl zzTy = new zzl("MetadataUtils");
    private static final String[] zzXU = {"Z", "+hh", "+hhmm", "+hh:mm"};
    private static final String zzXV = ("yyyyMMdd'T'HHmmss" + zzXU[0]);

    public static String zza(Calendar calendar) {
        if (calendar == null) {
            zzTy.zzb("Calendar object cannot be null", new Object[0]);
            return null;
        }
        String str = zzXV;
        if (calendar.get(11) == 0 && calendar.get(12) == 0 && calendar.get(13) == 0) {
            str = "yyyyMMdd";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(calendar.getTimeZone());
        String format = simpleDateFormat.format(calendar.getTime());
        return format.endsWith("+0000") ? format.replace("+0000", zzXU[0]) : format;
    }

    public static void zza(List<WebImage> list, JSONObject jSONObject) {
        try {
            list.clear();
            JSONArray jSONArray = jSONObject.getJSONArray("images");
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                try {
                    list.add(new WebImage(jSONArray.getJSONObject(i)));
                } catch (IllegalArgumentException e) {
                }
            }
        } catch (JSONException e2) {
        }
    }

    public static void zza(JSONObject jSONObject, List<WebImage> list) {
        if (list != null && !list.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (WebImage json : list) {
                jSONArray.put(json.toJson());
            }
            try {
                jSONObject.put("images", jSONArray);
            } catch (JSONException e) {
            }
        }
    }

    public static Calendar zzbS(String str) {
        if (TextUtils.isEmpty(str)) {
            zzTy.zzb("Input string is empty or null", new Object[0]);
            return null;
        }
        String zzbT = zzbT(str);
        if (TextUtils.isEmpty(zzbT)) {
            zzTy.zzb("Invalid date format", new Object[0]);
            return null;
        }
        String zzbU = zzbU(str);
        String str2 = "yyyyMMdd";
        if (!TextUtils.isEmpty(zzbU)) {
            zzbT = zzbT + "T" + zzbU;
            str2 = zzbU.length() == "HHmmss".length() ? "yyyyMMdd'T'HHmmss" : zzXV;
        }
        Calendar instance = GregorianCalendar.getInstance();
        try {
            instance.setTime(new SimpleDateFormat(str2).parse(zzbT));
            return instance;
        } catch (ParseException e) {
            zzTy.zzb("Error parsing string: %s", e.getMessage());
            return null;
        }
    }

    private static String zzbT(String str) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            zzTy.zzb("Input string is empty or null", new Object[0]);
            return str2;
        }
        try {
            return str.substring(0, "yyyyMMdd".length());
        } catch (IndexOutOfBoundsException e) {
            zzTy.zze("Error extracting the date: %s", e.getMessage());
            return str2;
        }
    }

    private static String zzbU(String str) {
        if (TextUtils.isEmpty(str)) {
            zzTy.zzb("string is empty or null", new Object[0]);
            return null;
        }
        int indexOf = str.indexOf(84);
        int i = indexOf + 1;
        if (indexOf != "yyyyMMdd".length()) {
            zzTy.zzb("T delimeter is not found", new Object[0]);
            return null;
        }
        try {
            String substring = str.substring(i);
            if (substring.length() == "HHmmss".length()) {
                return substring;
            }
            switch (substring.charAt("HHmmss".length())) {
                case '+':
                case '-':
                    if (zzbV(substring)) {
                        return substring.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
                    }
                    return null;
                case 'Z':
                    if (substring.length() == "HHmmss".length() + zzXU[0].length()) {
                        return substring.substring(0, substring.length() - 1) + "+0000";
                    }
                    return null;
                default:
                    return null;
            }
        } catch (IndexOutOfBoundsException e) {
            zzTy.zzb("Error extracting the time substring: %s", e.getMessage());
            return null;
        }
    }

    private static boolean zzbV(String str) {
        int length = str.length();
        int length2 = "HHmmss".length();
        return length == zzXU[1].length() + length2 || length == zzXU[2].length() + length2 || length == length2 + zzXU[3].length();
    }
}
