package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.support.p000v4.app.LoaderManager;
import android.support.p000v4.app.LoaderManager.LoaderCallbacks;
import android.support.p000v4.content.Loader;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzq extends Fragment implements OnCancelListener, LoaderCallbacks<ConnectionResult> {
    private boolean zzaaJ;
    private int zzaaK = -1;
    private ConnectionResult zzaaL;
    private final Handler zzaaM = new Handler(Looper.getMainLooper());
    private final SparseArray<zzb> zzaaN = new SparseArray<>();

    static class zza extends Loader<ConnectionResult> implements ConnectionCallbacks, OnConnectionFailedListener {
        public final GoogleApiClient zzaaP;
        private boolean zzaaU;
        private ConnectionResult zzaaV;

        public zza(Context context, GoogleApiClient googleApiClient) {
            super(context);
            this.zzaaP = googleApiClient;
        }

        private void zzh(ConnectionResult connectionResult) {
            this.zzaaV = connectionResult;
            if (isStarted() && !isAbandoned()) {
                deliverResult(connectionResult);
            }
        }

        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            super.dump(prefix, fd, writer, args);
            this.zzaaP.dump(prefix, fd, writer, args);
        }

        public void onConnected(Bundle connectionHint) {
            this.zzaaU = false;
            zzh(ConnectionResult.zzYi);
        }

        public void onConnectionFailed(ConnectionResult result) {
            this.zzaaU = true;
            zzh(result);
        }

        public void onConnectionSuspended(int cause) {
        }

        /* access modifiers changed from: protected */
        public void onReset() {
            this.zzaaV = null;
            this.zzaaU = false;
            this.zzaaP.unregisterConnectionCallbacks(this);
            this.zzaaP.unregisterConnectionFailedListener(this);
            this.zzaaP.disconnect();
        }

        /* access modifiers changed from: protected */
        public void onStartLoading() {
            super.onStartLoading();
            this.zzaaP.registerConnectionCallbacks(this);
            this.zzaaP.registerConnectionFailedListener(this);
            if (this.zzaaV != null) {
                deliverResult(this.zzaaV);
            }
            if (!this.zzaaP.isConnected() && !this.zzaaP.isConnecting() && !this.zzaaU) {
                this.zzaaP.connect();
            }
        }

        /* access modifiers changed from: protected */
        public void onStopLoading() {
            this.zzaaP.disconnect();
        }

        public boolean zznL() {
            return this.zzaaU;
        }
    }

    private static class zzb {
        public final GoogleApiClient zzaaP;
        public final OnConnectionFailedListener zzaaQ;

        private zzb(GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.zzaaP = googleApiClient;
            this.zzaaQ = onConnectionFailedListener;
        }
    }

    private class zzc implements Runnable {
        private final int zzaaS;
        private final ConnectionResult zzaaT;

        public zzc(int i, ConnectionResult connectionResult) {
            this.zzaaS = i;
            this.zzaaT = connectionResult;
        }

        public void run() {
            if (this.zzaaT.hasResolution()) {
                try {
                    this.zzaaT.startResolutionForResult(zzq.this.getActivity(), ((zzq.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzq.this) + 1) << 16) + 1);
                } catch (SendIntentException e) {
                    zzq.this.zznJ();
                }
            } else if (GooglePlayServicesUtil.isUserRecoverableError(this.zzaaT.getErrorCode())) {
                GooglePlayServicesUtil.showErrorDialogFragment(this.zzaaT.getErrorCode(), zzq.this.getActivity(), zzq.this, 2, zzq.this);
            } else {
                zzq.this.zza(this.zzaaS, this.zzaaT);
            }
        }
    }

    /* access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLoaderLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zzb zzb2 = (zzb) this.zzaaN.get(i);
        if (zzb2 != null) {
            zzbi(i);
            OnConnectionFailedListener onConnectionFailedListener = zzb2.zzaaQ;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zznJ();
    }

    private void zzb(int i, ConnectionResult connectionResult) {
        if (!this.zzaaJ) {
            this.zzaaJ = true;
            this.zzaaK = i;
            this.zzaaL = connectionResult;
            this.zzaaM.post(new zzc(i, connectionResult));
        }
    }

    public static zzq zzc(FragmentActivity fragmentActivity) {
        zzx.zzch("Must be called from main thread of process");
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        try {
            zzq zzq = (zzq) supportFragmentManager.findFragmentByTag("GmsSupportLoaderLifecycleFragment");
            if (zzq != null && !zzq.isRemoving()) {
                return zzq;
            }
            zzq zzq2 = new zzq();
            supportFragmentManager.beginTransaction().add((Fragment) zzq2, "GmsSupportLoaderLifecycleFragment").commit();
            supportFragmentManager.executePendingTransactions();
            return zzq2;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLoaderLifecycleFragment is not a SupportLoaderLifecycleFragment", e);
        }
    }

    /* access modifiers changed from: private */
    public void zznJ() {
        this.zzaaJ = false;
        this.zzaaK = -1;
        this.zzaaL = null;
        LoaderManager loaderManager = getLoaderManager();
        for (int i = 0; i < this.zzaaN.size(); i++) {
            int keyAt = this.zzaaN.keyAt(i);
            zza zzbk = zzbk(keyAt);
            if (zzbk != null && zzbk.zznL()) {
                loaderManager.destroyLoader(keyAt);
                loaderManager.initLoader(keyAt, null, this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity()) == 0) goto L_0x0006;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0018, code lost:
        if (r5 == -1) goto L_0x0006;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            switch(r4) {
                case 1: goto L_0x0017;
                case 2: goto L_0x000c;
                default: goto L_0x0005;
            }
        L_0x0005:
            r0 = r1
        L_0x0006:
            if (r0 == 0) goto L_0x001b
            r3.zznJ()
        L_0x000b:
            return
        L_0x000c:
            android.support.v4.app.FragmentActivity r2 = r3.getActivity()
            int r2 = com.google.android.gms.common.GooglePlayServicesUtil.isGooglePlayServicesAvailable(r2)
            if (r2 != 0) goto L_0x0005
            goto L_0x0006
        L_0x0017:
            r2 = -1
            if (r5 != r2) goto L_0x0005
            goto L_0x0006
        L_0x001b:
            int r0 = r3.zzaaK
            com.google.android.gms.common.ConnectionResult r1 = r3.zzaaL
            r3.zza(r0, r1)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzq.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzaaN.size()) {
                int keyAt = this.zzaaN.keyAt(i2);
                zza zzbk = zzbk(keyAt);
                if (zzbk == null || ((zzb) this.zzaaN.valueAt(i2)).zzaaP == zzbk.zzaaP) {
                    getLoaderManager().initLoader(keyAt, null, this);
                } else {
                    getLoaderManager().restartLoader(keyAt, null, this);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzaaK, new ConnectionResult(13, null));
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            this.zzaaJ = savedInstanceState.getBoolean("resolving_error", false);
            this.zzaaK = savedInstanceState.getInt("failed_client_id", -1);
            if (this.zzaaK >= 0) {
                this.zzaaL = new ConnectionResult(savedInstanceState.getInt("failed_status"), (PendingIntent) savedInstanceState.getParcelable("failed_resolution"));
            }
        }
    }

    public Loader<ConnectionResult> onCreateLoader(int id, Bundle args) {
        return new zza(getActivity(), ((zzb) this.zzaaN.get(id)).zzaaP);
    }

    public void onLoaderReset(Loader<ConnectionResult> loader) {
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("resolving_error", this.zzaaJ);
        if (this.zzaaK >= 0) {
            outState.putInt("failed_client_id", this.zzaaK);
            outState.putInt("failed_status", this.zzaaL.getErrorCode());
            outState.putParcelable("failed_resolution", this.zzaaL.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        if (!this.zzaaJ) {
            for (int i = 0; i < this.zzaaN.size(); i++) {
                getLoaderManager().initLoader(this.zzaaN.keyAt(i), null, this);
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzx.zza(this.zzaaN.indexOfKey(i) < 0, (Object) "Already managing a GoogleApiClient with id " + i);
        this.zzaaN.put(i, new zzb(googleApiClient, onConnectionFailedListener));
        if (getActivity() != null) {
            LoaderManager.enableDebugLogging(false);
            getLoaderManager().initLoader(i, null, this);
        }
    }

    /* renamed from: zza */
    public void onLoadFinished(Loader<ConnectionResult> loader, ConnectionResult connectionResult) {
        if (!connectionResult.isSuccess()) {
            zzb(loader.getId(), connectionResult);
        }
    }

    public void zzbi(int i) {
        this.zzaaN.remove(i);
        getLoaderManager().destroyLoader(i);
    }

    public GoogleApiClient zzbj(int i) {
        if (getActivity() != null) {
            zza zzbk = zzbk(i);
            if (zzbk != null) {
                return zzbk.zzaaP;
            }
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    public zza zzbk(int i) {
        try {
            return (zza) getLoaderManager().getLoader(i);
        } catch (ClassCastException e) {
            throw new IllegalStateException("Unknown loader in SupportLoaderLifecycleFragment", e);
        }
    }
}
