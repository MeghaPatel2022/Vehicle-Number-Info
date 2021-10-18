package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Request;
import com.google.android.gms.appdatasearch.GetRecentContextCall.Response;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appdatasearch.zzk;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.List;

public final class zzjh implements zzk, AppIndexApi {

    @Deprecated
    private static final class zza implements ActionResult {
        private zzjh zzQa;
        private PendingResult<Status> zzQb;
        private Action zzQc;

        zza(zzjh zzjh, PendingResult<Status> pendingResult, Action action) {
            this.zzQa = zzjh;
            this.zzQb = pendingResult;
            this.zzQc = action;
        }

        public PendingResult<Status> end(GoogleApiClient apiClient) {
            String packageName = apiClient.getContext().getPackageName();
            UsageInfo zza = zzjg.zza(this.zzQc, System.currentTimeMillis(), packageName, 2);
            return this.zzQa.zza(apiClient, zza);
        }

        public PendingResult<Status> getPendingResult() {
            return this.zzQb;
        }
    }

    private static abstract class zzb<T extends Result> extends com.google.android.gms.common.api.zzc.zza<T, zzjf> {
        public zzb(GoogleApiClient googleApiClient) {
            super(com.google.android.gms.appdatasearch.zza.zzOO, googleApiClient);
        }

        /* access modifiers changed from: protected */
        public abstract void zza(zzjc zzjc) throws RemoteException;

        /* access modifiers changed from: protected */
        public final void zza(zzjf zzjf) throws RemoteException {
            zza(zzjf.zzlg());
        }
    }

    private static abstract class zzc<T extends Result> extends zzb<Status> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzd */
        public Status zzb(Status status) {
            return status;
        }
    }

    private static final class zzd extends zzje<Status> {
        public zzd(com.google.android.gms.common.api.zzc.zzb<Status> zzb) {
            super(zzb);
        }

        public void zzc(Status status) {
            this.zzPW.zzn(status);
        }
    }

    public static Intent zza(String str, Uri uri) {
        zzb(str, uri);
        List pathSegments = uri.getPathSegments();
        String str2 = (String) pathSegments.get(0);
        Builder builder = new Builder();
        builder.scheme(str2);
        if (pathSegments.size() > 1) {
            builder.authority((String) pathSegments.get(1));
            int i = 2;
            while (true) {
                int i2 = i;
                if (i2 >= pathSegments.size()) {
                    break;
                }
                builder.appendPath((String) pathSegments.get(i2));
                i = i2 + 1;
            }
        }
        builder.encodedQuery(uri.getEncodedQuery());
        builder.encodedFragment(uri.getEncodedFragment());
        return new Intent("android.intent.action.VIEW", builder.build());
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, Action action, int i) {
        return zza(googleApiClient, zzjg.zza(action, System.currentTimeMillis(), googleApiClient.getContext().getPackageName(), i));
    }

    private static void zzb(String str, Uri uri) {
        if (!"android-app".equals(uri.getScheme())) {
            throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
        }
        String host = uri.getHost();
        if (str == null || str.equals(host)) {
            List pathSegments = uri.getPathSegments();
            if (pathSegments.isEmpty() || ((String) pathSegments.get(0)).isEmpty()) {
                throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
            }
            return;
        }
        throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + uri);
    }

    public static void zzi(List<AppIndexingLink> list) {
        if (list != null) {
            for (AppIndexingLink appIndexingLink : list) {
                zzb(null, appIndexingLink.appIndexingUrl);
            }
        }
    }

    public ActionResult action(GoogleApiClient apiClient, Action action) {
        return new zza(this, zza(apiClient, action, 1), action);
    }

    public PendingResult<Status> end(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 2);
    }

    public PendingResult<Status> start(GoogleApiClient apiClient, Action action) {
        return zza(apiClient, action, 1);
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Intent viewIntent, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzi(outLinks);
        return zza(apiClient, new UsageInfo(packageName, viewIntent, title, webUrl, null, outLinks, 1));
    }

    public PendingResult<Status> view(GoogleApiClient apiClient, Activity activity, Uri appIndexingUrl, String title, Uri webUrl, List<AppIndexingLink> outLinks) {
        String packageName = apiClient.getContext().getPackageName();
        zzb(packageName, appIndexingUrl);
        return view(apiClient, activity, zza(packageName, appIndexingUrl), title, webUrl, outLinks);
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Intent viewIntent) {
        return zza(apiClient, new com.google.android.gms.appdatasearch.UsageInfo.zza().zza(UsageInfo.zza(apiClient.getContext().getPackageName(), viewIntent)).zzw(System.currentTimeMillis()).zzam(0).zzan(2).zzlf());
    }

    public PendingResult<Status> viewEnd(GoogleApiClient apiClient, Activity activity, Uri appUri) {
        return viewEnd(apiClient, activity, zza(apiClient.getContext().getPackageName(), appUri));
    }

    public PendingResult<Response> zza(GoogleApiClient googleApiClient, Request request) {
        return googleApiClient.zza(new com.google.android.gms.appdatasearch.GetRecentContextCall.zza(request, googleApiClient));
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, final UsageInfo... usageInfoArr) {
        final String packageName = googleApiClient.getContext().getPackageName();
        return googleApiClient.zza(new zzc<Status>(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzjc zzjc) throws RemoteException {
                zzjc.zza((zzjd) new zzd(this), packageName, usageInfoArr);
            }
        });
    }
}
