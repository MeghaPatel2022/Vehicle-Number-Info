package android.support.p003v7.media;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.support.p003v7.media.MediaRouteDescriptor.Builder;
import android.support.p003v7.media.MediaRouteProvider.ProviderMetadata;
import android.support.p003v7.media.MediaRouteProvider.RouteController;
import android.support.p003v7.media.MediaRouterJellybean.Callback;
import android.support.p003v7.media.MediaRouterJellybean.GetDefaultRouteWorkaround;
import android.support.p003v7.media.MediaRouterJellybean.RouteInfo;
import android.support.p003v7.media.MediaRouterJellybean.SelectRouteWorkaround;
import android.support.p003v7.media.MediaRouterJellybean.UserRouteInfo;
import android.support.p003v7.media.MediaRouterJellybean.VolumeCallback;
import android.support.p003v7.media.MediaRouterJellybeanMr1.ActiveScanWorkaround;
import android.support.p003v7.media.MediaRouterJellybeanMr1.IsConnectingWorkaround;
import android.support.p003v7.mediarouter.C0195R;
import android.view.Display;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: android.support.v7.media.SystemMediaRouteProvider */
abstract class SystemMediaRouteProvider extends MediaRouteProvider {
    public static final String DEFAULT_ROUTE_ID = "DEFAULT_ROUTE";
    public static final String PACKAGE_NAME = "android";
    private static final String TAG = "SystemMediaRouteProvider";

    /* renamed from: android.support.v7.media.SystemMediaRouteProvider$JellybeanImpl */
    static class JellybeanImpl extends SystemMediaRouteProvider implements Callback, VolumeCallback {
        private static final ArrayList<IntentFilter> LIVE_AUDIO_CONTROL_FILTERS = new ArrayList<>();
        private static final ArrayList<IntentFilter> LIVE_VIDEO_CONTROL_FILTERS = new ArrayList<>();
        protected boolean mActiveScan;
        protected final Object mCallbackObj;
        protected boolean mCallbackRegistered;
        private GetDefaultRouteWorkaround mGetDefaultRouteWorkaround;
        protected int mRouteTypes;
        protected final Object mRouterObj;
        private SelectRouteWorkaround mSelectRouteWorkaround;
        private final SyncCallback mSyncCallback;
        protected final ArrayList<SystemRouteRecord> mSystemRouteRecords = new ArrayList<>();
        protected final Object mUserRouteCategoryObj;
        protected final ArrayList<UserRouteRecord> mUserRouteRecords = new ArrayList<>();
        protected final Object mVolumeCallbackObj;

        /* renamed from: android.support.v7.media.SystemMediaRouteProvider$JellybeanImpl$SystemRouteController */
        protected final class SystemRouteController extends RouteController {
            private final Object mRouteObj;

            public SystemRouteController(Object routeObj) {
                this.mRouteObj = routeObj;
            }

            public void onSetVolume(int volume) {
                RouteInfo.requestSetVolume(this.mRouteObj, volume);
            }

            public void onUpdateVolume(int delta) {
                RouteInfo.requestUpdateVolume(this.mRouteObj, delta);
            }
        }

        /* renamed from: android.support.v7.media.SystemMediaRouteProvider$JellybeanImpl$SystemRouteRecord */
        protected static final class SystemRouteRecord {
            public MediaRouteDescriptor mRouteDescriptor;
            public final String mRouteDescriptorId;
            public final Object mRouteObj;

            public SystemRouteRecord(Object routeObj, String id) {
                this.mRouteObj = routeObj;
                this.mRouteDescriptorId = id;
            }
        }

        /* renamed from: android.support.v7.media.SystemMediaRouteProvider$JellybeanImpl$UserRouteRecord */
        protected static final class UserRouteRecord {
            public final MediaRouter.RouteInfo mRoute;
            public final Object mRouteObj;

            public UserRouteRecord(MediaRouter.RouteInfo route, Object routeObj) {
                this.mRoute = route;
                this.mRouteObj = routeObj;
            }
        }

