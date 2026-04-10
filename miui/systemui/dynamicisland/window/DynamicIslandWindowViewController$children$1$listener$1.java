/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  androidx.core.view.ViewGroupKt
 *  d1.e
 *  d1.l
 *  h1.q
 */
package miui.systemui.dynamicisland.window;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import d1.e;
import d1.l;
import h1.q;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowViewController.children.1.listener.1
implements ViewGroup.OnHierarchyChangeListener {
    final q $$this$conflatedCallbackFlow;
    final DynamicIslandWindowView $view;

    public DynamicIslandWindowViewController.children.1.listener.1(q q2, DynamicIslandWindowView dynamicIslandWindowView) {
        this.$$this$conflatedCallbackFlow = q2;
        this.$view = dynamicIslandWindowView;
    }

    public void onChildViewAdded(View view, View view2) {
        this.$$this$conflatedCallbackFlow.i((Object)l.r((e)ViewGroupKt.getChildren((ViewGroup)this.$view)));
    }

    public void onChildViewRemoved(View view, View view2) {
        this.$$this$conflatedCallbackFlow.i((Object)l.r((e)ViewGroupKt.getChildren((ViewGroup)this.$view)));
    }
}
