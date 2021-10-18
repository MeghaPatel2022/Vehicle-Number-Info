package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.app.FragmentManager;
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
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzri;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment extends Fragment {
    /* access modifiers changed from: private */
    public boolean mCreated = false;
    /* access modifiers changed from: private */
    public zzb zzaXM;
    /* access modifiers changed from: private */
    public final zzh zzaXN = zzh.zza(this);
    private final zzc zzaXO = new zzc();
    /* access modifiers changed from: private */
    public zza zzaXP = new zza(this);
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
    public final Fragment zzadh = this;

    public interface OnStateChangedListener {
        void onStateChanged(SupportWalletFragment supportWalletFragment, int i, int i2, Bundle bundle);
    }

    static class zza extends com.google.android.gms.internal.zzrb.zza {
        private OnStateChangedListener zzaXV;
        private final SupportWalletFragment zzaXW;

        zza(SupportWalletFragment supportWalletFragment) {
            this.zzaXW = supportWalletFragment;
        }

        public void zza(int i, int i2, Bundle bundle) {
            if (this.zzaXV != null) {
                this.zzaXV.onStateChanged(this.zzaXW, i, i2, bundle);
            }
        }

        public void zza(OnStateChangedListener onStateChangedListener) {
            this.zzaXV = onStateChangedListener;
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
            FragmentActivity activity = SupportWalletFragment.this.zzadh.getActivity();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity), activity, -1);
        }

        /* access modifiers changed from: protected */
        public void zza(FrameLayout frameLayout) {
            Button button = new Button(SupportWalletFragment.this.zzadh.getActivity());
            button.setText(C0224R.string.wallet_buy_button_place_holder);
            int i = -1;
            int i2 = -2;
            if (SupportWalletFragment.this.zzaXQ != null) {
                WalletFragmentStyle fragmentStyle = SupportWalletFragment.this.zzaXQ.getFragmentStyle();
                if (fragmentStyle != null) {
                    DisplayMetrics displayMetrics = SupportWalletFragment.this.zzadh.getResources().getDisplayMetrics();
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
            FragmentActivity activity = SupportWalletFragment.this.zzadh.getActivity();
            if (SupportWalletFragment.this.zzaXM == null && SupportWalletFragment.this.mCreated && activity != null) {
                try {
                    SupportWalletFragment.this.zzaXM = new zzb(zzri.zza(activity, SupportWalletFragment.this.zzaXN, SupportWalletFragment.this.zzaXQ, SupportWalletFragment.this.zzaXP));
                    SupportWalletFragment.this.zzaXQ = null;
                    zzf.zza(SupportWalletFragment.this.zzaXM);
                    if (SupportWalletFragment.this.zzaXR != null) {
                        SupportWalletFragment.this.zzaXM.initialize(SupportWalletFragment.this.zzaXR);
                        SupportWalletFragment.this.zzaXR = null;
                    }
                    if (SupportWalletFragment.this.zzaXS != null) {
                        SupportWalletFragment.this.zzaXM.updateMaskedWalletRequest(SupportWalletFragment.this.zzaXS);
                        SupportWalletFragment.this.zzaXS = null;
                    }
                    if (SupportWalletFragment.this.zzaXT != null) {
                        SupportWalletFragment.this.zzaXM.updateMaskedWallet(SupportWalletFragment.this.zzaXT);
                        SupportWalletFragment.this.zzaXT = null;
                    }
                    if (SupportWalletFragment.this.zzaXU != null) {
                        SupportWalletFragment.this.zzaXM.setEnabled(SupportWalletFragment.this.zzaXU.booleanValue());
                        SupportWalletFragment.this.zzaXU = null;
                    }
                } catch (GooglePlayServicesNotAvailableException e) {
                }
            }
        }
    }

    public static SupportWalletFragment newInstance(WalletFragmentOptions options) {
        SupportWalletFragment supportWalletFragment = new SupportWalletFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("extraWalletFragmentOptions", options);
        supportWalletFragment.zzadh.setArguments(bundle);
        return supportWalletFragment;
    }

    public int getState() {
        if (this.zzaXM != null) {
            return this.zzaXM.getState();
        }
        return 0;
    }

    public void initialize(WalletFragmentInitParams initParams) {
        if (this.zzaXM != null) {
            this.zzaXM.initialize(initParams);
            this.zzaXR = null;
        } else if (this.zzaXR == null) {
            this.zzaXR = initParams;
            if (this.zzaXS != null) {
                Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
            }
            if (this.zzaXT != null) {
                Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
            }
        } else {
            Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (this.zzaXM != null) {
            this.zzaXM.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
            WalletFragmentInitParams walletFragmentInitParams = (WalletFragmentInitParams) savedInstanceState.getParcelable("walletFragmentInitParams");
            if (walletFragmentInitParams != null) {
                if (this.zzaXR != null) {
                    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
        } else if (this.zzadh.getArguments() != null) {
            WalletFragmentOptions walletFragmentOptions = (WalletFragmentOptions) this.zzadh.getArguments().getParcelable("extraWalletFragmentOptions");
            if (walletFragmentOptions != null) {
                walletFragmentOptions.zzaS(this.zzadh.getActivity());
                this.zzaXQ = walletFragmentOptions;
            }
        }
        this.mCreated = true;
        this.zzaXO.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaXO.onCreateView(inflater, container, savedInstanceState);
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
        this.zzaXO.onInflate(activity, bundle, savedInstanceState);
    }

    public void onPause() {
        super.onPause();
        this.zzaXO.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaXO.onResume();
        FragmentManager supportFragmentManager = this.zzadh.getActivity().getSupportFragmentManager();
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(GooglePlayServicesUtil.GMS_ERROR_DIALOG);
        if (findFragmentByTag != null) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
            GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzadh.getActivity()), this.zzadh.getActivity(), -1);
        }
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.setClassLoader(WalletFragmentOptions.class.getClassLoader());
        this.zzaXO.onSaveInstanceState(outState);
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
        this.zzaXO.onStart();
    }

    public void onStop() {
        super.onStop();
        this.zzaXO.onStop();
    }

    public void setEnabled(boolean enabled) {
        if (this.zzaXM != null) {
            this.zzaXM.setEnabled(enabled);
            this.zzaXU = null;
            return;
        }
        this.zzaXU = Boolean.valueOf(enabled);
    }

    public void setOnStateChangedListener(OnStateChangedListener listener) {
        this.zzaXP.zza(listener);
    }

    public void updateMaskedWallet(MaskedWallet maskedWallet) {
        if (this.zzaXM != null) {
            this.zzaXM.updateMaskedWallet(maskedWallet);
            this.zzaXT = null;
            return;
        }
        this.zzaXT = maskedWallet;
    }

    public void updateMaskedWalletRequest(MaskedWalletRequest request) {
        if (this.zzaXM != null) {
            this.zzaXM.updateMaskedWalletRequest(request);
            this.zzaXS = null;
            return;
        }
        this.zzaXS = request;
    }
}
