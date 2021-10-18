package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import com.google.android.gms.internal.zzaf.zzf;
import com.google.android.gms.internal.zzqh.zza;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqp.zzc;
import com.google.android.gms.internal.zzqp.zzg;
import com.google.android.gms.internal.zzrw;
import com.google.android.gms.internal.zzrx;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;

class zzcn implements zzf {
    private final Context mContext;
    private final String zzaOS;
    private zzbf<zza> zzaRo;
    private final ExecutorService zzaRv = Executors.newSingleThreadExecutor();

    zzcn(Context context, String str) {
        this.mContext = context;
        this.zzaOS = str;
    }

    private zzc zza(ByteArrayOutputStream byteArrayOutputStream) {
        boolean z = false;
        try {
            return zzaz.zzeN(byteArrayOutputStream.toString("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            zzbg.zzaC("Failed to convert binary resource to string for JSON parsing; the file format is not UTF-8 format.");
            return z;
        } catch (JSONException e2) {
            zzbg.zzaE("Failed to extract the container from the resource file. Resource is a UTF-8 encoded string but doesn't contain a JSON container");
            return z;
        }
    }

    private void zzd(zza zza) throws IllegalArgumentException {
        if (zza.zziR == null && zza.zzaTu == null) {
            throw new IllegalArgumentException("Resource and SupplementedResource are NULL.");
        }
    }

    private zzc zzr(byte[] bArr) {
        try {
            zzc zzb = zzqp.zzb(zzf.zzc(bArr));
            if (zzb == null) {
                return zzb;
            }
            zzbg.m29v("The container was successfully loaded from the resource (using binary file)");
            return zzb;
        } catch (zzrw e) {
            zzbg.m28e("The resource file is corrupted. The container cannot be extracted from the binary file");
            return null;
        } catch (zzg e2) {
            zzbg.zzaE("The resource file is invalid. The container from the binary file is invalid");
            return null;
        }
    }

    public synchronized void release() {
        this.zzaRv.shutdown();
    }

    /* access modifiers changed from: 0000 */
    public void zzAD() {
        if (this.zzaRo == null) {
            throw new IllegalStateException("Callback must be set before execute");
        }
        this.zzaRo.zzzL();
        zzbg.m29v("Attempting to load resource from disk");
        if ((zzcb.zzAv().zzAw() == zza.CONTAINER || zzcb.zzAv().zzAw() == zza.CONTAINER_DEBUG) && this.zzaOS.equals(zzcb.zzAv().getContainerId())) {
            this.zzaRo.zza(zzbf.zza.NOT_AVAILABLE);
            return;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(zzAE());
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqp.zzc(fileInputStream, byteArrayOutputStream);
                zza zzs = zza.zzs(byteArrayOutputStream.toByteArray());
                zzd(zzs);
                this.zzaRo.zzB(zzs);
                try {
                } catch (IOException e) {
                    zzbg.zzaE("Error closing stream for reading resource from disk");
                }
            } catch (IOException e2) {
                this.zzaRo.zza(zzbf.zza.IO_ERROR);
                zzbg.zzaE("Failed to read the resource from disk");
                try {
                } catch (IOException e3) {
                    zzbg.zzaE("Error closing stream for reading resource from disk");
                }
            } catch (IllegalArgumentException e4) {
                this.zzaRo.zza(zzbf.zza.IO_ERROR);
                zzbg.zzaE("Failed to read the resource from disk. The resource is inconsistent");
                try {
                } catch (IOException e5) {
                    zzbg.zzaE("Error closing stream for reading resource from disk");
                }
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                    zzbg.zzaE("Error closing stream for reading resource from disk");
                }
            }
            zzbg.m29v("The Disk resource was successfully read.");
        } catch (FileNotFoundException e7) {
            zzbg.zzaC("Failed to find the resource in the disk");
            this.zzaRo.zza(zzbf.zza.NOT_AVAILABLE);
        }
    }

    /* access modifiers changed from: 0000 */
    public File zzAE() {
        return new File(this.mContext.getDir("google_tagmanager", 0), "resource_" + this.zzaOS);
    }

    public void zza(zzbf<zza> zzbf) {
        this.zzaRo = zzbf;
    }

    public void zzb(final zza zza) {
        this.zzaRv.execute(new Runnable() {
            public void run() {
                zzcn.this.zzc(zza);
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public boolean zzc(zza zza) {
        boolean z = false;
        File zzAE = zzAE();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzAE);
            try {
                fileOutputStream.write(zzrx.zzf(zza));
                z = true;
                try {
                } catch (IOException e) {
                    zzbg.zzaE("error closing stream for writing resource to disk");
                }
            } catch (IOException e2) {
                zzbg.zzaE("Error writing resource to disk. Removing resource from disk.");
                zzAE.delete();
                try {
                } catch (IOException e3) {
                    zzbg.zzaE("error closing stream for writing resource to disk");
                }
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e4) {
                    zzbg.zzaE("error closing stream for writing resource to disk");
                }
            }
        } catch (FileNotFoundException e5) {
            zzbg.m28e("Error opening resource file for writing");
        }
        return z;
    }

    public zzc zzjc(int i) {
        try {
            InputStream openRawResource = this.mContext.getResources().openRawResource(i);
            zzbg.m29v("Attempting to load a container from the resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                zzqp.zzc(openRawResource, byteArrayOutputStream);
                zzc zza = zza(byteArrayOutputStream);
                if (zza == null) {
                    return zzr(byteArrayOutputStream.toByteArray());
                }
                zzbg.m29v("The container was successfully loaded from the resource (using JSON file format)");
                return zza;
            } catch (IOException e) {
                zzbg.zzaE("Error reading the default container with resource ID " + i + " (" + this.mContext.getResources().getResourceName(i) + ")");
                return null;
            }
        } catch (NotFoundException e2) {
            zzbg.zzaE("Failed to load the container. No default container resource found with the resource ID " + i);
            return null;
        }
    }

    public void zzzM() {
        this.zzaRv.execute(new Runnable() {
            public void run() {
                zzcn.this.zzAD();
            }
        });
    }
}
