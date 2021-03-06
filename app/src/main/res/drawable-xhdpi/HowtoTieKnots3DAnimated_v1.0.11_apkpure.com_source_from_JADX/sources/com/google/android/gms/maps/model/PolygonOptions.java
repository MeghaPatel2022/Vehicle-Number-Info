package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.support.p000v4.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements SafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int mVersionCode;
    private float zzaGW;
    private int zzaGX;
    private int zzaGY;
    private float zzaGZ;
    private final List<LatLng> zzaHB;
    private final List<List<LatLng>> zzaHC;
    private boolean zzaHD;
    private boolean zzaHa;

    public PolygonOptions() {
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = 1;
        this.zzaHB = new ArrayList();
        this.zzaHC = new ArrayList();
    }

    PolygonOptions(int versionCode, List<LatLng> points, List holes, float strokeWidth, int strokeColor, int fillColor, float zIndex, boolean visible, boolean geodesic) {
        this.zzaGW = 10.0f;
        this.zzaGX = ViewCompat.MEASURED_STATE_MASK;
        this.zzaGY = 0;
        this.zzaGZ = 0.0f;
        this.zzaHa = true;
        this.zzaHD = false;
        this.mVersionCode = versionCode;
        this.zzaHB = points;
        this.zzaHC = holes;
        this.zzaGW = strokeWidth;
        this.zzaGX = strokeColor;
        this.zzaGY = fillColor;
        this.zzaGZ = zIndex;
        this.zzaHa = visible;
        this.zzaHD = geodesic;
    }

    public PolygonOptions add(LatLng point) {
        this.zzaHB.add(point);
        return this;
    }

    public PolygonOptions add(LatLng... points) {
        this.zzaHB.addAll(Arrays.asList(points));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> points) {
        for (LatLng add : points) {
            this.zzaHB.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> points) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : points) {
            arrayList.add(add);
        }
        this.zzaHC.add(arrayList);
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int color) {
        this.zzaGY = color;
        return this;
    }

    public PolygonOptions geodesic(boolean geodesic) {
        this.zzaHD = geodesic;
        return this;
    }

    public int getFillColor() {
        return this.zzaGY;
    }

    public List<List<LatLng>> getHoles() {
        return this.zzaHC;
    }

    public List<LatLng> getPoints() {
        return this.zzaHB;
    }

    public int getStrokeColor() {
        return this.zzaGX;
    }

    public float getStrokeWidth() {
        return this.zzaGW;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public float getZIndex() {
        return this.zzaGZ;
    }

    public boolean isGeodesic() {
        return this.zzaHD;
    }

    public boolean isVisible() {
        return this.zzaHa;
    }

    public PolygonOptions strokeColor(int color) {
        this.zzaGX = color;
        return this;
    }

    public PolygonOptions strokeWidth(float width) {
        this.zzaGW = width;
        return this;
    }

    public PolygonOptions visible(boolean visible) {
        this.zzaHa = visible;
        return this;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzh.zza(this, out, flags);
    }

    public PolygonOptions zIndex(float zIndex) {
        this.zzaGZ = zIndex;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public List zzxe() {
        return this.zzaHC;
    }
}
