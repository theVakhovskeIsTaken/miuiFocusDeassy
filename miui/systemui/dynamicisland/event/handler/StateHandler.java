/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  H0.m
 *  android.content.Context
 *  android.util.Log
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.z
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event.handler;

import G0.i;
import H0.m;
import android.content.Context;
import android.util.Log;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.z;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.b;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

public class StateHandler {
    private static final List<Integer> COMBINATIONS;
    public static final Companion Companion;
    public static final int FLAG_BIG = 1;
    public static final int FLAG_BIG_EXPAND = 5;
    public static final int FLAG_BIG_HIDDEN = 9;
    public static final int FLAG_BIG_HIDDEN_EXPANDED = 13;
    public static final int FLAG_EXPANDED = 4;
    public static final int FLAG_HIDDEN = 8;
    public static final int FLAG_HIDDEN_EXPANDED = 12;
    public static final int FLAG_SMALL = 2;
    public static final int FLAG_SMALL_BIG = 3;
    public static final int FLAG_SMALL_BIG_EXPANDED = 7;
    public static final int FLAG_SMALL_BIG_HIDDEN = 11;
    public static final int NONE = 0;
    private static final ArrayList<DynamicIslandContentView> newList;
    private final Context ctx;
    private DynamicIslandContentView current;
    private ArrayList<DynamicIslandContentView> currentList;
    private HashMap<String, ArrayList<DynamicIslandContentView>> currentMap;
    private DynamicIslandContentView currentTempShow;
    private long exposedTime;
    private DynamicIslandContentView lastTempShow;
    private StateHandler next;
    private final DynamicIslandTouchInteractor touchInteractor;

    static {
        Companion = new Object(null){
            {
                this();
            }

            public final List<Integer> getCOMBINATIONS() {
                return COMBINATIONS;
            }
        };
        newList = new ArrayList();
        COMBINATIONS = m.j((Object[])new Integer[]{0, 1, 3, 4, 5, 7, 8, 9, 11, 12, 13});
    }

    public StateHandler(DynamicIslandTouchInteractor object) {
        o.g((Object)object, (String)"touchInteractor");
        this.touchInteractor = object;
        this.exposedTime = Long.MIN_VALUE;
        this.currentList = new ArrayList();
        this.currentMap = new HashMap();
        object = this.getCurrent();
        object = object != null ? object.getContext() : null;
        this.ctx = object;
    }

    public static /* synthetic */ boolean a(Function1 function1, Object object) {
        return StateHandler.addState$lambda$2(function1, object);
    }

