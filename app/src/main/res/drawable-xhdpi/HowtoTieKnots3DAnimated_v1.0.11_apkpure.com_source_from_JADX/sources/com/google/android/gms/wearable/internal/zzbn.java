package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zza.C1552zza;
import com.google.android.gms.wearable.zzc.zza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzbn extends zzj<zzaw> {
    private final ExecutorService zzaRv = Executors.newCachedThreadPool();
    private final zzax<zza> zzbaU = new zzax<>();
    private final zzax<C1552zza> zzbaV = new zzax<>();
    private final zzax<ChannelListener> zzbaW = new zzax<>();
    private final zzax<DataListener> zzbaX = new zzax<>();
    private final zzax<MessageListener> zzbaY = new zzax<>();
    private final zzax<NodeListener> zzbaZ = new zzax<>();
    private final zzax<NodeApi.zza> zzbba = new zzax<>();
    private final Map<String, zzax<CapabilityListener>> zzbbb = new HashMap();

    public zzbn(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzf zzf) {
        super(context, looper, 14, zzf, connectionCallbacks, onConnectionFailedListener);
    }

    private FutureTask<Boolean> zza(final ParcelFileDescriptor parcelFileDescriptor, final byte[] bArr) {
        return new FutureTask<>(new Callable<Boolean>() {
            /* renamed from: zzCI */
            public Boolean call() {
                if (Log.isLoggable("WearableClient", 3)) {
                    Log.d("WearableClient", "processAssets: writing data to FD : " + parcelFileDescriptor);
                }
                AutoCloseOutputStream autoCloseOutputStream = new AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    autoCloseOutputStream.write(bArr);
                    autoCloseOutputStream.flush();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: wrote data: " + parcelFileDescriptor);
                    }
                    Boolean valueOf = Boolean.valueOf(true);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                        return valueOf;
                    } catch (IOException e) {
                        return valueOf;
                    }
                } catch (IOException e2) {
                    Log.w("WearableClient", "processAssets: writing data failed: " + parcelFileDescriptor);
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e3) {
                    }
                    return Boolean.valueOf(false);
                } finally {
                    try {
                        if (Log.isLoggable("WearableClient", 3)) {
                            Log.d("WearableClient", "processAssets: closing: " + parcelFileDescriptor);
                        }
                        autoCloseOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
            }
        });
    }

    private FutureTask<Void> zzb(zzb<Status> zzb, String str, Uri uri, long j, long j2) {
        zzx.zzv(zzb);
        zzx.zzv(str);
        zzx.zzv(uri);
        zzx.zzb(j >= 0, "startOffset is negative: %s", Long.valueOf(j));
        zzx.zzb(j2 >= -1, "invalid length: %s", Long.valueOf(j2));
        final Uri uri2 = uri;
        final zzb<Status> zzb2 = zzb;
        final String str2 = str;
        final long j3 = j;
        final long j4 = j2;
        return new FutureTask<>(new Runnable() {
            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing sendFileToChannelTask");
                }
                if (!"file".equals(uri2.getScheme())) {
                    Log.w("WearableClient", "Channel.sendFile used with non-file URI");
                    zzb2.zzx(new Status(10, "Channel.sendFile used with non-file URI"));
                    return;
                }
                File file = new File(uri2.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, DriveFile.MODE_READ_ONLY);
                    try {
                        ((zzaw) zzbn.this.zzoA()).zza(new zzr(zzb2), str2, open, j3, j4);
                        try {
                        } catch (IOException e) {
                            Log.w("WearableClient", "Failed to close sourceFd", e);
                        }
                    } catch (RemoteException e2) {
                        Log.w("WearableClient", "Channel.sendFile failed.", e2);
                        zzb2.zzx(new Status(8));
                        try {
                        } catch (IOException e3) {
                            Log.w("WearableClient", "Failed to close sourceFd", e3);
                        }
                    } finally {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close sourceFd", e4);
                        }
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.sendFile: " + file);
                    zzb2.zzx(new Status(13));
                }
            }
        }, null);
    }

    private FutureTask<Void> zzb(zzb<Status> zzb, String str, Uri uri, boolean z) {
        zzx.zzv(zzb);
        zzx.zzv(str);
        zzx.zzv(uri);
        final Uri uri2 = uri;
        final zzb<Status> zzb2 = zzb;
        final boolean z2 = z;
        final String str2 = str;
        return new FutureTask<>(new Runnable() {
            public void run() {
                if (Log.isLoggable("WearableClient", 2)) {
                    Log.v("WearableClient", "Executing receiveFileFromChannelTask");
                }
                if (!"file".equals(uri2.getScheme())) {
                    Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
                    zzb2.zzx(new Status(10, "Channel.receiveFile used with non-file URI"));
                    return;
                }
                File file = new File(uri2.getPath());
                try {
                    ParcelFileDescriptor open = ParcelFileDescriptor.open(file, (z2 ? 33554432 : 0) | DriveFile.MODE_WRITE_ONLY);
                    try {
                        ((zzaw) zzbn.this.zzoA()).zza((zzau) new zzu(zzb2), str2, open);
                        try {
                        } catch (IOException e) {
                            Log.w("WearableClient", "Failed to close targetFd", e);
                        }
                    } catch (RemoteException e2) {
                        Log.w("WearableClient", "Channel.receiveFile failed.", e2);
                        zzb2.zzx(new Status(8));
                        try {
                        } catch (IOException e3) {
                            Log.w("WearableClient", "Failed to close targetFd", e3);
                        }
                    } finally {
                        try {
                            open.close();
                        } catch (IOException e4) {
                            Log.w("WearableClient", "Failed to close targetFd", e4);
                        }
                    }
                } catch (FileNotFoundException e5) {
                    Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: " + file);
                    zzb2.zzx(new Status(13));
                }
            }
        }, null);
    }

    private zzax<CapabilityListener> zzfw(String str) {
        zzax<CapabilityListener> zzax = (zzax) this.zzbbb.get(str);
        if (zzax != null) {
            return zzax;
        }
        zzax<CapabilityListener> zzax2 = new zzax<>();
        this.zzbbb.put(str, zzax2);
        return zzax2;
    }

    public void disconnect() {
        this.zzbaU.zzb(this);
        this.zzbaV.zzb(this);
        this.zzbaX.zzb(this);
        this.zzbaY.zzb(this);
        this.zzbaZ.zzb(this);
        this.zzbba.zzb(this);
        synchronized (this.zzbbb) {
            for (zzax zzb : this.zzbbb.values()) {
                zzb.zzb(this);
            }
        }
        super.disconnect();
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (Log.isLoggable("WearableClient", 2)) {
            Log.d("WearableClient", "onPostInitHandler: statusCode " + i);
        }
        if (i == 0) {
            this.zzbaU.zzeb(iBinder);
            this.zzbaV.zzeb(iBinder);
            this.zzbaX.zzeb(iBinder);
            this.zzbaY.zzeb(iBinder);
            this.zzbaZ.zzeb(iBinder);
            this.zzbba.zzeb(iBinder);
            synchronized (this.zzbbb) {
                for (zzax zzeb : this.zzbbb.values()) {
                    zzeb.zzeb(iBinder);
                }
            }
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(zzb<DataItemResult> zzb, Uri uri) throws RemoteException {
        ((zzaw) zzoA()).zza((zzau) new zzk(zzb), uri);
    }

    public void zza(zzb<DataItemBuffer> zzb, Uri uri, int i) throws RemoteException {
        ((zzaw) zzoA()).zza((zzau) new zzl(zzb), uri, i);
    }

    public void zza(zzb<GetFdForAssetResult> zzb, Asset asset) throws RemoteException {
        ((zzaw) zzoA()).zza((zzau) new zzm(zzb), asset);
    }

    public void zza(zzb<Status> zzb, CapabilityListener capabilityListener, String str) throws RemoteException {
        synchronized (this.zzbbb) {
            zzfw(str).zza(this, zzb, capabilityListener, zzbo.zza(capabilityListener, str));
        }
    }

    public void zza(zzb<Status> zzb, ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzbaW.zza(this, zzb, channelListener, zzbo.zzb(channelListener));
            return;
        }
        zzbi zzbi = new zzbi(str, channelListener);
        this.zzbaW.zza(this, zzb, zzbi, zzbo.zza((ChannelListener) zzbi, str));
    }

    public void zza(zzb<Status> zzb, DataListener dataListener) throws RemoteException {
        this.zzbaX.zza(this, zzb, dataListener);
    }

    public void zza(zzb<Status> zzb, DataListener dataListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbaX.zza(this, zzb, dataListener, zzbo.zza(dataListener, intentFilterArr));
    }

    public void zza(zzb<GetFdForAssetResult> zzb, DataItemAsset dataItemAsset) throws RemoteException {
        zza(zzb, Asset.createFromRef(dataItemAsset.getId()));
    }

    public void zza(zzb<Status> zzb, MessageListener messageListener) throws RemoteException {
        this.zzbaY.zza(this, zzb, messageListener);
    }

    public void zza(zzb<Status> zzb, MessageListener messageListener, IntentFilter[] intentFilterArr) throws RemoteException {
        this.zzbaY.zza(this, zzb, messageListener, zzbo.zza(messageListener, intentFilterArr));
    }

    public void zza(zzb<Status> zzb, NodeListener nodeListener) throws RemoteException {
        this.zzbaZ.zza(this, zzb, nodeListener, zzbo.zza(nodeListener));
    }

    public void zza(zzb<DataItemResult> zzb, PutDataRequest putDataRequest) throws RemoteException {
        for (Entry value : putDataRequest.getAssets().entrySet()) {
            Asset asset = (Asset) value.getValue();
            if (asset.getData() == null && asset.getDigest() == null && asset.getFd() == null && asset.getUri() == null) {
                throw new IllegalArgumentException("Put for " + putDataRequest.getUri() + " contains invalid asset: " + asset);
            }
        }
        PutDataRequest zzo = PutDataRequest.zzo(putDataRequest.getUri());
        zzo.setData(putDataRequest.getData());
        ArrayList arrayList = new ArrayList();
        for (Entry entry : putDataRequest.getAssets().entrySet()) {
            Asset asset2 = (Asset) entry.getValue();
            if (asset2.getData() == null) {
                zzo.putAsset((String) entry.getKey(), (Asset) entry.getValue());
            } else {
                try {
                    ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                    if (Log.isLoggable("WearableClient", 3)) {
                        Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + asset2 + " read:" + createPipe[0] + " write:" + createPipe[1]);
                    }
                    zzo.putAsset((String) entry.getKey(), Asset.createFromFd(createPipe[0]));
                    FutureTask zza = zza(createPipe[1], asset2.getData());
                    arrayList.add(zza);
                    this.zzaRv.submit(zza);
                } catch (IOException e) {
                    throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + putDataRequest, e);
                }
            }
        }
        ((zzaw) zzoA()).zza((zzau) new zzq(zzb, arrayList), zzo);
    }

    public void zza(zzb<Status> zzb, String str, Uri uri, long j, long j2) {
        try {
            this.zzaRv.submit(zzb(zzb, str, uri, j, j2));
        } catch (RuntimeException e) {
            zzb.zzx(new Status(8));
            throw e;
        }
    }

    public void zza(zzb<Status> zzb, String str, Uri uri, boolean z) {
        try {
            this.zzaRv.submit(zzb(zzb, str, uri, z));
        } catch (RuntimeException e) {
            zzb.zzx(new Status(8));
            throw e;
        }
    }

    public void zza(zzb<SendMessageResult> zzb, String str, String str2, byte[] bArr) throws RemoteException {
        ((zzaw) zzoA()).zza(new zzt(zzb), str, str2, bArr);
    }

    public void zzb(zzb<DeleteDataItemsResult> zzb, Uri uri, int i) throws RemoteException {
        ((zzaw) zzoA()).zzb((zzau) new zze(zzb), uri, i);
    }

    public void zzb(zzb<Status> zzb, CapabilityListener capabilityListener, String str) throws RemoteException {
        synchronized (this.zzbbb) {
            zzax zzfw = zzfw(str);
            zzfw.zza(this, zzb, capabilityListener);
            if (zzfw.isEmpty()) {
                this.zzbbb.remove(str);
            }
        }
    }

    public void zzb(zzb<Status> zzb, ChannelListener channelListener, String str) throws RemoteException {
        if (str == null) {
            this.zzbaW.zza(this, zzb, channelListener);
            return;
        }
        this.zzbaW.zza(this, zzb, new zzbi(str, channelListener));
    }

    public void zzb(zzb<Status> zzb, NodeListener nodeListener) throws RemoteException {
        this.zzbaZ.zza(this, zzb, nodeListener);
    }

    public void zzd(zzb<GetAllCapabilitiesResult> zzb, int i) throws RemoteException {
        ((zzaw) zzoA()).zza((zzau) new zzf(zzb), i);
    }

    public void zze(zzb<OpenChannelResult> zzb, String str, String str2) throws RemoteException {
        ((zzaw) zzoA()).zza((zzau) new zzp(zzb), str, str2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzec */
    public zzaw zzV(IBinder iBinder) {
        return zzaw.zza.zzea(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.wearable.BIND";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    public void zzg(zzb<GetCapabilityResult> zzb, String str, int i) throws RemoteException {
        ((zzaw) zzoA()).zza((zzau) new zzg(zzb), str, i);
    }

    public void zzh(zzb<Status> zzb, String str, int i) throws RemoteException {
        ((zzaw) zzoA()).zzb((zzau) new zzd(zzb), str, i);
    }

    public void zzn(zzb<DataItemBuffer> zzb) throws RemoteException {
        ((zzaw) zzoA()).zzb(new zzl(zzb));
    }

    public void zzo(zzb<GetLocalNodeResult> zzb) throws RemoteException {
        ((zzaw) zzoA()).zzc(new zzn(zzb));
    }

    public void zzp(zzb<GetConnectedNodesResult> zzb) throws RemoteException {
        ((zzaw) zzoA()).zzd(new zzj(zzb));
    }

    public void zzr(zzb<AddLocalCapabilityResult> zzb, String str) throws RemoteException {
        ((zzaw) zzoA()).zzd(new zza(zzb), str);
    }

    public void zzs(zzb<RemoveLocalCapabilityResult> zzb, String str) throws RemoteException {
        ((zzaw) zzoA()).zze(new zzs(zzb), str);
    }

    public void zzt(zzb<Status> zzb, String str) throws RemoteException {
        ((zzaw) zzoA()).zzf(new zzc(zzb), str);
    }

    public void zzu(zzb<GetInputStreamResult> zzb, String str) throws RemoteException {
        zzs zzs = new zzs();
        ((zzaw) zzoA()).zza((zzau) new zzh(zzb, zzs), (zzat) zzs, str);
    }

    public void zzv(zzb<GetOutputStreamResult> zzb, String str) throws RemoteException {
        zzs zzs = new zzs();
        ((zzaw) zzoA()).zzb((zzau) new zzi(zzb, zzs), (zzat) zzs, str);
    }
}
