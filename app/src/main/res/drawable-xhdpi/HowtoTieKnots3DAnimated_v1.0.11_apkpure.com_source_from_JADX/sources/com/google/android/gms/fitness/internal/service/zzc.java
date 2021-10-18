package com.google.android.gms.fitness.internal.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznh;

public interface zzc extends IInterface {

    public static abstract class zza extends Binder implements zzc {
        public zza() {
            attachInterface(this, "com.google.android.gms.fitness.internal.service.IFitnessSensorService");
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest] */
        /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.fitness.service.FitnessSensorServiceRequest] */
        /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.fitness.service.FitnessSensorServiceRequest] */
        /* JADX WARNING: type inference failed for: r0v11, types: [com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest] */
        /* JADX WARNING: type inference failed for: r0v15, types: [com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest] */
        /* JADX WARNING: type inference failed for: r0v19 */
        /* JADX WARNING: type inference failed for: r0v20 */
        /* JADX WARNING: type inference failed for: r0v21 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r0v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.fitness.service.FitnessSensorServiceRequest, com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest, com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest]
          uses: [com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest, com.google.android.gms.fitness.service.FitnessSensorServiceRequest, com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest]
          mth insns count: 43
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
        /* JADX WARNING: Unknown variable types count: 4 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 0
                r1 = 1
                switch(r4) {
                    case 1: goto L_0x0011;
                    case 2: goto L_0x0031;
                    case 3: goto L_0x0051;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
            L_0x0009:
                return r0
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r6.writeString(r0)
                r0 = r1
                goto L_0x0009
            L_0x0011:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0024
                android.os.Parcelable$Creator<com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest> r0 = com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest r0 = (com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest) r0
            L_0x0024:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.internal.zzmt r2 = com.google.android.gms.internal.zzmt.zza.zzbv(r2)
                r3.zza(r0, r2)
                r0 = r1
                goto L_0x0009
            L_0x0031:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0044
                android.os.Parcelable$Creator<com.google.android.gms.fitness.service.FitnessSensorServiceRequest> r0 = com.google.android.gms.fitness.service.FitnessSensorServiceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.service.FitnessSensorServiceRequest r0 = (com.google.android.gms.fitness.service.FitnessSensorServiceRequest) r0
            L_0x0044:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.internal.zznh r2 = com.google.android.gms.internal.zznh.zza.zzbJ(r2)
                r3.zza(r0, r2)
                r0 = r1
                goto L_0x0009
            L_0x0051:
                java.lang.String r2 = "com.google.android.gms.fitness.internal.service.IFitnessSensorService"
                r5.enforceInterface(r2)
                int r2 = r5.readInt()
                if (r2 == 0) goto L_0x0064
                android.os.Parcelable$Creator<com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest> r0 = com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest r0 = (com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest) r0
            L_0x0064:
                android.os.IBinder r2 = r5.readStrongBinder()
                com.google.android.gms.internal.zznh r2 = com.google.android.gms.internal.zznh.zza.zzbJ(r2)
                r3.zza(r0, r2)
                r0 = r1
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.fitness.internal.service.zzc.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzmt zzmt) throws RemoteException;

    void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zznh zznh) throws RemoteException;

    void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zznh zznh) throws RemoteException;
}
