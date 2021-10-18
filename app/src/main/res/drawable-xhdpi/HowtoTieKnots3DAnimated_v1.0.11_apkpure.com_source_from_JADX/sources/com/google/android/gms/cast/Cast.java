package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions.Builder;
import com.google.android.gms.cast.internal.zze;
import com.google.android.gms.cast.internal.zzh;
import com.google.android.gms.cast.internal.zzk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;

public final class Cast {
    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api<CastOptions> API = new Api<>("Cast.API", zzQg, zzk.zzQf);
    public static final CastApi CastApi = new zza();
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 65536;
    public static final int MAX_NAMESPACE_LENGTH = 128;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    private static final com.google.android.gms.common.api.Api.zza<zze, CastOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zze, CastOptions>() {
        public zze zza(Context context, Looper looper, zzf zzf, CastOptions castOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            zzx.zzb(castOptions, (Object) "Setting the API options is required.");
            return new zze(context, looper, zzf, castOptions.zzTg, (long) castOptions.zzTi, castOptions.zzTh, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    public interface CastApi {

        public static final class zza implements CastApi {
            public int getActiveInputState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzQf)).zzmz();
            }

            public ApplicationMetadata getApplicationMetadata(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzQf)).getApplicationMetadata();
            }

            public String getApplicationStatus(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzQf)).getApplicationStatus();
            }

            public int getStandbyState(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzQf)).zzmA();
            }

            public double getVolume(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzQf)).zzmy();
            }

            public boolean isMute(GoogleApiClient client) throws IllegalStateException {
                return ((zze) client.zza(zzk.zzQf)).isMute();
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client) {
                return client.zzb(new zza(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zzb(null, null, this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zzb(applicationId, null, this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient client, final String applicationId, final String sessionId) {
                return client.zzb(new zza(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zzb(applicationId, sessionId, this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId) {
                return client.zzb(new zza(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(applicationId, false, (zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, final String applicationId, final LaunchOptions options) {
                return client.zzb(new zza(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(applicationId, options, (zzb<ApplicationConnectionResult>) this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            @Deprecated
            public PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient client, String applicationId, boolean relaunchIfRunning) {
                return launchApplication(client, applicationId, new Builder().setRelaunchIfRunning(relaunchIfRunning).build());
            }

            public PendingResult<Status> leaveApplication(GoogleApiClient client) {
                return client.zzb(new zzh(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zzd((zzb<Status>) this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public void removeMessageReceivedCallbacks(GoogleApiClient client, String namespace) throws IOException, IllegalArgumentException {
                try {
                    ((zze) client.zza(zzk.zzQf)).zzbK(namespace);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void requestStatus(GoogleApiClient client) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzQf)).zzmx();
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> sendMessage(GoogleApiClient client, final String namespace, final String message) {
                return client.zzb(new zzh(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza(namespace, message, (zzb<Status>) this);
                        } catch (IllegalArgumentException | IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public void setMessageReceivedCallbacks(GoogleApiClient client, String namespace, MessageReceivedCallback callbacks) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzQf)).zza(namespace, callbacks);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setMute(GoogleApiClient client, boolean mute) throws IOException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzQf)).zzV(mute);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public void setVolume(GoogleApiClient client, double volume) throws IOException, IllegalArgumentException, IllegalStateException {
                try {
                    ((zze) client.zza(zzk.zzQf)).zze(volume);
                } catch (RemoteException e) {
                    throw new IOException("service error");
                }
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client) {
                return client.zzb(new zzh(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        try {
                            zze.zza("", (zzb<Status>) this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }

            public PendingResult<Status> stopApplication(GoogleApiClient client, final String sessionId) {
                return client.zzb(new zzh(client) {
                    /* access modifiers changed from: protected */
                    public void zza(zze zze) throws RemoteException {
                        if (TextUtils.isEmpty(sessionId)) {
                            zzd(2001, "IllegalArgument: sessionId cannot be null or empty");
                            return;
                        }
                        try {
                            zze.zza(sessionId, (zzb<Status>) this);
                        } catch (IllegalStateException e) {
                            zzaT(2001);
                        }
                    }
                });
            }
        }

        int getActiveInputState(GoogleApiClient googleApiClient) throws IllegalStateException;

        ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient) throws IllegalStateException;

        String getApplicationStatus(GoogleApiClient googleApiClient) throws IllegalStateException;

        int getStandbyState(GoogleApiClient googleApiClient) throws IllegalStateException;

        double getVolume(GoogleApiClient googleApiClient) throws IllegalStateException;

        boolean isMute(GoogleApiClient googleApiClient) throws IllegalStateException;

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> joinApplication(GoogleApiClient googleApiClient, String str, String str2);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str);

        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions);

        @Deprecated
        PendingResult<ApplicationConnectionResult> launchApplication(GoogleApiClient googleApiClient, String str, boolean z);

        PendingResult<Status> leaveApplication(GoogleApiClient googleApiClient);

        void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str) throws IOException, IllegalArgumentException;

        void requestStatus(GoogleApiClient googleApiClient) throws IOException, IllegalStateException;

        PendingResult<Status> sendMessage(GoogleApiClient googleApiClient, String str, String str2);

        void setMessageReceivedCallbacks(GoogleApiClient googleApiClient, String str, MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException;

        void setMute(GoogleApiClient googleApiClient, boolean z) throws IOException, IllegalStateException;

        void setVolume(GoogleApiClient googleApiClient, double d) throws IOException, IllegalArgumentException, IllegalStateException;

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient);

        PendingResult<Status> stopApplication(GoogleApiClient googleApiClient, String str);
    }

    public static final class CastOptions implements HasOptions {
        final CastDevice zzTg;
        final Listener zzTh;
        /* access modifiers changed from: private */
        public final int zzTi;

        public static final class Builder {
            CastDevice zzTj;
            Listener zzTk;
            /* access modifiers changed from: private */
            public int zzTl = 0;

            public Builder(CastDevice castDevice, Listener castListener) {
                zzx.zzb(castDevice, (Object) "CastDevice parameter cannot be null");
                zzx.zzb(castListener, (Object) "CastListener parameter cannot be null");
                this.zzTj = castDevice;
                this.zzTk = castListener;
            }

            public CastOptions build() {
                return new CastOptions(this);
            }

            public Builder setVerboseLoggingEnabled(boolean enabled) {
                if (enabled) {
                    this.zzTl |= 1;
                } else {
                    this.zzTl &= -2;
                }
                return this;
            }
        }

        private CastOptions(Builder builder) {
            this.zzTg = builder.zzTj;
            this.zzTh = builder.zzTk;
            this.zzTi = builder.zzTl;
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice, Listener castListener) {
            return new Builder(castDevice, castListener);
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int activeInputState) {
        }

        public void onApplicationDisconnected(int statusCode) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onStandbyStateChanged(int standbyState) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice castDevice, String str, String str2);
    }

    private static abstract class zza extends com.google.android.gms.cast.internal.zzb<ApplicationConnectionResult> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzq */
        public ApplicationConnectionResult zzb(final Status status) {
            return new ApplicationConnectionResult() {
                public ApplicationMetadata getApplicationMetadata() {
                    return null;
                }

                public String getApplicationStatus() {
                    return null;
                }

                public String getSessionId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public boolean getWasLaunched() {
                    return false;
                }
            };
        }
    }

    private Cast() {
    }
}
