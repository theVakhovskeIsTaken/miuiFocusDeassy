/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 */
package miui.systemui.dynamicisland.event;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.event.UpdateEventCoordinator;

public final class b
implements Predicate {
    public final Function1 a;

    public /* synthetic */ b(Function1 function1) {
        this.a = function1;
    }

    public final boolean test(Object object) {
        return UpdateEventCoordinator.a(this.a, object);
    }
}
