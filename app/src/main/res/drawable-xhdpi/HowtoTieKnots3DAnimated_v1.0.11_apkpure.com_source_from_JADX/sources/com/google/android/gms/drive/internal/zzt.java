package com.google.android.gms.drive.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableOptions;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzg;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.internal.zzs.zza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzt extends zzj<zzal> {
    private final String zzQl;
    final ConnectionCallbacks zzadB;
    private final Bundle zzaip;
    private final boolean zzaiq;
    private DriveId zzair;
    private DriveId zzais;
    final Map<DriveId, Map<ChangeListener, zzad>> zzait = new HashMap();
    final Map<zzc, zzad> zzaiu = new HashMap();
    final Map<DriveId, Map<zzi, zzad>> zzaiv = new HashMap();
    final Map<DriveId, Map<zzi, zzad>> zzaiw = new HashMap();

    public zzt(Context context, Looper looper, zzf zzf, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, zzf, connectionCallbacks, onConnectionFailedListener);
        this.zzQl = zzf.zzol();
        this.zzadB = connectionCallbacks;
        this.zzaip = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        switch (queryIntentServices.size()) {
            case 0:
                this.zzaiq = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (!serviceInfo.exported) {
                    throw new IllegalStateException("Drive event service " + serviceInfo.name + " must be exported in AndroidManifest.xml");
                }
                this.zzaiq = true;
                return;
            default:
                throw new IllegalStateException("AndroidManifest.xml can only define one service that handles the " + intent.getAction() + " action");
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new RemoveEventListenerRequest(driveId, i), (zzan) null, (String) null, (zzam) new zzbr(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, ChangesAvailableOptions changesAvailableOptions) {
        zzx.zzb(zzg.zza(i, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        if (!this.zzaiq) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        }
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final ChangesAvailableOptions changesAvailableOptions2 = changesAvailableOptions;
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new AddEventListenerRequest(driveId2, i2, changesAvailableOptions2), (zzan) null, (String) null, (zzam) new zzbr(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzad zzad) {
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final zzad zzad2 = zzad;
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new RemoveEventListenerRequest(driveId2, i2), (zzan) zzad2, (String) null, (zzam) new zzbr(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, int i, DriveId driveId, zzad zzad, ChangesAvailableOptions changesAvailableOptions) {
        final DriveId driveId2 = driveId;
        final int i2 = i;
        final ChangesAvailableOptions changesAvailableOptions2 = changesAvailableOptions;
        final zzad zzad2 = zzad;
        return googleApiClient.zzb(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new AddEventListenerRequest(driveId2, i2, changesAvailableOptions2), (zzan) zzad2, (String) null, (zzam) new zzbr(this));
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public PendingResult<Status> cancelPendingActions(GoogleApiClient apiClient, final List<String> pendingTags) {
        boolean z = true;
        zzx.zzZ(pendingTags != null);
        if (pendingTags.isEmpty()) {
            z = false;
        }
        zzx.zzZ(z);
        zzx.zza(isConnected(), (Object) "Client must be connected");
        return apiClient.zzb(new zza(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzt zzt) throws RemoteException {
                zzt.zzqF().zza(new CancelPendingActionsRequest(pendingTags), (zzam) new zzbr(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzal) zzoA()).zza(new DisconnectRequest());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzait) {
            this.zzait.clear();
        }
        synchronized (this.zzaiu) {
            this.zzaiu.clear();
        }
        synchronized (this.zzaiv) {
            this.zzaiv.clear();
        }
        synchronized (this.zzaiw) {
            this.zzaiw.clear();
        }
    }

    /* access modifiers changed from: 0000 */
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId, (ChangesAvailableOptions) null);
    }

    /* access modifiers changed from: 0000 */
    public PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        Map map;
        zzad zzad;
        PendingResult<Status> zzj;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zzb(changeListener, (Object) "listener");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzait) {
            Map map2 = (Map) this.zzait.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.zzait.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            zzad zzad2 = (zzad) map.get(changeListener);
            if (zzad2 == null) {
                zzad = new zzad(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, zzad);
            } else if (zzad2.zzcK(1)) {
                zzj = new zzj<>(googleApiClient, Status.zzaaD);
            } else {
                zzad = zzad2;
            }
            zzad.zzcJ(1);
            zzj = zza(googleApiClient, 1, driveId, zzad, null);
        }
        return zzj;
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzair = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzais = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
        }
        super.zza(i, iBinder, bundle, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaR */
    public zzal zzV(IBinder iBinder) {
        return zzal.zza.zzaS(iBinder);
    }

    /* access modifiers changed from: 0000 */
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    /* access modifiers changed from: 0000 */
    public PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> zza;
        zzx.zzb(zzg.zza(1, driveId), (Object) "id");
        zzx.zza(isConnected(), (Object) "Client must be connected");
        zzx.zzb(changeListener, (Object) "listener");
        synchronized (this.zzait) {
            Map map = (Map) this.zzait.get(driveId);
            if (map == null) {
                zza = new zzj<>(googleApiClient, Status.zzaaD);
            } else {
                zzad zzad = (zzad) map.remove(changeListener);
                if (zzad == null) {
                    zza = new zzj<>(googleApiClient, Status.zzaaD);
                } else {
                    if (map.isEmpty()) {
                        this.zzait.remove(driveId);
                    }
                    zza = zza(googleApiClient, 1, driveId, zzad);
                }
            }
        }
        return zza;
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        String packageName = getContext().getPackageName();
        zzx.zzv(packageName);
        zzx.zzY(!zzoy().zzoj().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzQl)) {
            bundle.putString("proxy_package_name", this.zzQl);
        }
        bundle.putAll(this.zzaip);
        return bundle;
    }

    public boolean zzlm() {
        return !getContext().getPackageName().equals(this.zzQl) || !zzqE();
    }

    public boolean zzoC() {
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzqE() {
        return GooglePlayServicesUtil.zze(getContext(), Process.myUid());
    }

    public zzal zzqF() throws DeadObjectException {
        return (zzal) zzoA();
    }

    public DriveId zzqG() {
        return this.zzair;
    }

    public DriveId zzqH() {
        return this.zzais;
    }

    public boolean zzqI() {
        return this.zzaiq;
    }
}
