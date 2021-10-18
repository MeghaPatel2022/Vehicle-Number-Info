package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzkq<T> {
    /* access modifiers changed from: private */
    public static zza zzaaX = null;
    private static int zzaaY = 0;
    private static String zzaaZ = "com.google.android.providers.gsf.permission.READ_GSERVICES";
    private static final Object zzpm = new Object();
    private T zzNR = null;
    protected final String zztP;
    protected final T zztQ;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zzb(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzkq(String str, T t) {
        this.zztP = str;
        this.zztQ = t;
    }

    public static boolean isInitialized() {
        return zzaaX != null;
    }

    public static zzkq<Float> zza(String str, Float f) {
        return new zzkq<Float>(str, f) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcb */
            public Float zzbX(String str) {
                return zzkq.zzaaX.zzb(this.zztP, (Float) this.zztQ);
            }
        };
    }

    public static zzkq<Integer> zza(String str, Integer num) {
        return new zzkq<Integer>(str, num) {
            /* access modifiers changed from: protected */
            /* renamed from: zzca */
            public Integer zzbX(String str) {
                return zzkq.zzaaX.zzb(this.zztP, (Integer) this.zztQ);
            }
        };
    }

    public static zzkq<Long> zza(String str, Long l) {
        return new zzkq<Long>(str, l) {
            /* access modifiers changed from: protected */
            /* renamed from: zzbZ */
            public Long zzbX(String str) {
                return zzkq.zzaaX.getLong(this.zztP, (Long) this.zztQ);
            }
        };
    }

    public static zzkq<Boolean> zzg(String str, boolean z) {
        return new zzkq<Boolean>(str, Boolean.valueOf(z)) {
            /* access modifiers changed from: protected */
            /* renamed from: zzbY */
            public Boolean zzbX(String str) {
                return zzkq.zzaaX.zzb(this.zztP, (Boolean) this.zztQ);
            }
        };
    }

    public static int zznM() {
        return zzaaY;
    }

    public static zzkq<String> zzu(String str, String str2) {
        return new zzkq<String>(str, str2) {
            /* access modifiers changed from: protected */
            /* renamed from: zzcc */
            public String zzbX(String str) {
                return zzkq.zzaaX.getString(this.zztP, (String) this.zztQ);
            }
        };
    }

    public final T get() {
        return this.zzNR != null ? this.zzNR : zzbX(this.zztP);
    }

    /* access modifiers changed from: protected */
    public abstract T zzbX(String str);

    public final T zznN() {
        long clearCallingIdentity = Binder.clearCallingIdentity();
        try {
            return get();
        } finally {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
    }
}
