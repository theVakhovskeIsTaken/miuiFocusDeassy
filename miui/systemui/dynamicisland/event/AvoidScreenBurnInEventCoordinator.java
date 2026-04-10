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
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class AvoidScreenBurnInEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "AvoidScreenBurnInEventCoordinator";

    public AvoidScreenBurnInEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> arrayList) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.AvoidScreenReset) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("event: ");
            ((StringBuilder)object2).append(object);
            Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            object2 = this.getBigIslandStateHandler().getCurrent();
            object = this.getSmallIslandStateHandler().getCurrent();
            if (object2 != null) {
                StateHandler.addState$default(this.getBigIslandStateHandler(), object2, null, 2, null);
            }
            if (object != null) {
                StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
            }
            this.getStateHandler().stop();
        }
    }
}
