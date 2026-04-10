/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content.ui.viewbinder;

import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static final class DynamicIslandBaseContentViewBinder.bind.1<T>
implements g {
    final DynamicIslandBaseContentView $view;

    public DynamicIslandBaseContentViewBinder.bind.1(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        this.$view = dynamicIslandBaseContentView;
    }

    public final Object emit(DynamicIslandSizeRepository.IslandWidthParams islandWidthParams, d object) {
        object = this.$view;
        float f = islandWidthParams.getMaxWidth();
        float f2 = islandWidthParams.getClockWidth();
        float f3 = islandWidthParams.getBatteryWidth();
        ((DynamicIslandBaseContentView)((Object)object)).setMaxWidth(f, f2, f3);
        return s.a;
    }
}
