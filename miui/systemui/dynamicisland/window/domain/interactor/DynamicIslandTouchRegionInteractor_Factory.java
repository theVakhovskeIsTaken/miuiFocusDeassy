/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import D0.a;
import E0.d;
import E0.e;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public final class DynamicIslandTouchRegionInteractor_Factory
implements e {
    private final F0.a contextProvider;
    private final F0.a eventCoordinatorLazyProvider;
    private final F0.a scopeProvider;
    private final F0.a windowViewControllerLazyProvider;
    private final F0.a windowViewProvider;

    public DynamicIslandTouchRegionInteractor_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.windowViewProvider = a4;
        this.windowViewControllerLazyProvider = a5;
        this.eventCoordinatorLazyProvider = a6;
    }

    public static DynamicIslandTouchRegionInteractor_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6) {
        return new DynamicIslandTouchRegionInteractor_Factory(a2, a3, a4, a5, a6);
    }

    public static DynamicIslandTouchRegionInteractor newInstance(E e2, Context context, DynamicIslandWindowView dynamicIslandWindowView, a a2, a a3) {
        return new DynamicIslandTouchRegionInteractor(e2, context, dynamicIslandWindowView, a2, a3);
    }

    public DynamicIslandTouchRegionInteractor get() {
        return DynamicIslandTouchRegionInteractor_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), d.a((F0.a)this.windowViewControllerLazyProvider), d.a((F0.a)this.eventCoordinatorLazyProvider));
    }
}
