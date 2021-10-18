package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {
    protected final DataBuffer<T> zzabd;
    protected int zzabe = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.zzabd = (DataBuffer) zzx.zzv(dataBuffer);
    }

    public boolean hasNext() {
        return this.zzabe < this.zzabd.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzabe);
        }
        DataBuffer<T> dataBuffer = this.zzabd;
        int i = this.zzabe + 1;
        this.zzabe = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
