package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.CastApi;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.games.GameManagerClient;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerInstanceResult;
import com.google.android.gms.cast.games.GameManagerClient.GameManagerResult;
import com.google.android.gms.cast.games.GameManagerClient.Listener;
import com.google.android.gms.cast.games.GameManagerState;
import com.google.android.gms.cast.games.PlayerInfo;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.cast.internal.zzp;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class zzkd extends com.google.android.gms.cast.internal.zzc {
    static final String NAMESPACE = zzf.zzbM("com.google.cast.games");
    /* access modifiers changed from: private */
    public static final zzl zzTy = new zzl("GameManagerChannel");
    private final Map<String, String> zzVP = new ConcurrentHashMap();
    private final List<zzp> zzVQ;
    private final String zzVR;
    /* access modifiers changed from: private */
    public final CastApi zzVS;
    /* access modifiers changed from: private */
    public final GoogleApiClient zzVT;
    /* access modifiers changed from: private */
    public zzke zzVU;
    private boolean zzVV = false;
    private GameManagerState zzVW;
    private GameManagerState zzVX;
    private String zzVY;
    private JSONObject zzVZ;
    private long zzWa = 0;
    private Listener zzWb;
    /* access modifiers changed from: private */
    public String zzWc;
    private final SharedPreferences zztU;

    public abstract class zza extends zzb<GameManagerResult> {
        public zza() {
            super();
            this.zzVC = new zzo(zzkd.this) {
                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            zza.this.zza(new zze(new Status(i, null, null), null, j, null));
                        } catch (ClassCastException e) {
                            zza.this.zza(zza.this.zzb(new Status(13)));
                        }
                    } else {
                        zzkf zzkf = (zzkf) obj;
                        String playerId = zzkf.getPlayerId();
                        if (i == 0 && playerId != null) {
                            zzkd.this.zzWc = playerId;
                        }
                        zza.this.zza(new zze(new Status(i, zzkf.zzmn(), null), playerId, zzkf.getRequestId(), zzkf.getExtraMessageData()));
                    }
                }

                public void zzy(long j) {
                    zza.this.zza(zza.this.zzb(new Status(2103)));
                }
            };
        }

        /* renamed from: zzt */
        public GameManagerResult zzb(Status status) {
            return new zze(status, null, -1, null);
        }
    }

    public abstract class zzb<R extends Result> extends com.google.android.gms.cast.internal.zzb<R> {
        protected zzo zzVC;

        public zzb() {
            super(zzkd.this.zzVT);
        }

        public abstract void execute();

        /* access modifiers changed from: protected */
        public void zza(com.google.android.gms.cast.internal.zze zze) {
            execute();
        }

        public zzo zzmk() {
            return this.zzVC;
        }
    }

    public abstract class zzc extends zzb<GameManagerInstanceResult> {
        /* access modifiers changed from: private */
        public GameManagerClient zzWl;

        public zzc(GameManagerClient gameManagerClient) {
            super();
            this.zzWl = gameManagerClient;
            this.zzVC = new zzo(zzkd.this) {
                public void zza(long j, int i, Object obj) {
                    if (obj == null) {
                        try {
                            zzc.this.zza(new zzd(new Status(i, null, null), zzc.this.zzWl));
                        } catch (ClassCastException e) {
                            zzc.this.zza(zzc.this.zzb(new Status(13)));
                        }
                    } else {
                        zzkf zzkf = (zzkf) obj;
                        zzke zzmr = zzkf.zzmr();
                        if (zzmr == null || zzf.zza("1.0.0", zzmr.getVersion())) {
                            zzc.this.zza(new zzd(new Status(i, zzkf.zzmn(), null), zzc.this.zzWl));
                            return;
                        }
                        zzc.this.zza(zzc.this.zzb(new Status(GameManagerClient.STATUS_INCORRECT_VERSION, String.format(Locale.ROOT, "Incorrect Game Manager SDK version. Receiver: %s Sender: %s", new Object[]{zzmr.getVersion(), "1.0.0"}))));
                        zzkd.this.zzVU = null;
                    }
                }

                public void zzy(long j) {
                    zzc.this.zza(zzc.this.zzb(new Status(2103)));
                }
            };
        }

        /* renamed from: zzu */
        public GameManagerInstanceResult zzb(Status status) {
            return new zzd(status, null);
        }
    }

    private static final class zzd implements GameManagerInstanceResult {
        private final Status zzQA;
        private final GameManagerClient zzWl;

        zzd(Status status, GameManagerClient gameManagerClient) {
            this.zzQA = status;
            this.zzWl = gameManagerClient;
        }

        public GameManagerClient getGameManagerClient() {
            return this.zzWl;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    private static final class zze implements GameManagerResult {
        private final Status zzQA;
        private final String zzWn;
        private final long zzWo;
        private final JSONObject zzWp;

        zze(Status status, String str, long j, JSONObject jSONObject) {
            this.zzQA = status;
            this.zzWn = str;
            this.zzWo = j;
            this.zzWp = jSONObject;
        }

        public JSONObject getExtraMessageData() {
            return this.zzWp;
        }

        public String getPlayerId() {
            return this.zzWn;
        }

        public long getRequestId() {
            return this.zzWo;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public zzkd(GoogleApiClient googleApiClient, String str, CastApi castApi) throws IllegalArgumentException, IllegalStateException {
        super(NAMESPACE, "CastGameManagerChannel", null);
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("castSessionId cannot be null.");
        } else if (googleApiClient == null || !googleApiClient.isConnected() || !googleApiClient.hasConnectedApi(Cast.API)) {
            throw new IllegalArgumentException("googleApiClient needs to be connected and contain the Cast.API API.");
        } else {
            this.zzVQ = new ArrayList();
            this.zzVR = str;
            this.zzVS = castApi;
            this.zzVT = googleApiClient;
            Context applicationContext = googleApiClient.getContext().getApplicationContext();
            this.zztU = applicationContext.getApplicationContext().getSharedPreferences(String.format(Locale.ROOT, "%s.%s", new Object[]{applicationContext.getPackageName(), "game_manager_channel_data"}), 0);
            this.zzVX = null;
            this.zzVW = new zzkh(0, 0, "", null, new ArrayList(), "", -1);
        }
    }

    private JSONObject zza(long j, String str, int i, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("requestId", j);
            jSONObject2.put("type", i);
            jSONObject2.put("extraMessageData", jSONObject);
            jSONObject2.put("playerId", str);
            jSONObject2.put("playerToken", zzbI(str));
            return jSONObject2;
        } catch (JSONException e) {
            zzTy.zzf("JSONException when trying to create a message: %s", e.getMessage());
            return null;
        }
    }

    private synchronized void zza(zzkf zzkf) {
        boolean z = true;
        synchronized (this) {
            if (zzkf.zzmm() != 1) {
                z = false;
            }
            this.zzVX = this.zzVW;
            if (z && zzkf.zzmr() != null) {
                this.zzVU = zzkf.zzmr();
            }
            if (isInitialized()) {
                ArrayList arrayList = new ArrayList();
                for (zzkj zzkj : zzkf.zzmo()) {
                    String playerId = zzkj.getPlayerId();
                    arrayList.add(new zzki(playerId, zzkj.getPlayerState(), zzkj.getPlayerData(), this.zzVP.containsKey(playerId)));
                }
                this.zzVW = new zzkh(zzkf.getLobbyState(), zzkf.getGameplayState(), zzkf.zzmp(), zzkf.getGameData(), arrayList, this.zzVU.zzml(), this.zzVU.getMaxPlayers());
                PlayerInfo player = this.zzVW.getPlayer(zzkf.getPlayerId());
                if (player != null && player.isControllable() && zzkf.zzmm() == 2) {
                    this.zzVY = zzkf.getPlayerId();
                    this.zzVZ = zzkf.getExtraMessageData();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void zza(String str, int i, JSONObject jSONObject, zzo zzo) {
        final long j = 1 + this.zzWa;
        this.zzWa = j;
        JSONObject zza2 = zza(j, str, i, jSONObject);
        if (zza2 == null) {
            zzo.zza(-1, 2001, null);
            zzTy.zzf("Not sending request because it was invalid.", new Object[0]);
            return;
        }
        zzp zzp = new zzp(30000);
        zzp.zza(j, zzo);
        this.zzVQ.add(zzp);
        zzU(true);
        this.zzVS.sendMessage(this.zzVT, getNamespace(), zza2.toString()).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzr */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    zzkd.this.zzb(j, status.getStatusCode());
                }
            }
        });
    }

    private int zzaQ(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2001;
            case 2:
                return 2003;
            case 3:
                return GameManagerClient.STATUS_INCORRECT_VERSION;
            case 4:
                return GameManagerClient.STATUS_TOO_MANY_PLAYERS;
            default:
                zzTy.zzf("Unknown GameManager protocol status code: " + i, new Object[0]);
                return 13;
        }
    }

    private void zzb(long j, int i, Object obj) {
        Iterator it = this.zzVQ.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzc(j, i, obj)) {
                it.remove();
            }
        }
    }

    private synchronized void zzmf() throws IllegalStateException {
        if (!isInitialized()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel before it is initialized.");
        } else if (isDisposed()) {
            throw new IllegalStateException("Attempted to perform an operation on the GameManagerChannel after it has been disposed.");
        }
    }

    private void zzmg() {
        if (this.zzWb != null) {
            if (this.zzVX != null && !this.zzVW.equals(this.zzVX)) {
                this.zzWb.onStateChanged(this.zzVW, this.zzVX);
            }
            if (!(this.zzVZ == null || this.zzVY == null)) {
                this.zzWb.onGameMessageReceived(this.zzVY, this.zzVZ);
            }
        }
        this.zzVX = null;
        this.zzVY = null;
        this.zzVZ = null;
    }

    /* access modifiers changed from: private */
    public synchronized void zzmh() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("castSessionId", this.zzVR);
            jSONObject.put("playerTokenMap", new JSONObject(this.zzVP));
            this.zztU.edit().putString("save_data", jSONObject.toString()).commit();
        } catch (JSONException e) {
            zzTy.zzf("Error while saving data: %s", e.getMessage());
        }
        return;
    }

    /* access modifiers changed from: private */
    public synchronized void zzmi() {
        String string = this.zztU.getString("save_data", null);
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (this.zzVR.equals(jSONObject.getString("castSessionId"))) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("playerTokenMap");
                    Iterator keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String str = (String) keys.next();
                        this.zzVP.put(str, jSONObject2.getString(str));
                    }
                    this.zzWa = 0;
                }
            } catch (JSONException e) {
                zzTy.zzf("Error while loading data: %s", e.getMessage());
            }
        }
        return;
    }

    public synchronized void dispose() throws IllegalStateException {
        if (!this.zzVV) {
            this.zzVW = null;
            this.zzVX = null;
            this.zzVY = null;
            this.zzVZ = null;
            this.zzVV = true;
            try {
                this.zzVS.removeMessageReceivedCallbacks(this.zzVT, getNamespace());
            } catch (IOException e) {
                zzTy.zzf("Exception while detaching game manager channel.", e);
            }
        }
        return;
    }

    public synchronized GameManagerState getCurrentState() throws IllegalStateException {
        zzmf();
        return this.zzVW;
    }

    public synchronized String getLastUsedPlayerId() throws IllegalStateException {
        zzmf();
        return this.zzWc;
    }

    public synchronized boolean isDisposed() {
        return this.zzVV;
    }

    public synchronized boolean isInitialized() {
        return this.zzVU != null;
    }

    public synchronized void sendGameMessage(String playerId, JSONObject extraMessageData) throws IllegalStateException {
        zzmf();
        long j = 1 + this.zzWa;
        this.zzWa = j;
        JSONObject zza2 = zza(j, playerId, 7, extraMessageData);
        if (zza2 != null) {
            this.zzVS.sendMessage(this.zzVT, getNamespace(), zza2.toString());
        }
    }

    public synchronized PendingResult<GameManagerResult> sendGameRequest(final String playerId, final JSONObject extraMessageData) throws IllegalStateException {
        zzmf();
        return this.zzVT.zzb(new zza() {
            public void execute() {
                zzkd.this.zza(playerId, 6, extraMessageData, zzmk());
            }
        });
    }

    public synchronized void setListener(Listener listener) {
        this.zzWb = listener;
    }

    public synchronized PendingResult<GameManagerInstanceResult> zza(GameManagerClient gameManagerClient) throws IllegalArgumentException {
        if (gameManagerClient == null) {
            throw new IllegalArgumentException("gameManagerClient can't be null.");
        }
        return this.zzVT.zzb(new zzc(gameManagerClient) {
            public void execute() {
                try {
                    zzkd.this.zzVS.setMessageReceivedCallbacks(zzkd.this.zzVT, zzkd.this.getNamespace(), new MessageReceivedCallback() {
                        public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
                            zzkd.this.zzbJ(message);
                        }
                    });
                    zzkd.this.zzmi();
                    zzkd.this.zzmh();
                    zzkd.this.zza((String) null, 1100, (JSONObject) null, zzmk());
                } catch (IOException | IllegalStateException e) {
                    zzmk().zza(-1, 8, null);
                }
            }
        });
    }

    public synchronized PendingResult<GameManagerResult> zza(final String str, final int i, final JSONObject jSONObject) throws IllegalStateException {
        zzmf();
        return this.zzVT.zzb(new zza() {
            public void execute() {
                int zzaR = zzkg.zzaR(i);
                if (zzaR == 0) {
                    zzmk().zza(-1, 2001, null);
                    zzkd.zzTy.zzf("sendPlayerRequest for unsupported playerState: %d", Integer.valueOf(i));
                    return;
                }
                zzkd.this.zza(str, zzaR, jSONObject, zzmk());
            }
        });
    }

    public void zzb(long j, int i) {
        zzb(j, i, null);
    }

    public synchronized String zzbI(String str) throws IllegalStateException {
        return str == null ? null : (String) this.zzVP.get(str);
    }

    public final void zzbJ(String str) {
        zzTy.zzb("message received: %s", str);
        try {
            zzkf zzh = zzkf.zzh(new JSONObject(str));
            if (zzh == null) {
                zzTy.zzf("Could not parse game manager message from string: %s", str);
            } else if ((isInitialized() || zzh.zzmr() != null) && !isDisposed()) {
                boolean z = zzh.zzmm() == 1;
                if (z && !TextUtils.isEmpty(zzh.zzmq())) {
                    this.zzVP.put(zzh.getPlayerId(), zzh.zzmq());
                    zzmh();
                }
                if (zzh.getStatusCode() == 0) {
                    zza(zzh);
                } else {
                    zzTy.zzf("Not updating from game message because the message contains error code: %d", Integer.valueOf(zzh.getStatusCode()));
                }
                int zzaQ = zzaQ(zzh.getStatusCode());
                if (z) {
                    zzb(zzh.getRequestId(), zzaQ, zzh);
                }
                if (isInitialized() && zzaQ == 0) {
                    zzmg();
                }
            }
        } catch (JSONException e) {
            zzTy.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzz(long j) {
        boolean z;
        Iterator it = this.zzVQ.iterator();
        while (it.hasNext()) {
            if (((zzp) it.next()).zzd(j, 15)) {
                it.remove();
            }
        }
        synchronized (zzp.zzXT) {
            Iterator it2 = this.zzVQ.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (((zzp) it2.next()).zzmO()) {
                        z = true;
                        break;
                    }
                } else {
                    z = false;
                    break;
                }
            }
        }
        return z;
    }
}
