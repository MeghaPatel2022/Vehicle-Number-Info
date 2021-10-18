package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzlc extends IInterface {

    public static abstract class zza extends Binder implements zzlc {

        /* renamed from: com.google.android.gms.internal.zzlc$zza$zza reason: collision with other inner class name */
        private static class C1428zza implements zzlc {
            private IBinder zznI;

            C1428zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzlb zzlb) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    if (zzlb != null) {
                        iBinder = zzlb.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzlc zzaQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzlc)) ? new C1428zza(iBinder) : (zzlc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                    zza(com.google.android.gms.internal.zzlb.zza.zzaP(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.common.internal.service.ICommonService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(zzlb zzlb) throws RemoteException;
}
