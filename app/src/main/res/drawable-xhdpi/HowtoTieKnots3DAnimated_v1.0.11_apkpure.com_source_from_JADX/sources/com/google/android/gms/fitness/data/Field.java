package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Field implements SafeParcelable {
    public static final Creator<Field> CREATOR = new zzi();
    public static final Field FIELD_ACCURACY = zzcS("accuracy");
    public static final Field FIELD_ACTIVITY = zzcR("activity");
    public static final Field FIELD_ALTITUDE = zzcS("altitude");
    public static final Field FIELD_AVERAGE = zzcS("average");
    public static final Field FIELD_BPM = zzcS("bpm");
    public static final Field FIELD_CALORIES = zzcS(NUTRIENT_CALORIES);
    public static final Field FIELD_CIRCUMFERENCE = zzcS("circumference");
    public static final Field FIELD_CONFIDENCE = zzcS("confidence");
    public static final Field FIELD_DISTANCE = zzcS("distance");
    public static final Field FIELD_DURATION = zzcR("duration");
    public static final Field FIELD_EXERCISE = zzcT("exercise");
    public static final Field FIELD_FOOD_ITEM = zzcT("food_item");
    public static final Field FIELD_HEIGHT = zzcS("height");
    public static final Field FIELD_HIGH_LATITUDE = zzcS("high_latitude");
    public static final Field FIELD_HIGH_LONGITUDE = zzcS("high_longitude");
    public static final Field FIELD_LATITUDE = zzcS("latitude");
    public static final Field FIELD_LONGITUDE = zzcS("longitude");
    public static final Field FIELD_LOW_LATITUDE = zzcS("low_latitude");
    public static final Field FIELD_LOW_LONGITUDE = zzcS("low_longitude");
    public static final Field FIELD_MAX = zzcS("max");
    public static final Field FIELD_MEAL_TYPE = zzcR("meal_type");
    public static final Field FIELD_MIN = zzcS("min");
    public static final Field FIELD_NUM_SEGMENTS = zzcR("num_segments");
    public static final Field FIELD_NUTRIENTS = zzcU("nutrients");
    public static final Field FIELD_PERCENTAGE = zzcS("percentage");
    public static final Field FIELD_REPETITIONS = zzcR("repetitions");
    public static final Field FIELD_RESISTANCE = zzcS("resistance");
    public static final Field FIELD_RESISTANCE_TYPE = zzcR("resistance_type");
    public static final Field FIELD_REVOLUTIONS = zzcR("revolutions");
    public static final Field FIELD_RPM = zzcS("rpm");
    public static final Field FIELD_SPEED = zzcS("speed");
    public static final Field FIELD_STEPS = zzcR("steps");
    public static final Field FIELD_WATTS = zzcS("watts");
    public static final Field FIELD_WEIGHT = zzcS("weight");
    public static final int FORMAT_FLOAT = 2;
    public static final int FORMAT_INT32 = 1;
    public static final int FORMAT_MAP = 4;
    public static final int FORMAT_STRING = 3;
    public static final int MEAL_TYPE_BREAKFAST = 1;
    public static final int MEAL_TYPE_DINNER = 3;
    public static final int MEAL_TYPE_LUNCH = 2;
    public static final int MEAL_TYPE_SNACK = 4;
    public static final int MEAL_TYPE_UNKNOWN = 0;
    public static final String NUTRIENT_CALCIUM = "calcium";
    public static final String NUTRIENT_CALORIES = "calories";
    public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
    public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
    public static final String NUTRIENT_IRON = "iron";
    public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
    public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
    public static final String NUTRIENT_POTASSIUM = "potassium";
    public static final String NUTRIENT_PROTEIN = "protein";
    public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
    public static final String NUTRIENT_SODIUM = "sodium";
    public static final String NUTRIENT_SUGAR = "sugar";
    public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
    public static final String NUTRIENT_TOTAL_FAT = "fat.total";
    public static final String NUTRIENT_TRANS_FAT = "fat.trans";
    public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
    public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
    public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
    public static final int RESISTANCE_TYPE_BARBELL = 1;
    public static final int RESISTANCE_TYPE_BODY = 6;
    public static final int RESISTANCE_TYPE_CABLE = 2;
    public static final int RESISTANCE_TYPE_DUMBBELL = 3;
    public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
    public static final int RESISTANCE_TYPE_MACHINE = 5;
    public static final int RESISTANCE_TYPE_UNKNOWN = 0;
    public static final Field zzaoc = zzcU("activity_confidence");
    public static final Field zzaod = zzcU("activity_duration");
    public static final Field zzaoe = zzcU("activity_duration.ascending");
    public static final Field zzaof = zzcU("activity_duration.descending");
    public static final Field zzaog = zzcS("elevation.change");
    public static final Field zzaoh = zzcU("elevation.gain");
    public static final Field zzaoi = zzcU("elevation.loss");
    public static final Field zzaoj = zzcS("floors");
    public static final Field zzaok = zzcU("floor.gain");
    public static final Field zzaol = zzcU("floor.loss");
    public static final Field zzaom = zzcR("edge_type");
    public static final Field zzaon = zzcS("x");
    public static final Field zzaoo = zzcS("y");
    public static final Field zzaop = zzcS("z");
    private final String mName;
    private final int mVersionCode;
    private final int zzaoq;

    Field(int versionCode, String name, int format) {
        this.mVersionCode = versionCode;
        this.mName = (String) zzx.zzv(name);
        this.zzaoq = format;
    }

    private Field(String name, int format) {
        this(1, name, format);
    }

    private boolean zza(Field field) {
        return this.mName.equals(field.mName) && this.zzaoq == field.zzaoq;
    }

    private static Field zzcR(String str) {
        return new Field(str, 1);
    }

    private static Field zzcS(String str) {
        return new Field(str, 2);
    }

    private static Field zzcT(String str) {
        return new Field(str, 3);
    }

    private static Field zzcU(String str) {
        return new Field(str, 4);
    }

    public static Field zzo(String str, int i) {
        char c = 65535;
        switch (str.hashCode()) {
            case -2131707655:
                if (str.equals("accuracy")) {
                    c = 0;
                    break;
                }
                break;
            case -1992012396:
                if (str.equals("duration")) {
                    c = 12;
                    break;
                }
                break;
            case -1655966961:
                if (str.equals("activity")) {
                    c = 1;
                    break;
                }
                break;
            case -1579612127:
                if (str.equals("floor.gain")) {
                    c = 18;
                    break;
                }
                break;
            case -1579449403:
                if (str.equals("floor.loss")) {
                    c = 19;
                    break;
                }
                break;
            case -1569430471:
                if (str.equals("num_segments")) {
                    c = ' ';
                    break;
                }
                break;
            case -1531570079:
                if (str.equals("elevation.change")) {
                    c = 14;
                    break;
                }
                break;
            case -1439978388:
                if (str.equals("latitude")) {
                    c = 25;
                    break;
                }
                break;
            case -1271636505:
                if (str.equals("floors")) {
                    c = 20;
                    break;
                }
                break;
            case -1221029593:
                if (str.equals("height")) {
                    c = 22;
                    break;
                }
                break;
            case -1133736764:
                if (str.equals("activity_duration")) {
                    c = 2;
                    break;
                }
                break;
            case -1110756780:
                if (str.equals("food_item")) {
                    c = 21;
                    break;
                }
                break;
            case -921832806:
                if (str.equals("percentage")) {
                    c = '\"';
                    break;
                }
                break;
            case -791592328:
                if (str.equals("weight")) {
                    c = '+';
                    break;
                }
                break;
            case -631448035:
                if (str.equals("average")) {
                    c = 6;
                    break;
                }
                break;
            case -626344110:
                if (str.equals("high_longitude")) {
                    c = 24;
                    break;
                }
                break;
            case -619868540:
                if (str.equals("low_longitude")) {
                    c = 28;
                    break;
                }
                break;
            case -494782871:
                if (str.equals("high_latitude")) {
                    c = 23;
                    break;
                }
                break;
            case -437053898:
                if (str.equals("meal_type")) {
                    c = 30;
                    break;
                }
                break;
            case -277306353:
                if (str.equals("circumference")) {
                    c = 9;
                    break;
                }
                break;
            case -266093204:
                if (str.equals("nutrients")) {
                    c = '!';
                    break;
                }
                break;
            case -168965370:
                if (str.equals(NUTRIENT_CALORIES)) {
                    c = 8;
                    break;
                }
                break;
            case -126538880:
                if (str.equals("resistance_type")) {
                    c = '%';
                    break;
                }
                break;
            case 120:
                if (str.equals("x")) {
                    c = ',';
                    break;
                }
                break;
            case 121:
                if (str.equals("y")) {
                    c = '-';
                    break;
                }
                break;
            case 122:
                if (str.equals("z")) {
                    c = '.';
                    break;
                }
                break;
            case 97759:
                if (str.equals("bpm")) {
                    c = 7;
                    break;
                }
                break;
            case 107876:
                if (str.equals("max")) {
                    c = 29;
                    break;
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    c = 31;
                    break;
                }
                break;
            case 113135:
                if (str.equals("rpm")) {
                    c = '\'';
                    break;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    c = '(';
                    break;
                }
                break;
            case 109761319:
                if (str.equals("steps")) {
                    c = ')';
                    break;
                }
                break;
            case 112903913:
                if (str.equals("watts")) {
                    c = '*';
                    break;
                }
                break;
            case 137365935:
                if (str.equals("longitude")) {
                    c = 26;
                    break;
                }
                break;
            case 198162679:
                if (str.equals("low_latitude")) {
                    c = 27;
                    break;
                }
                break;
            case 224520316:
                if (str.equals("edge_type")) {
                    c = 13;
                    break;
                }
                break;
            case 286612066:
                if (str.equals("activity_duration.descending")) {
                    c = 4;
                    break;
                }
                break;
            case 288459765:
                if (str.equals("distance")) {
                    c = 11;
                    break;
                }
                break;
            case 455965230:
                if (str.equals("activity_duration.ascending")) {
                    c = 3;
                    break;
                }
                break;
            case 811264586:
                if (str.equals("revolutions")) {
                    c = '&';
                    break;
                }
                break;
            case 829251210:
                if (str.equals("confidence")) {
                    c = 10;
                    break;
                }
                break;
            case 984367650:
                if (str.equals("repetitions")) {
                    c = '#';
                    break;
                }
                break;
            case 1857734768:
                if (str.equals("elevation.gain")) {
                    c = 15;
                    break;
                }
                break;
            case 1857897492:
                if (str.equals("elevation.loss")) {
                    c = 16;
                    break;
                }
                break;
            case 1863800889:
                if (str.equals("resistance")) {
                    c = '$';
                    break;
                }
                break;
            case 2036550306:
                if (str.equals("altitude")) {
                    c = 5;
                    break;
                }
                break;
            case 2056323544:
                if (str.equals("exercise")) {
                    c = 17;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return FIELD_ACCURACY;
            case 1:
                return FIELD_ACTIVITY;
            case 2:
                return zzaod;
            case 3:
                return zzaoe;
            case 4:
                return zzaof;
            case 5:
                return FIELD_ALTITUDE;
            case 6:
                return FIELD_AVERAGE;
            case 7:
                return FIELD_BPM;
            case 8:
                return FIELD_CALORIES;
            case 9:
                return FIELD_CIRCUMFERENCE;
            case 10:
                return FIELD_CONFIDENCE;
            case 11:
                return FIELD_DISTANCE;
            case 12:
                return FIELD_DURATION;
            case 13:
                return zzaom;
            case 14:
                return zzaog;
            case 15:
                return zzaoh;
            case 16:
                return zzaoi;
            case 17:
                return FIELD_EXERCISE;
            case 18:
                return zzaok;
            case 19:
                return zzaol;
            case 20:
                return zzaoj;
            case 21:
                return FIELD_FOOD_ITEM;
            case 22:
                return FIELD_HEIGHT;
            case 23:
                return FIELD_HIGH_LATITUDE;
            case 24:
                return FIELD_HIGH_LONGITUDE;
            case 25:
                return FIELD_LATITUDE;
            case 26:
                return FIELD_LONGITUDE;
            case 27:
                return FIELD_LOW_LATITUDE;
            case 28:
                return FIELD_LOW_LONGITUDE;
            case 29:
                return FIELD_MAX;
            case 30:
                return FIELD_MEAL_TYPE;
            case 31:
                return FIELD_MIN;
            case ' ':
                return FIELD_NUM_SEGMENTS;
            case '!':
                return FIELD_NUTRIENTS;
            case '\"':
                return FIELD_PERCENTAGE;
            case '#':
                return FIELD_REPETITIONS;
            case '$':
                return FIELD_RESISTANCE;
            case '%':
                return FIELD_RESISTANCE_TYPE;
            case '&':
                return FIELD_REVOLUTIONS;
            case '\'':
                return FIELD_RPM;
            case '(':
                return FIELD_SPEED;
            case ')':
                return FIELD_STEPS;
            case '*':
                return FIELD_WATTS;
            case '+':
                return FIELD_WEIGHT;
            case ',':
                return zzaon;
            case '-':
                return zzaoo;
            case '.':
                return zzaop;
            default:
                return new Field(str, i);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object that) {
        return this == that || ((that instanceof Field) && zza((Field) that));
    }

    public int getFormat() {
        return this.zzaoq;
    }

    public String getName() {
        return this.mName;
    }

    /* access modifiers changed from: 0000 */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        String str = "%s(%s)";
        Object[] objArr = new Object[2];
        objArr[0] = this.mName;
        objArr[1] = this.zzaoq == 1 ? "i" : "f";
        return String.format(str, objArr);
    }

    public void writeToParcel(Parcel dest, int flags) {
        zzi.zza(this, dest, flags);
    }
}
