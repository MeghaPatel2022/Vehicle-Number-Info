package com.google.android.gms.location;

import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.internal.ParcelableGeofence;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingEvent {
    private final int zzCI;
    private final int zzaBI;
    private final List<Geofence> zzaBJ;
    private final Location zzaBK;

    private GeofencingEvent(int errorCode, int transitionType, List<Geofence> triggeringGeofences, Location triggeringLocaton) {
        this.zzCI = errorCode;
        this.zzaBI = transitionType;
        this.zzaBJ = triggeringGeofences;
        this.zzaBK = triggeringLocaton;
    }

    public static GeofencingEvent fromIntent(Intent intent) {
        if (intent == null) {
            return null;
        }
        return new GeofencingEvent(intent.getIntExtra("gms_error_code", -1), zzs(intent), zzt(intent), (Location) intent.getParcelableExtra("com.google.android.location.intent.extra.triggering_location"));
    }

    private static int zzs(Intent intent) {
        int intExtra = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (intExtra == -1) {
            return -1;
        }
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return intExtra;
        }
        return -1;
    }

    private static List<Geofence> zzt(Intent intent) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(ParcelableGeofence.zzn((byte[]) it.next()));
        }
        return arrayList2;
    }

    public int getErrorCode() {
        return this.zzCI;
    }

    public int getGeofenceTransition() {
        return this.zzaBI;
    }

    public List<Geofence> getTriggeringGeofences() {
        return this.zzaBJ;
    }

    public Location getTriggeringLocation() {
        return this.zzaBK;
    }

    public boolean hasError() {
        return this.zzCI != -1;
    }
}
