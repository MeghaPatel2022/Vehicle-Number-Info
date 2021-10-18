package com.google.android.gms.location;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.location.zzc$zza$zza reason: collision with other inner class name */
        private static class C1482zza implements zzc {
            private IBinder zznI;

            C1482zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void onLocationAvailability(LocationAvailability state) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (state != null) {
                        obtain.writeInt(1);
                        state.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void onLocationResult(LocationResult result) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.ILocationCallback");
                    if (result != null) {
                        obtain.writeInt(1);
                        result.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.location.ILocationCallback");
        }

        public static zzc zzbW(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C1482zza(iBinder) : (zzc) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.location.LocationAvailability] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.location.LocationAvailability] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.location.LocationResult] */
        /* JADX WARNING: type inference failed for: r0v9, types: [com.google.android.gms.location.LocationResult] */
        /* JADX WARNING: type inference failed for: r0v13 */
        /* JADX WARNING: type inference failed for: r0v14 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.location.LocationResult, com.google.android.gms.location.LocationAvailability]
          uses: [com.google.android.gms.location.LocationAvailability, com.google.android.gms.location.LocationResult]
          mth insns count: 26
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
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0029;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.location.ILocationCallback"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.location.ILocationCallback"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.location.LocationResult> r0 = com.google.android.gms.location.LocationResult.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.location.LocationResult r0 = (com.google.android.gms.location.LocationResult) r0
            L_0x0024:
                r3.onLocationResult(r0)
                r0 = r1
                goto L_0x0009
            L_0x0029:
                java.lang.String r2 = "com.google.android.gms.location.ILocationCallback"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003a
                com.google.android.gms.location.LocationAvailabilityCreator r0 = com.google.android.gms.location.LocationAvailability.CREATOR
                com.google.android.gms.location.LocationAvailability r0 = r0.createFromParcel(r5)
            L_0x003a:
                r3.onLocationAvailability(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onLocationAvailability(LocationAvailability locationAvailability) throws RemoteException;

    void onLocationResult(LocationResult locationResult) throws RemoteException;
}
