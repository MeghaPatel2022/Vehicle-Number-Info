package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.internal.zzd;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {

        /* renamed from: com.google.android.gms.maps.internal.zzf$zza$zza reason: collision with other inner class name */
        private static class C1498zza implements zzf {
            private IBinder zznI;

            C1498zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void onIndoorBuildingFocused() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    this.zznI.transact(1, obtain, obtain2, 0);
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
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
        }

        public static zzf zzcr(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new C1498zza(iBinder) : (zzf) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    onIndoorBuildingFocused();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    zza(com.google.android.gms.maps.model.internal.zzd.zza.zzcR(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.internal.IOnIndoorStateChangeListener");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void onIndoorBuildingFocused() throws RemoteException;

    void zza(zzd zzd) throws RemoteException;
}
