/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 */
package miui.systemui.dynamicisland.window;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public final class p
implements Predicate {
    public final Function1 a;

    public /* synthetic */ p(Function1 function1) {
        this.a = function1;
    }

    public final boolean test(Object object) {
        return DynamicIslandWindowView.e(this.a, object);
    }
}
