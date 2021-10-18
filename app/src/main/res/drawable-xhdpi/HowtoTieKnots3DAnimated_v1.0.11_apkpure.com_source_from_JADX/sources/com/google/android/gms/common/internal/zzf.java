package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.signin.zze;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzf {
    private final Account zzOY;
    private final String zzQl;
    private final Set<Scope> zzYY;
    private final int zzYZ;
    private final View zzZa;
    private final String zzZb;
    private final Set<Scope> zzadc;
    private final Map<Api<?>, zza> zzadd;
    private final zze zzade;
    private Integer zzadf;

    public static final class zza {
        public final Set<Scope> zzZp;
        public final boolean zzadg;

        public zza(Set<Scope> set, boolean z) {
            zzx.zzv(set);
            this.zzZp = Collections.unmodifiableSet(set);
            this.zzadg = z;
        }
    }

    public zzf(Account account, Set<Scope> set, Map<Api<?>, zza> map, int i, View view, String str, String str2, zze zze) {
        this.zzOY = account;
        this.zzYY = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        if (map == null) {
            map = Collections.EMPTY_MAP;
        }
        this.zzadd = map;
        this.zzZa = view;
        this.zzYZ = i;
        this.zzQl = str;
        this.zzZb = str2;
        this.zzade = zze;
        HashSet hashSet = new HashSet(this.zzYY);
        for (zza zza2 : this.zzadd.values()) {
            hashSet.addAll(zza2.zzZp);
        }
        this.zzadc = Collections.unmodifiableSet(hashSet);
    }

    public static zzf zzaj(Context context) {
        return new Builder(context).zzni();
    }

    public Account getAccount() {
        return this.zzOY;
    }

    @Deprecated
    public String getAccountName() {
        if (this.zzOY != null) {
            return this.zzOY.name;
        }
        return null;
    }

    public void zza(Integer num) {
        this.zzadf = num;
    }

    public Set<Scope> zzb(Api<?> api) {
        zza zza2 = (zza) this.zzadd.get(api);
        if (zza2 == null || zza2.zzZp.isEmpty()) {
            return this.zzYY;
        }
        HashSet hashSet = new HashSet(this.zzYY);
        hashSet.addAll(zza2.zzZp);
        return hashSet;
    }

    public Account zzog() {
        return this.zzOY != null ? this.zzOY : new Account("<<default account>>", GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
    }

    public int zzoh() {
        return this.zzYZ;
    }

    public Set<Scope> zzoi() {
        return this.zzYY;
    }

    public Set<Scope> zzoj() {
        return this.zzadc;
    }

    public Map<Api<?>, zza> zzok() {
        return this.zzadd;
    }

    public String zzol() {
        return this.zzQl;
    }

    public String zzom() {
        return this.zzZb;
    }

    public View zzon() {
        return this.zzZa;
    }

    public zze zzoo() {
        return this.zzade;
    }

    public Integer zzop() {
        return this.zzadf;
    }
}
