package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack {
    public static final int SUBTYPE_CAPTIONS = 2;
    public static final int SUBTYPE_CHAPTERS = 4;
    public static final int SUBTYPE_DESCRIPTIONS = 3;
    public static final int SUBTYPE_METADATA = 5;
    public static final int SUBTYPE_NONE = 0;
    public static final int SUBTYPE_SUBTITLES = 1;
    public static final int SUBTYPE_UNKNOWN = -1;
    public static final int TYPE_AUDIO = 2;
    public static final int TYPE_TEXT = 1;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_VIDEO = 3;
    private String mName;
    private long zzQD;
    private int zzUS;
    private int zzUT;
    private String zzUc;
    private String zzUe;
    private String zzUg;
    private JSONObject zzUl;

    public static class Builder {
        private final MediaTrack zzUU;

        public Builder(long trackId, int trackType) throws IllegalArgumentException {
            this.zzUU = new MediaTrack(trackId, trackType);
        }

        public MediaTrack build() {
            return this.zzUU;
        }

        public Builder setContentId(String contentId) {
            this.zzUU.setContentId(contentId);
            return this;
        }

        public Builder setContentType(String contentType) {
            this.zzUU.setContentType(contentType);
            return this;
        }

        public Builder setCustomData(JSONObject customData) {
            this.zzUU.setCustomData(customData);
            return this;
        }

        public Builder setLanguage(String language) {
            this.zzUU.setLanguage(language);
            return this;
        }

        public Builder setLanguage(Locale locale) {
            this.zzUU.setLanguage(zzf.zzb(locale));
            return this;
        }

        public Builder setName(String trackName) {
            this.zzUU.setName(trackName);
            return this;
        }

        public Builder setSubtype(int subtype) throws IllegalArgumentException {
            this.zzUU.zzaO(subtype);
            return this;
        }
    }

    MediaTrack(long id, int type) throws IllegalArgumentException {
        clear();
        this.zzQD = id;
        if (type <= 0 || type > 3) {
            throw new IllegalArgumentException("invalid type " + type);
        }
        this.zzUS = type;
    }

    MediaTrack(JSONObject json) throws JSONException {
        zzf(json);
    }

    private void clear() {
        this.zzQD = 0;
        this.zzUS = 0;
        this.zzUe = null;
        this.mName = null;
        this.zzUc = null;
        this.zzUT = -1;
        this.zzUl = null;
    }

    private void zzf(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzQD = jSONObject.getLong("trackId");
        String string = jSONObject.getString("type");
        if ("TEXT".equals(string)) {
            this.zzUS = 1;
        } else if ("AUDIO".equals(string)) {
            this.zzUS = 2;
        } else if ("VIDEO".equals(string)) {
            this.zzUS = 3;
        } else {
            throw new JSONException("invalid type: " + string);
        }
        this.zzUe = jSONObject.optString("trackContentId", null);
        this.zzUg = jSONObject.optString("trackContentType", null);
        this.mName = jSONObject.optString("name", null);
        this.zzUc = jSONObject.optString("language", null);
        if (jSONObject.has("subtype")) {
            String string2 = jSONObject.getString("subtype");
            if ("SUBTITLES".equals(string2)) {
                this.zzUT = 1;
            } else if ("CAPTIONS".equals(string2)) {
                this.zzUT = 2;
            } else if ("DESCRIPTIONS".equals(string2)) {
                this.zzUT = 3;
            } else if ("CHAPTERS".equals(string2)) {
                this.zzUT = 4;
            } else if ("METADATA".equals(string2)) {
                this.zzUT = 5;
            } else {
                throw new JSONException("invalid subtype: " + string2);
            }
        } else {
            this.zzUT = 0;
        }
        this.zzUl = jSONObject.optJSONObject("customData");
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof MediaTrack)) {
            return false;
        }
        MediaTrack mediaTrack = (MediaTrack) other;
        if ((this.zzUl == null) != (mediaTrack.zzUl == null)) {
            return false;
        }
        if (this.zzUl != null && mediaTrack.zzUl != null && !zzls.zzd(this.zzUl, mediaTrack.zzUl)) {
            return false;
        }
        if (this.zzQD != mediaTrack.zzQD || this.zzUS != mediaTrack.zzUS || !zzf.zza(this.zzUe, mediaTrack.zzUe) || !zzf.zza(this.zzUg, mediaTrack.zzUg) || !zzf.zza(this.mName, mediaTrack.mName) || !zzf.zza(this.zzUc, mediaTrack.zzUc) || this.zzUT != mediaTrack.zzUT) {
            z = false;
        }
        return z;
    }

    public String getContentId() {
        return this.zzUe;
    }

    public String getContentType() {
        return this.zzUg;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public long getId() {
        return this.zzQD;
    }

    public String getLanguage() {
        return this.zzUc;
    }

    public String getName() {
        return this.mName;
    }

    public int getSubtype() {
        return this.zzUT;
    }

    public int getType() {
        return this.zzUS;
    }

    public int hashCode() {
        return zzw.hashCode(Long.valueOf(this.zzQD), Integer.valueOf(this.zzUS), this.zzUe, this.zzUg, this.mName, this.zzUc, Integer.valueOf(this.zzUT), this.zzUl);
    }

    public void setContentId(String contentId) {
        this.zzUe = contentId;
    }

    public void setContentType(String contentType) {
        this.zzUg = contentType;
    }

    /* access modifiers changed from: 0000 */
    public void setCustomData(JSONObject customData) {
        this.zzUl = customData;
    }

    /* access modifiers changed from: 0000 */
    public void setLanguage(String language) {
        this.zzUc = language;
    }

    /* access modifiers changed from: 0000 */
    public void setName(String name) {
        this.mName = name;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("trackId", this.zzQD);
            switch (this.zzUS) {
                case 1:
                    jSONObject.put("type", "TEXT");
                    break;
                case 2:
                    jSONObject.put("type", "AUDIO");
                    break;
                case 3:
                    jSONObject.put("type", "VIDEO");
                    break;
            }
            if (this.zzUe != null) {
                jSONObject.put("trackContentId", this.zzUe);
            }
            if (this.zzUg != null) {
                jSONObject.put("trackContentType", this.zzUg);
            }
            if (this.mName != null) {
                jSONObject.put("name", this.mName);
            }
            if (!TextUtils.isEmpty(this.zzUc)) {
                jSONObject.put("language", this.zzUc);
            }
            switch (this.zzUT) {
                case 1:
                    jSONObject.put("subtype", "SUBTITLES");
                    break;
                case 2:
                    jSONObject.put("subtype", "CAPTIONS");
                    break;
                case 3:
                    jSONObject.put("subtype", "DESCRIPTIONS");
                    break;
                case 4:
                    jSONObject.put("subtype", "CHAPTERS");
                    break;
                case 5:
                    jSONObject.put("subtype", "METADATA");
                    break;
            }
            if (this.zzUl != null) {
                jSONObject.put("customData", this.zzUl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: 0000 */
    public void zzaO(int i) throws IllegalArgumentException {
        if (i <= -1 || i > 5) {
            throw new IllegalArgumentException("invalid subtype " + i);
        } else if (i == 0 || this.zzUS == 1) {
            this.zzUT = i;
        } else {
            throw new IllegalArgumentException("subtypes are only valid for text tracks");
        }
    }
}
