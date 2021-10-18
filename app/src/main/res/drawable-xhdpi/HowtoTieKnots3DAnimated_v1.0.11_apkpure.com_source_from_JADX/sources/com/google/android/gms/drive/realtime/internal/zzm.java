package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;

public interface zzm extends IInterface {

    public static abstract class zza extends Binder implements zzm {

        /* renamed from: com.google.android.gms.drive.realtime.internal.zzm$zza$zza reason: collision with other inner class name */
        private static class C1373zza implements zzm {
            private IBinder zznI;

            C1373zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(int i, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DriveId driveId, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (driveId != null) {
                        obtain.writeInt(1);
                        driveId.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ParcelableIndexReference parcelableIndexReference, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zznI.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zznI.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zznI.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    this.zznI.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzi zzi) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zznI.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zznI.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zznI.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, int i2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzk zzk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzk != null ? zzk.asBinder() : null);
                    this.zznI.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zznI.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(boolean z, zzo zzo) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zznI.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zznI.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zznI.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zznI.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zznI.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zznI.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zznI.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zznI.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzrm() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.zznI.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzm zzbg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new C1373zza(iBinder) : (zzm) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest] */
        /* JADX WARNING: type inference failed for: r0v8, types: [com.google.android.gms.drive.DriveId] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.drive.DriveId] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v43, types: [com.google.android.gms.drive.realtime.internal.ParcelableIndexReference] */
        /* JADX WARNING: type inference failed for: r0v46, types: [com.google.android.gms.drive.realtime.internal.ParcelableIndexReference] */
        /* JADX WARNING: type inference failed for: r0v66, types: [com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest] */
        /* JADX WARNING: type inference failed for: r0v69, types: [com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest] */
        /* JADX WARNING: type inference failed for: r0v70, types: [com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest] */
        /* JADX WARNING: type inference failed for: r0v73, types: [com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest] */
        /* JADX WARNING: type inference failed for: r0v79, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v81, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v82, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v84, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v105, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v107, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v135 */
        /* JADX WARNING: type inference failed for: r0v136 */
        /* JADX WARNING: type inference failed for: r0v137 */
        /* JADX WARNING: type inference failed for: r0v138 */
        /* JADX WARNING: type inference failed for: r0v139 */
        /* JADX WARNING: type inference failed for: r0v140 */
        /* JADX WARNING: type inference failed for: r0v141 */
        /* JADX WARNING: type inference failed for: r0v142 */
        /* JADX WARNING: type inference failed for: r0v143 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.drive.DriveId, com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.ParcelableIndexReference, com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest]
          uses: [com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest, com.google.android.gms.drive.DriveId, com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.realtime.internal.ParcelableIndexReference, com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest]
          mth insns count: 455
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
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 10 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r0 = 0
                r6 = 1
                switch(r8) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x0028;
                    case 3: goto L_0x003c;
                    case 4: goto L_0x00bf;
                    case 5: goto L_0x00dc;
                    case 6: goto L_0x00f5;
                    case 7: goto L_0x011a;
                    case 8: goto L_0x0169;
                    case 9: goto L_0x0182;
                    case 10: goto L_0x019b;
                    case 11: goto L_0x01bc;
                    case 12: goto L_0x01dd;
                    case 13: goto L_0x01fa;
                    case 14: goto L_0x0213;
                    case 15: goto L_0x022c;
                    case 16: goto L_0x0255;
                    case 17: goto L_0x027e;
                    case 18: goto L_0x02c5;
                    case 19: goto L_0x052e;
                    case 20: goto L_0x0133;
                    case 21: goto L_0x014c;
                    case 22: goto L_0x030b;
                    case 23: goto L_0x0320;
                    case 24: goto L_0x0335;
                    case 25: goto L_0x034a;
                    case 26: goto L_0x0396;
                    case 27: goto L_0x03b9;
                    case 28: goto L_0x03d2;
                    case 29: goto L_0x03ef;
                    case 30: goto L_0x0404;
                    case 31: goto L_0x041d;
                    case 32: goto L_0x0432;
                    case 33: goto L_0x0050;
                    case 34: goto L_0x0447;
                    case 35: goto L_0x0064;
                    case 36: goto L_0x045c;
                    case 37: goto L_0x029f;
                    case 38: goto L_0x0471;
                    case 39: goto L_0x048a;
                    case 40: goto L_0x0078;
                    case 41: goto L_0x02e8;
                    case 42: goto L_0x04a3;
                    case 43: goto L_0x04c0;
                    case 44: goto L_0x04e9;
                    case 45: goto L_0x008d;
                    case 46: goto L_0x00a2;
                    case 47: goto L_0x035f;
                    case 48: goto L_0x04f6;
                    case 49: goto L_0x0519;
                    case 50: goto L_0x037d;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r6 = super.onTransact(r8, r9, r10, r11)
            L_0x0009:
                return r6
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r10.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbh(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0028:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzaW(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x003c:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0050:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzaW(r0)
                r7.zzb(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0064:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r0)
                r7.zzb(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0078:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r0 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbf(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x008d:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzaW(r0)
                r7.zzc(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x00a2:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r2 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbh(r2)
                r7.zza(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x00bf:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r2 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzaZ(r2)
                r7.zza(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x00dc:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbf(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x00f5:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                if (r2 == 0) goto L_0x010a
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x010a:
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r2 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r2)
                r7.zza(r1, r0, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x011a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0133:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r1 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzaZ(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x014c:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r2 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzba(r2)
                r7.zza(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x0169:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbf(r1)
                r7.zzb(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0182:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbh(r1)
                r7.zzb(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x019b:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r3)
                r7.zza(r0, r1, r2, r3)
                r10.writeNoException()
                goto L_0x0009
            L_0x01bc:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r3)
                r7.zza(r0, r1, r2, r3)
                r10.writeNoException()
                goto L_0x0009
            L_0x01dd:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r2 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r2)
                r7.zza(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x01fa:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r1 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzaZ(r1)
                r7.zzb(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0213:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbf(r1)
                r7.zzc(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x022c:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x0245
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0245:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r3)
                r7.zza(r1, r2, r0, r3)
                r10.writeNoException()
                goto L_0x0009
            L_0x0255:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x026e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x026e:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r3 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzba(r3)
                r7.zza(r1, r2, r0, r3)
                r10.writeNoException()
                goto L_0x0009
            L_0x027e:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                int r2 = r9.readInt()
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r3 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzba(r3)
                r7.zza(r0, r1, r2, r3)
                r10.writeNoException()
                goto L_0x0009
            L_0x029f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r1 = r9.readString()
                int r2 = r9.readInt()
                java.lang.String r3 = r9.readString()
                int r4 = r9.readInt()
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r5 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r0)
                r0 = r7
                r0.zza(r1, r2, r3, r4, r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x02c5:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02d8
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r0
            L_0x02d8:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x02e8:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x02fb
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0
            L_0x02fb:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x030b:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0320:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r0)
                r7.zzb(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0335:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzaW(r0)
                r7.zzd(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x034a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzaW(r0)
                r7.zze(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x035f:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x037b
                r0 = r6
            L_0x036b:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x037b:
                r0 = 0
                goto L_0x036b
            L_0x037d:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0396:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x03a9
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.ParcelableIndexReference> r0 = com.google.android.gms.drive.realtime.internal.ParcelableIndexReference.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.ParcelableIndexReference r0 = (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r0
            L_0x03a9:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbh(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x03b9:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzk r1 = com.google.android.gms.drive.realtime.internal.zzk.zza.zzbe(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x03d2:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                int r1 = r9.readInt()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r2 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r2)
                r7.zza(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x03ef:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r0 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbf(r0)
                r7.zzb(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0404:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x041d:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zze r0 = com.google.android.gms.drive.realtime.internal.zze.zza.zzaY(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0432:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzd r0 = com.google.android.gms.drive.realtime.internal.zzd.zza.zzaX(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0447:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzi r0 = com.google.android.gms.drive.realtime.internal.zzi.zza.zzbc(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x045c:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzh r0 = com.google.android.gms.drive.realtime.internal.zzh.zza.zzbb(r0)
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0471:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x048a:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zzb(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x04a3:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                java.lang.String r1 = r9.readString()
                android.os.IBinder r2 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r2 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzaZ(r2)
                r7.zzb(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x04c0:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                java.lang.String r1 = r9.readString()
                java.lang.String r2 = r9.readString()
                int r3 = r9.readInt()
                if (r3 == 0) goto L_0x04d9
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x04d9:
                android.os.IBinder r3 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbd(r3)
                r7.zza(r1, r2, r0, r3)
                r10.writeNoException()
                goto L_0x0009
            L_0x04e9:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                r7.zzrm()
                r10.writeNoException()
                goto L_0x0009
            L_0x04f6:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0509
                android.os.Parcelable$Creator<com.google.android.gms.drive.DriveId> r0 = com.google.android.gms.drive.DriveId.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.DriveId r0 = (com.google.android.gms.drive.DriveId) r0
            L_0x0509:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0519:
                java.lang.String r0 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r0)
                android.os.IBinder r0 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r0)
                r7.zzc(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x052e:
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r9.enforceInterface(r1)
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0541
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r0 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r0
            L_0x0541:
                android.os.IBinder r1 = r9.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbi(r1)
                r7.zza(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.realtime.internal.zzm.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, zzj zzj) throws RemoteException;

    void zza(int i, zzo zzo) throws RemoteException;

    void zza(DriveId driveId, zzo zzo) throws RemoteException;

    void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzo) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzj) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzo) throws RemoteException;

    void zza(ParcelableIndexReference parcelableIndexReference, zzn zzn) throws RemoteException;

    void zza(zzc zzc) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(zze zze) throws RemoteException;

    void zza(zzh zzh) throws RemoteException;

    void zza(zzi zzi) throws RemoteException;

    void zza(zzj zzj) throws RemoteException;

    void zza(zzl zzl) throws RemoteException;

    void zza(zzo zzo) throws RemoteException;

    void zza(String str, int i, int i2, zzg zzg) throws RemoteException;

    void zza(String str, int i, int i2, zzj zzj) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzg zzg) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, int i, zzn zzn) throws RemoteException;

    void zza(String str, int i, zzo zzo) throws RemoteException;

    void zza(String str, int i, String str2, int i2, zzj zzj) throws RemoteException;

    void zza(String str, int i, String str2, zzj zzj) throws RemoteException;

    void zza(String str, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, zzf zzf) throws RemoteException;

    void zza(String str, zzj zzj) throws RemoteException;

    void zza(String str, zzk zzk) throws RemoteException;

    void zza(String str, zzl zzl) throws RemoteException;

    void zza(String str, zzn zzn) throws RemoteException;

    void zza(String str, zzo zzo) throws RemoteException;

    void zza(String str, String str2, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, String str2, zzf zzf) throws RemoteException;

    void zza(String str, String str2, zzg zzg) throws RemoteException;

    void zza(String str, String str2, zzj zzj) throws RemoteException;

    void zza(boolean z, zzo zzo) throws RemoteException;

    void zzb(zzc zzc) throws RemoteException;

    void zzb(zzj zzj) throws RemoteException;

    void zzb(zzl zzl) throws RemoteException;

    void zzb(zzo zzo) throws RemoteException;

    void zzb(String str, zzf zzf) throws RemoteException;

    void zzb(String str, zzl zzl) throws RemoteException;

    void zzb(String str, zzn zzn) throws RemoteException;

    void zzb(String str, zzo zzo) throws RemoteException;

    void zzb(String str, String str2, zzf zzf) throws RemoteException;

    void zzc(zzc zzc) throws RemoteException;

    void zzc(zzo zzo) throws RemoteException;

    void zzc(String str, zzl zzl) throws RemoteException;

    void zzd(zzc zzc) throws RemoteException;

    void zze(zzc zzc) throws RemoteException;

    void zzrm() throws RemoteException;
}
