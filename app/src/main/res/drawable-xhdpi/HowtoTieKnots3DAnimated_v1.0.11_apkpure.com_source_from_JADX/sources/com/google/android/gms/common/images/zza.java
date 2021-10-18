package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzku;
import java.lang.ref.WeakReference;

public abstract class zza {
    final C1350zza zzabQ;
    protected int zzabR = 0;
    protected int zzabS = 0;
    protected boolean zzabT = false;
    protected OnImageLoadedListener zzabU;
    private boolean zzabV = true;
    private boolean zzabW = false;
    private boolean zzabX = true;
    protected int zzabY;

    /* renamed from: com.google.android.gms.common.images.zza$zza reason: collision with other inner class name */
    static final class C1350zza {
        public final Uri uri;

        public C1350zza(Uri uri2) {
            this.uri = uri2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1350zza)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return zzw.equal(((C1350zza) obj).uri, this.uri);
        }

        public int hashCode() {
            return zzw.hashCode(this.uri);
        }
    }

    public static final class zzb extends zza {
        private WeakReference<ImageView> zzabZ;

        public zzb(ImageView imageView, int i) {
            super(null, i);
            com.google.android.gms.common.internal.zzb.zzr(imageView);
            this.zzabZ = new WeakReference<>(imageView);
        }

        public zzb(ImageView imageView, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzr(imageView);
            this.zzabZ = new WeakReference<>(imageView);
        }

        private void zza(ImageView imageView, Drawable drawable, boolean z, boolean z2, boolean z3) {
            boolean z4 = !z2 && !z3;
            if (z4 && (imageView instanceof zzkt)) {
                int zzof = ((zzkt) imageView).zzof();
                if (this.zzabS != 0 && zzof == this.zzabS) {
                    return;
                }
            }
            boolean zzb = zzb(z, z2);
            Drawable drawable2 = (!this.zzabT || drawable == null) ? drawable : drawable.getConstantState().newDrawable();
            if (zzb) {
                drawable2 = zza(imageView.getDrawable(), drawable2);
            }
            imageView.setImageDrawable(drawable2);
            if (imageView instanceof zzkt) {
                zzkt zzkt = (zzkt) imageView;
                zzkt.zzj(z3 ? this.zzabQ.uri : null);
                zzkt.zzbv(z4 ? this.zzabS : 0);
            }
            if (zzb) {
                ((zzkr) drawable2).startTransition(250);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzb)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            ImageView imageView = (ImageView) this.zzabZ.get();
            ImageView imageView2 = (ImageView) ((zzb) obj).zzabZ.get();
            return (imageView2 == null || imageView == null || !zzw.equal(imageView2, imageView)) ? false : true;
        }

        public int hashCode() {
            return 0;
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageView imageView = (ImageView) this.zzabZ.get();
            if (imageView != null) {
                zza(imageView, drawable, z, z2, z3);
            }
        }
    }

    public static final class zzc extends zza {
        private WeakReference<OnImageLoadedListener> zzaca;

        public zzc(OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            com.google.android.gms.common.internal.zzb.zzr(onImageLoadedListener);
            this.zzaca = new WeakReference<>(onImageLoadedListener);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zzc)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            zzc zzc = (zzc) obj;
            OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzaca.get();
            OnImageLoadedListener onImageLoadedListener2 = (OnImageLoadedListener) zzc.zzaca.get();
            return onImageLoadedListener2 != null && onImageLoadedListener != null && zzw.equal(onImageLoadedListener2, onImageLoadedListener) && zzw.equal(zzc.zzabQ, this.zzabQ);
        }

        public int hashCode() {
            return zzw.hashCode(this.zzabQ);
        }

        /* access modifiers changed from: protected */
        public void zza(Drawable drawable, boolean z, boolean z2, boolean z3) {
            if (!z2) {
                OnImageLoadedListener onImageLoadedListener = (OnImageLoadedListener) this.zzaca.get();
                if (onImageLoadedListener != null) {
                    onImageLoadedListener.onImageLoaded(this.zzabQ.uri, drawable, z3);
                }
            }
        }
    }

    public zza(Uri uri, int i) {
        this.zzabQ = new C1350zza(uri);
        this.zzabS = i;
    }

    private Drawable zza(Context context, zzku zzku, int i) {
        Resources resources = context.getResources();
        if (this.zzabY <= 0) {
            return resources.getDrawable(i);
        }
        com.google.android.gms.internal.zzku.zza zza = new com.google.android.gms.internal.zzku.zza(i, this.zzabY);
        Drawable drawable = (Drawable) zzku.get(zza);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i);
        if ((this.zzabY & 1) != 0) {
            drawable2 = zza(resources, drawable2);
        }
        zzku.put(zza, drawable2);
        return drawable2;
    }

    /* access modifiers changed from: protected */
    public Drawable zza(Resources resources, Drawable drawable) {
        return zzks.zza(resources, drawable);
    }

    /* access modifiers changed from: protected */
    public zzkr zza(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof zzkr) {
            drawable = ((zzkr) drawable).zzod();
        }
        return new zzkr(drawable, drawable2);
    }

    /* access modifiers changed from: 0000 */
    public void zza(Context context, Bitmap bitmap, boolean z) {
        com.google.android.gms.common.internal.zzb.zzr(bitmap);
        if ((this.zzabY & 1) != 0) {
            bitmap = zzks.zza(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.zzabU != null) {
            this.zzabU.onImageLoaded(this.zzabQ.uri, bitmapDrawable, true);
        }
        zza(bitmapDrawable, z, false, true);
    }

    /* access modifiers changed from: 0000 */
    public void zza(Context context, zzku zzku) {
        if (this.zzabX) {
            Drawable drawable = null;
            if (this.zzabR != 0) {
                drawable = zza(context, zzku, this.zzabR);
            }
            zza(drawable, false, true, false);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zza(Context context, zzku zzku, boolean z) {
        Drawable drawable = null;
        if (this.zzabS != 0) {
            drawable = zza(context, zzku, this.zzabS);
        }
        if (this.zzabU != null) {
            this.zzabU.onImageLoaded(this.zzabQ.uri, drawable, false);
        }
        zza(drawable, z, false, false);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(Drawable drawable, boolean z, boolean z2, boolean z3);

    /* access modifiers changed from: protected */
    public boolean zzb(boolean z, boolean z2) {
        return this.zzabV && !z2 && (!z || this.zzabW);
    }

    public void zzbt(int i) {
        this.zzabS = i;
    }
}
