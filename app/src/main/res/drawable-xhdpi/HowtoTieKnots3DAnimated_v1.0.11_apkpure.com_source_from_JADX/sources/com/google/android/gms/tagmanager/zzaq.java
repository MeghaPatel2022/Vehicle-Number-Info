package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzaq {
    private final long zzOa;
    private final long zzaQf;
    private final long zzaQg;
    private String zzaQh;

    zzaq(long j, long j2, long j3) {
        this.zzaQf = j;
        this.zzOa = j2;
        this.zzaQg = j3;
    }

    /* access modifiers changed from: 0000 */
    public long zzAe() {
        return this.zzaQf;
    }

    /* access modifiers changed from: 0000 */
    public long zzAf() {
        return this.zzaQg;
    }

    /* access modifiers changed from: 0000 */
    public String zzAg() {
        return this.zzaQh;
    }

    /* access modifiers changed from: 0000 */
    public void zzeK(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.zzaQh = str;
        }
    }
}
