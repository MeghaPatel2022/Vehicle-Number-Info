package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzk;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzgk
public class zzew extends zzfb {
    static final Set<String> zzzo = new HashSet(Arrays.asList(new String[]{"top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center"}));
    private int zznP = -1;
    private int zznQ = -1;
    private final zzip zzoL;
    private final Object zzpc = new Object();
    private AdSizeParcel zzyK;
    private RelativeLayout zzzA;
    private ViewGroup zzzB;
    private String zzzp = "top-right";
    private boolean zzzq = true;
    private int zzzr = 0;
    private int zzzs = 0;
    private int zzzt = 0;
    private int zzzu = 0;
    private final Activity zzzv;
    private ImageView zzzw;
    private LinearLayout zzzx;
    private zzfc zzzy;
    private PopupWindow zzzz;

    public zzew(zzip zzip, zzfc zzfc) {
        super(zzip, "resize");
        this.zzoL = zzip;
        this.zzzv = zzip.zzgN();
        this.zzzy = zzfc;
    }

    private int[] zzdX() {
        if (!zzdZ()) {
            return null;
        }
        if (this.zzzq) {
            return new int[]{this.zzzr + this.zzzt, this.zzzs + this.zzzu};
        }
        int[] zzh = zzp.zzbx().zzh(this.zzzv);
        int[] zzj = zzp.zzbx().zzj(this.zzzv);
        int i = zzh[0];
        int i2 = this.zzzr + this.zzzt;
        int i3 = this.zzzs + this.zzzu;
        if (i2 < 0) {
            i2 = 0;
        } else if (this.zznP + i2 > i) {
            i2 = i - this.zznP;
        }
        if (i3 < zzj[0]) {
            i3 = zzj[0];
        } else if (this.zznQ + i3 > zzj[1]) {
            i3 = zzj[1] - this.zznQ;
        }
        return new int[]{i2, i3};
    }

