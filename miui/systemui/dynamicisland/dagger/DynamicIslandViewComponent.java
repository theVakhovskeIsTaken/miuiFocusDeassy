/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.dagger;

import java.util.Map;
import miui.systemui.dynamicisland.DynamicIslandBackgroundViewController;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;

@DynamicIslandScope
public interface DynamicIslandViewComponent {
    public DynamicIslandBackgroundViewController.Factory getBackgroundViewControllerFactory();

    public DynamicIslandBaseContentViewController.FactoryImpl getBaseContentViewControllerFactory();

    public DynamicIslandContentViewController.Factory getContentViewControllerFactory();

    public DynamicIslandEventCoordinator getDynamicIslandEventCoordinator();

    public DynamicIslandWindowViewController getDynamicIslandWindowViewController();

    public IslandTemplateFactory getIslandTemplateFactory();

    public DynamicIslandSizeRepository getSizeRepository();

    public Map<Class<?>, DynamicIslandStartable> getStartables();
}
