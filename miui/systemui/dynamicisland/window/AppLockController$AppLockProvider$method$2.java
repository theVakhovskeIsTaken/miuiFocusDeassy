/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.j$a
 *  G0.k
 *  U0.a
 *  kotlin.jvm.internal.p
 *  miui.security.SecurityManager
 */
package miui.systemui.dynamicisland.window;

import G0.j;
import G0.k;
import U0.a;
import java.lang.reflect.Method;
import kotlin.jvm.internal.p;
import miui.security.SecurityManager;
import miui.systemui.dynamicisland.window.AppLockController;

public static final class AppLockController.AppLockProvider.method.2
extends p
implements a {
    final AppLockController.AppLockProvider this$0;

    public AppLockController.AppLockProvider.method.2(AppLockController.AppLockProvider appLockProvider) {
        this.this$0 = appLockProvider;
        super(0);
    }

    public final Method invoke() {
        Object object;
        try {
            object = j.a;
            object = Integer.TYPE;
            object = SecurityManager.class.getDeclaredMethod("getAllApplicationsAccessControlNotPass", new Class[]{object});
            object = j.a((Object)object);
        }
        catch (Throwable throwable) {
            j.a a2 = j.a;
            object = j.a((Object)k.a((Throwable)throwable));
        }
        if (j.b((Object)object) != null) {
            object = null;
        }
        return (Method)object;
    }
}
