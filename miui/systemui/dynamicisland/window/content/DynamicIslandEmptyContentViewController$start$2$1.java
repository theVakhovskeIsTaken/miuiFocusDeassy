/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  i1.g
 *  kotlin.jvm.functions.Function1
 */
package miui.systemui.dynamicisland.window.content;

import G0.s;
import K0.d;
import M0.b;
import i1.g;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentViewController;

public static final class DynamicIslandEmptyContentViewController.start.1<T>
implements g {
    final DynamicIslandEmptyContentViewController this$0;

    public DynamicIslandEmptyContentViewController.start.1(DynamicIslandEmptyContentViewController dynamicIslandEmptyContentViewController) {
        this.this$0 = dynamicIslandEmptyContentViewController;
    }

    public final Object emit(Function1 function1, d d2) {
        function1.invoke((Object)b.a((boolean)this.this$0.touchInteractor.performLongClick()));
        return s.a;
    }
}
