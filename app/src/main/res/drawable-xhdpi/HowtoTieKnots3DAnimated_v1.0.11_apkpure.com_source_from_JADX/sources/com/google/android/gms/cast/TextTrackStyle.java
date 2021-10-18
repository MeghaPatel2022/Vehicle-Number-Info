package com.google.android.gms.cast;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import android.view.accessibility.CaptioningManager.CaptionStyle;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zzls;
import com.google.android.gms.internal.zzlv;
import org.json.JSONException;
import org.json.JSONObject;

public final class TextTrackStyle {
    public static final int COLOR_UNSPECIFIED = 0;
    public static final float DEFAULT_FONT_SCALE = 1.0f;
    public static final int EDGE_TYPE_DEPRESSED = 4;
    public static final int EDGE_TYPE_DROP_SHADOW = 2;
    public static final int EDGE_TYPE_NONE = 0;
    public static final int EDGE_TYPE_OUTLINE = 1;
    public static final int EDGE_TYPE_RAISED = 3;
    public static final int EDGE_TYPE_UNSPECIFIED = -1;
    public static final int FONT_FAMILY_CASUAL = 4;
    public static final int FONT_FAMILY_CURSIVE = 5;
    public static final int FONT_FAMILY_MONOSPACED_SANS_SERIF = 1;
    public static final int FONT_FAMILY_MONOSPACED_SERIF = 3;
    public static final int FONT_FAMILY_SANS_SERIF = 0;
    public static final int FONT_FAMILY_SERIF = 2;
    public static final int FONT_FAMILY_SMALL_CAPITALS = 6;
    public static final int FONT_FAMILY_UNSPECIFIED = -1;
    public static final int FONT_STYLE_BOLD = 1;
    public static final int FONT_STYLE_BOLD_ITALIC = 3;
    public static final int FONT_STYLE_ITALIC = 2;
    public static final int FONT_STYLE_NORMAL = 0;
    public static final int FONT_STYLE_UNSPECIFIED = -1;
    public static final int WINDOW_TYPE_NONE = 0;
    public static final int WINDOW_TYPE_NORMAL = 1;
    public static final int WINDOW_TYPE_ROUNDED = 2;
    public static final int WINDOW_TYPE_UNSPECIFIED = -1;
    private JSONObject zzUl;
    private float zzVE;
    private int zzVF;
    private int zzVG;
    private int zzVH;
    private int zzVI;
    private int zzVJ;
    private int zzVK;
    private String zzVL;
    private int zzVM;
    private int zzVN;
    private int zzvF;

    public TextTrackStyle() {
        clear();
    }

    private void clear() {
        this.zzVE = 1.0f;
        this.zzVF = 0;
        this.zzvF = 0;
        this.zzVG = -1;
        this.zzVH = 0;
        this.zzVI = -1;
        this.zzVJ = 0;
        this.zzVK = 0;
        this.zzVL = null;
        this.zzVM = -1;
        this.zzVN = -1;
        this.zzUl = null;
    }

    public static TextTrackStyle fromSystemSettings(Context context) {
        TextTrackStyle textTrackStyle = new TextTrackStyle();
        if (!zzlv.zzpV()) {
            return textTrackStyle;
        }
        CaptioningManager captioningManager = (CaptioningManager) context.getSystemService("captioning");
        textTrackStyle.setFontScale(captioningManager.getFontScale());
        CaptionStyle userStyle = captioningManager.getUserStyle();
        textTrackStyle.setBackgroundColor(userStyle.backgroundColor);
        textTrackStyle.setForegroundColor(userStyle.foregroundColor);
        switch (userStyle.edgeType) {
            case 1:
                textTrackStyle.setEdgeType(1);
                break;
            case 2:
                textTrackStyle.setEdgeType(2);
                break;
            default:
                textTrackStyle.setEdgeType(0);
                break;
        }
        textTrackStyle.setEdgeColor(userStyle.edgeColor);
        Typeface typeface = userStyle.getTypeface();
        if (typeface != null) {
            if (Typeface.MONOSPACE.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(1);
            } else if (Typeface.SANS_SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(0);
            } else if (Typeface.SERIF.equals(typeface)) {
                textTrackStyle.setFontGenericFamily(2);
            } else {
                textTrackStyle.setFontGenericFamily(0);
            }
            boolean isBold = typeface.isBold();
            boolean isItalic = typeface.isItalic();
            if (isBold && isItalic) {
                textTrackStyle.setFontStyle(3);
            } else if (isBold) {
                textTrackStyle.setFontStyle(1);
            } else if (isItalic) {
                textTrackStyle.setFontStyle(2);
            } else {
                textTrackStyle.setFontStyle(0);
            }
        }
        return textTrackStyle;
    }

    private String zzH(int i) {
        return String.format("#%02X%02X%02X%02X", new Object[]{Integer.valueOf(Color.red(i)), Integer.valueOf(Color.green(i)), Integer.valueOf(Color.blue(i)), Integer.valueOf(Color.alpha(i))});
    }

