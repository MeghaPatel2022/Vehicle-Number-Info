package com.google.android.gms.wearable.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import java.util.List;

public interface zzav extends IInterface {

    public static abstract class zza extends Binder implements zzav {

        /* renamed from: com.google.android.gms.wearable.internal.zzav$zza$zza reason: collision with other inner class name */
        private static class C1550zza implements zzav {
            private IBinder zznI;

            C1550zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void onConnectedNodes(List<NodeParcelable> connectedNodes) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    obtain.writeTypedList(connectedNodes);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (amsEntityUpdateParcelable != null) {
                        obtain.writeInt(1);
                        amsEntityUpdateParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (ancsNotificationParcelable != null) {
                        obtain.writeInt(1);
                        ancsNotificationParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (capabilityInfoParcelable != null) {
                        obtain.writeInt(1);
                        capabilityInfoParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(ChannelEventParcelable channelEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (channelEventParcelable != null) {
                        obtain.writeInt(1);
                        channelEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(MessageEventParcelable messageEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (messageEventParcelable != null) {
                        obtain.writeInt(1);
                        messageEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzad(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(NodeParcelable nodeParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.wearable.internal.IWearableListener");
                    if (nodeParcelable != null) {
                        obtain.writeInt(1);
                        nodeParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.wearable.internal.IWearableListener");
        }

        public static zzav zzdZ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzav)) ? new C1550zza(iBinder) : (zzav) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.wearable.internal.CapabilityInfoParcelable] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.wearable.internal.CapabilityInfoParcelable] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.wearable.internal.ChannelEventParcelable] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.wearable.internal.ChannelEventParcelable] */
        /* JADX WARNING: type inference failed for: r0v16, types: [com.google.android.gms.wearable.internal.AncsNotificationParcelable] */
        /* JADX WARNING: type inference failed for: r0v20, types: [com.google.android.gms.wearable.internal.AncsNotificationParcelable] */
        /* JADX WARNING: type inference failed for: r0v25, types: [com.google.android.gms.wearable.internal.NodeParcelable] */
        /* JADX WARNING: type inference failed for: r0v29, types: [com.google.android.gms.wearable.internal.NodeParcelable] */
        /* JADX WARNING: type inference failed for: r0v30, types: [com.google.android.gms.wearable.internal.NodeParcelable] */
        /* JADX WARNING: type inference failed for: r0v34, types: [com.google.android.gms.wearable.internal.NodeParcelable] */
        /* JADX WARNING: type inference failed for: r0v35, types: [com.google.android.gms.wearable.internal.MessageEventParcelable] */
        /* JADX WARNING: type inference failed for: r0v39, types: [com.google.android.gms.wearable.internal.MessageEventParcelable] */
        /* JADX WARNING: type inference failed for: r0v40, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v43, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r0v47 */
        /* JADX WARNING: type inference failed for: r0v48 */
        /* JADX WARNING: type inference failed for: r0v49 */
        /* JADX WARNING: type inference failed for: r0v50 */
        /* JADX WARNING: type inference failed for: r0v51 */
        /* JADX WARNING: type inference failed for: r0v52 */
        /* JADX WARNING: type inference failed for: r0v53 */
        /* JADX WARNING: type inference failed for: r0v54 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.wearable.internal.CapabilityInfoParcelable, com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable, com.google.android.gms.wearable.internal.ChannelEventParcelable, com.google.android.gms.wearable.internal.AncsNotificationParcelable, com.google.android.gms.wearable.internal.NodeParcelable, com.google.android.gms.wearable.internal.MessageEventParcelable, com.google.android.gms.common.data.DataHolder]
          uses: [com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable, com.google.android.gms.wearable.internal.CapabilityInfoParcelable, com.google.android.gms.wearable.internal.ChannelEventParcelable, com.google.android.gms.wearable.internal.AncsNotificationParcelable, com.google.android.gms.wearable.internal.NodeParcelable, com.google.android.gms.wearable.internal.MessageEventParcelable, com.google.android.gms.common.data.DataHolder]
          mth insns count: 92
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
        /* JADX WARNING: Unknown variable types count: 9 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0027;
                    case 3: goto L_0x003f;
                    case 4: goto L_0x0057;
                    case 5: goto L_0x006f;
                    case 6: goto L_0x007f;
                    case 7: goto L_0x0098;
                    case 8: goto L_0x00b1;
                    case 9: goto L_0x00ca;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableListener"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0022
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r5)
            L_0x0022:
                r3.zzad(r0)
                r0 = r1
                goto L_0x0009
            L_0x0027:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x003a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.MessageEventParcelable> r0 = com.google.android.gms.wearable.internal.MessageEventParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.MessageEventParcelable r0 = (com.google.android.gms.wearable.internal.MessageEventParcelable) r0
            L_0x003a:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x003f:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0052
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.NodeParcelable> r0 = com.google.android.gms.wearable.internal.NodeParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.NodeParcelable r0 = (com.google.android.gms.wearable.internal.NodeParcelable) r0
            L_0x0052:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0057:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x006a
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.NodeParcelable> r0 = com.google.android.gms.wearable.internal.NodeParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.NodeParcelable r0 = (com.google.android.gms.wearable.internal.NodeParcelable) r0
            L_0x006a:
                r3.zzb(r0)
                r0 = r1
                goto L_0x0009
            L_0x006f:
                java.lang.String r0 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r0)
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.NodeParcelable> r0 = com.google.android.gms.wearable.internal.NodeParcelable.CREATOR
                java.util.ArrayList r0 = r5.createTypedArrayList(r0)
                r3.onConnectedNodes(r0)
                r0 = r1
                goto L_0x0009
            L_0x007f:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0092
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AncsNotificationParcelable> r0 = com.google.android.gms.wearable.internal.AncsNotificationParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.AncsNotificationParcelable r0 = (com.google.android.gms.wearable.internal.AncsNotificationParcelable) r0
            L_0x0092:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x0098:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00ab
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.ChannelEventParcelable> r0 = com.google.android.gms.wearable.internal.ChannelEventParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.ChannelEventParcelable r0 = (com.google.android.gms.wearable.internal.ChannelEventParcelable) r0
            L_0x00ab:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x00b1:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00c4
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.CapabilityInfoParcelable> r0 = com.google.android.gms.wearable.internal.CapabilityInfoParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.CapabilityInfoParcelable r0 = (com.google.android.gms.wearable.internal.CapabilityInfoParcelable) r0
            L_0x00c4:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            L_0x00ca:
                java.lang.String r2 = "com.google.android.gms.wearable.internal.IWearableListener"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x00dd
                android.os.Parcelable$Creator<com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable> r0 = com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable r0 = (com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable) r0
            L_0x00dd:
                r3.zza(r0)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.wearable.internal.zzav.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onConnectedNodes(List<NodeParcelable> list) throws RemoteException;

    void zza(AmsEntityUpdateParcelable amsEntityUpdateParcelable) throws RemoteException;

    void zza(AncsNotificationParcelable ancsNotificationParcelable) throws RemoteException;

    void zza(CapabilityInfoParcelable capabilityInfoParcelable) throws RemoteException;

    void zza(ChannelEventParcelable channelEventParcelable) throws RemoteException;

    void zza(MessageEventParcelable messageEventParcelable) throws RemoteException;

    void zza(NodeParcelable nodeParcelable) throws RemoteException;

    void zzad(DataHolder dataHolder) throws RemoteException;

    void zzb(NodeParcelable nodeParcelable) throws RemoteException;
}
