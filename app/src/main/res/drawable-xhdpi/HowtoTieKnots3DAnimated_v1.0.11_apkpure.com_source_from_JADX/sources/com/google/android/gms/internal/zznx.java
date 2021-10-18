package com.google.android.gms.internal;

import android.accounts.Account;
import android.app.Activity;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.identity.intents.AddressConstants.ErrorCodes;
import com.google.android.gms.identity.intents.AddressConstants.Extras;
import com.google.android.gms.identity.intents.UserAddressRequest;

public class zznx extends zzj<zznz> {
    private Activity mActivity;
    private final int mTheme;
    private final String zzQE;
    private zza zzaAB;

    public static final class zza extends com.google.android.gms.internal.zzny.zza {
        private Activity mActivity;
        private final int zzadi;

        public zza(int i, Activity activity) {
            this.zzadi = i;
            this.mActivity = activity;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.mActivity = activity;
        }

        public void zzh(int i, Bundle bundle) {
            if (i == 1) {
                Intent intent = new Intent();
                intent.putExtras(bundle);
                PendingIntent createPendingResult = this.mActivity.createPendingResult(this.zzadi, intent, 1073741824);
                if (createPendingResult != null) {
                    try {
                        createPendingResult.send(1);
                    } catch (CanceledException e) {
                        Log.w("AddressClientImpl", "Exception settng pending result", e);
                    }
                }
            } else {
                PendingIntent pendingIntent = null;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable("com.google.android.gms.identity.intents.EXTRA_PENDING_INTENT");
                }
                ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
                if (connectionResult.hasResolution()) {
                    try {
                        connectionResult.startResolutionForResult(this.mActivity, this.zzadi);
                    } catch (SendIntentException e2) {
                        Log.w("AddressClientImpl", "Exception starting pending intent", e2);
                    }
                } else {
                    try {
                        PendingIntent createPendingResult2 = this.mActivity.createPendingResult(this.zzadi, new Intent(), 1073741824);
                        if (createPendingResult2 != null) {
                            createPendingResult2.send(1);
                        }
                    } catch (CanceledException e3) {
                        Log.w("AddressClientImpl", "Exception setting pending result", e3);
                    }
                }
            }
        }
    }

    public zznx(Activity activity, Looper looper, zzf zzf, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(activity, looper, 12, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQE = zzf.getAccountName();
        this.mActivity = activity;
        this.mTheme = i;
    }

    public void disconnect() {
        super.disconnect();
        if (this.zzaAB != null) {
            this.zzaAB.setActivity(null);
            this.zzaAB = null;
        }
    }

    public void zza(UserAddressRequest userAddressRequest, int i) {
        zzvw();
        this.zzaAB = new zza(i, this.mActivity);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("com.google.android.gms.identity.intents.EXTRA_CALLING_PACKAGE_NAME", getContext().getPackageName());
            if (!TextUtils.isEmpty(this.zzQE)) {
                bundle.putParcelable("com.google.android.gms.identity.intents.EXTRA_ACCOUNT", new Account(this.zzQE, GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE));
            }
            bundle.putInt("com.google.android.gms.identity.intents.EXTRA_THEME", this.mTheme);
            zzvv().zza(this.zzaAB, userAddressRequest, bundle);
        } catch (RemoteException e) {
            Log.e("AddressClientImpl", "Exception requesting user address", e);
            Bundle bundle2 = new Bundle();
            bundle2.putInt(Extras.EXTRA_ERROR_CODE, ErrorCodes.ERROR_CODE_NO_APPLICABLE_ADDRESSES);
            this.zzaAB.zzh(1, bundle2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbS */
    public zznz zzV(IBinder iBinder) {
        return com.google.android.gms.internal.zznz.zza.zzbU(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.identity.service.BIND";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.identity.intents.internal.IAddressService";
    }

    public boolean zzoC() {
        return true;
    }

    /* access modifiers changed from: protected */
    public zznz zzvv() throws DeadObjectException {
        return (zznz) super.zzoA();
    }

    /* access modifiers changed from: protected */
    public void zzvw() {
        super.zzoz();
    }
}
