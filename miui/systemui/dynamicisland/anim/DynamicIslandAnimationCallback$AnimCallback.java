/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;

public static final class DynamicIslandAnimationCallback.AnimCallback {
    private final Function1 callback;
    private final DynamicIslandAnimationCallbackType type;

    public DynamicIslandAnimationCallback.AnimCallback(DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 function1) {
        o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"type");
        o.g((Object)function1, (String)"callback");
        this.type = dynamicIslandAnimationCallbackType;
        this.callback = function1;
    }

    public static /* synthetic */ DynamicIslandAnimationCallback.AnimCallback copy$default(DynamicIslandAnimationCallback.AnimCallback animCallback, DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 function1, int n, Object object) {
        if ((n & 1) != 0) {
            dynamicIslandAnimationCallbackType = animCallback.type;
        }
        if ((n & 2) != 0) {
            function1 = animCallback.callback;
        }
        return animCallback.copy(dynamicIslandAnimationCallbackType, function1);
    }

    public final DynamicIslandAnimationCallbackType component1() {
        return this.type;
    }

    public final Function1 component2() {
        return this.callback;
    }

    public final DynamicIslandAnimationCallback.AnimCallback copy(DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType, Function1 function1) {
        o.g((Object)((Object)dynamicIslandAnimationCallbackType), (String)"type");
        o.g((Object)function1, (String)"callback");
        return new DynamicIslandAnimationCallback.AnimCallback(dynamicIslandAnimationCallbackType, function1);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof DynamicIslandAnimationCallback.AnimCallback)) {
            return false;
        }
        object = object;
        if (this.type != (object).type) {
            return false;
        }
        return o.c((Object)this.callback, (Object)(object).callback);
    }

    public final Function1 getCallback() {
        return this.callback;
    }

    public final DynamicIslandAnimationCallbackType getType() {
        return this.type;
    }

    public int hashCode() {
        return ((Object)((Object)this.type)).hashCode() * 31 + this.callback.hashCode();
    }

    public String toString() {
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = this.type;
        Function1 function1 = this.callback;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AnimCallback(type=");
        stringBuilder.append((Object)dynamicIslandAnimationCallbackType);
        stringBuilder.append(", callback=");
        stringBuilder.append(function1);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
