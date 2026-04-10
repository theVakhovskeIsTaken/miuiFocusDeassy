/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.event.handler;

import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@DynamicIslandScope
public final class ShowOnceIslandHandler
extends StateHandler {
    private final BigIslandStateHandler bigIslandStateHandler;

    public ShowOnceIslandHandler(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, BigIslandStateHandler bigIslandStateHandler) {
        o.g((Object)dynamicIslandTouchInteractor, (String)"touchInteractor");
        o.g((Object)bigIslandStateHandler, (String)"bigIslandStateHandler");
        super(dynamicIslandTouchInteractor);
        this.bigIslandStateHandler = bigIslandStateHandler;
    }

    @Override
    public void handleReplacedState(DynamicIslandContentView object, ArrayList<DynamicIslandContentView> object2, Boolean object3) {
        block4: {
            block5: {
                Object object4;
                Object object5;
                block7: {
                    block6: {
                        Object var6_4 = null;
                        object5 = object != null && (object5 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object5.getTickerData() : null;
                        DynamicIslandContentView dynamicIslandContentView = this.getCurrent();
                        object4 = this.getCurrent();
                        object4 = object4 != null && (object4 = ((DynamicIslandBaseContentView)((Object)object4)).getCurrentIslandData()) != null ? object4.getTickerData() : null;
                        DynamicIslandContentView dynamicIslandContentView2 = this.getCurrentTempShow();
                        object2 = object2 != null ? Integer.valueOf(((ArrayList)object2).size()) : null;
                        StateHandler stateHandler = this.getNext();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("ShowOnceIslandHandler handleReplacedState: originState: ");
                        stringBuilder.append(object);
                        stringBuilder.append("  ---- ");
                        stringBuilder.append((String)object5);
                        stringBuilder.append(", current: ");
                        stringBuilder.append((Object)dynamicIslandContentView);
                        stringBuilder.append("----");
                        stringBuilder.append((String)object4);
                        stringBuilder.append(", currentTempShow: ");
                        stringBuilder.append((Object)dynamicIslandContentView2);
                        stringBuilder.append("hiddenList: ");
                        stringBuilder.append(object2);
                        stringBuilder.append("}, userSwipe: ");
                        stringBuilder.append(object3);
                        stringBuilder.append(" , next: ");
                        stringBuilder.append(stateHandler);
                        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
                        if (object == null || (object2 = ((DynamicIslandBaseContentView)((Object)object)).getState()) == null || !((State)object2).getTempShow()) break block4;
                        object5 = this.bigIslandStateHandler.getCurrentTempShow();
                        this.setCurrent((DynamicIslandContentView)((Object)object));
                        this.bigIslandStateHandler.setCurrentTempShow(this.getCurrent());
                        object2 = ((DynamicIslandBaseContentView)((Object)object)).getState();
                        object = var6_4;
                        if (object2 != null) {
                            object = new DynamicIslandState(){};
                            ((State)object).setTempShow(true);
                            object = ((DynamicIslandState)object2).changeToState((DynamicIslandState)object);
                        }
                        if (object5 == null) break block5;
                        object4 = new DynamicIslandState(){
                            private boolean deleteByAddNew;

                            public final boolean getDeleteByAddNew() {
                                return this.deleteByAddNew;
                            }

                            public final void setDeleteByAddNew(boolean bl) {
                                this.deleteByAddNew = bl;
                            }
                        };
                        object2 = ((DynamicIslandBaseContentView)((Object)object5)).getCurrentIslandData();
                        if (object2 == null) break block6;
                        object2 = object3 = object2.getKey();
                        if (object3 != null) break block7;
                    }
                    object2 = "";
                }
                ((State)object4).setDeleteKey((String)object2);
                object4.setDeleteByAddNew(true);
                this.addState((DynamicIslandContentView)((Object)object5), (DynamicIslandState)object4);
            }
            this.addState(this.getCurrent(), (DynamicIslandState)object);
        }
    }
}
