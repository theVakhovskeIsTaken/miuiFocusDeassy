/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.u
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event.handler;

import H0.u;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class MiniWindowStateHandler
extends StateHandler {
    public MiniWindowStateHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        super(dynamicIslandTouchInteractor);
    }

    public final DynamicIslandContentView getFirstElement(String object) {
        o.g((Object)object, (String)"pkg");
        object = this.getCurrentMap().get(object);
        if (object != null && !object.isEmpty()) {
            return (DynamicIslandContentView)((Object)u.K((List)object));
        }
        return null;
    }

    public final DynamicIslandContentView getMainElement(String object) {
        o.g((Object)object, (String)"pkg");
        object = this.getCurrentMap().get(object);
        if (object != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                if (!(object instanceof DynamicIslandState.MiniWindowExpanded)) continue;
                return dynamicIslandContentView;
            }
        }
        return null;
    }

    public final DynamicIslandContentView getSubElement(String object) {
        o.g((Object)object, (String)"pkg");
        object = this.getCurrentMap().get(object);
        if (object != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                if (!(object instanceof DynamicIslandState.SubMiniWindowExpanded)) continue;
                return dynamicIslandContentView;
            }
        }
        return null;
    }

    public final DynamicIslandContentView getTopLevel(String iterator) {
        o.g((Object)iterator, (String)"pkg");
        DynamicIslandContentView dynamicIslandContentView = this.getMainElement((String)((Object)iterator));
        iterator = this.getCurrentMap().get(iterator);
        if (iterator != null) {
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView2 = (DynamicIslandContentView)((Object)iterator.next());
                if (o.c((Object)((Object)dynamicIslandContentView), (Object)((Object)dynamicIslandContentView2)) || !StateHandler.compareState$default(this, dynamicIslandContentView, dynamicIslandContentView2, false, 4, null)) continue;
                return dynamicIslandContentView2;
            }
        }
        return null;
    }

    public final int getTopLevelCount(String iterator) {
        boolean bl;
        Object object;
        int n;
        int n2;
        DynamicIslandContentView dynamicIslandContentView;
        block6: {
            block5: {
                o.g((Object)iterator, (String)"pkg");
                dynamicIslandContentView = this.getMainElement((String)((Object)iterator));
                iterator = this.getCurrentMap().get(iterator);
                n2 = 0;
                n = 0;
                if (dynamicIslandContentView == null || (object = dynamicIslandContentView.getCurrentIslandData()) == null || (object = object.getProperties()) == null) break block5;
                int n3 = object.intValue();
                bl = true;
                if (n3 == 1) break block6;
            }
            bl = false;
        }
        if (iterator != null) {
            iterator = iterator.iterator();
            while (true) {
                n2 = n++;
                if (!iterator.hasNext()) break;
                object = (DynamicIslandContentView)((Object)iterator.next());
                if (o.c((Object)((Object)dynamicIslandContentView), (Object)object) || !this.compareState(dynamicIslandContentView, (DynamicIslandContentView)((Object)object), bl)) continue;
            }
        }
        return n2;
    }
}
