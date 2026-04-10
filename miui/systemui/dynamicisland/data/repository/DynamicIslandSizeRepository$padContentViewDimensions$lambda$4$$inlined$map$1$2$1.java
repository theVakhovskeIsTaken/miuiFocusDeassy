/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.data.repository;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$;

@f(c="miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$$inlined$map$1$2", f="DynamicIslandSizeRepository.kt", l={50}, m="emit")
public static final class DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$.inlined.map.1
extends M0.d {
    Object L$0;
    int label;
    Object result;
    final DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$.inlined.map.2 this$0;

    public DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$.inlined.map.1(DynamicIslandSizeRepository$padContentViewDimensions$lambda$4$.inlined.map.2 var1_1, d d2) {
        this.this$0 = var1_1;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (d)this);
    }
}
