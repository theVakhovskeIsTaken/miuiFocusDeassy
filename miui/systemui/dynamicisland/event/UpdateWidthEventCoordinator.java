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
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class UpdateWidthEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "UpdateWidthEventCoordinator";

    public UpdateWidthEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.UpdateDynamicIslandWidth) {
            if (this.isTinyScreen()) {
                return;
            }
            object = object2 != null && (object = object2.getCurrentIslandData()) != null ? object.getKey() : null;
            object3 = this.getBigIslandStateHandler().getCurrent();
            object3 = object3 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData()) != null ? object3.getKey() : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("current key:");
            stringBuilder.append((String)object);
            stringBuilder.append(", bigIslandKey: ");
            stringBuilder.append((String)object3);
            Log.d((String)TAG, (String)stringBuilder.toString());
            object = object2 != null && (object = object2.getCurrentIslandData()) != null ? object.getKey() : null;
            object2 = this.getBigIslandStateHandler().getCurrent();
            object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
            if (o.c((Object)object, (Object)object2)) {
                object = this.getBigIslandStateHandler().getCurrent();
                StateHandler.addState$default(this.getBigIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                if (this.getBigIslandStateHandler().getCurrentTempShow() == null && (object = this.getSmallIslandStateHandler().getCurrent()) != null) {
                    StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                }
            } else {
                object2 = this.getBigIslandStateHandler().getCurrentTempShow();
                object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
                if (o.c((Object)object, (Object)object2)) {
                    object2 = this.getBigIslandStateHandler().getCurrentTempShow();
                    object = this.getBigIslandStateHandler().getCurrentTempShow();
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                    if (object != null) {
                        ((State)object).setTempShow(true);
                    }
                    StateHandler.addState$default(this.getBigIslandStateHandler(), object2, null, 2, null);
                }
            }
            this.getStateHandler().stop();
        }
    }
}
