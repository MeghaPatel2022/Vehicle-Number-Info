package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zze {
    public static final zze zzacG = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(8192, 8202));
    public static final zze zzacH = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(8192, 8198)).zza(zza(8200, 8202));
    public static final zze zzacI = zza(0, 127);
    public static final zze zzacJ;
    public static final zze zzacK = zza(9, 13).zza(zza(28, ' ')).zza(zzc(5760)).zza(zzc(6158)).zza(zza(8192, 8198)).zza(zza(8200, 8203)).zza(zza(8232, 8233)).zza(zzc(8287)).zza(zzc(12288));
    public static final zze zzacL = new zze() {
        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    };
    public static final zze zzacM = new zze() {
        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    };
    public static final zze zzacN = new zze() {
        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    };
    public static final zze zzacO = new zze() {
        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    };
    public static final zze zzacP = new zze() {
        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    };
    public static final zze zzacQ = zza(0, 31).zza(zza(127, 159));
    public static final zze zzacR = zza(0, ' ').zza(zza(127, 160)).zza(zzc(173)).zza(zza(1536, 1539)).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(8192, 8207)).zza(zza(8232, 8239)).zza(zza(8287, 8292)).zza(zza(8298, 8303)).zza(zzc(12288)).zza(zza(55296, 63743)).zza(zza((CharSequence) "﻿￹￺￻"));
    public static final zze zzacS = zza(0, 1273).zza(zzc(1470)).zza(zza(1488, 1514)).zza(zzc(1523)).zza(zzc(1524)).zza(zza(1536, 1791)).zza(zza(1872, 1919)).zza(zza(3584, 3711)).zza(zza(7680, 8367)).zza(zza(8448, 8506)).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));
    public static final zze zzacT = new zze() {
        public zze zza(zze zze) {
            zzx.zzv(zze);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzx.zzv(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    };
    public static final zze zzacU = new zze() {
        public zze zza(zze zze) {
            return (zze) zzx.zzv(zze);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };

    private static class zza extends zze {
        List<zze> zzadb;

        zza(List<zze> list) {
            this.zzadb = list;
        }

        public zze zza(zze zze) {
            ArrayList arrayList = new ArrayList(this.zzadb);
            arrayList.add(zzx.zzv(zze));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zze zzd : this.zzadb) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        char[] charArray;
        zze zza2 = zza('0', '9');
        zze zze = zza2;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zze = zze.zza(zza(c, (char) (c + 9)));
        }
        zzacJ = zze;
    }

    public static zze zza(final char c, final char c2) {
        zzx.zzZ(c2 >= c);
        return new zze() {
            public boolean zzd(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    public static zze zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return zzacU;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new zze() {
                    public boolean zzd(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zze() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zze zzc(final char c) {
        return new zze() {
            public zze zza(zze zze) {
                return zze.zzd(c) ? zze : zze.super.zza(zze);
            }

            public boolean zzd(char c) {
                return c == c;
            }
        };
    }

    public zze zza(zze zze) {
        return new zza(Arrays.asList(new zze[]{this, (zze) zzx.zzv(zze)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
