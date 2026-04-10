/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  H0.u
 *  android.content.Context
 *  android.util.Log
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event;

import G0.s;
import H0.u;
import android.content.Context;
import android.util.Log;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.SwipeEventCoordinator;
import miui.systemui.dynamicisland.event.a;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class SwipeEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "SwipeEventCoordinator";

    public SwipeEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    public static /* synthetic */ boolean a(Function1 function1, Object object) {
        return SwipeEventCoordinator.handleAppEvent$lambda$1(function1, object);
    }

    private static final boolean handleAppEvent$lambda$1(Function1 function1, Object object) {
        o.g((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> arrayList) {
        Object object3;
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.SwipeLeft) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("handleEvent: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            object3 = this.getBigIslandStateHandler().getCurrent();
            Object object4 = this.getSmallIslandStateHandler().getCurrent();
            object2 = this.getHiddenStateHandler().getCurrent();
            if (object3 != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("states: ");
                stringBuilder.append(object3);
                stringBuilder.append(" ");
                stringBuilder.append(object4);
                stringBuilder.append(" ");
                stringBuilder.append(object2);
                Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
                if (object4 == null && object2 != null && !(((DynamicIslandBaseContentView)((Object)object2)).getState() instanceof DynamicIslandState.Empty)) {
                    StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object3), null, 2, null);
                    this.getSmallIslandStateHandler().handleFillInState(arrayList);
                } else {
                    object2 = ((DynamicIslandBaseContentView)((Object)object3)).getState();
                    object2 = object2 != null ? ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){}) : null;
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("SwipeLeft ");
                    ((StringBuilder)object4).append(arrayList);
                    Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object4).toString());
                    this.getBigIslandStateHandler().addState((DynamicIslandContentView)((Object)object3), (DynamicIslandState)object2);
                    if (!this.hasEmpty(arrayList) && arrayList != null) {
                        object2 = object3.getContext();
                        o.f((Object)object2, (String)"getContext(...)");
                        object2 = new DynamicIslandContentView((Context)object2, null, 2, null);
                        ((DynamicIslandBaseContentView)((Object)object2)).setState(new DynamicIslandState(){});
                        arrayList.add((DynamicIslandContentView)((Object)object2));
                    }
                    if (arrayList != null) {
                        arrayList.removeIf(new a(new Function1((DynamicIslandContentView)((Object)object3)){
                            final DynamicIslandContentView $bigState;
                            {
                                this.$bigState = dynamicIslandContentView;
                                super(1);
                            }

                            public final Boolean invoke(DynamicIslandContentView object) {
                                o.g((Object)object, (String)"it");
                                object = object.getCurrentIslandData();
                                String string = null;
                                object = object != null ? object.getKey() : null;
                                DynamicIslandData dynamicIslandData = this.$bigState.getCurrentIslandData();
                                if (dynamicIslandData != null) {
                                    string = dynamicIslandData.getKey();
                                }
                                return o.c((Object)object, (Object)string);
                            }
                        }));
                    }
                    if (arrayList != null) {
                        arrayList.add((DynamicIslandContentView)((Object)object3));
                    }
                    this.getBigIslandStateHandler().handleFillInState(arrayList);
                }
            } else {
                if (!this.hasEmpty(arrayList) && arrayList != null) {
                    object2 = this.getDynamicIslandEventCoordinator().getWindowView().getContext();
                    o.f((Object)object2, (String)"getContext(...)");
                    object2 = new DynamicIslandContentView((Context)object2, null, 2, null);
                    ((DynamicIslandBaseContentView)((Object)object2)).setState(new /* invalid duplicate definition of identical inner class */);
                    arrayList.add((DynamicIslandContentView)((Object)object2));
                }
                this.getBigIslandStateHandler().handleFillInState(arrayList);
                this.getSmallIslandStateHandler().handleFillInState(arrayList);
            }
            object2 = this.getExpandedStateHandler().getCurrent();
            if (object2 != null) {
                this.getExpandedStateHandler().setCurrent(null);
                EventCoordinator.collapse$default(this, (DynamicIslandContentView)((Object)object2), arrayList, false, 4, null);
            }
            this.getStateHandler().stop();
        }
        if (object instanceof DynamicIslandEvent.SwipeRight) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("handleEvent: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            if (arrayList != null && arrayList.size() != 0) {
                object = arrayList.get(arrayList.size() - 1);
                o.f((Object)object, (String)"get(...)");
                object = (DynamicIslandContentView)((Object)object);
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("hiddenState: ");
                ((StringBuilder)object2).append(object);
                Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
                if (!(((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.Empty)) {
                    if (!this.hasEmpty(arrayList)) {
                        object2 = this.getDynamicIslandEventCoordinator().getWindowView().getContext();
                        o.f((Object)object2, (String)"getContext(...)");
                        object3 = new DynamicIslandContentView((Context)object2, null, 2, null);
                        ((DynamicIslandBaseContentView)((Object)object3)).setState(new /* invalid duplicate definition of identical inner class */);
                        object2 = s.a;
                        arrayList.add(0, (DynamicIslandContentView)((Object)object3));
                    }
                    arrayList.remove(object);
                    this.getHiddenStateHandler().handleFillInState(arrayList);
                    this.getBigIslandStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, Boolean.TRUE);
                } else {
                    object = this.getSmallIslandStateHandler().getCurrent();
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("smallState: ");
                    ((StringBuilder)object2).append(object);
                    Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
                    if (object != null) {
                        StateHandler.addState$default(this.getHiddenStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                        object3 = this.getHiddenStateHandler();
                        object2 = Boolean.TRUE;
                        ((StateHandler)object3).handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, (Boolean)object2);
                        object = this.getBigIslandStateHandler().getCurrent();
                        if (object != null) {
                            StateHandler.addState$default(this.getHiddenStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                            this.getHiddenStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, (Boolean)object2);
                        }
                        if (((DynamicIslandBaseContentView)((Object)(object = (DynamicIslandContentView)((Object)u.V(arrayList))))).getState() instanceof DynamicIslandState.Empty) {
                            arrayList.remove(object);
                        }
                        this.getSmallIslandStateHandler().setCurrent(null);
                        this.getBigIslandStateHandler().setCurrent(null);
                    } else {
                        object = this.getBigIslandStateHandler().getCurrent();
                        if (object != null) {
                            this.getHiddenStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, Boolean.TRUE);
                            this.getBigIslandStateHandler().setCurrent(null);
                            object = arrayList.get(arrayList.size() - 1);
                            o.f((Object)object, (String)"get(...)");
                            object2 = (DynamicIslandContentView)((Object)object);
                            object = new StringBuilder();
                            ((StringBuilder)object).append("hidden: ");
                            ((StringBuilder)object).append(object2);
                            Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
                            arrayList.remove(object2);
                        }
                    }
                }
                object = this.getExpandedStateHandler().getCurrent();
                if (object != null) {
                    this.getExpandedStateHandler().setCurrent(null);
                    EventCoordinator.collapse$default(this, (DynamicIslandContentView)((Object)object), arrayList, false, 4, null);
                }
                this.getStateHandler().stop();
            } else {
                Log.e((String)"DynamicIslandEventDebug", (String)"hiddenList is null");
            }
        }
    }

    public final void handleSwipe(float f, float f2, boolean bl, ArrayList<DynamicIslandContentView> arrayList) {
        Object object;
        Object object2;
        Object object3;
        DynamicIslandContentView dynamicIslandContentView = this.getBigIslandStateHandler().getCurrent();
        DynamicIslandContentView dynamicIslandContentView2 = this.getSmallIslandStateHandler().getCurrent();
        Object object4 = this.getHiddenStateHandler().getCurrent();
        DynamicIslandContentView dynamicIslandContentView3 = this.getExpandedStateHandler().getCurrent();
        String string = null;
        object3 = dynamicIslandContentView != null && (object3 = dynamicIslandContentView.getCurrentIslandData()) != null ? object3.getKey() : null;
        object2 = dynamicIslandContentView2 != null && (object2 = dynamicIslandContentView2.getCurrentIslandData()) != null ? object2.getKey() : null;
        object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getKey() : null;
        object = dynamicIslandContentView3 != null && (object = dynamicIslandContentView3.getCurrentIslandData()) != null ? object.getKey() : null;
        if (arrayList != null) {
            string = u.T(arrayList, (CharSequence)", ", null, null, (int)0, null, (Function1)handleSwipe.1.INSTANCE, (int)30, null);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handle swipe: big:");
        stringBuilder.append((String)object3);
        stringBuilder.append(", small:");
        stringBuilder.append((String)object2);
        stringBuilder.append(", hidden:");
        stringBuilder.append((String)object4);
        stringBuilder.append(", expanded:");
        stringBuilder.append((String)object);
        stringBuilder.append(" \n hiddenList:");
        stringBuilder.append(string);
        Log.e((String)"DynamicIslandSwipeDebug", (String)stringBuilder.toString());
        if (bl && dynamicIslandContentView3 != null) {
            Log.d((String)"DynamicIslandSwipeDebug", (String)"swipe on expanded state. Only expanded view handles swipe");
            this.getExpandedStateHandler().onSwipe(f, f2, dynamicIslandContentView, dynamicIslandContentView2, dynamicIslandContentView3, arrayList);
            return;
        }
        if (!CommonUtils.INSTANCE.getIS_TABLET()) {
            this.getBigIslandStateHandler().onSwipe(f, f2, dynamicIslandContentView, dynamicIslandContentView2, dynamicIslandContentView3, arrayList);
        }
        this.getSmallIslandStateHandler().onSwipe(f, f2, dynamicIslandContentView, dynamicIslandContentView2, dynamicIslandContentView3, arrayList);
        this.getHiddenStateHandler().onSwipe(f, f2, dynamicIslandContentView, dynamicIslandContentView2, dynamicIslandContentView3, arrayList);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void resetSwipe(float var1_1, float var2_2, ArrayList<DynamicIslandContentView> var3_3) {
        var10_4 = this.getBigIslandStateHandler().getCurrent();
        var12_5 = this.getSmallIslandStateHandler().getCurrent();
        var11_6 = this.getExpandedStateHandler().getCurrent();
        var9_7 = null;
        if (var3_3 == null || (var5_8 /* !! */  = var3_3.isEmpty() == false ? var3_3 : null) == null) ** GOTO lbl13
        if (var1_1 < 0.0f) {
            var5_8 /* !! */  = u.M((List)var5_8 /* !! */ );
lbl8:
            // 2 sources

            while (true) {
                var7_9 /* !! */  = (DynamicIslandContentView)var5_8 /* !! */ ;
                break;
            }
        } else {
            var5_8 /* !! */  = u.W((List)var5_8 /* !! */ );
            ** continue;
lbl13:
            // 1 sources

            var7_9 /* !! */  = null;
        }
        var5_8 /* !! */  = var10_4 != null && (var5_8 /* !! */  = var10_4.getCurrentIslandData()) != null ? var5_8 /* !! */ .getKey() : null;
        var6_10 /* !! */  = var12_5 != null && (var6_10 /* !! */  = var12_5.getCurrentIslandData()) != null ? var6_10 /* !! */ .getKey() : null;
        var7_9 /* !! */  = var7_9 /* !! */  != null && (var7_9 /* !! */  = var7_9 /* !! */ .getCurrentIslandData()) != null ? var7_9 /* !! */ .getKey() : null;
        var8_11 /* !! */  = var9_7;
        if (var11_6 != null) {
            var13_12 = var11_6.getCurrentIslandData();
            var8_11 /* !! */  = var9_7;
            if (var13_12 != null) {
                var8_11 /* !! */  = var13_12.getKey();
            }
        }
        var9_7 = new StringBuilder();
        var9_7.append("reset swipe big:");
        var9_7.append((String)var5_8 /* !! */ );
        var9_7.append(" small:");
        var9_7.append((String)var6_10 /* !! */ );
        var9_7.append(", hidden:");
        var9_7.append((String)var7_9 /* !! */ );
        var9_7.append(" expanded:");
        var9_7.append((String)var8_11 /* !! */ );
        var9_7.append(" ");
        Log.d((String)"DynamicIslandSwipeDebug", (String)var9_7.toString());
        var5_8 /* !! */  = this.getBigIslandStateHandler().getCurrent();
        if (var5_8 /* !! */  != null && var10_4 != null) {
            var10_4.resetSwipe((DynamicIslandContentView)var5_8 /* !! */ );
        }
        if ((var5_8 /* !! */  = this.getSmallIslandStateHandler().getCurrent()) != null && var12_5 != null) {
            var12_5.resetSwipe((DynamicIslandContentView)var5_8 /* !! */ );
        }
        if ((var5_8 /* !! */  = this.getExpandedStateHandler().getCurrent()) != null && var11_6 != null) {
            var11_6.resetSwipe((DynamicIslandContentView)var5_8 /* !! */ );
        }
        if (var10_4 == null && var12_5 == null && var3_3 != null && var3_3.size() >= 1) {
            if (var1_1 < 0.0f) {
                var4_13 = 0;
lbl57:
                // 2 sources

                while (true) {
                    continue;
                    break;
                }
            }
            var4_13 = var3_3.size() - 1;
            ** continue;
            var3_3 = (DynamicIslandContentView)var3_3.get(var4_13);
            o.d((Object)var3_3);
            var3_3.resetSwipe((DynamicIslandContentView)var3_3);
        }
    }
}
