package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.Moments.LoadMomentsResult;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class zze extends zzj<zzd> {
    private Person zzaLo;
    private final PlusSession zzaLp;

    static final class zza implements LoadMomentsResult {
        private final Status zzQA;
        private final String zzaLq;
        private final String zzaLr;
        private final MomentBuffer zzaLs;

        public zza(Status status, DataHolder dataHolder, String str, String str2) {
            this.zzQA = status;
            this.zzaLq = str;
            this.zzaLr = str2;
            this.zzaLs = dataHolder != null ? new MomentBuffer(dataHolder) : null;
        }

        public MomentBuffer getMomentBuffer() {
            return this.zzaLs;
        }

        public String getNextPageToken() {
            return this.zzaLq;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public String getUpdated() {
            return this.zzaLr;
        }

        public void release() {
            if (this.zzaLs != null) {
                this.zzaLs.release();
            }
        }
    }

    static final class zzb implements LoadPeopleResult {
        private final Status zzQA;
        private final String zzaLq;
        private final PersonBuffer zzaLt;

        public zzb(Status status, DataHolder dataHolder, String str) {
            this.zzQA = status;
            this.zzaLq = str;
            this.zzaLt = dataHolder != null ? new PersonBuffer(dataHolder) : null;
        }

        public String getNextPageToken() {
            return this.zzaLq;
        }

        public PersonBuffer getPersonBuffer() {
            return this.zzaLt;
        }

        public Status getStatus() {
            return this.zzQA;
        }

        public void release() {
            if (this.zzaLt != null) {
                this.zzaLt.release();
            }
        }
    }

    static final class zzc extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzaCS;

        public zzc(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            this.zzaCS = zzb;
        }

        public void zzaX(Status status) {
            this.zzaCS.zzn(status);
        }
    }

    static final class zzd extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> zzaCS;

        public zzd(com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> zzb) {
            this.zzaCS = zzb;
        }

        public void zza(DataHolder dataHolder, String str, String str2) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zznP() != null ? (PendingIntent) dataHolder.zznP().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaCS.zzn(new zza(status, dataHolder, str, str2));
        }
    }

    /* renamed from: com.google.android.gms.plus.internal.zze$zze reason: collision with other inner class name */
    static final class C1540zze extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzaCS;

        public C1540zze(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzb) {
            this.zzaCS = zzb;
        }

        public void zza(DataHolder dataHolder, String str) {
            Status status = new Status(dataHolder.getStatusCode(), null, dataHolder.zznP() != null ? (PendingIntent) dataHolder.zznP().getParcelable("pendingIntent") : null);
            if (!status.isSuccess() && dataHolder != null) {
                if (!dataHolder.isClosed()) {
                    dataHolder.close();
                }
                dataHolder = null;
            }
            this.zzaCS.zzn(new zzb(status, dataHolder, str));
        }
    }

    static final class zzf extends zza {
        private final com.google.android.gms.common.api.zzc.zzb<Status> zzaCS;

        public zzf(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            this.zzaCS = zzb;
        }

        public void zzi(int i, Bundle bundle) {
            this.zzaCS.zzn(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        }
    }

    public zze(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzf2, PlusSession plusSession, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 2, zzf2, connectionCallbacks, onConnectionFailedListener);
        this.zzaLp = plusSession;
    }

    public static boolean zzd(Set<Scope> set) {
        if (set == null || set.isEmpty()) {
            return false;
        }
        return set.size() != 1 || !set.contains(new Scope("plus_one_placeholder_scope"));
    }

    private Bundle zzlj() {
        Bundle zzyS = this.zzaLp.zzyS();
        zzyS.putStringArray("request_visible_actions", this.zzaLp.zzyM());
        zzyS.putString("auth_package", this.zzaLp.zzyO());
        return zzyS;
    }

    public String getAccountName() {
        zzoz();
        try {
            return ((zzd) zzoA()).getAccountName();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public zzq zza(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzb2, int i, String str) {
        zzoz();
        C1540zze zze = new C1540zze(zzb2);
        try {
            return ((zzd) zzoA()).zza(zze, 1, i, -1, str);
        } catch (RemoteException e) {
            zze.zza(DataHolder.zzbp(8), null);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (i == 0 && bundle != null && bundle.containsKey("loaded_person")) {
            this.zzaLo = PersonEntity.zzp(bundle.getByteArray("loaded_person"));
        }
        super.zza(i, iBinder, bundle, i2);
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> zzb2, int i, String str, Uri uri, String str2, String str3) {
        zzoz();
        zzd zzd2 = zzb2 != null ? new zzd(zzb2) : null;
        try {
            ((zzd) zzoA()).zza(zzd2, i, str, uri, str2, str3);
        } catch (RemoteException e) {
            zzd2.zza(DataHolder.zzbp(8), null, null);
        }
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<Status> zzb2, Moment moment) {
        zzoz();
        zzc zzc2 = zzb2 != null ? new zzc(zzb2) : null;
        try {
            ((zzd) zzoA()).zza((zzb) zzc2, SafeParcelResponse.zza((MomentEntity) moment));
        } catch (RemoteException e) {
            if (zzc2 == null) {
                throw new IllegalStateException(e);
            }
            zzc2.zzaX(new Status(8, null, null));
        }
    }

    public void zza(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzb2, Collection<String> collection) {
        zzoz();
        C1540zze zze = new C1540zze(zzb2);
        try {
            ((zzd) zzoA()).zza((zzb) zze, (List<String>) new ArrayList<String>(collection));
        } catch (RemoteException e) {
            zze.zza(DataHolder.zzbp(8), null);
        }
    }

    public void zzd(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzb2, String[] strArr) {
        zza(zzb2, (Collection<String>) Arrays.asList(strArr));
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdy */
    public zzd zzV(IBinder iBinder) {
        return com.google.android.gms.plus.internal.zzd.zza.zzdx(iBinder);
    }

    public void zzej(String str) {
        zzoz();
        try {
            ((zzd) zzoA()).zzej(str);
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public String zzfA() {
        return "com.google.android.gms.plus.service.START";
    }

    /* access modifiers changed from: protected */
    public String zzfB() {
        return "com.google.android.gms.plus.internal.IPlusService";
    }

    public void zzk(com.google.android.gms.common.api.zzc.zzb<LoadMomentsResult> zzb2) {
        zza(zzb2, 20, null, null, null, "me");
    }

    public void zzl(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzb2) {
        zzoz();
        C1540zze zze = new C1540zze(zzb2);
        try {
            ((zzd) zzoA()).zza(zze, 2, 1, -1, null);
        } catch (RemoteException e) {
            zze.zza(DataHolder.zzbp(8), null);
        }
    }

    /* access modifiers changed from: protected */
    public Bundle zzli() {
        return zzlj();
    }

    public boolean zzlm() {
        return zzd(zzoy().zzb(Plus.API));
    }

    public void zzm(com.google.android.gms.common.api.zzc.zzb<Status> zzb2) {
        zzoz();
        zzyG();
        zzf zzf2 = new zzf(zzb2);
        try {
            ((zzd) zzoA()).zzb(zzf2);
        } catch (RemoteException e) {
            zzf2.zzi(8, null);
        }
    }

    /* access modifiers changed from: protected */
    public Bundle zzoB() {
        return zzlj();
    }

    public zzq zzq(com.google.android.gms.common.api.zzc.zzb<LoadPeopleResult> zzb2, String str) {
        return zza(zzb2, 0, str);
    }

    public void zzyG() {
        zzoz();
        try {
            this.zzaLo = null;
            ((zzd) zzoA()).zzyG();
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public Person zzyI() {
        zzoz();
        return this.zzaLo;
    }
}
