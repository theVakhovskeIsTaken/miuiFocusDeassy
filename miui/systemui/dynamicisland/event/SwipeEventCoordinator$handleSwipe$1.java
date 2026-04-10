/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class SwipeEventCoordinator.handleSwipe.1
extends p
implements Function1 {
    public static final SwipeEventCoordinator.handleSwipe.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final CharSequence invoke(DynamicIslandContentView object) {
        o.g((Object)object, (String)"it");
        object = object.getCurrentIslandData();
        object = object != null ? object.getKey() : null;
        return String.valueOf(object);
    }
}
