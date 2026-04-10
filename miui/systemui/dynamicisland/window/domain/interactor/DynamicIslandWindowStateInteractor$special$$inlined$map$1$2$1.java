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
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor$special$;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor$special$$inlined$map$1$2", f="DynamicIslandWindowStateInteractor.kt", l={50}, m="emit")
public static final class DynamicIslandWindowStateInteractor$special$.inlined.map.1
extends M0.d {
    Object L$0;
    int label;
    Object result;
    final DynamicIslandWindowStateInteractor$special$.inlined.map.2 this$0;

    public DynamicIslandWindowStateInteractor$special$.inlined.map.1(DynamicIslandWindowStateInteractor$special$.inlined.map.2 var1_1, d d2) {
        this.this$0 = var1_1;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit(null, (d)this);
    }
}
