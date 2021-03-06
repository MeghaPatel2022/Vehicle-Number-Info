package com.google.android.gms.internal;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.drive.DriveFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzgk
public final class zzdn implements zzdg {
    private final zze zzxj;
    private final zzew zzxk;
    private final zzdi zzxm;

    public static class zza extends zzhq {
        private final String zzF;
        private final zzip zzoL;
        private final String zzxn = "play.google.com";
        private final String zzxo = "market";
        private final int zzxp = 10;

        public zza(zzip zzip, String str) {
            this.zzoL = zzip;
            this.zzF = str;
        }

        public void onStop() {
        }

        public Intent zzY(String str) {
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(parse);
            return intent;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:30:0x008b, code lost:
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Arrived at landing page, this ideally should not happen. Will open it in browser.");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0093, code lost:
            r0 = r2;
         */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x00a6 A[SYNTHETIC, Splitter:B:39:0x00a6] */
        /* JADX WARNING: Removed duplicated region for block: B:64:0x008b A[EDGE_INSN: B:64:0x008b->B:30:0x008b ?: BREAK  
        EDGE_INSN: B:64:0x008b->B:30:0x008b ?: BREAK  
        EDGE_INSN: B:64:0x008b->B:30:0x008b ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void zzdG() {
            /*
                r8 = this;
                r0 = 0
                java.lang.String r2 = r8.zzF
            L_0x0003:
                r1 = 10
                if (r0 >= r1) goto L_0x0115
                int r4 = r0 + 1
                java.net.URL r0 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                r0.<init>(r2)     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                java.lang.String r1 = "play.google.com"
                java.lang.String r3 = r0.getHost()     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                if (r1 == 0) goto L_0x0029
                r0 = r2
            L_0x001b:
                android.content.Intent r0 = r8.zzY(r0)
                com.google.android.gms.internal.zzip r1 = r8.zzoL
                android.content.Context r1 = r1.getContext()
                r1.startActivity(r0)
                return
            L_0x0029:
                java.lang.String r1 = "market"
                java.lang.String r3 = r0.getProtocol()     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                boolean r1 = r1.equalsIgnoreCase(r3)     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                if (r1 == 0) goto L_0x0037
                r0 = r2
                goto L_0x001b
            L_0x0037:
                java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                com.google.android.gms.internal.zzhu r1 = com.google.android.gms.ads.internal.zzp.zzbx()     // Catch:{ all -> 0x00ad }
                com.google.android.gms.internal.zzip r3 = r8.zzoL     // Catch:{ all -> 0x00ad }
                android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x00ad }
                com.google.android.gms.internal.zzip r5 = r8.zzoL     // Catch:{ all -> 0x00ad }
                com.google.android.gms.ads.internal.util.client.VersionInfoParcel r5 = r5.zzgV()     // Catch:{ all -> 0x00ad }
                java.lang.String r5 = r5.zzIz     // Catch:{ all -> 0x00ad }
                r6 = 0
                r1.zza(r3, r5, r6, r0)     // Catch:{ all -> 0x00ad }
                int r1 = r0.getResponseCode()     // Catch:{ all -> 0x00ad }
                java.util.Map r5 = r0.getHeaderFields()     // Catch:{ all -> 0x00ad }
                java.lang.String r3 = ""
                r6 = 300(0x12c, float:4.2E-43)
                if (r1 < r6) goto L_0x0112
                r6 = 399(0x18f, float:5.59E-43)
                if (r1 > r6) goto L_0x0112
                r1 = 0
                java.lang.String r6 = "Location"
                boolean r6 = r5.containsKey(r6)     // Catch:{ all -> 0x00ad }
                if (r6 == 0) goto L_0x0095
                java.lang.String r1 = "Location"
                java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x00ad }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00ad }
            L_0x0076:
                if (r1 == 0) goto L_0x0112
                int r5 = r1.size()     // Catch:{ all -> 0x00ad }
                if (r5 <= 0) goto L_0x0112
                r3 = 0
                java.lang.Object r1 = r1.get(r3)     // Catch:{ all -> 0x00ad }
                java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00ad }
            L_0x0085:
                boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00ad }
                if (r3 == 0) goto L_0x00a6
                java.lang.String r1 = "Arrived at landing page, this ideally should not happen. Will open it in browser."
                com.google.android.gms.ads.internal.util.client.zzb.zzaE(r1)     // Catch:{ all -> 0x00ad }
                r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                r0 = r2
                goto L_0x001b
            L_0x0095:
                java.lang.String r6 = "location"
                boolean r6 = r5.containsKey(r6)     // Catch:{ all -> 0x00ad }
                if (r6 == 0) goto L_0x0076
                java.lang.String r1 = "location"
                java.lang.Object r1 = r5.get(r1)     // Catch:{ all -> 0x00ad }
                java.util.List r1 = (java.util.List) r1     // Catch:{ all -> 0x00ad }
                goto L_0x0076
            L_0x00a6:
                r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x010d, IOException -> 0x0108, RuntimeException -> 0x0103 }
                r0 = r4
                r2 = r1
                goto L_0x0003
            L_0x00ad:
                r1 = move-exception
                r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
                throw r1     // Catch:{ IndexOutOfBoundsException -> 0x00b2, IOException -> 0x00cd, RuntimeException -> 0x00e8 }
            L_0x00b2:
                r0 = move-exception
                r1 = r0
                r0 = r2
            L_0x00b5:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error while parsing ping URL: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r1)
                goto L_0x001b
            L_0x00cd:
                r0 = move-exception
                r1 = r0
                r0 = r2
            L_0x00d0:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error while pinging URL: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r1)
                goto L_0x001b
            L_0x00e8:
                r0 = move-exception
                r1 = r0
                r0 = r2
            L_0x00eb:
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Error while pinging URL: "
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.StringBuilder r2 = r2.append(r0)
                java.lang.String r2 = r2.toString()
                com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r1)
                goto L_0x001b
            L_0x0103:
                r0 = move-exception
                r7 = r0
                r0 = r1
                r1 = r7
                goto L_0x00eb
            L_0x0108:
                r0 = move-exception
                r7 = r0
                r0 = r1
                r1 = r7
                goto L_0x00d0
            L_0x010d:
                r0 = move-exception
                r7 = r0
                r0 = r1
                r1 = r7
                goto L_0x00b5
            L_0x0112:
                r1 = r3
                goto L_0x0085
            L_0x0115:
                r0 = r2
                goto L_0x001b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdn.zza.zzdG():void");
        }
    }

    public static class zzb {
        public Intent zza(Intent intent, ResolveInfo resolveInfo) {
            Intent intent2 = new Intent(intent);
            intent2.setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            return intent2;
        }

        public ResolveInfo zza(Context context, Intent intent) {
            return zza(context, intent, new ArrayList());
        }

        public ResolveInfo zza(Context context, Intent intent, ArrayList<ResolveInfo> arrayList) {
            ResolveInfo resolveInfo;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            List queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    }
                    ResolveInfo resolveInfo2 = (ResolveInfo) queryIntentActivities.get(i2);
                    if (resolveActivity != null && resolveActivity.activityInfo.name.equals(resolveInfo2.activityInfo.name)) {
                        resolveInfo = resolveActivity;
                        break;
                    }
                    i = i2 + 1;
                }
            }
            resolveInfo = null;
            arrayList.addAll(queryIntentActivities);
            return resolveInfo;
        }

        public Intent zzb(Context context, Map<String, String> map) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str = (String) map.get("u");
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Uri parse = Uri.parse(str);
            boolean parseBoolean = Boolean.parseBoolean((String) map.get("use_first_package"));
            boolean parseBoolean2 = Boolean.parseBoolean((String) map.get("use_running_process"));
            Uri uri = "http".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("https").build() : "https".equalsIgnoreCase(parse.getScheme()) ? parse.buildUpon().scheme("http").build() : null;
            ArrayList arrayList = new ArrayList();
            Intent zzd = zzd(parse);
            Intent zzd2 = zzd(uri);
            ResolveInfo zza = zza(context, zzd, arrayList);
            if (zza != null) {
                return zza(zzd, zza);
            }
            if (zzd2 != null) {
                ResolveInfo zza2 = zza(context, zzd2);
                if (zza2 != null) {
                    Intent zza3 = zza(zzd, zza2);
                    if (zza(context, zza3) != null) {
                        return zza3;
                    }
                }
            }
            if (arrayList.size() == 0) {
                return zzd;
            }
            if (parseBoolean2 && activityManager != null) {
                List runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ResolveInfo resolveInfo = (ResolveInfo) it.next();
                        Iterator it2 = runningAppProcesses.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (((RunningAppProcessInfo) it2.next()).processName.equals(resolveInfo.activityInfo.packageName)) {
                                    return zza(zzd, resolveInfo);
                                }
                            }
                        }
                    }
                }
            }
            return parseBoolean ? zza(zzd, (ResolveInfo) arrayList.get(0)) : zzd;
        }

        public Intent zzd(Uri uri) {
            if (uri == null) {
                return null;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(DriveFile.MODE_READ_ONLY);
            intent.setData(uri);
            intent.setAction("android.intent.action.VIEW");
            return intent;
        }
    }

    public zzdn(zzdi zzdi, zze zze, zzew zzew) {
        this.zzxm = zzdi;
        this.zzxj = zze;
        this.zzxk = zzew;
    }

    private static void zza(Context context, Map<String, String> map) {
        if (TextUtils.isEmpty((String) map.get("u"))) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Destination url cannot be empty.");
            return;
        }
        try {
            context.startActivity(new zzb().zzb(context, map));
        } catch (ActivityNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE(e.getMessage());
        }
    }

    private static void zzb(zzip zzip, Map<String, String> map) {
        String str = (String) map.get("u");
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Destination url cannot be empty.");
        } else {
            new zza(zzip, str).zzgn();
        }
    }

    private static boolean zzc(Map<String, String> map) {
        return "1".equals(map.get("custom_close"));
    }

    private static int zzd(Map<String, String> map) {
        String str = (String) map.get("o");
        if (str != null) {
            if ("p".equalsIgnoreCase(str)) {
                return zzp.zzbz().zzgw();
            }
            if ("l".equalsIgnoreCase(str)) {
                return zzp.zzbz().zzgv();
            }
            if ("c".equalsIgnoreCase(str)) {
                return zzp.zzbz().zzgx();
            }
        }
        return -1;
    }

    private void zzm(boolean z) {
        if (this.zzxk != null) {
            this.zzxk.zzn(z);
        }
    }

    public void zza(zzip zzip, Map<String, String> map) {
        String str;
        String str2 = (String) map.get("a");
        if (str2 == null) {
            com.google.android.gms.ads.internal.util.client.zzb.zzaE("Action missing from an open GMSG.");
        } else if (this.zzxj == null || this.zzxj.zzbe()) {
            zziq zzgS = zzip.zzgS();
            if ("expand".equalsIgnoreCase(str2)) {
                if (zzip.zzgW()) {
                    com.google.android.gms.ads.internal.util.client.zzb.zzaE("Cannot expand WebView that is already expanded.");
                    return;
                }
                zzm(false);
                zzgS.zza(zzc(map), zzd(map));
            } else if ("webapp".equalsIgnoreCase(str2)) {
                String str3 = (String) map.get("u");
                zzm(false);
                if (str3 != null) {
                    zzgS.zza(zzc(map), zzd(map), str3);
                } else {
                    zzgS.zza(zzc(map), zzd(map), (String) map.get("html"), (String) map.get("baseurl"));
                }
            } else if ("in_app_purchase".equalsIgnoreCase(str2)) {
                String str4 = (String) map.get("product_id");
                String str5 = (String) map.get("report_urls");
                if (this.zzxm == null) {
                    return;
                }
                if (str5 == null || str5.isEmpty()) {
                    this.zzxm.zza(str4, new ArrayList());
                    return;
                }
                this.zzxm.zza(str4, new ArrayList(Arrays.asList(str5.split(" "))));
            } else if ("app".equalsIgnoreCase(str2) && "true".equalsIgnoreCase((String) map.get("play_store"))) {
                zzb(zzip, map);
            } else if (!"app".equalsIgnoreCase(str2) || !"true".equalsIgnoreCase((String) map.get("system_browser"))) {
                zzm(true);
                zzan zzgU = zzip.zzgU();
                String str6 = (String) map.get("u");
                if (!TextUtils.isEmpty(str6)) {
                    if (zzgU != null && zzgU.zzb(Uri.parse(str6))) {
                        str6 = zzp.zzbx().zzd(zzip.getContext(), str6, zzip.zzha());
                    }
                    str = zzp.zzbx().zza(zzip, str6);
                } else {
                    str = str6;
                }
                zzgS.zza(new AdLauncherIntentInfoParcel((String) map.get("i"), str, (String) map.get("m"), (String) map.get("p"), (String) map.get("c"), (String) map.get("f"), (String) map.get("e")));
            } else {
                zza(zzip.getContext(), map);
            }
        } else {
            this.zzxj.zzp((String) map.get("u"));
        }
    }
}
