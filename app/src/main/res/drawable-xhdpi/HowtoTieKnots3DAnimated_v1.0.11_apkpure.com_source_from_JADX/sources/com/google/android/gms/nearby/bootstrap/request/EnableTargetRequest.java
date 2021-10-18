package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;

public class EnableTargetRequest implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private final String description;
    private final String name;
    final int versionCode;
    private final byte zzaJa;
    private final zzow zzaJc;
    private final zzox zzaJd;
    private final zzoy zzaJe;

    EnableTargetRequest(int versionCode2, String name2, String description2, byte deviceType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode2;
        this.name = zzx.zzcs(name2);
        this.description = (String) zzx.zzv(description2);
        this.zzaJa = deviceType;
        zzx.zzv(connectionListener);
        this.zzaJc = zza.zzcZ(connectionListener);
        zzx.zzv(dataListener);
        this.zzaJd = zzox.zza.zzda(dataListener);
        zzx.zzv(callback);
        this.zzaJe = zzoy.zza.zzdb(callback);
    }

    public int describeContents() {
        zze zze = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze zze = CREATOR;
        zze.zza(this, out, flags);
    }

    public IBinder zzsc() {
        if (this.zzaJe == null) {
            return null;
        }
        return this.zzaJe.asBinder();
    }

    public byte zzyc() {
        return this.zzaJa;
    }

    public IBinder zzyh() {
        if (this.zzaJc == null) {
            return null;
        }
        return this.zzaJc.asBinder();
    }

    public IBinder zzyi() {
        if (this.zzaJd == null) {
            return null;
        }
        return this.zzaJd.asBinder();
    }
}
