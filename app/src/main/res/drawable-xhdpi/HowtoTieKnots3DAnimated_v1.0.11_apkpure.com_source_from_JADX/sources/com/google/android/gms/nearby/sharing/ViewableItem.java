package com.google.android.gms.nearby.sharing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;

public class ViewableItem implements SafeParcelable {
    public static final Creator<ViewableItem> CREATOR = new zzf();
    private final int versionCode;
    private String[] zzaKp;

    private ViewableItem() {
        this.versionCode = 1;
    }

    ViewableItem(int versionCode2, String[] uris) {
        this.versionCode = versionCode2;
        this.zzaKp = uris;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ViewableItem)) {
            return false;
        }
        return zzw.equal(this.zzaKp, ((ViewableItem) o).zzaKp);
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.versionCode;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaKp);
    }

    public String toString() {
        return "ViewableItem[uris=" + Arrays.toString(this.zzaKp) + "]";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    public String[] zzyv() {
        return this.zzaKp;
    }
}
