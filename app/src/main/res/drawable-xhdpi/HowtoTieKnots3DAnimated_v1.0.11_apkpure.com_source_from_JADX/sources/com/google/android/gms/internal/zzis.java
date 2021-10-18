package com.google.android.gms.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzgk
public class zzis extends WebView implements OnGlobalLayoutListener, DownloadListener, zzip {
    private String zzBm = "";
    private final zziq zzCq;
    private Boolean zzHi;
    private final zza zzJk;
    private zzd zzJl;
    private boolean zzJm;
    private boolean zzJn;
    private boolean zzJo;
    private boolean zzJp;
    private int zzJq;
    private boolean zzJr = true;
    private String zzJs;
    private zzd zzJt;
    private Map<String, zzdr> zzJu;
    private final com.google.android.gms.ads.internal.zzd zzov;
    private final VersionInfoParcel zzpa;
    private final Object zzpc = new Object();
    private zzid zzqG;
    private final WindowManager zzqX;
    private final zzan zzwh;
    private AdSizeParcel zzyK;
    private int zzzQ = -1;
    private int zzzR = -1;
    private int zzzT = -1;
    private int zzzU = -1;

    @zzgk
    public static class zza extends MutableContextWrapper {
        private Activity zzIs;
        private Context zzJw;
        private Context zzqO;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String service) {
            return this.zzJw.getSystemService(service);
        }

        public void setBaseContext(Context base) {
            this.zzqO = base.getApplicationContext();
            this.zzIs = base instanceof Activity ? (Activity) base : null;
            this.zzJw = base;
            super.setBaseContext(this.zzqO);
        }

        public void startActivity(Intent intent) {
            if (this.zzIs == null || zzlv.isAtLeastL()) {
                intent.setFlags(DriveFile.MODE_READ_ONLY);
                this.zzqO.startActivity(intent);
                return;
            }
            this.zzIs.startActivity(intent);
        }

        public Activity zzgN() {
            return this.zzIs;
        }

