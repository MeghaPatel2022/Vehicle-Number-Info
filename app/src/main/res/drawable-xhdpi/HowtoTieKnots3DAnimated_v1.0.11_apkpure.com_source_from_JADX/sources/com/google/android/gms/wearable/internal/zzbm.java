package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzbm {

    static final class zza extends zzb<AddLocalCapabilityResult> {
        public zza(com.google.android.gms.common.api.zzc.zzb<AddLocalCapabilityResult> zzb) {
            super(zzb);
        }

        public void zza(AddLocalCapabilityResponse addLocalCapabilityResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zzb(zzbj.zzfx(addLocalCapabilityResponse.statusCode)));
        }
    }

    static abstract class zzb<T> extends zza {
        private com.google.android.gms.common.api.zzc.zzb<T> zzPW;

        public zzb(com.google.android.gms.common.api.zzc.zzb<T> zzb) {
            this.zzPW = zzb;
        }

        public void zzR(T t) {
            com.google.android.gms.common.api.zzc.zzb<T> zzb = this.zzPW;
            if (zzb != null) {
                zzb.zzn(t);
                this.zzPW = null;
            }
        }
    }

    static final class zzc extends zzb<Status> {
        public zzc(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
        }

        public void zza(CloseChannelResponse closeChannelResponse) {
            zzR(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zzd extends zzb<Status> {
        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
        }

        public void zzb(CloseChannelResponse closeChannelResponse) {
            zzR(new Status(closeChannelResponse.statusCode));
        }
    }

    static final class zze extends zzb<DeleteDataItemsResult> {
        public zze(com.google.android.gms.common.api.zzc.zzb<DeleteDataItemsResult> zzb) {
            super(zzb);
        }

        public void zza(DeleteDataItemsResponse deleteDataItemsResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzc(zzbj.zzfx(deleteDataItemsResponse.statusCode), deleteDataItemsResponse.zzbaq));
        }
    }

    static final class zzf extends zzb<GetAllCapabilitiesResult> {
        public zzf(com.google.android.gms.common.api.zzc.zzb<GetAllCapabilitiesResult> zzb) {
            super(zzb);
        }

        public void zza(GetAllCapabilitiesResponse getAllCapabilitiesResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zzd(zzbj.zzfx(getAllCapabilitiesResponse.statusCode), zzbm.zzv(getAllCapabilitiesResponse.zzbar)));
        }
    }

    static final class zzg extends zzb<GetCapabilityResult> {
        public zzg(com.google.android.gms.common.api.zzc.zzb<GetCapabilityResult> zzb) {
            super(zzb);
        }

        public void zza(GetCapabilityResponse getCapabilityResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zze(zzbj.zzfx(getCapabilityResponse.statusCode), new com.google.android.gms.wearable.internal.zzi.zzc(getCapabilityResponse.zzbas)));
        }
    }

    static final class zzh extends zzb<GetInputStreamResult> {
        private final zzs zzbaT;

        public zzh(com.google.android.gms.common.api.zzc.zzb<GetInputStreamResult> zzb, zzs zzs) {
            super(zzb);
            this.zzbaT = (zzs) zzx.zzv(zzs);
        }

        public void zza(GetChannelInputStreamResponse getChannelInputStreamResponse) {
            zzo zzo = null;
            if (getChannelInputStreamResponse.zzbat != null) {
                zzo = new zzo(new AutoCloseInputStream(getChannelInputStreamResponse.zzbat));
                this.zzbaT.zza(zzo.zzCD());
            }
            zzR(new zza(new Status(getChannelInputStreamResponse.statusCode), zzo));
        }
    }

    static final class zzi extends zzb<GetOutputStreamResult> {
        private final zzs zzbaT;

        public zzi(com.google.android.gms.common.api.zzc.zzb<GetOutputStreamResult> zzb, zzs zzs) {
            super(zzb);
            this.zzbaT = (zzs) zzx.zzv(zzs);
        }

        public void zza(GetChannelOutputStreamResponse getChannelOutputStreamResponse) {
            zzp zzp = null;
            if (getChannelOutputStreamResponse.zzbat != null) {
                zzp = new zzp(new AutoCloseOutputStream(getChannelOutputStreamResponse.zzbat));
                this.zzbaT.zza(zzp.zzCD());
            }
            zzR(new zzb(new Status(getChannelOutputStreamResponse.statusCode), zzp));
        }
    }

    static final class zzj extends zzb<GetConnectedNodesResult> {
        public zzj(com.google.android.gms.common.api.zzc.zzb<GetConnectedNodesResult> zzb) {
            super(zzb);
        }

        public void zza(GetConnectedNodesResponse getConnectedNodesResponse) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(getConnectedNodesResponse.zzbaz);
            zzR(new com.google.android.gms.wearable.internal.zzba.zzb(zzbj.zzfx(getConnectedNodesResponse.statusCode), arrayList));
        }
    }

    static final class zzk extends zzb<DataItemResult> {
        public zzk(com.google.android.gms.common.api.zzc.zzb<DataItemResult> zzb) {
            super(zzb);
        }

        public void zza(GetDataItemResponse getDataItemResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzb(zzbj.zzfx(getDataItemResponse.statusCode), getDataItemResponse.zzbaA));
        }
    }

    static final class zzl extends zzb<DataItemBuffer> {
        public zzl(com.google.android.gms.common.api.zzc.zzb<DataItemBuffer> zzb) {
            super(zzb);
        }

        public void zzae(DataHolder dataHolder) {
            zzR(new DataItemBuffer(dataHolder));
        }
    }

    static final class zzm extends zzb<GetFdForAssetResult> {
        public zzm(com.google.android.gms.common.api.zzc.zzb<GetFdForAssetResult> zzb) {
            super(zzb);
        }

        public void zza(GetFdForAssetResponse getFdForAssetResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzd(zzbj.zzfx(getFdForAssetResponse.statusCode), getFdForAssetResponse.zzbaB));
        }
    }

    static final class zzn extends zzb<GetLocalNodeResult> {
        public zzn(com.google.android.gms.common.api.zzc.zzb<GetLocalNodeResult> zzb) {
            super(zzb);
        }

        public void zza(GetLocalNodeResponse getLocalNodeResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzba.zzc(zzbj.zzfx(getLocalNodeResponse.statusCode), getLocalNodeResponse.zzbaC));
        }
    }

    static final class zzo extends zza {
        zzo() {
        }

        public void zzc(Status status) {
        }
    }

    static final class zzp extends zzb<OpenChannelResult> {
        public zzp(com.google.android.gms.common.api.zzc.zzb<OpenChannelResult> zzb) {
            super(zzb);
        }

        public void zza(OpenChannelResponse openChannelResponse) {
            zzR(new zzb(zzbj.zzfx(openChannelResponse.statusCode), openChannelResponse.zzaZR));
        }
    }

    static final class zzq extends zzb<DataItemResult> {
        private final List<FutureTask<Boolean>> zzxu;

        zzq(com.google.android.gms.common.api.zzc.zzb<DataItemResult> zzb, List<FutureTask<Boolean>> list) {
            super(zzb);
            this.zzxu = list;
        }

        public void zza(PutDataResponse putDataResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzw.zzb(zzbj.zzfx(putDataResponse.statusCode), putDataResponse.zzbaA));
            if (putDataResponse.statusCode != 0) {
                for (FutureTask cancel : this.zzxu) {
                    cancel.cancel(true);
                }
            }
        }
    }

    static final class zzr extends zzb<Status> {
        public zzr(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
        }

        public void zza(ChannelSendFileResponse channelSendFileResponse) {
            zzR(new Status(channelSendFileResponse.statusCode));
        }
    }

    static final class zzs extends zzb<RemoveLocalCapabilityResult> {
        public zzs(com.google.android.gms.common.api.zzc.zzb<RemoveLocalCapabilityResult> zzb) {
            super(zzb);
        }

        public void zza(RemoveLocalCapabilityResponse removeLocalCapabilityResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzi.zzb(zzbj.zzfx(removeLocalCapabilityResponse.statusCode)));
        }
    }

    static final class zzt extends zzb<SendMessageResult> {
        public zzt(com.google.android.gms.common.api.zzc.zzb<SendMessageResult> zzb) {
            super(zzb);
        }

        public void zza(SendMessageResponse sendMessageResponse) {
            zzR(new com.google.android.gms.wearable.internal.zzay.zzb(zzbj.zzfx(sendMessageResponse.statusCode), sendMessageResponse.zzaBi));
        }
    }

    static final class zzu extends zzb<Status> {
        public zzu(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
        }

        public void zza(ChannelReceiveFileResponse channelReceiveFileResponse) {
            zzR(new Status(channelReceiveFileResponse.statusCode));
        }
    }

    /* access modifiers changed from: private */
    public static Map<String, CapabilityInfo> zzv(List<CapabilityInfoParcelable> list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        for (CapabilityInfoParcelable capabilityInfoParcelable : list) {
            hashMap.put(capabilityInfoParcelable.getName(), new com.google.android.gms.wearable.internal.zzi.zzc(capabilityInfoParcelable));
        }
        return hashMap;
    }
}