    private void zzf(Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence) map.get("width"))) {
            this.zznP = zzp.zzbx().zzax((String) map.get("width"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("height"))) {
            this.zznQ = zzp.zzbx().zzax((String) map.get("height"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetX"))) {
            this.zzzt = zzp.zzbx().zzax((String) map.get("offsetX"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("offsetY"))) {
            this.zzzu = zzp.zzbx().zzax((String) map.get("offsetY"));
        }
        if (!TextUtils.isEmpty((CharSequence) map.get("allowOffscreen"))) {
            this.zzzq = Boolean.parseBoolean((String) map.get("allowOffscreen"));
        }
        String str = (String) map.get("customClosePosition");
        if (!TextUtils.isEmpty(str)) {
            this.zzzp = str;
        }
    }

    public void zza(int i, int i2, boolean z) {
        synchronized (this.zzpc) {
            this.zzzr = i;
            this.zzzs = i2;
            if (this.zzzz != null && z) {
                int[] zzdX = zzdX();
                if (zzdX != null) {
                    this.zzzz.update(zzk.zzcE().zzb((Context) this.zzzv, zzdX[0]), zzk.zzcE().zzb((Context) this.zzzv, zzdX[1]), this.zzzz.getWidth(), this.zzzz.getHeight());
                    zzc(zzdX[0], zzdX[1]);
                } else {
                    zzn(true);
                }
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzb(int i, int i2) {
        if (this.zzzy != null) {
            this.zzzy.zza(i, i2, this.zznP, this.zznQ);
        }
    }

    /* access modifiers changed from: 0000 */
    public void zzc(int i, int i2) {
        zzb(i, i2 - zzp.zzbx().zzj(this.zzzv)[0], this.zznP, this.zznQ);
    }

    public void zzd(int i, int i2) {
        this.zzzr = i;
        this.zzzs = i2;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzdW() {
        return this.zznP > -1 && this.zznQ > -1;
    }

    public boolean zzdY() {
        boolean z;
        synchronized (this.zzpc) {
            z = this.zzzz != null;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean zzdZ() {
        int i;
        int i2;
        int[] zzh = zzp.zzbx().zzh(this.zzzv);
        int[] zzj = zzp.zzbx().zzj(this.zzzv);
        int i3 = zzh[0];
        int i4 = zzh[1];
        if (this.zznP < 50 || this.zznP > i3) {
            zzb.zzaE("Width is too small or too large.");
            return false;
        } else if (this.zznQ < 50 || this.zznQ > i4) {
            zzb.zzaE("Height is too small or too large.");
            return false;
        } else if (this.zznQ == i4 && this.zznP == i3) {
            zzb.zzaE("Cannot resize to a full-screen ad.");
            return false;
        } else {
            if (this.zzzq) {
                String str = this.zzzp;
                char c = 65535;
                switch (str.hashCode()) {
                    case -1364013995:
                        if (str.equals("center")) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1012429441:
                        if (str.equals("top-left")) {
                            c = 0;
                            break;
                        }
                        break;
                    case -655373719:
                        if (str.equals("bottom-left")) {
                            c = 3;
                            break;
                        }
                        break;
                    case 1163912186:
                        if (str.equals("bottom-right")) {
                            c = 5;
                            break;
                        }
                        break;
                    case 1288627767:
                        if (str.equals("bottom-center")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 1755462605:
                        if (str.equals("top-center")) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        i = this.zzzt + this.zzzr;
                        i2 = this.zzzs + this.zzzu;
                        break;
                    case 1:
                        i = ((this.zzzr + this.zzzt) + (this.zznP / 2)) - 25;
                        i2 = this.zzzs + this.zzzu;
                        break;
                    case 2:
                        i = ((this.zzzr + this.zzzt) + (this.zznP / 2)) - 25;
                        i2 = ((this.zzzs + this.zzzu) + (this.zznQ / 2)) - 25;
                        break;
                    case 3:
                        i = this.zzzt + this.zzzr;
                        i2 = ((this.zzzs + this.zzzu) + this.zznQ) - 50;
                        break;
                    case 4:
                        i = ((this.zzzr + this.zzzt) + (this.zznP / 2)) - 25;
                        i2 = ((this.zzzs + this.zzzu) + this.zznQ) - 50;
                        break;
                    case 5:
                        i = ((this.zzzr + this.zzzt) + this.zznP) - 50;
                        i2 = ((this.zzzs + this.zzzu) + this.zznQ) - 50;
                        break;
                    default:
                        i = ((this.zzzr + this.zzzt) + this.zznP) - 50;
                        i2 = this.zzzs + this.zzzu;
                        break;
                }
                if (i < 0 || i + 50 > i3 || i2 < zzj[0] || i2 + 50 > zzj[1]) {
                    return false;
                }
            }
            return true;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzg(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            r12 = this;
            r4 = -1
            r5 = 1
            r3 = 0
            java.lang.Object r6 = r12.zzpc
            monitor-enter(r6)
            android.app.Activity r1 = r12.zzzv     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0011
            java.lang.String r1 = "Not an activity context. Cannot resize."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
        L_0x0010:
            return
        L_0x0011:
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzaN()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0023
            java.lang.String r1 = "Webview is not yet available, size is not set."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0020:
            r1 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            throw r1
        L_0x0023:
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzaN()     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.zzsH     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0034
            java.lang.String r1 = "Is interstitial. Cannot resize an interstitial."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0034:
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            boolean r1 = r1.zzgW()     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0043
            java.lang.String r1 = "Cannot resize an expanded banner."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0043:
            r12.zzf(r13)     // Catch:{ all -> 0x0020 }
            boolean r1 = r12.zzdW()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0053
            java.lang.String r1 = "Invalid width and height options. Cannot resize."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0053:
            android.app.Activity r1 = r12.zzzv     // Catch:{ all -> 0x0020 }
            android.view.Window r7 = r1.getWindow()     // Catch:{ all -> 0x0020 }
            if (r7 == 0) goto L_0x0061
            android.view.View r1 = r7.getDecorView()     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x0068
        L_0x0061:
            java.lang.String r1 = "Activity context is not ready, cannot get window or decor view."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0068:
            int[] r8 = r12.zzdX()     // Catch:{ all -> 0x0020 }
            if (r8 != 0) goto L_0x0075
            java.lang.String r1 = "Resize location out of screen or close button is not visible."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x0075:
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzk.zzcE()     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzzv     // Catch:{ all -> 0x0020 }
            int r9 = r12.zznP     // Catch:{ all -> 0x0020 }
            int r9 = r1.zzb(r2, r9)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzk.zzcE()     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzzv     // Catch:{ all -> 0x0020 }
            int r10 = r12.zznQ     // Catch:{ all -> 0x0020 }
            int r10 = r1.zzb(r2, r10)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            android.webkit.WebView r1 = r1.getWebView()     // Catch:{ all -> 0x0020 }
            android.view.ViewParent r2 = r1.getParent()     // Catch:{ all -> 0x0020 }
            if (r2 == 0) goto L_0x01d5
            boolean r1 = r2 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x01d5
            r0 = r2
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0     // Catch:{ all -> 0x0020 }
            r1 = r0
            com.google.android.gms.internal.zzip r11 = r12.zzoL     // Catch:{ all -> 0x0020 }
            android.webkit.WebView r11 = r11.getWebView()     // Catch:{ all -> 0x0020 }
            r1.removeView(r11)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzzz     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01ce
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch:{ all -> 0x0020 }
            r12.zzzB = r2     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzhu r1 = com.google.android.gms.ads.internal.zzp.zzbx()     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r2 = r12.zzoL     // Catch:{ all -> 0x0020 }
            android.webkit.WebView r2 = r2.getWebView()     // Catch:{ all -> 0x0020 }
            android.graphics.Bitmap r1 = r1.zzj(r2)     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = new android.widget.ImageView     // Catch:{ all -> 0x0020 }
            android.app.Activity r11 = r12.zzzv     // Catch:{ all -> 0x0020 }
            r2.<init>(r11)     // Catch:{ all -> 0x0020 }
            r12.zzzw = r2     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.zzzw     // Catch:{ all -> 0x0020 }
            r2.setImageBitmap(r1)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r1.zzaN()     // Catch:{ all -> 0x0020 }
            r12.zzyK = r1     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.zzzB     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.zzzw     // Catch:{ all -> 0x0020 }
            r1.addView(r2)     // Catch:{ all -> 0x0020 }
        L_0x00dd:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzzv     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            r12.zzzA = r1     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzzA     // Catch:{ all -> 0x0020 }
            r2 = 0
            r1.setBackgroundColor(r2)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzzA     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup$LayoutParams r2 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0020 }
            r2.<init>(r9, r10)     // Catch:{ all -> 0x0020 }
            r1.setLayoutParams(r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzhu r1 = com.google.android.gms.ads.internal.zzp.zzbx()     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r2 = r12.zzzA     // Catch:{ all -> 0x0020 }
            r11 = 0
            android.widget.PopupWindow r1 = r1.zza(r2, r9, r10, r11)     // Catch:{ all -> 0x0020 }
            r12.zzzz = r1     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzzz     // Catch:{ all -> 0x0020 }
            r2 = 1
            r1.setOutsideTouchable(r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzzz     // Catch:{ all -> 0x0020 }
            r2 = 1
            r1.setTouchable(r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r2 = r12.zzzz     // Catch:{ all -> 0x0020 }
            boolean r1 = r12.zzzq     // Catch:{ all -> 0x0020 }
            if (r1 != 0) goto L_0x01dd
            r1 = r5
        L_0x0116:
            r2.setClippingEnabled(r1)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzzA     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r2 = r12.zzoL     // Catch:{ all -> 0x0020 }
            android.webkit.WebView r2 = r2.getWebView()     // Catch:{ all -> 0x0020 }
            r9 = -1
            r10 = -1
            r1.addView(r2, r9, r10)     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r1 = new android.widget.LinearLayout     // Catch:{ all -> 0x0020 }
            android.app.Activity r2 = r12.zzzv     // Catch:{ all -> 0x0020 }
            r1.<init>(r2)     // Catch:{ all -> 0x0020 }
            r12.zzzx = r1     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout$LayoutParams r2 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzk.zzcE()     // Catch:{ all -> 0x0020 }
            android.app.Activity r9 = r12.zzzv     // Catch:{ all -> 0x0020 }
            r10 = 50
            int r1 = r1.zzb(r9, r10)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.util.client.zza r9 = com.google.android.gms.ads.internal.client.zzk.zzcE()     // Catch:{ all -> 0x0020 }
            android.app.Activity r10 = r12.zzzv     // Catch:{ all -> 0x0020 }
            r11 = 50
            int r9 = r9.zzb(r10, r11)     // Catch:{ all -> 0x0020 }
            r2.<init>(r1, r9)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r12.zzzp     // Catch:{ all -> 0x0020 }
            int r9 = r1.hashCode()     // Catch:{ all -> 0x0020 }
            switch(r9) {
                case -1364013995: goto L_0x01f6;
                case -1012429441: goto L_0x01e0;
                case -655373719: goto L_0x0201;
                case 1163912186: goto L_0x0217;
                case 1288627767: goto L_0x020c;
                case 1755462605: goto L_0x01eb;
                default: goto L_0x0155;
            }     // Catch:{ all -> 0x0020 }
        L_0x0155:
            r1 = r4
        L_0x0156:
            switch(r1) {
                case 0: goto L_0x0222;
                case 1: goto L_0x022e;
                case 2: goto L_0x023a;
                case 3: goto L_0x0241;
                case 4: goto L_0x024d;
                case 5: goto L_0x0259;
                default: goto L_0x0159;
            }     // Catch:{ all -> 0x0020 }
        L_0x0159:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
        L_0x0163:
            android.widget.LinearLayout r1 = r12.zzzx     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzew$1 r3 = new com.google.android.gms.internal.zzew$1     // Catch:{ all -> 0x0020 }
            r3.<init>()     // Catch:{ all -> 0x0020 }
            r1.setOnClickListener(r3)     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r1 = r12.zzzx     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "Close button"
            r1.setContentDescription(r3)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzzA     // Catch:{ all -> 0x0020 }
            android.widget.LinearLayout r3 = r12.zzzx     // Catch:{ all -> 0x0020 }
            r1.addView(r3, r2)     // Catch:{ all -> 0x0020 }
            android.widget.PopupWindow r1 = r12.zzzz     // Catch:{ RuntimeException -> 0x0265 }
            android.view.View r2 = r7.getDecorView()     // Catch:{ RuntimeException -> 0x0265 }
            r3 = 0
            com.google.android.gms.ads.internal.util.client.zza r4 = com.google.android.gms.ads.internal.client.zzk.zzcE()     // Catch:{ RuntimeException -> 0x0265 }
            android.app.Activity r5 = r12.zzzv     // Catch:{ RuntimeException -> 0x0265 }
            r7 = 0
            r7 = r8[r7]     // Catch:{ RuntimeException -> 0x0265 }
            int r4 = r4.zzb(r5, r7)     // Catch:{ RuntimeException -> 0x0265 }
            com.google.android.gms.ads.internal.util.client.zza r5 = com.google.android.gms.ads.internal.client.zzk.zzcE()     // Catch:{ RuntimeException -> 0x0265 }
            android.app.Activity r7 = r12.zzzv     // Catch:{ RuntimeException -> 0x0265 }
            r9 = 1
            r9 = r8[r9]     // Catch:{ RuntimeException -> 0x0265 }
            int r5 = r5.zzb(r7, r9)     // Catch:{ RuntimeException -> 0x0265 }
            r1.showAtLocation(r2, r3, r4, r5)     // Catch:{ RuntimeException -> 0x0265 }
            r1 = 0
            r1 = r8[r1]     // Catch:{ all -> 0x0020 }
            r2 = 1
            r2 = r8[r2]     // Catch:{ all -> 0x0020 }
            r12.zzb(r1, r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = new com.google.android.gms.ads.internal.client.AdSizeParcel     // Catch:{ all -> 0x0020 }
            android.app.Activity r3 = r12.zzzv     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.AdSize r4 = new com.google.android.gms.ads.AdSize     // Catch:{ all -> 0x0020 }
            int r5 = r12.zznP     // Catch:{ all -> 0x0020 }
            int r7 = r12.zznQ     // Catch:{ all -> 0x0020 }
            r4.<init>(r5, r7)     // Catch:{ all -> 0x0020 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0020 }
            r1.zza(r2)     // Catch:{ all -> 0x0020 }
            r1 = 0
            r1 = r8[r1]     // Catch:{ all -> 0x0020 }
            r2 = 1
            r2 = r8[r2]     // Catch:{ all -> 0x0020 }
            r12.zzc(r1, r2)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = "resized"
            r12.zzaj(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x01ce:
            android.widget.PopupWindow r1 = r12.zzzz     // Catch:{ all -> 0x0020 }
            r1.dismiss()     // Catch:{ all -> 0x0020 }
            goto L_0x00dd
        L_0x01d5:
            java.lang.String r1 = "Webview is detached, probably in the middle of a resize or expand."
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        L_0x01dd:
            r1 = r3
            goto L_0x0116
        L_0x01e0:
            java.lang.String r5 = "top-left"
            boolean r1 = r1.equals(r5)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = r3
            goto L_0x0156
        L_0x01eb:
            java.lang.String r3 = "top-center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = r5
            goto L_0x0156
        L_0x01f6:
            java.lang.String r3 = "center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 2
            goto L_0x0156
        L_0x0201:
            java.lang.String r3 = "bottom-left"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 3
            goto L_0x0156
        L_0x020c:
            java.lang.String r3 = "bottom-center"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 4
            goto L_0x0156
        L_0x0217:
            java.lang.String r3 = "bottom-right"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x0155
            r1 = 5
            goto L_0x0156
        L_0x0222:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x022e:
            r1 = 10
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x023a:
            r1 = 13
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0241:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 9
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x024d:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 14
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0259:
            r1 = 12
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            r1 = 11
            r2.addRule(r1)     // Catch:{ all -> 0x0020 }
            goto L_0x0163
        L_0x0265:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0020 }
            r2.<init>()     // Catch:{ all -> 0x0020 }
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0020 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0020 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0020 }
            r12.zzah(r1)     // Catch:{ all -> 0x0020 }
            android.widget.RelativeLayout r1 = r12.zzzA     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r2 = r12.zzoL     // Catch:{ all -> 0x0020 }
            android.webkit.WebView r2 = r2.getWebView()     // Catch:{ all -> 0x0020 }
            r1.removeView(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.zzzB     // Catch:{ all -> 0x0020 }
            if (r1 == 0) goto L_0x02a8
            android.view.ViewGroup r1 = r12.zzzB     // Catch:{ all -> 0x0020 }
            android.widget.ImageView r2 = r12.zzzw     // Catch:{ all -> 0x0020 }
            r1.removeView(r2)     // Catch:{ all -> 0x0020 }
            android.view.ViewGroup r1 = r12.zzzB     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r2 = r12.zzoL     // Catch:{ all -> 0x0020 }
            android.webkit.WebView r2 = r2.getWebView()     // Catch:{ all -> 0x0020 }
            r1.addView(r2)     // Catch:{ all -> 0x0020 }
            com.google.android.gms.internal.zzip r1 = r12.zzoL     // Catch:{ all -> 0x0020 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r12.zzyK     // Catch:{ all -> 0x0020 }
            r1.zza(r2)     // Catch:{ all -> 0x0020 }
        L_0x02a8:
            monitor-exit(r6)     // Catch:{ all -> 0x0020 }
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzew.zzg(java.util.Map):void");
    }

    public void zzn(boolean z) {
        synchronized (this.zzpc) {
            if (this.zzzz != null) {
                this.zzzz.dismiss();
                this.zzzA.removeView(this.zzoL.getWebView());
                if (this.zzzB != null) {
                    this.zzzB.removeView(this.zzzw);
                    this.zzzB.addView(this.zzoL.getWebView());
                    this.zzoL.zza(this.zzyK);
                }
                if (z) {
                    zzaj("default");
                    if (this.zzzy != null) {
                        this.zzzy.zzbc();
                    }
                }
                this.zzzz = null;
                this.zzzA = null;
                this.zzzB = null;
                this.zzzx = null;
            }
        }
    }
}
