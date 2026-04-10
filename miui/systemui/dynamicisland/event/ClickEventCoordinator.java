/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.event;

import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.EventCoordinator;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class ClickEventCoordinator
extends EventCoordinator {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ClickEventCoordinator";

    public ClickEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"dynamicIslandEventCoordinator");
        super(dynamicIslandEventCoordinator);
    }

    @Override
    public void handleAppEvent(DynamicIslandEvent object, DynamicIslandContentView dynamicIslandContentView, ArrayList<DynamicIslandContentView> arrayList) {
        o.g((Object)object, (String)"event");
        if (object instanceof DynamicIslandEvent.ClickDynamicIsland) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("event: ");
            stringBuilder.append(object);
            Log.e((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
            if (this.isTinyScreen()) {
                object = new StringBuilder();
                ((StringBuilder)object).append("isTiny hiddenList: ");
                ((StringBuilder)object).append(arrayList);
                Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
                this.getStateHandler().stop();
                return;
            }
            object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
            if (object instanceof DynamicIslandState.BigIsland) {
                if (this.getShowOnceIslandHandler().getCurrent() != null && !CommonUtils.INSTANCE.getIS_TABLET()) {
                    return;
                }
                dynamicIslandContentView = this.getExpandedStateHandler().getCurrent();
                if (dynamicIslandContentView != null && (object = dynamicIslandContentView.getState()) != null && ((State)object).getTempShow()) {
                    this.getShowOnceIslandHandler().handleReplacedState(dynamicIslandContentView, arrayList, Boolean.FALSE);
                }
                object = this.getBigIslandStateHandler().getCurrent();
                this.getBigIslandStateHandler().setCurrent(null);
                this.getBigIslandStateHandler().handleFillInState(arrayList);
                this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, Boolean.FALSE);
                if (this.getShowOnceIslandHandler().getCurrent() != null) {
                    StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                    StateHandler.addState$default(this.getSmallIslandStateHandler(), this.getSmallIslandStateHandler().getCurrent(), null, 2, null);
                }
            } else {
                object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                if (object instanceof DynamicIslandState.SmallIsland) {
                    if (this.getShowOnceIslandHandler().getCurrent() != null) {
                        return;
                    }
                    dynamicIslandContentView = this.getExpandedStateHandler().getCurrent();
                    if (dynamicIslandContentView != null && (object = dynamicIslandContentView.getState()) != null && ((State)object).getTempShow()) {
                        this.getShowOnceIslandHandler().handleReplacedState(dynamicIslandContentView, arrayList, Boolean.FALSE);
                    } else {
                        StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                    }
                    object = this.getSmallIslandStateHandler().getCurrent();
                    this.getSmallIslandStateHandler().setCurrent(null);
                    this.getSmallIslandStateHandler().handleFillInState(arrayList);
                    this.getExpandedStateHandler().handleReplacedState((DynamicIslandContentView)((Object)object), arrayList, Boolean.FALSE);
                    if (this.getShowOnceIslandHandler().getCurrent() != null) {
                        StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                        StateHandler.addState$default(this.getSmallIslandStateHandler(), this.getSmallIslandStateHandler().getCurrent(), null, 2, null);
                    }
                } else {
                    object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                    if (object instanceof DynamicIslandState.ShowOnceBigIsland) {
                        dynamicIslandContentView = this.getShowOnceIslandHandler().getCurrent();
                        object = this.getExpandedStateHandler().getCurrent();
                        this.getExpandedStateHandler().handleReplacedState(dynamicIslandContentView, arrayList, Boolean.FALSE);
                        this.getShowOnceIslandHandler().setCurrent(null);
                        this.getBigIslandStateHandler().setCurrentTempShow(null);
                        if (object == null) {
                            StateHandler.addState$default(this.getBigIslandStateHandler(), this.getBigIslandStateHandler().getCurrent(), null, 2, null);
                            StateHandler.addState$default(this.getSmallIslandStateHandler(), this.getSmallIslandStateHandler().getCurrent(), null, 2, null);
                        }
                    }
                }
            }
            this.getStateHandler().stop();
        }
    }
}
