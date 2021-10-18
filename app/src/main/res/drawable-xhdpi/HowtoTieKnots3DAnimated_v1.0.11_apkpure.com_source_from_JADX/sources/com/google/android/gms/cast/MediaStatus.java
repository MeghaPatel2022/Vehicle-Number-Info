package com.google.android.gms.cast;

import android.util.SparseArray;
import com.google.android.gms.cast.internal.zzf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus {
    public static final long COMMAND_PAUSE = 1;
    public static final long COMMAND_SEEK = 2;
    public static final long COMMAND_SET_VOLUME = 4;
    public static final long COMMAND_SKIP_BACKWARD = 32;
    public static final long COMMAND_SKIP_FORWARD = 16;
    public static final long COMMAND_TOGGLE_MUTE = 8;
    public static final int IDLE_REASON_CANCELED = 2;
    public static final int IDLE_REASON_ERROR = 4;
    public static final int IDLE_REASON_FINISHED = 1;
    public static final int IDLE_REASON_INTERRUPTED = 3;
    public static final int IDLE_REASON_NONE = 0;
    public static final int PLAYER_STATE_BUFFERING = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_PAUSED = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    public static final int PLAYER_STATE_UNKNOWN = 0;
    public static final int REPEAT_MODE_REPEAT_ALL = 1;
    public static final int REPEAT_MODE_REPEAT_ALL_AND_SHUFFLE = 3;
    public static final int REPEAT_MODE_REPEAT_OFF = 0;
    public static final int REPEAT_MODE_REPEAT_SINGLE = 2;
    private long[] zzUA;
    /* access modifiers changed from: private */
    public int zzUC = 0;
    private long zzUD;
    private double zzUE;
    private int zzUF;
    private int zzUG;
    private long zzUH;
    private long zzUI;
    private double zzUJ;
    private boolean zzUK;
    private int zzUL = 0;
    private int zzUM = 0;
    private final zza zzUN = new zza();
    private JSONObject zzUl;
    /* access modifiers changed from: private */
    public MediaInfo zzUm;

    private class zza {
        private int zzUO = 0;
        private List<MediaQueueItem> zzUP = new ArrayList();
        private SparseArray<Integer> zzUQ = new SparseArray<>();

        zza() {
        }

        /* access modifiers changed from: private */
        public void clear() {
            this.zzUO = 0;
            this.zzUP.clear();
            this.zzUQ.clear();
        }

        private void zza(MediaQueueItem[] mediaQueueItemArr) {
            this.zzUP.clear();
            this.zzUQ.clear();
            for (int i = 0; i < mediaQueueItemArr.length; i++) {
                MediaQueueItem mediaQueueItem = mediaQueueItemArr[i];
                this.zzUP.add(mediaQueueItem);
                this.zzUQ.put(mediaQueueItem.getItemId(), Integer.valueOf(i));
            }
        }

        private Integer zzaN(int i) {
            return (Integer) this.zzUQ.get(i);
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x00f5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean zzg(org.json.JSONObject r11) throws org.json.JSONException {
            /*
                r10 = this;
                r3 = 3
                r0 = 2
                r1 = 0
                r2 = 1
                java.lang.String r4 = "repeatMode"
                boolean r4 = r11.has(r4)
                if (r4 == 0) goto L_0x00f7
                int r4 = r10.zzUO
                java.lang.String r5 = "repeatMode"
                java.lang.String r6 = r11.getString(r5)
                r5 = -1
                int r7 = r6.hashCode()
                switch(r7) {
                    case -1118317585: goto L_0x0073;
                    case -962896020: goto L_0x0069;
                    case 1645938909: goto L_0x005f;
                    case 1645952171: goto L_0x0055;
                    default: goto L_0x001c;
                }
            L_0x001c:
                switch(r5) {
                    case 0: goto L_0x007d;
                    case 1: goto L_0x007f;
                    case 2: goto L_0x0020;
                    case 3: goto L_0x0081;
                    default: goto L_0x001f;
                }
            L_0x001f:
                r0 = r4
            L_0x0020:
                int r3 = r10.zzUO
                if (r3 == r0) goto L_0x00f7
                r10.zzUO = r0
                r0 = r2
            L_0x0027:
                java.lang.String r3 = "items"
                boolean r3 = r11.has(r3)
                if (r3 == 0) goto L_0x00f5
                java.lang.String r3 = "items"
                org.json.JSONArray r4 = r11.getJSONArray(r3)
                int r5 = r4.length()
                android.util.SparseArray r6 = new android.util.SparseArray
                r6.<init>()
                r3 = r1
            L_0x003f:
                if (r3 >= r5) goto L_0x0083
                org.json.JSONObject r7 = r4.getJSONObject(r3)
                java.lang.String r8 = "itemId"
                int r7 = r7.getInt(r8)
                java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                r6.put(r3, r7)
                int r3 = r3 + 1
                goto L_0x003f
            L_0x0055:
                java.lang.String r7 = "REPEAT_OFF"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r1
                goto L_0x001c
            L_0x005f:
                java.lang.String r7 = "REPEAT_ALL"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r2
                goto L_0x001c
            L_0x0069:
                java.lang.String r7 = "REPEAT_SINGLE"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r0
                goto L_0x001c
            L_0x0073:
                java.lang.String r7 = "REPEAT_ALL_AND_SHUFFLE"
                boolean r6 = r6.equals(r7)
                if (r6 == 0) goto L_0x001c
                r5 = r3
                goto L_0x001c
            L_0x007d:
                r0 = r1
                goto L_0x0020
            L_0x007f:
                r0 = r2
                goto L_0x0020
            L_0x0081:
                r0 = r3
                goto L_0x0020
            L_0x0083:
                com.google.android.gms.cast.MediaQueueItem[] r7 = new com.google.android.gms.cast.MediaQueueItem[r5]
                r3 = r1
                r1 = r0
            L_0x0087:
                if (r3 >= r5) goto L_0x00e5
                java.lang.Object r0 = r6.get(r3)
                java.lang.Integer r0 = (java.lang.Integer) r0
                org.json.JSONObject r8 = r4.getJSONObject(r3)
                int r9 = r0.intValue()
                com.google.android.gms.cast.MediaQueueItem r9 = r10.zzaL(r9)
                if (r9 == 0) goto L_0x00b8
                boolean r8 = r9.zzg(r8)
                r1 = r1 | r8
                r7[r3] = r9
                int r0 = r0.intValue()
                java.lang.Integer r0 = r10.zzaN(r0)
                int r0 = r0.intValue()
                if (r3 == r0) goto L_0x00f3
                r0 = r2
            L_0x00b3:
                int r1 = r3 + 1
                r3 = r1
                r1 = r0
                goto L_0x0087
            L_0x00b8:
                int r0 = r0.intValue()
                com.google.android.gms.cast.MediaStatus r1 = com.google.android.gms.cast.MediaStatus.this
                int r1 = r1.zzUC
                if (r0 != r1) goto L_0x00dc
                com.google.android.gms.cast.MediaQueueItem$Builder r0 = new com.google.android.gms.cast.MediaQueueItem$Builder
                com.google.android.gms.cast.MediaStatus r1 = com.google.android.gms.cast.MediaStatus.this
                com.google.android.gms.cast.MediaInfo r1 = r1.zzUm
                r0.<init>(r1)
                com.google.android.gms.cast.MediaQueueItem r0 = r0.build()
                r7[r3] = r0
                r0 = r7[r3]
                r0.zzg(r8)
                r0 = r2
                goto L_0x00b3
            L_0x00dc:
                com.google.android.gms.cast.MediaQueueItem r0 = new com.google.android.gms.cast.MediaQueueItem
                r0.<init>(r8)
                r7[r3] = r0
                r0 = r2
                goto L_0x00b3
            L_0x00e5:
                java.util.List<com.google.android.gms.cast.MediaQueueItem> r0 = r10.zzUP
                int r0 = r0.size()
                if (r0 == r5) goto L_0x00f1
            L_0x00ed:
                r10.zza(r7)
            L_0x00f0:
                return r2
            L_0x00f1:
                r2 = r1
                goto L_0x00ed
            L_0x00f3:
                r0 = r1
                goto L_0x00b3
            L_0x00f5:
                r2 = r0
                goto L_0x00f0
            L_0x00f7:
                r0 = r1
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaStatus.zza.zzg(org.json.JSONObject):boolean");
        }

        public int getItemCount() {
            return this.zzUP.size();
        }

        public int getRepeatMode() {
            return this.zzUO;
        }

        public MediaQueueItem zzaL(int i) {
            Integer num = (Integer) this.zzUQ.get(i);
            if (num == null) {
                return null;
            }
            return (MediaQueueItem) this.zzUP.get(num.intValue());
        }

        public MediaQueueItem zzaM(int i) {
            if (i < 0 || i >= this.zzUP.size()) {
                return null;
            }
            return (MediaQueueItem) this.zzUP.get(i);
        }

        public List<MediaQueueItem> zzmd() {
            return Collections.unmodifiableList(this.zzUP);
        }
    }

    public MediaStatus(JSONObject json) throws JSONException {
        zza(json, 0);
    }

    private boolean zzi(int i, int i2) {
        return i == 1 && i2 == 0;
    }

    public long[] getActiveTrackIds() {
        return this.zzUA;
    }

    public int getCurrentItemId() {
        return this.zzUC;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public int getIdleReason() {
        return this.zzUG;
    }

    public int getLoadingItemId() {
        return this.zzUL;
    }

    public MediaInfo getMediaInfo() {
        return this.zzUm;
    }

    public double getPlaybackRate() {
        return this.zzUE;
    }

    public int getPlayerState() {
        return this.zzUF;
    }

    public int getPreloadedItemId() {
        return this.zzUM;
    }

    public MediaQueueItem getQueueItem(int index) {
        return this.zzUN.zzaM(index);
    }

    public MediaQueueItem getQueueItemById(int itemId) {
        return this.zzUN.zzaL(itemId);
    }

    public int getQueueItemCount() {
        return this.zzUN.getItemCount();
    }

    public List<MediaQueueItem> getQueueItems() {
        return this.zzUN.zzmd();
    }

    public int getQueueRepeatMode() {
        return this.zzUN.getRepeatMode();
    }

    public long getStreamPosition() {
        return this.zzUH;
    }

    public double getStreamVolume() {
        return this.zzUJ;
    }

    public boolean isMediaCommandSupported(long mediaCommand) {
        return (this.zzUI & mediaCommand) != 0;
    }

    public boolean isMute() {
        return this.zzUK;
    }

    public int zza(JSONObject jSONObject, int i) throws JSONException {
        int i2;
        long[] jArr;
        boolean z;
        int i3 = 2;
        boolean z2 = true;
        long j = jSONObject.getLong("mediaSessionId");
        if (j != this.zzUD) {
            this.zzUD = j;
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (jSONObject.has("playerState")) {
            String string = jSONObject.getString("playerState");
            int i4 = string.equals("IDLE") ? 1 : string.equals("PLAYING") ? 2 : string.equals("PAUSED") ? 3 : string.equals("BUFFERING") ? 4 : 0;
            if (i4 != this.zzUF) {
                this.zzUF = i4;
                i2 |= 2;
            }
            if (i4 == 1 && jSONObject.has("idleReason")) {
                String string2 = jSONObject.getString("idleReason");
                if (!string2.equals("CANCELLED")) {
                    i3 = string2.equals("INTERRUPTED") ? 3 : string2.equals("FINISHED") ? 1 : string2.equals("ERROR") ? 4 : 0;
                }
                if (i3 != this.zzUG) {
                    this.zzUG = i3;
                    i2 |= 2;
                }
            }
        }
        if (jSONObject.has("playbackRate")) {
            double d = jSONObject.getDouble("playbackRate");
            if (this.zzUE != d) {
                this.zzUE = d;
                i2 |= 2;
            }
        }
        if (jSONObject.has("currentTime") && (i & 2) == 0) {
            long zzf = zzf.zzf(jSONObject.getDouble("currentTime"));
            if (zzf != this.zzUH) {
                this.zzUH = zzf;
                i2 |= 2;
            }
        }
        if (jSONObject.has("supportedMediaCommands")) {
            long j2 = jSONObject.getLong("supportedMediaCommands");
            if (j2 != this.zzUI) {
                this.zzUI = j2;
                i2 |= 2;
            }
        }
        if (jSONObject.has(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME) && (i & 1) == 0) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME);
            double d2 = jSONObject2.getDouble("level");
            if (d2 != this.zzUJ) {
                this.zzUJ = d2;
                i2 |= 2;
            }
            boolean z3 = jSONObject2.getBoolean("muted");
            if (z3 != this.zzUK) {
                this.zzUK = z3;
                i2 |= 2;
            }
        }
        if (jSONObject.has("activeTrackIds")) {
            JSONArray jSONArray = jSONObject.getJSONArray("activeTrackIds");
            int length = jSONArray.length();
            long[] jArr2 = new long[length];
            for (int i5 = 0; i5 < length; i5++) {
                jArr2[i5] = jSONArray.getLong(i5);
            }
            if (this.zzUA != null && this.zzUA.length == length) {
                int i6 = 0;
                while (true) {
                    if (i6 < length) {
                        if (this.zzUA[i6] != jArr2[i6]) {
                            break;
                        }
                        i6++;
                    } else {
                        z2 = false;
                        break;
                    }
                }
            }
            if (z2) {
                this.zzUA = jArr2;
            }
            long[] jArr3 = jArr2;
            z = z2;
            jArr = jArr3;
        } else if (this.zzUA != null) {
            z = true;
            jArr = null;
        } else {
            jArr = null;
            z = false;
        }
        if (z) {
            this.zzUA = jArr;
            i2 |= 2;
        }
        if (jSONObject.has("customData")) {
            this.zzUl = jSONObject.getJSONObject("customData");
            i2 |= 2;
        }
        if (jSONObject.has("media")) {
            JSONObject jSONObject3 = jSONObject.getJSONObject("media");
            this.zzUm = new MediaInfo(jSONObject3);
            i2 |= 2;
            if (jSONObject3.has("metadata")) {
                i2 |= 4;
            }
        }
        if (jSONObject.has("currentItemId")) {
            int i7 = jSONObject.getInt("currentItemId");
            if (this.zzUC != i7) {
                this.zzUC = i7;
                i2 |= 2;
            }
        }
        int optInt = jSONObject.optInt("preloadedItemId", 0);
        if (this.zzUM != optInt) {
            this.zzUM = optInt;
            i2 |= 16;
        }
        int optInt2 = jSONObject.optInt("loadingItemId", 0);
        if (this.zzUL != optInt2) {
            this.zzUL = optInt2;
            i2 |= 2;
        }
        if (!zzi(this.zzUF, this.zzUL)) {
            return this.zzUN.zzg(jSONObject) ? i2 | 8 : i2;
        }
        this.zzUC = 0;
        this.zzUL = 0;
        this.zzUM = 0;
        if (this.zzUN.getItemCount() <= 0) {
            return i2;
        }
        this.zzUN.clear();
        return i2 | 8;
    }

    public long zzmc() {
        return this.zzUD;
    }
}
