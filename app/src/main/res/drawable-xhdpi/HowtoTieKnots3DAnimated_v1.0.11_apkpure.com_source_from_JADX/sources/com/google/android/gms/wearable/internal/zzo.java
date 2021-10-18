package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzo extends InputStream {
    private final InputStream zzaZY;
    private volatile zzl zzaZZ;

    public zzo(InputStream inputStream) {
        this.zzaZY = (InputStream) zzx.zzv(inputStream);
    }

    private int zzkF(int i) throws ChannelIOException {
        if (i == -1) {
            zzl zzl = this.zzaZZ;
            if (zzl != null) {
                throw new ChannelIOException("Channel closed unexpectedly before stream was finished", zzl.zzaZP, zzl.zzaZQ);
            }
        }
        return i;
    }

    public int available() throws IOException {
        return this.zzaZY.available();
    }

    public void close() throws IOException {
        this.zzaZY.close();
    }

    public void mark(int readlimit) {
        this.zzaZY.mark(readlimit);
    }

    public boolean markSupported() {
        return this.zzaZY.markSupported();
    }

    public int read() throws IOException {
        return zzkF(this.zzaZY.read());
    }

    public int read(byte[] buffer) throws IOException {
        return zzkF(this.zzaZY.read(buffer));
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        return zzkF(this.zzaZY.read(buffer, byteOffset, byteCount));
    }

    public void reset() throws IOException {
        this.zzaZY.reset();
    }

    public long skip(long byteCount) throws IOException {
        return this.zzaZY.skip(byteCount);
    }

    /* access modifiers changed from: 0000 */
    public zzt zzCD() {
        return new zzt() {
            public void zzb(zzl zzl) {
                zzo.this.zza(zzl);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public void zza(zzl zzl) {
        this.zzaZZ = (zzl) zzx.zzv(zzl);
    }
}
