package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p000v4.view.accessibility.AccessibilityEventCompat;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */
    public static final Object zzabB = new Object();
    /* access modifiers changed from: private */
    public static HashSet<Uri> zzabC = new HashSet<>();
    private static ImageManager zzabD;
    private static ImageManager zzabE;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final ExecutorService zzabF = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */
    public final zzb zzabG;
    /* access modifiers changed from: private */
    public final zzku zzabH;
    /* access modifiers changed from: private */
    public final Map<zza, ImageReceiver> zzabI;
    /* access modifiers changed from: private */
    public final Map<Uri, ImageReceiver> zzabJ;
    /* access modifiers changed from: private */
    public final Map<Uri, Long> zzabK;

    private final class ImageReceiver extends ResultReceiver {
        private final Uri mUri;
        /* access modifiers changed from: private */
        public final ArrayList<zza> zzabL = new ArrayList<>();

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int resultCode, Bundle resultData) {
            ImageManager.this.zzabF.execute(new zzc(this.mUri, (ParcelFileDescriptor) resultData.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzb.zzch("ImageReceiver.addImageRequest() must be called in the main thread");
            this.zzabL.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzb.zzch("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.zzabL.remove(zza);
        }

        public void zzoc() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends zzlf<C1350zza, Bitmap> {
        public zzb(Context context) {
            super(zzai(context));
        }

        private static int zzai(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START) != 0) || !zzlv.zzpO()) ? activityManager.getMemoryClass() : zza.zza(activityManager)) * AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public int sizeOf(C1350zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void entryRemoved(boolean z, C1350zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {
        private final Uri mUri;
        private final ParcelFileDescriptor zzabN;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.zzabN = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzci("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.zzabN != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.zzabN.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    Log.e("ImageManager", "OOM while loading bitmap for uri: " + this.mUri, e);
                    z = true;
                }
                try {
                    this.zzabN.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                Log.w("ImageManager", "Latch interrupted while posting " + this.mUri);
            }
        }
    }

    private final class zzd implements Runnable {
        private final zza zzabO;

        public zzd(zza zza) {
            this.zzabO = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzch("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzabI.get(this.zzabO);
            if (imageReceiver != null) {
                ImageManager.this.zzabI.remove(this.zzabO);
                imageReceiver.zzc(this.zzabO);
            }
            C1350zza zza = this.zzabO.zzabQ;
            if (zza.uri == null) {
                this.zzabO.zza(ImageManager.this.mContext, ImageManager.this.zzabH, true);
                return;
            }
            Bitmap zza2 = ImageManager.this.zza(zza);
            if (zza2 != null) {
                this.zzabO.zza(ImageManager.this.mContext, zza2, true);
                return;
            }
            Long l = (Long) ImageManager.this.zzabK.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.zzabO.zza(ImageManager.this.mContext, ImageManager.this.zzabH, true);
                    return;
                }
                ImageManager.this.zzabK.remove(zza.uri);
            }
            this.zzabO.zza(ImageManager.this.mContext, ImageManager.this.zzabH);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.zzabJ.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.zzabJ.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.zzabO);
            if (!(this.zzabO instanceof com.google.android.gms.common.images.zza.zzc)) {
                ImageManager.this.zzabI.put(this.zzabO, imageReceiver2);
            }
            synchronized (ImageManager.zzabB) {
                if (!ImageManager.zzabC.contains(zza.uri)) {
                    ImageManager.zzabC.add(zza.uri);
                    imageReceiver2.zzoc();
                }
            }
        }
    }

    private static final class zze implements ComponentCallbacks2 {
        private final zzb zzabG;

        public zze(zzb zzb) {
            this.zzabG = zzb;
        }

        public void onConfigurationChanged(Configuration newConfig) {
        }

        public void onLowMemory() {
            this.zzabG.evictAll();
        }

        public void onTrimMemory(int level) {
            if (level >= 60) {
                this.zzabG.evictAll();
            } else if (level >= 20) {
                this.zzabG.trimToSize(this.zzabG.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {
        private final Bitmap mBitmap;
        private final Uri mUri;
        private boolean zzabP;
        private final CountDownLatch zzoR;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.zzabP = z;
            this.zzoR = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.zzabL;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                if (z) {
                    zza2.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.zzabK.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(ImageManager.this.mContext, ImageManager.this.zzabH, false);
                }
                if (!(zza2 instanceof com.google.android.gms.common.images.zza.zzc)) {
                    ImageManager.this.zzabI.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzb.zzch("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.zzabG != null) {
                if (this.zzabP) {
                    ImageManager.this.zzabG.evictAll();
                    System.gc();
                    this.zzabP = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.zzabG.put(new C1350zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.zzabJ.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzoR.countDown();
            synchronized (ImageManager.zzabB) {
                ImageManager.zzabC.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean withMemoryCache) {
        this.mContext = context.getApplicationContext();
        if (withMemoryCache) {
            this.zzabG = new zzb(this.mContext);
            if (zzlv.zzpR()) {
                zznZ();
            }
        } else {
            this.zzabG = null;
        }
        this.zzabH = new zzku();
        this.zzabI = new HashMap();
        this.zzabJ = new HashMap();
        this.zzabK = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzb(context, false);
    }

    /* access modifiers changed from: private */
    public Bitmap zza(C1350zza zza2) {
        if (this.zzabG == null) {
            return null;
        }
        return (Bitmap) this.zzabG.get(zza2);
    }

    public static ImageManager zzb(Context context, boolean z) {
        if (z) {
            if (zzabE == null) {
                zzabE = new ImageManager(context, true);
            }
            return zzabE;
        }
        if (zzabD == null) {
            zzabD = new ImageManager(context, false);
        }
        return zzabD;
    }

    private void zznZ() {
        this.mContext.registerComponentCallbacks(new zze(this.zzabG));
    }

    public void loadImage(ImageView imageView, int resId) {
        zza((zza) new com.google.android.gms.common.images.zza.zzb(imageView, resId));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza((zza) new com.google.android.gms.common.images.zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int defaultResId) {
        com.google.android.gms.common.images.zza.zzb zzb2 = new com.google.android.gms.common.images.zza.zzb(imageView, uri);
        zzb2.zzbt(defaultResId);
        zza((zza) zzb2);
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri) {
        zza((zza) new com.google.android.gms.common.images.zza.zzc(listener, uri));
    }

    public void loadImage(OnImageLoadedListener listener, Uri uri, int defaultResId) {
        com.google.android.gms.common.images.zza.zzc zzc2 = new com.google.android.gms.common.images.zza.zzc(listener, uri);
        zzc2.zzbt(defaultResId);
        zza((zza) zzc2);
    }

    public void zza(zza zza2) {
        com.google.android.gms.common.internal.zzb.zzch("ImageManager.loadImage() must be called in the main thread");
        new zzd(zza2).run();
    }
}
