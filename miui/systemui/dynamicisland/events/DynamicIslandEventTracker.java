/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.d
 *  G0.e
 *  U0.a
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.LruCache
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  systemui.plugin.eventtracking.trackers.BaseEventTracker
 *  systemui.plugin.eventtracking.trackers.BaseEventTracker$Companion
 */
package miui.systemui.dynamicisland.events;

import G0.d;
import G0.e;
import U0.a;
import android.content.Context;
import android.content.pm.PackageManager;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.LruCache;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.events.DynamicIslandEventTracker;
import miui.systemui.dynamicisland.events.DynamicIslandExpandedClick;
import miui.systemui.dynamicisland.events.DynamicIslandExpandedExpose;
import miui.systemui.dynamicisland.events.DynamicIslandSummaryClick;
import miui.systemui.dynamicisland.events.DynamicIslandSummaryExpose;
import miui.systemui.util.CommonUtils;
import systemui.plugin.eventtracking.trackers.BaseEventTracker;

public final class DynamicIslandEventTracker {
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        private final LruCache<String, String> getAppNameCache() {
            return (LruCache)appNameCache$delegate.getValue();
        }

        private final String getPhoneType() {
            String string = CommonUtils.isFlipDevice() ? "flip" : (CommonUtils.INSTANCE.getIS_FOLD() ? "fold" : "\u76f4\u677f");
            return string;
        }

        /*
         * WARNING - void declaration
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private final String resolveAppName(Context object, String string) {
            void var1_4;
            void var2_7;
            String string2 = DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
            if (var2_7 == null) {
                return DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
            }
            String string3 = (String)this.getAppNameCache().get((Object)var2_7);
            if (string3 != null) {
                return string3;
            }
            try {
                PackageManager packageManager = object.getPackageManager();
                String string4 = ((Object)packageManager.getApplicationLabel(packageManager.getApplicationInfo((String)var2_7, 0))).toString();
                this.getAppNameCache().put((Object)var2_7, (Object)string4);
                return var1_4;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                String string5 = string2;
                return var1_4;
            }
        }

        private final String resolveChannelType(StatusBarNotification object) {
            object = (object = object.getNotification()) != null && (object = object.extras) != null ? object.getString("miui.focus.param.channeltype") : null;
            Object object2 = object;
            if (object == null) {
                object2 = "normal";
            }
            return object2;
        }

        private final String resolveClickTip(String string) {
            boolean bl = o.c((Object)string, (Object)"\u5c0f") ? true : o.c((Object)string, (Object)"\u5927");
            string = bl ? "1868.1.1.1.45216" : "1868.1.2.1.45220";
            return string;
        }

        private final String resolveExtraItems(StatusBarNotification object) {
            object = (object = object.getNotification()) != null && (object = object.extras) != null ? object.getString("notif_extend_items") : null;
            Object object2 = object;
            if (object == null) {
                object2 = DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
            }
            return object2;
        }

        private final String resolveNotifTag(StatusBarNotification object) {
            String string = object.getTag();
            object = string;
            if (string == null) {
                object = DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
            }
            return object;
        }

        private final String resolveNotifType(StatusBarNotification object) {
            if ((object = DynamicIslandUtils.INSTANCE.resolveFocusParam((StatusBarNotification)object)) == null) {
                return DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
            }
            boolean bl = object.optBoolean("isShowNotification", true);
            boolean bl2 = object.optBoolean("updatable");
            object = bl && bl2 ? "\u6301\u7eed\u66f4\u65b0\u901a\u77e5" : (bl ? "\u4e00\u6b21\u6027\u901a\u77e5" : (bl2 ? "\u6301\u7eed\u670d\u52a1\u63d0\u9192" : "\u4e00\u6b21\u6027\u8bbe\u5907\u63d0\u9192"));
            return object;
        }

        private final String resolvePackage(StatusBarNotification object) {
            object = object.getOpPkg();
            o.f((Object)object, (String)"getOpPkg(...)");
            return object;
        }

        private final String resolveServiceScene(StatusBarNotification object) {
            if ((object = DynamicIslandUtils.INSTANCE.resolveFocusParam((StatusBarNotification)object)) == null) {
                return DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
            }
            object = object.optString("business", DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN);
            o.f((Object)object, (String)"optString(...)");
            return object;
        }

        private final String resolveTargetPackage(StatusBarNotification statusBarNotification) {
            String string = statusBarNotification.getPackageName();
            if (TextUtils.equals((CharSequence)"com.xiaomi.xmsf", (CharSequence)string)) {
                string = null;
            }
            String string2 = string;
            if (string == null) {
                string2 = statusBarNotification.getOpPkg();
                o.f((Object)string2, (String)"getOpPkg(...)");
            }
            return string2;
        }

        public static /* synthetic */ void trackExpandedClick$default(Companion companion, Context context, StatusBarNotification statusBarNotification, String string, Boolean bl, String string2, String string3, boolean bl2, int n, Object object) {
            if ((n & 0x40) != 0) {
                bl2 = false;
            }
            companion.trackExpandedClick(context, statusBarNotification, string, bl, string2, string3, bl2);
        }

