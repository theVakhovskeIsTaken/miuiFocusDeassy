/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.m
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import H0.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class MiniWindowEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "AppEventCoordinator";

    public MiniWindowEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    private final boolean hasMiniWindowExpanded(String object) {
        object = this.getMiniWindowStateHandler().getCurrentMap().get(object);
        if (object != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                object = (DynamicIslandContentView)((Object)iterator.next());
                object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                if (!(object instanceof DynamicIslandState.MiniWindowExpanded)) continue;
                return true;
            }
        }
        return false;
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object7, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        o.g((Object)object7, (String)"event");
        boolean bl = object7 instanceof DynamicIslandEvent.EnterMiniWindow;
        int n = 0;
        Object var10_6 = null;
        Object var11_7 = null;
        Object object4 = null;
        Object var12_9 = null;
        if (bl) {
            object4 = object2 != null ? ((DynamicIslandBaseContentView)((Object)object2)).getState() : null;
            String string = object2 != null && (object7 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null && (object7 = object7.getExtras()) != null ? object7.getString("miui.pkg.name") : null;
            object7 = object2 != null && (object7 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object7.getKey() : null;
            Object object5 = this.getBigIslandStateHandler().getCurrent();
            if (o.c((Object)object7, (Object)(object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getKey() : null))) {
                this.getBigIslandStateHandler().setCurrent(null);
                this.getBigIslandStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
            } else {
                object5 = this.getSmallIslandStateHandler().getCurrent();
                object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getKey() : null;
                if (o.c((Object)object7, (Object)object5)) {
                    this.getSmallIslandStateHandler().setCurrent(null);
                    this.getSmallIslandStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
                    object7 = this.getBigIslandStateHandler().getCurrent();
                    StateHandler.addState$default(this.getBigIslandStateHandler(), object7, null, 2, null);
                } else {
                    object5 = this.getExpandedStateHandler().getCurrent();
                    object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getKey() : null;
                    if (o.c(object7, (Object)object5)) {
                        this.getExpandedStateHandler().setCurrent(null);
                    } else {
                        object5 = this.getHiddenStateHandler().getCurrent();
                        object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getKey() : null;
                        if (o.c(object7, (Object)object5)) {
                            object7 = object2 != null && (object7 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object7.getKey() : null;
                            this.removeHiddenState((ArrayList<DynamicIslandContentView>)object3, (String)object7);
                        } else {
                            object7 = this.getAppStateHandler().getCurrentList();
                            object7 = object7 != null ? object7.iterator() : null;
                            while (object7 != null && object7.hasNext()) {
                                Object object6;
                                object5 = (DynamicIslandContentView)((Object)object7.next());
                                object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getKey() : null;
                                if (!o.c((Object)object5, (Object)(object6 = object2 != null && (object6 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object6.getKey() : null))) continue;
                                object7.remove();
                            }
                            object7 = object3 != null ? object3.iterator() : null;
                            while (object7 != null && object7.hasNext()) {
                                object3 = object7.next();
                                o.f(object3, (String)"next(...)");
                                object3 = ((DynamicIslandContentView)((Object)object3)).getCurrentIslandData();
                                if (!o.c((Object)(object3 = object3 != null ? object3.getKey() : null), (Object)(object5 = object2 != null && (object5 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object5.getKey() : null))) continue;
                                object7.remove();
                            }
                            object7 = this.getMiniWindowStateHandler().getCurrentMap();
                            object7 = object7 != null ? (ArrayList)object7.get(string) : null;
                            if (object7 != null) {
                                for (Object object7 : object7) {
                                    object7 = object7 != null && (object7 = object7.getCurrentIslandData()) != null ? object7.getKey() : null;
                                    if (!o.c((Object)object7, (Object)(object3 = object2 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object3.getKey() : null))) continue;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            object7 = this.getMiniWindowStateHandler().getCurrentMap();
            object7 = object7 != null ? (ArrayList)object7.get(string) : null;
            object3 = object7;
            if (object7 == null) {
                object7 = new ArrayList();
                object3 = object7;
                if (string != null) {
                    object5 = this.getMiniWindowStateHandler().getCurrentMap();
                    object3 = object7;
                    if (object5 != null) {
                        object3 = (ArrayList)((HashMap)object5).put(string, object7);
                        object3 = object7;
                    }
                }
            }
            if (string != null) {
                object7 = this.getMiniWindowStateHandler();
                o.e(object7, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler");
                object7 = ((MiniWindowStateHandler)object7).getFirstElement(string);
            } else {
                object7 = null;
            }
            if (object7 == null) {
                object7 = var12_9;
                if (object4 != null) {
                    object7 = ((DynamicIslandState)object4).changeToState(new DynamicIslandState(){});
                }
                object3.add(0, (DynamicIslandContentView)((Object)object2));
                this.getMiniWindowStateHandler().addState((DynamicIslandContentView)((Object)object2), (DynamicIslandState)object7);
            } else if (this.hasMiniWindowExpanded(string)) {
                object7 = var10_6;
                if (object4 != null) {
                    object7 = ((DynamicIslandState)object4).changeToState(new DynamicIslandState(){});
                }
                object3.add((DynamicIslandContentView)((Object)object2));
                this.getMiniWindowStateHandler().addState((DynamicIslandContentView)((Object)object2), (DynamicIslandState)object7);
            } else {
                object7 = var11_7;
                if (object4 != null) {
                    object7 = ((DynamicIslandState)object4).changeToState(new /* invalid duplicate definition of identical inner class */);
                }
                object3.add(0, object2);
                this.getMiniWindowStateHandler().addState((DynamicIslandContentView)((Object)object2), (DynamicIslandState)object7);
            }
            this.getStateHandler().stop();
        } else if (object7 instanceof DynamicIslandEvent.ExitMiniWindow) {
            object7 = object2 != null && (object7 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null && (object7 = object7.getExtras()) != null ? object7.getString("miui.pkg.name") : null;
            HashMap<String, ArrayList<DynamicIslandContentView>> hashMap = this.getMiniWindowStateHandler().getCurrentMap();
            object2 = object4;
            if (hashMap != null) {
                object2 = (ArrayList)hashMap.get(object7);
            }
            if (object2 != null) {
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object4 = object2.next();
                    if (n < 0) {
                        m.n();
                    }
                    if ((object4 = (DynamicIslandContentView)((Object)object4)) != null) {
                        this.collapse((DynamicIslandContentView)((Object)object4), (ArrayList<DynamicIslandContentView>)object3, this.isTinyScreen());
                        this.getStateHandler().stop();
                    }
                    ++n;
                }
            }
            E.d(this.getMiniWindowStateHandler().getCurrentMap()).remove(object7);
        }
    }
}
