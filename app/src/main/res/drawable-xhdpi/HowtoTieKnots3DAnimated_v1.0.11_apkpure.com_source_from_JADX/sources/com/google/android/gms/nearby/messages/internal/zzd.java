package com.google.android.gms.nearby.messages.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.nearby.messages.internal.zzd$zza$zza reason: collision with other inner class name */
        private static class C1529zza implements zzd {
            private IBinder zznI;

            C1529zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(GetPermissionStatusRequest getPermissionStatusRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (getPermissionStatusRequest != null) {
                        obtain.writeInt(1);
                        getPermissionStatusRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PublishRequest publishRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (publishRequest != null) {
                        obtain.writeInt(1);
                        publishRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SubscribeRequest subscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (subscribeRequest != null) {
                        obtain.writeInt(1);
                        subscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(UnpublishRequest unpublishRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (unpublishRequest != null) {
                        obtain.writeInt(1);
                        unpublishRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    if (unsubscribeRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzee(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
                    obtain.writeString(str);
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdj(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C1529zza(iBinder) : (zzd) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest] */
        /* JADX WARNING: type inference failed for: r0v9, types: [com.google.android.gms.nearby.messages.internal.UnsubscribeRequest] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.nearby.messages.internal.UnsubscribeRequest] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.nearby.messages.internal.SubscribeRequest] */
        /* JADX WARNING: type inference failed for: r0v18, types: [com.google.android.gms.nearby.messages.internal.SubscribeRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.google.android.gms.nearby.messages.internal.UnpublishRequest] */
        /* JADX WARNING: type inference failed for: r0v23, types: [com.google.android.gms.nearby.messages.internal.UnpublishRequest] */
        /* JADX WARNING: type inference failed for: r0v24, types: [com.google.android.gms.nearby.messages.internal.PublishRequest] */
        /* JADX WARNING: type inference failed for: r0v28, types: [com.google.android.gms.nearby.messages.internal.PublishRequest] */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: type inference failed for: r0v34 */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.nearby.messages.internal.UnsubscribeRequest, com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest, com.google.android.gms.nearby.messages.internal.SubscribeRequest, com.google.android.gms.nearby.messages.internal.UnpublishRequest, com.google.android.gms.nearby.messages.internal.PublishRequest]
          uses: [com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest, com.google.android.gms.nearby.messages.internal.UnsubscribeRequest, com.google.android.gms.nearby.messages.internal.SubscribeRequest, com.google.android.gms.nearby.messages.internal.UnpublishRequest, com.google.android.gms.nearby.messages.internal.PublishRequest]
          mth insns count: 62
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 6 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0029;
                    case 3: goto L_0x0041;
                    case 4: goto L_0x0059;
                    case 6: goto L_0x0071;
                    case 7: goto L_0x007f;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.PublishRequest> r0 = com.google.android.gms.nearby.messages.internal.PublishRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.PublishRequest r0 = (com.google.android.gms.nearby.messages.internal.PublishRequest) r0
            L_0x0024:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0029:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003c
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.UnpublishRequest> r0 = com.google.android.gms.nearby.messages.internal.UnpublishRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.UnpublishRequest r0 = (com.google.android.gms.nearby.messages.internal.UnpublishRequest) r0
            L_0x003c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0041:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0054
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.SubscribeRequest> r0 = com.google.android.gms.nearby.messages.internal.SubscribeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.SubscribeRequest r0 = (com.google.android.gms.nearby.messages.internal.SubscribeRequest) r0
            L_0x0054:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0059:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.UnsubscribeRequest> r0 = com.google.android.gms.nearby.messages.internal.UnsubscribeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.UnsubscribeRequest r0 = (com.google.android.gms.nearby.messages.internal.UnsubscribeRequest) r0
            L_0x006c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0071:
                java.lang.String r0 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r0)
                java.lang.String r0 = r5.readString()
                r3.zzee(r0)
                r0 = r1
                goto L_0x0009
            L_0x007f:
                java.lang.String r2 = "com.google.android.gms.nearby.messages.internal.INearbyMessagesService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0092
                android.os.Parcelable$Creator<com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest> r0 = com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest r0 = (com.google.android.gms.nearby.messages.internal.GetPermissionStatusRequest) r0
            L_0x0092:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.messages.internal.zzd.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(GetPermissionStatusRequest getPermissionStatusRequest) throws RemoteException;

    void zza(PublishRequest publishRequest) throws RemoteException;

    void zza(SubscribeRequest subscribeRequest) throws RemoteException;

    void zza(UnpublishRequest unpublishRequest) throws RemoteException;

    void zza(UnsubscribeRequest unsubscribeRequest) throws RemoteException;

    void zzee(String str) throws RemoteException;
}
