package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.internal.zzlr;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class SnapshotContentsEntity implements SafeParcelable, SnapshotContents {
    public static final SnapshotContentsEntityCreator CREATOR = new SnapshotContentsEntityCreator();
    private static final Object zzaze = new Object();
    private final int mVersionCode;
    private Contents zzaiD;

    SnapshotContentsEntity(int versionCode, Contents contents) {
        this.mVersionCode = versionCode;
        this.zzaiD = contents;
    }

    public SnapshotContentsEntity(Contents contents) {
        this(1, contents);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean zza(int r9, byte[] r10, int r11, int r12, boolean r13) {
        /*
            r8 = this;
            r1 = 1
            r2 = 0
            boolean r0 = r8.isClosed()
            if (r0 != 0) goto L_0x003c
            r0 = r1
        L_0x0009:
            java.lang.String r3 = "Must provide a previously opened SnapshotContents"
            com.google.android.gms.common.internal.zzx.zza(r0, r3)
            java.lang.Object r3 = zzaze
            monitor-enter(r3)
            com.google.android.gms.drive.Contents r0 = r8.zzaiD     // Catch:{ all -> 0x0049 }
            android.os.ParcelFileDescriptor r0 = r0.getParcelFileDescriptor()     // Catch:{ all -> 0x0049 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x0049 }
            java.io.FileDescriptor r0 = r0.getFileDescriptor()     // Catch:{ all -> 0x0049 }
            r4.<init>(r0)     // Catch:{ all -> 0x0049 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0049 }
            r0.<init>(r4)     // Catch:{ all -> 0x0049 }
            java.nio.channels.FileChannel r4 = r4.getChannel()     // Catch:{ IOException -> 0x003e }
            long r6 = (long) r9     // Catch:{ IOException -> 0x003e }
            r4.position(r6)     // Catch:{ IOException -> 0x003e }
            r0.write(r10, r11, r12)     // Catch:{ IOException -> 0x003e }
            if (r13 == 0) goto L_0x0037
            int r5 = r10.length     // Catch:{ IOException -> 0x003e }
            long r6 = (long) r5     // Catch:{ IOException -> 0x003e }
            r4.truncate(r6)     // Catch:{ IOException -> 0x003e }
        L_0x0037:
            r0.flush()     // Catch:{ IOException -> 0x003e }
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
        L_0x003b:
            return r1
        L_0x003c:
            r0 = r2
            goto L_0x0009
        L_0x003e:
            r0 = move-exception
            java.lang.String r1 = "SnapshotContentsEntity"
            java.lang.String r4 = "Failed to write snapshot data"
            com.google.android.gms.games.internal.GamesLog.zza(r1, r4, r0)     // Catch:{ all -> 0x0049 }
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            r1 = r2
            goto L_0x003b
        L_0x0049:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0049 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.snapshot.SnapshotContentsEntity.zza(int, byte[], int, int, boolean):boolean");
    }

    public void close() {
        this.zzaiD = null;
    }

    public int describeContents() {
        return 0;
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        zzx.zza(!isClosed(), (Object) "Cannot mutate closed contents!");
        return this.zzaiD.getParcelFileDescriptor();
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        return this.zzaiD == null;
    }

    public boolean modifyBytes(int dstOffset, byte[] content, int srcOffset, int count) {
        return zza(dstOffset, content, srcOffset, content.length, false);
    }

    public byte[] readFully() throws IOException {
        byte[] zza;
        boolean z = false;
        if (!isClosed()) {
            z = true;
        }
        zzx.zza(z, (Object) "Must provide a previously opened Snapshot");
        synchronized (zzaze) {
            FileInputStream fileInputStream = new FileInputStream(this.zzaiD.getParcelFileDescriptor().getFileDescriptor());
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            try {
                fileInputStream.getChannel().position(0);
                zza = zzlr.zza((InputStream) bufferedInputStream, false);
                fileInputStream.getChannel().position(0);
            } catch (IOException e) {
                GamesLog.zzb("SnapshotContentsEntity", "Failed to read snapshot data", e);
                throw e;
            }
        }
        return zza;
    }

    public boolean writeBytes(byte[] content) {
        return zza(0, content, 0, content.length, true);
    }

    public void writeToParcel(Parcel out, int flags) {
        SnapshotContentsEntityCreator.zza(this, out, flags);
    }

    public Contents zzqh() {
        return this.zzaiD;
    }
}
