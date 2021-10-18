package com.google.android.gms.wallet;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LineItem implements SafeParcelable {
    public static final Creator<LineItem> CREATOR = new zzi();
    String description;
    private final int mVersionCode;
    String zzaWE;
    String zzaWF;
    int zzaWG;
    String zzaWb;
    String zzaWc;

    public final class Builder {
        private Builder() {
        }

        public LineItem build() {
            return LineItem.this;
        }

        public Builder setCurrencyCode(String currencyCode) {
            LineItem.this.zzaWc = currencyCode;
            return this;
        }

        public Builder setDescription(String description) {
            LineItem.this.description = description;
            return this;
        }

        public Builder setQuantity(String quantity) {
            LineItem.this.zzaWE = quantity;
            return this;
        }

        public Builder setRole(int role) {
            LineItem.this.zzaWG = role;
            return this;
        }

        public Builder setTotalPrice(String totalPrice) {
            LineItem.this.zzaWb = totalPrice;
            return this;
        }

        public Builder setUnitPrice(String unitPrice) {
            LineItem.this.zzaWF = unitPrice;
            return this;
        }
    }

    public interface Role {
        public static final int REGULAR = 0;
        public static final int SHIPPING = 2;
        public static final int TAX = 1;
    }

    LineItem() {
        this.mVersionCode = 1;
        this.zzaWG = 0;
    }

    LineItem(int versionCode, String description2, String quantity, String unitPrice, String totalPrice, int role, String currencyCode) {
        this.mVersionCode = versionCode;
        this.description = description2;
        this.zzaWE = quantity;
        this.zzaWF = unitPrice;
        this.zzaWb = totalPrice;
        this.zzaWG = role;
        this.zzaWc = currencyCode;
    }

    public static Builder newBuilder() {
        LineItem lineItem = new LineItem();
        lineItem.getClass();
        return new Builder();
    }

    public int describeContents() {
        return 0;
    }

    public String getCurrencyCode() {
        return this.zzaWc;
    }

    public String getDescription() {
        return this.description;
    }

    public String getQuantity() {
        return this.zzaWE;
    }

    public int getRole() {
        return this.zzaWG;
    }

    public String getTotalPrice() {
        return this.zzaWb;
    }

    public String getUnitPrice() {
        return this.zzaWF;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
