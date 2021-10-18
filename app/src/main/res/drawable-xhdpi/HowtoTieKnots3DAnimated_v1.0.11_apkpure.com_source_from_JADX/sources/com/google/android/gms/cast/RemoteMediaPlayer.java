package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzm;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.cast.internal.zzo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer implements MessageReceivedCallback {
    public static final int RESUME_STATE_PAUSE = 2;
    public static final int RESUME_STATE_PLAY = 1;
    public static final int RESUME_STATE_UNCHANGED = 0;
    public static final int STATUS_CANCELED = 2101;
    public static final int STATUS_FAILED = 2100;
    public static final int STATUS_REPLACED = 2103;
    public static final int STATUS_SUCCEEDED = 0;
    public static final int STATUS_TIMED_OUT = 2102;
    /* access modifiers changed from: private */
    public final zzm zzUV = new zzm(null) {
        /* access modifiers changed from: protected */
        public void onMetadataUpdated() {
            RemoteMediaPlayer.this.onMetadataUpdated();
        }

        /* access modifiers changed from: protected */
        public void onPreloadStatusUpdated() {
            RemoteMediaPlayer.this.onPreloadStatusUpdated();
        }

        /* access modifiers changed from: protected */
        public void onQueueStatusUpdated() {
            RemoteMediaPlayer.this.onQueueStatusUpdated();
        }

        /* access modifiers changed from: protected */
        public void onStatusUpdated() {
            RemoteMediaPlayer.this.onStatusUpdated();
        }
    };
    /* access modifiers changed from: private */
    public final zza zzUW = new zza();
    private OnPreloadStatusUpdatedListener zzUX;
    private OnQueueStatusUpdatedListener zzUY;
    private OnMetadataUpdatedListener zzUZ;
    private OnStatusUpdatedListener zzVa;
    /* access modifiers changed from: private */
    public final Object zzpc = new Object();

    public interface MediaChannelResult extends Result {
        JSONObject getCustomData();
    }

    public interface OnMetadataUpdatedListener {
        void onMetadataUpdated();
    }

    public interface OnPreloadStatusUpdatedListener {
        void onPreloadStatusUpdated();
    }

    public interface OnQueueStatusUpdatedListener {
        void onQueueStatusUpdated();
    }

    public interface OnStatusUpdatedListener {
        void onStatusUpdated();
    }

    private class zza implements zzn {
        private GoogleApiClient zzVy;
        private long zzVz = 0;

        /* renamed from: com.google.android.gms.cast.RemoteMediaPlayer$zza$zza reason: collision with other inner class name */
        private final class C1347zza implements ResultCallback<Status> {
            private final long zzVA;

            C1347zza(long j) {
                this.zzVA = j;
            }

            /* renamed from: zzr */
            public void onResult(Status status) {
                if (!status.isSuccess()) {
                    RemoteMediaPlayer.this.zzUV.zzb(this.zzVA, status.getStatusCode());
                }
            }
        }

        public zza() {
        }

        public void zza(String str, String str2, long j, String str3) throws IOException {
            if (this.zzVy == null) {
                throw new IOException("No GoogleApiClient available");
            }
            Cast.CastApi.sendMessage(this.zzVy, str, str2).setResultCallback(new C1347zza(j));
        }

        public void zzb(GoogleApiClient googleApiClient) {
            this.zzVy = googleApiClient;
        }

        public long zzme() {
            long j = this.zzVz + 1;
            this.zzVz = j;
            return j;
        }
    }

    private static abstract class zzb extends com.google.android.gms.cast.internal.zzb<MediaChannelResult> {
        zzo zzVC = new zzo() {
            public void zza(long j, int i, Object obj) {
                zzb.this.zza((Result) new zzc(new Status(i), obj instanceof JSONObject ? (JSONObject) obj : null));
            }

            public void zzy(long j) {
                zzb.this.zza((Result) zzb.this.zzb(new Status(2103)));
            }
        };

        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzs */
        public MediaChannelResult zzb(final Status status) {
            return new MediaChannelResult() {
                public JSONObject getCustomData() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static final class zzc implements MediaChannelResult {
        private final Status zzQA;
        private final JSONObject zzUl;

        zzc(Status status, JSONObject jSONObject) {
            this.zzQA = status;
            this.zzUl = jSONObject;
        }

        public JSONObject getCustomData() {
            return this.zzUl;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public RemoteMediaPlayer() {
        this.zzUV.zza(this.zzUW);
    }

    /* access modifiers changed from: private */
    public void onMetadataUpdated() {
        if (this.zzUZ != null) {
            this.zzUZ.onMetadataUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onPreloadStatusUpdated() {
        if (this.zzUX != null) {
            this.zzUX.onPreloadStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onQueueStatusUpdated() {
        if (this.zzUY != null) {
            this.zzUY.onQueueStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    public void onStatusUpdated() {
        if (this.zzVa != null) {
            this.zzVa.onStatusUpdated();
        }
    }

    /* access modifiers changed from: private */
    public int zzaP(int i) {
        MediaStatus mediaStatus = getMediaStatus();
        for (int i2 = 0; i2 < mediaStatus.getQueueItemCount(); i2++) {
            if (mediaStatus.getQueueItem(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public long getApproximateStreamPosition() {
        long approximateStreamPosition;
        synchronized (this.zzpc) {
            approximateStreamPosition = this.zzUV.getApproximateStreamPosition();
        }
        return approximateStreamPosition;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo;
        synchronized (this.zzpc) {
            mediaInfo = this.zzUV.getMediaInfo();
        }
        return mediaInfo;
    }

    public MediaStatus getMediaStatus() {
        MediaStatus mediaStatus;
        synchronized (this.zzpc) {
            mediaStatus = this.zzUV.getMediaStatus();
        }
        return mediaStatus;
    }

    public String getNamespace() {
        return this.zzUV.getNamespace();
    }

    public long getStreamDuration() {
        long streamDuration;
        synchronized (this.zzpc) {
            streamDuration = this.zzUV.getStreamDuration();
        }
        return streamDuration;
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo) {
        return load(apiClient, mediaInfo, true, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay) {
        return load(apiClient, mediaInfo, autoplay, 0, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, null);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, JSONObject customData) {
        return load(apiClient, mediaInfo, autoplay, playPosition, null, customData);
    }

    public PendingResult<MediaChannelResult> load(GoogleApiClient apiClient, MediaInfo mediaInfo, boolean autoplay, long playPosition, long[] activeTrackIds, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaInfo mediaInfo2 = mediaInfo;
        final boolean z = autoplay;
        final long j = playPosition;
        final long[] jArr = activeTrackIds;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, mediaInfo2, z, j, jArr, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public void onMessageReceived(CastDevice castDevice, String namespace, String message) {
        this.zzUV.zzbJ(message);
    }

    public PendingResult<MediaChannelResult> pause(GoogleApiClient apiClient) {
        return pause(apiClient, null);
    }

    public PendingResult<MediaChannelResult> pause(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, customData);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> play(GoogleApiClient apiClient) {
        return play(apiClient, null);
    }

    public PendingResult<MediaChannelResult> play(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zzc(this.zzVC, customData);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueAppendItem(GoogleApiClient apiClient, MediaQueueItem item, JSONObject customData) throws IllegalArgumentException {
        return queueInsertItems(apiClient, new MediaQueueItem[]{item}, 0, customData);
    }

    public PendingResult<MediaChannelResult> queueInsertItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToInsert, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToInsert;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, mediaQueueItemArr, i, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueJumpToItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.cast.internal.zze r9) {
                /*
                    r8 = this;
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this
                    java.lang.Object r7 = r0.zzpc
                    monitor-enter(r7)
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    int r1 = r3     // Catch:{ all -> 0x004a }
                    int r0 = r0.zzaP(r1)     // Catch:{ all -> 0x004a }
                    r1 = -1
                    if (r0 != r1) goto L_0x0021
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.<init>(r1)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzb(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r7)     // Catch:{ all -> 0x004a }
                L_0x0020:
                    return
                L_0x0021:
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004a }
                    com.google.android.gms.common.api.GoogleApiClient r1 = r4     // Catch:{ all -> 0x004a }
                    r0.zzb(r1)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ IOException -> 0x004d }
                    com.google.android.gms.cast.internal.zzm r0 = r0.zzUV     // Catch:{ IOException -> 0x004d }
                    com.google.android.gms.cast.internal.zzo r1 = r8.zzVC     // Catch:{ IOException -> 0x004d }
                    int r2 = r3     // Catch:{ IOException -> 0x004d }
                    r3 = 0
                    r4 = 0
                    r5 = 0
                    org.json.JSONObject r6 = r5     // Catch:{ IOException -> 0x004d }
                    r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.zzb(r1)     // Catch:{ all -> 0x004a }
                L_0x0048:
                    monitor-exit(r7)     // Catch:{ all -> 0x004a }
                    goto L_0x0020
                L_0x004a:
                    r0 = move-exception
                    monitor-exit(r7)     // Catch:{ all -> 0x004a }
                    throw r0
                L_0x004d:
                    r0 = move-exception
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0067 }
                    r1 = 2100(0x834, float:2.943E-42)
                    r0.<init>(r1)     // Catch:{ all -> 0x0067 }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzb(r0)     // Catch:{ all -> 0x0067 }
                    r8.zza(r0)     // Catch:{ all -> 0x0067 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.zzb(r1)     // Catch:{ all -> 0x004a }
                    goto L_0x0048
                L_0x0067:
                    r0 = move-exception
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r1 = r1.zzUW     // Catch:{ all -> 0x004a }
                    r2 = 0
                    r1.zzb(r2)     // Catch:{ all -> 0x004a }
                    throw r0     // Catch:{ all -> 0x004a }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.RemoteMediaPlayer.C036714.zza(com.google.android.gms.cast.internal.zze):void");
            }
        });
    }

    public PendingResult<MediaChannelResult> queueLoad(GoogleApiClient apiClient, MediaQueueItem[] items, int startIndex, int repeatMode, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = items;
        final int i = startIndex;
        final int i2 = repeatMode;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, mediaQueueItemArr, i, i2, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueMoveItemToNewIndex(GoogleApiClient apiClient, int itemId, int newIndex, JSONObject customData) {
        final int i = itemId;
        final int i2 = newIndex;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.cast.internal.zze r9) {
                /*
                    r8 = this;
                    r0 = 0
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this
                    java.lang.Object r2 = r1.zzpc
                    monitor-enter(r2)
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    int r3 = r3     // Catch:{ all -> 0x004a }
                    int r1 = r1.zzaP(r3)     // Catch:{ all -> 0x004a }
                    r3 = -1
                    if (r1 != r3) goto L_0x0022
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.<init>(r1)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzb(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                L_0x0021:
                    return
                L_0x0022:
                    int r3 = r4     // Catch:{ all -> 0x004a }
                    if (r3 >= 0) goto L_0x004d
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 2001(0x7d1, float:2.804E-42)
                    java.util.Locale r3 = java.util.Locale.ROOT     // Catch:{ all -> 0x004a }
                    java.lang.String r4 = "Invalid request: Invalid newIndex %d."
                    r5 = 1
                    java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x004a }
                    r6 = 0
                    int r7 = r4     // Catch:{ all -> 0x004a }
                    java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x004a }
                    r5[r6] = r7     // Catch:{ all -> 0x004a }
                    java.lang.String r3 = java.lang.String.format(r3, r4, r5)     // Catch:{ all -> 0x004a }
                    r0.<init>(r1, r3)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzb(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    goto L_0x0021
                L_0x004a:
                    r0 = move-exception
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    throw r0
                L_0x004d:
                    int r3 = r4     // Catch:{ all -> 0x004a }
                    if (r1 != r3) goto L_0x0060
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.<init>(r1)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzb(r0)     // Catch:{ all -> 0x004a }
                    r8.zza(r0)     // Catch:{ all -> 0x004a }
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    goto L_0x0021
                L_0x0060:
                    int r3 = r4     // Catch:{ all -> 0x004a }
                    if (r3 <= r1) goto L_0x00a5
                    int r1 = r4     // Catch:{ all -> 0x004a }
                    int r1 = r1 + 1
                L_0x0068:
                    com.google.android.gms.cast.RemoteMediaPlayer r3 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.MediaStatus r3 = r3.getMediaStatus()     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.MediaQueueItem r1 = r3.getQueueItem(r1)     // Catch:{ all -> 0x004a }
                    if (r1 == 0) goto L_0x0078
                    int r0 = r1.getItemId()     // Catch:{ all -> 0x004a }
                L_0x0078:
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r1 = r1.zzUW     // Catch:{ all -> 0x004a }
                    com.google.android.gms.common.api.GoogleApiClient r3 = r5     // Catch:{ all -> 0x004a }
                    r1.zzb(r3)     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ IOException -> 0x00a8 }
                    com.google.android.gms.cast.internal.zzm r1 = r1.zzUV     // Catch:{ IOException -> 0x00a8 }
                    com.google.android.gms.cast.internal.zzo r3 = r8.zzVC     // Catch:{ IOException -> 0x00a8 }
                    r4 = 1
                    int[] r4 = new int[r4]     // Catch:{ IOException -> 0x00a8 }
                    r5 = 0
                    int r6 = r3     // Catch:{ IOException -> 0x00a8 }
                    r4[r5] = r6     // Catch:{ IOException -> 0x00a8 }
                    org.json.JSONObject r5 = r6     // Catch:{ IOException -> 0x00a8 }
                    r1.zza(r3, r4, r0, r5)     // Catch:{ IOException -> 0x00a8 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.zzb(r1)     // Catch:{ all -> 0x004a }
                L_0x00a2:
                    monitor-exit(r2)     // Catch:{ all -> 0x004a }
                    goto L_0x0021
                L_0x00a5:
                    int r1 = r4     // Catch:{ all -> 0x004a }
                    goto L_0x0068
                L_0x00a8:
                    r0 = move-exception
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x00c2 }
                    r1 = 2100(0x834, float:2.943E-42)
                    r0.<init>(r1)     // Catch:{ all -> 0x00c2 }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r8.zzb(r0)     // Catch:{ all -> 0x00c2 }
                    r8.zza(r0)     // Catch:{ all -> 0x00c2 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004a }
                    r1 = 0
                    r0.zzb(r1)     // Catch:{ all -> 0x004a }
                    goto L_0x00a2
                L_0x00c2:
                    r0 = move-exception
                    com.google.android.gms.cast.RemoteMediaPlayer r1 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004a }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r1 = r1.zzUW     // Catch:{ all -> 0x004a }
                    r3 = 0
                    r1.zzb(r3)     // Catch:{ all -> 0x004a }
                    throw r0     // Catch:{ all -> 0x004a }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.RemoteMediaPlayer.C036815.zza(com.google.android.gms.cast.internal.zze):void");
            }
        });
    }

    public PendingResult<MediaChannelResult> queueNext(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, 0, (MediaQueueItem[]) null, 1, (Integer) null, customData);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queuePrev(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, 0, (MediaQueueItem[]) null, -1, (Integer) null, customData);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItem(GoogleApiClient apiClient, int itemId, JSONObject customData) {
        final int i = itemId;
        final GoogleApiClient googleApiClient = apiClient;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* JADX INFO: finally extract failed */
            /* access modifiers changed from: protected */
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void zza(com.google.android.gms.cast.internal.zze r7) {
                /*
                    r6 = this;
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this
                    java.lang.Object r1 = r0.zzpc
                    monitor-enter(r1)
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    int r2 = r3     // Catch:{ all -> 0x004d }
                    int r0 = r0.zzaP(r2)     // Catch:{ all -> 0x004d }
                    r2 = -1
                    if (r0 != r2) goto L_0x0021
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x004d }
                    r2 = 0
                    r0.<init>(r2)     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r6.zzb(r0)     // Catch:{ all -> 0x004d }
                    r6.zza(r0)     // Catch:{ all -> 0x004d }
                    monitor-exit(r1)     // Catch:{ all -> 0x004d }
                L_0x0020:
                    return
                L_0x0021:
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004d }
                    com.google.android.gms.common.api.GoogleApiClient r2 = r4     // Catch:{ all -> 0x004d }
                    r0.zzb(r2)     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ IOException -> 0x0050 }
                    com.google.android.gms.cast.internal.zzm r0 = r0.zzUV     // Catch:{ IOException -> 0x0050 }
                    com.google.android.gms.cast.internal.zzo r2 = r6.zzVC     // Catch:{ IOException -> 0x0050 }
                    r3 = 1
                    int[] r3 = new int[r3]     // Catch:{ IOException -> 0x0050 }
                    r4 = 0
                    int r5 = r3     // Catch:{ IOException -> 0x0050 }
                    r3[r4] = r5     // Catch:{ IOException -> 0x0050 }
                    org.json.JSONObject r4 = r5     // Catch:{ IOException -> 0x0050 }
                    r0.zza(r2, r3, r4)     // Catch:{ IOException -> 0x0050 }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004d }
                    r2 = 0
                    r0.zzb(r2)     // Catch:{ all -> 0x004d }
                L_0x004b:
                    monitor-exit(r1)     // Catch:{ all -> 0x004d }
                    goto L_0x0020
                L_0x004d:
                    r0 = move-exception
                    monitor-exit(r1)     // Catch:{ all -> 0x004d }
                    throw r0
                L_0x0050:
                    r0 = move-exception
                    com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x006a }
                    r2 = 2100(0x834, float:2.943E-42)
                    r0.<init>(r2)     // Catch:{ all -> 0x006a }
                    com.google.android.gms.cast.RemoteMediaPlayer$MediaChannelResult r0 = r6.zzb(r0)     // Catch:{ all -> 0x006a }
                    r6.zza(r0)     // Catch:{ all -> 0x006a }
                    com.google.android.gms.cast.RemoteMediaPlayer r0 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r0 = r0.zzUW     // Catch:{ all -> 0x004d }
                    r2 = 0
                    r0.zzb(r2)     // Catch:{ all -> 0x004d }
                    goto L_0x004b
                L_0x006a:
                    r0 = move-exception
                    com.google.android.gms.cast.RemoteMediaPlayer r2 = com.google.android.gms.cast.RemoteMediaPlayer.this     // Catch:{ all -> 0x004d }
                    com.google.android.gms.cast.RemoteMediaPlayer$zza r2 = r2.zzUW     // Catch:{ all -> 0x004d }
                    r3 = 0
                    r2.zzb(r3)     // Catch:{ all -> 0x004d }
                    throw r0     // Catch:{ all -> 0x004d }
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.RemoteMediaPlayer.C036613.zza(com.google.android.gms.cast.internal.zze):void");
            }
        });
    }

    public PendingResult<MediaChannelResult> queueRemoveItems(GoogleApiClient apiClient, int[] itemIdsToRemove, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToRemove;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, iArr, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueReorderItems(GoogleApiClient apiClient, int[] itemIdsToReorder, int insertBeforeItemId, JSONObject customData) throws IllegalArgumentException {
        final GoogleApiClient googleApiClient = apiClient;
        final int[] iArr = itemIdsToReorder;
        final int i = insertBeforeItemId;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, iArr, i, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueSetRepeatMode(GoogleApiClient apiClient, int repeatMode, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final int i = repeatMode;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, 0, (MediaQueueItem[]) null, 0, Integer.valueOf(i), jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> queueUpdateItems(GoogleApiClient apiClient, MediaQueueItem[] itemsToUpdate, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final MediaQueueItem[] mediaQueueItemArr = itemsToUpdate;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, 0, mediaQueueItemArr, 0, (Integer) null, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient apiClient) {
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position) {
        return seek(apiClient, position, 0, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState) {
        return seek(apiClient, position, resumeState, null);
    }

    public PendingResult<MediaChannelResult> seek(GoogleApiClient apiClient, long position, int resumeState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final long j = position;
        final int i = resumeState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, j, i, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient apiClient, final long[] trackIds) {
        if (trackIds != null) {
            return apiClient.zzb(new zzb(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzpc) {
                        RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                        try {
                            RemoteMediaPlayer.this.zzUV.zza(this.zzVC, trackIds);
                            RemoteMediaPlayer.this.zzUW.zzb(null);
                        } catch (IOException e) {
                            zza((Result) zzb(new Status(2100)));
                            RemoteMediaPlayer.this.zzUW.zzb(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzUW.zzb(null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackIds cannot be null");
    }

    public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener listener) {
        this.zzUZ = listener;
    }

    public void setOnPreloadStatusUpdatedListener(OnPreloadStatusUpdatedListener listener) {
        this.zzUX = listener;
    }

    public void setOnQueueStatusUpdatedListener(OnQueueStatusUpdatedListener listener) {
        this.zzUY = listener;
    }

    public void setOnStatusUpdatedListener(OnStatusUpdatedListener listener) {
        this.zzVa = listener;
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState) {
        return setStreamMute(apiClient, muteState, null);
    }

    public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient apiClient, boolean muteState, JSONObject customData) {
        final GoogleApiClient googleApiClient = apiClient;
        final boolean z = muteState;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, z, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException | IllegalStateException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume) throws IllegalArgumentException {
        return setStreamVolume(apiClient, volume, null);
    }

    public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient apiClient, double volume, JSONObject customData) throws IllegalArgumentException {
        if (Double.isInfinite(volume) || Double.isNaN(volume)) {
            throw new IllegalArgumentException("Volume cannot be " + volume);
        }
        final GoogleApiClient googleApiClient = apiClient;
        final double d = volume;
        final JSONObject jSONObject = customData;
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(googleApiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zza(this.zzVC, d, jSONObject);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }

    public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient apiClient, final TextTrackStyle trackStyle) {
        if (trackStyle != null) {
            return apiClient.zzb(new zzb(apiClient) {
                /* access modifiers changed from: protected */
                public void zza(zze zze) {
                    synchronized (RemoteMediaPlayer.this.zzpc) {
                        RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                        try {
                            RemoteMediaPlayer.this.zzUV.zza(this.zzVC, trackStyle);
                            RemoteMediaPlayer.this.zzUW.zzb(null);
                        } catch (IOException e) {
                            zza((Result) zzb(new Status(2100)));
                            RemoteMediaPlayer.this.zzUW.zzb(null);
                        } catch (Throwable th) {
                            RemoteMediaPlayer.this.zzUW.zzb(null);
                            throw th;
                        }
                    }
                }
            });
        }
        throw new IllegalArgumentException("trackStyle cannot be null");
    }

    public PendingResult<MediaChannelResult> stop(GoogleApiClient apiClient) {
        return stop(apiClient, null);
    }

    public PendingResult<MediaChannelResult> stop(final GoogleApiClient apiClient, final JSONObject customData) {
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                synchronized (RemoteMediaPlayer.this.zzpc) {
                    RemoteMediaPlayer.this.zzUW.zzb(apiClient);
                    try {
                        RemoteMediaPlayer.this.zzUV.zzb(this.zzVC, customData);
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (IOException e) {
                        zza((Result) zzb(new Status(2100)));
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                    } catch (Throwable th) {
                        RemoteMediaPlayer.this.zzUW.zzb(null);
                        throw th;
                    }
                }
            }
        });
    }
}
