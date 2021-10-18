package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl implements SafeParcelable, Channel {
    public static final Creator<ChannelImpl> CREATOR = new zzn();
    private final String mPath;
    final int mVersionCode;
    private final String zzaYR;
    /* access modifiers changed from: private */
    public final String zzaZM;

    static final class zza implements GetInputStreamResult {
        private final Status zzQA;
        private final InputStream zzaZW;

        zza(Status status, InputStream inputStream) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZW = inputStream;
        }

        public InputStream getInputStream() {
            return this.zzaZW;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaZW != null) {
                try {
                    this.zzaZW.close();
                } catch (IOException e) {
                }
            }
        }
    }

    static final class zzb implements GetOutputStreamResult {
        private final Status zzQA;
        private final OutputStream zzaZX;

        zzb(Status status, OutputStream outputStream) {
            this.zzQA = (Status) zzx.zzv(status);
            this.zzaZX = outputStream;
        }

        public OutputStream getOutputStream() {
            return this.zzaZX;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaZX != null) {
                try {
                    this.zzaZX.close();
                } catch (IOException e) {
                }
            }
        }
    }

    ChannelImpl(int versionCode, String token, String nodeId, String path) {
        this.mVersionCode = versionCode;
        this.zzaZM = (String) zzx.zzv(token);
        this.zzaYR = (String) zzx.zzv(nodeId);
        this.mPath = (String) zzx.zzv(path);
    }

    public PendingResult<Status> addListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(listener, (Object) "listener is null");
        return client.zza(new zza(client, listener, this.zzaZM));
    }

    public PendingResult<Status> close(GoogleApiClient client) {
        return client.zzb(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzt(this, ChannelImpl.this.zzaZM);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> close(GoogleApiClient client, final int errorCode) {
        return client.zzb(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzh(this, ChannelImpl.this.zzaZM, errorCode);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ChannelImpl)) {
            return false;
        }
        ChannelImpl channelImpl = (ChannelImpl) other;
        return this.zzaZM.equals(channelImpl.zzaZM) && zzw.equal(channelImpl.zzaYR, this.zzaYR) && zzw.equal(channelImpl.mPath, this.mPath) && channelImpl.mVersionCode == this.mVersionCode;
    }

    public PendingResult<GetInputStreamResult> getInputStream(GoogleApiClient client) {
        return client.zzb(new zzh<GetInputStreamResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzu(this, ChannelImpl.this.zzaZM);
            }

            /* renamed from: zzbn */
            public GetInputStreamResult zzb(Status status) {
                return new zza(status, null);
            }
        });
    }

    public String getNodeId() {
        return this.zzaYR;
    }

    public PendingResult<GetOutputStreamResult> getOutputStream(GoogleApiClient client) {
        return client.zzb(new zzh<GetOutputStreamResult>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zzv(this, ChannelImpl.this.zzaZM);
            }

            /* renamed from: zzbo */
            public GetOutputStreamResult zzb(Status status) {
                return new zzb(status, null);
            }
        });
    }

    public String getPath() {
        return this.mPath;
    }

    public String getToken() {
        return this.zzaZM;
    }

    public int hashCode() {
        return this.zzaZM.hashCode();
    }

    public PendingResult<Status> receiveFile(GoogleApiClient client, final Uri uri, final boolean append) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(uri, (Object) "uri is null");
        return client.zzb(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza((com.google.android.gms.common.api.zzc.zzb<Status>) this, ChannelImpl.this.zzaZM, uri, append);
            }

            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public PendingResult<Status> removeListener(GoogleApiClient client, ChannelListener listener) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(listener, (Object) "listener is null");
        return client.zza(new zzc(client, listener, this.zzaZM));
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri) {
        return sendFile(client, uri, 0, -1);
    }

    public PendingResult<Status> sendFile(GoogleApiClient client, Uri uri, long startOffset, long length) {
        zzx.zzb(client, (Object) "client is null");
        zzx.zzb(this.zzaZM, (Object) "token is null");
        zzx.zzb(uri, (Object) "uri is null");
        zzx.zzb(startOffset >= 0, "startOffset is negative: %s", Long.valueOf(startOffset));
        zzx.zzb(length >= 0 || length == -1, "invalid length: %s", Long.valueOf(length));
        final Uri uri2 = uri;
        final long j = startOffset;
        final long j2 = length;
        return client.zzb(new zzh<Status>(client) {
            /* access modifiers changed from: protected */
            public void zza(zzbn zzbn) throws RemoteException {
                zzbn.zza(this, ChannelImpl.this.zzaZM, uri2, j, j2);
            }

            /* renamed from: zzd */
            public Status zzb(Status status) {
                return status;
            }
        });
    }

    public String toString() {
        return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzaZM + '\'' + ", nodeId='" + this.zzaYR + '\'' + ", path='" + this.mPath + '\'' + "}";
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzn.zza(this, dest, flags);
    }
}
