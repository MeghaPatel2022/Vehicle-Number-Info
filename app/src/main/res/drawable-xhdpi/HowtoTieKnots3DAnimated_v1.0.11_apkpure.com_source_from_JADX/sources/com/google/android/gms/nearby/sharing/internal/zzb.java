package com.google.android.gms.nearby.sharing.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.sharing.SharedContent;
import java.util.List;

public interface zzb extends IInterface {

    public static abstract class zza extends Binder implements zzb {

        /* renamed from: com.google.android.gms.nearby.sharing.internal.zzb$zza$zza reason: collision with other inner class name */
        private static class C1532zza implements zzb {
            private IBinder zznI;

            C1532zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public List<SharedContent> zzyw() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(SharedContent.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzb zzdm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzb)) ? new C1532zza(iBinder) : (zzb) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    List zzyw = zzyw();
                    reply.writeNoException();
                    reply.writeTypedList(zzyw);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.nearby.sharing.internal.IContentProvider");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    List<SharedContent> zzyw() throws RemoteException;
}
