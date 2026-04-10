/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 */
package miui.systemui.dynamicisland.anim;

import java.util.function.Predicate;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;

public final class a
implements Predicate {
    public final Function1 a;

    public /* synthetic */ a(Function1 function1) {
        this.a = function1;
    }

    public final boolean test(Object object) {
        return DynamicIslandAnimationCallback.a(this.a, object);
    }
}
