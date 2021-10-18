package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzae;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.plus.internal.zzg;

public final class PlusOneButton extends FrameLayout {
    public static final int ANNOTATION_BUBBLE = 1;
    public static final int ANNOTATION_INLINE = 2;
    public static final int ANNOTATION_NONE = 0;
    public static final int DEFAULT_ACTIVITY_REQUEST_CODE = -1;
    public static final int SIZE_MEDIUM = 1;
    public static final int SIZE_SMALL = 0;
    public static final int SIZE_STANDARD = 3;
    public static final int SIZE_TALL = 2;
    private int mSize;
    private String zzF;
    /* access modifiers changed from: private */
    public View zzaLg;
    private int zzaLh;
    /* access modifiers changed from: private */
    public int zzaLi;
    private OnPlusOneClickListener zzaLj;

    protected class DefaultOnPlusOneClickListener implements OnClickListener, OnPlusOneClickListener {
        private final OnPlusOneClickListener zzaLk;

        public DefaultOnPlusOneClickListener(OnPlusOneClickListener proxy) {
            this.zzaLk = proxy;
        }

        public void onClick(View view) {
            Intent intent = (Intent) PlusOneButton.this.zzaLg.getTag();
            if (this.zzaLk != null) {
                this.zzaLk.onPlusOneClick(intent);
            } else {
                onPlusOneClick(intent);
            }
        }

        public void onPlusOneClick(Intent intent) {
            Context context = PlusOneButton.this.getContext();
            if ((context instanceof Activity) && intent != null) {
                ((Activity) context).startActivityForResult(intent, PlusOneButton.this.zzaLi);
            }
        }
    }

    public interface OnPlusOneClickListener {
        void onPlusOneClick(Intent intent);
    }

    public PlusOneButton(Context context) {
        this(context, null);
    }

    public PlusOneButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mSize = getSize(context, attrs);
        this.zzaLh = getAnnotation(context, attrs);
        this.zzaLi = -1;
        zzah(getContext());
        if (isInEditMode()) {
        }
    }

    protected static int getAnnotation(Context context, AttributeSet attrs) {
        String zza = zzae.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", context, attrs, true, false, "PlusOneButton");
        if ("INLINE".equalsIgnoreCase(zza)) {
            return 2;
        }
        return !"NONE".equalsIgnoreCase(zza) ? 1 : 0;
    }

    protected static int getSize(Context context, AttributeSet attrs) {
        String zza = zzae.zza("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", context, attrs, true, false, "PlusOneButton");
        if ("SMALL".equalsIgnoreCase(zza)) {
            return 0;
        }
        if ("MEDIUM".equalsIgnoreCase(zza)) {
            return 1;
        }
        return "TALL".equalsIgnoreCase(zza) ? 2 : 3;
    }

    private void zzah(Context context) {
        if (this.zzaLg != null) {
            removeView(this.zzaLg);
        }
        this.zzaLg = zzg.zza(context, this.mSize, this.zzaLh, this.zzF, this.zzaLi);
        setOnPlusOneClickListener(this.zzaLj);
        addView(this.zzaLg);
    }

    public void initialize(String url, int activityRequestCode) {
        zzx.zza(getContext() instanceof Activity, (Object) "To use this method, the PlusOneButton must be placed in an Activity. Use initialize(String, OnPlusOneClickListener).");
        this.zzF = url;
        this.zzaLi = activityRequestCode;
        zzah(getContext());
    }

    public void initialize(String url, OnPlusOneClickListener plusOneClickListener) {
        this.zzF = url;
        this.zzaLi = 0;
        zzah(getContext());
        setOnPlusOneClickListener(plusOneClickListener);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        this.zzaLg.layout(0, 0, right - left, bottom - top);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        View view = this.zzaLg;
        measureChild(view, widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void plusOneClick() {
        this.zzaLg.performClick();
    }

    public void setAnnotation(int annotation) {
        this.zzaLh = annotation;
        zzah(getContext());
    }

    public void setIntent(Intent intent) {
        this.zzaLg.setTag(intent);
    }

    public void setOnPlusOneClickListener(OnPlusOneClickListener listener) {
        this.zzaLj = listener;
        this.zzaLg.setOnClickListener(new DefaultOnPlusOneClickListener(listener));
    }

    public void setSize(int size) {
        this.mSize = size;
        zzah(getContext());
    }
}
