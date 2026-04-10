/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.touch.data.repository;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository$special$;

@f(c="miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository$special$$inlined$map$1$2", f="DynamicIslandTouchConstantsRepository.kt", l={50}, m="emit")
public static final class DynamicIslandTouchConstantsRepository$special$.inlined.map.1
extends M0.d {
    Object L$0;
    int label;
    Object result;
    final DynamicIslandTouchConstantsRepository$special$.inlined.map.2 this$0;

    public DynamicIslandTouchConstantsRepository$special$.inlined.map.1(DynamicIslandTouchConstantsRepository$special$.inlined.map.2 var1_1, d d2) {
        this.this$0 = var1_1;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (d)this);
    }
}
