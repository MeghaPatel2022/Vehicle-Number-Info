package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.SessionRegistrationRequest;
import com.google.android.gms.fitness.request.SessionStartRequest;
import com.google.android.gms.fitness.request.SessionStopRequest;
import com.google.android.gms.fitness.request.SessionUnregistrationRequest;

public interface zznb extends IInterface {

    public static abstract class zza extends Binder implements zznb {

        /* renamed from: com.google.android.gms.internal.zznb$zza$zza reason: collision with other inner class name */
        private static class C1439zza implements zznb {
            private IBinder zznI;

            C1439zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionInsertRequest != null) {
                        obtain.writeInt(1);
                        sessionInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionReadRequest sessionReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionReadRequest != null) {
                        obtain.writeInt(1);
                        sessionReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionRegistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionRegistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionStartRequest sessionStartRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStartRequest != null) {
                        obtain.writeInt(1);
                        sessionStartRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionStopRequest sessionStopRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionStopRequest != null) {
                        obtain.writeInt(1);
                        sessionStopRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
                    if (sessionUnregistrationRequest != null) {
                        obtain.writeInt(1);
                        sessionUnregistrationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zznb zzbD(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zznb)) ? new C1439zza(iBinder) : (zznb) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.fitness.request.SessionUnregistrationRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.fitness.request.SessionUnregistrationRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.fitness.request.SessionRegistrationRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.fitness.request.SessionRegistrationRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.fitness.request.SessionReadRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.fitness.request.SessionReadRequest] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.fitness.request.SessionInsertRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.fitness.request.SessionInsertRequest] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.fitness.request.SessionStopRequest] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.fitness.request.SessionStopRequest] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.fitness.request.SessionStartRequest] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.fitness.request.SessionStartRequest] */
        /* JADX WARNING: type inference failed for: r0v34 */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: type inference failed for: r0v37 */
        /* JADX WARNING: type inference failed for: r0v38 */
        /* JADX WARNING: type inference failed for: r0v39 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.fitness.request.SessionRegistrationRequest, com.google.android.gms.fitness.request.SessionUnregistrationRequest, com.google.android.gms.fitness.request.SessionReadRequest, com.google.android.gms.fitness.request.SessionInsertRequest, com.google.android.gms.fitness.request.SessionStopRequest, com.google.android.gms.fitness.request.SessionStartRequest]
          uses: [com.google.android.gms.fitness.request.SessionUnregistrationRequest, com.google.android.gms.fitness.request.SessionRegistrationRequest, com.google.android.gms.fitness.request.SessionReadRequest, com.google.android.gms.fitness.request.SessionInsertRequest, com.google.android.gms.fitness.request.SessionStopRequest, com.google.android.gms.fitness.request.SessionStartRequest]
          mth insns count: 67
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
        /* JADX WARNING: Unknown variable types count: 7 */
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
                    case 6: goto L_0x0089;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionStartRequest> r0 = com.google.android.gms.fitness.request.SessionStartRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.SessionStartRequest r0 = (com.google.android.gms.fitness.request.SessionStartRequest) r0
            L_0x0024:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0029:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionStopRequest> r0 = com.google.android.gms.fitness.request.SessionStopRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.SessionStopRequest r0 = (com.google.android.gms.fitness.request.SessionStopRequest) r0
            L_0x003c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0041:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0054
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionInsertRequest> r0 = com.google.android.gms.fitness.request.SessionInsertRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.SessionInsertRequest r0 = (com.google.android.gms.fitness.request.SessionInsertRequest) r0
            L_0x0054:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0059:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionReadRequest> r0 = com.google.android.gms.fitness.request.SessionReadRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.SessionReadRequest r0 = (com.google.android.gms.fitness.request.SessionReadRequest) r0
            L_0x006c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0071:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0084
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionRegistrationRequest> r0 = com.google.android.gms.fitness.request.SessionRegistrationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.SessionRegistrationRequest r0 = (com.google.android.gms.fitness.request.SessionRegistrationRequest) r0
            L_0x0084:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0089:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x009c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.SessionUnregistrationRequest> r0 = com.google.android.gms.fitness.request.SessionUnregistrationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.SessionUnregistrationRequest r0 = (com.google.android.gms.fitness.request.SessionUnregistrationRequest) r0
            L_0x009c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznb.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(SessionInsertRequest sessionInsertRequest) throws RemoteException;

    void zza(SessionReadRequest sessionReadRequest) throws RemoteException;

    void zza(SessionRegistrationRequest sessionRegistrationRequest) throws RemoteException;

    void zza(SessionStartRequest sessionStartRequest) throws RemoteException;

    void zza(SessionStopRequest sessionStopRequest) throws RemoteException;

    void zza(SessionUnregistrationRequest sessionUnregistrationRequest) throws RemoteException;
}
