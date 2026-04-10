/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;

public static final class DynamicIslandSafeguardsController.start.1<T>
implements g {
    final DynamicIslandSafeguardsController this$0;

    public DynamicIslandSafeguardsController.start.1(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        this.this$0 = dynamicIslandSafeguardsController;
    }

    public final Object emit(boolean bl, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("isAppAnimating ");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandSafeguardsController", (String)((StringBuilder)object).toString());
        if (bl) {
            this.this$0.delayResetWindowAnimation(5L);
        } else {
            this.this$0.cancelDelayResetWindowAnimation();
        }
        return s.a;
    }
}
