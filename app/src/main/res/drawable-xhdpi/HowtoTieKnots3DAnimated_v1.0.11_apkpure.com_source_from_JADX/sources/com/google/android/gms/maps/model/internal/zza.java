package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.maps.model.internal.zza$zza reason: collision with other inner class name */
    public static abstract class C1517zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.maps.model.internal.zza$zza$zza reason: collision with other inner class name */
        private static class C1518zza implements zza {
            private IBinder zznI;

            C1518zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public zzd zzb(Bitmap bitmap) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzdF(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzdG(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzdH(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzh(float f) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzhM(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzxg() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zza zzcO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C1518zza(iBinder) : (zza) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzhM = zzhM(data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zzhM != null ? zzhM.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzdF = zzdF(data.readString());
                    reply.writeNoException();
                    if (zzdF != null) {
                        iBinder = zzdF.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzdG = zzdG(data.readString());
                    reply.writeNoException();
                    if (zzdG != null) {
                        iBinder = zzdG.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzxg = zzxg();
                    reply.writeNoException();
                    if (zzxg != null) {
                        iBinder = zzxg.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzh = zzh(data.readFloat());
                    reply.writeNoException();
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzb = zzb(data.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zzb != null) {
                        iBinder = zzb.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzd zzdH = zzdH(data.readString());
                    reply.writeNoException();
                    if (zzdH != null) {
                        iBinder = zzdH.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzd zzb(Bitmap bitmap) throws RemoteException;

    zzd zzdF(String str) throws RemoteException;

    zzd zzdG(String str) throws RemoteException;

    zzd zzdH(String str) throws RemoteException;

    zzd zzh(float f) throws RemoteException;

    zzd zzhM(int i) throws RemoteException;

    zzd zzxg() throws RemoteException;
}
