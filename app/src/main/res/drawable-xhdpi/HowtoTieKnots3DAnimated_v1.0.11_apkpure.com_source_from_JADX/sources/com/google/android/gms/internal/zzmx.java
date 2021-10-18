package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.GetSyncInfoRequest;
import com.google.android.gms.fitness.request.ReadRawRequest;
import com.google.android.gms.fitness.request.ReadStatsRequest;

public interface zzmx extends IInterface {

    public static abstract class zza extends Binder implements zzmx {

        /* renamed from: com.google.android.gms.internal.zzmx$zza$zza reason: collision with other inner class name */
        private static class C1435zza implements zzmx {
            private IBinder zznI;

            C1435zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(DailyTotalRequest dailyTotalRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dailyTotalRequest != null) {
                        obtain.writeInt(1);
                        dailyTotalRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataDeleteRequest != null) {
                        obtain.writeInt(1);
                        dataDeleteRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataInsertRequest dataInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(DataReadRequest dataReadRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataReadRequest != null) {
                        obtain.writeInt(1);
                        dataReadRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(GetSyncInfoRequest getSyncInfoRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (getSyncInfoRequest != null) {
                        obtain.writeInt(1);
                        getSyncInfoRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ReadRawRequest readRawRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readRawRequest != null) {
                        obtain.writeInt(1);
                        readRawRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ReadStatsRequest readStatsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (readStatsRequest != null) {
                        obtain.writeInt(1);
                        readStatsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(DataInsertRequest dataInsertRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                    if (dataInsertRequest != null) {
                        obtain.writeInt(1);
                        dataInsertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzmx zzbz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzmx)) ? new C1435zza(iBinder) : (zzmx) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.fitness.request.DataInsertRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.fitness.request.DataInsertRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.fitness.request.DailyTotalRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.fitness.request.DailyTotalRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.fitness.request.ReadRawRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.fitness.request.ReadRawRequest] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.fitness.request.ReadStatsRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.fitness.request.ReadStatsRequest] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.fitness.request.GetSyncInfoRequest] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.fitness.request.GetSyncInfoRequest] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.fitness.request.DataDeleteRequest] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.fitness.request.DataDeleteRequest] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.google.android.gms.fitness.request.DataInsertRequest] */
        /* JADX WARNING: type inference failed for: r0v35, types: [com.google.android.gms.fitness.request.DataInsertRequest] */
        /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.fitness.request.DataReadRequest] */
        /* JADX WARNING: type inference failed for: r0v40, types: [com.google.android.gms.fitness.request.DataReadRequest] */
        /* JADX WARNING: type inference failed for: r0v44 */
        /* JADX WARNING: type inference failed for: r0v45 */
        /* JADX WARNING: type inference failed for: r0v46 */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: type inference failed for: r0v49 */
        /* JADX WARNING: type inference failed for: r0v50 */
        /* JADX WARNING: type inference failed for: r0v51 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.fitness.request.DailyTotalRequest, com.google.android.gms.fitness.request.DataInsertRequest, com.google.android.gms.fitness.request.ReadRawRequest, com.google.android.gms.fitness.request.ReadStatsRequest, com.google.android.gms.fitness.request.GetSyncInfoRequest, com.google.android.gms.fitness.request.DataDeleteRequest, com.google.android.gms.fitness.request.DataReadRequest]
          uses: [com.google.android.gms.fitness.request.DataInsertRequest, com.google.android.gms.fitness.request.DailyTotalRequest, com.google.android.gms.fitness.request.ReadRawRequest, com.google.android.gms.fitness.request.ReadStatsRequest, com.google.android.gms.fitness.request.GetSyncInfoRequest, com.google.android.gms.fitness.request.DataDeleteRequest, com.google.android.gms.fitness.request.DataReadRequest]
          mth insns count: 87
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
                    case 2: goto L_0x0029;
                    case 3: goto L_0x0041;
                    case 4: goto L_0x0059;
                    case 5: goto L_0x0071;
                    case 6: goto L_0x0089;
                    case 7: goto L_0x00a2;
                    case 8: goto L_0x00bb;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataReadRequest> r0 = com.google.android.gms.fitness.request.DataReadRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.DataReadRequest r0 = (com.google.android.gms.fitness.request.DataReadRequest) r0
            L_0x0024:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0029:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataInsertRequest> r0 = com.google.android.gms.fitness.request.DataInsertRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.DataInsertRequest r0 = (com.google.android.gms.fitness.request.DataInsertRequest) r0
            L_0x003c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0041:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0054
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataDeleteRequest> r0 = com.google.android.gms.fitness.request.DataDeleteRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.DataDeleteRequest r0 = (com.google.android.gms.fitness.request.DataDeleteRequest) r0
            L_0x0054:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0059:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.GetSyncInfoRequest> r0 = com.google.android.gms.fitness.request.GetSyncInfoRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.GetSyncInfoRequest r0 = (com.google.android.gms.fitness.request.GetSyncInfoRequest) r0
            L_0x006c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0071:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0084
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ReadStatsRequest> r0 = com.google.android.gms.fitness.request.ReadStatsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.ReadStatsRequest r0 = (com.google.android.gms.fitness.request.ReadStatsRequest) r0
            L_0x0084:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0089:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x009c
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.ReadRawRequest> r0 = com.google.android.gms.fitness.request.ReadRawRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.ReadRawRequest r0 = (com.google.android.gms.fitness.request.ReadRawRequest) r0
            L_0x009c:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x00a2:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00b5
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DailyTotalRequest> r0 = com.google.android.gms.fitness.request.DailyTotalRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.DailyTotalRequest r0 = (com.google.android.gms.fitness.request.DailyTotalRequest) r0
            L_0x00b5:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x00bb:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00ce
                android.os.Parcelable$Creator<com.google.android.gms.fitness.request.DataInsertRequest> r0 = com.google.android.gms.fitness.request.DataInsertRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.request.DataInsertRequest r0 = (com.google.android.gms.fitness.request.DataInsertRequest) r0
            L_0x00ce:
                r3.zzb(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzmx.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(DailyTotalRequest dailyTotalRequest) throws RemoteException;

    void zza(DataDeleteRequest dataDeleteRequest) throws RemoteException;

    void zza(DataInsertRequest dataInsertRequest) throws RemoteException;

    void zza(DataReadRequest dataReadRequest) throws RemoteException;

    void zza(GetSyncInfoRequest getSyncInfoRequest) throws RemoteException;

    void zza(ReadRawRequest readRawRequest) throws RemoteException;

    void zza(ReadStatsRequest readStatsRequest) throws RemoteException;

    void zzb(DataInsertRequest dataInsertRequest) throws RemoteException;
}
