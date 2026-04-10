/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import G0.s;
import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class CollapseEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "CollapseEventCoordinator";

    public CollapseEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> arrayList) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.Collapse) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("event: ");
            ((StringBuilder)object2).append(object);
            Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            object = this.getExpandedStateHandler().getCurrent();
            DynamicIslandContentView dynamicIslandContentView = this.getShowOnceIslandHandler().getCurrent();
            if (dynamicIslandContentView != null && this.getWindowState().isAodOn() && !this.getWindowState().isFullAodOn()) {
                object2 = this.getBigIslandStateHandler();
                DynamicIslandState dynamicIslandState = new DynamicIslandState(){
                    private boolean deleteByAddNew;

                    public final boolean getDeleteByAddNew() {
                        return this.deleteByAddNew;
                    }

                    public final void setDeleteByAddNew(boolean bl) {
                        this.deleteByAddNew = bl;
                    }
                };
                dynamicIslandState.setDeleteByAddNew(true);
                dynamicIslandState.setDeleteNoAnimation(true);
                s s2 = s.a;
                ((StateHandler)object2).addState(dynamicIslandContentView, dynamicIslandState);
            }
            if (object != null) {
                this.getExpandedStateHandler().setCurrent(null);
                EventCoordinator.collapse$default(this, (DynamicIslandContentView)((Object)object), arrayList, false, 4, null);
            }
            this.getStateHandler().stop();
        }
    }
}
