package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzw implements DataApi {

    private static final class zza extends zzh<Status> {
        private DataListener zzbak;
        private IntentFilter[] zzbal;

        private zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
            super(googleApiClient);
            this.zzbak = dataListener;
            this.zzbal = intentFilterArr;
        }

        /* access modifiers changed from: protected */
        public void zza(zzbn zzbn) throws RemoteException {
            zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, this.zzbak, this.zzbal);
            this.zzbak = null;
            this.zzbal = null;
        }

        /* renamed from: zzd */
        public Status zzb(Status status) {
            this.zzbak = null;
            this.zzbal = null;
            return status;
        }
    }

    public static class zzb implements DataItemResult {
        private final Status zzQA;
        private final DataItem zzbam;

        public zzb(Status status, DataItem dataItem) {
            this.zzQA = status;
            this.zzbam = dataItem;
        }

        public DataItem getDataItem() {
            return this.zzbam;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzc implements DeleteDataItemsResult {
        private final Status zzQA;
        private final int zzban;

        public zzc(Status status, int i) {
            this.zzQA = status;
            this.zzban = i;
        }

        public int getNumDeleted() {
            return this.zzban;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public static class zzd implements GetFdForAssetResult {
        private volatile boolean mClosed = false;
        private final Status zzQA;
        private volatile InputStream zzaZW;
        private volatile ParcelFileDescriptor zzbao;

        public zzd(Status status, ParcelFileDescriptor parcelFileDescriptor) {
            this.zzQA = status;
            this.zzbao = parcelFileDescriptor;
        }

        public ParcelFileDescriptor getFd() {
            if (!this.mClosed) {
                return this.zzbao;
            }
            throw new IllegalStateException("Cannot access the file descriptor after release().");
        }

        public InputStream getInputStream() {
            if (this.mClosed) {
                throw new IllegalStateException("Cannot access the input stream after release().");
            } else if (this.zzbao == null) {
                return null;
            } else {
                if (this.zzaZW == null) {
                    this.zzaZW = new AutoCloseInputStream(this.zzbao);
                }
                return this.zzaZW;
            }
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzbao != null) {
                if (this.mClosed) {
                    throw new IllegalStateException("releasing an already released result.");
                }
                try {
                    if (this.zzaZW != null) {
                        this.zzaZW.close();
                    } else {
                        this.zzbao.close();
                    }
                    this.mClosed = true;
                    this.zzbao = null;
                    this.zzaZW = null;
                } catch (IOException e) {
                }
            }
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, DataListener dataListener, IntentFilter[] intentFilterArr) {
        return googleApiClient.zza(new zza(googleApiClient, dataListener, intentFilterArr));
    }

    private void zza(Asset asset) {
        if (asset == null) {
            throw new IllegalArgumentException("asset is null");
        } else if (asset.getDigest() == null) {
            throw new IllegalArgumentException("invalid asset");
        } else if (asset.getData() != null) {
            throw new IllegalArgumentException("invalid asset");
        }
    }

    public PendingResult<Status> addListener(GoogleApiClient client, DataListener listener) {
        return zza(client, listener, null);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, Uri uri) {
        return deleteDataItems(client, uri, 0);
    }

    public PendingResult<DeleteDataItemsResult> deleteDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        return client.zza(new zzh<DeleteDataItemsResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzb((com.google.android.gms.common.api.zzc.zzb<DeleteDataItemsResult>) this, uri, filterType);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbr */
            public DeleteDataItemsResult zzb(Status status) {
                return new zzc(status, 0);
            }
        });
    }

    public PendingResult<DataItemResult> getDataItem(GoogleApiClient client, final Uri uri) {
        return client.zza(new zzh<DataItemResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<DataItemResult>) this, uri);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbp */
            public DataItemResult zzb(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client) {
        return client.zza(new zzh<DataItemBuffer>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzn(this);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbq */
            public DataItemBuffer zzb(Status status) {
                return new DataItemBuffer(DataHolder.zzbp(status.getStatusCode()));
            }
        });
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, Uri uri) {
        return getDataItems(client, uri, 0);
    }

    public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient client, final Uri uri, final int filterType) {
        return client.zza(new zzh<DataItemBuffer>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<DataItemBuffer>) this, uri, filterType);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbq */
            public DataItemBuffer zzb(Status status) {
                return new DataItemBuffer(DataHolder.zzbp(status.getStatusCode()));
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final Asset asset) {
        zza(asset);
        return client.zza(new zzh<GetFdForAssetResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<GetFdForAssetResult>) this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbs */
            public GetFdForAssetResult zzb(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<GetFdForAssetResult> getFdForAsset(GoogleApiClient client, final DataItemAsset asset) {
        return client.zza(new zzh<GetFdForAssetResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<GetFdForAssetResult>) this, asset);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzbs */
            public GetFdForAssetResult zzb(Status status) {
                return new zzd(status, null);
            }
        });
    }

    public PendingResult<DataItemResult> putDataItem(GoogleApiClient client, final PutDataRequest request) {
        return client.zza(new zzh<DataItemResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<DataItemResult>) this, request);
            }

            /* renamed from: zzbp */
            public DataItemResult zzb(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, final DataListener listener) {
        return client.zza(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, listener);
            }

            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }
}
