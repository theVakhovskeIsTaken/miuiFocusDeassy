/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor$special$;

@f(c="miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor$special$$inlined$filter$1$2", f="DynamicIslandExternalTouchInteractor.kt", l={50}, m="emit")
public static final class DynamicIslandExternalTouchInteractor$special$.inlined.filter.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final DynamicIslandExternalTouchInteractor$special$.inlined.filter.2 this$0;

    public DynamicIslandExternalTouchInteractor$special$.inlined.filter.1(DynamicIslandExternalTouchInteractor$special$.inlined.filter.2 var1_1, d d2) {
        this.this$0 = var1_1;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (d)this);
    }
}
