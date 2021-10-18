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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;

public final class LeaderboardsImpl implements Leaderboards {

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$10 */
    class C071310 extends LoadScoresImpl {
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;
        final /* synthetic */ int zzauY;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, this.zzauv, this.zzauV, this.zzauW, this.zzauX, this.zzauY, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$11 */
    class C071411 extends LoadScoresImpl {
        final /* synthetic */ String zzauV;
        final /* synthetic */ int zzauW;
        final /* synthetic */ int zzauX;
        final /* synthetic */ int zzauY;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, this.zzauv, this.zzauV, this.zzauW, this.zzauX, this.zzauY, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$8 */
    class C07218 extends LoadMetadataImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb<LeaderboardMetadataResult>) this, this.zzauv, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.LeaderboardsImpl$9 */
    class C07229 extends LoadMetadataImpl {
        final /* synthetic */ String zzauV;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LeaderboardMetadataResult>) this, this.zzauv, this.zzauV, this.zzaut);
        }
    }

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzah */
        public LeaderboardMetadataResult zzb(final Status status) {
            return new LeaderboardMetadataResult() {
                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzai */
        public LoadPlayerScoreResult zzb(final Status status) {
            return new LoadPlayerScoreResult() {
                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaj */
        public LoadScoresResult zzb(final Status status) {
            return new LoadScoresResult() {
                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzak */
        public SubmitScoreResult zzb(final Status status) {
            return new SubmitScoreResult() {
                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztL();
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId) {
        return getLeaderboardIntent(apiClient, leaderboardId, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient apiClient, String leaderboardId, int timeSpan) {
        return Games.zzd(apiClient).zzp(leaderboardId, timeSpan);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        return apiClient.zza(new LoadPlayerScoreImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadPlayerScoreResult>) this, (String) null, str, i, i2);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final String leaderboardId, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<LeaderboardMetadataResult>) this, leaderboardId, forceReload);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadMetadataImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<LeaderboardMetadataResult>) this, forceReload);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient apiClient, LeaderboardScoreBuffer buffer, int maxResults, int pageDirection) {
        final LeaderboardScoreBuffer leaderboardScoreBuffer = buffer;
        final int i = maxResults;
        final int i2 = pageDirection;
        return apiClient.zza(new LoadScoresImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadScoresResult>) this, leaderboardScoreBuffer, i, i2);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadPlayerCenteredScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.zza(new LoadScoresImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<LoadScoresResult>) this, str, i, i2, i3, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults) {
        return loadTopScores(apiClient, leaderboardId, span, leaderboardCollection, maxResults, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient apiClient, String leaderboardId, int span, int leaderboardCollection, int maxResults, boolean forceReload) {
        final String str = leaderboardId;
        final int i = span;
        final int i2 = leaderboardCollection;
        final int i3 = maxResults;
        final boolean z = forceReload;
        return apiClient.zza(new LoadScoresImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadScoresResult>) this, str, i, i2, i3, z);
            }
        });
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score) {
        submitScore(apiClient, leaderboardId, score, null);
    }

    public void submitScore(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            try {
                zzb.zza(null, leaderboardId, score, scoreTag);
            } catch (RemoteException e) {
                GamesLog.zzw("LeaderboardsImpl", "service died");
            }
        }
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score) {
        return submitScoreImmediate(apiClient, leaderboardId, score, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient apiClient, String leaderboardId, long score, String scoreTag) {
        final String str = leaderboardId;
        final long j = score;
        final String str2 = scoreTag;
        return apiClient.zzb(new SubmitScoreImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<SubmitScoreResult>) this, str, j, str2);
            }
        });
    }
}
