package com.google.android.gms.drive.events;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.drive.internal.OnEventResponse;
import com.google.android.gms.drive.internal.zzy;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class DriveEventService extends Service implements ChangeListener, CompletionListener, zzc {
    public static final String ACTION_HANDLE_EVENT = "com.google.android.gms.drive.events.HANDLE_EVENT";
    private final String mName;
    int zzacB;
    /* access modifiers changed from: private */
    public CountDownLatch zzahA;
    zza zzahB;
    boolean zzahC;

    final class zza extends Handler {
        zza() {
        }

        /* access modifiers changed from: private */
        public Message zzb(OnEventResponse onEventResponse) {
            return obtainMessage(1, onEventResponse);
        }

        /* access modifiers changed from: private */
        public Message zzqz() {
            return obtainMessage(2);
        }

        public void handleMessage(Message msg) {
            zzy.zzv("DriveEventService", "handleMessage message type:" + msg.what);
            switch (msg.what) {
                case 1:
                    DriveEventService.this.zza((OnEventResponse) msg.obj);
                    return;
                case 2:
                    getLooper().quit();
                    return;
                default:
                    zzy.zzw("DriveEventService", "Unexpected message type:" + msg.what);
                    return;
            }
        }
    }

    final class zzb extends com.google.android.gms.drive.internal.zzan.zza {
        zzb() {
        }

        public void zzc(OnEventResponse onEventResponse) throws RemoteException {
            synchronized (DriveEventService.this) {
                zzy.zzv("DriveEventService", "onEvent: " + onEventResponse);
                DriveEventService.this.zzqy();
                if (DriveEventService.this.zzahB != null) {
                    DriveEventService.this.zzahB.sendMessage(DriveEventService.this.zzahB.zzb(onEventResponse));
                } else {
                    zzy.zzx("DriveEventService", "Receiving event before initialize is completed.");
                }
            }
        }
    }

    protected DriveEventService() {
        this("DriveEventService");
    }

    protected DriveEventService(String name) {
        this.zzahC = false;
        this.zzacB = -1;
        this.mName = name;
    }

    /* access modifiers changed from: private */
    public void zza(OnEventResponse onEventResponse) {
        DriveEvent zzqS = onEventResponse.zzqS();
        zzy.zzv("DriveEventService", "handleEventMessage: " + zzqS);
        try {
            switch (zzqS.getType()) {
                case 1:
                    onChange((ChangeEvent) zzqS);
                    return;
                case 2:
                    onCompletion((CompletionEvent) zzqS);
                    return;
                case 4:
                    zza((ChangesAvailableEvent) zzqS);
                    return;
                default:
                    zzy.zzw(this.mName, "Unhandled event: " + zzqS);
                    return;
            }
        } catch (Exception e) {
            zzy.zza(this.mName, e, "Error handling event: " + zzqS);
        }
        zzy.zza(this.mName, e, "Error handling event: " + zzqS);
    }

    /* access modifiers changed from: private */
    public void zzqy() throws SecurityException {
        int callingUid = getCallingUid();
        if (callingUid != this.zzacB) {
            if (GooglePlayServicesUtil.zze(this, callingUid)) {
                this.zzacB = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    /* access modifiers changed from: protected */
    public int getCallingUid() {
        return Binder.getCallingUid();
    }

    public final synchronized IBinder onBind(Intent intent) {
        IBinder iBinder;
        if (ACTION_HANDLE_EVENT.equals(intent.getAction())) {
            if (this.zzahB == null && !this.zzahC) {
                this.zzahC = true;
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                this.zzahA = new CountDownLatch(1);
                new Thread() {
                    public void run() {
                        try {
                            Looper.prepare();
                            DriveEventService.this.zzahB = new zza();
                            DriveEventService.this.zzahC = false;
                            countDownLatch.countDown();
                            zzy.zzv("DriveEventService", "Bound and starting loop");
                            Looper.loop();
                            zzy.zzv("DriveEventService", "Finished loop");
                        } finally {
                            if (DriveEventService.this.zzahA != null) {
                                DriveEventService.this.zzahA.countDown();
                            }
                        }
                    }
                }.start();
                try {
                    if (!countDownLatch.await(5000, TimeUnit.MILLISECONDS)) {
                        zzy.zzx("DriveEventService", "Failed to synchronously initialize event handler.");
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException("Unable to start event handler", e);
                }
            }
            iBinder = new zzb().asBinder();
        } else {
            iBinder = null;
        }
        return iBinder;
    }

    public void onChange(ChangeEvent event) {
        zzy.zzw(this.mName, "Unhandled change event: " + event);
    }

    public void onCompletion(CompletionEvent event) {
        zzy.zzw(this.mName, "Unhandled completion event: " + event);
    }

    public synchronized void onDestroy() {
        zzy.zzv("DriveEventService", "onDestroy");
        if (this.zzahB != null) {
            this.zzahB.sendMessage(this.zzahB.zzqz());
            this.zzahB = null;
            try {
                if (!this.zzahA.await(5000, TimeUnit.MILLISECONDS)) {
                    zzy.zzw("DriveEventService", "Failed to synchronously quit event handler. Will quit itself");
                }
            } catch (InterruptedException e) {
            }
            this.zzahA = null;
        }
        super.onDestroy();
    }

    public boolean onUnbind(Intent intent) {
        return true;
    }

    public void zza(ChangesAvailableEvent changesAvailableEvent) {
        zzy.zzw(this.mName, "Unhandled changes available event: " + changesAvailableEvent);
    }
}
