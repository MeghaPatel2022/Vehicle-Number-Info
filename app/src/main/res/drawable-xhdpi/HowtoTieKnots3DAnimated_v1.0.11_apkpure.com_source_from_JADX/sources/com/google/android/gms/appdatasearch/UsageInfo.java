package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznw.zza.C1448zza;
import com.google.android.gms.internal.zzrx;
import com.google.android.gms.plus.PlusShare;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

public class UsageInfo implements SafeParcelable {
    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzPP;
    final long zzPQ;
    int zzPR;
    final DocumentContents zzPS;
    final boolean zzPT;
    int zzPU;
    int zzPV;
    public final String zztM;

    public static final class zza {
        private String zzJZ;
        private DocumentId zzPP;
        private long zzPQ = -1;
        private int zzPR = -1;
        private DocumentContents zzPS;
        private boolean zzPT = false;
        private int zzPU = -1;
        private int zzPV = 0;

        public zza zzO(boolean z) {
            this.zzPT = z;
            return this;
        }

        public zza zza(DocumentContents documentContents) {
            this.zzPS = documentContents;
            return this;
        }

        public zza zza(DocumentId documentId) {
            this.zzPP = documentId;
            return this;
        }

        public zza zzam(int i) {
            this.zzPR = i;
            return this;
        }

        public zza zzan(int i) {
            this.zzPV = i;
            return this;
        }

        public UsageInfo zzlf() {
            return new UsageInfo(this.zzPP, this.zzPQ, this.zzPR, this.zzJZ, this.zzPS, this.zzPT, this.zzPU, this.zzPV);
        }

        public zza zzw(long j) {
            this.zzPQ = j;
            return this;
        }
    }

    UsageInfo(int versionCode, DocumentId documentId, long timestamp, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this.mVersionCode = versionCode;
        this.zzPP = documentId;
        this.zzPQ = timestamp;
        this.zzPR = usageType;
        this.zztM = query;
        this.zzPS = document;
        this.zzPT = isDeviceOnly;
        this.zzPU = taskPosition;
        this.zzPV = eventStatus;
    }

    private UsageInfo(DocumentId documentId, long timestampMs, int usageType, String query, DocumentContents document, boolean isDeviceOnly, int taskPosition, int eventStatus) {
        this(1, documentId, timestampMs, usageType, query, document, isDeviceOnly, taskPosition, eventStatus);
    }

    public UsageInfo(String packageName, Intent viewIntent, String title, Uri webUrl, String schemaOrgType, List<AppIndexingLink> outLinks, int eventStatus) {
        this(1, zza(packageName, viewIntent), System.currentTimeMillis(), 0, (String) null, zza(viewIntent, title, webUrl, schemaOrgType, outLinks).zzkY(), false, -1, eventStatus);
    }

    public static com.google.android.gms.appdatasearch.DocumentContents.zza zza(Intent intent, String str, Uri uri, String str2, List<AppIndexingLink> list) {
        com.google.android.gms.appdatasearch.DocumentContents.zza zza2 = new com.google.android.gms.appdatasearch.DocumentContents.zza();
        zza2.zza(zzbA(str));
        if (uri != null) {
            zza2.zza(zzi(uri));
        }
        if (list != null) {
            zza2.zza(zzh(list));
        }
        String action = intent.getAction();
        if (action != null) {
            zza2.zza(zzq("intent_action", action));
        }
        String dataString = intent.getDataString();
        if (dataString != null) {
            zza2.zza(zzq("intent_data", dataString));
        }
        ComponentName component = intent.getComponent();
        if (component != null) {
            zza2.zza(zzq("intent_activity", component.getClassName()));
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String string = extras.getString("intent_extra_data_key");
            if (string != null) {
                zza2.zza(zzq("intent_extra_data", string));
            }
        }
        return zza2.zzbv(str2).zzK(true);
    }

    public static DocumentId zza(String str, Intent intent) {
        return zzp(str, zzg(intent));
    }

    private static DocumentSection zzbA(String str) {
        return new DocumentSection(str, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE).zzak(1).zzN(true).zzbz("name").zzld(), "text1");
    }

    private static String zzg(Intent intent) {
        String uri = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try {
            crc32.update(uri.getBytes("UTF-8"));
            return Long.toHexString(crc32.getValue());
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    private static DocumentSection zzh(List<AppIndexingLink> list) {
        com.google.android.gms.internal.zznw.zza zza2 = new com.google.android.gms.internal.zznw.zza();
        C1448zza[] zzaArr = new C1448zza[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < zzaArr.length) {
                zzaArr[i2] = new C1448zza();
                AppIndexingLink appIndexingLink = (AppIndexingLink) list.get(i2);
                zzaArr[i2].zzaAo = appIndexingLink.appIndexingUrl.toString();
                zzaArr[i2].viewId = appIndexingLink.viewId;
                if (appIndexingLink.webUrl != null) {
                    zzaArr[i2].zzaAp = appIndexingLink.webUrl.toString();
                }
                i = i2 + 1;
            } else {
                zza2.zzaAm = zzaArr;
                return new DocumentSection(zzrx.zzf(zza2), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("outlinks").zzM(true).zzbz(".private:outLinks").zzby("blob").zzld());
            }
        }
    }

    private static DocumentSection zzi(Uri uri) {
        return new DocumentSection(uri.toString(), new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza("web_url").zzak(4).zzM(true).zzbz(PlusShare.KEY_CALL_TO_ACTION_URL).zzld());
    }

    private static DocumentId zzp(String str, String str2) {
        return new DocumentId(str, "", str2);
    }

    private static DocumentSection zzq(String str, String str2) {
        return new DocumentSection(str2, new com.google.android.gms.appdatasearch.RegisterSectionInfo.zza(str).zzM(true).zzld(), str);
    }

    public int describeContents() {
        zzj zzj = CREATOR;
        return 0;
    }

    public String toString() {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[]{this.zzPP, Long.valueOf(this.zzPQ), Integer.valueOf(this.zzPR), Integer.valueOf(this.zzPV)});
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzj zzj = CREATOR;
        zzj.zza(this, dest, flags);
    }

    public DocumentContents zzle() {
        return this.zzPS;
    }
}
