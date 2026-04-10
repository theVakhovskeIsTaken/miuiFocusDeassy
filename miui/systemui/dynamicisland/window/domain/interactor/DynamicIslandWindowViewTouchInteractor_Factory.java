/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 *  miui.systemui.statusbar.data.repository.StatusBarAreaRepository
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;
import miui.systemui.statusbar.data.repository.StatusBarAreaRepository;

public final class DynamicIslandWindowViewTouchInteractor_Factory
implements e {
    private final a contextProvider;
    private final a scopeProvider;
    private final a statusBarAreaRepositoryProvider;
    private final a windowViewProvider;

    public DynamicIslandWindowViewTouchInteractor_Factory(a a2, a a3, a a4, a a5) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.windowViewProvider = a4;
        this.statusBarAreaRepositoryProvider = a5;
    }

    public static DynamicIslandWindowViewTouchInteractor_Factory create(a a2, a a3, a a4, a a5) {
        return new DynamicIslandWindowViewTouchInteractor_Factory(a2, a3, a4, a5);
    }

    public static DynamicIslandWindowViewTouchInteractor newInstance(E e2, Context context, DynamicIslandWindowView dynamicIslandWindowView, StatusBarAreaRepository statusBarAreaRepository) {
        return new DynamicIslandWindowViewTouchInteractor(e2, context, dynamicIslandWindowView, statusBarAreaRepository);
    }

    public DynamicIslandWindowViewTouchInteractor get() {
        return DynamicIslandWindowViewTouchInteractor_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (StatusBarAreaRepository)this.statusBarAreaRepositoryProvider.get());
    }
}
