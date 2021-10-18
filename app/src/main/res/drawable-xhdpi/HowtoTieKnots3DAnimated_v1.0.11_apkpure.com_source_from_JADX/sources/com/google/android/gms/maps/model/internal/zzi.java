package com.google.android.gms.maps.model.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

public interface zzi extends IInterface {

    public static abstract class zza extends Binder implements zzi {

        /* renamed from: com.google.android.gms.maps.model.internal.zzi$zza$zza reason: collision with other inner class name */
        private static class C1526zza implements zzi {
            private IBinder zznI;

            C1526zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public Tile getTile(int x, int y, int zoom) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    obtain.writeInt(x);
                    obtain.writeInt(y);
                    obtain.writeInt(zoom);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? Tile.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        }

        public static zzi zzcX(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzi)) ? new C1526zza(iBinder) : (zzi) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    Tile tile = getTile(data.readInt(), data.readInt(), data.readInt());
                    reply.writeNoException();
                    if (tile != null) {
                        reply.writeInt(1);
                        tile.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    Tile getTile(int i, int i2, int i3) throws RemoteException;
}
