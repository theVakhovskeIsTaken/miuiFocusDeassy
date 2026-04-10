/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  android.os.Handler
 *  com.android.systemui.settings.UserTracker
 *  f1.E
 */
package miui.systemui.dynamicisland.window;

import E0.e;
import F0.a;
import android.content.Context;
import android.os.Handler;
import com.android.systemui.settings.UserTracker;
import f1.E;
import java.util.concurrent.Executor;
import miui.systemui.dynamicisland.window.AppLockController;

public final class AppLockController_Factory
implements e {
    private final a bgExecutorProvider;
    private final a bgHandlerProvider;
    private final a contextProvider;
    private final a scopeProvider;
    private final a userTrackerProvider;

    public AppLockController_Factory(a a2, a a3, a a4, a a5, a a6) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.userTrackerProvider = a4;
        this.bgExecutorProvider = a5;
        this.bgHandlerProvider = a6;
    }

    public static AppLockController_Factory create(a a2, a a3, a a4, a a5, a a6) {
        return new AppLockController_Factory(a2, a3, a4, a5, a6);
    }

    public static AppLockController newInstance(E e2, Context context, UserTracker userTracker, Executor executor, Handler handler) {
        return new AppLockController(e2, context, userTracker, executor, handler);
    }

    public AppLockController get() {
        return AppLockController_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (UserTracker)this.userTrackerProvider.get(), (Executor)this.bgExecutorProvider.get(), (Handler)this.bgHandlerProvider.get());
    }
}
