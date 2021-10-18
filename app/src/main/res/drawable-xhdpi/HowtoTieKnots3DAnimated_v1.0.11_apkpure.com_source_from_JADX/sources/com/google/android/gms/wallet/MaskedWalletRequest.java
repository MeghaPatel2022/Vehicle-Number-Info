package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;

public final class MaskedWalletRequest implements SafeParcelable {
    public static final Creator<MaskedWalletRequest> CREATOR = new zzl();
    private final int mVersionCode;
    String zzaWc;
    String zzaWj;
    Cart zzaWt;
    boolean zzaXe;
    boolean zzaXf;
    boolean zzaXg;
    String zzaXh;
    String zzaXi;
    boolean zzaXj;
    boolean zzaXk;
    CountrySpecification[] zzaXl;
    boolean zzaXm;
    boolean zzaXn;
    ArrayList<CountrySpecification> zzaXo;
    PaymentMethodTokenizationParameters zzaXp;
    ArrayList<Integer> zzaXq;

    public final class Builder {
        private Builder() {
        }

        public Builder addAllowedCardNetwork(int allowedCardNetwork) {
            if (MaskedWalletRequest.this.zzaXq == null) {
                MaskedWalletRequest.this.zzaXq = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzaXq.add(Integer.valueOf(allowedCardNetwork));
            return this;
        }

        public Builder addAllowedCardNetworks(Collection<Integer> allowedCardNetworks) {
            if (allowedCardNetworks != null) {
                if (MaskedWalletRequest.this.zzaXq == null) {
                    MaskedWalletRequest.this.zzaXq = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzaXq.addAll(allowedCardNetworks);
            }
            return this;
        }

        public Builder addAllowedCountrySpecificationForShipping(CountrySpecification countrySpecification) {
            if (MaskedWalletRequest.this.zzaXo == null) {
                MaskedWalletRequest.this.zzaXo = new ArrayList<>();
            }
            MaskedWalletRequest.this.zzaXo.add(countrySpecification);
            return this;
        }

        public Builder addAllowedCountrySpecificationsForShipping(Collection<CountrySpecification> countrySpecifications) {
            if (countrySpecifications != null) {
                if (MaskedWalletRequest.this.zzaXo == null) {
                    MaskedWalletRequest.this.zzaXo = new ArrayList<>();
                }
                MaskedWalletRequest.this.zzaXo.addAll(countrySpecifications);
            }
            return this;
        }

        public MaskedWalletRequest build() {
            return MaskedWalletRequest.this;
        }

        public Builder setAllowDebitCard(boolean allowDebitCard) {
            MaskedWalletRequest.this.zzaXn = allowDebitCard;
            return this;
        }

        public Builder setAllowPrepaidCard(boolean allowPrepaidCard) {
            MaskedWalletRequest.this.zzaXm = allowPrepaidCard;
            return this;
        }

        public Builder setCart(Cart cart) {
            MaskedWalletRequest.this.zzaWt = cart;
            return this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            MaskedWalletRequest.this.zzaWc = currencyCode;
            return this;
        }

        public Builder setEstimatedTotalPrice(String estimatedTotalPrice) {
            MaskedWalletRequest.this.zzaXh = estimatedTotalPrice;
            return this;
        }

        public Builder setIsBillingAgreement(boolean isBillingAgreement) {
            MaskedWalletRequest.this.zzaXk = isBillingAgreement;
            return this;
        }

        public Builder setMerchantName(String merchantName) {
            MaskedWalletRequest.this.zzaXi = merchantName;
            return this;
        }

        public Builder setMerchantTransactionId(String merchantTransactionId) {
            MaskedWalletRequest.this.zzaWj = merchantTransactionId;
            return this;
        }

        public Builder setPaymentMethodTokenizationParameters(PaymentMethodTokenizationParameters paymentMethodTokenizationParameters) {
            MaskedWalletRequest.this.zzaXp = paymentMethodTokenizationParameters;
            return this;
        }

        public Builder setPhoneNumberRequired(boolean phoneNumberRequired) {
            MaskedWalletRequest.this.zzaXe = phoneNumberRequired;
            return this;
        }

        public Builder setShippingAddressRequired(boolean shippingAddressRequired) {
            MaskedWalletRequest.this.zzaXf = shippingAddressRequired;
            return this;
        }

        public Builder setUseMinimalBillingAddress(boolean useMinimalBillingAddress) {
            MaskedWalletRequest.this.zzaXg = useMinimalBillingAddress;
            return this;
        }
    }

    MaskedWalletRequest() {
        this.mVersionCode = 3;
        this.zzaXm = true;
        this.zzaXn = true;
    }

    MaskedWalletRequest(int versionCode, String merchantTransactionId, boolean phoneNumberRequired, boolean shippingAddressRequired, boolean useMinimalBillingAddress, String estimatedTotalPrice, String currencyCode, String merchantName, Cart cart, boolean shouldRetrieveWalletObjects, boolean isBillingAgreement, CountrySpecification[] allowedShippingCountrySpecifications, boolean allowPrepaidCard, boolean allowDebitCard, ArrayList<CountrySpecification> allowedCountrySpecificationsForShipping, PaymentMethodTokenizationParameters paymentMethodTokenizationParameters, ArrayList<Integer> allowedCardNetworks) {
        this.mVersionCode = versionCode;
        this.zzaWj = merchantTransactionId;
        this.zzaXe = phoneNumberRequired;
        this.zzaXf = shippingAddressRequired;
        this.zzaXg = useMinimalBillingAddress;
        this.zzaXh = estimatedTotalPrice;
        this.zzaWc = currencyCode;
        this.zzaXi = merchantName;
        this.zzaWt = cart;
        this.zzaXj = shouldRetrieveWalletObjects;
        this.zzaXk = isBillingAgreement;
        this.zzaXl = allowedShippingCountrySpecifications;
        this.zzaXm = allowPrepaidCard;
        this.zzaXn = allowDebitCard;
        this.zzaXo = allowedCountrySpecificationsForShipping;
        this.zzaXp = paymentMethodTokenizationParameters;
        this.zzaXq = allowedCardNetworks;
    }

    public static Builder newBuilder() {
        MaskedWalletRequest maskedWalletRequest = new MaskedWalletRequest();
        maskedWalletRequest.getClass();
        return new Builder();
    }

    public boolean allowDebitCard() {
        return this.zzaXn;
    }

    public boolean allowPrepaidCard() {
        return this.zzaXm;
    }

    public int describeContents() {
        return 0;
    }

    public ArrayList<Integer> getAllowedCardNetworks() {
        return this.zzaXq;
    }

    public ArrayList<CountrySpecification> getAllowedCountrySpecificationsForShipping() {
        return this.zzaXo;
    }

    public CountrySpecification[] getAllowedShippingCountrySpecifications() {
        return this.zzaXl;
    }

    public Cart getCart() {
        return this.zzaWt;
    }

    public String getCurrencyCode() {
        return this.zzaWc;
    }

    public String getEstimatedTotalPrice() {
        return this.zzaXh;
    }

    public String getMerchantName() {
        return this.zzaXi;
    }

    public String getMerchantTransactionId() {
        return this.zzaWj;
    }

    public PaymentMethodTokenizationParameters getPaymentMethodTokenizationParameters() {
        return this.zzaXp;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isBillingAgreement() {
        return this.zzaXk;
    }

    public boolean isPhoneNumberRequired() {
        return this.zzaXe;
    }

    public boolean isShippingAddressRequired() {
        return this.zzaXf;
    }

    public boolean useMinimalBillingAddress() {
        return this.zzaXg;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzl.zza(this, dest, flags);
    }
}
