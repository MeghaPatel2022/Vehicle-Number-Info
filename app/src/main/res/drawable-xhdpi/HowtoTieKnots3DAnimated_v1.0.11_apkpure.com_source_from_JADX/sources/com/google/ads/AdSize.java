package com.google.ads;

import android.content.Context;
import com.google.android.gms.nearby.messages.Strategy;

@Deprecated
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(Strategy.TTL_SECONDS_DEFAULT, 250, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");
    private final com.google.android.gms.ads.AdSize zzaJ;

    public AdSize(int width, int height) {
        this(new com.google.android.gms.ads.AdSize(width, height));
    }

    private AdSize(int width, int height, String type) {
        this(new com.google.android.gms.ads.AdSize(width, height));
    }

    public AdSize(com.google.android.gms.ads.AdSize adSize) {
        this.zzaJ = adSize;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdSize)) {
            return false;
        }
        return this.zzaJ.equals(((AdSize) other).zzaJ);
    }

    public AdSize findBestSize(AdSize... options) {
        float f;
        AdSize adSize;
        AdSize adSize2 = null;
        if (options != null) {
            float f2 = 0.0f;
            int width = getWidth();
            int height = getHeight();
            int length = options.length;
            int i = 0;
            while (i < length) {
                AdSize adSize3 = options[i];
                int width2 = adSize3.getWidth();
                int height2 = adSize3.getHeight();
                if (isSizeAppropriate(width2, height2)) {
                    f = ((float) (width2 * height2)) / ((float) (width * height));
                    if (f > 1.0f) {
                        f = 1.0f / f;
                    }
                    if (f > f2) {
                        adSize = adSize3;
                        i++;
                        adSize2 = adSize;
                        f2 = f;
                    }
                }
                f = f2;
                adSize = adSize2;
                i++;
                adSize2 = adSize;
                f2 = f;
            }
        }
        return adSize2;
    }

    public int getHeight() {
        return this.zzaJ.getHeight();
    }

    public int getHeightInPixels(Context context) {
        return this.zzaJ.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.zzaJ.getWidth();
    }

    public int getWidthInPixels(Context context) {
        return this.zzaJ.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.zzaJ.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzaJ.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.zzaJ.isFullWidth();
    }

    public boolean isSizeAppropriate(int width, int height) {
        int width2 = getWidth();
        int height2 = getHeight();
        return ((float) width) <= ((float) width2) * 1.25f && ((float) width) >= ((float) width2) * 0.8f && ((float) height) <= ((float) height2) * 1.25f && ((float) height) >= ((float) height2) * 0.8f;
    }

    public String toString() {
        return this.zzaJ.toString();
    }
}
