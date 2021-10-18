package com.google.android.gms.games.internal.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class NotificationsImpl implements Notifications {

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$1 */
    class C07271 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzavh;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb<GameMuteStatusChangeResult>) this, this.zzavh, true);
        }

        /* renamed from: zzal */
        public GameMuteStatusChangeResult zzb(final Status status) {
            return new GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$2 */
    class C07292 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        final /* synthetic */ String zzavh;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb<GameMuteStatusChangeResult>) this, this.zzavh, false);
        }

        /* renamed from: zzal */
        public GameMuteStatusChangeResult zzb(final Status status) {
            return new GameMuteStatusChangeResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$3 */
    class C07313 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        final /* synthetic */ String zzavh;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this, this.zzavh);
        }

        /* renamed from: zzam */
        public GameMuteStatusLoadResult zzb(final Status status) {
            return new GameMuteStatusLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$4 */
    class C07334 extends ContactSettingLoadImpl {
        final /* synthetic */ boolean zzaut;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb<ContactSettingLoadResult>) this, this.zzaut);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$5 */
    class C07345 extends ContactSettingUpdateImpl {
        final /* synthetic */ boolean zzavl;
        final /* synthetic */ Bundle zzavm;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<Status>) this, this.zzavl, this.zzavm);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.NotificationsImpl$6 */
    class C07356 extends InboxCountImpl {
        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh(this);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        /* renamed from: zzan */
        public ContactSettingLoadResult zzb(final Status status) {
            return new ContactSettingLoadResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        /* renamed from: zzao */
        public InboxCountResult zzb(final Status status) {
            return new InboxCountResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public void clear(GoogleApiClient apiClient, int notificationTypes) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzfN(notificationTypes);
        }
    }

    public void clearAll(GoogleApiClient apiClient) {
        clear(apiClient, 31);
    }
}
