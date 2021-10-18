package com.google.android.gms.location.places.internal;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.NearbyAlertRequest;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlaceRequest;
import com.google.android.gms.location.places.UserDataType;
import com.google.android.gms.location.places.personalized.PlaceAlias;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;
import java.util.List;

public interface zzf extends IInterface {

    public static abstract class zza extends Binder implements zzf {

        /* renamed from: com.google.android.gms.location.places.internal.zzf$zza$zza reason: collision with other inner class name */
        private static class C1479zza implements zzf {
            private IBinder zznI;

            C1479zza(IBinder iBinder) {
                this.zznI = iBinder;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void zza(AddPlaceRequest addPlaceRequest, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (addPlaceRequest != null) {
                        obtain.writeInt(1);
                        addPlaceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (nearbyAlertRequest != null) {
                        obtain.writeInt(1);
                        nearbyAlertRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceReport placeReport, PlacesParams placesParams) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeReport != null) {
                        obtain.writeInt(1);
                        placeReport.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeRequest != null) {
                        obtain.writeInt(1);
                        placeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(UserDataType userDataType, LatLngBounds latLngBounds, List<String> list, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (userDataType != null) {
                        obtain.writeInt(1);
                        userDataType.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringList(list);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(PlaceAlias placeAlias, String str, String str2, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeAlias != null) {
                        obtain.writeInt(1);
                        placeAlias.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LatLng latLng, PlaceFilter placeFilter, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (latLng != null) {
                        obtain.writeInt(1);
                        latLng.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, int i3, PlacesParams placesParams, zzg zzg) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzg != null) {
                        iBinder = zzg.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlacesParams placesParams, zzg zzg) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzg != null) {
                        iBinder = zzg.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(19, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (latLngBounds != null) {
                        obtain.writeInt(1);
                        latLngBounds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (autocompleteFilter != null) {
                        obtain.writeInt(1);
                        autocompleteFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(List<String> list, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeStringList(list);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(PlaceFilter placeFilter, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placeFilter != null) {
                        obtain.writeInt(1);
                        placeFilter.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (pendingIntent != null) {
                        obtain.writeInt(1);
                        pendingIntent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(String str, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeString(str);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zzb(List<String> list, PlacesParams placesParams, zzh zzh) throws RemoteException {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    obtain.writeStringList(list);
                    if (placesParams != null) {
                        obtain.writeInt(1);
                        placesParams.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (zzh != null) {
                        iBinder = zzh.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zznI.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzf zzce(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzf)) ? new C1479zza(iBinder) : (zzf) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            PlacesParams placesParams = null;
            switch (code) {
                case 2:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    LatLngBounds latLngBounds = data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null;
                    int readInt = data.readInt();
                    String readString = data.readString();
                    PlaceFilter placeFilter = data.readInt() != 0 ? PlaceFilter.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(latLngBounds, readInt, readString, placeFilter, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 3:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    String readString2 = data.readString();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(readString2, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 4:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    LatLng latLng = data.readInt() != 0 ? LatLng.CREATOR.createFromParcel(data) : null;
                    PlaceFilter placeFilter2 = data.readInt() != 0 ? PlaceFilter.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(latLng, placeFilter2, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    PlaceFilter placeFilter3 = data.readInt() != 0 ? PlaceFilter.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zzb(placeFilter3, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 6:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    String readString3 = data.readString();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zzb(readString3, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    ArrayList createStringArrayList = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza((List<String>) createStringArrayList, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 8:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? UserDataType.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null, (List<String>) data.createStringArrayList(), data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 9:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? (PlaceRequest) PlaceRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case 10:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case 11:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? NearbyAlertRequest.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zzb(data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(data) : null);
                    return true;
                case 13:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readString(), data.readInt() != 0 ? LatLngBounds.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? AutocompleteFilter.CREATOR.createFromParcel(data) : null, data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 14:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    AddPlaceRequest addPlaceRequest = data.readInt() != 0 ? (AddPlaceRequest) AddPlaceRequest.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(addPlaceRequest, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 15:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    PlaceReport placeReport = data.readInt() != 0 ? (PlaceReport) PlaceReport.CREATOR.createFromParcel(data) : null;
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(placeReport, placesParams);
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    zza(data.readInt() != 0 ? PlaceAlias.CREATOR.createFromParcel(data) : null, data.readString(), data.readString(), data.readInt() != 0 ? PlacesParams.CREATOR.createFromParcel(data) : null, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    ArrayList createStringArrayList2 = data.createStringArrayList();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zzb((List<String>) createStringArrayList2, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 18:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    String readString4 = data.readString();
                    int readInt2 = data.readInt();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(readString4, readInt2, placesParams, com.google.android.gms.location.places.internal.zzh.zza.zzcg(data.readStrongBinder()));
                    return true;
                case 19:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    String readString5 = data.readString();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(readString5, placesParams, com.google.android.gms.location.places.internal.zzg.zza.zzcf(data.readStrongBinder()));
                    return true;
                case 20:
                    data.enforceInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    String readString6 = data.readString();
                    int readInt3 = data.readInt();
                    int readInt4 = data.readInt();
                    int readInt5 = data.readInt();
                    if (data.readInt() != 0) {
                        placesParams = PlacesParams.CREATOR.createFromParcel(data);
                    }
                    zza(readString6, readInt3, readInt4, readInt5, placesParams, com.google.android.gms.location.places.internal.zzg.zza.zzcf(data.readStrongBinder()));
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.location.places.internal.IGooglePlacesService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    void zza(AddPlaceRequest addPlaceRequest, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(NearbyAlertRequest nearbyAlertRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zza(PlaceReport placeReport, PlacesParams placesParams) throws RemoteException;

    void zza(PlaceRequest placeRequest, PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zza(UserDataType userDataType, LatLngBounds latLngBounds, List<String> list, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zza(PlaceAlias placeAlias, String str, String str2, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(LatLng latLng, PlaceFilter placeFilter, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(LatLngBounds latLngBounds, int i, String str, PlaceFilter placeFilter, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(String str, int i, int i2, int i3, PlacesParams placesParams, zzg zzg) throws RemoteException;

    void zza(String str, int i, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(String str, PlacesParams placesParams, zzg zzg) throws RemoteException;

    void zza(String str, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(String str, LatLngBounds latLngBounds, AutocompleteFilter autocompleteFilter, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zza(List<String> list, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zzb(PlaceFilter placeFilter, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zzb(PlacesParams placesParams, PendingIntent pendingIntent) throws RemoteException;

    void zzb(String str, PlacesParams placesParams, zzh zzh) throws RemoteException;

    void zzb(List<String> list, PlacesParams placesParams, zzh zzh) throws RemoteException;
}
