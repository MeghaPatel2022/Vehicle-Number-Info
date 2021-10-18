package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.zzm;

public interface zzam extends IInterface {

    public static abstract class zza extends Binder implements zzam {

        /* renamed from: com.google.android.gms.drive.internal.zzam$zza$zza reason: collision with other inner class name */
        private static class C1360zza implements zzam {
            private IBinder zznI;

            C1360zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.zznI.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (changeSequenceNumber != null) {
                        obtain.writeInt(1);
                        changeSequenceNumber.writeToParcel(obtain, 0);
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

            public void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (getPermissionsResponse != null) {
                        obtain.writeInt(1);
                        getPermissionsResponse.writeToParcel(obtain, 0);
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

            public void zza(OnChangesResponse onChangesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onChangesResponse != null) {
                        obtain.writeInt(1);
                        onChangesResponse.writeToParcel(obtain, 0);
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

            public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onContentsResponse != null) {
                        obtain.writeInt(1);
                        onContentsResponse.writeToParcel(obtain, 0);
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

            public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDeviceUsagePreferenceResponse != null) {
                        obtain.writeInt(1);
                        onDeviceUsagePreferenceResponse.writeToParcel(obtain, 0);
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

            public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDownloadProgressResponse != null) {
                        obtain.writeInt(1);
                        onDownloadProgressResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDriveIdResponse != null) {
                        obtain.writeInt(1);
                        onDriveIdResponse.writeToParcel(obtain, 0);
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

            public void zza(OnDrivePreferencesResponse onDrivePreferencesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDrivePreferencesResponse != null) {
                        obtain.writeInt(1);
                        onDrivePreferencesResponse.writeToParcel(obtain, 0);
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

            public void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onFetchThumbnailResponse != null) {
                        obtain.writeInt(1);
                        onFetchThumbnailResponse.writeToParcel(obtain, 0);
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

            public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListEntriesResponse != null) {
                        obtain.writeInt(1);
                        onListEntriesResponse.writeToParcel(obtain, 0);
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

            public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListParentsResponse != null) {
                        obtain.writeInt(1);
                        onListParentsResponse.writeToParcel(obtain, 0);
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

            public void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onLoadRealtimeResponse != null) {
                        obtain.writeInt(1);
                        onLoadRealtimeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzm != null ? zzm.asBinder() : null);
                    this.zznI.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onMetadataResponse != null) {
                        obtain.writeInt(1);
                        onMetadataResponse.writeToParcel(obtain, 0);
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

            public void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onResourceIdSetResponse != null) {
                        obtain.writeInt(1);
                        onResourceIdSetResponse.writeToParcel(obtain, 0);
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

            public void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onSyncMoreResponse != null) {
                        obtain.writeInt(1);
                        onSyncMoreResponse.writeToParcel(obtain, 0);
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

            public void zzaa(boolean z) throws RemoteException {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.zznI.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzy(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
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
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        public static zzam zzaT(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzam)) ? new C1360zza(iBinder) : (zzam) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.drive.internal.GetPermissionsResponse] */
        /* JADX WARNING: type inference failed for: r0v4, types: [com.google.android.gms.drive.internal.GetPermissionsResponse] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.drive.internal.OnChangesResponse] */
        /* JADX WARNING: type inference failed for: r0v8, types: [com.google.android.gms.drive.internal.OnChangesResponse] */
        /* JADX WARNING: type inference failed for: r0v9, types: [com.google.android.gms.drive.ChangeSequenceNumber] */
        /* JADX WARNING: type inference failed for: r0v12, types: [com.google.android.gms.drive.ChangeSequenceNumber] */
        /* JADX WARNING: type inference failed for: r0v13, types: [com.google.android.gms.drive.internal.OnFetchThumbnailResponse] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.drive.internal.OnFetchThumbnailResponse] */
        /* JADX WARNING: type inference failed for: r0v22, types: [com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse] */
        /* JADX WARNING: type inference failed for: r0v26, types: [com.google.android.gms.drive.internal.OnDrivePreferencesResponse] */
        /* JADX WARNING: type inference failed for: r0v29, types: [com.google.android.gms.drive.internal.OnDrivePreferencesResponse] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.drive.internal.OnResourceIdSetResponse] */
        /* JADX WARNING: type inference failed for: r0v33, types: [com.google.android.gms.drive.internal.OnResourceIdSetResponse] */
        /* JADX WARNING: type inference failed for: r0v34, types: [com.google.android.gms.drive.internal.OnLoadRealtimeResponse] */
        /* JADX WARNING: type inference failed for: r0v37, types: [com.google.android.gms.drive.internal.OnLoadRealtimeResponse] */
        /* JADX WARNING: type inference failed for: r0v38, types: [com.google.android.gms.drive.internal.OnSyncMoreResponse] */
        /* JADX WARNING: type inference failed for: r0v41, types: [com.google.android.gms.drive.internal.OnSyncMoreResponse] */
        /* JADX WARNING: type inference failed for: r0v42, types: [com.google.android.gms.drive.internal.OnListParentsResponse] */
        /* JADX WARNING: type inference failed for: r0v45, types: [com.google.android.gms.drive.internal.OnListParentsResponse] */
        /* JADX WARNING: type inference failed for: r0v47, types: [com.google.android.gms.common.api.Status] */
        /* JADX WARNING: type inference failed for: r0v50, types: [com.google.android.gms.common.api.Status] */
        /* JADX WARNING: type inference failed for: r0v51, types: [com.google.android.gms.drive.internal.OnContentsResponse] */
        /* JADX WARNING: type inference failed for: r0v54, types: [com.google.android.gms.drive.internal.OnContentsResponse] */
        /* JADX WARNING: type inference failed for: r0v55, types: [com.google.android.gms.drive.internal.OnMetadataResponse] */
        /* JADX WARNING: type inference failed for: r0v58, types: [com.google.android.gms.drive.internal.OnMetadataResponse] */
        /* JADX WARNING: type inference failed for: r0v59, types: [com.google.android.gms.drive.internal.OnDriveIdResponse] */
        /* JADX WARNING: type inference failed for: r0v62, types: [com.google.android.gms.drive.internal.OnDriveIdResponse] */
        /* JADX WARNING: type inference failed for: r0v63, types: [com.google.android.gms.drive.internal.OnListEntriesResponse] */
        /* JADX WARNING: type inference failed for: r0v66, types: [com.google.android.gms.drive.internal.OnListEntriesResponse] */
        /* JADX WARNING: type inference failed for: r0v67, types: [com.google.android.gms.drive.internal.OnDownloadProgressResponse] */
        /* JADX WARNING: type inference failed for: r0v70, types: [com.google.android.gms.drive.internal.OnDownloadProgressResponse] */
        /* JADX WARNING: type inference failed for: r0v72 */
        /* JADX WARNING: type inference failed for: r0v73 */
        /* JADX WARNING: type inference failed for: r0v74 */
        /* JADX WARNING: type inference failed for: r0v75 */
        /* JADX WARNING: type inference failed for: r0v76 */
        /* JADX WARNING: type inference failed for: r0v77 */
        /* JADX WARNING: type inference failed for: r0v78 */
        /* JADX WARNING: type inference failed for: r0v79 */
        /* JADX WARNING: type inference failed for: r0v80 */
        /* JADX WARNING: type inference failed for: r0v81 */
        /* JADX WARNING: type inference failed for: r0v82 */
        /* JADX WARNING: type inference failed for: r0v83 */
        /* JADX WARNING: type inference failed for: r0v84 */
        /* JADX WARNING: type inference failed for: r0v85 */
        /* JADX WARNING: type inference failed for: r0v86 */
        /* JADX WARNING: type inference failed for: r0v87 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.drive.internal.OnChangesResponse, com.google.android.gms.drive.internal.GetPermissionsResponse, com.google.android.gms.drive.ChangeSequenceNumber, com.google.android.gms.drive.internal.OnFetchThumbnailResponse, com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse, com.google.android.gms.drive.internal.OnDrivePreferencesResponse, com.google.android.gms.drive.internal.OnResourceIdSetResponse, com.google.android.gms.drive.internal.OnLoadRealtimeResponse, com.google.android.gms.drive.internal.OnSyncMoreResponse, com.google.android.gms.drive.internal.OnListParentsResponse, com.google.android.gms.common.api.Status, com.google.android.gms.drive.internal.OnContentsResponse, com.google.android.gms.drive.internal.OnMetadataResponse, com.google.android.gms.drive.internal.OnDriveIdResponse, com.google.android.gms.drive.internal.OnListEntriesResponse, com.google.android.gms.drive.internal.OnDownloadProgressResponse]
          uses: [com.google.android.gms.drive.internal.GetPermissionsResponse, com.google.android.gms.drive.internal.OnChangesResponse, com.google.android.gms.drive.ChangeSequenceNumber, com.google.android.gms.drive.internal.OnFetchThumbnailResponse, com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse, com.google.android.gms.drive.internal.OnDrivePreferencesResponse, com.google.android.gms.drive.internal.OnResourceIdSetResponse, com.google.android.gms.drive.internal.OnLoadRealtimeResponse, com.google.android.gms.drive.internal.OnSyncMoreResponse, com.google.android.gms.drive.internal.OnListParentsResponse, com.google.android.gms.common.api.Status, com.google.android.gms.drive.internal.OnContentsResponse, com.google.android.gms.drive.internal.OnMetadataResponse, com.google.android.gms.drive.internal.OnDriveIdResponse, com.google.android.gms.drive.internal.OnListEntriesResponse, com.google.android.gms.drive.internal.OnDownloadProgressResponse]
          mth insns count: 199
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
        /* JADX WARNING: Unknown variable types count: 17 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0010;
                    case 2: goto L_0x002a;
                    case 3: goto L_0x0044;
                    case 4: goto L_0x005e;
                    case 5: goto L_0x0078;
                    case 6: goto L_0x0093;
                    case 7: goto L_0x00ae;
                    case 8: goto L_0x00bb;
                    case 9: goto L_0x00d6;
                    case 11: goto L_0x00f1;
                    case 12: goto L_0x0114;
                    case 13: goto L_0x012f;
                    case 14: goto L_0x014a;
                    case 15: goto L_0x0165;
                    case 16: goto L_0x017b;
                    case 17: goto L_0x0196;
                    case 18: goto L_0x01b1;
                    case 20: goto L_0x01cc;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r1 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r1
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r6.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0023
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDownloadProgressResponse> r0 = com.google.android.gms.drive.internal.OnDownloadProgressResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDownloadProgressResponse r0 = (com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0
            L_0x0023:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x002a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListEntriesResponse> r0 = com.google.android.gms.drive.internal.OnListEntriesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListEntriesResponse r0 = (com.google.android.gms.drive.internal.OnListEntriesResponse) r0
            L_0x003d:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x0044:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0057
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDriveIdResponse> r0 = com.google.android.gms.drive.internal.OnDriveIdResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDriveIdResponse r0 = (com.google.android.gms.drive.internal.OnDriveIdResponse) r0
            L_0x0057:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x005e:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0071
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnMetadataResponse> r0 = com.google.android.gms.drive.internal.OnMetadataResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnMetadataResponse r0 = (com.google.android.gms.drive.internal.OnMetadataResponse) r0
            L_0x0071:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x0078:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x008b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnContentsResponse> r0 = com.google.android.gms.drive.internal.OnContentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnContentsResponse r0 = (com.google.android.gms.drive.internal.OnContentsResponse) r0
            L_0x008b:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x0093:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00a6
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            L_0x00a6:
                r3.zzy(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x00ae:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r0)
                r3.onSuccess()
                r6.writeNoException()
                goto L_0x0009
            L_0x00bb:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00ce
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListParentsResponse> r0 = com.google.android.gms.drive.internal.OnListParentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListParentsResponse r0 = (com.google.android.gms.drive.internal.OnListParentsResponse) r0
            L_0x00ce:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x00d6:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00e9
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnSyncMoreResponse> r0 = com.google.android.gms.drive.internal.OnSyncMoreResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnSyncMoreResponse r0 = (com.google.android.gms.drive.internal.OnSyncMoreResponse) r0
            L_0x00e9:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x00f1:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0104
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnLoadRealtimeResponse> r0 = com.google.android.gms.drive.internal.OnLoadRealtimeResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnLoadRealtimeResponse r0 = (com.google.android.gms.drive.internal.OnLoadRealtimeResponse) r0
            L_0x0104:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzm r2 = com.google.android.gms.drive.realtime.internal.zzm.zza.zzbg(r2)
                r3.zza(r0, r2)
                r6.writeNoException()
                goto L_0x0009
            L_0x0114:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0127
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnResourceIdSetResponse> r0 = com.google.android.gms.drive.internal.OnResourceIdSetResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnResourceIdSetResponse r0 = (com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0
            L_0x0127:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x012f:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0142
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDrivePreferencesResponse> r0 = com.google.android.gms.drive.internal.OnDrivePreferencesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDrivePreferencesResponse r0 = (com.google.android.gms.drive.internal.OnDrivePreferencesResponse) r0
            L_0x0142:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x014a:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x015d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse> r0 = com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse r0 = (com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) r0
            L_0x015d:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x0165:
                java.lang.String r0 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r0)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x0179
                r0 = r1
            L_0x0171:
                r3.zzaa(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x0179:
                r0 = 0
                goto L_0x0171
            L_0x017b:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x018e
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnFetchThumbnailResponse> r0 = com.google.android.gms.drive.internal.OnFetchThumbnailResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnFetchThumbnailResponse r0 = (com.google.android.gms.drive.internal.OnFetchThumbnailResponse) r0
            L_0x018e:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x0196:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01a9
                android.os.Parcelable$Creator<com.google.android.gms.drive.ChangeSequenceNumber> r0 = com.google.android.gms.drive.ChangeSequenceNumber.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.ChangeSequenceNumber r0 = (com.google.android.gms.drive.ChangeSequenceNumber) r0
            L_0x01a9:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x01b1:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01c4
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnChangesResponse> r0 = com.google.android.gms.drive.internal.OnChangesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnChangesResponse r0 = (com.google.android.gms.drive.internal.OnChangesResponse) r0
            L_0x01c4:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            L_0x01cc:
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x01df
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetPermissionsResponse> r0 = com.google.android.gms.drive.internal.GetPermissionsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.GetPermissionsResponse r0 = (com.google.android.gms.drive.internal.GetPermissionsResponse) r0
            L_0x01df:
                r3.zza(r0)
                r6.writeNoException()
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzam.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onSuccess() throws RemoteException;

    void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException;

    void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException;

    void zza(OnChangesResponse onChangesResponse) throws RemoteException;

    void zza(OnContentsResponse onContentsResponse) throws RemoteException;

    void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException;

    void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException;

    void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException;

    void zza(OnDrivePreferencesResponse onDrivePreferencesResponse) throws RemoteException;

    void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException;

    void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException;

    void zza(OnListParentsResponse onListParentsResponse) throws RemoteException;

    void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm zzm) throws RemoteException;

    void zza(OnMetadataResponse onMetadataResponse) throws RemoteException;

    void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException;

    void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException;

    void zzaa(boolean z) throws RemoteException;

    void zzy(Status status) throws RemoteException;
}
