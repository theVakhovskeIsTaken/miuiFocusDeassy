/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  android.util.Log
 *  i1.g
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import M0.b;
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
        this.this$0.getWindowState().isTempHidden(b.c((int)1));
        object = this.this$0.getWindowState().getTempHiddenType();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("collect screenLocked:");
        stringBuilder.append(bl);
        stringBuilder.append(" ");
        stringBuilder.append(object);
        Log.e((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(bl, this.this$0.getWindowState().getTempHiddenType());
        }
        return s.a;
    }
}
