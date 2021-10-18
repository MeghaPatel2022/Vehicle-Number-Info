package com.google.android.gms.location.places.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.zzf;
import com.google.android.gms.location.places.zzf.zza;

public class zzp implements PlacePhotoMetadata {
    /* access modifiers changed from: private */
    public int mIndex;
    /* access modifiers changed from: private */
    public final String zzaET;
    private final CharSequence zzaEU;
    private final int zzzT;
    private final int zzzU;

    public zzp(String str, int i, int i2, CharSequence charSequence, int i3) {
        this.zzaET = str;
        this.zzzT = i;
        this.zzzU = i2;
        this.zzaEU = charSequence;
        this.mIndex = i3;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof zzp)) {
            return false;
        }
        zzp zzp = (zzp) other;
        return zzp.zzzT == this.zzzT && zzp.zzzU == this.zzzU && zzw.equal(zzp.zzaET, this.zzaET) && zzw.equal(zzp.zzaEU, this.zzaEU);
    }

    public CharSequence getAttributions() {
        return this.zzaEU;
    }

    public int getMaxHeight() {
        return this.zzzU;
    }

    public int getMaxWidth() {
        return this.zzzT;
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        final int i = width;
        final int i2 = height;
        return client.zza(new zza<zzd>(Places.zzaDN, client) {
            /* access modifiers changed from: protected */
            public void zza(zzd zzd) throws RemoteException {
                zzd.zza(new zzf((zza) this), zzp.this.zzaET, i, i2, zzp.this.mIndex);
            }
        });
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzzT), Integer.valueOf(this.zzzU), this.zzaET, this.zzaEU);
    }

    public boolean isDataValid() {
        return true;
    }

    /* renamed from: zzwu */
    public PlacePhotoMetadata freeze() {
        return this;
    }
}
