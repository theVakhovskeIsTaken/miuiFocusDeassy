/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event.handler;

import G0.i;
import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class ExpandedStateHandler
extends StateHandler {
    private DynamicIslandContentView current;
    private DynamicIslandContentView lastExpandedView;

    public ExpandedStateHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        super(dynamicIslandTouchInteractor);
    }

    private final void handleHorizontalSwipe(float f, float f2, DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandState dynamicIslandState = dynamicIslandContentView.getState();
        dynamicIslandState = dynamicIslandState != null ? dynamicIslandState.changeToState(new DynamicIslandState(){}) : null;
        dynamicIslandContentView.onSwipe(f, f2, dynamicIslandContentView, dynamicIslandContentView.getState(), dynamicIslandState);
    }

    private final void handleSwipeUp(float f, float f2, DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandState dynamicIslandState;
        dynamicIslandState = dynamicIslandContentView != null && (dynamicIslandState = dynamicIslandContentView.getState()) != null ? dynamicIslandState.changeToState(new /* invalid duplicate definition of identical inner class */) : null;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.onSwipe(f, f2, dynamicIslandContentView, dynamicIslandContentView.getState(), dynamicIslandState);
        }
    }

    @Override
    public DynamicIslandContentView getCurrent() {
        return this.current;
    }

    public final DynamicIslandContentView getLastExpandedView() {
        return this.lastExpandedView;
    }

    @Override
    public DynamicIslandContentView handleFillInState(ArrayList<DynamicIslandContentView> serializable) {
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("ExpandedStateHandler handleFillInState ");
        ((StringBuilder)serializable).append((Object)dynamicIslandContentView);
        Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)serializable).toString());
        if (dynamicIslandContentView != null) {
            this.addState(dynamicIslandContentView, new DynamicIslandState(){
                private boolean deleteByAddNew;

                public final boolean getDeleteByAddNew() {
                    return this.deleteByAddNew;
                }

                public final void setDeleteByAddNew(boolean bl) {
                    this.deleteByAddNew = bl;
                }
            });
            this.setCurrent(null);
        }
        return dynamicIslandContentView;
    }

    @Override
    public void handleReplacedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> arrayList, Boolean bl) {
        boolean bl2;
        Object object2;
        Object object3;
        Object var10_4 = null;
        Object var11_5 = null;
        object3 = object != null && (object3 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object3.getTickerData() : null;
        object2 = object != null && (object2 = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null ? Boolean.valueOf(((State)object2).getTempShow()) : null;
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        Object object4 = this.getCurrent();
        object4 = object4 != null && (object4 = object4.getCurrentIslandData()) != null ? object4.getTickerData() : null;
        Integer n = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        StateHandler stateHandler = this.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExpandedStateHandler handleReplacedState: originState: ");
        stringBuilder.append(object);
        stringBuilder.append("  ---- ");
        stringBuilder.append((String)object3);
        stringBuilder.append("--- tempShow:");
        stringBuilder.append(object2);
        stringBuilder.append(", current: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append("----");
        stringBuilder.append((String)object4);
        stringBuilder.append(", hiddenList: ");
        stringBuilder.append(n);
        stringBuilder.append("}, userSwipe: ");
        stringBuilder.append(bl);
        stringBuilder.append(" , next: ");
        stringBuilder.append(stateHandler);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object2 = this.getCurrent();
        boolean bl3 = bl2 = false;
        if (object2 != null) {
            object3 = ((DynamicIslandBaseContentView)((Object)object2)).getState();
            bl3 = bl2;
            if (object3 != null) {
                bl3 = bl2;
                if (((State)object3).getTempShow()) {
                    bl3 = true;
                }
            }
        }
        if (object != null && (object3 = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null && ((State)object3).getTempShow()) {
            this.setCurrent((DynamicIslandContentView)((Object)object));
            object3 = ((DynamicIslandBaseContentView)((Object)object)).getState();
            object = var11_5;
            if (object3 != null) {
                object = new DynamicIslandState(){};
                ((State)object).setTempShow(true);
                object = ((DynamicIslandState)object3).changeToState((DynamicIslandState)object);
            }
            this.addState(this.getCurrent(), (DynamicIslandState)object);
            if (object2 == null) {
                return;
            }
            if (this.getNext() != null && (object = this.getNext()) != null) {
                ((StateHandler)object).handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, bl);
            }
            return;
        }
        this.setCurrent((DynamicIslandContentView)((Object)object));
        object3 = var10_4;
        if (object != null) {
            object = ((DynamicIslandBaseContentView)((Object)object)).getState();
            object3 = var10_4;
            if (object != null) {
                object3 = ((DynamicIslandState)object).changeToState(new /* invalid duplicate definition of identical inner class */);
            }
        }
        this.addState(this.getCurrent(), (DynamicIslandState)object3);
        if (object2 == null) {
            return;
        }
        if (this.getNext() != null && !bl3 && (object = this.getNext()) != null) {
            ((StateHandler)object).handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, bl);
        }
    }

    @Override
    public void onSwipe(float f, float f2, DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2, DynamicIslandContentView dynamicIslandContentView3, ArrayList<DynamicIslandContentView> arrayList) {
        this.checkStates(this.gatherStates(dynamicIslandContentView, dynamicIslandContentView2, dynamicIslandContentView3, arrayList));
        if (dynamicIslandContentView3 == null) {
            return;
        }
        dynamicIslandContentView = (i)this.getTouchInteractor().getSwipeInfo().getValue();
        ((Number)dynamicIslandContentView.d()).floatValue();
        ((Number)dynamicIslandContentView.e()).floatValue();
        if (!this.swipeHorizontal(dynamicIslandContentView3) && !this.isSwipeUp(dynamicIslandContentView3)) {
            return;
        }
        if (this.swipeHorizontal(dynamicIslandContentView3)) {
            this.handleHorizontalSwipe(f, 0.0f, dynamicIslandContentView3);
        } else {
            this.handleSwipeUp(0.0f, f2, dynamicIslandContentView3);
        }
    }

    @Override
    public void setCurrent(DynamicIslandContentView dynamicIslandContentView) {
        if (!o.c((Object)((Object)this.current), (Object)((Object)dynamicIslandContentView))) {
            this.setLastView(this.getCurrent());
            this.current = dynamicIslandContentView;
        }
    }

    public final void setLastView(DynamicIslandContentView dynamicIslandContentView) {
        this.lastExpandedView = dynamicIslandContentView;
    }
}
