package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzc.zzb;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;

public final class SnapshotsImpl implements Snapshots {

    /* renamed from: com.google.android.gms.games.internal.api.SnapshotsImpl$6 */
    class C07956 extends LoadImpl {
        final /* synthetic */ String zzWg;
        final /* synthetic */ boolean zzaut;
        final /* synthetic */ String zzauv;

        /* access modifiers changed from: protected */
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb<LoadSnapshotsResult>) this, this.zzWg, this.zzauv, this.zzaut);
        }
    }

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {
        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaA */
        public CommitSnapshotResult zzb(final Status status) {
            return new CommitSnapshotResult() {
                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {
        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaB */
        public DeleteSnapshotResult zzb(final Status status) {
            return new DeleteSnapshotResult() {
                public String getSnapshotId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaC */
        public LoadSnapshotsResult zzb(final Status status) {
            return new LoadSnapshotsResult() {
                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.zzbp(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {
        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzaD */
        public OpenSnapshotResult zzb(final Status status) {
            return new OpenSnapshotResult() {
                public String getConflictId() {
                    return null;
                }

                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                public Snapshot getSnapshot() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient apiClient, final Snapshot snapshot, final SnapshotMetadataChange metadataChange) {
        return apiClient.zzb(new CommitImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<CommitSnapshotResult>) this, snapshot, metadataChange);
            }
        });
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient apiClient, final SnapshotMetadata metadata) {
        return apiClient.zzb(new DeleteImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzi((zzb<DeleteSnapshotResult>) this, metadata.getSnapshotId());
            }
        });
    }

    public void discardAndClose(GoogleApiClient apiClient, Snapshot snapshot) {
        Games.zzd(apiClient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzuc();
    }

    public int getMaxDataSize(GoogleApiClient apiClient) {
        return Games.zzd(apiClient).zzub();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient apiClient, String title, boolean allowAddButton, boolean allowDelete, int maxSnapshots) {
        return Games.zzd(apiClient).zza(title, allowAddButton, allowDelete, maxSnapshots);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle extras) {
        if (extras == null || !extras.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) {
            return null;
        }
        return (SnapshotMetadata) extras.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient apiClient, final boolean forceReload) {
        return apiClient.zza(new LoadImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb<LoadSnapshotsResult>) this, forceReload);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata) {
        return open(apiClient, metadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, SnapshotMetadata metadata, int conflictPolicy) {
        return open(apiClient, metadata.getUniqueName(), false, conflictPolicy);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound) {
        return open(apiClient, fileName, createIfNotFound, -1);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient apiClient, String fileName, boolean createIfNotFound, int conflictPolicy) {
        final String str = fileName;
        final boolean z = createIfNotFound;
        final int i = conflictPolicy;
        return apiClient.zzb(new OpenImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<OpenSnapshotResult>) this, str, z, i);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(apiClient, conflictId, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient apiClient, String conflictId, String snapshotId, SnapshotMetadataChange metadataChange, SnapshotContents snapshotContents) {
        final String str = conflictId;
        final String str2 = snapshotId;
        final SnapshotMetadataChange snapshotMetadataChange = metadataChange;
        final SnapshotContents snapshotContents2 = snapshotContents;
        return apiClient.zzb(new OpenImpl(apiClient) {
            /* access modifiers changed from: protected */
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb<OpenSnapshotResult>) this, str, str2, snapshotMetadataChange, snapshotContents2);
            }
        });
    }
}
