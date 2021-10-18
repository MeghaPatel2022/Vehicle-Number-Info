package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl implements Acls {

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$2 */
    class C06932 extends LoadNotifyAclImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.AclsImpl$3 */
    class C06943 extends UpdateNotifyAclImpl {
        final /* synthetic */ String zzauA;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, this.zzauA);
        }
    }

    private static abstract class LoadNotifyAclImpl extends BaseGamesApiMethodImpl<LoadAclResult> {
        /* renamed from: zzaa */
        public LoadAclResult zzb(Status status) {
            return AclsImpl.zzY(status);
        }
    }

    private static abstract class UpdateNotifyAclImpl extends BaseGamesApiMethodImpl<Status> {
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    /* access modifiers changed from: private */
    public static LoadAclResult zzY(final Status status) {
        return new LoadAclResult() {
            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
