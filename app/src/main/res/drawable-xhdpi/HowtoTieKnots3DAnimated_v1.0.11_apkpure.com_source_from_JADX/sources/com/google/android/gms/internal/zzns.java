package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public class zzns implements SessionsApi {

    private static class zza extends com.google.android.gms.internal.zznf.zza {
        private final com.google.android.gms.common.api.zzc.zzb<SessionReadResult> zzQz;

        private zza(com.google.android.gms.common.api.zzc.zzb<SessionReadResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(SessionReadResult sessionReadResult) throws RemoteException {
            this.zzQz.zzn(sessionReadResult);
        }
    }

    private static class zzb extends com.google.android.gms.internal.zzng.zza {
        private final com.google.android.gms.common.api.zzc.zzb<SessionStopResult> zzQz;

        private zzb(com.google.android.gms.common.api.zzc.zzb<SessionStopResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(SessionStopResult sessionStopResult) {
            this.zzQz.zzn(sessionStopResult);
        }
    }

    private PendingResult<SessionStopResult> zza(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new zza<SessionStopResult>(googleApiClient) {
            /* access modifiers changed from: protected */
            /* renamed from: zzN */
            public SessionStopResult zzb(Status status) {
                return SessionStopResult.zzV(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmq zzmq) throws RemoteException {
                ((zznb) zzmq.zzoA()).zza(new SessionStopRequest(str, str2, new zzb(this), zzmq.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> insertSession(GoogleApiClient client, final SessionInsertRequest request) {
        return client.zza(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmq zzmq) throws RemoteException {
                ((zznb) zzmq.zzoA()).zza(new SessionInsertRequest(request, new zznt(this), zzmq.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionReadResult> readSession(GoogleApiClient client, final SessionReadRequest request) {
        return client.zza(new zza<SessionReadResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzO */
            public SessionReadResult zzb(Status status) {
                return SessionReadResult.zzU(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmq zzmq) throws RemoteException {
                ((zznb) zzmq.zzoA()).zza(new SessionReadRequest(request, new zza(this), zzmq.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> registerForSessions(GoogleApiClient client, PendingIntent intent) {
        return zza(client, intent, 0);
    }

    public PendingResult<Status> startSession(GoogleApiClient client, final Session session) {
        zzx.zzb(session, (Object) "Session cannot be null");
        zzx.zzb(session.getEndTime(TimeUnit.MILLISECONDS) == 0, (Object) "Cannot start a session which has already ended");
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmq zzmq) throws RemoteException {
                ((zznb) zzmq.zzoA()).zza(new SessionStartRequest(session, new zznt(this), zzmq.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<SessionStopResult> stopSession(GoogleApiClient client, String identifier) {
        return zza(client, (String) null, identifier);
    }

    public PendingResult<Status> unregisterForSessions(GoogleApiClient client, final PendingIntent intent) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmq zzmq) throws RemoteException {
                ((zznb) zzmq.zzoA()).zza(new SessionUnregistrationRequest(intent, new zznt(this), zzmq.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final PendingIntent pendingIntent, final int i) {
        return googleApiClient.zzb(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzmq zzmq) throws RemoteException {
                ((zznb) zzmq.zzoA()).zza(new SessionRegistrationRequest(pendingIntent, new zznt(this), zzmq.getContext().getPackageName(), i));
            }
        });
    }
}
