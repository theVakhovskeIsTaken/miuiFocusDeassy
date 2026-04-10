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
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.1<T>
implements g {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public final Object emit(boolean bl, d object) {
        Object object2 = this.this$0.getWindowState().getTempHidden().getValue();
        object = new StringBuilder();
        ((StringBuilder)object).append("collect isKeyguardShowing:");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", windowState.tempHidden.value=");
        ((StringBuilder)object).append(object2);
        Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
        this.this$0.getWindowState().setKeyguardShowing(bl);
        this.this$0.lockScreen(bl);
        DynamicIslandWindowViewController.access$getView(this.this$0).onKeyguardShowing(bl);
        return s.a;
    }
}
