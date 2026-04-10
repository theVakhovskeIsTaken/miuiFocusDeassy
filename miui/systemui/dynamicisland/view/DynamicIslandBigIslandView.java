/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;

public final class DynamicIslandBigIslandView
extends DynamicGlowEffectView {
    public DynamicIslandBigIslandView(Context context) {
        o.g((Object)context, (String)"context");
        this(context, null, 2, null);
    }

    public DynamicIslandBigIslandView(Context context, AttributeSet attributeSet) {
        o.g((Object)context, (String)"context");
        super(context, attributeSet);
    }

    public /* synthetic */ DynamicIslandBigIslandView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public final ViewGroup getContentView$miui_dynamicisland_release() {
        return this.getMContainer();
    }

    public final void suppressAdaptiveGlowViewSize$miui_dynamicisland_release() {
        this.setAdaptiveGlowViewSize(false);
    }

    public final void updateGlowEffectAnim$miui_dynamicisland_release(float f, float f2, float f3, float f4, float f5) {
        this.setGlowEffectPosition(f, f2, f3, f4, f5);
    }
}
