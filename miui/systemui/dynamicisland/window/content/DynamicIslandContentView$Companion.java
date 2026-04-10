/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.h
 *  miuix.animation.property.FloatProperty
 *  miuix.animation.utils.EaseManager$EaseStyle
 */
package miui.systemui.dynamicisland.window.content;

import kotlin.jvm.internal.h;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.property.FloatProperty;
import miuix.animation.utils.EaseManager;

public static final class DynamicIslandContentView.Companion {
    private DynamicIslandContentView.Companion() {
    }

    public /* synthetic */ DynamicIslandContentView.Companion(h h2) {
        this();
    }

    public final EaseManager.EaseStyle getANTI_BURN_IN_EASE() {
        return ANTI_BURN_IN_EASE;
    }

    public final FloatProperty<DynamicIslandContentView> getCONTAINER_BG_ALPHA() {
        return CONTAINER_BG_ALPHA;
    }
}
