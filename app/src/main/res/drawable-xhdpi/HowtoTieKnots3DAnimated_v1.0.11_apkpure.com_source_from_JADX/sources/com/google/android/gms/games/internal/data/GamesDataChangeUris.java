package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    public static final Uri zzawA = zzawz.buildUpon().appendPath("invitations").build();
    public static final Uri zzawB = zzawz.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
    private static final Uri zzawz = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
}
