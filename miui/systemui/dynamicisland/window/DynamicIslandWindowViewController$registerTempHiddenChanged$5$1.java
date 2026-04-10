/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import M0.b;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.1<T>
implements g {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public final Object emit(boolean bl, d d2) {
        this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
        DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide((Boolean)this.this$0.getWindowState().getTempHidden().getValue(), this.this$0.getWindowState().getTempHiddenType());
        return s.a;
    }
}
