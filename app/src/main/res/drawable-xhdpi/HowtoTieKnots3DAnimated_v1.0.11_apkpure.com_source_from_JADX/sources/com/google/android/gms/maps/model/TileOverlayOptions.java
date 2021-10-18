package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions implements SafeParcelable {
    public static final zzo CREATOR = new zzo();
    private final int mVersionCode;
    private float zzaGZ;
    /* access modifiers changed from: private */
    public zzi zzaHH;
    private TileProvider zzaHI;
    private boolean zzaHJ;
    private boolean zzaHa;

    public TileOverlayOptions() {
        this.zzaHa = true;
        this.zzaHJ = true;
        this.mVersionCode = 1;
    }

    TileOverlayOptions(int versionCode, IBinder delegate, boolean visible, float zIndex, boolean fadeIn) {
        this.zzaHa = true;
        this.zzaHJ = true;
        this.mVersionCode = versionCode;
        this.zzaHH = zza.zzcX(delegate);
        this.zzaHI = this.zzaHH == null ? null : new TileProvider() {
            private final zzi zzaHK = TileOverlayOptions.this.zzaHH;

            public Tile getTile(int x, int y, int zoom) {
                try {
                    return this.zzaHK.getTile(x, y, zoom);
                } catch (RemoteException e) {
                    return null;
                }
            }
        };
        this.zzaHa = visible;
        this.zzaGZ = zIndex;
        this.zzaHJ = fadeIn;
    }

    public int describeContents() {
        return 0;
    }

    public TileOverlayOptions fadeIn(boolean fadeIn) {
        this.zzaHJ = fadeIn;
        return this;
    }

    public boolean getFadeIn() {
        return this.zzaHJ;
    }

    public TileProvider getTileProvider() {
        return this.zzaHI;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public TileOverlayOptions tileProvider(final TileProvider tileProvider) {
        this.zzaHI = tileProvider;
        this.zzaHH = this.zzaHI == null ? null : new zza() {
            public Tile getTile(int x, int y, int zoom) {
                return tileProvider.getTile(x, y, zoom);
            }
        };
        return this;
    }

    public TileOverlayOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzo.zza(this, out, flags);
    }

    public TileOverlayOptions zIndex(float zIndex) {
        this.zzaGZ = zIndex;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public IBinder zzxf() {
        return this.zzaHH.asBinder();
    }
}
