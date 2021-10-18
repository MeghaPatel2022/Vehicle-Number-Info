package com.google.android.gms.vision.face.internal.client;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {

        /* renamed from: com.google.android.gms.vision.face.internal.client.zzc$zza$zza reason: collision with other inner class name */
        private static class C1546zza implements zzc {
            private IBinder zznI;

            C1546zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zzCf() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public FaceParcel[] zzc(zzd zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (frameMetadataParcel != null) {
                        obtain.writeInt(1);
                        frameMetadataParcel.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return (FaceParcel[]) obtain2.createTypedArray(FaceParcel.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzjG(int i) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    obtain.writeInt(i);
                    this.zznI.transact(2, obtain, obtain2, 0);
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
        }

        public static zzc zzdM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzc)) ? new C1546zza(iBinder) : (zzc) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    FaceParcel[] zzc = zzc(com.google.android.gms.dynamic.zzd.zza.zzbk(data.readStrongBinder()), data.readInt() != 0 ? FrameMetadataParcel.CREATOR.createFromParcel(data) : null);
                    reply.writeNoException();
                    reply.writeTypedArray(zzc, 1);
                    return true;
                case 2:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    boolean zzjG = zzjG(data.readInt());
                    reply.writeNoException();
                    reply.writeInt(zzjG ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    zzCf();
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zzCf() throws RemoteException;

    FaceParcel[] zzc(zzd zzd, FrameMetadataParcel frameMetadataParcel) throws RemoteException;

    boolean zzjG(int i) throws RemoteException;
}
