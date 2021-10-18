package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.People.LoadPeopleResult;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzpr implements People {

    private static abstract class zza extends com.google.android.gms.plus.Plus.zza<LoadPeopleResult> {
        private zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaZ */
        public LoadPeopleResult zzb(final Status status) {
            return new LoadPeopleResult() {
                public String getNextPageToken() {
                    return null;
                }

                public PersonBuffer getPersonBuffer() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    public Person getCurrentPerson(GoogleApiClient googleApiClient) {
        return Plus.zzf(googleApiClient, true).zzyI();
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final Collection<String> personIds) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zza((zzb<LoadPeopleResult>) this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> load(GoogleApiClient googleApiClient, final String... personIds) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzd(this, personIds);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadConnected(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zze.zzl(this);
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final int orderBy, final String pageToken) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zza(zze.zza(this, orderBy, pageToken));
            }
        });
    }

    public PendingResult<LoadPeopleResult> loadVisible(GoogleApiClient googleApiClient, final String pageToken) {
        return googleApiClient.zza(new zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zze zze) {
                zza(zze.zzq(this, pageToken));
            }
        });
    }
}
