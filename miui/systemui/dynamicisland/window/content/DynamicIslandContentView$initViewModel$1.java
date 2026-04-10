/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package miui.systemui.dynamicisland.window.content;

import android.util.Log;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewExtKt;

public static final class DynamicIslandContentView.initViewModel.1
implements DynamicIslandViewModel.DynamicIslandViewStateChangeCallback {
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.initViewModel.1(DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandContentView;
    }

    @Override
    public void onStateChanged(DynamicIslandState object, DynamicIslandState object2) {
        Object var5_3 = null;
        Object var6_4 = null;
        Object object3 = object != null ? Boolean.valueOf(((State)object).getTempShow()) : null;
        Boolean bl = object2 != null ? Boolean.valueOf(((State)object2).getTempShow()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("initViewModel1 state: ");
        stringBuilder.append(object);
        stringBuilder.append(" ");
        stringBuilder.append(object3);
        stringBuilder.append(" ->");
        stringBuilder.append(object2);
        stringBuilder.append(" ");
        stringBuilder.append(bl);
        Log.e((String)"DynamicIslandContentView", (String)stringBuilder.toString());
        if (object2 instanceof DynamicIslandState.BigIsland) {
            object3 = this.this$0.getDynamicIslandEventCoordinator();
            object2 = var6_4;
            if (object3 != null) {
                object2 = ((DynamicIslandEventCoordinator)object3).getAnimationController();
            }
            if (object2 != null) {
                ((DynamicIslandAnimationController)object2).setCurrentBigIsland((DynamicIslandState)object);
            }
        } else if (object2 instanceof DynamicIslandState.Expanded) {
            DynamicIslandContentViewExtKt.dispatchAutoExpand(this.this$0);
            object2 = this.this$0.getDynamicIslandEventCoordinator();
            object2 = object2 != null ? ((DynamicIslandEventCoordinator)object2).getAnimationController() : null;
            if (object2 != null) {
                object3 = this.this$0.getDynamicIslandEventCoordinator();
                object3 = object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getAnimationController()) != null ? ((DynamicIslandAnimationController)object3).getCurrentExpanded() : null;
                ((DynamicIslandAnimationController)object2).setLastExpanded((DynamicIslandState)object3);
            }
            object3 = this.this$0.getDynamicIslandEventCoordinator();
            object2 = var5_3;
            if (object3 != null) {
                object2 = ((DynamicIslandEventCoordinator)object3).getAnimationController();
            }
            if (object2 != null) {
                ((DynamicIslandAnimationController)object2).setCurrentExpanded((DynamicIslandState)object);
            }
        } else if (object2 instanceof DynamicIslandState.Deleted) {
            object = (object2).getDeleteKey();
            this.this$0.getController().getIslandTemplateFactory().removeTemplate((String)object);
        }
    }

    @Override
    public void onStateChanged(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        Object object2;
        Object var6_2 = null;
        Object object3 = dynamicIslandContentView != null ? dynamicIslandContentView.getLastState() : null;
        object2 = dynamicIslandContentView != null && (object2 = dynamicIslandContentView.getLastState()) != null ? Boolean.valueOf(((State)object2).getTempShow()) : null;
        DynamicIslandState dynamicIslandState = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
        object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getState()) != null ? Boolean.valueOf(((State)object).getTempShow()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("initViewModel2 state: ");
        stringBuilder.append(object3);
        stringBuilder.append(" ");
        stringBuilder.append(object2);
        stringBuilder.append(" ->");
        stringBuilder.append(dynamicIslandState);
        stringBuilder.append(" ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandContentView", (String)stringBuilder.toString());
        ((DynamicIslandContentViewController)this.this$0.getController()).onStateChange();
        object3 = var6_2;
        if (dynamicIslandContentView != null) {
            object3 = dynamicIslandContentView.getState();
        }
        if (object3 instanceof DynamicIslandState.Deleted && (object3 = this.this$0.getState()) != null && (object3 = ((State)object3).getDeleteKey()) != null) {
            this.this$0.getController().getIslandTemplateFactory().removeTemplate((String)object3);
        }
        if ((object3 = this.this$0.getDynamicIslandEventCoordinator()) != null) {
            ((DynamicIslandEventCoordinator)object3).alignBurnInStates();
        }
        if ((object3 = this.this$0.getDynamicIslandEventCoordinator()) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getAnimationController()) != null) {
            ((DynamicIslandAnimationController)object3).onStateChange(dynamicIslandContentView);
        }
    }
}
