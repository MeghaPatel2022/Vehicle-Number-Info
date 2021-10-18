package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface IMapViewDelegate extends IInterface {

    public static abstract class zza extends Binder implements IMapViewDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IMapViewDelegate$zza$zza reason: collision with other inner class name */
        private static class C1488zza implements IMapViewDelegate {
            private IBinder zznI;

            C1488zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public IGoogleMapDelegate getMap() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.maps.internal.IGoogleMapDelegate.zza.zzcl(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void getMapAsync(zzl callback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    obtain.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd getView() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onCreate(Bundle savedInstanceState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    if (savedInstanceState != null) {
                        obtain.writeInt(1);
                        savedInstanceState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLowMemory() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onResume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSaveInstanceState(Bundle outState) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IMapViewDelegate");
                    if (outState != null) {
                        obtain.writeInt(1);
                        outState.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        outState.readFromParcel(obtain2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IMapViewDelegate zzcp(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IMapViewDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IMapViewDelegate)) ? new C1488zza(iBinder) : (IMapViewDelegate) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v7, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v8, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v13, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v22, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v26, types: [android.os.Bundle] */
        /* JADX WARNING: type inference failed for: r0v27, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v29, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v33 */
        /* JADX WARNING: type inference failed for: r0v34 */
        /* JADX WARNING: type inference failed for: r0v35 */
        /* JADX WARNING: type inference failed for: r0v36 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.Bundle, android.os.IBinder]
          uses: [android.os.IBinder, android.os.Bundle, ?[int, boolean, OBJECT, ARRAY, byte, short, char]]
          mth insns count: 78
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
        /* JADX WARNING: Unknown variable types count: 5 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0043;
                    case 4: goto L_0x0050;
                    case 5: goto L_0x005d;
                    case 6: goto L_0x006a;
                    case 7: goto L_0x0077;
                    case 8: goto L_0x00a0;
                    case 9: goto L_0x00b8;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.maps.internal.IGoogleMapDelegate r2 = r3.getMap()
                r6.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003b
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x003b:
                r3.onCreate(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0043:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onResume()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0050:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onPause()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x005d:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onDestroy()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                r3.onLowMemory()
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0077:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x008a
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x008a:
                r3.onSaveInstanceState(r0)
                r6.writeNoException()
                if (r0 == 0) goto L_0x009b
                r6.writeInt(r1)
                r0.writeToParcel(r6, r1)
            L_0x0098:
                r0 = r1
                goto L_0x0009
            L_0x009b:
                r0 = 0
                r6.writeInt(r0)
                goto L_0x0098
            L_0x00a0:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r2)
                com.google.android.gms.dynamic.zzd r2 = r3.getView()
                r6.writeNoException()
                if (r2 == 0) goto L_0x00b2
                android.os.IBinder r0 = r2.asBinder()
            L_0x00b2:
                r6.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x00b8:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IMapViewDelegate"
                r5.enforceInterface(r0)
                android.os.IBinder r0 = r5.readStrongBinder()
                com.google.android.gms.maps.internal.zzl r0 = com.google.android.gms.maps.internal.zzl.zza.zzcx(r0)
                r3.getMapAsync(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.IMapViewDelegate.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IGoogleMapDelegate getMap() throws RemoteException;

    void getMapAsync(zzl zzl) throws RemoteException;

    zzd getView() throws RemoteException;

    void onCreate(Bundle bundle) throws RemoteException;

    void onDestroy() throws RemoteException;

    void onLowMemory() throws RemoteException;

    void onPause() throws RemoteException;

    void onResume() throws RemoteException;

    void onSaveInstanceState(Bundle bundle) throws RemoteException;
}
