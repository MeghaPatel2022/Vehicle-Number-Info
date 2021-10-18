package android.support.p000v4.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.PopupWindowCompat */
public class PopupWindowCompat {
    static final PopupWindowImpl IMPL;

    /* renamed from: android.support.v4.widget.PopupWindowCompat$BasePopupWindowImpl */
    static class BasePopupWindowImpl implements PopupWindowImpl {
        BasePopupWindowImpl() {
        }

        public void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
            popup.showAsDropDown(anchor, xoff, yoff);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$KitKatPopupWindowImpl */
    static class KitKatPopupWindowImpl extends BasePopupWindowImpl {
        KitKatPopupWindowImpl() {
        }

        public void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
            PopupWindowCompatKitKat.showAsDropDown(popup, anchor, xoff, yoff, gravity);
        }
    }

    /* renamed from: android.support.v4.widget.PopupWindowCompat$PopupWindowImpl */
    interface PopupWindowImpl {
        void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3);
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            IMPL = new KitKatPopupWindowImpl();
        } else {
            IMPL = new BasePopupWindowImpl();
        }
    }

    private PopupWindowCompat() {
    }

    public static void showAsDropDown(PopupWindow popup, View anchor, int xoff, int yoff, int gravity) {
        IMPL.showAsDropDown(popup, anchor, xoff, yoff, gravity);
    }
}
