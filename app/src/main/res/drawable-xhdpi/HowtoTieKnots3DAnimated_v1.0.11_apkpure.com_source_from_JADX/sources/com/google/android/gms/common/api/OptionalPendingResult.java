package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;

public interface OptionalPendingResult<R extends Result> extends PendingResult<R> {
    R get();

    boolean isDone();
}