    private int zzbH(String str) {
        int i = 0;
        if (str == null || str.length() != 9 || str.charAt(i) != '#') {
            return i;
        }
        try {
            return Color.argb(Integer.parseInt(str.substring(7, 9), 16), Integer.parseInt(str.substring(1, 3), 16), Integer.parseInt(str.substring(3, 5), 16), Integer.parseInt(str.substring(5, 7), 16));
        } catch (NumberFormatException e) {
            return i;
        }
    }

    public boolean equals(Object other) {
        boolean z = true;
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextTrackStyle)) {
            return false;
        }
        TextTrackStyle textTrackStyle = (TextTrackStyle) other;
        if ((this.zzUl == null) != (textTrackStyle.zzUl == null)) {
            return false;
        }
        if (this.zzUl != null && textTrackStyle.zzUl != null && !zzls.zzd(this.zzUl, textTrackStyle.zzUl)) {
            return false;
        }
        if (!(this.zzVE == textTrackStyle.zzVE && this.zzVF == textTrackStyle.zzVF && this.zzvF == textTrackStyle.zzvF && this.zzVG == textTrackStyle.zzVG && this.zzVH == textTrackStyle.zzVH && this.zzVI == textTrackStyle.zzVI && this.zzVK == textTrackStyle.zzVK && zzf.zza(this.zzVL, textTrackStyle.zzVL) && this.zzVM == textTrackStyle.zzVM && this.zzVN == textTrackStyle.zzVN)) {
            z = false;
        }
        return z;
    }

    public int getBackgroundColor() {
        return this.zzvF;
    }

    public JSONObject getCustomData() {
        return this.zzUl;
    }

    public int getEdgeColor() {
        return this.zzVH;
    }

    public int getEdgeType() {
        return this.zzVG;
    }

    public String getFontFamily() {
        return this.zzVL;
    }

    public int getFontGenericFamily() {
        return this.zzVM;
    }

    public float getFontScale() {
        return this.zzVE;
    }

    public int getFontStyle() {
        return this.zzVN;
    }

    public int getForegroundColor() {
        return this.zzVF;
    }

    public int getWindowColor() {
        return this.zzVJ;
    }

    public int getWindowCornerRadius() {
        return this.zzVK;
    }

    public int getWindowType() {
        return this.zzVI;
    }

    public int hashCode() {
        return zzw.hashCode(Float.valueOf(this.zzVE), Integer.valueOf(this.zzVF), Integer.valueOf(this.zzvF), Integer.valueOf(this.zzVG), Integer.valueOf(this.zzVH), Integer.valueOf(this.zzVI), Integer.valueOf(this.zzVJ), Integer.valueOf(this.zzVK), this.zzVL, Integer.valueOf(this.zzVM), Integer.valueOf(this.zzVN), this.zzUl);
    }

    public void setBackgroundColor(int backgroundColor) {
        this.zzvF = backgroundColor;
    }

    public void setCustomData(JSONObject customData) {
        this.zzUl = customData;
    }

    public void setEdgeColor(int edgeColor) {
        this.zzVH = edgeColor;
    }

    public void setEdgeType(int edgeType) {
        if (edgeType < 0 || edgeType > 4) {
            throw new IllegalArgumentException("invalid edgeType");
        }
        this.zzVG = edgeType;
    }

    public void setFontFamily(String fontFamily) {
        this.zzVL = fontFamily;
    }

    public void setFontGenericFamily(int fontGenericFamily) {
        if (fontGenericFamily < 0 || fontGenericFamily > 6) {
            throw new IllegalArgumentException("invalid fontGenericFamily");
        }
        this.zzVM = fontGenericFamily;
    }

    public void setFontScale(float fontScale) {
        this.zzVE = fontScale;
    }

    public void setFontStyle(int fontStyle) {
        if (fontStyle < 0 || fontStyle > 3) {
            throw new IllegalArgumentException("invalid fontStyle");
        }
        this.zzVN = fontStyle;
    }

    public void setForegroundColor(int foregroundColor) {
        this.zzVF = foregroundColor;
    }

    public void setWindowColor(int windowColor) {
        this.zzVJ = windowColor;
    }

    public void setWindowCornerRadius(int windowCornerRadius) {
        if (windowCornerRadius < 0) {
            throw new IllegalArgumentException("invalid windowCornerRadius");
        }
        this.zzVK = windowCornerRadius;
    }

    public void setWindowType(int windowType) {
        if (windowType < 0 || windowType > 2) {
            throw new IllegalArgumentException("invalid windowType");
        }
        this.zzVI = windowType;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("fontScale", (double) this.zzVE);
            if (this.zzVF != 0) {
                jSONObject.put("foregroundColor", zzH(this.zzVF));
            }
            if (this.zzvF != 0) {
                jSONObject.put("backgroundColor", zzH(this.zzvF));
            }
            switch (this.zzVG) {
                case 0:
                    jSONObject.put("edgeType", "NONE");
                    break;
                case 1:
                    jSONObject.put("edgeType", "OUTLINE");
                    break;
                case 2:
                    jSONObject.put("edgeType", "DROP_SHADOW");
                    break;
                case 3:
                    jSONObject.put("edgeType", "RAISED");
                    break;
                case 4:
                    jSONObject.put("edgeType", "DEPRESSED");
                    break;
            }
            if (this.zzVH != 0) {
                jSONObject.put("edgeColor", zzH(this.zzVH));
            }
            switch (this.zzVI) {
                case 0:
                    jSONObject.put("windowType", "NONE");
                    break;
                case 1:
                    jSONObject.put("windowType", "NORMAL");
                    break;
                case 2:
                    jSONObject.put("windowType", "ROUNDED_CORNERS");
                    break;
            }
            if (this.zzVJ != 0) {
                jSONObject.put("windowColor", zzH(this.zzVJ));
            }
            if (this.zzVI == 2) {
                jSONObject.put("windowRoundedCornerRadius", this.zzVK);
            }
            if (this.zzVL != null) {
                jSONObject.put("fontFamily", this.zzVL);
            }
            switch (this.zzVM) {
                case 0:
                    jSONObject.put("fontGenericFamily", "SANS_SERIF");
                    break;
                case 1:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SANS_SERIF");
                    break;
                case 2:
                    jSONObject.put("fontGenericFamily", "SERIF");
                    break;
                case 3:
                    jSONObject.put("fontGenericFamily", "MONOSPACED_SERIF");
                    break;
                case 4:
                    jSONObject.put("fontGenericFamily", "CASUAL");
                    break;
                case 5:
                    jSONObject.put("fontGenericFamily", "CURSIVE");
                    break;
                case 6:
                    jSONObject.put("fontGenericFamily", "SMALL_CAPITALS");
                    break;
            }
            switch (this.zzVN) {
                case 0:
                    jSONObject.put("fontStyle", "NORMAL");
                    break;
                case 1:
                    jSONObject.put("fontStyle", "BOLD");
                    break;
                case 2:
                    jSONObject.put("fontStyle", "ITALIC");
                    break;
                case 3:
                    jSONObject.put("fontStyle", "BOLD_ITALIC");
                    break;
            }
            if (this.zzUl != null) {
                jSONObject.put("customData", this.zzUl);
            }
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void zzf(JSONObject jSONObject) throws JSONException {
        clear();
        this.zzVE = (float) jSONObject.optDouble("fontScale", 1.0d);
        this.zzVF = zzbH(jSONObject.optString("foregroundColor"));
        this.zzvF = zzbH(jSONObject.optString("backgroundColor"));
        if (jSONObject.has("edgeType")) {
            String string = jSONObject.getString("edgeType");
            if ("NONE".equals(string)) {
                this.zzVG = 0;
            } else if ("OUTLINE".equals(string)) {
                this.zzVG = 1;
            } else if ("DROP_SHADOW".equals(string)) {
                this.zzVG = 2;
            } else if ("RAISED".equals(string)) {
                this.zzVG = 3;
            } else if ("DEPRESSED".equals(string)) {
                this.zzVG = 4;
            }
        }
        this.zzVH = zzbH(jSONObject.optString("edgeColor"));
        if (jSONObject.has("windowType")) {
            String string2 = jSONObject.getString("windowType");
            if ("NONE".equals(string2)) {
                this.zzVI = 0;
            } else if ("NORMAL".equals(string2)) {
                this.zzVI = 1;
            } else if ("ROUNDED_CORNERS".equals(string2)) {
                this.zzVI = 2;
            }
        }
        this.zzVJ = zzbH(jSONObject.optString("windowColor"));
        if (this.zzVI == 2) {
            this.zzVK = jSONObject.optInt("windowRoundedCornerRadius", 0);
        }
        this.zzVL = jSONObject.optString("fontFamily", null);
        if (jSONObject.has("fontGenericFamily")) {
            String string3 = jSONObject.getString("fontGenericFamily");
            if ("SANS_SERIF".equals(string3)) {
                this.zzVM = 0;
            } else if ("MONOSPACED_SANS_SERIF".equals(string3)) {
                this.zzVM = 1;
            } else if ("SERIF".equals(string3)) {
                this.zzVM = 2;
            } else if ("MONOSPACED_SERIF".equals(string3)) {
                this.zzVM = 3;
            } else if ("CASUAL".equals(string3)) {
                this.zzVM = 4;
            } else if ("CURSIVE".equals(string3)) {
                this.zzVM = 5;
            } else if ("SMALL_CAPITALS".equals(string3)) {
                this.zzVM = 6;
            }
        }
        if (jSONObject.has("fontStyle")) {
            String string4 = jSONObject.getString("fontStyle");
            if ("NORMAL".equals(string4)) {
                this.zzVN = 0;
            } else if ("BOLD".equals(string4)) {
                this.zzVN = 1;
            } else if ("ITALIC".equals(string4)) {
                this.zzVN = 2;
            } else if ("BOLD_ITALIC".equals(string4)) {
                this.zzVN = 3;
            }
        }
        this.zzUl = jSONObject.optJSONObject("customData");
    }
}
