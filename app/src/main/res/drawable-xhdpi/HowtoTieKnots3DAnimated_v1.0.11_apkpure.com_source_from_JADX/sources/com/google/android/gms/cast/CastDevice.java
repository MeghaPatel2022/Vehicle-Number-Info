package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CastDevice implements SafeParcelable {
    public static final int CAPABILITY_AUDIO_IN = 8;
    public static final int CAPABILITY_AUDIO_OUT = 4;
    public static final int CAPABILITY_VIDEO_IN = 2;
    public static final int CAPABILITY_VIDEO_OUT = 1;
    public static final Creator<CastDevice> CREATOR = new zzb();
    private final int mVersionCode;
    private String zzTn;
    String zzTo;
    private Inet4Address zzTp;
    private String zzTq;
    private String zzTr;
    private String zzTs;
    private int zzTt;
    private List<WebImage> zzTu;
    private int zzTv;
    private int zzxJ;

    private CastDevice() {
        this(3, null, null, null, null, null, -1, new ArrayList(), 0, -1);
    }

    CastDevice(int versionCode, String deviceId, String hostAddress, String friendlyName, String modelName, String deviceVersion, int servicePort, List<WebImage> icons, int capabilities, int status) {
        this.mVersionCode = versionCode;
        this.zzTn = deviceId;
        this.zzTo = hostAddress;
        if (this.zzTo != null) {
            try {
                InetAddress byName = InetAddress.getByName(this.zzTo);
                if (byName instanceof Inet4Address) {
                    this.zzTp = (Inet4Address) byName;
                }
            } catch (UnknownHostException e) {
                this.zzTp = null;
            }
        }
        this.zzTq = friendlyName;
        this.zzTr = modelName;
        this.zzTs = deviceVersion;
        this.zzTt = servicePort;
        this.zzTu = icons;
        this.zzTv = capabilities;
        this.zzxJ = status;
    }

    public static CastDevice getFromBundle(Bundle extras) {
        if (extras == null) {
            return null;
        }
        extras.setClassLoader(CastDevice.class.getClassLoader());
        return (CastDevice) extras.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        return getDeviceId() == null ? castDevice.getDeviceId() == null : zzf.zza(this.zzTn, castDevice.zzTn) && zzf.zza(this.zzTp, castDevice.zzTp) && zzf.zza(this.zzTr, castDevice.zzTr) && zzf.zza(this.zzTq, castDevice.zzTq) && zzf.zza(this.zzTs, castDevice.zzTs) && this.zzTt == castDevice.zzTt && zzf.zza(this.zzTu, castDevice.zzTu) && this.zzTv == castDevice.zzTv && this.zzxJ == castDevice.zzxJ;
    }

    public int getCapabilities() {
        return this.zzTv;
    }

    public String getDeviceId() {
        return this.zzTn;
    }

    public String getDeviceVersion() {
        return this.zzTs;
    }

    public String getFriendlyName() {
        return this.zzTq;
    }

    public WebImage getIcon(int preferredWidth, int preferredHeight) {
        WebImage webImage;
        WebImage webImage2 = null;
        if (this.zzTu.isEmpty()) {
            return null;
        }
        if (preferredWidth <= 0 || preferredHeight <= 0) {
            return (WebImage) this.zzTu.get(0);
        }
        WebImage webImage3 = null;
        for (WebImage webImage4 : this.zzTu) {
            int width = webImage4.getWidth();
            int height = webImage4.getHeight();
            if (width < preferredWidth || height < preferredHeight) {
                if (width < preferredWidth && height < preferredHeight && (webImage2 == null || (webImage2.getWidth() < width && webImage2.getHeight() < height))) {
                    webImage = webImage3;
                }
                webImage4 = webImage2;
                webImage = webImage3;
            } else {
                if (webImage3 == null || (webImage3.getWidth() > width && webImage3.getHeight() > height)) {
                    WebImage webImage5 = webImage2;
                    webImage = webImage4;
                    webImage4 = webImage5;
                }
                webImage4 = webImage2;
                webImage = webImage3;
            }
            webImage3 = webImage;
            webImage2 = webImage4;
        }
        if (webImage3 == null) {
            webImage3 = webImage2 != null ? webImage2 : (WebImage) this.zzTu.get(0);
        }
        return webImage3;
    }

    public List<WebImage> getIcons() {
        return Collections.unmodifiableList(this.zzTu);
    }

    public Inet4Address getIpAddress() {
        return this.zzTp;
    }

    public String getModelName() {
        return this.zzTr;
    }

    public int getServicePort() {
        return this.zzTt;
    }

    public int getStatus() {
        return this.zzxJ;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasCapabilities(int[] capabilities) {
        if (capabilities == null) {
            return false;
        }
        for (int hasCapability : capabilities) {
            if (!hasCapability(hasCapability)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCapability(int capability) {
        return (this.zzTv & capability) == capability;
    }

    public boolean hasIcons() {
        return !this.zzTu.isEmpty();
    }

    public int hashCode() {
        if (this.zzTn == null) {
            return 0;
        }
        return this.zzTn.hashCode();
    }

    public boolean isOnLocalNetwork() {
        return !this.zzTn.startsWith("__cast_nearby__");
    }

    public boolean isSameDevice(CastDevice castDevice) {
        if (castDevice == null) {
            return false;
        }
        if (getDeviceId() == null) {
            return castDevice.getDeviceId() == null;
        }
        return zzf.zza(getDeviceId(), castDevice.getDeviceId());
    }

    public void putInBundle(Bundle bundle) {
        if (bundle != null) {
            bundle.putParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE", this);
        }
    }

    public String toString() {
        return String.format("\"%s\" (%s)", new Object[]{this.zzTq, this.zzTn});
    }

    public void writeToParcel(Parcel out, int flags) {
        zzb.zza(this, out, flags);
    }
}
