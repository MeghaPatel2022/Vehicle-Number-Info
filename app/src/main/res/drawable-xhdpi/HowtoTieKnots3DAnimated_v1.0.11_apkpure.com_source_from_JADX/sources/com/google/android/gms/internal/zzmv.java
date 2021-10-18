package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

public interface zzmv extends IInterface {

    public static abstract class zza extends Binder implements zzmv {

        /* renamed from: com.google.android.gms.internal.zzmv$zza$zza reason: collision with other inner class name */
        private static class C1433zza implements zzmv {
            private IBinder zznI;

            C1433zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(ClaimBleDeviceRequest claimBleDeviceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (claimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        claimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (listClaimedBleDevicesRequest != null) {
                        obtain.writeInt(1);
                        listClaimedBleDevicesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(StartBleScanRequest startBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (startBleScanRequest != null) {
                        obtain.writeInt(1);
                        startBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(StopBleScanRequest stopBleScanRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (stopBleScanRequest != null) {
                        obtain.writeInt(1);
                        stopBleScanRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
                    if (unclaimBleDeviceRequest != null) {
                        obtain.writeInt(1);
                        unclaimBleDeviceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzmv zzbx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmv)) ? new C1433zza(iBinder) : (zzmv) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.fitness.request.UnclaimBleDeviceRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.fitness.request.UnclaimBleDeviceRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.fitness.request.ClaimBleDeviceRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.fitness.request.ClaimBleDeviceRequest] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.fitness.request.StopBleScanRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.fitness.request.StopBleScanRequest] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.fitness.request.StartBleScanRequest] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.fitness.request.StartBleScanRequest] */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: type inference failed for: r0v30 */
        /* JADX WARNING: type inference failed for: r0v31 */
        /* JADX WARNING: type inference failed for: r0v32 */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.fitness.request.UnclaimBleDeviceRequest, com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest, com.google.android.gms.fitness.request.ClaimBleDeviceRequest, com.google.android.gms.fitness.request.StopBleScanRequest, com.google.android.gms.fitness.request.StartBleScanRequest]
          uses: [com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest, com.google.android.gms.fitness.request.UnclaimBleDeviceRequest, com.google.android.gms.fitness.request.ClaimBleDeviceRequest, com.google.android.gms.fitness.request.StopBleScanRequest, com.google.android.gms.fitness.request.StartBleScanRequest]
          mth insns count: 57
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
                    case 5: goto L_0x0071;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitBleApi"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitBleApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.StartBleScanRequest> r0 = com.google.android.gms.fitness.request.StartBleScanRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.StartBleScanRequest r0 = (com.google.android.gms.fitness.request.StartBleScanRequest) r0
            L_0x0024:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0029:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitBleApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.StopBleScanRequest> r0 = com.google.android.gms.fitness.request.StopBleScanRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.StopBleScanRequest r0 = (com.google.android.gms.fitness.request.StopBleScanRequest) r0
            L_0x003c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0041:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitBleApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0054
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ClaimBleDeviceRequest> r0 = com.google.android.gms.fitness.request.ClaimBleDeviceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.ClaimBleDeviceRequest r0 = (com.google.android.gms.fitness.request.ClaimBleDeviceRequest) r0
            L_0x0054:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0059:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitBleApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.UnclaimBleDeviceRequest> r0 = com.google.android.gms.fitness.request.UnclaimBleDeviceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.UnclaimBleDeviceRequest r0 = (com.google.android.gms.fitness.request.UnclaimBleDeviceRequest) r0
            L_0x006c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0071:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitBleApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0084
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest> r0 = com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest r0 = (com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest) r0
            L_0x0084:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmv.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(ClaimBleDeviceRequest claimBleDeviceRequest) throws RemoteException;

    void zza(ListClaimedBleDevicesRequest listClaimedBleDevicesRequest) throws RemoteException;

    void zza(StartBleScanRequest startBleScanRequest) throws RemoteException;

    void zza(StopBleScanRequest stopBleScanRequest) throws RemoteException;

    void zza(UnclaimBleDeviceRequest unclaimBleDeviceRequest) throws RemoteException;
}
