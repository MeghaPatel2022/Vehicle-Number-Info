package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

final class zzax<T> {
    private final Map<T, zzbo<T>> zzaot = new HashMap();

    private static class zza<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbo<T>>> zzbaD;
        private WeakReference<T> zzbaE;

        zza(Map<T, zzbo<T>> map, T t, com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
            this.zzbaD = new WeakReference<>(map);
            this.zzbaE = new WeakReference<>(t);
        }

        public void zzc(Status status) {
            Map map = (Map) this.zzbaD.get();
            Object obj = this.zzbaE.get();
            if (!(status.getStatus().isSuccess() || map == null || obj == null)) {
                synchronized (map) {
                    zzbo zzbo = (zzbo) map.remove(obj);
                    if (zzbo != null) {
                        zzbo.clear();
                    }
                }
            }
            zzR(status);
        }
    }

    private static class zzb<T> extends zzb<Status> {
        private WeakReference<Map<T, zzbo<T>>> zzbaD;
        private WeakReference<T> zzbaE;

        zzb(Map<T, zzbo<T>> map, T t, com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
            this.zzbaD = new WeakReference<>(map);
            this.zzbaE = new WeakReference<>(t);
        }

        public void zzc(Status status) {
            Map map = (Map) this.zzbaD.get();
            Object obj = this.zzbaE.get();
            if (!(status.getStatus().getStatusCode() != 4002 || map == null || obj == null)) {
                synchronized (map) {
                    zzbo zzbo = (zzbo) map.remove(obj);
                    if (zzbo != null) {
                        zzbo.clear();
                    }
                }
            }
            zzR(status);
        }
    }

    zzax() {
    }

    public boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.zzaot) {
            isEmpty = this.zzaot.isEmpty();
        }
        return isEmpty;
    }

    public void zza(zzbn zzbn, com.google.android.gms.common.api.zzc.zzb<Status> zzb2, T t) throws RemoteException {
        synchronized (this.zzaot) {
            zzbo zzbo = (zzbo) this.zzaot.remove(t);
            if (zzbo == null) {
                zzb2.zzn(new Status(4002));
                return;
            }
            zzbo.clear();
            ((zzaw) zzbn.zzoA()).zza((zzau) new zzb(this.zzaot, t, zzb2), new RemoveListenerRequest(zzbo));
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.wearable.internal.zzbn r5, com.google.android.gms.common.api.zzc.zzb<com.google.android.gms.common.api.Status> r6, T r7, com.google.android.gms.wearable.internal.zzbo<T> r8) throws android.os.RemoteException {
        /*
            r4 = this;
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbo<T>> r1 = r4.zzaot
            monitor-enter(r1)
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbo<T>> r0 = r4.zzaot     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r0.get(r7)     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0033 }
            r2 = 4001(0xfa1, float:5.607E-42)
            r0.<init>(r2)     // Catch:{ all -> 0x0033 }
            r6.zzn(r0)     // Catch:{ all -> 0x0033 }
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
        L_0x0016:
            return
        L_0x0017:
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbo<T>> r0 = r4.zzaot     // Catch:{ all -> 0x0033 }
            r0.put(r7, r8)     // Catch:{ all -> 0x0033 }
            android.os.IInterface r0 = r5.zzoA()     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.wearable.internal.zzaw r0 = (com.google.android.gms.wearable.internal.zzaw) r0     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.wearable.internal.zzax$zza r2 = new com.google.android.gms.wearable.internal.zzax$zza     // Catch:{ RemoteException -> 0x0036 }
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbo<T>> r3 = r4.zzaot     // Catch:{ RemoteException -> 0x0036 }
            r2.<init>(r3, r7, r6)     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.wearable.internal.AddListenerRequest r3 = new com.google.android.gms.wearable.internal.AddListenerRequest     // Catch:{ RemoteException -> 0x0036 }
            r3.<init>(r8)     // Catch:{ RemoteException -> 0x0036 }
            r0.zza(r2, r3)     // Catch:{ RemoteException -> 0x0036 }
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0016
        L_0x0033:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0033 }
            throw r0
        L_0x0036:
            r0 = move-exception
            java.util.Map<T, com.google.android.gms.wearable.internal.zzbo<T>> r2 = r4.zzaot     // Catch:{ all -> 0x0033 }
            r2.remove(r7)     // Catch:{ all -> 0x0033 }
            throw r0     // Catch:{ all -> 0x0033 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzax.zza(com.google.android.gms.wearable.internal.zzbn, com.google.android.gms.common.api.zzc$zzb, java.lang.Object, com.google.android.gms.wearable.internal.zzbo):void");
    }

    public void zzb(zzbn zzbn) {
        synchronized (this.zzaot) {
            zzo zzo = new zzo();
            for (Entry entry : this.zzaot.entrySet()) {
                zzbo zzbo = (zzbo) entry.getValue();
                if (zzbo != null) {
                    zzbo.clear();
                    if (zzbn.isConnected()) {
                        try {
                            ((zzaw) zzbn.zzoA()).zza((zzau) zzo, new RemoveListenerRequest(zzbo));
                            if (Log.isLoggable("WearableClient", 2)) {
                                Log.d("WearableClient", "disconnect: removed: " + entry.getKey() + "/" + zzbo);
                            }
                        } catch (RemoteException e) {
                            Log.w("WearableClient", "disconnect: Didn't remove: " + entry.getKey() + "/" + zzbo);
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.zzaot.clear();
        }
    }

    public void zzeb(IBinder iBinder) {
        synchronized (this.zzaot) {
            zzaw zzea = com.google.android.gms.wearable.internal.zzaw.zza.zzea(iBinder);
            zzo zzo = new zzo();
            for (Entry entry : this.zzaot.entrySet()) {
                zzbo zzbo = (zzbo) entry.getValue();
                try {
                    zzea.zza((zzau) zzo, new AddListenerRequest(zzbo));
                    if (Log.isLoggable("WearableClient", 2)) {
                        Log.d("WearableClient", "onPostInitHandler: added: " + entry.getKey() + "/" + zzbo);
                    }
                } catch (RemoteException e) {
                    Log.d("WearableClient", "onPostInitHandler: Didn't add: " + entry.getKey() + "/" + zzbo);
                }
            }
        }
    }
}
