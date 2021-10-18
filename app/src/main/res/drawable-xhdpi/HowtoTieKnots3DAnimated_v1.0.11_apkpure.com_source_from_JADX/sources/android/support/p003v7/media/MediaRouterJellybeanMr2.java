package android.support.p003v7.media;

import android.media.MediaRouter;
import android.media.MediaRouter.Callback;

/* renamed from: android.support.v7.media.MediaRouterJellybeanMr2 */
final class MediaRouterJellybeanMr2 {

    /* renamed from: android.support.v7.media.MediaRouterJellybeanMr2$RouteInfo */
    public static final class RouteInfo {
        public static CharSequence getDescription(Object routeObj) {
            return ((android.media.MediaRouter.RouteInfo) routeObj).getDescription();
        }

        public static boolean isConnecting(Object routeObj) {
            return ((android.media.MediaRouter.RouteInfo) routeObj).isConnecting();
        }
    }

    /* renamed from: android.support.v7.media.MediaRouterJellybeanMr2$UserRouteInfo */
    public static final class UserRouteInfo {
        public static void setDescription(Object routeObj, CharSequence description) {
            ((android.media.MediaRouter.UserRouteInfo) routeObj).setDescription(description);
        }
    }

    MediaRouterJellybeanMr2() {
    }

    public static Object getDefaultRoute(Object routerObj) {
        return ((MediaRouter) routerObj).getDefaultRoute();
    }

    public static void addCallback(Object routerObj, int types, Object callbackObj, int flags) {
        ((MediaRouter) routerObj).addCallback(types, (Callback) callbackObj, flags);
    }
}
