package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class zzkt extends ImageView {
    private Uri zzact;
    private int zzacu;
    private int zzacv;
    private zza zzacw;
    private int zzacx;
    private float zzacy;

    public interface zza {
        Path zzl(int i, int i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.zzacw != null) {
            canvas.clipPath(this.zzacw.zzl(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzacv != 0) {
            canvas.drawColor(this.zzacv);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredWidth;
        int i;
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        switch (this.zzacx) {
            case 1:
                i = getMeasuredHeight();
                measuredWidth = (int) (((float) i) * this.zzacy);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i = (int) (((float) measuredWidth) / this.zzacy);
                break;
            default:
                return;
        }
        setMeasuredDimension(measuredWidth, i);
    }

    public void zzbv(int i) {
        this.zzacu = i;
    }

    public void zzj(Uri uri) {
        this.zzact = uri;
    }

    public int zzof() {
        return this.zzacu;
    }
}
