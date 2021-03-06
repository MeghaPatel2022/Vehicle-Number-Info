package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.FullWallet;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.WalletConstants;
import com.google.android.gms.wallet.firstparty.GetBuyFlowInitializationTokenResponse;
import com.google.android.gms.wallet.firstparty.GetInstrumentsResponse;
import java.lang.ref.WeakReference;

public class zzrh extends zzj<zzrc> {
    private final Context mContext;
    private final int mTheme;
    private final String zzQE;
    private final int zzaXE;

    private static class zza extends com.google.android.gms.internal.zzrf.zza {
        private zza() {
        }

        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
        }

        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
        }

        public void zza(int i, boolean z, Bundle bundle) {
        }

        public void zza(Status status, GetBuyFlowInitializationTokenResponse getBuyFlowInitializationTokenResponse, Bundle bundle) {
        }

        public void zza(Status status, GetInstrumentsResponse getInstrumentsResponse, Bundle bundle) {
        }

        public void zzb(int i, boolean z, Bundle bundle) {
        }

        public void zzj(int i, Bundle bundle) {
        }
    }

    static final class zzb extends zza {
        private final WeakReference<Activity> zzaYs;
        private final int zzadi;

        public zzb(Context context, int i) {
            super();
            this.zzaYs = new WeakReference<>((Activity) context);
            this.zzadi = i;
        }

        public void zza(int i, FullWallet fullWallet, Bundle bundle) {
            int i2;
            Activity activity = (Activity) this.zzaYs.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onFullWalletLoaded, Activity has gone");
                return;
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzadi);
                } catch (SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra(WalletConstants.EXTRA_FULL_WALLET, fullWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                PendingIntent createPendingResult = activity.createPendingResult(this.zzadi, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onFullWalletLoaded");
                    return;
                }
                try {
                    createPendingResult.send(i2);
                } catch (CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        public void zza(int i, MaskedWallet maskedWallet, Bundle bundle) {
            int i2;
            Activity activity = (Activity) this.zzaYs.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onMaskedWalletLoaded, Activity has gone");
                return;
            }
            PendingIntent pendingIntent = null;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT");
            }
            ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzadi);
                } catch (SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Intent intent = new Intent();
                if (connectionResult.isSuccess()) {
                    i2 = -1;
                    intent.putExtra(WalletConstants.EXTRA_MASKED_WALLET, maskedWallet);
                } else {
                    i2 = i == 408 ? 0 : 1;
                    intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, i);
                }
                PendingIntent createPendingResult = activity.createPendingResult(this.zzadi, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onMaskedWalletLoaded");
                    return;
                }
                try {
                    createPendingResult.send(i2);
                } catch (CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }

        public void zza(int i, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzaYs.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onPreAuthorizationDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_USER_PREAUTHORIZED, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzadi, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onPreAuthorizationDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void zzb(int i, boolean z, Bundle bundle) {
            Activity activity = (Activity) this.zzaYs.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onIsNewUserDetermined, Activity has gone");
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WalletConstants.EXTRA_IS_NEW_USER, z);
            PendingIntent createPendingResult = activity.createPendingResult(this.zzadi, intent, 1073741824);
            if (createPendingResult == null) {
                Log.w("WalletClientImpl", "Null pending result returned for onIsNewUserDetermined");
                return;
            }
            try {
                createPendingResult.send(-1);
            } catch (CanceledException e) {
                Log.w("WalletClientImpl", "Exception setting pending result", e);
            }
        }

        public void zzj(int i, Bundle bundle) {
            zzx.zzb(bundle, (Object) "Bundle should not be null");
            Activity activity = (Activity) this.zzaYs.get();
            if (activity == null) {
                Log.d("WalletClientImpl", "Ignoring onWalletObjectsCreated, Activity has gone");
                return;
            }
            ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) bundle.getParcelable("com.google.android.gms.wallet.EXTRA_PENDING_INTENT"));
            if (connectionResult.hasResolution()) {
                try {
                    connectionResult.startResolutionForResult(activity, this.zzadi);
                } catch (SendIntentException e) {
                    Log.w("WalletClientImpl", "Exception starting pending intent", e);
                }
            } else {
                Log.e("WalletClientImpl", "Create Wallet Objects confirmation UI will not be shown connection result: " + connectionResult);
                Intent intent = new Intent();
                intent.putExtra(WalletConstants.EXTRA_ERROR_CODE, WalletConstants.ERROR_CODE_UNKNOWN);
                PendingIntent createPendingResult = activity.createPendingResult(this.zzadi, intent, 1073741824);
                if (createPendingResult == null) {
                    Log.w("WalletClientImpl", "Null pending result returned for onWalletObjectsCreated");
                    return;
                }
                try {
                    createPendingResult.send(1);
                } catch (CanceledException e2) {
                    Log.w("WalletClientImpl", "Exception setting pending result", e2);
                }
            }
        }
    }

    public zzrh(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, int i, int i2) {
        super(context, looper, 4, zzf, connectionCallbacks, onConnectionFailedListener);
        this.mContext = context;
        this.zzaXE = i;
        this.zzQE = zzf.getAccountName();
        this.mTheme = i2;
    }

    private Bundle zzCl() {
        return zza(this.zzaXE, this.mContext.getPackageName(), this.zzQE, this.mTheme);
    }

    public static Bundle zza(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        bundle.putInt("com.google.android.gms.wallet.EXTRA_ENVIRONMENT", i);
        bundle.putString("androidPackageName", str);
        if (!TextUtils.isEmpty(str2)) {
            bundle.putParcelable("com.google.android.gms.wallet.EXTRA_BUYER_ACCOUNT", new Account(str2, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
        }
        bundle.putInt("com.google.android.gms.wallet.EXTRA_THEME", i2);
        return bundle;
    }

    public void zza(FullWalletRequest fullWalletRequest, int i) {
        zzb zzb2 = new zzb(this.mContext, i);
        try {
            ((zzrc) zzoA()).zza(fullWalletRequest, zzCl(), (zzrf) zzb2);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting full wallet", e);
            zzb2.zza(8, (FullWallet) null, Bundle.EMPTY);
        }
    }

    public void zza(MaskedWalletRequest maskedWalletRequest, int i) {
        Bundle zzCl = zzCl();
        zzb zzb2 = new zzb(this.mContext, i);
        try {
            ((zzrc) zzoA()).zza(maskedWalletRequest, zzCl, (zzrf) zzb2);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException getting masked wallet", e);
            zzb2.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    public void zza(NotifyTransactionStatusRequest notifyTransactionStatusRequest) {
        try {
            ((zzrc) zzoA()).zza(notifyTransactionStatusRequest, zzCl());
        } catch (RemoteException e) {
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdV */
    public zzrc zzV(IBinder iBinder) {
        return com.google.android.gms.internal.zzrc.zza.zzdR(iBinder);
    }

    public void zze(String str, String str2, int i) {
        Bundle zzCl = zzCl();
        zzb zzb2 = new zzb(this.mContext, i);
        try {
            ((zzrc) zzoA()).zza(str, str2, zzCl, zzb2);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException changing masked wallet", e);
            zzb2.zza(8, (MaskedWallet) null, Bundle.EMPTY);
        }
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.wallet.service.BIND";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.wallet.internal.IOwService";
    }

    public void zzki(int i) {
        Bundle zzCl = zzCl();
        zzb zzb2 = new zzb(this.mContext, i);
        try {
            ((zzrc) zzoA()).zza(zzCl, (zzrf) zzb2);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during checkForPreAuthorization", e);
            zzb2.zza(8, false, Bundle.EMPTY);
        }
    }

    public void zzkj(int i) {
        Bundle zzCl = zzCl();
        zzb zzb2 = new zzb(this.mContext, i);
        try {
            ((zzrc) zzoA()).zzb(zzCl, zzb2);
        } catch (RemoteException e) {
            Log.e("WalletClientImpl", "RemoteException during isNewUser", e);
            zzb2.zzb(8, false, Bundle.EMPTY);
        }
    }

    public boolean zzoC() {
        return true;
    }
}
