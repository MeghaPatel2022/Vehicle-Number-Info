package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter implements SafeParcelable, zza<String, Integer> {
    public static final zzb CREATOR = new zzb();
    private final int mVersionCode;
    private final HashMap<String, Integer> zzaeL;
    private final HashMap<Integer, String> zzaeM;
    private final ArrayList<Entry> zzaeN;

    public static final class Entry implements SafeParcelable {
        public static final zzc CREATOR = new zzc();
        final int versionCode;
        final String zzaeO;
        final int zzaeP;

        Entry(int versionCode2, String stringValue, int intValue) {
            this.versionCode = versionCode2;
            this.zzaeO = stringValue;
            this.zzaeP = intValue;
        }

        Entry(String stringValue, int intValue) {
            this.versionCode = 1;
            this.zzaeO = stringValue;
            this.zzaeP = intValue;
        }

        public int describeContents() {
            zzc zzc = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel out, int flags) {
            zzc zzc = CREATOR;
            zzc.zza(this, out, flags);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.zzaeL = new HashMap<>();
        this.zzaeM = new HashMap<>();
        this.zzaeN = null;
    }

    StringToIntConverter(int versionCode, ArrayList<Entry> serializedMap) {
        this.mVersionCode = versionCode;
        this.zzaeL = new HashMap<>();
        this.zzaeM = new HashMap<>();
        this.zzaeN = null;
        zzb(serializedMap);
    }

    private void zzb(ArrayList<Entry> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            zzi(entry.zzaeO, entry.zzaeP);
        }
    }

    public int describeContents() {
        zzb zzb = CREATOR;
        return 0;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb zzb = CREATOR;
        zzb.zza(this, out, flags);
    }

    /* renamed from: zzb */
    public String convertBack(Integer num) {
        String str = (String) this.zzaeM.get(num);
        return (str != null || !this.zzaeL.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzi(String str, int i) {
        this.zzaeL.put(str, Integer.valueOf(i));
        this.zzaeM.put(Integer.valueOf(i), str);
        return this;
    }

    /* access modifiers changed from: 0000 */
    public ArrayList<Entry> zzoY() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.zzaeL.keySet()) {
            arrayList.add(new Entry(str, ((Integer) this.zzaeL.get(str)).intValue()));
        }
        return arrayList;
    }

    public int zzoZ() {
        return 7;
    }

    public int zzpa() {
        return 0;
    }
}
