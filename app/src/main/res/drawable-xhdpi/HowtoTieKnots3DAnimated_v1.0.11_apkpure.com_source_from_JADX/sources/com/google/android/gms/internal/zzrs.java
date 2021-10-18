package com.google.android.gms.internal;

import com.google.android.gms.internal.zzrr;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzrs<M extends zzrr<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzbcb;
    protected final boolean zzbcc;

    private zzrs(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzbcb = cls;
        this.tag = i2;
        this.zzbcc = z;
    }

    @Deprecated
    public static <M extends zzrr<M>, T extends zzrx> zzrs<M, T> zza(int i, Class<T> cls, int i2) {
        return new zzrs<>(i, cls, i2, false);
    }

    private T zzy(List<zzrz> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzrz zzrz = (zzrz) list.get(i);
            if (zzrz.zzbcm.length != 0) {
                zza(zzrz, (List<Object>) arrayList);
            }
        }
        int size = arrayList.size();
        if (size == 0) {
            return null;
        }
        T cast = this.zzbcb.cast(Array.newInstance(this.zzbcb.getComponentType(), size));
        for (int i2 = 0; i2 < size; i2++) {
            Array.set(cast, i2, arrayList.get(i2));
        }
        return cast;
    }

    private T zzz(List<zzrz> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzbcb.cast(zzA(zzrp.zzz(((zzrz) list.get(list.size() - 1)).zzbcm)));
    }

    /* access modifiers changed from: protected */
    public Object zzA(zzrp zzrp) {
        Class<T> cls = this.zzbcc ? this.zzbcb.getComponentType() : this.zzbcb;
        try {
            switch (this.type) {
                case 10:
                    zzrx zzrx = (zzrx) cls.newInstance();
                    zzrp.zza(zzrx, zzsa.zzlE(this.tag));
                    return zzrx;
                case 11:
                    zzrx zzrx2 = (zzrx) cls.newInstance();
                    zzrp.zza(zzrx2);
                    return zzrx2;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("Error creating instance of class " + cls, e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException("Error creating instance of class " + cls, e2);
        } catch (IOException e3) {
            throw new IllegalArgumentException("Error reading extension field", e3);
        }
    }

    /* access modifiers changed from: 0000 */
    public int zzS(Object obj) {
        return this.zzbcc ? zzT(obj) : zzU(obj);
    }

    /* access modifiers changed from: protected */
    public int zzT(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzU(Array.get(obj, i2));
            }
        }
        return i;
    }

    /* access modifiers changed from: protected */
    public int zzU(Object obj) {
        int zzlE = zzsa.zzlE(this.tag);
        switch (this.type) {
            case 10:
                return zzrq.zzb(zzlE, (zzrx) obj);
            case 11:
                return zzrq.zzc(zzlE, (zzrx) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzrz zzrz, List<Object> list) {
        list.add(zzA(zzrp.zzz(zzrz.zzbcm)));
    }

    /* access modifiers changed from: 0000 */
    public void zza(Object obj, zzrq zzrq) throws IOException {
        if (this.zzbcc) {
            zzc(obj, zzrq);
        } else {
            zzb(obj, zzrq);
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(Object obj, zzrq zzrq) {
        try {
            zzrq.zzlw(this.tag);
            switch (this.type) {
                case 10:
                    zzrx zzrx = (zzrx) obj;
                    int zzlE = zzsa.zzlE(this.tag);
                    zzrq.zzb(zzrx);
                    zzrq.zzD(zzlE, 4);
                    return;
                case 11:
                    zzrq.zzc((zzrx) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    /* access modifiers changed from: protected */
    public void zzc(Object obj, zzrq zzrq) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, zzrq);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public final T zzx(List<zzrz> list) {
        if (list == null) {
            return null;
        }
        return this.zzbcc ? zzy(list) : zzz(list);
    }
}
