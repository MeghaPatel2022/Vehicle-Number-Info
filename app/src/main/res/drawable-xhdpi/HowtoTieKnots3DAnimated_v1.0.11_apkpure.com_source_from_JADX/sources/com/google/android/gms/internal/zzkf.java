package com.google.android.gms.internal;

import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.games.Games;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzkf {
    private static final zzl zzTy = new zzl("GameManagerMessage");
    protected final zzke zzVU;
    protected final String zzWA;
    protected final String zzWB;
    protected final String zzWn;
    protected final long zzWo;
    protected final JSONObject zzWp;
    protected final int zzWt;
    protected final int zzWu;
    protected final String zzWv;
    protected final int zzWw;
    protected final int zzWx;
    protected final List<zzkj> zzWy;
    protected final JSONObject zzWz;

    public zzkf(int i, int i2, String str, JSONObject jSONObject, int i3, int i4, List<zzkj> list, JSONObject jSONObject2, String str2, String str3, long j, String str4, zzke zzke) {
        this.zzWt = i;
        this.zzWu = i2;
        this.zzWv = str;
        this.zzWp = jSONObject;
        this.zzWw = i3;
        this.zzWx = i4;
        this.zzWy = list;
        this.zzWz = jSONObject2;
        this.zzWA = str2;
        this.zzWn = str3;
        this.zzWo = j;
        this.zzWB = str4;
        this.zzVU = zzke;
    }

    private static List<zzkj> zza(JSONArray jSONArray) {
        zzkj zzkj;
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                try {
                    zzkj = new zzkj(optJSONObject);
                } catch (JSONException e) {
                    zzTy.zzc(e, "Exception when attempting to parse PlayerInfoMessageComponent at index %d", Integer.valueOf(i));
                    zzkj = null;
                }
                if (zzkj != null) {
                    arrayList.add(zzkj);
                }
            }
        }
        return arrayList;
    }

    protected static zzkf zzh(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("type", -1);
        switch (optInt) {
            case 1:
                zzke zzke = null;
                JSONObject optJSONObject = jSONObject.optJSONObject("gameManagerConfig");
                if (optJSONObject != null) {
                    zzke = new zzke(optJSONObject);
                }
                return new zzkf(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), jSONObject.optLong("requestId"), jSONObject.optString("playerToken"), zzke);
            case 2:
                return new zzkf(optInt, jSONObject.optInt("statusCode"), jSONObject.optString("errorDescription"), jSONObject.optJSONObject("extraMessageData"), jSONObject.optInt("gameplayState"), jSONObject.optInt("lobbyState"), zza(jSONObject.optJSONArray(Games.EXTRA_PLAYER_IDS)), jSONObject.optJSONObject("gameData"), jSONObject.optString("gameStatusText"), jSONObject.optString("playerId"), -1, null, null);
            default:
                try {
                    zzTy.zzf("Unrecognized Game Message type %d", Integer.valueOf(optInt));
                    break;
                } catch (JSONException e) {
                    zzTy.zzc(e, "Exception while parsing GameManagerMessage from json", new Object[0]);
                    break;
                }
        }
        return null;
    }

    public final JSONObject getExtraMessageData() {
        return this.zzWp;
    }

    public final JSONObject getGameData() {
        return this.zzWz;
    }

    public final int getGameplayState() {
        return this.zzWw;
    }

    public final int getLobbyState() {
        return this.zzWx;
    }

    public final String getPlayerId() {
        return this.zzWn;
    }

    public final long getRequestId() {
        return this.zzWo;
    }

    public final int getStatusCode() {
        return this.zzWu;
    }

    public final int zzmm() {
        return this.zzWt;
    }

    public final String zzmn() {
        return this.zzWv;
    }

    public final List<zzkj> zzmo() {
        return this.zzWy;
    }

    public final String zzmp() {
        return this.zzWA;
    }

    public final String zzmq() {
        return this.zzWB;
    }

    public final zzke zzmr() {
        return this.zzVU;
    }
}
