/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  i1.g
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewRefactor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandWindowViewRefactor.listenForOrientationChanged.1<T>
implements g {
    final DynamicIslandWindowViewRefactor this$0;

    public DynamicIslandWindowViewRefactor.listenForOrientationChanged.1(DynamicIslandWindowViewRefactor dynamicIslandWindowViewRefactor) {
        this.this$0 = dynamicIslandWindowViewRefactor;
    }

    public final Object emit(s object, d object2) {
        object = this.this$0.windowView.getFakeViews();
        object2 = object.iterator();
        while (object2.hasNext()) {
            object = (DynamicIslandContentFakeView)((Object)object2.next());
            object.suppressLayout(false);
        }
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            object = this.this$0.windowView.getContentViews();
            object = object.iterator();
            while (object.hasNext()) {
                object2 = (DynamicIslandContentView)((Object)object.next());
                ((DynamicIslandBaseContentView)((Object)object2)).calculateBigIslandY();
            }
        }
        return s.a;
    }
}
