package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.Cast.ApplicationConnectionResult;
import com.google.android.gms.cast.Cast.Listener;
import com.google.android.gms.cast.Cast.MessageReceivedCallback;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zze extends zzj<zzi> {
    /* access modifiers changed from: private */
    public static final zzl zzTy = new zzl("CastClientImpl");
    /* access modifiers changed from: private */
    public static final Object zzXf = new Object();
    /* access modifiers changed from: private */
    public static final Object zzXg = new Object();
    /* access modifiers changed from: private */
    public final Listener zzTk;
    private double zzUJ;
    private boolean zzUK;
    /* access modifiers changed from: private */
    public ApplicationMetadata zzWN;
    /* access modifiers changed from: private */
    public final CastDevice zzWO;
    /* access modifiers changed from: private */
    public final Map<String, MessageReceivedCallback> zzWP = new HashMap();
    private final long zzWQ;
    private zzb zzWR;
    private String zzWS;
    private boolean zzWT;
    private boolean zzWU;
    private boolean zzWV;
    private int zzWW;
    private int zzWX;
    private final AtomicLong zzWY = new AtomicLong(0);
    /* access modifiers changed from: private */
    public String zzWZ;
    /* access modifiers changed from: private */
    public String zzXa;
    private Bundle zzXb;
    /* access modifiers changed from: private */
    public final Map<Long, com.google.android.gms.common.api.zzc.zzb<Status>> zzXc = new HashMap();
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> zzXd;
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.zzc.zzb<Status> zzXe;

    private static final class zza implements ApplicationConnectionResult {
        private final String zzGY;
        private final Status zzQA;
        private final ApplicationMetadata zzXh;
        private final String zzXi;
        private final boolean zzXj;

        public zza(Status status) {
            this(status, null, null, null, false);
        }

        public zza(Status status, ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            this.zzQA = status;
            this.zzXh = applicationMetadata;
            this.zzXi = str;
            this.zzGY = str2;
            this.zzXj = z;
        }

        public ApplicationMetadata getApplicationMetadata() {
            return this.zzXh;
        }

        public String getApplicationStatus() {
            return this.zzXi;
        }

        public String getSessionId() {
            return this.zzGY;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public boolean getWasLaunched() {
            return this.zzXj;
        }
    }

    private static class zzb extends com.google.android.gms.cast.internal.zzj.zza {
        private final Handler mHandler;
        private final AtomicReference<zze> zzXk;

        public zzb(zze zze) {
            this.zzXk = new AtomicReference<>(zze);
            this.mHandler = new Handler(zze.getLooper());
        }

        private void zza(zze zze, long j, int i) {
            com.google.android.gms.common.api.zzc.zzb zzb;
            synchronized (zze.zzXc) {
                zzb = (com.google.android.gms.common.api.zzc.zzb) zze.zzXc.remove(Long.valueOf(j));
            }
            if (zzb != null) {
                zzb.zzn(new Status(i));
            }
        }

        private boolean zza(zze zze, int i) {
            synchronized (zze.zzXg) {
                if (zze.zzXe == null) {
                    return false;
                }
                zze.zzXe.zzn(new Status(i));
                zze.zzXe = null;
                return true;
            }
        }

        public boolean isDisposed() {
            return this.zzXk.get() == null;
        }

        public void onApplicationDisconnected(final int statusCode) {
            final zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zze.zzWZ = null;
                zze.zzXa = null;
                zza(zze, statusCode);
                if (zze.zzTk != null) {
                    this.mHandler.post(new Runnable() {
                        public void run() {
                            if (zze.zzTk != null) {
                                zze.zzTk.onApplicationDisconnected(statusCode);
                            }
                        }
                    });
                }
            }
        }

        public void zza(ApplicationMetadata applicationMetadata, String str, String str2, boolean z) {
            zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zze.zzWN = applicationMetadata;
                zze.zzWZ = applicationMetadata.getApplicationId();
                zze.zzXa = str2;
                synchronized (zze.zzXf) {
                    if (zze.zzXd != null) {
                        zze.zzXd.zzn(new zza(new Status(0), applicationMetadata, str, str2, z));
                        zze.zzXd = null;
                    }
                }
            }
        }

        public void zza(String str, double d, boolean z) {
            zze.zzTy.zzb("Deprecated callback: \"onStatusreceived\"", new Object[0]);
        }

        public void zza(String str, long j, int i) {
            zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zza(zze, j, i);
            }
        }

        public void zzaU(int i) {
            zze zzmG = zzmG();
            if (zzmG != null) {
                zze.zzTy.zzb("ICastDeviceControllerListener.onDisconnected: %d", Integer.valueOf(i));
                if (i != 0) {
                    zzmG.zzbz(2);
                }
            }
        }

        public void zzaV(int i) {
            zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                synchronized (zze.zzXf) {
                    if (zze.zzXd != null) {
                        zze.zzXd.zzn(new zza(new Status(i)));
                        zze.zzXd = null;
                    }
                }
            }
        }

        public void zzaW(int i) {
            zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zza(zze, i);
            }
        }

        public void zzaX(int i) {
            zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zza(zze, i);
            }
        }

        public void zzb(final ApplicationStatus applicationStatus) {
            final zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zze.zzTy.zzb("onApplicationStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable() {
                    public void run() {
                        zze.zza(applicationStatus);
                    }
                });
            }
        }

        public void zzb(final DeviceStatus deviceStatus) {
            final zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zze.zzTy.zzb("onDeviceStatusChanged", new Object[0]);
                this.mHandler.post(new Runnable() {
                    public void run() {
                        zze.zza(deviceStatus);
                    }
                });
            }
        }

        public void zzb(String str, byte[] bArr) {
            if (((zze) this.zzXk.get()) != null) {
                zze.zzTy.zzb("IGNORING: Receive (type=binary, ns=%s) <%d bytes>", str, Integer.valueOf(bArr.length));
            }
        }

        public void zzd(String str, long j) {
            zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zza(zze, j, 0);
            }
        }

        public zze zzmG() {
            zze zze = (zze) this.zzXk.getAndSet(null);
            if (zze == null) {
                return null;
            }
            zze.zzmv();
            return zze;
        }

        public void zzs(final String str, final String str2) {
            final zze zze = (zze) this.zzXk.get();
            if (zze != null) {
                zze.zzTy.zzb("Receive (type=text, ns=%s) %s", str, str2);
                this.mHandler.post(new Runnable() {
                    public void run() {
                        MessageReceivedCallback messageReceivedCallback;
                        synchronized (zze.zzWP) {
                            messageReceivedCallback = (MessageReceivedCallback) zze.zzWP.get(str);
                        }
                        if (messageReceivedCallback != null) {
                            messageReceivedCallback.onMessageReceived(zze.zzWO, str, str2);
                            return;
                        }
                        zze.zzTy.zzb("Discarded message for unknown namespace '%s'", str);
                    }
                });
            }
        }
    }

    public zze(Context context, Looper looper, zzf zzf, CastDevice castDevice, long j, Listener listener, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 10, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzWO = castDevice;
        this.zzTk = listener;
        this.zzWQ = j;
        zzmv();
    }

    /* access modifiers changed from: private */
    public void zza(ApplicationStatus applicationStatus) {
        boolean z;
        String zzms = applicationStatus.zzms();
        if (!zzf.zza(zzms, this.zzWS)) {
            this.zzWS = zzms;
            z = true;
        } else {
            z = false;
        }
        zzTy.zzb("hasChanged=%b, mFirstApplicationStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzWT));
        if (this.zzTk != null && (z || this.zzWT)) {
            this.zzTk.onApplicationStatusChanged();
        }
        this.zzWT = false;
    }

    /* access modifiers changed from: private */
    public void zza(DeviceStatus deviceStatus) {
        boolean z;
        boolean z2;
        boolean z3;
        ApplicationMetadata applicationMetadata = deviceStatus.getApplicationMetadata();
        if (!zzf.zza(applicationMetadata, this.zzWN)) {
            this.zzWN = applicationMetadata;
            this.zzTk.onApplicationMetadataChanged(this.zzWN);
        }
        double zzmy = deviceStatus.zzmy();
        if (zzmy == Double.NaN || Math.abs(zzmy - this.zzUJ) <= 1.0E-7d) {
            z = false;
        } else {
            this.zzUJ = zzmy;
            z = true;
        }
        boolean zzmH = deviceStatus.zzmH();
        if (zzmH != this.zzUK) {
            this.zzUK = zzmH;
            z = true;
        }
        zzTy.zzb("hasVolumeChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z), Boolean.valueOf(this.zzWU));
        if (this.zzTk != null && (z || this.zzWU)) {
            this.zzTk.onVolumeChanged();
        }
        int zzmz = deviceStatus.zzmz();
        if (zzmz != this.zzWW) {
            this.zzWW = zzmz;
            z2 = true;
        } else {
            z2 = false;
        }
        zzTy.zzb("hasActiveInputChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z2), Boolean.valueOf(this.zzWU));
        if (this.zzTk != null && (z2 || this.zzWU)) {
            this.zzTk.onActiveInputStateChanged(this.zzWW);
        }
        int zzmA = deviceStatus.zzmA();
        if (zzmA != this.zzWX) {
            this.zzWX = zzmA;
            z3 = true;
        } else {
            z3 = false;
        }
        zzTy.zzb("hasStandbyStateChanged=%b, mFirstDeviceStatusUpdate=%b", Boolean.valueOf(z3), Boolean.valueOf(this.zzWU));
        if (this.zzTk != null && (z3 || this.zzWU)) {
            this.zzTk.onStandbyStateChanged(this.zzWX);
        }
        this.zzWU = false;
    }

    private void zzc(com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> zzb2) {
        synchronized (zzXf) {
            if (this.zzXd != null) {
                this.zzXd.zzn(new zza(new Status(2002)));
            }
            this.zzXd = zzb2;
        }
    }

    private void zze(com.google.android.gms.common.api.zzc.zzb<Status> zzb2) {
        synchronized (zzXg) {
            if (this.zzXe != null) {
                zzb2.zzn(new Status(2001));
            } else {
                this.zzXe = zzb2;
            }
        }
    }

    private void zzmB() {
        zzTy.zzb("removing all MessageReceivedCallbacks", new Object[0]);
        synchronized (this.zzWP) {
            this.zzWP.clear();
        }
    }

    private void zzmC() throws IllegalStateException {
        if (!this.zzWV || this.zzWR == null || this.zzWR.isDisposed()) {
            throw new IllegalStateException("Not connected to a device");
        }
    }

    /* access modifiers changed from: private */
    public void zzmv() {
        this.zzWV = false;
        this.zzWW = -1;
        this.zzWX = -1;
        this.zzWN = null;
        this.zzWS = null;
        this.zzUJ = 0.0d;
        this.zzUK = false;
    }

    public void disconnect() {
        zzTy.zzb("disconnect(); ServiceListener=%s, isConnected=%b", this.zzWR, Boolean.valueOf(isConnected()));
        zzb zzb2 = this.zzWR;
        this.zzWR = null;
        if (zzb2 == null || zzb2.zzmG() == null) {
            zzTy.zzb("already disposed, so short-circuiting", new Object[0]);
            return;
        }
        zzmB();
        try {
            if (isConnected() || isConnecting()) {
                ((zzi) zzoA()).disconnect();
            }
        } catch (RemoteException e) {
            zzTy.zzb(e, "Error while disconnecting the controller interface: %s", e.getMessage());
        } finally {
            super.disconnect();
        }
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        zzmC();
        return this.zzWN;
    }

    public String getApplicationStatus() throws IllegalStateException {
        zzmC();
        return this.zzWS;
    }

    public boolean isMute() throws IllegalStateException {
        zzmC();
        return this.zzUK;
    }

    public void onConnectionFailed(ConnectionResult result) {
        super.onConnectionFailed(result);
        zzmB();
    }

    public void zzV(boolean z) throws IllegalStateException, RemoteException {
        ((zzi) zzoA()).zza(z, this.zzUJ, this.zzUK);
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        zzTy.zzb("in onPostInitHandler; statusCode=%d", Integer.valueOf(i));
        if (i == 0 || i == 1001) {
            this.zzWV = true;
            this.zzWT = true;
            this.zzWU = true;
        } else {
            this.zzWV = false;
        }
        if (i == 1001) {
            this.zzXb = new Bundle();
            this.zzXb.putBoolean(Cast.EXTRA_APP_NO_LONGER_RUNNING, true);
            i = 0;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(String str, MessageReceivedCallback messageReceivedCallback) throws IllegalArgumentException, IllegalStateException, RemoteException {
        zzf.zzbL(str);
        zzbK(str);
        if (messageReceivedCallback != null) {
            synchronized (this.zzWP) {
                this.zzWP.put(str, messageReceivedCallback);
            }
            ((zzi) zzoA()).zzbP(str);
        }
    }

    public void zza(String str, LaunchOptions launchOptions, com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> zzb2) throws IllegalStateException, RemoteException {
        zzc(zzb2);
        ((zzi) zzoA()).zza(str, launchOptions);
    }

    public void zza(String str, com.google.android.gms.common.api.zzc.zzb<Status> zzb2) throws IllegalStateException, RemoteException {
        zze(zzb2);
        ((zzi) zzoA()).zzbO(str);
    }

    public void zza(String str, String str2, com.google.android.gms.common.api.zzc.zzb<Status> zzb2) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("The message payload cannot be null or empty");
        } else if (str2.length() > 65536) {
            throw new IllegalArgumentException("Message exceeds maximum size");
        } else {
            zzf.zzbL(str);
            zzmC();
            long incrementAndGet = this.zzWY.incrementAndGet();
            try {
                this.zzXc.put(Long.valueOf(incrementAndGet), zzb2);
                ((zzi) zzoA()).zza(str, str2, incrementAndGet);
            } catch (Throwable th) {
                this.zzXc.remove(Long.valueOf(incrementAndGet));
                throw th;
            }
        }
    }

    public void zza(String str, boolean z, com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> zzb2) throws IllegalStateException, RemoteException {
        zzc(zzb2);
        ((zzi) zzoA()).zzf(str, z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaA */
    public zzi zzV(IBinder iBinder) {
        return com.google.android.gms.cast.internal.zzi.zza.zzaB(iBinder);
    }

    public void zzb(String str, String str2, com.google.android.gms.common.api.zzc.zzb<ApplicationConnectionResult> zzb2) throws IllegalStateException, RemoteException {
        zzc(zzb2);
        ((zzi) zzoA()).zzt(str, str2);
    }

    public void zzbK(String str) throws IllegalArgumentException, RemoteException {
        MessageReceivedCallback messageReceivedCallback;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Channel namespace cannot be null or empty");
        }
        synchronized (this.zzWP) {
            messageReceivedCallback = (MessageReceivedCallback) this.zzWP.remove(str);
        }
        if (messageReceivedCallback != null) {
            try {
                ((zzi) zzoA()).zzbQ(str);
            } catch (IllegalStateException e) {
                zzTy.zzb(e, "Error unregistering namespace (%s): %s", str, e.getMessage());
            }
        }
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb<Status> zzb2) throws IllegalStateException, RemoteException {
        zze(zzb2);
        ((zzi) zzoA()).zzmI();
    }

    public void zze(double d) throws IllegalArgumentException, IllegalStateException, RemoteException {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            throw new IllegalArgumentException("Volume cannot be " + d);
        }
        ((zzi) zzoA()).zza(d, this.zzUJ, this.zzUK);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        Bundle bundle = new Bundle();
        zzTy.zzb("getRemoteService(): mLastApplicationId=%s, mLastSessionId=%s", this.zzWZ, this.zzXa);
        this.zzWO.putInBundle(bundle);
        bundle.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzWQ);
        this.zzWR = new zzb(this);
        bundle.putParcelable("listener", new BinderWrapper(this.zzWR.asBinder()));
        if (this.zzWZ != null) {
            bundle.putString("last_application_id", this.zzWZ);
            if (this.zzXa != null) {
                bundle.putString("last_session_id", this.zzXa);
            }
        }
        return bundle;
    }

    public int zzmA() throws IllegalStateException {
        zzmC();
        return this.zzWX;
    }

    public Bundle zzmw() {
        if (this.zzXb == null) {
            return super.zzmw();
        }
        Bundle bundle = this.zzXb;
        this.zzXb = null;
        return bundle;
    }

    public void zzmx() throws IllegalStateException, RemoteException {
        ((zzi) zzoA()).zzmx();
    }

    public double zzmy() throws IllegalStateException {
        zzmC();
        return this.zzUJ;
    }

    public int zzmz() throws IllegalStateException {
        zzmC();
        return this.zzWW;
    }
}
