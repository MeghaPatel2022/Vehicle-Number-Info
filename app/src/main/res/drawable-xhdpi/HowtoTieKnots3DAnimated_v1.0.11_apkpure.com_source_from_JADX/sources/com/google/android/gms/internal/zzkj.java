package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzf;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzkj {
    private final int zzUF;
    private final JSONObject zzWD;
    private final String zzWn;

    public zzkj(String str, int i, JSONObject jSONObject) {
        this.zzWn = str;
        this.zzUF = i;
        this.zzWD = jSONObject;
    }

    public zzkj(JSONObject jSONObject) throws JSONException {
        this(jSONObject.optString("playerId"), jSONObject.optInt("playerState"), jSONObject.optJSONObject("playerData"));
    }

    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof zzkj)) {
            return false;
        }
        zzkj zzkj = (zzkj) otherObj;
        return this.zzUF == zzkj.getPlayerState() && zzf.zza(this.zzWn, zzkj.getPlayerId()) && zzls.zzd(this.zzWD, zzkj.getPlayerData());
    }

    public JSONObject getPlayerData() {
        return this.zzWD;
    }

    public String getPlayerId() {
        return this.zzWn;
    }

    public int getPlayerState() {
        return this.zzUF;
    }
}
