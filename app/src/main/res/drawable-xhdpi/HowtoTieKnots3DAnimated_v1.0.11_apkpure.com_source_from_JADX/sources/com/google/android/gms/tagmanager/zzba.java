package com.google.android.gms.tagmanager;

import android.util.LruCache;
import com.google.android.gms.tagmanager.zzm.zza;

class zzba<K, V> implements zzl<K, V> {
    private LruCache<K, V> zzaQy;

    zzba(int i, final zza<K, V> zza) {
        this.zzaQy = new LruCache<K, V>(i) {
            /* access modifiers changed from: protected */
            public int sizeOf(K key, V value) {
                return zza.sizeOf(key, value);
            }
        };
    }

    public V get(K key) {
        return this.zzaQy.get(key);
    }

    public void zzf(K k, V v) {
        this.zzaQy.put(k, v);
    }
}
