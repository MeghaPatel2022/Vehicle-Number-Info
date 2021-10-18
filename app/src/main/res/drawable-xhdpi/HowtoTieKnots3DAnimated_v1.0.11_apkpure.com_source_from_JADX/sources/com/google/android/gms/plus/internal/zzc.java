package com.google.android.gms.plus.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.plus.internal.zzc$zza$zza reason: collision with other inner class name */
        private static class C1538zza implements zzc {
            private IBinder zznI;

            C1538zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public zzd zza(zzd zzd, int i, int i2, String str, int i3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeInt(i3);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zza(zzd zzd, int i, int i2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return com.google.android.gms.dynamic.zzd.zza.zzbk(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzc zzdw(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C1538zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            IBinder iBinder = null;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    zzd zza = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readInt());
                    reply.writeNoException();
                    reply.writeStrongBinder(zza != null ? zza.asBinder() : null);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    zzd zza2 = zza(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt(), data.readInt(), data.readString(), data.readString());
                    reply.writeNoException();
                    if (zza2 != null) {
                        iBinder = zza2.asBinder();
                    }
                    reply.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    zzd zza(zzd zzd, int i, int i2, String str, int i3) throws RemoteException;

    zzd zza(zzd zzd, int i, int i2, String str, String str2) throws RemoteException;
}
