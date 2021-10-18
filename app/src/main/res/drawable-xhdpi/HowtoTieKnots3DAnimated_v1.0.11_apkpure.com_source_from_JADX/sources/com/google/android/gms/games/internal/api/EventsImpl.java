package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzac */
        public LoadEventsResult zzb(final Status status) {
            return new LoadEventsResult() {
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzb(final Status status) {
            return new Result() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void increment(GoogleApiClient apiClient, final String eventId, final int incrementAmount) {
        GamesClientImpl zzc = Games.zzc(apiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzq(eventId, incrementAmount);
            } else {
                apiClient.zzb(new UpdateImpl(apiClient) {
                    public void zza(GamesClientImpl gamesClientImpl) {
                        gamesClientImpl.zzq(eventId, incrementAmount);
                    }
                });
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb<LoadEventsResult>) this, forceReload);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient apiClient, final boolean forceReload, final String... eventIds) {
        return apiClient.zza(new LoadImpl(apiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadEventsResult>) this, forceReload, eventIds);
            }
        });
    }
}
