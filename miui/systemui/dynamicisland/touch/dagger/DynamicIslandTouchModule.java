/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.touch.dagger;

import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchDispatcher;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public interface DynamicIslandTouchModule {
    public DynamicIslandStartable bindsTouchDispatcherAsStartable(DynamicIslandExternalTouchDispatcher var1);

    public DynamicIslandStartable bindsTouchHandlerAsStartable(DynamicIslandTouchInteractor var1);

    public DynamicIslandStartable bindsWindowViewTouchInteractorAsStartable(DynamicIslandWindowViewTouchInteractor var1);
}
