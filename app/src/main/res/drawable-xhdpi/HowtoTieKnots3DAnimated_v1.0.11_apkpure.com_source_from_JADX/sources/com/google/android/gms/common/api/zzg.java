package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzg implements zzj {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public com.google.android.gms.signin.zzd zzZA;
    private int zzZB;
    /* access modifiers changed from: private */
    public boolean zzZC;
    private boolean zzZD;
    /* access modifiers changed from: private */
    public zzp zzZE;
    private boolean zzZF;
    private boolean zzZG;
    private final com.google.android.gms.common.internal.zzf zzZH;
    private final Map<Api<?>, Integer> zzZI;
    private ArrayList<Future<?>> zzZJ = new ArrayList<>();
    /* access modifiers changed from: private */
    public final GoogleApiAvailability zzZi;
    private final com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.signin.zzd, com.google.android.gms.signin.zze> zzZj;
    /* access modifiers changed from: private */
    public final zzi zzZq;
    /* access modifiers changed from: private */
    public final Lock zzZs;
    private ConnectionResult zzZt;
    private int zzZu;
    private int zzZv = 0;
    private boolean zzZw = false;
    private int zzZx;
    private final Bundle zzZy = new Bundle();
    private final Set<com.google.android.gms.common.api.Api.zzc> zzZz = new HashSet();

    private static class zza extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzg> zzZL;

        zza(zzg zzg) {
            this.zzZL = new WeakReference<>(zzg);
        }

        public void zza(final ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            final zzg zzg = (zzg) this.zzZL.get();
            if (zzg != null) {
                zzg.zzZq.zza((zzb) new zzb(zzg) {
                    public void zznn() {
                        zzg.zzc(connectionResult);
                    }
                });
            }
        }
    }

    private static class zzb extends com.google.android.gms.common.internal.zzt.zza {
        private final WeakReference<zzg> zzZL;

        zzb(zzg zzg) {
            this.zzZL = new WeakReference<>(zzg);
        }

        public void zzb(final ResolveAccountResponse resolveAccountResponse) {
            final zzg zzg = (zzg) this.zzZL.get();
            if (zzg != null) {
                zzg.zzZq.zza((zzb) new zzb(zzg) {
                    public void zznn() {
                        zzg.zza(resolveAccountResponse);
                    }
                });
            }
        }
    }

    private class zzc extends zzi {
        private zzc() {
            super();
        }

        public void zznn() {
            zzg.this.zzZA.zza(zzg.this.zzZE, zzg.this.zzZq.zzaah, new zza(zzg.this));
        }
    }

    private static class zzd implements com.google.android.gms.common.api.GoogleApiClient.zza {
        private final WeakReference<zzg> zzZL;
        private final Api<?> zzZR;
        private final int zzZS;

        public zzd(zzg zzg, Api<?> api, int i) {
            this.zzZL = new WeakReference<>(zzg);
            this.zzZR = api;
            this.zzZS = i;
        }

        public void zza(ConnectionResult connectionResult) {
            boolean z = false;
            zzg zzg = (zzg) this.zzZL.get();
            if (zzg != null) {
                if (Looper.myLooper() == zzg.zzZq.getLooper()) {
                    z = true;
                }
                zzx.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzg.zzZs.lock();
                try {
                    if (zzg.zzbe(0)) {
                        if (!connectionResult.isSuccess()) {
                            zzg.zzb(connectionResult, this.zzZR, this.zzZS);
                        }
                        if (zzg.zzno()) {
                            zzg.zznp();
                        }
                        zzg.zzZs.unlock();
                    }
                } finally {
                    zzg.zzZs.unlock();
                }
            }
        }

        public void zzb(ConnectionResult connectionResult) {
            boolean z = true;
            zzg zzg = (zzg) this.zzZL.get();
            if (zzg != null) {
                if (Looper.myLooper() != zzg.zzZq.getLooper()) {
                    z = false;
                }
                zzx.zza(z, (Object) "onReportAccountValidation must be called on the GoogleApiClient handler thread");
                zzg.zzZs.lock();
                try {
                    if (zzg.zzbe(1)) {
                        if (!connectionResult.isSuccess()) {
                            zzg.zzb(connectionResult, this.zzZR, this.zzZS);
                        }
                        if (zzg.zzno()) {
                            zzg.zznr();
                        }
                        zzg.zzZs.unlock();
                    }
                } finally {
                    zzg.zzZs.unlock();
                }
            }
        }
    }

    private class zze extends zzi {
        private final Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> zzZT;

        public zze(Map<com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.api.GoogleApiClient.zza> map) {
            super();
            this.zzZT = map;
        }

        public void zznn() {
            int isGooglePlayServicesAvailable = zzg.this.zzZi.isGooglePlayServicesAvailable(zzg.this.mContext);
            if (isGooglePlayServicesAvailable != 0) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
                zzg.this.zzZq.zza((zzb) new zzb(zzg.this) {
                    public void zznn() {
                        zzg.this.zzf(connectionResult);
                    }
                });
                return;
            }
            if (zzg.this.zzZC) {
                zzg.this.zzZA.connect();
            }
            for (com.google.android.gms.common.api.Api.zzb zzb : this.zzZT.keySet()) {
                zzb.zza((com.google.android.gms.common.api.GoogleApiClient.zza) this.zzZT.get(zzb));
            }
        }
    }

    private class zzf extends zzi {
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzZW;

        public zzf(ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            super();
            this.zzZW = arrayList;
        }

        public void zznn() {
            Set<Scope> set = zzg.this.zzZq.zzaah;
            Set<Scope> set2 = set.isEmpty() ? zzg.this.zznw() : set;
            Iterator it = this.zzZW.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(zzg.this.zzZE, set2);
            }
        }
    }

    /* renamed from: com.google.android.gms.common.api.zzg$zzg reason: collision with other inner class name */
    private class C1349zzg implements ConnectionCallbacks, OnConnectionFailedListener {
        private C1349zzg() {
        }

        public void onConnected(Bundle connectionHint) {
            zzg.this.zzZA.zza(new zzb(zzg.this));
        }

        public void onConnectionFailed(ConnectionResult result) {
            zzg.this.zzZs.lock();
            try {
                if (zzg.this.zze(result)) {
                    zzg.this.zznu();
                    zzg.this.zzns();
                } else {
                    zzg.this.zzf(result);
                }
            } finally {
                zzg.this.zzZs.unlock();
            }
        }

        public void onConnectionSuspended(int cause) {
        }
    }

    private class zzh extends zzi {
        private final ArrayList<com.google.android.gms.common.api.Api.zzb> zzZW;

        public zzh(ArrayList<com.google.android.gms.common.api.Api.zzb> arrayList) {
            super();
            this.zzZW = arrayList;
        }

        public void zznn() {
            Iterator it = this.zzZW.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zzb) it.next()).zza(zzg.this.zzZE);
            }
        }
    }

    private abstract class zzi implements Runnable {
        private zzi() {
        }

        public void run() {
            zzg.this.zzZs.lock();
            try {
                if (!Thread.interrupted()) {
                    zznn();
                    zzg.this.zzZs.unlock();
                }
            } catch (RuntimeException e) {
                zzg.this.zzZq.zza(e);
            } finally {
                zzg.this.zzZs.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public abstract void zznn();
    }

    public zzg(zzi zzi2, com.google.android.gms.common.internal.zzf zzf2, Map<Api<?>, Integer> map, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends com.google.android.gms.signin.zzd, com.google.android.gms.signin.zze> zza2, Lock lock, Context context) {
        this.zzZq = zzi2;
        this.zzZH = zzf2;
        this.zzZI = map;
        this.zzZi = googleApiAvailability;
        this.zzZj = zza2;
        this.zzZs = lock;
        this.mContext = context;
    }

    private void zzX(boolean z) {
        if (this.zzZA != null) {
            if (this.zzZA.isConnected() && z) {
                this.zzZA.zzzn();
            }
            this.zzZA.disconnect();
            this.zzZE = null;
        }
    }

    /* access modifiers changed from: private */
    public void zza(ResolveAccountResponse resolveAccountResponse) {
        if (zzbe(0)) {
            ConnectionResult zzoP = resolveAccountResponse.zzoP();
            if (zzoP.isSuccess()) {
                this.zzZE = resolveAccountResponse.zzoO();
                this.zzZD = true;
                this.zzZF = resolveAccountResponse.zzoQ();
                this.zzZG = resolveAccountResponse.zzoR();
                zznp();
            } else if (zze(zzoP)) {
                zznu();
                zznp();
            } else {
                zzf(zzoP);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zzd(connectionResult)) {
            return this.zzZt == null || i < this.zzZu;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zznb().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.zzZt = connectionResult;
                this.zzZu = priority;
            }
        }
        this.zzZq.zzaag.put(api.zznd(), connectionResult);
    }

    /* access modifiers changed from: private */
    public boolean zzbe(int i) {
        if (this.zzZv == i) {
            return true;
        }
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbf(this.zzZv) + " but received callback for step " + zzbf(i));
        zzf(new ConnectionResult(8, null));
        return false;
    }

    private String zzbf(int i) {
        switch (i) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    public void zzc(ConnectionResult connectionResult) {
        if (zzbe(2)) {
            if (connectionResult.isSuccess()) {
                zzns();
            } else if (zze(connectionResult)) {
                zznu();
                zzns();
            } else {
                zzf(connectionResult);
            }
        }
    }

    private boolean zzd(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.zzZi.zzbb(connectionResult.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    public boolean zze(ConnectionResult connectionResult) {
        if (this.zzZB != 2) {
            return this.zzZB == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void zzf(ConnectionResult connectionResult) {
        boolean z = false;
        this.zzZw = false;
        zznv();
        if (!connectionResult.hasResolution()) {
            z = true;
        }
        zzX(z);
        this.zzZq.zzaag.clear();
        this.zzZq.zzg(connectionResult);
        if (!this.zzZq.zznB() || !this.zzZi.zzd(this.mContext, connectionResult.getErrorCode())) {
            this.zzZq.zznE();
            this.zzZq.zzZY.zzj(connectionResult);
        }
        this.zzZq.zzZY.zzoI();
    }

    /* access modifiers changed from: private */
    public boolean zzno() {
        this.zzZx--;
        if (this.zzZx > 0) {
            return false;
        }
        if (this.zzZx < 0) {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            zzf(new ConnectionResult(8, null));
            return false;
        } else if (this.zzZt == null) {
            return true;
        } else {
            zzf(this.zzZt);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void zznp() {
        if (this.zzZx == 0) {
            if (!this.zzZC) {
                zzns();
            } else if (this.zzZD) {
                zznq();
            }
        }
    }

    private void zznq() {
        ArrayList arrayList = new ArrayList();
        this.zzZv = 1;
        this.zzZx = this.zzZq.zzaaf.size();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzZq.zzaaf.keySet()) {
            if (!this.zzZq.zzaag.containsKey(zzc2)) {
                arrayList.add(this.zzZq.zzaaf.get(zzc2));
            } else if (zzno()) {
                zznr();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzZJ.add(zzk.zznF().submit(new zzh(arrayList)));
        }
    }

    /* access modifiers changed from: private */
    public void zznr() {
        this.zzZv = 2;
        this.zzZq.zzaah = zznw();
        this.zzZJ.add(zzk.zznF().submit(new zzc()));
    }

    /* access modifiers changed from: private */
    public void zzns() {
        ArrayList arrayList = new ArrayList();
        this.zzZv = 3;
        this.zzZx = this.zzZq.zzaaf.size();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzZq.zzaaf.keySet()) {
            if (!this.zzZq.zzaag.containsKey(zzc2)) {
                arrayList.add(this.zzZq.zzaaf.get(zzc2));
            } else if (zzno()) {
                zznt();
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzZJ.add(zzk.zznF().submit(new zzf(arrayList)));
        }
    }

    private void zznt() {
        this.zzZq.zznA();
        zzk.zznF().execute(new Runnable() {
            public void run() {
                zzg.this.zzZi.zzac(zzg.this.mContext);
            }
        });
        if (this.zzZA != null) {
            if (this.zzZF) {
                this.zzZA.zza(this.zzZE, this.zzZG);
            }
            zzX(false);
        }
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzZq.zzaag.keySet()) {
            ((com.google.android.gms.common.api.Api.zzb) this.zzZq.zzaaf.get(zzc2)).disconnect();
        }
        if (this.zzZw) {
            this.zzZw = false;
            disconnect();
            return;
        }
        this.zzZq.zzZY.zzh(this.zzZy.isEmpty() ? null : this.zzZy);
    }

    /* access modifiers changed from: private */
    public void zznu() {
        this.zzZC = false;
        this.zzZq.zzaah = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc zzc2 : this.zzZz) {
            if (!this.zzZq.zzaag.containsKey(zzc2)) {
                this.zzZq.zzaag.put(zzc2, new ConnectionResult(17, null));
            }
        }
    }

    private void zznv() {
        Iterator it = this.zzZJ.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.zzZJ.clear();
    }

    /* access modifiers changed from: private */
    public Set<Scope> zznw() {
        HashSet hashSet = new HashSet(this.zzZH.zzoi());
        Map zzok = this.zzZH.zzok();
        for (Api api : zzok.keySet()) {
            if (!this.zzZq.zzaag.containsKey(api.zznd())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzf.zza) zzok.get(api)).zzZp);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.zzZq.zzZY.zzoJ();
        this.zzZq.zzaag.clear();
        this.zzZw = false;
        this.zzZC = false;
        this.zzZt = null;
        this.zzZv = 0;
        this.zzZB = 2;
        this.zzZD = false;
        this.zzZF = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api api : this.zzZI.keySet()) {
            com.google.android.gms.common.api.Api.zzb zzb2 = (com.google.android.gms.common.api.Api.zzb) this.zzZq.zzaaf.get(api.zznd());
            int intValue = ((Integer) this.zzZI.get(api)).intValue();
            boolean z2 = (api.zznb().getPriority() == 1) | z;
            if (zzb2.zzlm()) {
                this.zzZC = true;
                if (intValue < this.zzZB) {
                    this.zzZB = intValue;
                }
                if (intValue != 0) {
                    this.zzZz.add(api.zznd());
                }
            }
            hashMap.put(zzb2, new zzd(this, api, intValue));
            z = z2;
        }
        if (z) {
            this.zzZC = false;
        }
        if (this.zzZC) {
            this.zzZH.zza(Integer.valueOf(this.zzZq.getSessionId()));
            C1349zzg zzg = new C1349zzg();
            this.zzZA = (com.google.android.gms.signin.zzd) this.zzZj.zza(this.mContext, this.zzZq.getLooper(), this.zzZH, this.zzZH.zzoo(), zzg, zzg);
        }
        this.zzZx = this.zzZq.zzaaf.size();
        this.zzZJ.add(zzk.zznF().submit(new zze(hashMap)));
    }

    public void connect() {
        this.zzZw = false;
    }

    public void disconnect() {
        Iterator it = this.zzZq.zzZZ.iterator();
        while (it.hasNext()) {
            zze zze2 = (zze) it.next();
            if (zze2.zzng() != 1) {
                zze2.cancel();
                it.remove();
            }
        }
        this.zzZq.zznx();
        if (this.zzZt != null || this.zzZq.zzZZ.isEmpty()) {
            zznv();
            zzX(true);
            this.zzZq.zzaag.clear();
            this.zzZq.zzg(null);
            this.zzZq.zzZY.zzoI();
            return;
        }
        this.zzZw = true;
    }

    public String getName() {
        return "CONNECTING";
    }

    public void onConnected(Bundle connectionHint) {
        if (zzbe(3)) {
            if (connectionHint != null) {
                this.zzZy.putAll(connectionHint);
            }
            if (zzno()) {
                zznt();
            }
        }
    }

    public void onConnectionSuspended(int cause) {
        zzf(new ConnectionResult(8, null));
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.common.api.zzc.zza<R, A>> T zza(T t) {
        this.zzZq.zzZZ.add(t);
        return t;
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzbe(3)) {
            zzb(connectionResult, api, i);
            if (zzno()) {
                zznt();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.common.api.zzc.zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
