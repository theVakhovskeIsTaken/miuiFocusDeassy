/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  android.view.WindowManager$LayoutParams
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.util.Log;
import android.view.WindowManager;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;

public static final class DynamicIslandWindowController.listenForWatchOutsideTouch.1<T>
implements g {
    final DynamicIslandWindowController this$0;

    public DynamicIslandWindowController.listenForWatchOutsideTouch.1(DynamicIslandWindowController dynamicIslandWindowController) {
        this.this$0 = dynamicIslandWindowController;
    }

    public final Object emit(boolean bl, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("update watch outside touch to ");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandWindowController", (String)((StringBuilder)object).toString());
        object = this.this$0.lpChanged;
        int n = bl ? ((DynamicIslandWindowController)this.this$0).lp.flags | 0x40000 : ((DynamicIslandWindowController)this.this$0).lp.flags & 0xFFFBFFFF;
        ((WindowManager.LayoutParams)object).flags = n;
        this.this$0.apply();
        return s.a;
    }
}
