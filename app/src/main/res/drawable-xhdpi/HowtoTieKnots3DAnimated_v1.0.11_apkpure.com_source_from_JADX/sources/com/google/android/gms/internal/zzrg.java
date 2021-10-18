package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.zzb;

public class zzrg implements Payments {
    public void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        final String str = googleTransactionId;
        final String str2 = merchantTransactionId;
        final int i = requestCode;
        googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrh zzrh) {
                zzrh.zze(str, str2, i);
                zza(Status.zzaaD);
            }
        });
    }

    public void checkForPreAuthorization(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrh zzrh) {
                zzrh.zzki(requestCode);
                zza(Status.zzaaD);
            }
        });
    }

    public void isNewUser(GoogleApiClient googleApiClient, final int requestCode) {
        googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrh zzrh) {
                zzrh.zzkj(requestCode);
                zza(Status.zzaaD);
            }
        });
    }

    public void loadFullWallet(GoogleApiClient googleApiClient, final FullWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrh zzrh) {
                zzrh.zza(request, requestCode);
                zza(Status.zzaaD);
            }
        });
    }

    public void loadMaskedWallet(GoogleApiClient googleApiClient, final MaskedWalletRequest request, final int requestCode) {
        googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrh zzrh) {
                zzrh.zza(request, requestCode);
                zza(Status.zzaaD);
            }
        });
    }

    public void notifyTransactionStatus(GoogleApiClient googleApiClient, final NotifyTransactionStatusRequest request) {
        googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzrh zzrh) {
                zzrh.zza(request);
                zza(Status.zzaaD);
            }
        });
    }
}
