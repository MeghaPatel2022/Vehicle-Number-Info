package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzpv extends IInterface {

    public static abstract class zza extends Binder implements zzpv {

        /* renamed from: com.google.android.gms.internal.zzpv$zza$zza reason: collision with other inner class name */
        private static class C1461zza implements zzpv {
            private IBinder zznI;

            C1461zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzpu zzpu) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(zzpu != null ? zzpu.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzpu zzpu, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(zzpu != null ? zzpu.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzpu zzpu, String str, int[] iArr, int i, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(zzpu != null ? zzpu.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeIntArray(iArr);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzpu zzpu, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    obtain.writeStrongBinder(zzpu != null ? zzpu.asBinder() : null);
                    obtain.writeByteArray(bArr);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzpv zzdB(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzpv)) ? new C1461zza(iBinder) : (zzpv) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzpu.zza.zzdA(data.readStrongBinder()), data.createByteArray());
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzpu.zza.zzdA(data.readStrongBinder()));
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzpu.zza.zzdA(data.readStrongBinder()), data.readString(), data.createIntArray(), data.readInt(), data.readString());
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    zza(com.google.android.gms.internal.zzpu.zza.zzdA(data.readStrongBinder()), data.readString());
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.safetynet.internal.ISafetyNetService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzpu zzpu) throws RemoteException;

    void zza(zzpu zzpu, String str) throws RemoteException;

    void zza(zzpu zzpu, String str, int[] iArr, int i, String str2) throws RemoteException;

    void zza(zzpu zzpu, byte[] bArr) throws RemoteException;
}
