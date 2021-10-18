package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AclsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API = new Api<>("Games.API", zzQg, zzQf);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    static final zzc<GamesClientImpl> zzQf = new zzc<>();
    private static final zza<GamesClientImpl, GamesOptions> zzQg = new GamesClientBuilder() {
        /* renamed from: zza */
        public List<Scope> zzl(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }
    };
    private static final zza<GamesClientImpl, GamesOptions> zzaro = new GamesClientBuilder() {
        /* renamed from: zza */
        public List<Scope> zzl(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzarp);
        }
    };
    public static final Scope zzarp = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzarq = new Api<>("Games.API_1P", zzaro, zzQf);
    public static final AppContents zzarr = new AppContentsImpl();
    public static final Multiplayer zzars = new MultiplayerImpl();
    public static final Stats zzart = new StatsImpl();
    public static final Acls zzaru = new AclsImpl();

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzQf, googleApiClient);
        }
    }

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzf zzf, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, zzf, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static final class GamesOptions implements Optional {
        public final String zzarA;
        public final ArrayList<String> zzarB;
        public final boolean zzarv;
        public final boolean zzarw;
        public final int zzarx;
        public final boolean zzary;
        public final int zzarz;

        public static final class Builder {
            String zzarA;
            ArrayList<String> zzarB;
            boolean zzarv;
            boolean zzarw;
            int zzarx;
            boolean zzary;
            int zzarz;

            private Builder() {
                this.zzarv = false;
                this.zzarw = true;
                this.zzarx = 17;
                this.zzary = false;
                this.zzarz = 4368;
                this.zzarA = null;
                this.zzarB = new ArrayList<>();
            }

            public GamesOptions build() {
                return new GamesOptions(this);
            }

            public Builder setSdkVariant(int variant) {
                this.zzarz = variant;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup) {
                this.zzarw = showConnectingPopup;
                this.zzarx = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean showConnectingPopup, int gravity) {
                this.zzarw = showConnectingPopup;
                this.zzarx = gravity;
                return this;
            }
        }

        private GamesOptions() {
            this.zzarv = false;
            this.zzarw = true;
            this.zzarx = 17;
            this.zzary = false;
            this.zzarz = 4368;
            this.zzarA = null;
            this.zzarB = new ArrayList<>();
        }

        private GamesOptions(Builder builder) {
            this.zzarv = builder.zzarv;
            this.zzarw = builder.zzarw;
            this.zzarx = builder.zzarx;
            this.zzary = builder.zzary;
            this.zzarz = builder.zzarz;
            this.zzarA = builder.zzarA;
            this.zzarB = builder.zzarB;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzsQ() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.zzarv);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzarw);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzarx);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", this.zzary);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzarz);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", this.zzarA);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzarB);
            return bundle;
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient apiClient) {
        return zzd(apiClient).zztW();
    }

    public static String getCurrentAccountName(GoogleApiClient apiClient) {
        return zzd(apiClient).zztH();
    }

    public static int getSdkVariant(GoogleApiClient apiClient) {
        return zzd(apiClient).zztV();
    }

    public static Intent getSettingsIntent(GoogleApiClient apiClient) {
        return zzd(apiClient).zztU();
    }

    public static void setGravityForPopups(GoogleApiClient apiClient, int gravity) {
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzfM(gravity);
        }
    }

    public static void setViewForPopups(GoogleApiClient apiClient, View gamesContentView) {
        zzx.zzv(gamesContentView);
        GamesClientImpl zzb = zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzm(gamesContentView);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient apiClient) {
        return apiClient.zzb(new SignOutImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<Status>) this);
            }
        });
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        } else if (hasConnectedApi) {
            return (GamesClientImpl) googleApiClient.zza(zzQf);
        } else {
            return null;
        }
    }

    public static GamesClientImpl zzd(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
