package com.google.android.gms.internal;

import com.google.android.gms.auth.GoogleAuthUtil;

public class zznl {
    private static final ThreadLocal<String> zzaoN = new ThreadLocal<>();

    public static String zzcV(String str) {
        return zzrY() ? str : zzz(str, (String) zzaoN.get());
    }

    public static boolean zzrY() {
        String str = (String) zzaoN.get();
        return str == null || str.startsWith(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    public static String zzz(String str, String str2) {
        if (str == null || str2 == null) {
            return str;
        }
        byte[] bArr = new byte[(str.length() + str2.length())];
        System.arraycopy(str.getBytes(), 0, bArr, 0, str.length());
        System.arraycopy(str2.getBytes(), 0, bArr, str.length(), str2.length());
        return Integer.toHexString(zzlu.zza(bArr, 0, bArr.length, 0));
    }
}
