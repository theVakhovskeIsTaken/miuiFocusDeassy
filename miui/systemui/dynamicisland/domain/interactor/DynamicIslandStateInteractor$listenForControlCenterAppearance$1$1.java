/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  i1.g
 */
package miui.systemui.dynamicisland.domain.interactor;

import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandStateInteractor;

public static final class DynamicIslandStateInteractor.listenForControlCenterAppearance.1<T>
implements g {
    final DynamicIslandStateInteractor this$0;

    public DynamicIslandStateInteractor.listenForControlCenterAppearance.1(DynamicIslandStateInteractor dynamicIslandStateInteractor) {
        this.this$0 = dynamicIslandStateInteractor;
    }

    public final Object emit(boolean bl, d d2) {
        this.this$0.dynamicIslandWindowViewController.controlCenterExpanded(bl);
        return s.a;
    }
}
