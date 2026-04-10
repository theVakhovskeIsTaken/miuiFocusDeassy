/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;

public static final class DynamicIslandContentViewController.log.1<T>
implements g {
    final DynamicIslandContentViewController this$0;

    public DynamicIslandContentViewController.log.1(DynamicIslandContentViewController dynamicIslandContentViewController) {
        this.this$0 = dynamicIslandContentViewController;
    }

    public final Object emit(DynamicIslandState dynamicIslandState, d object) {
        object = ((DynamicIslandContentView)((Object)this.this$0.getView())).getViewModel().getOldState();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("initViewModel state: ");
        stringBuilder.append(object);
        stringBuilder.append(" ->");
        stringBuilder.append(dynamicIslandState);
        Log.e((String)"DynamicIslandContentView", (String)stringBuilder.toString());
        return s.a;
    }
}
