package com.google.android.gms.plus.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.FavaDiagnosticsEntity;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import java.util.List;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.plus.internal.zzd$zza$zza reason: collision with other inner class name */
        private static class C1539zza implements zzd {
            private IBinder zznI;

            C1539zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public String getAccountName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAuthCode() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznI.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzq zza(zzb zzb, int i, int i2, int i3, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeString(str);
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.common.internal.zzq.zza.zzaI(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SafeParcelResponse safeParcelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    if (safeParcelResponse != null) {
                        obtain.writeInt(1);
                        safeParcelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb, int i, String str, Uri uri, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb, SafeParcelResponse safeParcelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    if (safeParcelResponse != null) {
                        obtain.writeInt(1);
                        safeParcelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzb zzb, List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeStringList(list);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, FavaDiagnosticsEntity favaDiagnosticsEntity, FavaDiagnosticsEntity favaDiagnosticsEntity2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    if (favaDiagnosticsEntity != null) {
                        obtain.writeInt(1);
                        favaDiagnosticsEntity.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (favaDiagnosticsEntity2 != null) {
                        obtain.writeInt(1);
                        favaDiagnosticsEntity2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb zzb) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzb zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzb zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzb zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzb zzb, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeStrongBinder(zzb != null ? zzb.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzej(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    obtain.writeString(str);
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzlG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznI.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzyG() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzyH() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusService");
                    this.zznI.transact(42, obtain, obtain2, 0);
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
        }

        public static zzd zzdx(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C1539zza(iBinder) : (zzd) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r6v0 */
        /* JADX WARNING: type inference failed for: r6v1, types: [com.google.android.gms.common.server.FavaDiagnosticsEntity] */
        /* JADX WARNING: type inference failed for: r6v2, types: [com.google.android.gms.common.server.FavaDiagnosticsEntity] */
        /* JADX WARNING: type inference failed for: r6v3, types: [com.google.android.gms.common.server.response.SafeParcelResponse] */
        /* JADX WARNING: type inference failed for: r6v4, types: [com.google.android.gms.common.server.response.SafeParcelResponse] */
        /* JADX WARNING: type inference failed for: r6v5, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r6v6, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r6v8 */
        /* JADX WARNING: type inference failed for: r6v9 */
        /* JADX WARNING: type inference failed for: r6v10 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r6v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.common.server.response.SafeParcelResponse, com.google.android.gms.common.server.FavaDiagnosticsEntity, android.os.IBinder]
          uses: [com.google.android.gms.common.server.FavaDiagnosticsEntity, com.google.android.gms.common.server.response.SafeParcelResponse, android.os.IBinder]
          mth insns count: 209
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
        /* JADX WARNING: Unknown variable types count: 4 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
            /*
                r8 = this;
                r6 = 0
                r7 = 1
                switch(r9) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x005c;
                    case 5: goto L_0x0076;
                    case 6: goto L_0x0086;
                    case 8: goto L_0x0093;
                    case 9: goto L_0x00a8;
                    case 14: goto L_0x00de;
                    case 16: goto L_0x0115;
                    case 17: goto L_0x0145;
                    case 18: goto L_0x0156;
                    case 19: goto L_0x016f;
                    case 34: goto L_0x0184;
                    case 40: goto L_0x019d;
                    case 41: goto L_0x01b6;
                    case 42: goto L_0x01c7;
                    case 43: goto L_0x01dd;
                    case 44: goto L_0x01ee;
                    case 45: goto L_0x0207;
                    case 46: goto L_0x0228;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r7 = super.onTransact(r9, r10, r11, r12)
            L_0x0009:
                return r7
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r11.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.lang.String r1 = r10.readString()
                r8.zza(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.lang.String r1 = r10.readString()
                java.lang.String r2 = r10.readString()
                r8.zza(r0, r1, r2)
                r11.writeNoException()
                goto L_0x0009
            L_0x0044:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.lang.String r1 = r10.readString()
                r8.zzb(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x005c:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0074
                com.google.android.gms.common.server.response.zze r0 = com.google.android.gms.common.server.response.SafeParcelResponse.CREATOR
                com.google.android.gms.common.server.response.SafeParcelResponse r0 = r0.createFromParcel(r10)
            L_0x006d:
                r8.zza(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0074:
                r0 = r6
                goto L_0x006d
            L_0x0076:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.getAccountName()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x0086:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                r8.zzyG()
                r11.writeNoException()
                goto L_0x0009
            L_0x0093:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                r8.zza(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x00a8:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r2 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00da
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r1 = r0
            L_0x00c4:
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x00dc
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x00d2:
                r8.zza(r2, r1, r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x00da:
                r1 = r6
                goto L_0x00c4
            L_0x00dc:
                r0 = r6
                goto L_0x00d2
            L_0x00de:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r1 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                int r2 = r10.readInt()
                java.lang.String r3 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0113
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r10)
                android.net.Uri r0 = (android.net.Uri) r0
                r4 = r0
            L_0x0102:
                java.lang.String r5 = r10.readString()
                java.lang.String r6 = r10.readString()
                r0 = r8
                r0.zza(r1, r2, r3, r4, r5, r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0113:
                r4 = r6
                goto L_0x0102
            L_0x0115:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r1 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                int r2 = r10.readInt()
                int r3 = r10.readInt()
                int r4 = r10.readInt()
                java.lang.String r5 = r10.readString()
                r0 = r8
                com.google.android.gms.common.internal.zzq r0 = r0.zza(r1, r2, r3, r4, r5)
                r11.writeNoException()
                if (r0 == 0) goto L_0x0140
                android.os.IBinder r6 = r0.asBinder()
            L_0x0140:
                r11.writeStrongBinder(r6)
                goto L_0x0009
            L_0x0145:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r10.readString()
                r8.zzej(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0156:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.lang.String r1 = r10.readString()
                r8.zzc(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x016f:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                r8.zzb(r0)
                r11.writeNoException()
                goto L_0x0009
            L_0x0184:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.util.ArrayList r1 = r10.createStringArrayList()
                r8.zza(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x019d:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.lang.String r1 = r10.readString()
                r8.zzd(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x01b6:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.getAuthCode()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x01c7:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                boolean r0 = r8.zzyH()
                r11.writeNoException()
                if (r0 == 0) goto L_0x01db
                r0 = r7
            L_0x01d6:
                r11.writeInt(r0)
                goto L_0x0009
            L_0x01db:
                r0 = 0
                goto L_0x01d6
            L_0x01dd:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r0 = r8.zzlG()
                r11.writeNoException()
                r11.writeString(r0)
                goto L_0x0009
            L_0x01ee:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                java.lang.String r1 = r10.readString()
                r8.zze(r0, r1)
                r11.writeNoException()
                goto L_0x0009
            L_0x0207:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                android.os.IBinder r0 = r10.readStrongBinder()
                com.google.android.gms.plus.internal.zzb r0 = com.google.android.gms.plus.internal.zzb.zza.zzdv(r0)
                int r1 = r10.readInt()
                if (r1 == 0) goto L_0x0220
                com.google.android.gms.common.server.response.zze r1 = com.google.android.gms.common.server.response.SafeParcelResponse.CREATOR
                com.google.android.gms.common.server.response.SafeParcelResponse r6 = r1.createFromParcel(r10)
            L_0x0220:
                r8.zza(r0, r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0228:
                java.lang.String r0 = "com.google.android.gms.plus.internal.IPlusService"
                r10.enforceInterface(r0)
                java.lang.String r1 = r10.readString()
                int r0 = r10.readInt()
                if (r0 == 0) goto L_0x0251
                com.google.android.gms.common.server.zza r0 = com.google.android.gms.common.server.FavaDiagnosticsEntity.CREATOR
                com.google.android.gms.common.server.FavaDiagnosticsEntity r0 = r0.createFromParcel(r10)
            L_0x023d:
                int r2 = r10.readInt()
                if (r2 == 0) goto L_0x0249
                com.google.android.gms.common.server.zza r2 = com.google.android.gms.common.server.FavaDiagnosticsEntity.CREATOR
                com.google.android.gms.common.server.FavaDiagnosticsEntity r6 = r2.createFromParcel(r10)
            L_0x0249:
                r8.zza(r1, r0, r6)
                r11.writeNoException()
                goto L_0x0009
            L_0x0251:
                r0 = r6
                goto L_0x023d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.plus.internal.zzd.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    String getAccountName() throws RemoteException;

    String getAuthCode() throws RemoteException;

    zzq zza(zzb zzb, int i, int i2, int i3, String str) throws RemoteException;

    void zza(SafeParcelResponse safeParcelResponse) throws RemoteException;

    void zza(zzb zzb) throws RemoteException;

    void zza(zzb zzb, int i, String str, Uri uri, String str2, String str3) throws RemoteException;

    void zza(zzb zzb, Uri uri, Bundle bundle) throws RemoteException;

    void zza(zzb zzb, SafeParcelResponse safeParcelResponse) throws RemoteException;

    void zza(zzb zzb, String str) throws RemoteException;

    void zza(zzb zzb, String str, String str2) throws RemoteException;

    void zza(zzb zzb, List<String> list) throws RemoteException;

    void zza(String str, FavaDiagnosticsEntity favaDiagnosticsEntity, FavaDiagnosticsEntity favaDiagnosticsEntity2) throws RemoteException;

    void zzb(zzb zzb) throws RemoteException;

    void zzb(zzb zzb, String str) throws RemoteException;

    void zzc(zzb zzb, String str) throws RemoteException;

    void zzd(zzb zzb, String str) throws RemoteException;

    void zze(zzb zzb, String str) throws RemoteException;

    void zzej(String str) throws RemoteException;

    String zzlG() throws RemoteException;

    void zzyG() throws RemoteException;

    boolean zzyH() throws RemoteException;
}
