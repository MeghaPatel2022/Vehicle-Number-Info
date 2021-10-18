package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zznm implements BleApi {

    private static class zza extends com.google.android.gms.internal.zznv.zza {
        private final zzb<BleDevicesResult> zzQz;

        private zza(zzb<BleDevicesResult> zzb) {
            this.zzQz = zzb;
        }

        public void zza(BleDevicesResult bleDevicesResult) {
            this.zzQz.zzn(bleDevicesResult);
        }
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final BleDevice bleDevice) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmk zzmk) throws RemoteException {
                ((zzmv) zzmk.zzoA()).zza(new ClaimBleDeviceRequest(bleDevice.getAddress(), bleDevice, new zznt(this), zzmk.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmk zzmk) throws RemoteException {
                ((zzmv) zzmk.zzoA()).zza(new ClaimBleDeviceRequest(deviceAddress, null, new zznt(this), zzmk.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return client.zza(new zza<BleDevicesResult>(client) {
            /* access modifiers changed from: protected */
            /* renamed from: zzH */
            public BleDevicesResult zzb(Status status) {
                return BleDevicesResult.zzP(status);
            }

            /* access modifiers changed from: protected */
            public void zza(zzmk zzmk) throws RemoteException {
                ((zzmv) zzmk.zzoA()).zza(new ListClaimedBleDevicesRequest(new zza(this), zzmk.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, final StartBleScanRequest request) {
        return client.zza(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmk zzmk) throws RemoteException {
                ((zzmv) zzmk.zzoA()).zza(new StartBleScanRequest(request, new zznt(this), zzmk.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, final BleScanCallback requestCallback) {
        return client.zza(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmk zzmk) throws RemoteException {
                ((zzmv) zzmk.zzoA()).zza(new StopBleScanRequest(requestCallback, (zznh) new zznt(this), zzmk.getContext().getPackageName()));
            }
        });
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return unclaimBleDevice(client, bleDevice.getAddress());
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, final String deviceAddress) {
        return client.zzb(new zzc(client) {
            /* access modifiers changed from: protected */
            public void zza(zzmk zzmk) throws RemoteException {
                ((zzmv) zzmk.zzoA()).zza(new UnclaimBleDeviceRequest(deviceAddress, new zznt(this), zzmk.getContext().getPackageName()));
            }
        });
    }
}
