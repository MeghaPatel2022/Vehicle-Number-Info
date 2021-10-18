package com.google.android.gms.wallet.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import com.google.android.gms.C0224R;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class WalletFragmentOptions implements SafeParcelable {
    public static final Creator<WalletFragmentOptions> CREATOR = new zzb();
    /* access modifiers changed from: private */
    public int mTheme;
    final int mVersionCode;
    /* access modifiers changed from: private */
    public int zzaXE;
    /* access modifiers changed from: private */
    public WalletFragmentStyle zzaYi;
    /* access modifiers changed from: private */
    public int zzagr;

    public final class Builder {
        private Builder() {
        }

        public WalletFragmentOptions build() {
            return WalletFragmentOptions.this;
        }

        public Builder setEnvironment(int environment) {
            WalletFragmentOptions.this.zzaXE = environment;
            return this;
        }

        public Builder setFragmentStyle(int styleResourceId) {
            WalletFragmentOptions.this.zzaYi = new WalletFragmentStyle().setStyleResourceId(styleResourceId);
            return this;
        }

        public Builder setFragmentStyle(WalletFragmentStyle fragmentStyle) {
            WalletFragmentOptions.this.zzaYi = fragmentStyle;
            return this;
        }

        public Builder setMode(int mode) {
            WalletFragmentOptions.this.zzagr = mode;
            return this;
        }

        public Builder setTheme(int theme) {
            WalletFragmentOptions.this.mTheme = theme;
            return this;
        }
    }

    private WalletFragmentOptions() {
        this.mVersionCode = 1;
    }

    WalletFragmentOptions(int versionCode, int environment, int theme, WalletFragmentStyle fragmentStyle, int mode) {
        this.mVersionCode = versionCode;
        this.zzaXE = environment;
        this.mTheme = theme;
        this.zzaYi = fragmentStyle;
        this.zzagr = mode;
    }

    public static Builder newBuilder() {
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.getClass();
        return new Builder();
    }

    public static WalletFragmentOptions zza(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0224R.styleable.WalletFragmentOptions);
        int i = obtainStyledAttributes.getInt(C0224R.styleable.WalletFragmentOptions_appTheme, 0);
        int i2 = obtainStyledAttributes.getInt(C0224R.styleable.WalletFragmentOptions_environment, 1);
        int resourceId = obtainStyledAttributes.getResourceId(C0224R.styleable.WalletFragmentOptions_fragmentStyle, 0);
        int i3 = obtainStyledAttributes.getInt(C0224R.styleable.WalletFragmentOptions_fragmentMode, 1);
        obtainStyledAttributes.recycle();
        WalletFragmentOptions walletFragmentOptions = new WalletFragmentOptions();
        walletFragmentOptions.mTheme = i;
        walletFragmentOptions.zzaXE = i2;
        walletFragmentOptions.zzaYi = new WalletFragmentStyle().setStyleResourceId(resourceId);
        walletFragmentOptions.zzaYi.zzaS(context);
        walletFragmentOptions.zzagr = i3;
        return walletFragmentOptions;
    }

    public int describeContents() {
        return 0;
    }

    public int getEnvironment() {
        return this.zzaXE;
    }

    public WalletFragmentStyle getFragmentStyle() {
        return this.zzaYi;
    }

    public int getMode() {
        return this.zzagr;
    }

    public int getTheme() {
        return this.mTheme;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    public void zzaS(Context context) {
        if (this.zzaYi != null) {
            this.zzaYi.zzaS(context);
        }
    }
}
