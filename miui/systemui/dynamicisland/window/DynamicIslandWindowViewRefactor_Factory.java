/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  com.android.systemui.settings.UserTracker
 *  f1.E
 *  miui.systemui.ui.data.repository.ConfigurationRepository
 */
package miui.systemui.dynamicisland.window;

import E0.e;
import F0.a;
import android.content.Context;
import com.android.systemui.settings.UserTracker;
import f1.E;
import java.util.concurrent.Executor;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;
import miui.systemui.ui.data.repository.ConfigurationRepository;

public final class DynamicIslandWindowViewRefactor_Factory
implements e {
    private final a configurationRepositoryProvider;
    private final a contextProvider;
    private final a eventCoordinatorProvider;
    private final a scopeProvider;
    private final a sysUIContextProvider;
    private final a uiExecutorProvider;
    private final a userTrackerProvider;
    private final a windowViewProvider;

    public DynamicIslandWindowViewRefactor_Factory(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9) {
        this.sysUIContextProvider = a2;
        this.contextProvider = a3;
        this.scopeProvider = a4;
        this.windowViewProvider = a5;
        this.eventCoordinatorProvider = a6;
        this.userTrackerProvider = a7;
        this.uiExecutorProvider = a8;
        this.configurationRepositoryProvider = a9;
    }

    public static DynamicIslandWindowViewRefactor_Factory create(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9) {
        return new DynamicIslandWindowViewRefactor_Factory(a2, a3, a4, a5, a6, a7, a8, a9);
    }

    public static DynamicIslandWindowViewRefactor newInstance(Context context, Context context2, E e2, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandEventCoordinator dynamicIslandEventCoordinator, UserTracker userTracker, Executor executor, ConfigurationRepository configurationRepository) {
        return new DynamicIslandWindowViewRefactor(context, context2, e2, dynamicIslandWindowView, dynamicIslandEventCoordinator, userTracker, executor, configurationRepository);
    }

    public DynamicIslandWindowViewRefactor get() {
        return DynamicIslandWindowViewRefactor_Factory.newInstance((Context)this.sysUIContextProvider.get(), (Context)this.contextProvider.get(), (E)this.scopeProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DynamicIslandEventCoordinator)this.eventCoordinatorProvider.get(), (UserTracker)this.userTrackerProvider.get(), (Executor)this.uiExecutorProvider.get(), (ConfigurationRepository)this.configurationRepositoryProvider.get());
    }
}
