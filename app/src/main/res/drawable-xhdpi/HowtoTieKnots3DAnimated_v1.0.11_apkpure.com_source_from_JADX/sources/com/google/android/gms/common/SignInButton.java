package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zzg.zza;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private View zzYB;
    private OnClickListener zzYC;

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzYC = null;
        setStyle(0, 0);
    }

    private static Button zza(Context context, int i, int i2) {
        zzab zzab = new zzab(context);
        zzab.zza(context.getResources(), i, i2);
        return zzab;
    }

    private void zzah(Context context) {
        if (this.zzYB != null) {
            removeView(this.zzYB);
        }
        try {
            this.zzYB = zzaa.zzb(context, this.mSize, this.mColor);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzYB = zza(context, this.mSize, this.mColor);
        }
        addView(this.zzYB);
        this.zzYB.setEnabled(isEnabled());
        this.zzYB.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.zzYC != null && view == this.zzYB) {
            this.zzYC.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.zzYB.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.zzYC = listener;
        if (this.zzYB != null) {
            this.zzYB.setOnClickListener(this);
        }
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.mColor);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        zzx.zza(buttonSize >= 0 && buttonSize < 3, "Unknown button size %d", Integer.valueOf(buttonSize));
        zzx.zza(colorScheme >= 0 && colorScheme < 2, "Unknown color scheme %s", Integer.valueOf(colorScheme));
        this.mSize = buttonSize;
        this.mColor = colorScheme;
        zzah(getContext());
    }
}
