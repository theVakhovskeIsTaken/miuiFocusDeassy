/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 */
package miui.systemui.dynamicisland.view;

import android.view.View;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;

public final class a
implements View.OnLayoutChangeListener {
    public final DynamicGlowEffectView a;

    public /* synthetic */ a(DynamicGlowEffectView dynamicGlowEffectView) {
        this.a = dynamicGlowEffectView;
    }

    public final void onLayoutChange(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        DynamicGlowEffectView.a(this.a, view, n, n2, n3, n4, n5, n6, n7, n8);
    }
}
