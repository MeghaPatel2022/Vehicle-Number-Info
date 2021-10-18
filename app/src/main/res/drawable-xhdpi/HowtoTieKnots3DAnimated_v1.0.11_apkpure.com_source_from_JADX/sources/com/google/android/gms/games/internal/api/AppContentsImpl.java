package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl implements AppContents {

    /* renamed from: com.google.android.gms.games.internal.api.AppContentsImpl$1 */
    class C06951 extends LoadsImpl {
        final /* synthetic */ int zzauB;
        final /* synthetic */ String zzauC;
        final /* synthetic */ String[] zzauD;
        final /* synthetic */ boolean zzaut;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadAppContentResult>) this, this.zzauB, this.zzauC, this.zzauD, this.zzaut);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadAppContentResult> {
        /* renamed from: zzab */
        public LoadAppContentResult zzb(final Status status) {
            return new LoadAppContentResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }
}