        static {
            IntentFilter f = new IntentFilter();
            f.addCategory(MediaControlIntent.CATEGORY_LIVE_AUDIO);
            LIVE_AUDIO_CONTROL_FILTERS.add(f);
            IntentFilter f2 = new IntentFilter();
            f2.addCategory(MediaControlIntent.CATEGORY_LIVE_VIDEO);
            LIVE_VIDEO_CONTROL_FILTERS.add(f2);
        }

        public JellybeanImpl(Context context, SyncCallback syncCallback) {
            super(context);
            this.mSyncCallback = syncCallback;
            this.mRouterObj = MediaRouterJellybean.getMediaRouter(context);
            this.mCallbackObj = createCallbackObj();
            this.mVolumeCallbackObj = createVolumeCallbackObj();
            this.mUserRouteCategoryObj = MediaRouterJellybean.createRouteCategory(this.mRouterObj, context.getResources().getString(C0195R.string.mr_user_route_category_name), false);
            updateSystemRoutes();
        }

        public RouteController onCreateRouteController(String routeId) {
            int index = findSystemRouteRecordByDescriptorId(routeId);
            if (index >= 0) {
                return new SystemRouteController(((SystemRouteRecord) this.mSystemRouteRecords.get(index)).mRouteObj);
            }
            return null;
        }

        public void onDiscoveryRequestChanged(MediaRouteDiscoveryRequest request) {
            int newRouteTypes = 0;
            boolean newActiveScan = false;
            if (request != null) {
                List<String> categories = request.getSelector().getControlCategories();
                int count = categories.size();
                for (int i = 0; i < count; i++) {
                    String category = (String) categories.get(i);
                    if (category.equals(MediaControlIntent.CATEGORY_LIVE_AUDIO)) {
                        newRouteTypes |= 1;
                    } else if (category.equals(MediaControlIntent.CATEGORY_LIVE_VIDEO)) {
                        newRouteTypes |= 2;
                    } else {
                        newRouteTypes |= 8388608;
                    }
                }
                newActiveScan = request.isActiveScan();
            }
            if (this.mRouteTypes != newRouteTypes || this.mActiveScan != newActiveScan) {
                this.mRouteTypes = newRouteTypes;
                this.mActiveScan = newActiveScan;
                updateCallback();
                updateSystemRoutes();
            }
        }

        public void onRouteAdded(Object routeObj) {
            if (addSystemRouteNoPublish(routeObj)) {
                publishRoutes();
            }
        }

        private void updateSystemRoutes() {
            boolean changed = false;
            for (Object routeObj : MediaRouterJellybean.getRoutes(this.mRouterObj)) {
                changed |= addSystemRouteNoPublish(routeObj);
            }
            if (changed) {
                publishRoutes();
            }
        }

        private boolean addSystemRouteNoPublish(Object routeObj) {
            if (getUserRouteRecord(routeObj) != null || findSystemRouteRecord(routeObj) >= 0) {
                return false;
            }
            SystemRouteRecord record = new SystemRouteRecord(routeObj, assignRouteId(routeObj));
            updateSystemRouteDescriptor(record);
            this.mSystemRouteRecords.add(record);
            return true;
        }

        private String assignRouteId(Object routeObj) {
            boolean isDefault;
            String id;
            if (getDefaultRoute() == routeObj) {
                isDefault = true;
            } else {
                isDefault = false;
            }
            if (isDefault) {
                id = SystemMediaRouteProvider.DEFAULT_ROUTE_ID;
            } else {
                id = String.format(Locale.US, "ROUTE_%08x", new Object[]{Integer.valueOf(getRouteName(routeObj).hashCode())});
            }
            if (findSystemRouteRecordByDescriptorId(id) < 0) {
                return id;
            }
            int i = 2;
            while (true) {
                String newId = String.format(Locale.US, "%s_%d", new Object[]{id, Integer.valueOf(i)});
                if (findSystemRouteRecordByDescriptorId(newId) < 0) {
                    return newId;
                }
                i++;
            }
        }

