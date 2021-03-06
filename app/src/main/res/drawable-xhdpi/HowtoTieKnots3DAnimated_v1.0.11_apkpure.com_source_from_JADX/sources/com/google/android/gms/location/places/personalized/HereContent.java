package com.google.android.gms.location.places.personalized;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.plus.PlusShare;
import java.util.List;

public class HereContent implements SafeParcelable {
    public static final zzb CREATOR = new zzb();
    final int mVersionCode;
    private final String zzaFe;
    private final List<Action> zzaFf;

    public static final class Action implements SafeParcelable {
        public static final zza CREATOR = new zza();
        final int mVersionCode;
        private final String zzPb;
        private final String zzagU;

        Action(int versionCode, String title, String uri) {
            this.mVersionCode = versionCode;
            this.zzagU = title;
            this.zzPb = uri;
        }

        public int describeContents() {
            zza zza = CREATOR;
            return 0;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (!(object instanceof Action)) {
                return false;
            }
            Action action = (Action) object;
            return zzw.equal(this.zzagU, action.zzagU) && zzw.equal(this.zzPb, action.zzPb);
        }

        public String getTitle() {
            return this.zzagU;
        }

        public String getUri() {
            return this.zzPb;
        }

        public int hashCode() {
            return zzw.hashCode(this.zzagU, this.zzPb);
        }

        public String toString() {
            return zzw.zzu(this).zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, this.zzagU).zzg("uri", this.zzPb).toString();
        }

        public void writeToParcel(Parcel parcel, int flags) {
            zza zza = CREATOR;
            zza.zza(this, parcel, flags);
        }
    }

    HereContent(int versionCode, String data, List<Action> actions) {
        this.mVersionCode = versionCode;
        this.zzaFe = data;
        this.zzaFf = actions;
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof HereContent)) {
            return false;
        }
        HereContent hereContent = (HereContent) object;
        return zzw.equal(this.zzaFe, hereContent.zzaFe) && zzw.equal(this.zzaFf, hereContent.zzaFf);
    }

    public List<Action> getActions() {
        return this.zzaFf;
    }

    public String getData() {
        return this.zzaFe;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaFe, this.zzaFf);
    }

    public String toString() {
        return zzw.zzu(this).zzg("data", this.zzaFe).zzg("actions", this.zzaFf).toString();
    }

    public void writeToParcel(Parcel parcel, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, flags);
    }
}
