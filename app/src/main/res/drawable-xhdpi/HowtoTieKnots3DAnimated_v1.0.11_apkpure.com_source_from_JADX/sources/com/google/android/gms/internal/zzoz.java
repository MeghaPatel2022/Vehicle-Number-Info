package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.request.ConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest;
import com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.DisconnectRequest;
import com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest;
import com.google.android.gms.nearby.bootstrap.request.SendDataRequest;
import com.google.android.gms.nearby.bootstrap.request.StartScanRequest;
import com.google.android.gms.nearby.bootstrap.request.StopScanRequest;

public interface zzoz extends IInterface {

    public static abstract class zza extends Binder implements zzoz {

        /* renamed from: com.google.android.gms.internal.zzoz$zza$zza reason: collision with other inner class name */
        private static class C1454zza implements zzoz {
            private IBinder zznI;

            C1454zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public String getToken() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzoy zzoy) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (zzoy != null) {
                        iBinder = zzoy.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ConnectRequest connectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (connectRequest != null) {
                        obtain.writeInt(1);
                        connectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (continueConnectRequest != null) {
                        obtain.writeInt(1);
                        continueConnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DisableTargetRequest disableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disableTargetRequest != null) {
                        obtain.writeInt(1);
                        disableTargetRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(EnableTargetRequest enableTargetRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (enableTargetRequest != null) {
                        obtain.writeInt(1);
                        enableTargetRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SendDataRequest sendDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (sendDataRequest != null) {
                        obtain.writeInt(1);
                        sendDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(StartScanRequest startScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (startScanRequest != null) {
                        obtain.writeInt(1);
                        startScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(StopScanRequest stopScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
                    if (stopScanRequest != null) {
                        obtain.writeInt(1);
                        stopScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzoz zzdc(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzoz)) ? new C1454zza(iBinder) : (zzoz) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v8, types: [com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest] */
        /* JADX WARNING: type inference failed for: r0v12, types: [com.google.android.gms.nearby.bootstrap.request.SendDataRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.nearby.bootstrap.request.SendDataRequest] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.nearby.bootstrap.request.DisconnectRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.google.android.gms.nearby.bootstrap.request.DisconnectRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.nearby.bootstrap.request.ConnectRequest] */
        /* JADX WARNING: type inference failed for: r0v23, types: [com.google.android.gms.nearby.bootstrap.request.ConnectRequest] */
        /* JADX WARNING: type inference failed for: r0v24, types: [com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest] */
        /* JADX WARNING: type inference failed for: r0v27, types: [com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest] */
        /* JADX WARNING: type inference failed for: r0v28, types: [com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest] */
        /* JADX WARNING: type inference failed for: r0v32, types: [com.google.android.gms.nearby.bootstrap.request.StopScanRequest] */
        /* JADX WARNING: type inference failed for: r0v35, types: [com.google.android.gms.nearby.bootstrap.request.StopScanRequest] */
        /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.nearby.bootstrap.request.StartScanRequest] */
        /* JADX WARNING: type inference failed for: r0v39, types: [com.google.android.gms.nearby.bootstrap.request.StartScanRequest] */
        /* JADX WARNING: type inference failed for: r0v43 */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: type inference failed for: r0v45 */
        /* JADX WARNING: type inference failed for: r0v46 */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: type inference failed for: r0v49 */
        /* JADX WARNING: type inference failed for: r0v50 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.nearby.bootstrap.request.SendDataRequest, com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest, com.google.android.gms.nearby.bootstrap.request.DisconnectRequest, com.google.android.gms.nearby.bootstrap.request.ConnectRequest, com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest, com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest, com.google.android.gms.nearby.bootstrap.request.StopScanRequest, com.google.android.gms.nearby.bootstrap.request.StartScanRequest]
          uses: [com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest, com.google.android.gms.nearby.bootstrap.request.SendDataRequest, com.google.android.gms.nearby.bootstrap.request.DisconnectRequest, com.google.android.gms.nearby.bootstrap.request.ConnectRequest, com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest, com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest, com.google.android.gms.nearby.bootstrap.request.StopScanRequest, com.google.android.gms.nearby.bootstrap.request.StartScanRequest]
          mth insns count: 91
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 9 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x0053;
                    case 5: goto L_0x0069;
                    case 6: goto L_0x007f;
                    case 7: goto L_0x0096;
                    case 8: goto L_0x00ad;
                    case 9: goto L_0x00c4;
                    case 10: goto L_0x00d6;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0022
                com.google.android.gms.nearby.bootstrap.request.zzg r0 = com.google.android.gms.nearby.bootstrap.request.StartScanRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.StartScanRequest r0 = r0.createFromParcel(r5)
            L_0x0022:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0027:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0038
                com.google.android.gms.nearby.bootstrap.request.zzh r0 = com.google.android.gms.nearby.bootstrap.request.StopScanRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.StopScanRequest r0 = r0.createFromParcel(r5)
            L_0x0038:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x003d:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x004e
                com.google.android.gms.nearby.bootstrap.request.zze r0 = com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.EnableTargetRequest r0 = r0.createFromParcel(r5)
            L_0x004e:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0053:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0064
                com.google.android.gms.nearby.bootstrap.request.zzc r0 = com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.DisableTargetRequest r0 = r0.createFromParcel(r5)
            L_0x0064:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0069:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x007a
                com.google.android.gms.nearby.bootstrap.request.zza r0 = com.google.android.gms.nearby.bootstrap.request.ConnectRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.ConnectRequest r0 = r0.createFromParcel(r5)
            L_0x007a:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x007f:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0090
                com.google.android.gms.nearby.bootstrap.request.zzd r0 = com.google.android.gms.nearby.bootstrap.request.DisconnectRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.DisconnectRequest r0 = r0.createFromParcel(r5)
            L_0x0090:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0096:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00a7
                com.google.android.gms.nearby.bootstrap.request.zzf r0 = com.google.android.gms.nearby.bootstrap.request.SendDataRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.SendDataRequest r0 = r0.createFromParcel(r5)
            L_0x00a7:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x00ad:
                java.lang.String r2 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00be
                com.google.android.gms.nearby.bootstrap.request.zzb r0 = com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest.CREATOR
                com.google.android.gms.nearby.bootstrap.request.ContinueConnectRequest r0 = r0.createFromParcel(r5)
            L_0x00be:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x00c4:
                java.lang.String r0 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r0)
                java.lang.String r0 = r3.getToken()
                r6.writeNoException()
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x00d6:
                java.lang.String r0 = "com.google.android.gms.nearby.bootstrap.internal.INearbyBootstrapService"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.internal.zzoy r0 = com.google.android.gms.internal.zzoy.zza.zzdb(r0)
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzoz.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    String getToken() throws RemoteException;

    void zza(zzoy zzoy) throws RemoteException;

    void zza(ConnectRequest connectRequest) throws RemoteException;

    void zza(ContinueConnectRequest continueConnectRequest) throws RemoteException;

    void zza(DisableTargetRequest disableTargetRequest) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(EnableTargetRequest enableTargetRequest) throws RemoteException;

    void zza(SendDataRequest sendDataRequest) throws RemoteException;

    void zza(StartScanRequest startScanRequest) throws RemoteException;

    void zza(StopScanRequest stopScanRequest) throws RemoteException;
}
