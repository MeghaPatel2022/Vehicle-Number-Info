package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznh;
import java.util.List;

public abstract class FitnessSensorService extends Service {
    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzaqP;

    private static class zza extends com.google.android.gms.fitness.internal.service.zzc.zza {
        private final FitnessSensorService zzaqQ;

        private zza(FitnessSensorService fitnessSensorService) {
            this.zzaqQ = fitnessSensorService;
        }

        public void zza(FitnessDataSourcesRequest fitnessDataSourcesRequest, zzmt zzmt) throws RemoteException {
            this.zzaqQ.zzsI();
            zzmt.zza(new DataSourcesResult(this.zzaqQ.onFindDataSources(fitnessDataSourcesRequest.getDataTypes()), Status.zzaaD));
        }

        public void zza(FitnessUnregistrationRequest fitnessUnregistrationRequest, zznh zznh) throws RemoteException {
            this.zzaqQ.zzsI();
            if (this.zzaqQ.onUnregister(fitnessUnregistrationRequest.getDataSource())) {
                zznh.zzr(Status.zzaaD);
            } else {
                zznh.zzr(new Status(13));
            }
        }

        public void zza(FitnessSensorServiceRequest fitnessSensorServiceRequest, zznh zznh) throws RemoteException {
            this.zzaqQ.zzsI();
            if (this.zzaqQ.onRegister(fitnessSensorServiceRequest)) {
                zznh.zzr(Status.zzaaD);
            } else {
                zznh.zzr(new Status(13));
            }
        }
    }

    public final IBinder onBind(Intent intent) {
        if (!SERVICE_INTERFACE.equals(intent.getAction())) {
            return null;
        }
        if (Log.isLoggable("FitnessSensorService", 3)) {
            Log.d("FitnessSensorService", "Intent " + intent + " received by " + getClass().getName());
        }
        return this.zzaqP.asBinder();
    }

    public void onCreate() {
        super.onCreate();
        this.zzaqP = new zza();
    }

    public abstract List<DataSource> onFindDataSources(List<DataType> list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnessSensorServiceRequest);

    public abstract boolean onUnregister(DataSource dataSource);

    /* access modifiers changed from: protected */
    public void zzsI() throws SecurityException {
        int callingUid = Binder.getCallingUid();
        String str = "com.google.android.gms";
        if (zzlv.zzpV()) {
            ((AppOpsManager) getSystemService("appops")).checkPackage(callingUid, "com.google.android.gms");
            return;
        }
        String[] packagesForUid = getPackageManager().getPackagesForUid(callingUid);
        if (packagesForUid != null) {
            int length = packagesForUid.length;
            int i = 0;
            while (i < length) {
                if (!packagesForUid[i].equals("com.google.android.gms")) {
                    i++;
                } else {
                    return;
                }
            }
        }
        throw new SecurityException("Unauthorized caller");
    }
}
