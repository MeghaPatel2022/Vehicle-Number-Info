package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.internal.zza.C1517zza;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.maps.internal.zzc$zza$zza reason: collision with other inner class name */
        private static class C1495zza implements zzc {
            private IBinder zznI;

            C1495zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public IMapViewDelegate zza(zzd zzd, GoogleMapOptions googleMapOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (googleMapOptions != null) {
                        obtain.writeInt(1);
                        googleMapOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.maps.internal.IMapViewDelegate.zza.zzcp(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaViewDelegate zza(zzd zzd, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (streetViewPanoramaOptions != null) {
                        obtain.writeInt(1);
                        streetViewPanoramaOptions.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate.zza.zzcM(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzd zzd, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzs(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IMapFragmentDelegate zzt(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.maps.internal.IMapFragmentDelegate.zza.zzco(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IStreetViewPanoramaFragmentDelegate zzu(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate.zza.zzcL(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ICameraUpdateFactoryDelegate zzwX() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate.zza.zzci(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public com.google.android.gms.maps.model.internal.zza zzwY() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.ICreator");
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return C1517zza.zzcO(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc zzck(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C1495zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzs(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapFragmentDelegate zzt = zzt(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzt != null) {
                        iBinder = zzt.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IMapViewDelegate zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt() != 0 ? GoogleMapOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zza != null) {
                        iBinder = zza.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    ICameraUpdateFactoryDelegate zzwX = zzwX();
                    reply.writeNoException();
                    if (zzwX != null) {
                        iBinder = zzwX.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    com.google.android.gms.maps.model.internal.zza zzwY = zzwY();
                    reply.writeNoException();
                    if (zzwY != null) {
                        iBinder = zzwY.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    zzd(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaViewDelegate zza2 = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt() != 0 ? StreetViewPanoramaOptions.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    if (zza2 != null) {
                        iBinder = zza2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.maps.internal.ICreator");
                    IStreetViewPanoramaFragmentDelegate zzu = zzu(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzu != null) {
                        iBinder = zzu.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.ICreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    IMapViewDelegate zza(zzd zzd, GoogleMapOptions googleMapOptions) throws RemoteException;

    IStreetViewPanoramaViewDelegate zza(zzd zzd, StreetViewPanoramaOptions streetViewPanoramaOptions) throws RemoteException;

    void zzd(zzd zzd, int i) throws RemoteException;

    void zzs(zzd zzd) throws RemoteException;

    IMapFragmentDelegate zzt(zzd zzd) throws RemoteException;

    IStreetViewPanoramaFragmentDelegate zzu(zzd zzd) throws RemoteException;

    ICameraUpdateFactoryDelegate zzwX() throws RemoteException;

    com.google.android.gms.maps.model.internal.zza zzwY() throws RemoteException;
}
