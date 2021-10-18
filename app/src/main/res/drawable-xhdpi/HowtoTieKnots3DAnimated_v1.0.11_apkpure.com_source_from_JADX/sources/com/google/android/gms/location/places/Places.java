package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.internal.zzc;
import com.google.android.gms.location.places.internal.zzd;
import com.google.android.gms.location.places.internal.zzd.zza;
import com.google.android.gms.location.places.internal.zzi;
import com.google.android.gms.location.places.internal.zzj;

public class Places {
    public static final Api<PlacesOptions> GEO_DATA_API = new Api<>("Places.GEO_DATA_API", new zza(null, null), zzaDN);
    public static final GeoDataApi GeoDataApi = new zzc();
    public static final Api<PlacesOptions> PLACE_DETECTION_API = new Api<>("Places.PLACE_DETECTION_API", new zzj.zza(null, null), zzaDO);
    public static final PlaceDetectionApi PlaceDetectionApi = new zzi();
    public static final Api.zzc<zzd> zzaDN = new Api.zzc<>();
    public static final Api.zzc<zzj> zzaDO = new Api.zzc<>();

    private Places() {
    }
}
