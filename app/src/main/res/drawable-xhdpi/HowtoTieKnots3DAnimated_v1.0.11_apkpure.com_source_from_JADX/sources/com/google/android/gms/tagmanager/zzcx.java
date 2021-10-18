package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;

class zzcx implements zzac {
    private final Context zzaRY;
    private final String zzaSp = zza("GoogleTagManager", "4.00", VERSION.RELEASE, zzc(Locale.getDefault()), Build.MODEL, Build.ID);
    private final HttpClient zzaSq;
    private zza zzaSr;

    public interface zza {
        void zza(zzaq zzaq);

        void zzb(zzaq zzaq);

        void zzc(zzaq zzaq);
    }

    zzcx(HttpClient httpClient, Context context, zza zza2) {
        this.zzaRY = context.getApplicationContext();
        this.zzaSq = httpClient;
        this.zzaSr = zza2;
    }

    private void zza(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Header obj : httpEntityEnclosingRequest.getAllHeaders()) {
            stringBuffer.append(obj.toString()).append("\n");
        }
        stringBuffer.append(httpEntityEnclosingRequest.getRequestLine().toString()).append("\n");
        if (httpEntityEnclosingRequest.getEntity() != null) {
            try {
                InputStream content = httpEntityEnclosingRequest.getEntity().getContent();
                if (content != null) {
                    int available = content.available();
                    if (available > 0) {
                        byte[] bArr = new byte[available];
                        content.read(bArr);
                        stringBuffer.append("POST:\n");
                        stringBuffer.append(new String(bArr)).append("\n");
                    }
                }
            } catch (IOException e) {
                zzbg.m29v("Error Writing hit to log...");
            }
        }
        zzbg.m29v(stringBuffer.toString());
    }

    static String zzc(Locale locale) {
        if (locale == null || locale.getLanguage() == null || locale.getLanguage().length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(locale.getLanguage().toLowerCase());
        if (!(locale.getCountry() == null || locale.getCountry().length() == 0)) {
            sb.append("-").append(locale.getCountry().toLowerCase());
        }
        return sb.toString();
    }

    private HttpEntityEnclosingRequest zzd(URL url) {
        URISyntaxException e;
        HttpEntityEnclosingRequest httpEntityEnclosingRequest;
        try {
            httpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", url.toURI().toString());
            try {
                httpEntityEnclosingRequest.addHeader("User-Agent", this.zzaSp);
            } catch (URISyntaxException e2) {
                e = e2;
                zzbg.zzaE("Exception sending hit: " + e.getClass().getSimpleName());
                zzbg.zzaE(e.getMessage());
                return httpEntityEnclosingRequest;
            }
        } catch (URISyntaxException e3) {
            URISyntaxException uRISyntaxException = e3;
            httpEntityEnclosingRequest = null;
            e = uRISyntaxException;
            zzbg.zzaE("Exception sending hit: " + e.getClass().getSimpleName());
            zzbg.zzaE(e.getMessage());
            return httpEntityEnclosingRequest;
        }
        return httpEntityEnclosingRequest;
    }

    /* access modifiers changed from: 0000 */
    public String zza(String str, String str2, String str3, String str4, String str5, String str6) {
        return String.format("%s/%s (Linux; U; Android %s; %s; %s Build/%s)", new Object[]{str, str2, str3, str4, str5, str6});
    }

    /* access modifiers changed from: 0000 */
    public URL zzd(zzaq zzaq) {
        try {
            return new URL(zzaq.zzAg());
        } catch (MalformedURLException e) {
            zzbg.m28e("Error trying to parse the GTM url.");
            return null;
        }
    }

    public void zzr(List<zzaq> list) {
        boolean z;
        int min = Math.min(list.size(), 40);
        boolean z2 = true;
        int i = 0;
        while (i < min) {
            zzaq zzaq = (zzaq) list.get(i);
            URL zzd = zzd(zzaq);
            if (zzd == null) {
                zzbg.zzaE("No destination: discarding hit.");
                this.zzaSr.zzb(zzaq);
                z = z2;
            } else {
                HttpEntityEnclosingRequest zzd2 = zzd(zzd);
                if (zzd2 == null) {
                    this.zzaSr.zzb(zzaq);
                    z = z2;
                } else {
                    HttpHost httpHost = new HttpHost(zzd.getHost(), zzd.getPort(), zzd.getProtocol());
                    zzd2.addHeader("Host", httpHost.toHostString());
                    zza(zzd2);
                    if (z2) {
                        try {
                            zzbl.zzaQ(this.zzaRY);
                            z2 = false;
                        } catch (ClientProtocolException e) {
                            zzbg.zzaE("ClientProtocolException sending hit; discarding hit...");
                            this.zzaSr.zzb(zzaq);
                            z = z2;
                        } catch (IOException e2) {
                            zzbg.zzaE("Exception sending hit: " + e2.getClass().getSimpleName());
                            zzbg.zzaE(e2.getMessage());
                            this.zzaSr.zzc(zzaq);
                            z = z2;
                        }
                    }
                    HttpResponse execute = this.zzaSq.execute(httpHost, zzd2);
                    int statusCode = execute.getStatusLine().getStatusCode();
                    HttpEntity entity = execute.getEntity();
                    if (entity != null) {
                        entity.consumeContent();
                    }
                    if (statusCode != 200) {
                        zzbg.zzaE("Bad response: " + execute.getStatusLine().getStatusCode());
                        this.zzaSr.zzc(zzaq);
                    } else {
                        this.zzaSr.zza(zzaq);
                    }
                    z = z2;
                }
            }
            i++;
            z2 = z;
        }
    }

    public boolean zzzX() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.zzaRY.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        zzbg.m29v("...no network connectivity");
        return false;
    }
}
