/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event.handler;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class AppStateHandler
extends StateHandler {
    public AppStateHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        super(dynamicIslandTouchInteractor);
    }

    public final DynamicIslandContentView getMainElement() {
        Object object = this.getCurrentList();
        if (object != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                if (!(object instanceof DynamicIslandState.AppExpanded)) continue;
                return dynamicIslandContentView;
            }
        }
        return null;
    }

    public final DynamicIslandContentView getSubElement() {
        Object object = this.getCurrentList();
        if (object != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                if (!(object instanceof DynamicIslandState.SubAppExpanded)) continue;
                return dynamicIslandContentView;
            }
        }
        return null;
    }

    public final DynamicIslandContentView getTopLevel() {
        DynamicIslandContentView dynamicIslandContentView = this.getMainElement();
        ArrayList<DynamicIslandContentView> object2 = this.getCurrentList();
        if (object2 != null) {
            for (DynamicIslandContentView dynamicIslandContentView2 : object2) {
                if (o.c((Object)((Object)dynamicIslandContentView), (Object)((Object)dynamicIslandContentView2)) || !StateHandler.compareState$default(this, dynamicIslandContentView, dynamicIslandContentView2, false, 4, null)) continue;
                return dynamicIslandContentView2;
            }
        }
        return null;
    }

    public final int getTopLevelCount() {
        boolean bl;
        Object object;
        int n;
        int n2;
        DynamicIslandContentView dynamicIslandContentView;
        block6: {
            block5: {
                dynamicIslandContentView = this.getMainElement();
                n2 = 0;
                n = 0;
                if (dynamicIslandContentView == null || (object = dynamicIslandContentView.getCurrentIslandData()) == null || (object = object.getProperties()) == null) break block5;
                int n3 = (Integer)object;
                bl = true;
                if (n3 == 1) break block6;
            }
            bl = false;
        }
        object = this.getCurrentList();
        if (object != null) {
            object = object.iterator();
            while (true) {
                n2 = n++;
                if (!object.hasNext()) break;
                DynamicIslandContentView dynamicIslandContentView2 = (DynamicIslandContentView)((Object)object.next());
                if (o.c((Object)((Object)dynamicIslandContentView), (Object)((Object)dynamicIslandContentView2)) || !this.compareState(dynamicIslandContentView, dynamicIslandContentView2, bl)) continue;
            }
        }
        return n2;
    }
}
