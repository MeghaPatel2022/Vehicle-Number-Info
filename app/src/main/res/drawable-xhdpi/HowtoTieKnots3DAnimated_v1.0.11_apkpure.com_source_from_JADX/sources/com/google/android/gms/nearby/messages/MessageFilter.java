package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter implements SafeParcelable {
    public static final Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    final int versionCode;
    private final List<MessageType> zzaJI;

    public static final class Builder {
        private final List<MessageType> zzaJI = new ArrayList();

        private Builder zzE(String str, String str2) {
            this.zzaJI.add(new MessageType(str, str2));
            return this;
        }

        public MessageFilter build() {
            zzx.zza(!this.zzaJI.isEmpty(), (Object) "At least one of the include methods must be called.");
            return new MessageFilter((List) this.zzaJI);
        }

        public Builder includeAllMyTypes() {
            return zzE("", "");
        }

        public Builder includeFilter(MessageFilter filter) {
            this.zzaJI.addAll(filter.zzyo());
            return this;
        }

        public Builder includeNamespacedType(String namespace, String type) {
            return zzE(namespace, type);
        }
    }

    MessageFilter(int versionCode2, List<MessageType> messageTypes) {
        this.versionCode = versionCode2;
        this.zzaJI = Collections.unmodifiableList((List) zzx.zzv(messageTypes));
    }

    private MessageFilter(List<MessageType> messageTypes) {
        this(1, messageTypes);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageFilter)) {
            return false;
        }
        return zzw.equal(this.zzaJI, ((MessageFilter) o).zzaJI);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaJI);
    }

    public String toString() {
        return "MessageFilter" + this.zzaJI;
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzb.zza(this, dest, flags);
    }

    /* access modifiers changed from: 0000 */
    public List<MessageType> zzyo() {
        return this.zzaJI;
    }
}
