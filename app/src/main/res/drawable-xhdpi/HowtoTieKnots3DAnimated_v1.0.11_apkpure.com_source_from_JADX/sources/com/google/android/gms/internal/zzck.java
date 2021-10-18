package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.ads.formats.NativeAd.Image;

@zzgk
public class zzck implements Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final zzcj zzww;

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r0v8, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: type inference failed for: r0v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzck(com.google.android.gms.internal.zzcj r4) {
        /*
            r3 = this;
            r1 = 0
            r3.<init>()
            r3.zzww = r4
            com.google.android.gms.internal.zzcj r0 = r3.zzww     // Catch:{ RemoteException -> 0x001f }
            com.google.android.gms.dynamic.zzd r0 = r0.zzdr()     // Catch:{ RemoteException -> 0x001f }
            if (r0 == 0) goto L_0x0025
            java.lang.Object r0 = com.google.android.gms.dynamic.zze.zzp(r0)     // Catch:{ RemoteException -> 0x001f }
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0     // Catch:{ RemoteException -> 0x001f }
        L_0x0014:
            r3.mDrawable = r0
            com.google.android.gms.internal.zzcj r0 = r3.zzww     // Catch:{ RemoteException -> 0x0027 }
            android.net.Uri r1 = r0.getUri()     // Catch:{ RemoteException -> 0x0027 }
        L_0x001c:
            r3.mUri = r1
            return
        L_0x001f:
            r0 = move-exception
            java.lang.String r2 = "Failed to get drawable."
            com.google.android.gms.ads.internal.util.client.zzb.zzb(r2, r0)
        L_0x0025:
            r0 = r1
            goto L_0x0014
        L_0x0027:
            r0 = move-exception
            java.lang.String r2 = "Failed to get uri."
            com.google.android.gms.ads.internal.util.client.zzb.zzb(r2, r0)
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzck.<init>(com.google.android.gms.internal.zzcj):void");
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