        public Context zzgO() {
            return this.zzJw;
        }
    }

    protected zzis(zza zza2, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzan, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzd zzd) {
        super(zza2);
        this.zzJk = zza2;
        this.zzyK = adSizeParcel;
        this.zzJo = z;
        this.zzJq = -1;
        this.zzwh = zzan;
        this.zzpa = versionInfoParcel;
        this.zzov = zzd;
        this.zzqX = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
        }
        zzp.zzbx().zza((Context) zza2, versionInfoParcel.zzIz, settings);
        zzp.zzbz().zza(getContext(), settings);
        setDownloadListener(this);
        this.zzCq = zzp.zzbz().zzb((zzip) this, z2);
        setWebViewClient(this.zzCq);
        setWebChromeClient(zzp.zzbz().zzf((zzip) this));
        zzhk();
        if (zzlv.zzpT()) {
            addJavascriptInterface(new zzit(this), "googleAdsJsInterface");
        }
        this.zzqG = new zzid(this.zzJk.zzgN(), this, null);
    }

    static zzis zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, zzan zzan, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zzd zzd) {
        return new zzis(new zza(context), adSizeParcel, z, z2, zzan, versionInfoParcel, zzd);
    }

    private void zzhj() {
        synchronized (this.zzpc) {
            this.zzHi = zzp.zzbA().zzgg();
            if (this.zzHi == null) {
                try {
                    evaluateJavascript("(function(){})()", null);
                    zzb(Boolean.valueOf(true));
                } catch (IllegalStateException e) {
                    zzb(Boolean.valueOf(false));
                }
            }
        }
    }

    private void zzhk() {
        synchronized (this.zzpc) {
            if (this.zzJo || this.zzyK.zzsH) {
                if (VERSION.SDK_INT < 14) {
                    zzb.zzaC("Disabling hardware acceleration on an overlay.");
                    zzhl();
                } else {
                    zzb.zzaC("Enabling hardware acceleration on an overlay.");
                    zzhm();
                }
            } else if (VERSION.SDK_INT < 18) {
                zzb.zzaC("Disabling hardware acceleration on an AdView.");
                zzhl();
            } else {
                zzb.zzaC("Enabling hardware acceleration on an AdView.");
                zzhm();
            }
        }
    }

    private void zzhl() {
        synchronized (this.zzpc) {
            if (!this.zzJp) {
                zzp.zzbz().zzl(this);
            }
            this.zzJp = true;
        }
    }

    private void zzhm() {
        synchronized (this.zzpc) {
            if (this.zzJp) {
                zzp.zzbz().zzk(this);
            }
            this.zzJp = false;
        }
    }

    private void zzhn() {
        synchronized (this.zzpc) {
            if (this.zzJu != null) {
                for (zzdr release : this.zzJu.values()) {
                    release.release();
                }
            }
        }
    }

    public void destroy() {
        synchronized (this.zzpc) {
            this.zzqG.zzgE();
            if (this.zzJl != null) {
                this.zzJl.close();
                this.zzJl.onDestroy();
                this.zzJl = null;
            }
            this.zzCq.reset();
            if (!this.zzJn) {
                zzp.zzbK().zza((zzip) this);
                zzhn();
                this.zzJn = true;
                zzb.m20v("Initiating WebView self destruct sequence in 3...");
                this.zzCq.zzhd();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.zzpc
            monitor-enter(r1)
            boolean r0 = r2.isDestroyed()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "The webview is destroyed. Ignoring action."
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r0)     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0014
            r0 = 0
            r4.onReceiveValue(r0)     // Catch:{ all -> 0x001b }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0015:
            return
        L_0x0016:
            super.evaluateJavascript(r3, r4)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0015
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzis.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    public String getRequestId() {
        String str;
        synchronized (this.zzpc) {
            str = this.zzBm;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzpc) {
            i = this.zzJq;
        }
        return i;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzJn;
        }
        return z;
    }

    public void loadData(String data, String mimeType, String encoding) {
        synchronized (this.zzpc) {
            if (!isDestroyed()) {
                super.loadData(data, mimeType, encoding);
            } else {
                zzb.zzaE("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        synchronized (this.zzpc) {
            if (!isDestroyed()) {
                super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
            } else {
                zzb.zzaE("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public void loadUrl(String uri) {
        synchronized (this.zzpc) {
            if (!isDestroyed()) {
                super.loadUrl(uri);
            } else {
                zzb.zzaE("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        synchronized (this.zzpc) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzqG.onAttachedToWindow();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        synchronized (this.zzpc) {
            if (!isDestroyed()) {
                this.zzqG.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
        }
    }

    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(url), mimeType);
            getContext().startActivity(intent);
        } catch (ActivityNotFoundException e) {
            zzb.zzaC("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public void onGlobalLayout() {
        boolean zzhi = zzhi();
        zzd zzgQ = zzgQ();
        if (zzgQ != null && zzhi) {
            zzgQ.zzeC();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            r8 = 1073741824(0x40000000, float:2.0)
            r7 = 8
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.zzpc
            monitor-enter(r4)
            boolean r1 = r9.isDestroyed()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0019
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
        L_0x0018:
            return
        L_0x0019:
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0029
            boolean r1 = r9.zzJo     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0029
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzyK     // Catch:{ all -> 0x002e }
            boolean r1 = r1.zzsJ     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0031
        L_0x0029:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x002e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            throw r0
        L_0x0031:
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzyK     // Catch:{ all -> 0x002e }
            boolean r1 = r1.zzsH     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x004e
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ all -> 0x002e }
            r0.<init>()     // Catch:{ all -> 0x002e }
            android.view.WindowManager r1 = r9.zzqX     // Catch:{ all -> 0x002e }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ all -> 0x002e }
            r1.getMetrics(r0)     // Catch:{ all -> 0x002e }
            int r1 = r0.widthPixels     // Catch:{ all -> 0x002e }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x002e }
            r9.setMeasuredDimension(r1, r0)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x004e:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x002e }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x002e }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x002e }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x002e }
            if (r2 == r6) goto L_0x0062
            if (r2 != r8) goto L_0x00f7
        L_0x0062:
            r2 = r3
        L_0x0063:
            if (r5 == r6) goto L_0x0067
            if (r5 != r8) goto L_0x0068
        L_0x0067:
            r0 = r1
        L_0x0068:
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.zzyK     // Catch:{ all -> 0x002e }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x002e }
            if (r5 > r2) goto L_0x0074
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r9.zzyK     // Catch:{ all -> 0x002e }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x002e }
            if (r2 <= r0) goto L_0x00e1
        L_0x0074:
            com.google.android.gms.internal.zzis$zza r0 = r9.zzJk     // Catch:{ all -> 0x002e }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x002e }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x002e }
            float r0 = r0.density     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r2.<init>()     // Catch:{ all -> 0x002e }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.zzyK     // Catch:{ all -> 0x002e }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x002e }
            float r5 = (float) r5     // Catch:{ all -> 0x002e }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = "x"
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.zzyK     // Catch:{ all -> 0x002e }
            int r5 = r5.heightPixels     // Catch:{ all -> 0x002e }
            float r5 = (float) r5     // Catch:{ all -> 0x002e }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r5 = " dp, but only has "
            java.lang.StringBuilder r2 = r2.append(r5)     // Catch:{ all -> 0x002e }
            float r3 = (float) r3     // Catch:{ all -> 0x002e }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x002e }
            java.lang.String r3 = "x"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x002e }
            float r1 = (float) r1     // Catch:{ all -> 0x002e }
            float r0 = r1 / r0
            int r0 = (int) r0     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = " dp."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(r0)     // Catch:{ all -> 0x002e }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x002e }
            if (r0 == r7) goto L_0x00d9
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x002e }
        L_0x00d9:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x002e }
        L_0x00de:
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x00e1:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x002e }
            if (r0 == r7) goto L_0x00eb
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x002e }
        L_0x00eb:
            com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r9.zzyK     // Catch:{ all -> 0x002e }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzyK     // Catch:{ all -> 0x002e }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x002e }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x002e }
            goto L_0x00de
        L_0x00f7:
            r2 = r0
            goto L_0x0063
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzis.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzb.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzb.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (this.zzwh != null) {
            this.zzwh.zza(event);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(event);
    }

    public void setContext(Context context) {
        this.zzJk.setBaseContext(context);
        this.zzqG.zzl(this.zzJk.zzgN());
    }

    public void setRequestedOrientation(int requestedOrientation) {
        synchronized (this.zzpc) {
            this.zzJq = requestedOrientation;
            if (this.zzJl != null) {
                this.zzJl.setRequestedOrientation(this.zzJq);
            }
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzb.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zzC(boolean z) {
        synchronized (this.zzpc) {
            this.zzJo = z;
            zzhk();
        }
    }

    public void zzD(boolean z) {
        synchronized (this.zzpc) {
            if (this.zzJl != null) {
                this.zzJl.zza(this.zzCq.zzbY(), z);
            } else {
                this.zzJm = z;
            }
        }
    }

    public void zzE(boolean z) {
        synchronized (this.zzpc) {
            this.zzJr = z;
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel) {
        synchronized (this.zzpc) {
            this.zzqG.zzgE();
            setContext(context);
            this.zzJl = null;
            this.zzyK = adSizeParcel;
            this.zzJo = false;
            this.zzJm = false;
            this.zzBm = "";
            this.zzJq = -1;
            zzp.zzbz().zzb(this);
            loadUrl("about:blank");
            this.zzCq.reset();
            setOnTouchListener(null);
            setOnClickListener(null);
            this.zzJr = true;
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzpc) {
            this.zzyK = adSizeParcel;
            requestLayout();
        }
    }

    public void zza(zzd zzd) {
        synchronized (this.zzpc) {
            this.zzJl = zzd;
        }
    }

    public void zza(zzaz zzaz, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zzc("onAdVisibilityChanged", hashMap);
    }

    /* access modifiers changed from: protected */
    public void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzpc) {
            if (!isDestroyed()) {
                evaluateJavascript(str, valueCallback);
            } else {
                zzb.zzaE("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue(null);
                }
            }
        }
    }

    public void zza(String str, String str2) {
        zzaK(str + "(" + str2 + ");");
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zza(str, jSONObject.toString());
    }

    public void zzaF(String str) {
        synchronized (this.zzpc) {
            super.loadUrl(str);
        }
    }

    public void zzaG(String str) {
        synchronized (this.zzpc) {
            if (str == null) {
                str = "";
            }
            this.zzBm = str;
        }
    }

    public void zzaH(String str) {
        synchronized (this.zzpc) {
            this.zzJs = str;
        }
    }

    /* access modifiers changed from: protected */
    public void zzaJ(String str) {
        synchronized (this.zzpc) {
            if (!isDestroyed()) {
                loadUrl(str);
            } else {
                zzb.zzaE("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaK(String str) {
        if (zzlv.zzpV()) {
            if (zzgg() == null) {
                zzhj();
            }
            if (zzgg().booleanValue()) {
                zza(str, null);
            } else {
                zzaJ("javascript:" + str);
            }
        } else {
            zzaJ("javascript:" + str);
        }
    }

    public AdSizeParcel zzaN() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzpc) {
            adSizeParcel = this.zzyK;
        }
        return adSizeParcel;
    }

    public void zzb(zzd zzd) {
        synchronized (this.zzpc) {
            this.zzJt = zzd;
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzb(Boolean bool) {
        this.zzHi = bool;
        zzp.zzbA().zzb(bool);
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("AFMA_ReceiveMessage('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        zzb.m20v("Dispatching AFMA event: " + sb.toString());
        zzaK(sb.toString());
    }

    public void zzc(String str, Map<String, ?> map) {
        try {
            zzb(str, zzp.zzbx().zzx(map));
        } catch (JSONException e) {
            zzb.zzaE("Could not convert parameters to JSON.");
        }
    }

    public void zzeD() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzpa.zzIz);
        zzc("onshow", hashMap);
    }

    public void zzgM() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzpa.zzIz);
        zzc("onhide", hashMap);
    }

    public Activity zzgN() {
        return this.zzJk.zzgN();
    }

    public Context zzgO() {
        return this.zzJk.zzgO();
    }

    public com.google.android.gms.ads.internal.zzd zzgP() {
        return this.zzov;
    }

    public zzd zzgQ() {
        zzd zzd;
        synchronized (this.zzpc) {
            zzd = this.zzJl;
        }
        return zzd;
    }

    public zzd zzgR() {
        zzd zzd;
        synchronized (this.zzpc) {
            zzd = this.zzJt;
        }
        return zzd;
    }

    public zziq zzgS() {
        return this.zzCq;
    }

    public boolean zzgT() {
        return this.zzJm;
    }

    public zzan zzgU() {
        return this.zzwh;
    }

    public VersionInfoParcel zzgV() {
        return this.zzpa;
    }

    public boolean zzgW() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzJo;
        }
        return z;
    }

    public void zzgX() {
        synchronized (this.zzpc) {
            zzb.m20v("Destroying WebView!");
            zzhu.zzHK.post(new Runnable() {
                public void run() {
                    zzis.super.destroy();
                }
            });
        }
    }

    public boolean zzgY() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzJr;
        }
        return z;
    }

    public void zzgZ() {
        this.zzqG.zzgD();
    }

    /* access modifiers changed from: 0000 */
    public Boolean zzgg() {
        Boolean bool;
        synchronized (this.zzpc) {
            bool = this.zzHi;
        }
        return bool;
    }

    public String zzha() {
        String str;
        synchronized (this.zzpc) {
            str = this.zzJs;
        }
        return str;
    }

    public boolean zzhi() {
        int i;
        int i2;
        if (!zzgS().zzbY()) {
            return false;
        }
        DisplayMetrics zza2 = zzp.zzbx().zza(this.zzqX);
        int zzb = zzk.zzcE().zzb(zza2, zza2.widthPixels);
        int zzb2 = zzk.zzcE().zzb(zza2, zza2.heightPixels);
        Activity zzgN = zzgN();
        if (zzgN == null || zzgN.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzg = zzp.zzbx().zzg(zzgN);
            i2 = zzk.zzcE().zzb(zza2, zzg[0]);
            i = zzk.zzcE().zzb(zza2, zzg[1]);
        }
        if (this.zzzQ == zzb && this.zzzR == zzb2 && this.zzzT == i2 && this.zzzU == i) {
            return false;
        }
        boolean z = (this.zzzQ == zzb && this.zzzR == zzb2) ? false : true;
        this.zzzQ = zzb;
        this.zzzR = zzb2;
        this.zzzT = i2;
        this.zzzU = i;
        new zzfb(this).zza(zzb, zzb2, i2, i, zza2.density, this.zzqX.getDefaultDisplay().getRotation());
        return z;
    }

    public void zzv(int i) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzpa.zzIz);
        zzc("onhide", hashMap);
    }
}
