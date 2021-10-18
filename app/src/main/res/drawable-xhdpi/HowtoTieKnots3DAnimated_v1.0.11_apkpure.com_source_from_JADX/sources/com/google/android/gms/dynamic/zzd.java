package com.google.android.gms.dynamic;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.dynamic.zzd$zza$zza reason: collision with other inner class name */
        private static class C1378zza implements zzd {
            private IBinder zznI;

            C1378zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static zzd zzbk(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C1378zza(iBinder) : (zzd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1598968902:
                    reply.writeString("com.google.android.gms.dynamic.IObjectWrapper");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }
}
