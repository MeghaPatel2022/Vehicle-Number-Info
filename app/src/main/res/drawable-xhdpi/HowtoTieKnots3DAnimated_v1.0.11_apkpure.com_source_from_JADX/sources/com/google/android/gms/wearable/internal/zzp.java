package com.google.android.gms.wearable.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.OutputStream;

public final class zzp extends OutputStream {
    private volatile zzl zzaZZ;
    private final OutputStream zzbab;

    public zzp(OutputStream outputStream) {
        this.zzbab = (OutputStream) zzx.zzv(outputStream);
    }

    private IOException zza(IOException iOException) {
        zzl zzl = this.zzaZZ;
        if (zzl == null) {
            return iOException;
        }
        if (Log.isLoggable("ChannelOutputStream", 2)) {
            Log.v("ChannelOutputStream", "Caught IOException, but channel has been closed. Translating to ChannelIOException.", iOException);
        }
        return new ChannelIOException("Channel closed unexpectedly before stream was finished", zzl.zzaZP, zzl.zzaZQ);
    }

    public void close() throws IOException {
        try {
            this.zzbab.close();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void flush() throws IOException {
        try {
            this.zzbab.flush();
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(int i) throws IOException {
        try {
            this.zzbab.write(i);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer) throws IOException {
        try {
            this.zzbab.write(buffer);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    public void write(byte[] buffer, int offset, int count) throws IOException {
        try {
            this.zzbab.write(buffer, offset, count);
        } catch (IOException e) {
            throw zza(e);
        }
    }

    /* access modifiers changed from: 0000 */
    public zzt zzCD() {
        return new zzt() {
            public void zzb(zzl zzl) {
                zzp.this.zzc(zzl);
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public void zzc(zzl zzl) {
        this.zzaZZ = zzl;
    }
}
