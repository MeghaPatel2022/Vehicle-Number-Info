package com.google.android.gms.cast;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.p000v4.app.NotificationCompat.Builder;
import android.support.p003v7.media.MediaRouter;
import android.support.p003v7.media.MediaRouter.Callback;
import android.support.p003v7.media.MediaRouter.RouteInfo;
import android.text.TextUtils;
import android.view.Display;
import com.google.android.gms.C0224R;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplayOptions;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CastRemoteDisplayLocalService extends Service {
    /* access modifiers changed from: private */
    public static final Object zzTA = new Object();
    /* access modifiers changed from: private */
    public static AtomicBoolean zzTB = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static CastRemoteDisplayLocalService zzTP;
    /* access modifiers changed from: private */
    public static final zzl zzTy = new zzl("CastRemoteDisplayLocalService");
    private static final int zzTz = C0224R.C0226id.cast_notification_id;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private Notification mNotification;
    private String zzSX;
    private GoogleApiClient zzTC;
    private CastRemoteDisplaySessionCallbacks zzTD;
    private Callbacks zzTE;
    private zzb zzTF;
    private NotificationSettings zzTG;
    private Boolean zzTH;
    private PendingIntent zzTI;
    /* access modifiers changed from: private */
    public CastDevice zzTJ;
    /* access modifiers changed from: private */
    public Display zzTK;
    /* access modifiers changed from: private */
    public Context zzTL;
    /* access modifiers changed from: private */
    public ServiceConnection zzTM;
    private MediaRouter zzTN;
    private final Callback zzTO = new Callback() {
        public void onRouteUnselected(MediaRouter router, RouteInfo info) {
            CastRemoteDisplayLocalService.this.zzaZ("onRouteUnselected");
            if (CastRemoteDisplayLocalService.this.zzTJ == null) {
                CastRemoteDisplayLocalService.this.zzaZ("onRouteUnselected, no device was selected");
            } else if (!CastDevice.getFromBundle(info.getExtras()).getDeviceId().equals(CastRemoteDisplayLocalService.this.zzTJ.getDeviceId())) {
                CastRemoteDisplayLocalService.this.zzaZ("onRouteUnselected, device does not match");
            } else {
                CastRemoteDisplayLocalService.stopService();
            }
        }
    };
    private final IBinder zzTQ = new zza();

    public interface Callbacks {
        void onRemoteDisplaySessionError(Status status);

        void onRemoteDisplaySessionStarted(CastRemoteDisplayLocalService castRemoteDisplayLocalService);
    }

    public static final class NotificationSettings {
        /* access modifiers changed from: private */
        public Notification mNotification;
        /* access modifiers changed from: private */
        public PendingIntent zzTX;
        /* access modifiers changed from: private */
        public String zzTY;
        /* access modifiers changed from: private */
        public String zzTZ;

        public static final class Builder {
            private NotificationSettings zzUa = new NotificationSettings();

            public NotificationSettings build() {
                if (this.zzUa.mNotification != null) {
                    if (!TextUtils.isEmpty(this.zzUa.zzTY)) {
                        throw new IllegalArgumentException("notificationTitle requires using the default notification");
                    } else if (!TextUtils.isEmpty(this.zzUa.zzTZ)) {
                        throw new IllegalArgumentException("notificationText requires using the default notification");
                    } else if (this.zzUa.zzTX != null) {
                        throw new IllegalArgumentException("notificationPendingIntent requires using the default notification");
                    }
                } else if (TextUtils.isEmpty(this.zzUa.zzTY) && TextUtils.isEmpty(this.zzUa.zzTZ) && this.zzUa.zzTX == null) {
                    throw new IllegalArgumentException("At least an argument must be provided");
                }
                return this.zzUa;
            }

            public Builder setNotification(Notification notification) {
                this.zzUa.mNotification = notification;
                return this;
            }

            public Builder setNotificationPendingIntent(PendingIntent notificationPendingIntent) {
                this.zzUa.zzTX = notificationPendingIntent;
                return this;
            }

            public Builder setNotificationText(String notificationText) {
                this.zzUa.zzTZ = notificationText;
                return this;
            }

            public Builder setNotificationTitle(String notificationTitle) {
                this.zzUa.zzTY = notificationTitle;
                return this;
            }
        }

        private NotificationSettings() {
        }

        private NotificationSettings(NotificationSettings newSettings) {
            this.mNotification = newSettings.mNotification;
            this.zzTX = newSettings.zzTX;
            this.zzTY = newSettings.zzTY;
            this.zzTZ = newSettings.zzTZ;
        }
    }

    private class zza extends Binder {
        private zza() {
        }

        /* access modifiers changed from: 0000 */
        public CastRemoteDisplayLocalService zzlZ() {
            return CastRemoteDisplayLocalService.this;
        }
    }

    private static final class zzb extends BroadcastReceiver {
        private zzb() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT")) {
                CastRemoteDisplayLocalService.zzTy.zzb("disconnecting", new Object[0]);
                CastRemoteDisplayLocalService.stopService();
            }
        }
    }

    public static CastRemoteDisplayLocalService getInstance() {
        CastRemoteDisplayLocalService castRemoteDisplayLocalService;
        synchronized (zzTA) {
            castRemoteDisplayLocalService = zzTP;
        }
        return castRemoteDisplayLocalService;
    }

    protected static void setDebugEnabled() {
        zzTy.zzW(true);
    }

    public static void startService(Context activityContext, Class<? extends CastRemoteDisplayLocalService> serviceClass, String applicationId, CastDevice device, NotificationSettings notificationSettings, Callbacks callbacks) {
        zzTy.zzb("Starting Service", new Object[0]);
        synchronized (zzTA) {
            if (zzTP != null) {
                zzTy.zzf("An existing service had not been stopped before starting one", new Object[0]);
                zzQ(true);
            }
        }
        zzb(activityContext, (Class) serviceClass);
        zzx.zzb(activityContext, (Object) "activityContext is required.");
        zzx.zzb(serviceClass, (Object) "serviceClass is required.");
        zzx.zzb(applicationId, (Object) "applicationId is required.");
        zzx.zzb(device, (Object) "device is required.");
        zzx.zzb(notificationSettings, (Object) "notificationSettings is required.");
        zzx.zzb(callbacks, (Object) "callbacks is required.");
        if (notificationSettings.mNotification == null && notificationSettings.zzTX == null) {
            throw new IllegalArgumentException("notificationSettings: Either the notification or the notificationPendingIntent must be provided");
        } else if (zzTB.getAndSet(true)) {
            zzTy.zzc("Service is already being started, startService has been called twice", new Object[0]);
        } else {
            Intent intent = new Intent(activityContext, serviceClass);
            activityContext.startService(intent);
            final String str = applicationId;
            final CastDevice castDevice = device;
            final NotificationSettings notificationSettings2 = notificationSettings;
            final Context context = activityContext;
            final Callbacks callbacks2 = callbacks;
            activityContext.bindService(intent, new ServiceConnection() {
                public void onServiceConnected(ComponentName className, IBinder binder) {
                    CastRemoteDisplayLocalService zzlZ = ((zza) binder).zzlZ();
                    if (zzlZ != null) {
                        if (zzlZ.zza(str, castDevice, notificationSettings2, context, this, callbacks2)) {
                            return;
                        }
                    }
                    CastRemoteDisplayLocalService.zzTy.zzc("Connected but unable to get the service instance", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
                    CastRemoteDisplayLocalService.zzTB.set(false);
                    try {
                        context.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzTy.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }

                public void onServiceDisconnected(ComponentName arg0) {
                    CastRemoteDisplayLocalService.zzTy.zzb("onServiceDisconnected", new Object[0]);
                    callbacks2.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_DISCONNECTED, "Service Disconnected"));
                    CastRemoteDisplayLocalService.zzTB.set(false);
                    try {
                        context.unbindService(this);
                    } catch (IllegalArgumentException e) {
                        CastRemoteDisplayLocalService.zzTy.zzb("No need to unbind service, already unbound", new Object[0]);
                    }
                }
            }, 64);
        }
    }

    public static void stopService() {
        zzQ(false);
    }

    private void zzP(boolean z) {
        zzaZ("Stopping Service");
        if (!z && this.zzTN != null) {
            zzaZ("Setting default route");
            this.zzTN.selectRoute(this.zzTN.getDefaultRoute());
        }
        if (this.zzTF != null) {
            zzaZ("Unregistering notification receiver");
            unregisterReceiver(this.zzTF);
        }
        zzlS();
        zzlT();
        zzlO();
        if (this.zzTC != null) {
            this.zzTC.disconnect();
            this.zzTC = null;
        }
        if (!(this.zzTL == null || this.zzTM == null)) {
            try {
                this.zzTL.unbindService(this.zzTM);
            } catch (IllegalArgumentException e) {
                zzaZ("No need to unbind service, already unbound");
            }
            this.zzTM = null;
            this.zzTL = null;
        }
        this.zzSX = null;
        this.zzTC = null;
        this.mNotification = null;
        this.zzTK = null;
    }

    /* access modifiers changed from: private */
    public static void zzQ(boolean z) {
        zzTy.zzb("Stopping Service", new Object[0]);
        zzTB.set(false);
        synchronized (zzTA) {
            if (zzTP == null) {
                zzTy.zzc("Service is already being stopped", new Object[0]);
                return;
            }
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzTP;
            zzTP = null;
            castRemoteDisplayLocalService.zzP(z);
        }
    }

    private Notification zzR(boolean z) {
        int i;
        int i2;
        String str;
        zzaZ("createDefaultNotification");
        int i3 = getApplicationInfo().labelRes;
        String zzb2 = this.zzTG.zzTY;
        String zzc = this.zzTG.zzTZ;
        if (z) {
            i = C0224R.string.cast_notification_connected_message;
            i2 = C0224R.C0225drawable.cast_ic_notification_on;
        } else {
            i = C0224R.string.cast_notification_connecting_message;
            i2 = C0224R.C0225drawable.cast_ic_notification_connecting;
        }
        if (TextUtils.isEmpty(zzb2)) {
            zzb2 = getString(i3);
        }
        if (TextUtils.isEmpty(zzc)) {
            str = getString(i, new Object[]{this.zzTJ.getFriendlyName()});
        } else {
            str = zzc;
        }
        return new Builder(this).setContentTitle(zzb2).setContentText(str).setContentIntent(this.zzTG.zzTX).setSmallIcon(i2).setOngoing(true).addAction(17301560, getString(C0224R.string.cast_notification_disconnect), zzlU()).build();
    }

    private GoogleApiClient zza(CastDevice castDevice) {
        return new GoogleApiClient.Builder(this, new ConnectionCallbacks() {
            public void onConnected(Bundle bundle) {
                CastRemoteDisplayLocalService.this.zzaZ("onConnected");
                CastRemoteDisplayLocalService.this.zzlP();
            }

            public void onConnectionSuspended(int cause) {
                CastRemoteDisplayLocalService.zzTy.zzf(String.format("[Instance: %s] ConnectionSuspended %d", new Object[]{this, Integer.valueOf(cause)}), new Object[0]);
            }
        }, new OnConnectionFailedListener() {
            public void onConnectionFailed(ConnectionResult connectionResult) {
                CastRemoteDisplayLocalService.this.zzbc("Connection failed: " + connectionResult);
                CastRemoteDisplayLocalService.this.zzlR();
            }
        }).addApi(CastRemoteDisplay.API, new CastRemoteDisplayOptions.Builder(castDevice, this.zzTD).build()).build();
    }

    /* access modifiers changed from: private */
    public void zza(Display display) {
        this.zzTK = display;
        if (this.zzTH.booleanValue()) {
            this.mNotification = zzR(true);
            startForeground(zzTz, this.mNotification);
        }
        if (this.zzTE != null) {
            this.zzTE.onRemoteDisplaySessionStarted(this);
            this.zzTE = null;
        }
        onCreatePresentation(this.zzTK);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0088, code lost:
        if (com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zza(r7.zzTG) != null) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x008a, code lost:
        r7.zzTH = java.lang.Boolean.valueOf(true);
        r7.mNotification = zzR(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0096, code lost:
        startForeground(zzTz, r7.mNotification);
        r7.zzTC = zza(r9);
        r7.zzTC.connect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ae, code lost:
        r7.zzTH = java.lang.Boolean.valueOf(false);
        r7.mNotification = com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zza(r7.zzTG);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        r7.zzTE = r13;
        r7.zzSX = r8;
        r7.zzTJ = r9;
        r7.zzTL = r11;
        r7.zzTM = r12;
        r7.zzTN = android.support.p003v7.media.MediaRouter.getInstance(getApplicationContext());
        r2 = new android.support.p003v7.media.MediaRouteSelector.Builder().addControlCategory(com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r7.zzSX)).build();
        zzaZ("addMediaRouterCallback");
        r7.zzTN.addCallback(r2, r7.zzTO, 4);
        r7.mHandler = new android.os.Handler(getMainLooper());
        r7.mNotification = com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings.zza(r10);
        r7.zzTF = new com.google.android.gms.cast.CastRemoteDisplayLocalService.zzb(null);
        registerReceiver(r7.zzTF, new android.content.IntentFilter("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"));
        r7.zzTG = new com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings(r10, null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean zza(java.lang.String r8, com.google.android.gms.cast.CastDevice r9, com.google.android.gms.cast.CastRemoteDisplayLocalService.NotificationSettings r10, android.content.Context r11, android.content.ServiceConnection r12, com.google.android.gms.cast.CastRemoteDisplayLocalService.Callbacks r13) {
        /*
            r7 = this;
            r6 = 0
            r1 = 1
            r0 = 0
            java.lang.String r2 = "startRemoteDisplaySession"
            r7.zzaZ(r2)
            java.lang.String r2 = "Starting the Cast Remote Display must be done on the main thread"
            com.google.android.gms.common.internal.zzx.zzch(r2)
            java.lang.Object r2 = zzTA
            monitor-enter(r2)
            com.google.android.gms.cast.CastRemoteDisplayLocalService r3 = zzTP     // Catch:{ all -> 0x00ab }
            if (r3 == 0) goto L_0x0020
            com.google.android.gms.cast.internal.zzl r1 = zzTy     // Catch:{ all -> 0x00ab }
            java.lang.String r3 = "An existing service had not been stopped before starting one"
            r4 = 0
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00ab }
            r1.zzf(r3, r4)     // Catch:{ all -> 0x00ab }
            monitor-exit(r2)     // Catch:{ all -> 0x00ab }
        L_0x001f:
            return r0
        L_0x0020:
            zzTP = r7     // Catch:{ all -> 0x00ab }
            monitor-exit(r2)     // Catch:{ all -> 0x00ab }
            r7.zzTE = r13
            r7.zzSX = r8
            r7.zzTJ = r9
            r7.zzTL = r11
            r7.zzTM = r12
            android.content.Context r2 = r7.getApplicationContext()
            android.support.v7.media.MediaRouter r2 = android.support.p003v7.media.MediaRouter.getInstance(r2)
            r7.zzTN = r2
            android.support.v7.media.MediaRouteSelector$Builder r2 = new android.support.v7.media.MediaRouteSelector$Builder
            r2.<init>()
            java.lang.String r3 = r7.zzSX
            java.lang.String r3 = com.google.android.gms.cast.CastMediaControlIntent.categoryForCast(r3)
            android.support.v7.media.MediaRouteSelector$Builder r2 = r2.addControlCategory(r3)
            android.support.v7.media.MediaRouteSelector r2 = r2.build()
            java.lang.String r3 = "addMediaRouterCallback"
            r7.zzaZ(r3)
            android.support.v7.media.MediaRouter r3 = r7.zzTN
            android.support.v7.media.MediaRouter$Callback r4 = r7.zzTO
            r5 = 4
            r3.addCallback(r2, r4, r5)
            android.os.Handler r2 = new android.os.Handler
            android.os.Looper r3 = r7.getMainLooper()
            r2.<init>(r3)
            r7.mHandler = r2
            android.app.Notification r2 = r10.mNotification
            r7.mNotification = r2
            com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb
            r2.<init>()
            r7.zzTF = r2
            com.google.android.gms.cast.CastRemoteDisplayLocalService$zzb r2 = r7.zzTF
            android.content.IntentFilter r3 = new android.content.IntentFilter
            java.lang.String r4 = "com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"
            r3.<init>(r4)
            r7.registerReceiver(r2, r3)
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r2 = new com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings
            r2.<init>(r10)
            r7.zzTG = r2
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r2 = r7.zzTG
            android.app.Notification r2 = r2.mNotification
            if (r2 != 0) goto L_0x00ae
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            r7.zzTH = r2
            android.app.Notification r0 = r7.zzR(r0)
            r7.mNotification = r0
        L_0x0096:
            int r0 = zzTz
            android.app.Notification r2 = r7.mNotification
            r7.startForeground(r0, r2)
            com.google.android.gms.common.api.GoogleApiClient r0 = r7.zza(r9)
            r7.zzTC = r0
            com.google.android.gms.common.api.GoogleApiClient r0 = r7.zzTC
            r0.connect()
            r0 = r1
            goto L_0x001f
        L_0x00ab:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ab }
            throw r0
        L_0x00ae:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r7.zzTH = r0
            com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings r0 = r7.zzTG
            android.app.Notification r0 = r0.mNotification
            r7.mNotification = r0
            goto L_0x0096
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.zza(java.lang.String, com.google.android.gms.cast.CastDevice, com.google.android.gms.cast.CastRemoteDisplayLocalService$NotificationSettings, android.content.Context, android.content.ServiceConnection, com.google.android.gms.cast.CastRemoteDisplayLocalService$Callbacks):boolean");
    }

    /* access modifiers changed from: private */
    public void zzaZ(String str) {
        zzTy.zzb("[Instance: %s] %s", this, str);
    }

    private static void zzb(Context context, Class cls) {
        try {
            ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 128);
            if (serviceInfo != null && serviceInfo.exported) {
                throw new IllegalStateException("The service must not be exported, verify the manifest configuration");
            }
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("Service not found, did you forget to configure it in the manifest?");
        }
    }

    /* access modifiers changed from: private */
    public void zzbc(String str) {
        zzTy.zzc("[Instance: %s] %s", this, str);
    }

    private void zzlO() {
        if (this.zzTN != null) {
            zzx.zzch("CastRemoteDisplayLocalService calls must be done on the main thread");
            zzaZ("removeMediaRouterCallback");
            this.zzTN.removeCallback(this.zzTO);
        }
    }

    /* access modifiers changed from: private */
    public void zzlP() {
        zzaZ("startRemoteDisplay");
        if (this.zzTC == null || !this.zzTC.isConnected()) {
            zzTy.zzc("Unable to start the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.startRemoteDisplay(this.zzTC, this.zzSX).setResultCallback(new ResultCallback<CastRemoteDisplaySessionResult>() {
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
                    r0 = r6.getPresentationDisplay();
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:17:0x004e, code lost:
                    if (r0 == null) goto L_0x0086;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zza(r5.zzTR, r0);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zzlW().set(false);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
                    if (com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd(r5.zzTR) == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
                    if (com.google.android.gms.cast.CastRemoteDisplayLocalService.zze(r5.zzTR) == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zzd(r5.zzTR).unbindService(com.google.android.gms.cast.CastRemoteDisplayLocalService.zze(r5.zzTR));
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zzlV().zzc("Cast Remote Display session created without display", new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
                    com.google.android.gms.cast.CastRemoteDisplayLocalService.zzlV().zzb("No need to unbind service, already unbound", new java.lang.Object[0]);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
                    return;
                 */
                /* renamed from: zza */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onResult(com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult r6) {
                    /*
                        r5 = this;
                        r4 = 0
                        r3 = 0
                        com.google.android.gms.common.api.Status r0 = r6.getStatus()
                        boolean r0 = r0.isSuccess()
                        if (r0 != 0) goto L_0x001d
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTy
                        java.lang.String r1 = "Connection was not successful"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzc(r1, r2)
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        r0.zzlR()
                    L_0x001c:
                        return
                    L_0x001d:
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTy
                        java.lang.String r1 = "startRemoteDisplay successful"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzb(r1, r2)
                        java.lang.Object r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTA
                        monitor-enter(r1)
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTP     // Catch:{ all -> 0x0046 }
                        if (r0 != 0) goto L_0x0049
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTy     // Catch:{ all -> 0x0046 }
                        java.lang.String r2 = "Remote Display started but session already cancelled"
                        r3 = 0
                        java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x0046 }
                        r0.zzb(r2, r3)     // Catch:{ all -> 0x0046 }
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this     // Catch:{ all -> 0x0046 }
                        r0.zzlR()     // Catch:{ all -> 0x0046 }
                        monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                        goto L_0x001c
                    L_0x0046:
                        r0 = move-exception
                        monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                        throw r0
                    L_0x0049:
                        monitor-exit(r1)     // Catch:{ all -> 0x0046 }
                        android.view.Display r0 = r6.getPresentationDisplay()
                        if (r0 == 0) goto L_0x0086
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        r1.zza(r0)
                    L_0x0055:
                        java.util.concurrent.atomic.AtomicBoolean r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTB
                        r0.set(r3)
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        android.content.Context r0 = r0.zzTL
                        if (r0 == 0) goto L_0x001c
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        android.content.ServiceConnection r0 = r0.zzTM
                        if (r0 == 0) goto L_0x001c
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this     // Catch:{ IllegalArgumentException -> 0x0092 }
                        android.content.Context r0 = r0.zzTL     // Catch:{ IllegalArgumentException -> 0x0092 }
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r1 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this     // Catch:{ IllegalArgumentException -> 0x0092 }
                        android.content.ServiceConnection r1 = r1.zzTM     // Catch:{ IllegalArgumentException -> 0x0092 }
                        r0.unbindService(r1)     // Catch:{ IllegalArgumentException -> 0x0092 }
                    L_0x007b:
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        r0.zzTM = r4
                        com.google.android.gms.cast.CastRemoteDisplayLocalService r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.this
                        r0.zzTL = r4
                        goto L_0x001c
                    L_0x0086:
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTy
                        java.lang.String r1 = "Cast Remote Display session created without display"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzc(r1, r2)
                        goto L_0x0055
                    L_0x0092:
                        r0 = move-exception
                        com.google.android.gms.cast.internal.zzl r0 = com.google.android.gms.cast.CastRemoteDisplayLocalService.zzTy
                        java.lang.String r1 = "No need to unbind service, already unbound"
                        java.lang.Object[] r2 = new java.lang.Object[r3]
                        r0.zzb(r1, r2)
                        goto L_0x007b
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.CastRemoteDisplayLocalService.C03544.onResult(com.google.android.gms.cast.CastRemoteDisplay$CastRemoteDisplaySessionResult):void");
                }
            });
        }
    }

    private void zzlQ() {
        zzaZ("stopRemoteDisplay");
        if (this.zzTC == null || !this.zzTC.isConnected()) {
            zzTy.zzc("Unable to stop the remote display as the API client is not ready", new Object[0]);
        } else {
            CastRemoteDisplay.CastRemoteDisplayApi.stopRemoteDisplay(this.zzTC).setResultCallback(new ResultCallback<CastRemoteDisplaySessionResult>() {
                /* renamed from: zza */
                public void onResult(CastRemoteDisplaySessionResult castRemoteDisplaySessionResult) {
                    if (!castRemoteDisplaySessionResult.getStatus().isSuccess()) {
                        CastRemoteDisplayLocalService.this.zzaZ("Unable to stop the remote display, result unsuccessful");
                    } else {
                        CastRemoteDisplayLocalService.this.zzaZ("remote display stopped");
                    }
                    CastRemoteDisplayLocalService.this.zzTK = null;
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void zzlR() {
        if (this.zzTE != null) {
            this.zzTE.onRemoteDisplaySessionError(new Status(CastStatusCodes.ERROR_SERVICE_CREATION_FAILED));
            this.zzTE = null;
        }
        stopService();
    }

    private void zzlS() {
        zzaZ("stopRemoteDisplaySession");
        zzlQ();
        onDismissPresentation();
    }

    private void zzlT() {
        zzaZ("Stopping the remote display Service");
        stopForeground(true);
        stopSelf();
    }

    private PendingIntent zzlU() {
        if (this.zzTI == null) {
            this.zzTI = PendingIntent.getBroadcast(this, 0, new Intent("com.google.android.gms.cast.remote_display.ACTION_NOTIFICATION_DISCONNECT"), DriveFile.MODE_READ_ONLY);
        }
        return this.zzTI;
    }

    /* access modifiers changed from: protected */
    public Display getDisplay() {
        return this.zzTK;
    }

    public IBinder onBind(Intent intent) {
        zzaZ("onBind");
        return this.zzTQ;
    }

    public void onCreate() {
        super.onCreate();
        this.zzTD = new CastRemoteDisplaySessionCallbacks() {
            public void onRemoteDisplayEnded(Status status) {
                CastRemoteDisplayLocalService.zzTy.zzb(String.format("Cast screen has ended: %d", new Object[]{Integer.valueOf(status.getStatusCode())}), new Object[0]);
                if (CastRemoteDisplayLocalService.this.mHandler != null) {
                    CastRemoteDisplayLocalService.this.mHandler.post(new Runnable() {
                        public void run() {
                            CastRemoteDisplayLocalService.zzQ(false);
                        }
                    });
                }
            }
        };
    }

    public abstract void onCreatePresentation(Display display);

    public abstract void onDismissPresentation();

    public int onStartCommand(Intent intent, int flags, int startId) {
        zzaZ("onStartCommand");
        return 2;
    }

    public void updateNotificationSettings(NotificationSettings notificationSettings) {
        zzx.zzb(notificationSettings, (Object) "notificationSettings is required.");
        if (this.zzTG == null) {
            throw new IllegalStateException("No current notification settings to update");
        }
        if (!this.zzTH.booleanValue()) {
            zzx.zzb(notificationSettings.mNotification, (Object) "notification is required.");
            this.mNotification = notificationSettings.mNotification;
            this.zzTG.mNotification = this.mNotification;
        } else if (notificationSettings.mNotification != null) {
            throw new IllegalStateException("Current mode is default notification, notification attribute must not be provided");
        } else {
            if (notificationSettings.zzTX != null) {
                this.zzTG.zzTX = notificationSettings.zzTX;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzTY)) {
                this.zzTG.zzTY = notificationSettings.zzTY;
            }
            if (!TextUtils.isEmpty(notificationSettings.zzTZ)) {
                this.zzTG.zzTZ = notificationSettings.zzTZ;
            }
            this.mNotification = zzR(true);
        }
        startForeground(zzTz, this.mNotification);
    }
}
