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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AchievementsImpl implements Achievements {

    /* renamed from: com.google.android.gms.games.internal.api.AchievementsImpl$10 */
    class C068110 extends LoadImpl {
        final /* synthetic */ String zzWg;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb<LoadAchievementsResult>) this, this.zzWg, this.zzauv, this.zzaut);
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzW */
        public LoadAchievementsResult zzb(final Status status) {
            return new LoadAchievementsResult() {
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        /* access modifiers changed from: private */
        public final String zzwj;

        public UpdateImpl(String id, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzwj = id;
        }

        /* renamed from: zzX */
        public UpdateAchievementResult zzb(final Status status) {
            return new UpdateAchievementResult() {
                public String getAchievementId() {
                    return UpdateImpl.this.zzwj;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztM();
    }

    public void increment(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.zzb(new UpdateImpl(id, apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.zzb(new UpdateImpl(id, apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<UpdateAchievementResult>) this, str, i);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb<LoadAchievementsResult>) this, forceReload);
            }
        });
    }

    public void reveal(GoogleApiClient apiClient, final String id) {
        apiClient.zzb(new UpdateImpl(apiClient, id) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.zzb(new UpdateImpl(apiClient, id) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<UpdateAchievementResult>) this, id);
            }
        });
    }

    public void setSteps(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        apiClient.zzb(new UpdateImpl(id, apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(null, str, i);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient apiClient, String id, int numSteps) {
        final String str = id;
        final int i = numSteps;
        return apiClient.zzb(new UpdateImpl(id, apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<UpdateAchievementResult>) this, str, i);
            }
        });
    }

    public void unlock(GoogleApiClient apiClient, final String id) {
        apiClient.zzb(new UpdateImpl(apiClient, id) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(null, id);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient apiClient, final String id) {
        return apiClient.zzb(new UpdateImpl(apiClient, id) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<UpdateAchievementResult>) this, id);
            }
        });
    }
}
