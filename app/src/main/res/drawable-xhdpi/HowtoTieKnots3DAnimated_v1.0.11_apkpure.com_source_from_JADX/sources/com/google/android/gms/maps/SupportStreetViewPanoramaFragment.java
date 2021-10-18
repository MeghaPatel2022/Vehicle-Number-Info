package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p000v4.app.Fragment;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class SupportStreetViewPanoramaFragment extends Fragment {
    private final zzb zzaGJ = new zzb(this);
    private StreetViewPanorama zzaGq;

    static class zza implements StreetViewLifecycleDelegate {
        private final IStreetViewPanoramaFragmentDelegate zzaGr;
        private final Fragment zzadh;

        public zza(Fragment fragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
            this.zzaGr = (IStreetViewPanoramaFragmentDelegate) zzx.zzv(iStreetViewPanoramaFragmentDelegate);
            this.zzadh = (Fragment) zzx.zzv(fragment);
        }

        public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback callback) {
            try {
                this.zzaGr.getStreetViewPanoramaAsync(new com.google.android.gms.maps.internal.zzv.zza() {
                    public void zza(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
                        callback.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
                    }
                });
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onCreate(Bundle savedInstanceState) {
            if (savedInstanceState == null) {
                try {
                    savedInstanceState = new Bundle();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            }
            Bundle arguments = this.zzadh.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                com.google.android.gms.maps.internal.zzx.zza(savedInstanceState, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.zzaGr.onCreate(savedInstanceState);
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            try {
                return (View) zze.zzp(this.zzaGr.onCreateView(zze.zzx(inflater), zze.zzx(container), savedInstanceState));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroy() {
            try {
                this.zzaGr.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onDestroyView() {
            try {
                this.zzaGr.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onInflate(Activity activity, Bundle attrs, Bundle savedInstanceState) {
            try {
                this.zzaGr.onInflate(zze.zzx(activity), null, savedInstanceState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onLowMemory() {
            try {
                this.zzaGr.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onPause() {
            try {
                this.zzaGr.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onResume() {
            try {
                this.zzaGr.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onSaveInstanceState(Bundle outState) {
            try {
                this.zzaGr.onSaveInstanceState(outState);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public void onStart() {
        }

        public void onStop() {
        }

        public IStreetViewPanoramaFragmentDelegate zzwS() {
            return this.zzaGr;
        }
    }

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        protected zzf<zza> zzaFZ;
        private final List<OnStreetViewPanoramaReadyCallback> zzaGu = new ArrayList();
        private final Fragment zzadh;

        zzb(Fragment fragment) {
            this.zzadh = fragment;
        }

        /* access modifiers changed from: private */
        public void setActivity(Activity activity) {
            this.mActivity = activity;
            zzwP();
        }

        public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
            if (zzrn() != null) {
                ((zza) zzrn()).getStreetViewPanoramaAsync(callback);
            } else {
                this.zzaGu.add(callback);
            }
        }

        /* access modifiers changed from: protected */
        public void zza(zzf<zza> zzf) {
            this.zzaFZ = zzf;
            zzwP();
        }

        public void zzwP() {
            if (this.mActivity != null && this.zzaFZ != null && zzrn() == null) {
                try {
                    MapsInitializer.initialize(this.mActivity);
                    this.zzaFZ.zza(new zza(this.zzadh, zzy.zzaF(this.mActivity).zzu(zze.zzx(this.mActivity))));
                    for (OnStreetViewPanoramaReadyCallback streetViewPanoramaAsync : this.zzaGu) {
                        ((zza) zzrn()).getStreetViewPanoramaAsync(streetViewPanoramaAsync);
                    }
                    this.zzaGu.clear();
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                } catch (GooglePlayServicesNotAvailableException e2) {
                }
            }
        }
    }

    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public static SupportStreetViewPanoramaFragment newInstance(StreetViewPanoramaOptions options) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", options);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }

    @Deprecated
    public final StreetViewPanorama getStreetViewPanorama() {
        IStreetViewPanoramaFragmentDelegate zzwS = zzwS();
        if (zzwS == null) {
            return null;
        }
        try {
            IStreetViewPanoramaDelegate streetViewPanorama = zzwS.getStreetViewPanorama();
            if (streetViewPanorama == null) {
                return null;
            }
            if (this.zzaGq == null || this.zzaGq.zzwR().asBinder() != streetViewPanorama.asBinder()) {
                this.zzaGq = new StreetViewPanorama(streetViewPanorama);
            }
            return this.zzaGq;
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback callback) {
        zzx.zzch("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzaGJ.getStreetViewPanoramaAsync(callback);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            savedInstanceState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onActivityCreated(savedInstanceState);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzaGJ.setActivity(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.zzaGJ.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return this.zzaGJ.onCreateView(inflater, container, savedInstanceState);
    }

    public void onDestroy() {
        this.zzaGJ.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzaGJ.onDestroyView();
        super.onDestroyView();
    }

    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(activity, attrs, savedInstanceState);
        this.zzaGJ.setActivity(activity);
        this.zzaGJ.onInflate(activity, new Bundle(), savedInstanceState);
    }

    public void onLowMemory() {
        this.zzaGJ.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzaGJ.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzaGJ.onResume();
    }

    public void onSaveInstanceState(Bundle outState) {
        if (outState != null) {
            outState.setClassLoader(SupportStreetViewPanoramaFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(outState);
        this.zzaGJ.onSaveInstanceState(outState);
    }

    public void setArguments(Bundle args) {
        super.setArguments(args);
    }

    /* access modifiers changed from: protected */
    public IStreetViewPanoramaFragmentDelegate zzwS() {
        this.zzaGJ.zzwP();
        if (this.zzaGJ.zzrn() == null) {
            return null;
        }
        return ((zza) this.zzaGJ.zzrn()).zzwS();
    }
}
