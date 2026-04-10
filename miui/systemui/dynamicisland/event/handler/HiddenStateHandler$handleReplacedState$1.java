/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event.handler;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.event.handler.HiddenStateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class HiddenStateHandler.handleReplacedState.1
extends p
implements Function1 {
    final HiddenStateHandler this$0;

    public HiddenStateHandler.handleReplacedState.1(HiddenStateHandler hiddenStateHandler) {
        this.this$0 = hiddenStateHandler;
        super(1);
    }

    public final Boolean invoke(DynamicIslandContentView object) {
        o.g((Object)object, (String)"it");
        object = object.getCurrentIslandData();
        String string = null;
        object = object != null ? object.getKey() : null;
        DynamicIslandContentView dynamicIslandContentView = this.this$0.getCurrent();
        String string2 = string;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
            string2 = string;
            if (dynamicIslandContentView != null) {
                string2 = dynamicIslandContentView.getKey();
            }
        }
        return o.c((Object)object, string2);
    }
}
