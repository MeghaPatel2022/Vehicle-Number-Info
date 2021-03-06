package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes {
    private static final String[] zzaxr = {"requestId", "outcome"};
    private final int zzWu;
    private final HashMap<String, Integer> zzaxs;

    public static final class Builder {
        private int zzWu = 0;
        private HashMap<String, Integer> zzaxs = new HashMap<>();

        public Builder zzga(int i) {
            this.zzWu = i;
            return this;
        }

        public RequestUpdateOutcomes zzuP() {
            return new RequestUpdateOutcomes(this.zzWu, this.zzaxs);
        }

        public Builder zzy(String str, int i) {
            if (RequestUpdateResultOutcome.isValid(i)) {
                this.zzaxs.put(str, Integer.valueOf(i));
            }
            return this;
        }
    }

    private RequestUpdateOutcomes(int statusCode, HashMap<String, Integer> outcomeMap) {
        this.zzWu = statusCode;
        this.zzaxs = outcomeMap;
    }

    public static RequestUpdateOutcomes zzY(DataHolder dataHolder) {
        Builder builder = new Builder();
        builder.zzga(dataHolder.getStatusCode());
        int count = dataHolder.getCount();
        for (int i = 0; i < count; i++) {
            int zzbo = dataHolder.zzbo(i);
            builder.zzy(dataHolder.zzd("requestId", i, zzbo), dataHolder.zzc("outcome", i, zzbo));
        }
        return builder.zzuP();
    }

    public Set<String> getRequestIds() {
        return this.zzaxs.keySet();
    }

    public int getRequestOutcome(String requestId) {
        zzx.zzb(this.zzaxs.containsKey(requestId), (Object) "Request " + requestId + " was not part of the update operation!");
        return ((Integer) this.zzaxs.get(requestId)).intValue();
    }
}
