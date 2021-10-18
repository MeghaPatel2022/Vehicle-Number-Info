package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzko extends IInterface {

    public static abstract class zza extends Binder implements zzko {

        /* renamed from: com.google.android.gms.internal.zzko$zza$zza reason: collision with other inner class name */
        private static class C1424zza implements zzko {
            private IBinder zznI;

            C1424zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void destroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void disconnect() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzkn zzkn) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    if (zzkn != null) {
                        iBinder = zzkn.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzkn zzkn, int i) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    if (zzkn != null) {
                        iBinder = zzkn.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeInt(i);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(zzkn zzkn, zzkp zzkp, String str, String str2) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    obtain.writeStrongBinder(zzkn != null ? zzkn.asBinder() : null);
                    if (zzkp != null) {
                        iBinder = zzkp.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzko zzaE(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzko)) ? new C1424zza(iBinder) : (zzko) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    destroy();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    disconnect();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzkn.zza.zzaD(data.readStrongBinder()), com.google.android.gms.internal.zzkp.zza.zzaF(data.readStrongBinder()), data.readString(), data.readString());
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzkn.zza.zzaD(data.readStrongBinder()), data.readInt());
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    zza(com.google.android.gms.internal.zzkn.zza.zzaD(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void destroy() throws RemoteException;

    void disconnect() throws RemoteException;

    void zza(zzkn zzkn) throws RemoteException;

    void zza(zzkn zzkn, int i) throws RemoteException;

    void zza(zzkn zzkn, zzkp zzkp, String str, String str2) throws RemoteException;
}
