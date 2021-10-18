package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.dynamic.LifecycleDelegate;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zza<T extends LifecycleDelegate> {
    /* access modifiers changed from: private */
    public T zzamN;
    /* access modifiers changed from: private */
    public Bundle zzamO;
    /* access modifiers changed from: private */
    public LinkedList<C1376zza> zzamP;
    private final zzf<T> zzamQ = new zzf<T>() {
        public void zza(T t) {
            zza.this.zzamN = t;
            Iterator it = zza.this.zzamP.iterator();
            while (it.hasNext()) {
                ((C1376zza) it.next()).zzb(zza.this.zzamN);
            }
            zza.this.zzamP.clear();
            zza.this.zzamO = null;
        }
    };

    /* renamed from: com.google.android.gms.dynamic.zza$zza reason: collision with other inner class name */
    private interface C1376zza {
        int getState();

        void zzb(LifecycleDelegate lifecycleDelegate);
    }

    private void zza(Bundle bundle, C1376zza zza) {
        if (this.zzamN != null) {
            zza.zzb(this.zzamN);
            return;
        }
        if (this.zzamP == null) {
            this.zzamP = new LinkedList<>();
        }
        this.zzamP.add(zza);
        if (bundle != null) {
            if (this.zzamO == null) {
                this.zzamO = (Bundle) bundle.clone();
            } else {
                this.zzamO.putAll(bundle);
            }
        }
        zza(this.zzamQ);
    }

    public static void zzb(FrameLayout frameLayout) {
        final Context context = frameLayout.getContext();
        final int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        String zzb = zzg.zzb(context, isGooglePlayServicesAvailable, GooglePlayServicesUtil.zzaf(context));
        String zzh = zzg.zzh(context, isGooglePlayServicesAvailable);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new LayoutParams(-2, -2));
        textView.setText(zzb);
        linearLayout.addView(textView);
        if (zzh != null) {
            Button button = new Button(context);
            button.setLayoutParams(new LayoutParams(-2, -2));
            button.setText(zzh);
            linearLayout.addView(button);
            button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    context.startActivity(GooglePlayServicesUtil.zzbc(isGooglePlayServicesAvailable));
                }
            });
        }
    }

    private void zzei(int i) {
        while (!this.zzamP.isEmpty() && ((C1376zza) this.zzamP.getLast()).getState() >= i) {
            this.zzamP.removeLast();
        }
    }

    public void onCreate(final Bundle savedInstanceState) {
        zza(savedInstanceState, (C1376zza) new C1376zza() {
            public int getState() {
                return 1;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzamN.onCreate(savedInstanceState);
            }
        });
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final FrameLayout frameLayout = new FrameLayout(inflater.getContext());
        final LayoutInflater layoutInflater = inflater;
        final ViewGroup viewGroup = container;
        final Bundle bundle = savedInstanceState;
        zza(savedInstanceState, (C1376zza) new C1376zza() {
            public int getState() {
                return 2;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                frameLayout.removeAllViews();
                frameLayout.addView(zza.this.zzamN.onCreateView(layoutInflater, viewGroup, bundle));
            }
        });
        if (this.zzamN == null) {
            zza(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        if (this.zzamN != null) {
            this.zzamN.onDestroy();
        } else {
            zzei(1);
        }
    }

    public void onDestroyView() {
        if (this.zzamN != null) {
            this.zzamN.onDestroyView();
        } else {
            zzei(2);
        }
    }

    public void onInflate(final Activity activity, final Bundle attrs, final Bundle savedInstanceState) {
        zza(savedInstanceState, (C1376zza) new C1376zza() {
            public int getState() {
                return 0;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzamN.onInflate(activity, attrs, savedInstanceState);
            }
        });
    }

    public void onLowMemory() {
        if (this.zzamN != null) {
            this.zzamN.onLowMemory();
        }
    }

    public void onPause() {
        if (this.zzamN != null) {
            this.zzamN.onPause();
        } else {
            zzei(5);
        }
    }

    public void onResume() {
        zza((Bundle) null, (C1376zza) new C1376zza() {
            public int getState() {
                return 5;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzamN.onResume();
            }
        });
    }

    public void onSaveInstanceState(Bundle outState) {
        if (this.zzamN != null) {
            this.zzamN.onSaveInstanceState(outState);
        } else if (this.zzamO != null) {
            outState.putAll(this.zzamO);
        }
    }

    public void onStart() {
        zza((Bundle) null, (C1376zza) new C1376zza() {
            public int getState() {
                return 4;
            }

            public void zzb(LifecycleDelegate lifecycleDelegate) {
                zza.this.zzamN.onStart();
            }
        });
    }

    public void onStop() {
        if (this.zzamN != null) {
            this.zzamN.onStop();
        } else {
            zzei(4);
        }
    }

    /* access modifiers changed from: protected */
    public void zza(FrameLayout frameLayout) {
        zzb(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzf<T> zzf);

    public T zzrn() {
        return this.zzamN;
    }
}