        public void onRouteRemoved(Object routeObj) {
            if (getUserRouteRecord(routeObj) == null) {
                int index = findSystemRouteRecord(routeObj);
                if (index >= 0) {
                    this.mSystemRouteRecords.remove(index);
                    publishRoutes();
                }
            }
        }

        public void onRouteChanged(Object routeObj) {
            if (getUserRouteRecord(routeObj) == null) {
                int index = findSystemRouteRecord(routeObj);
                if (index >= 0) {
                    updateSystemRouteDescriptor((SystemRouteRecord) this.mSystemRouteRecords.get(index));
                    publishRoutes();
                }
            }
        }

        public void onRouteVolumeChanged(Object routeObj) {
            if (getUserRouteRecord(routeObj) == null) {
                int index = findSystemRouteRecord(routeObj);
                if (index >= 0) {
                    SystemRouteRecord record = (SystemRouteRecord) this.mSystemRouteRecords.get(index);
                    int newVolume = RouteInfo.getVolume(routeObj);
                    if (newVolume != record.mRouteDescriptor.getVolume()) {
                        record.mRouteDescriptor = new Builder(record.mRouteDescriptor).setVolume(newVolume).build();
                        publishRoutes();
                    }
                }
            }
        }

        public void onRouteSelected(int type, Object routeObj) {
            if (routeObj == MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611)) {
                UserRouteRecord userRouteRecord = getUserRouteRecord(routeObj);
                if (userRouteRecord != null) {
                    userRouteRecord.mRoute.select();
                    return;
                }
                int index = findSystemRouteRecord(routeObj);
                if (index >= 0) {
                    MediaRouter.RouteInfo route = this.mSyncCallback.getSystemRouteByDescriptorId(((SystemRouteRecord) this.mSystemRouteRecords.get(index)).mRouteDescriptorId);
                    if (route != null) {
                        route.select();
                    }
                }
            }
        }

        public void onRouteUnselected(int type, Object routeObj) {
        }

        public void onRouteGrouped(Object routeObj, Object groupObj, int index) {
        }

        public void onRouteUngrouped(Object routeObj, Object groupObj) {
        }

        public void onVolumeSetRequest(Object routeObj, int volume) {
            UserRouteRecord record = getUserRouteRecord(routeObj);
            if (record != null) {
                record.mRoute.requestSetVolume(volume);
            }
        }

        public void onVolumeUpdateRequest(Object routeObj, int direction) {
            UserRouteRecord record = getUserRouteRecord(routeObj);
            if (record != null) {
                record.mRoute.requestUpdateVolume(direction);
            }
        }

        public void onSyncRouteAdded(MediaRouter.RouteInfo route) {
            if (route.getProviderInstance() != this) {
                Object routeObj = MediaRouterJellybean.createUserRoute(this.mRouterObj, this.mUserRouteCategoryObj);
                UserRouteRecord record = new UserRouteRecord(route, routeObj);
                RouteInfo.setTag(routeObj, record);
                UserRouteInfo.setVolumeCallback(routeObj, this.mVolumeCallbackObj);
                updateUserRouteProperties(record);
                this.mUserRouteRecords.add(record);
                MediaRouterJellybean.addUserRoute(this.mRouterObj, routeObj);
                return;
            }
            int index = findSystemRouteRecord(MediaRouterJellybean.getSelectedRoute(this.mRouterObj, 8388611));
            if (index >= 0 && ((SystemRouteRecord) this.mSystemRouteRecords.get(index)).mRouteDescriptorId.equals(route.getDescriptorId())) {
                route.select();
            }
        }

        public void onSyncRouteRemoved(MediaRouter.RouteInfo route) {
            if (route.getProviderInstance() != this) {
                int index = findUserRouteRecord(route);
                if (index >= 0) {
                    UserRouteRecord record = (UserRouteRecord) this.mUserRouteRecords.remove(index);
                    RouteInfo.setTag(record.mRouteObj, null);
                    UserRouteInfo.setVolumeCallback(record.mRouteObj, null);
                    MediaRouterJellybean.removeUserRoute(this.mRouterObj, record.mRouteObj);
                }
            }
        }

