/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event;

import android.util.Log;
import android.view.View;
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
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class AddEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "AddEventCoordinator";

    public AddEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    private final void updateExpandedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> object2) {
        if (!CommonUtils.INSTANCE.getIS_TABLET()) {
            return;
        }
        DynamicIslandContentView dynamicIslandContentView = this.getBigIslandStateHandler().getCurrent();
        DynamicIslandContentView dynamicIslandContentView2 = this.getExpandedStateHandler().getCurrent();
        object = object2 != null ? Integer.valueOf(((ArrayList)object2).size()) : null;
        int n = this.getMiniWindowStateHandler().getCurrentMap().size();
        Object object3 = this.getAppStateHandler().getCurrentList();
        object3 = object3 != null ? Integer.valueOf(object3.size()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateExpandedState, ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(", ");
        stringBuilder.append((Object)dynamicIslandContentView2);
        stringBuilder.append(", ");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(object3);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object = this.getBigIslandStateHandler().getCurrent();
        if (object != null) {
            object.calculateBigIslandY();
        }
        if (object2 != null) {
            object = object2.iterator();
            while (object.hasNext()) {
                ((DynamicIslandContentView)((Object)object.next())).calculateBigIslandY();
            }
        }
        object = this.getMiniWindowStateHandler().getCurrentMap().values();
        o.f((Object)object, (String)"<get-values>(...)");
        object = object.iterator();
        while (object.hasNext()) {
            object2 = (ArrayList)object.next();
            if (object2 == null) continue;
            o.d((Object)object2);
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object3 = (DynamicIslandContentView)((Object)object2.next());
                if (object3 == null) continue;
                ((DynamicIslandBaseContentView)((Object)object3)).calculateBigIslandY();
            }
        }
        object = this.getAppStateHandler().getCurrentList();
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                object2 = (DynamicIslandContentView)((Object)object.next());
                if (object2 == null) continue;
                ((DynamicIslandBaseContentView)((Object)object2)).calculateBigIslandY();
            }
        }
        if (this.getExpandedStateHandler().getCurrent() != null) {
            object = this.getExpandedStateHandler().getCurrent();
            if (object != null) {
                object.calculateBigIslandY();
            }
            StateHandler.addState$default(this.getExpandedStateHandler(), this.getExpandedStateHandler().getCurrent(), null, 2, null);
        }
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> arrayList) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.AddDynamicIsland) {
            Object object3;
            Object object4;
            boolean bl;
            boolean bl2 = bl = false;
            if (object2 != null) {
                object4 = object2.getState();
                bl2 = bl;
                if (object4 != null) {
                    bl2 = bl;
                    if (((State)object4).getExpanded()) {
                        bl2 = true;
                    }
                }
            }
            Object var8_7 = null;
            object4 = object2 != null && (object4 = object2.getCurrentIslandData()) != null ? object4.getView() : null;
            object3 = object2 != null && (object3 = object2.getCurrentIslandData()) != null ? object3.getKey() : null;
            bl2 = this.canExpanded(bl2, (View)object4, (String)object3);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("handleEvent: ");
            ((StringBuilder)object4).append(object);
            ((StringBuilder)object4).append(" canExpanded ");
            ((StringBuilder)object4).append(bl2);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object4).toString());
            if ((object).getTempShow()) {
                if (bl2) {
                    this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, Boolean.FALSE);
                } else {
                    this.getShowOnceIslandHandler().handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, Boolean.FALSE);
                    object4 = this.getBigIslandStateHandler().getCurrent();
                    object = this.getSmallIslandStateHandler().getCurrent();
                    if (object4 != null) {
                        StateHandler.addState$default(this.getBigIslandStateHandler(), (DynamicIslandContentView)((Object)object4), null, 2, null);
                    }
                    if (object != null) {
                        StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                    }
                    this.updateExpandedState((DynamicIslandContentView)((Object)object2), arrayList);
                }
                this.getStateHandler().stop();
                return;
            }
            if (this.isTinyScreen()) {
                object = var8_7;
                if (object2 != null) {
                    object4 = object2.getCurrentIslandData();
                    object = var8_7;
                    if (object4 != null) {
                        object = object4.getProperties();
                    }
                }
                object4 = new StringBuilder();
                ((StringBuilder)object4).append("handleEvent isInTinyScreen: prop=");
                ((StringBuilder)object4).append(object);
                Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object4).toString());
                this.getBigIslandStateHandler().handleReplacedStateInTinyScreen((DynamicIslandContentView)((Object)object2), arrayList, Boolean.FALSE);
                object = new StringBuilder();
                ((StringBuilder)object).append("hiddenList: ");
                ((StringBuilder)object).append(arrayList);
                Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
                this.getStateHandler().stop();
                return;
            }
            if (bl2) {
                object4 = this.getExpandedStateHandler().getCurrent();
                object3 = this.getExpandedStateHandler();
                object = Boolean.FALSE;
                ((StateHandler)object3).handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, (Boolean)object);
                if (object4 != null && (object2 = ((DynamicIslandBaseContentView)((Object)object4)).getState()) != null && ((State)object2).getTempShow()) {
                    this.getShowOnceIslandHandler().handleReplacedState((DynamicIslandContentView)((Object)object4), arrayList, (Boolean)object);
                    object2 = this.getBigIslandStateHandler().getCurrent();
                    object = this.getSmallIslandStateHandler().getCurrent();
                    if (object2 != null) {
                        StateHandler.addState$default(this.getBigIslandStateHandler(), object2, null, 2, null);
                    }
                    if (object != null) {
                        StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                    }
                }
            } else {
                this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, Boolean.FALSE);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("hiddenList: ");
            ((StringBuilder)object).append(arrayList);
            Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
            this.getStateHandler().stop();
        }
    }
}
