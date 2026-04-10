/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.event;

import miui.systemui.dynamicisland.event.DynamicIslandEvent;

public static final class DynamicIslandEvent.PanelExpandedRatio
extends DynamicIslandEvent {
    public static final DynamicIslandEvent.PanelExpandedRatio INSTANCE = new DynamicIslandEvent.PanelExpandedRatio();
    private static float blurRatio;

    private DynamicIslandEvent.PanelExpandedRatio() {
        super(null);
    }

    public final float getBlurRatio() {
        return blurRatio;
    }

    public final void setBlurRatio(float f) {
        blurRatio = f;
    }
}
