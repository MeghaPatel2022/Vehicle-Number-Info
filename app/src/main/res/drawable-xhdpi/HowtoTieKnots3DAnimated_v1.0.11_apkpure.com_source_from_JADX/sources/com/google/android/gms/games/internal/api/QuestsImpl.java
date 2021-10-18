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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;

public final class QuestsImpl implements Quests {

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$5 */
    class C07735 extends LoadsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;
        final /* synthetic */ int[] zzavD;
        final /* synthetic */ String zzavF;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadQuestsResult>) this, this.zzauv, this.zzavF, this.zzavD, this.zzauQ, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.QuestsImpl$6 */
    class C07746 extends LoadsImpl {
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;
        final /* synthetic */ String[] zzavE;
        final /* synthetic */ String zzavF;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadQuestsResult>) this, this.zzauv, this.zzavF, this.zzaut, this.zzavE);
        }
    }

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzat */
        public AcceptQuestResult zzb(final Status status) {
            return new AcceptQuestResult() {
                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzau */
        public ClaimMilestoneResult zzb(final Status status) {
            return new ClaimMilestoneResult() {
                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzav */
        public LoadQuestsResult zzb(final Status status) {
            return new LoadQuestsResult() {
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzbp(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient apiClient, final String questId) {
        return apiClient.zzb(new AcceptImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzh((zzb<AcceptQuestResult>) this, questId);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient apiClient, final String questId, final String milestoneId) {
        return apiClient.zzb(new ClaimImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<ClaimMilestoneResult>) this, questId, milestoneId);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient apiClient, String questId) {
        return Games.zzd(apiClient).zzcY(questId);
    }

    public Intent getQuestsIntent(GoogleApiClient apiClient, int[] questSelectors) {
        return Games.zzd(apiClient).zzb(questSelectors);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient apiClient, int[] questSelectors, int sortOrder, boolean forceReload) {
        final int[] iArr = questSelectors;
        final int i = sortOrder;
        final boolean z = forceReload;
        return apiClient.zza(new LoadsImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadQuestsResult>) this, iArr, i, z);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... questIds) {
        return apiClient.zza(new LoadsImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<LoadQuestsResult>) this, forceReload, questIds);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient apiClient, QuestUpdateListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzc(apiClient.zzp(listener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient apiClient, String questId) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzcZ(questId);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zztR();
        }
    }
}
