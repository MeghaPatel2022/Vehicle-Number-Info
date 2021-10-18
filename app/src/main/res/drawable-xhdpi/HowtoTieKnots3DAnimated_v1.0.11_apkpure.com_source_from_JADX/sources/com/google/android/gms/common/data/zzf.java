package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {
    private boolean zzaby = false;
    private ArrayList<Integer> zzabz;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zznX() {
        synchronized (this) {
            if (!this.zzaby) {
                int count = this.zzYX.getCount();
                this.zzabz = new ArrayList<>();
                if (count > 0) {
                    this.zzabz.add(Integer.valueOf(0));
                    String zznW = zznW();
                    String zzd = this.zzYX.zzd(zznW, 0, this.zzYX.zzbo(0));
                    int i = 1;
                    while (i < count) {
                        int zzbo = this.zzYX.zzbo(i);
                        String zzd2 = this.zzYX.zzd(zznW, i, zzbo);
                        if (zzd2 == null) {
                            throw new NullPointerException("Missing value for markerColumn: " + zznW + ", at row: " + i + ", for window: " + zzbo);
                        }
                        if (!zzd2.equals(zzd)) {
                            this.zzabz.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.zzaby = true;
            }
        }
    }

    public final T get(int position) {
        zznX();
        return zzk(zzbr(position), zzbs(position));
    }

    public int getCount() {
        zznX();
        return this.zzabz.size();
    }

    /* access modifiers changed from: 0000 */
    public int zzbr(int i) {
        if (i >= 0 && i < this.zzabz.size()) {
            return ((Integer) this.zzabz.get(i)).intValue();
        }
        throw new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
    }

    /* access modifiers changed from: protected */
    public int zzbs(int i) {
        if (i < 0 || i == this.zzabz.size()) {
            return 0;
        }
        int intValue = i == this.zzabz.size() + -1 ? this.zzYX.getCount() - ((Integer) this.zzabz.get(i)).intValue() : ((Integer) this.zzabz.get(i + 1)).intValue() - ((Integer) this.zzabz.get(i)).intValue();
        if (intValue != 1) {
            return intValue;
        }
        int zzbr = zzbr(i);
        int zzbo = this.zzYX.zzbo(zzbr);
        String zznY = zznY();
        if (zznY == null || this.zzYX.zzd(zznY, zzbr, zzbo) != null) {
            return intValue;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T zzk(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zznW();

    /* access modifiers changed from: protected */
    public String zznY() {
        return null;
    }
}
