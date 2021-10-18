package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzf;

public interface zzn extends IInterface {

    public static abstract class zza extends Binder implements zzn {

        /* renamed from: com.google.android.gms.maps.internal.zzn$zza$zza reason: collision with other inner class name */
        private static class C1506zza implements zzn {
            private IBinder zznI;

            C1506zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zzb(zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnMarkerDragListener");
        }

        public static zzn zzcz(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzn)) ? new C1506zza(iBinder) : (zzn) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    zzb(com.google.android.gms.maps.model.internal.zzf.zza.zzcT(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    zzd(com.google.android.gms.maps.model.internal.zzf.zza.zzcT(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    zzc(com.google.android.gms.maps.model.internal.zzf.zza.zzcT(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnMarkerDragListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzb(zzf zzf) throws RemoteException;

    void zzc(zzf zzf) throws RemoteException;

    void zzd(zzf zzf) throws RemoteException;
}
