package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;
import com.google.android.gms.C0224R;

public final class zzab extends Button {
    public zzab(Context context) {
        this(context, null);
    }

    public zzab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 16842824);
    }

    private void zza(Resources resources) {
        setTypeface(Typeface.DEFAULT_BOLD);
        setTextSize(14.0f);
        float f = resources.getDisplayMetrics().density;
        setMinHeight((int) ((f * 48.0f) + 0.5f));
        setMinWidth((int) ((f * 48.0f) + 0.5f));
    }

    private void zzb(Resources resources, int i, int i2) {
        int zzd;
        switch (i) {
            case 0:
            case 1:
                zzd = zzd(i2, C0224R.C0225drawable.common_signin_btn_text_dark, C0224R.C0225drawable.common_signin_btn_text_light);
                break;
            case 2:
                zzd = zzd(i2, C0224R.C0225drawable.common_signin_btn_icon_dark, C0224R.C0225drawable.common_signin_btn_icon_light);
                break;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
        if (zzd == -1) {
            throw new IllegalStateException("Could not find background resource!");
        }
        setBackgroundDrawable(resources.getDrawable(zzd));
    }

    private void zzc(Resources resources, int i, int i2) {
        setTextColor(resources.getColorStateList(zzd(i2, C0224R.color.common_signin_btn_text_dark, C0224R.color.common_signin_btn_text_light)));
        switch (i) {
            case 0:
                setText(resources.getString(C0224R.string.common_signin_button_text));
                return;
            case 1:
                setText(resources.getString(C0224R.string.common_signin_button_text_long));
                return;
            case 2:
                setText(null);
                return;
            default:
                throw new IllegalStateException("Unknown button size: " + i);
        }
    }

    private int zzd(int i, int i2, int i3) {
        switch (i) {
            case 0:
                return i2;
            case 1:
                return i3;
            default:
                throw new IllegalStateException("Unknown color scheme: " + i);
        }
    }

    public void zza(Resources resources, int i, int i2) {
        zzx.zza(i >= 0 && i < 3, "Unknown button size %d", Integer.valueOf(i));
        zzx.zza(i2 >= 0 && i2 < 2, "Unknown color scheme %s", Integer.valueOf(i2));
        zza(resources);
        zzb(resources, i, i2);
        zzc(resources, i, i2);
    }
}
