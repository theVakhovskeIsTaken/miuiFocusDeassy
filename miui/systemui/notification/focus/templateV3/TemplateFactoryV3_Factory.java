/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 */
package miui.systemui.notification.focus.templateV3;

import E0.e;
import F0.a;
import miui.systemui.notification.focus.FocusNotifUtils;
import miui.systemui.notification.focus.templateV3.TemplateBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateDecoBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateDecoLandBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateFactoryV3;
import miui.systemui.notification.focus.templateV3.TemplateTinyBuilderV3;

public final class TemplateFactoryV3_Factory
implements e {
    private final a focusNotifUtilsProvider;
    private final a templateBuilderV3FactoryProvider;
    private final a templateDecoBuilderV3FactoryProvider;
    private final a templateDecoLandBuilderV3FactoryProvider;
    private final a templateTinyBuilderV3FactoryProvider;

    public TemplateFactoryV3_Factory(a a2, a a3, a a4, a a5, a a6) {
        this.focusNotifUtilsProvider = a2;
        this.templateBuilderV3FactoryProvider = a3;
        this.templateDecoBuilderV3FactoryProvider = a4;
        this.templateDecoLandBuilderV3FactoryProvider = a5;
        this.templateTinyBuilderV3FactoryProvider = a6;
    }

    public static TemplateFactoryV3_Factory create(a a2, a a3, a a4, a a5, a a6) {
        return new TemplateFactoryV3_Factory(a2, a3, a4, a5, a6);
    }

    public static TemplateFactoryV3 newInstance(FocusNotifUtils focusNotifUtils, TemplateBuilderV3.Factory factory, TemplateDecoBuilderV3.Factory factory2, TemplateDecoLandBuilderV3.Factory factory3, TemplateTinyBuilderV3.Factory factory4) {
        return new TemplateFactoryV3(focusNotifUtils, factory, factory2, factory3, factory4);
    }

    public TemplateFactoryV3 get() {
        return TemplateFactoryV3_Factory.newInstance((FocusNotifUtils)this.focusNotifUtilsProvider.get(), (TemplateBuilderV3.Factory)this.templateBuilderV3FactoryProvider.get(), (TemplateDecoBuilderV3.Factory)this.templateDecoBuilderV3FactoryProvider.get(), (TemplateDecoLandBuilderV3.Factory)this.templateDecoLandBuilderV3FactoryProvider.get(), (TemplateTinyBuilderV3.Factory)this.templateTinyBuilderV3FactoryProvider.get());
    }
}
