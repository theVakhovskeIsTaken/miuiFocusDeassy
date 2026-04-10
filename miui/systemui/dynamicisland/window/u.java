/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 */
package miui.systemui.dynamicisland.window;

import java.util.function.Function;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;

public final class u
implements Function {
    public final Function1 a;

    public /* synthetic */ u(Function1 function1) {
        this.a = function1;
    }

    public final Object apply(Object object) {
        return DynamicMiniWindowDataRepo.d(this.a, object);
    }
}
