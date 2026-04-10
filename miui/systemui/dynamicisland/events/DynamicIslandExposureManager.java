/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  X0.b
 *  android.content.Context
 *  android.os.Bundle
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  systemui.plugin.eventtracking.EventTracker
 */
package miui.systemui.dynamicisland.events;

import X0.b;
import android.content.Context;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.events.Callback;
import miui.systemui.dynamicisland.events.DynamicIslandEventTracker;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import systemui.plugin.eventtracking.EventTracker;

@DynamicIslandScope
public final class DynamicIslandExposureManager {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final boolean DEBUG = false;
    private static final String ISLAND_FORM_BIG = "big";
    private static final String ISLAND_FORM_EXPAND = "expand";
    private static final String ISLAND_FORM_SMALL = "small";
    private static final String TAG = "DynamicIslandExpoMan";
    private final AntiBurnInManager antiBurnInMan;
    private final List<Callback> callbacks;
    private final Context context;
    private final DynamicIslandEventCoordinator eventCoordinator;

    public DynamicIslandExposureManager(Context context, DynamicIslandEventCoordinator dynamicIslandEventCoordinator, AntiBurnInManager antiBurnInManager) {
        o.g((Object)context, (String)"context");
        o.g((Object)dynamicIslandEventCoordinator, (String)"eventCoordinator");
        o.g((Object)antiBurnInManager, (String)"antiBurnInMan");
        this.context = context;
        this.eventCoordinator = dynamicIslandEventCoordinator;
        this.antiBurnInMan = antiBurnInManager;
        this.callbacks = new ArrayList<Callback>();
    }

    private final String getStateStr(DynamicIslandState object) {
        if (object == null) {
            object = "null";
        } else if (object instanceof DynamicIslandState.BigIsland) {
            object = ISLAND_FORM_BIG;
        } else if (object instanceof DynamicIslandState.SmallIsland) {
            object = ISLAND_FORM_SMALL;
        } else if (object instanceof DynamicIslandState.Expanded) {
            object = ISLAND_FORM_EXPAND;
        } else {
            object = object.getClass().getSimpleName();
            o.f((Object)object, (String)"getSimpleName(...)");
        }
        return object;
    }

    private final String resolveDisappearType() {
        Object object = this.eventCoordinator.getHandlingEvent();
        boolean bl = object instanceof DynamicIslandEvent.SwipeRight ? true : object instanceof DynamicIslandEvent.SwipeLeft;
        object = bl ? "\u5207\u6362\u5927\u5c0f\u5c9b" : (object instanceof DynamicIslandEvent.EnterMiniWindow ? "\u4e0b\u62c9\u5c55\u5f00" : (object instanceof DynamicIslandEvent.DeletedDynamicIsland ? "\u5220\u9664" : (object instanceof DynamicIslandEvent.ClickDynamicIsland ? "\u5c55\u5f00" : "\u5176\u4ed6")));
        return object;
    }

    private final String resolveExpandType() {
        String string = this.eventCoordinator.getUserExpanded() ? "\u4e3b\u52a8" : "\u88ab\u52a8";
        return string;
    }

    private final boolean shouldHandleBurnIn(String string, Integer n) {
        boolean bl = !(n != null && n == 0 || !o.c((Object)string, (Object)ISLAND_FORM_BIG) && !o.c((Object)string, (Object)ISLAND_FORM_SMALL));
        return bl;
    }

    private final void trackExpand(int n, StatusBarNotification statusBarNotification, Boolean bl, String string) {
        DynamicIslandEventTracker.Companion companion = DynamicIslandEventTracker.Companion;
        Context context = this.context;
        companion.trackExpandedExpose(context, statusBarNotification, n, EventTracker.Companion.getScreenType(context), bl, string);
    }

    private final void trackSummary(int n, String string, StatusBarNotification statusBarNotification, Boolean bl, String string2) {
        DynamicIslandEventTracker.Companion.trackSummaryExpose(this.context, statusBarNotification, n, this.resolveDisappearType(), string, EventTracker.Companion.getScreenType(this.context), bl, string2);
    }

    public final void startExpose(DynamicIslandContentViewController dynamicIslandContentViewController) {
        o.g((Object)dynamicIslandContentViewController, (String)"con");
        String string = dynamicIslandContentViewController.getIslandKey();
        if (string == null) {
            return;
        }
        if (this.shouldHandleBurnIn(this.getStateStr(((DynamicIslandContentView)((Object)dynamicIslandContentViewController.getView())).getState()), dynamicIslandContentViewController.getIslandProp())) {
            this.antiBurnInMan.scheduleEnter(string, (DynamicIslandContentView)((Object)dynamicIslandContentViewController.getView()));
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final void stopExpose(DynamicIslandContentViewController object) {
        void var7_9;
        String string;
        Bundle bundle;
        o.g((Object)object, (String)"con");
        long l = ((DynamicIslandContentViewController)object).getActualTime();
        StatusBarNotification statusBarNotification = ((DynamicIslandContentViewController)object).getIslandSbn();
        String string2 = this.getStateStr(((DynamicIslandContentView)((Object)((DynamicIslandBaseContentViewController)object).getView())).getLastState());
        boolean bl = this.eventCoordinator.getWindowView().isMediaApp(((DynamicIslandContentView)((Object)((DynamicIslandBaseContentViewController)object).getView())).getCurrentIslandData());
        DynamicIslandData dynamicIslandData = ((DynamicIslandContentView)((Object)((DynamicIslandBaseContentViewController)object).getView())).getCurrentIslandData();
        if (dynamicIslandData != null && (bundle = dynamicIslandData.getExtras()) != null) {
            String string3 = bundle.getString("miui.pkg.name");
        } else {
            Object var7_11 = null;
        }
        if (this.shouldHandleBurnIn(string2, ((DynamicIslandContentViewController)object).getIslandProp()) && (string = ((DynamicIslandContentViewController)object).getIslandKey()) != null) {
            this.antiBurnInMan.pauseExpose((DynamicIslandContentView)((Object)((DynamicIslandBaseContentViewController)object).getView()), l, string);
        }
        int n = b.a((double)((double)l / 1000.0));
        if (999L > l) return;
        int n2 = string2.hashCode();
        if (n2 != -1289167206) {
            if (n2 != 97536) {
                if (n2 == 109548807 && string2.equals(ISLAND_FORM_SMALL)) {
                    this.trackSummary(n, "\u5c0f", statusBarNotification, bl, (String)var7_9);
                    return;
                }
            } else if (string2.equals(ISLAND_FORM_BIG)) {
                this.trackSummary(n, "\u5927", statusBarNotification, bl, (String)var7_9);
                return;
            }
        } else if (string2.equals(ISLAND_FORM_EXPAND)) {
            this.trackExpand(n, statusBarNotification, bl, (String)var7_9);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("failed to get exposed island ");
        ((StringBuilder)object).append(string2);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
    }
}
