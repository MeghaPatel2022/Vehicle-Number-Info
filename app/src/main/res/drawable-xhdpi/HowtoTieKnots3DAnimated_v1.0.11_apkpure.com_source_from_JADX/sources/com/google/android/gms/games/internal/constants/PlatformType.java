package com.google.android.gms.games.internal.constants;

public final class PlatformType {
    private PlatformType() {
    }

    public static String zzfQ(int i) {
        switch (i) {
            case 0:
                return "ANDROID";
            case 1:
                return "IOS";
            case 2:
                return "WEB_APP";
            default:
                throw new IllegalArgumentException("Unknown platform type: " + i);
        }
    }
}
