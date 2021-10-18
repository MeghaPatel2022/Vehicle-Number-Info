package com.google.android.gms.analytics.internal;

public class zzak extends zzq<zzal> {

    private static class zza extends zzc implements com.google.android.gms.analytics.internal.zzq.zza<zzal> {
        private final zzal zzOD = new zzal();

        public zza(zzf zzf) {
            super(zzf);
        }

        public void zzc(String str, boolean z) {
            int i = 1;
            if ("ga_autoActivityTracking".equals(str)) {
                zzal zzal = this.zzOD;
                if (!z) {
                    i = 0;
                }
                zzal.zzOG = i;
            } else if ("ga_anonymizeIp".equals(str)) {
                zzal zzal2 = this.zzOD;
                if (!z) {
                    i = 0;
                }
                zzal2.zzOH = i;
            } else if ("ga_reportUncaughtExceptions".equals(str)) {
                zzal zzal3 = this.zzOD;
                if (!z) {
                    i = 0;
                }
                zzal3.zzOI = i;
            } else {
                zzd("bool configuration name not recognized", str);
            }
        }

        public void zzd(String str, int i) {
            if ("ga_sessionTimeout".equals(str)) {
                this.zzOD.zzOF = i;
            } else {
                zzd("int configuration name not recognized", str);
            }
        }

        /* renamed from: zzkL */
        public zzal zzjj() {
            return this.zzOD;
        }

        public void zzl(String str, String str2) {
            this.zzOD.zzOJ.put(str, str2);
        }

        public void zzm(String str, String str2) {
            if ("ga_trackingId".equals(str)) {
                this.zzOD.zztw = str2;
            } else if ("ga_sampleFrequency".equals(str)) {
                try {
                    this.zzOD.zzOE = Double.parseDouble(str2);
                } catch (NumberFormatException e) {
                    zzc("Error parsing ga_sampleFrequency value", str2, e);
                }
            } else {
                zzd("string configuration name not recognized", str);
            }
        }
    }

    public zzak(zzf zzf) {
        super(zzf, new zza(zzf));
    }
}
