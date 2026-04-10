/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.event;

import miui.systemui.dynamicisland.event.DynamicIslandEvent;

public static final class DynamicIslandEvent.AddDynamicIsland
extends DynamicIslandEvent {
    public static final DynamicIslandEvent.AddDynamicIsland INSTANCE = new DynamicIslandEvent.AddDynamicIsland();
    private static boolean tempShow;

    private DynamicIslandEvent.AddDynamicIsland() {
        super(null);
    }

    public final boolean getTempShow() {
        return tempShow;
    }

    public final void setTempShow(boolean bl) {
        tempShow = bl;
    }
}
