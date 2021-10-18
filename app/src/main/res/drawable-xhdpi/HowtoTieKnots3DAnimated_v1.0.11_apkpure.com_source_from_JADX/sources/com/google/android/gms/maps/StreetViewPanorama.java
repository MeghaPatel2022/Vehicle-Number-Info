package com.google.android.gms.maps;

import android.graphics.Point;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzr.zza;
import com.google.android.gms.maps.internal.zzs;
import com.google.android.gms.maps.internal.zzt;
import com.google.android.gms.maps.internal.zzu;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public class StreetViewPanorama {
    private final IStreetViewPanoramaDelegate zzaGj;

    public interface OnStreetViewPanoramaCameraChangeListener {
        void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera streetViewPanoramaCamera);
    }

    public interface OnStreetViewPanoramaChangeListener {
        void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation);
    }

    public interface OnStreetViewPanoramaClickListener {
        void onStreetViewPanoramaClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    public interface OnStreetViewPanoramaLongClickListener {
        void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation streetViewPanoramaOrientation);
    }

    protected StreetViewPanorama(IStreetViewPanoramaDelegate sv) {
        this.zzaGj = (IStreetViewPanoramaDelegate) zzx.zzv(sv);
    }

    public void animateTo(StreetViewPanoramaCamera camera, long duration) {
        try {
            this.zzaGj.animateTo(camera, duration);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaLocation getLocation() {
        try {
            return this.zzaGj.getStreetViewPanoramaLocation();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaCamera getPanoramaCamera() {
        try {
            return this.zzaGj.getPanoramaCamera();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isPanningGesturesEnabled() {
        try {
            return this.zzaGj.isPanningGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isStreetNamesEnabled() {
        try {
            return this.zzaGj.isStreetNamesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isUserNavigationEnabled() {
        try {
            return this.zzaGj.isUserNavigationEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public boolean isZoomGesturesEnabled() {
        try {
            return this.zzaGj.isZoomGesturesEnabled();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public Point orientationToPoint(StreetViewPanoramaOrientation orientation) {
        try {
            zzd orientationToPoint = this.zzaGj.orientationToPoint(orientation);
            if (orientationToPoint == null) {
                return null;
            }
            return (Point) zze.zzp(orientationToPoint);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public StreetViewPanoramaOrientation pointToOrientation(Point point) {
        try {
            return this.zzaGj.pointToOrientation(zze.zzx(point));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void setOnStreetViewPanoramaCameraChangeListener(final OnStreetViewPanoramaCameraChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaCameraChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaGj.setOnStreetViewPanoramaCameraChangeListener(new zza() {
                public void onStreetViewPanoramaCameraChange(StreetViewPanoramaCamera camera) {
                    listener.onStreetViewPanoramaCameraChange(camera);
                }
            });
        }
    }

    public final void setOnStreetViewPanoramaChangeListener(final OnStreetViewPanoramaChangeListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaChangeListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaGj.setOnStreetViewPanoramaChangeListener(new zzs.zza() {
                public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
                    listener.onStreetViewPanoramaChange(location);
                }
            });
        }
    }

    public final void setOnStreetViewPanoramaClickListener(final OnStreetViewPanoramaClickListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaGj.setOnStreetViewPanoramaClickListener(new zzt.zza() {
                public void onStreetViewPanoramaClick(StreetViewPanoramaOrientation orientation) {
                    listener.onStreetViewPanoramaClick(orientation);
                }
            });
        }
    }

    public final void setOnStreetViewPanoramaLongClickListener(final OnStreetViewPanoramaLongClickListener listener) {
        if (listener == null) {
            try {
                this.zzaGj.setOnStreetViewPanoramaLongClickListener(null);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        } else {
            this.zzaGj.setOnStreetViewPanoramaLongClickListener(new zzu.zza() {
                public void onStreetViewPanoramaLongClick(StreetViewPanoramaOrientation orientation) {
                    listener.onStreetViewPanoramaLongClick(orientation);
                }
            });
        }
    }

    public void setPanningGesturesEnabled(boolean enablePanning) {
        try {
            this.zzaGj.enablePanning(enablePanning);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position) {
        try {
            this.zzaGj.setPosition(position);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(LatLng position, int radius) {
        try {
            this.zzaGj.setPositionWithRadius(position, radius);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setPosition(String panoId) {
        try {
            this.zzaGj.setPositionWithID(panoId);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setStreetNamesEnabled(boolean enableStreetNames) {
        try {
            this.zzaGj.enableStreetNames(enableStreetNames);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setUserNavigationEnabled(boolean enableUserNavigation) {
        try {
            this.zzaGj.enableUserNavigation(enableUserNavigation);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void setZoomGesturesEnabled(boolean enableZoom) {
        try {
            this.zzaGj.enableZoom(enableZoom);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public IStreetViewPanoramaDelegate zzwR() {
        return this.zzaGj;
    }
}
