package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzr;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzz;

public final class Drive {
    public static final Api<NoOptions> API = new Api<>("Drive.API", new zza<NoOptions>() {
        /* access modifiers changed from: protected */
        /* renamed from: zzb */
        public Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }, zzQf);
    public static final DriveApi DriveApi = new zzr();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzz();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final zzc<zzt> zzQf = new zzc<>();
    public static final zzc zzagA = new zzw();
    public static final zzf zzagB = new zzab();
    public static final Scope zzagx = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzagy = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzagz = new Api<>("Drive.INTERNAL_API", new zza<zzb>() {
        /* access modifiers changed from: protected */
        public Bundle zza(zzb zzb) {
            return zzb == null ? new Bundle() : zzb.zzqg();
        }
    }, zzQf);

    public static abstract class zza<O extends ApiOptions> extends com.google.android.gms.common.api.Api.zza<zzt, O> {
        /* access modifiers changed from: protected */
        public abstract Bundle zza(O o);

        public zzt zza(Context context, Looper looper, zzf zzf, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzt(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzQe;

        private zzb() {
            this(new Bundle());
        }

        private zzb(Bundle bundle) {
            this.zzQe = bundle;
        }

        public Bundle zzqg() {
            return this.zzQe;
        }
    }

    private Drive() {
    }
}
