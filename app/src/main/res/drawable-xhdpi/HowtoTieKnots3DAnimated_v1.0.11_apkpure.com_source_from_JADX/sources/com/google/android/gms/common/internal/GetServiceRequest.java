package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzp.zza;
import java.util.Collection;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new zzi();
    final int version;
    final int zzadn;
    int zzado;
    String zzadp;
    IBinder zzadq;
    Scope[] zzadr;
    Bundle zzads;
    Account zzadt;

    public GetServiceRequest(int serviceId) {
        this.version = 2;
        this.zzado = GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzadn = serviceId;
    }

    GetServiceRequest(int version2, int serviceId, int clientVersion, String callingPackage, IBinder accountAccessorBinder, Scope[] scopes, Bundle extraArgs, Account clientRequestedAccount) {
        this.version = version2;
        this.zzadn = serviceId;
        this.zzado = clientVersion;
        this.zzadp = callingPackage;
        if (version2 < 2) {
            this.zzadt = zzaG(accountAccessorBinder);
        } else {
            this.zzadq = accountAccessorBinder;
            this.zzadt = clientRequestedAccount;
        }
        this.zzadr = scopes;
        this.zzads = extraArgs;
    }

    private Account zzaG(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zzb(zza.zzaH(iBinder));
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }

    public GetServiceRequest zzb(Account account) {
        this.zzadt = account;
        return this;
    }

    public GetServiceRequest zzc(zzp zzp) {
        if (zzp != null) {
            this.zzadq = zzp.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzck(String str) {
        this.zzadp = str;
        return this;
    }

    public GetServiceRequest zzd(Collection<Scope> collection) {
        this.zzadr = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzg(Bundle bundle) {
        this.zzads = bundle;
        return this;
    }
}
