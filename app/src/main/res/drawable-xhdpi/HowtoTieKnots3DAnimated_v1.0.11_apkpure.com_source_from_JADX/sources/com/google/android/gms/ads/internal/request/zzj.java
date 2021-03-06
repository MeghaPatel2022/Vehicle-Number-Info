package com.google.android.gms.ads.internal.request;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzj extends IInterface {

    public static abstract class zza extends Binder implements zzj {

        /* renamed from: com.google.android.gms.ads.internal.request.zzj$zza$zza reason: collision with other inner class name */
        private static class C1332zza implements zzj {
            private IBinder zznI;

            C1332zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(AdRequestInfoParcel adRequestInfoParcel, zzk zzk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzk != null ? zzk.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (adRequestInfoParcel != null) {
                        obtain.writeInt(1);
                        adRequestInfoParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? AdResponseParcel.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.request.IAdRequestService");
        }

        public static zzj zzW(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzj)) ? new C1332zza(iBinder) : (zzj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AdRequestInfoParcel adRequestInfoParcel = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (data.readInt() != 0) {
                        adRequestInfoParcel = AdRequestInfoParcel.CREATOR.createFromParcel(data);
                    }
                    AdResponseParcel zze = zze(adRequestInfoParcel);
                    reply.writeNoException();
                    if (zze != null) {
                        reply.writeInt(1);
                        zze.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.request.IAdRequestService");
                    if (data.readInt() != 0) {
                        adRequestInfoParcel = AdRequestInfoParcel.CREATOR.createFromParcel(data);
                    }
                    zza(adRequestInfoParcel, com.google.android.gms.ads.internal.request.zzk.zza.zzX(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.request.IAdRequestService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(AdRequestInfoParcel adRequestInfoParcel, zzk zzk) throws RemoteException;

    AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) throws RemoteException;
}
