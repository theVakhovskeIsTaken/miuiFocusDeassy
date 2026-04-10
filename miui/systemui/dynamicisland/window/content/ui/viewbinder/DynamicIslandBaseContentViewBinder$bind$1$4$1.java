/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content.ui.viewbinder;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static final class DynamicIslandBaseContentViewBinder.bind.1<T>
implements g {
    final boolean $propOnce;
    final DynamicIslandBaseContentView $view;

    public DynamicIslandBaseContentViewBinder.bind.1(boolean bl, DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        this.$propOnce = bl;
        this.$view = dynamicIslandBaseContentView;
    }

    public final Object emit(int n, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("statusBarDatePosX change to ");
        ((StringBuilder)object).append(n);
        Log.d((String)"DynamicIslandContentView", (String)((StringBuilder)object).toString());
        if (this.$propOnce) {
            return s.a;
        }
        if (n != this.$view.getStatusBarDatePosX()) {
            this.$view.setStatusBarDatePosX(n);
            this.$view.updateBigIslandLayout();
            object = this.$view.getDynamicIslandEventCoordinator();
            if (object != null) {
                ((DynamicIslandEventCoordinator)object).updateTouchRegion();
            }
            if (this.$view.getState() instanceof DynamicIslandState.BigIsland) {
                object = this.$view.getAnimatorDelegate();
                if (object != null) {
                    ((DynamicIslandAnimationDelegate)object).updateBigIslandPosition();
                }
                if ((object = this.$view.getAnimatorDelegate()) != null) {
                    ((DynamicIslandAnimationDelegate)object).containerScheduleUpdate();
                }
            }
        }
        return s.a;
    }
}
