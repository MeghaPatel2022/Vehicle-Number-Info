package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$4 */
    class C07814 extends SendRequestImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String[] zzavN;
        final /* synthetic */ int zzavO;
        final /* synthetic */ byte[] zzavP;
        final /* synthetic */ int zzavQ;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<SendRequestResult>) this, this.zzauv, this.zzavN, this.zzavO, this.zzavP, this.zzavQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$5 */
    class C07825 extends SendRequestImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String[] zzavN;
        final /* synthetic */ int zzavO;
        final /* synthetic */ byte[] zzavP;
        final /* synthetic */ int zzavQ;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<SendRequestResult>) this, this.zzauv, this.zzavN, this.zzavO, this.zzavP, this.zzavQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$6 */
    class C07836 extends UpdateRequestsImpl {
        final /* synthetic */ String zzauv;
        final /* synthetic */ String zzavF;
        final /* synthetic */ String[] zzavJ;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<UpdateRequestsResult>) this, this.zzauv, this.zzavF, this.zzavJ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$7 */
    class C07847 extends LoadRequestsImpl {
        final /* synthetic */ int zzauQ;
        final /* synthetic */ String zzauv;
        final /* synthetic */ String zzavF;
        final /* synthetic */ int zzavL;
        final /* synthetic */ int zzavM;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb<LoadRequestsResult>) this, this.zzauv, this.zzavF, this.zzavL, this.zzavM, this.zzauQ);
        }
    }

    /* renamed from: com.google.android.gms.games.internal.api.RequestsImpl$8 */
    class C07858 extends LoadRequestSummariesImpl {
        final /* synthetic */ String zzavF;
        final /* synthetic */ int zzavM;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(this, this.zzavF, this.zzavM);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        /* renamed from: zzaw */
        public LoadRequestSummariesResult zzb(final Status status) {
            return new LoadRequestSummariesResult() {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzax */
        public LoadRequestsResult zzb(final Status status) {
            return new LoadRequestsResult() {
                public GameRequestBuffer getRequests(int type) {
                    return new GameRequestBuffer(DataHolder.zzbp(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        /* renamed from: zzay */
        public SendRequestResult zzb(final Status status) {
            return new SendRequestResult() {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaz */
        public UpdateRequestsResult zzb(final Status status) {
            return new UpdateRequestsResult() {
                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String requestId) {
                    throw new IllegalArgumentException("Unknown request ID " + requestId);
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return acceptRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb<UpdateRequestsResult>) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient apiClient, String requestId) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestId);
        return dismissRequests(apiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient apiClient, List<String> requestIds) {
        final String[] strArr = requestIds == null ? null : (String[]) requestIds.toArray(new String[requestIds.size()]);
        return apiClient.zzb(new UpdateRequestsImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb<UpdateRequestsResult>) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList<>();
        }
        ArrayList arrayList = (ArrayList) extras.get(Requests.EXTRA_REQUESTS);
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent response) {
        return response == null ? new ArrayList<>() : getGameRequestsFromBundle(response.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztY();
    }

    public int getMaxLifetimeDays(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzua();
    }

    public int getMaxPayloadSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zztZ();
    }

    public Intent getSendIntent(GoogleApiClient apiClient, int type, byte[] payload, int requestLifetimeDays, Bitmap icon, String description) {
        return Games.zzd(apiClient).zza(type, payload, requestLifetimeDays, icon, description);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient apiClient, int requestDirection, int types, int sortOrder) {
        final int i = requestDirection;
        final int i2 = types;
        final int i3 = sortOrder;
        return apiClient.zza(new LoadRequestsImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<LoadRequestsResult>) this, i, i2, i3);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient apiClient, OnRequestReceivedListener listener) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zzd(apiClient.zzp(listener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient apiClient) {
        GamesClientImpl zzb = Games.zzb(apiClient, false);
        if (zzb != null) {
            zzb.zztS();
        }
    }
}
