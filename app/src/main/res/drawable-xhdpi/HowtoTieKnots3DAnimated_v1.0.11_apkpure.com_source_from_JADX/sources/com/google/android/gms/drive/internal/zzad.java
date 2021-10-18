package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.ProgressEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzj;
import com.google.android.gms.drive.events.zzl;
import java.util.ArrayList;
import java.util.List;

public class zzad extends com.google.android.gms.drive.internal.zzan.zza {
    private final int zzafk;
    private final zzf zzajf;
    private final zza zzajg;
    private final List<Integer> zzajh = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzl zzl, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzqA = queryResultEventParcelable.zzqA();
            if (zzqA != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(zzqA);
                zzl.zza(new zzj() {
                });
            }
            if (queryResultEventParcelable.zzqB()) {
                zzl.zzcs(queryResultEventParcelable.zzqC());
            }
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    Pair pair = (Pair) msg.obj;
                    zzf zzf = (zzf) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) zzf).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) zzf).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            zza((zzl) zzf, (QueryResultEventParcelable) driveEvent);
                            return;
                        case 4:
                            ((zzc) zzf).zza((ChangesAvailableEvent) driveEvent);
                            return;
                        case 5:
                        case 6:
                            ((zzi) zzf).zza((ProgressEvent) driveEvent);
                            return;
                        default:
                            zzy.zzw("EventCallback", "Unexpected event: " + driveEvent);
                            return;
                    }
                default:
                    zzy.zzf(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzf zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(zzf, driveEvent)));
        }
    }

    public zzad(Looper looper, Context context, int i, zzf zzf) {
        this.zzafk = i;
        this.zzajf = zzf;
        this.zzajg = new zza(looper, context);
    }

    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzqS = onEventResponse.zzqS();
        zzx.zzY(this.zzafk == zzqS.getType());
        zzx.zzY(this.zzajh.contains(Integer.valueOf(zzqS.getType())));
        this.zzajg.zza(this.zzajf, zzqS);
    }

    public void zzcJ(int i) {
        this.zzajh.add(Integer.valueOf(i));
    }

    public boolean zzcK(int i) {
        return this.zzajh.contains(Integer.valueOf(i));
    }
}
