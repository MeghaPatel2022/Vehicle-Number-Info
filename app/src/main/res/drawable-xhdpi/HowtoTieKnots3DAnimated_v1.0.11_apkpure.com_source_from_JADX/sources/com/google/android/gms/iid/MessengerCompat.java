package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new Creator<MessengerCompat>() {
        /* renamed from: zzen */
        public MessengerCompat createFromParcel(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                return new MessengerCompat(readStrongBinder);
            }
            return null;
        }

        /* renamed from: zzgA */
        public MessengerCompat[] newArray(int i) {
            return new MessengerCompat[i];
        }
    };
    Messenger zzaBc;
    zzb zzaBd;

    private final class zza extends com.google.android.gms.iid.zzb.zza {
        Handler handler;

        zza(Handler handler2) {
            this.handler = handler2;
        }

        public void send(Message msg) throws RemoteException {
            msg.arg2 = Binder.getCallingUid();
            this.handler.dispatchMessage(msg);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaBc = new Messenger(handler);
        } else {
            this.zzaBd = new zza(handler);
        }
    }

    public MessengerCompat(IBinder target) {
        if (VERSION.SDK_INT >= 21) {
            this.zzaBc = new Messenger(target);
        } else {
            this.zzaBd = com.google.android.gms.iid.zzb.zza.zzbV(target);
        }
    }

    public static int zzc(Message message) {
        return VERSION.SDK_INT >= 21 ? zzd(message) : message.arg2;
    }

    private static int zzd(Message message) {
        return message.sendingUid;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object otherObj) {
        boolean z = false;
        if (otherObj == null) {
            return z;
        }
        try {
            return getBinder().equals(((MessengerCompat) otherObj).getBinder());
        } catch (ClassCastException e) {
            return z;
        }
    }

    public IBinder getBinder() {
        return this.zzaBc != null ? this.zzaBc.getBinder() : this.zzaBd.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) throws RemoteException {
        if (this.zzaBc != null) {
            this.zzaBc.send(message);
        } else {
            this.zzaBd.send(message);
        }
    }

    public void writeToParcel(Parcel out, int flags) {
        if (this.zzaBc != null) {
            out.writeStrongBinder(this.zzaBc.getBinder());
        } else {
            out.writeStrongBinder(this.zzaBd.asBinder());
        }
    }
}
