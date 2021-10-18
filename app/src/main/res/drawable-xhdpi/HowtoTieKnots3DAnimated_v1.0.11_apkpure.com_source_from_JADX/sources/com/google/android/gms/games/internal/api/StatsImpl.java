package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.stats.Stats.LoadPlayerStatsResult;

public final class StatsImpl implements Stats {

    /* renamed from: com.google.android.gms.games.internal.api.StatsImpl$1 */
    class C08001 extends LoadsImpl {
        final /* synthetic */ boolean zzaut;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb<LoadPlayerStatsResult>) this, this.zzaut);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadPlayerStatsResult> {
        /* renamed from: zzaE */
        public LoadPlayerStatsResult zzb(final Status status) {
            return new LoadPlayerStatsResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }
}
