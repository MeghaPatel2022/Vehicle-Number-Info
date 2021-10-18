package com.google.android.gms.tagmanager;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzaf.zzj;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzqk;
import com.google.android.gms.internal.zzqo;

public class zzp extends com.google.android.gms.common.api.zzb<ContainerHolder> {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Looper zzYV;
    /* access modifiers changed from: private */
    public final String zzaOS;
    /* access modifiers changed from: private */
    public long zzaOX;
    /* access modifiers changed from: private */
    public final TagManager zzaPe;
    private final zzd zzaPh;
    /* access modifiers changed from: private */
    public final zzcd zzaPi;
    private final int zzaPj;
    private zzf zzaPk;
    private zzqk zzaPl;
    /* access modifiers changed from: private */
    public volatile zzo zzaPm;
    /* access modifiers changed from: private */
    public volatile boolean zzaPn;
    /* access modifiers changed from: private */
    public zzj zzaPo;
    private String zzaPp;
    private zze zzaPq;
    private zza zzaPr;
    /* access modifiers changed from: private */
    public final zzlm zzpO;

    interface zza {
        boolean zzb(Container container);
    }

    private class zzb implements zzbf<com.google.android.gms.internal.zzqh.zza> {
        private zzb() {
        }

        /* renamed from: zza */
        public void zzB(com.google.android.gms.internal.zzqh.zza zza) {
            zzj zzj;
            if (zza.zzaTu != null) {
                zzj = zza.zzaTu;
            } else {
                com.google.android.gms.internal.zzaf.zzf zzf = zza.zziR;
                zzj = new zzj();
                zzj.zziR = zzf;
                zzj.zziQ = null;
                zzj.zziS = zzf.version;
            }
            zzp.this.zza(zzj, zza.zzaTt, true);
        }

        public void zza(com.google.android.gms.tagmanager.zzbf.zza zza) {
            if (!zzp.this.zzaPn) {
                zzp.this.zzR(0);
            }
        }

        public void zzzL() {
        }
    }

    private class zzc implements zzbf<zzj> {
        private zzc() {
        }

