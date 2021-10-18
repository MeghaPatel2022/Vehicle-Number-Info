package com.google.android.gms.tagmanager;

class zzde extends Number implements Comparable<zzde> {
    private double zzaSK;
    private long zzaSL;
    private boolean zzaSM = false;

    private zzde(double d) {
        this.zzaSK = d;
    }

    private zzde(long j) {
        this.zzaSL = j;
    }

    public static zzde zzT(long j) {
        return new zzde(j);
    }

    public static zzde zza(Double d) {
        return new zzde(d.doubleValue());
    }

    public static zzde zzeX(String str) throws NumberFormatException {
        try {
            return new zzde(Long.parseLong(str));
        } catch (NumberFormatException e) {
            try {
                return new zzde(Double.parseDouble(str));
            } catch (NumberFormatException e2) {
                throw new NumberFormatException(str + " is not a valid TypedNumber");
            }
        }
    }

    public byte byteValue() {
        return (byte) ((int) longValue());
    }

    public double doubleValue() {
        return zzAW() ? (double) this.zzaSL : this.zzaSK;
    }

    public boolean equals(Object other) {
        return (other instanceof zzde) && compareTo((zzde) other) == 0;
    }

    public float floatValue() {
        return (float) doubleValue();
    }

    public int hashCode() {
        return new Long(longValue()).hashCode();
    }

    public int intValue() {
        return zzAY();
    }

    public long longValue() {
        return zzAX();
    }

    public short shortValue() {
        return zzAZ();
    }

    public String toString() {
        return zzAW() ? Long.toString(this.zzaSL) : Double.toString(this.zzaSK);
    }

    public boolean zzAV() {
        return !zzAW();
    }

    public boolean zzAW() {
        return this.zzaSM;
    }

    public long zzAX() {
        return zzAW() ? this.zzaSL : (long) this.zzaSK;
    }

    public int zzAY() {
        return (int) longValue();
    }

    public short zzAZ() {
        return (short) ((int) longValue());
    }

    /* renamed from: zza */
    public int compareTo(zzde zzde) {
        return (!zzAW() || !zzde.zzAW()) ? Double.compare(doubleValue(), zzde.doubleValue()) : new Long(this.zzaSL).compareTo(Long.valueOf(zzde.zzaSL));
    }
}
