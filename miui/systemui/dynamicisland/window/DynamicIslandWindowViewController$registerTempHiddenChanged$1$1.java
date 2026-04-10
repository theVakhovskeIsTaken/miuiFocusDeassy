/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.1<T>
implements g {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public final Object emit(boolean bl, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("lockScreenControlCenterCollapse:");
        ((StringBuilder)object).append(bl);
        Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
        if (CommonUtils.INSTANCE.getIS_TABLET() && bl) {
            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(true, this.this$0.getWindowState().getTempHiddenType());
        }
        return s.a;
    }
}
