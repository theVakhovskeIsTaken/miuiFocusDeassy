/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$$inlined$filter$1$2", f="DynamicIslandWindowViewTouchInteractor.kt", l={50}, m="emit")
public static final class DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$.inlined.filter.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$.inlined.filter.2 this$0;

    public DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$.inlined.filter.1(DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$.inlined.filter.2 var1_1, d d2) {
        this.this$0 = var1_1;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (d)this);
    }
}
