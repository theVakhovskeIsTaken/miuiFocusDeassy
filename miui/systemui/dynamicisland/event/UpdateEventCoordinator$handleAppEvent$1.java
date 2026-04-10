/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event;

import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class UpdateEventCoordinator.handleAppEvent.1
extends p
implements Function1 {
    final DynamicIslandContentView $view;

    public UpdateEventCoordinator.handleAppEvent.1(DynamicIslandContentView dynamicIslandContentView) {
        this.$view = dynamicIslandContentView;
        super(1);
    }

    public final Boolean invoke(DynamicIslandContentView object) {
        o.g((Object)object, (String)"it");
        object = object.getCurrentIslandData();
        String string = null;
        object = object != null ? object.getKey() : null;
        DynamicIslandData dynamicIslandData = this.$view.getCurrentIslandData();
        if (dynamicIslandData != null) {
            string = dynamicIslandData.getKey();
        }
        return o.c((Object)object, (Object)string);
    }
}
