package com.google.android.gms.internal;

import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public class zzkl implements CastRemoteDisplayApi {
    /* access modifiers changed from: private */
    public static final zzl zzTy = new zzl("CastRemoteDisplayApiImpl");
    /* access modifiers changed from: private */
    public com.google.android.gms.common.api.Api.zzc<zzkm> zzXW;
    /* access modifiers changed from: private */
    public VirtualDisplay zzXX;
    /* access modifiers changed from: private */
    public final zzkp zzXY = new com.google.android.gms.internal.zzkp.zza() {
        public void zzaZ(int i) {
            zzkl.zzTy.zzb("onRemoteDisplayEnded", new Object[0]);
            zzkl.this.zzmP();
        }
    };

    private abstract class zza extends com.google.android.gms.internal.zzkn.zza {
        private zza() {
        }

        public void onDisconnected() throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void onError(int statusCode) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int i2, Surface surface) throws RemoteException {
            throw new UnsupportedOperationException();
        }

        public void zzmR() throws RemoteException {
            throw new UnsupportedOperationException();
        }
    }

    private abstract class zzb extends com.google.android.gms.common.api.zzc.zza<CastRemoteDisplaySessionResult, zzkm> {

        protected final class zza extends zza {
            private final zzkm zzYb;

            public zza(zzkm zzkm) {
                super();
                this.zzYb = zzkm;
            }

            private int zzj(int i, int i2) {
                if (i >= i2) {
                    i = i2;
                }
                return (i * 320) / 1080;
            }

            public void onError(int statusCode) throws RemoteException {
                zzkl.zzTy.zzb("onError: %d", Integer.valueOf(statusCode));
                zzkl.this.zzmP();
                zzb.this.zza(new zzc(Status.zzaaF));
            }

            public void zza(int i, int i2, Surface surface) {
                zzkl.zzTy.zzb("onConnected", new Object[0]);
                DisplayManager displayManager = (DisplayManager) this.zzYb.getContext().getSystemService("display");
                if (displayManager == null) {
                    zzkl.zzTy.zzc("Unable to get the display manager", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzaaF));
                    return;
                }
                zzkl.this.zzmP();
                zzkl.this.zzXX = displayManager.createVirtualDisplay("private_display", i, i2, zzj(i, i2), surface, 2);
                if (zzkl.this.zzXX == null) {
                    zzkl.zzTy.zzc("Unable to create virtual display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzaaF));
                } else if (zzkl.this.zzXX.getDisplay() == null) {
                    zzkl.zzTy.zzc("Virtual display does not have a display", new Object[0]);
                    zzb.this.zza(new zzc(Status.zzaaF));
                } else {
                    try {
                        this.zzYb.zza(this, zzkl.this.zzXX.getDisplay().getDisplayId());
                    } catch (RemoteException | IllegalStateException e) {
                        zzkl.zzTy.zzc("Unable to provision the route's new virtual Display", new Object[0]);
                        zzb.this.zza(new zzc(Status.zzaaF));
                    }
                }
            }

            public void zzmR() {
                zzkl.zzTy.zzb("onConnectedWithDisplay", new Object[0]);
                Display display = zzkl.this.zzXX.getDisplay();
                if (display != null) {
                    zzb.this.zza(new zzc(display));
                    return;
                }
                zzkl.zzTy.zzc("Virtual display no longer has a display", new Object[0]);
                zzb.this.zza(new zzc(Status.zzaaF));
            }
        }

        /* renamed from: com.google.android.gms.internal.zzkl$zzb$zzb reason: collision with other inner class name */
        protected final class C1422zzb extends zza {
            protected C1422zzb() {
                super();
            }

            public void onDisconnected() throws RemoteException {
                zzkl.zzTy.zzb("onDisconnected", new Object[0]);
                zzkl.this.zzmP();
                zzb.this.zza(new zzc(Status.zzaaD));
            }

            public void onError(int statusCode) throws RemoteException {
                zzkl.zzTy.zzb("onError: %d", Integer.valueOf(statusCode));
                zzkl.this.zzmP();
                zzb.this.zza(new zzc(Status.zzaaF));
            }
        }

        public zzb(GoogleApiClient googleApiClient) {
            super(zzkl.this.zzXW, googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzv */
        public CastRemoteDisplaySessionResult zzb(Status status) {
            return new zzc(status);
        }
    }

    private static final class zzc implements CastRemoteDisplaySessionResult {
        private final Status zzQA;
        private final Display zzTK;

        public zzc(Display display) {
            this.zzQA = Status.zzaaD;
            this.zzTK = display;
        }

        public zzc(Status status) {
            this.zzQA = status;
            this.zzTK = null;
        }

        public Display getPresentationDisplay() {
            return this.zzTK;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public zzkl(com.google.android.gms.common.api.Api.zzc<zzkm> zzc2) {
        this.zzXW = zzc2;
    }

    /* access modifiers changed from: private */
    public void zzmP() {
        if (this.zzXX != null) {
            if (this.zzXX.getDisplay() != null) {
                zzTy.zzb("releasing virtual display: " + this.zzXX.getDisplay().getDisplayId(), new Object[0]);
            }
            this.zzXX.release();
            this.zzXX = null;
        }
    }

    public PendingResult<CastRemoteDisplaySessionResult> startRemoteDisplay(GoogleApiClient apiClient, final String appId) {
        zzTy.zzb("startRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzkm zzkm) throws RemoteException {
                zzkm.zza(new zza(zzkm), zzkl.this.zzXY, appId);
            }
        });
    }

    public PendingResult<CastRemoteDisplaySessionResult> stopRemoteDisplay(GoogleApiClient apiClient) {
        zzTy.zzb("stopRemoteDisplay", new Object[0]);
        return apiClient.zzb(new zzb(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzkm zzkm) throws RemoteException {
                zzkm.zza(new C1422zzb());
            }
        });
    }
}
