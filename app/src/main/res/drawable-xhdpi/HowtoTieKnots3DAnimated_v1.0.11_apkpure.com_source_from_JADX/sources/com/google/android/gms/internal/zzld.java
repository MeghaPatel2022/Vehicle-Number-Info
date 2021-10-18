package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzld<K, V> extends zzlh<K, V> implements Map<K, V> {
    zzlg<K, V> zzaev;

    private zzlg<K, V> zzoV() {
        if (this.zzaev == null) {
            this.zzaev = new zzlg<K, V>() {
                /* access modifiers changed from: protected */
                public void colClear() {
                    zzld.this.clear();
                }

                /* access modifiers changed from: protected */
                public Object colGetEntry(int index, int offset) {
                    return zzld.this.mArray[(index << 1) + offset];
                }

                /* access modifiers changed from: protected */
                public Map<K, V> colGetMap() {
                    return zzld.this;
                }

                /* access modifiers changed from: protected */
                public int colGetSize() {
                    return zzld.this.mSize;
                }

                /* access modifiers changed from: protected */
                public int colIndexOfKey(Object key) {
                    return key == null ? zzld.this.indexOfNull() : zzld.this.indexOf(key, key.hashCode());
                }

                /* access modifiers changed from: protected */
                public int colIndexOfValue(Object value) {
                    return zzld.this.indexOfValue(value);
                }

                /* access modifiers changed from: protected */
                public void colPut(K key, V value) {
                    zzld.this.put(key, value);
                }

                /* access modifiers changed from: protected */
                public void colRemoveAt(int index) {
                    zzld.this.removeAt(index);
                }

                /* access modifiers changed from: protected */
                public V colSetValue(int index, V value) {
                    return zzld.this.setValueAt(index, value);
                }
            };
        }
        return this.zzaev;
    }

    public Set<Entry<K, V>> entrySet() {
        return zzoV().getEntrySet();
    }

    public Set<K> keySet() {
        return zzoV().getKeySet();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public Collection<V> values() {
        return zzoV().getValues();
    }
}
