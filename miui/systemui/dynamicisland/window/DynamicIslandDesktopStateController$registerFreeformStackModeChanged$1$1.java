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
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;

public static final class DynamicIslandDesktopStateController.registerFreeformStackModeChanged.1<T>
implements g {
    final DynamicIslandDesktopStateController this$0;

    public DynamicIslandDesktopStateController.registerFreeformStackModeChanged.1(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        this.this$0 = dynamicIslandDesktopStateController;
    }

    public final Object emit(int n, d object) {
        String string = this.this$0.TAG;
        object = new StringBuilder();
        ((StringBuilder)object).append("registerFreeformStackModeChanged it:");
        ((StringBuilder)object).append(n);
        Log.d((String)string, (String)((StringBuilder)object).toString());
        if (n == 0 || n == 10) {
            this.this$0.runDesktopAnim(false);
        }
        return s.a;
    }
}
