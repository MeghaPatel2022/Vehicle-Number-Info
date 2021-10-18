package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzcu;
import com.google.android.gms.internal.zzcv;
import com.google.android.gms.internal.zzcw;

public interface zzp extends IInterface {

    public static abstract class zza extends Binder implements zzp {

        /* renamed from: com.google.android.gms.ads.internal.client.zzp$zza$zza reason: collision with other inner class name */
        private static class C1323zza implements zzp {
            private IBinder zznI;

            C1323zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzct zzct) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzct != null ? zzct.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzcu zzcu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzcu != null ? zzcu.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzcw zzcw, zzcv zzcv) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzcw != null ? zzcw.asBinder() : null);
                    if (zzcv != null) {
                        iBinder = zzcv.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzo zzbk() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.ads.internal.client.zzo.zza.zzh(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
        }

        public static zzp zzi(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzp)) ? new C1323zza(iBinder) : (zzp) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel] */
        /* JADX WARNING: type inference failed for: r0v20, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v22, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v26 */
        /* JADX WARNING: type inference failed for: r0v27 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.IBinder, com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel]
          uses: [com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel, android.os.IBinder]
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
        /* JADX WARNING: Unknown variable types count: 3 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x003d;
                    case 4: goto L_0x0052;
                    case 5: goto L_0x0067;
                    case 6: goto L_0x0088;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r5, r6, r7, r8)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r7.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                com.google.android.gms.ads.internal.client.zzo r2 = r4.zzbk()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0023
                android.os.IBinder r0 = r2.asBinder()
            L_0x0023:
                r7.writeStrongBinder(r0)
                r0 = r1
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.ads.internal.client.zzn r0 = com.google.android.gms.ads.internal.client.zzn.zza.zzg(r0)
                r4.zzb(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x003d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzct r0 = com.google.android.gms.internal.zzct.zza.zzz(r0)
                r4.zza(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0052:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.internal.zzcu r0 = com.google.android.gms.internal.zzcu.zza.zzA(r0)
                r4.zza(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0067:
                java.lang.String r0 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.internal.zzcw r2 = com.google.android.gms.internal.zzcw.zza.zzC(r2)
                android.os.IBinder r3 = r6.readStrongBinder()
                com.google.android.gms.internal.zzcv r3 = com.google.android.gms.internal.zzcv.zza.zzB(r3)
                r4.zza(r0, r2, r3)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0088:
                java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0099
                com.google.android.gms.ads.internal.formats.zzi r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r0 = r0.createFromParcel(r6)
            L_0x0099:
                r4.zza(r0)
                r7.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzp.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(NativeAdOptionsParcel nativeAdOptionsParcel) throws RemoteException;

    void zza(zzct zzct) throws RemoteException;

    void zza(zzcu zzcu) throws RemoteException;

    void zza(String str, zzcw zzcw, zzcv zzcv) throws RemoteException;

    void zzb(zzn zzn) throws RemoteException;

    zzo zzbk() throws RemoteException;
}
