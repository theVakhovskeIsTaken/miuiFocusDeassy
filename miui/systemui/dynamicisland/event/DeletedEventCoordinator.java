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
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class DeletedEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "DeletedEventCoordinator";

    public DeletedEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    private final void removeContentView(DynamicIslandContentView frameLayout) {
        DynamicIslandWindowView dynamicIslandWindowView = this.getDynamicIslandEventCoordinator().getWindowView();
        frameLayout = frameLayout != null ? frameLayout.getBackgroundView() : null;
        dynamicIslandWindowView.removeView((View)frameLayout);
        this.getDynamicIslandEventCoordinator().getWindowView().setPendingMediaView(null);
    }

    /*
     * WARNING - void declaration
     */
    private final void updateExpandedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> arrayList) {
        void var5_10;
        if (!CommonUtils.INSTANCE.getIS_TABLET()) {
            return;
        }
        DynamicIslandContentView dynamicIslandContentView4 = this.getBigIslandStateHandler().getCurrent();
        DynamicIslandContentView dynamicIslandContentView2 = this.getExpandedStateHandler().getCurrent();
        Object object2 = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        int n = this.getMiniWindowStateHandler().getCurrentMap().size();
        ArrayList<DynamicIslandContentView> object32 = this.getAppStateHandler().getCurrentList();
        if (object32 != null) {
            Integer n2 = object32.size();
        } else {
            Object var5_9 = null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateExpandedState, ");
        stringBuilder.append((Object)dynamicIslandContentView4);
        stringBuilder.append(", ");
        stringBuilder.append((Object)dynamicIslandContentView2);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        stringBuilder.append(", ");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(var5_10);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        object2 = this.getExpandedStateHandler().getCurrent();
        DynamicIslandContentView dynamicIslandContentView3 = this.getBigIslandStateHandler().getCurrent();
        if (dynamicIslandContentView3 != null) {
            dynamicIslandContentView3.calculateBigIslandY();
        }
        if (object2 != null) {
            ((DynamicIslandBaseContentView)((Object)object2)).calculateBigIslandY();
        }
        if (arrayList != null) {
            arrayList = arrayList.iterator();
            while (arrayList.hasNext()) {
                ((DynamicIslandContentView)((Object)arrayList.next())).calculateBigIslandY();
            }
        }
        arrayList = this.getMiniWindowStateHandler().getCurrentMap().values();
        o.f(arrayList, (String)"<get-values>(...)");
        for (ArrayList arrayList2 : arrayList) {
            if (arrayList2 == null) continue;
            o.d((Object)arrayList2);
            for (DynamicIslandContentView dynamicIslandContentView4 : arrayList2) {
                if (dynamicIslandContentView4 == null) continue;
                dynamicIslandContentView4.calculateBigIslandY();
            }
        }
        arrayList = this.getAppStateHandler().getCurrentList();
        if (arrayList != null) {
            for (DynamicIslandContentView dynamicIslandContentView5 : arrayList) {
                if (dynamicIslandContentView5 == null) continue;
                dynamicIslandContentView5.calculateBigIslandY();
            }
        }
        if (!(object2 == null || object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null && ((State)object).getDeleteNoAnimation())) {
            StateHandler.addState$default(this.getExpandedStateHandler(), (DynamicIslandContentView)((Object)object2), null, 2, null);
        }
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView object2, ArrayList<DynamicIslandContentView> object3) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.DeletedDynamicIsland) {
            Object object4;
            Object object5 = null;
            Object var14_5 = null;
            object = object2 != null && (object = object2.getCurrentIslandData()) != null ? object.getKey() : null;
            object4 = object2 != null && (object4 = object2.getState()) != null ? Boolean.valueOf(((State)object4).getDeleteNoAnimation()) : null;
            Object object6 = this.getBigIslandStateHandler().getCurrent();
            object6 = object6 != null && (object6 = object6.getCurrentIslandData()) != null ? object6.getKey() : null;
            Object object7 = this.getBigIslandStateHandler().getCurrentTempShow();
            object7 = object7 != null && (object7 = object7.getCurrentIslandData()) != null ? object7.getKey() : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DeletedDynamicIsland event: ");
            stringBuilder.append((String)object);
            stringBuilder.append(" deleteNoAnimation\uff1a");
            stringBuilder.append(object4);
            stringBuilder.append(" currentKey:");
            stringBuilder.append((String)object6);
            stringBuilder.append(" currentTempShowKey:");
            stringBuilder.append((String)object7);
            Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
            object = object2 != null && (object = object2.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
            object4 = object2 != null && (object4 = object2.getCurrentIslandData()) != null ? object4.getKey() : null;
            object6 = this.getExpandedStateHandler().getCurrent();
            object6 = object6 != null && (object6 = object6.getCurrentIslandData()) != null ? object6.getKey() : null;
            boolean bl = o.c((Object)object4, (Object)object6);
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            if (bl) {
                if (object2 != null && (object = object2.getState()) != null && ((State)object).getDeleteNoAnimation()) {
                    object = this.getExpandedStateHandler().getCurrent();
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getBackgroundView() : null;
                    if (object != null) {
                        ((DynamicIslandBackgroundView)((Object)object)).setVisibility(4);
                    }
                    object = this.getExpandedStateHandler().getCurrent();
                    if (object != null) {
                        object.setVisibility(4);
                    }
                }
                object4 = this.getExpandedStateHandler().getCurrent();
                object = var14_5;
                if (object4 != null) {
                    object = ((DynamicIslandBaseContentView)((Object)object4)).getState();
                }
                if (object != null) {
                    bl = bl6;
                    if (object2 != null) {
                        object2 = object2.getState();
                        bl = bl6;
                        if (object2 != null) {
                            bl = bl6;
                            if (((State)object2).getDeleteNoAnimation()) {
                                bl = true;
                            }
                        }
                    }
                    ((State)object).setDeleteNoAnimation(bl);
                }
                this.getExpandedStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
            } else {
                object6 = this.getBigIslandStateHandler().getCurrent();
                object6 = object6 != null && (object6 = object6.getCurrentIslandData()) != null ? object6.getKey() : null;
                if (o.c((Object)object4, (Object)object6)) {
                    if (object2 != null && (object = object2.getState()) != null && ((State)object).getDeleteNoAnimation()) {
                        object = this.getBigIslandStateHandler().getCurrent();
                        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getBackgroundView() : null;
                        if (object != null) {
                            ((DynamicIslandBackgroundView)((Object)object)).setVisibility(4);
                        }
                        object = this.getBigIslandStateHandler().getCurrent();
                        if (object != null) {
                            object.setVisibility(4);
                        }
                    }
                    object4 = new DynamicIslandState(){
                        private boolean deleteByAddNew;

                        public final boolean getDeleteByAddNew() {
                            return this.deleteByAddNew;
                        }

                        public final void setDeleteByAddNew(boolean bl) {
                            this.deleteByAddNew = bl;
                        }
                    };
                    object = this.getBigIslandStateHandler().getCurrent();
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                    if (object != null) {
                        bl = object2 != null && (object6 = object2.getState()) != null && ((State)object6).getDeleteNoAnimation();
                        ((State)object).setDeleteNoAnimation(bl);
                    }
                    bl = bl2;
                    if (object2 != null) {
                        object = object2.getState();
                        bl = bl2;
                        if (object != null) {
                            bl = bl2;
                            if (((State)object).getDeleteNoAnimation()) {
                                bl = true;
                            }
                        }
                    }
                    ((State)object4).setDeleteNoAnimation(bl);
                    object = this.getBigIslandStateHandler().getCurrent();
                    this.getBigIslandStateHandler().addState((DynamicIslandContentView)((Object)object), (DynamicIslandState)object4);
                    this.getBigIslandStateHandler().setCurrent(null);
                    this.getBigIslandStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
                } else {
                    object6 = this.getShowOnceIslandHandler().getCurrent();
                    object6 = object6 != null && (object6 = object6.getCurrentIslandData()) != null ? object6.getKey() : null;
                    if (o.c((Object)object4, (Object)object6)) {
                        if (object2 != null && (object = object2.getState()) != null && ((State)object).getDeleteNoAnimation()) {
                            object = this.getShowOnceIslandHandler().getCurrent();
                            object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getBackgroundView() : null;
                            if (object != null) {
                                ((DynamicIslandBackgroundView)((Object)object)).setVisibility(4);
                            }
                            object = this.getShowOnceIslandHandler().getCurrent();
                            if (object != null) {
                                object.setVisibility(4);
                            }
                        }
                        object4 = new /* invalid duplicate definition of identical inner class */;
                        bl = object2 != null && (object = object2.getState()) != null && ((State)object).getDeleteNoAnimation();
                        ((State)object4).setDeleteNoAnimation(bl);
                        object = this.getBigIslandStateHandler().getCurrentTempShow();
                        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                        if (object != null) {
                            bl = object2 != null && (object6 = object2.getState()) != null && ((State)object6).getDeleteNoAnimation();
                            ((State)object).setDeleteNoAnimation(bl);
                        }
                        if ((object = (object = this.getShowOnceIslandHandler().getCurrent()) != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null) != null) {
                            bl = object2 != null && (object6 = object2.getState()) != null && ((State)object6).getDeleteNoAnimation();
                            ((State)object).setDeleteNoAnimation(bl);
                        }
                        bl = bl3;
                        if (object2 != null) {
                            object = object2.getState();
                            bl = bl3;
                            if (object != null) {
                                bl = bl3;
                                if (((State)object).getDeleteNoAnimation()) {
                                    bl = true;
                                }
                            }
                        }
                        ((State)object4).setDeleteNoAnimation(bl);
                        this.getShowOnceIslandHandler().addState(this.getShowOnceIslandHandler().getCurrent(), (DynamicIslandState)object4);
                        this.getDynamicIslandEventCoordinator().getDynamicIslandWindowState().setTempHiddenChange(Boolean.TRUE);
                        this.getShowOnceIslandHandler().setCurrent(null);
                        this.getBigIslandStateHandler().setCurrentTempShow(null);
                        object = this.getBigIslandStateHandler().getCurrent();
                        StateHandler.addState$default(this.getBigIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                        object = this.getSmallIslandStateHandler().getCurrent();
                        if (object != null) {
                            StateHandler.addState$default(this.getSmallIslandStateHandler(), (DynamicIslandContentView)((Object)object), null, 2, null);
                        }
                        this.updateExpandedState((DynamicIslandContentView)((Object)object2), (ArrayList<DynamicIslandContentView>)object3);
                        if (object3 != null) {
                            object = object3.iterator();
                            while (object.hasNext()) {
                                object2 = (DynamicIslandContentView)((Object)object.next());
                                StateHandler.addState$default(this.getHiddenStateHandler(), object2, null, 2, null);
                            }
                        }
                    } else {
                        object6 = this.getSmallIslandStateHandler().getCurrent();
                        object6 = object6 != null && (object6 = object6.getCurrentIslandData()) != null ? object6.getKey() : null;
                        if (o.c((Object)object4, (Object)object6)) {
                            if (object2 != null && (object = object2.getState()) != null && ((State)object).getDeleteNoAnimation()) {
                                object = this.getSmallIslandStateHandler().getCurrent();
                                object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getBackgroundView() : null;
                                if (object != null) {
                                    ((DynamicIslandBackgroundView)((Object)object)).setVisibility(4);
                                }
                                object = this.getSmallIslandStateHandler().getCurrent();
                                if (object != null) {
                                    object.setVisibility(4);
                                }
                            }
                            object4 = new /* invalid duplicate definition of identical inner class */;
                            object = this.getSmallIslandStateHandler().getCurrent();
                            object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                            if (object != null) {
                                bl = object2 != null && (object6 = object2.getState()) != null && ((State)object6).getDeleteNoAnimation();
                                ((State)object).setDeleteNoAnimation(bl);
                            }
                            bl = bl4;
                            if (object2 != null) {
                                object = object2.getState();
                                bl = bl4;
                                if (object != null) {
                                    bl = bl4;
                                    if (((State)object).getDeleteNoAnimation()) {
                                        bl = true;
                                    }
                                }
                            }
                            ((State)object4).setDeleteNoAnimation(bl);
                            this.getSmallIslandStateHandler().addState(this.getSmallIslandStateHandler().getCurrent(), (DynamicIslandState)object4);
                            this.getSmallIslandStateHandler().setCurrent(null);
                            this.getSmallIslandStateHandler().handleFillInState((ArrayList<DynamicIslandContentView>)object3);
                            StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                        } else {
                            object6 = this.getHiddenStateHandler().getCurrent();
                            object6 = object6 != null && (object6 = object6.getCurrentIslandData()) != null ? object6.getKey() : null;
                            if (o.c((Object)object4, (Object)object6)) {
                                object4 = new /* invalid duplicate definition of identical inner class */;
                                object = this.getHiddenStateHandler().getCurrent();
                                object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
                                if (object != null) {
                                    bl = object2 != null && (object6 = object2.getState()) != null && ((State)object6).getDeleteNoAnimation();
                                    ((State)object).setDeleteNoAnimation(bl);
                                }
                                bl = bl5;
                                if (object2 != null) {
                                    object = object2.getState();
                                    bl = bl5;
                                    if (object != null) {
                                        bl = bl5;
                                        if (((State)object).getDeleteNoAnimation()) {
                                            bl = true;
                                        }
                                    }
                                }
                                ((State)object4).setDeleteNoAnimation(bl);
                                this.getHiddenStateHandler().addState(this.getHiddenStateHandler().getCurrent(), (DynamicIslandState)object4);
                                object = object5;
                                if (object2 != null) {
                                    object2 = object2.getCurrentIslandData();
                                    object = object5;
                                    if (object2 != null) {
                                        object = object2.getKey();
                                    }
                                }
                                this.removeHiddenState((ArrayList<DynamicIslandContentView>)object3, (String)object);
                            } else {
                                object4 = object2 != null ? object2.getState() : null;
                                if (object4 instanceof DynamicIslandState.Init) {
                                    this.removeContentView((DynamicIslandContentView)((Object)object2));
                                }
                                object4 = (object4 = this.getAppStateHandler().getCurrentList()) != null ? ((ArrayList)object4).iterator() : null;
                                while (object4 != null && object4.hasNext()) {
                                    object5 = (DynamicIslandContentView)((Object)object4.next());
                                    object6 = object5 != null && (object6 = object5.getCurrentIslandData()) != null ? object6.getKey() : null;
                                    if (!o.c((Object)object6, (Object)(object7 = object2 != null && (object7 = object2.getCurrentIslandData()) != null ? object7.getKey() : null))) continue;
                                    object4.remove();
                                    this.removeContentView((DynamicIslandContentView)((Object)object5));
                                }
                                object = (ArrayList)this.getMiniWindowStateHandler().getCurrentMap().get(object);
                                object = object != null ? ((ArrayList)object).iterator() : null;
                                while (object != null && object.hasNext()) {
                                    object7 = (DynamicIslandContentView)((Object)object.next());
                                    object4 = object7 != null && (object4 = object7.getCurrentIslandData()) != null ? object4.getKey() : null;
                                    if (!o.c((Object)object4, (Object)(object6 = object2 != null && (object6 = object2.getCurrentIslandData()) != null ? object6.getKey() : null))) continue;
                                    object6 = new /* invalid duplicate definition of identical inner class */;
                                    object4 = object7 != null ? object7.getState() : null;
                                    if (object4 != null) {
                                        bl = object2 != null && (object5 = object2.getState()) != null && ((State)object5).getDeleteNoAnimation();
                                        ((State)object4).setDeleteNoAnimation(bl);
                                    }
                                    bl = object2 != null && (object4 = object2.getState()) != null && ((State)object4).getDeleteNoAnimation();
                                    ((State)object6).setDeleteNoAnimation(bl);
                                    this.getMiniWindowStateHandler().addState((DynamicIslandContentView)((Object)object7), (DynamicIslandState)object6);
                                    object.remove();
                                    this.removeContentView((DynamicIslandContentView)((Object)object7));
                                }
                                object = object3 != null ? ((ArrayList)object3).iterator() : null;
                                while (object != null && object.hasNext()) {
                                    object3 = object.next();
                                    o.f(object3, (String)"next(...)");
                                    object6 = (DynamicIslandContentView)((Object)object3);
                                    object3 = object6.getCurrentIslandData();
                                    if (!o.c((Object)(object3 = object3 != null ? object3.getKey() : null), (Object)(object4 = object2 != null && (object4 = object2.getCurrentIslandData()) != null ? object4.getKey() : null))) continue;
                                    object3 = new /* invalid duplicate definition of identical inner class */;
                                    this.getHiddenStateHandler().addState((DynamicIslandContentView)((Object)object6), (DynamicIslandState)object3);
                                    object.remove();
                                    this.removeContentView((DynamicIslandContentView)((Object)object6));
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
