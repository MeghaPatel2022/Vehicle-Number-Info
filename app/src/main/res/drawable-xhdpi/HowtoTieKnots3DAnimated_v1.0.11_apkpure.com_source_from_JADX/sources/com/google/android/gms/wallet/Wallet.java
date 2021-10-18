package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrh;
import com.google.android.gms.internal.zzrj;
import com.google.android.gms.internal.zzrk;
import com.google.android.gms.wallet.wobs.zzj;
import java.util.Locale;

public final class Wallet {
    public static final Api<WalletOptions> API = new Api<>("Wallet.API", zzQg, zzQf);
    public static final Payments Payments = new zzrg();
    /* access modifiers changed from: private */
    public static final zzc<zzrh> zzQf = new zzc<>();
    private static final com.google.android.gms.common.api.Api.zza<zzrh, WalletOptions> zzQg = new com.google.android.gms.common.api.Api.zza<zzrh, WalletOptions>() {
        public zzrh zza(Context context, Looper looper, zzf zzf, WalletOptions walletOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            if (walletOptions == null) {
                walletOptions = new WalletOptions();
            }
            return new zzrh(context, looper, zzf, connectionCallbacks, onConnectionFailedListener, walletOptions.environment, walletOptions.theme);
        }
    };
    public static final zzj zzaXC = new zzrk();
    public static final com.google.android.gms.wallet.firstparty.zza zzaXD = new zzrj();

    public static final class WalletOptions implements HasOptions {
        public final int environment;
        public final int theme;

        public static final class Builder {
            /* access modifiers changed from: private */
            public int mTheme = 0;
            /* access modifiers changed from: private */
            public int zzaXE = 3;

            public WalletOptions build() {
                return new WalletOptions(this);
            }

            public Builder setEnvironment(int environment) {
                if (environment == 0 || environment == 2 || environment == 1 || environment == 3) {
                    this.zzaXE = environment;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[]{Integer.valueOf(environment)}));
            }

            public Builder setTheme(int theme) {
                if (theme == 0 || theme == 1) {
                    this.mTheme = theme;
                    return this;
                }
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[]{Integer.valueOf(theme)}));
            }
        }

        private WalletOptions() {
            this(new Builder());
        }

        private WalletOptions(Builder builder) {
            this.environment = builder.zzaXE;
            this.theme = builder.mTheme;
        }
    }

    public static abstract class zza<R extends Result> extends com.google.android.gms.common.api.zzc.zza<R, zzrh> {
        public zza(GoogleApiClient googleApiClient) {
            super(Wallet.zzQf, googleApiClient);
        }
    }

    public static abstract class zzb extends zza<Status> {
        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    private Wallet() {
    }

    @Deprecated
    public static void changeMaskedWallet(GoogleApiClient googleApiClient, String googleTransactionId, String merchantTransactionId, int requestCode) {
        Payments.changeMaskedWallet(googleApiClient, googleTransactionId, merchantTransactionId, requestCode);
    }

    @Deprecated
    public static void checkForPreAuthorization(GoogleApiClient googleApiClient, int requestCode) {
        Payments.checkForPreAuthorization(googleApiClient, requestCode);
    }

    @Deprecated
    public static void loadFullWallet(GoogleApiClient googleApiClient, FullWalletRequest request, int requestCode) {
        Payments.loadFullWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void loadMaskedWallet(GoogleApiClient googleApiClient, MaskedWalletRequest request, int requestCode) {
        Payments.loadMaskedWallet(googleApiClient, request, requestCode);
    }

    @Deprecated
    public static void notifyTransactionStatus(GoogleApiClient googleApiClient, NotifyTransactionStatusRequest request) {
        Payments.notifyTransactionStatus(googleApiClient, request);
    }
}