        public void zza(com.google.android.gms.tagmanager.zzbf.zza zza) {
            synchronized (zzp.this) {
                if (!zzp.this.isReady()) {
                    if (zzp.this.zzaPm != null) {
                        zzp.this.zza(zzp.this.zzaPm);
                    } else {
                        zzp.this.zza(zzp.this.zzb(Status.zzaaG));
                    }
                }
            }
            zzp.this.zzR(3600000);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* renamed from: zzb */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzB(com.google.android.gms.internal.zzaf.zzj r6) {
            /*
                r5 = this;
                com.google.android.gms.tagmanager.zzp r1 = com.google.android.gms.tagmanager.zzp.this
                monitor-enter(r1)
                com.google.android.gms.internal.zzaf$zzf r0 = r6.zziR     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x002a
                com.google.android.gms.tagmanager.zzp r0 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.zzaf$zzj r0 = r0.zzaPo     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.zzaf$zzf r0 = r0.zziR     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0020
                java.lang.String r0 = "Current resource is null; network resource is also null"
                com.google.android.gms.tagmanager.zzbg.m28e(r0)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.zzp r0 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                r2 = 3600000(0x36ee80, double:1.7786363E-317)
                r0.zzR(r2)     // Catch:{ all -> 0x0065 }
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
            L_0x001f:
                return
            L_0x0020:
                com.google.android.gms.tagmanager.zzp r0 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.zzaf$zzj r0 = r0.zzaPo     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.zzaf$zzf r0 = r0.zziR     // Catch:{ all -> 0x0065 }
                r6.zziR = r0     // Catch:{ all -> 0x0065 }
            L_0x002a:
                com.google.android.gms.tagmanager.zzp r0 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.zzp r2 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                com.google.android.gms.internal.zzlm r2 = r2.zzpO     // Catch:{ all -> 0x0065 }
                long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x0065 }
                r4 = 0
                r0.zza(r6, r2, r4)     // Catch:{ all -> 0x0065 }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
                r0.<init>()     // Catch:{ all -> 0x0065 }
                java.lang.String r2 = "setting refresh time to current time: "
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.zzp r2 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                long r2 = r2.zzaOX     // Catch:{ all -> 0x0065 }
                java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0065 }
                java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.zzbg.m29v(r0)     // Catch:{ all -> 0x0065 }
                com.google.android.gms.tagmanager.zzp r0 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                boolean r0 = r0.zzzK()     // Catch:{ all -> 0x0065 }
                if (r0 != 0) goto L_0x0063
                com.google.android.gms.tagmanager.zzp r0 = com.google.android.gms.tagmanager.zzp.this     // Catch:{ all -> 0x0065 }
                r0.zza(r6)     // Catch:{ all -> 0x0065 }
            L_0x0063:
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
                goto L_0x001f
            L_0x0065:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0065 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zzc.zzB(com.google.android.gms.internal.zzaf$zzj):void");
        }

        public void zzzL() {
        }
    }

    private class zzd implements com.google.android.gms.tagmanager.zzo.zza {
        private zzd() {
        }

        public void zzey(String str) {
            zzp.this.zzey(str);
        }

        public String zzzE() {
            return zzp.this.zzzE();
        }

        public void zzzG() {
            if (zzp.this.zzaPi.zzkp()) {
                zzp.this.zzR(0);
            }
        }
    }

    interface zze extends Releasable {
        void zza(zzbf<zzj> zzbf);

        void zzeB(String str);

        void zzf(long j, String str);
    }

    interface zzf extends Releasable {
        void zza(zzbf<com.google.android.gms.internal.zzqh.zza> zzbf);

        void zzb(com.google.android.gms.internal.zzqh.zza zza);

        com.google.android.gms.internal.zzqp.zzc zzjc(int i);

        void zzzM();
    }

    zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzf zzf2, zze zze2, zzqk zzqk, zzlm zzlm, zzcd zzcd) {
        super(looper == null ? Looper.getMainLooper() : looper);
        this.mContext = context;
        this.zzaPe = tagManager;
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        this.zzYV = looper;
        this.zzaOS = str;
        this.zzaPj = i;
        this.zzaPk = zzf2;
        this.zzaPq = zze2;
        this.zzaPl = zzqk;
        this.zzaPh = new zzd();
        this.zzaPo = new zzj();
        this.zzpO = zzlm;
        this.zzaPi = zzcd;
        if (zzzK()) {
            zzey(zzcb.zzAv().zzAx());
        }
    }

    public zzp(Context context, TagManager tagManager, Looper looper, String str, int i, zzs zzs) {
        this(context, tagManager, looper, str, i, new zzcn(context, str), new zzcm(context, str, zzs), new zzqk(context), zzlo.zzpN(), new zzbe(30, 900000, 5000, "refreshing", zzlo.zzpN()));
        this.zzaPl.zzfj(zzs.zzzN());
    }

    /* access modifiers changed from: private */
    public synchronized void zzR(long j) {
        if (this.zzaPq == null) {
            zzbg.zzaE("Refresh requested, but no network load scheduler.");
        } else {
            this.zzaPq.zzf(j, this.zzaPo.zziS);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void zza(zzj zzj) {
        if (this.zzaPk != null) {
            com.google.android.gms.internal.zzqh.zza zza2 = new com.google.android.gms.internal.zzqh.zza();
            zza2.zzaTt = this.zzaOX;
            zza2.zziR = new com.google.android.gms.internal.zzaf.zzf();
            zza2.zzaTu = zzj;
            this.zzaPk.zzb(zza2);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r8.zzaPn != false) goto L_0x000a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void zza(com.google.android.gms.internal.zzaf.zzj r9, long r10, boolean r12) {
        /*
            r8 = this;
            r6 = 43200000(0x2932e00, double:2.1343636E-316)
            monitor-enter(r8)
            if (r12 == 0) goto L_0x000c
            boolean r0 = r8.zzaPn     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x000c
        L_0x000a:
            monitor-exit(r8)
            return
        L_0x000c:
            boolean r0 = r8.isReady()     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.tagmanager.zzo r0 = r8.zzaPm     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0016
        L_0x0016:
            r8.zzaPo = r9     // Catch:{ all -> 0x006a }
            r8.zzaOX = r10     // Catch:{ all -> 0x006a }
            r0 = 0
            r2 = 43200000(0x2932e00, double:2.1343636E-316)
            long r4 = r8.zzaOX     // Catch:{ all -> 0x006a }
            long r4 = r4 + r6
            com.google.android.gms.internal.zzlm r6 = r8.zzpO     // Catch:{ all -> 0x006a }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x006a }
            long r4 = r4 - r6
            long r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x006a }
            long r0 = java.lang.Math.max(r0, r2)     // Catch:{ all -> 0x006a }
            r8.zzR(r0)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.Container r0 = new com.google.android.gms.tagmanager.Container     // Catch:{ all -> 0x006a }
            android.content.Context r1 = r8.mContext     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.TagManager r2 = r8.zzaPe     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.DataLayer r2 = r2.getDataLayer()     // Catch:{ all -> 0x006a }
            java.lang.String r3 = r8.zzaOS     // Catch:{ all -> 0x006a }
            r4 = r10
            r6 = r9
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.zzo r1 = r8.zzaPm     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x006d
            com.google.android.gms.tagmanager.zzo r1 = new com.google.android.gms.tagmanager.zzo     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.TagManager r2 = r8.zzaPe     // Catch:{ all -> 0x006a }
            android.os.Looper r3 = r8.zzYV     // Catch:{ all -> 0x006a }
            com.google.android.gms.tagmanager.zzp$zzd r4 = r8.zzaPh     // Catch:{ all -> 0x006a }
            r1.<init>(r2, r3, r0, r4)     // Catch:{ all -> 0x006a }
            r8.zzaPm = r1     // Catch:{ all -> 0x006a }
        L_0x0056:
            boolean r1 = r8.isReady()     // Catch:{ all -> 0x006a }
            if (r1 != 0) goto L_0x000a
            com.google.android.gms.tagmanager.zzp$zza r1 = r8.zzaPr     // Catch:{ all -> 0x006a }
            boolean r0 = r1.zzb(r0)     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x000a
            com.google.android.gms.tagmanager.zzo r0 = r8.zzaPm     // Catch:{ all -> 0x006a }
            r8.zza(r0)     // Catch:{ all -> 0x006a }
            goto L_0x000a
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x006d:
            com.google.android.gms.tagmanager.zzo r1 = r8.zzaPm     // Catch:{ all -> 0x006a }
            r1.zza(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0056
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzp.zza(com.google.android.gms.internal.zzaf$zzj, long, boolean):void");
    }

    private void zzar(final boolean z) {
        this.zzaPk.zza(new zzb());
        this.zzaPq.zza(new zzc());
        com.google.android.gms.internal.zzqp.zzc zzjc = this.zzaPk.zzjc(this.zzaPj);
        if (zzjc != null) {
            this.zzaPm = new zzo(this.zzaPe, this.zzYV, new Container(this.mContext, this.zzaPe.getDataLayer(), this.zzaOS, 0, zzjc), this.zzaPh);
        }
        this.zzaPr = new zza() {
            public boolean zzb(Container container) {
                return z ? container.getLastRefreshTime() + 43200000 >= zzp.this.zzpO.currentTimeMillis() : !container.isDefault();
            }
        };
        if (zzzK()) {
            this.zzaPq.zzf(0, "");
        } else {
            this.zzaPk.zzzM();
        }
    }

    /* access modifiers changed from: private */
    public boolean zzzK() {
        zzcb zzAv = zzcb.zzAv();
        return (zzAv.zzAw() == zza.CONTAINER || zzAv.zzAw() == zza.CONTAINER_DEBUG) && this.zzaOS.equals(zzAv.getContainerId());
    }

    public void load(final String resourceIdParameterName) {
        this.zzaPl.zza(this.zzaOS, this.zzaPj != -1 ? Integer.valueOf(this.zzaPj) : null, resourceIdParameterName, new com.google.android.gms.internal.zzqk.zza() {
            public void zza(zzqo zzqo) {
                if (zzqo.getStatus() != Status.zzaaD) {
                    zzbg.m28e("Load request failed for the container " + zzp.this.zzaOS);
                    zzp.this.zza(zzp.this.zzb(Status.zzaaF));
                    return;
                }
                com.google.android.gms.internal.zzqp.zzc zzBA = zzqo.zzBw().zzBA();
                if (zzBA == null) {
                    String str = "Response doesn't have the requested container";
                    zzbg.m28e(str);
                    zzp.this.zza(zzp.this.zzb(new Status(8, str, null)));
                    return;
                }
                zzp.this.zzaPm = new zzo(zzp.this.zzaPe, zzp.this.zzYV, new Container(zzp.this.mContext, zzp.this.zzaPe.getDataLayer(), zzp.this.zzaOS, zzqo.zzBw().zzBB(), zzBA), new com.google.android.gms.tagmanager.zzo.zza() {
                    public void zzey(String str) {
                        zzp.this.zzey(str);
                    }

                    public String zzzE() {
                        return zzp.this.zzzE();
                    }

                    public void zzzG() {
                        if (zzp.this.zzaPi.zzkp()) {
                            zzp.this.load(resourceIdParameterName);
                        }
                    }
                });
                zzp.this.zza(zzp.this.zzaPm);
            }
        });
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbg */
    public ContainerHolder zzb(Status status) {
        if (this.zzaPm != null) {
            return this.zzaPm;
        }
        if (status == Status.zzaaG) {
            zzbg.m28e("timer expired: setting result to failure");
        }
        return new zzo(status);
    }

    /* access modifiers changed from: 0000 */
    public synchronized void zzey(String str) {
        this.zzaPp = str;
        if (this.zzaPq != null) {
            this.zzaPq.zzeB(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public synchronized String zzzE() {
        return this.zzaPp;
    }

    public void zzzH() {
        com.google.android.gms.internal.zzqp.zzc zzjc = this.zzaPk.zzjc(this.zzaPj);
        if (zzjc != null) {
            zza(new zzo(this.zzaPe, this.zzYV, new Container(this.mContext, this.zzaPe.getDataLayer(), this.zzaOS, 0, zzjc), new com.google.android.gms.tagmanager.zzo.zza() {
                public void zzey(String str) {
                    zzp.this.zzey(str);
                }

                public String zzzE() {
                    return zzp.this.zzzE();
                }

                public void zzzG() {
                    zzbg.zzaE("Refresh ignored: container loaded as default only.");
                }
            }));
        } else {
            String str = "Default was requested, but no default container was found";
            zzbg.m28e(str);
            zza(zzb(new Status(10, str, null)));
        }
        this.zzaPq = null;
        this.zzaPk = null;
    }

    public void zzzI() {
        zzar(false);
    }

    public void zzzJ() {
        zzar(true);
    }
}
