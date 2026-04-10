/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.content.res.Configuration
 *  i1.g
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.content.res.Configuration;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandWindowViewRefactor.listenForRotationChanged.1<T>
implements g {
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForRotationChanged.1(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        this.this$0 = dynamicIslandWindowViewRefactor;
    }

    public final Object emit(int n, d object) {
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            if (this.this$0.lastRotation == 1 && n == 3 || this.this$0.lastRotation == 3 && n == 1) {
                object = this.this$0.windowView.getWindowViewController();
                Configuration configuration = this.this$0.context.getResources().getConfiguration();
                o.f((Object)configuration, (String)"getConfiguration(...)");
                ((DynamicIslandWindowViewController)object).onConfigChanged(configuration);
            }
            this.this$0.lastRotation = n;
        }
        return s.a;
    }
}
