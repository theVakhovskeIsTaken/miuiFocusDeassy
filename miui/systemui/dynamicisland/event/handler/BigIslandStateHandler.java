/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.s
 *  H0.u
 *  android.content.Context
 *  android.util.Log
 *  e1.n
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event.handler;

import G0.i;
import G0.s;
import H0.u;
import android.content.Context;
import android.util.Log;
import e1.n;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.AppStateHandler;
import miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class BigIslandStateHandler
extends StateHandler {
    private final Context context;
    private DynamicIslandContentView current;

    public BigIslandStateHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, Context context) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        o.g((Object)context, (String)"context");
        super(dynamicIslandTouchInteractor);
        this.context = context;
    }

    private final boolean doMultiAppExpanded(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> arrayList, Boolean bl) {
        Object object2;
        object2 = object != null && (object2 = object.getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getAppStateHandler()) != null ? Integer.valueOf(((AppStateHandler)object2).getTopLevelCount()) : null;
        if (object2 != null && (Integer)object2 == 0) {
            this.setCurrent((DynamicIslandContentView)((Object)object));
            object = object.getState();
            object = object != null ? ((DynamicIslandState)object).changeToState(new DynamicIslandState(){}) : null;
            this.addState(this.getCurrent(), (DynamicIslandState)object);
            if (!this.hasEmpty(arrayList)) {
                if (arrayList != null) {
                    object = this.getCurrent();
                    object = object != null ? object.getContext() : null;
                    o.d((Object)object);
                    object = new DynamicIslandContentView((Context)object, null, 2, null);
                    object.setState(new DynamicIslandState(){});
                    bl = s.a;
                    arrayList.add(0, (DynamicIslandContentView)((Object)object));
                }
                if ((object = this.getNext()) != null && (object = ((StateHandler)object).getNext()) != null) {
                    ((StateHandler)object).handleFillInState(arrayList);
                }
            }
            return false;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.getCurrent() == null && !this.hasEmpty(arrayList) && arrayList != null) {
            object2 = object != null ? object.getContext() : null;
            o.d((Object)object2);
            object2 = new DynamicIslandContentView((Context)object2, null, 2, null);
            ((DynamicIslandBaseContentView)((Object)object2)).setState(new /* invalid duplicate definition of identical inner class */);
            s s2 = s.a;
            arrayList.add(0, (DynamicIslandContentView)((Object)object2));
        }
        if (this.getNext() != null && (object2 = this.getNext()) != null) {
            ((StateHandler)object2).handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, bl);
        }
        return true;
    }

    private final boolean doMultiMiniWindow(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> arrayList, Boolean bl) {
        Object object2;
        Object object3;
        object3 = object != null && (object3 = object.getCurrentIslandData()) != null && (object3 = object3.getExtras()) != null ? object3.getString("miui.pkg.name") : null;
        if ((object3 = object3 != null && (object2 = object.getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getMiniWindowStateHandler()) != null ? Integer.valueOf(((MiniWindowStateHandler)object2).getTopLevelCount((String)object3)) : null) != null && (Integer)object3 == 0) {
            this.setCurrent((DynamicIslandContentView)((Object)object));
            object = object.getState();
            object = object != null ? ((DynamicIslandState)object).changeToState(new /* invalid duplicate definition of identical inner class */) : null;
            this.addState(this.getCurrent(), (DynamicIslandState)object);
            if (!this.hasEmpty(arrayList)) {
                if (arrayList != null) {
                    object = this.getCurrent();
                    object = object != null ? object.getContext() : null;
                    o.d((Object)object);
                    object = new DynamicIslandContentView((Context)object, null, 2, null);
                    object.setState(new /* invalid duplicate definition of identical inner class */);
                    bl = s.a;
                    arrayList.add(0, (DynamicIslandContentView)((Object)object));
                }
                if ((object = this.getNext()) != null && (object = ((StateHandler)object).getNext()) != null) {
                    ((StateHandler)object).handleFillInState(arrayList);
                }
            }
            return false;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.getCurrent() == null && !this.hasEmpty(arrayList) && arrayList != null) {
            object3 = object != null ? object.getContext() : null;
            o.d((Object)object3);
            object3 = new DynamicIslandContentView((Context)object3, null, 2, null);
            ((DynamicIslandBaseContentView)((Object)object3)).setState(new /* invalid duplicate definition of identical inner class */);
            object2 = s.a;
            arrayList.add(0, (DynamicIslandContentView)((Object)object3));
        }
        if (this.getNext() != null && (object3 = this.getNext()) != null) {
            ((StateHandler)object3).handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, bl);
        }
        return true;
    }

    @Override
    public DynamicIslandState calculateCollapse(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandState dynamicIslandState;
        if (CommonUtils.INSTANCE.getIS_TABLET() && dynamicIslandContentView != null) {
            return new /* invalid duplicate definition of identical inner class */;
        }
        if (StateHandler.compareState$default(this, this.getCurrent(), dynamicIslandContentView, false, 4, null)) {
            return new /* invalid duplicate definition of identical inner class */;
        }
        if (this.getCurrent() == null) {
            return new /* invalid duplicate definition of identical inner class */;
        }
        DynamicIslandState dynamicIslandState2 = dynamicIslandState = null;
        if (dynamicIslandContentView != null) {
            dynamicIslandState2 = dynamicIslandState;
            if (this.getNext() != null) {
                StateHandler stateHandler = this.getNext();
                dynamicIslandState2 = dynamicIslandState;
                if (stateHandler != null) {
                    dynamicIslandState2 = stateHandler.calculateCollapse(dynamicIslandContentView);
                }
            }
        }
        return dynamicIslandState2;
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
            dynamicIslandContentView.animBigIslandBurnIn(this.getCurrent());
        }
    }

    @Override
    public void handleExitBurnIn() {
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.animBigIslandExitBurn();
        }
    }

    @Override
    public DynamicIslandContentView handleFillInState(ArrayList<DynamicIslandContentView> arrayList) {
        Object object = this.getNext();
        DynamicIslandState dynamicIslandState = null;
        Object var5_4 = null;
        object = object != null ? object.handleFillInState(arrayList) : null;
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        Object object2 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BigIslandHandler handleFillInState ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append("  ");
        stringBuilder.append(object2);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        if (object != null && !(((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.Empty)) {
            object2 = CommonUtils.INSTANCE;
            if (object2.getIS_TABLET() && ((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.Deleted) {
                this.setCurrent(null);
                return null;
            }
            this.setCurrent((DynamicIslandContentView)((Object)object));
            dynamicIslandState = ((DynamicIslandBaseContentView)((Object)object)).getState();
            object = var5_4;
            if (dynamicIslandState != null) {
                object = dynamicIslandState.changeToState(new /* invalid duplicate definition of identical inner class */);
            }
            this.addState(this.getCurrent(), (DynamicIslandState)object);
            if (object2.getIS_TABLET()) {
                if (arrayList != null) {
                    object = arrayList.remove(0);
                }
                if ((object = this.getNext()) != null && (object = object.getNext()) != null) {
                    object.handleFillInState(arrayList);
                }
            } else {
                object = this.getNext();
                if (object != null) {
                    object.handleFillInState(arrayList);
                }
            }
        } else {
            this.setCurrent(null);
            object = arrayList != null ? (DynamicIslandContentView)((Object)u.M(arrayList)) : null;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("BigIslandHandler handleFillInState hidden: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
            object2 = dynamicIslandState;
            if (object != null) {
                object2 = ((DynamicIslandBaseContentView)((Object)object)).getState();
            }
            if (object2 instanceof DynamicIslandState.Empty) {
                arrayList.remove(0);
                object = this.getNext();
                if (object != null && (object = object.getNext()) != null) {
                    object.handleFillInState(arrayList);
                }
            }
        }
        return this.getCurrent();
    }

    @Override
    public void handleReplacedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> arrayList, Boolean bl) {
        Object object2;
        Object object3;
        Object var9_4 = null;
        object3 = object != null && (object3 = object.getCurrentIslandData()) != null ? object3.getTickerData() : null;
        object2 = object != null && (object2 = object.getState()) != null ? Boolean.valueOf(((State)object2).getTempShow()) : null;
        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
        Object object4 = this.getCurrent();
        object4 = object4 != null && (object4 = ((DynamicIslandBaseContentView)((Object)object4)).getCurrentIslandData()) != null ? object4.getTickerData() : null;
        Object object5 = this.getCurrent();
        object5 = object5 != null && (object5 = ((DynamicIslandBaseContentView)((Object)object5)).getState()) != null ? Boolean.valueOf(((State)object5).getTempShow()) : null;
        DynamicIslandContentView dynamicIslandContentView2 = this.getCurrentTempShow();
        Integer n2 = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        StateHandler stateHandler = this.getNext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BigIslandHandler BigIslandStateHandler handleReplacedState: originState: ");
        stringBuilder.append(object);
        stringBuilder.append("  ---- ");
        stringBuilder.append((String)object3);
        stringBuilder.append("--- tempShow:");
        stringBuilder.append(object2);
        stringBuilder.append(" current: ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append("----");
        stringBuilder.append((String)object4);
        stringBuilder.append(" ");
        stringBuilder.append(object5);
        stringBuilder.append(", currentTempShow: ");
        stringBuilder.append((Object)dynamicIslandContentView2);
        stringBuilder.append("hiddenList: ");
        stringBuilder.append(n2);
        stringBuilder.append("}, userSwipe: ");
        stringBuilder.append(bl);
        stringBuilder.append(" , next: ");
        stringBuilder.append(stateHandler);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object3 = object != null && (object3 = object.getState()) != null ? Boolean.valueOf(((State)object3).getTempShow()) : null;
        object4 = this.getCurrentTempShow();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("BigIslandHandler handleState: originState?.tempShow : ");
        ((StringBuilder)object2).append(object3);
        ((StringBuilder)object2).append(" currentTempShow : ");
        ((StringBuilder)object2).append(object4);
        Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object2).toString());
        object2 = this.getCurrent();
        object3 = object != null && (object3 = object.getState()) != null ? Boolean.valueOf(((State)object3).getTempShow()) : null;
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("BigIslandHandler handleState: originState?.tempShow : ");
        ((StringBuilder)object4).append(object3);
        Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object4).toString());
        if (!StateHandler.compareState$default(this, this.getCurrent(), object, false, 4, null) && !o.c((Object)bl, (Object)Boolean.TRUE)) {
            if (this.getCurrent() == null) {
                object3 = object != null ? object.getState() : null;
                if (object3 instanceof DynamicIslandState.AppExpanded) {
                    this.doMultiAppExpanded((DynamicIslandContentView)((Object)object), arrayList, bl);
                } else {
                    object3 = object != null ? object.getState() : null;
                    if (object3 instanceof DynamicIslandState.MiniWindowExpanded) {
                        this.doMultiMiniWindow((DynamicIslandContentView)((Object)object), arrayList, bl);
                    } else {
                        this.setCurrent((DynamicIslandContentView)((Object)object));
                        object = object != null && (object = object.getState()) != null ? ((DynamicIslandState)object).changeToState(new /* invalid duplicate definition of identical inner class */) : null;
                        this.addState(this.getCurrent(), (DynamicIslandState)object);
                        if (!this.hasEmpty(arrayList)) {
                            object = this.getCurrent();
                            if (object != null && (object = object.getContext()) != null) {
                                object = new DynamicIslandContentView((Context)object, null, 2, null);
                                object.setState(new /* invalid duplicate definition of identical inner class */);
                                if (arrayList != null) {
                                    arrayList.add(0, (DynamicIslandContentView)((Object)object));
                                }
                            }
                            if ((object = this.getNext()) != null && (object = ((StateHandler)object).getNext()) != null) {
                                ((StateHandler)object).handleFillInState(arrayList);
                            }
                        }
                    }
                }
            } else {
                object3 = object != null ? object.getState() : null;
                if (!(object3 instanceof DynamicIslandState.SubAppExpanded) && !((object3 = object != null ? object.getState() : null) instanceof DynamicIslandState.SubMiniWindowExpanded) || !n.m((String)(object2 = object.getPkgName()), (String)(object3 = (object3 = this.getCurrent()) != null ? ((DynamicIslandBaseContentView)((Object)object3)).getPkgName() : null), (boolean)false, (int)2, null)) {
                    StateHandler.addState$default(this, this.getCurrent(), null, 2, null);
                }
                if (object != null && this.getNext() != null && (object3 = this.getNext()) != null) {
                    ((StateHandler)object3).handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, bl);
                }
            }
            return;
        }
        object3 = object != null ? object.getState() : null;
        if (object3 instanceof DynamicIslandState.AppExpanded) {
            if (this.doMultiAppExpanded((DynamicIslandContentView)((Object)object), arrayList, bl)) {
                return;
            }
        } else {
            object3 = object != null ? object.getState() : null;
            if (object3 instanceof DynamicIslandState.MiniWindowExpanded) {
                if (this.doMultiMiniWindow((DynamicIslandContentView)((Object)object), arrayList, bl)) {
                    return;
                }
            } else {
                this.setCurrent((DynamicIslandContentView)((Object)object));
                object3 = var9_4;
                if (object != null) {
                    object = object.getState();
                    object3 = var9_4;
                    if (object != null) {
                        object3 = ((DynamicIslandState)object).changeToState(new /* invalid duplicate definition of identical inner class */);
                    }
                }
                this.addState(this.getCurrent(), (DynamicIslandState)object3);
            }
        }
        if (object2 != null && this.getNext() != null && (object = this.getNext()) != null) {
            ((StateHandler)object).handleReplacedState((DynamicIslandContentView)((Object)object2), arrayList, bl);
        }
    }

    @Override
    public void handleReplacedStateInTinyScreen(DynamicIslandContentView dynamicIslandContentView, ArrayList<DynamicIslandContentView> object, Boolean object2) {
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object var9_4;
        block8: {
            Object object7;
            block10: {
                block9: {
                    var9_4 = null;
                    object6 = dynamicIslandContentView != null && (object6 = dynamicIslandContentView.getCurrentIslandData()) != null ? object6.getTickerData() : null;
                    object5 = dynamicIslandContentView != null && (object5 = dynamicIslandContentView.getState()) != null ? Boolean.valueOf(((State)object5).getTempShow()) : null;
                    DynamicIslandContentView dynamicIslandContentView2 = this.getCurrent();
                    object4 = this.getCurrent();
                    object4 = object4 != null && (object4 = ((DynamicIslandBaseContentView)((Object)object4)).getCurrentIslandData()) != null ? object4.getTickerData() : null;
                    object3 = this.getCurrent();
                    object3 = object3 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getState()) != null ? Boolean.valueOf(((State)object3).getTempShow()) : null;
                    DynamicIslandContentView dynamicIslandContentView3 = this.getCurrentTempShow();
                    object7 = object != null ? Integer.valueOf(((ArrayList)object).size()) : null;
                    StateHandler stateHandler = this.getNext();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("BigIslandStateHandler handleReplacedStateInTinyScreen: originState: ");
                    stringBuilder.append((Object)dynamicIslandContentView);
                    stringBuilder.append("  ---- ");
                    stringBuilder.append((String)object6);
                    stringBuilder.append("--- tempShow:");
                    stringBuilder.append(object5);
                    stringBuilder.append(" current: ");
                    stringBuilder.append((Object)dynamicIslandContentView2);
                    stringBuilder.append("----");
                    stringBuilder.append((String)object4);
                    stringBuilder.append(" ");
                    stringBuilder.append(object3);
                    stringBuilder.append(", currentTempShow: ");
                    stringBuilder.append((Object)dynamicIslandContentView3);
                    stringBuilder.append("hiddenList: ");
                    stringBuilder.append(object7);
                    stringBuilder.append("}, userSwipe: ");
                    stringBuilder.append(object2);
                    stringBuilder.append(" , next: ");
                    stringBuilder.append(stateHandler);
                    Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
                    object7 = this.getCurrent();
                    object5 = "";
                    if (object7 == null) break block8;
                    object3 = new DynamicIslandState(){
                        private boolean deleteByAddNew;

                        public final boolean getDeleteByAddNew() {
                            return this.deleteByAddNew;
                        }

                        public final void setDeleteByAddNew(boolean bl) {
                            this.deleteByAddNew = bl;
                        }
                    };
                    object6 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData();
                    if (object6 == null) break block9;
                    object6 = object4 = object6.getKey();
                    if (object4 != null) break block10;
                }
                object6 = "";
            }
            ((State)object3).setDeleteKey((String)object6);
            this.addState((DynamicIslandContentView)((Object)object7), (DynamicIslandState)object3);
        }
        if (dynamicIslandContentView != null && (object6 = dynamicIslandContentView.getState()) != null && ((State)object6).getTempShow()) {
            object6 = this.getCurrentTempShow();
            this.setCurrentTempShow(dynamicIslandContentView);
            object2 = dynamicIslandContentView.getState();
            object = var9_4;
            if (object2 != null) {
                object = new /* invalid duplicate definition of identical inner class */;
                ((State)object).setTempShow(true);
                object = ((DynamicIslandState)object2).changeToState((DynamicIslandState)object);
            }
            if (object6 != null) {
                object4 = new /* invalid duplicate definition of identical inner class */;
                object3 = ((DynamicIslandBaseContentView)((Object)object6)).getCurrentIslandData();
                object2 = object5;
                if (object3 != null && (object2 = object3.getKey()) == null) {
                    object2 = object5;
                }
                ((State)object4).setDeleteKey((String)object2);
                this.addState((DynamicIslandContentView)((Object)object6), (DynamicIslandState)object4);
            }
            this.addState(dynamicIslandContentView, (DynamicIslandState)object);
            return;
        }
        object6 = this.getNext();
        if (object6 != null) {
            ((StateHandler)object6).handleReplacedStateInTinyScreen(dynamicIslandContentView, (ArrayList<DynamicIslandContentView>)object, (Boolean)object2);
        }
    }

    @Override
    public void onSwipe(float f, float f2, DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        int n2 = this.gatherStates(dynamicIslandContentView, (DynamicIslandContentView)((Object)object), (DynamicIslandContentView)((Object)object2), (ArrayList<DynamicIslandContentView>)object3);
        object = null;
        object2 = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
        if (dynamicIslandContentView == null) {
            return;
        }
        ((Number)((i)this.getTouchInteractor().getSwipeInfo().getValue()).d()).floatValue();
        if (!this.swipeHorizontal(dynamicIslandContentView)) {
            return;
        }
        if (n2 != 3) {
            if (n2 != 5) {
                if (n2 != 9) {
                    if (n2 != 11) {
                        if (object2 != null) {
                            object = ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){});
                        }
                    } else if (!this.isSwipeTowardsSmallIsland(f, dynamicIslandContentView.getContext())) {
                        if (object2 != null) {
                            object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                        }
                    } else if (object3 != null && object3.size() != 0) {
                        object3 = object3.get(object3.size() - 1);
                        o.f(object3, (String)"get(...)");
                        if (((DynamicIslandContentView)((Object)object3)).getState() instanceof DynamicIslandState.Empty) {
                            if (object2 != null) {
                                object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                            }
                        } else if (object2 != null) {
                            object = ((DynamicIslandState)object2).changeToState(new DynamicIslandState(){});
                        }
                    } else if (object2 != null) {
                        object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                    }
                } else if (object3 != null && object3.size() != 0) {
                    if (!this.isSwipeTowardsSmallIsland(f, dynamicIslandContentView.getContext())) {
                        if (object3.get(0).getState() instanceof DynamicIslandState.Hidden) {
                            if (object2 != null) {
                                object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                            }
                        } else if (object2 != null) {
                            object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                        }
                    } else if (object3.get(object3.size() - 1).getState() instanceof DynamicIslandState.Hidden) {
                        if (object2 != null) {
                            object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                        }
                    } else if (object2 != null) {
                        object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                    }
                } else if (object2 != null) {
                    object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
                }
            } else if (object2 != null) {
                object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
            }
        } else if (object2 != null) {
            object = ((DynamicIslandState)object2).changeToState(new /* invalid duplicate definition of identical inner class */);
        }
        dynamicIslandContentView.onSwipe(f, f2, dynamicIslandContentView, (DynamicIslandState)object2, (DynamicIslandState)object);
    }

    @Override
    public void setCurrent(DynamicIslandContentView dynamicIslandContentView) {
        this.current = dynamicIslandContentView;
    }
}
