/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 */
package miui.systemui.notification.focus.templateV3;

import E0.f;
import F0.a;
import miui.systemui.notification.focus.templateV3.TemplateBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateBuilderV3_Factory;

public final class TemplateBuilderV3_Factory_Impl
implements TemplateBuilderV3.Factory {
    private final TemplateBuilderV3_Factory delegateFactory;

    public TemplateBuilderV3_Factory_Impl(TemplateBuilderV3_Factory templateBuilderV3_Factory) {
        this.delegateFactory = templateBuilderV3_Factory;
    }

    public static a create(TemplateBuilderV3_Factory templateBuilderV3_Factory) {
        return f.a((Object)new TemplateBuilderV3_Factory_Impl(templateBuilderV3_Factory));
    }

    @Override
    public TemplateBuilderV3 create(boolean bl) {
        return this.delegateFactory.get(bl);
    }
}