        public void onSyncRouteChanged(MediaRouter.RouteInfo route) {
            if (route.getProviderInstance() != this) {
                int index = findUserRouteRecord(route);
                if (index >= 0) {
                    updateUserRouteProperties((UserRouteRecord) this.mUserRouteRecords.get(index));
                }
            }
        }

        public void onSyncRouteSelected(MediaRouter.RouteInfo route) {
            if (route.isSelected()) {
                if (route.getProviderInstance() != this) {
                    int index = findUserRouteRecord(route);
                    if (index >= 0) {
                        selectRoute(((UserRouteRecord) this.mUserRouteRecords.get(index)).mRouteObj);
                        return;
                    }
                    return;
                }
                int index2 = findSystemRouteRecordByDescriptorId(route.getDescriptorId());
                if (index2 >= 0) {
                    selectRoute(((SystemRouteRecord) this.mSystemRouteRecords.get(index2)).mRouteObj);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void publishRoutes() {
            MediaRouteProviderDescriptor.Builder builder = new MediaRouteProviderDescriptor.Builder();
            int count = this.mSystemRouteRecords.size();
            for (int i = 0; i < count; i++) {
                builder.addRoute(((SystemRouteRecord) this.mSystemRouteRecords.get(i)).mRouteDescriptor);
            }
            setDescriptor(builder.build());
        }

        /* access modifiers changed from: protected */
        public int findSystemRouteRecord(Object routeObj) {
            int count = this.mSystemRouteRecords.size();
            for (int i = 0; i < count; i++) {
                if (((SystemRouteRecord) this.mSystemRouteRecords.get(i)).mRouteObj == routeObj) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public int findSystemRouteRecordByDescriptorId(String id) {
            int count = this.mSystemRouteRecords.size();
            for (int i = 0; i < count; i++) {
                if (((SystemRouteRecord) this.mSystemRouteRecords.get(i)).mRouteDescriptorId.equals(id)) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public int findUserRouteRecord(MediaRouter.RouteInfo route) {
            int count = this.mUserRouteRecords.size();
            for (int i = 0; i < count; i++) {
                if (((UserRouteRecord) this.mUserRouteRecords.get(i)).mRoute == route) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public UserRouteRecord getUserRouteRecord(Object routeObj) {
            Object tag = RouteInfo.getTag(routeObj);
            if (tag instanceof UserRouteRecord) {
                return (UserRouteRecord) tag;
            }
            return null;
        }

        /* access modifiers changed from: protected */
        public void updateSystemRouteDescriptor(SystemRouteRecord record) {
            Builder builder = new Builder(record.mRouteDescriptorId, getRouteName(record.mRouteObj));
            onBuildSystemRouteDescriptor(record, builder);
            record.mRouteDescriptor = builder.build();
        }

        /* access modifiers changed from: protected */
        public String getRouteName(Object routeObj) {
            CharSequence name = RouteInfo.getName(routeObj, getContext());
            return name != null ? name.toString() : "";
        }

        /* access modifiers changed from: protected */
        public void onBuildSystemRouteDescriptor(SystemRouteRecord record, Builder builder) {
            int supportedTypes = RouteInfo.getSupportedTypes(record.mRouteObj);
            if ((supportedTypes & 1) != 0) {
                builder.addControlFilters(LIVE_AUDIO_CONTROL_FILTERS);
            }
            if ((supportedTypes & 2) != 0) {
                builder.addControlFilters(LIVE_VIDEO_CONTROL_FILTERS);
            }
            builder.setPlaybackType(RouteInfo.getPlaybackType(record.mRouteObj));
            builder.setPlaybackStream(RouteInfo.getPlaybackStream(record.mRouteObj));
            builder.setVolume(RouteInfo.getVolume(record.mRouteObj));
            builder.setVolumeMax(RouteInfo.getVolumeMax(record.mRouteObj));
            builder.setVolumeHandling(RouteInfo.getVolumeHandling(record.mRouteObj));
        }

        /* access modifiers changed from: protected */
        public void updateUserRouteProperties(UserRouteRecord record) {
            UserRouteInfo.setName(record.mRouteObj, record.mRoute.getName());
            UserRouteInfo.setPlaybackType(record.mRouteObj, record.mRoute.getPlaybackType());
            UserRouteInfo.setPlaybackStream(record.mRouteObj, record.mRoute.getPlaybackStream());
            UserRouteInfo.setVolume(record.mRouteObj, record.mRoute.getVolume());
            UserRouteInfo.setVolumeMax(record.mRouteObj, record.mRoute.getVolumeMax());
            UserRouteInfo.setVolumeHandling(record.mRouteObj, record.mRoute.getVolumeHandling());
        }

        /* access modifiers changed from: protected */
        public void updateCallback() {
            if (this.mCallbackRegistered) {
                this.mCallbackRegistered = false;
                MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
            }
            if (this.mRouteTypes != 0) {
                this.mCallbackRegistered = true;
                MediaRouterJellybean.addCallback(this.mRouterObj, this.mRouteTypes, this.mCallbackObj);
            }
        }

        /* access modifiers changed from: protected */
        public Object createCallbackObj() {
            return MediaRouterJellybean.createCallback(this);
        }

        /* access modifiers changed from: protected */
        public Object createVolumeCallbackObj() {
            return MediaRouterJellybean.createVolumeCallback(this);
        }

        /* access modifiers changed from: protected */
        public void selectRoute(Object routeObj) {
            if (this.mSelectRouteWorkaround == null) {
                this.mSelectRouteWorkaround = new SelectRouteWorkaround();
            }
            this.mSelectRouteWorkaround.selectRoute(this.mRouterObj, 8388611, routeObj);
        }

        /* access modifiers changed from: protected */
        public Object getDefaultRoute() {
            if (this.mGetDefaultRouteWorkaround == null) {
                this.mGetDefaultRouteWorkaround = new GetDefaultRouteWorkaround();
            }
            return this.mGetDefaultRouteWorkaround.getDefaultRoute(this.mRouterObj);
        }
    }

    /* renamed from: android.support.v7.media.SystemMediaRouteProvider$JellybeanMr1Impl */
    private static class JellybeanMr1Impl extends JellybeanImpl implements MediaRouterJellybeanMr1.Callback {
        private ActiveScanWorkaround mActiveScanWorkaround;
        private IsConnectingWorkaround mIsConnectingWorkaround;

        public JellybeanMr1Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        public void onRoutePresentationDisplayChanged(Object routeObj) {
            int index = findSystemRouteRecord(routeObj);
            if (index >= 0) {
                SystemRouteRecord record = (SystemRouteRecord) this.mSystemRouteRecords.get(index);
                Display newPresentationDisplay = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(routeObj);
                int newPresentationDisplayId = newPresentationDisplay != null ? newPresentationDisplay.getDisplayId() : -1;
                if (newPresentationDisplayId != record.mRouteDescriptor.getPresentationDisplayId()) {
                    record.mRouteDescriptor = new Builder(record.mRouteDescriptor).setPresentationDisplayId(newPresentationDisplayId).build();
                    publishRoutes();
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onBuildSystemRouteDescriptor(SystemRouteRecord record, Builder builder) {
            super.onBuildSystemRouteDescriptor(record, builder);
            if (!MediaRouterJellybeanMr1.RouteInfo.isEnabled(record.mRouteObj)) {
                builder.setEnabled(false);
            }
            if (isConnecting(record)) {
                builder.setConnecting(true);
            }
            Display presentationDisplay = MediaRouterJellybeanMr1.RouteInfo.getPresentationDisplay(record.mRouteObj);
            if (presentationDisplay != null) {
                builder.setPresentationDisplayId(presentationDisplay.getDisplayId());
            }
        }

        /* access modifiers changed from: protected */
        public void updateCallback() {
            super.updateCallback();
            if (this.mActiveScanWorkaround == null) {
                this.mActiveScanWorkaround = new ActiveScanWorkaround(getContext(), getHandler());
            }
            this.mActiveScanWorkaround.setActiveScanRouteTypes(this.mActiveScan ? this.mRouteTypes : 0);
        }

        /* access modifiers changed from: protected */
        public Object createCallbackObj() {
            return MediaRouterJellybeanMr1.createCallback(this);
        }

        /* access modifiers changed from: protected */
        public boolean isConnecting(SystemRouteRecord record) {
            if (this.mIsConnectingWorkaround == null) {
                this.mIsConnectingWorkaround = new IsConnectingWorkaround();
            }
            return this.mIsConnectingWorkaround.isConnecting(record.mRouteObj);
        }
    }

    /* renamed from: android.support.v7.media.SystemMediaRouteProvider$JellybeanMr2Impl */
    private static class JellybeanMr2Impl extends JellybeanMr1Impl {
        public JellybeanMr2Impl(Context context, SyncCallback syncCallback) {
            super(context, syncCallback);
        }

        /* access modifiers changed from: protected */
        public void onBuildSystemRouteDescriptor(SystemRouteRecord record, Builder builder) {
            super.onBuildSystemRouteDescriptor(record, builder);
            CharSequence description = MediaRouterJellybeanMr2.RouteInfo.getDescription(record.mRouteObj);
            if (description != null) {
                builder.setDescription(description.toString());
            }
        }

        /* access modifiers changed from: protected */
        public void selectRoute(Object routeObj) {
            MediaRouterJellybean.selectRoute(this.mRouterObj, 8388611, routeObj);
        }

        /* access modifiers changed from: protected */
        public Object getDefaultRoute() {
            return MediaRouterJellybeanMr2.getDefaultRoute(this.mRouterObj);
        }

        /* access modifiers changed from: protected */
        public void updateUserRouteProperties(UserRouteRecord record) {
            super.updateUserRouteProperties(record);
            MediaRouterJellybeanMr2.UserRouteInfo.setDescription(record.mRouteObj, record.mRoute.getDescription());
        }

        /* access modifiers changed from: protected */
        public void updateCallback() {
            int i = 1;
            if (this.mCallbackRegistered) {
                MediaRouterJellybean.removeCallback(this.mRouterObj, this.mCallbackObj);
            }
            this.mCallbackRegistered = true;
            Object obj = this.mRouterObj;
            int i2 = this.mRouteTypes;
            Object obj2 = this.mCallbackObj;
            if (!this.mActiveScan) {
                i = 0;
            }
            MediaRouterJellybeanMr2.addCallback(obj, i2, obj2, i | 2);
        }

        /* access modifiers changed from: protected */
        public boolean isConnecting(SystemRouteRecord record) {
            return MediaRouterJellybeanMr2.RouteInfo.isConnecting(record.mRouteObj);
        }
    }

    /* renamed from: android.support.v7.media.SystemMediaRouteProvider$LegacyImpl */
    static class LegacyImpl extends SystemMediaRouteProvider {
        private static final ArrayList<IntentFilter> CONTROL_FILTERS = new ArrayList<>();
        private static final int PLAYBACK_STREAM = 3;
        /* access modifiers changed from: private */
        public final AudioManager mAudioManager;
        /* access modifiers changed from: private */
        public int mLastReportedVolume = -1;
        private final VolumeChangeReceiver mVolumeChangeReceiver;

        /* renamed from: android.support.v7.media.SystemMediaRouteProvider$LegacyImpl$DefaultRouteController */
        final class DefaultRouteController extends RouteController {
            DefaultRouteController() {
            }

            public void onSetVolume(int volume) {
                LegacyImpl.this.mAudioManager.setStreamVolume(3, volume, 0);
                LegacyImpl.this.publishRoutes();
            }

            public void onUpdateVolume(int delta) {
                int volume = LegacyImpl.this.mAudioManager.getStreamVolume(3);
                if (Math.min(LegacyImpl.this.mAudioManager.getStreamMaxVolume(3), Math.max(0, volume + delta)) != volume) {
                    LegacyImpl.this.mAudioManager.setStreamVolume(3, volume, 0);
                }
                LegacyImpl.this.publishRoutes();
            }
        }

        /* renamed from: android.support.v7.media.SystemMediaRouteProvider$LegacyImpl$VolumeChangeReceiver */
        final class VolumeChangeReceiver extends BroadcastReceiver {
            public static final String EXTRA_VOLUME_STREAM_TYPE = "android.media.EXTRA_VOLUME_STREAM_TYPE";
            public static final String EXTRA_VOLUME_STREAM_VALUE = "android.media.EXTRA_VOLUME_STREAM_VALUE";
            public static final String VOLUME_CHANGED_ACTION = "android.media.VOLUME_CHANGED_ACTION";

            VolumeChangeReceiver() {
            }

            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(VOLUME_CHANGED_ACTION) && intent.getIntExtra(EXTRA_VOLUME_STREAM_TYPE, -1) == 3) {
                    int volume = intent.getIntExtra(EXTRA_VOLUME_STREAM_VALUE, -1);
                    if (volume >= 0 && volume != LegacyImpl.this.mLastReportedVolume) {
                        LegacyImpl.this.publishRoutes();
                    }
                }
            }
        }

        static {
            IntentFilter f = new IntentFilter();
            f.addCategory(MediaControlIntent.CATEGORY_LIVE_AUDIO);
            f.addCategory(MediaControlIntent.CATEGORY_LIVE_VIDEO);
            CONTROL_FILTERS.add(f);
        }

        public LegacyImpl(Context context) {
            super(context);
            this.mAudioManager = (AudioManager) context.getSystemService("audio");
            this.mVolumeChangeReceiver = new VolumeChangeReceiver();
            context.registerReceiver(this.mVolumeChangeReceiver, new IntentFilter(VolumeChangeReceiver.VOLUME_CHANGED_ACTION));
            publishRoutes();
        }

        /* access modifiers changed from: private */
        public void publishRoutes() {
            Resources r = getContext().getResources();
            int maxVolume = this.mAudioManager.getStreamMaxVolume(3);
            this.mLastReportedVolume = this.mAudioManager.getStreamVolume(3);
            setDescriptor(new MediaRouteProviderDescriptor.Builder().addRoute(new Builder(SystemMediaRouteProvider.DEFAULT_ROUTE_ID, r.getString(C0195R.string.mr_system_route_name)).addControlFilters(CONTROL_FILTERS).setPlaybackStream(3).setPlaybackType(0).setVolumeHandling(1).setVolumeMax(maxVolume).setVolume(this.mLastReportedVolume).build()).build());
        }

        public RouteController onCreateRouteController(String routeId) {
            if (routeId.equals(SystemMediaRouteProvider.DEFAULT_ROUTE_ID)) {
                return new DefaultRouteController();
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.media.SystemMediaRouteProvider$SyncCallback */
    public interface SyncCallback {
        MediaRouter.RouteInfo getSystemRouteByDescriptorId(String str);
    }

    protected SystemMediaRouteProvider(Context context) {
        super(context, new ProviderMetadata(new ComponentName(PACKAGE_NAME, SystemMediaRouteProvider.class.getName())));
    }

    public static SystemMediaRouteProvider obtain(Context context, SyncCallback syncCallback) {
        if (VERSION.SDK_INT >= 18) {
            return new JellybeanMr2Impl(context, syncCallback);
        }
        if (VERSION.SDK_INT >= 17) {
            return new JellybeanMr1Impl(context, syncCallback);
        }
        if (VERSION.SDK_INT >= 16) {
            return new JellybeanImpl(context, syncCallback);
        }
        return new LegacyImpl(context);
    }

    public void onSyncRouteAdded(MediaRouter.RouteInfo route) {
    }

    public void onSyncRouteRemoved(MediaRouter.RouteInfo route) {
    }

    public void onSyncRouteChanged(MediaRouter.RouteInfo route) {
    }

    public void onSyncRouteSelected(MediaRouter.RouteInfo route) {
    }
}
