package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public abstract class zzc {
    protected final DataHolder zzYX;
    protected int zzabg;
    private int zzabh;

    public zzc(DataHolder dataHolder, int i) {
        this.zzYX = (DataHolder) zzx.zzv(dataHolder);
        zzbm(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return zzw.equal(Integer.valueOf(zzc.zzabg), Integer.valueOf(this.zzabg)) && zzw.equal(Integer.valueOf(zzc.zzabh), Integer.valueOf(this.zzabh)) && zzc.zzYX == this.zzYX;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String column) {
        return this.zzYX.zze(column, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String column) {
        return this.zzYX.zzg(column, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String column) {
        return this.zzYX.zzf(column, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String column) {
        return this.zzYX.zzc(column, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public long getLong(String column) {
        return this.zzYX.zzb(column, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public String getString(String column) {
        return this.zzYX.zzd(column, this.zzabg, this.zzabh);
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzabg), Integer.valueOf(this.zzabh), this.zzYX);
    }

    public boolean isDataValid() {
        return !this.zzYX.isClosed();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.zzYX.zza(str, this.zzabg, this.zzabh, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public void zzbm(int i) {
        zzx.zzY(i >= 0 && i < this.zzYX.getCount());
        this.zzabg = i;
        this.zzabh = this.zzYX.zzbo(this.zzabg);
    }

    public boolean zzcd(String str) {
        return this.zzYX.zzcd(str);
    }

    /* access modifiers changed from: protected */
    public Uri zzce(String str) {
        return this.zzYX.zzh(str, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public boolean zzcf(String str) {
        return this.zzYX.zzi(str, this.zzabg, this.zzabh);
    }

    /* access modifiers changed from: protected */
    public int zznS() {
        return this.zzabg;
    }
}
