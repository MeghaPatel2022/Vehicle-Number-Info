package com.google.android.gms.analytics.internal;

import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzp;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

abstract class zzq<T extends zzp> extends zzc {
    zza<T> zzMM;

    public interface zza<U extends zzp> {
        void zzc(String str, boolean z);

        void zzd(String str, int i);

        U zzjj();

        void zzl(String str, String str2);

        void zzm(String str, String str2);
    }

    public zzq(zzf zzf, zza<T> zza2) {
        super(zzf);
        this.zzMM = zza2;
    }

    private T zza(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase();
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.zzMM.zzl(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.zzMM.zzm(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.zzMM.zzc(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                zzc("Error parsing bool configuration value", trim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.zzMM.zzd(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                zzc("Error parsing int configuration value", trim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (XmlPullParserException e3) {
            zze("Error parsing tracker configuration file", e3);
        } catch (IOException e4) {
            zze("Error parsing tracker configuration file", e4);
        }
        return this.zzMM.zzjj();
    }

    public T zzac(int i) {
        try {
            return zza(zzia().zziq().getResources().getXml(i));
        } catch (NotFoundException e) {
            zzd("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
