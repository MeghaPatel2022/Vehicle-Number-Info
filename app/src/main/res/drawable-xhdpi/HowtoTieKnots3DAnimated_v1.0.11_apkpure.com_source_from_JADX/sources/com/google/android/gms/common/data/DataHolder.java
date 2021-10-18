package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataHolder implements SafeParcelable {
    public static final zze CREATOR = new zze();
    private static final zza zzabs = new zza(new String[0], null) {
    };
    boolean mClosed;
    private final int mVersionCode;
    private final int zzWu;
    private final String[] zzabk;
    Bundle zzabl;
    private final CursorWindow[] zzabm;
    private final Bundle zzabn;
    int[] zzabo;
    int zzabp;
    private Object zzabq;
    private boolean zzabr;

    public static class zza {
        /* access modifiers changed from: private */
        public final String[] zzabk;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zzabt;
        private final String zzabu;
        private final HashMap<Object, Integer> zzabv;
        private boolean zzabw;
        private String zzabx;

        private zza(String[] strArr, String str) {
            this.zzabk = (String[]) zzx.zzv(strArr);
            this.zzabt = new ArrayList<>();
            this.zzabu = str;
            this.zzabv = new HashMap<>();
            this.zzabw = false;
            this.zzabx = null;
        }
    }

    public static class zzb extends RuntimeException {
        public zzb(String str) {
            super(str);
        }
    }

    DataHolder(int versionCode, String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzabr = true;
        this.mVersionCode = versionCode;
        this.zzabk = columns;
        this.zzabm = windows;
        this.zzWu = statusCode;
        this.zzabn = metadata;
    }

    private DataHolder(zza builder, int statusCode, Bundle metadata) {
        this(builder.zzabk, zza(builder, -1), statusCode, metadata);
    }

    public DataHolder(String[] columns, CursorWindow[] windows, int statusCode, Bundle metadata) {
        this.mClosed = false;
        this.zzabr = true;
        this.mVersionCode = 1;
        this.zzabk = (String[]) zzx.zzv(columns);
        this.zzabm = (CursorWindow[]) zzx.zzv(windows);
        this.zzWu = statusCode;
        this.zzabn = metadata;
        zznT();
    }

    public static DataHolder zza(int i, Bundle bundle) {
        return new DataHolder(zzabs, i, bundle);
    }

    private static CursorWindow[] zza(zza zza2, int i) {
        int i2;
        boolean z;
        CursorWindow cursorWindow;
        if (zza2.zzabk.length == 0) {
            return new CursorWindow[0];
        }
        List zzb2 = (i < 0 || i >= zza2.zzabt.size()) ? zza2.zzabt : zza2.zzabt.subList(0, i);
        int size = zzb2.size();
        CursorWindow cursorWindow2 = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow2);
        cursorWindow2.setNumColumns(zza2.zzabk.length);
        int i3 = 0;
        boolean z2 = false;
        while (i3 < size) {
            try {
                if (!cursorWindow2.allocRow()) {
                    Log.d("DataHolder", "Allocating additional cursor window for large data set (row " + i3 + ")");
                    cursorWindow2 = new CursorWindow(false);
                    cursorWindow2.setStartPosition(i3);
                    cursorWindow2.setNumColumns(zza2.zzabk.length);
                    arrayList.add(cursorWindow2);
                    if (!cursorWindow2.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow2);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zzb2.get(i3);
                boolean z3 = true;
                for (int i4 = 0; i4 < zza2.zzabk.length && z3; i4++) {
                    String str = zza2.zzabk[i4];
                    Object obj = map.get(str);
                    if (obj == null) {
                        z3 = cursorWindow2.putNull(i3, i4);
                    } else if (obj instanceof String) {
                        z3 = cursorWindow2.putString((String) obj, i3, i4);
                    } else if (obj instanceof Long) {
                        z3 = cursorWindow2.putLong(((Long) obj).longValue(), i3, i4);
                    } else if (obj instanceof Integer) {
                        z3 = cursorWindow2.putLong((long) ((Integer) obj).intValue(), i3, i4);
                    } else if (obj instanceof Boolean) {
                        z3 = cursorWindow2.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i3, i4);
                    } else if (obj instanceof byte[]) {
                        z3 = cursorWindow2.putBlob((byte[]) obj, i3, i4);
                    } else if (obj instanceof Double) {
                        z3 = cursorWindow2.putDouble(((Double) obj).doubleValue(), i3, i4);
                    } else if (obj instanceof Float) {
                        z3 = cursorWindow2.putDouble((double) ((Float) obj).floatValue(), i3, i4);
                    } else {
                        throw new IllegalArgumentException("Unsupported object for column " + str + ": " + obj);
                    }
                }
                if (z3) {
                    i2 = i3;
                    z = false;
                    cursorWindow = cursorWindow2;
                } else if (z2) {
                    throw new zzb("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                } else {
                    Log.d("DataHolder", "Couldn't populate window data for row " + i3 + " - allocating new window.");
                    cursorWindow2.freeLastRow();
                    CursorWindow cursorWindow3 = new CursorWindow(false);
                    cursorWindow3.setStartPosition(i3);
                    cursorWindow3.setNumColumns(zza2.zzabk.length);
                    arrayList.add(cursorWindow3);
                    i2 = i3 - 1;
                    cursorWindow = cursorWindow3;
                    z = true;
                }
                z2 = z;
                cursorWindow2 = cursorWindow;
                i3 = i2 + 1;
            } catch (RuntimeException e) {
                RuntimeException runtimeException = e;
                int size2 = arrayList.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    ((CursorWindow) arrayList.get(i5)).close();
                }
                throw runtimeException;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    public static DataHolder zzbp(int i) {
        return zza(i, (Bundle) null);
    }

    private void zzh(String str, int i) {
        if (this.zzabl == null || !this.zzabl.containsKey(str)) {
            throw new IllegalArgumentException("No such column: " + str);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i < 0 || i >= this.zzabp) {
            throw new CursorIndexOutOfBoundsException(i, this.zzabp);
        }
    }

    public void close() {
        synchronized (this) {
            if (!this.mClosed) {
                this.mClosed = true;
                for (CursorWindow close : this.zzabm) {
                    close.close();
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            if (this.zzabr && this.zzabm.length > 0 && !isClosed()) {
                Log.e("DataBuffer", "Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (" + (this.zzabq == null ? "internal object: " + toString() : this.zzabq.toString()) + ")");
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public int getCount() {
        return this.zzabp;
    }

    public int getStatusCode() {
        return this.zzWu;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.mClosed;
        }
        return z;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zze.zza(this, dest, flags);
    }

    public void zza(String str, int i, int i2, CharArrayBuffer charArrayBuffer) {
        zzh(str, i);
        this.zzabm[i2].copyStringToBuffer(i, this.zzabl.getInt(str), charArrayBuffer);
    }

    public long zzb(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getLong(i, this.zzabl.getInt(str));
    }

    public int zzbo(int i) {
        int i2 = 0;
        zzx.zzY(i >= 0 && i < this.zzabp);
        while (true) {
            if (i2 >= this.zzabo.length) {
                break;
            } else if (i < this.zzabo[i2]) {
                i2--;
                break;
            } else {
                i2++;
            }
        }
        return i2 == this.zzabo.length ? i2 - 1 : i2;
    }

    public int zzc(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getInt(i, this.zzabl.getInt(str));
    }

    public boolean zzcd(String str) {
        return this.zzabl.containsKey(str);
    }

    public String zzd(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getString(i, this.zzabl.getInt(str));
    }

    public boolean zze(String str, int i, int i2) {
        zzh(str, i);
        return Long.valueOf(this.zzabm[i2].getLong(i, this.zzabl.getInt(str))).longValue() == 1;
    }

    public float zzf(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getFloat(i, this.zzabl.getInt(str));
    }

    public byte[] zzg(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].getBlob(i, this.zzabl.getInt(str));
    }

    public Uri zzh(String str, int i, int i2) {
        String zzd = zzd(str, i, i2);
        if (zzd == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public boolean zzi(String str, int i, int i2) {
        zzh(str, i);
        return this.zzabm[i2].isNull(i, this.zzabl.getInt(str));
    }

    public Bundle zznP() {
        return this.zzabn;
    }

    public void zznT() {
        this.zzabl = new Bundle();
        for (int i = 0; i < this.zzabk.length; i++) {
            this.zzabl.putInt(this.zzabk[i], i);
        }
        this.zzabo = new int[this.zzabm.length];
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzabm.length; i3++) {
            this.zzabo[i3] = i2;
            i2 += this.zzabm[i3].getNumRows() - (i2 - this.zzabm[i3].getStartPosition());
        }
        this.zzabp = i2;
    }

    /* access modifiers changed from: 0000 */
    public String[] zznU() {
        return this.zzabk;
    }

    /* access modifiers changed from: 0000 */
    public CursorWindow[] zznV() {
        return this.zzabm;
    }

    public void zzq(Object obj) {
        this.zzabq = obj;
    }
}
