package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzov;
import com.google.android.gms.internal.zzpd;
import com.google.android.gms.nearby.bootstrap.zza;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzh;
import com.google.android.gms.nearby.messages.internal.zzi;
import com.google.android.gms.nearby.messages.zzc;
import com.google.android.gms.nearby.sharing.zzd;
import com.google.android.gms.nearby.sharing.zze;

public final class Nearby {
    public static final Api<NoOptions> CONNECTIONS_API = new Api<>("Nearby.CONNECTIONS_API", zzpd.zzQg, zzpd.zzQf);
    public static final Connections Connections = new zzpd();
    public static final Api<MessagesOptions> MESSAGES_API = new Api<>("Nearby.MESSAGES_API", zzh.zzQg, zzh.zzQf);
    public static final Messages Messages = new zzh();
    public static final zzc zzaIT = new zzi();
    public static final Api<NoOptions> zzaIU = new Api<>("Nearby.SHARING_API", com.google.android.gms.nearby.sharing.internal.zzh.zzQg, com.google.android.gms.nearby.sharing.internal.zzh.zzQf);
    public static final zzd zzaIV = new com.google.android.gms.nearby.sharing.internal.zzh();
    public static final zze zzaIW = new com.google.android.gms.nearby.sharing.internal.zzi();
    public static final Api<NoOptions> zzaIX = new Api<>("Nearby.BOOTSTRAP_API", zzov.zzQg, zzov.zzQf);
    public static final zza zzaIY = new zzov();

    private Nearby() {
    }
}
