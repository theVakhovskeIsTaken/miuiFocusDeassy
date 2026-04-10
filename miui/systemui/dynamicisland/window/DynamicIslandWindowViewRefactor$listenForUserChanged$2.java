/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.settings.UserTracker$Callback
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import com.android.systemui.settings.UserTracker;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;

public static final class DynamicIslandWindowViewRefactor.listenForUserChanged.2
extends p
implements Function1 {
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForUserChanged.2(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        this.this$0 = dynamicIslandWindowViewRefactor;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.this$0.userTracker.removeCallback((UserTracker.Callback)this.this$0.windowView);
    }
}
