/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 */
package miui.systemui.dynamicisland.event.handler;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.event.handler.HiddenStateHandler;

public final class a
implements Predicate {
    public final Function1 a;

    public /* synthetic */ a(Function1 function1) {
        this.a = function1;
    }

    public final boolean test(Object object) {
        return HiddenStateHandler.b(this.a, object);
    }
}
