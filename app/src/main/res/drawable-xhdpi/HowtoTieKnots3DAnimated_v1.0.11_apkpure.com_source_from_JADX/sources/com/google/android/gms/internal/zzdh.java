package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.plus.PlusShare;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzgk
public class zzdh implements zzdg {
    private final Context mContext;
    private final VersionInfoParcel zzpa;

    @zzgk
    static class zza {
        private final String mValue;
        private final String zztP;

        public zza(String str, String str2) {
            this.zztP = str;
            this.mValue = str2;
        }

        public String getKey() {
            return this.zztP;
        }

        public String getValue() {
            return this.mValue;
        }
    }

    @zzgk
    static class zzb {
        private final String zzwY;
        private final URL zzwZ;
        private final ArrayList<zza> zzxa;
        private final String zzxb;

        public zzb(String str, URL url, ArrayList<zza> arrayList, String str2) {
            this.zzwY = str;
            this.zzwZ = url;
            if (arrayList == null) {
                this.zzxa = new ArrayList<>();
            } else {
                this.zzxa = arrayList;
            }
            this.zzxb = str2;
        }

        public String zzdA() {
            return this.zzwY;
        }

        public URL zzdB() {
            return this.zzwZ;
        }

        public ArrayList<zza> zzdC() {
            return this.zzxa;
        }

        public String zzdD() {
            return this.zzxb;
        }
    }

    @zzgk
    class zzc {
        private final zzd zzxc;
        private final boolean zzxd;
        private final String zzxe;

        public zzc(boolean z, zzd zzd, String str) {
            this.zzxd = z;
            this.zzxc = zzd;
            this.zzxe = str;
        }

        public String getReason() {
            return this.zzxe;
        }

        public boolean isSuccess() {
            return this.zzxd;
        }

        public zzd zzdE() {
            return this.zzxc;
        }
    }

    @zzgk
    static class zzd {
        private final String zzvM;
        private final String zzwY;
        private final int zzxf;
        private final List<zza> zzxg;

        public zzd(String str, int i, List<zza> list, String str2) {
            this.zzwY = str;
            this.zzxf = i;
            if (list == null) {
                this.zzxg = new ArrayList();
            } else {
                this.zzxg = list;
            }
            this.zzvM = str2;
        }

        public String getBody() {
            return this.zzvM;
        }

        public int getResponseCode() {
            return this.zzxf;
        }

        public String zzdA() {
            return this.zzwY;
        }

        public Iterable<zza> zzdF() {
            return this.zzxg;
        }
    }

    public zzdh(Context context, VersionInfoParcel versionInfoParcel) {
        this.mContext = context;
        this.zzpa = versionInfoParcel;
    }

    public JSONObject zzV(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject();
            String str2 = "";
            try {
                str2 = jSONObject.optString("http_request_id");
                zzc zza2 = zza(zzb(jSONObject));
                if (zza2.isSuccess()) {
                    jSONObject2.put("response", zza(zza2.zzdE()));
                    jSONObject2.put("success", true);
                    return jSONObject2;
                }
                jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                jSONObject2.put("success", false);
                jSONObject2.put("reason", zza2.getReason());
                return jSONObject2;
            } catch (Exception e) {
                try {
                    jSONObject2.put("response", new JSONObject().put("http_request_id", str2));
                    jSONObject2.put("success", false);
                    jSONObject2.put("reason", e.toString());
                    return jSONObject2;
                } catch (JSONException e2) {
                    return jSONObject2;
                }
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.m19e("The request is not a valid JSON.");
            try {
                return new JSONObject().put("success", false);
            } catch (JSONException e4) {
                return new JSONObject();
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzc zza(zzb zzb2) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) zzb2.zzdB().openConnection();
            zzp.zzbx().zza(this.mContext, this.zzpa.zzIz, false, httpURLConnection);
            Iterator it = zzb2.zzdC().iterator();
            while (it.hasNext()) {
                zza zza2 = (zza) it.next();
                httpURLConnection.addRequestProperty(zza2.getKey(), zza2.getValue());
            }
            if (!TextUtils.isEmpty(zzb2.zzdD())) {
                httpURLConnection.setDoOutput(true);
                byte[] bytes = zzb2.zzdD().getBytes();
                httpURLConnection.setFixedLengthStreamingMode(bytes.length);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream());
                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
            }
            ArrayList arrayList = new ArrayList();
            if (httpURLConnection.getHeaderFields() != null) {
                for (Entry entry : httpURLConnection.getHeaderFields().entrySet()) {
                    for (String zza3 : (List) entry.getValue()) {
                        arrayList.add(new zza((String) entry.getKey(), zza3));
                    }
                }
            }
            return new zzc(true, new zzd(zzb2.zzdA(), httpURLConnection.getResponseCode(), arrayList, zzp.zzbx().zza(new InputStreamReader(httpURLConnection.getInputStream()))), null);
        } catch (Exception e) {
            return new zzc(false, null, e.toString());
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject zza(zzd zzd2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("http_request_id", zzd2.zzdA());
            if (zzd2.getBody() != null) {
                jSONObject.put("body", zzd2.getBody());
            }
            JSONArray jSONArray = new JSONArray();
            for (zza zza2 : zzd2.zzdF()) {
                jSONArray.put(new JSONObject().put("key", zza2.getKey()).put("value", zza2.getValue()));
            }
            jSONObject.put("headers", jSONArray);
            jSONObject.put("response_code", zzd2.getResponseCode());
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing JSON for http response.", e);
        }
        return jSONObject;
    }

    public void zza(final zzip zzip, final Map<String, String> map) {
        zzht.zza((Runnable) new Runnable() {
            public void run() {
                com.google.android.gms.ads.internal.util.client.zzb.zzaC("Received Http request.");
                final JSONObject zzV = zzdh.this.zzV((String) map.get("http_request"));
                if (zzV == null) {
                    com.google.android.gms.ads.internal.util.client.zzb.m19e("Response should not be null.");
                } else {
                    zzhu.zzHK.post(new Runnable() {
                        public void run() {
                            zzip.zzb("fetchHttpRequestCompleted", zzV);
                            com.google.android.gms.ads.internal.util.client.zzb.zzaC("Dispatched http response.");
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public zzb zzb(JSONObject jSONObject) {
        URL url;
        String optString = jSONObject.optString("http_request_id");
        String optString2 = jSONObject.optString(PlusShare.KEY_CALL_TO_ACTION_URL);
        String optString3 = jSONObject.optString("post_body", null);
        try {
            url = new URL(optString2);
        } catch (MalformedURLException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzb("Error constructing http request.", e);
            url = null;
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("headers");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(new zza(optJSONObject.optString("key"), optJSONObject.optString("value")));
            }
        }
        return new zzb(optString, url, arrayList, optString3);
    }
}
