package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.BleApi;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.result.BleDevicesResult;

public class zznu implements BleApi {
    private static final Status zzapy = new Status(FitnessStatusCodes.UNSUPPORTED_PLATFORM);

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return new zznj(zzapy);
    }

    public PendingResult<Status> claimBleDevice(GoogleApiClient client, String deviceAddress) {
        return new zznj(zzapy);
    }

    public PendingResult<BleDevicesResult> listClaimedBleDevices(GoogleApiClient client) {
        return new zznj(BleDevicesResult.zzP(zzapy));
    }

    public PendingResult<Status> startBleScan(GoogleApiClient client, StartBleScanRequest request) {
        return new zznj(zzapy);
    }

    public PendingResult<Status> stopBleScan(GoogleApiClient client, BleScanCallback callback) {
        return new zznj(zzapy);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, BleDevice bleDevice) {
        return new zznj(zzapy);
    }

    public PendingResult<Status> unclaimBleDevice(GoogleApiClient client, String deviceAddress) {
        return new zznj(zzapy);
    }
}
