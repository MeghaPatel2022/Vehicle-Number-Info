package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class PlayersImpl implements Players {

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$10 */
    class C073910 extends LoadPlayersImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadPlayersResult>) this, "nearby", this.zzauv, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$11 */
    class C074011 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadPlayersResult>) this, "played_with", this.zzauv, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$12 */
    class C074112 extends LoadPlayersImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadPlayersResult>) this, "played_with", this.zzauv, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$13 */
    class C074213 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb<LoadPlayersResult>) this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$14 */
    class C074314 extends LoadPlayersImpl {
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb<LoadPlayersResult>) this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$15 */
    class C074415 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb<LoadPlayersResult>) this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$16 */
    class C074516 extends LoadPlayersImpl {
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb<LoadPlayersResult>) this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$17 */
    class C074617 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$18 */
    class C074718 extends LoadPlayersImpl {
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$19 */
    class C074819 extends LoadPlayersImpl {
        final /* synthetic */ String zzauM;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzauM, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$20 */
    class C075020 extends LoadPlayersImpl {
        final /* synthetic */ String zzauM;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzauM, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$21 */
    class C075121 extends LoadPlayersImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzavh;
        final /* synthetic */ int zzavq;
        final /* synthetic */ String zzavr;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb<LoadPlayersResult>) this, this.zzavr, this.zzavh, this.zzavq, false, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$22 */
    class C075222 extends LoadPlayersImpl {
        final /* synthetic */ String zzavh;
        final /* synthetic */ int zzavq;
        final /* synthetic */ String zzavr;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb<LoadPlayersResult>) this, this.zzavr, this.zzavh, this.zzavq, true, false);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$23 */
    class C075323 extends LoadXpForGameCategoriesResultImpl {
        final /* synthetic */ String zzavs;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this, this.zzavs);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$24 */
    class C075424 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzavs;
        final /* synthetic */ int zzavt;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb<LoadXpStreamResult>) this, this.zzavs, this.zzavt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$25 */
    class C075525 extends LoadXpStreamResultImpl {
        final /* synthetic */ String zzavs;
        final /* synthetic */ int zzavt;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb<LoadXpStreamResult>) this, this.zzavs, this.zzavt);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$26 */
    class C075626 extends LoadProfileSettingsResultImpl {
        final /* synthetic */ boolean zzaut;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb<LoadProfileSettingsResult>) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$27 */
    class C075727 extends UpdateProfileSettingsResultImpl {
        final /* synthetic */ boolean zzavu;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb<Status>) this, this.zzavu);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$3 */
    class C07583 extends LoadPlayersImpl {
        final /* synthetic */ String[] zzavv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadPlayersResult>) this, this.zzavv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.PlayersImpl$9 */
    class C07649 extends LoadPlayersImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ int zzavq;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadPlayersResult>) this, "nearby", this.zzauv, this.zzavq, false, false);
        }
    }

    private static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        private LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzap */
        public LoadPlayersResult zzb(final Status status) {
            return new LoadPlayersResult() {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        /* access modifiers changed from: protected */
        /* renamed from: zzaq */
        public LoadProfileSettingsResult zzb(final Status status) {
            return new LoadProfileSettingsResult() {
                public Status getStatus() {
                    return status;
                }

                public boolean isProfileVisible() {
                    return true;
                }

                public boolean isVisibilityExplicitlySet() {
                    return false;
                }
            };
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        /* renamed from: zzar */
        public LoadXpForGameCategoriesResult zzb(final Status status) {
            return new LoadXpForGameCategoriesResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        /* renamed from: zzas */
        public LoadXpStreamResult zzb(final Status status) {
            return new LoadXpStreamResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient apiClient, Player player) {
        return Games.zzd(apiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztJ();
    }

    public String getCurrentPlayerId(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztI();
    }

    public Intent getPlayerSearchIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztT();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, pageSize, false, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, "played_with", pageSize, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, playerId, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient apiClient, final String playerId, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, playerId, forceReload);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient apiClient, final int pageSize, final boolean forceReload) {
        return apiClient.zza(new LoadPlayersImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayersResult>) this, "played_with", pageSize, false, forceReload);
            }
        });
    }
}
