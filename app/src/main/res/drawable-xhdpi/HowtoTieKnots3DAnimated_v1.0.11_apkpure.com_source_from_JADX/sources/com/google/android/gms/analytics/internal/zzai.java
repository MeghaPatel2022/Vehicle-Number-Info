package com.google.android.gms.analytics.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import java.util.UUID;

public class zzai extends zzd {
    /* access modifiers changed from: private */
    public SharedPreferences zzOw;
    private long zzOx;
    private long zzOy = -1;
    private final zza zzOz = new zza("monitoring", zzif().zzjQ());

    public final class zza {
        private final String mName;
        private final long zzOA;

        private zza(String str, long j) {
            zzx.zzcs(str);
            zzx.zzZ(j > 0);
            this.mName = str;
            this.zzOA = j;
        }

        private void zzkE() {
            long currentTimeMillis = zzai.this.zzid().currentTimeMillis();
            Editor edit = zzai.this.zzOw.edit();
            edit.remove(zzkJ());
            edit.remove(zzkK());
            edit.putLong(zzkI(), currentTimeMillis);
            edit.commit();
        }

        private long zzkF() {
            long zzkH = zzkH();
            if (zzkH == 0) {
                return 0;
            }
            return Math.abs(zzkH - zzai.this.zzid().currentTimeMillis());
        }

        private long zzkH() {
            return zzai.this.zzOw.getLong(zzkI(), 0);
        }

        private String zzkI() {
            return this.mName + ":start";
        }

        private String zzkJ() {
            return this.mName + ":count";
        }

        public void zzbl(String str) {
            if (zzkH() == 0) {
                zzkE();
            }
            if (str == null) {
                str = "";
            }
            synchronized (this) {
                long j = zzai.this.zzOw.getLong(zzkJ(), 0);
                if (j <= 0) {
                    Editor edit = zzai.this.zzOw.edit();
                    edit.putString(zzkK(), str);
                    edit.putLong(zzkJ(), 1);
                    edit.apply();
                    return;
                }
                boolean z = (UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE) < Long.MAX_VALUE / (j + 1);
                Editor edit2 = zzai.this.zzOw.edit();
                if (z) {
                    edit2.putString(zzkK(), str);
                }
                edit2.putLong(zzkJ(), j + 1);
                edit2.apply();
            }
        }

        public Pair<String, Long> zzkG() {
            long zzkF = zzkF();
            if (zzkF < this.zzOA) {
                return null;
            }
            if (zzkF > this.zzOA * 2) {
                zzkE();
                return null;
            }
            String string = zzai.this.zzOw.getString(zzkK(), null);
            long j = zzai.this.zzOw.getLong(zzkJ(), 0);
            zzkE();
            if (string == null || j <= 0) {
                return null;
            }
            return new Pair<>(string, Long.valueOf(j));
        }

        /* access modifiers changed from: protected */
        public String zzkK() {
            return this.mName + ":value";
        }
    }

    protected zzai(zzf zzf) {
        super(zzf);
    }

    public void zzbk(String str) {
        zzic();
        zzio();
        Editor edit = this.zzOw.edit();
        if (TextUtils.isEmpty(str)) {
            edit.remove("installation_campaign");
        } else {
            edit.putString("installation_campaign", str);
        }
        if (!edit.commit()) {
            zzbb("Failed to commit campaign data");
        }
    }

    /* access modifiers changed from: protected */
    public void zzhB() {
        this.zzOw = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public long zzkA() {
        zzic();
        zzio();
        if (this.zzOy == -1) {
            this.zzOy = this.zzOw.getLong("last_dispatch", 0);
        }
        return this.zzOy;
    }

    public void zzkB() {
        zzic();
        zzio();
        long currentTimeMillis = zzid().currentTimeMillis();
        Editor edit = this.zzOw.edit();
        edit.putLong("last_dispatch", currentTimeMillis);
        edit.apply();
        this.zzOy = currentTimeMillis;
    }

    public String zzkC() {
        zzic();
        zzio();
        String string = this.zzOw.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public zza zzkD() {
        return this.zzOz;
    }

    public long zzky() {
        zzic();
        zzio();
        if (this.zzOx == 0) {
            long j = this.zzOw.getLong("first_run", 0);
            if (j != 0) {
                this.zzOx = j;
            } else {
                long currentTimeMillis = zzid().currentTimeMillis();
                Editor edit = this.zzOw.edit();
                edit.putLong("first_run", currentTimeMillis);
                if (!edit.commit()) {
                    zzbb("Failed to commit first run time");
                }
                this.zzOx = currentTimeMillis;
            }
        }
        return this.zzOx;
    }

    public zzaj zzkz() {
        return new zzaj(zzid(), zzky());
    }
}
