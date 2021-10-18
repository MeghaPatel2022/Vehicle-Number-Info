package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import java.util.List;

public abstract class WearableListenerService extends Service implements CapabilityListener, ChannelListener, DataListener, MessageListener, NodeListener, com.google.android.gms.wearable.NodeApi.zza {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    /* access modifiers changed from: private */
    public boolean zzLA;
    /* access modifiers changed from: private */
    public String zzOZ;
    /* access modifiers changed from: private */
    public Handler zzaZc;
    /* access modifiers changed from: private */
    public Object zzaZd = new Object();
    private volatile int zzacB = -1;
    private IBinder zzacE;

    private class zza extends com.google.android.gms.wearable.internal.zzav.zza {
        boolean zzaZe = false;

        zza() {
            this.zzaZe = WearableListenerService.this instanceof zzj;
        }

        public void onConnectedNodes(final List<NodeParcelable> connectedNodes) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onConnectedNodes: " + WearableListenerService.this.zzOZ + ": " + connectedNodes);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (!WearableListenerService.this.zzLA) {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onConnectedNodes(connectedNodes);
                        }
                    });
                }
            }
        }

        public void zza(final AmsEntityUpdateParcelable amsEntityUpdateParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onEntityUpdate: " + amsEntityUpdateParcelable);
            }
            if (this.zzaZe) {
                WearableListenerService.this.zzCs();
                final zzj zzj = (zzj) WearableListenerService.this;
                synchronized (WearableListenerService.this.zzaZd) {
                    if (!WearableListenerService.this.zzLA) {
                        WearableListenerService.this.zzaZc.post(new Runnable() {
                            public void run() {
                                zzj.zza((zzb) amsEntityUpdateParcelable);
                            }
                        });
                    }
                }
            }
        }

        public void zza(final AncsNotificationParcelable ancsNotificationParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onNotificationReceived: " + ancsNotificationParcelable);
            }
            if (this.zzaZe) {
                WearableListenerService.this.zzCs();
                final zzj zzj = (zzj) WearableListenerService.this;
                synchronized (WearableListenerService.this.zzaZd) {
                    if (!WearableListenerService.this.zzLA) {
                        WearableListenerService.this.zzaZc.post(new Runnable() {
                            public void run() {
                                zzj.zza((zzd) ancsNotificationParcelable);
                            }
                        });
                    }
                }
            }
        }

        public void zza(final CapabilityInfoParcelable capabilityInfoParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onConnectedCapabilityChanged: " + capabilityInfoParcelable);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (!WearableListenerService.this.zzLA) {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onCapabilityChanged(capabilityInfoParcelable);
                        }
                    });
                }
            }
        }

        public void zza(final ChannelEventParcelable channelEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onChannelEvent: " + channelEventParcelable);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (!WearableListenerService.this.zzLA) {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            channelEventParcelable.zza(WearableListenerService.this);
                        }
                    });
                }
            }
        }

        public void zza(final MessageEventParcelable messageEventParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onMessageReceived: " + messageEventParcelable);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (!WearableListenerService.this.zzLA) {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onMessageReceived(messageEventParcelable);
                        }
                    });
                }
            }
        }

        public void zza(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerConnected: " + WearableListenerService.this.zzOZ + ": " + nodeParcelable);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (!WearableListenerService.this.zzLA) {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onPeerConnected(nodeParcelable);
                        }
                    });
                }
            }
        }

        public void zzad(final DataHolder dataHolder) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onDataItemChanged: " + WearableListenerService.this.zzOZ + ": " + dataHolder);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (WearableListenerService.this.zzLA) {
                    dataHolder.close();
                } else {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            DataEventBuffer dataEventBuffer = new DataEventBuffer(dataHolder);
                            try {
                                WearableListenerService.this.onDataChanged(dataEventBuffer);
                            } finally {
                                dataEventBuffer.release();
                            }
                        }
                    });
                }
            }
        }

        public void zzb(final NodeParcelable nodeParcelable) {
            if (Log.isLoggable("WearableLS", 3)) {
                Log.d("WearableLS", "onPeerDisconnected: " + WearableListenerService.this.zzOZ + ": " + nodeParcelable);
            }
            WearableListenerService.this.zzCs();
            synchronized (WearableListenerService.this.zzaZd) {
                if (!WearableListenerService.this.zzLA) {
                    WearableListenerService.this.zzaZc.post(new Runnable() {
                        public void run() {
                            WearableListenerService.this.onPeerDisconnected(nodeParcelable);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void zzCs() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        if (callingUid != this.zzacB) {
            if (GooglePlayServicesUtil.zze(this, callingUid)) {
                this.zzacB = callingUid;
                return;
            }
            throw new SecurityException("Caller is not GooglePlayServices");
        }
    }

    public final IBinder onBind(Intent intent) {
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            return this.zzacE;
        }
        return null;
    }

    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    public void onChannelClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onChannelOpened(Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        super.onCreate();
        if (Log.isLoggable("WearableLS", 3)) {
            Log.d("WearableLS", "onCreate: " + getPackageName());
        }
        this.zzOZ = getPackageName();
        HandlerThread handlerThread = new HandlerThread("WearableListenerService");
        handlerThread.start();
        this.zzaZc = new Handler(handlerThread.getLooper());
        this.zzacE = new zza();
    }

    public void onDataChanged(DataEventBuffer dataEvents) {
    }

    public void onDestroy() {
        synchronized (this.zzaZd) {
            this.zzLA = true;
            if (this.zzaZc == null) {
                throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
            }
            this.zzaZc.getLooper().quit();
        }
        super.onDestroy();
    }

    public void onInputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onOutputClosed(Channel channel, int closeReason, int appSpecificErrorCode) {
    }

    public void onPeerConnected(Node peer) {
    }

    public void onPeerDisconnected(Node peer) {
    }
}
