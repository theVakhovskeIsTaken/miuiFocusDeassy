/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 *  miui.systemui.autodensity.AutoDensityController
 */
package miui.systemui.dynamicisland.touch.data.repository;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;

public final class DynamicIslandTouchConstantsRepository_Factory
implements e {
    private final a autoDensityControllerProvider;
    private final a contextProvider;
    private final a scopeProvider;

    public DynamicIslandTouchConstantsRepository_Factory(a a2, a a3, a a4) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.autoDensityControllerProvider = a4;
    }

    public static DynamicIslandTouchConstantsRepository_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandTouchConstantsRepository_Factory(a2, a3, a4);
    }

    public static DynamicIslandTouchConstantsRepository newInstance(E e2, Context context, AutoDensityController autoDensityController) {
        return new DynamicIslandTouchConstantsRepository(e2, context, autoDensityController);
    }

    public DynamicIslandTouchConstantsRepository get() {
        return DynamicIslandTouchConstantsRepository_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (AutoDensityController)this.autoDensityControllerProvider.get());
    }
}
