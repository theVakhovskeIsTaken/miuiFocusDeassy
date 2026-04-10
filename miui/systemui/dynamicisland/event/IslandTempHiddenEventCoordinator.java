/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class IslandTempHiddenEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "IslandTempHiddenEventCoordinator";

    public IslandTempHiddenEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.IslandTempHiddenChanged) {
            DynamicIslandContentView dynamicIslandContentView = this.getExpandedStateHandler().getCurrent();
            object2 = null;
            if (dynamicIslandContentView != null && !((Boolean)this.getWindowState().getStatusBarDisappearance().getValue()).booleanValue() && this.getWindowState().getTempHiddenType() != DynamicIslandWindowState.TempHiddenType.SHOW_ONCE_PROP_ISLAND && (object).getHide()) {
                this.getExpandedStateHandler().setCurrent(null);
                EventCoordinator.collapse$default(this, dynamicIslandContentView, object3, false, 4, null);
            }
            DynamicIslandContentView dynamicIslandContentView2 = this.getBigIslandStateHandler().getCurrent();
            DynamicIslandContentView dynamicIslandContentView3 = this.getSmallIslandStateHandler().getCurrent();
            this.getHiddenStateHandler().getCurrent();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("IslandTempHiddenEventCoordinator handleEvent: expandedState=");
            stringBuilder.append((Object)dynamicIslandContentView);
            stringBuilder.append(" bigState=");
            stringBuilder.append((Object)dynamicIslandContentView2);
            stringBuilder.append(" smallState=");
            stringBuilder.append((Object)dynamicIslandContentView3);
            Log.e((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
            if (this.isTinyScreen()) {
                object = object2;
                if (dynamicIslandContentView2 != null) {
                    object3 = dynamicIslandContentView2.getState();
                    object = object2;
                    if (object3 != null) {
                        object = ((State)object3).getTempShow();
                    }
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("isTiny handleEvent1: ");
                ((StringBuilder)object2).append((Object)dynamicIslandContentView2);
                ((StringBuilder)object2).append(" ");
                ((StringBuilder)object2).append(object);
                Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
                this.getStateHandler().stop();
                return;
            }
            this.setTempHide((object).getHide(), (DynamicIslandEvent)object, (ArrayList<DynamicIslandContentView>)object3);
            this.getStateHandler().stop();
        }
    }
}
