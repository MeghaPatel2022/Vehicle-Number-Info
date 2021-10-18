package com.google.android.gms.games.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.nearby.connection.ConnectionsStatusCodes;
import com.google.android.gms.safetynet.SafetyNetStatusCodes;

public interface IGamesCallbacks extends IInterface {

    public static abstract class Stub extends Binder implements IGamesCallbacks {

        private static class Proxy implements IGamesCallbacks {
            private IBinder zznI;

            Proxy(IBinder remote) {
                this.zznI = remote;
            }

            public IBinder asBinder() {
                return this.zznI;
            }

            public void onInvitationRemoved(String invitationId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(invitationId);
                    this.zznI.transact(8010, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onLeftRoom(int statusCode, String roomId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(statusCode);
                    obtain.writeString(roomId);
                    this.zznI.transact(5020, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PConnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.zznI.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onP2PDisconnected(String participantId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(participantId);
                    this.zznI.transact(GamesStatusCodes.STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRealTimeMessageReceived(RealTimeMessage message) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (message != null) {
                        obtain.writeInt(1);
                        message.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5032, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onRequestRemoved(String requestId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(requestId);
                    this.zznI.transact(GamesActivityResultCodes.RESULT_SIGN_IN_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onTurnBasedMatchRemoved(String matchId) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeString(matchId);
                    this.zznI.transact(8009, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzA(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5022, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzB(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5023, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzC(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5024, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzD(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5025, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzE(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5038, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzF(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5035, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzG(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5039, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzH(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzI(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(GamesActivityResultCodes.RESULT_LICENSE_FAILED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzJ(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzK(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(GamesActivityResultCodes.RESULT_NETWORK_FAILURE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzL(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(SafetyNetStatusCodes.SAFE_BROWSING_MISSING_API_KEY, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzM(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12005, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzN(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzO(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzP(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12014, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzQ(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzR(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzS(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12013, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzT(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(13001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzU(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(15001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, String str, boolean z) throws RemoteException {
                int i2 = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    if (z) {
                        i2 = 1;
                    }
                    obtain.writeInt(i2);
                    this.zznI.transact(5034, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        obtain.writeInt(1);
                        dataHolder2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.UNKNOWN_AUTH_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, Contents contents) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12004, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (contents != null) {
                        obtain.writeInt(1);
                        contents.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents2 != null) {
                        obtain.writeInt(1);
                        contents2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (contents3 != null) {
                        obtain.writeInt(1);
                        contents3.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zznI.transact(5026, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DataHolder[] dataHolderArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeTypedArray(dataHolderArr, 0);
                    this.zznI.transact(14001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.zznI.transact(5033, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zznI.transact(5027, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zznI.transact(5028, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(GamesActivityResultCodes.RESULT_LEFT_ROOM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zznI.transact(5029, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(11001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zznI.transact(5030, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zznI.transact(FitnessStatusCodes.CONFLICTING_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.INCONSISTENT_DATA_TYPE, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(DataHolder dataHolder, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStringArray(strArr);
                    this.zznI.transact(5031, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzfI(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zznI.transact(5036, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzfJ(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zznI.transact(5040, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzfK(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    this.zznI.transact(13002, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12015, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zznI.transact(FitnessStatusCodes.DATA_TYPE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(12011, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zznI.transact(8007, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.APP_MISMATCH, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.zznI.transact(12012, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzi(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.MISSING_BLE_PERMISSION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzj(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.UNSUPPORTED_PLATFORM, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzk(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.TRANSIENT_ERROR, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzl(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.EQUIVALENT_SESSION_ENDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzll() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.zznI.transact(5016, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzm(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.APP_NOT_FIT_ENABLED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzn(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.API_EXCEPTION, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzo(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(PlacesStatusCodes.USAGE_LIMIT_EXCEEDED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzp(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5017, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzq(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5037, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzr(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(10001, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzs(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8003, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzt(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(ConnectionsStatusCodes.STATUS_CONNECTION_REJECTED, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzu(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(ConnectionsStatusCodes.STATUS_NOT_CONNECTED_TO_ENDPOINT, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzv(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8006, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzw(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(8008, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzx(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(FitnessStatusCodes.DATA_SOURCE_NOT_FOUND, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzy(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5019, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzz(DataHolder dataHolder) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zznI.transact(5021, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        public static IGamesCallbacks zzbO(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IGamesCallbacks)) ? new Proxy(iBinder) : (IGamesCallbacks) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX WARNING: type inference failed for: r5v0 */
        /* JADX WARNING: type inference failed for: r5v1, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v3, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v4, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v5, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v6, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v8, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v9, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v10, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v11, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v13, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v14, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v15, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v16, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v17, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v18, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v19, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v20, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v21, types: [com.google.android.gms.drive.Contents] */
        /* JADX WARNING: type inference failed for: r0v60, types: [com.google.android.gms.drive.Contents] */
        /* JADX WARNING: type inference failed for: r5v22 */
        /* JADX WARNING: type inference failed for: r5v23, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v24, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v25, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v26, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v27, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v28, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v29, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v30, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v31, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v32, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v33, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v34, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v35, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v36, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v37, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v38, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v39, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v40, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v41, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v42, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v43, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v44, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v45, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v46, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v47, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v48, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v49, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v50, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v51, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v52, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v53, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v54, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v55, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v56, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v57, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v58, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v59, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v60, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v61, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v62, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v63, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v64, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v65, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v66, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v67, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v68, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v69, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v70, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v71, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v72, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v73, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v74, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v75, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v76, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v77, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v78, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v79, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v80, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v81, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v82, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v83, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v84, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v85, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v86, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v87, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v88, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v89, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v90, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v91, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v92, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v93, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v94, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v95, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v96, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v97, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v98, types: [com.google.android.gms.common.data.DataHolder] */
        /* JADX WARNING: type inference failed for: r5v99 */
        /* JADX WARNING: type inference failed for: r5v100 */
        /* JADX WARNING: type inference failed for: r5v101 */
        /* JADX WARNING: type inference failed for: r5v102 */
        /* JADX WARNING: type inference failed for: r5v103 */
        /* JADX WARNING: type inference failed for: r5v104 */
        /* JADX WARNING: type inference failed for: r5v105 */
        /* JADX WARNING: type inference failed for: r5v106 */
        /* JADX WARNING: type inference failed for: r5v107 */
        /* JADX WARNING: type inference failed for: r5v108 */
        /* JADX WARNING: type inference failed for: r5v109 */
        /* JADX WARNING: type inference failed for: r5v110 */
        /* JADX WARNING: type inference failed for: r5v111 */
        /* JADX WARNING: type inference failed for: r5v112 */
        /* JADX WARNING: type inference failed for: r5v113 */
        /* JADX WARNING: type inference failed for: r5v114 */
        /* JADX WARNING: type inference failed for: r5v115 */
        /* JADX WARNING: type inference failed for: r5v116 */
        /* JADX WARNING: type inference failed for: r5v117 */
        /* JADX WARNING: type inference failed for: r5v118 */
        /* JADX WARNING: type inference failed for: r5v119 */
        /* JADX WARNING: type inference failed for: r5v120 */
        /* JADX WARNING: type inference failed for: r5v121 */
        /* JADX WARNING: type inference failed for: r5v122 */
        /* JADX WARNING: type inference failed for: r5v123 */
        /* JADX WARNING: type inference failed for: r5v124 */
        /* JADX WARNING: type inference failed for: r5v125 */
        /* JADX WARNING: type inference failed for: r5v126 */
        /* JADX WARNING: type inference failed for: r5v127 */
        /* JADX WARNING: type inference failed for: r5v128 */
        /* JADX WARNING: type inference failed for: r5v129 */
        /* JADX WARNING: type inference failed for: r5v130 */
        /* JADX WARNING: type inference failed for: r5v131 */
        /* JADX WARNING: type inference failed for: r5v132 */
        /* JADX WARNING: type inference failed for: r5v133 */
        /* JADX WARNING: type inference failed for: r5v134 */
        /* JADX WARNING: type inference failed for: r5v135 */
        /* JADX WARNING: type inference failed for: r5v136 */
        /* JADX WARNING: type inference failed for: r5v137 */
        /* JADX WARNING: type inference failed for: r5v138 */
        /* JADX WARNING: type inference failed for: r5v139 */
        /* JADX WARNING: type inference failed for: r5v140 */
        /* JADX WARNING: type inference failed for: r5v141 */
        /* JADX WARNING: type inference failed for: r5v142 */
        /* JADX WARNING: type inference failed for: r5v143 */
        /* JADX WARNING: type inference failed for: r5v144 */
        /* JADX WARNING: type inference failed for: r5v145 */
        /* JADX WARNING: type inference failed for: r5v146 */
        /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v0
          assigns: [?[int, float, boolean, short, byte, char, OBJECT, ARRAY], com.google.android.gms.common.data.DataHolder, ?[OBJECT, ARRAY]]
          uses: [com.google.android.gms.common.data.DataHolder, com.google.android.gms.drive.Contents]
          mth insns count: 743
        	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
        	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$0(DepthTraversal.java:13)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:13)
        	at jadx.core.ProcessClass.process(ProcessClass.java:30)
        	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
        	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
        	at jadx.core.ProcessClass.process(ProcessClass.java:35)
        	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
        	at jadx.api.JavaClass.decompile(JavaClass.java:62)
        	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
         */
        /* JADX WARNING: Unknown variable types count: 50 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r8, android.os.Parcel r9, android.os.Parcel r10, int r11) throws android.os.RemoteException {
            /*
                r7 = this;
                r5 = 0
                r6 = 1
                switch(r8) {
                    case 5001: goto L_0x0010;
                    case 5002: goto L_0x0024;
                    case 5003: goto L_0x003e;
                    case 5004: goto L_0x0052;
                    case 5005: goto L_0x006a;
                    case 5006: goto L_0x0091;
                    case 5007: goto L_0x00aa;
                    case 5008: goto L_0x00c3;
                    case 5009: goto L_0x00dc;
                    case 5010: goto L_0x00f5;
                    case 5011: goto L_0x010e;
                    case 5016: goto L_0x0127;
                    case 5017: goto L_0x0134;
                    case 5018: goto L_0x0166;
                    case 5019: goto L_0x017f;
                    case 5020: goto L_0x0198;
                    case 5021: goto L_0x01ad;
                    case 5022: goto L_0x01c6;
                    case 5023: goto L_0x01df;
                    case 5024: goto L_0x01f8;
                    case 5025: goto L_0x0211;
                    case 5026: goto L_0x022a;
                    case 5027: goto L_0x0247;
                    case 5028: goto L_0x0264;
                    case 5029: goto L_0x0281;
                    case 5030: goto L_0x029e;
                    case 5031: goto L_0x02bb;
                    case 5032: goto L_0x02d8;
                    case 5033: goto L_0x02f5;
                    case 5034: goto L_0x030e;
                    case 5035: goto L_0x0345;
                    case 5036: goto L_0x035e;
                    case 5037: goto L_0x014d;
                    case 5038: goto L_0x032c;
                    case 5039: goto L_0x036f;
                    case 5040: goto L_0x0388;
                    case 6001: goto L_0x0399;
                    case 6002: goto L_0x03aa;
                    case 8001: goto L_0x03bb;
                    case 8002: goto L_0x03d4;
                    case 8003: goto L_0x03f5;
                    case 8004: goto L_0x040e;
                    case 8005: goto L_0x0427;
                    case 8006: goto L_0x0440;
                    case 8007: goto L_0x0459;
                    case 8008: goto L_0x046e;
                    case 8009: goto L_0x0487;
                    case 8010: goto L_0x0498;
                    case 9001: goto L_0x04a9;
                    case 10001: goto L_0x04c2;
                    case 10002: goto L_0x04db;
                    case 10003: goto L_0x04ec;
                    case 10004: goto L_0x0505;
                    case 10005: goto L_0x051e;
                    case 10006: goto L_0x053f;
                    case 11001: goto L_0x0558;
                    case 12001: goto L_0x0579;
                    case 12003: goto L_0x063d;
                    case 12004: goto L_0x0592;
                    case 12005: goto L_0x060f;
                    case 12006: goto L_0x0690;
                    case 12007: goto L_0x06a9;
                    case 12008: goto L_0x06f4;
                    case 12011: goto L_0x0677;
                    case 12012: goto L_0x0628;
                    case 12013: goto L_0x065e;
                    case 12014: goto L_0x06c2;
                    case 12015: goto L_0x070d;
                    case 12016: goto L_0x06db;
                    case 12017: goto L_0x05be;
                    case 13001: goto L_0x072e;
                    case 13002: goto L_0x0747;
                    case 14001: goto L_0x0758;
                    case 15001: goto L_0x076d;
                    case 1598968902: goto L_0x000a;
                    default: goto L_0x0005;
                }
            L_0x0005:
                boolean r6 = super.onTransact(r8, r9, r10, r11)
            L_0x0009:
                return r6
            L_0x000a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r10.writeString(r0)
                goto L_0x0009
            L_0x0010:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzf(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0024:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x003c
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x0035:
                r7.zzf(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x003c:
                r0 = r5
                goto L_0x0035
            L_0x003e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzg(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x0052:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0063
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0063:
                r7.zzh(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x006a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x008f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
            L_0x007b:
                int r1 = r9.readInt()
                if (r1 == 0) goto L_0x0087
                com.google.android.gms.common.data.zze r1 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r1.createFromParcel(r9)
            L_0x0087:
                r7.zza(r0, r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x008f:
                r0 = r5
                goto L_0x007b
            L_0x0091:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00a2
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00a2:
                r7.zzi(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00aa:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00bb
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00bb:
                r7.zzj(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00c3:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00d4
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00d4:
                r7.zzk(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00dc:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x00ed
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x00ed:
                r7.zzl(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x00f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0106
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0106:
                r7.zzm(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x010e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x011f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x011f:
                r7.zzn(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0127:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                r7.zzll()
                r10.writeNoException()
                goto L_0x0009
            L_0x0134:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0145
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0145:
                r7.zzp(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x014d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x015e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x015e:
                r7.zzq(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0166:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0177
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0177:
                r7.zzx(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x017f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0190
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0190:
                r7.zzy(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0198:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.onLeftRoom(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x01ad:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01be
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01be:
                r7.zzz(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x01c6:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01d7
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01d7:
                r7.zzA(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x01df:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x01f0
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x01f0:
                r7.zzB(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x01f8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0209
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0209:
                r7.zzC(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0211:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0222
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0222:
                r7.zzD(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x022a:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x023b
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x023b:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zza(r5, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0247:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0258
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0258:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzb(r5, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0264:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0275
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0275:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzc(r5, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0281:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0292
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0292:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzd(r5, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x029e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02af
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x02af:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zze(r5, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x02bb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02cc
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x02cc:
                java.lang.String[] r0 = r9.createStringArray()
                r7.zzf(r5, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x02d8:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x02f3
                android.os.Parcelable$Creator<com.google.android.gms.games.multiplayer.realtime.RealTimeMessage> r0 = com.google.android.gms.games.multiplayer.realtime.RealTimeMessage.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.games.multiplayer.realtime.RealTimeMessage r0 = (com.google.android.gms.games.multiplayer.realtime.RealTimeMessage) r0
            L_0x02eb:
                r7.onRealTimeMessageReceived(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x02f3:
                r0 = r5
                goto L_0x02eb
            L_0x02f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                r7.zzb(r0, r1, r2)
                r10.writeNoException()
                goto L_0x0009
            L_0x030e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                java.lang.String r2 = r9.readString()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x032a
                r0 = r6
            L_0x0322:
                r7.zza(r1, r2, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x032a:
                r0 = 0
                goto L_0x0322
            L_0x032c:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x033d
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x033d:
                r7.zzE(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0345:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0356
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0356:
                r7.zzF(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x035e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzfI(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x036f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0380
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0380:
                r7.zzG(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0388:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzfJ(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0399:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onP2PConnected(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x03aa:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onP2PDisconnected(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x03bb:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x03cc
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x03cc:
                r7.zzH(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x03d4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x03f3
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x03eb:
                r7.zzc(r1, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x03f3:
                r0 = r5
                goto L_0x03eb
            L_0x03f5:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0406
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0406:
                r7.zzs(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x040e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x041f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x041f:
                r7.zzt(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0427:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0438
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0438:
                r7.zzu(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0440:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0451
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0451:
                r7.zzv(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0459:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzh(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x046e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x047f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x047f:
                r7.zzw(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0487:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onTurnBasedMatchRemoved(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0498:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onInvitationRemoved(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x04a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04ba
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04ba:
                r7.zzo(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x04c2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04d3
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04d3:
                r7.zzr(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x04db:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                java.lang.String r0 = r9.readString()
                r7.onRequestRemoved(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x04ec:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x04fd
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x04fd:
                r7.zzI(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0505:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0516
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0516:
                r7.zzJ(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x051e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x053d
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0535:
                r7.zzd(r1, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x053d:
                r0 = r5
                goto L_0x0535
            L_0x053f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0550
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0550:
                r7.zzK(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0558:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0577
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x056f:
                r7.zze(r1, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0577:
                r0 = r5
                goto L_0x056f
            L_0x0579:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x058a
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x058a:
                r7.zzL(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0592:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05ba
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r0 = r0.createFromParcel(r9)
                r1 = r0
            L_0x05a4:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x05bc
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
            L_0x05b2:
                r7.zza(r1, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x05ba:
                r1 = r5
                goto L_0x05a4
            L_0x05bc:
                r0 = r5
                goto L_0x05b2
            L_0x05be:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0609
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r1 = r0.createFromParcel(r9)
            L_0x05cf:
                java.lang.String r2 = r9.readString()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x060b
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r3 = r0
            L_0x05e2:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x060d
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r4 = r0
            L_0x05f1:
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0600
                android.os.Parcelable$Creator<com.google.android.gms.drive.Contents> r0 = com.google.android.gms.drive.Contents.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                com.google.android.gms.drive.Contents r0 = (com.google.android.gms.drive.Contents) r0
                r5 = r0
            L_0x0600:
                r0 = r7
                r0.zza(r1, r2, r3, r4, r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0609:
                r1 = r5
                goto L_0x05cf
            L_0x060b:
                r3 = r5
                goto L_0x05e2
            L_0x060d:
                r4 = r5
                goto L_0x05f1
            L_0x060f:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0620
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0620:
                r7.zzM(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0628:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                java.lang.String r1 = r9.readString()
                r7.zzi(r0, r1)
                r10.writeNoException()
                goto L_0x0009
            L_0x063d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x065c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0654:
                r7.zzf(r1, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x065c:
                r0 = r5
                goto L_0x0654
            L_0x065e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x066f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x066f:
                r7.zzS(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0677:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0688
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0688:
                r7.zzg(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0690:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06a1
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06a1:
                r7.zzN(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06a9:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06ba
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06ba:
                r7.zzO(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06c2:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06d3
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06d3:
                r7.zzP(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06db:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x06ec
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x06ec:
                r7.zzQ(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x06f4:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x0705
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x0705:
                r7.zzR(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x070d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r1 = r9.readInt()
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x072c
                android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r9)
                android.os.Bundle r0 = (android.os.Bundle) r0
            L_0x0724:
                r7.zzg(r1, r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x072c:
                r0 = r5
                goto L_0x0724
            L_0x072e:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x073f
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x073f:
                r7.zzT(r5)
                r10.writeNoException()
                goto L_0x0009
            L_0x0747:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                r7.zzfK(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x0758:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                java.lang.Object[] r0 = r9.createTypedArray(r0)
                com.google.android.gms.common.data.DataHolder[] r0 = (com.google.android.gms.common.data.DataHolder[]) r0
                r7.zza(r0)
                r10.writeNoException()
                goto L_0x0009
            L_0x076d:
                java.lang.String r0 = "com.google.android.gms.games.internal.IGamesCallbacks"
                r9.enforceInterface(r0)
                int r0 = r9.readInt()
                if (r0 == 0) goto L_0x077e
                com.google.android.gms.common.data.zze r0 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r5 = r0.createFromParcel(r9)
            L_0x077e:
                r7.zzU(r5)
                r10.writeNoException()
                goto L_0x0009
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.IGamesCallbacks.Stub.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onInvitationRemoved(String str) throws RemoteException;

    void onLeftRoom(int i, String str) throws RemoteException;

    void onP2PConnected(String str) throws RemoteException;

    void onP2PDisconnected(String str) throws RemoteException;

    void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException;

    void onRequestRemoved(String str) throws RemoteException;

    void onTurnBasedMatchRemoved(String str) throws RemoteException;

    void zzA(DataHolder dataHolder) throws RemoteException;

    void zzB(DataHolder dataHolder) throws RemoteException;

    void zzC(DataHolder dataHolder) throws RemoteException;

    void zzD(DataHolder dataHolder) throws RemoteException;

    void zzE(DataHolder dataHolder) throws RemoteException;

    void zzF(DataHolder dataHolder) throws RemoteException;

    void zzG(DataHolder dataHolder) throws RemoteException;

    void zzH(DataHolder dataHolder) throws RemoteException;

    void zzI(DataHolder dataHolder) throws RemoteException;

    void zzJ(DataHolder dataHolder) throws RemoteException;

    void zzK(DataHolder dataHolder) throws RemoteException;

    void zzL(DataHolder dataHolder) throws RemoteException;

    void zzM(DataHolder dataHolder) throws RemoteException;

    void zzN(DataHolder dataHolder) throws RemoteException;

    void zzO(DataHolder dataHolder) throws RemoteException;

    void zzP(DataHolder dataHolder) throws RemoteException;

    void zzQ(DataHolder dataHolder) throws RemoteException;

    void zzR(DataHolder dataHolder) throws RemoteException;

    void zzS(DataHolder dataHolder) throws RemoteException;

    void zzT(DataHolder dataHolder) throws RemoteException;

    void zzU(DataHolder dataHolder) throws RemoteException;

    void zza(int i, String str, boolean z) throws RemoteException;

    void zza(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException;

    void zza(DataHolder dataHolder, Contents contents) throws RemoteException;

    void zza(DataHolder dataHolder, String str, Contents contents, Contents contents2, Contents contents3) throws RemoteException;

    void zza(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zza(DataHolder[] dataHolderArr) throws RemoteException;

    void zzb(int i, int i2, String str) throws RemoteException;

    void zzb(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzc(int i, Bundle bundle) throws RemoteException;

    void zzc(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzd(int i, Bundle bundle) throws RemoteException;

    void zzd(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zze(int i, Bundle bundle) throws RemoteException;

    void zze(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzf(int i, Bundle bundle) throws RemoteException;

    void zzf(int i, String str) throws RemoteException;

    void zzf(DataHolder dataHolder) throws RemoteException;

    void zzf(DataHolder dataHolder, String[] strArr) throws RemoteException;

    void zzfI(int i) throws RemoteException;

    void zzfJ(int i) throws RemoteException;

    void zzfK(int i) throws RemoteException;

    void zzg(int i, Bundle bundle) throws RemoteException;

    void zzg(int i, String str) throws RemoteException;

    void zzg(DataHolder dataHolder) throws RemoteException;

    void zzh(int i, String str) throws RemoteException;

    void zzh(DataHolder dataHolder) throws RemoteException;

    void zzi(int i, String str) throws RemoteException;

    void zzi(DataHolder dataHolder) throws RemoteException;

    void zzj(DataHolder dataHolder) throws RemoteException;

    void zzk(DataHolder dataHolder) throws RemoteException;

    void zzl(DataHolder dataHolder) throws RemoteException;

    void zzll() throws RemoteException;

    void zzm(DataHolder dataHolder) throws RemoteException;

    void zzn(DataHolder dataHolder) throws RemoteException;

    void zzo(DataHolder dataHolder) throws RemoteException;

    void zzp(DataHolder dataHolder) throws RemoteException;

    void zzq(DataHolder dataHolder) throws RemoteException;

    void zzr(DataHolder dataHolder) throws RemoteException;

    void zzs(DataHolder dataHolder) throws RemoteException;

    void zzt(DataHolder dataHolder) throws RemoteException;

    void zzu(DataHolder dataHolder) throws RemoteException;

    void zzv(DataHolder dataHolder) throws RemoteException;

    void zzw(DataHolder dataHolder) throws RemoteException;

    void zzx(DataHolder dataHolder) throws RemoteException;

    void zzy(DataHolder dataHolder) throws RemoteException;

    void zzz(DataHolder dataHolder) throws RemoteException;
}
