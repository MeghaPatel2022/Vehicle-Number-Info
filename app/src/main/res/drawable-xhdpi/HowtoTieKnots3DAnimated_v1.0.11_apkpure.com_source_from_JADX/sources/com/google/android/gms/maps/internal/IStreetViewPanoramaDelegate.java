package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public interface IStreetViewPanoramaDelegate extends IInterface {

    public static abstract class zza extends Binder implements IStreetViewPanoramaDelegate {

        /* renamed from: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate$zza$zza reason: collision with other inner class name */
        private static class C1490zza implements IStreetViewPanoramaDelegate {
            private IBinder zznI;

            C1490zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public void animateTo(StreetViewPanoramaCamera camera, long duration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (camera != null) {
                        obtain.writeInt(1);
                        camera.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(duration);
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void enablePanning(boolean enablePanning) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enablePanning) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableStreetNames(boolean enableStreetNames) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enableStreetNames) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableUserNavigation(boolean enableUserNavigation) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (enableUserNavigation) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void enableZoom(boolean enableZoom) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (!enableZoom) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.zznI.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? StreetViewPanoramaCamera.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? StreetViewPanoramaLocation.CREATOR.zzfh(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isPanningGesturesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.zznI.transact(6, obtain, obtain2, 0);
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

            public boolean isStreetNamesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.zznI.transact(8, obtain, obtain2, 0);
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

            public boolean isUserNavigationEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.zznI.transact(7, obtain, obtain2, 0);
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

            public boolean isZoomGesturesEnabled() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    this.zznI.transact(5, obtain, obtain2, 0);
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

            public zzd orientationToPoint(StreetViewPanoramaOrientation orientation) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (orientation != null) {
                        obtain.writeInt(1);
                        orientation.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public StreetViewPanoramaOrientation pointToOrientation(zzd point) throws RemoteException {
                StreetViewPanoramaOrientation streetViewPanoramaOrientation = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(point != null ? point.asBinder() : null);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        streetViewPanoramaOrientation = StreetViewPanoramaOrientation.CREATOR.createFromParcel(obtain2);
                    }
                    return streetViewPanoramaOrientation;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaCameraChangeListener(zzr listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaChangeListener(zzs listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaClickListener(zzt listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setOnStreetViewPanoramaLongClickListener(zzu listener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.zznI.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPosition(LatLng position) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPositionWithID(String panoId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    obtain.writeString(panoId);
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setPositionWithRadius(LatLng position, int radius) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
                    if (position != null) {
                        obtain.writeInt(1);
                        position.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(radius);
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IStreetViewPanoramaDelegate zzcK(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IStreetViewPanoramaDelegate)) ? new C1490zza(iBinder) : (IStreetViewPanoramaDelegate) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r2v0 */
        /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IBinder] */
        /* JADX WARNING: type inference failed for: r2v9, types: [com.google.android.gms.maps.model.LatLng] */
        /* JADX WARNING: type inference failed for: r2v10, types: [com.google.android.gms.maps.model.LatLng] */
        /* JADX WARNING: type inference failed for: r2v11, types: [com.google.android.gms.maps.model.LatLng] */
        /* JADX WARNING: type inference failed for: r2v12, types: [com.google.android.gms.maps.model.LatLng] */
        /* JADX WARNING: type inference failed for: r2v32 */
        /* JADX WARNING: type inference failed for: r2v33 */
        /* JADX WARNING: type inference failed for: r2v34 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.maps.model.LatLng, android.os.IBinder]
          uses: [android.os.IBinder, com.google.android.gms.maps.model.LatLng]
          mth insns count: 184
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
        /* JADX WARNING: Unknown variable types count: 4 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r2 = 0
                r0 = 0
                r1 = 1
                switch(r5) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0024;
                    case 3: goto L_0x0037;
                    case 4: goto L_0x004a;
                    case 5: goto L_0x005d;
                    case 6: goto L_0x0070;
                    case 7: goto L_0x0083;
                    case 8: goto L_0x0097;
                    case 9: goto L_0x00ab;
                    case 10: goto L_0x00ca;
                    case 11: goto L_0x00e5;
                    case 12: goto L_0x00f6;
                    case 13: goto L_0x010f;
                    case 14: goto L_0x012c;
                    case 15: goto L_0x0147;
                    case 16: goto L_0x015c;
                    case 17: goto L_0x0171;
                    case 18: goto L_0x0186;
                    case 19: goto L_0x01a9;
                    case 20: goto L_0x01ce;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r1 = super.onTransact(r5, r6, r7, r8)
            L_0x000a:
                return r1
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r7.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x001d
                r0 = r1
            L_0x001d:
                r4.enableZoom(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0024:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0030
                r0 = r1
            L_0x0030:
                r4.enablePanning(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0037:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0043
                r0 = r1
            L_0x0043:
                r4.enableUserNavigation(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x004a:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x0056
                r0 = r1
            L_0x0056:
                r4.enableStreetNames(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x005d:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                boolean r2 = r4.isZoomGesturesEnabled()
                r7.writeNoException()
                if (r2 == 0) goto L_0x006c
                r0 = r1
            L_0x006c:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0070:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                boolean r2 = r4.isPanningGesturesEnabled()
                r7.writeNoException()
                if (r2 == 0) goto L_0x007f
                r0 = r1
            L_0x007f:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0083:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                boolean r2 = r4.isUserNavigationEnabled()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0092
                r0 = r1
            L_0x0092:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0097:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                boolean r2 = r4.isStreetNamesEnabled()
                r7.writeNoException()
                if (r2 == 0) goto L_0x00a6
                r0 = r1
            L_0x00a6:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x00ab:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x00c8
                com.google.android.gms.maps.model.zzj r0 = com.google.android.gms.maps.model.StreetViewPanoramaCamera.CREATOR
                com.google.android.gms.maps.model.StreetViewPanoramaCamera r0 = r0.createFromParcel(r6)
            L_0x00bc:
                long r2 = r6.readLong()
                r4.animateTo(r0, r2)
                r7.writeNoException()
                goto L_0x000a
            L_0x00c8:
                r0 = r2
                goto L_0x00bc
            L_0x00ca:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                com.google.android.gms.maps.model.StreetViewPanoramaCamera r2 = r4.getPanoramaCamera()
                r7.writeNoException()
                if (r2 == 0) goto L_0x00e0
                r7.writeInt(r1)
                r2.writeToParcel(r7, r1)
                goto L_0x000a
            L_0x00e0:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x00e5:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                java.lang.String r0 = r6.readString()
                r4.setPositionWithID(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x00f6:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0107
                com.google.android.gms.maps.model.zze r0 = com.google.android.gms.maps.model.LatLng.CREATOR
                com.google.android.gms.maps.model.LatLng r2 = r0.createFromParcel(r6)
            L_0x0107:
                r4.setPosition(r2)
                r7.writeNoException()
                goto L_0x000a
            L_0x010f:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0120
                com.google.android.gms.maps.model.zze r0 = com.google.android.gms.maps.model.LatLng.CREATOR
                com.google.android.gms.maps.model.LatLng r2 = r0.createFromParcel(r6)
            L_0x0120:
                int r0 = r6.readInt()
                r4.setPositionWithRadius(r2, r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x012c:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                com.google.android.gms.maps.model.StreetViewPanoramaLocation r2 = r4.getStreetViewPanoramaLocation()
                r7.writeNoException()
                if (r2 == 0) goto L_0x0142
                r7.writeInt(r1)
                r2.writeToParcel(r7, r1)
                goto L_0x000a
            L_0x0142:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x0147:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.maps.internal.zzs r0 = com.google.android.gms.maps.internal.zzs.zza.zzcE(r0)
                r4.setOnStreetViewPanoramaChangeListener(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x015c:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.maps.internal.zzr r0 = com.google.android.gms.maps.internal.zzr.zza.zzcD(r0)
                r4.setOnStreetViewPanoramaCameraChangeListener(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0171:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.maps.internal.zzt r0 = com.google.android.gms.maps.internal.zzt.zza.zzcF(r0)
                r4.setOnStreetViewPanoramaClickListener(r0)
                r7.writeNoException()
                goto L_0x000a
            L_0x0186:
                java.lang.String r2 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r2)
                android.os.IBinder r2 = r6.readStrongBinder()
                com.google.android.gms.dynamic.zzd r2 = com.google.android.gms.dynamic.zzd.zza.zzbk(r2)
                com.google.android.gms.maps.model.StreetViewPanoramaOrientation r2 = r4.pointToOrientation(r2)
                r7.writeNoException()
                if (r2 == 0) goto L_0x01a4
                r7.writeInt(r1)
                r2.writeToParcel(r7, r1)
                goto L_0x000a
            L_0x01a4:
                r7.writeInt(r0)
                goto L_0x000a
            L_0x01a9:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x01cc
                com.google.android.gms.maps.model.zzm r0 = com.google.android.gms.maps.model.StreetViewPanoramaOrientation.CREATOR
                com.google.android.gms.maps.model.StreetViewPanoramaOrientation r0 = r0.createFromParcel(r6)
            L_0x01ba:
                com.google.android.gms.dynamic.zzd r0 = r4.orientationToPoint(r0)
                r7.writeNoException()
                if (r0 == 0) goto L_0x01c7
                android.os.IBinder r2 = r0.asBinder()
            L_0x01c7:
                r7.writeStrongBinder(r2)
                goto L_0x000a
            L_0x01cc:
                r0 = r2
                goto L_0x01ba
            L_0x01ce:
                java.lang.String r0 = "com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate"
                r6.enforceInterface(r0)
                android.os.IBinder r0 = r6.readStrongBinder()
                com.google.android.gms.maps.internal.zzu r0 = com.google.android.gms.maps.internal.zzu.zza.zzcG(r0)
                r4.setOnStreetViewPanoramaLongClickListener(r0)
                r7.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void animateTo(StreetViewPanoramaCamera streetViewPanoramaCamera, long j) throws RemoteException;

    void enablePanning(boolean z) throws RemoteException;

    void enableStreetNames(boolean z) throws RemoteException;

    void enableUserNavigation(boolean z) throws RemoteException;

    void enableZoom(boolean z) throws RemoteException;

    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    zzd orientationToPoint(StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    StreetViewPanoramaOrientation pointToOrientation(zzd zzd) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(zzr zzr) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(zzs zzs) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(zzt zzt) throws RemoteException;

    void setOnStreetViewPanoramaLongClickListener(zzu zzu) throws RemoteException;

    void setPosition(LatLng latLng) throws RemoteException;

    void setPositionWithID(String str) throws RemoteException;

    void setPositionWithRadius(LatLng latLng, int i) throws RemoteException;
}
