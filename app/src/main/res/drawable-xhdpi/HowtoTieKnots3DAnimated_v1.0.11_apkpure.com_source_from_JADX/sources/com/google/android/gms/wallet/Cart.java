package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

public final class Cart implements SafeParcelable {
    public static final Creator<Cart> CREATOR = new zzb();
    private final int mVersionCode;
    String zzaWb;
    String zzaWc;
    ArrayList<LineItem> zzaWd;

    public final class Builder {
        private Builder() {
        }

        public Builder addLineItem(LineItem lineItem) {
            Cart.this.zzaWd.add(lineItem);
            return this;
        }

        public Cart build() {
            return Cart.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            Cart.this.zzaWc = currencyCode;
            return this;
        }

        public Builder setLineItems(List<LineItem> lineItems) {
            Cart.this.zzaWd.clear();
            Cart.this.zzaWd.addAll(lineItems);
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            Cart.this.zzaWb = totalPrice;
            return this;
        }
    }

    Cart() {
        this.mVersionCode = 1;
        this.zzaWd = new ArrayList<>();
    }

    Cart(int versionCode, String totalPrice, String currencyCode, ArrayList<LineItem> lineItems) {
        this.mVersionCode = versionCode;
        this.zzaWb = totalPrice;
        this.zzaWc = currencyCode;
        this.zzaWd = lineItems;
    }

    public static Builder newBuilder() {
        Cart cart = new Cart();
        cart.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaWc;
    }

    public ArrayList<LineItem> getLineItems() {
        return this.zzaWd;
    }

    public String getTotalPrice() {
        return this.zzaWb;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }
}
