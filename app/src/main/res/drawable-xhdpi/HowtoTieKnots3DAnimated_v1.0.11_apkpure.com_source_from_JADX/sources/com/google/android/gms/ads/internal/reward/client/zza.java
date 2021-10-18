package com.google.android.gms.ads.internal.reward.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.ads.internal.reward.client.zza$zza reason: collision with other inner class name */
    public static abstract class C1334zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.ads.internal.reward.client.zza$zza$zza reason: collision with other inner class name */
        private static class C1335zza implements zza {
            private IBinder zznI;

            C1335zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public int getAmount() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getType() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public C1334zza() {
            attachInterface(this, "com.google.android.gms.ads.internal.reward.client.IRewardItem");
        }

        public static zza zzY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C1335zza(iBinder) : (zza) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    String type = getType();
                    reply.writeNoException();
                    reply.writeString(type);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    int amount = getAmount();
                    reply.writeNoException();
                    reply.writeInt(amount);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.reward.client.IRewardItem");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    int getAmount() throws RemoteException;

    String getType() throws RemoteException;
}
