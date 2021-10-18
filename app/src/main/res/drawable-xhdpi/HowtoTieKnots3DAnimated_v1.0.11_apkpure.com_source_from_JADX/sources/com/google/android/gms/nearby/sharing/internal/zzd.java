package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.nearby.sharing.internal.zzd$zza$zza reason: collision with other inner class name */
        private static class C1534zza implements zzd {
            private IBinder zznI;

            C1534zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(ProvideContentRequest provideContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (provideContentRequest != null) {
                        obtain.writeInt(1);
                        provideContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ReceiveContentRequest receiveContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (receiveContentRequest != null) {
                        obtain.writeInt(1);
                        receiveContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (stopProvidingContentRequest != null) {
                        obtain.writeInt(1);
                        stopProvidingContentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (trustedDevicesRequest != null) {
                        obtain.writeInt(1);
                        trustedDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzc zzc) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
                    if (zzc != null) {
                        iBinder = zzc.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzd zzdo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.INearbySharingService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C1534zza(iBinder) : (zzd) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest] */
        /* JADX WARNING: type inference failed for: r0v9, types: [com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.nearby.sharing.internal.ProvideContentRequest] */
        /* JADX WARNING: type inference failed for: r0v24, types: [com.google.android.gms.nearby.sharing.internal.ProvideContentRequest] */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest, com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest, com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest, com.google.android.gms.nearby.sharing.internal.ProvideContentRequest]
          uses: [com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest, com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest, com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest, com.google.android.gms.nearby.sharing.internal.ProvideContentRequest]
          mth insns count: 53
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
        /* JADX WARNING: Unknown variable types count: 5 */
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
                    case 5: goto L_0x0071;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.nearby.sharing.internal.INearbySharingService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.nearby.sharing.internal.INearbySharingService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.nearby.sharing.internal.ProvideContentRequest> r0 = com.google.android.gms.nearby.sharing.internal.ProvideContentRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.sharing.internal.ProvideContentRequest r0 = (com.google.android.gms.nearby.sharing.internal.ProvideContentRequest) r0
            L_0x0024:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0029:
                java.lang.String r2 = "com.google.android.gms.nearby.sharing.internal.INearbySharingService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003c
                android.os.Parcelable$Creator<com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest> r0 = com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest r0 = (com.google.android.gms.nearby.sharing.internal.StopProvidingContentRequest) r0
            L_0x003c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0041:
                java.lang.String r2 = "com.google.android.gms.nearby.sharing.internal.INearbySharingService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0054
                android.os.Parcelable$Creator<com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest> r0 = com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest r0 = (com.google.android.gms.nearby.sharing.internal.TrustedDevicesRequest) r0
            L_0x0054:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0059:
                java.lang.String r2 = "com.google.android.gms.nearby.sharing.internal.INearbySharingService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest> r0 = com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest r0 = (com.google.android.gms.nearby.sharing.internal.ReceiveContentRequest) r0
            L_0x006c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0071:
                java.lang.String r0 = "com.google.android.gms.nearby.sharing.internal.INearbySharingService"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.nearby.sharing.internal.zzc r0 = com.google.android.gms.nearby.sharing.internal.zzc.zza.zzdn(r0)
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.nearby.sharing.internal.zzd.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(ProvideContentRequest provideContentRequest) throws RemoteException;

    void zza(ReceiveContentRequest receiveContentRequest) throws RemoteException;

    void zza(StopProvidingContentRequest stopProvidingContentRequest) throws RemoteException;

    void zza(TrustedDevicesRequest trustedDevicesRequest) throws RemoteException;

    void zza(zzc zzc) throws RemoteException;
}
