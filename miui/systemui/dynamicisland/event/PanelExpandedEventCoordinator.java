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
import java.util.Map;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class PanelExpandedEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "PanelExpandedEventCoordinator";

    public PanelExpandedEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.PanelExpandedRatio) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("event: ");
            ((StringBuilder)object2).append(object);
            Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            DynamicIslandContentView dynamicIslandContentView = this.getExpandedStateHandler().getCurrent();
            object = this.getBigIslandStateHandler().getCurrent();
            object2 = this.getSmallIslandStateHandler().getCurrent();
            this.getHiddenStateHandler().getCurrent();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("PanelExpandedEventCoordinator handleEvent: expandedState=");
            ((StringBuilder)object3).append((Object)dynamicIslandContentView);
            ((StringBuilder)object3).append(" bigState=");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(" smallState=");
            ((StringBuilder)object3).append(object2);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object3).toString());
            if (object != null) {
                StateHandler.addState$default(this.getBigIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
            }
            if (object2 != null) {
                StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object2), null, 2, null);
            }
            object = this.getMiniWindowStateHandler().getCurrentMap().entrySet().iterator();
            while (object.hasNext()) {
                object2 = (ArrayList)((Map.Entry)object.next()).getValue();
                if (object2 == null) continue;
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object3 = (DynamicIslandContentView)((Object)object2.next());
                    StateHandler.addState$default(this.getMiniWindowStateHandler(), object3, null, 2, null);
                }
            }
            object = this.getAppStateHandler().getCurrentList();
            if (object != null) {
                object2 = object.iterator();
                while (object2.hasNext()) {
                    object = (DynamicIslandContentView)((Object)object2.next());
                    StateHandler.addState$default(this.getAppStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                }
            }
            this.getStateHandler().stop();
        }
    }
}
