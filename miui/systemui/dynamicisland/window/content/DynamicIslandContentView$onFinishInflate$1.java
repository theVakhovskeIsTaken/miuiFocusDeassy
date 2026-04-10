/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  kotlin.jvm.internal.o
 *  miuix.animation.Folme
 */
package miui.systemui.dynamicisland.window.content;

import android.view.View;
import kotlin.jvm.internal.o;
import miuix.animation.Folme;

public static final class DynamicIslandContentView.onFinishInflate.1
implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        o.g((Object)view, (String)"v");
    }

    public void onViewDetachedFromWindow(View view) {
        o.g((Object)view, (String)"v");
        Folme.clean((View)view);
    }
}
