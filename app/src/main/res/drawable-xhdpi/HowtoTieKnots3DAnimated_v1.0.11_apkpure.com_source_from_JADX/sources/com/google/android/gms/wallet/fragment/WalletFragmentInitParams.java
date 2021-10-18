package com.google.android.gms.wallet.fragment;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragmentInitParams implements SafeParcelable {
    public static final Creator<WalletFragmentInitParams> CREATOR = new zza();
    final int mVersionCode;
    /* access modifiers changed from: private */
    public String zzQE;
    /* access modifiers changed from: private */
    public MaskedWalletRequest zzaXS;
    /* access modifiers changed from: private */
    public MaskedWallet zzaXT;
    /* access modifiers changed from: private */
    public int zzaYg;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentInitParams build() {
            boolean z = true;
            zzx.zza((WalletFragmentInitParams.this.zzaXT != null && WalletFragmentInitParams.this.zzaXS == null) || (WalletFragmentInitParams.this.zzaXT == null && WalletFragmentInitParams.this.zzaXS != null), (Object) "Exactly one of MaskedWallet or MaskedWalletRequest is required");
            if (WalletFragmentInitParams.this.zzaYg < 0) {
                z = false;
            }
            zzx.zza(z, (Object) "masked wallet request code is required and must be non-negative");
            return WalletFragmentInitParams.this;
        }

        public Builder setAccountName(String accountName) {
            WalletFragmentInitParams.this.zzQE = accountName;
            return this;
        }

        public Builder setMaskedWallet(MaskedWallet maskedWallet) {
            WalletFragmentInitParams.this.zzaXT = maskedWallet;
            return this;
        }

        public Builder setMaskedWalletRequest(MaskedWalletRequest request) {
            WalletFragmentInitParams.this.zzaXS = request;
            return this;
        }

        public Builder setMaskedWalletRequestCode(int requestCode) {
            WalletFragmentInitParams.this.zzaYg = requestCode;
            return this;
        }
    }

    private WalletFragmentInitParams() {
        this.mVersionCode = 1;
        this.zzaYg = -1;
    }

    WalletFragmentInitParams(int versionCode, String accountName, MaskedWalletRequest maskedWalletRequest, int maskedWalletRequestCode, MaskedWallet maskedWallet) {
        this.mVersionCode = versionCode;
        this.zzQE = accountName;
        this.zzaXS = maskedWalletRequest;
        this.zzaYg = maskedWalletRequestCode;
        this.zzaXT = maskedWallet;
    }

    public static Builder newBuilder() {
        WalletFragmentInitParams walletFragmentInitParams = new WalletFragmentInitParams();
        walletFragmentInitParams.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getAccountName() {
        return this.zzQE;
    }

    public MaskedWallet getMaskedWallet() {
        return this.zzaXT;
    }

    public MaskedWalletRequest getMaskedWalletRequest() {
        return this.zzaXS;
    }

    public int getMaskedWalletRequestCode() {
        return this.zzaYg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zza.zza(this, dest, flags);
    }
}
