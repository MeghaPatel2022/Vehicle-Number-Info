package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzi;
import com.google.android.gms.drive.metadata.internal.zzj;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzo;
import com.google.android.gms.drive.metadata.internal.zzp;
import com.google.android.gms.plus.PlusShare;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzmb {
    public static final MetadataField<Boolean> zzakA = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
    public static final MetadataField<Boolean> zzakB = new com.google.android.gms.drive.metadata.internal.zzb("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000) {
        /* access modifiers changed from: protected */
        /* renamed from: zze */
        public Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc("trashed", i, i2) == 2);
        }
    };
    public static final MetadataField<Boolean> zzakC = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
    public static final zzb zzakD = new zzb("isPinned", 4100000);
    public static final MetadataField<Boolean> zzakE = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
    public static final MetadataField<Boolean> zzakF = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
    public static final MetadataField<Boolean> zzakG = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
    public static final MetadataField<Boolean> zzakH = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField<Boolean> zzakI = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField<Boolean> zzakJ = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
    public static final MetadataField<Boolean> zzakK = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
    public static final zzc zzakL = new zzc(4100000);
    public static final MetadataField<String> zzakM = new zzo("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzakN = new zzn("ownerNames", 4300000);
    public static final zzp zzakO = new zzp("lastModifyingUser", 6000000);
    public static final zzp zzakP = new zzp("sharingUser", 6000000);
    public static final zzl zzakQ = new zzl(4100000);
    public static final zzd zzakR = new zzd("quotaBytesUsed", 4300000);
    public static final zzf zzakS = new zzf("starred", 4100000);
    public static final MetadataField<BitmapTeleporter> zzakT = new zzj<BitmapTeleporter>("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000) {
        /* access modifiers changed from: protected */
        /* renamed from: zzk */
        public BitmapTeleporter zzc(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    };
    public static final zzg zzakU = new zzg(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_TITLE, 4100000);
    public static final zzh zzakV = new zzh("trashed", 4100000);
    public static final MetadataField<String> zzakW = new zzo("webContentLink", 4300000);
    public static final MetadataField<String> zzakX = new zzo("webViewLink", 4300000);
    public static final MetadataField<String> zzakY = new zzo("uniqueIdentifier", 5000000);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzakZ = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
    public static final MetadataField<DriveId> zzako = zzme.zzali;
    public static final MetadataField<String> zzakp = new zzo("alternateLink", 4300000);
    public static final zza zzakq = new zza(5000000);
    public static final MetadataField<String> zzakr = new zzo(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 4300000);
    public static final MetadataField<String> zzaks = new zzo("embedLink", 4300000);
    public static final MetadataField<String> zzakt = new zzo("fileExtension", 4300000);
    public static final MetadataField<Long> zzaku = new com.google.android.gms.drive.metadata.internal.zzg("fileSize", 4300000);
    public static final MetadataField<String> zzakv = new zzo("folderColorRgb", 7500000);
    public static final MetadataField<Boolean> zzakw = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
    public static final MetadataField<String> zzakx = new zzo("indexableText", 4300000);
    public static final MetadataField<Boolean> zzaky = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
    public static final MetadataField<Boolean> zzakz = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
    public static final MetadataField<String> zzala = new zzo("role", 6000000);
    public static final MetadataField<String> zzalb = new zzo("md5Checksum", 7000000);
    public static final zze zzalc = new zze(7000000);

    public static class zza extends zzmc implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends zzo implements SearchableMetadataField<String> {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzg implements SortableMetadataField<Long> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends zzi<DriveSpace> {
        public zze(int i) {
            super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Collection<DriveSpace> zzc(DataHolder dataHolder, int i, int i2) {
            ArrayList arrayList = new ArrayList();
            if (dataHolder.zze("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzagH);
            }
            if (dataHolder.zze("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzagI);
            }
            if (dataHolder.zze("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzagJ);
            }
            return arrayList;
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    public static class zzg extends zzo implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzh(String str, int i) {
            super(str, i);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zze */
        public Boolean zzc(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc(getName(), i, i2) != 0);
        }
    }
}