        public final void clearAppNameCache() {
            this.getAppNameCache().evictAll();
        }

        public final void removeAppName(String string) {
            o.g((Object)string, (String)"pkg");
            this.getAppNameCache().remove((Object)string);
        }

        public final void trackExpandedClick(Context object, StatusBarNotification object2, String string, Boolean object3, String string2, String string3, boolean bl) {
            o.g((Object)object, (String)"context");
            o.g((Object)string, (String)"screenType");
            o.g((Object)string3, (String)"elementName");
            if (!o.c((Object)object3, (Object)Boolean.TRUE) && object2 != null) {
                object3 = BaseEventTracker.Companion.get();
                String string4 = this.resolveAppName((Context)object, this.resolvePackage((StatusBarNotification)object2));
                string2 = this.resolvePackage((StatusBarNotification)object2);
                object = this.resolveTargetPackage((StatusBarNotification)object2);
                int n = object2.getId();
                String string5 = this.resolveNotifTag((StatusBarNotification)object2);
                String string6 = this.resolveNotifType((StatusBarNotification)object2);
                String string7 = this.resolveServiceScene((StatusBarNotification)object2);
                if (!bl) {
                    string3 = "\u5c9b";
                }
                object3.track((Object)new DynamicIslandExpandedClick(string4, string2, (String)object, String.valueOf(n), string5, string6, string7, string3, this.resolveChannelType((StatusBarNotification)object2), this.resolveExtraItems((StatusBarNotification)object2), "1868.1.2.1.45220", this.getPhoneType(), string));
            } else {
                BaseEventTracker.Companion companion = BaseEventTracker.Companion.get();
                String string8 = this.resolveAppName((Context)object, string2);
                object = string2 == null ? DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL : string2;
                object2 = string2;
                if (string2 == null) {
                    object2 = DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
                }
                object3 = bl ? string3 : "\u5c9b";
                companion.track((Object)new DynamicIslandExpandedClick(string8, (String)object, (String)object2, DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "\u6301\u7eed\u66f4\u65b0\u901a\u77e5", DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, (String)object3, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "1868.1.2.1.45220", this.getPhoneType(), string));
            }
        }

        public final void trackExpandedExpose(Context object, StatusBarNotification object2, int n, String string, Boolean bl, String string2) {
            o.g((Object)object, (String)"context");
            o.g((Object)string, (String)"screenType");
            if (!o.c((Object)bl, (Object)Boolean.TRUE) && object2 != null) {
                BaseEventTracker.Companion.get().track((Object)new DynamicIslandExpandedExpose(this.resolveAppName((Context)object, this.resolvePackage((StatusBarNotification)object2)), this.resolvePackage((StatusBarNotification)object2), this.resolveTargetPackage((StatusBarNotification)object2), String.valueOf(object2.getId()), this.resolveNotifTag((StatusBarNotification)object2), this.resolveNotifType((StatusBarNotification)object2), this.resolveServiceScene((StatusBarNotification)object2), n, "\u5c55\u5f00", this.resolveChannelType((StatusBarNotification)object2), this.resolveExtraItems((StatusBarNotification)object2), "1868.1.2.1.45219", this.getPhoneType(), string));
            } else {
                bl = BaseEventTracker.Companion.get();
                String string3 = this.resolveAppName((Context)object, string2);
                object = string2 == null ? DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL : string2;
                object2 = string2 == null ? DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL : string2;
                bl.track(new DynamicIslandExpandedExpose(string3, (String)object, (String)object2, DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "\u6301\u7eed\u66f4\u65b0\u901a\u77e5", DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, n, "\u5c55\u5f00", DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "1868.1.2.1.45219", this.getPhoneType(), string));
            }
        }

