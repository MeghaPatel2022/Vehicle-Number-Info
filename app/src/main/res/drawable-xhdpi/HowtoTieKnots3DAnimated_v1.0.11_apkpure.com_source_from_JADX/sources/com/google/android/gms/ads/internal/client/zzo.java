package com.google.android.gms.ads.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzo extends IInterface {

    public static abstract class zza extends Binder implements zzo {

        /* renamed from: com.google.android.gms.ads.internal.client.zzo$zza$zza reason: collision with other inner class name */
        private static class C1322zza implements zzo {
            private IBinder zznI;

            C1322zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public String getMediationAdapterClassName() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isLoading() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    return z;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(AdRequestParcel adRequestParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdLoader");
                    if (adRequestParcel != null) {
                        obtain.writeInt(1);
                        adRequestParcel.writeToParcel(obtain, 0);
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
            attachInterface(this, "com.google.android.gms.ads.internal.client.IAdLoader");
        }

        public static zzo zzh(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoader");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzo)) ? new C1322zza(iBinder) : (zzo) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    zze(data.readInt() != 0 ? AdRequestParcel.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    String mediationAdapterClassName = getMediationAdapterClassName();
                    reply.writeNoException();
                    reply.writeString(mediationAdapterClassName);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.internal.client.IAdLoader");
                    boolean isLoading = isLoading();
                    reply.writeNoException();
                    reply.writeInt(isLoading ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.internal.client.IAdLoader");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoading() throws RemoteException;

    void zze(AdRequestParcel adRequestParcel) throws RemoteException;
}
