package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzav extends IInterface {

    public static abstract class zza extends Binder implements zzav {

        /* renamed from: com.google.android.gms.internal.zzav$zza$zza reason: collision with other inner class name */
        private static class C1386zza implements zzav {
            private IBinder zznI;

            C1386zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeString(str);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzc(boolean z) throws RemoteException {
                boolean z2 = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeInt(z ? 1 : 0);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzn(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeString(str);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzav zzb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzav)) ? new C1386zza(iBinder) : (zzav) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean z = false;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String id = getId();
                    reply.writeNoException();
                    reply.writeString(id);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean zzc = zzc(data.readInt() != 0);
                    reply.writeNoException();
                    if (zzc) {
                        z = true;
                    }
                    reply.writeInt(z ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String zzn = zzn(data.readString());
                    reply.writeNoException();
                    reply.writeString(zzn);
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        z = true;
                    }
                    zzb(readString, z);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    String getId() throws RemoteException;

    void zzb(String str, boolean z) throws RemoteException;

    boolean zzc(boolean z) throws RemoteException;

    String zzn(String str) throws RemoteException;
}
