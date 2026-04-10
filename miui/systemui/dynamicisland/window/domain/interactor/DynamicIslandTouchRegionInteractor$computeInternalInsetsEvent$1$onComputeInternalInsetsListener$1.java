/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$InternalInsetsInfo
 *  android.view.ViewTreeObserver$OnComputeInternalInsetsListener
 *  h1.h
 *  h1.q
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import android.view.ViewTreeObserver;
import h1.h;
import h1.q;

public static final class DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.1.onComputeInternalInsetsListener.1
implements ViewTreeObserver.OnComputeInternalInsetsListener {
    final q $$this$conflatedCallbackFlow;

    public DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.1.onComputeInternalInsetsListener.1(q q2) {
        this.$$this$conflatedCallbackFlow = q2;
    }

    public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
        if (internalInsetsInfo != null) {
            h.b((Object)this.$$this$conflatedCallbackFlow.i((Object)internalInsetsInfo));
        }
    }
}
