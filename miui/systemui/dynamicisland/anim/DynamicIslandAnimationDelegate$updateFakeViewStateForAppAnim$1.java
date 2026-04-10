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
package miui.systemui.dynamicisland.anim;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;

public static final class DynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim.1
extends ViewOutlineProvider {
    public void getOutline(View view, Outline outline) {
        o.g((Object)view, (String)"view");
        o.g((Object)outline, (String)"outline");
        float f = view.getContext().getResources().getDimension(R.dimen.island_radius);
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        int n = dynamicIslandUtils.getScreenWidthOld(context);
        view = view.getContext();
        o.f((Object)view, (String)"getContext(...)");
        outline.setRoundRect(0, 0, n, dynamicIslandUtils.getScreenHeightOld((Context)view), f);
    }
}
