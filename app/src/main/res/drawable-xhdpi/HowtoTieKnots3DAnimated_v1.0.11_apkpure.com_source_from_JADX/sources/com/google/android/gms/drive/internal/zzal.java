package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public interface zzal extends IInterface {

    public static abstract class zza extends Binder implements zzal {

        /* renamed from: com.google.android.gms.drive.internal.zzal$zza$zza reason: collision with other inner class name */
        private static class C1359zza implements zzal {
            private IBinder zznI;

            C1359zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzam zzam) throws RemoteException {
                DriveServiceResponse driveServiceResponse = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = (DriveServiceResponse) DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    return driveServiceResponse;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddEventListenerRequest addEventListenerRequest, zzan zzan, String str, zzam zzam) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    obtain.writeString(str);
                    if (zzam != null) {
                        iBinder = zzam.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddPermissionRequest addPermissionRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsRequest closeContentsRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ControlProgressRequest controlProgressRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (controlProgressRequest != null) {
                        obtain.writeInt(1);
                        controlProgressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateContentsRequest createContentsRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFileRequest createFileRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFolderRequest createFolderRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DeleteResourceRequest deleteResourceRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
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

            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetChangesRequest getChangesRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetMetadataRequest getMetadataRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetPermissionsRequest getPermissionsRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ListParentsRequest listParentsRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzan zzan, zzam zzam) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    if (zzam != null) {
                        iBinder = zzam.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzan zzan, String str, zzam zzam) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    obtain.writeString(str);
                    if (zzam != null) {
                        iBinder = zzam.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemovePermissionRequest removePermissionRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setDrivePreferencesRequest != null) {
                        obtain.writeInt(1);
                        setDrivePreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(TrashResourceRequest trashResourceRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UntrashResourceRequest untrashResourceRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdateMetadataRequest updateMetadataRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdatePermissionRequest updatePermissionRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzan zzan, zzam zzam) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    if (zzam != null) {
                        iBinder = zzam.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(QueryRequest queryRequest, zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzam zzam) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzam != null ? zzam.asBinder() : null);
                    this.zznI.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzal zzaS(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzal)) ? new C1359zza(iBinder) : (zzal) queryLocalInterface;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.drive.internal.ControlProgressRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.drive.internal.ControlProgressRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.drive.internal.RemovePermissionRequest] */
        /* JADX WARNING: type inference failed for: r0v19, types: [com.google.android.gms.drive.internal.RemovePermissionRequest] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.drive.internal.UpdatePermissionRequest] */
        /* JADX WARNING: type inference failed for: r0v24, types: [com.google.android.gms.drive.internal.UpdatePermissionRequest] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.drive.internal.AddPermissionRequest] */
        /* JADX WARNING: type inference failed for: r0v29, types: [com.google.android.gms.drive.internal.AddPermissionRequest] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.drive.internal.GetPermissionsRequest] */
        /* JADX WARNING: type inference failed for: r0v34, types: [com.google.android.gms.drive.internal.GetPermissionsRequest] */
        /* JADX WARNING: type inference failed for: r0v35, types: [com.google.android.gms.drive.internal.UnsubscribeResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v39, types: [com.google.android.gms.drive.internal.UnsubscribeResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v40, types: [com.google.android.gms.drive.internal.GetChangesRequest] */
        /* JADX WARNING: type inference failed for: r0v44, types: [com.google.android.gms.drive.internal.GetChangesRequest] */
        /* JADX WARNING: type inference failed for: r0v49, types: [com.google.android.gms.drive.internal.FetchThumbnailRequest] */
        /* JADX WARNING: type inference failed for: r0v53, types: [com.google.android.gms.drive.internal.FetchThumbnailRequest] */
        /* JADX WARNING: type inference failed for: r0v58, types: [com.google.android.gms.drive.internal.UntrashResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v62, types: [com.google.android.gms.drive.internal.UntrashResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v63, types: [com.google.android.gms.drive.internal.CancelPendingActionsRequest] */
        /* JADX WARNING: type inference failed for: r0v67, types: [com.google.android.gms.drive.internal.CancelPendingActionsRequest] */
        /* JADX WARNING: type inference failed for: r0v68, types: [com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest] */
        /* JADX WARNING: type inference failed for: r0v72, types: [com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest] */
        /* JADX WARNING: type inference failed for: r0v77, types: [com.google.android.gms.drive.RealtimeDocumentSyncRequest] */
        /* JADX WARNING: type inference failed for: r0v81, types: [com.google.android.gms.drive.RealtimeDocumentSyncRequest] */
        /* JADX WARNING: type inference failed for: r0v82, types: [com.google.android.gms.drive.internal.SetDrivePreferencesRequest] */
        /* JADX WARNING: type inference failed for: r0v86, types: [com.google.android.gms.drive.internal.SetDrivePreferencesRequest] */
        /* JADX WARNING: type inference failed for: r0v95, types: [com.google.android.gms.drive.internal.CheckResourceIdsExistRequest] */
        /* JADX WARNING: type inference failed for: r0v99, types: [com.google.android.gms.drive.internal.CheckResourceIdsExistRequest] */
        /* JADX WARNING: type inference failed for: r0v100, types: [com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest] */
        /* JADX WARNING: type inference failed for: r0v104, types: [com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest] */
        /* JADX WARNING: type inference failed for: r0v105, types: [com.google.android.gms.drive.internal.SetResourceParentsRequest] */
        /* JADX WARNING: type inference failed for: r0v109, types: [com.google.android.gms.drive.internal.SetResourceParentsRequest] */
        /* JADX WARNING: type inference failed for: r0v110, types: [com.google.android.gms.drive.internal.LoadRealtimeRequest] */
        /* JADX WARNING: type inference failed for: r0v114, types: [com.google.android.gms.drive.internal.LoadRealtimeRequest] */
        /* JADX WARNING: type inference failed for: r0v115, types: [com.google.android.gms.drive.internal.DeleteResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v119, types: [com.google.android.gms.drive.internal.DeleteResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v120, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v124, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v125, types: [com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v129, types: [com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v130, types: [com.google.android.gms.drive.internal.TrashResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v134, types: [com.google.android.gms.drive.internal.TrashResourceRequest] */
        /* JADX WARNING: type inference failed for: r0v135, types: [com.google.android.gms.drive.internal.DisconnectRequest] */
        /* JADX WARNING: type inference failed for: r0v139, types: [com.google.android.gms.drive.internal.DisconnectRequest] */
        /* JADX WARNING: type inference failed for: r0v140, types: [com.google.android.gms.drive.internal.RemoveEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v144, types: [com.google.android.gms.drive.internal.RemoveEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v145, types: [com.google.android.gms.drive.internal.AddEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v149, types: [com.google.android.gms.drive.internal.AddEventListenerRequest] */
        /* JADX WARNING: type inference failed for: r0v150, types: [com.google.android.gms.drive.internal.ListParentsRequest] */
        /* JADX WARNING: type inference failed for: r0v154, types: [com.google.android.gms.drive.internal.ListParentsRequest] */
        /* JADX WARNING: type inference failed for: r0v155, types: [com.google.android.gms.drive.internal.AuthorizeAccessRequest] */
        /* JADX WARNING: type inference failed for: r0v159, types: [com.google.android.gms.drive.internal.AuthorizeAccessRequest] */
        /* JADX WARNING: type inference failed for: r0v160, types: [com.google.android.gms.drive.internal.CreateFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v165, types: [com.google.android.gms.drive.internal.CreateFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v166, types: [com.google.android.gms.drive.internal.OpenFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v171, types: [com.google.android.gms.drive.internal.OpenFileIntentSenderRequest] */
        /* JADX WARNING: type inference failed for: r0v176, types: [com.google.android.gms.drive.internal.CloseContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v180, types: [com.google.android.gms.drive.internal.CloseContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v181, types: [com.google.android.gms.drive.internal.OpenContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v186, types: [com.google.android.gms.drive.internal.OpenContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v187, types: [com.google.android.gms.drive.internal.CreateFolderRequest] */
        /* JADX WARNING: type inference failed for: r0v191, types: [com.google.android.gms.drive.internal.CreateFolderRequest] */
        /* JADX WARNING: type inference failed for: r0v192, types: [com.google.android.gms.drive.internal.CreateFileRequest] */
        /* JADX WARNING: type inference failed for: r0v196, types: [com.google.android.gms.drive.internal.CreateFileRequest] */
        /* JADX WARNING: type inference failed for: r0v197, types: [com.google.android.gms.drive.internal.CreateContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v201, types: [com.google.android.gms.drive.internal.CreateContentsRequest] */
        /* JADX WARNING: type inference failed for: r0v202, types: [com.google.android.gms.drive.internal.UpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v206, types: [com.google.android.gms.drive.internal.UpdateMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v207, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v211, types: [com.google.android.gms.drive.internal.QueryRequest] */
        /* JADX WARNING: type inference failed for: r0v212, types: [com.google.android.gms.drive.internal.GetMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v216, types: [com.google.android.gms.drive.internal.GetMetadataRequest] */
        /* JADX WARNING: type inference failed for: r0v220 */
        /* JADX WARNING: type inference failed for: r0v221 */
        /* JADX WARNING: type inference failed for: r0v222 */
        /* JADX WARNING: type inference failed for: r0v223 */
        /* JADX WARNING: type inference failed for: r0v224 */
        /* JADX WARNING: type inference failed for: r0v225 */
        /* JADX WARNING: type inference failed for: r0v226 */
        /* JADX WARNING: type inference failed for: r0v227 */
        /* JADX WARNING: type inference failed for: r0v228 */
        /* JADX WARNING: type inference failed for: r0v229 */
        /* JADX WARNING: type inference failed for: r0v230 */
        /* JADX WARNING: type inference failed for: r0v231 */
        /* JADX WARNING: type inference failed for: r0v232 */
        /* JADX WARNING: type inference failed for: r0v233 */
        /* JADX WARNING: type inference failed for: r0v234 */
        /* JADX WARNING: type inference failed for: r0v235 */
        /* JADX WARNING: type inference failed for: r0v236 */
        /* JADX WARNING: type inference failed for: r0v237 */
        /* JADX WARNING: type inference failed for: r0v238 */
        /* JADX WARNING: type inference failed for: r0v239 */
        /* JADX WARNING: type inference failed for: r0v240 */
        /* JADX WARNING: type inference failed for: r0v241 */
        /* JADX WARNING: type inference failed for: r0v242 */
        /* JADX WARNING: type inference failed for: r0v243 */
        /* JADX WARNING: type inference failed for: r0v244 */
        /* JADX WARNING: type inference failed for: r0v245 */
        /* JADX WARNING: type inference failed for: r0v246 */
        /* JADX WARNING: type inference failed for: r0v247 */
        /* JADX WARNING: type inference failed for: r0v248 */
        /* JADX WARNING: type inference failed for: r0v249 */
        /* JADX WARNING: type inference failed for: r0v250 */
        /* JADX WARNING: type inference failed for: r0v251 */
        /* JADX WARNING: type inference failed for: r0v252 */
        /* JADX WARNING: type inference failed for: r0v253 */
        /* JADX WARNING: type inference failed for: r0v254 */
        /* JADX WARNING: type inference failed for: r0v255 */
        /* JADX WARNING: type inference failed for: r0v256 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.ControlProgressRequest, com.google.android.gms.drive.internal.RemovePermissionRequest, com.google.android.gms.drive.internal.UpdatePermissionRequest, com.google.android.gms.drive.internal.AddPermissionRequest, com.google.android.gms.drive.internal.GetPermissionsRequest, com.google.android.gms.drive.internal.UnsubscribeResourceRequest, com.google.android.gms.drive.internal.GetChangesRequest, com.google.android.gms.drive.internal.FetchThumbnailRequest, com.google.android.gms.drive.internal.UntrashResourceRequest, com.google.android.gms.drive.internal.CancelPendingActionsRequest, com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest, com.google.android.gms.drive.RealtimeDocumentSyncRequest, com.google.android.gms.drive.internal.SetDrivePreferencesRequest, com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.DisconnectRequest, com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.CreateFileIntentSenderRequest, com.google.android.gms.drive.internal.OpenFileIntentSenderRequest, com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.GetMetadataRequest]
          uses: [com.google.android.gms.drive.internal.ControlProgressRequest, com.google.android.gms.drive.internal.QueryRequest, com.google.android.gms.drive.internal.RemovePermissionRequest, com.google.android.gms.drive.internal.UpdatePermissionRequest, com.google.android.gms.drive.internal.AddPermissionRequest, com.google.android.gms.drive.internal.GetPermissionsRequest, com.google.android.gms.drive.internal.UnsubscribeResourceRequest, com.google.android.gms.drive.internal.GetChangesRequest, com.google.android.gms.drive.internal.FetchThumbnailRequest, com.google.android.gms.drive.internal.UntrashResourceRequest, com.google.android.gms.drive.internal.CancelPendingActionsRequest, com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest, com.google.android.gms.drive.RealtimeDocumentSyncRequest, com.google.android.gms.drive.internal.SetDrivePreferencesRequest, com.google.android.gms.drive.internal.CheckResourceIdsExistRequest, com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest, com.google.android.gms.drive.internal.SetResourceParentsRequest, com.google.android.gms.drive.internal.LoadRealtimeRequest, com.google.android.gms.drive.internal.DeleteResourceRequest, com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest, com.google.android.gms.drive.internal.TrashResourceRequest, com.google.android.gms.drive.internal.DisconnectRequest, com.google.android.gms.drive.internal.RemoveEventListenerRequest, com.google.android.gms.drive.internal.AddEventListenerRequest, com.google.android.gms.drive.internal.ListParentsRequest, com.google.android.gms.drive.internal.AuthorizeAccessRequest, com.google.android.gms.drive.internal.CreateFileIntentSenderRequest, com.google.android.gms.drive.internal.OpenFileIntentSenderRequest, com.google.android.gms.drive.internal.CloseContentsRequest, com.google.android.gms.drive.internal.OpenContentsRequest, com.google.android.gms.drive.internal.CreateFolderRequest, com.google.android.gms.drive.internal.CreateFileRequest, com.google.android.gms.drive.internal.CreateContentsRequest, com.google.android.gms.drive.internal.UpdateMetadataRequest, com.google.android.gms.drive.internal.GetMetadataRequest]
          mth insns count: 553
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
        /* JADX WARNING: Unknown variable types count: 38 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r3 = 0
                r0 = 0
                r1 = 1
                switch(r6) {
                    case 1: goto L_0x0012;
                    case 2: goto L_0x0035;
                    case 3: goto L_0x0058;
                    case 4: goto L_0x007b;
                    case 5: goto L_0x009f;
                    case 6: goto L_0x00c3;
                    case 7: goto L_0x00e7;
                    case 8: goto L_0x0118;
                    case 9: goto L_0x013c;
                    case 10: goto L_0x0152;
                    case 11: goto L_0x017b;
                    case 12: goto L_0x01a4;
                    case 13: goto L_0x01c8;
                    case 14: goto L_0x01ec;
                    case 15: goto L_0x021c;
                    case 16: goto L_0x024c;
                    case 17: goto L_0x0268;
                    case 18: goto L_0x028c;
                    case 19: goto L_0x02b0;
                    case 24: goto L_0x02d4;
                    case 27: goto L_0x02f8;
                    case 28: goto L_0x031c;
                    case 29: goto L_0x0340;
                    case 30: goto L_0x0364;
                    case 31: goto L_0x0388;
                    case 32: goto L_0x039e;
                    case 33: goto L_0x03b4;
                    case 34: goto L_0x03d8;
                    case 35: goto L_0x03fc;
                    case 36: goto L_0x0412;
                    case 37: goto L_0x0436;
                    case 38: goto L_0x045a;
                    case 41: goto L_0x047e;
                    case 42: goto L_0x0494;
                    case 43: goto L_0x04b8;
                    case 44: goto L_0x04ce;
                    case 46: goto L_0x04f2;
                    case 47: goto L_0x0516;
                    case 48: goto L_0x053a;
                    case 49: goto L_0x055e;
                    case 50: goto L_0x0582;
                    case 51: goto L_0x05a6;
                    case 52: goto L_0x05d2;
                    case 53: goto L_0x05f0;
                    case 1598968902: goto L_0x000b;
                    default: goto L_0x0006;
                }
            L_0x0006:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
            L_0x000a:
                return r0
            L_0x000b:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r8.writeString(r0)
                r0 = r1
                goto L_0x000a
            L_0x0012:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0025
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetMetadataRequest> r0 = com.google.android.gms.drive.internal.GetMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetMetadataRequest r0 = (com.google.android.gms.drive.internal.GetMetadataRequest) r0
            L_0x0025:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0035:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0048
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x0048:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0058:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x006b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.UpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.UpdateMetadataRequest) r0
            L_0x006b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x007b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x008e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateContentsRequest> r0 = com.google.android.gms.drive.internal.CreateContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateContentsRequest r0 = (com.google.android.gms.drive.internal.CreateContentsRequest) r0
            L_0x008e:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x009f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00b2
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileRequest> r0 = com.google.android.gms.drive.internal.CreateFileRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileRequest r0 = (com.google.android.gms.drive.internal.CreateFileRequest) r0
            L_0x00b2:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00c3:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00d6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFolderRequest> r0 = com.google.android.gms.drive.internal.CreateFolderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFolderRequest r0 = (com.google.android.gms.drive.internal.CreateFolderRequest) r0
            L_0x00d6:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x00e7:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x00fa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenContentsRequest> r0 = com.google.android.gms.drive.internal.OpenContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenContentsRequest r0 = (com.google.android.gms.drive.internal.OpenContentsRequest) r0
            L_0x00fa:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                com.google.android.gms.drive.internal.DriveServiceResponse r0 = r5.zza(r0, r2)
                r8.writeNoException()
                if (r0 == 0) goto L_0x0114
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0111:
                r0 = r1
                goto L_0x000a
            L_0x0114:
                r8.writeInt(r3)
                goto L_0x0111
            L_0x0118:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x012b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsRequest> r0 = com.google.android.gms.drive.internal.CloseContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsRequest r0 = (com.google.android.gms.drive.internal.CloseContentsRequest) r0
            L_0x012b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x013c:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r0 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r0)
                r5.zza(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0152:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0165
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.OpenFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r0
            L_0x0165:
                android.content.IntentSender r0 = r5.zza(r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x0177
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x0174:
                r0 = r1
                goto L_0x000a
            L_0x0177:
                r8.writeInt(r3)
                goto L_0x0174
            L_0x017b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x018e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileIntentSenderRequest> r0 = com.google.android.gms.drive.internal.CreateFileIntentSenderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileIntentSenderRequest r0 = (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r0
            L_0x018e:
                android.content.IntentSender r0 = r5.zza(r0)
                r8.writeNoException()
                if (r0 == 0) goto L_0x01a0
                r8.writeInt(r1)
                r0.writeToParcel(r8, r1)
            L_0x019d:
                r0 = r1
                goto L_0x000a
            L_0x01a0:
                r8.writeInt(r3)
                goto L_0x019d
            L_0x01a4:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01b7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AuthorizeAccessRequest> r0 = com.google.android.gms.drive.internal.AuthorizeAccessRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AuthorizeAccessRequest r0 = (com.google.android.gms.drive.internal.AuthorizeAccessRequest) r0
            L_0x01b7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01c8:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01db
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ListParentsRequest> r0 = com.google.android.gms.drive.internal.ListParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ListParentsRequest r0 = (com.google.android.gms.drive.internal.ListParentsRequest) r0
            L_0x01db:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x01ec:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x01ff
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddEventListenerRequest> r0 = com.google.android.gms.drive.internal.AddEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AddEventListenerRequest r0 = (com.google.android.gms.drive.internal.AddEventListenerRequest) r0
            L_0x01ff:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzaU(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r4 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r4)
                r5.zza(r0, r2, r3, r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x021c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x022f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemoveEventListenerRequest> r0 = com.google.android.gms.drive.internal.RemoveEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.RemoveEventListenerRequest r0 = (com.google.android.gms.drive.internal.RemoveEventListenerRequest) r0
            L_0x022f:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzaU(r2)
                java.lang.String r3 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r4 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r4)
                r5.zza(r0, r2, r3, r4)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x024c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x025f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DisconnectRequest> r0 = com.google.android.gms.drive.internal.DisconnectRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DisconnectRequest r0 = (com.google.android.gms.drive.internal.DisconnectRequest) r0
            L_0x025f:
                r5.zza(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0268:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x027b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.TrashResourceRequest> r0 = com.google.android.gms.drive.internal.TrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.TrashResourceRequest r0 = (com.google.android.gms.drive.internal.TrashResourceRequest) r0
            L_0x027b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x028c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x029f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest r0 = (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r0
            L_0x029f:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02b0:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x02c3
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x02c3:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zzb(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02d4:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x02e7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DeleteResourceRequest> r0 = com.google.android.gms.drive.internal.DeleteResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.DeleteResourceRequest r0 = (com.google.android.gms.drive.internal.DeleteResourceRequest) r0
            L_0x02e7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x02f8:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x030b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.LoadRealtimeRequest> r0 = com.google.android.gms.drive.internal.LoadRealtimeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.LoadRealtimeRequest r0 = (com.google.android.gms.drive.internal.LoadRealtimeRequest) r0
            L_0x030b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x031c:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x032f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetResourceParentsRequest> r0 = com.google.android.gms.drive.internal.SetResourceParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetResourceParentsRequest r0 = (com.google.android.gms.drive.internal.SetResourceParentsRequest) r0
            L_0x032f:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0340:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0353
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest> r0 = com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest r0 = (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r0
            L_0x0353:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0364:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0377
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CheckResourceIdsExistRequest> r0 = com.google.android.gms.drive.internal.CheckResourceIdsExistRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CheckResourceIdsExistRequest r0 = (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r0
            L_0x0377:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0388:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r0 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r0)
                r5.zzb(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x039e:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r0 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r0)
                r5.zzc(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03b4:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x03c7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetDrivePreferencesRequest> r0 = com.google.android.gms.drive.internal.SetDrivePreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetDrivePreferencesRequest r0 = (com.google.android.gms.drive.internal.SetDrivePreferencesRequest) r0
            L_0x03c7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03d8:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x03eb
                android.os.Parcelable$Creator<com.google.android.gms.drive.RealtimeDocumentSyncRequest> r0 = com.google.android.gms.drive.RealtimeDocumentSyncRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.RealtimeDocumentSyncRequest r0 = (com.google.android.gms.drive.RealtimeDocumentSyncRequest) r0
            L_0x03eb:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x03fc:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r0 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r0)
                r5.zzd(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0412:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0425
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest> r0 = com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest r0 = (com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest) r0
            L_0x0425:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0436:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0449
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CancelPendingActionsRequest> r0 = com.google.android.gms.drive.internal.CancelPendingActionsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.CancelPendingActionsRequest r0 = (com.google.android.gms.drive.internal.CancelPendingActionsRequest) r0
            L_0x0449:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x045a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x046d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UntrashResourceRequest> r0 = com.google.android.gms.drive.internal.UntrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UntrashResourceRequest r0 = (com.google.android.gms.drive.internal.UntrashResourceRequest) r0
            L_0x046d:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x047e:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r0 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r0)
                r5.zze(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0494:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x04a7
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.FetchThumbnailRequest> r0 = com.google.android.gms.drive.internal.FetchThumbnailRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.FetchThumbnailRequest r0 = (com.google.android.gms.drive.internal.FetchThumbnailRequest) r0
            L_0x04a7:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x04b8:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r0 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r0)
                r5.zzf(r0)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x04ce:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x04e1
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetChangesRequest> r0 = com.google.android.gms.drive.internal.GetChangesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetChangesRequest r0 = (com.google.android.gms.drive.internal.GetChangesRequest) r0
            L_0x04e1:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x04f2:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0505
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UnsubscribeResourceRequest> r0 = com.google.android.gms.drive.internal.UnsubscribeResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UnsubscribeResourceRequest r0 = (com.google.android.gms.drive.internal.UnsubscribeResourceRequest) r0
            L_0x0505:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0516:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0529
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetPermissionsRequest> r0 = com.google.android.gms.drive.internal.GetPermissionsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.GetPermissionsRequest r0 = (com.google.android.gms.drive.internal.GetPermissionsRequest) r0
            L_0x0529:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x053a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x054d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddPermissionRequest> r0 = com.google.android.gms.drive.internal.AddPermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.AddPermissionRequest r0 = (com.google.android.gms.drive.internal.AddPermissionRequest) r0
            L_0x054d:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x055e:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0571
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdatePermissionRequest> r0 = com.google.android.gms.drive.internal.UpdatePermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.UpdatePermissionRequest r0 = (com.google.android.gms.drive.internal.UpdatePermissionRequest) r0
            L_0x0571:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x0582:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0595
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemovePermissionRequest> r0 = com.google.android.gms.drive.internal.RemovePermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.RemovePermissionRequest r0 = (com.google.android.gms.drive.internal.RemovePermissionRequest) r0
            L_0x0595:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x05a6:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x05b9
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.QueryRequest r0 = (com.google.android.gms.drive.internal.QueryRequest) r0
            L_0x05b9:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzaU(r2)
                android.os.IBinder r3 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r3 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r3)
                r5.zza(r0, r2, r3)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x05d2:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r0)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzaU(r0)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            L_0x05f0:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0603
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ControlProgressRequest> r0 = com.google.android.gms.drive.internal.ControlProgressRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                com.google.android.gms.drive.internal.ControlProgressRequest r0 = (com.google.android.gms.drive.internal.ControlProgressRequest) r0
            L_0x0603:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzam r2 = com.google.android.gms.drive.internal.zzam.zza.zzaT(r2)
                r5.zza(r0, r2)
                r8.writeNoException()
                r0 = r1
                goto L_0x000a
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzal.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzam zzam) throws RemoteException;

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzam zzam) throws RemoteException;

    void zza(AddEventListenerRequest addEventListenerRequest, zzan zzan, String str, zzam zzam) throws RemoteException;

    void zza(AddPermissionRequest addPermissionRequest, zzam zzam) throws RemoteException;

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzam zzam) throws RemoteException;

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzam zzam) throws RemoteException;

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzam zzam) throws RemoteException;

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzam zzam) throws RemoteException;

    void zza(CloseContentsRequest closeContentsRequest, zzam zzam) throws RemoteException;

    void zza(ControlProgressRequest controlProgressRequest, zzam zzam) throws RemoteException;

    void zza(CreateContentsRequest createContentsRequest, zzam zzam) throws RemoteException;

    void zza(CreateFileRequest createFileRequest, zzam zzam) throws RemoteException;

    void zza(CreateFolderRequest createFolderRequest, zzam zzam) throws RemoteException;

    void zza(DeleteResourceRequest deleteResourceRequest, zzam zzam) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzam zzam) throws RemoteException;

    void zza(GetChangesRequest getChangesRequest, zzam zzam) throws RemoteException;

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzam zzam) throws RemoteException;

    void zza(GetMetadataRequest getMetadataRequest, zzam zzam) throws RemoteException;

    void zza(GetPermissionsRequest getPermissionsRequest, zzam zzam) throws RemoteException;

    void zza(ListParentsRequest listParentsRequest, zzam zzam) throws RemoteException;

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzam zzam) throws RemoteException;

    void zza(QueryRequest queryRequest, zzam zzam) throws RemoteException;

    void zza(QueryRequest queryRequest, zzan zzan, zzam zzam) throws RemoteException;

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzan zzan, String str, zzam zzam) throws RemoteException;

    void zza(RemovePermissionRequest removePermissionRequest, zzam zzam) throws RemoteException;

    void zza(SetDrivePreferencesRequest setDrivePreferencesRequest, zzam zzam) throws RemoteException;

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzam zzam) throws RemoteException;

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzam zzam) throws RemoteException;

    void zza(TrashResourceRequest trashResourceRequest, zzam zzam) throws RemoteException;

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzam zzam) throws RemoteException;

    void zza(UntrashResourceRequest untrashResourceRequest, zzam zzam) throws RemoteException;

    void zza(UpdateMetadataRequest updateMetadataRequest, zzam zzam) throws RemoteException;

    void zza(UpdatePermissionRequest updatePermissionRequest, zzam zzam) throws RemoteException;

    void zza(zzam zzam) throws RemoteException;

    void zza(zzan zzan, zzam zzam) throws RemoteException;

    void zzb(QueryRequest queryRequest, zzam zzam) throws RemoteException;

    void zzb(zzam zzam) throws RemoteException;

    void zzc(zzam zzam) throws RemoteException;

    void zzd(zzam zzam) throws RemoteException;

    void zze(zzam zzam) throws RemoteException;

    void zzf(zzam zzam) throws RemoteException;
}
