package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd {
    private final Context mContext;
    private final BarcodeDetectorOptions zzaVs;
    private zzb zzaVu = null;
    private final Object zzpc = new Object();

    static class zza extends zzg<zzc> {
        private static zza zzaVv;

        zza() {
            super("com.google.android.gms.vision.client.DynamiteNativeBarcodeDetectorCreator");
        }

        static zzb zza(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            if (zzaVv == null) {
                zzaVv = new zza();
            }
            return zzaVv.zzb(context, barcodeDetectorOptions);
        }

        private zzb zzb(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
            try {
                return ((zzc) zzar(context)).zza(zze.zzx(context), barcodeDetectorOptions);
            } catch (RemoteException e) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e);
            } catch (com.google.android.gms.dynamic.zzg.zza e2) {
                Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", e2);
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zzdL */
        public zzc zzd(IBinder iBinder) {
            return com.google.android.gms.vision.barcode.internal.client.zzc.zza.zzdK(iBinder);
        }
    }

    public zzd(Context context, BarcodeDetectorOptions barcodeDetectorOptions) {
        this.mContext = context;
        this.zzaVs = barcodeDetectorOptions;
        zzCe();
    }

    private zzb zzCe() {
        zzb zzb;
        synchronized (this.zzpc) {
            if (this.zzaVu == null) {
                this.zzaVu = zza.zza(this.mContext, this.zzaVs);
            }
            zzb = this.zzaVu;
        }
        return zzb;
    }

    public boolean isOperational() {
        return zzCe() != null;
    }

    public Barcode[] zza(Bitmap bitmap, FrameMetadataParcel frameMetadataParcel) {
        zzb zzCe = zzCe();
        if (zzCe == null) {
            return new Barcode[0];
        }
        try {
            return zzCe.zzb(zze.zzx(bitmap), frameMetadataParcel);
        } catch (RemoteException e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }

    public Barcode[] zza(ByteBuffer byteBuffer, FrameMetadataParcel frameMetadataParcel) {
        zzb zzCe = zzCe();
        if (zzCe == null) {
            return new Barcode[0];
        }
        try {
            return zzCe.zza(zze.zzx(byteBuffer), frameMetadataParcel);
        } catch (RemoteException e) {
            Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", e);
            return new Barcode[0];
        }
    }
}
