package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;

public class zzk {
    private String zzagU;
    private DriveId zzagX;
    protected MetadataChangeSet zzahY;
    private Integer zzahZ;
    private final int zzaia;

    public zzk(int i) {
        this.zzaia = i;
    }

    public IntentSender build(GoogleApiClient apiClient) {
        zzx.zzb(this.zzahY, (Object) "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(apiClient.isConnected(), (Object) "Client must be connected");
        zzt zzt = (zzt) apiClient.zza(Drive.zzQf);
        this.zzahY.zzqp().setContext(zzt.getContext());
        try {
            return zzt.zzqF().zza(new CreateFileIntentSenderRequest(this.zzahY.zzqp(), this.zzahZ == null ? 0 : this.zzahZ.intValue(), this.zzagU, this.zzagX, this.zzaia));
        } catch (RemoteException e) {
            throw new RuntimeException("Unable to connect Drive Play Service", e);
        }
    }

    public void zza(DriveId driveId) {
        this.zzagX = (DriveId) zzx.zzv(driveId);
    }

    public void zza(MetadataChangeSet metadataChangeSet) {
        this.zzahY = (MetadataChangeSet) zzx.zzv(metadataChangeSet);
    }

    public void zzcC(int i) {
        this.zzahZ = Integer.valueOf(i);
    }

    public void zzcF(String str) {
        this.zzagU = (String) zzx.zzv(str);
    }
}
