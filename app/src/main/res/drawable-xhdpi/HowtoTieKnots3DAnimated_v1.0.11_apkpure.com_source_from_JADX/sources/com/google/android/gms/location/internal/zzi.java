package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzd;
import java.util.HashMap;
import java.util.Map;

public class zzi {
    private final Context mContext;
    private ContentProviderClient zzaCK = null;
    private boolean zzaCL = false;
    private Map<LocationCallback, zza> zzaCM = new HashMap();
    private final zzn<zzg> zzaCs;
    private Map<LocationListener, zzc> zzaot = new HashMap();

    private static class zza extends com.google.android.gms.location.zzc.zza {
        private Handler zzaCN;

        zza(final LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzx.zza(looper != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaCN = new Handler(looper) {
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case 0:
                            locationCallback.onLocationResult((LocationResult) msg.obj);
                            return;
                        case 1:
                            locationCallback.onLocationAvailability((LocationAvailability) msg.obj);
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        private void zzb(int i, Object obj) {
            if (this.zzaCN == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.zzaCN.sendMessage(obtain);
        }

        public void onLocationAvailability(LocationAvailability state) {
            zzb(1, state);
        }

        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public void release() {
            this.zzaCN = null;
        }
    }

    private static class zzb extends Handler {
        private final LocationListener zzaCP;

        public zzb(LocationListener locationListener) {
            this.zzaCP = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.zzaCP = locationListener;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.zzaCP.onLocationChanged(new Location((Location) msg.obj));
                    return;
                default:
                    Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                    return;
            }
        }
    }

    private static class zzc extends com.google.android.gms.location.zzd.zza {
        private Handler zzaCN;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzx.zza(Looper.myLooper() != null, (Object) "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.zzaCN = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        public void onLocationChanged(Location location) {
            if (this.zzaCN == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.zzaCN.sendMessage(obtain);
        }

        public void release() {
            this.zzaCN = null;
        }
    }

    public zzi(Context context, zzn<zzg> zzn) {
        this.mContext = context;
        this.zzaCs = zzn;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza zza2;
        synchronized (this.zzaot) {
            zza2 = (zza) this.zzaCM.get(locationCallback);
            if (zza2 == null) {
                zza2 = new zza(locationCallback, looper);
            }
            this.zzaCM.put(locationCallback, zza2);
        }
        return zza2;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc zzc2;
        synchronized (this.zzaot) {
            zzc2 = (zzc) this.zzaot.get(locationListener);
            if (zzc2 == null) {
                zzc2 = new zzc(locationListener, looper);
            }
            this.zzaot.put(locationListener, zzc2);
        }
        return zzc2;
    }

    public Location getLastLocation() {
        this.zzaCs.zzoz();
        try {
            return ((zzg) this.zzaCs.zzoA()).zzdw(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.zzaot) {
                for (zzc zzc2 : this.zzaot.values()) {
                    if (zzc2 != null) {
                        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(zzc2));
                    }
                }
                this.zzaot.clear();
                for (zza zza2 : this.zzaCM.values()) {
                    if (zza2 != null) {
                        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zza(zza2));
                    }
                }
                this.zzaCM.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zza(LocationCallback locationCallback) throws RemoteException {
        this.zzaCs.zzoz();
        zzx.zzb(locationCallback, (Object) "Invalid null callback");
        synchronized (this.zzaCM) {
            zza zza2 = (zza) this.zzaCM.remove(locationCallback);
            if (zza2 != null) {
                zza2.release();
                ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zza(zza2));
            }
        }
    }

    public void zza(LocationListener locationListener) throws RemoteException {
        this.zzaCs.zzoz();
        zzx.zzb(locationListener, (Object) "Invalid null listener");
        synchronized (this.zzaot) {
            zzc zzc2 = (zzc) this.zzaot.remove(locationListener);
            if (this.zzaCK != null && this.zzaot.isEmpty()) {
                this.zzaCK.release();
                this.zzaCK = null;
            }
            if (zzc2 != null) {
                zzc2.release();
                ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(zzc2));
            }
        }
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(LocationRequestInternal.zzb(locationRequest), (zzd) zza(locationListener, looper)));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zza(locationRequestInternal, zza(locationCallback, looper)));
    }

    public void zzag(boolean z) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zzag(z);
        this.zzaCL = z;
    }

    public void zzb(Location location) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zzb(location);
    }

    public void zzb(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzb(LocationRequestInternal.zzb(locationRequest), pendingIntent));
    }

    public void zzf(PendingIntent pendingIntent) throws RemoteException {
        this.zzaCs.zzoz();
        ((zzg) this.zzaCs.zzoA()).zza(LocationRequestUpdateData.zzg(pendingIntent));
    }

    public LocationAvailability zzvQ() {
        this.zzaCs.zzoz();
        try {
            return ((zzg) this.zzaCs.zzoA()).zzdx(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzvR() {
        if (this.zzaCL) {
            try {
                zzag(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
