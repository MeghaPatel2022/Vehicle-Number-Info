package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GestureRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzd;
import java.util.List;

public interface zzg extends IInterface {

    public static abstract class zza extends Binder implements zzg {

        /* renamed from: com.google.android.gms.location.internal.zzg$zza$zza reason: collision with other inner class name */
        private static class C1476zza implements zzg {
            private IBinder zznI;

            C1476zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public Status zza(GestureRequest gestureRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (gestureRequest != null) {
                        obtain.writeInt(1);
                        gestureRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(60, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeLong(j);
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(PendingIntent pendingIntent, zzf zzf, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(Location location, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (geofencingRequest != null) {
                        obtain.writeInt(1);
                        geofencingRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
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

            public void zza(LocationRequest locationRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequest locationRequest, zzd zzd, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequest != null) {
                        obtain.writeInt(1);
                        locationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationSettingsRequest locationSettingsRequest, zzh zzh, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationSettingsRequest != null) {
                        obtain.writeInt(1);
                        locationSettingsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(63, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestInternal locationRequestInternal, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestInternal != null) {
                        obtain.writeInt(1);
                        locationRequestInternal.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (locationRequestUpdateData != null) {
                        obtain.writeInt(1);
                        locationRequestUpdateData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(59, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzf zzf, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzf zzf, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeTypedList(list);
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String[] strArr, zzf zzf, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeStringArray(strArr);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzag(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Status zzb(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(65, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(Location location) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (location != null) {
                        obtain.writeInt(1);
                        location.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Status zzc(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(66, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Status zzd(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(61, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Status) Status.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ActivityRecognitionResult zzdv(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zznI.transact(64, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ActivityRecognitionResult.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzdw(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zznI.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public LocationAvailability zzdx(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    obtain.writeString(str);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? LocationAvailability.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Location zzvO() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Location) Location.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder zzvP() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
                    this.zznI.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readStrongBinder();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzg zzca(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzg)) ? new C1476zza(iBinder) : (zzg) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v4, types: [com.google.android.gms.location.internal.LocationRequestUpdateData] */
        /* JADX WARNING: type inference failed for: r1v5, types: [com.google.android.gms.location.internal.LocationRequestUpdateData] */
        /* JADX WARNING: type inference failed for: r1v6, types: [com.google.android.gms.location.internal.LocationRequestInternal] */
        /* JADX WARNING: type inference failed for: r1v7, types: [com.google.android.gms.location.internal.LocationRequestInternal] */
        /* JADX WARNING: type inference failed for: r1v8, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r1v9, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r1v10, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.location.LocationRequest] */
        /* JADX WARNING: type inference failed for: r1v21 */
        /* JADX WARNING: type inference failed for: r1v22 */
        /* JADX WARNING: type inference failed for: r1v23 */
        /* JADX WARNING: type inference failed for: r1v24 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.location.internal.LocationRequestInternal, com.google.android.gms.location.internal.LocationRequestUpdateData, com.google.android.gms.location.LocationRequest]
          uses: [com.google.android.gms.location.internal.LocationRequestUpdateData, com.google.android.gms.location.internal.LocationRequestInternal, com.google.android.gms.location.LocationRequest]
          mth insns count: 364
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
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r2 = 0
                r1 = 0
                r3 = 1
                switch(r7) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0074;
                    case 3: goto L_0x009d;
                    case 4: goto L_0x00ba;
                    case 5: goto L_0x00d3;
                    case 6: goto L_0x00fb;
                    case 7: goto L_0x01f2;
                    case 8: goto L_0x020d;
                    case 9: goto L_0x0253;
                    case 10: goto L_0x02cc;
                    case 11: goto L_0x02e1;
                    case 12: goto L_0x0317;
                    case 13: goto L_0x032b;
                    case 20: goto L_0x022e;
                    case 21: goto L_0x0348;
                    case 26: goto L_0x0367;
                    case 34: goto L_0x0388;
                    case 51: goto L_0x03a7;
                    case 52: goto L_0x027f;
                    case 53: goto L_0x02a0;
                    case 57: goto L_0x003f;
                    case 59: goto L_0x02fe;
                    case 60: goto L_0x018d;
                    case 61: goto L_0x01c7;
                    case 63: goto L_0x03b8;
                    case 64: goto L_0x0118;
                    case 65: goto L_0x0137;
                    case 66: goto L_0x0162;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r3 = super.onTransact(r7, r8, r9, r10)
            L_0x000a:
                return r3
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r9.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                com.google.android.gms.location.internal.zzm r0 = com.google.android.gms.location.internal.ParcelableGeofence.CREATOR
                java.util.ArrayList r2 = r8.createTypedArrayList(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x003d
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x002a:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzf r1 = com.google.android.gms.location.internal.zzf.zza.zzbZ(r1)
                java.lang.String r4 = r8.readString()
                r6.zza(r2, r0, r1, r4)
                r9.writeNoException()
                goto L_0x000a
            L_0x003d:
                r0 = r1
                goto L_0x002a
            L_0x003f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0070
                android.os.Parcelable$Creator<com.google.android.gms.location.GeofencingRequest> r0 = com.google.android.gms.location.GeofencingRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.location.GeofencingRequest r0 = (com.google.android.gms.location.GeofencingRequest) r0
                r2 = r0
            L_0x0053:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0072
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0061:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzf r1 = com.google.android.gms.location.internal.zzf.zza.zzbZ(r1)
                r6.zza(r2, r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0070:
                r2 = r1
                goto L_0x0053
            L_0x0072:
                r0 = r1
                goto L_0x0061
            L_0x0074:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x009b
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0087:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzf r1 = com.google.android.gms.location.internal.zzf.zza.zzbZ(r1)
                java.lang.String r2 = r8.readString()
                r6.zza(r0, r1, r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x009b:
                r0 = r1
                goto L_0x0087
            L_0x009d:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                java.lang.String[] r0 = r8.createStringArray()
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzf r1 = com.google.android.gms.location.internal.zzf.zza.zzbZ(r1)
                java.lang.String r2 = r8.readString()
                r6.zza(r0, r1, r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x00ba:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzf r0 = com.google.android.gms.location.internal.zzf.zza.zzbZ(r0)
                java.lang.String r1 = r8.readString()
                r6.zza(r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x00d3:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                long r4 = r8.readLong()
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x00e3
                r2 = r3
            L_0x00e3:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x00f9
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x00f1:
                r6.zza(r4, r2, r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x00f9:
                r0 = r1
                goto L_0x00f1
            L_0x00fb:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0116
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x010e:
                r6.zza(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0116:
                r0 = r1
                goto L_0x010e
            L_0x0118:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                com.google.android.gms.location.ActivityRecognitionResult r0 = r6.zzdv(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x0132
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x0132:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x0137:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x015b
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x014a:
                com.google.android.gms.common.api.Status r0 = r6.zzb(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x015d
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x015b:
                r0 = r1
                goto L_0x014a
            L_0x015d:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x0162:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0186
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0175:
                com.google.android.gms.common.api.Status r0 = r6.zzc(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x0188
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x0186:
                r0 = r1
                goto L_0x0175
            L_0x0188:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x018d:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01be
                com.google.android.gms.location.zzb r0 = com.google.android.gms.location.GestureRequest.CREATOR
                com.google.android.gms.location.GestureRequest r0 = r0.createFromParcel(r8)
                r4 = r0
            L_0x019f:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01c0
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01ad:
                com.google.android.gms.common.api.Status r0 = r6.zza(r4, r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x01c2
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x01be:
                r4 = r1
                goto L_0x019f
            L_0x01c0:
                r0 = r1
                goto L_0x01ad
            L_0x01c2:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x01c7:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x01eb
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x01da:
                com.google.android.gms.common.api.Status r0 = r6.zzd(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x01ed
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x01eb:
                r0 = r1
                goto L_0x01da
            L_0x01ed:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x01f2:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.location.Location r0 = r6.zzvO()
                r9.writeNoException()
                if (r0 == 0) goto L_0x0208
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x0208:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x020d:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x021e
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r1 = r0.createFromParcel(r8)
            L_0x021e:
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzbX(r0)
                r6.zza(r1, r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x022e:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x023f
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r1 = r0.createFromParcel(r8)
            L_0x023f:
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzbX(r0)
                java.lang.String r2 = r8.readString()
                r6.zza(r1, r0, r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x0253:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x027b
                com.google.android.gms.location.LocationRequestCreator r0 = com.google.android.gms.location.LocationRequest.CREATOR
                com.google.android.gms.location.LocationRequest r0 = r0.createFromParcel(r8)
                r2 = r0
            L_0x0265:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x027d
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x0273:
                r6.zza(r2, r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x027b:
                r2 = r1
                goto L_0x0265
            L_0x027d:
                r0 = r1
                goto L_0x0273
            L_0x027f:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0290
                com.google.android.gms.location.internal.zzk r0 = com.google.android.gms.location.internal.LocationRequestInternal.CREATOR
                com.google.android.gms.location.internal.LocationRequestInternal r1 = r0.createFromParcel(r8)
            L_0x0290:
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzbX(r0)
                r6.zza(r1, r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02a0:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02c8
                com.google.android.gms.location.internal.zzk r0 = com.google.android.gms.location.internal.LocationRequestInternal.CREATOR
                com.google.android.gms.location.internal.LocationRequestInternal r0 = r0.createFromParcel(r8)
                r2 = r0
            L_0x02b2:
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02ca
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x02c0:
                r6.zza(r2, r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02c8:
                r2 = r1
                goto L_0x02b2
            L_0x02ca:
                r0 = r1
                goto L_0x02c0
            L_0x02cc:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r8.readStrongBinder()
                com.google.android.gms.location.zzd r0 = com.google.android.gms.location.zzd.zza.zzbX(r0)
                r6.zza(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02e1:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x02fc
                android.os.Parcelable$Creator r0 = android.app.PendingIntent.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.app.PendingIntent r0 = (android.app.PendingIntent) r0
            L_0x02f4:
                r6.zze(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x02fc:
                r0 = r1
                goto L_0x02f4
            L_0x02fe:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x030f
                com.google.android.gms.location.internal.zzl r0 = com.google.android.gms.location.internal.LocationRequestUpdateData.CREATOR
                com.google.android.gms.location.internal.LocationRequestUpdateData r1 = r0.createFromParcel(r8)
            L_0x030f:
                r6.zza(r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0317:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0323
                r2 = r3
            L_0x0323:
                r6.zzag(r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x032b:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0346
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.location.Location r0 = (android.location.Location) r0
            L_0x033e:
                r6.zzb(r0)
                r9.writeNoException()
                goto L_0x000a
            L_0x0346:
                r0 = r1
                goto L_0x033e
            L_0x0348:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                android.location.Location r0 = r6.zzdw(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x0362
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x0362:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x0367:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x0386
                android.os.Parcelable$Creator r0 = android.location.Location.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                android.location.Location r0 = (android.location.Location) r0
            L_0x037a:
                int r1 = r8.readInt()
                r6.zza(r0, r1)
                r9.writeNoException()
                goto L_0x000a
            L_0x0386:
                r0 = r1
                goto L_0x037a
            L_0x0388:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                java.lang.String r0 = r8.readString()
                com.google.android.gms.location.LocationAvailability r0 = r6.zzdx(r0)
                r9.writeNoException()
                if (r0 == 0) goto L_0x03a2
                r9.writeInt(r3)
                r0.writeToParcel(r9, r3)
                goto L_0x000a
            L_0x03a2:
                r9.writeInt(r2)
                goto L_0x000a
            L_0x03a7:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                android.os.IBinder r0 = r6.zzvP()
                r9.writeNoException()
                r9.writeStrongBinder(r0)
                goto L_0x000a
            L_0x03b8:
                java.lang.String r0 = "com.google.android.gms.location.internal.IGoogleLocationManagerService"
                r8.enforceInterface(r0)
                int r0 = r8.readInt()
                if (r0 == 0) goto L_0x03df
                android.os.Parcelable$Creator<com.google.android.gms.location.LocationSettingsRequest> r0 = com.google.android.gms.location.LocationSettingsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r8)
                com.google.android.gms.location.LocationSettingsRequest r0 = (com.google.android.gms.location.LocationSettingsRequest) r0
            L_0x03cb:
                android.os.IBinder r1 = r8.readStrongBinder()
                com.google.android.gms.location.internal.zzh r1 = com.google.android.gms.location.internal.zzh.zza.zzcb(r1)
                java.lang.String r2 = r8.readString()
                r6.zza(r0, r1, r2)
                r9.writeNoException()
                goto L_0x000a
            L_0x03df:
                r0 = r1
                goto L_0x03cb
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.location.internal.zzg.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    Status zza(GestureRequest gestureRequest, PendingIntent pendingIntent) throws RemoteException;

    void zza(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent) throws RemoteException;

    void zza(PendingIntent pendingIntent, zzf zzf, String str) throws RemoteException;

    void zza(Location location, int i) throws RemoteException;

    void zza(GeofencingRequest geofencingRequest, PendingIntent pendingIntent, zzf zzf) throws RemoteException;

    void zza(LocationRequest locationRequest, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequest locationRequest, zzd zzd) throws RemoteException;

    void zza(LocationRequest locationRequest, zzd zzd, String str) throws RemoteException;

    void zza(LocationSettingsRequest locationSettingsRequest, zzh zzh, String str) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, PendingIntent pendingIntent) throws RemoteException;

    void zza(LocationRequestInternal locationRequestInternal, zzd zzd) throws RemoteException;

    void zza(LocationRequestUpdateData locationRequestUpdateData) throws RemoteException;

    void zza(zzf zzf, String str) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(List<ParcelableGeofence> list, PendingIntent pendingIntent, zzf zzf, String str) throws RemoteException;

    void zza(String[] strArr, zzf zzf, String str) throws RemoteException;

    void zzag(boolean z) throws RemoteException;

    Status zzb(PendingIntent pendingIntent) throws RemoteException;

    void zzb(Location location) throws RemoteException;

    Status zzc(PendingIntent pendingIntent) throws RemoteException;

    Status zzd(PendingIntent pendingIntent) throws RemoteException;

    ActivityRecognitionResult zzdv(String str) throws RemoteException;

    Location zzdw(String str) throws RemoteException;

    LocationAvailability zzdx(String str) throws RemoteException;

    void zze(PendingIntent pendingIntent) throws RemoteException;

    Location zzvO() throws RemoteException;

    IBinder zzvP() throws RemoteException;
}
