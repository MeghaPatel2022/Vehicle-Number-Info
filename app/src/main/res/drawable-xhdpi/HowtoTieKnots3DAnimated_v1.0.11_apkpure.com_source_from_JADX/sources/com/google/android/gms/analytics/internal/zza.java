package com.google.android.gms.analytics.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

public class zza extends zzd {
    public static boolean zzLk;
    private Info zzLl;
    private final zzaj zzLm;
    private String zzLn;
    private boolean zzLo = false;
    private Object zzLp = new Object();

    zza(zzf zzf) {
        super(zzf);
        this.zzLm = new zzaj(zzf.zzid());
    }

    private boolean zza(Info info, Info info2) {
        String str;
        String str2 = null;
        String id = info2 == null ? null : info2.getId();
        if (TextUtils.isEmpty(id)) {
            return true;
        }
        String zzjd = zzij().zzjd();
        synchronized (this.zzLp) {
            if (!this.zzLo) {
                this.zzLn = zzhT();
                this.zzLo = true;
            } else if (TextUtils.isEmpty(this.zzLn)) {
                if (info != null) {
                    str2 = info.getId();
                }
                if (str2 == null) {
                    boolean zzaX = zzaX(id + zzjd);
                    return zzaX;
                }
                this.zzLn = zzaW(str2 + zzjd);
            }
            String zzaW = zzaW(id + zzjd);
            if (TextUtils.isEmpty(zzaW)) {
                return false;
            }
            if (zzaW.equals(this.zzLn)) {
                return true;
            }
            if (!TextUtils.isEmpty(this.zzLn)) {
                zzaY("Resetting the client id because Advertising Id changed.");
                str = zzij().zzje();
                zza("New client Id", str);
            } else {
                str = zzjd;
            }
            boolean zzaX2 = zzaX(id + str);
            return zzaX2;
        }
    }

    private static String zzaW(String str) {
        MessageDigest zzbq = zzam.zzbq("MD5");
        if (zzbq == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzbq.digest(str.getBytes()))});
    }

    private boolean zzaX(String str) {
        try {
            String zzaW = zzaW(str);
            zzaY("Storing hashed adid.");
            FileOutputStream openFileOutput = getContext().openFileOutput("gaClientIdData", 0);
            openFileOutput.write(zzaW.getBytes());
            openFileOutput.close();
            this.zzLn = zzaW;
            return true;
        } catch (IOException e) {
            zze("Error creating hash file", e);
            return false;
        }
    }

    private synchronized Info zzhR() {
        if (this.zzLm.zzv(1000)) {
            this.zzLm.start();
            Info zzhS = zzhS();
            if (zza(this.zzLl, zzhS)) {
                this.zzLl = zzhS;
            } else {
                zzbc("Failed to reset client id on adid change. Not using adid");
                this.zzLl = new Info("", false);
            }
        }
        return this.zzLl;
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
    }

    public boolean zzhM() {
        zzio();
        Info zzhR = zzhR();
        return zzhR != null && !zzhR.isLimitAdTrackingEnabled();
    }

    public String zzhQ() {
        zzio();
        Info zzhR = zzhR();
        String str = zzhR != null ? zzhR.getId() : null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public Info zzhS() {
        boolean z = false;
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(getContext());
        } catch (IllegalStateException e) {
            zzbb("IllegalStateException getting Ad Id Info. If you would like to see Audience reports, please ensure that you have added '<meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />' to your application manifest file. See http://goo.gl/naFqQk for details.");
            return z;
        } catch (Throwable th) {
            if (zzLk) {
                return z;
            }
            zzLk = true;
            zzd("Error getting advertiser id", th);
            return z;
        }
    }

    /* access modifiers changed from: protected */
    public String zzhT() {
        String str = null;
        try {
            FileInputStream openFileInput = getContext().openFileInput("gaClientIdData");
            byte[] bArr = new byte[128];
            int read = openFileInput.read(bArr, 0, 128);
            if (openFileInput.available() > 0) {
                zzbb("Hash file seems corrupted, deleting it.");
                openFileInput.close();
                getContext().deleteFile("gaClientIdData");
                return null;
            } else if (read <= 0) {
                zzaY("Hash file is empty.");
                openFileInput.close();
                return null;
            } else {
                String str2 = new String(bArr, 0, read);
                try {
                    openFileInput.close();
                    return str2;
                } catch (FileNotFoundException e) {
                    return str2;
                } catch (IOException e2) {
                    Object obj = e2;
                    str = str2;
                    e = obj;
                    zzd("Error reading Hash file, deleting it", e);
                    getContext().deleteFile("gaClientIdData");
                    return str;
                }
            }
        } catch (FileNotFoundException e3) {
            return null;
        } catch (IOException e4) {
            e = e4;
            zzd("Error reading Hash file, deleting it", e);
            getContext().deleteFile("gaClientIdData");
            return str;
        }
    }
}
