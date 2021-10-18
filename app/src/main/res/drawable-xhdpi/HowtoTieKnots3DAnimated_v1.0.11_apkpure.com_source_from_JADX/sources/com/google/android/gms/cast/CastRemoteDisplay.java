package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.view.Display;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkl;
import com.google.android.gms.internal.zzkm;

public final class CastRemoteDisplay {
    public static final Api<CastRemoteDisplayOptions> API = new Api<>("CastRemoteDisplay.API", zzQg, zzQf);
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = new zzkl(zzQf);
    private static final zzc<zzkm> zzQf = new zzc<>();
    private static final zza<zzkm, CastRemoteDisplayOptions> zzQg = new zza<zzkm, CastRemoteDisplayOptions>() {
        public zzkm zza(Context context, Looper looper, zzf zzf, CastRemoteDisplayOptions castRemoteDisplayOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzkm(context, looper, zzf, castRemoteDisplayOptions.zzTg, castRemoteDisplayOptions.zzTw, connectionCallbacks, onConnectionFailedListener);
        }
    };

    public static final class CastRemoteDisplayOptions implements HasOptions {
        final CastDevice zzTg;
        final CastRemoteDisplaySessionCallbacks zzTw;

        public static final class Builder {
            CastDevice zzTj;
            CastRemoteDisplaySessionCallbacks zzTx;

            public Builder(CastDevice castDevice, CastRemoteDisplaySessionCallbacks callbacks) {
                zzx.zzb(castDevice, (Object) "CastDevice parameter cannot be null");
                this.zzTj = castDevice;
                this.zzTx = callbacks;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions(this);
            }
        }

        private CastRemoteDisplayOptions(Builder builder) {
            this.zzTg = builder.zzTj;
            this.zzTw = builder.zzTx;
        }
    }

    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status status);
    }

    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    private CastRemoteDisplay() {
    }
}
