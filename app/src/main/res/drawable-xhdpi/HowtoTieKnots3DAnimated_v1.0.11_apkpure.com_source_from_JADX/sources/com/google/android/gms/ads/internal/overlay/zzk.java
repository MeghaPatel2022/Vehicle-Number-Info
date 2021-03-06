package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.InputDeviceCompat;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.internal.zzcc;
import com.google.android.gms.internal.zzcd;
import com.google.android.gms.internal.zzgk;
import com.google.android.gms.internal.zzip;
import java.util.HashMap;

@zzgk
public class zzk extends FrameLayout implements zzh {
    private final FrameLayout zzBb;
    private final zzq zzBc = new zzq(this);
    private zzi zzBd;
    private boolean zzBe;
    private boolean zzBf;
    private TextView zzBg;
    private long zzBh;
    private long zzBi;
    private String zzBj;
    private final zzip zzoL;
    private String zzxs;

    public zzk(Context context, zzip zzip, int i, zzcd zzcd, zzcc zzcc) {
        super(context);
        this.zzoL = zzip;
        this.zzBb = new FrameLayout(context);
        addView(this.zzBb);
        zzb.zzr(zzip.zzgP());
        this.zzBd = zzip.zzgP().zzoG.zza(context, zzip, i, zzcd, zzcc);
        this.zzBb.addView(this.zzBd, new LayoutParams(-1, -1, 17));
        this.zzBg = new TextView(context);
        this.zzBg.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        zzeS();
        this.zzBc.zzfa();
        this.zzBd.zza((zzh) this);
    }

    private void zza(String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", str);
        int length = strArr.length;
        int i = 0;
        String str2 = null;
        while (i < length) {
            String str3 = strArr[i];
            if (str2 != null) {
                hashMap.put(str2, str3);
                str3 = null;
            }
            i++;
            str2 = str3;
        }
        this.zzoL.zzc("onVideoEvent", hashMap);
    }

    public static void zzd(zzip zzip) {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "no_video_view");
        zzip.zzc("onVideoEvent", hashMap);
    }

    private void zzeS() {
        if (!zzeU()) {
            this.zzBb.addView(this.zzBg, new LayoutParams(-1, -1));
            this.zzBb.bringChildToFront(this.zzBg);
        }
    }

    private void zzeT() {
        if (zzeU()) {
            this.zzBb.removeView(this.zzBg);
        }
    }

    private boolean zzeU() {
        return this.zzBg.getParent() != null;
    }

    private void zzeV() {
        if (this.zzoL.zzgN() != null && !this.zzBe) {
            this.zzBf = (this.zzoL.zzgN().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzBf) {
                this.zzoL.zzgN().getWindow().addFlags(128);
                this.zzBe = true;
            }
        }
    }

    private void zzeW() {
        if (this.zzoL.zzgN() != null && this.zzBe && !this.zzBf) {
            this.zzoL.zzgN().getWindow().clearFlags(128);
            this.zzBe = false;
        }
    }

    public void destroy() {
        this.zzBc.cancel();
        this.zzBd.stop();
        zzeW();
    }

    public void onPaused() {
        zza("pause", new String[0]);
        zzeW();
    }

    public void pause() {
        this.zzBd.pause();
    }

    public void play() {
        this.zzBd.play();
    }

    public void seekTo(int millis) {
        this.zzBd.seekTo(millis);
    }

    public void setMimeType(String mimeType) {
        this.zzBj = mimeType;
    }

    public void zza(float f) {
        this.zzBd.zza(f);
    }

    public void zzak(String str) {
        this.zzxs = str;
    }

    public void zzd(MotionEvent motionEvent) {
        this.zzBd.dispatchTouchEvent(motionEvent);
    }

    public void zze(int i, int i2, int i3, int i4) {
        if (i3 != 0 && i4 != 0) {
            LayoutParams layoutParams = new LayoutParams(i3 + 2, i4 + 2);
            layoutParams.setMargins(i - 1, i2 - 1, 0, 0);
            this.zzBb.setLayoutParams(layoutParams);
            requestLayout();
        }
    }

    public void zzeK() {
    }

    public void zzeL() {
        if (this.zzBi == 0) {
            zza("canplaythrough", "duration", String.valueOf(((float) this.zzBd.getDuration()) / 1000.0f), "videoWidth", String.valueOf(this.zzBd.getVideoWidth()), "videoHeight", String.valueOf(this.zzBd.getVideoHeight()));
        }
    }

    public void zzeM() {
        zzeV();
    }

    public void zzeN() {
        zza("ended", new String[0]);
        zzeW();
    }

    public void zzeO() {
        zzeS();
        this.zzBi = this.zzBh;
    }

    public void zzeP() {
        if (!TextUtils.isEmpty(this.zzxs)) {
            this.zzBd.setMimeType(this.zzBj);
            this.zzBd.setVideoPath(this.zzxs);
            return;
        }
        zza("no_src", new String[0]);
    }

    public void zzeQ() {
        TextView textView = new TextView(this.zzBd.getContext());
        textView.setText("AdMob - " + this.zzBd.zzek());
        textView.setTextColor(SupportMenu.CATEGORY_MASK);
        textView.setBackgroundColor(InputDeviceCompat.SOURCE_ANY);
        this.zzBb.addView(textView, new LayoutParams(-2, -2, 17));
        this.zzBb.bringChildToFront(textView);
    }

    /* access modifiers changed from: 0000 */
    public void zzeR() {
        long currentPosition = (long) this.zzBd.getCurrentPosition();
        if (this.zzBh != currentPosition && currentPosition > 0) {
            zzeT();
            zza("timeupdate", "time", String.valueOf(((float) currentPosition) / 1000.0f));
            this.zzBh = currentPosition;
        }
    }

    public void zzeq() {
        this.zzBd.zzeq();
    }

    public void zzer() {
        this.zzBd.zzer();
    }

    public void zzh(String str, String str2) {
        zza(MediaRouteProviderProtocol.SERVICE_DATA_ERROR, "what", str, "extra", str2);
    }
}
