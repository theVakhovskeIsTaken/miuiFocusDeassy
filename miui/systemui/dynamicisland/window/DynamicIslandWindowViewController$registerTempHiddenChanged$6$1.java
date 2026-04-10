/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import M0.b;
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
        object = new StringBuilder();
        ((StringBuilder)object).append("collect screenPinning:");
        ((StringBuilder)object).append(bl);
        Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
        this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)false));
        DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide((Boolean)this.this$0.getWindowState().getTempHidden().getValue(), this.this$0.getWindowState().getTempHiddenType());
        return s.a;
    }
}
