package com.google.android.gms.appstate;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzjn;
import java.util.Arrays;
import java.util.List;

@Deprecated
public final class AppStateManager {
    public static final Api<NoOptions> API = new Api<>("AppStateManager.API", zzQg, zzQf);
    public static final Scope SCOPE_APP_STATE = new Scope(Scopes.APP_STATE);
    static final com.google.android.gms.common.api.Api.zzc<zzjn> zzQf = new com.google.android.gms.common.api.Api.zzc<>();
    private static final com.google.android.gms.common.api.Api.zza<zzjn, NoOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zzjn, NoOptions>() {
        /* renamed from: zza */
        public List<Scope> zzl(NoOptions noOptions) {
            return Arrays.asList(new Scope[]{AppStateManager.SCOPE_APP_STATE});
        }

        /* renamed from: zzc */
        public zzjn zza(Context context, Looper looper, zzf zzf, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzjn(context, looper, zzf, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public interface StateConflictResult extends Releasable, Result {
        byte[] getLocalData();

        String getResolvedVersion();

        byte[] getServerData();

        int getStateKey();
    }

    public interface StateDeletedResult extends Result {
        int getStateKey();
    }

    public interface StateListResult extends Result {
        AppStateBuffer getStateBuffer();
    }

    public interface StateLoadedResult extends Releasable, Result {
        byte[] getLocalData();

        int getStateKey();
    }

    public interface StateResult extends Releasable, Result {
        StateConflictResult getConflictResult();

        StateLoadedResult getLoadedResult();
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzjn> {
        public zza(GoogleApiClient googleApiClient) {
            super(AppStateManager.zzQf, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StateDeletedResult> {
        zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }
    }

    private static abstract class zzc extends zza<StateListResult> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzi */
        public StateListResult zzb(final Status status) {
            return new StateListResult() {
                public AppStateBuffer getStateBuffer() {
                    return new AppStateBuffer(null);
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class zzd extends zza<Status> {
        public zzd(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    private static abstract class zze extends zza<StateResult> {
        public zze(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzj */
        public StateResult zzb(Status status) {
            return AppStateManager.zzf(status);
        }
    }

    private AppStateManager() {
    }

    public static PendingResult<StateDeletedResult> delete(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.zzb(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zza(this, stateKey);
            }

            /* renamed from: zzh */
            public StateDeletedResult zzb(final Status status) {
                return new StateDeletedResult() {
                    public int getStateKey() {
                        return stateKey;
                    }

                    public Status getStatus() {
                        return status;
                    }
                };
            }
        });
    }

    public static int getMaxNumKeys(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzlo();
    }

    public static int getMaxStateSize(GoogleApiClient googleApiClient) {
        return zza(googleApiClient).zzln();
    }

    public static PendingResult<StateListResult> list(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zza((com.google.android.gms.common.api.zzc.zzb<StateListResult>) this);
            }
        });
    }

    public static PendingResult<StateResult> load(GoogleApiClient googleApiClient, final int stateKey) {
        return googleApiClient.zza(new zze(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zzb(this, stateKey);
            }
        });
    }

    public static PendingResult<StateResult> resolve(GoogleApiClient googleApiClient, final int stateKey, final String resolvedVersion, final byte[] resolvedData) {
        return googleApiClient.zzb(new zze(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zza(this, stateKey, resolvedVersion, resolvedData);
            }
        });
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzd(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zzb(this);
            }
        });
    }

    public static void update(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        googleApiClient.zzb(new zze(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zza(null, stateKey, data);
            }
        });
    }

    public static PendingResult<StateResult> updateImmediate(GoogleApiClient googleApiClient, final int stateKey, final byte[] data) {
        return googleApiClient.zzb(new zze(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjn zzjn) throws RemoteException {
                zzjn.zza(this, stateKey, data);
            }
        });
    }

    public static zzjn zza(GoogleApiClient googleApiClient) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the AppState API. Pass AppStateManager.API into GoogleApiClient.Builder#addApi() to use this feature.");
        return (zzjn) googleApiClient.zza(zzQf);
    }

    /* access modifiers changed from: private */
    public static StateResult zzf(final Status status) {
        return new StateResult() {
            public StateConflictResult getConflictResult() {
                return null;
            }

            public StateLoadedResult getLoadedResult() {
                return null;
            }

            public Status getStatus() {
                return status;
            }

            public void release() {
            }
        };
    }
}
