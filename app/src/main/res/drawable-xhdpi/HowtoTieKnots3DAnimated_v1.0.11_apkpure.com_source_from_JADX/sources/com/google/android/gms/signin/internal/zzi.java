package com.google.android.gms.signin.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.ServerAuthCodeCallbacks.CheckResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.signin.zzd;
import com.google.android.gms.signin.zze;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class zzi extends zzj<zzf> implements zzd {
    private final zzf zzZH;
    private final boolean zzaOn;
    private final ExecutorService zzaOo;
    private final zze zzade;
    private Integer zzadf;

    private static class zza extends com.google.android.gms.signin.internal.zzd.zza {
        private final ExecutorService zzaOo;
        private final zze zzade;

        public zza(zze zze, ExecutorService executorService) {
            this.zzade = zze;
            this.zzaOo = executorService;
        }

        /* access modifiers changed from: private */
        public ServerAuthCodeCallbacks zzzq() throws RemoteException {
            return this.zzade.zzzq();
        }

        public void zza(final String str, final String str2, final zzf zzf) throws RemoteException {
            this.zzaOo.submit(new Runnable() {
                public void run() {
                    try {
                        zzf.zzaq(zza.this.zzzq().onUploadServerAuthCode(str, str2));
                    } catch (RemoteException e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing uploadServerAuthCode callback", e);
                    }
                }
            });
        }

        public void zza(final String str, final List<Scope> list, final zzf zzf) throws RemoteException {
            this.zzaOo.submit(new Runnable() {
                public void run() {
                    try {
                        CheckResult onCheckServerAuthorization = zza.this.zzzq().onCheckServerAuthorization(str, Collections.unmodifiableSet(new HashSet(list)));
                        zzf.zza(new CheckServerAuthResult(onCheckServerAuthorization.zznl(), onCheckServerAuthorization.zznm()));
                    } catch (RemoteException e) {
                        Log.e("SignInClientImpl", "RemoteException thrown when processing checkServerAuthorization callback", e);
                    }
                }
            });
        }
    }

    public zzi(Context context, Looper looper, boolean z, zzf zzf, zze zze, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, ExecutorService executorService) {
        super(context, looper, 44, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzaOn = z;
        this.zzZH = zzf;
        this.zzade = zzf.zzoo();
        this.zzadf = zzf.zzop();
        this.zzaOo = executorService;
    }

    public static Bundle zza(zze zze, Integer num, ExecutorService executorService) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zze.zzzo());
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zze.zzzp());
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", zze.zzlG());
        if (zze.zzzq() != null) {
            bundle.putParcelable("com.google.android.gms.signin.internal.signInCallbacks", new BinderWrapper(new zza(zze, executorService).asBinder()));
        }
        if (num != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
        }
        return bundle;
    }

    public void connect() {
        zza((com.google.android.gms.common.api.GoogleApiClient.zza) new zzf());
    }

    public void zza(zzp zzp, Set<Scope> set, zze zze) {
        zzx.zzb(zze, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zzf) zzoA()).zza(new AuthAccountRequest(zzp, set), zze);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when authAccount is called");
            try {
                zze.zza(new ConnectionResult(8, null), new AuthAccountResult());
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onAuthAccount should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    public void zza(zzp zzp, boolean z) {
        try {
            ((zzf) zzoA()).zza(zzp, this.zzadf.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzt zzt) {
        zzx.zzb(zzt, (Object) "Expecting a valid IResolveAccountCallbacks");
        try {
            ((zzf) zzoA()).zza(new ResolveAccountRequest(this.zzZH.zzog(), this.zzadf.intValue()), zzt);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when resolveAccount is called");
            try {
                zzt.zzb(new ResolveAccountResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "IResolveAccountCallbacks#onAccountResolutionComplete should be executed from the same process, unexpected RemoteException.");
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdI */
    public zzf zzV(IBinder iBinder) {
        return com.google.android.gms.signin.internal.zzf.zza.zzdH(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        Bundle zza2 = zza(this.zzade, this.zzZH.zzop(), this.zzaOo);
        if (!getContext().getPackageName().equals(this.zzZH.zzol())) {
            zza2.putString("com.google.android.gms.signin.internal.realClientPackageName", this.zzZH.zzol());
        }
        return zza2;
    }

    public boolean zzlm() {
        return this.zzaOn;
    }

    public void zzzn() {
        try {
            ((zzf) zzoA()).zzja(this.zzadf.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }
}
