package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;

public class PlaceReport implements SafeParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzj();
    private final String mTag;
    final int mVersionCode;
    private final String zzaDH;
    private final String zzaDI;

    PlaceReport(int versionCode, String placeId, String tag, String source) {
        this.mVersionCode = versionCode;
        this.zzaDH = placeId;
        this.mTag = tag;
        this.zzaDI = source;
    }

    public static PlaceReport create(String placeId, String tag) {
        return zzi(placeId, tag, "unknown");
    }

    private static boolean zzdz(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    c = 1;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    c = 0;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport zzi(String str, String str2, String str3) {
        zzx.zzcs(str);
        zzx.zzcs(str2);
        zzx.zzcs(str3);
        zzx.zzb(zzdz(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        if (!(that instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) that;
        return zzw.equal(this.zzaDH, placeReport.zzaDH) && zzw.equal(this.mTag, placeReport.mTag) && zzw.equal(this.zzaDI, placeReport.zzaDI);
    }

    public String getPlaceId() {
        return this.zzaDH;
    }

    public String getSource() {
        return this.zzaDI;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaDH, this.mTag, this.zzaDI);
    }

    public String toString() {
        zza zzu = zzw.zzu(this);
        zzu.zzg("placeId", this.zzaDH);
        zzu.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzaDI)) {
            zzu.zzg("source", this.zzaDI);
        }
        return zzu.toString();
    }

    public void writeToParcel(Parcel out, int flags) {
        zzj.zza(this, out, flags);
    }
}