        public final void trackSummaryClick(Context object, StatusBarNotification object2, String string, String string2, Boolean bl, String string3) {
            o.g((Object)object, (String)"context");
            o.g((Object)string, (String)"islandForm");
            o.g((Object)string2, (String)"screenType");
            if (!o.c((Object)bl, (Object)Boolean.TRUE) && object2 != null) {
                BaseEventTracker.Companion.get().track((Object)new DynamicIslandSummaryClick(this.resolveAppName((Context)object, this.resolvePackage((StatusBarNotification)object2)), this.resolvePackage((StatusBarNotification)object2), this.resolveTargetPackage((StatusBarNotification)object2), String.valueOf(object2.getId()), this.resolveNotifTag((StatusBarNotification)object2), this.resolveNotifType((StatusBarNotification)object2), this.resolveServiceScene((StatusBarNotification)object2), string, this.resolveChannelType((StatusBarNotification)object2), this.resolveExtraItems((StatusBarNotification)object2), this.resolveClickTip(string), this.getPhoneType(), string2));
            } else {
                bl = BaseEventTracker.Companion.get();
                String string4 = this.resolveAppName((Context)object, string3);
                object = string3 == null ? DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL : string3;
                object2 = string3;
                if (string3 == null) {
                    object2 = DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
                }
                bl.track(new DynamicIslandSummaryClick(string4, (String)object, (String)object2, DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "\u6301\u7eed\u66f4\u65b0\u901a\u77e5", DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, string, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, this.resolveClickTip(string), this.getPhoneType(), string2));
            }
        }

        public final void trackSummaryExpose(Context object, StatusBarNotification statusBarNotification, int n, String string, String string2, String string3, Boolean object2, String string4) {
            o.g((Object)object, (String)"context");
            o.g((Object)string, (String)"disappearType");
            o.g((Object)string2, (String)"islandForm");
            o.g((Object)string3, (String)"screenType");
            if (!o.c((Object)object2, (Object)Boolean.TRUE) && statusBarNotification != null) {
                BaseEventTracker.Companion.get().track((Object)new DynamicIslandSummaryExpose(this.resolveAppName((Context)object, this.resolvePackage(statusBarNotification)), this.resolvePackage(statusBarNotification), this.resolveTargetPackage(statusBarNotification), String.valueOf(statusBarNotification.getId()), this.resolveNotifTag(statusBarNotification), this.resolveNotifType(statusBarNotification), this.resolveServiceScene(statusBarNotification), n, string, string2, this.resolveChannelType(statusBarNotification), this.resolveExtraItems(statusBarNotification), "1868.1.1.1.45215", this.getPhoneType(), string3));
            } else {
                statusBarNotification = BaseEventTracker.Companion.get();
                object2 = this.resolveAppName((Context)object, string4);
                object = string4 == null ? DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL : string4;
                if (string4 == null) {
                    string4 = DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL;
                }
                statusBarNotification.track((Object)new DynamicIslandSummaryExpose((String)object2, (String)object, string4, DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "\u6301\u7eed\u66f4\u65b0\u901a\u77e5", DynamicIslandEventTracker.DEFAULT_ISLAND_NO_SBN, n, string, string2, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, DynamicIslandEventTracker.DEFAULT_ISLAND_STRING_NULL, "1868.1.1.1.45215", this.getPhoneType(), string3));
            }
        }
    };
    private static final String DEFAULT_ISLAND_NO_SBN = "\u672a\u83b7\u53d6";
    private static final String DEFAULT_ISLAND_STRING_NULL = "null";
    private static final d appNameCache$delegate = e.b((a)appNameCache.2.INSTANCE);
}
