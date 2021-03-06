package com.google.android.gms.location.places;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

public class PlacesStatusCodes extends CommonStatusCodes {
    public static final int ACCESS_NOT_CONFIGURED = 9003;
    public static final int DEVICE_RATE_LIMIT_EXCEEDED = 9006;
    public static final int INVALID_ARGUMENT = 9004;
    public static final int KEY_EXPIRED = 9007;
    public static final int KEY_INVALID = 9002;
    public static final int RATE_LIMIT_EXCEEDED = 9005;
    public static final int USAGE_LIMIT_EXCEEDED = 9001;

    private PlacesStatusCodes() {
    }

    public static String getStatusCodeString(int statusCode) {
        switch (statusCode) {
            case 9000:
                return "PLACES_API_QUOTA_FAILED";
            case USAGE_LIMIT_EXCEEDED /*9001*/:
                return "PLACES_API_USAGE_LIMIT_EXCEEDED";
            case KEY_INVALID /*9002*/:
                return "PLACES_API_KEY_INVALID";
            case ACCESS_NOT_CONFIGURED /*9003*/:
                return "PLACES_API_ACCESS_NOT_CONFIGURED";
            case INVALID_ARGUMENT /*9004*/:
                return "PLACES_API_INVALID_ARGUMENT";
            case RATE_LIMIT_EXCEEDED /*9005*/:
                return "PLACES_API_RATE_LIMIT_EXCEEDED";
            case DEVICE_RATE_LIMIT_EXCEEDED /*9006*/:
                return "PLACES_API_DEVICE_RATE_LIMIT_EXCEEDED";
            case KEY_EXPIRED /*9007*/:
                return "PLACES_API_KEY_EXPIRED";
            case 9101:
                return "PLACE_PROXIMITY_CANNOT_BE_DETERMINED";
            default:
                return CommonStatusCodes.getStatusCodeString(statusCode);
        }
    }

    public static Status zzhg(int i) {
        return zzj(i, getStatusCodeString(i));
    }

    public static Status zzj(int i, String str) {
        zzx.zzv(str);
        return new Status(i, str);
    }
}
