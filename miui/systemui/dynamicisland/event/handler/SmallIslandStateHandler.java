/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  android.content.Context
 *  android.util.Log
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event.handler;

import G0.i;
import android.content.Context;
import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class SmallIslandStateHandler
extends StateHandler {
    private final Context context;
    private DynamicIslandContentView current;

    public SmallIslandStateHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, Context context) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        o.g((Object)context, (String)"context");
        super(dynamicIslandTouchInteractor);
        this.context = context;
    }

    @Override
    public DynamicIslandState calculateCollapse(DynamicIslandContentView dynamicIslandContentView) {
        if (this.compareState(this.getCurrent(), dynamicIslandContentView, false)) {
            return new DynamicIslandState.SmallIsland();
        }
        if (this.getCurrent() == null) {
            return new DynamicIslandState.SmallIsland();
        }
        if (dynamicIslandContentView != null && this.getNext() != null) {
            return new DynamicIslandState.Hidden();
        }
        return null;
    }

    @Override
    public DynamicIslandContentView getCurrent() {
        return this.current;
    }

    @Override
    public void handleEnterBurnIn() {
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setHasEverBurnedIn(true);
        }
        dynamicIslandContentView = this.getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setBurnInState(AntiBurnInManager.BurnInStates.BurnIn);
        }
        dynamicIslandContentView = this.getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.animSmallIslandBurnIn(this.getCurrent());
        }
    }

    @Override
    public void handleExitBurnIn() {
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.animSmallIslandExitBurn();
        }
    }

    @Override
    public DynamicIslandContentView handleFillInState(ArrayList<DynamicIslandContentView> object) {
        Object object2 = this.getCurrent();
        Object object3 = new StringBuilder();
        object3.append("SmallIslandStateHandler handleFillInState: ");
        object3.append(object2);
        Log.d((String)"DynamicIslandEventDebug", (String)object3.toString());
        object3 = this.getCurrent();
        Object var5_4 = null;
        if (object3 != null) {
            this.setCurrent(null);
            return object3;
        }
        object3 = this.getNext();
        object3 = object3 != null ? ((StateHandler)object3).handleFillInState((ArrayList<DynamicIslandContentView>)object) : null;
        object2 = object3 != null ? ((DynamicIslandBaseContentView)((Object)object3)).getState() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SmallIslandStateHandler handleFillInState nextState: ");
        stringBuilder.append(object2);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            return object3;
        }
        if (object3 != null && !(((DynamicIslandBaseContentView)((Object)object3)).getState() instanceof DynamicIslandState.Empty)) {
            if (object != null) {
                object2 = ((ArrayList)object).remove(0);
            }
            if ((object2 = this.getNext()) != null) {
                ((StateHandler)object2).handleFillInState((ArrayList<DynamicIslandContentView>)object);
            }
            boolean bl = this.isTempHidden((DynamicIslandContentView)((Object)object3));
            object = new StringBuilder();
            ((StringBuilder)object).append("SmallIslandStateHandler isTempHidden: ");
            ((StringBuilder)object).append(bl);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
            this.setCurrent((DynamicIslandContentView)((Object)object3));
            object2 = ((DynamicIslandBaseContentView)((Object)object3)).getState();
            object = var5_4;
            if (object2 != null) {
                object = ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){});
            }
            this.addState(this.getCurrent(), (DynamicIslandState)object);
        } else {
            this.setCurrent(null);
        }
        return object3;
    }

    @Override
    public void handleReplacedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> object2, Boolean bl) {
        Object object3;
        Object object4;
        Object var9_4 = null;
        Object var10_5 = null;
        object4 = object != null && (object4 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object4.getTickerData() : null;
        object3 = object != null && (object3 = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null ? Boolean.valueOf(((State)object3).getTempShow()) : null;
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        Object object5 = this.getCurrent();
        object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getTickerData() : null;
        Object object6 = this.getCurrent();
        object6 = object6 != null && (object6 = ((DynamicIslandBaseContentView)((Object)object6)).getState()) != null ? Boolean.valueOf(((State)object6).getTempShow()) : null;
        Integer n = object2 != null ? Integer.valueOf(((ArrayList)object2).size()) : null;
        StateHandler stateHandler = this.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SmallIslandStateHandler handleReplacedState: originState: ");
        stringBuilder.append(object);
        stringBuilder.append("  ---- ");
        stringBuilder.append((String)object4);
        stringBuilder.append("--- tempShow:");
        stringBuilder.append(object3);
        stringBuilder.append(" current: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append("----");
        stringBuilder.append((String)object5);
        stringBuilder.append(" ");
        stringBuilder.append(object6);
        stringBuilder.append(", hiddenList: ");
        stringBuilder.append(n);
        stringBuilder.append("}, userSwipe: ");
        stringBuilder.append(bl);
        stringBuilder.append(" , next: ");
        stringBuilder.append(stateHandler);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object3 = this.getCurrent();
        if (object != null && (object4 = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null && ((State)object4).getTempShow()) {
            StateHandler.addState$default(this, (DynamicIslandContentView)((Object)object3), null, 2, null);
            return;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            if (object != null && this.getNext() != null && (object4 = this.getNext()) != null) {
                ((StateHandler)object4).handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object2, bl);
            }
            return;
        }
        if (!this.compareState(this.getCurrent(), (DynamicIslandContentView)((Object)object), false) && !o.c((Object)bl, (Object)Boolean.TRUE)) {
            if (this.getCurrent() == null) {
                this.setCurrent((DynamicIslandContentView)((Object)object));
                object2 = var10_5;
                if (object != null) {
                    object = ((DynamicIslandBaseContentView)((Object)object)).getState();
                    object2 = var10_5;
                    if (object != null) {
                        object2 = ((DynamicIslandState)object).changeToState(new /* invalid duplicate definition of identical inner class */);
                    }
                }
                this.addState(this.getCurrent(), (DynamicIslandState)object2);
            } else {
                StateHandler.addState$default(this, (DynamicIslandContentView)((Object)object3), null, 2, null);
                if (object != null && this.getNext() != null && (object4 = this.getNext()) != null) {
                    ((StateHandler)object4).handleReplacedState((DynamicIslandContentView)((Object)object), (ArrayList<DynamicIslandContentView>)object2, bl);
                }
            }
            return;
        }
        this.setCurrent((DynamicIslandContentView)((Object)object));
        object4 = var9_4;
        if (object != null) {
            object = ((DynamicIslandBaseContentView)((Object)object)).getState();
            object4 = var9_4;
            if (object != null) {
                object4 = ((DynamicIslandState)object).changeToState(new /* invalid duplicate definition of identical inner class */);
            }
        }
        this.addState(this.getCurrent(), (DynamicIslandState)object4);
        if (object3 != null && this.getNext() != null && (object = this.getNext()) != null) {
            ((StateHandler)object).handleReplacedState((DynamicIslandContentView)((Object)object3), (ArrayList<DynamicIslandContentView>)object2, bl);
        }
    }

    @Override
    public void handleReplacedStateInTinyScreen(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> object2, Boolean object3) {
        block2: {
            DynamicIslandState dynamicIslandState;
            block4: {
                block3: {
                    Log.e((String)"DynamicIslandEventDebug", (String)"SmallIslandHandler isTiny not supposed to be here");
                    object3 = this.getCurrent();
                    if (object3 == null) break block2;
                    dynamicIslandState = new DynamicIslandState(){
                        private boolean deleteByAddNew;

                        public final boolean getDeleteByAddNew() {
                            return this.deleteByAddNew;
                        }

                        public final void setDeleteByAddNew(boolean bl) {
                            this.deleteByAddNew = bl;
                        }
                    };
                    object = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData();
                    if (object == null) break block3;
                    object2 = object.getKey();
                    object = object2;
                    if (object2 != null) break block4;
                }
                object = "";
            }
            dynamicIslandState.setDeleteKey((String)object);
            this.addState((DynamicIslandContentView)((Object)object3), dynamicIslandState);
        }
    }

    @Override
    public void onSwipe(float f, float f2, DynamicIslandContentView object, DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> arrayList) {
        this.checkStates(this.gatherStates((DynamicIslandContentView)((Object)object), dynamicIslandContentView, (DynamicIslandContentView)((Object)object2), arrayList));
        object = null;
        object2 = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
        if (dynamicIslandContentView == null) {
            return;
        }
        ((Number)((i)this.getTouchInteractor().getSwipeInfo().getValue()).d()).floatValue();
        if (!this.swipeHorizontal(dynamicIslandContentView)) {
            return;
        }
        if (!this.isSwipeTowardsSmallIsland(f, dynamicIslandContentView.getContext())) {
            if (object2 != null) {
                object = ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){});
            }
        } else if (object2 != null) {
            object = ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){});
        }
        dynamicIslandContentView.onSwipe(f, f2, dynamicIslandContentView, (DynamicIslandState)object2, (DynamicIslandState)object);
    }

    @Override
    public void setCurrent(DynamicIslandContentView dynamicIslandContentView) {
        this.current = dynamicIslandContentView;
    }
}
