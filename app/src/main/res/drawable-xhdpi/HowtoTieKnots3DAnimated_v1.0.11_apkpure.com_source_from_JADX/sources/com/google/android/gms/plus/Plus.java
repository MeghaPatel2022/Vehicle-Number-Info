package com.google.android.gms.plus;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzly;
import com.google.android.gms.internal.zzpn;
import com.google.android.gms.internal.zzpo;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpq;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.plus.internal.PlusCommonExtras;
import com.google.android.gms.plus.internal.PlusSession;
import com.google.android.gms.plus.internal.zze;
import java.util.HashSet;
import java.util.Set;

public final class Plus {
    public static final Api<PlusOptions> API = new Api<>("Plus.API", zzQg, zzQf);
    public static final Account AccountApi = new zzpn();
    public static final Moments MomentsApi = new zzpq();
    public static final People PeopleApi = new zzpr();
    public static final Scope SCOPE_PLUS_LOGIN = new Scope(Scopes.PLUS_LOGIN);
    public static final Scope SCOPE_PLUS_PROFILE = new Scope(Scopes.PLUS_ME);
    public static final zzc<zze> zzQf = new zzc<>();
    static final com.google.android.gms.common.api.Api.zza<zze, PlusOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zze, PlusOptions>() {
        public int getPriority() {
            return 2;
        }

        public zze zza(Context context, Looper looper, zzf zzf, PlusOptions plusOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (plusOptions == null) {
                plusOptions = new PlusOptions();
            }
            zze zze = new zze(context, looper, zzf, new PlusSession(zzf.zzog().name, zzly.zzc(zzf.zzoj()), (String[]) plusOptions.zzaLf.toArray(new String[0]), new String[0], context.getPackageName(), context.getPackageName(), null, new PlusCommonExtras()), connectionCallbacks, onConnectionFailedListener);
            return zze;
        }
    };
    public static final zzb zzaLc = new zzpp();
    public static final zza zzaLd = new zzpo();

    public static final class PlusOptions implements Optional {
        final String zzaLe;
        final Set<String> zzaLf;

        public static final class Builder {
            String zzaLe;
            final Set<String> zzaLf = new HashSet();

            public Builder addActivityTypes(String... activityTypes) {
                zzx.zzb(activityTypes, (Object) "activityTypes may not be null.");
                for (String add : activityTypes) {
                    this.zzaLf.add(add);
                }
                return this;
            }

            public PlusOptions build() {
                return new PlusOptions(this);
            }

            public Builder setServerClientId(String clientId) {
                this.zzaLe = clientId;
                return this;
            }
        }

        private PlusOptions() {
            this.zzaLe = null;
            this.zzaLf = new HashSet();
        }

        private PlusOptions(Builder builder) {
            this.zzaLe = builder.zzaLe;
            this.zzaLf = builder.zzaLf;
        }

        public static Builder builder() {
            return new Builder();
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zze> {
        public zza(GoogleApiClient googleApiClient) {
            super(Plus.zzQf, googleApiClient);
        }
    }

    private Plus() {
    }

    public static zze zzf(GoogleApiClient googleApiClient, boolean z) {
        zzx.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzx.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        zzx.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Plus.API Api. Pass this into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (z && !hasConnectedApi) {
            throw new IllegalStateException("GoogleApiClient has an optional Plus.API and is not connected to Plus. Use GoogleApiClient.hasConnectedApi(Plus.API) to guard this call.");
        } else if (hasConnectedApi) {
            return (zze) googleApiClient.zza(zzQf);
        } else {
            return null;
        }
    }
}
