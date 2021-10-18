package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zzm extends zzc {
    private static final String NAMESPACE = zzf.zzbM("com.google.cast.media");
    private final List<zzp> zzVQ = new ArrayList();
    private long zzXA;
    private MediaStatus zzXB;
    private final zzp zzXC = new zzp(86400000);
    private final zzp zzXD = new zzp(86400000);
    private final zzp zzXE = new zzp(86400000);
    private final zzp zzXF = new zzp(86400000);
    private final zzp zzXG = new zzp(86400000);
    private final zzp zzXH = new zzp(86400000);
    private final zzp zzXI = new zzp(86400000);
    private final zzp zzXJ = new zzp(86400000);
    private final zzp zzXK = new zzp(86400000);
    private final zzp zzXL = new zzp(86400000);
    private final zzp zzXM = new zzp(86400000);
    private final zzp zzXN = new zzp(86400000);
    private final zzp zzXO = new zzp(86400000);
    private final zzp zzXP = new zzp(86400000);

    public zzm(String str) {
        super(NAMESPACE, "MediaControlChannel", str, 1000);
        this.zzVQ.add(this.zzXC);
        this.zzVQ.add(this.zzXD);
        this.zzVQ.add(this.zzXE);
        this.zzVQ.add(this.zzXF);
        this.zzVQ.add(this.zzXG);
        this.zzVQ.add(this.zzXH);
        this.zzVQ.add(this.zzXI);
        this.zzVQ.add(this.zzXJ);
        this.zzVQ.add(this.zzXK);
        this.zzVQ.add(this.zzXL);
        this.zzVQ.add(this.zzXM);
        this.zzVQ.add(this.zzXN);
        this.zzVQ.add(this.zzXO);
        this.zzVQ.add(this.zzXP);
        zzmM();
    }

    private void zza(long j, JSONObject jSONObject) throws JSONException {
        int i;
        boolean z = true;
        boolean zzB = this.zzXC.zzB(j);
        boolean z2 = this.zzXG.zzmO() && !this.zzXG.zzB(j);
        if ((!this.zzXH.zzmO() || this.zzXH.zzB(j)) && (!this.zzXI.zzmO() || this.zzXI.zzB(j))) {
            z = false;
        }
        int i2 = z2 ? 2 : 0;
        if (z) {
            i2 |= 1;
        }
        if (zzB || this.zzXB == null) {
            this.zzXB = new MediaStatus(jSONObject);
            this.zzXA = SystemClock.elapsedRealtime();
            i = 31;
        } else {
            i = this.zzXB.zza(jSONObject, i2);
        }
        if ((i & 1) != 0) {
            this.zzXA = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 2) != 0) {
            this.zzXA = SystemClock.elapsedRealtime();
            onStatusUpdated();
        }
        if ((i & 4) != 0) {
            onMetadataUpdated();
        }
        if ((i & 8) != 0) {
            onQueueStatusUpdated();
        }
        if ((i & 16) != 0) {
            onPreloadStatusUpdated();
        }
        for (zzp zzc : this.zzVQ) {
            zzc.zzc(j, 0);
        }
    }

    private void zzmM() {
        this.zzXA = 0;
        this.zzXB = null;
        for (zzp clear : this.zzVQ) {
            clear.clear();
        }
    }

    public long getApproximateStreamPosition() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo == null || this.zzXA == 0) {
            return 0;
        }
        double playbackRate = this.zzXB.getPlaybackRate();
        long streamPosition = this.zzXB.getStreamPosition();
        int playerState = this.zzXB.getPlayerState();
        if (playbackRate == 0.0d || playerState != 2) {
            return streamPosition;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzXA;
        long j = elapsedRealtime < 0 ? 0 : elapsedRealtime;
        if (j == 0) {
            return streamPosition;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        long j2 = streamPosition + ((long) (((double) j) * playbackRate));
        if (streamDuration <= 0 || j2 <= streamDuration) {
            streamDuration = j2 < 0 ? 0 : j2;
        }
        return streamDuration;
    }

    public MediaInfo getMediaInfo() {
        if (this.zzXB == null) {
            return null;
        }
        return this.zzXB.getMediaInfo();
    }

    public MediaStatus getMediaStatus() {
        return this.zzXB;
    }

    public long getStreamDuration() {
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            return mediaInfo.getStreamDuration();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMetadataUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onPreloadStatusUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onQueueStatusUpdated() {
    }

    /* access modifiers changed from: protected */
    public void onStatusUpdated() {
    }

    public long zza(zzo zzo) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzmu = zzmu();
        this.zzXJ.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject.put("requestId", zzmu);
            jSONObject.put("type", "GET_STATUS");
            if (this.zzXB != null) {
                jSONObject.put("mediaSessionId", this.zzXB.zzmc());
            }
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, double d, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXH.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("level", d);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, int i, MediaQueueItem[] mediaQueueItemArr, int i2, Integer num, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXN.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", zzmc());
            if (i != 0) {
                jSONObject2.put("currentItemId", i);
            }
            if (i2 != 0) {
                jSONObject2.put("jump", i2);
            }
            if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (num != null) {
                switch (num.intValue()) {
                    case 0:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case 1:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case 2:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case 3:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                }
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, long j, int i, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXG.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "SEEK");
            jSONObject2.put("mediaSessionId", zzmc());
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (i == 1) {
                jSONObject2.put("resumeState", "PLAYBACK_START");
            } else if (i == 2) {
                jSONObject2.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, MediaInfo mediaInfo, boolean z, long j, long[] jArr, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXC.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "LOAD");
            jSONObject2.put("media", mediaInfo.toJson());
            jSONObject2.put("autoplay", z);
            jSONObject2.put("currentTime", zzf.zzA(j));
            if (jArr != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < jArr.length; i++) {
                    jSONArray.put(i, jArr[i]);
                }
                jSONObject2.put("activeTrackIds", jSONArray);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, TextTrackStyle textTrackStyle) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzmu = zzmu();
        this.zzXL.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject.put("requestId", zzmu);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            if (textTrackStyle != null) {
                jSONObject.put("textTrackStyle", textTrackStyle.toJson());
            }
            jSONObject.put("mediaSessionId", zzmc());
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXD.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzmc());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, boolean z, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXI.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z);
            jSONObject2.put(MediaRouteProviderProtocol.CLIENT_DATA_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, int[] iArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXP.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < iArr.length; i2++) {
                jSONArray.put(i2, iArr[i2]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, int[] iArr, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalArgumentException {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXO.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < iArr.length; i++) {
                jSONArray.put(i, iArr[i]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, long[] jArr) throws IOException {
        JSONObject jSONObject = new JSONObject();
        long zzmu = zzmu();
        this.zzXK.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject.put("requestId", zzmu);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < jArr.length; i++) {
                jSONArray.put(i, jArr[i]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException e) {
        }
        zza(jSONObject.toString(), zzmu, null);
        return zzmu;
    }

    public long zza(zzo zzo, MediaQueueItem[] mediaQueueItemArr, int i, int i2, JSONObject jSONObject) throws IOException, IllegalArgumentException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        } else if (i < 0 || i >= mediaQueueItemArr.length) {
            throw new IllegalArgumentException("Invalid startIndex: " + i);
        } else {
            JSONObject jSONObject2 = new JSONObject();
            long zzmu = zzmu();
            this.zzXC.zza(zzmu, zzo);
            zzU(true);
            try {
                jSONObject2.put("requestId", zzmu);
                jSONObject2.put("type", "QUEUE_LOAD");
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < mediaQueueItemArr.length; i3++) {
                    jSONArray.put(i3, mediaQueueItemArr[i3].toJson());
                }
                jSONObject2.put("items", jSONArray);
                switch (i2) {
                    case 0:
                        jSONObject2.put("repeatMode", "REPEAT_OFF");
                        break;
                    case 1:
                        jSONObject2.put("repeatMode", "REPEAT_ALL");
                        break;
                    case 2:
                        jSONObject2.put("repeatMode", "REPEAT_SINGLE");
                        break;
                    case 3:
                        jSONObject2.put("repeatMode", "REPEAT_ALL_AND_SHUFFLE");
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid repeat mode: " + i2);
                }
                jSONObject2.put("startIndex", i);
                if (jSONObject != null) {
                    jSONObject2.put("customData", jSONObject);
                }
            } catch (JSONException e) {
            }
            zza(jSONObject2.toString(), zzmu, null);
            return zzmu;
        }
    }

    public long zza(zzo zzo, MediaQueueItem[] mediaQueueItemArr, int i, JSONObject jSONObject) throws IOException, IllegalStateException, IllegalStateException {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXM.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "QUEUE_INSERT");
            jSONObject2.put("mediaSessionId", zzmc());
            JSONArray jSONArray = new JSONArray();
            for (int i2 = 0; i2 < mediaQueueItemArr.length; i2++) {
                jSONArray.put(i2, mediaQueueItemArr[i2].toJson());
            }
            jSONObject2.put("items", jSONArray);
            if (i != 0) {
                jSONObject2.put("insertBefore", i);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zzb(zzo zzo, JSONObject jSONObject) throws IOException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXF.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzmc());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public void zzb(long j, int i) {
        for (zzp zzc : this.zzVQ) {
            zzc.zzc(j, i);
        }
    }

    public final void zzbJ(String str) {
        this.zzWK.zzb("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1);
            if (string.equals("MEDIA_STATUS")) {
                JSONArray jSONArray = jSONObject.getJSONArray("status");
                if (jSONArray.length() > 0) {
                    zza(optLong, jSONArray.getJSONObject(0));
                    return;
                }
                this.zzXB = null;
                onStatusUpdated();
                onMetadataUpdated();
                onQueueStatusUpdated();
                onPreloadStatusUpdated();
                this.zzXJ.zzc(optLong, 0);
            } else if (string.equals("INVALID_PLAYER_STATE")) {
                this.zzWK.zzf("received unexpected error: Invalid Player State.", new Object[0]);
                JSONObject optJSONObject = jSONObject.optJSONObject("customData");
                for (zzp zzc : this.zzVQ) {
                    zzc.zzc(optLong, 2100, optJSONObject);
                }
            } else if (string.equals("LOAD_FAILED")) {
                this.zzXC.zzc(optLong, 2100, jSONObject.optJSONObject("customData"));
            } else if (string.equals("LOAD_CANCELLED")) {
                this.zzXC.zzc(optLong, RemoteMediaPlayer.STATUS_CANCELED, jSONObject.optJSONObject("customData"));
            } else if (string.equals("INVALID_REQUEST")) {
                this.zzWK.zzf("received unexpected error: Invalid Request.", new Object[0]);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("customData");
                for (zzp zzc2 : this.zzVQ) {
                    zzc2.zzc(optLong, 2100, optJSONObject2);
                }
            }
        } catch (JSONException e) {
            this.zzWK.zzf("Message is malformed (%s); ignoring: %s", e.getMessage(), str);
        }
    }

    public long zzc(zzo zzo, JSONObject jSONObject) throws IOException, IllegalStateException {
        JSONObject jSONObject2 = new JSONObject();
        long zzmu = zzmu();
        this.zzXE.zza(zzmu, zzo);
        zzU(true);
        try {
            jSONObject2.put("requestId", zzmu);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzmc());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException e) {
        }
        zza(jSONObject2.toString(), zzmu, null);
        return zzmu;
    }

    public long zzmc() throws IllegalStateException {
        if (this.zzXB != null) {
            return this.zzXB.zzmc();
        }
        throw new IllegalStateException("No current media session");
    }

    public void zzmt() {
        super.zzmt();
        zzmM();
    }

    /* access modifiers changed from: protected */
    public boolean zzz(long j) {
        boolean z;
        for (zzp zzd : this.zzVQ) {
            zzd.zzd(j, RemoteMediaPlayer.STATUS_TIMED_OUT);
        }
        synchronized (zzp.zzXT) {
            Iterator it = this.zzVQ.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((zzp) it.next()).zzmO()) {
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
