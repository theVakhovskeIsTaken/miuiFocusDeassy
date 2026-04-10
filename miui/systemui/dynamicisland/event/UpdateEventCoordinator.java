/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event;

import android.util.Log;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.b;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class UpdateEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "UpdateEventCoordinator";

    public UpdateEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    public static /* synthetic */ boolean a(Function1 function1, Object object) {
        return UpdateEventCoordinator.handleAppEvent$lambda$1(function1, object);
    }

    private static final boolean handleAppEvent$lambda$1(Function1 function1, Object object) {
        o.g((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.UpdateDynamicIsland) {
            Object object4;
            if (object2 != null && (object4 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null && (object4 = object4.getExtras()) != null) {
                object4.getString("miui.pkg.name");
            }
            object4 = new StringBuilder();
            object4.append("UpdateEventCoordinator handleEvent: ");
            object4.append(object);
            Log.d((String)"DynamicIslandEventDebug", (String)object4.toString());
            boolean bl = this.isTinyScreen();
            DynamicIslandData dynamicIslandData = null;
            Object var15_7 = null;
            Object var13_8 = null;
            Iterator iterator = null;
            if (bl) {
                object = object2 != null && (object = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object.getKey() : null;
                object3 = this.getBigIslandStateHandler().getCurrent();
                if (o.c((Object)object, (Object)(object3 = object3 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData()) != null ? object3.getKey() : null))) {
                    StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                } else {
                    object = object2 != null && (object = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object.getKey() : null;
                    object2 = this.getSmallIslandStateHandler().getCurrent();
                    if (o.c((Object)object, (Object)(object2 = object2 != null && (object2 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object2.getKey() : null))) {
                        StateHandler.addState$default(this.getSmallIslandStateHandler(), this.getSmallIslandStateHandler().getCurrent(), null, 2, null);
                    }
                }
                this.getStateHandler().stop();
                return;
            }
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            if (object2 != null && (object = ((DynamicIslandBaseContentView)((Object)object2)).getState()) != null && ((State)object).getExpanded() || (bl = object2 != null && (object = ((DynamicIslandBaseContentView)((Object)object2)).getState()) != null ? o.c((Object)((State)object).getUpdateOrder(), (Object)Boolean.TRUE) : false)) {
                object4 = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                object = new StringBuilder();
                ((StringBuilder)object).append("UpdateEventCoordinator event: ");
                ((StringBuilder)object).append(object4);
                Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
                object = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
                object = object != null ? object.getKey() : null;
                object4 = this.getBigIslandStateHandler().getCurrent();
                object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                if (o.c((Object)object, (Object)object4)) {
                    object = this.getBigIslandStateHandler().getCurrent();
                    this.getBigIslandStateHandler().setCurrent(null);
                    this.getBigIslandStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
                    object2 = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                    boolean bl7 = bl6;
                    if (object2 != null) {
                        bl7 = bl6;
                        if (((State)object2).getExpanded()) {
                            bl7 = true;
                        }
                    }
                    if (bl7) {
                        this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                    } else {
                        this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                    }
                } else {
                    object4 = this.getSmallIslandStateHandler().getCurrent();
                    object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                    if (o.c((Object)object, (Object)object4)) {
                        object = this.getSmallIslandStateHandler().getCurrent();
                        this.getSmallIslandStateHandler().setCurrent(null);
                        this.getSmallIslandStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
                        object2 = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                        boolean bl8 = bl2;
                        if (object2 != null) {
                            bl8 = bl2;
                            if (((State)object2).getExpanded()) {
                                bl8 = true;
                            }
                        }
                        if (bl8) {
                            this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                        } else {
                            this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                        }
                    } else {
                        object4 = this.getExpandedStateHandler().getCurrent();
                        object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                        if (o.c((Object)object, (Object)object4)) {
                            object = this.getExpandedStateHandler().getCurrent();
                            StateHandler.addState$default(this.getExpandedStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                        } else {
                            object4 = this.getHiddenStateHandler().getCurrent();
                            object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                            if (o.c((Object)object, (Object)object4)) {
                                object4 = this.getHiddenStateHandler().getCurrent();
                                dynamicIslandData = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
                                object = iterator;
                                if (dynamicIslandData != null) {
                                    object = dynamicIslandData.getKey();
                                }
                                this.removeHiddenState((ArrayList<DynamicIslandContentView>)object3, (String)object);
                                object = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                                boolean bl9 = bl3;
                                if (object != null) {
                                    bl9 = bl3;
                                    if (((State)object).getExpanded()) {
                                        bl9 = true;
                                    }
                                }
                                if (bl9) {
                                    this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object4), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                } else {
                                    this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object4), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                }
                            } else {
                                if (((DynamicIslandBaseContentView)((Object)object2)).getState() instanceof DynamicIslandState.Deleted && ((DynamicIslandBaseContentView)((Object)object2)).getLastState() instanceof DynamicIslandState.Expanded) {
                                    object = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                                    boolean bl10 = bl4;
                                    if (object != null) {
                                        bl10 = bl4;
                                        if (((State)object).getExpanded()) {
                                            bl10 = true;
                                        }
                                    }
                                    if (bl10) {
                                        this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object2), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                    } else {
                                        this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object2), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                    }
                                    return;
                                }
                                object = var15_7;
                                if (object3 != null) {
                                    block56: {
                                        iterator = object3.iterator();
                                        do {
                                            object = dynamicIslandData;
                                            if (!iterator.hasNext()) break block56;
                                            var13_8 = iterator.next();
                                            object = ((DynamicIslandContentView)var13_8).getCurrentIslandData();
                                            object = object != null ? object.getKey() : null;
                                            object4 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
                                        } while (!o.c((Object)object, (Object)(object4 = object4 != null ? object4.getKey() : null)));
                                        object = var13_8;
                                    }
                                    object = (DynamicIslandContentView)((Object)object);
                                }
                                if (object3 != null) {
                                    ((ArrayList)object3).removeIf(new b(new Function1((DynamicIslandContentView)((Object)object2)){
                                        final DynamicIslandContentView $view;
                                        {
                                            this.$view = dynamicIslandContentView;
                                            super(1);
                                        }

                                        public final Boolean invoke(DynamicIslandContentView object) {
                                            o.g((Object)object, (String)"it");
                                            object = object.getCurrentIslandData();
                                            String string = null;
                                            object = object != null ? object.getKey() : null;
                                            DynamicIslandData dynamicIslandData = this.$view.getCurrentIslandData();
                                            if (dynamicIslandData != null) {
                                                string = dynamicIslandData.getKey();
                                            }
                                            return o.c((Object)object, (Object)string);
                                        }
                                    }));
                                }
                                if (object == null) {
                                    return;
                                }
                                object2 = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                                boolean bl11 = bl5;
                                if (object2 != null) {
                                    bl11 = bl5;
                                    if (((State)object2).getExpanded()) {
                                        bl11 = true;
                                    }
                                }
                                if (bl11) {
                                    this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                } else {
                                    this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                }
                            }
                        }
                    }
                }
                this.getStateHandler().stop();
            } else {
                object = object2 != null ? ((DynamicIslandBaseContentView)((Object)object2)).getState() : null;
                object4 = new StringBuilder();
                object4.append("UpdateEventCoordinator event1: ");
                object4.append(object);
                Log.e((String)"DynamicIslandEventDebug", (String)object4.toString());
                object = object2 != null && (object = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData()) != null ? object.getKey() : null;
                object4 = this.getBigIslandStateHandler().getCurrent();
                object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                if (o.c((Object)object, (Object)object4)) {
                    object = this.getBigIslandStateHandler().getCurrent();
                    StateHandler.addState$default(this.getBigIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                    if (this.getBigIslandStateHandler().getCurrentTempShow() == null && (object = this.getSmallIslandStateHandler().getCurrent()) != null) {
                        StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                    }
                } else {
                    object4 = this.getShowOnceIslandHandler().getCurrent();
                    object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                    if (o.c((Object)object, (Object)object4)) {
                        object2 = this.getShowOnceIslandHandler().getCurrent();
                        object = this.getShowOnceIslandHandler().getCurrent();
                        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                        if (object != null) {
                            ((State)object).setTempShow(true);
                        }
                        this.getBigIslandStateHandler().setCurrentTempShow(this.getShowOnceIslandHandler().getCurrent());
                        StateHandler.addState$default(this.getShowOnceIslandHandler(), (DynamicIslandContentView)((Object)object2), null, 2, null);
                    } else {
                        object4 = this.getSmallIslandStateHandler().getCurrent();
                        object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                        if (o.c((Object)object, (Object)object4)) {
                            object = this.getSmallIslandStateHandler().getCurrent();
                            StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                        } else {
                            object4 = this.getExpandedStateHandler().getCurrent();
                            object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                            if (o.c((Object)object, (Object)object4)) {
                                object = this.getExpandedStateHandler().getCurrent();
                                StateHandler.addState$default(this.getExpandedStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                            } else {
                                object4 = this.getHiddenStateHandler().getCurrent();
                                object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
                                if (o.c((Object)object, (Object)object4)) {
                                    object = this.getHiddenStateHandler().getCurrent();
                                    StateHandler.addState$default(this.getHiddenStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                                } else {
                                    object = var13_8;
                                    if (object2 != null) {
                                        object = ((DynamicIslandBaseContentView)((Object)object2)).getState();
                                    }
                                    if (object instanceof DynamicIslandState.Deleted && ((DynamicIslandBaseContentView)((Object)object2)).getLastState() instanceof DynamicIslandState.Expanded) {
                                        this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object2), (ArrayList<DynamicIslandContentView>)object3, Boolean.FALSE);
                                    }
                                }
                            }
                        }
                    }
                }
                this.getStateHandler().stop();
            }
        }
    }
}
