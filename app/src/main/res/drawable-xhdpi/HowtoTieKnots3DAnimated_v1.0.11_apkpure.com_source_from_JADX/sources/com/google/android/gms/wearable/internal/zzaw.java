package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.ConnectionConfiguration;
import com.google.android.gms.wearable.PutDataRequest;

public interface zzaw extends IInterface {

    public static abstract class zza extends Binder implements zzaw {

        /* renamed from: com.google.android.gms.wearable.internal.zzaw$zza$zza reason: collision with other inner class name */
        private static class C1551zza implements zzaw {
            private IBinder zznI;

            C1551zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, byte b) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeByte(b);
                    this.zznI.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, Asset asset) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (asset != null) {
                        obtain.writeInt(1);
                        asset.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, PutDataRequest putDataRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (putDataRequest != null) {
                        obtain.writeInt(1);
                        putDataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, AddListenerRequest addListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (addListenerRequest != null) {
                        obtain.writeInt(1);
                        addListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, RemoveListenerRequest removeListenerRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (removeListenerRequest != null) {
                        obtain.writeInt(1);
                        removeListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, zzat zzat, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (zzat != null) {
                        iBinder = zzat.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznI.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    if (parcelFileDescriptor != null) {
                        obtain.writeInt(1);
                        parcelFileDescriptor.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.zznI.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.zznI.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, String str, String str2, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeByteArray(bArr);
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzau zzau, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, Uri uri, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (connectionConfiguration != null) {
                        obtain.writeInt(1);
                        connectionConfiguration.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, zzat zzat, String str) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (zzat != null) {
                        iBinder = zzat.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    obtain.writeString(str);
                    this.zznI.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.zznI.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzau zzau, boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau zzau, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeInt(i);
                    this.zznI.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau zzau, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzau zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzau zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzau zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzau zzau, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    obtain.writeString(str);
                    this.zznI.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(zzau zzau) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableService");
                    obtain.writeStrongBinder(zzau != null ? zzau.asBinder() : null);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzaw zzea(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaw)) ? new C1551zza(iBinder) : (zzaw) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.wearable.ConnectionConfiguration] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.wearable.ConnectionConfiguration] */
        /* JADX WARNING: type inference failed for: r0v42, types: [android.os.ParcelFileDescriptor] */
        /* JADX WARNING: type inference failed for: r0v45, types: [android.os.ParcelFileDescriptor] */
        /* JADX WARNING: type inference failed for: r0v70, types: [com.google.android.gms.wearable.internal.AncsNotificationParcelable] */
        /* JADX WARNING: type inference failed for: r0v73, types: [com.google.android.gms.wearable.internal.AncsNotificationParcelable] */
        /* JADX WARNING: type inference failed for: r0v86, types: [com.google.android.gms.wearable.internal.RemoveListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v89, types: [com.google.android.gms.wearable.internal.RemoveListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v90, types: [com.google.android.gms.wearable.internal.AddListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v93, types: [com.google.android.gms.wearable.internal.AddListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v112, types: [com.google.android.gms.wearable.Asset] */
        /* JADX WARNING: type inference failed for: r0v115, types: [com.google.android.gms.wearable.Asset] */
        /* JADX WARNING: type inference failed for: r0v119, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v122, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v123, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v126, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v127, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v130, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v131, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v134, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v138, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v141, types: [android.net.Uri] */
        /* JADX WARNING: type inference failed for: r0v142, types: [com.google.android.gms.wearable.PutDataRequest] */
        /* JADX WARNING: type inference failed for: r0v145, types: [com.google.android.gms.wearable.PutDataRequest] */
        /* JADX WARNING: type inference failed for: r0v158, types: [com.google.android.gms.wearable.ConnectionConfiguration] */
        /* JADX WARNING: type inference failed for: r0v161, types: [com.google.android.gms.wearable.ConnectionConfiguration] */
        /* JADX WARNING: type inference failed for: r0v163 */
        /* JADX WARNING: type inference failed for: r0v164 */
        /* JADX WARNING: type inference failed for: r0v165 */
        /* JADX WARNING: type inference failed for: r0v166 */
        /* JADX WARNING: type inference failed for: r0v167 */
        /* JADX WARNING: type inference failed for: r0v168 */
        /* JADX WARNING: type inference failed for: r0v169 */
        /* JADX WARNING: type inference failed for: r0v170 */
        /* JADX WARNING: type inference failed for: r0v171 */
        /* JADX WARNING: type inference failed for: r0v172 */
        /* JADX WARNING: type inference failed for: r0v173 */
        /* JADX WARNING: type inference failed for: r0v174 */
        /* JADX WARNING: type inference failed for: r0v175 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], android.os.ParcelFileDescriptor, com.google.android.gms.wearable.ConnectionConfiguration, com.google.android.gms.wearable.internal.AncsNotificationParcelable, com.google.android.gms.wearable.internal.RemoveListenerRequest, com.google.android.gms.wearable.internal.AddListenerRequest, com.google.android.gms.wearable.Asset, android.net.Uri, com.google.android.gms.wearable.PutDataRequest]
          uses: [com.google.android.gms.wearable.ConnectionConfiguration, android.os.ParcelFileDescriptor, com.google.android.gms.wearable.internal.AncsNotificationParcelable, com.google.android.gms.wearable.internal.RemoveListenerRequest, com.google.android.gms.wearable.internal.AddListenerRequest, com.google.android.gms.wearable.Asset, android.net.Uri, com.google.android.gms.wearable.PutDataRequest]
          mth insns count: 468
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 14 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
                r9 = this;
                r1 = 0
                r0 = 0
                r8 = 1
                switch(r10) {
                    case 2: goto L_0x04ef;
                    case 3: goto L_0x0512;
                    case 4: goto L_0x0527;
                    case 5: goto L_0x053c;
                    case 6: goto L_0x0090;
                    case 7: goto L_0x00b3;
                    case 8: goto L_0x00d6;
                    case 9: goto L_0x00eb;
                    case 11: goto L_0x0135;
                    case 12: goto L_0x017f;
                    case 13: goto L_0x01a0;
                    case 14: goto L_0x01c3;
                    case 15: goto L_0x01d8;
                    case 16: goto L_0x0255;
                    case 17: goto L_0x0278;
                    case 18: goto L_0x029b;
                    case 19: goto L_0x02b0;
                    case 20: goto L_0x0011;
                    case 21: goto L_0x0033;
                    case 22: goto L_0x004b;
                    case 23: goto L_0x005f;
                    case 24: goto L_0x0077;
                    case 25: goto L_0x02c5;
                    case 26: goto L_0x02da;
                    case 27: goto L_0x02ef;
                    case 28: goto L_0x0312;
                    case 29: goto L_0x032b;
                    case 30: goto L_0x0344;
                    case 31: goto L_0x0359;
                    case 32: goto L_0x0376;
                    case 33: goto L_0x038f;
                    case 34: goto L_0x03ac;
                    case 35: goto L_0x03cd;
                    case 37: goto L_0x0448;
                    case 38: goto L_0x03ee;
                    case 39: goto L_0x0415;
                    case 40: goto L_0x010e;
                    case 41: goto L_0x0158;
                    case 42: goto L_0x01ed;
                    case 43: goto L_0x020a;
                    case 46: goto L_0x0223;
                    case 47: goto L_0x023c;
                    case 48: goto L_0x045d;
                    case 49: goto L_0x047b;
                    case 50: goto L_0x0490;
                    case 51: goto L_0x04ac;
                    case 52: goto L_0x04c1;
                    case 53: goto L_0x04d6;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r8 = super.onTransact(r10, r11, r12, r13)
            L_0x000a:
                return r8
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r12.writeString(r0)
                goto L_0x000a
            L_0x0011:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x002c
                android.os.Parcelable$Creator<com.google.android.gms.wearable.ConnectionConfiguration> r0 = com.google.android.gms.wearable.ConnectionConfiguration.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.ConnectionConfiguration r0 = (com.google.android.gms.wearable.ConnectionConfiguration) r0
            L_0x002c:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0033:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                r9.zza(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x004b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zza(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x005f:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                r9.zzb(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x0077:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                r9.zzc(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x0090:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x00ab
                android.os.Parcelable$Creator<com.google.android.gms.wearable.PutDataRequest> r0 = com.google.android.gms.wearable.PutDataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.PutDataRequest r0 = (com.google.android.gms.wearable.PutDataRequest) r0
            L_0x00ab:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x00b3:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x00ce
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x00ce:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x00d6:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzb(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x00eb:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0106
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0106:
                r9.zzb(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x010e:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0129
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0129:
                int r2 = r11.readInt()
                r9.zza(r1, r0, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x0135:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0150
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0150:
                r9.zzc(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0158:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0173
                android.os.Parcelable$Creator r0 = android.net.Uri.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.net.Uri r0 = (android.net.Uri) r0
            L_0x0173:
                int r2 = r11.readInt()
                r9.zzb(r1, r0, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x017f:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                java.lang.String r2 = r11.readString()
                byte[] r3 = r11.createByteArray()
                r9.zza(r0, r1, r2, r3)
                r12.writeNoException()
                goto L_0x000a
            L_0x01a0:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x01bb
                android.os.Parcelable$Creator<com.google.android.gms.wearable.Asset> r0 = com.google.android.gms.wearable.Asset.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.Asset r0 = (com.google.android.gms.wearable.Asset) r0
            L_0x01bb:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x01c3:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzc(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x01d8:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzd(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x01ed:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                int r2 = r11.readInt()
                r9.zza(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x020a:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                int r1 = r11.readInt()
                r9.zza(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x0223:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                r9.zzd(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x023c:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                r9.zze(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x0255:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0270
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AddListenerRequest> r0 = com.google.android.gms.wearable.internal.AddListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.internal.AddListenerRequest r0 = (com.google.android.gms.wearable.internal.AddListenerRequest) r0
            L_0x0270:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0278:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x0293
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.RemoveListenerRequest> r0 = com.google.android.gms.wearable.internal.RemoveListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.internal.RemoveListenerRequest r0 = (com.google.android.gms.wearable.internal.RemoveListenerRequest) r0
            L_0x0293:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x029b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zze(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x02b0:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzf(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x02c5:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzg(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x02da:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzh(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x02ef:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x030a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AncsNotificationParcelable> r0 = com.google.android.gms.wearable.internal.AncsNotificationParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.internal.AncsNotificationParcelable r0 = (com.google.android.gms.wearable.internal.AncsNotificationParcelable) r0
            L_0x030a:
                r9.zza(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0312:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                int r1 = r11.readInt()
                r9.zzb(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x032b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                int r1 = r11.readInt()
                r9.zzc(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x0344:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzi(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0359:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                java.lang.String r2 = r11.readString()
                r9.zza(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x0376:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                r9.zzf(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x038f:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                java.lang.String r1 = r11.readString()
                int r2 = r11.readInt()
                r9.zzb(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x03ac:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzat r1 = com.google.android.gms.wearable.internal.zzat.zza.zzdX(r1)
                java.lang.String r2 = r11.readString()
                r9.zza(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x03cd:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzat r1 = com.google.android.gms.wearable.internal.zzat.zza.zzdX(r1)
                java.lang.String r2 = r11.readString()
                r9.zzb(r0, r1, r2)
                r12.writeNoException()
                goto L_0x000a
            L_0x03ee:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                java.lang.String r2 = r11.readString()
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x040d
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
            L_0x040d:
                r9.zza(r1, r2, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0415:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                java.lang.String r2 = r11.readString()
                int r3 = r11.readInt()
                if (r3 == 0) goto L_0x0446
                android.os.Parcelable$Creator r0 = android.os.ParcelFileDescriptor.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                android.os.ParcelFileDescriptor r0 = (android.os.ParcelFileDescriptor) r0
                r3 = r0
            L_0x0435:
                long r4 = r11.readLong()
                long r6 = r11.readLong()
                r0 = r9
                r0.zza(r1, r2, r3, r4, r6)
                r12.writeNoException()
                goto L_0x000a
            L_0x0446:
                r3 = r0
                goto L_0x0435
            L_0x0448:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzj(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x045d:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r2 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0479
                r0 = r8
            L_0x0471:
                r9.zza(r2, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0479:
                r0 = r1
                goto L_0x0471
            L_0x047b:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzk(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0490:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x04a4
                r1 = r8
            L_0x04a4:
                r9.zzb(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x04ac:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzl(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x04c1:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzm(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x04d6:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                byte r1 = r11.readByte()
                r9.zza(r0, r1)
                r12.writeNoException()
                goto L_0x000a
            L_0x04ef:
                java.lang.String r1 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r1)
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r1 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r1)
                int r2 = r11.readInt()
                if (r2 == 0) goto L_0x050a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.ConnectionConfiguration> r0 = com.google.android.gms.wearable.ConnectionConfiguration.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                com.google.android.gms.wearable.ConnectionConfiguration r0 = (com.google.android.gms.wearable.ConnectionConfiguration) r0
            L_0x050a:
                r9.zzb(r1, r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0512:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzn(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x0527:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzo(r0)
                r12.writeNoException()
                goto L_0x000a
            L_0x053c:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableService"
                r11.enforceInterface(r0)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.wearable.internal.zzau r0 = com.google.android.gms.wearable.internal.zzau.zza.zzdY(r0)
                r9.zzp(r0)
                r12.writeNoException()
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzaw.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(zzau zzau) throws RemoteException;

    void zza(zzau zzau, byte b) throws RemoteException;

    void zza(zzau zzau, int i) throws RemoteException;

    void zza(zzau zzau, Uri uri) throws RemoteException;

    void zza(zzau zzau, Uri uri, int i) throws RemoteException;

    void zza(zzau zzau, Asset asset) throws RemoteException;

    void zza(zzau zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zza(zzau zzau, PutDataRequest putDataRequest) throws RemoteException;

    void zza(zzau zzau, AddListenerRequest addListenerRequest) throws RemoteException;

    void zza(zzau zzau, AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(zzau zzau, RemoveListenerRequest removeListenerRequest) throws RemoteException;

    void zza(zzau zzau, zzat zzat, String str) throws RemoteException;

    void zza(zzau zzau, String str) throws RemoteException;

    void zza(zzau zzau, String str, int i) throws RemoteException;

    void zza(zzau zzau, String str, ParcelFileDescriptor parcelFileDescriptor) throws RemoteException;

    void zza(zzau zzau, String str, ParcelFileDescriptor parcelFileDescriptor, long j, long j2) throws RemoteException;

    void zza(zzau zzau, String str, String str2) throws RemoteException;

    void zza(zzau zzau, String str, String str2, byte[] bArr) throws RemoteException;

    void zza(zzau zzau, boolean z) throws RemoteException;

    void zzb(zzau zzau) throws RemoteException;

    void zzb(zzau zzau, int i) throws RemoteException;

    void zzb(zzau zzau, Uri uri) throws RemoteException;

    void zzb(zzau zzau, Uri uri, int i) throws RemoteException;

    void zzb(zzau zzau, ConnectionConfiguration connectionConfiguration) throws RemoteException;

    void zzb(zzau zzau, zzat zzat, String str) throws RemoteException;

    void zzb(zzau zzau, String str) throws RemoteException;

    void zzb(zzau zzau, String str, int i) throws RemoteException;

    void zzb(zzau zzau, boolean z) throws RemoteException;

    void zzc(zzau zzau) throws RemoteException;

    void zzc(zzau zzau, int i) throws RemoteException;

    void zzc(zzau zzau, Uri uri) throws RemoteException;

    void zzc(zzau zzau, String str) throws RemoteException;

    void zzd(zzau zzau) throws RemoteException;

    void zzd(zzau zzau, String str) throws RemoteException;

    void zze(zzau zzau) throws RemoteException;

    void zze(zzau zzau, String str) throws RemoteException;

    void zzf(zzau zzau) throws RemoteException;

    void zzf(zzau zzau, String str) throws RemoteException;

    void zzg(zzau zzau) throws RemoteException;

    void zzh(zzau zzau) throws RemoteException;

    void zzi(zzau zzau) throws RemoteException;

    void zzj(zzau zzau) throws RemoteException;

    void zzk(zzau zzau) throws RemoteException;

    void zzl(zzau zzau) throws RemoteException;

    void zzm(zzau zzau) throws RemoteException;

    void zzn(zzau zzau) throws RemoteException;

    void zzo(zzau zzau) throws RemoteException;

    void zzp(zzau zzau) throws RemoteException;
}
