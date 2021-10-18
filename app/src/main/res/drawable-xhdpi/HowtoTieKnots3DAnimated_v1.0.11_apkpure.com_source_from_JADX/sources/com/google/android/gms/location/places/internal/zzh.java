package com.google.android.gms.location.places.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzh extends IInterface {

    public static abstract class zza extends Binder implements zzh {

        /* renamed from: com.google.android.gms.location.places.internal.zzh$zza$zza reason: collision with other inner class name */
        private static class C1481zza implements zzh {
            private IBinder zznI;

            C1481zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zzZ(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzaO(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzaa(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzab(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzac(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
        }

        public static zzh zzcg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IPlacesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzh)) ? new C1481zza(iBinder) : (zzh) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.common.api.Status] */
        /* JADX WARNING: type inference failed for: r0v9, types: [com.google.android.gms.common.api.Status] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v17, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v18, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v25 */
        /* JADX WARNING: type inference failed for: r0v26 */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: type inference failed for: r0v28 */
        /* JADX WARNING: type inference failed for: r0v29 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.common.api.Status, com.google.android.gms.common.data.DataHolder]
          uses: [com.google.android.gms.common.data.DataHolder, com.google.android.gms.common.api.Status]
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
                    case 2: goto L_0x0027;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x0053;
                    case 5: goto L_0x006b;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.location.places.internal.IPlacesCallbacks"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.location.places.internal.IPlacesCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0022
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x0022:
                r3.zzZ(r0)
                r0 = r1
                goto L_0x0009
            L_0x0027:
                java.lang.String r2 = "com.google.android.gms.location.places.internal.IPlacesCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0038
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x0038:
                r3.zzaa(r0)
                r0 = r1
                goto L_0x0009
            L_0x003d:
                java.lang.String r2 = "com.google.android.gms.location.places.internal.IPlacesCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x004e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x004e:
                r3.zzab(r0)
                r0 = r1
                goto L_0x0009
            L_0x0053:
                java.lang.String r2 = "com.google.android.gms.location.places.internal.IPlacesCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0066
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            L_0x0066:
                r3.zzaO(r0)
                r0 = r1
                goto L_0x0009
            L_0x006b:
                java.lang.String r2 = "com.google.android.gms.location.places.internal.IPlacesCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x007c
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x007c:
                r3.zzac(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.places.internal.zzh.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zzZ(DataHolder dataHolder) throws RemoteException;

    void zzaO(Status status) throws RemoteException;

    void zzaa(DataHolder dataHolder) throws RemoteException;

    void zzab(DataHolder dataHolder) throws RemoteException;

    void zzac(DataHolder dataHolder) throws RemoteException;
}
