package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.PlacePhotoMetadata;
import com.google.android.gms.location.places.PlacePhotoResult;

public class zzq extends zzt implements PlacePhotoMetadata {
    private final String zzaET = getString("photo_fife_url");

    public zzq(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public CharSequence getAttributions() {
        return zzD("photo_attributions", null);
    }

    public int getMaxHeight() {
        return zzA("photo_max_height", 0);
    }

    public int getMaxWidth() {
        return zzA("photo_max_width", 0);
    }

    public PendingResult<PlacePhotoResult> getPhoto(GoogleApiClient client) {
        return getScaledPhoto(client, getMaxWidth(), getMaxHeight());
    }

    public PendingResult<PlacePhotoResult> getScaledPhoto(GoogleApiClient client, int width, int height) {
        return freeze().getScaledPhoto(client, width, height);
    }

    /* renamed from: zzwu */
    public PlacePhotoMetadata freeze() {
        return new zzp(this.zzaET, getMaxWidth(), getMaxHeight(), getAttributions(), this.zzabg);
    }
}
