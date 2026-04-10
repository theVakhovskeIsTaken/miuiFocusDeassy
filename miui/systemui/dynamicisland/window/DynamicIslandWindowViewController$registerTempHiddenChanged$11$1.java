/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import M0.b;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.1<T>
implements g {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public final Object emit(String string, d object) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = DynamicIslandWindowViewController.access$getView(this.this$0).getEventCoordinator();
        if (dynamicIslandEventCoordinator == null) {
            return s.a;
        }
        object = this.this$0;
        Object object2 = dynamicIslandEventCoordinator.getLastFullScreenActivityPkg();
        if (((DynamicIslandWindowViewController)object).isInMiniWindow((String)object2, b.c((int)DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).getCurrentUserId()))) {
            Object object3 = new StringBuilder();
            object3.append("fullscreen_to_mini_freeform state: ");
            object3.append((String)object2);
            Log.d((String)"DynamicIslandAnimDebug", (String)object3.toString());
            ((DynamicIslandWindowViewController)object).cancelDelayOperate((String)object2);
            object2 = DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).requestHasIsland((String)object2);
            if (object2 != null) {
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object3 = (DynamicIslandContentView)((Object)object2.next());
                    DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object), (DynamicIslandContentView)((Object)object3), true, null, 4, null);
                    DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).enterMiniWindow((DynamicIslandContentView)((Object)object3));
                    DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)((Object)object3));
                }
            }
        }
        dynamicIslandEventCoordinator.setLastFullScreenActivityPkg(string);
        object = dynamicIslandEventCoordinator.getExpandedStateHandler().getCurrent();
        if (object != null) {
            if (!((DynamicIslandBaseContentView)((Object)object)).getHideByFullScreenPkg()) {
                object = null;
            }
            if (object != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("refresh miniBar by fullScreen pkg = ");
                ((StringBuilder)object2).append(string);
                Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object2).toString());
                dynamicIslandEventCoordinator.updateMiniBar((DynamicIslandContentView)((Object)object));
            }
        }
        return s.a;
    }
}