    public static /* synthetic */ void addState$default(StateHandler stateHandler, DynamicIslandContentView dynamicIslandContentView, DynamicIslandState dynamicIslandState, int n, Object object) {
        if (object == null) {
            if ((n & 2) != 0) {
                dynamicIslandState = null;
            }
            stateHandler.addState(dynamicIslandContentView, dynamicIslandState);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addState");
    }

    private static final boolean addState$lambda$2(Function1 function1, Object object) {
        o.g((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    private final boolean checkHiddenList(ArrayList<DynamicIslandContentView> object) {
        if (object != null) {
            object = object.iterator();
            while (object.hasNext()) {
                if (!(((DynamicIslandContentView)((Object)object.next())).getState() instanceof DynamicIslandState.Hidden)) continue;
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean compareState$default(StateHandler stateHandler, DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 4) != 0) {
                bl = true;
            }
            return stateHandler.compareState(dynamicIslandContentView, dynamicIslandContentView2, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: compareState");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean compareStateForTablet(DynamicIslandContentView object, DynamicIslandContentView object2) {
        Object object3 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
        boolean bl = true;
        int n = object3 != null && (object3 = object3.getPriority()) != null ? (Integer)object3 : 1;
        object3 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
        int n2 = object3 != null && (object3 = object3.getPriority()) != null ? (Integer)object3 : 1;
        if (n == 2) {
            return false;
        }
        if (n2 == 2) return bl;
        if ((object2 = ((DynamicIslandBaseContentView)((Object)object2)).getState()) == null) return false;
        if ((object2 = ((State)object2).getPostTime()) == null) return false;
        long l = (Long)object2;
        if ((object = ((DynamicIslandBaseContentView)((Object)object)).getState()) == null) return false;
        if ((object = ((State)object).getPostTime()) == null) return false;
        if (l > (Long)object) return false;
        return bl;
    }

    public final void addState(DynamicIslandContentView dynamicIslandContentView, DynamicIslandState dynamicIslandState) {
        StringBuilder stringBuilder = null;
        Object object = dynamicIslandContentView != null ? dynamicIslandContentView.getLastState() : null;
        Object object2 = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
        CharSequence charSequence = stringBuilder;
        if (dynamicIslandContentView != null) {
            DynamicIslandData dynamicIslandData = dynamicIslandContentView.getCurrentIslandData();
            charSequence = stringBuilder;
            if (dynamicIslandData != null) {
                charSequence = dynamicIslandData.getKey();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("addState: lastState:");
        stringBuilder.append(object);
        stringBuilder.append(", State:");
        stringBuilder.append(object2);
        stringBuilder.append(", key\uff1a");
        stringBuilder.append((String)charSequence);
        stringBuilder.append(" ");
        stringBuilder.append(dynamicIslandState);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object = new z();
        object2 = newList;
        ((ArrayList)object2).removeIf(new b(new Function1(dynamicIslandContentView, (z)object){
            final z $initState;
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                this.$initState = z2;
                super(1);
            }

            public final Boolean invoke(DynamicIslandContentView dynamicIslandContentView) {
                Object object;
                Object var5_2 = null;
                object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null;
                Object object2 = this.$view;
                boolean bl = o.c((Object)object, (Object)(object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null));
                if (bl) {
                    object2 = this.$initState;
                    object = var5_2;
                    if (dynamicIslandContentView != null) {
                        object = dynamicIslandContentView.getLastState();
                    }
                    ((z)object2).a = object;
                }
                return bl;
            }
        }));
        object = ((z)object).a;
        if (object != null) {
            if (dynamicIslandContentView != null) {
                dynamicIslandContentView.setLastState((DynamicIslandState)object);
            }
        } else if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setLastState(dynamicIslandContentView.getState());
        }
        if (dynamicIslandContentView != null) {
            object = dynamicIslandState;
            if (dynamicIslandState == null) {
                object = dynamicIslandContentView.getState();
            }
            dynamicIslandContentView.setState((DynamicIslandState)object);
        }
        ((ArrayList)object2).add(dynamicIslandContentView);
    }

    public DynamicIslandState calculateCollapse(DynamicIslandContentView dynamicIslandContentView) {
        return null;
    }

    public final boolean checkStates(int n) {
        return COMBINATIONS.contains(n);
    }

    public final boolean compareState(DynamicIslandContentView object, DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = bl3;
        if (object != null) {
            if (dynamicIslandContentView == null) {
                bl5 = bl3;
            } else {
                Object object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                Object var14_9 = null;
                object2 = object2 != null ? object2.getProperties() : null;
                Object object3 = dynamicIslandContentView.getCurrentIslandData();
                object3 = object3 != null ? object3.getProperties() : null;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("BigIslandHandler compareState ");
                stringBuilder.append(object2);
                stringBuilder.append(" ");
                stringBuilder.append(object3);
                Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
                if (CommonUtils.INSTANCE.getIS_TABLET()) {
                    return this.compareStateForTablet(dynamicIslandContentView, (DynamicIslandContentView)((Object)object));
                }
                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                object2 = object2 != null ? object2.getProperties() : null;
                stringBuilder = dynamicIslandContentView.getCurrentIslandData();
                object3 = var14_9;
                if (stringBuilder != null) {
                    object3 = stringBuilder.getProperties();
                }
                if (o.c((Object)object2, (Object)object3)) {
                    object2 = dynamicIslandContentView.getCurrentIslandData();
                    int n = object2 != null && (object2 = object2.getPriority()) != null ? (Integer)object2 : 1;
                    object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                    int n2 = object2 != null && (object2 = object2.getPriority()) != null ? (Integer)object2 : 1;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("compareState currentPriority ");
                    ((StringBuilder)object2).append(n2);
                    ((StringBuilder)object2).append("  originPriority ");
                    ((StringBuilder)object2).append(n);
                    Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
                    if (n2 == n) {
                        object = ((DynamicIslandBaseContentView)((Object)object)).getState();
                        bl = bl4;
                        if (object != null) {
                            object = ((State)object).getTime();
                            bl = bl4;
                            if (object != null) {
                                long l = (Long)object;
                                object = dynamicIslandContentView.getState();
                                bl = bl4;
                                if (object != null) {
                                    object = ((State)object).getTime();
                                    bl = bl4;
                                    if (object != null) {
                                        bl = bl4;
                                        if (l <= (Long)object) {
                                            bl = true;
                                        }
                                    }
                                }
                            }
                        }
                        return bl;
                    }
                    return n2 > n;
                }
                if (bl) {
                    object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                    bl = bl2;
                    if (object != null) {
                        if ((object = object.getProperties()) == null) {
                            bl = bl2;
                        } else {
                            bl = bl2;
                            if ((Integer)object == 2) {
                                object = dynamicIslandContentView.getCurrentIslandData();
                                bl = bl2;
                                if (object != null) {
                                    if ((object = object.getProperties()) == null) {
                                        bl = bl2;
                                    } else {
                                        bl = bl2;
                                        if ((Integer)object == 1) {
                                            bl = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return bl;
                }
                object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                bl5 = bl3;
                if (object != null) {
                    if ((object = object.getProperties()) == null) {
                        bl5 = bl3;
                    } else {
                        bl5 = bl3;
                        if ((Integer)object == 1) {
                            object = dynamicIslandContentView.getCurrentIslandData();
                            bl5 = bl3;
                            if (object != null) {
                                if ((object = object.getProperties()) == null) {
                                    bl5 = bl3;
                                } else {
                                    bl5 = bl3;
                                    if ((Integer)object == 2) {
                                        bl5 = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl5;
    }

    public final int gatherStates(DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2, DynamicIslandContentView dynamicIslandContentView3, ArrayList<DynamicIslandContentView> arrayList) {
        int n = dynamicIslandContentView != null ? 1 : 0;
        int n2 = n;
        if (dynamicIslandContentView2 != null) {
            n2 = n + 2;
        }
        n = n2;
        if (dynamicIslandContentView3 != null) {
            n = n2 + 4;
        }
        if (arrayList != null && arrayList.size() == 0) {
            n2 = n;
        } else {
            n2 = n;
            if (this.checkHiddenList(arrayList)) {
                n2 = n + 8;
            }
        }
        return n2;
    }

    public final Context getCtx() {
        return this.ctx;
    }

    public DynamicIslandContentView getCurrent() {
        return this.current;
    }

    public final String getCurrentKey() {
        Object object;
        block3: {
            block2: {
                object = this.getCurrent();
                if (object == null) break block2;
                String string = object.getIslandKey();
                object = string;
                if (string != null) break block3;
            }
            object = "null";
        }
        return object;
    }

    public final ArrayList<DynamicIslandContentView> getCurrentList() {
        return this.currentList;
    }

    public final HashMap<String, ArrayList<DynamicIslandContentView>> getCurrentMap() {
        return this.currentMap;
    }

    public final DynamicIslandContentView getCurrentTempShow() {
        return this.currentTempShow;
    }

    public final long getExposedTime() {
        return this.exposedTime;
    }

    public final DynamicIslandContentView getLastTempShow() {
        return this.lastTempShow;
    }

    public final StateHandler getNext() {
        return this.next;
    }

    public final DynamicIslandTouchInteractor getTouchInteractor() {
        return this.touchInteractor;
    }

    public void handleEnterBurnIn() {
    }

    public void handleExitBurnIn() {
    }

    public DynamicIslandContentView handleFillInState(ArrayList<DynamicIslandContentView> arrayList) {
        return null;
    }

    public DynamicIslandState handleFillInStateInTinyScreen(ArrayList<DynamicIslandState> arrayList) {
        return null;
    }

    public void handlePauseExpose() {
    }

    public void handleReplacedState(DynamicIslandContentView dynamicIslandContentView, ArrayList<DynamicIslandContentView> arrayList, Boolean bl) {
    }

    public void handleReplacedStateInTinyScreen(DynamicIslandContentView dynamicIslandContentView, ArrayList<DynamicIslandContentView> arrayList, Boolean bl) {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isSwipeTowardsSmallIsland(float f, Context context) {
        boolean bl = false;
        if (context != null && CommonUtils.isLayoutRtl((Context)context)) {
            if (!(f <= 0.0f)) return bl;
            return true;
        }
        if (!(f >= 0.0f)) return bl;
        return true;
    }

    public final boolean isSwipeUp(DynamicIslandContentView object) {
        boolean bl;
        block3: {
            block2: {
                o.g((Object)object, (String)"view");
                float f = ((Number)((i)this.touchInteractor.getSwipeInfo().getValue()).e()).floatValue();
                object = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
                if (object == null) break block2;
                boolean bl2 = ((DynamicIslandEventCoordinator)object).getVerticalSwipeDispatched();
                bl = true;
                if (bl2 && f < 0.0f) break block3;
            }
            bl = false;
        }
        return bl;
    }

    public final boolean isTempHidden(DynamicIslandContentView dynamicIslandContentView) {
        boolean bl;
        boolean bl2 = bl = false;
        if (dynamicIslandContentView != null) {
            DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator();
            bl2 = bl;
            if (dynamicIslandEventCoordinator != null) {
                bl2 = bl;
                if (dynamicIslandEventCoordinator.isTempHidden(dynamicIslandContentView)) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    public void onSwipe(float f, float f2, DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2, DynamicIslandContentView dynamicIslandContentView3, ArrayList<DynamicIslandContentView> arrayList) {
    }

    public void setCurrent(DynamicIslandContentView dynamicIslandContentView) {
        this.current = dynamicIslandContentView;
    }

    public final void setCurrentList(ArrayList<DynamicIslandContentView> arrayList) {
        this.currentList = arrayList;
    }

    public final void setCurrentMap(HashMap<String, ArrayList<DynamicIslandContentView>> hashMap) {
        o.g(hashMap, (String)"<set-?>");
        this.currentMap = hashMap;
    }

    public final void setCurrentTempShow(DynamicIslandContentView dynamicIslandContentView) {
        this.lastTempShow = this.currentTempShow;
        this.currentTempShow = dynamicIslandContentView;
    }

    public final void setExposedTime(long l) {
        this.exposedTime = l;
    }

    public final void setLastTempShow(DynamicIslandContentView dynamicIslandContentView) {
        this.lastTempShow = dynamicIslandContentView;
    }

    public final void setNext(StateHandler stateHandler) {
        this.next = stateHandler;
    }

    public final void stop() {
        Object object;
        Object object2 = newList;
        int n = ((ArrayList)object2).size();
        Object object3 = new StringBuilder();
        object3.append("StateHandler stop->updateState, listSize=");
        object3.append(n);
        object3.append(", new:");
        object3.append(object2);
        Log.e((String)"DynamicIslandEventDebug", (String)object3.toString());
        if (((ArrayList)object2).size() > 0) {
            boolean bl = false;
            object3 = ((ArrayList)object2).get(0);
            object3 = object3 != null ? ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator() : null;
            if (object3 != null) {
                boolean bl2;
                block6: {
                    if (object2 != null && object2.isEmpty()) {
                        bl2 = bl;
                    } else {
                        DynamicIslandContentView dynamicIslandContentView;
                        object = object2.iterator();
                        do {
                            bl2 = bl;
                            if (!object.hasNext()) break block6;
                        } while (!((object2 = (dynamicIslandContentView = (DynamicIslandContentView)((Object)object.next())) != null ? dynamicIslandContentView.getState() : null) instanceof DynamicIslandState.AppExpanded) && !((object2 = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null) instanceof DynamicIslandState.SubAppExpanded));
                        bl2 = true;
                    }
                }
                ((DynamicIslandEventCoordinator)object3).setHasAppExpandedState(bl2);
            }
        }
        object2 = new ArrayList<DynamicIslandContentView>(newList).iterator();
        o.f((Object)object2, (String)"iterator(...)");
        while (object2.hasNext()) {
            object3 = (DynamicIslandContentView)((Object)object2.next());
            if (object3 == null || (object = ((DynamicIslandBaseContentView)((Object)object3)).getViewModel()) == null) continue;
            ((DynamicIslandViewModel)object).updateState((DynamicIslandContentView)((Object)object3));
        }
        newList.clear();
    }

    public final boolean swipeHorizontal(DynamicIslandContentView object) {
        boolean bl;
        boolean bl2 = bl = false;
        if (object != null) {
            object = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
            bl2 = bl;
            if (object != null) {
                bl2 = bl;
                if (((DynamicIslandEventCoordinator)object).getHorizontalSwipeDispatched()) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }
}
