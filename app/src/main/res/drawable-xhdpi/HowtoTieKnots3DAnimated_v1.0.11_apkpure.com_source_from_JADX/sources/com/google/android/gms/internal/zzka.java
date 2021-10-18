package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.proxy.ProxyApi.ProxyResult;
import com.google.android.gms.auth.api.proxy.ProxyRequest;
import com.google.android.gms.auth.api.proxy.ProxyResponse;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.zzx;

public class zzka implements ProxyApi {
    public PendingResult<ProxyResult> performProxyRequest(GoogleApiClient client, final ProxyRequest request) {
        zzx.zzv(client);
        zzx.zzv(request);
        return client.zzb(new zzjz(client) {
            /* access modifiers changed from: protected */
            public void zza(Context context, zzjy zzjy) throws RemoteException {
                zzjy.zza((zzjx) new zzjv() {
                    public void zza(ProxyResponse proxyResponse) {
                        C09891.this.zza(new zzkb(proxyResponse));
                    }
                }, request);
            }
        });
    }
}
