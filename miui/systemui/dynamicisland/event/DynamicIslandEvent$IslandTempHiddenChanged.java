/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.event;

import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;

public static final class DynamicIslandEvent.IslandTempHiddenChanged
extends DynamicIslandEvent {
    public static final DynamicIslandEvent.IslandTempHiddenChanged INSTANCE = new DynamicIslandEvent.IslandTempHiddenChanged();
    private static boolean hide;
    private static DynamicIslandWindowState.TempHiddenType type;

    private DynamicIslandEvent.IslandTempHiddenChanged() {
        super(null);
    }

    public final boolean getHide() {
        return hide;
    }

    public final DynamicIslandWindowState.TempHiddenType getType() {
        return type;
    }

    public final void setHide(boolean bl) {
        hide = bl;
    }

    public final void setType(DynamicIslandWindowState.TempHiddenType tempHiddenType) {
        type = tempHiddenType;
    }
}
