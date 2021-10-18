package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Asset implements SafeParcelable {
    public static final Creator<Asset> CREATOR = new zze();
    final int mVersionCode;
    public Uri uri;
    private String zzaYK;
    public ParcelFileDescriptor zzaYL;
    private byte[] zzayG;

    Asset(int versionCode, byte[] data, String digest, ParcelFileDescriptor fd, Uri uri2) {
        this.mVersionCode = versionCode;
        this.zzayG = data;
        this.zzaYK = digest;
        this.zzaYL = fd;
        this.uri = uri2;
    }

    public static Asset createFromBytes(byte[] assetData) {
        if (assetData != null) {
            return new Asset(1, assetData, null, null, null);
        }
        throw new IllegalArgumentException("Asset data cannot be null");
    }

    public static Asset createFromFd(ParcelFileDescriptor fd) {
        if (fd != null) {
            return new Asset(1, null, null, fd, null);
        }
        throw new IllegalArgumentException("Asset fd cannot be null");
    }

    public static Asset createFromRef(String digest) {
        if (digest != null) {
            return new Asset(1, null, digest, null, null);
        }
        throw new IllegalArgumentException("Asset digest cannot be null");
    }

    public static Asset createFromUri(Uri uri2) {
        if (uri2 != null) {
            return new Asset(1, null, null, null, uri2);
        }
        throw new IllegalArgumentException("Asset uri cannot be null");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Asset)) {
            return false;
        }
        Asset asset = (Asset) o;
        return zzw.equal(this.zzayG, asset.zzayG) && zzw.equal(this.zzaYK, asset.zzaYK) && zzw.equal(this.zzaYL, asset.zzaYL) && zzw.equal(this.uri, asset.uri);
    }

    public byte[] getData() {
        return this.zzayG;
    }

    public String getDigest() {
        return this.zzaYK;
    }

    public ParcelFileDescriptor getFd() {
        return this.zzaYL;
    }

    public Uri getUri() {
        return this.uri;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzayG, this.zzaYK, this.zzaYL, this.uri);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asset[@");
        sb.append(Integer.toHexString(hashCode()));
        if (this.zzaYK == null) {
            sb.append(", nodigest");
        } else {
            sb.append(", ");
            sb.append(this.zzaYK);
        }
        if (this.zzayG != null) {
            sb.append(", size=");
            sb.append(this.zzayG.length);
        }
        if (this.zzaYL != null) {
            sb.append(", fd=");
            sb.append(this.zzaYL);
        }
        if (this.uri != null) {
            sb.append(", uri=");
            sb.append(this.uri);
        }
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags | 1);
    }
}
