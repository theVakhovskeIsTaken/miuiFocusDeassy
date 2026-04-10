/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public static final class DynamicIslandContentFakeView.updateViewStateWhenOpenAnimStart.1.1
extends ViewOutlineProvider {
    final DynamicIslandContentFakeView this$0;

    public DynamicIslandContentFakeView.updateViewStateWhenOpenAnimStart.1.1(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        this.this$0 = dynamicIslandContentFakeView;
    }

    public void getOutline(View object, Outline outline) {
        o.g((Object)object, (String)"view");
        o.g((Object)outline, (String)"outline");
        this.this$0.updateExpandViewPivot();
        this.this$0.updateExpandViewBlur(0, false, true);
        object = this.this$0;
        Object object2 = object.getContext();
        o.f((Object)object2, (String)"getContext(...)");
        int n = ((DynamicIslandContentFakeView)((Object)object)).getScreenWidth(object2);
        object2 = this.this$0;
        object = object2.getContext();
        o.f((Object)object, (String)"getContext(...)");
        outline.setRoundRect(0, 0, n, ((DynamicIslandContentFakeView)((Object)object2)).getScreenHeight((Context)object), this.this$0.radius);
    }
}
