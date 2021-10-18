package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public interface zzau extends IInterface {

    public static abstract class zza extends Binder implements zzau {

        /* renamed from: com.google.android.gms.wearable.internal.zzau$zza$zza reason: collision with other inner class name */
        private static class C1549zza implements zzau {
            private IBinder zznI;

            C1549zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (addLocalCapabilityResponse != null) {
                        obtain.writeInt(1);
                        addLocalCapabilityResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (channelReceiveFileResponse != null) {
                        obtain.writeInt(1);
                        channelReceiveFileResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChannelSendFileResponse channelSendFileResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (channelSendFileResponse != null) {
                        obtain.writeInt(1);
                        channelSendFileResponse.writeToParcel(obtain, 0);
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

            public void zza(CloseChannelResponse closeChannelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (closeChannelResponse != null) {
                        obtain.writeInt(1);
                        closeChannelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DeleteDataItemsResponse deleteDataItemsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (deleteDataItemsResponse != null) {
                        obtain.writeInt(1);
                        deleteDataItemsResponse.writeToParcel(obtain, 0);
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

            public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getAllCapabilitiesResponse != null) {
                        obtain.writeInt(1);
                        getAllCapabilitiesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetCapabilityResponse getCapabilityResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCapabilityResponse != null) {
                        obtain.writeInt(1);
                        getCapabilityResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getChannelInputStreamResponse != null) {
                        obtain.writeInt(1);
                        getChannelInputStreamResponse.writeToParcel(obtain, 0);
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

            public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getChannelOutputStreamResponse != null) {
                        obtain.writeInt(1);
                        getChannelOutputStreamResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCloudSyncOptInOutDoneResponse != null) {
                        obtain.writeInt(1);
                        getCloudSyncOptInOutDoneResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCloudSyncOptInStatusResponse != null) {
                        obtain.writeInt(1);
                        getCloudSyncOptInStatusResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetCloudSyncSettingResponse getCloudSyncSettingResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getCloudSyncSettingResponse != null) {
                        obtain.writeInt(1);
                        getCloudSyncSettingResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetConfigResponse getConfigResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getConfigResponse != null) {
                        obtain.writeInt(1);
                        getConfigResponse.writeToParcel(obtain, 0);
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

            public void zza(GetConfigsResponse getConfigsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getConfigsResponse != null) {
                        obtain.writeInt(1);
                        getConfigsResponse.writeToParcel(obtain, 0);
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

            public void zza(GetConnectedNodesResponse getConnectedNodesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getConnectedNodesResponse != null) {
                        obtain.writeInt(1);
                        getConnectedNodesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetDataItemResponse getDataItemResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getDataItemResponse != null) {
                        obtain.writeInt(1);
                        getDataItemResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetFdForAssetResponse getFdForAssetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getFdForAssetResponse != null) {
                        obtain.writeInt(1);
                        getFdForAssetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetLocalNodeResponse getLocalNodeResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (getLocalNodeResponse != null) {
                        obtain.writeInt(1);
                        getLocalNodeResponse.writeToParcel(obtain, 0);
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

            public void zza(OpenChannelResponse openChannelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (openChannelResponse != null) {
                        obtain.writeInt(1);
                        openChannelResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(PutDataResponse putDataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (putDataResponse != null) {
                        obtain.writeInt(1);
                        putDataResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (removeLocalCapabilityResponse != null) {
                        obtain.writeInt(1);
                        removeLocalCapabilityResponse.writeToParcel(obtain, 0);
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

            public void zza(SendMessageResponse sendMessageResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (sendMessageResponse != null) {
                        obtain.writeInt(1);
                        sendMessageResponse.writeToParcel(obtain, 0);
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

            public void zza(StorageInfoResponse storageInfoResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (storageInfoResponse != null) {
                        obtain.writeInt(1);
                        storageInfoResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzae(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(CloseChannelResponse closeChannelResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (closeChannelResponse != null) {
                        obtain.writeInt(1);
                        closeChannelResponse.writeToParcel(obtain, 0);
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

            public void zzc(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableCallbacks");
        }

        public static zzau zzdY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzau)) ? new C1549zza(iBinder) : (zzau) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.wearable.internal.AddLocalCapabilityResponse] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.wearable.internal.AddLocalCapabilityResponse] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.wearable.internal.GetCapabilityResponse] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.wearable.internal.GetCapabilityResponse] */
        /* JADX WARNING: type inference failed for: r0v21, types: [com.google.android.gms.wearable.internal.StorageInfoResponse] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.wearable.internal.StorageInfoResponse] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.common.api.Status] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.common.api.Status] */
        /* JADX WARNING: type inference failed for: r0v31, types: [com.google.android.gms.wearable.internal.ChannelSendFileResponse] */
        /* JADX WARNING: type inference failed for: r0v35, types: [com.google.android.gms.wearable.internal.ChannelSendFileResponse] */
        /* JADX WARNING: type inference failed for: r0v36, types: [com.google.android.gms.wearable.internal.ChannelReceiveFileResponse] */
        /* JADX WARNING: type inference failed for: r0v40, types: [com.google.android.gms.wearable.internal.ChannelReceiveFileResponse] */
        /* JADX WARNING: type inference failed for: r0v41, types: [com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse] */
        /* JADX WARNING: type inference failed for: r0v45, types: [com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse] */
        /* JADX WARNING: type inference failed for: r0v46, types: [com.google.android.gms.wearable.internal.GetChannelInputStreamResponse] */
        /* JADX WARNING: type inference failed for: r0v50, types: [com.google.android.gms.wearable.internal.GetChannelInputStreamResponse] */
        /* JADX WARNING: type inference failed for: r0v51, types: [com.google.android.gms.wearable.internal.CloseChannelResponse] */
        /* JADX WARNING: type inference failed for: r0v55, types: [com.google.android.gms.wearable.internal.CloseChannelResponse] */
        /* JADX WARNING: type inference failed for: r0v56, types: [com.google.android.gms.wearable.internal.CloseChannelResponse] */
        /* JADX WARNING: type inference failed for: r0v60, types: [com.google.android.gms.wearable.internal.CloseChannelResponse] */
        /* JADX WARNING: type inference failed for: r0v61, types: [com.google.android.gms.wearable.internal.OpenChannelResponse] */
        /* JADX WARNING: type inference failed for: r0v65, types: [com.google.android.gms.wearable.internal.OpenChannelResponse] */
        /* JADX WARNING: type inference failed for: r0v66, types: [com.google.android.gms.wearable.internal.GetConnectedNodesResponse] */
        /* JADX WARNING: type inference failed for: r0v70, types: [com.google.android.gms.wearable.internal.GetConnectedNodesResponse] */
        /* JADX WARNING: type inference failed for: r0v71, types: [com.google.android.gms.wearable.internal.GetLocalNodeResponse] */
        /* JADX WARNING: type inference failed for: r0v75, types: [com.google.android.gms.wearable.internal.GetLocalNodeResponse] */
        /* JADX WARNING: type inference failed for: r0v76, types: [com.google.android.gms.wearable.internal.GetFdForAssetResponse] */
        /* JADX WARNING: type inference failed for: r0v80, types: [com.google.android.gms.wearable.internal.GetFdForAssetResponse] */
        /* JADX WARNING: type inference failed for: r0v81, types: [com.google.android.gms.wearable.internal.SendMessageResponse] */
        /* JADX WARNING: type inference failed for: r0v85, types: [com.google.android.gms.wearable.internal.SendMessageResponse] */
        /* JADX WARNING: type inference failed for: r0v86, types: [com.google.android.gms.wearable.internal.DeleteDataItemsResponse] */
        /* JADX WARNING: type inference failed for: r0v90, types: [com.google.android.gms.wearable.internal.DeleteDataItemsResponse] */
        /* JADX WARNING: type inference failed for: r0v91, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v94, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v95, types: [com.google.android.gms.wearable.internal.GetDataItemResponse] */
        /* JADX WARNING: type inference failed for: r0v99, types: [com.google.android.gms.wearable.internal.GetDataItemResponse] */
        /* JADX WARNING: type inference failed for: r0v100, types: [com.google.android.gms.wearable.internal.PutDataResponse] */
        /* JADX WARNING: type inference failed for: r0v104, types: [com.google.android.gms.wearable.internal.PutDataResponse] */
        /* JADX WARNING: type inference failed for: r0v105, types: [com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse] */
        /* JADX WARNING: type inference failed for: r0v109, types: [com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse] */
        /* JADX WARNING: type inference failed for: r0v110, types: [com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse] */
        /* JADX WARNING: type inference failed for: r0v114, types: [com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse] */
        /* JADX WARNING: type inference failed for: r0v115, types: [com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse] */
        /* JADX WARNING: type inference failed for: r0v119, types: [com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse] */
        /* JADX WARNING: type inference failed for: r0v120, types: [com.google.android.gms.wearable.internal.GetConfigsResponse] */
        /* JADX WARNING: type inference failed for: r0v124, types: [com.google.android.gms.wearable.internal.GetConfigsResponse] */
        /* JADX WARNING: type inference failed for: r0v125, types: [com.google.android.gms.wearable.internal.GetConfigResponse] */
        /* JADX WARNING: type inference failed for: r0v129, types: [com.google.android.gms.wearable.internal.GetConfigResponse] */
        /* JADX WARNING: type inference failed for: r0v133 */
        /* JADX WARNING: type inference failed for: r0v134 */
        /* JADX WARNING: type inference failed for: r0v135 */
        /* JADX WARNING: type inference failed for: r0v136 */
        /* JADX WARNING: type inference failed for: r0v137 */
        /* JADX WARNING: type inference failed for: r0v138 */
        /* JADX WARNING: type inference failed for: r0v139 */
        /* JADX WARNING: type inference failed for: r0v140 */
        /* JADX WARNING: type inference failed for: r0v141 */
        /* JADX WARNING: type inference failed for: r0v142 */
        /* JADX WARNING: type inference failed for: r0v143 */
        /* JADX WARNING: type inference failed for: r0v144 */
        /* JADX WARNING: type inference failed for: r0v145 */
        /* JADX WARNING: type inference failed for: r0v146 */
        /* JADX WARNING: type inference failed for: r0v147 */
        /* JADX WARNING: type inference failed for: r0v148 */
        /* JADX WARNING: type inference failed for: r0v149 */
        /* JADX WARNING: type inference failed for: r0v150 */
        /* JADX WARNING: type inference failed for: r0v151 */
        /* JADX WARNING: type inference failed for: r0v152 */
        /* JADX WARNING: type inference failed for: r0v153 */
        /* JADX WARNING: type inference failed for: r0v154 */
        /* JADX WARNING: type inference failed for: r0v155 */
        /* JADX WARNING: type inference failed for: r0v156 */
        /* JADX WARNING: type inference failed for: r0v157 */
        /* JADX WARNING: type inference failed for: r0v158 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.wearable.internal.AddLocalCapabilityResponse, com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse, com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse, com.google.android.gms.wearable.internal.GetCapabilityResponse, com.google.android.gms.wearable.internal.StorageInfoResponse, com.google.android.gms.common.api.Status, com.google.android.gms.wearable.internal.ChannelSendFileResponse, com.google.android.gms.wearable.internal.ChannelReceiveFileResponse, com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse, com.google.android.gms.wearable.internal.GetChannelInputStreamResponse, com.google.android.gms.wearable.internal.CloseChannelResponse, com.google.android.gms.wearable.internal.OpenChannelResponse, com.google.android.gms.wearable.internal.GetConnectedNodesResponse, com.google.android.gms.wearable.internal.GetLocalNodeResponse, com.google.android.gms.wearable.internal.GetFdForAssetResponse, com.google.android.gms.wearable.internal.SendMessageResponse, com.google.android.gms.wearable.internal.DeleteDataItemsResponse, com.google.android.gms.common.data.DataHolder, com.google.android.gms.wearable.internal.GetDataItemResponse, com.google.android.gms.wearable.internal.PutDataResponse, com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse, com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse, com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse, com.google.android.gms.wearable.internal.GetConfigsResponse, com.google.android.gms.wearable.internal.GetConfigResponse]
          uses: [com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse, com.google.android.gms.wearable.internal.AddLocalCapabilityResponse, com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse, com.google.android.gms.wearable.internal.GetCapabilityResponse, com.google.android.gms.wearable.internal.StorageInfoResponse, com.google.android.gms.common.api.Status, com.google.android.gms.wearable.internal.ChannelSendFileResponse, com.google.android.gms.wearable.internal.ChannelReceiveFileResponse, com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse, com.google.android.gms.wearable.internal.GetChannelInputStreamResponse, com.google.android.gms.wearable.internal.CloseChannelResponse, com.google.android.gms.wearable.internal.OpenChannelResponse, com.google.android.gms.wearable.internal.GetConnectedNodesResponse, com.google.android.gms.wearable.internal.GetLocalNodeResponse, com.google.android.gms.wearable.internal.GetFdForAssetResponse, com.google.android.gms.wearable.internal.SendMessageResponse, com.google.android.gms.wearable.internal.DeleteDataItemsResponse, com.google.android.gms.common.data.DataHolder, com.google.android.gms.wearable.internal.GetDataItemResponse, com.google.android.gms.wearable.internal.PutDataResponse, com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse, com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse, com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse, com.google.android.gms.wearable.internal.GetConfigsResponse, com.google.android.gms.wearable.internal.GetConfigResponse]
          mth insns count: 292
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
        /* JADX WARNING: Unknown variable types count: 27 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 2: goto L_0x0011;
                    case 3: goto L_0x0099;
                    case 4: goto L_0x00b5;
                    case 5: goto L_0x00d1;
                    case 6: goto L_0x00eb;
                    case 7: goto L_0x0107;
                    case 8: goto L_0x0123;
                    case 9: goto L_0x013f;
                    case 10: goto L_0x015b;
                    case 11: goto L_0x023b;
                    case 12: goto L_0x0257;
                    case 13: goto L_0x002c;
                    case 14: goto L_0x0177;
                    case 15: goto L_0x0193;
                    case 16: goto L_0x01af;
                    case 17: goto L_0x01cb;
                    case 18: goto L_0x01e7;
                    case 19: goto L_0x0203;
                    case 20: goto L_0x021f;
                    case 22: goto L_0x0273;
                    case 23: goto L_0x028f;
                    case 26: goto L_0x02ab;
                    case 27: goto L_0x02c7;
                    case 28: goto L_0x0047;
                    case 29: goto L_0x0062;
                    case 30: goto L_0x007d;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetConfigResponse> r0 = com.google.android.gms.wearable.internal.GetConfigResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetConfigResponse r0 = (com.google.android.gms.wearable.internal.GetConfigResponse) r0
            L_0x0024:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x002c:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003f
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetConfigsResponse> r0 = com.google.android.gms.wearable.internal.GetConfigsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetConfigsResponse r0 = (com.google.android.gms.wearable.internal.GetConfigsResponse) r0
            L_0x003f:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0047:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x005a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse> r0 = com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse r0 = (com.google.android.gms.wearable.internal.GetCloudSyncOptInOutDoneResponse) r0
            L_0x005a:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0062:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0075
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse> r0 = com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse r0 = (com.google.android.gms.wearable.internal.GetCloudSyncSettingResponse) r0
            L_0x0075:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x007d:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0090
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse> r0 = com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse r0 = (com.google.android.gms.wearable.internal.GetCloudSyncOptInStatusResponse) r0
            L_0x0090:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0099:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00ac
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.PutDataResponse> r0 = com.google.android.gms.wearable.internal.PutDataResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.PutDataResponse r0 = (com.google.android.gms.wearable.internal.PutDataResponse) r0
            L_0x00ac:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00b5:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00c8
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetDataItemResponse> r0 = com.google.android.gms.wearable.internal.GetDataItemResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetDataItemResponse r0 = (com.google.android.gms.wearable.internal.GetDataItemResponse) r0
            L_0x00c8:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00d1:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00e2
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x00e2:
                r3.zzae(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x00eb:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00fe
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.DeleteDataItemsResponse> r0 = com.google.android.gms.wearable.internal.DeleteDataItemsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.DeleteDataItemsResponse r0 = (com.google.android.gms.wearable.internal.DeleteDataItemsResponse) r0
            L_0x00fe:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0107:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x011a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.SendMessageResponse> r0 = com.google.android.gms.wearable.internal.SendMessageResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.SendMessageResponse r0 = (com.google.android.gms.wearable.internal.SendMessageResponse) r0
            L_0x011a:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0123:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0136
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetFdForAssetResponse> r0 = com.google.android.gms.wearable.internal.GetFdForAssetResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetFdForAssetResponse r0 = (com.google.android.gms.wearable.internal.GetFdForAssetResponse) r0
            L_0x0136:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x013f:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0152
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetLocalNodeResponse> r0 = com.google.android.gms.wearable.internal.GetLocalNodeResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetLocalNodeResponse r0 = (com.google.android.gms.wearable.internal.GetLocalNodeResponse) r0
            L_0x0152:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x015b:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x016e
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetConnectedNodesResponse> r0 = com.google.android.gms.wearable.internal.GetConnectedNodesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetConnectedNodesResponse r0 = (com.google.android.gms.wearable.internal.GetConnectedNodesResponse) r0
            L_0x016e:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0177:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x018a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.OpenChannelResponse> r0 = com.google.android.gms.wearable.internal.OpenChannelResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.OpenChannelResponse r0 = (com.google.android.gms.wearable.internal.OpenChannelResponse) r0
            L_0x018a:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0193:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01a6
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.CloseChannelResponse> r0 = com.google.android.gms.wearable.internal.CloseChannelResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.CloseChannelResponse r0 = (com.google.android.gms.wearable.internal.CloseChannelResponse) r0
            L_0x01a6:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01af:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01c2
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.CloseChannelResponse> r0 = com.google.android.gms.wearable.internal.CloseChannelResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.CloseChannelResponse r0 = (com.google.android.gms.wearable.internal.CloseChannelResponse) r0
            L_0x01c2:
                r3.zzb(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01cb:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01de
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetChannelInputStreamResponse> r0 = com.google.android.gms.wearable.internal.GetChannelInputStreamResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetChannelInputStreamResponse r0 = (com.google.android.gms.wearable.internal.GetChannelInputStreamResponse) r0
            L_0x01de:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x01e7:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01fa
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse> r0 = com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse r0 = (com.google.android.gms.wearable.internal.GetChannelOutputStreamResponse) r0
            L_0x01fa:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0203:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0216
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ChannelReceiveFileResponse> r0 = com.google.android.gms.wearable.internal.ChannelReceiveFileResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ChannelReceiveFileResponse r0 = (com.google.android.gms.wearable.internal.ChannelReceiveFileResponse) r0
            L_0x0216:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x021f:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0232
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ChannelSendFileResponse> r0 = com.google.android.gms.wearable.internal.ChannelSendFileResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ChannelSendFileResponse r0 = (com.google.android.gms.wearable.internal.ChannelSendFileResponse) r0
            L_0x0232:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x023b:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x024e
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            L_0x024e:
                r3.zzc(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0257:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x026a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.StorageInfoResponse> r0 = com.google.android.gms.wearable.internal.StorageInfoResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.StorageInfoResponse r0 = (com.google.android.gms.wearable.internal.StorageInfoResponse) r0
            L_0x026a:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x0273:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0286
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetCapabilityResponse> r0 = com.google.android.gms.wearable.internal.GetCapabilityResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetCapabilityResponse r0 = (com.google.android.gms.wearable.internal.GetCapabilityResponse) r0
            L_0x0286:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x028f:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x02a2
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse> r0 = com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse r0 = (com.google.android.gms.wearable.internal.GetAllCapabilitiesResponse) r0
            L_0x02a2:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x02ab:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x02be
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AddLocalCapabilityResponse> r0 = com.google.android.gms.wearable.internal.AddLocalCapabilityResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.AddLocalCapabilityResponse r0 = (com.google.android.gms.wearable.internal.AddLocalCapabilityResponse) r0
            L_0x02be:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            L_0x02c7:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x02da
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse> r0 = com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse r0 = (com.google.android.gms.wearable.internal.RemoveLocalCapabilityResponse) r0
            L_0x02da:
                r3.zza(r0)
                r6.writeNoException()
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzau.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) throws RemoteException;

    void zza(ChannelReceiveFileResponse channelReceiveFileResponse) throws RemoteException;

    void zza(ChannelSendFileResponse channelSendFileResponse) throws RemoteException;

    void zza(CloseChannelResponse closeChannelResponse) throws RemoteException;

    void zza(DeleteDataItemsResponse deleteDataItemsResponse) throws RemoteException;

    void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) throws RemoteException;

    void zza(GetCapabilityResponse getCapabilityResponse) throws RemoteException;

    void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) throws RemoteException;

    void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) throws RemoteException;

    void zza(GetCloudSyncOptInOutDoneResponse getCloudSyncOptInOutDoneResponse) throws RemoteException;

    void zza(GetCloudSyncOptInStatusResponse getCloudSyncOptInStatusResponse) throws RemoteException;

    void zza(GetCloudSyncSettingResponse getCloudSyncSettingResponse) throws RemoteException;

    void zza(GetConfigResponse getConfigResponse) throws RemoteException;

    void zza(GetConfigsResponse getConfigsResponse) throws RemoteException;

    void zza(GetConnectedNodesResponse getConnectedNodesResponse) throws RemoteException;

    void zza(GetDataItemResponse getDataItemResponse) throws RemoteException;

    void zza(GetFdForAssetResponse getFdForAssetResponse) throws RemoteException;

    void zza(GetLocalNodeResponse getLocalNodeResponse) throws RemoteException;

    void zza(OpenChannelResponse openChannelResponse) throws RemoteException;

    void zza(PutDataResponse putDataResponse) throws RemoteException;

    void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) throws RemoteException;

    void zza(SendMessageResponse sendMessageResponse) throws RemoteException;

    void zza(StorageInfoResponse storageInfoResponse) throws RemoteException;

    void zzae(DataHolder dataHolder) throws RemoteException;

    void zzb(CloseChannelResponse closeChannelResponse) throws RemoteException;

    void zzc(Status status) throws RemoteException;
}
