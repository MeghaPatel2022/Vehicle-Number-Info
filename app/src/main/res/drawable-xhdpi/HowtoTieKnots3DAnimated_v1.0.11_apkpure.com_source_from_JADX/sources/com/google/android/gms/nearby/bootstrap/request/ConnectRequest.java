package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzow;
import com.google.android.gms.internal.zzow.zza;
import com.google.android.gms.internal.zzox;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.nearby.bootstrap.Device;

public class ConnectRequest implements SafeParcelable {
    public static final zza CREATOR = new zza();
    private final String description;
    private final String name;
    private final long timeoutMillis;
    final int versionCode;
    private final byte zzaJa;
    private final Device zzaJb;
    private final zzow zzaJc;
    private final zzox zzaJd;
    private final zzoy zzaJe;
    private final String zzaJf;
    private final byte zzaJg;

    ConnectRequest(int versionCode2, Device device, String name2, String description2, byte deviceType, long timeoutMillis2, String token, byte connectType, IBinder connectionListener, IBinder dataListener, IBinder callback) {
        this.versionCode = versionCode2;
        this.zzaJb = (Device) zzx.zzv(device);
        this.name = zzx.zzcs(name2);
        this.description = (String) zzx.zzv(description2);
        this.zzaJa = deviceType;
        this.timeoutMillis = timeoutMillis2;
        this.zzaJg = connectType;
        this.zzaJf = token;
        zzx.zzv(connectionListener);
        this.zzaJc = zza.zzcZ(connectionListener);
        zzx.zzv(dataListener);
        this.zzaJd = zzox.zza.zzda(dataListener);
        zzx.zzv(callback);
        this.zzaJe = zzoy.zza.zzdb(callback);
    }

    public int describeContents() {
        zza zza = CREATOR;
        return 0;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public String getToken() {
        return this.zzaJf;
    }

    public void writeToParcel(Parcel out, int flags) {
        zza zza = CREATOR;
        zza.zza(this, out, flags);
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

    public Device zzye() {
        return this.zzaJb;
    }

    public long zzyf() {
        return this.timeoutMillis;
    }

    public byte zzyg() {
        return this.zzaJg;
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
