package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzan extends IInterface {

    public static abstract class zza extends Binder implements zzan {

        /* renamed from: com.google.android.gms.drive.internal.zzan$zza$zza reason: collision with other inner class name */
        private static class C1361zza implements zzan {
            private IBinder zznI;

            C1361zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zzc(OnEventResponse onEventResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IEventCallback");
                    if (onEventResponse != null) {
                        obtain.writeInt(1);
                        onEventResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.drive.internal.IEventCallback");
        }

        public static zzan zzaU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IEventCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzan)) ? new C1361zza(iBinder) : (zzan) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.drive.internal.IEventCallback");
                    zzc(data.readInt() != 0 ? (OnEventResponse) OnEventResponse.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.drive.internal.IEventCallback");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzc(OnEventResponse onEventResponse) throws RemoteException;
}
