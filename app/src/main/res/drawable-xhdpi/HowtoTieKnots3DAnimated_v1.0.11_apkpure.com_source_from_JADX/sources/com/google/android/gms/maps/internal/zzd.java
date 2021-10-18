package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzf;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.maps.internal.zzd$zza$zza reason: collision with other inner class name */
        private static class C1496zza implements zzd {
            private IBinder zznI;

            C1496zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public com.google.android.gms.dynamic.zzd zzf(zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public com.google.android.gms.dynamic.zzd zzg(zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IInfoWindowAdapter");
        }

        public static zzd zzcm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C1496zza(iBinder) : (zzd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    com.google.android.gms.dynamic.zzd zzf = zzf(com.google.android.gms.maps.model.internal.zzf.zza.zzcT(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzf != null) {
                        iBinder = zzf.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    com.google.android.gms.dynamic.zzd zzg = zzg(com.google.android.gms.maps.model.internal.zzf.zza.zzcT(data.readStrongBinder()));
                    reply.writeNoException();
                    if (zzg != null) {
                        iBinder = zzg.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IInfoWindowAdapter");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    com.google.android.gms.dynamic.zzd zzf(zzf zzf) throws RemoteException;

    com.google.android.gms.dynamic.zzd zzg(zzf zzf) throws RemoteException;
}
