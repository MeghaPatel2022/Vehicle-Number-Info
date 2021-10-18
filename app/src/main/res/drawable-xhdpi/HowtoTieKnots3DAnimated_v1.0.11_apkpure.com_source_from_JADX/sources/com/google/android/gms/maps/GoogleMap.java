package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.LocationSource.OnLocationChangedListener;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.zzc;
import com.google.android.gms.maps.model.internal.zzd;
import com.google.android.gms.maps.model.internal.zzf;
import com.google.android.gms.maps.model.internal.zzh;

public final class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zzaFp;
    private UiSettings zzaFq;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);
    }

    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(IndoorBuilding indoorBuilding);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    @Deprecated
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    private static final class zza extends com.google.android.gms.maps.internal.zzb.zza {
        private final CancelableCallback zzaFH;

        zza(CancelableCallback cancelableCallback) {
            this.zzaFH = cancelableCallback;
        }

        public void onCancel() {
            this.zzaFH.onCancel();
        }

        public void onFinish() {
            this.zzaFH.onFinish();
        }
    }

    protected GoogleMap(IGoogleMapDelegate map) {
        this.zzaFp = (IGoogleMapDelegate) zzx.zzv(map);
    }

    public final Circle addCircle(CircleOptions options) {
        try {
            return new Circle(this.zzaFp.addCircle(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final GroundOverlay addGroundOverlay(GroundOverlayOptions options) {
        try {
            zzc addGroundOverlay = this.zzaFp.addGroundOverlay(options);
            if (addGroundOverlay != null) {
                return new GroundOverlay(addGroundOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Marker addMarker(MarkerOptions options) {
        try {
            zzf addMarker = this.zzaFp.addMarker(options);
            if (addMarker != null) {
                return new Marker(addMarker);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polygon addPolygon(PolygonOptions options) {
        try {
            return new Polygon(this.zzaFp.addPolygon(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Polyline addPolyline(PolylineOptions options) {
        try {
            return new Polyline(this.zzaFp.addPolyline(options));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final TileOverlay addTileOverlay(TileOverlayOptions options) {
        try {
            zzh addTileOverlay = this.zzaFp.addTileOverlay(options);
            if (addTileOverlay != null) {
                return new TileOverlay(addTileOverlay);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update) {
        try {
            this.zzaFp.animateCamera(update.zzwB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, int durationMs, CancelableCallback callback) {
        try {
            this.zzaFp.animateCameraWithDurationAndCallback(update.zzwB(), durationMs, callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void animateCamera(CameraUpdate update, CancelableCallback callback) {
        try {
            this.zzaFp.animateCameraWithCallback(update.zzwB(), callback == null ? null : new zza(callback));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void clear() {
        try {
            this.zzaFp.clear();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.zzaFp.getCameraPosition();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            zzd focusedBuilding = this.zzaFp.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final int getMapType() {
        try {
            return this.zzaFp.getMapType();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zzaFp.getMaxZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zzaFp.getMinZoomLevel();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zzaFp.getMyLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final Projection getProjection() {
        try {
            return new Projection(this.zzaFp.getProjection());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.zzaFq == null) {
                this.zzaFq = new UiSettings(this.zzaFp.getUiSettings());
            }
            return this.zzaFq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zzaFp.isBuildingsEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zzaFp.isIndoorEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zzaFp.isMyLocationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zzaFp.isTrafficEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void moveCamera(CameraUpdate update) {
        try {
            this.zzaFp.moveCamera(update.zzwB());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setBuildingsEnabled(boolean enabled) {
        try {
            this.zzaFp.setBuildingsEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setContentDescription(String description) {
        try {
            this.zzaFp.setContentDescription(description);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final boolean setIndoorEnabled(boolean enabled) {
        try {
            return this.zzaFp.setIndoorEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setInfoWindowAdapter(final InfoWindowAdapter adapter) {
        if (adapter == null) {
            try {
                this.zzaFp.setInfoWindowAdapter(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setInfoWindowAdapter(new com.google.android.gms.maps.internal.zzd.zza() {
                public com.google.android.gms.dynamic.zzd zzf(zzf zzf) {
                    return zze.zzx(adapter.getInfoWindow(new Marker(zzf)));
                }

                public com.google.android.gms.dynamic.zzd zzg(zzf zzf) {
                    return zze.zzx(adapter.getInfoContents(new Marker(zzf)));
                }
            });
        }
    }

    public final void setLocationSource(final LocationSource source) {
        if (source == null) {
            try {
                this.zzaFp.setLocationSource(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setLocationSource(new com.google.android.gms.maps.internal.ILocationSourceDelegate.zza() {
                public void activate(final com.google.android.gms.maps.internal.zzh listener) {
                    source.activate(new OnLocationChangedListener() {
                        public void onLocationChanged(Location location) {
                            try {
                                listener.zzc(location);
                            } catch (RemoteException e) {
                                throw new RuntimeRemoteException(e);
                            }
                        }
                    });
                }

                public void deactivate() {
                    source.deactivate();
                }
            });
        }
    }

    public final void setMapType(int type) {
        try {
            this.zzaFp.setMapType(type);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setMyLocationEnabled(boolean enabled) {
        try {
            this.zzaFp.setMyLocationEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnCameraChangeListener(final OnCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnCameraChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnCameraChangeListener(new com.google.android.gms.maps.internal.zze.zza() {
                public void onCameraChange(CameraPosition position) {
                    listener.onCameraChange(position);
                }
            });
        }
    }

    public final void setOnIndoorStateChangeListener(final OnIndoorStateChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnIndoorStateChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnIndoorStateChangeListener(new com.google.android.gms.maps.internal.zzf.zza() {
                public void onIndoorBuildingFocused() {
                    listener.onIndoorBuildingFocused();
                }

                public void zza(zzd zzd) {
                    listener.onIndoorLevelActivated(new IndoorBuilding(zzd));
                }
            });
        }
    }

    public final void setOnInfoWindowClickListener(final OnInfoWindowClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnInfoWindowClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnInfoWindowClickListener(new com.google.android.gms.maps.internal.zzg.zza() {
                public void zze(zzf zzf) {
                    listener.onInfoWindowClick(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnMapClickListener(final OnMapClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMapClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMapClickListener(new com.google.android.gms.maps.internal.zzi.zza() {
                public void onMapClick(LatLng point) {
                    listener.onMapClick(point);
                }
            });
        }
    }

    public void setOnMapLoadedCallback(final OnMapLoadedCallback callback) {
        if (callback == null) {
            try {
                this.zzaFp.setOnMapLoadedCallback(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMapLoadedCallback(new com.google.android.gms.maps.internal.zzj.zza() {
                public void onMapLoaded() throws RemoteException {
                    callback.onMapLoaded();
                }
            });
        }
    }

    public final void setOnMapLongClickListener(final OnMapLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMapLongClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMapLongClickListener(new com.google.android.gms.maps.internal.zzk.zza() {
                public void onMapLongClick(LatLng point) {
                    listener.onMapLongClick(point);
                }
            });
        }
    }

    public final void setOnMarkerClickListener(final OnMarkerClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMarkerClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMarkerClickListener(new com.google.android.gms.maps.internal.zzm.zza() {
                public boolean zza(zzf zzf) {
                    return listener.onMarkerClick(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnMarkerDragListener(final OnMarkerDragListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMarkerDragListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMarkerDragListener(new com.google.android.gms.maps.internal.zzn.zza() {
                public void zzb(zzf zzf) {
                    listener.onMarkerDragStart(new Marker(zzf));
                }

                public void zzc(zzf zzf) {
                    listener.onMarkerDragEnd(new Marker(zzf));
                }

                public void zzd(zzf zzf) {
                    listener.onMarkerDrag(new Marker(zzf));
                }
            });
        }
    }

    public final void setOnMyLocationButtonClickListener(final OnMyLocationButtonClickListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMyLocationButtonClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMyLocationButtonClickListener(new com.google.android.gms.maps.internal.zzo.zza() {
                public boolean onMyLocationButtonClick() throws RemoteException {
                    return listener.onMyLocationButtonClick();
                }
            });
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(final OnMyLocationChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaFp.setOnMyLocationChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaFp.setOnMyLocationChangeListener(new com.google.android.gms.maps.internal.zzp.zza() {
                public void zzq(com.google.android.gms.dynamic.zzd zzd) {
                    listener.onMyLocationChange((Location) zze.zzp(zzd));
                }
            });
        }
    }

    public final void setPadding(int left, int top, int right, int bottom) {
        try {
            this.zzaFp.setPadding(left, top, right, bottom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setTrafficEnabled(boolean enabled) {
        try {
            this.zzaFp.setTrafficEnabled(enabled);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void snapshot(SnapshotReadyCallback callback) {
        snapshot(callback, null);
    }

    public final void snapshot(final SnapshotReadyCallback callback, Bitmap bitmap) {
        try {
            this.zzaFp.snapshot(new com.google.android.gms.maps.internal.zzw.zza() {
                public void onSnapshotReady(Bitmap snapshot) throws RemoteException {
                    callback.onSnapshotReady(snapshot);
                }

                public void zzr(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
                    callback.onSnapshotReady((Bitmap) zze.zzp(zzd));
                }
            }, (zze) (bitmap != null ? zze.zzx(bitmap) : null));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void stopAnimation() {
        try {
            this.zzaFp.stopAnimation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public IGoogleMapDelegate zzwD() {
        return this.zzaFp;
    }
}
