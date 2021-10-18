package com.google.android.gms.location.places;

import android.content.Context;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.location.places.internal.zzm;

public class PlaceLikelihoodBuffer extends AbstractDataBuffer<PlaceLikelihood> implements Result {
    private final Context mContext;
    private final Status zzQA;
    private final int zzaDD;
    private final String zzaDy;

    public static class zza {
        static int zzhb(int i) {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                    return i;
                default:
                    throw new IllegalArgumentException("invalid source: " + i);
            }
        }
    }

    public PlaceLikelihoodBuffer(DataHolder dataHolder, int source, Context context) {
        super(dataHolder);
        this.mContext = context;
        this.zzQA = PlacesStatusCodes.zzhg(dataHolder.getStatusCode());
        this.zzaDD = zza.zzhb(source);
        if (dataHolder == null || dataHolder.zznP() == null) {
            this.zzaDy = null;
        } else {
            this.zzaDy = dataHolder.zznP().getString("com.google.android.gms.location.places.PlaceLikelihoodBuffer.ATTRIBUTIONS_EXTRA_KEY");
        }
    }

    public PlaceLikelihood get(int position) {
        return new zzm(this.zzYX, position, this.mContext);
    }

    public CharSequence getAttributions() {
        return this.zzaDy;
    }

    public Status getStatus() {
        return this.zzQA;
    }

    public String toString() {
        return zzw.zzu(this).zzg("status", getStatus()).zzg("attributions", this.zzaDy).toString();
    }
}
