package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzx;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzp extends Fragment implements OnCancelListener {
    /* access modifiers changed from: private */
    public boolean mStarted;
    /* access modifiers changed from: private */
    public boolean zzaaJ;
    /* access modifiers changed from: private */
    public int zzaaK = -1;
    /* access modifiers changed from: private */
    public ConnectionResult zzaaL;
    /* access modifiers changed from: private */
    public final Handler zzaaM = new Handler(Looper.getMainLooper());
    private final SparseArray<zza> zzaaN = new SparseArray<>();

    private class zza implements OnConnectionFailedListener {
        public final int zzaaO;
        public final GoogleApiClient zzaaP;
        public final OnConnectionFailedListener zzaaQ;

        public zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
            this.zzaaO = i;
            this.zzaaP = googleApiClient;
            this.zzaaQ = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
            writer.append(prefix).append("GoogleApiClient #").print(this.zzaaO);
            writer.println(":");
            this.zzaaP.dump(prefix + "  ", fd, writer, args);
        }

        public void onConnectionFailed(ConnectionResult result) {
            zzp.this.zzaaM.post(new zzb(this.zzaaO, result));
        }

        public void zznK() {
            this.zzaaP.unregisterConnectionFailedListener(this);
            this.zzaaP.disconnect();
        }
    }

    private class zzb implements Runnable {
        private final int zzaaS;
        private final ConnectionResult zzaaT;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzaaS = i;
            this.zzaaT = connectionResult;
        }

        public void run() {
            if (zzp.this.mStarted && !zzp.this.zzaaJ) {
                zzp.this.zzaaJ = true;
                zzp.this.zzaaK = this.zzaaS;
                zzp.this.zzaaL = this.zzaaT;
                if (this.zzaaT.hasResolution()) {
                    try {
                        this.zzaaT.startResolutionForResult(zzp.this.getActivity(), ((zzp.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzp.this) + 1) << 16) + 1);
                    } catch (SendIntentException e) {
                        zzp.this.zznJ();
                    }
                } else if (GooglePlayServicesUtil.isUserRecoverableError(this.zzaaT.getErrorCode())) {
                    GooglePlayServicesUtil.showErrorDialogFragment(this.zzaaT.getErrorCode(), zzp.this.getActivity(), zzp.this, 2, zzp.this);
                } else {
                    zzp.this.zza(this.zzaaS, this.zzaaT);
                }
            }
        }
    }

    public static zzp zza(FragmentActivity fragmentActivity) {
        zzx.zzch("Must be called from main thread of process");
        try {
            zzp zzp = (zzp) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFragment");
            if (zzp == null || zzp.isRemoving()) {
                return null;
            }
            return zzp;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", e);
        }
    }

    /* access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFragment", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zza2 = (zza) this.zzaaN.get(i);
        if (zza2 != null) {
            zzbi(i);
            OnConnectionFailedListener onConnectionFailedListener = zza2.zzaaQ;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zznJ();
    }

    public static zzp zzb(FragmentActivity fragmentActivity) {
        zzp zza2 = zza(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (zza2 != null) {
            return zza2;
        }
        zzp zzp = new zzp();
        supportFragmentManager.beginTransaction().add((Fragment) zzp, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
        supportFragmentManager.executePendingTransactions();
        return zzp;
    }

    /* access modifiers changed from: private */
    public void zznJ() {
        int i = 0;
        this.zzaaJ = false;
        this.zzaaK = -1;
        this.zzaaL = null;
        while (true) {
            int i2 = i;
            if (i2 < this.zzaaN.size()) {
                ((zza) this.zzaaN.valueAt(i2)).zzaaP.connect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        super.dump(prefix, fd, writer, args);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.zzaaN.size()) {
                ((zza) this.zzaaN.valueAt(i2)).dump(prefix, fd, writer, args);
                i = i2 + 1;
            } else {
                return;
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.zzp.onActivityResult(int, int, android.content.Intent):void");
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
        this.mStarted = true;
        if (!this.zzaaJ) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.zzaaN.size()) {
                    ((zza) this.zzaaN.valueAt(i2)).zzaaP.connect();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onStop() {
        int i = 0;
        super.onStop();
        this.mStarted = false;
        while (true) {
            int i2 = i;
            if (i2 < this.zzaaN.size()) {
                ((zza) this.zzaaN.valueAt(i2)).zzaaP.disconnect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzx.zza(this.zzaaN.indexOfKey(i) < 0, (Object) "Already managing a GoogleApiClient with id " + i);
        this.zzaaN.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.zzaaJ) {
            googleApiClient.connect();
        }
    }

    public void zzbi(int i) {
        zza zza2 = (zza) this.zzaaN.get(i);
        this.zzaaN.remove(i);
        if (zza2 != null) {
            zza2.zznK();
        }
    }
}
