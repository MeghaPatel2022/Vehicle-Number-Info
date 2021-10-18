package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.dynamic.zzd;
import java.util.List;

public interface zzei extends IInterface {

    public static abstract class zza extends Binder implements zzei {

        /* renamed from: com.google.android.gms.internal.zzei$zza$zza reason: collision with other inner class name */
        private static class C1400zza implements zzei {
            private IBinder zznI;

            C1400zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(5, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isInitialized() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void pause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void resume() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showInterstitial() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void showVideo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AdRequestParcel adRequestParcel, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza, String str2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str2);
                    this.zznI.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzej zzej) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zzej != null) {
                        iBinder = zzej.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzej zzej) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (zzej != null) {
                        iBinder = zzej.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzej zzej, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (zzej != null) {
                        iBinder = zzej.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (nativeAdOptionsParcel != null) {
                        obtain.writeInt(1);
                        nativeAdOptionsParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzej zzej) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (zzej != null) {
                        iBinder = zzej.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzej zzej) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (adSizeParcel != null) {
                        obtain.writeInt(1);
                        adSizeParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (zzej != null) {
                        iBinder = zzej.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzek zzdS() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzek.zza.zzH(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzel zzdT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.internal.zzel.zza.zzI(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
        }

        public static zzei zzF(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzei)) ? new C1400zza(iBinder) : (zzei) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v4, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.ads.internal.client.AdRequestParcel] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.ads.internal.client.AdRequestParcel] */
        /* JADX WARNING: type inference failed for: r0v29, types: [com.google.android.gms.ads.internal.client.AdRequestParcel] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.google.android.gms.ads.internal.client.AdRequestParcel] */
        /* JADX WARNING: type inference failed for: r0v32, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v33, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r0v38 */
        /* JADX WARNING: type inference failed for: r0v39 */
        /* JADX WARNING: type inference failed for: r0v40 */
        /* JADX WARNING: type inference failed for: r0v41 */
        /* JADX WARNING: type inference failed for: r0v42 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.IBinder, com.google.android.gms.ads.internal.client.AdRequestParcel]
          uses: [android.os.IBinder, com.google.android.gms.ads.internal.client.AdRequestParcel]
          mth insns count: 194
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
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
                r9 = this;
                r0 = 0
                r8 = 1
                switch(r10) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x004d;
                    case 3: goto L_0x0063;
                    case 4: goto L_0x0090;
                    case 5: goto L_0x009d;
                    case 6: goto L_0x00aa;
                    case 7: goto L_0x00ec;
                    case 8: goto L_0x0120;
                    case 9: goto L_0x012d;
                    case 10: goto L_0x013a;
                    case 11: goto L_0x016e;
                    case 12: goto L_0x018b;
                    case 13: goto L_0x0198;
                    case 14: goto L_0x01ae;
                    case 15: goto L_0x01f4;
                    case 16: goto L_0x020b;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r8 = super.onTransact(r10, r11, r12, r13)
            L_0x0009:
                return r8
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r12.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbk(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0049
                com.google.android.gms.ads.internal.client.zzh r2 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r2.createFromParcel(r11)
            L_0x0029:
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x004b
                com.google.android.gms.ads.internal.client.zzf r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r3 = r0.createFromParcel(r11)
            L_0x0035:
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzej r5 = com.google.android.gms.internal.zzej.zza.zzG(r0)
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5)
                r12.writeNoException()
                goto L_0x0009
            L_0x0049:
                r2 = r0
                goto L_0x0029
            L_0x004b:
                r3 = r0
                goto L_0x0035
            L_0x004d:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                com.google.android.gms.dynamic.zzd r1 = r9.getView()
                r12.writeNoException()
                if (r1 == 0) goto L_0x005f
                android.os.IBinder r0 = r1.asBinder()
            L_0x005f:
                r12.writeStrongBinder(r0)
                goto L_0x0009
            L_0x0063:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbk(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x007c
                com.google.android.gms.ads.internal.client.zzf r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.createFromParcel(r11)
            L_0x007c:
                java.lang.String r2 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.internal.zzej r3 = com.google.android.gms.internal.zzej.zza.zzG(r3)
                r9.zza(r1, r0, r2, r3)
                r12.writeNoException()
                goto L_0x0009
            L_0x0090:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.showInterstitial()
                r12.writeNoException()
                goto L_0x0009
            L_0x009d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.destroy()
                r12.writeNoException()
                goto L_0x0009
            L_0x00aa:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbk(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x00e8
                com.google.android.gms.ads.internal.client.zzh r2 = com.google.android.gms.ads.internal.client.AdSizeParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r2.createFromParcel(r11)
            L_0x00c3:
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x00ea
                com.google.android.gms.ads.internal.client.zzf r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r3 = r0.createFromParcel(r11)
            L_0x00cf:
                java.lang.String r4 = r11.readString()
                java.lang.String r5 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzej r6 = com.google.android.gms.internal.zzej.zza.zzG(r0)
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5, r6)
                r12.writeNoException()
                goto L_0x0009
            L_0x00e8:
                r2 = r0
                goto L_0x00c3
            L_0x00ea:
                r3 = r0
                goto L_0x00cf
            L_0x00ec:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbk(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x011e
                com.google.android.gms.ads.internal.client.zzf r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r2 = r0.createFromParcel(r11)
            L_0x0105:
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.internal.zzej r5 = com.google.android.gms.internal.zzej.zza.zzG(r0)
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5)
                r12.writeNoException()
                goto L_0x0009
            L_0x011e:
                r2 = r0
                goto L_0x0105
            L_0x0120:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.pause()
                r12.writeNoException()
                goto L_0x0009
            L_0x012d:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.resume()
                r12.writeNoException()
                goto L_0x0009
            L_0x013a:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbk(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x016c
                com.google.android.gms.ads.internal.client.zzf r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r2 = r0.createFromParcel(r11)
            L_0x0153:
                java.lang.String r3 = r11.readString()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.ads.internal.reward.mediation.client.zza r4 = com.google.android.gms.ads.internal.reward.mediation.client.zza.C1339zza.zzad(r0)
                java.lang.String r5 = r11.readString()
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5)
                r12.writeNoException()
                goto L_0x0009
            L_0x016c:
                r2 = r0
                goto L_0x0153
            L_0x016e:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                int r1 = r11.readInt()
                if (r1 == 0) goto L_0x017f
                com.google.android.gms.ads.internal.client.zzf r0 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.createFromParcel(r11)
            L_0x017f:
                java.lang.String r1 = r11.readString()
                r9.zza(r0, r1)
                r12.writeNoException()
                goto L_0x0009
            L_0x018b:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                r9.showVideo()
                r12.writeNoException()
                goto L_0x0009
            L_0x0198:
                java.lang.String r0 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r0)
                boolean r0 = r9.isInitialized()
                r12.writeNoException()
                if (r0 == 0) goto L_0x01ac
                r0 = r8
            L_0x01a7:
                r12.writeInt(r0)
                goto L_0x0009
            L_0x01ac:
                r0 = 0
                goto L_0x01a7
            L_0x01ae:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.dynamic.zzd r1 = com.google.android.gms.dynamic.zzd.zza.zzbk(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x01f0
                com.google.android.gms.ads.internal.client.zzf r2 = com.google.android.gms.ads.internal.client.AdRequestParcel.CREATOR
                com.google.android.gms.ads.internal.client.AdRequestParcel r2 = r2.createFromParcel(r11)
            L_0x01c7:
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                android.os.IBinder r5 = r11.readStrongBinder()
                com.google.android.gms.internal.zzej r5 = com.google.android.gms.internal.zzej.zza.zzG(r5)
                int r6 = r11.readInt()
                if (r6 == 0) goto L_0x01f2
                com.google.android.gms.ads.internal.formats.zzi r0 = com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel.CREATOR
                com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r6 = r0.createFromParcel(r11)
            L_0x01e3:
                java.util.ArrayList r7 = r11.createStringArrayList()
                r0 = r9
                r0.zza(r1, r2, r3, r4, r5, r6, r7)
                r12.writeNoException()
                goto L_0x0009
            L_0x01f0:
                r2 = r0
                goto L_0x01c7
            L_0x01f2:
                r6 = r0
                goto L_0x01e3
            L_0x01f4:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                com.google.android.gms.internal.zzek r1 = r9.zzdS()
                r12.writeNoException()
                if (r1 == 0) goto L_0x0206
                android.os.IBinder r0 = r1.asBinder()
            L_0x0206:
                r12.writeStrongBinder(r0)
                goto L_0x0009
            L_0x020b:
                java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter"
                r11.enforceInterface(r1)
                com.google.android.gms.internal.zzel r1 = r9.zzdT()
                r12.writeNoException()
                if (r1 == 0) goto L_0x021d
                android.os.IBinder r0 = r1.asBinder()
            L_0x021d:
                r12.writeStrongBinder(r0)
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzei.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void destroy() throws RemoteException;

    zzd getView() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(AdRequestParcel adRequestParcel, String str) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, com.google.android.gms.ads.internal.reward.mediation.client.zza zza2, String str2) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, zzej zzej) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzej zzej) throws RemoteException;

    void zza(zzd zzd, AdRequestParcel adRequestParcel, String str, String str2, zzej zzej, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) throws RemoteException;

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, zzej zzej) throws RemoteException;

    void zza(zzd zzd, AdSizeParcel adSizeParcel, AdRequestParcel adRequestParcel, String str, String str2, zzej zzej) throws RemoteException;

    zzek zzdS() throws RemoteException;

    zzel zzdT() throws RemoteException;
}
