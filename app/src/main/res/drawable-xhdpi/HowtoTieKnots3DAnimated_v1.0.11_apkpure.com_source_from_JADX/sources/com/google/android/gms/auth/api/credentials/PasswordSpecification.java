package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.support.p000v4.media.TransportMediator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public final class PasswordSpecification implements SafeParcelable {
    public static final zze CREATOR = new zze();
    public static final PasswordSpecification zzRo = new zza().zzh(12, 16).zzbD("abcdefghijkmnopqrstxyzABCDEFGHJKLMNPQRSTXY3456789").zzf("abcdefghijkmnopqrstxyz", 1).zzf("ABCDEFGHJKLMNPQRSTXY", 1).zzf("3456789", 1).zzlx();
    public static final PasswordSpecification zzRp = new zza().zzh(12, 16).zzbD("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890").zzf("abcdefghijklmnopqrstuvwxyz", 1).zzf("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1).zzf("1234567890", 1).zzlx();
    final int mVersionCode;
    final String zzRq;
    final List<String> zzRr;
    final List<Integer> zzRs;
    final int zzRt;
    final int zzRu;
    private final int[] zzRv = zzlw();
    private final Random zzsT = new SecureRandom();

    public static class zza {
        private final List<String> zzRr = new ArrayList();
        private final List<Integer> zzRs = new ArrayList();
        private int zzRt = 12;
        private int zzRu = 16;
        private final TreeSet<Character> zzRw = new TreeSet<>();

        private void zzly() {
            int i;
            int i2 = 0;
            Iterator it = this.zzRs.iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                }
                i2 = ((Integer) it.next()).intValue() + i;
            }
            if (i > this.zzRu) {
                throw new zzb("required character count cannot be greater than the max password size");
            }
        }

        private void zzlz() {
            boolean[] zArr = new boolean[95];
            for (String charArray : this.zzRr) {
                char[] charArray2 = charArray.toCharArray();
                int length = charArray2.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        char c = charArray2[i];
                        if (zArr[c - ' ']) {
                            throw new zzb("character " + c + " occurs in more than one required character set");
                        }
                        zArr[c - ' '] = true;
                        i++;
                    }
                }
            }
        }

        private TreeSet<Character> zzr(String str, String str2) {
            char[] charArray;
            if (TextUtils.isEmpty(str)) {
                throw new zzb(str2 + " cannot be null or empty");
            }
            TreeSet<Character> treeSet = new TreeSet<>();
            for (char c : str.toCharArray()) {
                if (PasswordSpecification.zzb(c, 32, TransportMediator.KEYCODE_MEDIA_PLAY)) {
                    throw new zzb(str2 + " must only contain ASCII printable characters");
                }
                treeSet.add(Character.valueOf(c));
            }
            return treeSet;
        }

        public zza zzbD(String str) {
            this.zzRw.addAll(zzr(str, "allowedChars"));
            return this;
        }

        public zza zzf(String str, int i) {
            if (i < 1) {
                throw new zzb("count must be at least 1");
            }
            this.zzRr.add(PasswordSpecification.zzb(zzr(str, "requiredChars")));
            this.zzRs.add(Integer.valueOf(i));
            return this;
        }

        public zza zzh(int i, int i2) {
            if (i < 1) {
                throw new zzb("minimumSize must be at least 1");
            } else if (i > i2) {
                throw new zzb("maximumSize must be greater than or equal to minimumSize");
            } else {
                this.zzRt = i;
                this.zzRu = i2;
                return this;
            }
        }

        public PasswordSpecification zzlx() {
            if (this.zzRw.isEmpty()) {
                throw new zzb("no allowed characters specified");
            }
            zzly();
            zzlz();
            return new PasswordSpecification(1, PasswordSpecification.zzb(this.zzRw), this.zzRr, this.zzRs, this.zzRt, this.zzRu);
        }
    }

    public static class zzb extends Error {
        public zzb(String str) {
            super(str);
        }
    }

    PasswordSpecification(int version, String allowedChars, List<String> requiredCharSets, List<Integer> requiredCharCounts, int minimumSize, int maximumSize) {
        this.mVersionCode = version;
        this.zzRq = allowedChars;
        this.zzRr = Collections.unmodifiableList(requiredCharSets);
        this.zzRs = Collections.unmodifiableList(requiredCharCounts);
        this.zzRt = minimumSize;
        this.zzRu = maximumSize;
    }

    private int zza(char c) {
        return c - ' ';
    }

    /* access modifiers changed from: private */
    public static String zzb(Collection<Character> collection) {
        char[] cArr = new char[collection.size()];
        int i = 0;
        Iterator it = collection.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return new String(cArr);
            }
            i = i2 + 1;
            cArr[i2] = ((Character) it.next()).charValue();
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzb(int i, int i2, int i3) {
        return i < i2 || i > i3;
    }

    private int[] zzlw() {
        int[] iArr = new int[95];
        Arrays.fill(iArr, -1);
        int i = 0;
        for (String charArray : this.zzRr) {
            for (char zza2 : charArray.toCharArray()) {
                iArr[zza(zza2)] = i;
            }
            i++;
        }
        return iArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        zze.zza(this, out, flags);
    }
}
