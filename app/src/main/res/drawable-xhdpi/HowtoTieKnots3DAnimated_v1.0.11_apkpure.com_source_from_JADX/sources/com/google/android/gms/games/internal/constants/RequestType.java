package com.google.android.gms.games.internal.constants;

import com.google.android.gms.games.internal.GamesLog;

public final class RequestType {
    private RequestType() {
    }

    public static String zzfQ(int i) {
        switch (i) {
            case 1:
                return "GIFT";
            case 2:
                return "WISH";
            default:
                GamesLog.zzx("RequestType", "Unknown request type: " + i);
                return "UNKNOWN_TYPE";
        }
    }
}
