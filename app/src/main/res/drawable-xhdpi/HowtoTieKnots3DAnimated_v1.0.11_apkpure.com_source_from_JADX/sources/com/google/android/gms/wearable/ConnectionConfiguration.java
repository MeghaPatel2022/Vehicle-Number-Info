package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new zzg();
    private final String mName;
    final int mVersionCode;
    private boolean zzOq;
    private final int zzUS;
    private final boolean zzaYO;
    private String zzaYP;
    private boolean zzaYQ;
    private String zzaYR;
    private final int zzahc;
    private final String zzanu;

    ConnectionConfiguration(int versionCode, String name, String address, int type, int role, boolean connectionEnabled, boolean isConnected, String peerNodeId, boolean btlePriority, String nodeId) {
        this.mVersionCode = versionCode;
        this.mName = name;
        this.zzanu = address;
        this.zzUS = type;
        this.zzahc = role;
        this.zzaYO = connectionEnabled;
        this.zzOq = isConnected;
        this.zzaYP = peerNodeId;
        this.zzaYQ = btlePriority;
        this.zzaYR = nodeId;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (!(o instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) o;
        return zzw.equal(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && zzw.equal(this.mName, connectionConfiguration.mName) && zzw.equal(this.zzanu, connectionConfiguration.zzanu) && zzw.equal(Integer.valueOf(this.zzUS), Integer.valueOf(connectionConfiguration.zzUS)) && zzw.equal(Integer.valueOf(this.zzahc), Integer.valueOf(connectionConfiguration.zzahc)) && zzw.equal(Boolean.valueOf(this.zzaYO), Boolean.valueOf(connectionConfiguration.zzaYO)) && zzw.equal(Boolean.valueOf(this.zzaYQ), Boolean.valueOf(connectionConfiguration.zzaYQ));
    }

    public String getAddress() {
        return this.zzanu;
    }

    public String getName() {
        return this.mName;
    }

    public String getNodeId() {
        return this.zzaYR;
    }

    public int getRole() {
        return this.zzahc;
    }

    public int getType() {
        return this.zzUS;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), this.mName, this.zzanu, Integer.valueOf(this.zzUS), Integer.valueOf(this.zzahc), Boolean.valueOf(this.zzaYO), Boolean.valueOf(this.zzaYQ));
    }

    public boolean isConnected() {
        return this.zzOq;
    }

    public boolean isEnabled() {
        return this.zzaYO;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConnectionConfiguration[ ");
        sb.append("mName=" + this.mName);
        sb.append(", mAddress=" + this.zzanu);
        sb.append(", mType=" + this.zzUS);
        sb.append(", mRole=" + this.zzahc);
        sb.append(", mEnabled=" + this.zzaYO);
        sb.append(", mIsConnected=" + this.zzOq);
        sb.append(", mPeerNodeId=" + this.zzaYP);
        sb.append(", mBtlePriority=" + this.zzaYQ);
        sb.append(", mNodeId=" + this.zzaYR);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzg.zza(this, dest, flags);
    }

    public String zzCp() {
        return this.zzaYP;
    }

    public boolean zzCq() {
        return this.zzaYQ;
    }
}
