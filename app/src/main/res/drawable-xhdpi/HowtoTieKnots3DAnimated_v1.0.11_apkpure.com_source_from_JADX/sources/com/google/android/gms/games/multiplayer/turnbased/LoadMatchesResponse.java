package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse {
    private final TurnBasedMatchBuffer zzayA;
    private final TurnBasedMatchBuffer zzayB;
    private final InvitationBuffer zzayy;
    private final TurnBasedMatchBuffer zzayz;

    public LoadMatchesResponse(Bundle matchData) {
        DataHolder zza = zza(matchData, 0);
        if (zza != null) {
            this.zzayy = new InvitationBuffer(zza);
        } else {
            this.zzayy = null;
        }
        DataHolder zza2 = zza(matchData, 1);
        if (zza2 != null) {
            this.zzayz = new TurnBasedMatchBuffer(zza2);
        } else {
            this.zzayz = null;
        }
        DataHolder zza3 = zza(matchData, 2);
        if (zza3 != null) {
            this.zzayA = new TurnBasedMatchBuffer(zza3);
        } else {
            this.zzayA = null;
        }
        DataHolder zza4 = zza(matchData, 3);
        if (zza4 != null) {
            this.zzayB = new TurnBasedMatchBuffer(zza4);
        } else {
            this.zzayB = null;
        }
    }

    private static DataHolder zza(Bundle bundle, int i) {
        String zzfQ = TurnBasedMatchTurnStatus.zzfQ(i);
        if (!bundle.containsKey(zzfQ)) {
            return null;
        }
        return (DataHolder) bundle.getParcelable(zzfQ);
    }

    @Deprecated
    public void close() {
        release();
    }

    public TurnBasedMatchBuffer getCompletedMatches() {
        return this.zzayB;
    }

    public InvitationBuffer getInvitations() {
        return this.zzayy;
    }

    public TurnBasedMatchBuffer getMyTurnMatches() {
        return this.zzayz;
    }

    public TurnBasedMatchBuffer getTheirTurnMatches() {
        return this.zzayA;
    }

    public boolean hasData() {
        if (this.zzayy != null && this.zzayy.getCount() > 0) {
            return true;
        }
        if (this.zzayz != null && this.zzayz.getCount() > 0) {
            return true;
        }
        if (this.zzayA == null || this.zzayA.getCount() <= 0) {
            return this.zzayB != null && this.zzayB.getCount() > 0;
        }
        return true;
    }

    public void release() {
        if (this.zzayy != null) {
            this.zzayy.release();
        }
        if (this.zzayz != null) {
            this.zzayz.release();
        }
        if (this.zzayA != null) {
            this.zzayA.release();
        }
        if (this.zzayB != null) {
            this.zzayB.release();
        }
    }
}
