package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.GamesMetadata;
import com.google.android.gms.games.GamesMetadata.LoadGameInstancesResult;
import com.google.android.gms.games.GamesMetadata.LoadGameSearchSuggestionsResult;
import com.google.android.gms.games.GamesMetadata.LoadGamesResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class GamesMetadataImpl implements GamesMetadata {

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$2 */
    class C07032 extends LoadGameInstancesImpl {
        final /* synthetic */ String zzauv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj(this, this.zzauv);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.GamesMetadataImpl$3 */
    class C07043 extends LoadGameSearchSuggestionsImpl {
        final /* synthetic */ String zzauM;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this, this.zzauM);
        }
    }

    private static abstract class LoadGameInstancesImpl extends BaseGamesApiMethodImpl<LoadGameInstancesResult> {
        /* renamed from: zzad */
        public LoadGameInstancesResult zzb(final Status status) {
            return new LoadGameInstancesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGameSearchSuggestionsImpl extends BaseGamesApiMethodImpl<LoadGameSearchSuggestionsResult> {
        /* renamed from: zzae */
        public LoadGameSearchSuggestionsResult zzb(final Status status) {
            return new LoadGameSearchSuggestionsResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadGamesImpl extends BaseGamesApiMethodImpl<LoadGamesResult> {
        private LoadGamesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaf */
        public LoadGamesResult zzb(final Status status) {
            return new LoadGamesResult() {
                public GameBuffer getGames() {
                    return new GameBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Game getCurrentGame(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztK();
    }

    public PendingResult<LoadGamesResult> loadGame(GoogleApiClient apiClient) {
        return apiClient.zza(new LoadGamesImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf(this);
            }
        });
    }
}
