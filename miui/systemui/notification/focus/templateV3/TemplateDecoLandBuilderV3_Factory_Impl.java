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
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.templateV3.TemplateDecoLandBuilderV3;
import miui.systemui.notification.focus.templateV3.TemplateDecoLandBuilderV3_Factory;

public final class TemplateDecoLandBuilderV3_Factory_Impl
implements TemplateDecoLandBuilderV3.Factory {
    private final TemplateDecoLandBuilderV3_Factory delegateFactory;

    public TemplateDecoLandBuilderV3_Factory_Impl(TemplateDecoLandBuilderV3_Factory templateDecoLandBuilderV3_Factory) {
        this.delegateFactory = templateDecoLandBuilderV3_Factory;
    }

    public static a create(TemplateDecoLandBuilderV3_Factory templateDecoLandBuilderV3_Factory) {
        return f.a((Object)new TemplateDecoLandBuilderV3_Factory_Impl(templateDecoLandBuilderV3_Factory));
    }

    @Override
    public TemplateDecoLandBuilderV3 create(Template template, boolean bl) {
        return this.delegateFactory.get(template, bl);
    }
}
