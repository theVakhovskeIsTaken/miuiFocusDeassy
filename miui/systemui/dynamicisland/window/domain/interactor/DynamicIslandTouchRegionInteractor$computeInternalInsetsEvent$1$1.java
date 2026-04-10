/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnComputeInternalInsetsListener
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import U0.a;
import android.view.ViewTreeObserver;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public static final class DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.1
extends p
implements a {
    final DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.onComputeInternalInsetsListener.1 $onComputeInternalInsetsListener;
    final ViewTreeObserver $viewTreeObserver;

    public DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.1(ViewTreeObserver viewTreeObserver, DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.onComputeInternalInsetsListener.1 var2_2) {
        this.$viewTreeObserver = viewTreeObserver;
        this.$onComputeInternalInsetsListener = var2_2;
        super(0);
    }

    public final void invoke() {
        if (this.$viewTreeObserver.isAlive()) {
            ViewTreeObserver viewTreeObserver = this.$viewTreeObserver;
            DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.onComputeInternalInsetsListener.1 var1_2 = this.$onComputeInternalInsetsListener;
            viewTreeObserver.removeOnComputeInternalInsetsListener((ViewTreeObserver.OnComputeInternalInsetsListener)var1_2);
        }
    }
}
