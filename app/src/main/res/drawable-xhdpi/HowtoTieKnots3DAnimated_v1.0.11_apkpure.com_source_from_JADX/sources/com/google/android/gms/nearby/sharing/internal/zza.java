package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.AppContentReceivedResult;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.nearby.sharing.internal.zza$zza reason: collision with other inner class name */
    public static abstract class C1530zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.nearby.sharing.internal.zza$zza$zza reason: collision with other inner class name */
        private static class C1531zza implements zza {
            private IBinder zznI;

            C1531zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(AppContentReceivedResult appContentReceivedResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    if (appContentReceivedResult != null) {
                        obtain.writeInt(1);
                        appContentReceivedResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public String zzef(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    obtain.writeString(str);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zza zzdl(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C1531zza(iBinder) : (zza) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    String zzef = zzef(data.readString());
                    reply.writeNoException();
                    reply.writeString(zzef);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    zza(data.readInt() != 0 ? (AppContentReceivedResult) AppContentReceivedResult.CREATOR.createFromParcel(data) : null);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.sharing.internal.IAppContentReceiver");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(AppContentReceivedResult appContentReceivedResult) throws RemoteException;

    String zzef(String str) throws RemoteException;
}
