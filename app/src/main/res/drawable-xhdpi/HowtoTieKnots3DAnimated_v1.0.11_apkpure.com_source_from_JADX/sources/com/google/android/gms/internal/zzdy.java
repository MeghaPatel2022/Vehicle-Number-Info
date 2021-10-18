package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;

@zzgk
public final class zzdy {
    private final Context mContext;
    private final zzeh zzow;
    private final Object zzpc = new Object();
    private final AdRequestInfoParcel zzyd;
    private final zzea zzye;
    private final boolean zzyf;
    private boolean zzyg = false;
    private zzed zzyh;

    public zzdy(Context context, AdRequestInfoParcel adRequestInfoParcel, zzeh zzeh, zzea zzea, boolean z) {
        this.mContext = context;
        this.zzyd = adRequestInfoParcel;
        this.zzow = zzeh;
        this.zzye = zzea;
        this.zzyf = z;
    }

    public void cancel() {
        synchronized (this.zzpc) {
            this.zzyg = true;
            if (this.zzyh != null) {
                this.zzyh.cancel();
            }
        }
    }

    /* JADX INFO: used method not loaded: com.google.android.gms.internal.zzed.zza(long, long):null, types can be incorrect */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x009f, code lost:
        r4 = r23.zzyh.zza(r24, r26);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00ad, code lost:
        if (r4.zzyP != 0) goto L_0x00f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x00af, code lost:
        com.google.android.gms.ads.internal.util.client.zzb.zzaC("Adapter succeeded.");
        r28.zzd("mediation_network_succeed", r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00bf, code lost:
        if (r16.isEmpty() != false) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c1, code lost:
        r0 = r28;
        r0.zzd("mediation_networks_fail", android.text.TextUtils.join(",", r16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d0, code lost:
        r28.zza(r20, "mls");
        r28.zza(r17, "ttm");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00f3, code lost:
        r16.add(r6);
        r28.zza(r20, "mlf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0109, code lost:
        if (r4.zzyR == null) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x010b, code lost:
        com.google.android.gms.internal.zzhu.zzHK.post(new com.google.android.gms.internal.zzdy.C09091(r23));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzee zza(long r24, long r26, com.google.android.gms.internal.zzcd r28) {
        /*
            r23 = this;
            java.lang.String r4 = "Starting mediation."
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r4)
            java.util.ArrayList r16 = new java.util.ArrayList
            r16.<init>()
            com.google.android.gms.internal.zzcc r17 = r28.zzdl()
            r0 = r23
            com.google.android.gms.internal.zzea r4 = r0.zzye
            java.util.List<com.google.android.gms.internal.zzdz> r4 = r4.zzyu
            java.util.Iterator r18 = r4.iterator()
        L_0x0018:
            boolean r4 = r18.hasNext()
            if (r4 == 0) goto L_0x0119
            java.lang.Object r9 = r18.next()
            com.google.android.gms.internal.zzdz r9 = (com.google.android.gms.internal.zzdz) r9
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Trying mediation network: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r5 = r9.zzyl
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzaD(r4)
            java.util.List<java.lang.String> r4 = r9.zzym
            java.util.Iterator r19 = r4.iterator()
        L_0x0042:
            boolean r4 = r19.hasNext()
            if (r4 == 0) goto L_0x0018
            java.lang.Object r6 = r19.next()
            java.lang.String r6 = (java.lang.String) r6
            com.google.android.gms.internal.zzcc r20 = r28.zzdl()
            r0 = r23
            java.lang.Object r0 = r0.zzpc
            r21 = r0
            monitor-enter(r21)
            r0 = r23
            boolean r4 = r0.zzyg     // Catch:{ all -> 0x00f0 }
            if (r4 == 0) goto L_0x0067
            com.google.android.gms.internal.zzee r4 = new com.google.android.gms.internal.zzee     // Catch:{ all -> 0x00f0 }
            r5 = -1
            r4.<init>(r5)     // Catch:{ all -> 0x00f0 }
            monitor-exit(r21)     // Catch:{ all -> 0x00f0 }
        L_0x0066:
            return r4
        L_0x0067:
            com.google.android.gms.internal.zzed r4 = new com.google.android.gms.internal.zzed     // Catch:{ all -> 0x00f0 }
            r0 = r23
            android.content.Context r5 = r0.mContext     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.internal.zzeh r7 = r0.zzow     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.internal.zzea r8 = r0.zzye     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r10 = r0.zzyd     // Catch:{ all -> 0x00f0 }
            com.google.android.gms.ads.internal.client.AdRequestParcel r10 = r10.zzDy     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r11 = r0.zzyd     // Catch:{ all -> 0x00f0 }
            com.google.android.gms.ads.internal.client.AdSizeParcel r11 = r11.zzqf     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r12 = r0.zzyd     // Catch:{ all -> 0x00f0 }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r12 = r12.zzqb     // Catch:{ all -> 0x00f0 }
            r0 = r23
            boolean r13 = r0.zzyf     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r14 = r0.zzyd     // Catch:{ all -> 0x00f0 }
            com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r14 = r14.zzqt     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r15 = r0.zzyd     // Catch:{ all -> 0x00f0 }
            java.util.List<java.lang.String> r15 = r15.zzqv     // Catch:{ all -> 0x00f0 }
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x00f0 }
            r0 = r23
            r0.zzyh = r4     // Catch:{ all -> 0x00f0 }
            monitor-exit(r21)     // Catch:{ all -> 0x00f0 }
            r0 = r23
            com.google.android.gms.internal.zzed r4 = r0.zzyh
            r0 = r24
            r2 = r26
            com.google.android.gms.internal.zzee r4 = r4.zza(r0, r2)
            int r5 = r4.zzyP
            if (r5 != 0) goto L_0x00f3
            java.lang.String r5 = "Adapter succeeded."
            com.google.android.gms.ads.internal.util.client.zzb.zzaC(r5)
            java.lang.String r5 = "mediation_network_succeed"
            r0 = r28
            r0.zzd(r5, r6)
            boolean r5 = r16.isEmpty()
            if (r5 != 0) goto L_0x00d0
            java.lang.String r5 = "mediation_networks_fail"
            java.lang.String r6 = ","
            r0 = r16
            java.lang.String r6 = android.text.TextUtils.join(r6, r0)
            r0 = r28
            r0.zzd(r5, r6)
        L_0x00d0:
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]
            r6 = 0
            java.lang.String r7 = "mls"
            r5[r6] = r7
            r0 = r28
            r1 = r20
            r0.zza(r1, r5)
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]
            r6 = 0
            java.lang.String r7 = "ttm"
            r5[r6] = r7
            r0 = r28
            r1 = r17
            r0.zza(r1, r5)
            goto L_0x0066
        L_0x00f0:
            r4 = move-exception
            monitor-exit(r21)     // Catch:{ all -> 0x00f0 }
            throw r4
        L_0x00f3:
            r0 = r16
            r0.add(r6)
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]
            r6 = 0
            java.lang.String r7 = "mlf"
            r5[r6] = r7
            r0 = r28
            r1 = r20
            r0.zza(r1, r5)
            com.google.android.gms.internal.zzei r5 = r4.zzyR
            if (r5 == 0) goto L_0x0042
            android.os.Handler r5 = com.google.android.gms.internal.zzhu.zzHK
            com.google.android.gms.internal.zzdy$1 r6 = new com.google.android.gms.internal.zzdy$1
            r0 = r23
            r6.<init>(r4)
            r5.post(r6)
            goto L_0x0042
        L_0x0119:
            boolean r4 = r16.isEmpty()
            if (r4 != 0) goto L_0x012e
            java.lang.String r4 = "mediation_networks_fail"
            java.lang.String r5 = ","
            r0 = r16
            java.lang.String r5 = android.text.TextUtils.join(r5, r0)
            r0 = r28
            r0.zzd(r4, r5)
        L_0x012e:
            com.google.android.gms.internal.zzee r4 = new com.google.android.gms.internal.zzee
            r5 = 1
            r4.<init>(r5)
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdy.zza(long, long, com.google.android.gms.internal.zzcd):com.google.android.gms.internal.zzee");
    }
}
