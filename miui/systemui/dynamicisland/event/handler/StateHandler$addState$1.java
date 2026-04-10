/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 *  kotlin.jvm.internal.z
 */
package miui.systemui.dynamicisland.event.handler;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.z;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class StateHandler.addState.1
extends p
implements Function1 {
    final z $initState;
    final DynamicIslandContentView $view;

    public StateHandler.addState.1(DynamicIslandContentView dynamicIslandContentView, z z2) {
        this.$view = dynamicIslandContentView;
        this.$initState = z2;
        super(1);
    }

    public final Boolean invoke(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        Object var5_2 = null;
        object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null;
        Object object2 = this.$view;
        boolean bl = o.c((Object)object, (Object)(object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null));
        if (bl) {
            object2 = this.$initState;
            object = var5_2;
            if (dynamicIslandContentView != null) {
                object = dynamicIslandContentView.getLastState();
            }
            ((z)object2).a = object;
        }
        return bl;
    }
}
