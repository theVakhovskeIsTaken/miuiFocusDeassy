/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  android.util.Log
 *  android.view.View
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import G0.s;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public class EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "EventCoordinator";
    private StateHandler appStateHandler;
    private StateHandler bigIslandStateHandler;
    private final DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
    private StateHandler expandedStateHandler;
    private StateHandler hiddenStateHandler;
    private StateHandler miniWindowStateHandler;
    private StateHandler showOnceIslandHandler;
    private StateHandler smallIslandStateHandler;
    private StateHandler stateHandler;

    public EventCoordinator(DynamicIslandEventCoordinator object) {
        o.g((Object)object, (String)"dynamicIslandEventCoordinator");
        this.dynamicIslandEventCoordinator = object;
        this.expandedStateHandler = ((DynamicIslandEventCoordinator)object).getExpandedStateHandler();
        this.bigIslandStateHandler = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler();
        this.showOnceIslandHandler = ((DynamicIslandEventCoordinator)object).getShowOnceIslandHandler();
        this.smallIslandStateHandler = ((DynamicIslandEventCoordinator)object).getSmallIslandStateHandler();
        this.hiddenStateHandler = ((DynamicIslandEventCoordinator)object).getHiddenStateHandler();
        this.miniWindowStateHandler = ((DynamicIslandEventCoordinator)object).getMiniWindowStateHandler();
        this.appStateHandler = object = ((DynamicIslandEventCoordinator)object).getAppStateHandler();
        this.stateHandler = object;
    }

    public static /* synthetic */ void collapse$default(EventCoordinator eventCoordinator, DynamicIslandContentView dynamicIslandContentView, ArrayList arrayList, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 4) != 0) {
                bl = false;
            }
            eventCoordinator.collapse(dynamicIslandContentView, arrayList, bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: collapse");
    }

    public final boolean canExpanded(boolean bl, View view, String string) {
        return this.dynamicIslandEventCoordinator.canExpanded(bl, view, string);
    }

    public final void collapse(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> object2, boolean bl) {
        o.g((Object)object, (String)"view");
        Object object3 = ((DynamicIslandBaseContentView)((Object)object)).getTemplate();
        object3 = object3 != null ? ((IslandTemplate)object3).getBigIslandArea() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("collapse");
        stringBuilder.append(object3);
        Log.e((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object3 = ((DynamicIslandBaseContentView)((Object)object)).getTemplate();
        object3 = object3 != null ? ((IslandTemplate)object3).getBigIslandArea() : null;
        if (object3 == null) {
            object2 = new DynamicIslandState(){
                private boolean deleteByAddNew;

                public final boolean getDeleteByAddNew() {
                    return this.deleteByAddNew;
                }

                public final void setDeleteByAddNew(boolean bl) {
                    this.deleteByAddNew = bl;
                }
            };
            object3 = this.expandedStateHandler.getCurrent();
            if (object3 != null) {
                ((DynamicIslandBaseContentView)((Object)object3)).setState((DynamicIslandState)object2);
            }
            StateHandler.addState$default(this.expandedStateHandler, (DynamicIslandContentView)((Object)object), null, 2, null);
            return;
        }
        if (bl) {
            this.bigIslandStateHandler.handleReplacedStateInTinyScreen((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object2, Boolean.FALSE);
            return;
        }
        object3 = ((DynamicIslandBaseContentView)((Object)object)).getState();
        if (object3 != null && ((State)object3).getTempShow()) {
            this.showOnceIslandHandler.handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object2, Boolean.FALSE);
            object = this.bigIslandStateHandler;
            StateHandler.addState$default((StateHandler)object, ((StateHandler)object).getCurrent(), null, 2, null);
            object = this.smallIslandStateHandler;
            StateHandler.addState$default((StateHandler)object, ((StateHandler)object).getCurrent(), null, 2, null);
        } else {
            this.bigIslandStateHandler.handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object2, Boolean.FALSE);
        }
    }

    public final StateHandler getAppStateHandler() {
        return this.appStateHandler;
    }

    public final StateHandler getBigIslandStateHandler() {
        return this.bigIslandStateHandler;
    }

    public final DynamicIslandEventCoordinator getDynamicIslandEventCoordinator() {
        return this.dynamicIslandEventCoordinator;
    }

    public final StateHandler getExpandedStateHandler() {
        return this.expandedStateHandler;
    }

    public final StateHandler getHiddenStateHandler() {
        return this.hiddenStateHandler;
    }

    public final StateHandler getMiniWindowStateHandler() {
        return this.miniWindowStateHandler;
    }

    public final StateHandler getShowOnceIslandHandler() {
        return this.showOnceIslandHandler;
    }

    public final StateHandler getSmallIslandStateHandler() {
        return this.smallIslandStateHandler;
    }

    public final StateHandler getStateHandler() {
        return this.stateHandler;
    }

    public final DynamicIslandWindowState getWindowState() {
        return this.dynamicIslandEventCoordinator.getWindowState();
    }

    public void handleAppEvent(DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView dynamicIslandContentView, ArrayList<DynamicIslandContentView> arrayList) {
        o.g((Object)dynamicIslandEvent, (String)"event");
    }

    public final boolean hasEmpty(ArrayList<DynamicIslandContentView> object) {
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                if (!(((DynamicIslandContentView)((Object)object.next())).getState() instanceof DynamicIslandState.Empty)) continue;
                return true;
            }
        }
        return false;
    }

    public final boolean isTinyScreen() {
        return this.dynamicIslandEventCoordinator.isTinyScreen();
    }

    public final void removeHiddenState(ArrayList<DynamicIslandContentView> arrayList, String string) {
        this.hiddenStateHandler.setCurrent(null);
        Iterator<DynamicIslandContentView> iterator = arrayList != null ? arrayList.iterator() : null;
        while (iterator != null && iterator.hasNext()) {
            Object object = iterator.next();
            o.f((Object)object, (String)"next(...)");
            object = object.getCurrentIslandData();
            if (!o.c((Object)(object = object != null ? object.getKey() : null), (Object)string)) continue;
            iterator.remove();
        }
        this.hiddenStateHandler.handleFillInState(arrayList);
    }

    public final void setAppStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.appStateHandler = stateHandler;
    }

    public final void setBigIslandStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.bigIslandStateHandler = stateHandler;
    }

    public final void setExpandedStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.expandedStateHandler = stateHandler;
    }

    public final void setHiddenStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.hiddenStateHandler = stateHandler;
    }

    public final void setMiniWindowStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.miniWindowStateHandler = stateHandler;
    }

    public final void setShowOnceIslandHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.showOnceIslandHandler = stateHandler;
    }

    public final void setSmallIslandStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.smallIslandStateHandler = stateHandler;
    }

    public final void setStateHandler(StateHandler stateHandler) {
        o.g((Object)stateHandler, (String)"<set-?>");
        this.stateHandler = stateHandler;
    }

    public final void setTempHide(boolean bl, DynamicIslandEvent object, ArrayList<DynamicIslandContentView> object2) {
        block21: {
            Object object3;
            Object object4;
            block20: {
                o.g((Object)object, (String)"event");
                object = this.bigIslandStateHandler.getCurrent();
                Object object5 = this.showOnceIslandHandler.getCurrent();
                object4 = this.smallIslandStateHandler.getCurrent();
                object3 = this.hiddenStateHandler.getCurrent();
                boolean bl2 = this.getWindowState().getTempHiddenType() == DynamicIslandWindowState.TempHiddenType.MIPLAY_SHOW;
                if (!bl) break block20;
                if (object5 != null) {
                    Object object6 = new StringBuilder();
                    ((StringBuilder)object6).append("once island temp show handleEvent: ");
                    ((StringBuilder)object6).append(object5);
                    Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object6).toString());
                    if (bl2) {
                        StateHandler stateHandler = this.showOnceIslandHandler;
                        object6 = new /* invalid duplicate definition of identical inner class */;
                        object6.setDeleteByAddNew(true);
                        s s2 = s.a;
                        stateHandler.addState((DynamicIslandContentView)((Object)object5), (DynamicIslandState)object6);
                    } else {
                        StateHandler.addState$default(this.showOnceIslandHandler, (DynamicIslandContentView)((Object)object5), null, 2, null);
                    }
                }
                if (object != null && (object5 = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null && !((State)object5).getTempShow()) {
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("big handleEvent: ");
                    ((StringBuilder)object5).append(object);
                    Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object5).toString());
                    StateHandler.addState$default(this.bigIslandStateHandler, (DynamicIslandContentView)((Object)object), null, 2, null);
                }
                if (object4 != null) {
                    object = this.smallIslandStateHandler;
                    object = object != null ? ((StateHandler)object).getCurrent() : null;
                    object5 = new StringBuilder();
                    ((StringBuilder)object5).append("small handleEvent ");
                    ((StringBuilder)object5).append(object4);
                    ((StringBuilder)object5).append(" ");
                    ((StringBuilder)object5).append(object);
                    Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object5).toString());
                    StateHandler.addState$default(this.smallIslandStateHandler, (DynamicIslandContentView)((Object)object4), null, 2, null);
                }
                if (object3 != null && !(((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.Empty)) {
                    object = this.hiddenStateHandler;
                    object = object != null ? ((StateHandler)object).getCurrent() : null;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("hidden handleEvent: ");
                    ((StringBuilder)object4).append(object3);
                    ((StringBuilder)object4).append(" ");
                    ((StringBuilder)object4).append(object);
                    Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object4).toString());
                    StateHandler.addState$default(this.hiddenStateHandler, (DynamicIslandContentView)((Object)object3), null, 2, null);
                }
                if (object2 != null) {
                    object2 = object2.iterator();
                    while (object2.hasNext()) {
                        object = (DynamicIslandContentView)((Object)object2.next());
                        if (!(((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.Hidden)) continue;
                        StateHandler.addState$default(this.hiddenStateHandler, (DynamicIslandContentView)((Object)object), null, 2, null);
                    }
                }
                object = this.miniWindowStateHandler.getCurrentMap().entrySet().iterator();
                while (object.hasNext()) {
                    object2 = (ArrayList)((Map.Entry)object.next()).getValue();
                    if (object2 == null) continue;
                    object3 = object2.iterator();
                    while (object3.hasNext()) {
                        object2 = (DynamicIslandContentView)((Object)object3.next());
                        StateHandler.addState$default(this.miniWindowStateHandler, (DynamicIslandContentView)((Object)object2), null, 2, null);
                    }
                }
                object = this.appStateHandler.getCurrentList();
                if (object == null) break block21;
                object = object.iterator();
                while (object.hasNext()) {
                    object2 = (DynamicIslandContentView)((Object)object.next());
                    StateHandler.addState$default(this.appStateHandler, (DynamicIslandContentView)((Object)object2), null, 2, null);
                }
                break block21;
            }
            if (object != null) {
                StateHandler.addState$default(this.bigIslandStateHandler, (DynamicIslandContentView)((Object)object), null, 2, null);
            }
            if (object4 != null) {
                StateHandler.addState$default(this.smallIslandStateHandler, (DynamicIslandContentView)((Object)object4), null, 2, null);
            }
            if (object3 != null && !(((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.Empty)) {
                StateHandler.addState$default(this.hiddenStateHandler, (DynamicIslandContentView)((Object)object3), null, 2, null);
            }
            if (object2 != null) {
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object = (DynamicIslandContentView)((Object)object2.next());
                    if (!(((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.Hidden)) continue;
                    StateHandler.addState$default(this.hiddenStateHandler, (DynamicIslandContentView)((Object)object), null, 2, null);
                }
            }
            object = this.miniWindowStateHandler.getCurrentMap().entrySet().iterator();
            while (object.hasNext()) {
                object2 = (ArrayList)((Map.Entry)object.next()).getValue();
                if (object2 == null) continue;
                object3 = object2.iterator();
                while (object3.hasNext()) {
                    object2 = (DynamicIslandContentView)((Object)object3.next());
                    StateHandler.addState$default(this.miniWindowStateHandler, (DynamicIslandContentView)((Object)object2), null, 2, null);
                }
            }
            object = this.appStateHandler.getCurrentList();
            if (object != null) {
                object = object.iterator();
                while (object.hasNext()) {
                    object2 = (DynamicIslandContentView)((Object)object.next());
                    StateHandler.addState$default(this.appStateHandler, (DynamicIslandContentView)((Object)object2), null, 2, null);
                }
            }
        }
    }
}
