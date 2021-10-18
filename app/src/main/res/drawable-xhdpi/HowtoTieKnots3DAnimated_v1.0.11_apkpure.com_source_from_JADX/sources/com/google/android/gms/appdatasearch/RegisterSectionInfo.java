package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class RegisterSectionInfo implements SafeParcelable {
    public static final zzi CREATOR = new zzi();
    final int mVersionCode;
    public final String name;
    public final int weight;
    public final String zzPA;
    public final boolean zzPB;
    public final boolean zzPC;
    public final String zzPD;
    public final Feature[] zzPE;
    final int[] zzPF;
    public final String zzPG;

    public static final class zza {
        private final String mName;
        private String zzPH;
        private boolean zzPI;
        private int zzPJ = 1;
        private boolean zzPK;
        private String zzPL;
        private final List<Feature> zzPM = new ArrayList();
        private BitSet zzPN;
        private String zzPO;

        public zza(String str) {
            this.mName = str;
        }

        public zza zzM(boolean z) {
            this.zzPI = z;
            return this;
        }

        public zza zzN(boolean z) {
            this.zzPK = z;
            return this;
        }

        public zza zzak(int i) {
            if (this.zzPN == null) {
                this.zzPN = new BitSet();
            }
            this.zzPN.set(i);
            return this;
        }

        public zza zzby(String str) {
            this.zzPH = str;
            return this;
        }

        public zza zzbz(String str) {
            this.zzPO = str;
            return this;
        }

        public RegisterSectionInfo zzld() {
            int i = 0;
            int[] iArr = null;
            if (this.zzPN != null) {
                iArr = new int[this.zzPN.cardinality()];
                int nextSetBit = this.zzPN.nextSetBit(0);
                while (nextSetBit >= 0) {
                    int i2 = i + 1;
                    iArr[i] = nextSetBit;
                    nextSetBit = this.zzPN.nextSetBit(nextSetBit + 1);
                    i = i2;
                }
            }
            return new RegisterSectionInfo(this.mName, this.zzPH, this.zzPI, this.zzPJ, this.zzPK, this.zzPL, (Feature[]) this.zzPM.toArray(new Feature[this.zzPM.size()]), iArr, this.zzPO);
        }
    }

    RegisterSectionInfo(int versionCode, String name2, String format, boolean noIndex, int weight2, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this.mVersionCode = versionCode;
        this.name = name2;
        this.zzPA = format;
        this.zzPB = noIndex;
        this.weight = weight2;
        this.zzPC = indexPrefixes;
        this.zzPD = subsectionSeparator;
        this.zzPE = features;
        this.zzPF = semanticLabels;
        this.zzPG = schemaOrgProperty;
    }

    RegisterSectionInfo(String name2, String format, boolean noIndex, int weight2, boolean indexPrefixes, String subsectionSeparator, Feature[] features, int[] semanticLabels, String schemaOrgProperty) {
        this(2, name2, format, noIndex, weight2, indexPrefixes, subsectionSeparator, features, semanticLabels, schemaOrgProperty);
    }

    public int describeContents() {
        zzi zzi = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzi zzi = CREATOR;
        zzi.zza(this, out, flags);
    }
}
