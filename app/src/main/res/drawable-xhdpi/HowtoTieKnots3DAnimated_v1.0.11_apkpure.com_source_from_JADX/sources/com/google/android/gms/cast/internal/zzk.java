package com.google.android.gms.cast.internal;

import com.google.android.gms.common.api.Api.zzc;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;

public final class zzk {
    public static final zzc<zze> zzQf = new zzc<>();
    public static final String zzXs = zzf.zzbM("com.google.cast.receiver");
    public static final String zzXt = zzf.zzbM("com.google.cast.tp.connection");
    public static final Charset zzXu;

    static {
        Charset charset = null;
        try {
            charset = Charset.forName("UTF-8");
        } catch (IllegalCharsetNameException | UnsupportedCharsetException e) {
        }
        zzXu = charset;
    }
}
