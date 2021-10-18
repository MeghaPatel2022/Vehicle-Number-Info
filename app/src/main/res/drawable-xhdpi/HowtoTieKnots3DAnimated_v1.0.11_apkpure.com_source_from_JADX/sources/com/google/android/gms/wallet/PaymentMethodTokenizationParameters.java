package com.google.android.gms.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class PaymentMethodTokenizationParameters implements SafeParcelable {
    public static final Creator<PaymentMethodTokenizationParameters> CREATOR = new zzp();
    private final int mVersionCode;
    int zzaXv;
    Bundle zzaXw;

    public final class Builder {
        private Builder() {
        }

        public Builder addParameter(String name, String value) {
            zzx.zzh(name, "Tokenization parameter name must not be empty");
            zzx.zzh(value, "Tokenization parameter value must not be empty");
            PaymentMethodTokenizationParameters.this.zzaXw.putString(name, value);
            return this;
        }

        public PaymentMethodTokenizationParameters build() {
            return PaymentMethodTokenizationParameters.this;
        }

        public Builder setPaymentMethodTokenizationType(int tokenizationType) {
            PaymentMethodTokenizationParameters.this.zzaXv = tokenizationType;
            return this;
        }
    }

    private PaymentMethodTokenizationParameters() {
        this.zzaXw = new Bundle();
        this.mVersionCode = 1;
    }

    PaymentMethodTokenizationParameters(int versionCode, int tokenizationType, Bundle parameters) {
        this.zzaXw = new Bundle();
        this.mVersionCode = versionCode;
        this.zzaXv = tokenizationType;
        this.zzaXw = parameters;
    }

    public static Builder newBuilder() {
        PaymentMethodTokenizationParameters paymentMethodTokenizationParameters = new PaymentMethodTokenizationParameters();
        paymentMethodTokenizationParameters.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getParameters() {
        return new Bundle(this.zzaXw);
    }

    public int getPaymentMethodTokenizationType() {
        return this.zzaXv;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzp.zza(this, out, flags);
    }
}
