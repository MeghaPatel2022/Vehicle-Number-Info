package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.C0224R;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment extends Fragment {
    /* access modifiers changed from: private */
    public boolean mCreated = false;
    /* access modifiers changed from: private */
    public WalletFragmentOptions zzaXQ;
    /* access modifiers changed from: private */
    public WalletFragmentInitParams zzaXR;
    /* access modifiers changed from: private */
    public MaskedWalletRequest zzaXS;
    /* access modifiers changed from: private */
    public MaskedWallet zzaXT;
    /* access modifiers changed from: private */
    public Boolean zzaXU;
    /* access modifiers changed from: private */
    public zzb zzaXZ;
    /* access modifiers changed from: private */
    public final com.google.android.gms.dynamic.zzb zzaYa = com.google.android.gms.dynamic.zzb.zza(this);
    private final zzc zzaYb = new zzc();
    /* access modifiers changed from: private */
    public zza zzaYc = new zza(this);
    /* access modifiers changed from: private */
    public final Fragment zzamZ = this;

    public interface OnStateChangedListener {
        void onStateChanged(WalletFragment walletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends com.google.android.gms.internal.zzrb.zza {
        private OnStateChangedListener zzaYd;
        private final WalletFragment zzaYe;

        zza(WalletFragment walletFragment) {
            this.zzaYe = walletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaYd != null) {
                this.zzaYd.onStateChanged(this.zzaYe, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaYd = onStateChangedListener;
        }
    }

    private static class zzb implements LifecycleDelegate {
        private final zzra zzaXX;

        private zzb(zzra zzra) {
            this.zzaXX = zzra;
        }

        /* access modifiers changed from: private */
        public int getState() {
            try {
                return this.zzaXX.getState();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void initialize(WalletFragmentInitParams startParams) {
            try {
                this.zzaXX.initialize(startParams);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            try {
                this.zzaXX.onActivityResult(requestCode, resultCode, data);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void setEnabled(boolean enabled) {
            try {
                this.zzaXX.setEnabled(enabled);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void updateMaskedWallet(MaskedWallet maskedWallet) {
            try {
                this.zzaXX.updateMaskedWallet(maskedWallet);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: private */
        public void updateMaskedWalletRequest(MaskedWalletRequest request) {
            try {
                this.zzaXX.updateMaskedWalletRequest(request);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            try {
                this.zzaXX.onCreate(savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzaXX.onCreateView(zze.zzx(inflater), zze.zzx(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onDestroy() {
        }

        public void onDestroyView() {
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaXX.zza(zze.zzx(activity), (WalletFragmentOptions) attrs.getParcelable("extraWalletFragmentOptions"), savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onLowMemory() {
        }

        public void onPause() {
            try {
                this.zzaXX.onPause();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaXX.onResume();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaXX.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onStart() {
            try {
                this.zzaXX.onStart();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }

        public void onStop() {
            try {
                this.zzaXX.onStop();
            } catch (RemoteException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class zzc extends com.google.android.gms.dynamic.zza<zzb> implements OnClickListener {
        private zzc() {
        }

        public void onClick(View view) {
            Activity activity = WalletFragment.this.zzamZ.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        /* access modifiers changed from: protected */
        public void zza(FrameLayout frameLayout) {
            Button button = new Button(WalletFragment.this.zzamZ.getActivity());
            button.setText(C0224R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (WalletFragment.this.zzaXQ != null) {
                WalletFragmentStyle fragmentStyle = WalletFragment.this.zzaXQ.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = WalletFragment.this.zzamZ.getResources().getDisplayMetrics();
                    i = fragmentStyle.zza("buyButtonWidth", displayMetrics, -1);
                    i2 = fragmentStyle.zza("buyButtonHeight", displayMetrics, -2);
                }
            }
            button.setLayoutParams(new LayoutParams(i, i2));
            button.setOnClickListener(this);
            frameLayout.addView(button);
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<zzb> zzf) {
            Activity activity = WalletFragment.this.zzamZ.getActivity();
            if (WalletFragment.this.zzaXZ == null && WalletFragment.this.mCreated && activity != null) {
                try {
                    WalletFragment.this.zzaXZ = new zzb(zzri.zza(activity, WalletFragment.this.zzaYa, WalletFragment.this.zzaXQ, WalletFragment.this.zzaYc));
                    WalletFragment.this.zzaXQ = null;
                    zzf.zza(WalletFragment.this.zzaXZ);
                    if (WalletFragment.this.zzaXR != null) {
                        WalletFragment.this.zzaXZ.initialize(WalletFragment.this.zzaXR);
                        WalletFragment.this.zzaXR = null;
                    }
                    if (WalletFragment.this.zzaXS != null) {
                        WalletFragment.this.zzaXZ.updateMaskedWalletRequest(WalletFragment.this.zzaXS);
                        WalletFragment.this.zzaXS = null;
                    }
                    if (WalletFragment.this.zzaXT != null) {
                        WalletFragment.this.zzaXZ.updateMaskedWallet(WalletFragment.this.zzaXT);
                        WalletFragment.this.zzaXT = null;
                    }
                    if (WalletFragment.this.zzaXU != null) {
                        WalletFragment.this.zzaXZ.setEnabled(WalletFragment.this.zzaXU.booleanValue());
                        WalletFragment.this.zzaXU = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static WalletFragment newInstance(WalletFragmentOptions options) {
        WalletFragment walletFragment = new WalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        walletFragment.zzamZ.setArguments(bundle);
        return walletFragment;
    }

    public int getState() {
        if (this.zzaXZ != null) {
            return this.zzaXZ.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaXZ != null) {
            this.zzaXZ.initialize(initParams);
            this.zzaXR = null;
        } else if (this.zzaXR == null) {
            this.zzaXR = initParams;
            if (this.zzaXS != null) {
                Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaXT != null) {
                Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaXZ != null) {
            this.zzaXZ.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaXR != null) {
                    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
                }
                this.zzaXR = walletFragmentInitParams;
            }
            if (this.zzaXS == null) {
                this.zzaXS = (MaskedWalletRequest) savedInstanceState.getParcelable("maskedWalletRequest");
            }
            if (this.zzaXT == null) {
                this.zzaXT = (MaskedWallet) savedInstanceState.getParcelable("maskedWallet");
            }
            if (savedInstanceState.containsKey("walletFragmentOptions")) {
                this.zzaXQ = (WalletFragmentOptions) savedInstanceState.getParcelable("walletFragmentOptions");
            }
            if (savedInstanceState.containsKey("enabled")) {
                this.zzaXU = Boolean.valueOf(savedInstanceState.getBoolean("enabled"));
            }
        } else if (this.zzamZ.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzamZ.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzaS(this.zzamZ.getActivity());
                this.zzaXQ = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaYb.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaYb.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        super.onDestroy();
        this.mCreated = false;
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        if (this.zzaXQ == null) {
            this.zzaXQ = WalletFragmentOptions.zza((Context) activity, attrs);
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("attrKeyWalletFragmentOptions", this.zzaXQ);
        this.zzaYb.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaYb.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaYb.onResume();
        FragmentManager fragmentManager = this.zzamZ.getActivity().getFragmentManager();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            fragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzamZ.getActivity()), this.zzamZ.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaYb.onSaveInstanceState(outState);
        if (this.zzaXR != null) {
            outState.putParcelable("walletFragmentInitParams", this.zzaXR);
            this.zzaXR = null;
        }
        if (this.zzaXS != null) {
            outState.putParcelable("maskedWalletRequest", this.zzaXS);
            this.zzaXS = null;
        }
        if (this.zzaXT != null) {
            outState.putParcelable("maskedWallet", this.zzaXT);
            this.zzaXT = null;
        }
        if (this.zzaXQ != null) {
            outState.putParcelable("walletFragmentOptions", this.zzaXQ);
            this.zzaXQ = null;
        }
        if (this.zzaXU != null) {
            outState.putBoolean("enabled", this.zzaXU.booleanValue());
            this.zzaXU = null;
        }
    }

    public void onStart() {
        super.onStart();
        this.zzaYb.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaYb.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaXZ != null) {
            this.zzaXZ.setEnabled(enabled);
            this.zzaXU = null;
            return;
        }
        this.zzaXU = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaYc.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaXZ != null) {
            this.zzaXZ.updateMaskedWallet(maskedWallet);
            this.zzaXT = null;
            return;
        }
        this.zzaXT = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaXZ != null) {
            this.zzaXZ.updateMaskedWalletRequest(request);
            this.zzaXS = null;
            return;
        }
        this.zzaXS = request;
    }
}
