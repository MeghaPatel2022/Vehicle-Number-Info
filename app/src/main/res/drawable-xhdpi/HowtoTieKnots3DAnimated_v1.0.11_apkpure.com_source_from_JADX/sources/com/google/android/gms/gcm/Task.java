package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class Task implements Parcelable {
    public static final int EXTRAS_LIMIT_BYTES = 10240;
    public static final int NETWORK_STATE_ANY = 2;
    public static final int NETWORK_STATE_CONNECTED = 0;
    public static final int NETWORK_STATE_UNMETERED = 1;
    protected static final long UNINITIALIZED = -1;
    private final Bundle mExtras;
    private final String mTag;
    private final String zzaAh;
    private final boolean zzaAi;
    private final boolean zzaAj;
    private final int zzaAk;
    private final boolean zzaAl;

    public static abstract class Builder {
        protected Bundle extras;
        protected String gcmTaskService;
        protected boolean isPersisted;
        protected int requiredNetworkState;
        protected boolean requiresCharging;
        protected String tag;
        protected boolean updateCurrent;

        public abstract Task build();

        /* access modifiers changed from: protected */
        public void checkConditions() {
            zzx.zzb(this.gcmTaskService != null, (Object) "Must provide an endpoint for this task by calling setService(ComponentName).");
            GcmNetworkManager.zzdi(this.tag);
            if (this.isPersisted) {
                Task.zzz(this.extras);
            }
        }

        public abstract Builder setExtras(Bundle bundle);

        public abstract Builder setPersisted(boolean z);

        public abstract Builder setRequiredNetwork(int i);

        public abstract Builder setRequiresCharging(boolean z);

        public abstract Builder setService(Class<? extends GcmTaskService> cls);

        public abstract Builder setTag(String str);

        public abstract Builder setUpdateCurrent(boolean z);
    }

    @Deprecated
    Task(Parcel in) {
        boolean z = true;
        this.zzaAh = in.readString();
        this.mTag = in.readString();
        this.zzaAi = in.readInt() == 1;
        if (in.readInt() != 1) {
            z = false;
        }
        this.zzaAj = z;
        this.zzaAk = 2;
        this.zzaAl = false;
        this.mExtras = null;
    }

    Task(Builder builder) {
        this.zzaAh = builder.gcmTaskService;
        this.mTag = builder.tag;
        this.zzaAi = builder.updateCurrent;
        this.zzaAj = builder.isPersisted;
        this.zzaAk = builder.requiredNetworkState;
        this.zzaAl = builder.requiresCharging;
        this.mExtras = builder.extras;
    }

    private static boolean zzy(Object obj) {
        return (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof String) || (obj instanceof Boolean);
    }

    public static void zzz(Bundle bundle) {
        if (bundle != null) {
            Parcel obtain = Parcel.obtain();
            bundle.writeToParcel(obtain, 0);
            int dataSize = obtain.dataSize();
            if (dataSize > 10240) {
                obtain.recycle();
                throw new IllegalArgumentException("Extras exceeding maximum size(10240 bytes): " + dataSize);
            }
            obtain.recycle();
            for (String str : bundle.keySet()) {
                if (!zzy(bundle.get(str))) {
                    throw new IllegalArgumentException("Only the following extra parameter types are supported: Integer, Long, Double, String, and Boolean. ");
                }
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public int getRequiredNetwork() {
        return this.zzaAk;
    }

    public boolean getRequiresCharging() {
        return this.zzaAl;
    }

    public String getServiceName() {
        return this.zzaAh;
    }

    public String getTag() {
        return this.mTag;
    }

    public boolean isPersisted() {
        return this.zzaAj;
    }

    public boolean isUpdateCurrent() {
        return this.zzaAi;
    }

    public void toBundle(Bundle bundle) {
        bundle.putString("tag", this.mTag);
        bundle.putBoolean("update_current", this.zzaAi);
        bundle.putBoolean("persisted", this.zzaAj);
        bundle.putString("service", this.zzaAh);
        bundle.putInt("requiredNetwork", this.zzaAk);
        bundle.putBoolean("requiresCharging", this.zzaAl);
        bundle.putBundle("extras", this.mExtras);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.zzaAh);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.zzaAi ? 1 : 0);
        if (!this.zzaAj) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
