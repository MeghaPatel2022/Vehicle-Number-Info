package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzkq;

public final class zzy {
    public static zza<Boolean> zzMY = zza.zzd("analytics.service_enabled", false);
    public static zza<Boolean> zzMZ = zza.zzd("analytics.service_client_enabled", true);
    public static zza<Integer> zzNA = zza.zze("analytics.batch_retry_interval.seconds.k", 3600);
    public static zza<Long> zzNB = zza.zzc("analytics.service_monitor_interval", 86400000);
    public static zza<Integer> zzNC = zza.zze("analytics.http_connection.connect_timeout_millis", 60000);
    public static zza<Integer> zzND = zza.zze("analytics.http_connection.read_timeout_millis", 61000);
    public static zza<Long> zzNE = zza.zzc("analytics.campaigns.time_limit", 86400000);
    public static zza<String> zzNF = zza.zzn("analytics.first_party_experiment_id", "");
    public static zza<Integer> zzNG = zza.zze("analytics.first_party_experiment_variant", 0);
    public static zza<Boolean> zzNH = zza.zzd("analytics.test.disable_receiver", false);
    public static zza<Long> zzNI = zza.zza("analytics.service_client.idle_disconnect_millis", 10000, 10000);
    public static zza<Long> zzNJ = zza.zzc("analytics.service_client.connect_timeout_millis", 5000);
    public static zza<Long> zzNK = zza.zzc("analytics.service_client.second_connect_delay_millis", 5000);
    public static zza<Long> zzNL = zza.zzc("analytics.service_client.unexpected_reconnect_millis", 60000);
    public static zza<Long> zzNM = zza.zzc("analytics.service_client.reconnect_throttle_millis", 1800000);
    public static zza<Long> zzNN = zza.zzc("analytics.monitoring.sample_period_millis", 86400000);
    public static zza<Long> zzNO = zza.zzc("analytics.initialization_warning_threshold", 5000);
    public static zza<String> zzNa = zza.zzd("analytics.log_tag", "GAv4", "GAv4-SVC");
    public static zza<Long> zzNb = zza.zzc("analytics.max_tokens", 60);
    public static zza<Float> zzNc = zza.zza("analytics.tokens_per_sec", 0.5f);
    public static zza<Integer> zzNd = zza.zza("analytics.max_stored_hits", 2000, 20000);
    public static zza<Integer> zzNe = zza.zze("analytics.max_stored_hits_per_app", 2000);
    public static zza<Integer> zzNf = zza.zze("analytics.max_stored_properties_per_app", 100);
    public static zza<Long> zzNg = zza.zza("analytics.local_dispatch_millis", 1800000, 120000);
    public static zza<Long> zzNh = zza.zza("analytics.initial_local_dispatch_millis", 5000, 5000);
    public static zza<Long> zzNi = zza.zzc("analytics.min_local_dispatch_millis", 120000);
    public static zza<Long> zzNj = zza.zzc("analytics.max_local_dispatch_millis", 7200000);
    public static zza<Long> zzNk = zza.zzc("analytics.dispatch_alarm_millis", 7200000);
    public static zza<Long> zzNl = zza.zzc("analytics.max_dispatch_alarm_millis", 32400000);
    public static zza<Integer> zzNm = zza.zze("analytics.max_hits_per_dispatch", 20);
    public static zza<Integer> zzNn = zza.zze("analytics.max_hits_per_batch", 20);
    public static zza<String> zzNo = zza.zzn("analytics.insecure_host", "http://www.google-analytics.com");
    public static zza<String> zzNp = zza.zzn("analytics.secure_host", "https://ssl.google-analytics.com");
    public static zza<String> zzNq = zza.zzn("analytics.simple_endpoint", "/collect");
    public static zza<String> zzNr = zza.zzn("analytics.batching_endpoint", "/batch");
    public static zza<Integer> zzNs = zza.zze("analytics.max_get_length", 2036);
    public static zza<String> zzNt = zza.zzd("analytics.batching_strategy.k", zzm.BATCH_BY_COUNT.name(), zzm.BATCH_BY_COUNT.name());
    public static zza<String> zzNu = zza.zzn("analytics.compression_strategy.k", zzo.GZIP.name());
    public static zza<Integer> zzNv = zza.zze("analytics.max_hits_per_request.k", 20);
    public static zza<Integer> zzNw = zza.zze("analytics.max_hit_length.k", 8192);
    public static zza<Integer> zzNx = zza.zze("analytics.max_post_length.k", 8192);
    public static zza<Integer> zzNy = zza.zze("analytics.max_batch_post_length", 8192);
    public static zza<String> zzNz = zza.zzn("analytics.fallback_responses.k", "404,502");

    public static final class zza<V> {
        private final V zzNP;
        private final zzkq<V> zzNQ;
        private V zzNR;

        private zza(zzkq<V> zzkq, V v) {
            zzx.zzv(zzkq);
            this.zzNQ = zzkq;
            this.zzNP = v;
        }

        static zza<Float> zza(String str, float f) {
            return zza(str, f, f);
        }

        static zza<Float> zza(String str, float f, float f2) {
            return new zza<>(zzkq.zza(str, Float.valueOf(f2)), Float.valueOf(f));
        }

        static zza<Integer> zza(String str, int i, int i2) {
            return new zza<>(zzkq.zza(str, Integer.valueOf(i2)), Integer.valueOf(i));
        }

        static zza<Long> zza(String str, long j, long j2) {
            return new zza<>(zzkq.zza(str, Long.valueOf(j2)), Long.valueOf(j));
        }

        static zza<Boolean> zza(String str, boolean z, boolean z2) {
            return new zza<>(zzkq.zzg(str, z2), Boolean.valueOf(z));
        }

        static zza<Long> zzc(String str, long j) {
            return zza(str, j, j);
        }

        static zza<String> zzd(String str, String str2, String str3) {
            return new zza<>(zzkq.zzu(str, str3), str2);
        }

        static zza<Boolean> zzd(String str, boolean z) {
            return zza(str, z, z);
        }

        static zza<Integer> zze(String str, int i) {
            return zza(str, i, i);
        }

        static zza<String> zzn(String str, String str2) {
            return zzd(str, str2, str2);
        }

        public V get() {
            return this.zzNR != null ? this.zzNR : (!zzd.zzacF || !zzkq.isInitialized()) ? this.zzNP : this.zzNQ.zznN();
        }
    }
}
