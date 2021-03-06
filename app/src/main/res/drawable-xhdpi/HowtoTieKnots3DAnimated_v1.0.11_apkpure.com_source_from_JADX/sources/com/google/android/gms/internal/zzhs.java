package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import java.util.concurrent.Future;

@zzgk
public final class zzhs {

    private static abstract class zza extends zzhq {
        private zza() {
        }

        public void onStop() {
        }
    }

    public interface zzb {
        void zzd(Bundle bundle);
    }

    public static Future zza(final Context context, final int i) {
        return new zza() {
            public void zzdG() {
                Editor edit = zzhs.zzv(context).edit();
                edit.putInt("webview_cache_version", i);
                edit.apply();
            }
        }.zzgn();
    }

    public static Future zza(final Context context, final zzb zzb2) {
        return new zza() {
            public void zzdG() {
                SharedPreferences zzH = zzhs.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putBoolean("use_https", zzH.getBoolean("use_https", true));
                if (zzb2 != null) {
                    zzb2.zzd(bundle);
                }
            }
        }.zzgn();
    }

    public static Future zza(final Context context, final boolean z) {
        return new zza() {
            public void zzdG() {
                Editor edit = zzhs.zzv(context).edit();
                edit.putBoolean("use_https", z);
                edit.apply();
            }
        }.zzgn();
    }

    public static Future zzb(final Context context, final zzb zzb2) {
        return new zza() {
            public void zzdG() {
                SharedPreferences zzH = zzhs.zzv(context);
                Bundle bundle = new Bundle();
                bundle.putInt("webview_cache_version", zzH.getInt("webview_cache_version", 0));
                if (zzb2 != null) {
                    zzb2.zzd(bundle);
                }
            }
        }.zzgn();
    }

    /* access modifiers changed from: private */
    public static SharedPreferences zzv(Context context) {
        return context.getSharedPreferences("admob", 0);
    }
}
