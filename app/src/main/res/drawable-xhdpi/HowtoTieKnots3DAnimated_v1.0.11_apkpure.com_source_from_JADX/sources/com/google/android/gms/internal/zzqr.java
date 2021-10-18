package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqp.zzg;
import com.google.android.gms.tagmanager.zzbg;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class zzqr {
    public static final Integer zzaUg = Integer.valueOf(0);
    public static final Integer zzaUh = Integer.valueOf(1);
    private final Context mContext;
    private final ExecutorService zzaRv;

    public zzqr(Context context) {
        this(context, Executors.newSingleThreadExecutor());
    }

    zzqr(Context context, ExecutorService executorService) {
        this.mContext = context;
        this.zzaRv = executorService;
    }

    private String zzfr(String str) {
        return "resource_" + str;
    }

    private byte[] zzm(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            zzlr.zza(inputStream, (OutputStream) byteArrayOutputStream);
            try {
                return byteArrayOutputStream.toByteArray();
            } catch (IOException e) {
                zzbg.zzaE("Error closing stream for reading resource from disk");
                return null;
            }
        } catch (IOException e2) {
            zzbg.zzaE("Failed to read the resource from disk");
            try {
            } catch (IOException e3) {
                zzbg.zzaE("Error closing stream for reading resource from disk");
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e4) {
                zzbg.zzaE("Error closing stream for reading resource from disk");
                return null;
            }
        }
    }

    public void zza(String str, Integer num, zzql zzql, zzqq zzqq) {
        final String str2 = str;
        final Integer num2 = num;
        final zzql zzql2 = zzql;
        final zzqq zzqq2 = zzqq;
        this.zzaRv.execute(new Runnable() {
            public void run() {
                zzqr.this.zzb(str2, num2, zzql2, zzqq2);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void zzb(String str, Integer num, zzql zzql, zzqq zzqq) {
        zzbg.m29v("DiskLoader: Starting to load resource from Disk.");
        try {
            Object zzt = zzql.zzt(zzm(new FileInputStream(zzfq(str))));
            if (zzt != null) {
                zzbg.m29v("Saved resource loaded: " + zzfr(str));
                zzqq.zza(Status.zzaaD, zzt, zzaUh, zzfp(str));
                return;
            }
        } catch (FileNotFoundException e) {
            zzbg.m28e("Saved resource not found: " + zzfr(str));
        } catch (zzg e2) {
            zzbg.m28e("Saved resource is corrupted: " + zzfr(str));
        }
        if (num == null) {
            zzqq.zza(Status.zzaaF, null, null, 0);
            return;
        }
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(num.intValue());
            if (openRawResource != null) {
                Object zzt2 = zzql.zzt(zzm(openRawResource));
                if (zzt2 != null) {
                    zzbg.m29v("Default resource loaded: " + this.mContext.getResources().getResourceEntryName(num.intValue()));
                    zzqq.zza(Status.zzaaD, zzt2, zzaUg, 0);
                    return;
                }
            }
        } catch (NotFoundException e3) {
            zzbg.m28e("Default resource not found. ID: " + num);
        } catch (zzg e4) {
            zzbg.m28e("Default resource resource is corrupted: " + num);
        }
        zzqq.zza(Status.zzaaF, null, null, 0);
    }

    public void zze(final String str, final byte[] bArr) {
        this.zzaRv.execute(new Runnable() {
            public void run() {
                zzqr.this.zzf(str, bArr);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void zzf(String str, byte[] bArr) {
        File zzfq = zzfq(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzfq);
            try {
                fileOutputStream.write(bArr);
                try {
                } catch (IOException e) {
                    zzbg.m28e("Error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzbg.m28e("Error writing resource to disk. Removing resource from disk");
                zzfq.delete();
                try {
                } catch (IOException e3) {
                    zzbg.m28e("Error closing stream for writing resource to disk");
                }
            } finally {
                try {
                    fileOutputStream.close();
                    zzbg.m29v("Resource " + str + " saved on Disk.");
                } catch (IOException e4) {
                    zzbg.m28e("Error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e5) {
            zzbg.m28e("Error opening resource file for writing");
        }
    }

    public long zzfp(String str) {
        File zzfq = zzfq(str);
        if (zzfq.exists()) {
            return zzfq.lastModified();
        }
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public File zzfq(String str) {
        return new File(this.mContext.getDir("google_tagmanager", 0), zzfr(str));
    }
}
