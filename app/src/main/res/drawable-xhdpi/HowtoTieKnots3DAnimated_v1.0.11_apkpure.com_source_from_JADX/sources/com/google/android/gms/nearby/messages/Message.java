package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Arrays;

public class Message implements SafeParcelable {
    public static final Creator<Message> CREATOR = new zza();
    public static final int MAX_CONTENT_SIZE_BYTES = 102400;
    public static final int MAX_TYPE_LENGTH = 32;
    private final byte[] content;
    private final String type;
    final int versionCode;
    private final String zzaeI;

    Message(int versionCode2, byte[] content2, String namespace, String type2) {
        this.versionCode = versionCode2;
        this.content = (byte[]) zzx.zzv(content2);
        this.type = (String) zzx.zzv(type2);
        if (namespace == null) {
            namespace = "";
        }
        this.zzaeI = namespace;
        zzx.zzb(content2.length <= 102400, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", Integer.valueOf(content2.length), Integer.valueOf(MAX_CONTENT_SIZE_BYTES));
        zzx.zzb(type2.length() <= 32, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", Integer.valueOf(type2.length()), Integer.valueOf(32));
    }

    public Message(byte[] content2) {
        this(content2, "", "");
    }

    public Message(byte[] content2, String type2) {
        this(1, content2, "", type2);
    }

    Message(byte[] content2, String namespace, String type2) {
        this(1, content2, namespace, type2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Message)) {
            return false;
        }
        Message message = (Message) object;
        return TextUtils.equals(this.zzaeI, message.zzaeI) && TextUtils.equals(this.type, message.type) && Arrays.equals(this.content, message.content);
    }

    public byte[] getContent() {
        return this.content;
    }

    public String getNamespace() {
        return this.zzaeI;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzaeI, this.type, Integer.valueOf(Arrays.hashCode(this.content)));
    }

    public String toString() {
        return "Message{namespace='" + this.zzaeI + "'" + ", type='" + this.type + "'" + ", content=[" + this.content.length + " bytes]" + "}";
    }

    public void writeToParcel(Parcel out, int flags) {
        zza.zza(this, out, flags);
    }
}
