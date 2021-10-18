package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.sharing.SharedContent;
import com.google.android.gms.nearby.sharing.internal.zzb.zza;
import java.util.List;

public final class ProvideContentRequest implements SafeParcelable {
    public static final Creator<ProvideContentRequest> CREATOR = new zzf();
    final int versionCode;
    public IBinder zzaKq;
    public zzb zzaKr;
    @Deprecated
    public List<SharedContent> zzaKs;
    public long zzaKt;
    public zzc zzaKu;

    ProvideContentRequest() {
        this.versionCode = 1;
    }

    ProvideContentRequest(int versionCode2, IBinder clientBinder, IBinder contentProviderAsBinder, List<SharedContent> content, long activityId, IBinder callbackAsBinder) {
        this.versionCode = versionCode2;
        this.zzaKq = clientBinder;
        this.zzaKr = zza.zzdm(contentProviderAsBinder);
        this.zzaKs = content;
        this.zzaKt = activityId;
        this.zzaKu = zzc.zza.zzdn(callbackAsBinder);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzf.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyp() {
        return this.zzaKu.asBinder();
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzyx() {
        if (this.zzaKr == null) {
            return null;
        }
        return this.zzaKr.asBinder();
    }
}
