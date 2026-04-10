/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;

public static final class DynamicIslandAnimationCallback.removeCallback.2
extends p
implements Function1 {
    final Function1 $callback;
    final DynamicIslandAnimationCallbackType $callbackType;

    public DynamicIslandAnimationCallback.removeCallback.2(DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 function1) {
        this.$callbackType = dynamicIslandAnimationCallbackType;
        this.$callback = function1;
        super(1);
    }

    public final Boolean invoke(DynamicIslandAnimationCallback.AnimCallback animCallback) {
        o.g((Object)animCallback, (String)"it");
        boolean bl = animCallback.getType() == this.$callbackType && o.c((Object)animCallback.getCallback(), (Object)this.$callback);
        return bl;
    }
}
