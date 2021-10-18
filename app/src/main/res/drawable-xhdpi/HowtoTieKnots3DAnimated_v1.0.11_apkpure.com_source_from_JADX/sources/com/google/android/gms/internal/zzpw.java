package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.safetynet.SafetyNetApi.AttestationResult;
import com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult;
import java.util.List;

public class zzpw implements SafetyNetApi {

    static class zza implements AttestationResult {
        private final Status zzQA;
        private final AttestationData zzaNH;

        public zza(Status status, AttestationData attestationData) {
            this.zzQA = status;
            this.zzaNH = attestationData;
        }

        public String getJwsResult() {
            if (this.zzaNH == null) {
                return null;
            }
            return this.zzaNH.getJwsResult();
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    static abstract class zzb extends zzpt<AttestationResult> {
        protected zzpu zzaNI = new zzps() {
            public void zza(Status status, AttestationData attestationData) {
                zzb.this.zza(new zza(status, attestationData));
            }
        };

        public zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzba */
        public AttestationResult zzb(Status status) {
            return new zza(status, null);
        }
    }

    static abstract class zzc extends zzpt<SafeBrowsingResult> {
        protected zzpu zzaNI = new zzps() {
            public void zza(Status status, SafeBrowsingData safeBrowsingData) {
                zzc.this.zza(new zzd(status, safeBrowsingData));
            }
        };

        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzbb */
        public SafeBrowsingResult zzb(Status status) {
            return new zzd(status, null);
        }
    }

    static class zzd implements SafeBrowsingResult {
        private Status zzQA;
        private String zzaNB = null;
        private final SafeBrowsingData zzaNL;

        public zzd(Status status, SafeBrowsingData safeBrowsingData) {
            this.zzQA = status;
            this.zzaNL = safeBrowsingData;
            if (this.zzaNL != null) {
                this.zzaNB = this.zzaNL.getMetadata();
            } else {
                this.zzQA = new Status(8);
            }
        }

        public String getMetadata() {
            return this.zzaNB;
        }

        public Status getStatus() {
            return this.zzQA;
        }
    }

    public PendingResult<AttestationResult> attest(GoogleApiClient googleApiClient, final byte[] nonce) {
        return googleApiClient.zza(new zzb(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzpx zzpx) throws RemoteException {
                zzpx.zza(this.zzaNI, nonce);
            }
        });
    }

    public PendingResult<SafeBrowsingResult> lookupUri(GoogleApiClient googleApiClient, final List<Integer> threatTypes, final String uri) {
        if (threatTypes == null) {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        } else if (!TextUtils.isEmpty(uri)) {
            return googleApiClient.zza(new zzc(googleApiClient) {
                /* access modifiers changed from: protected */
                public void zza(zzpx zzpx) throws RemoteException {
                    zzpx.zza(this.zzaNI, threatTypes, 1, uri);
                }
            });
        } else {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        }
    }
}
